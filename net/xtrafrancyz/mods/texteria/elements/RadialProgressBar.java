package net.xtrafrancyz.mods.texteria.elements;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.MathHelper;
import net.xtrafrancyz.util.ByteMap;

public class RadialProgressBar extends Element2D
{
    private final int size;
    protected float progress;

    public RadialProgressBar(ByteMap params)
    {
        super(params);
        this.size = params.getInt("size");
        this.progress = MathHelper.clamp_float(params.getFloat("progress", 0.5F), 0.0F, 1.0F);
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
        float f = this.progress * 360.0F;
        float f1 = (float)this.size / 2.0F;
        this.setColor(this.color.render);
        GlStateManager.translate(f1, f1, 0.0F);
        GlStateManager.disableTexture2D();
        WorldRenderer worldrenderer = Tessellator.getInstance().getWorldRenderer();
        worldrenderer.begin(4, DefaultVertexFormats.POSITION);

        if (f > 0.0F)
        {
            float f2 = -f1;

            if (f < 45.0F)
            {
                f2 = -f / 45.0F * f1;
            }

            this.drawTriangle(worldrenderer, 0.0F, -f1, f2, -f1);
        }

        if (f > 45.0F)
        {
            float f3 = 0.0F;

            if (f < 90.0F)
            {
                f3 = -((45.0F - f) / 45.0F) * f1 - f1;
            }

            this.drawTriangle(worldrenderer, -f1, -f1, -f1, f3);
        }

        if (f > 90.0F)
        {
            float f4 = f1;

            if (f < 135.0F)
            {
                f4 = -((90.0F - f) / 45.0F) * f1;
            }

            this.drawTriangle(worldrenderer, -f1, 0.0F, -f1, f4);
        }

        if (f > 135.0F)
        {
            float f5 = 0.0F;

            if (f < 180.0F)
            {
                f5 = -((135.0F - f) / 45.0F) * f1 - f1;
            }

            this.drawTriangle(worldrenderer, -f1, f1, f5, f1);
        }

        if (f > 180.0F)
        {
            float f6 = f1;

            if (f < 225.0F)
            {
                f6 = -((180.0F - f) / 45.0F) * f1;
            }

            this.drawTriangle(worldrenderer, 0.0F, f1, f6, f1);
        }

        if (f > 225.0F)
        {
            float f7 = 0.0F;

            if (f < 270.0F)
            {
                f7 = f1 + (225.0F - f) / 45.0F * f1;
            }

            this.drawTriangle(worldrenderer, f1, f1, f1, f7);
        }

        if (f > 270.0F)
        {
            float f8 = -f1;

            if (f < 315.0F)
            {
                f8 = (270.0F - f) / 45.0F * f1;
            }

            this.drawTriangle(worldrenderer, f1, 0.0F, f1, f8);
        }

        if (f > 315.0F)
        {
            this.drawTriangle(worldrenderer, f1, -f1, (360.0F - f) / 45.0F * f1, -f1);
        }

        Tessellator.getInstance().draw();
        GlStateManager.enableTexture2D();
    }

    private void drawTriangle(WorldRenderer worldRenderer, float x1, float y1, float x2, float y2)
    {
        worldRenderer.pos((double)x1, (double)y1, 0.0D).endVertex();
        worldRenderer.pos((double)x2, (double)y2, 0.0D).endVertex();
        worldRenderer.pos(0.0D, 0.0D, 0.0D).endVertex();
    }
}
