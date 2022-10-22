package net.xtrafrancyz.mods.texteria;

import com.creativemd.cmdcam.CMDCam;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.xtrafrancyz.covered.ObfValue;
import net.xtrafrancyz.util.ByteMap;

public class TexteriaOptions
{
    public static boolean worldLightUpdates;
    public static int worldLightForced = -1;
    public static boolean autumnColors;
    public static boolean disableClouds;
    public static ObfValue.WalkingBoolean disableCpsLimit = new ObfValue.WalkingBoolean(false, 1);
    public static boolean disableTab;
    public static int playerCollisionVelocity;
    public static int playerCollisionBoxes;

    public static void reset()
    {
        worldLightUpdates = true;
        autumnColors = ((Boolean)setWithRenderReload(Boolean.valueOf(autumnColors), Boolean.valueOf(false))).booleanValue();
        worldLightForced = ((Integer)setWithRenderReload(Integer.valueOf(worldLightForced), Integer.valueOf(-1))).intValue();
        disableClouds = false;
        disableCpsLimit.set(false);
        disableTab = false;
        playerCollisionBoxes = 0;
        playerCollisionVelocity = 0;
        CMDCam.disable();
    }

    public static void set(ByteMap map)
    {
        String s = map.getString("field", "");
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -2000180622:
                if (s.equals("player-collision-boxes"))
                {
                    b0 = 7;
                }

                break;

            case -1356940203:
                if (s.equals("cmdcam"))
                {
                    b0 = 8;
                }

                break;

            case -1063030521:
                if (s.equals("autumn-colors"))
                {
                    b0 = 2;
                }

                break;

            case -979293749:
                if (s.equals("world-light-forced"))
                {
                    b0 = 1;
                }

                break;

            case -373350668:
                if (s.equals("cmdcam-tp"))
                {
                    b0 = 9;
                }

                break;

            case -164193437:
                if (s.equals("disable-clouds"))
                {
                    b0 = 3;
                }

                break;

            case 149973016:
                if (s.equals("world-light-updates"))
                {
                    b0 = 0;
                }

                break;

            case 358289455:
                if (s.equals("disable-cps-limit"))
                {
                    b0 = 4;
                }

                break;

            case 872034180:
                if (s.equals("player-collision-velocity"))
                {
                    b0 = 6;
                }

                break;

            case 1352180528:
                if (s.equals("disable-tab"))
                {
                    b0 = 5;
                }
        }

        switch (b0)
        {
            case 0:
                worldLightUpdates = map.getBoolean("value");
                break;

            case 1:
                worldLightForced = ((Integer)setWithRenderReload(Integer.valueOf(worldLightForced), Integer.valueOf(map.getInt("value")))).intValue();
                break;

            case 2:
                autumnColors = ((Boolean)setWithRenderReload(Boolean.valueOf(autumnColors), Boolean.valueOf(map.getBoolean("value")))).booleanValue();
                break;

            case 3:
                disableClouds = map.getBoolean("value");
                break;

            case 4:
                disableCpsLimit.set(map.getBoolean("value"));
                break;

            case 5:
                disableTab = map.getBoolean("value");
                break;

            case 6:
                playerCollisionVelocity = map.getInt("value");
                break;

            case 7:
                playerCollisionBoxes = map.getInt("value");
                break;

            case 8:
                if (map.getBoolean("value"))
                {
                    CMDCam.enable();
                }
                else
                {
                    CMDCam.disable();
                }

                break;

            case 9:
                CMDCam.tpEnabled.set(map.getBoolean("value", false));
        }
    }

    private static <T> T setWithRenderReload(T old, T curr)
    {
        if (!Objects.equals(old, curr))
        {
            Minecraft.getMinecraft().renderGlobal.loadRenderers();
        }

        return (T)curr;
    }
}
