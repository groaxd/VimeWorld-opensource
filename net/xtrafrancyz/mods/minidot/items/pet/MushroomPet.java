package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MushroomPet extends BasePet
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer body;
    private static MModelRenderer RightLeg;
    private static MModelRenderer LeftLeg;
    private static MModelRenderer LeftHand;
    private static MModelRenderer RightHand;
    private static MModelRenderer Head;
    private static MModelRenderer bone7;
    private String color;

    public MushroomPet(String color)
    {
        this.disableAnimationInPreview = true;
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.color = color;

        if (body == null)
        {
            body = new MModelRenderer(this);
            body.cubeList.add(new ModelBox(body, 0, 16, -4.0F, -16.0F, -3.0F, 8, 8, 4, 0.0F, false));
            RightLeg = new MModelRenderer(this);
            RightLeg.setRotationPoint(-2.0F, -8.0F, -1.0F);
            this.setRotation(RightLeg, -0.0873F, 0.0F, 0.0F);
            RightLeg.cubeList.add(new ModelBox(RightLeg, 32, 48, -2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F, false));
            RightLeg.setDynamic(true);
            LeftLeg = new MModelRenderer(this);
            LeftLeg.setRotationPoint(2.0F, -8.0F, -1.0F);
            this.setRotation(LeftLeg, 0.0873F, 0.0F, 0.0F);
            LeftLeg.cubeList.add(new ModelBox(LeftLeg, 48, 48, -2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F, false));
            LeftLeg.setDynamic(true);
            LeftHand = new MModelRenderer(this);
            LeftHand.setRotationPoint(4.0F, -15.0F, -1.0F);
            this.setRotation(LeftHand, -0.0873F, 0.0F, 0.0F);
            LeftHand.cubeList.add(new ModelBox(LeftHand, 16, 48, 0.0F, -1.0F, -2.0F, 4, 8, 4, 0.0F, false));
            LeftHand.setDynamic(true);
            RightHand = new MModelRenderer(this);
            RightHand.setRotationPoint(-4.0F, -15.0F, -1.0F);
            this.setRotation(RightHand, 0.0873F, 0.0F, 0.0F);
            RightHand.cubeList.add(new ModelBox(RightHand, 0, 48, -4.0F, -1.0F, -2.0F, 4, 8, 4, 0.0F, false));
            RightHand.setDynamic(true);
            Head = new MModelRenderer(this);
            Head.setRotationPoint(0.0F, -16.0F, -1.0F);
            Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
            bone7 = new MModelRenderer(this);
            bone7.setRotationPoint(0.0F, 0.0F, 1.0F);
            this.setRotation(bone7, -0.1745F, 0.0F, 0.0F);
            Head.addChild(bone7);
            bone7.cubeList.add(new ModelBox(bone7, 0, 0, -16.0F, -21.2431F, -17.2216F, 32, 16, 32, 0.0F, false));
            Head.setDynamic(true);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.26F) * 0.05F;
        float f2 = MathHelper.cos(time * 0.16F);
        GlStateManager.scale(0.4F, 0.4F, 0.4F);
        GlStateManager.translate(1.8F, -0.5F + f, 0.7F);
        GlStateManager.rotate(f2 * 4.0F, 0.0F, 0.6F, 0.0F);
        Head.rotationY = modelPlayer.bipedHead.rotateAngleY + 0.2F;
        Head.rotationX = modelPlayer.bipedHead.rotateAngleX * 0.5F;
        Head.rotationZ = modelPlayer.bipedHead.rotateAngleZ;
        RightLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 2.5F + f1;
        LeftLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 2.5F + -f1;
        LeftHand.rotationX = modelPlayer.bipedLeftArm.rotateAngleX * 0.2F + f2 * 0.1F;
        LeftHand.rotationY = -f2 * f * 2.0F;
        LeftHand.rotationZ = f2 * f * 4.0F;
        RightHand.rotationX = -LeftHand.rotationX;
        RightHand.rotationY = -LeftHand.rotationY;
        RightHand.rotationZ = LeftHand.rotationZ;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.4F, 0.4F, 0.4F);
        GlStateManager.translate(0.0F, 0.85F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -1192516566:
                if (s.equals("nether_red"))
                {
                    b0 = 3;
                }

                break;

            case 112785:
                if (s.equals("red"))
                {
                    b0 = 1;
                }

                break;

            case 94011702:
                if (s.equals("brown"))
                {
                    b0 = 0;
                }

                break;

            case 738080860:
                if (s.equals("nether_green"))
                {
                    b0 = 2;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0411\u043e\u0440\u043e\u0432\u0438\u043a";

            case 1:
                return "\u041c\u0443\u0445\u043e\u043c\u043e\u0440";

            case 2:
                return "\u0418\u0441\u043a\u0430\u0436\u0451\u043d\u043d\u044b\u0439";

            case 3:
                return "\u0411\u0430\u0433\u0440\u044f\u043d\u0435\u0446";

            default:
                return "\u0425\u0443\u0439";
        }
    }

    public String getCreator()
    {
        return "Wenston";
    }

    static
    {
        colors.put("brown", new ResourceLocation("minidot", "pets/mushroom_brown.png"));
        colors.put("red", new ResourceLocation("minidot", "pets/mushroom_red.png"));
        colors.put("nether_red", new ResourceLocation("minidot", "pets/mushroom_nether_red.png"));
        colors.put("nether_green", new ResourceLocation("minidot", "pets/mushroom_nether_green.png"));
    }
}
