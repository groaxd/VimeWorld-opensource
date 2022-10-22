package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class HypnoGlasses extends BaseItem
{
    private final MModelRenderer bone3;
    private final MModelRenderer bone;
    private final MModelRenderer bone4;
    private final MModelRenderer bone2;
    private final MModelRenderer bb_main;
    private final IAnimation anim;

    public HypnoGlasses()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.setRotation(this.bone3, 0.0F, -0.0873F, 0.0F);
        this.bone3.setTextureOffset(0, 10).addBox(0.0F, -4.0F, 0.0F, 1, 1, 1, 0.0F);
        this.bone3.setTextureOffset(0, 12).addBox(1.0F, -5.2F, 0.0F, 1, 3, 1, 0.0F);
        this.bone3.setTextureOffset(19, 7).addBox(2.0F, -6.2F, 0.0F, 1, 1, 1, 0.0F);
        this.bone3.setTextureOffset(0, 0).addBox(3.0F, -7.0F, 0.0F, 3, 1, 1, 0.0F);
        this.bone3.setTextureOffset(15, 7).addBox(6.0F, -6.2F, 0.0F, 1, 1, 1, 0.0F);
        this.bone3.setTextureOffset(5, 11).addBox(7.0F, -5.2F, 0.0F, 1, 3, 1, 0.0F);
        this.bone3.setTextureOffset(19, 9).addBox(6.0F, -2.0F, 0.0F, 1, 1, 1, 0.0F);
        this.bone3.setTextureOffset(0, 2).addBox(3.0F, -1.0F, 0.0F, 3, 1, 1, 0.0F);
        this.bone3.setTextureOffset(8, 20).addBox(2.0F, -2.0F, 0.0F, 1, 1, 1, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(4.5F, -3.5F, 0.3F);
        this.bone3.addChild(this.bone);
        this.bone.setTextureOffset(11, 11).addBox(-3.5F, -3.5F, 0.0F, 7, 7, 0, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.setRotation(this.bone4, 0.0F, 0.0873F, 0.0F);
        this.bone4.setTextureOffset(19, 19).addBox(-2.0F, -5.2F, 0.0F, 1, 3, 1, 0.0F);
        this.bone4.setTextureOffset(0, 10).addBox(-1.0F, -4.0F, 0.0F, 1, 1, 1, 0.0F);
        this.bone4.setTextureOffset(11, 22).addBox(-3.0F, -6.2F, 0.0F, 1, 1, 1, 0.0F);
        this.bone4.setTextureOffset(22, 22).addBox(-3.0F, -2.0F, 0.0F, 1, 1, 1, 0.0F);
        this.bone4.setTextureOffset(0, 6).addBox(-6.0F, -1.0F, 0.0F, 3, 1, 1, 0.0F);
        this.bone4.setTextureOffset(7, 22).addBox(-7.0F, -2.0F, 0.0F, 1, 1, 1, 0.0F);
        this.bone4.setTextureOffset(3, 15).addBox(-8.0F, -5.2F, 0.0F, 1, 3, 1, 0.0F);
        this.bone4.setTextureOffset(15, 21).addBox(-7.0F, -6.2F, 0.0F, 1, 1, 1, 0.0F);
        this.bone4.setTextureOffset(0, 4).addBox(-6.0F, -7.0F, 0.0F, 3, 1, 1, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-4.5F, -3.5F, 0.3F);
        this.bone4.addChild(this.bone2);
        this.bone2.setTextureOffset(11, 0).addBox(-3.5F, -3.5F, 0.0F, 7, 7, 0, 0.0F);
        this.bb_main = new MModelRenderer(this);
        this.bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bb_main.setTextureOffset(0, 10).addBox(-8.9696F, -4.7F, 0.6972F, 1, 1, 9, 0.0F);
        this.bb_main.setTextureOffset(4, 20).addBox(-8.9696F, -3.7F, 9.3972F, 1, 2, 1, 0.0F);
        this.bb_main.setTextureOffset(12, 20).addBox(-8.9696F, -1.7F, 8.6972F, 1, 1, 1, 0.0F);
        this.bb_main.setTextureOffset(0, 0).addBox(7.9696F, -4.7F, 0.6972F, 1, 1, 9, 0.0F);
        this.bb_main.setTextureOffset(0, 20).addBox(7.9696F, -3.7F, 9.3972F, 1, 2, 1, 0.0F);
        this.bb_main.setTextureOffset(11, 7).addBox(7.9696F, -1.7F, 8.6972F, 1, 1, 1, 0.0F);
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/hypno_glasses_animation.json"));
        this.anim = bbanimationloader.mustGet("hypno.spin", this);
        this.setTexture(new ResourceLocation("minidot", "head/hypno_glasses.png"));
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.cos(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.anim.tick(time);
        GlStateManager.translate(0.0F, -0.9F, -0.32F);
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -1.0F, 0.0F);
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0413\u0438\u043f\u043d\u043e-\u043e\u0447\u043a\u0438";
    }

    public String getCreator()
    {
        return "chikon";
    }
}
