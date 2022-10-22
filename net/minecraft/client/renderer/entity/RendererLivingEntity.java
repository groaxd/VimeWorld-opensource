package net.minecraft.client.renderer.entity;

import com.google.common.collect.Lists;
import java.nio.FloatBuffer;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.MathHelper;
import net.xtrafrancyz.covered.ObfValue;
import optifine.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import shadersmod.client.Shaders;

public abstract class RendererLivingEntity<T extends EntityLivingBase> extends Render<T>
{
    private static final ObfValue.OInteger OBFVAL_T0s2h;
    private static final ObfValue.OInteger OBFVAL_a9zRj;
    private static final ObfValue.OInteger OBFVAL_jff3L;
    private static final ObfValue.OInteger OBFVAL_cJg57;
    private static final ObfValue.ODouble OBFVAL_0zWzV;
    private static final ObfValue.OFloat OBFVAL_R63C4;
    private static final ObfValue.OFloat OBFVAL_lR1DD;
    private static final ObfValue.OInteger OBFVAL_rf2Lq;
    private static final ObfValue.OFloat OBFVAL_G98DI;
    private static final ObfValue.OInteger OBFVAL_4ZK3E;
    private static final ObfValue.OFloat OBFVAL_0nKxT;
    private static final ObfValue.OFloat OBFVAL_PnfPS;
    private static final ObfValue.OFloat OBFVAL_nskd9;
    private static final ObfValue.OFloat OBFVAL_IFcir;
    private static final ObfValue.OInteger OBFVAL_cq6dL;
    private static final ObfValue.OFloat OBFVAL_KhlQR;
    private static final ObfValue.OFloat OBFVAL_SVRLp;
    private static final ObfValue.ODouble OBFVAL_anqiJ;
    private static final ObfValue.OInteger OBFVAL_6LUYZ;
    private static final ObfValue.OInteger OBFVAL_0lEHr;
    private static final ObfValue.OFloat OBFVAL_Irygb;
    private static final ObfValue.OFloat OBFVAL_KQLVW;
    private static final ObfValue.OInteger OBFVAL_koZx0;
    private static final ObfValue.OFloat OBFVAL_dAHMb;
    private static final ObfValue.OInteger OBFVAL_eDeDm;
    private static final ObfValue.OFloat OBFVAL_WcL1g;
    private static final ObfValue.OFloat OBFVAL_U48ME;
    private static final ObfValue.OFloat OBFVAL_nFGPR;
    private static final ObfValue.OInteger OBFVAL_f8CEv;
    private static final ObfValue.OInteger OBFVAL_QSNa9;
    private static final ObfValue.OFloat OBFVAL_kixb9;
    private static final ObfValue.OFloat OBFVAL_cQcDD;
    private static final ObfValue.OFloat OBFVAL_XqQRH;
    private static final ObfValue.OFloat OBFVAL_Sagdi;
    private static final ObfValue.OInteger OBFVAL_4MTep;
    private static final ObfValue.OFloat OBFVAL_f3nJ6;
    private static final ObfValue.OInteger OBFVAL_sV5Mm;
    private static final ObfValue.OFloat OBFVAL_0Yagz;
    private static final ObfValue.OInteger OBFVAL_pPLRE;
    private static final ObfValue.OInteger OBFVAL_9RlZu;
    private static final ObfValue.OFloat OBFVAL_mNjk1;
    private static final ObfValue.OInteger OBFVAL_YQvrx;
    private static final ObfValue.OFloat OBFVAL_8nfqx;
    private static final ObfValue.OInteger OBFVAL_EkNZu;
    private static final ObfValue.OFloat OBFVAL_WEsbr;
    private static final ObfValue.OFloat OBFVAL_CC0tp;
    private static final Logger logger = LogManager.getLogger();
    private static final DynamicTexture field_177096_e = new DynamicTexture(16, 16);
    protected ModelBase mainModel;
    protected FloatBuffer brightnessBuffer;
    protected List<LayerRenderer<T>> layerRenderers;
    protected boolean renderOutlines;
    private static final String __OBFID = "CL_00001012";
    public static float NAME_TAG_RANGE = 64.0F;
    public static float NAME_TAG_RANGE_SNEAK = 32.0F;

    public RendererLivingEntity(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn)
    {
        super(renderManagerIn);
        this.brightnessBuffer = GLAllocation.createDirectFloatBuffer(OBFVAL_4MTep.get());
        this.layerRenderers = Lists.<LayerRenderer<T>>newArrayList();
        this.renderOutlines = false;
        this.mainModel = modelBaseIn;
        this.shadowSize = shadowSizeIn;
    }

    public <V extends EntityLivingBase, U extends LayerRenderer<V>> boolean addLayer(U layer)
    {
        return this.layerRenderers.add(layer);
    }

    protected <V extends EntityLivingBase, U extends LayerRenderer<V>> boolean removeLayer(U layer)
    {
        return this.layerRenderers.remove(layer);
    }

    public ModelBase getMainModel()
    {
        return this.mainModel;
    }

    /**
     * Returns a rotation angle that is inbetween two other rotation angles. par1 and par2 are the angles between which
     * to interpolate, par3 is probably a float between 0.0 and 1.0 that tells us where "between" the two angles we are.
     * Example: par1 = 30, par2 = 50, par3 = 0.5, then return = 40
     */
    protected float interpolateRotation(float par1, float par2, float par3)
    {
        float f;

        for (f = par2 - par1; f < OBFVAL_8nfqx.get(); f += OBFVAL_WEsbr.get())
        {
            ;
        }

        while (f >= OBFVAL_f3nJ6.get())
        {
            f -= OBFVAL_WEsbr.get();
        }

        return par1 + par3 * f;
    }

    public void transformHeldFull3DItemLayer()
    {
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        this.mainModel.swingProgress = this.getSwingProgress(entity, partialTicks);
        this.mainModel.isRiding = entity.isRiding();
        this.mainModel.isChild = entity.isChild();

        try
        {
            float f = this.interpolateRotation(entity.prevRenderYawOffset, entity.renderYawOffset, partialTicks);
            float f1 = this.interpolateRotation(entity.prevRotationYawHead, entity.rotationYawHead, partialTicks);
            float f2 = f1 - f;

            if (this.mainModel.isRiding && entity.ridingEntity instanceof EntityLivingBase)
            {
                EntityLivingBase entitylivingbase = (EntityLivingBase)entity.ridingEntity;
                f = this.interpolateRotation(entitylivingbase.prevRenderYawOffset, entitylivingbase.renderYawOffset, partialTicks);
                f2 = f1 - f;
                float f3 = MathHelper.wrapAngleTo180_float(f2);

                if (f3 < OBFVAL_KQLVW.get())
                {
                    f3 = OBFVAL_KQLVW.get();
                }

                if (f3 >= OBFVAL_cQcDD.get())
                {
                    f3 = OBFVAL_cQcDD.get();
                }

                f = f1 - f3;

                if (f3 * f3 > OBFVAL_Sagdi.get())
                {
                    f += f3 * OBFVAL_KhlQR.get();
                }
            }

            float f7 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks;
            this.renderLivingAt(entity, x, y, z);
            float f8 = this.handleRotationFloat(entity, partialTicks);
            this.rotateCorpse(entity, f8, f, partialTicks);
            GlStateManager.enableRescaleNormal();
            GlStateManager.scale(OBFVAL_CC0tp.get(), OBFVAL_CC0tp.get(), 1.0F);
            this.preRenderCallback(entity, partialTicks);
            float f4 = OBFVAL_lR1DD.get();
            GlStateManager.translate(0.0F, OBFVAL_nskd9.get(), 0.0F);
            float f5 = entity.prevLimbSwingAmount + (entity.limbSwingAmount - entity.prevLimbSwingAmount) * partialTicks;
            float f6 = entity.limbSwing - entity.limbSwingAmount * (1.0F - partialTicks);

            if (entity.isChild())
            {
                f6 *= OBFVAL_U48ME.get();
            }

            if (f5 > 1.0F)
            {
                f5 = 1.0F;
            }

            GlStateManager.enableAlpha();
            this.mainModel.setLivingAnimations(entity, f6, f5, partialTicks);
            this.mainModel.setRotationAngles(f6, f5, f8, f2, f7, OBFVAL_lR1DD.get(), entity);

            if (this.renderOutlines)
            {
                boolean flag1 = this.setScoreTeamColor(entity);
                this.renderModel(entity, f6, f5, f8, f2, f7, OBFVAL_lR1DD.get());

                if (flag1)
                {
                    this.unsetScoreTeamColor();
                }
            }
            else
            {
                boolean flag = this.setDoRenderBrightness(entity, partialTicks);
                this.renderModel(entity, f6, f5, f8, f2, f7, OBFVAL_lR1DD.get());

                if (flag)
                {
                    this.unsetBrightness();
                }

                GlStateManager.depthMask(true);

                if (!(entity instanceof EntityPlayer) || !((EntityPlayer)entity).isSpectator())
                {
                    this.renderLayers(entity, f6, f5, partialTicks, f8, f2, f7, OBFVAL_lR1DD.get());
                }
            }

            GlStateManager.disableRescaleNormal();
        }
        catch (Exception exception)
        {
            logger.error((String)"Couldn\'t render entity", (Throwable)exception);
        }

        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.enableCull();
        GlStateManager.popMatrix();

        if (!this.renderOutlines)
        {
            super.doRender(entity, x, y, z, entityYaw, partialTicks);
        }
    }

    protected boolean setScoreTeamColor(EntityLivingBase entityLivingBaseIn)
    {
        int i = OBFVAL_f8CEv.get();
        i = entityLivingBaseIn.getOutlineColor();
        float f = (float)(i >> OBFVAL_EkNZu.get() & OBFVAL_QSNa9.get()) / OBFVAL_Irygb.get();
        float f1 = (float)(i >> OBFVAL_0lEHr.get() & OBFVAL_QSNa9.get()) / OBFVAL_Irygb.get();
        float f2 = (float)(i & OBFVAL_QSNa9.get()) / OBFVAL_Irygb.get();
        GlStateManager.disableLighting();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.color(f, f1, f2, 1.0F);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        return true;
    }

    protected void unsetScoreTeamColor()
    {
        GlStateManager.enableLighting();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    /**
     * Renders the model in RenderLiving
     */
    protected void renderModel(T entitylivingbaseIn, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_)
    {
        boolean flag = !entitylivingbaseIn.isInvisible();
        boolean flag1 = !flag && !entitylivingbaseIn.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer);

        if (flag || flag1)
        {
            if (!this.bindEntityTexture(entitylivingbaseIn))
            {
                return;
            }

            if (flag1)
            {
                GlStateManager.pushMatrix();
                GlStateManager.color(1.0F, 1.0F, 1.0F, OBFVAL_mNjk1.get());
                GlStateManager.depthMask(false);
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(OBFVAL_YQvrx.get(), OBFVAL_jff3L.get());
                GlStateManager.alphaFunc(OBFVAL_koZx0.get(), OBFVAL_IFcir.get());
            }

            this.mainModel.render(entitylivingbaseIn, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);

            if (flag1)
            {
                GlStateManager.disableBlend();
                GlStateManager.alphaFunc(OBFVAL_koZx0.get(), OBFVAL_dAHMb.get());
                GlStateManager.popMatrix();
                GlStateManager.depthMask(true);
            }
        }
    }

    protected boolean setDoRenderBrightness(T entityLivingBaseIn, float partialTicks)
    {
        return this.setBrightness(entityLivingBaseIn, partialTicks, true);
    }

    protected boolean setBrightness(T entitylivingbaseIn, float partialTicks, boolean combineTextures)
    {
        float f = entitylivingbaseIn.getBrightness(partialTicks);
        int i = this.getColorMultiplier(entitylivingbaseIn, f, partialTicks);
        boolean flag = (i >> OBFVAL_pPLRE.get() & OBFVAL_QSNa9.get()) > 0;
        boolean flag1 = entitylivingbaseIn.hurtTime > 0 || entitylivingbaseIn.deathTime > 0;

        if (!flag && !flag1)
        {
            return false;
        }
        else if (!flag && !combineTextures)
        {
            return false;
        }
        else
        {
            GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
            GlStateManager.enableTexture2D();
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OBFVAL_a9zRj.get(), OpenGlHelper.GL_COMBINE);
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_COMBINE_RGB, OBFVAL_cJg57.get());
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.defaultTexUnit);
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PRIMARY_COLOR);
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND0_RGB, OBFVAL_4ZK3E.get());
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND1_RGB, OBFVAL_4ZK3E.get());
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_COMBINE_ALPHA, OBFVAL_T0s2h.get());
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.defaultTexUnit);
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND0_ALPHA, OBFVAL_YQvrx.get());
            GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
            GlStateManager.enableTexture2D();
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OBFVAL_a9zRj.get(), OpenGlHelper.GL_COMBINE);
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_COMBINE_RGB, OpenGlHelper.GL_INTERPOLATE);
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.GL_CONSTANT);
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE2_RGB, OpenGlHelper.GL_CONSTANT);
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND0_RGB, OBFVAL_4ZK3E.get());
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND1_RGB, OBFVAL_4ZK3E.get());
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND2_RGB, OBFVAL_YQvrx.get());
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_COMBINE_ALPHA, OBFVAL_T0s2h.get());
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.GL_PREVIOUS);
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND0_ALPHA, OBFVAL_YQvrx.get());
            this.brightnessBuffer.position(0);

            if (flag1)
            {
                this.brightnessBuffer.put(1.0F);
                this.brightnessBuffer.put(0.0F);
                this.brightnessBuffer.put(0.0F);
                this.brightnessBuffer.put(OBFVAL_PnfPS.get());

                if (Config.isShaders())
                {
                    Shaders.setEntityColor(1.0F, 0.0F, 0.0F, OBFVAL_PnfPS.get());
                }
            }
            else
            {
                float f1 = (float)(i >> OBFVAL_pPLRE.get() & OBFVAL_QSNa9.get()) / OBFVAL_Irygb.get();
                float f2 = (float)(i >> OBFVAL_EkNZu.get() & OBFVAL_QSNa9.get()) / OBFVAL_Irygb.get();
                float f3 = (float)(i >> OBFVAL_0lEHr.get() & OBFVAL_QSNa9.get()) / OBFVAL_Irygb.get();
                float f4 = (float)(i & OBFVAL_QSNa9.get()) / OBFVAL_Irygb.get();
                this.brightnessBuffer.put(f2);
                this.brightnessBuffer.put(f3);
                this.brightnessBuffer.put(f4);
                this.brightnessBuffer.put(1.0F - f1);

                if (Config.isShaders())
                {
                    Shaders.setEntityColor(f2, f3, f4, 1.0F - f1);
                }
            }

            this.brightnessBuffer.flip();
            GL11.glTexEnv(OBFVAL_cq6dL.get(), OBFVAL_9RlZu.get(), this.brightnessBuffer);
            GlStateManager.setActiveTexture(OpenGlHelper.GL_TEXTURE2);
            GlStateManager.enableTexture2D();
            GlStateManager.bindTexture(field_177096_e.getGlTextureId());
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OBFVAL_a9zRj.get(), OpenGlHelper.GL_COMBINE);
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_COMBINE_RGB, OBFVAL_cJg57.get());
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.GL_PREVIOUS);
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.lightmapTexUnit);
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND0_RGB, OBFVAL_4ZK3E.get());
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND1_RGB, OBFVAL_4ZK3E.get());
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_COMBINE_ALPHA, OBFVAL_T0s2h.get());
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.GL_PREVIOUS);
            GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND0_ALPHA, OBFVAL_YQvrx.get());
            GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
            return true;
        }
    }

    protected void unsetBrightness()
    {
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.enableTexture2D();
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OBFVAL_a9zRj.get(), OpenGlHelper.GL_COMBINE);
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_COMBINE_RGB, OBFVAL_cJg57.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.defaultTexUnit);
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PRIMARY_COLOR);
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND0_RGB, OBFVAL_4ZK3E.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND1_RGB, OBFVAL_4ZK3E.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_COMBINE_ALPHA, OBFVAL_cJg57.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.defaultTexUnit);
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE1_ALPHA, OpenGlHelper.GL_PRIMARY_COLOR);
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND0_ALPHA, OBFVAL_YQvrx.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND1_ALPHA, OBFVAL_YQvrx.get());
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OBFVAL_a9zRj.get(), OpenGlHelper.GL_COMBINE);
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_COMBINE_RGB, OBFVAL_cJg57.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND0_RGB, OBFVAL_4ZK3E.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND1_RGB, OBFVAL_4ZK3E.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE0_RGB, OBFVAL_6LUYZ.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_COMBINE_ALPHA, OBFVAL_cJg57.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND0_ALPHA, OBFVAL_YQvrx.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE0_ALPHA, OBFVAL_6LUYZ.get());
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.setActiveTexture(OpenGlHelper.GL_TEXTURE2);
        GlStateManager.disableTexture2D();
        GlStateManager.bindTexture(0);
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OBFVAL_a9zRj.get(), OpenGlHelper.GL_COMBINE);
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_COMBINE_RGB, OBFVAL_cJg57.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND0_RGB, OBFVAL_4ZK3E.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND1_RGB, OBFVAL_4ZK3E.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE0_RGB, OBFVAL_6LUYZ.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_COMBINE_ALPHA, OBFVAL_cJg57.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_OPERAND0_ALPHA, OBFVAL_YQvrx.get());
        GL11.glTexEnvi(OBFVAL_cq6dL.get(), OpenGlHelper.GL_SOURCE0_ALPHA, OBFVAL_6LUYZ.get());
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);

        if (Config.isShaders())
        {
            Shaders.setEntityColor(0.0F, 0.0F, 0.0F, 0.0F);
        }
    }

    /**
     * Sets a simple glTranslate on a LivingEntity.
     */
    protected void renderLivingAt(T entityLivingBaseIn, double x, double y, double z)
    {
        GlStateManager.translate((float)x, (float)y, (float)z);
    }

    protected void rotateCorpse(T bat, float p_77043_2_, float p_77043_3_, float partialTicks)
    {
        GlStateManager.rotate(OBFVAL_f3nJ6.get() - p_77043_3_, 0.0F, 1.0F, 0.0F);

        if (bat.deathTime > 0)
        {
            float f = ((float)bat.deathTime + partialTicks - 1.0F) / OBFVAL_nFGPR.get() * OBFVAL_XqQRH.get();
            f = MathHelper.sqrt_float(f);

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            GlStateManager.rotate(f * this.getDeathMaxRotation(bat), 0.0F, 0.0F, 1.0F);
        }
    }

    /**
     * Returns where in the swing animation the living entity is (from 0 to 1).  Args : entity, partialTickTime
     */
    protected float getSwingProgress(T livingBase, float partialTickTime)
    {
        return livingBase.getSwingProgress(partialTickTime);
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(T livingBase, float partialTicks)
    {
        return (float)livingBase.ticksExisted + partialTicks;
    }

    protected void renderLayers(T entitylivingbaseIn, float p_177093_2_, float p_177093_3_, float partialTicks, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_)
    {
        for (LayerRenderer<T> layerrenderer : this.layerRenderers)
        {
            boolean flag = this.setBrightness(entitylivingbaseIn, partialTicks, layerrenderer.shouldCombineTextures());
            layerrenderer.doRenderLayer(entitylivingbaseIn, p_177093_2_, p_177093_3_, partialTicks, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);

            if (flag)
            {
                this.unsetBrightness();
            }
        }
    }

    protected float getDeathMaxRotation(T entityLivingBaseIn)
    {
        return OBFVAL_kixb9.get();
    }

    /**
     * Returns an ARGB int color back. Args: entityLiving, lightBrightness, partialTickTime
     */
    protected int getColorMultiplier(T entitylivingbaseIn, float lightBrightness, float partialTickTime)
    {
        return 0;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(T entitylivingbaseIn, float partialTickTime)
    {
    }

    public void renderName(T entity, double x, double y, double z)
    {
        if (this.canRenderName(entity))
        {
            double d0 = entity.getDistanceSqToEntity(this.renderManager.livingPlayer);
            float f = entity.isSneaking() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE;

            if (d0 < (double)(f * f))
            {
                String s;

                if (entity instanceof EntityPlayer)
                {
                    s = entity.hasCustomName() ? entity.getCustomNameTag() : entity.getName();
                }
                else if (entity instanceof EntityVillager)
                {
                    s = entity.getDisplayName().getFormattedText();
                }
                else
                {
                    s = entity.getName();
                }

                if (s.equals("\u00a78-@HIDDEN"))
                {
                    return;
                }

                GlStateManager.alphaFunc(OBFVAL_koZx0.get(), OBFVAL_dAHMb.get());

                if (entity.isSneaking())
                {
                    FontRenderer fontrenderer = this.getFontRendererFromRenderManager();
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((float)x, (float)y + entity.height + OBFVAL_0Yagz.get() - (entity.isChild() ? entity.height / OBFVAL_0nKxT.get() : 0.0F), (float)z);
                    GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                    GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
                    GlStateManager.rotate(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
                    GlStateManager.scale(OBFVAL_R63C4.get(), OBFVAL_R63C4.get(), OBFVAL_WcL1g.get());
                    GlStateManager.translate(0.0F, OBFVAL_G98DI.get(), 0.0F);
                    GlStateManager.disableLighting();
                    GlStateManager.depthMask(false);
                    GlStateManager.enableBlend();
                    GlStateManager.disableTexture2D();
                    GlStateManager.tryBlendFuncSeparate(OBFVAL_YQvrx.get(), OBFVAL_jff3L.get(), 1, 0);
                    int i = fontrenderer.getStringWidth(s) / OBFVAL_sV5Mm.get();
                    Tessellator tessellator = Tessellator.getInstance();
                    WorldRenderer worldrenderer = tessellator.getWorldRenderer();
                    worldrenderer.begin(OBFVAL_rf2Lq.get(), DefaultVertexFormats.POSITION_COLOR);
                    worldrenderer.pos((double)(-i - 1), OBFVAL_anqiJ.get(), 0.0D).color(0.0F, 0.0F, 0.0F, OBFVAL_SVRLp.get()).endVertex();
                    worldrenderer.pos((double)(-i - 1), OBFVAL_0zWzV.get(), 0.0D).color(0.0F, 0.0F, 0.0F, OBFVAL_SVRLp.get()).endVertex();
                    worldrenderer.pos((double)(i + 1), OBFVAL_0zWzV.get(), 0.0D).color(0.0F, 0.0F, 0.0F, OBFVAL_SVRLp.get()).endVertex();
                    worldrenderer.pos((double)(i + 1), OBFVAL_anqiJ.get(), 0.0D).color(0.0F, 0.0F, 0.0F, OBFVAL_SVRLp.get()).endVertex();
                    tessellator.draw();
                    GlStateManager.enableTexture2D();
                    GlStateManager.depthMask(true);
                    fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / OBFVAL_sV5Mm.get(), 0, OBFVAL_eDeDm.get());
                    GlStateManager.enableLighting();
                    GlStateManager.disableBlend();
                    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                    GlStateManager.popMatrix();
                }
                else
                {
                    this.renderOffsetLivingLabel(entity, x, y - (entity.isChild() ? (double)(entity.height / OBFVAL_0nKxT.get()) : 0.0D), z, s, OBFVAL_WcL1g.get(), d0);
                }
            }
        }
    }

    protected boolean canRenderName(T entity)
    {
        EntityPlayerSP entityplayersp = Minecraft.getMinecraft().thePlayer;
        boolean flag = !entity.isInvisibleToPlayer(entityplayersp);

        if (entity instanceof EntityPlayer && entity != entityplayersp)
        {
            Team team = entity.getTeam();
            Team team1 = entityplayersp.getTeam();

            if (team != null)
            {
                Team.EnumVisible team$enumvisible = team.getNameTagVisibility();

                switch (RendererLivingEntity.RendererLivingEntity$RendererLivingEntity$1.field_178679_a[team$enumvisible.ordinal()])
                {
                    case 1:
                        return flag;

                    case 2:
                        return false;

                    case 3:
                        return team1 == null ? flag : team.isSameTeam(team1) && (team.getSeeFriendlyInvisiblesEnabled() || flag);

                    case 4:
                        return team1 == null ? flag : !team.isSameTeam(team1) && flag;

                    default:
                        return true;
                }
            }
        }

        return Minecraft.isGuiEnabled() && entity != this.renderManager.livingPlayer && flag && entity.riddenByEntity == null;
    }

    public void setRenderOutlines(boolean renderOutlinesIn)
    {
        this.renderOutlines = renderOutlinesIn;
    }

    static
    {
        int[] aint = field_177096_e.getTextureData();

        for (int i = 0; i < 256; ++i)
        {
            aint[i] = -1;
        }

        field_177096_e.updateDynamicTexture();
        ObfValue.beginGeneration();
        OBFVAL_CC0tp = ObfValue.create(-1.0F);
        OBFVAL_WEsbr = ObfValue.create(360.0F);
        OBFVAL_EkNZu = ObfValue.create(16);
        OBFVAL_8nfqx = ObfValue.create(-180.0F);
        OBFVAL_YQvrx = ObfValue.create(770);
        OBFVAL_mNjk1 = ObfValue.create(0.15F);
        OBFVAL_9RlZu = ObfValue.create(8705);
        OBFVAL_pPLRE = ObfValue.create(24);
        OBFVAL_0Yagz = ObfValue.create(0.5F);
        OBFVAL_sV5Mm = ObfValue.create(2);
        OBFVAL_f3nJ6 = ObfValue.create(180.0F);
        OBFVAL_4MTep = ObfValue.create(4);
        OBFVAL_Sagdi = ObfValue.create(2500.0F);
        OBFVAL_XqQRH = ObfValue.create(1.6F);
        OBFVAL_cQcDD = ObfValue.create(85.0F);
        OBFVAL_kixb9 = ObfValue.create(90.0F);
        OBFVAL_QSNa9 = ObfValue.create(255);
        OBFVAL_f8CEv = ObfValue.create(16777215);
        OBFVAL_nFGPR = ObfValue.create(20.0F);
        OBFVAL_U48ME = ObfValue.create(3.0F);
        OBFVAL_WcL1g = ObfValue.create(0.02666667F);
        OBFVAL_eDeDm = ObfValue.create(553648127);
        OBFVAL_dAHMb = ObfValue.create(0.1F);
        OBFVAL_koZx0 = ObfValue.create(516);
        OBFVAL_KQLVW = ObfValue.create(-85.0F);
        OBFVAL_Irygb = ObfValue.create(255.0F);
        OBFVAL_0lEHr = ObfValue.create(8);
        OBFVAL_6LUYZ = ObfValue.create(5890);
        OBFVAL_anqiJ = ObfValue.create(-1.0D);
        OBFVAL_SVRLp = ObfValue.create(0.25F);
        OBFVAL_KhlQR = ObfValue.create(0.2F);
        OBFVAL_cq6dL = ObfValue.create(8960);
        OBFVAL_IFcir = ObfValue.create(0.003921569F);
        OBFVAL_nskd9 = ObfValue.create(-1.5078125F);
        OBFVAL_PnfPS = ObfValue.create(0.3F);
        OBFVAL_0nKxT = ObfValue.create(2.0F);
        OBFVAL_4ZK3E = ObfValue.create(768);
        OBFVAL_G98DI = ObfValue.create(9.374999F);
        OBFVAL_rf2Lq = ObfValue.create(7);
        OBFVAL_lR1DD = ObfValue.create(0.0625F);
        OBFVAL_R63C4 = ObfValue.create(-0.02666667F);
        OBFVAL_0zWzV = ObfValue.create(8.0D);
        OBFVAL_cJg57 = ObfValue.create(8448);
        OBFVAL_jff3L = ObfValue.create(771);
        OBFVAL_a9zRj = ObfValue.create(8704);
        OBFVAL_T0s2h = ObfValue.create(7681);
        ObfValue.endGeneration(new byte[] {(byte) - 110, (byte) - 3, (byte)103, (byte) - 42, (byte) - 5, (byte) - 50, (byte)26, (byte) - 40});
    }

    static final class RendererLivingEntity$RendererLivingEntity$1
    {
        static final int[] field_178679_a = new int[Team.EnumVisible.values().length];
        private static final String __OBFID = "CL_00002435";

        static
        {
            try
            {
                field_178679_a[Team.EnumVisible.ALWAYS.ordinal()] = 1;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                field_178679_a[Team.EnumVisible.NEVER.ordinal()] = 2;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                field_178679_a[Team.EnumVisible.HIDE_FOR_OTHER_TEAMS.ordinal()] = 3;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                field_178679_a[Team.EnumVisible.HIDE_FOR_OWN_TEAM.ordinal()] = 4;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
}
