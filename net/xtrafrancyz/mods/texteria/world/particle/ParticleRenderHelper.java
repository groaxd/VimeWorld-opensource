package net.xtrafrancyz.mods.texteria.world.particle;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class ParticleRenderHelper
{
    private final Tessellator tessellator = Tessellator.getInstance();
    private final WorldRenderer worldRenderer;
    private int currentTexture;
    private boolean hasVertices;

    public ParticleRenderHelper()
    {
        this.worldRenderer = this.tessellator.getWorldRenderer();
        this.currentTexture = Integer.MIN_VALUE;
        this.hasVertices = false;
    }

    public void begin()
    {
        this.worldRenderer.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
    }

    public void draw()
    {
        this.tessellator.draw();
        this.hasVertices = false;
    }

    public void bindTexture(int texture)
    {
        if (texture != this.currentTexture)
        {
            this.currentTexture = texture;

            if (this.hasVertices)
            {
                this.draw();
                this.begin();
            }

            GlStateManager.bindTexture(texture);
        }
    }

    public WorldRenderer pos(double x, double y, double z)
    {
        this.hasVertices = true;
        return this.worldRenderer.pos(x, y, z);
    }
}
