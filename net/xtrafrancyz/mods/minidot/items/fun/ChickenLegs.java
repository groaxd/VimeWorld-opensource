package net.xtrafrancyz.mods.minidot.items.fun;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ChickenLegs extends BaseItem
{
    private static final ResourceLocation[] textures = new ResourceLocation[] {new ResourceLocation("minidot", "body/chicken_legs_1.png"), new ResourceLocation("minidot", "body/chicken_legs_2.png"), new ResourceLocation("minidot", "body/chicken_legs_3.png"), new ResourceLocation("minidot", "body/chicken_legs_4.png")};
    private static MModelRenderer leftLeg;
    private static MModelRenderer rightLeg;

    public ChickenLegs()
    {
        super(ItemType.BODY);
        this.textureWidth = 16;
        this.textureHeight = 16;

        if (leftLeg == null)
        {
            leftLeg = new MModelRenderer(this);
            leftLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
            leftLeg.cubeList.add(new ModelBox(leftLeg, 8, 4, -1.1F, 0.0F, -1.0F, 2, 4, 2, 0.0F, false));
            leftLeg.cubeList.add(new ModelBox(leftLeg, 0, 0, -0.6F, 4.0F, -0.5F, 1, 7, 1, 0.0F, false));
            leftLeg.cubeList.add(new ModelBox(leftLeg, 0, 0, -0.6F, 11.0F, 1.5F, 1, 1, 1, 0.0F, false));
            leftLeg.cubeList.add(new ModelBox(leftLeg, 0, 0, 0.4F, 11.0F, -3.5F, 1, 1, 2, 0.0F, false));
            leftLeg.cubeList.add(new ModelBox(leftLeg, 0, 0, -1.6F, 11.0F, -3.5F, 1, 1, 2, 0.0F, false));
            leftLeg.cubeList.add(new ModelBox(leftLeg, 0, 0, -1.6F, 11.0F, -1.5F, 3, 1, 3, 0.0F, false));
            rightLeg = new MModelRenderer(this);
            rightLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
            rightLeg.cubeList.add(new ModelBox(rightLeg, 8, 4, -0.9F, 0.0F, -1.0F, 2, 4, 2, 0.0F, false));
            rightLeg.cubeList.add(new ModelBox(rightLeg, 0, 0, -0.4F, 4.0F, -0.5F, 1, 7, 1, 0.0F, false));
            rightLeg.cubeList.add(new ModelBox(rightLeg, 0, 0, -0.4F, 11.0F, 1.5F, 1, 1, 1, 0.0F, false));
            rightLeg.cubeList.add(new ModelBox(rightLeg, 0, 0, 0.6F, 11.0F, -3.5F, 1, 1, 2, 0.0F, false));
            rightLeg.cubeList.add(new ModelBox(rightLeg, 0, 0, -1.4F, 11.0F, -3.5F, 1, 1, 2, 0.0F, false));
            rightLeg.cubeList.add(new ModelBox(rightLeg, 0, 0, -1.4F, 11.0F, -1.5F, 3, 1, 3, 0.0F, false));
        }
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.setTexture(textures[Math.abs(player.getName().hashCode()) % textures.length]);
        modelPlayer.bipedLeftLeg.isHidden = true;
        modelPlayer.bipedRightLeg.isHidden = true;
        modelPlayer.bipedRightLegwear.isHidden = true;
        modelPlayer.bipedLeftLegwear.isHidden = true;
        rightLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX;
        leftLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX;
        rightLeg.rotationY = modelPlayer.bipedRightLeg.rotateAngleY;
        leftLeg.rotationY = modelPlayer.bipedLeftLeg.rotateAngleY;
        rightLeg.rotationZ = modelPlayer.bipedRightLeg.rotateAngleZ;
        leftLeg.rotationZ = modelPlayer.bipedLeftLeg.rotateAngleZ;
        rightLeg.rotationPointX = modelPlayer.bipedRightLeg.rotationPointX;
        leftLeg.rotationPointX = modelPlayer.bipedLeftLeg.rotationPointX;
        rightLeg.rotationPointY = modelPlayer.bipedRightLeg.rotationPointY;
        leftLeg.rotationPointY = modelPlayer.bipedLeftLeg.rotationPointY;
        rightLeg.rotationPointZ = modelPlayer.bipedRightLeg.rotationPointZ;
        leftLeg.rotationPointZ = modelPlayer.bipedLeftLeg.rotationPointZ;

        if (modelPlayer.isSneak)
        {
            rightLeg.rotationPointZ = 4.0F;
            leftLeg.rotationPointZ = 4.0F;
        }
        else
        {
            rightLeg.rotationPointZ = 0.1F;
            leftLeg.rotationPointZ = 0.1F;
        }

        rightLeg.rotationPointY = 12.0F;
        leftLeg.rotationPointY = 12.0F;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(0.0F, -0.42F, 0.4F);
        this.setTexture(textures[0]);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0443\u0440\u0438\u043d\u044b\u0435 \u043d\u043e\u0436\u043a\u0438";
    }
}
