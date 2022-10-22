package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class DeerPet extends BasePet
{
    private final MModelRenderer body;
    private final MModelRenderer rightLeg;
    private final MModelRenderer leftLeg;
    private final MModelRenderer rightHand;
    private final MModelRenderer leftHand;
    private final MModelRenderer Piece1;

    public DeerPet()
    {
        this.disableAnimationInPreview = true;
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.head", 0, 0);
        this.setTextureOffset("Piece1.Shape2", 48, 7);
        this.setTextureOffset("Piece1.Shape10", 0, 0);
        this.setTextureOffset("Piece1.Shape1", 44, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape32", 0, 0);
        this.setTextureOffset("Piece1.Shape42", 0, 0);
        this.setTextureOffset("Piece1.Shape82", 0, 0);
        this.setTextureOffset("Piece1.Shape11", 0, 0);
        this.setTextureOffset("Piece1.Shape72", 0, 0);
        this.setTextureOffset("Piece1.Shape52", 0, 0);
        this.setTextureOffset("Piece1.Shape62", 0, 0);
        this.setTextureOffset("Piece1.Shape102", 0, 0);
        this.setTextureOffset("Piece1.Shape92", 0, 0);
        this.setTextureOffset("Piece1.Shape112", 0, 0);
        this.setTextureOffset("Piece1.Shape12", 24, 24);
        this.setTextureOffset("Piece1.Shape13", 16, 24);
        this.body = new MModelRenderer(this, 43, 13);
        this.body.addBox(-2.0F, 0.0F, -1.0F, 4, 4, 2);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightLeg = new MModelRenderer(this, 0, 16);
        this.rightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
        this.rightLeg.setRotationPoint(-1.0F, 4.0F, 0.0F);
        this.rightLeg.setDynamic(true);
        this.leftLeg = new MModelRenderer(this, 0, 16);
        this.leftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
        this.leftLeg.setRotationPoint(1.0F, 4.0F, 0.0F);
        this.leftLeg.setDynamic(true);
        this.rightHand = new MModelRenderer(this, 0, 16);
        this.rightHand.addBox(-2.0F, -0.5F, -1.0F, 2, 4, 2);
        this.rightHand.setRotationPoint(-2.0F, 1.0F, 0.0F);
        this.rightHand.setDynamic(true);
        this.leftHand = new MModelRenderer(this, 0, 16);
        this.leftHand.addBox(0.0F, -0.5F, -1.0F, 2, 4, 2);
        this.leftHand.setRotationPoint(2.0F, 1.0F, 0.0F);
        this.leftHand.setDynamic(true);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("head", -4.0F, -8.0F, -4.0F, 8, 8, 8);
        this.Piece1.addBox("Shape2", -1.0F, -5.4F, -6.4F, 2, 2, 2);
        this.Piece1.addBox("Shape10", 7.0F, -16.0F, -1.0F, 1, 2, 1);
        this.Piece1.addBox("Shape1", -3.0F, -5.0F, -6.0F, 6, 4, 3);
        this.Piece1.addBox("Shape7", 4.0F, -17.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape9", 6.0F, -15.0F, -1.0F, 1, 3, 1);
        this.Piece1.addBox("Shape8", 5.0F, -18.0F, -1.0F, 1, 7, 1);
        this.Piece1.addBox("Shape5", 3.0F, -14.0F, -1.0F, 1, 5, 1);
        this.Piece1.addBox("Shape6", 4.0F, -13.0F, -1.0F, 1, 3, 1);
        this.Piece1.addBox("Shape3", 1.0F, -12.0F, -1.0F, 1, 4, 1);
        this.Piece1.addBox("Shape4", 2.0F, -11.0F, -1.0F, 1, 3, 1);
        this.Piece1.addBox("Shape32", -2.0F, -12.0F, -1.0F, 1, 4, 1);
        this.Piece1.addBox("Shape42", -3.0F, -11.0F, -1.0F, 1, 3, 1);
        this.Piece1.addBox("Shape82", -6.0F, -18.0F, -1.0F, 1, 7, 1);
        this.Piece1.addBox("Shape11", 7.0F, -13.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape72", -5.0F, -17.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape52", -4.0F, -14.0F, -1.0F, 1, 5, 1);
        this.Piece1.addBox("Shape62", -5.0F, -13.0F, -1.0F, 1, 3, 1);
        this.Piece1.addBox("Shape102", -8.0F, -16.0F, -1.0F, 1, 2, 1);
        this.Piece1.addBox("Shape92", -7.0F, -15.0F, -1.0F, 1, 3, 1);
        this.Piece1.addBox("Shape112", -8.0F, -13.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape12", 4.0F, -8.0F, -0.5F, 3, 4, 0);
        this.Piece1.addBox("Shape13", -7.0F, -8.0F, -0.5F, 3, 4, 0);
        this.Piece1.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/deerpet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.cos(time * 0.16F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.rightLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 2.0F + f1 * 0.1F;
        this.leftLeg.rotationX = -this.rightLeg.rotationX;
        this.Piece1.rotationX = modelPlayer.bipedHead.rotateAngleX / 2.0F + 0.2F;
        this.Piece1.rotationY = modelPlayer.bipedHead.rotateAngleY + 0.2F - f1 * 0.1F;
        this.Piece1.rotationZ = modelPlayer.bipedHead.rotateAngleZ - f * 2.0F;
        this.leftHand.rotationX = modelPlayer.bipedLeftArm.rotateAngleX / 1.2F + f1 * 0.15F;
        this.leftHand.rotationY = -f1 * f;
        this.leftHand.rotationZ = f1 * f * 2.0F;
        this.rightHand.rotationX = -this.leftHand.rotationX;
        this.rightHand.rotationY = -this.leftHand.rotationY;
        this.rightHand.rotationZ = this.leftHand.rotationZ;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.12F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041e\u043b\u0435\u043d\u044c";
    }
}
