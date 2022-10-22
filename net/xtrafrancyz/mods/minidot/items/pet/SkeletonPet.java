package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SkeletonPet extends BasePet
{
    private final MModelRenderer head;
    private final MModelRenderer rightHand;
    private final MModelRenderer leftHand;
    private final MModelRenderer body;
    private final MModelRenderer rightLeg;
    private final MModelRenderer leftLeg;
    private final MModelRenderer quiver;
    private final MModelRenderer body4;

    public SkeletonPet()
    {
        this.disableAnimationInPreview = true;
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("body.body3", 0, 9);
        this.setTextureOffset("body.body6", 0, 10);
        this.setTextureOffset("body.body7", 0, 9);
        this.setTextureOffset("body.body2", 0, 10);
        this.setTextureOffset("body.body1", 0, 8);
        this.setTextureOffset("body.body5", 0, 11);
        this.setTextureOffset("rightHand.bow1", 4, 16);
        this.setTextureOffset("rightHand.bow2", 0, 16);
        this.setTextureOffset("rightHand.bow3", 0, 16);
        this.setTextureOffset("rightHand.Hand", 0, 9);
        this.head = new MModelRenderer(this, 0, 0);
        this.head.addBox(-4.0F, -8.0F, -5.0F, 8, 8, 8);
        this.head.setDynamic(true);
        this.leftHand = new MModelRenderer(this, 0, 9);
        this.leftHand.addBox(0.0F, -0.2F, -0.5F, 1, 3, 1);
        this.leftHand.setRotationPoint(1.5F, 0.5F, -0.5F);
        this.setRotation(this.leftHand, -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.leftHand.setDynamic(true);
        this.leftLeg = new MModelRenderer(this, 0, 9);
        this.leftLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1);
        this.leftLeg.setRotationPoint(1.0F, 5.0F, -0.5F);
        this.leftLeg.setDynamic(true);
        this.rightLeg = new MModelRenderer(this, 3, 11);
        this.rightLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1);
        this.rightLeg.setRotationPoint(-1.0F, 5.0F, -0.5F);
        this.rightLeg.setDynamic(true);
        this.quiver = new MModelRenderer(this, 12, 16);
        this.quiver.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2);
        this.quiver.setRotationPoint(-1.7F, 1.2F, 0.1F);
        this.setRotation(this.quiver, 0.0F, 0.0F, -0.5235988F);
        this.body = new MModelRenderer(this, "body");
        this.body.addBox("body3", -1.5F, 0.0F, -1.0F, 0, 2, 1);
        this.body.addBox("body6", -0.5F, 2.0F, 0.0F, 1, 2, 0);
        this.body.addBox("body7", -1.5F, 4.0F, -1.0F, 3, 1, 1);
        this.body.addBox("body2", -1.5F, 0.0F, -1.0F, 1, 1, 0);
        this.body.addBox("body1", 1.5F, 0.0F, -1.0F, 0, 2, 1);
        this.body.addBox("body5", 0.5F, 0.0F, -1.0F, 1, 1, 0);
        this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
        this.body4 = new MModelRenderer(this, 0, 10);
        this.body4.addBox(0.0F, 0.0F, 0.0F, 3, 2, 0);
        this.body4.setRotationPoint(-1.5F, 0.0F, 0.0F);
        this.rightHand = new MModelRenderer(this, "rightHand");
        this.rightHand.setRotationPoint(-1.5F, 0.5F, -0.5F);
        this.rightHand.addBox("bow1", -1.0F, 2.8F, -2.0F, 1, 1, 3);
        this.rightHand.addBox("bow2", -1.0F, 2.0F, 1.0F, 1, 1, 1);
        this.rightHand.addBox("bow3", -1.0F, 2.0F, -3.0F, 1, 1, 1);
        this.rightHand.addBox("Hand", -1.0F, -0.2F, -0.5F, 1, 3, 1);
        this.setRotation(this.rightHand, -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.rightHand.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/skeleton.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.26F) * 0.05F;
        float f2 = MathHelper.cos(time * 0.16F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f2 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.head.rotationX = modelPlayer.bipedHead.rotateAngleX / 2.0F;
        this.head.rotationY = modelPlayer.bipedHead.rotateAngleY + 0.2F - f2 * 0.1F;
        this.head.rotationZ = modelPlayer.bipedHead.rotateAngleZ;
        this.rightLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 3.0F + f1 * 3.0F;
        this.leftLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 3.0F + -f1 * 3.0F;
        this.leftHand.rotationX = f2 * 0.1F;
        this.leftHand.rotationY = -f2 * f * 2.0F;
        this.leftHand.rotationZ = f2 * f * 4.0F;
        this.rightHand.rotationX = -this.leftHand.rotationX - 0.4F;
        this.rightHand.rotationY = -this.leftHand.rotationY;
        this.rightHand.rotationZ = this.leftHand.rotationZ;
    }

    public String getName()
    {
        return "\u0421\u043a\u0435\u043b\u0435\u0442";
    }
}
