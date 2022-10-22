package net.xtrafrancyz.mods.texteria.elements;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.xtrafrancyz.mods.texteria.gui.TexteriaGui;
import net.xtrafrancyz.mods.texteria.util.FValue;
import net.xtrafrancyz.mods.texteria.util.TRenderUtil;
import net.xtrafrancyz.util.ByteMap;
import org.lwjgl.opengl.GL11;

public class ProgressBar extends Rectangle
{
    private static final double BORDER_WIDTH = 0.5D;
    private static final double BORDER_WIDTH_D2 = 0.25D;
    public FValue progress;
    public int barColor;
    public int borderColor;

    public ProgressBar(ByteMap params)
    {
        super(params);
        this.progress = new FValue(params.getFloat("progress", 0.5F));
        this.barColor = params.getInt("barColor");
        this.borderColor = params.getInt("border", -1);
    }

    public void render(long time)
    {
        float f = this.getWidth();
        float f1 = this.getHeight();
        float f2 = f * this.progress.renderValue(time);
        GlStateManager.disableTexture2D();
        TRenderUtil.drawRect(0.0D, 0.0D, (double)f2, (double)f1, this.color.render);
        TRenderUtil.drawRect((double)f2, 0.0D, (double)(f - f2), (double)f1, this.setAlphaToBaseColorIfGreater(this.barColor));

        if (this.borderColor != -1)
        {
            GL11.glLineWidth(0.5F * (float)TexteriaGui.scaledResolution.getScaleFactor());
            GlStateManager.disableTexture2D();
            this.setColor(this.setAlphaToBaseColorIfGreater(this.borderColor));
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();
            worldrenderer.begin(2, DefaultVertexFormats.POSITION);
            worldrenderer.pos(-0.25D, -0.25D, 0.0D).endVertex();
            worldrenderer.pos((double)f + 0.25D, -0.25D, 0.0D).endVertex();
            worldrenderer.pos((double)f + 0.25D, (double)f1 + 0.25D, 0.0D).endVertex();
            worldrenderer.pos(-0.25D, (double)f1 + 0.25D, 0.0D).endVertex();
            tessellator.draw();
            GlStateManager.enableTexture2D();
        }
    }

    public void edit(ByteMap data)
    {
        if (data.containsKey("p"))
        {
            data.put("#progress", data.remove("p"));
        }

        super.edit(data);
    }
}
