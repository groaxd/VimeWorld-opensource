package net.xtrafrancyz.mods.texteria.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.xtrafrancyz.mods.texteria.util.Fluidity;
import net.xtrafrancyz.mods.texteria.util.TRenderUtil;
import net.xtrafrancyz.util.ByteMap;

public class Text extends Element2D
{
    private Fluidity widthFluidity;
    public Text.WordWrap wordWrap;
    public Text.Align align;
    public int width;
    public String[] text;
    public FontRenderer font;
    public boolean hasShadow;
    public int background;
    public int hoverBackground;

    public Text(ByteMap params)
    {
        super(params);
        this.font = Minecraft.getMinecraft().fontRendererObj;
        this.width = params.getInt("width", -1);
        this.widthFluidity = Fluidity.byValue(this.width);
        this.text = params.getStringArray("text");
        this.align = (Text.Align)params.getStringEnum("al", Text.Align.CENTER);
        this.wordWrap = (Text.WordWrap)params.getStringEnum("ww", Text.WordWrap.NO_WRAP);
        this.hasShadow = params.getBoolean("shadow", true);
        this.background = params.getInt("bg", -1);

        if (this.hoverable)
        {
            this.hoverBackground = params.getInt("hoverBg", -1);
        }
    }

    public void init()
    {
        super.init();
        this.update();
    }

    public void reload()
    {
        super.reload();
        this.update();
    }

    public void update()
    {
        if (this.widthFluidity == Fluidity.WRAP_CONTENT)
        {
            if (this.text.length == 0)
            {
                this.width = 0;
            }
            else
            {
                this.width = this.font.getStringWidth(this.text[0]);

                for (int i = 1; i < this.text.length; ++i)
                {
                    int j = this.font.getStringWidth(this.text[i]);

                    if (j > this.width)
                    {
                        this.width = j;
                    }
                }
            }
        }
        else if (this.wordWrap != Text.WordWrap.NO_WRAP && this.text.length != 0)
        {
            List<String> list = new ArrayList();
            int k = (int)this.getWidth();

            if (this.background != -1)
            {
                k -= 4;
            }

            for (String s : this.text)
            {
                list.addAll(Arrays.<String>asList(this.wrapLine(s, k)));
            }

            this.text = (String[])list.toArray(new String[0]);
        }
    }

    public Fluidity getWidthFluidity()
    {
        return this.widthFluidity == Fluidity.MATCH_PARENT ? Fluidity.MATCH_PARENT : Fluidity.FIXED;
    }

    public float getWidth()
    {
        float f = (float)this.width;

        if (this.widthFluidity == Fluidity.MATCH_PARENT)
        {
            f = this.parent.getWidth() / this.scaleX.render;
        }
        else if (this.background != -1)
        {
            f += 4.0F;
        }

        return f;
    }

    public float getHeight()
    {
        return (float)(this.font.FONT_HEIGHT * this.text.length);
    }

    public void render(long time)
    {
        GlStateManager.enableTexture2D();
        int i = this.hover && this.hoverBackground != -1 ? this.hoverBackground : this.background;
        float f = this.getWidth();

        if (i != -1)
        {
            TRenderUtil.drawRect(0.0D, 0.0D, (double)f, (double)this.getHeight(), this.setAlphaToBaseColorIfGreater(i));
            GlStateManager.translate(2.0F, 0.0F, 0.0F);
            f -= 4.0F;
        }

        int j = 0;

        switch (this.align)
        {
            case CENTER:
                for (String s2 : this.text)
                {
                    this.drawString(s2, ((int)f - this.font.getStringWidth(s2)) / 2, this.font.FONT_HEIGHT * j++, this.color.render);
                }

                return;

            case LEFT:
                for (String s1 : this.text)
                {
                    this.drawString(s1, 0, this.font.FONT_HEIGHT * j++, this.color.render);
                }

                return;

            case RIGHT:
                for (String s : this.text)
                {
                    this.drawString(s, (int)f - this.font.getStringWidth(s), this.font.FONT_HEIGHT * j++, this.color.render);
                }
        }
    }

    private void drawString(String text, int x, int y, int color)
    {
        if (this.hasShadow)
        {
            this.font.drawStringWithShadow(text, (float)x, (float)y, color);
        }
        else
        {
            this.font.drawString(text, x, y, color);
        }
    }

    public void edit(ByteMap data)
    {
        super.edit(data);

        if (data.containsKey(".width"))
        {
            this.widthFluidity = Fluidity.byValue(this.width);
        }

        this.update();
    }

    private String[] wrapLine(String message, int width)
    {
        List<IChatComponent> list = GuiUtilRenderComponents.func_178908_a(new ChatComponentText(message), width, this.font, true, true);
        String[] astring = new String[list.size()];

        for (int i = 0; i < list.size(); ++i)
        {
            String s = ((IChatComponent)list.get(i)).getUnformattedText();

            if (i > 0)
            {
                ChatStyle chatstyle = new ChatStyle();
                char[] achar = astring[i - 1].toCharArray();

                for (int j = 0; j < achar.length; ++j)
                {
                    if (achar[j] == 167 && j < achar.length - 1)
                    {
                        ++j;
                        int k = "0123456789abcdefklmnor".indexOf(achar[j]);

                        if (k < 16)
                        {
                            chatstyle = new ChatStyle();
                            chatstyle.setColor(EnumChatFormatting.func_175744_a(k));
                        }
                        else if (k == 16)
                        {
                            chatstyle.setObfuscated(Boolean.valueOf(true));
                        }
                        else if (k == 17)
                        {
                            chatstyle.setBold(Boolean.valueOf(true));
                        }
                        else if (k == 18)
                        {
                            chatstyle.setStrikethrough(Boolean.valueOf(true));
                        }
                        else if (k == 19)
                        {
                            chatstyle.setUnderlined(Boolean.valueOf(true));
                        }
                        else if (k == 20)
                        {
                            chatstyle.setItalic(Boolean.valueOf(true));
                        }
                        else if (k == 21)
                        {
                            chatstyle = new ChatStyle();
                        }
                    }
                }

                s = chatstyle.getFormattingCode() + s;
            }

            astring[i] = s;
        }

        return astring;
    }

    public static enum Align
    {
        LEFT,
        CENTER,
        RIGHT;
    }

    public static enum WordWrap
    {
        NO_WRAP,
        NORMAL,
        BREAK_WORD;
    }
}
