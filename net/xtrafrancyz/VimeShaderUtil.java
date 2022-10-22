package net.xtrafrancyz;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;
import net.minecraft.util.HttpUtil;
import net.xtrafrancyz.mods.texteria.Texteria;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class VimeShaderUtil
{
    private static final Gson GSON = (new GsonBuilder()).create();
    private static final Set<String> uploaded = Collections.<String>newSetFromMap(new ConcurrentHashMap());

    public static void uploadShaderpack(File file)
    {
        if (uploaded.add(file.getAbsolutePath()))
        {
            Thread thread = new Thread(new VimeShaderUtil.Uploader(file), "Shaderpack uploader");
            thread.setDaemon(true);
            thread.start();
        }
    }

    private static class Uploader implements Runnable
    {
        private static final String SERVER = "https://shaderserver.vimeworld.com";
        private final File file;

        public Uploader(File file)
        {
            this.file = file;
        }

        public void run()
        {
            byte[] abyte = new byte[8192];
            String s;

            try
            {
                MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
                InputStream inputstream = new FileInputStream(this.file);
                Throwable connection = null;

                try
                {
                    int i;

                    try
                    {
                        while ((i = ((InputStream)inputstream).read(abyte)) > 0)
                        {
                            messagedigest.update(abyte, 0, i);
                        }
                    }
                    catch (Throwable throwable13)
                    {
                        connection = throwable13;
                        throw throwable13;
                    }
                }
                finally
                {
                    if (inputstream != null)
                    {
                        if (connection != null)
                        {
                            try
                            {
                                inputstream.close();
                            }
                            catch (Throwable throwable2)
                            {
                                connection.addSuppressed(throwable2);
                            }
                        }
                        else
                        {
                            inputstream.close();
                        }
                    }
                }

                s = Hex.encodeHexString(messagedigest.digest());
            }
            catch (Exception exception1)
            {
                Texteria.log.error((String)"Could not hash resourcepack", (Throwable)exception1);
                return;
            }

            try
            {
                String s2 = this.file.getName();
                s2 = s2.substring(0, s2.length() - 4);
                Map<String, Object> map = new HashMap();
                map.put("hash", s);
                map.put("name", s2);
                map.put("size", Long.valueOf(this.file.length()));
                String s3 = VimeShaderUtil.GSON.toJson((Object)map);
                HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL("https://shaderserver.vimeworld.com/verify/check")).openConnection();
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.setConnectTimeout(15000);
                httpurlconnection.setReadTimeout(15000);
                httpurlconnection.setUseCaches(false);
                httpurlconnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                httpurlconnection.setRequestProperty("Content-Length", "" + s3.length());
                httpurlconnection.setDoOutput(true);
                OutputStream outputstream = httpurlconnection.getOutputStream();
                Throwable inputStream = null;

                try
                {
                    IOUtils.write(s3.getBytes(StandardCharsets.UTF_8), outputstream);
                }
                catch (Throwable throwable11)
                {
                    inputStream = throwable11;
                    throw throwable11;
                }
                finally
                {
                    if (outputstream != null)
                    {
                        if (inputStream != null)
                        {
                            try
                            {
                                outputstream.close();
                            }
                            catch (Throwable throwable5)
                            {
                                inputStream.addSuppressed(throwable5);
                            }
                        }
                        else
                        {
                            outputstream.close();
                        }
                    }
                }

                boolean flag = false;

                try
                {
                    InputStream inputstream2 = httpurlconnection.getInputStream();
                    Throwable errorStream = null;

                    try
                    {
                        String s1 = IOUtils.toString(inputstream2, Charsets.UTF_8);
                        JsonElement jsonelement = (new JsonParser()).parse(s1);
                        flag = jsonelement.getAsJsonObject().get("upload").getAsBoolean();
                    }
                    catch (Throwable throwable10)
                    {
                        errorStream = throwable10;
                        throw throwable10;
                    }
                    finally
                    {
                        if (inputstream2 != null)
                        {
                            if (errorStream != null)
                            {
                                try
                                {
                                    inputstream2.close();
                                }
                                catch (Throwable throwable9)
                                {
                                    errorStream.addSuppressed(throwable9);
                                }
                            }
                            else
                            {
                                inputstream2.close();
                            }
                        }
                    }
                }
                catch (IOException var190)
                {
                    InputStream inputstream1 = httpurlconnection.getErrorStream();

                    if (inputstream1 != null)
                    {
                        Texteria.log.error("Shaderpack upload check error. Code " + httpurlconnection.getResponseCode() + ". Response: " + IOUtils.toString(inputstream1, Charsets.UTF_8));
                    }
                }

                httpurlconnection.disconnect();

                if (!flag)
                {
                    return;
                }

                httpurlconnection = (HttpURLConnection)(new URL("https://shaderserver.vimeworld.com/verify/upload?" + HttpUtil.buildPostString(map))).openConnection();
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.setConnectTimeout(15000);
                httpurlconnection.setReadTimeout(15000);
                httpurlconnection.setUseCaches(false);
                httpurlconnection.setDoOutput(true);
                OutputStream outputstream1 = httpurlconnection.getOutputStream();
                Throwable throwable15 = null;

                try
                {
                    FileInputStream fileinputstream = new FileInputStream(this.file);
                    Throwable throwable16 = null;

                    try
                    {
                        IOUtils.copyLarge((InputStream)fileinputstream, (OutputStream)outputstream1, (byte[])abyte);
                    }
                    catch (Throwable throwable8)
                    {
                        throwable16 = throwable8;
                        throw throwable8;
                    }
                    finally
                    {
                        if (fileinputstream != null)
                        {
                            if (throwable16 != null)
                            {
                                try
                                {
                                    fileinputstream.close();
                                }
                                catch (Throwable throwable4)
                                {
                                    throwable16.addSuppressed(throwable4);
                                }
                            }
                            else
                            {
                                fileinputstream.close();
                            }
                        }
                    }
                }
                catch (Throwable throwable12)
                {
                    throwable15 = throwable12;
                    throw throwable12;
                }
                finally
                {
                    if (outputstream1 != null)
                    {
                        if (throwable15 != null)
                        {
                            try
                            {
                                outputstream1.close();
                            }
                            catch (Throwable throwable3)
                            {
                                throwable15.addSuppressed(throwable3);
                            }
                        }
                        else
                        {
                            outputstream1.close();
                        }
                    }
                }

                try
                {
                    InputStream inputstream3 = httpurlconnection.getInputStream();
                    throwable15 = null;

                    try
                    {
                        Texteria.log.info("Shaderpack " + s + " uploaded - " + IOUtils.toString(inputstream3, Charsets.UTF_8));
                    }
                    catch (Throwable throwable7)
                    {
                        throwable15 = throwable7;
                        throw throwable7;
                    }
                    finally
                    {
                        if (inputstream3 != null)
                        {
                            if (throwable15 != null)
                            {
                                try
                                {
                                    inputstream3.close();
                                }
                                catch (Throwable throwable6)
                                {
                                    throwable15.addSuppressed(throwable6);
                                }
                            }
                            else
                            {
                                inputstream3.close();
                            }
                        }
                    }
                }
                catch (IOException var188)
                {
                    InputStream inputstream4 = httpurlconnection.getErrorStream();

                    if (inputstream4 != null)
                    {
                        Texteria.log.error("Shaderpack upload error. Code " + httpurlconnection.getResponseCode() + ". Response: " + IOUtils.toString(inputstream4, Charsets.UTF_8));
                    }
                }
            }
            catch (Exception exception)
            {
                Texteria.log.error((String)"Could not upload shaderpack", (Throwable)exception);
            }
        }
    }

    public static class Verifier extends Thread
    {
        private static VimeShaderUtil.Verifier verifier;
        private final Object lock = new Object();
        private final Map<String, VimeShaderUtil.Verifier.Status> verified = new ConcurrentHashMap();
        private final Queue<VimeShaderUtil.Verifier.CheckEntry> queue = new ConcurrentLinkedQueue();

        public static synchronized VimeShaderUtil.Verifier instance()
        {
            if (verifier == null)
            {
                verifier = new VimeShaderUtil.Verifier();
                verifier.start();
            }

            return verifier;
        }

        public synchronized VimeShaderUtil.Verifier.Status getStatusLocked(File file)
        {
            long i = System.currentTimeMillis();

            while (true)
            {
                VimeShaderUtil.Verifier.Status vimeshaderutil$verifier$status = this.getStatus0(file, true);

                if (vimeshaderutil$verifier$status != VimeShaderUtil.Verifier.Status.VALIDATING)
                {
                    return vimeshaderutil$verifier$status;
                }

                try
                {
                    Thread.sleep(25L);
                }
                catch (InterruptedException var6)
                {
                    return VimeShaderUtil.Verifier.Status.ERROR;
                }

                if (System.currentTimeMillis() - i >= 5000L)
                {
                    break;
                }
            }

            return VimeShaderUtil.Verifier.Status.ERROR;
        }

        public synchronized VimeShaderUtil.Verifier.Status getStatus(File file)
        {
            return this.getStatus0(file, true);
        }

        private VimeShaderUtil.Verifier.Status getStatus0(File file, boolean wakeUp)
        {
            String s = this.id(file);
            VimeShaderUtil.Verifier.Status vimeshaderutil$verifier$status = (VimeShaderUtil.Verifier.Status)this.verified.get(s);

            if (vimeshaderutil$verifier$status == null)
            {
                this.verified.put(s, VimeShaderUtil.Verifier.Status.VALIDATING);
                vimeshaderutil$verifier$status = VimeShaderUtil.Verifier.Status.VALIDATING;
                this.queue.add(new VimeShaderUtil.Verifier.CheckEntry(file, s));

                if (wakeUp)
                {
                    synchronized (this.lock)
                    {
                        this.lock.notify();
                    }
                }
            }

            return vimeshaderutil$verifier$status;
        }

        public synchronized void verifyAll(File dir)
        {
            File[] afile = dir.listFiles();

            if (afile != null)
            {
                for (File file1 : afile)
                {
                    if (file1.isFile() && file1.getName().endsWith(".zip"))
                    {
                        this.getStatus0(file1, false);
                    }
                }

                synchronized (this.lock)
                {
                    this.lock.notify();
                }
            }
        }

        private String id(File file)
        {
            return file.getName() + file.length() + file.lastModified();
        }

        public void run()
        {
            while (true)
            {
                if (!this.queue.isEmpty())
                {
                    byte[] abyte = new byte[8192];
                    Map<String, List<VimeShaderUtil.Verifier.CheckEntry>> map = new HashMap();

                    for (VimeShaderUtil.Verifier.CheckEntry vimeshaderutil$verifier$checkentry = (VimeShaderUtil.Verifier.CheckEntry)this.queue.poll(); vimeshaderutil$verifier$checkentry != null; vimeshaderutil$verifier$checkentry = (VimeShaderUtil.Verifier.CheckEntry)this.queue.poll())
                    {
                        try
                        {
                            MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
                            InputStream inputstream = new FileInputStream(vimeshaderutil$verifier$checkentry.file);
                            Throwable json = null;

                            try
                            {
                                int i;

                                try
                                {
                                    while ((i = ((InputStream)inputstream).read(abyte)) > 0)
                                    {
                                        messagedigest.update(abyte, 0, i);
                                    }
                                }
                                catch (Throwable throwable6)
                                {
                                    json = throwable6;
                                    throw throwable6;
                                }
                            }
                            finally
                            {
                                if (inputstream != null)
                                {
                                    if (json != null)
                                    {
                                        try
                                        {
                                            inputstream.close();
                                        }
                                        catch (Throwable throwable4)
                                        {
                                            json.addSuppressed(throwable4);
                                        }
                                    }
                                    else
                                    {
                                        inputstream.close();
                                    }
                                }
                            }

                            String s = Hex.encodeHexString(messagedigest.digest());
                            ((List)map.computeIfAbsent(s, (h) ->
                            {
                                return new ArrayList();
                            })).add(vimeshaderutil$verifier$checkentry);
                        }
                        catch (Exception exception1)
                        {
                            Texteria.log.error((String)("Could not read file " + vimeshaderutil$verifier$checkentry.file.getName()), (Throwable)exception1);
                            this.verified.put(vimeshaderutil$verifier$checkentry.id, VimeShaderUtil.Verifier.Status.ERROR);
                        }
                    }

                    if (!map.isEmpty())
                    {
                        try
                        {
                            String s1 = VimeShaderUtil.GSON.toJson((Object)map.keySet());
                            HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL("https://shaderserver.vimeworld.com/client/check")).openConnection();
                            httpurlconnection.setConnectTimeout(3000);
                            httpurlconnection.setReadTimeout(3000);
                            httpurlconnection.setUseCaches(false);
                            httpurlconnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                            httpurlconnection.setRequestProperty("Content-Length", "" + s1.length());
                            httpurlconnection.setDoOutput(true);
                            OutputStream outputstream = httpurlconnection.getOutputStream();
                            Throwable errorStream = null;

                            try
                            {
                                IOUtils.write(s1.getBytes(StandardCharsets.UTF_8), outputstream);
                            }
                            catch (Throwable throwable3)
                            {
                                errorStream = throwable3;
                                throw throwable3;
                            }
                            finally
                            {
                                if (outputstream != null)
                                {
                                    if (errorStream != null)
                                    {
                                        try
                                        {
                                            outputstream.close();
                                        }
                                        catch (Throwable throwable2)
                                        {
                                            errorStream.addSuppressed(throwable2);
                                        }
                                    }
                                    else
                                    {
                                        outputstream.close();
                                    }
                                }
                            }

                            try
                            {
                                InputStream inputstream1 = httpurlconnection.getInputStream();
                                errorStream = null;

                                try
                                {
                                    String s2 = IOUtils.toString(inputstream1, Charsets.UTF_8);
                                    JsonElement jsonelement1 = (new JsonParser()).parse(s2);

                                    for (JsonElement jsonelement : jsonelement1.getAsJsonArray())
                                    {
                                        List<VimeShaderUtil.Verifier.CheckEntry> list = (List)map.remove(jsonelement.getAsString());

                                        if (list != null)
                                        {
                                            for (VimeShaderUtil.Verifier.CheckEntry vimeshaderutil$verifier$checkentry1 : list)
                                            {
                                                this.verified.put(vimeshaderutil$verifier$checkentry1.id, VimeShaderUtil.Verifier.Status.DENY);
                                            }
                                        }
                                    }

                                    Iterator iterator1 = map.values().iterator();

                                    while (iterator1.hasNext())
                                    {
                                        for (VimeShaderUtil.Verifier.CheckEntry vimeshaderutil$verifier$checkentry3 : (List)iterator1.next())
                                        {
                                            this.verified.put(vimeshaderutil$verifier$checkentry3.id, VimeShaderUtil.Verifier.Status.ALLOWED);
                                        }
                                    }
                                }
                                catch (Throwable throwable5)
                                {
                                    errorStream = throwable5;
                                    throw throwable5;
                                }
                                finally
                                {
                                    if (inputstream1 != null)
                                    {
                                        if (errorStream != null)
                                        {
                                            try
                                            {
                                                inputstream1.close();
                                            }
                                            catch (Throwable throwable1)
                                            {
                                                errorStream.addSuppressed(throwable1);
                                            }
                                        }
                                        else
                                        {
                                            inputstream1.close();
                                        }
                                    }
                                }
                            }
                            catch (IOException var74)
                            {
                                InputStream inputstream2 = httpurlconnection.getErrorStream();

                                if (inputstream2 != null)
                                {
                                    Texteria.log.error("Shaderpack check list error. Code " + httpurlconnection.getResponseCode() + ". Response: " + IOUtils.toString(inputstream2, Charsets.UTF_8));
                                }
                            }

                            httpurlconnection.disconnect();
                        }
                        catch (Exception exception)
                        {
                            Texteria.log.error((String)"Unable to check allowed shaderpacks list", (Throwable)exception);
                            Iterator connection = map.values().iterator();

                            while (connection.hasNext())
                            {
                                for (VimeShaderUtil.Verifier.CheckEntry vimeshaderutil$verifier$checkentry2 : (List)connection.next())
                                {
                                    this.verified.put(vimeshaderutil$verifier$checkentry2.id, VimeShaderUtil.Verifier.Status.ERROR);
                                }
                            }
                        }
                    }
                }

                try
                {
                    synchronized (this.lock)
                    {
                        this.lock.wait(3000L);
                    }
                }
                catch (InterruptedException var66)
                {
                    return;
                }
            }
        }

        private static class CheckEntry
        {
            File file;
            String id;

            public CheckEntry(File file, String id)
            {
                this.file = file;
                this.id = id;
            }
        }

        public static enum Status
        {
            VALIDATING,
            ALLOWED,
            DENY,
            ERROR;
        }
    }
}
