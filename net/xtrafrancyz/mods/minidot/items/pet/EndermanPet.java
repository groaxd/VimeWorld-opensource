package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class EndermanPet extends BasePet
{
    private final MModelRenderer head;
    private final MModelRenderer rightHand;
    private final MModelRenderer leftHand;
    private final MModelRenderer body;
    private final MModelRenderer rightLeg;
    private final MModelRenderer leftLeg;
    private final MModelRenderer cube;

    public EndermanPet()
    {
        this.disableAnimationInPreview = true;
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.body = new MModelRenderer(this, 32, 2);
        this.body.addBox(0.0F, 0.0F, 0.0F, 3, 4, 1);
        this.leftLeg = new MModelRenderer(this, 32, 0);
        this.leftLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
        this.leftLeg.setRotationPoint(2.5F, 4.0F, 0.5F);
        this.leftLeg.setDynamic(true);
        this.rightLeg = new MModelRenderer(this, 32, 0);
        this.rightLeg.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
        this.rightLeg.setRotationPoint(0.5F, 4.0F, 0.5F);
        this.rightLeg.setDynamic(true);
        this.head = new MModelRenderer(this, 0, 0);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
        this.head.setRotationPoint(1.5F, 0.0F, 0.5F);
        this.head.setDynamic(true);
        this.cube = new MModelRenderer(this, 48, 0);
        this.cube.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
        this.cube.setRotationPoint(0.0F, 2.0F, -5.0F);
        this.rightHand = new MModelRenderer(this, 42, 0);
        this.rightHand.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
        this.rightHand.setRotationPoint(-1.0F, 0.0F, 0.3F);
        this.setRotation(this.rightHand, -0.8726646F, 0.0F, 0.0F);
        this.leftHand = new MModelRenderer(this, 42, 0);
        this.leftHand.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
        this.leftHand.setRotationPoint(3.0F, 0.0F, 0.3F);
        this.setRotation(this.leftHand, -0.8726646F, 0.0F, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/enderman.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.03F;
        float f1 = MathHelper.sin(time * 0.26F) * 0.09F;
        float f2 = MathHelper.cos(time * 0.26F) * 0.09F;
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f * 200.0F, 1.0F, 0.6F, 0.0F);
        this.head.rotationY = f2 + modelPlayer.bipedHead.rotateAngleY + 0.2F;
        this.head.rotationX = modelPlayer.bipedHead.rotateAngleX / 2.0F;
        this.head.rotationZ = modelPlayer.bipedHead.rotateAngleZ;
        this.rightLeg.rotationX = f1 * 0.8F;
        this.rightLeg.rotationZ = f1 * 0.8F;
        this.leftLeg.rotationX = -f1 * 0.8F;
    }

    public String getName()
    {
        return "\u042d\u043d\u0434\u0435\u0440\u043c\u0435\u043d";
    }
}
