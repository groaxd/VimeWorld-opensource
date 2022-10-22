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

public class SnowFlakeHat extends BaseItem
{
    private final MModelRenderer all;
    private final MModelRenderer particles;
    private final MModelRenderer one;
    private final MModelRenderer one2;
    private final MModelRenderer one3;
    private final MModelRenderer one4;
    private final MModelRenderer one5;
    private final MModelRenderer one6;
    private final MModelRenderer one7;
    private final MModelRenderer one8;
    private final IAnimation anim;

    public SnowFlakeHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 22;
        this.textureHeight = 13;
        this.all = new MModelRenderer(this);
        this.all.setRotationPoint(0.0F, 14.0F, 0.0F);
        this.particles = new MModelRenderer(this);
        this.particles.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.all.addChild(this.particles);
        this.one = new MModelRenderer(this);
        this.one.setRotationPoint(0.0F, -2.95F, 0.0F);
        this.particles.addChild(this.one);
        this.one.setTextureOffset(4, 4).addBox(-1.5F, -1.8F, -0.5F, 3, 3, 1, 0.005F);
        this.one.setTextureOffset(11, 3).addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.2F);
        this.one.setTextureOffset(0, 0).addBox(-5.0F, -0.8F, -0.5F, 10, 1, 1, -0.002F);
        this.one.setTextureOffset(4, 8).addBox(3.0F, -1.8F, -0.5F, 1, 3, 1, 0.003F);
        this.one.setTextureOffset(4, 2).addBox(-1.5F, -4.4F, -0.5F, 3, 1, 1, 0.003F);
        this.one.setTextureOffset(4, 2).addBox(-1.5F, 2.6F, -0.5F, 3, 1, 1, 0.003F);
        this.one.setTextureOffset(4, 8).addBox(-4.0F, -1.8F, -0.5F, 1, 3, 1, 0.003F);
        this.one.setTextureOffset(0, 2).addBox(-0.5F, -5.3F, -0.5F, 1, 10, 1, 0.001F);
        this.one2 = new MModelRenderer(this);
        this.one2.setRotationPoint(0.0F, -2.95F, 0.0F);
        this.particles.addChild(this.one2);
        this.one2.setTextureOffset(4, 4).addBox(-1.5F, -1.8F, -0.5F, 3, 3, 1, -0.005F);
        this.one2.setTextureOffset(0, 0).addBox(-5.0F, -0.8F, -0.5F, 10, 1, 1, -0.002F);
        this.one2.setTextureOffset(4, 8).addBox(3.0F, -1.8F, -0.5F, 1, 3, 1, -0.003F);
        this.one2.setTextureOffset(4, 2).addBox(-1.5F, -4.4F, -0.5F, 3, 1, 1, -0.003F);
        this.one2.setTextureOffset(4, 2).addBox(-1.5F, 2.6F, -0.5F, 3, 1, 1, -0.003F);
        this.one2.setTextureOffset(4, 8).addBox(-4.0F, -1.8F, -0.5F, 1, 3, 1, -0.003F);
        this.one2.setTextureOffset(0, 2).addBox(-0.5F, -5.3F, -0.5F, 1, 10, 1, 0.001F);
        this.one2.setTextureOffset(11, 3).addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.2F);
        this.one3 = new MModelRenderer(this);
        this.one3.setRotationPoint(0.0F, -2.95F, 0.0F);
        this.particles.addChild(this.one3);
        this.one3.setTextureOffset(4, 4).addBox(-1.5F, -1.8F, -0.5F, 3, 3, 1, -0.005F);
        this.one3.setTextureOffset(0, 0).addBox(-5.0F, -0.8F, -0.5F, 10, 1, 1, -0.002F);
        this.one3.setTextureOffset(4, 8).addBox(3.0F, -1.8F, -0.5F, 1, 3, 1, -0.003F);
        this.one3.setTextureOffset(4, 2).addBox(-1.5F, -4.4F, -0.5F, 3, 1, 1, -0.003F);
        this.one3.setTextureOffset(4, 2).addBox(-1.5F, 2.6F, -0.5F, 3, 1, 1, -0.003F);
        this.one3.setTextureOffset(4, 8).addBox(-4.0F, -1.8F, -0.5F, 1, 3, 1, -0.003F);
        this.one3.setTextureOffset(0, 2).addBox(-0.5F, -5.3F, -0.5F, 1, 10, 1, 0.001F);
        this.one3.setTextureOffset(11, 3).addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.2F);
        this.one4 = new MModelRenderer(this);
        this.one4.setRotationPoint(0.0F, -2.95F, 0.0F);
        this.particles.addChild(this.one4);
        this.one4.setTextureOffset(4, 4).addBox(-1.5F, -1.8F, -0.5F, 3, 3, 1, -0.005F);
        this.one4.setTextureOffset(0, 0).addBox(-5.0F, -0.8F, -0.5F, 10, 1, 1, -0.002F);
        this.one4.setTextureOffset(4, 8).addBox(3.0F, -1.8F, -0.5F, 1, 3, 1, -0.003F);
        this.one4.setTextureOffset(4, 2).addBox(-1.5F, -4.4F, -0.5F, 3, 1, 1, -0.003F);
        this.one4.setTextureOffset(4, 2).addBox(-1.5F, 2.6F, -0.5F, 3, 1, 1, -0.003F);
        this.one4.setTextureOffset(4, 8).addBox(-4.0F, -1.8F, -0.5F, 1, 3, 1, -0.003F);
        this.one4.setTextureOffset(0, 2).addBox(-0.5F, -5.3F, -0.5F, 1, 10, 1, 0.001F);
        this.one4.setTextureOffset(11, 3).addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.2F);
        this.one5 = new MModelRenderer(this);
        this.one5.setRotationPoint(0.0F, -2.95F, 0.0F);
        this.particles.addChild(this.one5);
        this.one5.setTextureOffset(4, 4).addBox(-1.5F, -1.8F, -0.5F, 3, 3, 1, -0.005F);
        this.one5.setTextureOffset(0, 0).addBox(-5.0F, -0.8F, -0.5F, 10, 1, 1, -0.002F);
        this.one5.setTextureOffset(4, 8).addBox(3.0F, -1.8F, -0.5F, 1, 3, 1, -0.003F);
        this.one5.setTextureOffset(4, 2).addBox(-1.5F, -4.4F, -0.5F, 3, 1, 1, -0.003F);
        this.one5.setTextureOffset(4, 2).addBox(-1.5F, 2.6F, -0.5F, 3, 1, 1, -0.003F);
        this.one5.setTextureOffset(4, 8).addBox(-4.0F, -1.8F, -0.5F, 1, 3, 1, -0.003F);
        this.one5.setTextureOffset(0, 2).addBox(-0.5F, -5.3F, -0.5F, 1, 10, 1, 0.001F);
        this.one5.setTextureOffset(11, 3).addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.2F);
        this.one6 = new MModelRenderer(this);
        this.one6.setRotationPoint(0.0F, -2.95F, 0.0F);
        this.particles.addChild(this.one6);
        this.one6.setTextureOffset(4, 4).addBox(-1.5F, -1.8F, -0.5F, 3, 3, 1, -0.005F);
        this.one6.setTextureOffset(0, 0).addBox(-5.0F, -0.8F, -0.5F, 10, 1, 1, -0.002F);
        this.one6.setTextureOffset(4, 8).addBox(3.0F, -1.8F, -0.5F, 1, 3, 1, -0.003F);
        this.one6.setTextureOffset(4, 2).addBox(-1.5F, -4.4F, -0.5F, 3, 1, 1, -0.003F);
        this.one6.setTextureOffset(4, 2).addBox(-1.5F, 2.6F, -0.5F, 3, 1, 1, -0.003F);
        this.one6.setTextureOffset(4, 8).addBox(-4.0F, -1.8F, -0.5F, 1, 3, 1, -0.003F);
        this.one6.setTextureOffset(0, 2).addBox(-0.5F, -5.3F, -0.5F, 1, 10, 1, 0.001F);
        this.one6.setTextureOffset(11, 3).addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.2F);
        this.one7 = new MModelRenderer(this);
        this.one7.setRotationPoint(0.0F, -2.95F, 0.0F);
        this.particles.addChild(this.one7);
        this.one7.setTextureOffset(4, 4).addBox(-1.5F, -1.8F, -0.5F, 3, 3, 1, -0.005F);
        this.one7.setTextureOffset(0, 0).addBox(-5.0F, -0.8F, -0.5F, 10, 1, 1, -0.002F);
        this.one7.setTextureOffset(4, 8).addBox(3.0F, -1.8F, -0.5F, 1, 3, 1, -0.003F);
        this.one7.setTextureOffset(4, 2).addBox(-1.5F, -4.4F, -0.5F, 3, 1, 1, -0.003F);
        this.one7.setTextureOffset(4, 2).addBox(-1.5F, 2.6F, -0.5F, 3, 1, 1, -0.003F);
        this.one7.setTextureOffset(4, 8).addBox(-4.0F, -1.8F, -0.5F, 1, 3, 1, -0.003F);
        this.one7.setTextureOffset(0, 2).addBox(-0.5F, -5.3F, -0.5F, 1, 10, 1, 0.001F);
        this.one7.setTextureOffset(11, 3).addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.2F);
        this.one8 = new MModelRenderer(this);
        this.one8.setRotationPoint(0.0F, -2.95F, 0.0F);
        this.particles.addChild(this.one8);
        this.one8.setTextureOffset(4, 4).addBox(-1.5F, -1.8F, -0.5F, 3, 3, 1, -0.005F);
        this.one8.setTextureOffset(0, 0).addBox(-5.0F, -0.8F, -0.5F, 10, 1, 1, -0.002F);
        this.one8.setTextureOffset(4, 8).addBox(3.0F, -1.8F, -0.5F, 1, 3, 1, -0.003F);
        this.one8.setTextureOffset(4, 2).addBox(-1.5F, -4.4F, -0.5F, 3, 1, 1, -0.003F);
        this.one8.setTextureOffset(4, 2).addBox(-1.5F, 2.6F, -0.5F, 3, 1, 1, -0.003F);
        this.one8.setTextureOffset(4, 8).addBox(-4.0F, -1.8F, -0.5F, 1, 3, 1, -0.003F);
        this.one8.setTextureOffset(0, 2).addBox(-0.5F, -5.3F, -0.5F, 1, 10, 1, 0.001F);
        this.one8.setTextureOffset(11, 3).addBox(-0.5F, -0.8F, -0.5F, 1, 1, 1, 0.2F);
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/snowflakehat_animation.json"));
        this.anim = bbanimationloader.mustGet("snowhat.animation", this);
        this.setTexture(new ResourceLocation("minidot", "head/snowflakehat.png"));
    }

    public void itemMotion(float rotation, int number)
    {
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -1.5F, 0.0F);
        this.anim.tick(time);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -1.45F, 0.0F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u043d\u0435\u0436\u0438\u043d\u043a\u0438";
    }
}
