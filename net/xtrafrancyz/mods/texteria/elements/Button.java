package net.xtrafrancyz.mods.texteria.elements;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.util.ColorValue;
import net.xtrafrancyz.mods.texteria.util.Fluidity;
import net.xtrafrancyz.mods.texteria.util.TRenderUtil;
import net.xtrafrancyz.util.ByteMap;
import net.xtrafrancyz.util.Easing;

public class Button extends Rectangle
{
    public ColorValue textColor;
    public String text;
    public ColorValue hoverColor;
    public FontRenderer font;
    public int textWidth;
    private float hoverAnimationProgress;
    private long hoverAnimationFinish;
    private boolean lastHoverState;

    public Button(ByteMap params)
    {
        super(fixButtonFieldNames(params));
        this.font = Minecraft.getMinecraft().fontRendererObj;
        this.hoverAnimationProgress = 0.0F;
        this.hoverAnimationFinish = 0L;
        this.lastHoverState = false;
        this.hoverable = params.getBoolean("hv", true);
        this.text = params.getString("t");
        this.hoverColor = new ColorValue(params.getInt("hc", alterBrightness(this.color.orig, -20)), this.anim);
        this.textColor = new ColorValue(params.getInt("tc", -1), this.anim);
        this.textWidth = this.font.getStringWidth(this.text);
    }

    public float getWidth()
    {
        return this.widthFluidity == Fluidity.WRAP_CONTENT ? (float)(this.textWidth + 5) : (this.widthFluidity == Fluidity.MATCH_PARENT ? this.parent.getWidth() / this.scaleX.render : this.width.renderValue(Texteria.time));
    }

    public Fluidity getWidthFluidity()
    {
        return this.widthFluidity;
    }

    public float getHeight()
    {
        return this.heightFluidity == Fluidity.WRAP_CONTENT ? (float)(this.font.FONT_HEIGHT + 2) : (this.heightFluidity == Fluidity.MATCH_PARENT ? this.parent.getHeight() / this.scaleY.render : this.height.renderValue(Texteria.time));
    }

    public Fluidity getHeightFluidity()
    {
        return this.heightFluidity;
    }

    public void render(long time)
    {
        if (this.lastHoverState != this.hover)
        {
            this.lastHoverState = this.hover;

            if (this.hover)
            {
                this.hoverAnimationFinish = (long)(300.0F * (1.0F - this.hoverAnimationProgress)) + time;
            }
            else
            {
                this.hoverAnimationFinish = (long)(300.0F * this.hoverAnimationProgress) + time;
            }
        }

        float f;

        if (this.hoverAnimationFinish > time)
        {
            if (this.hover)
            {
                this.hoverAnimationProgress = 1.0F - Math.max(0.0F, (float)(this.hoverAnimationFinish - time) / 300.0F);
            }
            else
            {
                this.hoverAnimationProgress = Math.min(1.0F, (float)(this.hoverAnimationFinish - time) / 300.0F);
            }

            f = Easing.easeInOutQuad(this.hoverAnimationProgress);
        }
        else
        {
            f = this.hoverAnimationProgress = this.hover ? 1.0F : 0.0F;
        }

        float f1 = this.getWidth();
        float f2 = this.getHeight();
        float f3 = f2 * (0.9F - 0.8F * f);
        TRenderUtil.drawRect(0.0D, 0.0D, (double)f1, (double)f3, this.color.render);
        TRenderUtil.drawRect(0.0D, (double)f3, (double)f1, (double)(f2 - f3), this.setAlphaToBaseColor(this.hoverColor.renderValue(time)));
        this.font.drawStringWithShadow(this.text, (f1 - (float)this.textWidth) / 2.0F, (f2 - (float)this.font.FONT_HEIGHT) / 2.0F, this.setAlphaToBaseColor(this.textColor.renderValue(time)));
    }

    private static int alterBrightness(int color, int delta)
    {
        int i = color >> 16 & 255;
        int j = color >> 8 & 255;
        int k = color & 255;
        i = Math.min(255, i + delta);
        j = Math.min(255, j + delta);
        k = Math.min(255, k + delta);
        return (color & -16777216) + (i << 16) + (j << 8) + k;
    }

    public void edit(ByteMap data)
    {
        super.edit(data);

        if (data.containsKey(".text"))
        {
            this.textWidth = this.font.getStringWidth(this.text);
        }
    }

    private static ByteMap fixButtonFieldNames(ByteMap map)
    {
        if (map.containsKey("w"))
        {
            map.put("width", map.remove("w"));
        }

        if (map.containsKey("h"))
        {
            map.put("height", map.remove("h"));
        }

        return map;
    }
}
