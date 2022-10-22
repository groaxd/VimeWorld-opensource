package net.xtrafrancyz.covered;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ObfValue
{
    private static byte[] temp;
    private static ObfValue.Pack currentPack;
    private static final List<ObfValue.Pack> generated = new CopyOnWriteArrayList();
    private static final ObfValue.WalkingInteger generatedSize = new ObfValue.WalkingInteger(0, 1);
    private static final ObfValue.WalkingInteger summaryHashState = new ObfValue.WalkingInteger(0, 1);
    private static final ObfValue.WalkingLong summaryHashLo = new ObfValue.WalkingLong(0L, 1);
    private static final ObfValue.WalkingLong summaryHashHi = new ObfValue.WalkingLong(0L, 1);
    private static final int sOZXO;

    public static ObfValue.ODouble create(double val)
    {
        offset();
        return (ObfValue.ODouble)count(new ObfValue.ODouble(val));
    }

    public static ObfValue.OFloat create(float val)
    {
        offset();
        return (ObfValue.OFloat)count(val.new OFloat());
    }

    public static ObfValue.OInteger create(int val)
    {
        offset();
        return (ObfValue.OInteger)count(new ObfValue.OInteger(val));
    }

    public static ObfValue.OLong create(long val)
    {
        offset();
        return (ObfValue.OLong)count(val.new OLong());
    }

    private static void offset()
    {
        ThreadLocalRandom threadlocalrandom = ThreadLocalRandom.current();
        temp = new byte[threadlocalrandom.nextInt(128)];
        threadlocalrandom.nextBytes(temp);
    }

    private static <T extends ObfValue.OValue> T count(T value)
    {
        currentPack.values.add(value);
        return (T)value;
    }

    public static void beginGeneration()
    {
        currentPack = new ObfValue.Pack();
    }

    public static void endGeneration(byte[] bytes)
    {
        if (temp != null)
        {
            temp = null;
        }

        long i = currentPack.verifyHash();
        long j = 1L;

        try
        {
            j = (new DataInputStream(new ByteArrayInputStream(bytes))).readLong();
        }
        catch (IOException var6)
        {
            ;
        }

        if (j != i)
        {
            throw new RuntimeException("Constants are not ok");
        }
        else
        {
            Collections.shuffle(currentPack.values);
            ObfValue.Pack.unpack(currentPack.runtimeHash(), currentPack.lo, currentPack.hi);
            generated.add(currentPack);
            currentPack = null;
            int k = generatedSize.get();
            ++k;
            generatedSize.set(k);
        }
    }

    public static void tick()
    {
        if (generatedSize.get() != generated.size())
        {
            sOZXO *= sOZXO;
            throw new RuntimeException("Something changed");
        }
        else
        {
            sOZXO ^= -2062206682;

            if (generated.size() > summaryHashState.get())
            {
                sOZXO += sOZXO;
                summaryHashState.set(generated.size());
                Hasher hasher = Hashing.murmur3_128().newHasher();
                sOZXO ^= 861597668;

                for (Object object : generated)
                {
                    sOZXO = -sOZXO;
                    ObfValue.Pack obfvalue$pack = (ObfValue.Pack)object;
                    byte[] abyte2 = obfvalue$pack.runtimeHash();
                    sOZXO += 1012488154;
                    hasher.putBytes(abyte2);
                    sOZXO ^= 1234162597;
                }

                HashCode hashcode = hasher.hash();
                sOZXO *= 775904429;
                ObfValue.Pack.unpack(hashcode.asBytes(), summaryHashLo, summaryHashHi);
            }

            sOZXO -= -69178415;
            ThreadLocalRandom threadlocalrandom = ThreadLocalRandom.current();

            if (threadlocalrandom.nextBoolean())
            {
                sOZXO *= sOZXO;
                boolean flag = threadlocalrandom.nextBoolean();
                sOZXO += sOZXO;

                if (flag && threadlocalrandom.nextBoolean())
                {
                    ObfValue.WalkingLong obfvalue$walkinglong = new ObfValue.WalkingLong(0L, 100);
                    sOZXO *= 1851605632;
                    sOZXO = -sOZXO;
                    sOZXO *= 391778276;
                    ObfValue.WalkingLong obfvalue$walkinglong1 = new ObfValue.WalkingLong(0L, 100);
                    sOZXO *= sOZXO;
                    HashFunction hashfunction = Hashing.murmur3_128();
                    sOZXO ^= 2050881404;
                    Hasher hasher1 = hashfunction.newHasher();

                    for (ObfValue.Pack pack : generated)
                    {
                        sOZXO = -sOZXO;
                        byte[] abyte = pack.runtimeHash();
                        sOZXO -= -679769432;
                        ObfValue.Pack.unpack(abyte, obfvalue$walkinglong, obfvalue$walkinglong1);

                        if (obfvalue$walkinglong.get() != pack.lo.get())
                        {
                            throw new RuntimeException("Something changed");
                        }

                        long i = obfvalue$walkinglong1.get();
                        sOZXO = 1744846234;

                        if (i != pack.hi.get())
                        {
                            throw new RuntimeException("Something changed");
                        }

                        hasher1.putBytes(abyte);
                    }

                    byte[] abyte1 = hasher1.hash().asBytes();
                    sOZXO = -sOZXO;
                    ObfValue.Pack.unpack(abyte1, obfvalue$walkinglong, obfvalue$walkinglong1);
                    long j = obfvalue$walkinglong.get();
                    sOZXO = -sOZXO;
                    ObfValue.WalkingLong obfvalue$walkinglong2 = summaryHashLo;
                    sOZXO = -242554443 * sOZXO;
                    long k = obfvalue$walkinglong2.get();
                    sOZXO += -978555145;

                    if (j != k || obfvalue$walkinglong1.get() != summaryHashHi.get())
                    {
                        throw new RuntimeException("Something changed");
                    }
                }
            }
        }
    }

    private static class ContainerInt
    {
        public int value;

        public ContainerInt(int value)
        {
            this.value = value;
        }
    }

    private static class ContainerLong
    {
        public long value;

        public ContainerLong(long value)
        {
            this.value = value;
        }
    }

    public static class ODouble implements ObfValue.OValue
    {
        private static volatile long wtf = 0L;
        private long obfuscated;
        private final long salt = ThreadLocalRandom.current().nextLong();

        public ODouble(double value)
        {
            this.set(value);
        }

        public void set(double value)
        {
            this.obfuscated = Double.doubleToLongBits(value) ^ this.salt;
        }

        public double get()
        {
            return Double.longBitsToDouble(this.obfuscated ^ this.salt + wtf);
        }

        public boolean equals(double d, double e)
        {
            return Math.abs(this.get() - d) < e;
        }

        public int hashCode()
        {
            return Double.hashCode(this.get());
        }

        public long runtimeHash()
        {
            return this.obfuscated + this.salt + wtf + this.obfuscated ^ this.salt;
        }
    }

    public class OFloat implements ObfValue.OValue
    {
        private static volatile int wtf = 0;
        private int obfuscated;
        private final int salt = ThreadLocalRandom.current().nextInt();

        public OFloat()
        {
            this.set(ObfValue.this);
        }

        public void set(float value)
        {
            this.obfuscated = Float.floatToIntBits(value) ^ this.salt;
        }

        public float get()
        {
            return Float.intBitsToFloat(this.obfuscated ^ this.salt + wtf);
        }

        public boolean equals(float f, float e)
        {
            return Math.abs(this.get() - f) < e;
        }

        public int hashCode()
        {
            return Float.hashCode(this.get());
        }

        public long runtimeHash()
        {
            return (long)(this.obfuscated + this.salt + wtf + this.obfuscated ^ this.salt);
        }
    }

    public static class OInteger implements ObfValue.OValue
    {
        private static volatile int wtf = 0;
        private int obfuscated;
        private final int salt = ThreadLocalRandom.current().nextInt();

        public OInteger(int value)
        {
            this.set(value);
        }

        public void set(int value)
        {
            this.obfuscated = value ^ this.salt;
        }

        public int get()
        {
            return this.obfuscated ^ this.salt + wtf;
        }

        public int inc()
        {
            int i = this.get();
            ++i;
            this.set(i);
            return i;
        }

        public int hashCode()
        {
            return Integer.hashCode(this.get());
        }

        public long runtimeHash()
        {
            return (long)(this.obfuscated + this.salt + wtf + this.obfuscated ^ this.salt);
        }
    }

    public class OLong implements ObfValue.OValue
    {
        private static volatile long wtf = 0L;
        private long obfuscated;
        private final long salt = ThreadLocalRandom.current().nextLong();

        public OLong()
        {
            this.set(ObfValue.this);
        }

        public void set(long value)
        {
            this.obfuscated = value ^ this.salt;
        }

        public long get()
        {
            return this.obfuscated ^ this.salt + wtf;
        }

        public int hashCode()
        {
            return Long.hashCode(this.get());
        }

        public long runtimeHash()
        {
            return this.obfuscated + this.salt + wtf + this.obfuscated ^ this.salt;
        }
    }

    private interface OValue
    {
        long runtimeHash();
    }

    private static class Pack
    {
        List<ObfValue.OValue> values;
        ObfValue.WalkingLong lo;
        ObfValue.WalkingLong hi;
        private static final int uWELk;

        private Pack()
        {
            this.values = new ArrayList();
            this.lo = new ObfValue.WalkingLong(0L, 1);
            this.hi = new ObfValue.WalkingLong(0L, 1);
        }

        private long verifyHash()
        {
            long i = 0L;

            for (ObfValue.OValue obfvalue$ovalue : this.values)
            {
                i = 31L * i + (long)obfvalue$ovalue.hashCode();
            }

            return i;
        }

        private byte[] runtimeHash()
        {
            Hasher hasher1 = Hashing.murmur3_128().newHasher();
            uWELk += 1327041351;
            Hasher hasher = hasher1;
            uWELk = -1405963955;
            uWELk &= 872393460;
            Iterator iterator1 = this.values.iterator();
            uWELk = -uWELk;
            Iterator iterator = iterator1;

            while (true)
            {
                uWELk += uWELk;

                if (!iterator.hasNext())
                {
                    return hasher.hash().asBytes();
                }

                ObfValue.OValue obfvalue$ovalue1 = (ObfValue.OValue)iterator.next();
                uWELk = -840032654;
                ObfValue.OValue val = obfvalue$ovalue1;
                uWELk += 1765265839;
                uWELk = -uWELk;
                hasher.putLong(val.runtimeHash());
            }
        }

        private static void unpack(byte[] bytes, ObfValue.WalkingLong lo, ObfValue.WalkingLong hi)
        {
            ByteBuffer bytebuffer = ByteBuffer.wrap(bytes);
            uWELk += uWELk;
            hi.set(bytebuffer.getLong());
            uWELk += uWELk;
            lo.set(bytebuffer.getLong());
        }
    }

    public static class WalkingBoolean extends ObfValue.WalkingIntegerContainer
    {
        private static final int TRUE = ThreadLocalRandom.current().nextInt();
        private static final int FALSE = ThreadLocalRandom.current().nextInt();

        public WalkingBoolean(boolean value, int walk)
        {
            super(value ? TRUE : FALSE, walk);
        }

        public void set(boolean value)
        {
            this.set0(value ? TRUE : FALSE);
        }

        public boolean get()
        {
            return this.get0() == TRUE;
        }
    }

    public static class WalkingDouble extends ObfValue.WalkingLongContainer
    {
        public WalkingDouble(double value, int walk)
        {
            super(Double.doubleToLongBits(value), walk);
        }

        public void set(double value)
        {
            this.set0(Double.doubleToLongBits(value));
        }

        public double get()
        {
            return Double.longBitsToDouble(this.get0());
        }
    }

    public static class WalkingFloat extends ObfValue.WalkingIntegerContainer
    {
        public WalkingFloat(float value, int walk)
        {
            super(Float.floatToIntBits(value), walk);
        }

        public float get()
        {
            return Float.intBitsToFloat(this.get0());
        }

        public void set(float value)
        {
            this.set0(Float.floatToIntBits(value));
        }
    }

    public static class WalkingInteger extends ObfValue.WalkingIntegerContainer
    {
        public WalkingInteger(int value, int walk)
        {
            super(value, walk);
        }

        public int get()
        {
            return this.get0();
        }

        public void set(int value)
        {
            this.set0(value);
        }
    }

    private static class WalkingIntegerContainer
    {
        private ObfValue.ContainerInt obfuscated;
        private ObfValue.ContainerInt salt;
        private final int walk;
        private int steps;

        protected WalkingIntegerContainer(int value, int walk)
        {
            this.walk = walk;
            this.salt = new ObfValue.ContainerInt(ThreadLocalRandom.current().nextInt());
            this.obfuscated = new ObfValue.ContainerInt(0);
            this.set0(value);
        }

        protected void set0(int value)
        {
            if (this.steps++ == this.walk)
            {
                this.steps = 0;
                this.salt.value = ThreadLocalRandom.current().nextInt();
                this.obfuscated = new ObfValue.ContainerInt(value ^ this.salt.value);
            }
            else
            {
                this.obfuscated.value = value ^ this.salt.value;
            }
        }

        protected int get0()
        {
            return this.obfuscated.value ^ this.salt.value;
        }
    }

    public static class WalkingLong extends ObfValue.WalkingLongContainer
    {
        public WalkingLong(long value, int walk)
        {
            super(value, walk);
        }

        public long get()
        {
            return this.get0();
        }

        public void set(long value)
        {
            this.set0(value);
        }
    }

    private static class WalkingLongContainer
    {
        private ObfValue.ContainerLong obfuscated;
        private ObfValue.ContainerLong salt;
        private final int walk;
        private int steps;

        protected WalkingLongContainer(long value, int walk)
        {
            this.walk = walk;
            this.obfuscated = new ObfValue.ContainerLong(0L);
            this.salt = new ObfValue.ContainerLong(ThreadLocalRandom.current().nextLong());
            this.set0(value);
        }

        protected void set0(long value)
        {
            if (this.steps++ == this.walk)
            {
                this.steps = 0;
                this.salt.value = ThreadLocalRandom.current().nextLong();
                this.obfuscated = new ObfValue.ContainerLong(value ^ this.salt.value);
            }
            else
            {
                this.obfuscated.value = value ^ this.salt.value;
            }
        }

        protected long get0()
        {
            return this.obfuscated.value ^ this.salt.value;
        }
    }
}
