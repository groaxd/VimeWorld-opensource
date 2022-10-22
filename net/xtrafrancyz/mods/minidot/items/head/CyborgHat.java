package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class CyborgHat extends BaseHelm
{
    private final MModelRenderer HScollection_RHM;
    private final MModelRenderer brow;
    private final MModelRenderer eye;
    private final MModelRenderer yey;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bolts;
    private final IAnimation anim;

    public CyborgHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.HScollection_RHM = new MModelRenderer(this);
        this.HScollection_RHM.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.HScollection_RHM.setTextureOffset(0, 14).addBox(0.0F, -8.0F, -4.5F, 4, 8, 1, 0.0F);
        this.HScollection_RHM.setTextureOffset(12, 0).addBox(0.0F, -8.5F, -4.0F, 4, 1, 5, 0.0F);
        this.HScollection_RHM.setTextureOffset(7, 8).addBox(0.0F, -0.5F, -4.0F, 4, 1, 5, 0.0F);
        this.HScollection_RHM.setTextureOffset(0, 0).addBox(3.5F, -8.0F, -4.0F, 1, 8, 5, 0.0F);
        this.brow = new MModelRenderer(this);
        this.brow.setRotationPoint(4.0F, -6.5F, -5.5F);
        this.HScollection_RHM.addChild(this.brow);
        this.setRotation(this.brow, 0.0F, 0.0F, -0.0436F);
        this.brow.setTextureOffset(12, 6).addBox(-5.0F, -1.0F, 0.25F, 6, 1, 1, -0.75F);
        this.eye = new MModelRenderer(this);
        this.eye.setRotationPoint(0.0F, -0.5F, 0.25F);
        this.HScollection_RHM.addChild(this.eye);
        this.eye.setTextureOffset(10, 20).addBox(1.363F, -5.0383F, -5.25F, 1, 3, 1, 0.0F);
        this.eye.setTextureOffset(10, 14).addBox(0.763F, -5.5383F, -5.3F, 2, 3, 1, 0.0F);
        this.eye.setTextureOffset(0, 0).addBox(1.137F, -5.0383F, -5.25F, 1, 3, 1, 0.0F);
        this.eye.setTextureOffset(13, 23).addBox(1.137F, -5.9617F, -5.25F, 1, 1, 1, 0.0F);
        this.eye.setTextureOffset(4, 23).addBox(1.363F, -5.9617F, -5.25F, 1, 1, 1, 0.0F);
        this.eye.setTextureOffset(16, 16).addBox(2.25F, -5.5F, -5.25F, 1, 3, 1, 0.0F);
        this.eye.setTextureOffset(13, 0).addBox(0.25F, -5.5F, -5.25F, 1, 3, 1, 0.0F);
        this.yey = new MModelRenderer(this);
        this.yey.setRotationPoint(1.8F, -4.0F, -5.65F);
        this.eye.addChild(this.yey);
        this.yey.setTextureOffset(7, 0).addBox(-1.037F, -1.5383F, 0.0F, 2, 3, 1, -0.25F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(3.25F, -2.5F, -5.25F);
        this.eye.addChild(this.bone7);
        this.setRotation(this.bone7, 0.0F, 0.0F, -0.48F);
        this.bone7.setTextureOffset(7, 24).addBox(-1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.75F, -2.5F, -5.25F);
        this.eye.addChild(this.bone8);
        this.setRotation(this.bone8, 0.0F, 0.0F, 0.48F);
        this.bone8.setTextureOffset(23, 17).addBox(-0.4435F, -0.7691F, 0.0F, 1, 1, 1, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.75F, -5.5F, -5.25F);
        this.eye.addChild(this.bone9);
        this.setRotation(this.bone9, 0.0F, 0.0F, -0.48F);
        this.bone9.setTextureOffset(23, 10).addBox(-0.4435F, -0.2309F, 0.0F, 1, 1, 1, 0.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(3.25F, -5.5F, -5.25F);
        this.eye.addChild(this.bone10);
        this.setRotation(this.bone10, 0.0F, 0.0F, 0.48F);
        this.bone10.setTextureOffset(17, 23).addBox(-1.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.bolts = new MModelRenderer(this);
        this.bolts.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HScollection_RHM.addChild(this.bolts);
        this.bolts.setTextureOffset(0, 23).addBox(0.0F, -1.0F, -5.1F, 1, 1, 1, -0.7F);
        this.bolts.setTextureOffset(22, 14).addBox(0.0F, -2.0F, -5.1F, 1, 1, 1, -0.7F);
        this.bolts.setTextureOffset(21, 22).addBox(0.0F, -8.0F, -5.1F, 1, 1, 1, -0.7F);
        this.bolts.setTextureOffset(18, 21).addBox(0.0F, -9.0F, -4.1F, 1, 1, 1, -0.7F);
        this.bolts.setTextureOffset(20, 16).addBox(0.0F, -9.0F, -2.1F, 1, 1, 1, -0.7F);
        this.bolts.setTextureOffset(20, 11).addBox(0.0F, -9.0F, -0.1F, 1, 1, 1, -0.7F);
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/cyborghat_animation.json"));
        this.anim = bbanimationloader.mustGet("cyborg", this);
        this.setTexture(new ResourceLocation("minidot", "head/cyborghat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.08F, 1.08F, 1.08F);
        GlStateManager.translate(0.02F, -1.375F, 0.0F);
        this.anim.tickDelayed(time, 5.0F);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(195.0F + MathHelper.cos(rotation * 0.07F + (float)number) * 10.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.1F, -1.5F, 0.0F);
        this.anim.tickDelayed(time, 5.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0438\u0431\u043e\u0440\u0433";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
