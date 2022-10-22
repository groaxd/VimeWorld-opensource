package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class PlagueBringerPet extends BasePet
{
    private final MModelRenderer Plaguebringer;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer head;
    private final MModelRenderer eye;
    private final MModelRenderer eye2;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer antena;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer light;
    private final MModelRenderer slush;
    private final MModelRenderer arms;
    private final MModelRenderer bone11;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final MModelRenderer bone16;
    private final MModelRenderer bone17;
    private final MModelRenderer arms2;
    private final MModelRenderer bone18;
    private final MModelRenderer bone19;
    private final MModelRenderer bone20;
    private final MModelRenderer bone21;
    private final MModelRenderer bone22;
    private final MModelRenderer bone23;
    private final MModelRenderer bone24;
    private final MModelRenderer bone25;
    private final MModelRenderer bone26;
    private final MModelRenderer wings;
    private final MModelRenderer right;
    private final MModelRenderer bone27;
    private final MModelRenderer left;
    private final MModelRenderer bone28;
    private final IAnimation anim;

    public PlagueBringerPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Plaguebringer = new MModelRenderer(this);
        this.Plaguebringer.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Plaguebringer.setTextureOffset(22, 12).addBox(-1.0F, -14.0F, 0.75F, 2, 2, 1, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(2.0F, -8.0F, 0.0F);
        this.Plaguebringer.addChild(this.bone);
        this.bone.setTextureOffset(0, 17).addBox(-4.0F, -4.0F, 0.0F, 4, 4, 3, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(2.0F, -4.5F, 0.75F);
        this.Plaguebringer.addChild(this.bone2);
        this.setRotation(this.bone2, -0.5236F, 0.0F, 0.0F);
        this.bone2.setTextureOffset(15, 5).addBox(-4.0F, -3.8743F, -2.661F, 4, 4, 3, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(1.0F, -3.25F, 0.0F);
        this.Plaguebringer.addChild(this.bone3);
        this.setRotation(this.bone3, -0.9163F, 0.0F, 0.0F);
        this.bone3.setTextureOffset(6, 24).addBox(-0.5F, -0.8743F, -2.661F, 1, 3, 2, 0.0F);
        this.bone3.setTextureOffset(0, 24).addBox(-2.5F, -0.8743F, -2.661F, 1, 3, 2, 0.0F);
        this.bone3.setTextureOffset(29, 26).addBox(-2.5F, 1.9672F, -2.0154F, 1, 1, 1, 0.0F);
        this.bone3.setTextureOffset(29, 24).addBox(-0.5F, 1.9672F, -2.0154F, 1, 1, 1, 0.0F);
        this.bone3.setTextureOffset(0, 0).addBox(-1.5F, -0.7764F, -1.9175F, 1, 3, 1, 0.0F);
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(0.0F, -12.75F, 0.5F);
        this.Plaguebringer.addChild(this.head);
        this.setRotation(this.head, 0.1309F, 0.0F, 0.0F);
        this.head.setTextureOffset(0, 0).addBox(-2.5F, -4.0F, -1.25F, 5, 4, 4, 0.0F);
        this.head.setTextureOffset(28, 29).addBox(1.5F, 0.0F, -1.25F, 1, 2, 1, 0.0F);
        this.eye = new MModelRenderer(this);
        this.eye.setRotationPoint(2.3F, 0.4F, -1.25F);
        this.head.addChild(this.eye);
        this.setRotation(this.eye, 0.0F, 0.0F, 0.0873F);
        this.eye.setTextureOffset(24, 19).addBox(-5.25F, -2.75F, -0.5F, 2, 2, 1, 0.0F);
        this.eye2 = new MModelRenderer(this);
        this.eye2.setRotationPoint(-2.3F, 0.4F, -1.25F);
        this.head.addChild(this.eye2);
        this.setRotation(this.eye2, 0.0F, 0.0F, -0.0873F);
        this.eye2.setTextureOffset(12, 24).addBox(3.25F, -2.75F, -0.5F, 2, 2, 1, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(2.5F, 2.0F, -1.25F);
        this.head.addChild(this.bone4);
        this.bone4.setTextureOffset(20, 29).addBox(-1.0F, -2.5F, 1.0F, 1, 2, 1, 0.0F);
        this.bone4.setTextureOffset(29, 8).addBox(-1.0F, -2.0F, 2.0F, 1, 1, 1, 0.0F);
        this.bone4.setTextureOffset(29, 2).addBox(-1.25F, -2.5F, 0.0F, 1, 1, 1, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-2.5F, 2.0F, -1.25F);
        this.head.addChild(this.bone5);
        this.bone5.setTextureOffset(16, 29).addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.bone5.setTextureOffset(12, 29).addBox(0.0F, -2.5F, 1.0F, 1, 2, 1, 0.0F);
        this.bone5.setTextureOffset(28, 22).addBox(0.0F, -2.0F, 2.0F, 1, 1, 1, 0.0F);
        this.bone5.setTextureOffset(4, 24).addBox(0.25F, -2.5F, 0.0F, 1, 1, 1, 0.0F);
        this.antena = new MModelRenderer(this);
        this.antena.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.head.addChild(this.antena);
        this.antena.setTextureOffset(22, 22).addBox(-1.0F, -17.5F, -0.5F, 2, 1, 2, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.5F, -17.5F, 0.0F);
        this.antena.addChild(this.bone6);
        this.setRotation(this.bone6, 0.3054F, 0.0F, 0.0F);
        this.bone6.setTextureOffset(8, 29).addBox(-1.0F, -1.751F, -0.0218F, 1, 2, 1, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.5F, -17.5F, 0.0F);
        this.antena.addChild(this.bone7);
        this.setRotation(this.bone7, 1.1345F, 0.0F, 0.0F);
        this.bone7.setTextureOffset(4, 29).addBox(-1.0F, -2.4617F, 0.9518F, 1, 2, 1, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.5F, -17.5F, 0.0F);
        this.antena.addChild(this.bone8);
        this.setRotation(this.bone8, 1.8762F, 0.0F, 0.0F);
        this.bone8.setTextureOffset(0, 29).addBox(-1.0F, -2.4963F, 2.1021F, 1, 2, 1, 0.0F);
        this.light = new MModelRenderer(this);
        this.light.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.antena.addChild(this.light);
        this.light.setTextureOffset(14, 0).addBox(-1.0F, -20.2762F, -4.65F, 2, 2, 2, -0.25F);
        this.slush = new MModelRenderer(this);
        this.slush.setRotationPoint(0.0F, 12.75F, -1.5F);
        this.head.addChild(this.slush);
        this.slush.setTextureOffset(22, 0).addBox(-2.0F, -13.2999F, 0.5524F, 4, 3, 0, 0.0F);
        this.slush.setTextureOffset(22, 0).addBox(-2.0F, -13.2999F, 0.553F, 4, 3, 0, 0.0F);
        this.arms = new MModelRenderer(this);
        this.arms.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Plaguebringer.addChild(this.arms);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.arms.addChild(this.bone11);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(2.0F, -6.0F, -1.75F);
        this.bone11.addChild(this.bone9);
        this.setRotation(this.bone9, 0.0F, 0.9599F, 0.0F);
        this.bone9.setTextureOffset(28, 13).addBox(-1.7132F, -1.25F, 0.4096F, 2, 1, 1, 0.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(2.0F, -6.0F, -1.75F);
        this.bone11.addChild(this.bone10);
        this.setRotation(this.bone10, 0.0F, 2.3998F, 0.0F);
        this.bone10.setTextureOffset(28, 11).addBox(-1.3601F, -1.25F, -0.5317F, 2, 1, 1, 0.0F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(0.0F, -1.5F, 0.5F);
        this.arms.addChild(this.bone12);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(2.0F, -6.0F, -1.75F);
        this.bone12.addChild(this.bone13);
        this.setRotation(this.bone13, 0.0F, 0.9599F, 0.0F);
        this.bone13.setTextureOffset(24, 27).addBox(-1.7132F, -1.25F, 0.4096F, 2, 1, 1, 0.0F);
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(2.0F, -6.0F, -1.75F);
        this.bone12.addChild(this.bone14);
        this.setRotation(this.bone14, 0.0F, 2.3998F, 0.0F);
        this.bone14.setTextureOffset(18, 27).addBox(-1.3601F, -1.25F, -0.5317F, 2, 1, 1, 0.0F);
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(0.0F, -3.0F, 0.75F);
        this.arms.addChild(this.bone15);
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(2.0F, -6.0F, -1.75F);
        this.bone15.addChild(this.bone16);
        this.setRotation(this.bone16, 0.0F, 0.9599F, 0.0F);
        this.bone16.setTextureOffset(12, 27).addBox(-1.7132F, -1.25F, 0.4096F, 2, 1, 1, 0.0F);
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(2.0F, -6.0F, -1.75F);
        this.bone15.addChild(this.bone17);
        this.setRotation(this.bone17, 0.0F, 2.3998F, 0.0F);
        this.bone17.setTextureOffset(26, 6).addBox(-1.3601F, -1.25F, -0.5317F, 2, 1, 1, 0.0F);
        this.arms2 = new MModelRenderer(this);
        this.arms2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Plaguebringer.addChild(this.arms2);
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.arms2.addChild(this.bone18);
        this.bone19 = new MModelRenderer(this);
        this.bone19.setRotationPoint(-2.0F, -6.0F, -1.75F);
        this.bone18.addChild(this.bone19);
        this.setRotation(this.bone19, 0.0F, -0.9599F, 0.0F);
        this.bone19.setTextureOffset(26, 4).addBox(-0.2868F, -1.25F, 0.4096F, 2, 1, 1, 0.0F);
        this.bone20 = new MModelRenderer(this);
        this.bone20.setRotationPoint(-2.0F, -6.0F, -1.75F);
        this.bone18.addChild(this.bone20);
        this.setRotation(this.bone20, 0.0F, -2.3998F, 0.0F);
        this.bone20.setTextureOffset(25, 17).addBox(-0.6399F, -1.25F, -0.5317F, 2, 1, 1, 0.0F);
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(0.0F, -1.5F, 0.5F);
        this.arms2.addChild(this.bone21);
        this.bone22 = new MModelRenderer(this);
        this.bone22.setRotationPoint(-2.0F, -6.0F, -1.75F);
        this.bone21.addChild(this.bone22);
        this.setRotation(this.bone22, 0.0F, -0.9599F, 0.0F);
        this.bone22.setTextureOffset(25, 15).addBox(-0.2868F, -1.25F, 0.4096F, 2, 1, 1, 0.0F);
        this.bone23 = new MModelRenderer(this);
        this.bone23.setRotationPoint(-2.0F, -6.0F, -1.75F);
        this.bone21.addChild(this.bone23);
        this.setRotation(this.bone23, 0.0F, -2.3998F, 0.0F);
        this.bone23.setTextureOffset(24, 25).addBox(-0.6399F, -1.25F, -0.5317F, 2, 1, 1, 0.0F);
        this.bone24 = new MModelRenderer(this);
        this.bone24.setRotationPoint(0.0F, -3.0F, 0.75F);
        this.arms2.addChild(this.bone24);
        this.bone25 = new MModelRenderer(this);
        this.bone25.setRotationPoint(-2.0F, -6.0F, -1.75F);
        this.bone24.addChild(this.bone25);
        this.setRotation(this.bone25, 0.0F, -0.9599F, 0.0F);
        this.bone25.setTextureOffset(18, 25).addBox(-0.2868F, -1.25F, 0.4096F, 2, 1, 1, 0.0F);
        this.bone26 = new MModelRenderer(this);
        this.bone26.setRotationPoint(-2.0F, -6.0F, -1.75F);
        this.bone24.addChild(this.bone26);
        this.setRotation(this.bone26, 0.0F, -2.3998F, 0.0F);
        this.bone26.setTextureOffset(21, 3).addBox(-0.6399F, -1.25F, -0.5317F, 2, 1, 1, 0.0F);
        this.wings = new MModelRenderer(this);
        this.wings.setRotationPoint(0.0F, -10.0F, 3.0F);
        this.Plaguebringer.addChild(this.wings);
        this.right = new MModelRenderer(this);
        this.right.setRotationPoint(1.5F, 19.25F, -2.25F);
        this.wings.addChild(this.right);
        this.setRotation(this.right, 0.0436F, -0.5236F, 0.0F);
        this.right.setTextureOffset(0, 5).addBox(-1.5F, -22.9905F, 3.4362F, 0, 4, 7, 0.0F);
        this.bone27 = new MModelRenderer(this);
        this.bone27.setRotationPoint(-1.5F, -6.25F, 2.25F);
        this.right.addChild(this.bone27);
        this.setRotation(this.bone27, -0.2182F, 0.0F, 0.0F);
        this.bone27.setTextureOffset(14, 17).addBox(0.0F, -12.8329F, -1.9101F, 0, 2, 5, 0.0F);
        this.left = new MModelRenderer(this);
        this.left.setRotationPoint(-1.5F, 19.25F, -2.25F);
        this.wings.addChild(this.left);
        this.setRotation(this.left, 0.0436F, 0.5236F, 0.0F);
        this.left.setTextureOffset(0, 1).addBox(1.5F, -22.9905F, 3.4362F, 0, 4, 7, 0.0F);
        this.bone28 = new MModelRenderer(this);
        this.bone28.setRotationPoint(1.5F, -6.25F, 2.25F);
        this.left.addChild(this.bone28);
        this.setRotation(this.bone28, -0.2182F, 0.0F, 0.0F);
        this.bone28.setTextureOffset(14, 15).addBox(0.0F, -12.8329F, -1.9101F, 0, 2, 5, 0.0F);
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/plaguebringer_animation.json"));
        this.anim = bbanimationloader.mustGet("plaguebringer.animation", this);
        this.setTexture(new ResourceLocation("minidot", "pets/plaguebringer.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        GlStateManager.translate(0.6F, -0.8F + f, 0.3F);
        this.anim.tick(time);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        GlStateManager.translate(0.0F, -0.45F, 0.0F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public String getName()
    {
        return "\u0420\u0430\u0437\u043d\u043e\u0441\u0447\u0438\u043a \u0447\u0443\u043c\u044b";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
