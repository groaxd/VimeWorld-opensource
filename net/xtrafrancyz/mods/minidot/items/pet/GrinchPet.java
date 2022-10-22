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

public class GrinchPet extends BasePet
{
    private final MModelRenderer TheGrinch;
    private final MModelRenderer Head;
    private final MModelRenderer Hat;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer Body;
    private final MModelRenderer BodyWithoutHands;
    private final MModelRenderer Belly;
    private final MModelRenderer Torso;
    private final MModelRenderer Torso2;
    private final MModelRenderer Legs;
    private final MModelRenderer RightLeg;
    private final MModelRenderer bone14;
    private final MModelRenderer bone13;
    private final MModelRenderer LeftLeg;
    private final MModelRenderer bone15;
    private final MModelRenderer bone12;
    private final MModelRenderer Hands;
    private final MModelRenderer LeftArm;
    private final MModelRenderer RightArm;
    private final IAnimation animation;

    public GrinchPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.TheGrinch = new MModelRenderer(this);
        this.TheGrinch.setRotationPoint(1.0F, 3.0F, 0.0F);
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(-0.75F, -25.0F, 2.0F);
        this.TheGrinch.addChild(this.Head);
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 27, -5.25F, -4.0F, -4.0F, 10, 4, 7, 0.0F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 33, 7, -4.25F, -8.0F, -2.0F, 8, 7, 5, -0.001F, false));
        this.Hat = new MModelRenderer(this);
        this.Hat.setRotationPoint(0.75F, 25.0F, -2.0F);
        this.Head.addChild(this.Hat);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -34.5F, 2.0F);
        this.setRotation(this.bone, 0.0F, 0.0F, 0.0873F);
        this.Hat.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -6.0F, -1.0F, -4.0F, 10, 3, 9, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, -37.5F, 2.0F);
        this.setRotation(this.bone2, 0.0F, 0.0F, 0.0873F);
        this.Hat.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 27, 20, -4.0F, -3.0F, -3.0F, 7, 5, 7, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, -43.0F, 2.0F);
        this.setRotation(this.bone3, 0.0F, 0.0F, 0.2182F);
        this.Hat.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 29, 0, -1.5F, 0.0F, -1.0F, 11, 3, 2, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, -43.0F, 2.0F);
        this.setRotation(this.bone4, 0.0F, 0.0F, 0.2182F);
        this.Hat.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 34, 44, 9.5F, 0.75F, -2.0F, 3, 4, 4, 0.0F, false));
        this.Body = new MModelRenderer(this);
        this.TheGrinch.addChild(this.Body);
        this.BodyWithoutHands = new MModelRenderer(this);
        this.Body.addChild(this.BodyWithoutHands);
        this.Belly = new MModelRenderer(this);
        this.BodyWithoutHands.addChild(this.Belly);
        this.Belly.cubeList.add(new ModelBox(this.Belly, 0, 12, -5.5F, -20.0F, -3.0F, 9, 7, 8, 0.1F, false));
        this.Torso = new MModelRenderer(this);
        this.BodyWithoutHands.addChild(this.Torso);
        this.Torso.cubeList.add(new ModelBox(this.Torso, 0, 38, -5.0F, -25.0F, -1.0F, 8, 5, 5, 0.0F, false));
        this.Torso2 = new MModelRenderer(this);
        this.BodyWithoutHands.addChild(this.Torso2);
        this.Torso2.cubeList.add(new ModelBox(this.Torso2, 29, 33, -5.0F, -17.0F, -1.0F, 8, 6, 5, -0.01F, false));
        this.Legs = new MModelRenderer(this);
        this.BodyWithoutHands.addChild(this.Legs);
        this.RightLeg = new MModelRenderer(this);
        this.RightLeg.setRotationPoint(-3.0F, -11.0F, 2.0F);
        this.Legs.addChild(this.RightLeg);
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(3.0F, 11.0F, -2.0F);
        this.RightLeg.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 48, 19, -4.0F, -4.0F, -1.0F, 2, 1, 4, 0.0F, false));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(3.0F, 11.0F, -2.0F);
        this.RightLeg.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 8, 48, -4.0F, -13.0F, 1.0F, 2, 9, 2, 0.0F, false));
        this.LeftLeg = new MModelRenderer(this);
        this.LeftLeg.setRotationPoint(1.0F, -11.0F, 2.0F);
        this.BodyWithoutHands.addChild(this.LeftLeg);
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(-1.0F, 11.0F, -2.0F);
        this.LeftLeg.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 44, 48, 0.0F, -4.0F, -1.0F, 2, 1, 4, 0.0F, false));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(-1.0F, 11.0F, -2.0F);
        this.LeftLeg.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 0, 48, 0.0F, -13.0F, 1.0F, 2, 9, 2, 0.0F, false));
        this.Hands = new MModelRenderer(this);
        this.Body.addChild(this.Hands);
        this.LeftArm = new MModelRenderer(this);
        this.LeftArm.setRotationPoint(3.0F, -23.0F, 2.0F);
        this.setRotation(this.LeftArm, 0.0F, 0.0F, -0.1745F);
        this.Hands.addChild(this.LeftArm);
        this.LeftArm.cubeList.add(new ModelBox(this.LeftArm, 26, 44, 0.0F, -1.0F, -1.0F, 2, 14, 2, 0.0F, false));
        this.RightArm = new MModelRenderer(this);
        this.RightArm.setRotationPoint(-5.0F, -23.0F, 2.0F);
        this.setRotation(this.RightArm, 0.0F, 0.0F, 0.1745F);
        this.Hands.addChild(this.RightArm);
        this.RightArm.cubeList.add(new ModelBox(this.RightArm, 26, 44, -2.0F, -1.0F, -1.0F, 2, 14, 2, 0.0F, true));
        super.setTexture(new ResourceLocation("minidot", "pets/grinchpet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/grinchpet_animation.json"));
        this.animation = bbanimationloader.mustGet("grinch.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        GlStateManager.translate(1.25D, Math.sin((double)time * 0.05D) * 0.1D + 0.1D, 0.4D);
        double d0 = 0.7042D;
        GlStateManager.scale(d0, d0, d0);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        double d0 = 0.7042D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, 0.75D, 0.0D);
        super.renderAsItem(time);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.26F) * 0.05F;
        float f2 = MathHelper.cos(time * 0.16F);
        this.RightLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 2.0F + f1;
        this.RightLeg.rotationY = f * 2.0F;
        this.LeftLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 2.0F - f1;
        this.LeftLeg.rotationZ = f * 2.0F;
        this.LeftArm.rotationX = modelPlayer.bipedLeftArm.rotateAngleX / 1.2F + f2 * 0.1F;
        this.LeftArm.rotationY = -f2 * f * 2.0F;
        this.LeftArm.rotationZ = f2 * f * 4.0F;
        this.RightArm.rotationX = -this.LeftArm.rotationX;
        this.RightArm.rotationY = -this.LeftArm.rotationY;
        this.RightArm.rotationZ = this.LeftArm.rotationZ;
    }

    public String getName()
    {
        return "\u0413\u0440\u0438\u043d\u0447";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
