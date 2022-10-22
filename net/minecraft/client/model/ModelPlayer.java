package net.minecraft.client.model;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.xtrafrancyz.covered.ObfValue;

public class ModelPlayer extends ModelBiped
{
    private static final ObfValue.OFloat OBFVAL_n5Kzl = ObfValue.create(-5.0F);
    private static final ObfValue.OInteger OBFVAL_izVdB = ObfValue.create(32);
    private static final ObfValue.OFloat OBFVAL_6Xljm = ObfValue.create(0.0625F);
    private static final ObfValue.OFloat OBFVAL_hCPoG = ObfValue.create(-1.9F);
    private static final ObfValue.OFloat OBFVAL_2pxcJ = ObfValue.create(5.0F);
    private static final ObfValue.OFloat OBFVAL_3cZFx = ObfValue.create(0.2F);
    private static final ObfValue.OInteger OBFVAL_IRbu2 = ObfValue.create(24);
    private static final ObfValue.OInteger OBFVAL_oX4zK = ObfValue.create(48);
    private static final ObfValue.OInteger OBFVAL_aPzJv = ObfValue.create(6);
    private static final ObfValue.OInteger OBFVAL_COGKe = ObfValue.create(64);
    private static final ObfValue.OFloat OBFVAL_gbWP4 = ObfValue.create(-4.0F);
    private static final ObfValue.OFloat OBFVAL_uPteJ = ObfValue.create(-6.0F);
    private static final ObfValue.OInteger OBFVAL_AlvRw = ObfValue.create(40);
    private static final ObfValue.OFloat OBFVAL_V47n3 = ObfValue.create(-1.0F);
    private static final ObfValue.OInteger OBFVAL_un8HW = ObfValue.create(8);
    private static final ObfValue.OFloat OBFVAL_EEeSb = ObfValue.create(1.9F);
    private static final ObfValue.OInteger OBFVAL_lBJiO = ObfValue.create(10);
    private static final ObfValue.OFloat OBFVAL_FvFn7 = ObfValue.create(2.0F);
    private static final ObfValue.OFloat OBFVAL_pKh4I = ObfValue.create(-3.0F);
    private static final ObfValue.OFloat OBFVAL_stmLZ = ObfValue.create(0.25F);
    private static final ObfValue.OInteger OBFVAL_cVBfD = ObfValue.create(12);
    private static final ObfValue.OFloat OBFVAL_zFkoF = ObfValue.create(10.0F);
    private static final ObfValue.OInteger OBFVAL_yiH2M = ObfValue.create(3);
    private static final ObfValue.OFloat OBFVAL_B8wHT = ObfValue.create(24.0F);
    private static final ObfValue.OFloat OBFVAL_jgLnk = ObfValue.create(-2.0F);
    private static final ObfValue.OFloat OBFVAL_97NtA = ObfValue.create(12.0F);
    private static final ObfValue.OInteger OBFVAL_pNZk5 = ObfValue.create(16);
    private static final ObfValue.OFloat OBFVAL_1m7si = ObfValue.create(2.5F);
    private static final ObfValue.OInteger OBFVAL_i8LV9 = ObfValue.create(4);
    public ModelRenderer bipedLeftArmwear;
    public ModelRenderer bipedRightArmwear;
    public ModelRenderer bipedLeftLegwear;
    public ModelRenderer bipedRightLegwear;
    public ModelRenderer bipedBodyWear;
    private ModelRenderer bipedCape;
    private ModelRenderer bipedDeadmau5Head;
    private boolean smallArms;
    private static final String __OBFID = "CL_00002626";

    public ModelPlayer(float p_i46304_1_, boolean p_i46304_2_)
    {
        super(p_i46304_1_, 0.0F, OBFVAL_COGKe.get(), OBFVAL_COGKe.get());
        this.smallArms = p_i46304_2_;
        this.bipedDeadmau5Head = new ModelRenderer(this, OBFVAL_IRbu2.get(), 0);
        this.bipedDeadmau5Head.addBox(OBFVAL_pKh4I.get(), OBFVAL_uPteJ.get(), OBFVAL_V47n3.get(), OBFVAL_aPzJv.get(), OBFVAL_aPzJv.get(), 1, p_i46304_1_);
        this.bipedCape = new ModelRenderer(this, 0, 0);
        this.bipedCape.setTextureSize(OBFVAL_COGKe.get(), OBFVAL_izVdB.get());
        this.bipedCape.addBox(OBFVAL_n5Kzl.get(), 0.0F, OBFVAL_V47n3.get(), OBFVAL_lBJiO.get(), OBFVAL_pNZk5.get(), 1, p_i46304_1_);

        if (p_i46304_2_)
        {
            this.bipedLeftArm = new ModelRenderer(this, OBFVAL_izVdB.get(), OBFVAL_oX4zK.get());
            this.bipedLeftArm.addBox(OBFVAL_V47n3.get(), OBFVAL_jgLnk.get(), OBFVAL_jgLnk.get(), OBFVAL_yiH2M.get(), OBFVAL_cVBfD.get(), OBFVAL_i8LV9.get(), p_i46304_1_);
            this.bipedLeftArm.setRotationPoint(OBFVAL_2pxcJ.get(), OBFVAL_1m7si.get(), 0.0F);
            this.bipedRightArm = new ModelRenderer(this, OBFVAL_AlvRw.get(), OBFVAL_pNZk5.get());
            this.bipedRightArm.addBox(OBFVAL_jgLnk.get(), OBFVAL_jgLnk.get(), OBFVAL_jgLnk.get(), OBFVAL_yiH2M.get(), OBFVAL_cVBfD.get(), OBFVAL_i8LV9.get(), p_i46304_1_);
            this.bipedRightArm.setRotationPoint(OBFVAL_n5Kzl.get(), OBFVAL_1m7si.get(), 0.0F);
            this.bipedLeftArmwear = new ModelRenderer(this, OBFVAL_oX4zK.get(), OBFVAL_oX4zK.get());
            this.bipedLeftArmwear.addBox(OBFVAL_V47n3.get(), OBFVAL_jgLnk.get(), OBFVAL_jgLnk.get(), OBFVAL_yiH2M.get(), OBFVAL_cVBfD.get(), OBFVAL_i8LV9.get(), p_i46304_1_ + OBFVAL_stmLZ.get());
            this.bipedLeftArmwear.setRotationPoint(OBFVAL_2pxcJ.get(), OBFVAL_1m7si.get(), 0.0F);
            this.bipedRightArmwear = new ModelRenderer(this, OBFVAL_AlvRw.get(), OBFVAL_izVdB.get());
            this.bipedRightArmwear.addBox(OBFVAL_jgLnk.get(), OBFVAL_jgLnk.get(), OBFVAL_jgLnk.get(), OBFVAL_yiH2M.get(), OBFVAL_cVBfD.get(), OBFVAL_i8LV9.get(), p_i46304_1_ + OBFVAL_stmLZ.get());
            this.bipedRightArmwear.setRotationPoint(OBFVAL_n5Kzl.get(), OBFVAL_1m7si.get(), OBFVAL_zFkoF.get());
        }
        else
        {
            this.bipedLeftArm = new ModelRenderer(this, OBFVAL_izVdB.get(), OBFVAL_oX4zK.get());
            this.bipedLeftArm.addBox(OBFVAL_V47n3.get(), OBFVAL_jgLnk.get(), OBFVAL_jgLnk.get(), OBFVAL_i8LV9.get(), OBFVAL_cVBfD.get(), OBFVAL_i8LV9.get(), p_i46304_1_);
            this.bipedLeftArm.setRotationPoint(OBFVAL_2pxcJ.get(), OBFVAL_FvFn7.get(), 0.0F);
            this.bipedLeftArmwear = new ModelRenderer(this, OBFVAL_oX4zK.get(), OBFVAL_oX4zK.get());
            this.bipedLeftArmwear.addBox(OBFVAL_V47n3.get(), OBFVAL_jgLnk.get(), OBFVAL_jgLnk.get(), OBFVAL_i8LV9.get(), OBFVAL_cVBfD.get(), OBFVAL_i8LV9.get(), p_i46304_1_ + OBFVAL_stmLZ.get());
            this.bipedLeftArmwear.setRotationPoint(OBFVAL_2pxcJ.get(), OBFVAL_FvFn7.get(), 0.0F);
            this.bipedRightArmwear = new ModelRenderer(this, OBFVAL_AlvRw.get(), OBFVAL_izVdB.get());
            this.bipedRightArmwear.addBox(OBFVAL_pKh4I.get(), OBFVAL_jgLnk.get(), OBFVAL_jgLnk.get(), OBFVAL_i8LV9.get(), OBFVAL_cVBfD.get(), OBFVAL_i8LV9.get(), p_i46304_1_ + OBFVAL_stmLZ.get());
            this.bipedRightArmwear.setRotationPoint(OBFVAL_n5Kzl.get(), OBFVAL_FvFn7.get(), OBFVAL_zFkoF.get());
        }

        this.bipedLeftLeg = new ModelRenderer(this, OBFVAL_pNZk5.get(), OBFVAL_oX4zK.get());
        this.bipedLeftLeg.addBox(OBFVAL_jgLnk.get(), 0.0F, OBFVAL_jgLnk.get(), OBFVAL_i8LV9.get(), OBFVAL_cVBfD.get(), OBFVAL_i8LV9.get(), p_i46304_1_);
        this.bipedLeftLeg.setRotationPoint(OBFVAL_EEeSb.get(), OBFVAL_97NtA.get(), 0.0F);
        this.bipedLeftLegwear = new ModelRenderer(this, 0, OBFVAL_oX4zK.get());
        this.bipedLeftLegwear.addBox(OBFVAL_jgLnk.get(), 0.0F, OBFVAL_jgLnk.get(), OBFVAL_i8LV9.get(), OBFVAL_cVBfD.get(), OBFVAL_i8LV9.get(), p_i46304_1_ + OBFVAL_stmLZ.get());
        this.bipedLeftLegwear.setRotationPoint(OBFVAL_EEeSb.get(), OBFVAL_97NtA.get(), 0.0F);
        this.bipedRightLegwear = new ModelRenderer(this, 0, OBFVAL_izVdB.get());
        this.bipedRightLegwear.addBox(OBFVAL_jgLnk.get(), 0.0F, OBFVAL_jgLnk.get(), OBFVAL_i8LV9.get(), OBFVAL_cVBfD.get(), OBFVAL_i8LV9.get(), p_i46304_1_ + OBFVAL_stmLZ.get());
        this.bipedRightLegwear.setRotationPoint(OBFVAL_hCPoG.get(), OBFVAL_97NtA.get(), 0.0F);
        this.bipedBodyWear = new ModelRenderer(this, OBFVAL_pNZk5.get(), OBFVAL_izVdB.get());
        this.bipedBodyWear.addBox(OBFVAL_gbWP4.get(), 0.0F, OBFVAL_jgLnk.get(), OBFVAL_un8HW.get(), OBFVAL_cVBfD.get(), OBFVAL_i8LV9.get(), p_i46304_1_ + OBFVAL_stmLZ.get());
        this.bipedBodyWear.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale)
    {
        super.render(entityIn, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, scale);
        GlStateManager.pushMatrix();

        if (this.isChild)
        {
            float f = OBFVAL_FvFn7.get();
            GlStateManager.scale(1.0F / f, 1.0F / f, 1.0F / f);
            GlStateManager.translate(0.0F, OBFVAL_B8wHT.get() * scale, 0.0F);
            this.bipedLeftLegwear.render(scale);
            this.bipedRightLegwear.render(scale);
            this.bipedLeftArmwear.render(scale);
            this.bipedRightArmwear.render(scale);
            this.bipedBodyWear.render(scale);
        }
        else
        {
            if (entityIn.isSneaking())
            {
                GlStateManager.translate(0.0F, OBFVAL_3cZFx.get(), 0.0F);
            }

            this.bipedLeftLegwear.render(scale);
            this.bipedRightLegwear.render(scale);
            this.bipedLeftArmwear.render(scale);
            this.bipedRightArmwear.render(scale);
            this.bipedBodyWear.render(scale);
        }

        GlStateManager.popMatrix();
    }

    public void renderDeadmau5Head(float p_178727_1_)
    {
        copyModelAngles(this.bipedHead, this.bipedDeadmau5Head);
        this.bipedDeadmau5Head.rotationPointX = 0.0F;
        this.bipedDeadmau5Head.rotationPointY = 0.0F;
        this.bipedDeadmau5Head.render(p_178727_1_);
    }

    public void renderCape(float p_178728_1_)
    {
        this.bipedCape.render(p_178728_1_);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entityIn)
    {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, entityIn);
        copyModelAngles(this.bipedLeftLeg, this.bipedLeftLegwear);
        copyModelAngles(this.bipedRightLeg, this.bipedRightLegwear);
        copyModelAngles(this.bipedLeftArm, this.bipedLeftArmwear);
        copyModelAngles(this.bipedRightArm, this.bipedRightArmwear);
        copyModelAngles(this.bipedBody, this.bipedBodyWear);
    }

    public void renderRightArm()
    {
        this.bipedRightArm.render(OBFVAL_6Xljm.get());
        this.bipedRightArmwear.render(OBFVAL_6Xljm.get());
    }

    public void renderLeftArm()
    {
        this.bipedLeftArm.render(OBFVAL_6Xljm.get());
        this.bipedLeftArmwear.render(OBFVAL_6Xljm.get());
    }

    public void setInvisible(boolean invisible)
    {
        super.setInvisible(invisible);
        this.bipedLeftArmwear.showModel = invisible;
        this.bipedRightArmwear.showModel = invisible;
        this.bipedLeftLegwear.showModel = invisible;
        this.bipedRightLegwear.showModel = invisible;
        this.bipedBodyWear.showModel = invisible;
        this.bipedCape.showModel = invisible;
        this.bipedDeadmau5Head.showModel = invisible;
    }

    public void postRenderArm(float scale)
    {
        if (this.smallArms)
        {
            ++this.bipedRightArm.rotationPointX;
            this.bipedRightArm.postRender(scale);
            --this.bipedRightArm.rotationPointX;
        }
        else
        {
            this.bipedRightArm.postRender(scale);
        }
    }

    static
    {
        ObfValue.beginGeneration();
        ObfValue.endGeneration(new byte[] {(byte) - 28, (byte) - 96, (byte)32, (byte) - 19, (byte)47, (byte)83, (byte) - 77, (byte)88});
    }
}
