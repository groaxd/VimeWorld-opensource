package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ZombiePet extends BasePet
{
    private final MModelRenderer head;
    private final MModelRenderer rightHand;
    private final MModelRenderer leftHand;
    private final MModelRenderer body;
    private final MModelRenderer rightLeg;
    private final MModelRenderer leftLeg;

    public ZombiePet()
    {
        this.disableAnimationInPreview = true;
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body = new MModelRenderer(this, 32, 0);
        this.body.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 2);
        this.leftLeg = new MModelRenderer(this, 8, 22);
        this.leftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2);
        this.leftLeg.setRotationPoint(1.0F, 5.0F, 1.0F);
        this.leftLeg.setDynamic(true);
        this.rightLeg = new MModelRenderer(this, 0, 22);
        this.rightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2);
        this.rightLeg.setRotationPoint(-1.0F, 5.0F, 1.0F);
        this.rightLeg.setDynamic(true);
        this.head = new MModelRenderer(this, 0, 0);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
        this.head.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.head.setDynamic(true);
        this.leftHand = new MModelRenderer(this, 46, 0);
        this.leftHand.addBox(0.0F, -0.8F, -0.8F, 2, 4, 2);
        this.leftHand.setRotationPoint(2.0F, 1.0F, 1.0F);
        this.setRotation(this.leftHand, -1.466077F, 0.0F, 0.0F);
        this.leftHand.setDynamic(true);
        this.rightHand = new MModelRenderer(this, 46, 0);
        this.rightHand.addBox(-2.0F, -0.8F, -0.8F, 2, 4, 2);
        this.rightHand.setRotationPoint(-2.0F, 1.0F, 1.0F);
        this.setRotation(this.rightHand, -1.466077F, 0.0F, 0.0F);
        this.rightHand.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/zombie.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.26F) * 0.05F;
        float f2 = MathHelper.cos(time * 0.16F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f2 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.head.rotationY = modelPlayer.bipedHead.rotateAngleY + 0.2F;
        this.head.rotationX = modelPlayer.bipedHead.rotateAngleX / 2.0F;
        this.head.rotationZ = modelPlayer.bipedHead.rotateAngleZ;
        this.rightLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 2.5F + f1 * 3.0F;
        this.leftLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 2.5F + -f1 * 3.0F;
        this.leftLeg.rotationZ = f * 5.0F;
        this.leftHand.rotationX = f2 * 0.1F;
        this.leftHand.rotationY = -f2 * f * 2.0F;
        this.leftHand.rotationZ = f2 * f * 4.0F;
        this.rightHand.rotationX = -this.leftHand.rotationX;
        this.rightHand.rotationY = -this.leftHand.rotationY;
        this.rightHand.rotationZ = this.leftHand.rotationZ;
    }

    public String getName()
    {
        return "\u0417\u043e\u043c\u0431\u0438";
    }
}
