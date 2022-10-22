package net.xtrafrancyz.mods.pvp.gui.hud;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.xtrafrancyz.mods.texteria.elements.Element2D;
import net.xtrafrancyz.util.ByteMap;

public abstract class THudElement extends Element2D
{
    public THudElement(String id)
    {
        super(id);
    }

    public void edit(ByteMap data)
    {
    }

    protected static void drawChromaRect(long time, float x, float y, float width, float height)
    {
        GlStateManager.disableTexture2D();
        GlStateManager.shadeModel(7425);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        float f = 5.0F;

        for (float f1 = x; f1 < x + width; f1 += f)
        {
            for (float f2 = y; f2 < y + height; f2 += f)
            {
                float f3 = Math.min(x + width, f1 + f) - f1;
                float f4 = Math.min(y + height, f2 + f) - f2;
                int i = getChromaColor(time, f1, f2);
                int j = getChromaColor(time, f1 + f3, f2);
                int k = getChromaColor(time, f1, f2 + f4);
                int l = getChromaColor(time, f1 + f3, f2 + f4);
                worldrenderer.pos((double)f1, (double)(f2 + f4), 0.0D).color(k >> 16 & 255, k >> 8 & 255, k & 255, k >> 24 & 255).endVertex();
                worldrenderer.pos((double)(f1 + f3), (double)(f2 + f4), 0.0D).color(l >> 16 & 255, l >> 8 & 255, l & 255, l >> 24 & 255).endVertex();
                worldrenderer.pos((double)(f1 + f3), (double)f2, 0.0D).color(j >> 16 & 255, j >> 8 & 255, j & 255, j >> 24 & 255).endVertex();
                worldrenderer.pos((double)f1, (double)f2, 0.0D).color(i >> 16 & 255, i >> 8 & 255, i & 255, i >> 24 & 255).endVertex();
            }
        }

        tessellator.draw();
        GlStateManager.enableTexture2D();
    }

    protected void drawText(long time, String text, float x, float y, float scale, boolean centered, int textAnimation, int color, boolean shadow)
    {
        FontRenderer fontrenderer = Minecraft.getMinecraft().fontRendererObj;

        if (centered)
        {
            x -= (float)fontrenderer.getStringWidth(text) * scale / 2.0F;
            y -= (float)fontrenderer.FONT_HEIGHT * scale / 2.0F;
        }

        int i = this.getAlpha(color);
        boolean flag = scale != 1.0F;

        if (flag)
        {
            GlStateManager.pushMatrix();
            GlStateManager.scale(scale, scale, 0.0F);
        }

        if (textAnimation == 2)
        {
            char[] achar = text.toCharArray();
            int j = 0;

            while (j < achar.length)
            {
                char c0 = achar[j];

                if (c0 == 167)
                {
                    j += 2;
                }
                else
                {
                    String s = getLastColors(text, j) + c0;
                    float f = (float)fontrenderer.getStringWidth(s);
                    int k = this.setAlpha(getChromaColor(time, x, y), i);
                    fontrenderer.drawString0(s, x / scale, y / scale, k, shadow);
                    x += f * scale;
                    ++j;
                }
            }
        }
        else
        {
            int l = textAnimation == 1 ? getRainbowColor(time) : color;
            l = this.setAlpha(l, i);

            if (textAnimation == 1)
            {
                fontrenderer.drawString0(text, x / scale, y / scale, l, shadow);
            }
            else
            {
                fontrenderer.drawString(text, x / scale, y / scale, l, shadow);
            }
        }

        if (flag)
        {
            GlStateManager.popMatrix();
        }
    }

    protected static int getTextColor(long time, float x, float y, int color, int textAnimation)
    {
        return textAnimation == 2 ? getChromaColor(time, x, y) : (textAnimation == 1 ? getRainbowColor(time) : color);
    }

    protected static int getRainbowColor(long time)
    {
        return Color.HSBtoRGB((float)((double)time % 4000.0D / 4000.0D), 0.8F, 0.8F);
    }

    protected static int getChromaColor(long time, float x, float y)
    {
        return Color.HSBtoRGB((float)(((double)time - (double)x * 10.0D - (double)y * 10.0D) % 2000.0D / 2000.0D), 0.8F, 0.8F);
    }

    public static String getLastColors(String input, int lastIndex)
    {
        String s = "";
        int i = input.length();

        for (int j = lastIndex; j >= 0; --j)
        {
            char c0 = input.charAt(j);

            if (c0 == 167 && j < i - 1)
            {
                char c1 = input.charAt(j + 1);
                s = "\u00a7" + c1 + s;

                if (!isFormat(c1))
                {
                    break;
                }
            }
        }

        return s;
    }

    public static boolean isFormat(char sym)
    {
        return sym == 107 || sym == 108 || sym == 109 || sym == 110 || sym == 111;
    }
}
