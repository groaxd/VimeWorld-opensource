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

public class IceBlockPet extends BasePet
{
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final IAnimation anim;

    public IceBlockPet()
    {
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 15.5F, 0.5F);
        this.bone3.setTextureOffset(0, 0).addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, 15.5F, 0.5F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(3.0F, -1.0F, 3.0F);
        this.bone4.addChild(this.bone);
        this.bone.setTextureOffset(0, 0).addBox(-1.5F, -2.5F, -1.5F, 3, 3, 3, -0.6F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-3.25F, 2.0F, -3.0F);
        this.bone4.addChild(this.bone2);
        this.bone2.setTextureOffset(0, 0).addBox(-1.25F, -0.75F, -1.5F, 3, 3, 3, -0.6F);
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/iceblock_pet_animation.json"));
        this.anim = bbanimationloader.mustGet("ice_floating", this);
        this.setTexture(new ResourceLocation("minidot", "pets/iceblock_pet.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.05F;
        GlStateManager.translate(0.75F, -1.3F + f, 0.3F);
        GlStateManager.scale(1.8F, 1.8F, 1.8F);
        this.anim.tick(time);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(2.0F, 2.0F, 2.0F);
        GlStateManager.translate(0.0F, -0.55F, 0.0F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0443\u0431\u0438\u043a\u0438 \u043b\u044c\u0434\u0430";
    }
}
