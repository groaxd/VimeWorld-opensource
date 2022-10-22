package net.xtrafrancyz.mods.texteria.resources;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import net.xtrafrancyz.VimeStorage;
import net.xtrafrancyz.mods.texteria.Texteria;

public class TexteriaResource
{
    private final String id;
    private volatile byte[] data;
    private final CompletableFuture<VimeStorage.Entry> entry;
    private final List<TexteriaResource.LockedInputStream> futures = new ArrayList();

    public TexteriaResource(String id)
    {
        this.id = id;
        this.entry = new CompletableFuture();
    }

    public TexteriaResource(String id, VimeStorage.Entry entry)
    {
        this.id = id;
        this.entry = CompletableFuture.<VimeStorage.Entry>completedFuture(entry);
    }

    public InputStream getInputStream() throws IOException
    {
        VimeStorage.Entry vimestorage$entry = (VimeStorage.Entry)this.entry.getNow((VimeStorage.Entry)null);

        if (vimestorage$entry != null)
        {
            return vimestorage$entry.getInputStream();
        }
        else
        {
            synchronized (this.futures)
            {
                if (this.data != null)
                {
                    return new ByteArrayInputStream(this.data);
                }
                else
                {
                    TexteriaResource.LockedInputStream texteriaresource$lockedinputstream = new TexteriaResource.LockedInputStream();
                    this.futures.add(texteriaresource$lockedinputstream);
                    return texteriaresource$lockedinputstream;
                }
            }
        }
    }

    public CompletableFuture<VimeStorage.Entry> getEntry()
    {
        return this.entry;
    }

    public String getRelativePath()
    {
        return "texteria/cache/resource/" + this.id;
    }

    public String getId()
    {
        return this.id;
    }

    public void invalidate()
    {
        Texteria.instance.resourceManager.invalidate(this);
    }

    void load(VimeStorage.Entry file, byte[] data)
    {
        synchronized (this.futures)
        {
            this.data = data;
            this.entry.complete(file);
            this.futures.forEach((ls) ->
            {
                ls.future.complete(new ByteArrayInputStream(data));
            });
            this.futures.clear();
        }
    }

    private static class LockedInputStream extends FilterInputStream
    {
        private final CompletableFuture<InputStream> future = new CompletableFuture();

        protected LockedInputStream()
        {
            super((InputStream)null);
        }

        public int read(byte[] b, int off, int len) throws IOException
        {
            if (this.in == null)
            {
                this.in = (InputStream)this.future.join();
            }

            return super.read(b, off, len);
        }

        public int read() throws IOException
        {
            if (this.in == null)
            {
                this.in = (InputStream)this.future.join();
            }

            return super.read();
        }

        public void close() throws IOException
        {
            if (this.in != null)
            {
                super.close();
            }
        }
    }
}
