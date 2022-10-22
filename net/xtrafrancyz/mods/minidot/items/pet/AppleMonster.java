package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class AppleMonster extends BasePet
{
    private final MModelRenderer AppleMonster;
    private final MModelRenderer legside1;
    private final MModelRenderer leg1_1;
    private final MModelRenderer leg1_2;
    private final MModelRenderer leg2_1;
    private final MModelRenderer leg2_2;
    private final MModelRenderer leg3_1;
    private final MModelRenderer leg3_2;
    private final MModelRenderer leg4_1;
    private final MModelRenderer leg4_2;
    private final MModelRenderer legside3;
    private final MModelRenderer leg1_5;
    private final MModelRenderer leg1_6;
    private final MModelRenderer leg2_5;
    private final MModelRenderer leg2_6;
    private final MModelRenderer leg3_5;
    private final MModelRenderer leg3_6;
    private final MModelRenderer leg4_5;
    private final MModelRenderer leg4_6;
    private final MModelRenderer bone;
    private final MModelRenderer bb_main;
    private final IAnimation animation;

    public AppleMonster()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.AppleMonster = new MModelRenderer(this);
        this.legside1 = new MModelRenderer(this);
        this.legside1.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.setRotation(this.legside1, 0.0F, 0.0F, 0.2618F);
        this.AppleMonster.addChild(this.legside1);
        this.leg1_1 = new MModelRenderer(this);
        this.leg1_1.setRotationPoint(6.1745F, -7.8661F, -6.0F);
        this.legside1.addChild(this.leg1_1);
        this.leg1_1.cubeList.add(new ModelBox(this.leg1_1, 48, 12, -3.7117F, -1.7419F, -1.0F, 12, 2, 2, 0.0F, false));
        this.leg1_2 = new MModelRenderer(this);
        this.leg1_2.setRotationPoint(7.2791F, -0.8799F, 0.0F);
        this.setRotation(this.leg1_2, 0.0F, 0.0F, -0.0873F);
        this.leg1_1.addChild(this.leg1_2);
        this.leg1_2.cubeList.add(new ModelBox(this.leg1_2, 0, 32, -1.2189F, -0.0798F, -1.0F, 2, 6, 2, -0.1F, false));
        this.leg2_1 = new MModelRenderer(this);
        this.leg2_1.setRotationPoint(6.1745F, -7.8661F, -2.0F);
        this.legside1.addChild(this.leg2_1);
        this.leg2_1.cubeList.add(new ModelBox(this.leg2_1, 48, 32, -3.7117F, -1.7419F, -1.0F, 12, 2, 2, 0.0F, false));
        this.leg2_2 = new MModelRenderer(this);
        this.leg2_2.setRotationPoint(7.2791F, -0.8799F, 0.0F);
        this.setRotation(this.leg2_2, 0.0F, 0.0F, -0.0873F);
        this.leg2_1.addChild(this.leg2_2);
        this.leg2_2.cubeList.add(new ModelBox(this.leg2_2, 48, 52, -1.2189F, -0.0798F, -1.0F, 2, 6, 2, -0.1F, false));
        this.leg3_1 = new MModelRenderer(this);
        this.leg3_1.setRotationPoint(5.2086F, -7.6073F, 2.0F);
        this.legside1.addChild(this.leg3_1);
        this.leg3_1.cubeList.add(new ModelBox(this.leg3_1, 48, 28, -2.7457F, -2.0007F, -1.0F, 12, 2, 2, 0.0F, false));
        this.leg3_2 = new MModelRenderer(this);
        this.leg3_2.setRotationPoint(8.245F, -1.1387F, 0.0F);
        this.setRotation(this.leg3_2, 0.0F, 0.0F, -0.0873F);
        this.leg3_1.addChild(this.leg3_2);
        this.leg3_2.cubeList.add(new ModelBox(this.leg3_2, 0, 48, -1.2189F, -0.0798F, -1.0F, 2, 6, 2, -0.1F, false));
        this.leg4_1 = new MModelRenderer(this);
        this.leg4_1.setRotationPoint(6.1745F, -7.8661F, 6.0F);
        this.legside1.addChild(this.leg4_1);
        this.leg4_1.cubeList.add(new ModelBox(this.leg4_1, 48, 24, -3.7117F, -1.7419F, -1.0F, 12, 2, 2, 0.0F, false));
        this.leg4_2 = new MModelRenderer(this);
        this.leg4_2.setRotationPoint(7.2791F, -0.8799F, 0.0F);
        this.setRotation(this.leg4_2, 0.0F, 0.0F, -0.0873F);
        this.leg4_1.addChild(this.leg4_2);
        this.leg4_2.cubeList.add(new ModelBox(this.leg4_2, 8, 32, -1.2189F, -0.0798F, -1.0F, 2, 6, 2, -0.1F, false));
        this.legside3 = new MModelRenderer(this);
        this.legside3.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.setRotation(this.legside3, 0.0F, 0.0F, -0.2618F);
        this.AppleMonster.addChild(this.legside3);
        this.leg1_5 = new MModelRenderer(this);
        this.leg1_5.setRotationPoint(-6.1745F, -7.8661F, -6.0F);
        this.legside3.addChild(this.leg1_5);
        this.leg1_5.cubeList.add(new ModelBox(this.leg1_5, 48, 12, -8.2883F, -1.7419F, -1.0F, 12, 2, 2, 0.0F, true));
        this.leg1_6 = new MModelRenderer(this);
        this.leg1_6.setRotationPoint(-7.2791F, -0.8799F, 0.0F);
        this.setRotation(this.leg1_6, 0.0F, 0.0F, 0.0873F);
        this.leg1_5.addChild(this.leg1_6);
        this.leg1_6.cubeList.add(new ModelBox(this.leg1_6, 0, 32, -0.7811F, -0.0798F, -1.0F, 2, 6, 2, -0.1F, true));
        this.leg2_5 = new MModelRenderer(this);
        this.leg2_5.setRotationPoint(-6.1745F, -7.8661F, -2.0F);
        this.legside3.addChild(this.leg2_5);
        this.leg2_5.cubeList.add(new ModelBox(this.leg2_5, 48, 32, -8.2883F, -1.7419F, -1.0F, 12, 2, 2, 0.0F, true));
        this.leg2_6 = new MModelRenderer(this);
        this.leg2_6.setRotationPoint(-7.2791F, -0.8799F, 0.0F);
        this.setRotation(this.leg2_6, 0.0F, 0.0F, 0.0873F);
        this.leg2_5.addChild(this.leg2_6);
        this.leg2_6.cubeList.add(new ModelBox(this.leg2_6, 48, 52, -0.7811F, -0.0798F, -1.0F, 2, 6, 2, -0.1F, true));
        this.leg3_5 = new MModelRenderer(this);
        this.leg3_5.setRotationPoint(-5.2086F, -7.6073F, 2.0F);
        this.legside3.addChild(this.leg3_5);
        this.leg3_5.cubeList.add(new ModelBox(this.leg3_5, 48, 28, -9.2543F, -2.0007F, -1.0F, 12, 2, 2, 0.0F, true));
        this.leg3_6 = new MModelRenderer(this);
        this.leg3_6.setRotationPoint(-8.245F, -1.1387F, 0.0F);
        this.setRotation(this.leg3_6, 0.0F, 0.0F, 0.0873F);
        this.leg3_5.addChild(this.leg3_6);
        this.leg3_6.cubeList.add(new ModelBox(this.leg3_6, 0, 48, -0.7811F, -0.0798F, -1.0F, 2, 6, 2, -0.1F, true));
        this.leg4_5 = new MModelRenderer(this);
        this.leg4_5.setRotationPoint(-6.1745F, -7.8661F, 6.0F);
        this.legside3.addChild(this.leg4_5);
        this.leg4_5.cubeList.add(new ModelBox(this.leg4_5, 48, 24, -8.2883F, -1.7419F, -1.0F, 12, 2, 2, 0.0F, true));
        this.leg4_6 = new MModelRenderer(this);
        this.leg4_6.setRotationPoint(-7.2791F, -0.8799F, 0.0F);
        this.setRotation(this.leg4_6, 0.0F, 0.0F, 0.0873F);
        this.leg4_5.addChild(this.leg4_6);
        this.leg4_6.cubeList.add(new ModelBox(this.leg4_6, 8, 32, -0.7811F, -0.0798F, -1.0F, 2, 6, 2, -0.1F, true));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -14.0F, 8.0F);
        this.setRotation(this.bone, -0.3491F, 0.0F, 0.0F);
        this.AppleMonster.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -8.0F, -5.3468F, -16.0611F, 16, 8, 16, 0.1F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 10, -1.0F, -9.4654F, -8.3743F, 2, 4, 0, 0.1F, false));
        this.bb_main = new MModelRenderer(this);
        this.AppleMonster.addChild(this.bb_main);
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 24, -8.0F, -14.0F, -8.0F, 16, 8, 16, 0.0F, false));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 48, -8.0F, -16.75F, -8.0F, 16, 3, 8, -0.25F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/applemonster.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/applemonster_animation.json"));
        this.animation = bbanimationloader.mustGet("applemonster", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        float f = MathHelper.sin(time * 0.1F) * 0.09F;
        double d0 = 0.5D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(2.4D, -0.75D + (double)f, 0.8D);
        this.animation.tick(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        double d0 = 0.6D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, 0.35D, 0.0D);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u042f\u0431\u043b\u043e\u0447\u043d\u044b\u0439 \u043c\u043e\u043d\u0441\u0442\u0440";
    }

    public String getCreator()
    {
        return "TheLuxure & Sir_Kelt";
    }
}
