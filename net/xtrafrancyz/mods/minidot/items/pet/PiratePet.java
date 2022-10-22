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

public class PiratePet extends BasePet
{
    private final MModelRenderer pirate;
    private final MModelRenderer head;
    private final MModelRenderer hat;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer bone5;
    private final MModelRenderer body;
    private final MModelRenderer arms;
    private final MModelRenderer r_arm;
    private final MModelRenderer l_arm;
    private final MModelRenderer base;
    private final MModelRenderer legs;
    private final MModelRenderer l_leg;
    private final MModelRenderer r_leg;
    private final MModelRenderer bone8;
    private final MModelRenderer bone4;
    private final IAnimation animation;

    public PiratePet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.pirate = new MModelRenderer(this);
        this.pirate.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(-4.0F, -12.0F, 4.0F);
        this.pirate.addChild(this.head);
        this.head.cubeList.add(new ModelBox(this.head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 0, 6, -0.5F, -2.5F, -4.75F, 1, 1, 1, -0.1F, false));
        this.hat = new MModelRenderer(this);
        this.hat.setRotationPoint(-15.0F, 13.0F, -1.0F);
        this.head.addChild(this.hat);
        this.hat.cubeList.add(new ModelBox(this.hat, 24, 0, 12.0F, -25.0F, -2.0F, 6, 1, 6, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 0, 16, 11.0F, -24.0F, -3.0F, 8, 3, 8, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(11.0F, -21.0F, 1.0F);
        this.setRotation(this.bone3, 0.0F, 0.0F, -0.1745F);
        this.hat.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 30, -1.0F, -4.0F, -3.0F, 1, 1, 6, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 24, 8, -1.0F, -3.0F, -4.0F, 1, 3, 8, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(19.0F, -21.0F, 1.0F);
        this.setRotation(this.bone2, 0.0F, 0.0F, 0.1745F);
        this.hat.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 34, 19, 0.0F, -4.0F, -3.0F, 1, 1, 6, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 24, 19, 0.0F, -3.0F, -4.0F, 1, 3, 8, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(15.0F, -20.8F, -4.0F);
        this.setRotation(this.bone, 0.1745F, 0.0F, 0.0F);
        this.hat.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 17, 36, -3.0F, -6.0F, 0.0F, 6, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 16, 30, -5.0F, -5.0F, 0.0F, 10, 5, 1, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-16.0F, 20.8F, 7.0F);
        this.bone.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 0, 15.0F, -22.0F, -8.0F, 2, 1, 1, 0.0F, false));
        this.bone5.cubeList.add(new ModelBox(this.bone5, 40, 30, 14.0F, -25.0F, -8.0F, 4, 3, 1, 0.0F, false));
        this.body = new MModelRenderer(this);
        this.body.setRotationPoint(-4.0F, -12.0F, 4.0F);
        this.pirate.addChild(this.body);
        this.arms = new MModelRenderer(this);
        this.arms.setRotationPoint(4.0F, 12.0F, -4.0F);
        this.body.addChild(this.arms);
        this.r_arm = new MModelRenderer(this);
        this.r_arm.setRotationPoint(-6.0F, -12.0F, 4.0F);
        this.arms.addChild(this.r_arm);
        this.r_arm.cubeList.add(new ModelBox(this.r_arm, 10, 36, -2.0F, 0.0F, -1.75F, 2, 5, 3, 0.0F, false));
        this.l_arm = new MModelRenderer(this);
        this.l_arm.setRotationPoint(-2.0F, -12.0F, 4.0F);
        this.arms.addChild(this.l_arm);
        this.l_arm.cubeList.add(new ModelBox(this.l_arm, 20, 39, 0.0F, 0.0F, -1.75F, 2, 2, 3, 0.0F, false));
        this.l_arm.cubeList.add(new ModelBox(this.l_arm, 28, 37, 0.0F, 2.0F, -1.75F, 2, 2, 3, 0.1F, false));
        this.l_arm.cubeList.add(new ModelBox(this.l_arm, 0, 0, 1.0F, 4.0F, -1.75F, 0, 3, 3, 0.0F, false));
        this.base = new MModelRenderer(this);
        this.base.setRotationPoint(4.0F, 12.0F, -4.0F);
        this.body.addChild(this.base);
        this.base.cubeList.add(new ModelBox(this.base, 34, 7, -6.0F, -12.0F, 2.25F, 4, 5, 3, 0.0F, false));
        this.legs = new MModelRenderer(this);
        this.legs.setRotationPoint(4.0F, 12.0F, -4.0F);
        this.body.addChild(this.legs);
        this.l_leg = new MModelRenderer(this);
        this.l_leg.setRotationPoint(-3.0F, -7.0F, 4.0F);
        this.legs.addChild(this.l_leg);
        this.l_leg.cubeList.add(new ModelBox(this.l_leg, 0, 35, -1.0F, 0.0F, -1.75F, 2, 5, 3, 0.0F, false));
        this.r_leg = new MModelRenderer(this);
        this.r_leg.setRotationPoint(-5.0F, -7.0F, 4.0F);
        this.legs.addChild(this.r_leg);
        this.r_leg.cubeList.add(new ModelBox(this.r_leg, 38, 37, -1.0F, 0.0F, -1.75F, 2, 2, 3, 0.0F, false));
        this.r_leg.cubeList.add(new ModelBox(this.r_leg, 42, 0, -1.0F, 2.0F, -1.75F, 2, 1, 3, 0.1F, false));
        this.r_leg.cubeList.add(new ModelBox(this.r_leg, 0, 16, -0.5F, 3.0F, -0.75F, 1, 2, 1, 0.1F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-2.0F, 3.0F, -1.0F);
        this.setRotation(this.bone8, -0.7873F, -0.0617F, 0.0618F);
        this.body.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 19, 0.0F, -5.0F, -1.0F, 0, 8, 8, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(10.0F, -16.0F, 4.0F);
        this.pirate.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 57, -9.0F, -4.0F, 0.0F, 20, 7, 0, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/piratepet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/piratepet_animation.json"));
        this.animation = bbanimationloader.mustGet("piratepet.animation", this);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.animation.tick(time);
        float f = MathHelper.sin(time * 0.16F) * 0.04F;
        GlStateManager.translate(0.8F, f, 0.3F);
        float f1 = 0.9F;
        GlStateManager.scale(f1, f1, f1);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0F, 0.36288F, 0.0F);
        float f = 0.75F;
        GlStateManager.scale(f, f, f);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u0438\u0440\u0430\u0442";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
