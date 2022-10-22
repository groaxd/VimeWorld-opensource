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

public class SandGlass extends BasePet
{
    private final MModelRenderer Sand;
    private final MModelRenderer Osnova;
    private final IAnimation animation;

    public SandGlass()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Sand = new MModelRenderer(this);
        this.Sand.setRotationPoint(0.0F, 15.5F, 0.0F);
        this.Sand.setTextureOffset(0, 25).addBox(-2.0F, -5.5F, -3.0F, 4, 1, 6, 0.0F);
        this.Sand.setTextureOffset(12, 12).addBox(-2.0F, -6.0F, -2.0F, 4, 1, 4, 0.0F);
        this.Sand.setTextureOffset(12, 12).addBox(-2.0F, 5.0F, -2.0F, 4, 1, 4, 0.0F);
        this.Sand.setTextureOffset(0, 25).addBox(-2.0F, 4.5F, -3.0F, 4, 1, 6, 0.0F);
        this.Sand.setTextureOffset(20, 27).addBox(-3.0F, -5.5F, -2.0F, 1, 1, 4, 0.0F);
        this.Sand.setTextureOffset(20, 27).addBox(-3.0F, 4.5F, -2.0F, 1, 1, 4, 0.0F);
        this.Sand.setTextureOffset(20, 27).addBox(2.0F, -5.5F, -2.0F, 1, 1, 4, 0.0F);
        this.Sand.setTextureOffset(20, 27).addBox(2.0F, 4.5F, -2.0F, 1, 1, 4, 0.0F);
        this.Sand.setTextureOffset(0, 17).addBox(-1.5F, 1.5F, -2.5F, 3, 3, 5, 0.0F);
        this.Sand.setTextureOffset(16, 17).addBox(-1.5F, -4.5F, -2.5F, 3, 3, 5, 0.0F);
        this.Sand.setTextureOffset(14, 25).addBox(-2.5F, 1.5F, -1.5F, 1, 3, 3, 0.0F);
        this.Sand.setTextureOffset(24, 21).addBox(-2.5F, -4.5F, -1.5F, 1, 3, 3, 0.0F);
        this.Sand.setTextureOffset(14, 25).addBox(1.5F, 1.5F, -1.5F, 1, 3, 3, 0.0F);
        this.Sand.setTextureOffset(24, 21).addBox(1.5F, -4.5F, -1.5F, 1, 3, 3, 0.0F);
        this.Sand.setTextureOffset(0, 12).addBox(-1.0F, 0.5F, -2.0F, 2, 1, 4, 0.0F);
        this.Sand.setTextureOffset(17, 17).addBox(-1.0F, -1.5F, -2.0F, 2, 1, 4, 0.0F);
        this.Sand.setTextureOffset(0, 28).addBox(-2.0F, 0.5F, -1.0F, 1, 1, 2, 0.0F);
        this.Sand.setTextureOffset(26, 28).addBox(-2.0F, -1.5F, -1.0F, 1, 1, 2, 0.0F);
        this.Sand.setTextureOffset(0, 28).addBox(1.0F, 0.5F, -1.0F, 1, 1, 2, 0.0F);
        this.Sand.setTextureOffset(26, 28).addBox(1.0F, -1.5F, -1.0F, 1, 1, 2, 0.0F);
        this.Sand.setTextureOffset(16, 22).addBox(-1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
        this.Osnova = new MModelRenderer(this);
        this.Osnova.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Osnova.setTextureOffset(28, 0).addBox(4.0F, -16.5F, -0.5F, 1, 16, 1, 0.0F);
        this.Osnova.setTextureOffset(28, 0).addBox(-5.0F, -16.5F, -0.5F, 1, 16, 1, 0.0F);
        this.Osnova.setTextureOffset(0, 14).addBox(-4.0F, -1.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Osnova.setTextureOffset(0, 14).addBox(-4.0F, -16.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Osnova.setTextureOffset(10, 3).addBox(-4.0F, -9.0F, -0.5F, 8, 1, 1, 0.0F);
        this.Osnova.setTextureOffset(0, 5).addBox(-2.0F, -1.5F, -3.0F, 4, 1, 6, 0.0F);
        this.Osnova.setTextureOffset(0, 5).addBox(-2.0F, -16.5F, -3.0F, 4, 1, 6, 0.0F);
        this.Osnova.setTextureOffset(0, 0).addBox(2.0F, -1.5F, -2.0F, 1, 1, 4, 0.0F);
        this.Osnova.setTextureOffset(0, 0).addBox(2.0F, -16.5F, -2.0F, 1, 1, 4, 0.0F);
        this.Osnova.setTextureOffset(0, 0).addBox(-3.0F, -1.5F, -2.0F, 1, 1, 4, 0.0F);
        this.Osnova.setTextureOffset(0, 0).addBox(-3.0F, -16.5F, -2.0F, 1, 1, 4, 0.0F);
        this.Osnova.setTextureOffset(0, 14).addBox(3.0F, -1.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Osnova.setTextureOffset(0, 14).addBox(3.0F, -16.5F, -0.5F, 1, 1, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/sandglass.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/sandglass_animation.json"));
        this.animation = bbanimationloader.mustGet("sandglass", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.04F;
        GlStateManager.translate(0.699999988079071D, -0.9D + (double)f, 0.25D);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        GlStateManager.translate(0.0F, -0.55F, 0.0F);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u0435\u0441\u043e\u0447\u043d\u044b\u0435 \u0447\u0430\u0441\u044b";
    }

    public String getCreator()
    {
        return "EvilBendy";
    }
}
