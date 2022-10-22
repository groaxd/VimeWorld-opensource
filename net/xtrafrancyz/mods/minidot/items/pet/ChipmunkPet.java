package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ChipmunkPet extends BasePet
{
    private final MModelRenderer body;
    private final MModelRenderer body1;
    private final MModelRenderer tail;
    private final MModelRenderer rightLegFront;
    private final MModelRenderer rightLegBack;
    private final MModelRenderer leftLegFront;
    private final MModelRenderer leftLegBack;
    private final MModelRenderer Head;

    public ChipmunkPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.disableAnimationInPreview = true;
        this.setTextureOffset("Head.Shape2", 0, 0);
        this.setTextureOffset("Head.Shape1", 28, 9);
        this.setTextureOffset("Head.Shape3", 18, 11);
        this.setTextureOffset("Head.Shape4", 18, 11);
        this.setTextureOffset("Head.Shape5", 27, 0);
        this.setTextureOffset("Head.Shape6", 19, 0);
        this.setTextureOffset("Head.Shape7", 28, 11);
        this.setTextureOffset("Head.Shape8", 19, 4);
        this.setTextureOffset("Head.Shape9", 18, 7);
        this.body = new MModelRenderer(this, 0, 7);
        this.body.addBox(0.0F, 0.0F, 0.0F, 4, 3, 5);
        this.body.setRotationPoint(-2.0F, 0.0F, -2.0F);
        this.body1 = new MModelRenderer(this, 0, 15);
        this.body1.addBox(-2.5F, -1.0F, 1.0F, 5, 4, 3);
        this.tail = new MModelRenderer(this, 16, 15);
        this.tail.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 4);
        this.tail.setRotationPoint(0.0F, 1.0F, 3.5F);
        this.setRotation(this.tail, 0.3316126F, 0.0F, 0.0F);
        this.tail.setDynamic(true);
        this.rightLegFront = new MModelRenderer(this, 22, 7);
        this.rightLegFront.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1);
        this.rightLegFront.setRotationPoint(-1.5F, 3.0F, -1.5F);
        this.rightLegFront.setDynamic(true);
        this.rightLegBack = new MModelRenderer(this, 22, 9);
        this.rightLegBack.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1);
        this.rightLegBack.setRotationPoint(-1.5F, 3.0F, 2.5F);
        this.rightLegBack.setDynamic(true);
        this.leftLegFront = new MModelRenderer(this, 22, 11);
        this.leftLegFront.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1);
        this.leftLegFront.setRotationPoint(1.5F, 3.0F, -1.5F);
        this.leftLegFront.setDynamic(true);
        this.leftLegBack = new MModelRenderer(this, 22, 13);
        this.leftLegBack.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1);
        this.leftLegBack.setRotationPoint(1.5F, 3.0F, 2.5F);
        this.leftLegBack.setDynamic(true);
        this.Head = new MModelRenderer(this, "Head");
        this.Head.setRotationPoint(0.0F, 1.0F, -1.0F);
        this.Head.addBox("Shape2", -2.0F, -4.0F, -3.0F, 4, 3, 4);
        this.Head.addBox("Shape1", -1.5F, -3.0F, -2.0F, 3, 4, 2);
        this.Head.addBox("Shape3", -2.0F, -5.0F, 0.0F, 1, 1, 1);
        this.Head.addBox("Shape4", 1.0F, -5.0F, 0.0F, 1, 1, 1);
        this.Head.addBox("Shape5", 0.4F, -2.5F, -3.6F, 2, 2, 2);
        this.Head.addBox("Shape6", -2.4F, -2.5F, -3.6F, 2, 2, 2);
        this.Head.addBox("Shape7", -1.0F, -2.0F, -4.0F, 2, 1, 3);
        this.Head.addBox("Shape8", -1.0F, -2.8F, -4.1F, 2, 1, 2);
        this.Head.addBox("Shape9", -0.5F, -2.9F, -4.2F, 1, 1, 1);
        this.Head.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/chipmunk.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.26F) * 0.05F;
        float f2 = MathHelper.cos(time * 0.16F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f2 * 4.0F, 0.0F, 0.6F, 0.0F);
        GlStateManager.scale(1.4F, 1.4F, 1.4F);
        this.Head.rotationY = modelPlayer.bipedHead.rotateAngleY + 0.2F;
        this.Head.rotationX = modelPlayer.bipedHead.rotateAngleX / 2.0F + 0.2F;
        this.Head.rotationZ = modelPlayer.bipedHead.rotateAngleZ;
        this.leftLegFront.rotationX = f1;
        this.leftLegBack.rotationX = -f1;
        this.rightLegBack.rotationX = this.leftLegFront.rotationX;
        this.rightLegFront.rotationX = this.leftLegBack.rotationX;
        this.tail.rotationX = f2 * 0.2F;
        this.tail.rotationY = f1;
        this.tail.rotationZ = f1 * 2.0F;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(-0.01F, 0.0F, 0.0F);
        GlStateManager.scale(1.6F, 1.6F, 1.6F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0411\u0443\u0440\u0443\u043d\u0434\u0443\u043a";
    }
}
