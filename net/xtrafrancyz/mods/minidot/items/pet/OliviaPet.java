package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class OliviaPet extends BasePet
{
    private final MModelRenderer Body;
    private final MModelRenderer LeftHand;
    private final MModelRenderer RightHand;
    private final MModelRenderer LeftLeg;
    private final MModelRenderer RightLeg;
    private final MModelRenderer Head;

    public OliviaPet()
    {
        this.disableAnimationInPreview = true;
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.useDisplayLists = true;
        this.setTextureOffset("Head.Shape1", 35, 0);
        this.setTextureOffset("Head.1", 0, 0);
        this.setTextureOffset("Head.7", 35, 0);
        this.setTextureOffset("Head.8", 34, 28);
        this.setTextureOffset("Head.9", 35, 12);
        this.setTextureOffset("Head.10", 75, 0);
        this.setTextureOffset("Head.11", 69, 19);
        this.setTextureOffset("Head.12", 35, 12);
        this.setTextureOffset("Head.13", 81, 0);
        this.setTextureOffset("Head.14", 70, 8);
        this.setTextureOffset("Head.15", 4, 52);
        this.setTextureOffset("Head.16", 13, 53);
        this.setTextureOffset("Head.17", 4, 52);
        this.setTextureOffset("Head.18", 92, 0);
        this.setTextureOffset("Head.19", 101, 0);
        this.setTextureOffset("Head.20", 111, 0);
        this.setTextureOffset("Head.21", 100, 40);
        this.setTextureOffset("Head.22", 59, 30);
        this.setTextureOffset("Head.23", 55, 44);
        this.setTextureOffset("Head.24", 118, 0);
        this.setTextureOffset("Head.25", 92, 0);
        this.setTextureOffset("Head.26", 101, 0);
        this.setTextureOffset("Head.27", 111, 0);
        this.setTextureOffset("Head.28", 100, 40);
        this.setTextureOffset("Head.29", 59, 30);
        this.setTextureOffset("Head.30", 55, 44);
        this.setTextureOffset("Head.31", 118, 0);
        this.setTextureOffset("Head.32", 21, 40);
        this.setTextureOffset("Head.33", 67, 0);
        this.setTextureOffset("Head.34", 96, 7);
        this.Body = new MModelRenderer(this, 0, 36);
        this.Body.addBox(-2.0F, -0.6F, -1.0F, 4, 4, 2);
        this.Body.setDynamic(true);
        this.LeftHand = new MModelRenderer(this, 0, 24);
        this.LeftHand.addBox(0.0F, -1.0F, -1.0F, 2, 4, 2);
        this.LeftHand.setRotationPoint(2.0F, 1.0F, 0.0F);
        this.LeftHand.setDynamic(true);
        this.RightHand = new MModelRenderer(this, 14, 17);
        this.RightHand.addBox(-2.0F, -1.0F, -1.0F, 2, 4, 2);
        this.RightHand.setRotationPoint(-2.0F, 1.0F, 0.0F);
        this.RightHand.setDynamic(true);
        this.LeftLeg = new MModelRenderer(this, 14, 24);
        this.LeftLeg.addBox(-1.0F, -0.6F, -1.0F, 2, 4, 2);
        this.LeftLeg.setRotationPoint(1.0F, 4.0F, 0.0F);
        this.LeftLeg.setDynamic(true);
        this.RightLeg = new MModelRenderer(this, 24, 24);
        this.RightLeg.addBox(-1.0F, -0.6F, -1.0F, 2, 4, 2);
        this.RightLeg.setRotationPoint(-1.0F, 4.0F, 0.0F);
        this.RightLeg.setDynamic(true);
        this.Head = new MModelRenderer(this, "Head");
        this.Head.addBox("Shape1", 3.0F, -9.4F, -4.0F, 1, 1, 8);
        this.Head.addBox("1", -4.0F, -8.4F, -4.0F, 8, 8, 8);
        this.Head.addBox("7", -4.0F, -9.4F, -4.0F, 7, 1, 8);
        this.Head.addBox("8", -4.0F, -11.4F, -4.0F, 4, 1, 8);
        this.Head.addBox("9", 4.0F, -9.4F, -3.0F, 1, 3, 7);
        this.Head.addBox("10", 4.0F, -9.4F, -4.0F, 1, 2, 1);
        this.Head.addBox("11", -5.0F, -10.4F, -5.0F, 8, 3, 1);
        this.Head.addBox("12", -5.0F, -10.4F, -3.0F, 1, 4, 7);
        this.Head.addBox("13", -5.0F, -10.4F, -4.0F, 1, 3, 1);
        this.Head.addBox("14", -5.0F, -10.4F, 4.0F, 8, 4, 1);
        this.Head.addBox("15", 1.0F, -10.4F, -5.6F, 3, 3, 1);
        this.Head.addBox("16", -1.0F, -9.4F, -5.6F, 2, 1, 1);
        this.Head.addBox("17", -4.0F, -10.4F, -5.6F, 3, 3, 1);
        this.Head.addBox("18", 4.0F, -6.6F, -3.0F, 1, 2, 1);
        this.Head.addBox("19", 3.8F, -4.6F, -2.0F, 1, 1, 1);
        this.Head.addBox("20", 4.0F, -6.6F, 0.0F, 1, 2, 1);
        this.Head.addBox("21", 4.0F, -6.6F, 1.0F, 1, 3, 3);
        this.Head.addBox("22", 5.0F, -6.0F, 1.0F, 3, 2, 2);
        this.Head.addBox("23", 6.0F, -4.0F, 1.0F, 2, 1, 2);
        this.Head.addBox("24", 8.0F, -4.0F, 1.0F, 1, 1, 2);
        this.Head.addBox("25", -5.0F, -6.6F, -3.0F, 1, 2, 1);
        this.Head.addBox("26", -4.8F, -4.6F, -2.0F, 1, 1, 1);
        this.Head.addBox("27", -5.0F, -6.6F, 0.0F, 1, 2, 1);
        this.Head.addBox("28", -5.0F, -6.6F, 1.0F, 1, 3, 3);
        this.Head.addBox("29", -8.0F, -6.0F, 1.0F, 3, 2, 2);
        this.Head.addBox("30", -8.0F, -4.0F, 1.0F, 2, 1, 2);
        this.Head.addBox("31", -9.0F, -4.0F, 1.0F, 1, 1, 2);
        this.Head.addBox("32", -5.0F, -6.5F, 4.0F, 10, 4, 1);
        this.Head.addBox("33", 3.0F, -9.4F, -5.0F, 2, 2, 1);
        this.Head.addBox("34", 3.0F, -9.4F, 4.0F, 2, 3, 1);
        this.Head.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/oliviapet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.26F) * 0.05F;
        float f2 = MathHelper.cos(time * 0.16F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f2 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.Head.rotationY = modelPlayer.bipedHead.rotateAngleY + 0.2F;
        this.Head.rotationX = modelPlayer.bipedHead.rotateAngleX / 2.0F;
        this.Head.rotationZ = modelPlayer.bipedHead.rotateAngleZ;
        this.RightLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 2.5F + f1 * 3.0F;
        this.LeftLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 2.5F + -f1 * 3.0F;
        this.LeftLeg.rotationZ = f * 5.0F;
        this.LeftHand.rotationX = modelPlayer.bipedLeftArm.rotateAngleX / 1.2F + f2 * 0.1F;
        this.LeftHand.rotationY = -f2 * f * 2.0F;
        this.LeftHand.rotationZ = f2 * f * 4.0F;
        this.RightHand.rotationX = -this.LeftHand.rotationX;
        this.RightHand.rotationY = -this.LeftHand.rotationY;
        this.RightHand.rotationZ = this.LeftHand.rotationZ;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.1F, 0.0F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "Egor_Centr";
    }

    public String getName()
    {
        return "\u041e\u043b\u0438\u0432\u0438\u044f";
    }
}
