package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class CreeperPet extends BasePet
{
    private final MModelRenderer head;
    private final MModelRenderer body;
    private final MModelRenderer rightLegF;
    private final MModelRenderer rightLegB;
    private final MModelRenderer leftLegF;
    private final MModelRenderer leftLegB;

    public CreeperPet()
    {
        this.disableAnimationInPreview = true;
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.head = new MModelRenderer(this, 0, 0);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
        this.head.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.head.setDynamic(true);
        this.body = new MModelRenderer(this, 32, 0);
        this.body.addBox(0.0F, 0.0F, 0.0F, 4, 4, 2);
        this.body.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.rightLegF = new MModelRenderer(this, 0, 16);
        this.rightLegF.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2);
        this.rightLegF.setRotationPoint(-1.0F, 4.0F, 0.0F);
        this.rightLegF.setDynamic(true);
        this.rightLegB = new MModelRenderer(this, 0, 20);
        this.rightLegB.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2);
        this.rightLegB.setRotationPoint(-1.0F, 4.0F, 2.0F);
        this.rightLegB.setDynamic(true);
        this.leftLegF = new MModelRenderer(this, 0, 24);
        this.leftLegF.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2);
        this.leftLegF.setRotationPoint(1.0F, 4.0F, 0.0F);
        this.leftLegF.setDynamic(true);
        this.leftLegB = new MModelRenderer(this, 0, 28);
        this.leftLegB.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2);
        this.leftLegB.setRotationPoint(1.0F, 4.0F, 2.0F);
        this.leftLegB.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/creeper.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time);
        float f2 = MathHelper.sin(time + 90.0F);
        float f3 = MathHelper.cos(time * 0.16F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f3 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.head.rotationX = modelPlayer.bipedHead.rotateAngleX / 2.0F;
        this.head.rotationY = modelPlayer.bipedHead.rotateAngleY + 0.2F - f3 * 0.1F;
        this.head.rotationZ = modelPlayer.bipedHead.rotateAngleZ;
        this.leftLegF.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX + f1 / 3.0F;
        this.leftLegB.rotationX = modelPlayer.bipedRightLeg.rotateAngleX + f2 / 3.0F;
        this.rightLegB.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX + f1 / 3.0F;
        this.rightLegF.rotationX = modelPlayer.bipedRightLeg.rotateAngleX + f2 / 3.0F;
    }

    public String getName()
    {
        return "\u041a\u0440\u0438\u043f\u0435\u0440";
    }
}
