package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class GhastPet extends BasePet
{
    private final MModelRenderer Head;
    private final MModelRenderer atenta1;
    private final MModelRenderer atenta2;
    private final MModelRenderer atenta3;
    private final MModelRenderer atenta4;
    private final MModelRenderer atenta5;
    private final MModelRenderer btenta1;
    private final MModelRenderer btenta2;
    private final MModelRenderer btenta3;
    private final MModelRenderer btenta4;

    public GhastPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Head = new MModelRenderer(this, 0, 0);
        this.Head.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
        this.Head.setRotationPoint(-4.0F, 0.0F, -4.0F);
        this.atenta1 = new MModelRenderer(this, 0, 0);
        this.atenta1.addBox(-0.5F, 0.0F, -0.5F, 1, 5, 1);
        this.atenta1.setRotationPoint(-2.0F, 7.5F, -2.0F);
        this.setRotation(this.atenta1, 0.3839724F, 0.0F, 0.0F);
        this.atenta1.setDynamic(true);
        this.atenta2 = new MModelRenderer(this, 0, 0);
        this.atenta2.addBox(-0.5F, 0.0F, -0.5F, 1, 7, 1);
        this.atenta2.setRotationPoint(3.0F, 7.5F, 1.5F);
        this.setRotation(this.atenta2, 0.3839724F, 0.0F, 0.0F);
        this.atenta2.setDynamic(true);
        this.atenta3 = new MModelRenderer(this, 0, 0);
        this.atenta3.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
        this.atenta3.setRotationPoint(-0.5F, 7.5F, -1.5F);
        this.setRotation(this.atenta3, 0.3839724F, 0.0F, 0.0F);
        this.atenta3.setDynamic(true);
        this.atenta4 = new MModelRenderer(this, 0, 0);
        this.atenta4.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
        this.atenta4.setRotationPoint(-1.5F, 7.5F, 1.0F);
        this.setRotation(this.atenta4, 0.3839724F, 0.0F, 0.0F);
        this.atenta4.setDynamic(true);
        this.atenta5 = new MModelRenderer(this, 0, 0);
        this.atenta5.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
        this.atenta5.setRotationPoint(0.5F, 7.5F, -3.0F);
        this.setRotation(this.atenta5, 0.296706F, 0.0F, 0.0F);
        this.atenta5.setDynamic(true);
        this.btenta1 = new MModelRenderer(this, 0, 0);
        this.btenta1.addBox(-0.5F, 0.0F, -0.5F, 1, 7, 1);
        this.btenta1.setRotationPoint(-3.0F, 7.5F, 0.0F);
        this.setRotation(this.btenta1, 0.296706F, 0.0F, 0.0F);
        this.btenta1.setDynamic(true);
        this.btenta2 = new MModelRenderer(this, 0, 0);
        this.btenta2.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
        this.btenta2.setRotationPoint(1.0F, 7.5F, 2.5F);
        this.setRotation(this.btenta2, 0.296706F, 0.0F, 0.0F);
        this.btenta2.setDynamic(true);
        this.btenta3 = new MModelRenderer(this, 0, 0);
        this.btenta3.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
        this.btenta3.setRotationPoint(2.0F, 7.5F, -0.5F);
        this.setRotation(this.btenta3, 0.296706F, 0.0F, 0.0F);
        this.btenta3.setDynamic(true);
        this.btenta4 = new MModelRenderer(this, 0, 0);
        this.btenta4.addBox(-0.5F, 0.0F, -0.5F, 1, 5, 1);
        this.btenta4.setRotationPoint(3.0F, 7.5F, -2.0F);
        this.setRotation(this.btenta4, 0.3839724F, 0.0F, 0.0F);
        this.btenta4.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/ghast.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.04F;
        float f1 = MathHelper.sin(time * 0.2F) * 0.07F;
        float f2 = MathHelper.sin(time * 0.18F + 1.0F) * 0.05F;
        float f3 = MathHelper.cos(time * 0.16F);
        float f4 = MathHelper.cos(time * 0.16F) * 0.08F;
        GlStateManager.translate(0.6F, -0.7F + f * 0.5F, 0.3F);
        GlStateManager.rotate(f3 * 4.0F, 0.0F, 0.6F, 0.0F);
        GlStateManager.scale(1.3F, 1.3F, 1.3F);
        this.atenta1.rotationX = f * 4.0F;
        this.atenta2.rotationX = f * 3.0F;
        this.atenta3.rotationX = f4;
        this.atenta4.rotationX = f2 * 2.0F;
        this.atenta5.rotationX = f1;
        this.btenta1.rotationX = f * 2.0F;
        this.btenta2.rotationX = -this.atenta4.rotationX;
        this.btenta3.rotationX = -this.btenta1.rotationX;
        this.btenta4.rotationX = f2 * 4.0F;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.35F, 0.0F);
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0413\u0430\u0441\u0442";
    }
}
