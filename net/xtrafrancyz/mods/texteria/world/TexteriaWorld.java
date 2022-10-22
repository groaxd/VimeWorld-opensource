package net.xtrafrancyz.mods.texteria.world;

import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.world.aabb.BoxList;
import net.xtrafrancyz.mods.texteria.world.elements.Element3D;
import net.xtrafrancyz.mods.texteria.world.particle.Particle;
import net.xtrafrancyz.mods.texteria.world.particle.ParticleList;
import net.xtrafrancyz.mods.texteria.world.particle.ParticleRenderHelper;
import optifine.Config;
import shadersmod.client.Shaders;

public class TexteriaWorld implements IResourceManagerReloadListener
{
    public static int[] autumnGrass = new int[65536];
    public static int[] autumnFoliage = autumnGrass;
    private final Minecraft mc;
    public final Element3DList elements;
    public final ParticleList particles;
    public final BoxList boxes;
    private long lastBBRevalidation = 0L;
    public int visibleElementsCount = 0;
    public int visibleParticlesCount = 0;

    public TexteriaWorld(Minecraft mc)
    {
        this.mc = mc;
        this.elements = new Element3DList();
        this.particles = new ParticleList();
        this.boxes = new BoxList();

        if (mc.getResourceManager() instanceof IReloadableResourceManager)
        {
            ((IReloadableResourceManager)mc.getResourceManager()).registerReloadListener(this);
        }
    }

    public void onResourceManagerReload(IResourceManager resourceManager)
    {
        try
        {
            autumnGrass = TextureUtil.readImageData(resourceManager, new ResourceLocation("texteria", "autumn_grass.png"));
            autumnFoliage = TextureUtil.readImageData(resourceManager, new ResourceLocation("texteria", "autumn_foliage.png"));
        }
        catch (IOException var3)
        {
            ;
        }
    }

    public void render(Frustum frustum)
    {
        this.mc.theWorld.theProfiler.startSection("Texteria");
        GlStateManager.pushMatrix();
        GlStateManager.depthFunc(515);
        GlStateManager.alphaFunc(516, 0.01F);

        if (Config.isShaders())
        {
            Shaders.beginLivingDamage();
        }

        this.visibleElementsCount = 0;
        boolean flag = this.mc.getRenderManager().isDebugBoundingBox();
        long i = Texteria.time = System.currentTimeMillis();
        boolean flag1 = i - this.lastBBRevalidation > 250L;

        if (flag1)
        {
            this.lastBBRevalidation = i;
        }

        for (Element3D element3d : this.elements.getSortedVisible(i))
        {
            if (element3d.finishTime < i)
            {
                if (this.elements.getAll().contains(element3d))
                {
                    element3d.dispose();
                    this.elements.remove0(element3d);
                }
            }
            else
            {
                if (element3d.isInViewRange())
                {
                    if (flag)
                    {
                        GlStateManager.disableTexture2D();
                        GlStateManager.color(1.0F, 1.0F, 0.0F, 1.0F);
                        RenderGlobal.func_181561_a(element3d.boundingBox.offset(-TileEntityRendererDispatcher.staticPlayerX, -TileEntityRendererDispatcher.staticPlayerY, -TileEntityRendererDispatcher.staticPlayerZ));
                        GlStateManager.enableTexture2D();
                    }

                    if (element3d.isVisible(frustum))
                    {
                        element3d.render(i);
                        ++this.visibleElementsCount;
                        continue;
                    }

                    if (flag1)
                    {
                        element3d.revalidateBB(i);
                    }
                }

                element3d.invisibleTick(i);
            }
        }

        if (flag)
        {
            this.boxes.render(frustum);
        }

        GlStateManager.depthMask(true);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.theWorld.theProfiler.endSection();
    }

    public void tickParticles()
    {
        if (this.particles.size() != 0)
        {
            World world = this.mc.theWorld;
            long i = Texteria.time = System.currentTimeMillis();

            for (Particle particle : this.particles.getCachedSortedVisible())
            {
                particle.tick(i, world);
            }
        }
    }

    public void renderParticles(float partialTicks)
    {
        if (this.particles.size() != 0)
        {
            this.mc.theWorld.theProfiler.startSection("Texteria");
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            ParticleRenderHelper particlerenderhelper = new ParticleRenderHelper();
            particlerenderhelper.begin();
            float f = (float)EntityFX.interpPosX;
            float f1 = (float)EntityFX.interpPosY;
            float f2 = (float)EntityFX.interpPosZ;
            this.visibleParticlesCount = 0;
            long i = Texteria.time = System.currentTimeMillis();

            for (Particle particle : this.particles.getSortedVisible(i))
            {
                if (particle.deadline < i)
                {
                    this.particles.remove(particle);
                }
                else if (particle.isInViewRange())
                {
                    particle.render(particlerenderhelper, i, partialTicks, f, f1, f2);
                    ++this.visibleParticlesCount;
                }
            }

            particlerenderhelper.draw();
            this.mc.theWorld.theProfiler.endSection();
        }
    }
}
