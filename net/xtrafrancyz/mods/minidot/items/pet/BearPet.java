package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BearPet extends BasePet
{
    private final MModelRenderer head;
    private final MModelRenderer body;
    private final MModelRenderer leftHand;
    private final MModelRenderer rightHand;
    private final MModelRenderer leftLeg;
    private final MModelRenderer rightLeg;

    public BearPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.disableAnimationInPreview = true;
        this.setTextureOffset("headd.head", 0, 0);
        this.setTextureOffset("headd.head1", 8, 7);
        this.setTextureOffset("headd.head2", 8, 7);
        this.head = new MModelRenderer(this, "headd");
        this.head.addBox("head", -4.0F, -8.0F, -4.0F, 8, 8, 8);
        this.head.addBox("head1", 3.0F, -9.0F, -2.0F, 2, 2, 1);
        this.head.addBox("head2", -5.0F, -9.0F, -2.0F, 2, 2, 1);
        this.head.setDynamic(true);
        this.body = new MModelRenderer(this, 20, 20);
        this.body.addBox(-2.0F, 0.0F, -1.0F, 4, 4, 2);
        this.leftHand = new MModelRenderer(this, 44, 24);
        this.leftHand.addBox(0.0F, -0.5F, -1.0F, 2, 4, 2);
        this.leftHand.setRotationPoint(2.0F, 1.0F, 0.0F);
        this.leftHand.setDynamic(true);
        this.rightHand = new MModelRenderer(this, 44, 24);
        this.rightHand.addBox(-2.0F, -0.5F, -1.0F, 2, 4, 2);
        this.rightHand.setRotationPoint(-2.0F, 1.0F, 0.0F);
        this.rightHand.setDynamic(true);
        this.leftLeg = new MModelRenderer(this, 28, 26);
        this.leftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
        this.leftLeg.setRotationPoint(1.0F, 4.0F, 0.0F);
        this.leftLeg.setDynamic(true);
        this.rightLeg = new MModelRenderer(this, 28, 26);
        this.rightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
        this.rightLeg.setRotationPoint(-1.0F, 4.0F, 0.0F);
        this.rightLeg.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/bear.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.26F) * 0.05F;
        float f2 = MathHelper.cos(time * 0.1F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f2 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.head.rotationX = modelPlayer.bipedHead.rotateAngleX / 2.0F;
        this.head.rotationY = modelPlayer.bipedHead.rotateAngleY + 0.2F - f2 * 0.1F;
        this.head.rotationZ = modelPlayer.bipedHead.rotateAngleZ;
        this.rightLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 2.0F + f1;
        this.rightLeg.rotationY = f * 2.0F;
        this.leftLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 2.0F - f1;
        this.leftLeg.rotationZ = f * 2.0F;
        this.leftHand.rotationX = modelPlayer.bipedLeftArm.rotateAngleX / 1.2F + f2 * 0.1F;
        this.leftHand.rotationY = -f2 * f * 2.0F;
        this.leftHand.rotationZ = f2 * f * 4.0F;
        this.rightHand.rotationX = -this.leftHand.rotationX;
        this.rightHand.rotationY = -this.leftHand.rotationY;
        this.rightHand.rotationZ = this.leftHand.rotationZ;
    }

    public String getName()
    {
        return "\u041c\u0435\u0434\u0432\u0435\u0436\u043e\u043d\u043e\u043a";
    }

    public String getCreator()
    {
        return "Symbian";
    }
}
