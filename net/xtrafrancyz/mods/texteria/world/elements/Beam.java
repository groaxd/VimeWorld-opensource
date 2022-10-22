package net.xtrafrancyz.mods.texteria.world.elements;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.AxisAlignedBB;
import net.xtrafrancyz.mods.texteria.util.ColorValue;
import net.xtrafrancyz.mods.texteria.util.FValue;
import net.xtrafrancyz.util.ByteMap;
import net.xtrafrancyz.util.Easing;

public class Beam extends WorldGroup
{
    public ColorValue color = new ColorValue(-1, Easing.EASE_IN_SINE, 255);
    public float alphaMultiplier;
    public float origAlpha;
    public FValue height;

    public Beam(ByteMap params)
    {
        super(params);
        this.color.set(params.getInt("color"));
        this.alphaMultiplier = 1.0F;
        this.height = new FValue(params.getFloat("height", 255.0F - this.loc.y.orig));
        this.updateColor();
    }

    private void updateColor()
    {
        this.origAlpha = (float)this.getAlpha(this.color.orig) / 255.0F;
        this.color.set(this.setAlpha(this.color.orig, 39));
    }

    protected void recalculateBoundingBox()
    {
        double d0 = 0.30000001192092896D;
        this.boundingBox = (new AxisAlignedBB(-d0, 0.0D, -d0, d0, (double)(255.0F - this.loc.y.orig), d0)).offset((double)this.loc.x.orig, (double)this.loc.y.orig, (double)this.loc.z.orig);
    }

    public void calcDistanceSquaredToPlayer()
    {
        this.distanceSquaredToPlayer = (float)(square(this.renderManager.viewerPosX - (double)this.loc.x.orig) + square(this.renderManager.viewerPosZ - (double)this.loc.z.orig));
    }

    public void render(long time)
    {
        if (this.preRender(time))
        {
            this.setAlphaMultiplier(time);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.pushMatrix();
            GlStateManager.translate((double)this.loc.x.render - TileEntityRendererDispatcher.staticPlayerX, 0.0D - TileEntityRendererDispatcher.staticPlayerY, (double)this.loc.z.render - TileEntityRendererDispatcher.staticPlayerZ);
            float f = 0.03F;
            GlStateManager.scale(-this.scale.x.render * f, -f, -this.scale.z.render * f);
            GlStateManager.pushMatrix();
            float f1 = 2.15F;
            GlStateManager.translate(-5.0F * f1, 0.0F, 5.0F * f1);
            GlStateManager.scale(f1, 1.0F, f1);
            this.renderBeam(time, this.setAlpha(this.color.renderValue(time), 16), false);
            GlStateManager.popMatrix();
            GlStateManager.rotate((float)(time / 20L % 360L), 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(-5.0F, 0.0F, 5.0F);
            GlStateManager.pushMatrix();
            this.renderBeam(time, this.color.renderValue(time), true);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.translate(2.5F, 0.0F, -2.5F);
            GlStateManager.scale(0.5F, 1.0F, 0.5F);
            this.renderBeam(time, this.alterBrightness(this.color.renderValue(time), 190), true);
            GlStateManager.popMatrix();
            GlStateManager.popMatrix();
        }
    }

    private void setAlphaMultiplier(long time)
    {
        int i = (int)(time - this.startTime);
        int j = (int)(this.finishTime - time);

        if (i <= this.startFade)
        {
            this.alphaMultiplier = (float)i / (float)this.startFade;
        }
        else if (j <= this.finishFade)
        {
            this.alphaMultiplier = (float)j / (float)this.finishFade;
        }
        else
        {
            this.alphaMultiplier = 1.0F;
        }
    }

    private void renderBeam(long time, int color, boolean corners)
    {
        GlStateManager.disableTexture2D();
        GlStateManager.disableCull();
        this.setColor(this.setAlpha(color, (int)((float)this.getAlpha(color) * this.alphaMultiplier * this.origAlpha)));
        int i = 8500;
        int j = (int)(this.loc.y.render / 255.0F * (float)i);
        int k = (int)((this.loc.y.render + this.height.renderValue(time)) / 255.0F * (float)i);

        for (int l = 0; l < 4; ++l)
        {
            if (corners)
            {
                GlStateManager.pushMatrix();

                for (int i1 = 0; i1 < 2; ++i1)
                {
                    GlStateManager.translate(1.0F, 0.0F, 0.0F);
                    this.drawRect(-1.0F, (float)(-k), 1.0F, (float)(-j));
                    GlStateManager.translate(-1.0F, 0.0F, 0.0F);
                    GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
                }

                GlStateManager.popMatrix();
            }

            GlStateManager.translate(5.0F, 0.0F, 0.0F);
            this.drawRect(-5.0F, (float)(-k), 5.0F, (float)(-j));
            GlStateManager.translate(5.0F, 0.0F, 0.0F);
            GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
        }

        GlStateManager.enableTexture2D();
    }

    private int alterBrightness(int color, int val)
    {
        int i = color >> 16 & 255;
        int j = color >> 8 & 255;
        int k = color & 255;
        i = Math.min(255, i + val);
        j = Math.min(255, j + val);
        k = Math.min(255, k + val);
        return (color & -16777216) + (i << 16) + (j << 8) + k;
    }

    private void drawRect(float x1, float y1, float x2, float y2)
    {
        WorldRenderer worldrenderer = Tessellator.getInstance().getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION);
        worldrenderer.pos((double)x1, (double)y2, 0.0D).endVertex();
        worldrenderer.pos((double)x2, (double)y2, 0.0D).endVertex();
        worldrenderer.pos((double)x2, (double)y1, 0.0D).endVertex();
        worldrenderer.pos((double)x1, (double)y1, 0.0D).endVertex();
        Tessellator.getInstance().draw();
    }

    public void edit(ByteMap data)
    {
        data.remove("actions");
        super.edit(data);

        if (data.containsKey(".color") || data.containsKey("#color") || data.containsKey("#%color"))
        {
            this.updateColor();
        }
    }
}
