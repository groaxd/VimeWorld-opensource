package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ElfPet extends BasePet
{
    private final MModelRenderer Piece1;
    private final MModelRenderer rightHand;
    private final MModelRenderer leftHand;
    private final MModelRenderer body;
    private final MModelRenderer rightLeg;
    private final MModelRenderer leftLeg;
    private final MModelRenderer hair;

    public ElfPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.head", 0, 0);
        this.setTextureOffset("Piece1.Shape1", 0, 0);
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.body = new MModelRenderer(this, 0, 16);
        this.body.addBox(-2.0F, 0.0F, -1.0F, 4, 6, 2);
        this.body.setDynamic(true);
        this.rightHand = new MModelRenderer(this, 0, 24);
        this.rightHand.addBox(-2.0F, -1.0F, -1.0F, 2, 6, 2);
        this.rightHand.setRotationPoint(-2.0F, 2.0F, 0.0F);
        this.rightHand.setDynamic(true);
        this.leftHand = new MModelRenderer(this, 9, 24);
        this.leftHand.addBox(0.0F, -1.0F, -1.0F, 2, 6, 2);
        this.leftHand.setRotationPoint(2.0F, 2.0F, 0.0F);
        this.leftHand.setDynamic(true);
        this.rightLeg = new MModelRenderer(this, 28, 17);
        this.rightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2);
        this.rightLeg.setRotationPoint(-1.0F, 6.0F, 0.0F);
        this.leftLeg = new MModelRenderer(this, 18, 17);
        this.leftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2);
        this.leftLeg.setRotationPoint(1.0F, 6.0F, 0.0F);
        this.hair = new MModelRenderer(this, 32, 0);
        this.hair.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
        this.hair.setDynamic(true);
        this.hair.scaleModifier = 1.1F;
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.mirror = true;
        this.Piece1.addBox("head", -4.0F, -8.0F, -4.0F, 8, 8, 8);
        this.Piece1.addBox("Shape1", -4.7F, -5.0F, 0.0F, 1, 2, 2);
        this.Piece1.addBox("Shape2", -4.7F, -4.0F, -1.0F, 1, 2, 2);
        this.Piece1.addBox("Shape3", -4.7F, -5.0F, 2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape4", 3.7F, -5.0F, 0.0F, 1, 2, 2);
        this.Piece1.addBox("Shape5", 3.7F, -4.0F, -1.0F, 1, 2, 2);
        this.Piece1.addBox("Shape6", 3.7F, -5.0F, 2.0F, 1, 1, 1);
        this.Piece1.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/elfpet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.26F) * 0.05F;
        float f2 = MathHelper.cos(time * 0.16F);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f2 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.Piece1.rotationY = modelPlayer.bipedHead.rotateAngleY + 0.2F;
        this.Piece1.rotationX = modelPlayer.bipedHead.rotateAngleX / 2.0F;
        this.Piece1.rotationZ = modelPlayer.bipedHead.rotateAngleZ;
        this.hair.rotationX = this.Piece1.rotationX;
        this.hair.rotationY = this.Piece1.rotationY;
        this.hair.rotationZ = this.Piece1.rotationZ;
        this.rightLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 2.5F + f1 * 3.0F;
        this.leftLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 2.5F + -f1 * 3.0F;
        this.leftLeg.rotationZ = f * 5.0F;
        this.leftHand.rotationX = modelPlayer.bipedLeftArm.rotateAngleX / 1.2F + f2 * 0.1F;
        this.leftHand.rotationY = -f2 * f * 2.0F;
        this.leftHand.rotationZ = f2 * f * 4.0F;
        this.rightHand.rotationX = -this.leftHand.rotationX;
        this.rightHand.rotationY = -this.leftHand.rotationY;
        this.rightHand.rotationZ = this.leftHand.rotationZ;
    }

    public String getName()
    {
        return "\u042d\u043b\u044c\u0444";
    }
}
