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

public class ClownInBox extends BasePet
{
    private final MModelRenderer Clown;
    private final MModelRenderer Box;
    private final MModelRenderer LeverArm;
    private final MModelRenderer Body;
    private final MModelRenderer Cap;
    private final MModelRenderer Rack_Spring;
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer ClownModel;
    private final MModelRenderer Apron;
    private final MModelRenderer Head;
    private final MModelRenderer Nose;
    private final MModelRenderer Wigs;
    private final MModelRenderer RightWig;
    private final MModelRenderer LeftWig;
    private final MModelRenderer Hat;
    private final MModelRenderer TrTtTt;
    private final MModelRenderer Arms;
    private final MModelRenderer RightArm;
    private final MModelRenderer LeftArm;
    private final IAnimation animation;

    public ClownInBox()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Clown = new MModelRenderer(this);
        this.Clown.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.setRotation(this.Clown, 0.0F, 1.5708F, 0.0F);
        this.Box = new MModelRenderer(this);
        this.Box.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Clown.addChild(this.Box);
        this.LeverArm = new MModelRenderer(this);
        this.LeverArm.setRotationPoint(-0.5F, -3.0F, 3.0F);
        this.Box.addChild(this.LeverArm);
        this.LeverArm.setTextureOffset(8, 7).addBox(-0.5F, -0.5F, 0.1F, 1, 3, 1, -0.25F);
        this.LeverArm.setTextureOffset(8, 21).addBox(-0.5F, -0.5F, -0.4F, 1, 1, 1, -0.25F);
        this.LeverArm.setTextureOffset(0, 0).addBox(-0.5F, 1.5F, 1.0F, 1, 1, 2, -0.2F);
        this.LeverArm.setTextureOffset(8, 19).addBox(-0.5F, 1.5F, 0.6F, 1, 1, 1, -0.25F);
        this.Body = new MModelRenderer(this);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Box.addChild(this.Body);
        this.Body.setTextureOffset(0, 19).addBox(-3.0F, -4.0F, -3.0F, 1, 3, 6, 0.0F);
        this.Body.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, -3.0F, 6, 1, 6, 0.0F);
        this.Body.setTextureOffset(37, 9).addBox(-2.0F, -4.0F, -3.0F, 4, 3, 1, 0.0F);
        this.Body.setTextureOffset(8, 22).addBox(2.0F, -4.0F, -3.0F, 1, 3, 6, 0.0F);
        this.Body.setTextureOffset(26, 14).addBox(-2.0F, -4.0F, 2.0F, 4, 3, 1, 0.0F);
        this.Cap = new MModelRenderer(this);
        this.Cap.setRotationPoint(-3.0F, -4.0F, 0.0F);
        this.Body.addChild(this.Cap);
        this.Cap.setTextureOffset(0, 7).addBox(-1.0F, -6.0F, -3.0F, 1, 6, 6, 0.0F);
        this.Rack_Spring = new MModelRenderer(this);
        this.Rack_Spring.setRotationPoint(-1.5F, -1.9F, -0.5F);
        this.Clown.addChild(this.Rack_Spring);
        this.Rack_Spring.setTextureOffset(25, 8).addBox(0.0F, 0.4F, -1.0F, 3, 1, 3, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(1.5F, 0.4F, 0.5F);
        this.Rack_Spring.addChild(this.bone5);
        this.bone5.setTextureOffset(34, 4).addBox(-0.5F, -0.9F, -0.5F, 1, 1, 1, -0.1F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, -0.8F, 0.0F);
        this.bone5.addChild(this.bone4);
        this.bone4.setTextureOffset(37, 6).addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.bone4.addChild(this.bone3);
        this.bone3.setTextureOffset(34, 8).addBox(-0.5F, -0.9F, -0.5F, 1, 1, 1, -0.1F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, -0.7F, 0.0F);
        this.bone3.addChild(this.bone2);
        this.bone2.setTextureOffset(32, 2).addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.ClownModel = new MModelRenderer(this);
        this.ClownModel.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.bone2.addChild(this.ClownModel);
        this.ClownModel.setTextureOffset(22, 22).addBox(-1.0F, -4.0F, -1.5F, 2, 4, 3, 0.0F);
        this.ClownModel.setTextureOffset(31, 28).addBox(-0.5F, -4.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Apron = new MModelRenderer(this);
        this.Apron.setRotationPoint(-2.0F, 0.0F, -0.5F);
        this.ClownModel.addChild(this.Apron);
        this.Apron.setTextureOffset(14, 7).addBox(0.5F, -4.5F, -2.0F, 3, 2, 5, -0.4F);
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.ClownModel.addChild(this.Head);
        this.Head.setTextureOffset(14, 14).addBox(-2.0F, -4.05F, -2.0F, 4, 4, 4, -0.2F);
        this.Nose = new MModelRenderer(this);
        this.Nose.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.Head.addChild(this.Nose);
        this.Nose.setTextureOffset(18, 0).addBox(-2.0F, -12.05F, -1.0F, 5, 2, 2, -0.5F);
        this.Wigs = new MModelRenderer(this);
        this.Wigs.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.Head.addChild(this.Wigs);
        this.RightWig = new MModelRenderer(this);
        this.RightWig.setRotationPoint(-3.0F, -9.05F, 0.0F);
        this.Wigs.addChild(this.RightWig);
        this.RightWig.setTextureOffset(0, 7).addBox(2.0F, -3.4F, 2.2F, 2, 2, 1, -0.2F);
        this.RightWig.setTextureOffset(0, 19).addBox(1.4F, -3.4F, 2.2F, 1, 2, 1, -0.2F);
        this.RightWig.setTextureOffset(36, 2).addBox(1.5F, -1.8F, 1.6F, 3, 1, 1, -0.2F);
        this.RightWig.setTextureOffset(38, 4).addBox(3.6F, -2.4F, 2.2F, 1, 1, 1, -0.2F);
        this.RightWig.setTextureOffset(16, 26).addBox(3.6F, -3.0F, 2.2F, 1, 1, 1, -0.2F);
        this.RightWig.setTextureOffset(30, 18).addBox(1.0F, -3.4F, 1.6F, 4, 2, 1, -0.2F);
        this.RightWig.setTextureOffset(30, 12).addBox(1.0F, -4.0F, 1.6F, 3, 1, 1, -0.2F);
        this.LeftWig = new MModelRenderer(this);
        this.LeftWig.setRotationPoint(-3.0F, -9.05F, 0.0F);
        this.Wigs.addChild(this.LeftWig);
        this.LeftWig.setTextureOffset(0, 3).addBox(2.0F, -3.4F, -3.2F, 2, 2, 1, -0.2F);
        this.LeftWig.setTextureOffset(0, 10).addBox(1.4F, -3.4F, -3.2F, 1, 2, 1, -0.2F);
        this.LeftWig.setTextureOffset(30, 0).addBox(1.5F, -1.8F, -2.6F, 3, 1, 1, -0.2F);
        this.LeftWig.setTextureOffset(16, 24).addBox(3.6F, -2.4F, -3.2F, 1, 1, 1, -0.2F);
        this.LeftWig.setTextureOffset(8, 23).addBox(3.6F, -3.0F, -3.2F, 1, 1, 1, -0.2F);
        this.LeftWig.setTextureOffset(29, 21).addBox(1.0F, -3.4F, -2.6F, 4, 2, 1, -0.2F);
        this.LeftWig.setTextureOffset(16, 22).addBox(1.0F, -4.0F, -2.6F, 3, 1, 1, -0.2F);
        this.Hat = new MModelRenderer(this);
        this.Hat.setRotationPoint(-3.0F, -0.05F, 0.0F);
        this.Head.addChild(this.Hat);
        this.Hat.setTextureOffset(25, 4).addBox(1.5F, -4.6F, -1.5F, 3, 1, 3, -0.2F);
        this.Hat.setTextureOffset(0, 28).addBox(2.0F, -6.1F, -1.0F, 2, 2, 2, -0.2F);
        this.TrTtTt = new MModelRenderer(this);
        this.TrTtTt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hat.addChild(this.TrTtTt);
        this.TrTtTt.setTextureOffset(18, 4).addBox(1.0F, -6.4F, -0.5F, 4, 1, 1, -0.3F);
        this.TrTtTt.setTextureOffset(8, 7).addBox(2.5F, -6.4F, -2.0F, 1, 1, 4, -0.3F);
        this.TrTtTt.setTextureOffset(0, 22).addBox(2.5F, -6.4F, -0.5F, 1, 1, 1, -0.2F);
        this.Arms = new MModelRenderer(this);
        this.Arms.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.ClownModel.addChild(this.Arms);
        this.RightArm = new MModelRenderer(this);
        this.RightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Arms.addChild(this.RightArm);
        this.RightArm.setTextureOffset(14, 7).addBox(-0.5F, -8.75F, -2.5F, 1, 3, 1, 0.0F);
        this.LeftArm = new MModelRenderer(this);
        this.LeftArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Arms.addChild(this.LeftArm);
        this.LeftArm.setTextureOffset(14, 14).addBox(-0.5F, -8.75F, 1.5F, 1, 3, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/clown_in_box.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/clown_in_box_animation.json"));
        this.animation = bbanimationloader.mustGet("clown_animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.translate(0.65D, -1.2D + (double)f, 0.4D);
        double d0 = 1.4D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, -0.95D, 0.0D);
        double d0 = 1.6D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u043b\u043e\u0443\u043d \u0432 \u043a\u043e\u0440\u043e\u0431\u043a\u0435";
    }

    public String getCreator()
    {
        return "Wenston & Rander_";
    }
}
