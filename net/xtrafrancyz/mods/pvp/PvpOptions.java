package net.xtrafrancyz.mods.pvp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;
import net.minecraft.client.Minecraft;
import net.xtrafrancyz.mods.pvp.gui.hud.TArmorStatusHudElement;
import net.xtrafrancyz.mods.pvp.gui.hud.TEffectHudElement;
import net.xtrafrancyz.mods.pvp.gui.hud.TKeystrokesHudElement;
import net.xtrafrancyz.mods.texteria.gui.GuiElementWrapper;
import net.xtrafrancyz.mods.texteria.util.Position;

public abstract class PvpOptions
{
    public static int keyStatus = 0;
    public static boolean keyMovementButtons = true;
    public static boolean keyMouseButtons = true;
    public static boolean keySneakButton = true;
    public static boolean keyJumpButton = true;
    public static int keyTextColor = -1;
    public static boolean keyTextBold = false;
    public static int keyTextAnimation = 0;
    public static boolean keyTextShadow = false;
    public static boolean effectEnabled = true;
    public static int effectScale = 2;
    public static int effectTextColor = -1;
    public static int effectTextSize = 2;
    public static int effectTextAnimation = 0;
    public static int armorStatus = 0;
    public static boolean armorDirection = true;
    public static boolean armorDurabilityBar = true;
    public static int armorTextColor = -1;
    public static int armorTextType = 1;
    public static boolean armorItemAmount = true;
    public static int armorTextAnimation = 0;
    public static boolean armorTextDirection = true;
    public static boolean otherNetworkInfo = false;
    public static boolean showModels = true;
    public static PvPSelector selector = new PvPSelector();
    private static File optionsFile;

    public static void load(Minecraft mc)
    {
        if (optionsFile == null)
        {
            optionsFile = new File(mc.mcDataDir, "options-pvp.txt");
        }

        if (optionsFile.exists())
        {
            try
            {
                BufferedReader bufferedreader = new BufferedReader(new FileReader(optionsFile));
                Throwable throwable = null;

                try
                {
                    String s;

                    try
                    {
                        while ((s = bufferedreader.readLine()) != null)
                        {
                            try
                            {
                                String[] astring = s.split(":");
                                String s1 = astring[0];
                                byte b0 = -1;

                                switch (s1.hashCode())
                                {
                                    case -2116357615:
                                        if (s1.equals("armorStatus"))
                                        {
                                            b0 = 14;
                                        }

                                        break;

                                    case -2074018246:
                                        if (s1.equals("##TArmorStatusHud"))
                                        {
                                            b0 = 26;
                                        }

                                        break;

                                    case -1996901517:
                                        if (s1.equals("keyMovementButtons"))
                                        {
                                            b0 = 1;
                                        }

                                        break;

                                    case -1988765903:
                                        if (s1.equals("keyStatus"))
                                        {
                                            b0 = 0;
                                        }

                                        break;

                                    case -1585457174:
                                        if (s1.equals("armorItemAmount"))
                                        {
                                            b0 = 19;
                                        }

                                        break;

                                    case -1578048585:
                                        if (s1.equals("armorTextColor"))
                                        {
                                            b0 = 17;
                                        }

                                        break;

                                    case -1539413353:
                                        if (s1.equals("keyTextColor"))
                                        {
                                            b0 = 5;
                                        }

                                        break;

                                    case -1477067520:
                                        if (s1.equals("armorDirection"))
                                        {
                                            b0 = 15;
                                        }

                                        break;

                                    case -1332807662:
                                        if (s1.equals("##TEffectHud"))
                                        {
                                            b0 = 25;
                                        }

                                        break;

                                    case -1102345524:
                                        if (s1.equals("otherNetworkInfo"))
                                        {
                                            b0 = 22;
                                        }

                                        break;

                                    case -790350969:
                                        if (s1.equals("keySneakButton"))
                                        {
                                            b0 = 3;
                                        }

                                        break;

                                    case -327483290:
                                        if (s1.equals("armorTextType"))
                                        {
                                            b0 = 18;
                                        }

                                        break;

                                    case -193141989:
                                        if (s1.equals("keyMouseButtons"))
                                        {
                                            b0 = 2;
                                        }

                                        break;

                                    case -25910164:
                                        if (s1.equals("keyTextShadow"))
                                        {
                                            b0 = 8;
                                        }

                                        break;

                                    case 629944:
                                        if (s1.equals("keyTextAnimation"))
                                        {
                                            b0 = 7;
                                        }

                                        break;

                                    case 16762789:
                                        if (s1.equals("effectTextColor"))
                                        {
                                            b0 = 11;
                                        }

                                        break;

                                    case 59732435:
                                        if (s1.equals("armorTextDirection"))
                                        {
                                            b0 = 21;
                                        }

                                        break;

                                    case 571345995:
                                        if (s1.equals("armorDurabilityBar"))
                                        {
                                            b0 = 16;
                                        }

                                        break;

                                    case 606289863:
                                        if (s1.equals("showModels"))
                                        {
                                            b0 = 23;
                                        }

                                        break;

                                    case 865714886:
                                        if (s1.equals("effectTextAnimation"))
                                        {
                                            b0 = 13;
                                        }

                                        break;

                                    case 1247392880:
                                        if (s1.equals("effectEnabled"))
                                        {
                                            b0 = 9;
                                        }

                                        break;

                                    case 1364524223:
                                        if (s1.equals("keyJumpButton"))
                                        {
                                            b0 = 4;
                                        }

                                        break;

                                    case 1623041479:
                                        if (s1.equals("##TKeystrokesHud"))
                                        {
                                            b0 = 24;
                                        }

                                        break;

                                    case 1649652281:
                                        if (s1.equals("effectScale"))
                                        {
                                            b0 = 10;
                                        }

                                        break;

                                    case 1663580031:
                                        if (s1.equals("effectTextSize"))
                                        {
                                            b0 = 12;
                                        }

                                        break;

                                    case 2028521681:
                                        if (s1.equals("keyTextBold"))
                                        {
                                            b0 = 6;
                                        }

                                        break;

                                    case 2140833240:
                                        if (s1.equals("armorTextAnimation"))
                                        {
                                            b0 = 20;
                                        }
                                }

                                switch (b0)
                                {
                                    case 0:
                                        keyStatus = Integer.parseInt(astring[1]);
                                        break;

                                    case 1:
                                        keyMovementButtons = Boolean.parseBoolean(astring[1]);
                                        break;

                                    case 2:
                                        keyMouseButtons = Boolean.parseBoolean(astring[1]);
                                        break;

                                    case 3:
                                        keySneakButton = Boolean.parseBoolean(astring[1]);
                                        break;

                                    case 4:
                                        keyJumpButton = Boolean.parseBoolean(astring[1]);
                                        break;

                                    case 5:
                                        keyTextColor = Integer.parseInt(astring[1]);
                                        break;

                                    case 6:
                                        keyTextBold = Boolean.parseBoolean(astring[1]);
                                        break;

                                    case 7:
                                        keyTextAnimation = Integer.parseInt(astring[1]);
                                        break;

                                    case 8:
                                        keyTextShadow = Boolean.parseBoolean(astring[1]);
                                        break;

                                    case 9:
                                        effectEnabled = Boolean.parseBoolean(astring[1]);
                                        break;

                                    case 10:
                                        effectScale = Integer.parseInt(astring[1]);
                                        break;

                                    case 11:
                                        effectTextColor = Integer.parseInt(astring[1]);
                                        break;

                                    case 12:
                                        effectTextSize = Integer.parseInt(astring[1]);
                                        break;

                                    case 13:
                                        effectTextAnimation = Integer.parseInt(astring[1]);
                                        break;

                                    case 14:
                                        armorStatus = Integer.parseInt(astring[1]);
                                        break;

                                    case 15:
                                        armorDirection = Boolean.parseBoolean(astring[1]);
                                        break;

                                    case 16:
                                        armorDurabilityBar = Boolean.parseBoolean(astring[1]);
                                        break;

                                    case 17:
                                        armorTextColor = Integer.parseInt(astring[1]);
                                        break;

                                    case 18:
                                        armorTextType = Integer.parseInt(astring[1]);
                                        break;

                                    case 19:
                                        armorItemAmount = Boolean.parseBoolean(astring[1]);
                                        break;

                                    case 20:
                                        armorTextAnimation = Integer.parseInt(astring[1]);
                                        break;

                                    case 21:
                                        armorTextDirection = Boolean.parseBoolean(astring[1]);
                                        break;

                                    case 22:
                                        otherNetworkInfo = Boolean.parseBoolean(astring[1]);
                                        break;

                                    case 23:
                                        showModels = Boolean.parseBoolean(astring[1]);
                                        break;

                                    case 24:
                                        selector.set(Position.valueOf(astring[1]), TKeystrokesHudElement.WRAPPER);
                                        break;

                                    case 25:
                                        selector.set(Position.valueOf(astring[1]), TEffectHudElement.WRAPPER);
                                        break;

                                    case 26:
                                        selector.set(Position.valueOf(astring[1]), TArmorStatusHudElement.WRAPPER);
                                }
                            }
                            catch (Exception exception)
                            {
                                PvPMod.log.info((String)("Failed to parse option \'" + s + "\'"), (Throwable)exception);
                            }
                        }
                    }
                    catch (Throwable throwable2)
                    {
                        throwable = throwable2;
                        throw throwable2;
                    }
                }
                finally
                {
                    if (bufferedreader != null)
                    {
                        if (throwable != null)
                        {
                            try
                            {
                                bufferedreader.close();
                            }
                            catch (Throwable throwable1)
                            {
                                throwable.addSuppressed(throwable1);
                            }
                        }
                        else
                        {
                            bufferedreader.close();
                        }
                    }
                }
            }
            catch (IOException ioexception)
            {
                PvPMod.log.error((String)"Failed to load pvp options", (Throwable)ioexception);
            }
        }
    }

    public static void save()
    {
        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(optionsFile));
            Throwable throwable = null;

            try
            {
                printwriter.println("keyStatus:" + keyStatus);
                printwriter.println("keyMovementButtons:" + keyMovementButtons);
                printwriter.println("keyMouseButtons:" + keyMouseButtons);
                printwriter.println("keySneakButton:" + keySneakButton);
                printwriter.println("keyJumpButton:" + keyJumpButton);
                printwriter.println("keyTextColor:" + keyTextColor);
                printwriter.println("keyTextBold:" + keyTextBold);
                printwriter.println("keyTextAnimation:" + keyTextAnimation);
                printwriter.println("keyTextShadow:" + keyTextShadow);
                printwriter.println("effectEnabled:" + effectEnabled);
                printwriter.println("effectScale:" + effectScale);
                printwriter.println("effectTextColor:" + effectTextColor);
                printwriter.println("effectTextSize:" + effectTextSize);
                printwriter.println("effectTextAnimation:" + effectTextAnimation);
                printwriter.println("armorStatus:" + armorStatus);
                printwriter.println("armorDirection:" + armorDirection);
                printwriter.println("armorDurabilityBar:" + armorDurabilityBar);
                printwriter.println("armorTextColor:" + armorTextColor);
                printwriter.println("armorTextType:" + armorTextType);
                printwriter.println("armorItemAmount:" + armorItemAmount);
                printwriter.println("armorTextAnimation:" + armorTextAnimation);
                printwriter.println("armorTextDirection:" + armorTextDirection);
                printwriter.println("otherNetworkInfo:" + otherNetworkInfo);
                printwriter.println("showModels:" + showModels);

                for (Entry<Position, GuiElementWrapper> entry : selector.wrappers.entrySet())
                {
                    printwriter.println(((GuiElementWrapper)entry.getValue()).id + ":" + ((Position)entry.getKey()).name());
                }
            }
            catch (Throwable throwable2)
            {
                throwable = throwable2;
                throw throwable2;
            }
            finally
            {
                if (printwriter != null)
                {
                    if (throwable != null)
                    {
                        try
                        {
                            printwriter.close();
                        }
                        catch (Throwable throwable1)
                        {
                            throwable.addSuppressed(throwable1);
                        }
                    }
                    else
                    {
                        printwriter.close();
                    }
                }
            }
        }
        catch (IOException ioexception)
        {
            PvPMod.log.error((String)"Failed to save pvp options", (Throwable)ioexception);
        }
    }
}
