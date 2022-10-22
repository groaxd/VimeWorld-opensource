package net.xtrafrancyz.mods.texteria.elements;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.MathHelper;
import net.xtrafrancyz.util.ByteMap;

public class OctagonBarFull extends Element2D
{
    private int size;
    private int progress;
    private int fillColor;
    private int borderColor;

    public OctagonBarFull(ByteMap params)
    {
        super(params);
        this.size = params.getInt("size");
        this.progress = params.getInt("progress", 4);
        this.fillColor = params.getInt("fill");
        this.borderColor = params.getInt("border", -1);
    }

    public float getWidth()
    {
        return (float)this.size;
    }

    public float getHeight()
    {
        return (float)this.size;
    }

    public void render(long time)
    {
        float f = (float)(-this.size) / 2.0F;
        float f1 = f / 1.412F;
        GlStateManager.disableTexture2D();

        if (this.borderColor != -1)
        {
            float f2 = (float)this.size * MathHelper.sin(22.5F);
            this.setColor(this.setAlphaToBaseColorIfGreater(this.borderColor));
            GlStateManager.pushMatrix();
            GlStateManager.translate(-f, -f, 0.0F);
            GlStateManager.rotate(-22.5F, 0.0F, 0.0F, 1.0F);
            float f3 = f + (float)this.size * 0.038F;
            float f4 = -f1 - (float)this.size * 0.1551F;
            float f5 = f + (float)this.size * 0.02F;
            float f6 = -f1 + f2 - (float)this.size * 0.0656F;

            for (int i = 0; i < 8; ++i)
            {
                GlStateManager.rotate(45.0F, 0.0F, 0.0F, 1.0F);
                this.drawRect(f3, f4, f5, f6);
            }

            GlStateManager.popMatrix();
        }

        GlStateManager.translate(-f, -f, 0.0F);
        this.setColor(this.setAlphaToBaseColorIfGreater(this.fillColor));

        for (int j = 0; j < 8; ++j)
        {
            if (j == this.progress)
            {
                this.setColor(this.color.render);
            }

            GlStateManager.rotate(45.0F, 0.0F, 0.0F, 1.0F);
            this.drawTriangle(0.0F, f, f1, f1);
        }

        GlStateManager.enableTexture2D();
    }

    private void drawTriangle(float x1, float y1, float x2, float y2)
    {
        WorldRenderer worldrenderer = Tessellator.getInstance().getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION);
        worldrenderer.pos((double)x1, (double)y1, 0.0D).endVertex();
        worldrenderer.pos((double)x2, (double)y2, 0.0D).endVertex();
        worldrenderer.pos(0.0D, 0.0D, 0.0D).endVertex();
        worldrenderer.pos(0.0D, 0.0D, 0.0D).endVertex();
        Tessellator.getInstance().draw();
    }

    private void drawRect(float x1, float y1, float x2, float y2)
    {
        WorldRenderer worldrenderer = Tessellator.getInstance().getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION);
        worldrenderer.pos((double)x1, (double)(y2 * 0.9629F), 0.0D).endVertex();
        worldrenderer.pos((double)x2, (double)y2, 0.0D).endVertex();
        worldrenderer.pos((double)x2, (double)y1, 0.0D).endVertex();
        worldrenderer.pos((double)x1, (double)(y1 * 0.9629F), 0.0D).endVertex();
        Tessellator.getInstance().draw();
    }
}
