package net.xtrafrancyz.mods.texteria.resources;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import net.xtrafrancyz.VimeStorage;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.util.ByteMap;

public class TexteriaResourceManager
{
    public static final String STORAGE_PREFIX = "resource/";
    private final Map<String, TexteriaResource> resources = new ConcurrentHashMap();
    private static final char[] HEX_CHARS = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public void handlePacket(ByteMap map)
    {
        String s = map.getString("do", "");
        byte b0 = -1;

        switch (s.hashCode())
        {
            case 3327206:
                if (s.equals("load"))
                {
                    b0 = 1;
                }

                break;

            case 94627080:
                if (s.equals("check"))
                {
                    b0 = 0;
                }
        }

        switch (b0)
        {
            case 0:
                List<Integer> list = new ArrayList();
                byte[] abyte2 = map.getByteArray("list");

                for (int j = 0; j < abyte2.length / 16; ++j)
                {
                    String s2 = asHex(abyte2, j * 16, 16);
                    TexteriaResource texteriaresource = (TexteriaResource)this.resources.get(s2);

                    if (texteriaresource == null || !texteriaresource.getEntry().isDone())
                    {
                        VimeStorage.Entry vimestorage$entry = Texteria.instance.storage.getEntry("resource/" + s2);

                        if (!vimestorage$entry.exists())
                        {
                            list.add(Integer.valueOf(j));
                            this.resources.put(s2, new TexteriaResource(s2));
                        }
                        else
                        {
                            this.resources.put(s2, new TexteriaResource(s2, vimestorage$entry));
                        }
                    }
                }

                if (!list.isEmpty())
                {
                    byte[] abyte3 = new byte[16 * list.size()];

                    for (int k = 0; k < ((List)list).size(); ++k)
                    {
                        System.arraycopy(abyte2, ((Integer)list.get(k)).intValue() * 16, abyte3, k * 16, 16);
                    }

                    ByteMap bytemap = new ByteMap();
                    bytemap.put("%", "resource");
                    bytemap.put("rp", map.get("rp"));
                    bytemap.put("needed", abyte3);
                    Texteria.sendPacket(bytemap);
                }

                break;

            case 1:
                byte[] abyte = map.getByteArray("keys");

                for (int i = 0; i < abyte.length / 16; ++i)
                {
                    byte[] abyte1 = map.getByteArray("#" + i);

                    if (abyte1 != null)
                    {
                        String s1 = asHex(abyte, i * 16, 16);
                        this.save(s1, abyte1);
                    }
                }
        }
    }

    public void save(String id, byte[] data)
    {
        TexteriaResource texteriaresource = (TexteriaResource)this.resources.computeIfAbsent(id, TexteriaResource::<init>);

        if (!texteriaresource.getEntry().isDone())
        {
            VimeStorage.Entry vimestorage$entry = Texteria.instance.storage.getEntry("resource/" + id);

            try
            {
                OutputStream outputstream = vimestorage$entry.getOutputStream();
                Throwable throwable = null;

                try
                {
                    outputstream.write(data);
                }
                catch (Throwable throwable2)
                {
                    throwable = throwable2;
                    throw throwable2;
                }
                finally
                {
                    if (outputstream != null)
                    {
                        if (throwable != null)
                        {
                            try
                            {
                                outputstream.close();
                            }
                            catch (Throwable throwable1)
                            {
                                throwable.addSuppressed(throwable1);
                            }
                        }
                        else
                        {
                            outputstream.close();
                        }
                    }
                }
            }
            catch (Exception exception)
            {
                vimestorage$entry.delete();
                Texteria.log.warn((String)("Could not save resource " + id + " with size " + data.length), (Throwable)exception);
                return;
            }

            vimestorage$entry.save(2592000);
            texteriaresource.load(vimestorage$entry, data);
        }
    }

    public TexteriaResource getResource(String id)
    {
        return (TexteriaResource)this.resources.get(id);
    }

    public TexteriaResource getResource(byte[] id)
    {
        return (TexteriaResource)this.resources.get(asHex(id));
    }

    public void invalidate(TexteriaResource resource)
    {
        this.resources.remove(resource.getId());
        Texteria.instance.storage.getEntry("resource/" + resource.getId()).delete();
    }

    public static String asHex(byte[] data)
    {
        return asHex(data, 0, data.length);
    }

    public static String asHex(byte[] data, int offset, int length)
    {
        char[] achar = new char[length * 2];
        int int = offset;

        for (int int = 0; int < offset + length; ++int)
        {
            achar[int++] = HEX_CHARS[data[int] >>> 4 & 15];
            achar[int++] = HEX_CHARS[data[int] & 15];
        }

        return new String(achar);
    }
}
