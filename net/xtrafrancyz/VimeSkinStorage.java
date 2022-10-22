package net.xtrafrancyz;

import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public class VimeSkinStorage extends VimeStorage
{
    public VimeSkinStorage(File index, File root)
    {
        super(index, root);
    }

    protected int getEntryVersion()
    {
        return 1;
    }

    protected VimeStorage.Entry createEntry()
    {
        return new VimeSkinStorage.Entry();
    }

    public VimeSkinStorage.Entry getEntry(String path)
    {
        return (VimeSkinStorage.Entry)super.getEntry(path);
    }

    public VimeSkinStorage.Entry getEntryForTexture(Type type, String username)
    {
        String s = (type == Type.SKIN ? "skins/" : "capes/") + (username.length() > 2 ? username.substring(0, 2).toLowerCase() : "xx") + "/" + username + ".png";
        return this.getEntry(s);
    }

    public class Entry extends VimeStorage.Entry
    {
        private long lastModify;

        public Entry()
        {
        }

        public void setLastModify(long lastModify)
        {
            this.lastModify = lastModify;
            VimeSkinStorage.this.dirty = true;
        }

        public long getLastModify()
        {
            return this.lastModify;
        }

        protected void serialize(DataOutputStream dos) throws IOException
        {
            super.serialize(dos);
            dos.writeLong(this.lastModify);
        }

        protected void deserialize(DataInputStream dis, int version) throws IOException
        {
            super.deserialize(dis, version);
            this.lastModify = dis.readLong();
        }
    }
}
