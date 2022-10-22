package net.xtrafrancyz.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import net.minecraft.network.PacketBuffer;
import net.xtrafrancyz.mods.texteria.resources.TexteriaResourceManager;

public class ByteMap extends HashMap<String, Object>
{
    private static final byte TYPE_INT = 1;
    private static final byte TYPE_BYTE = 2;
    private static final byte TYPE_LONG = 3;
    private static final byte TYPE_STRING = 4;
    private static final byte TYPE_SHORT = 5;
    private static final byte TYPE_FLOAT = 6;
    private static final byte TYPE_DOUBLE = 7;
    private static final byte TYPE_BOOLEAN = 8;
    private static final byte TYPE_MAP = 9;
    private static final byte TYPE_BYTE_ARRAY = 10;
    private static final byte TYPE_STRING_ARRAY = 11;
    private static final byte TYPE_MAP_ARRAY = 12;
    private static final byte TYPE_VARINT = 13;
    private static final byte TYPE_LONG_VARINT = 14;
    private static final byte TYPE_UUID = 15;
    private static final byte TYPE_VARINT_ARRAY = 16;
    private static final byte TYPE_SIGNED_VARINT = 17;
    private static final byte TYPE_SIGNED_VARINT_ARRAY = 18;
    private static final byte TYPE_INT_ARRAY = 19;
    private static final byte TYPE_STRING_ARRAY_2D = 20;
    private static final byte TYPE_LONG_ARRAY = 21;

    public ByteMap()
    {
    }

    public ByteMap(HashMap<String, Object> map)
    {
        super(map);
    }

    public ByteMap(byte[] bytes)
    {
        this(new PacketBuffer(Unpooled.wrappedBuffer(bytes)));
    }

    public ByteMap(PacketBuffer in)
    {
        try
        {
            while (in.readerIndex() < in.capacity())
            {
                String s = in.readStringFromBuffer(256);

                switch (in.readByte())
                {
                    case 1:
                        this.put(s, Integer.valueOf(in.readInt()));
                        break;

                    case 2:
                        this.put(s, Byte.valueOf(in.readByte()));
                        break;

                    case 3:
                        this.put(s, Long.valueOf(in.readLong()));
                        break;

                    case 4:
                        this.put(s, in.readStringFromBuffer(32767));
                        break;

                    case 5:
                        this.put(s, Short.valueOf(in.readShort()));
                        break;

                    case 6:
                        this.put(s, Float.valueOf(in.readFloat()));
                        break;

                    case 7:
                        this.put(s, Double.valueOf(in.readDouble()));
                        break;

                    case 8:
                        this.put(s, Boolean.valueOf(in.readBoolean()));
                        break;

                    case 9:
                        byte[] abyte1 = new byte[in.readVarIntFromBuffer()];
                        in.readBytes((byte[])abyte1, 0, abyte1.length);
                        this.put(s, new ByteMap(abyte1));
                        break;

                    case 10:
                        byte[] abyte = new byte[in.readVarIntFromBuffer()];
                        in.readBytes((byte[])abyte, 0, abyte.length);
                        this.put(s, abyte);
                        break;

                    case 11:
                        String[] astring2 = new String[in.readVarIntFromBuffer()];

                        for (int l1 = 0; l1 < astring2.length; ++l1)
                        {
                            astring2[l1] = in.readStringFromBuffer(32767);
                        }

                        this.put(s, astring2);
                        break;

                    case 12:
                        ByteMap[] abytemap = new ByteMap[in.readVarIntFromBuffer()];

                        for (int k1 = 0; k1 < abytemap.length; ++k1)
                        {
                            byte[] abyte2 = new byte[in.readVarIntFromBuffer()];
                            in.readBytes((byte[])abyte2, 0, abyte2.length);
                            abytemap[k1] = new ByteMap(abyte2);
                        }

                        this.put(s, abytemap);
                        break;

                    case 13:
                        this.put(s, Integer.valueOf(in.readVarIntFromBuffer()));
                        break;

                    case 14:
                        this.put(s, Long.valueOf((long)in.readVarIntFromBuffer()));
                        break;

                    case 15:
                        this.put(s, new UUID(in.readLong(), in.readLong()));
                        break;

                    case 16:
                        int[] aint2 = new int[in.readVarIntFromBuffer()];

                        for (int j1 = 0; j1 < aint2.length; ++j1)
                        {
                            aint2[j1] = in.readVarIntFromBuffer();
                        }

                        this.put(s, aint2);
                        break;

                    case 17:
                        this.put(s, Integer.valueOf(readSignedVarInt(in)));
                        break;

                    case 18:
                        int[] aint1 = new int[in.readVarIntFromBuffer()];

                        for (int i1 = 0; i1 < aint1.length; ++i1)
                        {
                            aint1[i1] = readSignedVarInt(in);
                        }

                        this.put(s, aint1);
                        break;

                    case 19:
                        int[] aint = new int[in.readVarIntFromBuffer()];

                        for (int l = 0; l < aint.length; ++l)
                        {
                            aint[l] = in.readInt();
                        }

                        this.put(s, aint);
                        break;

                    case 20:
                        String[][] astring1 = new String[in.readVarIntFromBuffer()][];

                        for (int k = 0; k < astring1.length; ++k)
                        {
                            String[] astring = astring1[k] = new String[in.readVarIntFromBuffer()];

                            for (int j = 0; j < astring.length; ++j)
                            {
                                astring[j] = in.readStringFromBuffer(32767);
                            }
                        }

                        this.put(s, astring1);
                        break;

                    case 21:
                        long[] along = new long[in.readVarIntFromBuffer()];

                        for (int i = 0; i < along.length; ++i)
                        {
                            along[i] = in.readLong();
                        }

                        this.put(s, along);
                }
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public byte[] toByteArray()
    {
        ByteBuf bytebuf = Unpooled.buffer();

        try
        {
            PacketBuffer packetbuffer = new PacketBuffer(bytebuf);

            for (Entry<String, Object> entry : this.entrySet())
            {
                packetbuffer.writeString((String)entry.getKey());
                Object object = entry.getValue();
                Class oclass = object.getClass();

                if (oclass == Integer.class)
                {
                    int j = ((Integer)object).intValue();

                    if (j >= 0 && j < 2097152)
                    {
                        packetbuffer.writeByte(13);
                        packetbuffer.writeVarIntToBuffer(j);
                    }
                    else if (j < 0 && j > -1048576)
                    {
                        packetbuffer.writeByte(17);
                        writeSignedVarInt(packetbuffer, j);
                    }
                    else
                    {
                        packetbuffer.writeByte(1);
                        packetbuffer.writeInt(j);
                    }
                }
                else if (oclass == Float.class)
                {
                    packetbuffer.writeByte(6);
                    packetbuffer.writeFloat(((Float)object).floatValue());
                }
                else if (oclass == Byte.class)
                {
                    packetbuffer.writeByte(2);
                    packetbuffer.writeByte(((Byte)object).byteValue());
                }
                else if (oclass == Short.class)
                {
                    packetbuffer.writeByte(5);
                    packetbuffer.writeShort(((Short)object).shortValue());
                }
                else if (oclass == Long.class)
                {
                    long i = ((Long)object).longValue();

                    if (i >= 0L && i < 2097152L)
                    {
                        packetbuffer.writeByte(14);
                        packetbuffer.writeVarIntToBuffer((int)i);
                    }
                    else
                    {
                        packetbuffer.writeByte(3);
                        packetbuffer.writeLong(i);
                    }
                }
                else if (oclass == String.class)
                {
                    packetbuffer.writeByte(4);
                    packetbuffer.writeString((String)object);
                }
                else if (oclass == Double.class)
                {
                    packetbuffer.writeByte(7);
                    packetbuffer.writeDouble(((Double)object).doubleValue());
                }
                else if (oclass == Boolean.class)
                {
                    packetbuffer.writeByte(8);
                    packetbuffer.writeBoolean(((Boolean)object).booleanValue());
                }
                else if (oclass == UUID.class)
                {
                    packetbuffer.writeByte(15);
                    UUID uuid = (UUID)object;
                    packetbuffer.writeLong(uuid.getMostSignificantBits());
                    packetbuffer.writeLong(uuid.getLeastSignificantBits());
                }
                else if (oclass == ByteMap.class)
                {
                    packetbuffer.writeByte(9);
                    byte[] abyte2 = ((ByteMap)object).toByteArray();
                    packetbuffer.writeVarIntToBuffer(abyte2.length);
                    packetbuffer.writeBytes(abyte2);
                }
                else if (oclass == byte[].class)
                {
                    packetbuffer.writeByte(10);
                    byte[] abyte1 = (byte[])((byte[])object);
                    packetbuffer.writeVarIntToBuffer(abyte1.length);
                    packetbuffer.writeBytes(abyte1);
                }
                else if (oclass == int[].class)
                {
                    int[] aint = (int[])((int[])object);

                    if (aint.length == 0)
                    {
                        packetbuffer.writeByte(16);
                        packetbuffer.writeByte(0);
                    }
                    else
                    {
                        boolean flag = true;
                        boolean flag1 = false;

                        for (int k = 0; k < 4 && k < aint.length; ++k)
                        {
                            if (aint[k] < 0 || aint[k] > 2097152)
                            {
                                flag = false;
                            }

                            if (aint[k] < 0 && aint[k] > -1048576)
                            {
                                flag1 = true;
                            }
                        }

                        if (flag)
                        {
                            packetbuffer.writeByte(16);
                            packetbuffer.writeVarIntToBuffer(aint.length);

                            for (int k1 : aint)
                            {
                                packetbuffer.writeVarIntToBuffer(k1);
                            }
                        }
                        else if (flag1)
                        {
                            packetbuffer.writeByte(18);
                            packetbuffer.writeVarIntToBuffer(aint.length);

                            for (int j1 : aint)
                            {
                                writeSignedVarInt(packetbuffer, j1);
                            }
                        }
                        else
                        {
                            packetbuffer.writeByte(19);
                            packetbuffer.writeVarIntToBuffer(aint.length);

                            for (int i1 : aint)
                            {
                                packetbuffer.writeInt(i1);
                            }
                        }
                    }
                }
                else if (oclass == String[].class)
                {
                    packetbuffer.writeByte(11);
                    String[] astring2 = (String[])((String[])object);
                    packetbuffer.writeVarIntToBuffer(astring2.length);

                    for (String s1 : astring2)
                    {
                        packetbuffer.writeString(s1);
                    }
                }
                else if (oclass != String[][].class)
                {
                    if (oclass == ByteMap[].class)
                    {
                        packetbuffer.writeByte(12);
                        ByteMap[] abytemap = (ByteMap[])((ByteMap[])object);
                        packetbuffer.writeVarIntToBuffer(abytemap.length);

                        for (ByteMap bytemap : abytemap)
                        {
                            byte[] abyte3 = bytemap.toByteArray();
                            packetbuffer.writeVarIntToBuffer(abyte3.length);
                            packetbuffer.writeBytes(abyte3);
                        }
                    }
                    else
                    {
                        if (oclass != long[].class)
                        {
                            throw new IllegalStateException("Unknown value type " + oclass + " for key \'" + (String)entry.getKey() + "\'");
                        }

                        long[] along = (long[])((long[])object);
                        packetbuffer.writeByte(21);
                        packetbuffer.writeVarIntToBuffer(along.length);

                        for (long l : along)
                        {
                            packetbuffer.writeLong(l);
                        }
                    }
                }
                else
                {
                    packetbuffer.writeByte(20);
                    String[][] astring = (String[][])((String[][])object);
                    packetbuffer.writeVarIntToBuffer(astring.length);

                    for (String[] astring1 : astring)
                    {
                        packetbuffer.writeVarIntToBuffer(astring1.length);

                        for (String s : astring1)
                        {
                            packetbuffer.writeString(s);
                        }
                    }
                }
            }

            byte[] abyte = new byte[bytebuf.writerIndex()];
            bytebuf.readBytes(abyte);
            bytebuf.release();
            return abyte;
        }
        catch (Exception exception)
        {
            bytebuf.release();
            exception.printStackTrace();
            return new byte[0];
        }
    }

    private static int readSignedVarInt(PacketBuffer buf)
    {
        int i = buf.readVarIntFromBuffer();
        int j = (i << 31 >> 31 ^ i) >> 1;
        return j ^ i & Integer.MIN_VALUE;
    }

    private static void writeSignedVarInt(PacketBuffer buf, int val)
    {
        buf.writeVarIntToBuffer(val << 1 ^ val >> 31);
    }

    public String getString(String key)
    {
        return (String)this.get(key);
    }

    public byte getByte(String key)
    {
        return ((Number)this.get(key)).byteValue();
    }

    public short getShort(String key)
    {
        return ((Number)this.get(key)).shortValue();
    }

    public float getFloat(String key)
    {
        return ((Number)this.get(key)).floatValue();
    }

    public double getDouble(String key)
    {
        return ((Number)this.get(key)).doubleValue();
    }

    public int getInt(String key)
    {
        return ((Number)this.get(key)).intValue();
    }

    public long getLong(String key)
    {
        return ((Number)this.get(key)).longValue();
    }

    public boolean getBoolean(String key)
    {
        return ((Boolean)this.get(key)).booleanValue();
    }

    public UUID getUUID(String key)
    {
        return (UUID)this.get(key);
    }

    public ByteMap getMap(String key)
    {
        return (ByteMap)this.get(key);
    }

    public byte[] getByteArray(String key)
    {
        return (byte[])((byte[])this.get(key));
    }

    public int[] getIntArray(String key)
    {
        return (int[])((int[])this.get(key));
    }

    public String[] getStringArray(String key)
    {
        return (String[])((String[])this.get(key));
    }

    public ByteMap[] getMapArray(String key)
    {
        return (ByteMap[])((ByteMap[])this.get(key));
    }

    public long[] getLongArray(String key)
    {
        return (long[])((long[])this.get(key));
    }

    public String getString(String key, String def)
    {
        Object object = this.get(key);
        return object == null ? def : (String)object;
    }

    public byte getByte(String key, byte def)
    {
        Object object = this.get(key);
        return object == null ? def : ((Number)this.get(key)).byteValue();
    }

    public short getShort(String key, short def)
    {
        Object object = this.get(key);
        return object == null ? def : ((Number)this.get(key)).shortValue();
    }

    public float getFloat(String key, float def)
    {
        Object object = this.get(key);
        return object == null ? def : ((Number)this.get(key)).floatValue();
    }

    public double getDouble(String key, double def)
    {
        Object object = this.get(key);
        return object == null ? def : ((Number)this.get(key)).doubleValue();
    }

    public int getInt(String key, int def)
    {
        Object object = this.get(key);
        return object == null ? def : ((Number)this.get(key)).intValue();
    }

    public long getLong(String key, long def)
    {
        Object object = this.get(key);
        return object == null ? def : ((Number)this.get(key)).longValue();
    }

    public boolean getBoolean(String key, boolean def)
    {
        Object object = this.get(key);
        return object == null ? def : ((Boolean)object).booleanValue();
    }

    public ByteMap getMap(String key, ByteMap def)
    {
        Object object = this.get(key);
        return object == null ? def : (ByteMap)object;
    }

    public <T extends Enum<T>> T getStringEnum(String key, T def)
    {
        String s = this.getString(key);

        if (s == null)
        {
            return (T)def;
        }
        else
        {
            try
            {
                return Enum.valueOf(def.getDeclaringClass(), s);
            }
            catch (IllegalArgumentException var5)
            {
                return (T)def;
            }
        }
    }

    public String toString()
    {
        if (this.isEmpty())
        {
            return "{}";
        }
        else
        {
            Iterator<String> iterator = ((List)this.keySet().stream().sorted().collect(Collectors.toList())).iterator();
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append('{');

            while (true)
            {
                String s = (String)iterator.next();
                Object object = this.get(s);
                stringbuilder.append(s);
                stringbuilder.append('=');
                String s1;

                if (object == this)
                {
                    s1 = "(this Map)";
                }
                else if (object instanceof byte[])
                {
                    byte[] abyte = (byte[])((byte[])object);
                    s1 = TexteriaResourceManager.asHex(abyte, 0, Math.min(64, abyte.length));

                    if (abyte.length > 64)
                    {
                        s1 = s1 + "... (" + abyte.length + ")";
                    }
                }
                else if (object instanceof int[])
                {
                    s1 = Arrays.toString((int[])((int[])object));
                }
                else if (object instanceof Object[])
                {
                    s1 = Arrays.deepToString((Object[])((Object[])object));
                }
                else
                {
                    s1 = String.valueOf(object);
                }

                stringbuilder.append(s1);

                if (!iterator.hasNext())
                {
                    return stringbuilder.append('}').toString();
                }

                stringbuilder.append(',').append(' ');
            }
        }
    }
}
