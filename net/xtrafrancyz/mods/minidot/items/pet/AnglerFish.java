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

public class AnglerFish extends BasePet
{
    private final MModelRenderer bone;
    private final MModelRenderer bone6;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone7;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final IAnimation animation;

    public AnglerFish()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bone.setTextureOffset(0, 0).addBox(-2.0F, -10.0F, -4.0F, 4, 5, 6, 0.0F);
        this.bone.setTextureOffset(14, 0).addBox(-2.0F, -9.0F, 2.0F, 4, 4, 2, 0.0F);
        this.bone.setTextureOffset(16, 20).addBox(-2.0F, -8.0F, 4.0F, 4, 3, 1, 0.0F);
        this.bone.setTextureOffset(0, 0).addBox(1.5F, -9.5F, -3.5F, 1, 2, 2, 0.0F);
        this.bone.setTextureOffset(0, 0).addBox(-2.5F, -9.5F, -3.5F, 1, 2, 2, 0.0F);
        this.bone.setTextureOffset(0, 11).addBox(-2.5F, -7.0F, -5.5F, 5, 3, 5, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(2.0F, -5.75F, -0.45F);
        this.bone.addChild(this.bone6);
        this.setRotation(this.bone6, 0.0F, 0.0F, 0.6109F);
        this.bone6.setTextureOffset(17, 17).addBox(-0.0127F, 0.0175F, -1.55F, 4, 0, 3, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, -6.7F, 5.0F);
        this.bone.addChild(this.bone8);
        this.bone8.setTextureOffset(0, 15).addBox(0.0F, -2.5F, 0.0F, 0, 5, 4, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, -9.95F, 0.75F);
        this.bone.addChild(this.bone9);
        this.setRotation(this.bone9, 0.4363F, 0.0F, 0.0F);
        this.bone9.setTextureOffset(8, 15).addBox(0.0F, -1.9142F, -1.5968F, 0, 3, 4, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-2.0F, -5.75F, -0.45F);
        this.bone.addChild(this.bone7);
        this.setRotation(this.bone7, 0.0F, 0.0F, -0.6109F);
        this.bone7.setTextureOffset(12, 12).addBox(-3.9873F, 0.0175F, -1.55F, 4, 0, 3, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-1.5F, -5.0F, 0.75F);
        this.bone.addChild(this.bone2);
        this.bone2.setTextureOffset(12, 22).addBox(1.0F, -7.0F, -4.0F, 1, 2, 1, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-1.5F, -7.0F, 0.75F);
        this.bone.addChild(this.bone3);
        this.setRotation(this.bone3, ((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.bone3.setTextureOffset(8, 22).addBox(1.0F, -7.7586F, -0.0842F, 1, 2, 1, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, -13.0F, -3.75F);
        this.bone.addChild(this.bone4);
        this.setRotation(this.bone4, 2.0944F, 0.0F, 0.0F);
        this.bone4.setTextureOffset(0, 11).addBox(-0.5F, -2.5483F, -0.6464F, 1, 3, 1, 0.001F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, -11.65F, -5.65F);
        this.bone.addChild(this.bone5);
        this.setRotation(this.bone5, 2.5307F, 0.0F, 0.0F);
        this.bone5.setTextureOffset(27, 26).addBox(-0.25F, -2.8296F, -0.2712F, 0, 4, 0, -1.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/anglerfish.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/anglerfish_animation.json"));
        this.animation = bbanimationloader.mustGet("angleranimation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.04F;
        GlStateManager.translate(0.75F, -1.0F + f, 0.25F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        GlStateManager.translate(0.0F, -0.6F, 0.0F);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0420\u044b\u0431\u0430 \u0443\u0434\u0438\u043b\u044c\u0449\u0438\u043a";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
