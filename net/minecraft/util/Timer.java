package net.minecraft.util;

import net.minecraft.client.Minecraft;
import net.xtrafrancyz.covered.ObfValue;

public class Timer
{
    private static final ObfValue.ODouble OBFVAL_8jNf9 = ObfValue.create(0.20000000298023224D);
    private static final ObfValue.OLong OBFVAL_e2Xoz = ObfValue.create(1000L);
    private static final ObfValue.OInteger OBFVAL_gLbOj = ObfValue.create(10);
    private static final ObfValue.OLong OBFVAL_sEUUd = ObfValue.create(1000000L);
    private static final ObfValue.ODouble OBFVAL_NGBi1 = ObfValue.create(20.0D);
    private static final ObfValue.ODouble OBFVAL_bd39W = ObfValue.create(1000.0D);
    private static final ObfValue.OInteger OBFVAL_wEZDQ;

    /**
     * The time reported by the high-resolution clock at the last call of updateTimer(), in seconds
     */
    public final ObfValue.WalkingDouble lastHRTime;

    /**
     * How many full ticks have turned over since the last call to updateTimer(), capped at 10.
     */
    public final ObfValue.WalkingInteger elapsedTicks;

    /**
     * How much time has elapsed since the last tick, in ticks, for use by display rendering routines (range: 0.0 -
     * 1.0).  This field is frozen if the display is paused to eliminate jitter.
     */
    public final ObfValue.WalkingFloat renderPartialTicks;

    /**
     * How much time has elapsed since the last tick, in ticks (range: 0.0 - 1.0).
     */
    public final ObfValue.WalkingFloat elapsedPartialTicks;

    /**
     * The time reported by the system clock at the last sync, in milliseconds
     */
    public final ObfValue.WalkingLong lastSyncSysClock;

    /**
     * The time reported by the high-resolution clock at the last sync, in milliseconds
     */
    public final ObfValue.WalkingLong lastSyncHRClock;
    public final ObfValue.WalkingLong field_74285_i;

    /**
     * A ratio used to sync the high-resolution clock to the system clock, updated once per second
     */
    public final ObfValue.WalkingDouble timeSyncAdjustment;
    private static final int 9Ab3J = 1489479301;

    public Timer(float p_i1018_1_)
    {
        9Ab3J = -9Ab3J;
        this.lastHRTime = new ObfValue.WalkingDouble(0.0D, OBFVAL_wEZDQ.get());
        this.elapsedTicks = new ObfValue.WalkingInteger(0, OBFVAL_wEZDQ.get());
        this.renderPartialTicks = new ObfValue.WalkingFloat(0.0F, OBFVAL_wEZDQ.get());
        9Ab3J ^= -1960075657;
        this.elapsedPartialTicks = new ObfValue.WalkingFloat(0.0F, OBFVAL_wEZDQ.get());
        9Ab3J |= -589894682;
        9Ab3J += 9Ab3J;
        9Ab3J = -9Ab3J;
        this.lastSyncSysClock = new ObfValue.WalkingLong(0L, OBFVAL_wEZDQ.get());
        9Ab3J |= -1397911110;
        ObfValue.WalkingLong obfvalue$walkinglong1 = new ObfValue.WalkingLong(0L, OBFVAL_wEZDQ.get());
        9Ab3J -= 1017327222;
        this.lastSyncHRClock = obfvalue$walkinglong1;
        this.field_74285_i = new ObfValue.WalkingLong(0L, OBFVAL_wEZDQ.get());
        9Ab3J |= -968336228;
        this.timeSyncAdjustment = new ObfValue.WalkingDouble(1.0D, OBFVAL_wEZDQ.get());
        this.lastSyncSysClock.set(Minecraft.getSystemTime());
        ObfValue.WalkingLong obfvalue$walkinglong = this.lastSyncHRClock;
        long i = System.nanoTime() / OBFVAL_sEUUd.get();
        9Ab3J += 9Ab3J;
        obfvalue$walkinglong.set(i);
    }

    /**
     * Updates all fields of the Timer using the current time
     */
    public void updateTimer()
    {
        long i = Minecraft.getSystemTime();
        9Ab3J &= -1208337393;
        long i2 = i - this.lastSyncSysClock.get();
        9Ab3J &= -565481919;
        long j = i2;
        i2 = System.nanoTime();
        ObfValue.OLong obfvalue$olong1 = OBFVAL_sEUUd;
        9Ab3J += -403975513;
        long l1 = obfvalue$olong1.get();
        9Ab3J = -1510532143;
        long k = i2 / l1;
        double d4 = (double)k;
        double d5 = OBFVAL_bd39W.get();
        9Ab3J *= 9Ab3J;
        double d0 = d4 / d5;
        9Ab3J += 9Ab3J;
        ObfValue.OLong obfvalue$olong = OBFVAL_e2Xoz;
        9Ab3J &= -381637866;

        if (j <= obfvalue$olong.get() && j >= 0L)
        {
            long l = this.field_74285_i.get();
            long k1 = l + j;
            9Ab3J *= 9Ab3J;
            l = k1;
            obfvalue$olong = OBFVAL_e2Xoz;
            9Ab3J += 216250746;

            if (l > obfvalue$olong.get())
            {
                ObfValue.WalkingLong obfvalue$walkinglong1 = this.lastSyncHRClock;
                9Ab3J += 817349715;
                long i1 = k - obfvalue$walkinglong1.get();
                9Ab3J *= 9Ab3J;
                double d1 = (double)l / (double)i1;
                double d2 = this.timeSyncAdjustment.get();
                9Ab3J ^= -1561624451;
                d2 = d2 + (d1 - d2) * OBFVAL_8jNf9.get();
                this.timeSyncAdjustment.set(d2);
                9Ab3J *= 9Ab3J;
                this.lastSyncHRClock.set(k);
                l = 0L;
            }

            if (l < 0L)
            {
                this.lastSyncHRClock.set(k);
            }

            this.field_74285_i.set(l);
        }
        else
        {
            9Ab3J *= 9Ab3J;
            this.lastHRTime.set(d0);
        }

        ObfValue.WalkingLong obfvalue$walkinglong = this.lastSyncSysClock;
        9Ab3J = 576516457;
        obfvalue$walkinglong.set(i);
        9Ab3J = -88176992;
        9Ab3J *= 9Ab3J;
        double d3 = (d0 - this.lastHRTime.get()) * this.timeSyncAdjustment.get();
        this.lastHRTime.set(d0);
        d3 = MathHelper.clamp_double(d3, 0.0D, 1.0D);
        ObfValue.WalkingFloat obfvalue$walkingfloat = this.elapsedPartialTicks;
        9Ab3J += 9Ab3J;
        float f = obfvalue$walkingfloat.get();
        f = (float)((double)f + d3 * OBFVAL_NGBi1.get());
        int j1 = (int)f;
        f = f - (float)j1;

        if (j1 > OBFVAL_gLbOj.get())
        {
            j1 = OBFVAL_gLbOj.get();
        }

        ObfValue.WalkingInteger obfvalue$walkinginteger = this.elapsedTicks;
        9Ab3J *= -1200249087;
        9Ab3J ^= -1422425916;
        obfvalue$walkinginteger.set(j1);
        9Ab3J += 9Ab3J;
        this.renderPartialTicks.set(f);
        this.elapsedPartialTicks.set(f);
    }

    static
    {
        ObfValue.beginGeneration();
        ObfValue.OInteger obfvalue$ointeger = ObfValue.create(100);
        OBFVAL_wEZDQ = obfvalue$ointeger;
        9Ab3J = -9Ab3J;
        byte[] abyte = new byte[] {(byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
        9Ab3J ^= -932263926;
        9Ab3J += 9Ab3J;
        abyte[1] = 113;
        9Ab3J |= 1019467936;
        abyte[2] = -77;
        abyte[3] = 114;
        9Ab3J = 1940460685;
        abyte[4] = 54;
        abyte[5] = -108;
        9Ab3J *= 9Ab3J;
        abyte[6] = -77;
        abyte[7] = 95;
        ObfValue.endGeneration(abyte);
    }
}
