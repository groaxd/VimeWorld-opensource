package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class PersonaClown extends BasePet
{
    private final MModelRenderer main;
    private final MModelRenderer legs;
    private final MModelRenderer rightLeg;
    private final MModelRenderer rl1;
    private final MModelRenderer rl2;
    private final MModelRenderer leftLeg;
    private final MModelRenderer ll1;
    private final MModelRenderer ll2;
    private final MModelRenderer ears;
    private final MModelRenderer leftEar;
    private final MModelRenderer l2;
    private final MModelRenderer l1;
    private final MModelRenderer rightEar;
    private final MModelRenderer r1;
    private final MModelRenderer r2;
    private final MModelRenderer body;
    private final MModelRenderer arms;
    private final MModelRenderer rightArm;
    private final MModelRenderer la5;
    private final MModelRenderer la6;
    private final MModelRenderer la7;
    private final MModelRenderer la8;
    private final MModelRenderer leftArm;
    private final MModelRenderer la1;
    private final MModelRenderer la4;
    private final MModelRenderer la3;
    private final MModelRenderer la2;
    private final MModelRenderer nose;
    private final MModelRenderer hair;
    private final IAnimation anim;

    public PersonaClown()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.main = new MModelRenderer(this);
        this.main.setRotationPoint(0.0F, 24.0F, 2.6F);
        this.setRotation(this.main, 0.0F, 3.1416F, 0.0F);
        this.legs = new MModelRenderer(this);
        this.legs.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.main.addChild(this.legs);
        this.rightLeg = new MModelRenderer(this);
        this.rightLeg.setRotationPoint(-2.0F, -4.0F, 2.2F);
        this.legs.addChild(this.rightLeg);
        this.setRotation(this.rightLeg, -0.2618F, 0.0F, 0.2182F);
        this.rl1 = new MModelRenderer(this);
        this.rl1.setRotationPoint(1.0F, 0.0F, -1.0F);
        this.rightLeg.addChild(this.rl1);
        this.setRotation(this.rl1, 0.0F, 0.0F, 0.48F);
        this.rl1.setTextureOffset(36, 15).addBox(-1.0F, -1.0F, 0.0F, 2, 5, 2, 3.0E-4F);
        this.rl2 = new MModelRenderer(this);
        this.rl2.setRotationPoint(0.0F, 4.0F, -1.0F);
        this.rightLeg.addChild(this.rl2);
        this.rl2.setTextureOffset(8, 36).addBox(-2.0F, -5.0F, 0.0F, 2, 5, 2, 0.0F);
        this.leftLeg = new MModelRenderer(this);
        this.leftLeg.setRotationPoint(2.2F, -3.6F, 2.5F);
        this.legs.addChild(this.leftLeg);
        this.setRotation(this.leftLeg, 0.1745F, -0.1745F, -0.7854F);
        this.ll1 = new MModelRenderer(this);
        this.ll1.setRotationPoint(1.0F, 0.0F, -1.0F);
        this.leftLeg.addChild(this.ll1);
        this.setRotation(this.ll1, 0.0F, 0.0F, 0.48F);
        this.ll1.setTextureOffset(0, 36).addBox(-1.0F, -1.0F, 0.0F, 2, 5, 2, 3.0E-4F);
        this.ll2 = new MModelRenderer(this);
        this.ll2.setRotationPoint(0.0F, 4.0F, -1.0F);
        this.leftLeg.addChild(this.ll2);
        this.ll2.setTextureOffset(32, 35).addBox(-1.7344F, -5.9136F, -3.0E-4F, 2, 5, 2, 3.0E-4F);
        this.ears = new MModelRenderer(this);
        this.ears.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.main.addChild(this.ears);
        this.leftEar = new MModelRenderer(this);
        this.leftEar.setRotationPoint(2.8F, -13.7F, 2.4F);
        this.ears.addChild(this.leftEar);
        this.setRotation(this.leftEar, 0.0F, -0.2182F, 0.1745F);
        this.l2 = new MModelRenderer(this);
        this.l2.setRotationPoint(-0.1F, -0.5F, -0.4F);
        this.leftEar.addChild(this.l2);
        this.setRotation(this.l2, 0.0F, 0.0F, 0.1745F);
        this.l2.setTextureOffset(40, 33).addBox(-0.5176F, -1.9319F, 0.0F, 2, 5, 1, 0.0F);
        this.l1 = new MModelRenderer(this);
        this.l1.setRotationPoint(-0.1F, -0.5F, -0.4F);
        this.leftEar.addChild(this.l1);
        this.setRotation(this.l1, 0.0F, 0.0F, -0.0873F);
        this.l1.setTextureOffset(32, 42).addBox(-1.0F, -2.0F, 0.0F, 1, 5, 1, 3.0E-4F);
        this.rightEar = new MModelRenderer(this);
        this.rightEar.setRotationPoint(-1.8F, -14.0F, 2.4F);
        this.ears.addChild(this.rightEar);
        this.setRotation(this.rightEar, 0.0F, 0.2618F, -0.3927F);
        this.r1 = new MModelRenderer(this);
        this.r1.setRotationPoint(-0.1F, -0.5F, -0.4F);
        this.rightEar.addChild(this.r1);
        this.setRotation(this.r1, 0.0F, 0.0F, -0.0873F);
        this.r1.setTextureOffset(39, 27).addBox(-2.3525F, -2.2085F, -3.0E-4F, 2, 5, 1, 0.0F);
        this.r2 = new MModelRenderer(this);
        this.r2.setRotationPoint(-0.1F, -0.5F, -0.4F);
        this.rightEar.addChild(this.r2);
        this.setRotation(this.r2, 0.0F, 0.0F, 0.2182F);
        this.r2.setTextureOffset(40, 39).addBox(-1.0F, -2.0F, 0.0F, 1, 5, 1, 3.0E-4F);
        this.body = new MModelRenderer(this);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.main.addChild(this.body);
        this.body.setTextureOffset(0, 0).addBox(-5.0F, -13.0F, 0.0F, 10, 10, 5, 0.0F);
        this.body.setTextureOffset(18, 15).addBox(-4.0F, -12.0F, -0.6F, 8, 8, 1, 0.0F);
        this.body.setTextureOffset(0, 15).addBox(-4.0F, -12.0F, 4.4F, 8, 8, 1, 0.1F);
        this.body.setTextureOffset(30, 4).addBox(-3.0F, -3.0F, 1.0F, 6, 1, 3, 0.0F);
        this.body.setTextureOffset(25, 0).addBox(-3.0F, -14.0F, 1.0F, 6, 1, 3, 0.0F);
        this.body.setTextureOffset(24, 35).addBox(5.0F, -12.0F, 1.0F, 1, 8, 3, 0.0F);
        this.body.setTextureOffset(16, 32).addBox(-6.0F, -12.0F, 1.0F, 1, 8, 3, 0.0F);
        this.arms = new MModelRenderer(this);
        this.arms.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.main.addChild(this.arms);
        this.rightArm = new MModelRenderer(this);
        this.rightArm.setRotationPoint(5.5F, -6.7F, -0.5F);
        this.arms.addChild(this.rightArm);
        this.setRotation(this.rightArm, 0.0873F, -3.0107F, 0.5672F);
        this.la5 = new MModelRenderer(this);
        this.la5.setRotationPoint(3.0F, 1.5F, -0.5F);
        this.rightArm.addChild(this.la5);
        this.la5.setTextureOffset(25, 24).addBox(-7.0F, -2.0F, 0.0F, 7, 2, 1, 3.0E-4F);
        this.la6 = new MModelRenderer(this);
        this.la6.setRotationPoint(1.9F, -1.3F, -0.5F);
        this.rightArm.addChild(this.la6);
        this.la6.setTextureOffset(11, 31).addBox(-1.9569F, 0.1814F, 0.0F, 2, 1, 1, 0.0F);
        this.la7 = new MModelRenderer(this);
        this.la7.setRotationPoint(3.0F, -0.5F, -0.5F);
        this.rightArm.addChild(this.la7);
        this.setRotation(this.la7, 0.0F, 0.0F, 1.0036F);
        this.la7.setTextureOffset(11, 27).addBox(-1.9569F, 0.1814F, 0.0F, 2, 1, 1, 0.0F);
        this.la8 = new MModelRenderer(this);
        this.la8.setRotationPoint(3.0F, -0.5F, -0.5F);
        this.rightArm.addChild(this.la8);
        this.setRotation(this.la8, 0.0F, 0.0F, -0.2618F);
        this.la8.setTextureOffset(30, 11).addBox(-6.7615F, -1.8117F, 0.0F, 6, 1, 1, 0.0F);
        this.leftArm = new MModelRenderer(this);
        this.leftArm.setRotationPoint(-5.7F, -6.7F, -0.5F);
        this.arms.addChild(this.leftArm);
        this.setRotation(this.leftArm, 0.3927F, -0.0873F, -0.5672F);
        this.la1 = new MModelRenderer(this);
        this.la1.setRotationPoint(3.0F, 1.5F, -0.5F);
        this.leftArm.addChild(this.la1);
        this.la1.setTextureOffset(30, 8).addBox(-7.0F, -2.0F, 0.0F, 7, 2, 1, 3.0E-4F);
        this.la4 = new MModelRenderer(this);
        this.la4.setRotationPoint(1.9F, -1.3F, -0.5F);
        this.leftArm.addChild(this.la4);
        this.la4.setTextureOffset(11, 33).addBox(-1.9569F, 0.1814F, 0.0F, 2, 1, 1, 0.0F);
        this.la3 = new MModelRenderer(this);
        this.la3.setRotationPoint(3.0F, -0.5F, -0.5F);
        this.leftArm.addChild(this.la3);
        this.setRotation(this.la3, 0.0F, 0.0F, 1.0036F);
        this.la3.setTextureOffset(36, 22).addBox(-1.9569F, 0.1814F, 0.0F, 2, 1, 1, 0.0F);
        this.la2 = new MModelRenderer(this);
        this.la2.setRotationPoint(3.0F, -0.5F, -0.5F);
        this.leftArm.addChild(this.la2);
        this.setRotation(this.la2, 0.0F, 0.0F, -0.2618F);
        this.la2.setTextureOffset(30, 13).addBox(-6.7615F, -1.8117F, 0.0F, 6, 1, 1, 0.0F);
        this.nose = new MModelRenderer(this);
        this.nose.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.main.addChild(this.nose);
        this.nose.setTextureOffset(11, 24).addBox(-1.0F, -8.5F, 5.3F, 2, 2, 1, -0.1F);
        this.hair = new MModelRenderer(this);
        this.hair.setRotationPoint(0.0F, 0.0F, -0.2F);
        this.main.addChild(this.hair);
        this.hair.setTextureOffset(0, 30).addBox(-5.2F, -13.5F, 0.1F, 3, 1, 5, 0.15F);
        this.hair.setTextureOffset(25, 27).addBox(-6.5F, -13.0F, 0.1F, 2, 3, 5, 0.0F);
        this.hair.setTextureOffset(0, 24).addBox(2.1F, -13.5F, 0.1F, 3, 1, 5, 0.15F);
        this.hair.setTextureOffset(16, 24).addBox(4.5F, -13.0F, 0.1F, 2, 3, 5, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/personaclown.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/personaclown_animation.json"));
        this.anim = bbanimationloader.mustGet("clown.flight", this);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        GlStateManager.translate(0.87F, -1.0F + f, 0.3F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.7F, 0.0F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.anim.tick(time);
    }

    public String getName()
    {
        return "\u041a\u043b\u043e\u0443\u043d";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.RED + "" + EnumChatFormatting.BOLD + "1 \u0430\u043f\u0440\u0435\u043b\u044f");
    }
}
