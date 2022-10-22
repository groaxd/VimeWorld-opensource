package net.xtrafrancyz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import net.xtrafrancyz.mods.texteria.Texteria;
import sun.misc.IOUtils;

public class VimeStorage
{
    public static final int DEFAULT_TTL = 2592000;
    private final Map<String, VimeStorage.Entry> entries = new HashMap();
    private final File index;
    private final File root;
    protected volatile boolean dirty;
    private final ScheduledExecutorService executor;

    public VimeStorage(File index, File root)
    {
        this.index = index;
        this.root = root;
        this.loadIndex();
        this.executor = Executors.newSingleThreadScheduledExecutor((r) ->
        {
            Thread thread = new Thread(r, "VimeStorage Executor");
            thread.setDaemon(true);
            return thread;
        });
        this.executor.scheduleWithFixedDelay(this::saveIndex, 30L, 30L, TimeUnit.SECONDS);
        this.executor.scheduleWithFixedDelay(this::processTTL, 0L, 10L, TimeUnit.MINUTES);
    }

    protected int getEntryVersion()
    {
        return 1;
    }

    protected VimeStorage.Entry createEntry()
    {
        return new VimeStorage.Entry();
    }

    private void loadIndex()
    {
        if (!this.index.exists())
        {
            deleteRecursive(this.root);
        }
        else
        {
            try
            {
                DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(new InflaterInputStream(new FileInputStream(this.index))));
                Throwable throwable = null;

                try
                {
                    int int = datainputstream.readByte();
                    int int = int > 1 ? datainputstream.readByte() : 0;
                    int int = datainputstream.readInt();

                    for (int int = 0; int < int; ++int)
                    {
                        VimeStorage.Entry vimestorage$entry = this.createEntry();
                        vimestorage$entry.deserialize(datainputstream, int);
                        this.entries.put(vimestorage$entry.path, vimestorage$entry);
                    }
                }
                catch (Throwable throwable2)
                {
                    throwable = throwable2;
                    throw throwable2;
                }
                finally
                {
                    if (datainputstream != null)
                    {
                        if (throwable != null)
                        {
                            try
                            {
                                datainputstream.close();
                            }
                            catch (Throwable throwable1)
                            {
                                throwable.addSuppressed(throwable1);
                            }
                        }
                        else
                        {
                            datainputstream.close();
                        }
                    }
                }
            }
            catch (FileNotFoundException var19)
            {
                ;
            }
            catch (IOException ioexception)
            {
                Texteria.log.warn((String)("[VimeStorage] Could not load index from " + this.index.getAbsolutePath()), (Throwable)ioexception);
                this.entries.clear();
                this.index.delete();
            }
        }
    }

    private void saveIndex()
    {
        if (this.dirty)
        {
            ByteArrayOutputStream bytearrayoutputstream;

            synchronized (this)
            {
                if (!this.dirty)
                {
                    return;
                }

                this.dirty = false;
                bytearrayoutputstream = new ByteArrayOutputStream();

                try
                {
                    DeflaterOutputStream deflateroutputstream = new DeflaterOutputStream(bytearrayoutputstream);
                    DataOutputStream dataoutputstream = new DataOutputStream(new BufferedOutputStream(deflateroutputstream));
                    dataoutputstream.writeByte(2);
                    dataoutputstream.writeByte(this.getEntryVersion());
                    dataoutputstream.writeInt(this.entries.size());

                    for (VimeStorage.Entry vimestorage$entry : this.entries.values())
                    {
                        vimestorage$entry.serialize(dataoutputstream);
                    }

                    dataoutputstream.flush();
                    deflateroutputstream.close();
                }
                catch (Exception var21)
                {
                    ;
                }
            }

            File file = this.index.getParentFile();

            if (!file.exists())
            {
                file.mkdirs();
            }

            File file1 = new File(this.index.getParentFile(), this.index.getName() + ".tmp");

            try
            {
                FileOutputStream fileoutputstream = new FileOutputStream(file1);
                Throwable throwable2 = null;

                try
                {
                    bytearrayoutputstream.writeTo(fileoutputstream);
                }
                catch (Throwable throwable1)
                {
                    throwable2 = throwable1;
                    throw throwable1;
                }
                finally
                {
                    if (fileoutputstream != null)
                    {
                        if (throwable2 != null)
                        {
                            try
                            {
                                fileoutputstream.close();
                            }
                            catch (Throwable throwable)
                            {
                                throwable2.addSuppressed(throwable);
                            }
                        }
                        else
                        {
                            fileoutputstream.close();
                        }
                    }
                }
            }
            catch (Exception exception)
            {
                Texteria.log.warn((String)("[VimeStorage] Could not save index to " + this.index.getAbsolutePath()), (Throwable)exception);
                file1.delete();
            }

            this.index.delete();
            file1.renameTo(this.index);
        }
    }

    private static void deleteRecursive(File file)
    {
        try
        {
            if (!file.exists())
            {
                return;
            }

            if (file.isDirectory())
            {
                File[] afile = file.listFiles();

                if (afile != null)
                {
                    for (File file : afile)
                    {
                        deleteRecursive(file);
                    }
                }
            }

            file.delete();
        }
        catch (Exception exception)
        {
            Texteria.log.warn((String)"Could not delete file", (Throwable)exception);
        }
    }

    private void processTTL()
    {
        List<VimeStorage.Entry> list = new ArrayList();

        synchronized (this)
        {
            Iterator<VimeStorage.Entry> iterator = this.entries.values().iterator();
            long long = System.currentTimeMillis();

            while (iterator.hasNext())
            {
                VimeStorage.Entry vimestorage$entry = (VimeStorage.Entry)iterator.next();

                if (vimestorage$entry.deadline != 0L && vimestorage$entry.deadline < long)
                {
                    iterator.remove();
                    list.add(vimestorage$entry);
                    this.dirty = true;
                }
            }
        }

        for (VimeStorage.Entry vimestorage$entry1 : list)
        {
            vimestorage$entry1.realDelete();
        }
    }

    public void shutdown()
    {
        this.executor.shutdownNow();
        this.saveIndex();
    }

    public void forEach(Consumer<VimeStorage.Entry> consumer)
    {
        synchronized (this)
        {
            this.entries.values().forEach(consumer);
        }
    }

    public VimeStorage.Entry getEntry(String path)
    {
        VimeStorage.Entry vimestorage$entry;

        synchronized (this)
        {
            vimestorage$entry = (VimeStorage.Entry)this.entries.get(path);

            if (vimestorage$entry != null)
            {
                vimestorage$entry.touch();
                this.dirty = true;
            }
        }

        if (vimestorage$entry == null)
        {
            vimestorage$entry = this.createEntry();
            vimestorage$entry.path = path;
        }

        return vimestorage$entry;
    }

    public static void main(String[] args) throws Exception
    {
        File file = new File("D:/vstest");
        VimeStorage vimestorage = new VimeStorage(new File(file, "index.bin"), new File(file, "files"));
        Thread.sleep(500L);
        VimeStorage.Entry vimestorage$entry = vimestorage.getEntry("test/test.png");

        if (vimestorage$entry.exists())
        {
            FileInputStream fileinputstream = vimestorage$entry.getInputStream();
            Throwable throwable = null;

            try
            {
                System.out.println(new String(IOUtils.readFully(fileinputstream, -1, true)));
            }
            catch (Throwable throwable2)
            {
                throwable = throwable2;
                throw throwable2;
            }
            finally
            {
                if (fileinputstream != null)
                {
                    if (throwable != null)
                    {
                        try
                        {
                            fileinputstream.close();
                        }
                        catch (Throwable throwable1)
                        {
                            throwable.addSuppressed(throwable1);
                        }
                    }
                    else
                    {
                        fileinputstream.close();
                    }
                }
            }
        }

        vimestorage.shutdown();
    }

    public class Entry
    {
        private String path;
        private long deadline;
        private int ttl;
        private Boolean existsCache;

        private void realDelete()
        {
            File file1 = this.getFile();

            if (file1.exists())
            {
                file1.delete();

                if (this.path.contains("/"))
                {
                    for (File file2 = file1.getParentFile(); !file2.equals(VimeStorage.this.root); file2 = file2.getParentFile())
                    {
                        String[] astring = file2.list();

                        if (astring != null && astring.length != 0)
                        {
                            break;
                        }

                        file2.delete();
                    }
                }
            }
        }

        private void touch()
        {
            if (this.ttl != 0)
            {
                this.deadline = System.currentTimeMillis() + (long)this.ttl * 1000L;
            }
        }

        protected void serialize(DataOutputStream dos) throws IOException
        {
            dos.writeUTF(this.path);
            dos.writeLong(this.deadline);
            dos.writeInt(this.ttl);
        }

        protected void deserialize(DataInputStream dis, int version) throws IOException
        {
            this.path = dis.readUTF();
            this.deadline = dis.readLong();
            this.ttl = dis.readInt();
        }

        public void delete()
        {
            synchronized (VimeStorage.this)
            {
                if (VimeStorage.this.entries.remove(this.path, this))
                {
                    VimeStorage.this.dirty = true;
                }

                this.existsCache = null;
            }

            this.realDelete();
        }

        public boolean exists()
        {
            if (this.existsCache != null)
            {
                return this.existsCache.booleanValue();
            }
            else
            {
                synchronized (VimeStorage.this)
                {
                    boolean flag = (this.existsCache = Boolean.valueOf(this.getFile().exists())).booleanValue();

                    if (flag)
                    {
                        if (!VimeStorage.this.entries.containsKey(this.path))
                        {
                            if (this.ttl == 0)
                            {
                                this.ttl = 2592000;
                            }

                            this.touch();
                            VimeStorage.this.entries.put(this.path, this);
                            VimeStorage.this.dirty = true;
                        }
                    }
                    else if (VimeStorage.this.entries.containsKey(this.path))
                    {
                        VimeStorage.this.entries.remove(this.path);
                        VimeStorage.this.dirty = true;
                    }

                    return flag;
                }
            }
        }

        public FileOutputStream getOutputStream() throws IOException
        {
            File file1 = this.getFile();
            File file2 = file1.getParentFile();

            if (!file2.exists())
            {
                file2.mkdirs();
            }

            synchronized (VimeStorage.this)
            {
                this.existsCache = null;
            }

            return new FileOutputStream(file1);
        }

        public FileInputStream getInputStream() throws IOException
        {
            return new FileInputStream(this.getFile());
        }

        public void save(int ttl)
        {
            synchronized (VimeStorage.this)
            {
                this.ttl = ttl;
                this.touch();
                VimeStorage.this.entries.put(this.path, this);
                VimeStorage.this.dirty = true;
            }
        }

        public String getPath()
        {
            return this.path;
        }

        public File getFile()
        {
            return new File(VimeStorage.this.root, this.path);
        }

        public String toString()
        {
            return "Entry{path=" + this.path + "}";
        }
    }
}
