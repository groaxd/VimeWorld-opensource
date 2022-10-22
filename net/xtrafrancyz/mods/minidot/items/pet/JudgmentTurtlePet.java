package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class JudgmentTurtlePet extends BasePet
{
    private final MModelRenderer bone;
    private final MModelRenderer Eye;
    private final IAnimation anim;

    public JudgmentTurtlePet()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 8.0F, -3.0F);
        this.bone.setTextureOffset(16, 20).addBox(-2.0F, -5.0F, -4.0F, 3, 3, 3, 0.0F);
        this.bone.setTextureOffset(0, 0).addBox(-4.0F, -5.0F, -1.0F, 7, 3, 7, 0.0F);
        this.bone.setTextureOffset(0, 5).addBox(1.0F, -3.0F, -2.0F, 2, 1, 1, 0.0F);
        this.bone.setTextureOffset(0, 3).addBox(-4.0F, -3.0F, -2.0F, 2, 1, 1, 0.0F);
        this.bone.setTextureOffset(9, 18).addBox(-4.0F, -3.0F, 6.0F, 7, 1, 1, 0.0F);
        this.bone.setTextureOffset(0, 16).addBox(3.0F, -3.0F, -1.0F, 1, 1, 7, 0.0F);
        this.bone.setTextureOffset(13, 10).addBox(-5.0F, -3.0F, -1.0F, 1, 1, 7, 0.0F);
        this.bone.setTextureOffset(22, 10).addBox(-4.0F, -2.0F, -1.0F, 2, 1, 2, 0.0F);
        this.bone.setTextureOffset(21, 3).addBox(1.0F, -2.0F, -1.0F, 2, 1, 2, 0.0F);
        this.bone.setTextureOffset(21, 0).addBox(1.0F, -2.0F, 4.0F, 2, 1, 2, 0.0F);
        this.bone.setTextureOffset(9, 20).addBox(-4.0F, -2.0F, 4.0F, 2, 1, 2, 0.0F);
        this.bone.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, 7.0F, 1, 1, 2, 0.0F);
        this.bone.setTextureOffset(15, 10).addBox(-2.0F, -3.0F, 7.0F, 1, 1, 1, 0.0F);
        this.bone.setTextureOffset(0, 10).addBox(-3.0F, -6.0F, 0.0F, 5, 1, 5, 0.0F);
        this.Eye = new MModelRenderer(this);
        this.Eye.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.Eye.setTextureOffset(0, 12).addBox(-2.01F, -2.0F, -6.0F, 1, 1, 1, 0.0F);
        this.Eye.setTextureOffset(0, 10).addBox(0.01F, -2.0F, -6.0F, 1, 1, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/judgmentturtle.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/judgmentturtle_animation.json"));
        this.anim = bbanimationloader.mustGet("judgmentturtle.anim", this);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.translate(0.7F, -0.7F - f, 0.5F);
        float f1 = 1.5F;
        GlStateManager.scale(f1, f1, f1);
        this.anim.tick(time);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.2F, 0.0F);
        float f = 1.7F;
        GlStateManager.scale(f, f, f);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "GetoGdeto";
    }

    public String getName()
    {
        return "\u041e\u0441\u0443\u0436\u0434\u0430\u044e\u0449\u0430\u044f \u0447\u0435\u0440\u0435\u043f\u0430\u0448\u043a\u0430";
    }
}
