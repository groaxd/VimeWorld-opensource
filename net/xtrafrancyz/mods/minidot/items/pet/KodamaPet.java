package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class KodamaPet extends BasePet
{
    private final MModelRenderer body;
    private final MModelRenderer rightLeg;
    private final MModelRenderer leftLeg;
    private final MModelRenderer rightHand;
    private final MModelRenderer leftHand;
    private final MModelRenderer Head;

    public KodamaPet()
    {
        this.disableAnimationInPreview = true;
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body = new MModelRenderer(this, 31, 0);
        this.body.addBox(0.0F, 0.0F, 0.0F, 6, 7, 4);
        this.rightLeg = new MModelRenderer(this, 6, 15);
        this.rightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
        this.rightLeg.setRotationPoint(1.0F, 7.0F, 2.0F);
        this.rightLeg.setDynamic(true);
        this.leftLeg = new MModelRenderer(this, 6, 15);
        this.leftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
        this.leftLeg.setRotationPoint(5.0F, 7.0F, 2.0F);
        this.leftLeg.setDynamic(true);
        this.rightHand = new MModelRenderer(this, 0, 15);
        this.rightHand.addBox(-1.0F, 0.0F, -0.5F, 1, 4, 1);
        this.rightHand.setRotationPoint(0.0F, 1.0F, 1.5F);
        this.rightHand.setDynamic(true);
        this.leftHand = new MModelRenderer(this, 0, 15);
        this.leftHand.addBox(0.0F, 0.0F, -0.5F, 1, 4, 1);
        this.leftHand.setRotationPoint(6.0F, 1.0F, 1.5F);
        this.leftHand.setDynamic(true);
        this.Head = new MModelRenderer(this, 0, 0);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 7, 7);
        this.Head.setRotationPoint(3.0F, 1.0F, 2.0F);
        this.Head.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/kodama.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.26F) * 0.05F;
        float f2 = MathHelper.cos(time * 0.16F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f2 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.Head.rotationX = modelPlayer.bipedHead.rotateAngleX / 5.0F + 0.2F;
        this.Head.rotationY = modelPlayer.bipedHead.rotateAngleY + 0.2F - f2 * 0.1F;
        this.Head.rotationZ = modelPlayer.bipedHead.rotateAngleZ - f * 2.0F;
        this.rightLeg.rotationX = f1 * 0.5F;
        this.leftLeg.rotationX = this.rightLeg.rotationX;
        this.leftLeg.rotationZ = f * 0.5F;
        this.leftHand.rotationX = f2 * 0.1F;
        this.leftHand.rotationY = -f2 * f;
        this.leftHand.rotationZ = f2 * f * 2.0F;
        this.rightHand.rotationX = -this.leftHand.rotationX;
        this.rightHand.rotationY = -this.leftHand.rotationY;
        this.rightHand.rotationZ = this.leftHand.rotationZ;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(-0.1F, -0.06F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "Kodama";
    }
}
