package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class ElfHat extends BaseItem
{
    private final MModelRenderer model;
    private final MModelRenderer hat;
    private final MModelRenderer dzen;
    private final MModelRenderer decor;
    private final MModelRenderer bone;
    private final MModelRenderer ears;
    private final MModelRenderer ear1;
    private final MModelRenderer ear2;
    private final IAnimation anim;

    public ElfHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.model = new MModelRenderer(this);
        this.model.setRotationPoint(0.0F, 7.5F, 0.0F);
        this.hat = new MModelRenderer(this);
        this.hat.setRotationPoint(0.0F, 4.5F, -7.0F);
        this.model.addChild(this.hat);
        this.hat.setTextureOffset(0, 0).addBox(-4.0F, 3.0F, 2.0F, 8, 1, 10, 0.0F);
        this.hat.setTextureOffset(0, 11).addBox(-5.0F, 3.0F, 3.0F, 10, 1, 8, 1.0E-4F);
        this.hat.setTextureOffset(0, 20).addBox(-4.0F, 1.0F, 3.0F, 8, 2, 8, 0.0F);
        this.hat.setTextureOffset(24, 20).addBox(-3.0F, -1.0F, 4.0F, 6, 2, 6, 0.0F);
        this.hat.setTextureOffset(28, 13).addBox(-2.0F, -3.0F, 6.0F, 4, 2, 4, 0.0F);
        this.hat.setTextureOffset(0, 0).addBox(-1.0F, -4.0F, 7.0F, 2, 1, 3, 0.0F);
        this.hat.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 8.0F, 2, 1, 3, 0.0F);
        this.hat.setTextureOffset(0, 15).addBox(-0.5F, -6.0F, 9.0F, 1, 1, 3, 0.0F);
        this.hat.setTextureOffset(0, 8).addBox(-1.0F, -2.0F, 5.0F, 2, 1, 1, 0.0F);
        this.dzen = new MModelRenderer(this);
        this.dzen.setRotationPoint(0.0F, -5.5F, 12.0F);
        this.hat.addChild(this.dzen);
        this.dzen.setTextureOffset(0, 11).addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.decor = new MModelRenderer(this);
        this.decor.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.model.addChild(this.decor);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(7.0F, 7.9F, 2.5F);
        this.decor.addChild(this.bone);
        this.bone.setTextureOffset(26, 0).addBox(-10.5F, -1.2F, -7.0F, 1, 1, 9, 0.0F);
        this.bone.setTextureOffset(26, 0).addBox(-8.5F, -1.2F, -7.0F, 1, 1, 9, 0.0F);
        this.bone.setTextureOffset(26, 0).addBox(-6.5F, -1.2F, -7.0F, 1, 1, 9, 0.0F);
        this.bone.setTextureOffset(26, 0).addBox(-4.5F, -1.2F, -7.0F, 1, 1, 9, 0.0F);
        this.bone.setTextureOffset(28, 11).addBox(-11.5F, -1.2F, -6.0F, 9, 1, 1, 0.0F);
        this.bone.setTextureOffset(28, 11).addBox(-11.5F, -1.2F, -4.0F, 9, 1, 1, 0.0F);
        this.bone.setTextureOffset(28, 11).addBox(-11.5F, -1.2F, -2.0F, 9, 1, 1, 0.0F);
        this.bone.setTextureOffset(28, 11).addBox(-11.5F, -1.2F, 0.0F, 9, 1, 1, 0.0F);
        this.ears = new MModelRenderer(this);
        this.ears.setRotationPoint(-2.0F, 1.0F, -3.5F);
        this.bone.addChild(this.ears);
        this.ear1 = new MModelRenderer(this);
        this.ear1.setRotationPoint(-1.0F, 3.0F, 0.0F);
        this.ears.addChild(this.ear1);
        this.ear1.setTextureOffset(0, 20).addBox(0.5F, -2.0F, 1.0F, 1, 3, 1, 0.0F);
        this.ear1.setTextureOffset(0, 24).addBox(0.0F, -1.0F, 0.0F, 1, 2, 1, 0.0F);
        this.ear2 = new MModelRenderer(this);
        this.ear2.setRotationPoint(-9.0F, 3.0F, 0.0F);
        this.ears.addChild(this.ear2);
        this.ear2.setTextureOffset(0, 20).addBox(-1.5F, -2.0F, 1.0F, 1, 3, 1, 0.0F);
        this.ear2.setTextureOffset(0, 24).addBox(-1.0F, -1.0F, 0.0F, 1, 2, 1, 0.0F);
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/elfhat_animation.json"));
        this.anim = bbanimationloader.mustGet("elfhat_animation", this);
        this.setTexture(new ResourceLocation("minidot", "head/elfhat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.anim.tick(time);
        GlStateManager.translate(0.0F, -1.47F, 0.0F);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.9F, 0.0F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u0430\u043f\u043a\u0430 \u044d\u043b\u044c\u0444\u0430";
    }

    public String getCreator()
    {
        return "Veltorn";
    }
}
