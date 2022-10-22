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

public class BeePet extends BasePet
{
    private final MModelRenderer bee;
    private final MModelRenderer bone6;
    private final MModelRenderer bone5;
    private final MModelRenderer wings;
    private final MModelRenderer one2;
    private final MModelRenderer one;
    private final MModelRenderer two2;
    private final MModelRenderer two;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer bone4;
    private final IAnimation anim;

    public BeePet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bee = new MModelRenderer(this);
        this.bee.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.bee.setTextureOffset(0, 1).addBox(-3.5F, -6.0F, -5.0F, 7, 6, 10, 0.0F);
        this.bee.setTextureOffset(1, 2).addBox(1.5F, -7.0F, -9.0F, 0, 2, 4, 0.0F);
        this.bee.setTextureOffset(1, 2).addBox(-1.4995F, -7.0F, -9.0F, 0, 2, 4, 0.0F);
        this.bee.setTextureOffset(26, 2).addBox(-3.5F, 0.0F, -1.0F, 7, 1, 0, 0.0F);
        this.bee.setTextureOffset(26, 4).addBox(-3.5F, 0.0F, 1.0F, 7, 1, 0, 0.0F);
        this.bee.setTextureOffset(26, 6).addBox(-3.5F, 0.0F, 3.0F, 7, 1, 0, 0.0F);
        this.bee.setTextureOffset(2, 0).addBox(-5.0E-4F, -4.0F, 5.0F, 0, 1, 3, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.bee.addChild(this.bone6);
        this.setRotation(this.bone6, 0.0F, 3.1416F, 0.0F);
        this.bone6.setTextureOffset(1, 4).addBox(1.506F, -7.0F, 5.0F, 0, 2, 4, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bee.addChild(this.bone5);
        this.setRotation(this.bone5, 0.0F, 3.1416F, 0.0F);
        this.bone5.setTextureOffset(1, 4).addBox(1.5F, -7.0F, 5.0F, 0, 2, 4, 0.0F);
        this.wings = new MModelRenderer(this);
        this.wings.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bee.addChild(this.wings);
        this.one2 = new MModelRenderer(this);
        this.one2.setRotationPoint(1.6F, -6.0F, 0.0F);
        this.wings.addChild(this.one2);
        this.setRotation(this.one2, 3.1416F, 0.0F, 0.0F);
        this.one2.setTextureOffset(16, 30).addBox(0.0F, -0.05F, -4.0F, 7, 0, 6, 0.0F);
        this.one = new MModelRenderer(this);
        this.one.setRotationPoint(1.6F, -6.0F, 0.0F);
        this.wings.addChild(this.one);
        this.one.setTextureOffset(9, 24).addBox(0.0F, 0.0F, -2.0F, 7, 0, 6, 0.0F);
        this.two2 = new MModelRenderer(this);
        this.two2.setRotationPoint(-1.7F, -6.0F, 0.0F);
        this.wings.addChild(this.two2);
        this.setRotation(this.two2, 3.1416F, 0.0F, 0.0F);
        this.two2.setTextureOffset(14, 36).addBox(-7.0F, -0.05F, -4.0F, 7, 0, 6, 0.0F);
        this.two = new MModelRenderer(this);
        this.two.setRotationPoint(-1.7F, -6.0F, 0.0F);
        this.wings.addChild(this.two);
        this.two.setTextureOffset(2, 18).addBox(-7.0F, 0.0F, -2.0F, 7, 0, 6, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 0.0F, -1.9F);
        this.bee.addChild(this.bone3);
        this.setRotation(this.bone3, 0.0F, 3.1416F, 0.0F);
        this.bone3.setTextureOffset(26, 2).addBox(-3.5F, 0.0F, -0.95F, 7, 1, 0, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bee.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 3.1416F, 0.0F);
        this.bone2.setTextureOffset(26, 4).addBox(-3.5F, 0.0F, -1.05F, 7, 1, 0, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bee.addChild(this.bone);
        this.setRotation(this.bone, 0.0F, 3.1416F, 0.0F);
        this.bone.setTextureOffset(26, 6).addBox(-3.5F, 0.0F, -2.95F, 7, 1, 0, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.1F, 0.0F, 12.0F);
        this.bee.addChild(this.bone4);
        this.setRotation(this.bone4, 0.0F, 3.1416F, 0.0F);
        this.bone4.setTextureOffset(2, 0).addBox(0.05F, -4.0F, 5.0F, 0, 1, 3, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/beepet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/beepet_animation.json"));
        this.anim = bbanimationloader.mustGet("bee.flying", this);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        GlStateManager.translate(0.55F, -1.0F + f, 0.3F);
        this.anim.tick(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.8F, 0.0F);
        GlStateManager.scale(1.3F, 1.3F, 1.3F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u0447\u0435\u043b\u0430";
    }
}
