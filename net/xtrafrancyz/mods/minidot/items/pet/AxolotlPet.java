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

public class AxolotlPet extends BasePet
{
    private final MModelRenderer bone5;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final IAnimation anim;

    public AxolotlPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone5.addChild(this.bone);
        this.bone.setTextureOffset(36, 0).addBox(-6.0F, -5.0F, -4.0F, 6, 5, 8, 0.0F);
        this.bone.setTextureOffset(36, 0).addBox(-2.0F, -8.0F, -7.0F, 0, 8, 14, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone5.addChild(this.bone2);
        this.bone2.setTextureOffset(0, 22).addBox(0.0F, -5.0F, 0.0F, 23, 5, 0, 0.0F);
        this.bone2.setTextureOffset(0, 0).addBox(0.0F, -4.0F, -4.0F, 10, 4, 8, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, -1.5F, -6.5F);
        this.bone5.addChild(this.bone3);
        this.bone3.setTextureOffset(6, 8).addBox(8.0F, -1.5F, 10.5F, 0, 3, 5, 0.0F);
        this.bone3.setTextureOffset(6, 8).addBox(0.0F, -1.5F, 10.5F, 0, 3, 5, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone5.addChild(this.bone4);
        this.bone4.setTextureOffset(1, 8).addBox(8.0F, -3.0F, -9.0F, 0, 3, 5, 0.0F);
        this.bone4.setTextureOffset(1, 8).addBox(0.0F, -3.0F, -9.0F, 0, 3, 5, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/axolotl.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/axolotl_animation.json"));
        this.anim = bbanimationloader.mustGet("axolotl.anim", this);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.rotate(90.0F, 0.0F, -1.0F, 0.0F);
        GlStateManager.translate(0.0D, (double)(-1.0F + f), -0.8D);
        this.anim.tick(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
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
        GlStateManager.translate(-0.2F, -0.6F, 0.0F);
        this.anim.tick(time);
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "Mabult";
    }

    public String getName()
    {
        return "\u0410\u043a\u0441\u043e\u043b\u043e\u0442\u043b\u044c";
    }
}
