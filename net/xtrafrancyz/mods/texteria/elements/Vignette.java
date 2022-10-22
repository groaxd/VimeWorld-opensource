package net.xtrafrancyz.mods.texteria.elements;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.xtrafrancyz.mods.texteria.util.Fluidity;
import net.xtrafrancyz.mods.texteria.util.Position;
import net.xtrafrancyz.util.ByteMap;

public class Vignette extends Element2D
{
    private final Minecraft mc = Minecraft.getMinecraft();

    public Vignette(ByteMap params)
    {
        super(params);
        this.pos = Position.TOP_LEFT;
        this.x.set(0.0F);
        this.y.set(0.0F);
    }

    public Fluidity getWidthFluidity()
    {
        return Fluidity.MATCH_PARENT;
    }

    public float getWidth()
    {
        return this.parent.getWidth();
    }

    public Fluidity getHeightFluidity()
    {
        return Fluidity.MATCH_PARENT;
    }

    public float getHeight()
    {
        return this.parent.getHeight();
    }

    public void render(long time)
    {
        this.setColor0(this.color.render);
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.blendFunc(1, 769);
        this.mc.getTextureManager().bindTexture(GuiIngame.vignetteTexPath);
        WorldRenderer worldrenderer = Tessellator.getInstance().getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(0.0D, (double)this.parent.getHeight(), -90.0D).tex(0.0D, 1.0D).endVertex();
        worldrenderer.pos((double)this.parent.getWidth(), (double)this.parent.getHeight(), -90.0D).tex(1.0D, 1.0D).endVertex();
        worldrenderer.pos((double)this.parent.getWidth(), 0.0D, -90.0D).tex(1.0D, 0.0D).endVertex();
        worldrenderer.pos(0.0D, 0.0D, -90.0D).tex(0.0D, 0.0D).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
    }

    private void setColor0(int color)
    {
        float f = (float)(color >> 24 & 255) / 255.0F;
        float f1 = (float)(color >> 16 & 255) / 255.0F * f;
        float f2 = (float)(color >> 8 & 255) / 255.0F * f;
        float f3 = (float)(color & 255) / 255.0F * f;
        GlStateManager.color(f1, f2, f3, 1.0F);
    }
}
