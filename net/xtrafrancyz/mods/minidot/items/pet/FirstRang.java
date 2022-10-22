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

public class FirstRang extends BasePet
{
    private final MModelRenderer Ring;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone9;
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final IAnimation animation;

    public FirstRang()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Ring = new MModelRenderer(this);
        this.Ring.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Ring.setTextureOffset(23, 15).addBox(-1.5F, -15.75F, -1.5F, 3, 1, 3, 0.0F);
        this.Ring.setTextureOffset(9, 0).addBox(-3.5F, -10.0F, -4.0F, 7, 1, 1, 0.0F);
        this.Ring.setTextureOffset(9, 0).addBox(-3.5F, -10.0F, 3.0F, 7, 1, 1, 0.0F);
        this.Ring.setTextureOffset(0, 8).addBox(3.0F, -10.0F, -3.5F, 1, 1, 7, 0.0F);
        this.Ring.setTextureOffset(9, 3).addBox(2.0F, -10.0F, -3.0F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(9, 3).addBox(-3.0F, -10.0F, -3.0F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(9, 3).addBox(-3.0F, -10.0F, 2.0F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(9, 3).addBox(2.0F, -10.0F, 2.0F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(0, 8).addBox(-4.0F, -10.0F, -3.5F, 1, 1, 7, 0.0F);
        this.Ring.setTextureOffset(11, 3).addBox(-3.0F, -13.0F, -2.5F, 1, 3, 5, 0.0F);
        this.Ring.setTextureOffset(0, 16).addBox(-2.5F, -15.0F, -2.0F, 1, 2, 4, 0.0F);
        this.Ring.setTextureOffset(0, 16).addBox(1.5F, -15.0F, -2.0F, 1, 2, 4, 0.0F);
        this.Ring.setTextureOffset(23, 8).addBox(-2.0F, -15.0F, 1.5F, 4, 2, 1, 0.0F);
        this.Ring.setTextureOffset(23, 8).addBox(-2.0F, -15.0F, -2.5F, 4, 2, 1, 0.0F);
        this.Ring.setTextureOffset(11, 3).addBox(2.0F, -13.0F, -2.5F, 1, 3, 5, 0.0F);
        this.Ring.setTextureOffset(12, 19).addBox(-2.5F, -13.0F, -3.0F, 5, 3, 1, 0.0F);
        this.Ring.setTextureOffset(12, 19).addBox(-2.5F, -13.0F, 2.0F, 5, 3, 1, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -14.0F, 0.0F);
        this.Ring.addChild(this.bone);
        this.bone.setTextureOffset(0, 0).addBox(-0.5F, 1.0F, -0.5F, 1, 6, 1, 0.0F);
        this.bone.setTextureOffset(0, 9).addBox(-0.5F, 7.0F, -0.5F, 1, 1, 1, 0.25F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, -16.0F, 0.0F);
        this.Ring.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 0.0F, -0.0873F);
        this.bone2.setTextureOffset(18, 11).addBox(-6.0F, -3.75F, 0.0F, 6, 4, 0, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, -16.0F, 0.0F);
        this.Ring.addChild(this.bone3);
        this.setRotation(this.bone3, 0.0F, 0.0F, 0.0873F);
        this.bone3.setTextureOffset(18, 4).addBox(0.0F, -3.75F, 0.0F, 6, 4, 0, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(2.25F, -2.25F, 7.0F);
        this.Ring.addChild(this.bone9);
        this.setRotation(this.bone9, 0.5236F, 0.3054F, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-8.5F, -16.25F, -0.5F);
        this.bone9.addChild(this.bone5);
        this.setRotation(this.bone5, 0.2182F, -0.5672F, -1.2654F);
        this.bone5.setTextureOffset(0, 8).addBox(-3.6231F, 4.2823F, -3.5297F, 2, 0, 1, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-1.5F, -16.25F, -0.5F);
        this.bone9.addChild(this.bone4);
        this.setRotation(this.bone4, 0.0F, -0.829F, -0.5236F);
        this.bone4.setTextureOffset(17, 15).addBox(-4.0F, 0.25F, 0.0F, 4, 0, 1, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-2.25F, -2.25F, 7.0F);
        this.Ring.addChild(this.bone6);
        this.setRotation(this.bone6, 0.5236F, -0.3054F, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(8.5F, -16.25F, -0.5F);
        this.bone6.addChild(this.bone7);
        this.setRotation(this.bone7, 0.2182F, 0.5672F, 1.2654F);
        this.bone7.setTextureOffset(2, 0).addBox(1.6231F, 4.2823F, -3.5297F, 2, 0, 1, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(1.5F, -16.25F, -0.5F);
        this.bone6.addChild(this.bone8);
        this.setRotation(this.bone8, 0.0F, 0.829F, 0.5236F);
        this.bone8.setTextureOffset(8, 2).addBox(0.0F, 0.25F, 0.0F, 4, 0, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/firstrang.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/firstrang_animation.json"));
        this.animation = bbanimationloader.mustGet("animation.model.new", this);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.translate(0.7D, -0.8D + (double)f, 0.3D);
        this.animation.tick(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, -0.5D, 0.0D);
        GlStateManager.scale(1.2D, 1.2D, 1.2D);
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
        return "\u041f\u0435\u0440\u0432\u044b\u0439 \u0437\u0432\u043e\u043d\u043e\u043a";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
