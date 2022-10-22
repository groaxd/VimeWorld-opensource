package net.xtrafrancyz.covered;

import com.google.common.hash.Hashing;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.util.Timer;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;

public class HashGovna
{
    private static final ObfValue.WalkingLong lastTickHash = new ObfValue.WalkingLong(0L, 10);
    private static List<Object> lastTickElements = null;
    public static ObfValue.WalkingBoolean isTick = new ObfValue.WalkingBoolean(true, 20);
    private static final ObfValue.WalkingLong lastTimerHash;
    private static final int pdZWY = -858480344;

    public static void beforeTimer()
    {
        pdZWY = -pdZWY;
        ObfValue.WalkingLong obfvalue$walkinglong = lastTimerHash;
        pdZWY += -951699704;
        long i = obfvalue$walkinglong.get();
        pdZWY *= 1795728505;

        if (i != getTimerHash())
        {
            pdZWY = -pdZWY;
            pdZWY = -pdZWY;
            pdZWY &= 898109039;
            throw new RuntimeException("Something changed");
        }
        else
        {
            pdZWY += -1240297171;
        }
    }

    public static void afterTimer()
    {
        pdZWY = -pdZWY;
        ObfValue.WalkingLong obfvalue$walkinglong = lastTimerHash;
        pdZWY = -pdZWY;
        obfvalue$walkinglong.set(getTimerHash());
    }

    private static long getTimerHash()
    {
        Timer timer = Minecraft.getMinecraft().timer;
        pdZWY += pdZWY;
        HashGovna.Hasher hashgovna$hasher = new HashGovna.Hasher();
        pdZWY |= -808217718;
        pdZWY -= -582820346;
        hashgovna$hasher.append(timer.elapsedPartialTicks.get());
        pdZWY += pdZWY;
        pdZWY *= -2010969262;
        int j = timer.elapsedTicks.get();
        pdZWY += 1211684726;
        hashgovna$hasher.append(j);
        pdZWY &= 926846971;
        pdZWY *= pdZWY;
        hashgovna$hasher.append(timer.field_74285_i.get());
        pdZWY = -1104981735;
        pdZWY = -pdZWY;
        ObfValue.WalkingLong obfvalue$walkinglong = timer.lastSyncHRClock;
        pdZWY += pdZWY;
        hashgovna$hasher.append(obfvalue$walkinglong.get());
        pdZWY = -pdZWY;
        pdZWY -= -340740233;
        obfvalue$walkinglong = timer.lastSyncSysClock;
        pdZWY ^= -1071932637;
        hashgovna$hasher.append(obfvalue$walkinglong.get());
        pdZWY = -pdZWY;
        pdZWY = 472032896;
        float f = timer.renderPartialTicks.get();
        pdZWY &= -1996088417;
        hashgovna$hasher.append(f);
        pdZWY |= 350697927;
        pdZWY += -1159506022;
        pdZWY = 155439847;
        pdZWY = -874817188 - pdZWY;
        double d0 = timer.timeSyncAdjustment.get();
        pdZWY ^= -1903507575;
        hashgovna$hasher.append(d0);
        pdZWY -= -1093258976;
        pdZWY ^= -8428211;
        ObfValue.WalkingDouble obfvalue$walkingdouble = timer.lastHRTime;
        pdZWY += pdZWY;
        hashgovna$hasher.append(obfvalue$walkingdouble.get());
        pdZWY = 630153392 - pdZWY;
        pdZWY += -2095069191;
        long i = hashgovna$hasher.asLong();
        pdZWY += 1493394418;
        return i;
    }

    public static void beforeTick()
    {
        ObfValue.WalkingBoolean obfvalue$walkingboolean = isTick;
        pdZWY &= 959931275;
        pdZWY &= 812594575;
        obfvalue$walkingboolean.set(true);
        pdZWY ^= -1764815091;
        pdZWY = 1179364066 * pdZWY;
        HashGovna.Hasher current = genTickHash();
        pdZWY = -pdZWY;
        ObfValue.WalkingLong obfvalue$walkinglong = lastTickHash;
        pdZWY += pdZWY;
        long i = obfvalue$walkinglong.get();
        pdZWY *= pdZWY;
        pdZWY += -1036587903;
        long j = current.asLong();
        pdZWY *= pdZWY;

        if (i != j)
        {
            pdZWY *= pdZWY;
            pdZWY = -pdZWY;
            pdZWY |= -1246463247;
            pdZWY += -1049478699;
            pdZWY = -pdZWY;
            StringBuilder stringbuilder = new StringBuilder();
            pdZWY = 232801389;
            pdZWY |= 904587031;
            stringbuilder = stringbuilder.append("Something changed (");
            List list = lastTickElements;
            pdZWY += pdZWY;
            stringbuilder = stringbuilder.append((Object)list).append(", ");
            pdZWY = 1072395118;
            stringbuilder = stringbuilder.append((Object)current.elements);
            pdZWY |= -1599165865;
            String s = stringbuilder.append(")").toString();
            pdZWY = 1325660384 - pdZWY;
            throw new RuntimeException(s);
        }
        else
        {
            pdZWY = -1336762455 - pdZWY;
        }
    }

    public static void afterTick()
    {
        pdZWY *= pdZWY;
        isTick.set(false);
        pdZWY |= 364669080;
        HashGovna.Hasher hashgovna$hasher1 = genTickHash();
        pdZWY |= -1555805156;
        HashGovna.Hasher hash = hashgovna$hasher1;
        pdZWY += -807230728;
        ObfValue.WalkingLong obfvalue$walkinglong = lastTickHash;
        pdZWY += pdZWY;
        obfvalue$walkinglong.set(hash.asLong());
        pdZWY += pdZWY;
        lastTickElements = hash.elements;
        pdZWY += pdZWY;
        pdZWY &= 309308090;
    }

    private static HashGovna.Hasher genTickHash()
    {
        Minecraft minecraft1 = Minecraft.getMinecraft();
        pdZWY = -pdZWY;
        Minecraft mc = minecraft1;
        pdZWY += 8110338;
        pdZWY = -654720835 - pdZWY;
        World world = mc.theWorld;
        pdZWY += pdZWY;
        pdZWY = -pdZWY;
        HashGovna.Hasher hashgovna$hasher1 = new HashGovna.Hasher();
        pdZWY = -pdZWY;
        HashGovna.Hasher hashgovna$hasher = hashgovna$hasher1;
        pdZWY = 1173485325;

        if (world == null)
        {
            pdZWY |= -1287356883;
            return hashgovna$hasher;
        }
        else
        {
            pdZWY &= -336442787;
            pdZWY += 1703326496;
            List list = world.loadedEntityList;
            pdZWY &= 711756309;
            Iterator iterator = list.iterator();

            while (true)
            {
                pdZWY += pdZWY;

                if (!iterator.hasNext())
                {
                    list = world.playerEntities;
                    pdZWY = -pdZWY;
                    iterator = list.iterator();

                    while (iterator.hasNext())
                    {
                        pdZWY *= pdZWY;
                        Entity entity = (Entity)iterator.next();
                        pdZWY -= -681766073;
                        pdZWY = 778537534 * pdZWY;
                        pdZWY ^= -982741084;
                        float f = entity.height;
                        pdZWY += pdZWY;
                        hashgovna$hasher.append(f);
                    }

                    pdZWY = 209434152 - pdZWY;
                    pdZWY |= 1786948656;
                    EntityPlayerSP entityplayersp = mc.thePlayer;
                    pdZWY = -pdZWY;
                    PlayerCapabilities playercapabilities = entityplayersp.capabilities;
                    pdZWY *= pdZWY;
                    boolean flag = playercapabilities.allowFlying;
                    pdZWY |= 1045122836;
                    hashgovna$hasher.append(flag);
                    pdZWY |= -610850205;
                    pdZWY = -2106142355;
                    pdZWY &= 1459985177;
                    flag = mc.thePlayer.capabilities.isFlying;
                    pdZWY = -468871769 * pdZWY;
                    hashgovna$hasher.append(flag);
                    pdZWY = -3286588 - pdZWY;
                    EntityPlayerSP entityplayersp1 = mc.thePlayer;
                    pdZWY += -990997323;
                    PlayerCapabilities playercapabilities1 = entityplayersp1.capabilities;
                    pdZWY ^= 1954841023;
                    hashgovna$hasher.append(playercapabilities1.getWalkSpeed());
                    pdZWY *= -1403061780;
                    pdZWY |= -1548973252;
                    EntityPlayerSP entityplayersp2 = mc.thePlayer;
                    pdZWY |= 1705961767;
                    PlayerCapabilities playercapabilities2 = entityplayersp2.capabilities;
                    pdZWY ^= -714486121;
                    hashgovna$hasher.append(playercapabilities2.isCreativeMode);
                    pdZWY ^= -534866158;
                    pdZWY = 1484680621;
                    pdZWY += pdZWY;
                    EntityPlayerSP entityplayersp3 = mc.thePlayer;
                    pdZWY = -pdZWY;
                    boolean flag1 = entityplayersp3.onGround;
                    pdZWY *= pdZWY;
                    hashgovna$hasher.append(flag1);
                    EntityPlayerSP entityplayersp4 = mc.thePlayer;
                    pdZWY = -pdZWY;
                    boolean flag2 = entityplayersp4.isCollidedVertically;
                    pdZWY = 1846155553;
                    hashgovna$hasher.append(flag2);
                    pdZWY += 157162279;
                    pdZWY += pdZWY;
                    hashgovna$hasher.append(mc.thePlayer.isCollided);
                    pdZWY = -pdZWY;
                    pdZWY += -1115238519;
                    EntityPlayerSP entityplayersp5 = mc.thePlayer;
                    pdZWY *= 235434829;
                    hashgovna$hasher.append(entityplayersp5.isInWeb);
                    pdZWY ^= -298048446;
                    pdZWY &= -1541658046;
                    pdZWY = -pdZWY;
                    double d0 = mc.thePlayer.posX;
                    pdZWY *= pdZWY;
                    hashgovna$hasher.append(d0);
                    pdZWY += pdZWY;
                    pdZWY += -979983435;
                    hashgovna$hasher.append(mc.thePlayer.posY);
                    pdZWY = 531325004;
                    pdZWY = -1823109313;
                    EntityPlayerSP entityplayersp6 = mc.thePlayer;
                    pdZWY += pdZWY;
                    hashgovna$hasher.append(entityplayersp6.posZ);
                    entityplayersp6 = mc.thePlayer;
                    pdZWY += 737535879;
                    double d1 = entityplayersp6.motionX;
                    pdZWY *= pdZWY;
                    hashgovna$hasher.append(d1);
                    pdZWY = -831144383;
                    pdZWY -= 1828989056;
                    pdZWY += pdZWY;
                    pdZWY = -pdZWY;
                    EntityPlayerSP entityplayersp7 = mc.thePlayer;
                    pdZWY &= 745662121;
                    hashgovna$hasher.append(entityplayersp7.motionY);
                    pdZWY &= 1010865068;
                    double d2 = mc.thePlayer.motionZ;
                    pdZWY = -pdZWY;
                    hashgovna$hasher.append(d2);
                    pdZWY = 623435623;
                    pdZWY *= 931032914;
                    pdZWY += pdZWY;
                    EntityPlayerSP entityplayersp8 = mc.thePlayer;
                    pdZWY = -1449234989 * pdZWY;
                    hashgovna$hasher.append(entityplayersp8.stepHeight);
                    entityplayersp8 = mc.thePlayer;
                    pdZWY = -23209644 * pdZWY;
                    hashgovna$hasher.append(entityplayersp8.jumpMovementFactor);
                    entityplayersp8 = mc.thePlayer;
                    pdZWY *= pdZWY;
                    hashgovna$hasher.append(entityplayersp8.isSprinting());
                    entityplayersp8 = mc.thePlayer;
                    pdZWY *= pdZWY;
                    hashgovna$hasher.append(entityplayersp8.sprintingTicksLeft);
                    pdZWY = -pdZWY;
                    pdZWY ^= -2013265141;
                    pdZWY *= 1379487014;
                    int i = mc.leftClickCounter;
                    pdZWY *= -1430896941;
                    hashgovna$hasher.append(i);
                    pdZWY *= pdZWY;
                    pdZWY *= -729276735;
                    pdZWY ^= 1490490846;
                    i = mc.rightClickDelayTimer;
                    pdZWY *= -561009438;
                    hashgovna$hasher.append(i);
                    pdZWY = -pdZWY;
                    long j = mc.lastLeftClick;
                    pdZWY ^= 1289727960;
                    hashgovna$hasher.append(j);
                    pdZWY *= pdZWY;
                    pdZWY ^= 423112529;
                    pdZWY |= 156194197;
                    pdZWY ^= 873507989;
                    hashgovna$hasher.append(mc.lastRightClick);
                    pdZWY &= 1394526785;
                    pdZWY -= 1063168268;
                    hashgovna$hasher.append(mc.playerController.blockHitDelay);
                    pdZWY += -1149290565;
                    float f1 = mc.playerController.curBlockDamageMP;
                    pdZWY *= pdZWY;
                    hashgovna$hasher.append(f1);
                    pdZWY += pdZWY;
                    WorldSettings.GameType worldsettings$gametype = mc.playerController.getCurrentGameType();
                    pdZWY *= pdZWY;
                    int k = worldsettings$gametype.getID();
                    pdZWY = -732080360 * pdZWY;
                    hashgovna$hasher.append(k);
                    pdZWY = 1684459653;
                    return hashgovna$hasher;
                }

                Entity entity = (Entity)iterator.next();
                pdZWY -= 2049182178;
                pdZWY |= 198285010;
                pdZWY = -pdZWY;
                float f2 = entity.width;
                pdZWY ^= -2074783022;
                hashgovna$hasher.append(f2);
            }
        }
    }

    static
    {
        pdZWY += pdZWY;
        pdZWY += pdZWY;
        pdZWY += -1230315930;
        pdZWY += -1199330645;
        pdZWY |= -587936774;
        pdZWY += pdZWY;
        pdZWY *= pdZWY;
        pdZWY ^= 1586020455;
        pdZWY = -pdZWY;
        pdZWY = 1473434956 * pdZWY;
        ObfValue.WalkingLong obfvalue$walkinglong = new ObfValue.WalkingLong(0L, 10);
        pdZWY = -1983409381;
        lastTimerHash = obfvalue$walkinglong;
        pdZWY |= 919528193;
    }

    private static class Hasher
    {
        private final com.google.common.hash.Hasher hasher;
        private final List<Object> elements;

        private Hasher()
        {
            this.hasher = Hashing.murmur3_128().newHasher();
            this.elements = new ArrayList(64);
        }

        void append(int value)
        {
            this.log(Integer.valueOf(value));
            this.hasher.putInt(value);
        }

        void append(long value)
        {
            this.log(Long.valueOf(value));
            this.hasher.putLong(value);
        }

        void append(boolean value)
        {
            this.log(Boolean.valueOf(value));
            this.hasher.putBoolean(value);
        }

        void append(double value)
        {
            this.log(Double.valueOf(value));
            this.hasher.putDouble(value);
        }

        void append(float value)
        {
            this.log(Float.valueOf(value));
            this.hasher.putFloat(value);
        }

        private void log(Object value)
        {
            this.elements.add(value);
        }

        long asLong()
        {
            return this.hasher.hash().asLong();
        }
    }
}
