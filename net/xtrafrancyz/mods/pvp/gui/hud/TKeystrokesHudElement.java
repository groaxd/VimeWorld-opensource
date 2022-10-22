package net.xtrafrancyz.mods.pvp.gui.hud;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.xtrafrancyz.mods.pvp.PvPMod;
import net.xtrafrancyz.mods.pvp.PvpOptions;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.gui.GuiElementWrapper;
import net.xtrafrancyz.mods.texteria.util.ColorValue;
import net.xtrafrancyz.mods.texteria.util.TRenderUtil;
import org.lwjgl.input.Keyboard;

public class TKeystrokesHudElement extends THudElement
{
    public static final String TID = "##TKeystrokesHud";
    public static final GuiElementWrapper WRAPPER;
    private static final int PAD = 2;
    private static int SIZE = 28;
    private static int WIDTH = SIZE * 3 + 4;
    private final Minecraft mc = Minecraft.getMinecraft();
    private final Map<KeyBinding, TKeystrokesHudElement.KeyState> states = new HashMap();

    public TKeystrokesHudElement()
    {
        super("##TKeystrokesHud");
        this.x.set(2.0F);
        this.y.set(2.0F);
    }

    public float getWidth()
    {
        return (float)WIDTH;
    }

    public float getHeight()
    {
        int i = 0;
        i = i + (PvpOptions.keyMovementButtons ? 2 : 0);
        i = i + (PvpOptions.keyMouseButtons ? 1 : 0);
        i = i + (PvpOptions.keySneakButton ? 1 : 0);
        i = i + (PvpOptions.keyJumpButton ? 1 : 0);
        return i > 0 ? (float)(i * SIZE + (i - 1) * 2) : 0.0F;
    }

    public void render(long time)
    {
        GameSettings gamesettings = this.mc.gameSettings;
        int i = 0;

        if (PvpOptions.keyMovementButtons)
        {
            this.renderKey(time, gamesettings.keyBindForward, (float)(SIZE + 2), (float)i, (float)SIZE, (float)SIZE);
            i = i + SIZE + 2;
            this.renderKey(time, gamesettings.keyBindLeft, 0.0F, (float)i, (float)SIZE, (float)SIZE);
            this.renderKey(time, gamesettings.keyBindBack, (float)(SIZE + 2), (float)i, (float)SIZE, (float)SIZE);
            this.renderKey(time, gamesettings.keyBindRight, (float)(WIDTH - SIZE), (float)i, (float)SIZE, (float)SIZE);
            i = i + SIZE + 2;
        }

        if (PvpOptions.keyMouseButtons)
        {
            float f = (float)(WIDTH - 2) / 2.0F;
            this.renderMouse(time, gamesettings.keyBindAttack, PvPMod.leftMouseCounter, 0.0F, (float)i, f, (float)SIZE);
            this.renderMouse(time, gamesettings.keyBindUseItem, PvPMod.rightMouseCounter, (float)WIDTH - f, (float)i, f, (float)SIZE);
            i += SIZE + 2;
        }

        if (PvpOptions.keySneakButton)
        {
            this.renderKey(time, gamesettings.keyBindSneak, 0.0F, (float)i, (float)WIDTH, (float)SIZE);
            i += SIZE + 2;
        }

        if (PvpOptions.keyJumpButton)
        {
            this.renderSpaceKey(time, gamesettings.keyBindJump, 0.0F, (float)i, (float)WIDTH, (float)SIZE);
        }
    }

    private void renderKey(long time, KeyBinding keyBinding, float x, float y, float width, float height)
    {
        TRenderUtil.drawRect((double)x, (double)y, (double)width, (double)height, this.getBackgroundColor(time, keyBinding));
        String s = (PvpOptions.keyTextBold ? "\u00a7l" : "") + getKeyName(keyBinding.getKeyCode());

        if (PvpOptions.keyStatus == 1)
        {
            this.drawText(time, s, x + width / 2.0F, y + height / 2.0F, 1.0F, true, PvpOptions.keyTextAnimation, PvpOptions.keyTextColor, PvpOptions.keyTextShadow);
        }
        else if (PvpOptions.keyStatus == 2)
        {
            this.drawText(time, s, x + width / 2.0F, y + height / 2.0F, 2.0F, true, PvpOptions.keyTextAnimation, PvpOptions.keyTextColor, PvpOptions.keyTextShadow);
        }
    }

    private void renderMouse(long time, KeyBinding keyBinding, PvPMod.ClickCounter clickCounter, float x, float y, float width, float height)
    {
        TRenderUtil.drawRect((double)x, (double)y, (double)width, (double)height, this.getBackgroundColor(time, keyBinding));
        int i = clickCounter.getCPS();
        String s = PvpOptions.keyTextBold ? "\u00a7l" : "";
        String s1 = s + getKeyName(keyBinding.getKeyCode());
        String s2 = s + i + " CPS";

        if (PvpOptions.keyStatus == 1)
        {
            String s3 = i > 0 ? s2 : s1;
            this.drawText(time, s3, x + width / 2.0F, y + height / 2.0F, 1.0F, true, PvpOptions.keyTextAnimation, PvpOptions.keyTextColor, PvpOptions.keyTextShadow);
        }
        else if (PvpOptions.keyStatus == 2)
        {
            this.drawText(time, s1, x + width / 2.0F, y + height / 3.0F, 2.0F, true, PvpOptions.keyTextAnimation, PvpOptions.keyTextColor, PvpOptions.keyTextShadow);
            this.drawText(time, s2, x + width / 2.0F, y + height - height / 4.0F, 1.0F, true, PvpOptions.keyTextAnimation, PvpOptions.keyTextColor, PvpOptions.keyTextShadow);
        }
    }

    private void renderSpaceKey(long time, KeyBinding keyBinding, float x, float y, float width, float height)
    {
        TRenderUtil.drawRect((double)x, (double)y, (double)width, (double)height, this.getBackgroundColor(time, keyBinding));
        float f;
        float f1;
        float f2;

        if (PvpOptions.keyStatus == 1)
        {
            f = 30.0F;
            f1 = 2.0F;
            f2 = 0.5F;
        }
        else
        {
            f = 60.0F;
            f1 = 3.0F;
            f2 = 1.0F;
        }

        float f3 = x + width * 0.5F - f * 0.5F;
        float f4 = y + height * 0.5F - f1 * 0.5F;

        if (PvpOptions.keyTextShadow)
        {
            TRenderUtil.drawRect((double)(f3 + f2), (double)(f4 + f2), (double)f, (double)f1, -14013910);
        }

        if (PvpOptions.keyTextAnimation == 2)
        {
            drawChromaRect(time, f3, f4, f, f1);
        }
        else
        {
            TRenderUtil.drawRect((double)f3, (double)f4, (double)f, (double)f1, PvpOptions.keyTextAnimation == 1 ? getRainbowColor(time) : PvpOptions.keyTextColor);
        }
    }

    private static String getKeyName(int keyCode)
    {
        if (keyCode >= 0 && keyCode < 256)
        {
            switch (keyCode)
            {
                case 12:
                case 74:
                    return "-";

                case 13:
                    return "=";

                case 26:
                    return "[";

                case 27:
                    return "]";

                case 39:
                    return ";";

                case 40:
                    return "\'";

                case 41:
                    return "~";

                case 43:
                    return "\\";

                case 51:
                    return ",";

                case 52:
                    return ".";

                case 53:
                case 181:
                    return "/";

                case 55:
                    return "*";

                case 78:
                    return "+";

                case 200:
                    return "\u25b2";

                case 203:
                    return "\u25c0";

                case 205:
                    return "\u25b6";

                case 208:
                    return "\u25bc";

                default:
                    return Keyboard.getKeyName(keyCode);
            }
        }
        else
        {
            switch (keyCode)
            {
                case -100:
                    return "\u041b\u041a\u041c";

                case -99:
                    return "\u041f\u041a\u041c";

                default:
                    return "?";
            }
        }
    }

    private int getBackgroundColor(long time, KeyBinding key)
    {
        TKeystrokesHudElement.KeyState tkeystrokeshudelement$keystate = (TKeystrokesHudElement.KeyState)this.states.get(key);

        if (tkeystrokeshudelement$keystate == null)
        {
            this.states.put(key, tkeystrokeshudelement$keystate = new TKeystrokesHudElement.KeyState());
        }

        if (key.isKeyDown())
        {
            tkeystrokeshudelement$keystate.lastPressed = time;
        }

        return ColorValue.lerp(1.0F - (float)Math.min(time - tkeystrokeshudelement$keystate.lastPressed, 200L) / 200.0F, 1694498815, 1677721600);
    }

    public static void applyOptions()
    {
        PvPMod.addOrRemove(WRAPPER, PvpOptions.keyStatus != 0);
        SIZE = 12 + PvpOptions.keyStatus * 8;
        WIDTH = SIZE * 3 + 4;
    }

    static
    {
        WRAPPER = new GuiElementWrapper(new TKeystrokesHudElement(), Texteria.instance.gui);
    }

    private static class KeyState
    {
        private long lastPressed;

        private KeyState()
        {
        }
    }
}
