package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ChickenBabyPet extends BasePet
{
    private final MModelRenderer Hat;
    private final MModelRenderer RightHand;
    private final MModelRenderer LeftHand;
    private final MModelRenderer RightLeg;
    private final MModelRenderer LeftLeg;

    public ChickenBabyPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Hat.Shape1", 0, 0);
        this.setTextureOffset("Hat.Shape2", 9, 6);
        this.setTextureOffset("Hat.Shape3", 31, 0);
        this.setTextureOffset("Hat.Shape4", 13, 8);
        this.setTextureOffset("Hat.Shape5", 1, 24);
        this.setTextureOffset("RightLeg.Shape14", 3, 26);
        this.setTextureOffset("RightLeg.Shape11", 0, 25);
        this.setTextureOffset("RightLeg.Shape13", 3, 26);
        this.setTextureOffset("RightLeg.Shape9", 4, 24);
        this.setTextureOffset("LeftLeg.Shape16", 3, 26);
        this.setTextureOffset("LeftLeg.Shape15", 3, 26);
        this.setTextureOffset("LeftLeg.Shape12", 0, 25);
        this.setTextureOffset("LeftLeg.Shape10", 4, 24);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -3.5F, 0.0F, 0.0F, 7, 4, 8);
        this.Hat.addBox("Shape2", -2.5F, -1.0F, 6.0F, 5, 1, 2);
        this.Hat.addBox("Shape3", -3.5F, -6.0F, 0.0F, 7, 6, 5);
        this.Hat.addBox("Shape4", -2.53F, 0.0F, 8.0F, 5, 3, 1);
        this.Hat.addBox("Shape5", -2.47F, -4.0F, -3.0F, 5, 2, 3);
        this.RightHand = new MModelRenderer(this, 10, 0);
        this.RightHand.addBox(-2.0F, -1.0F, 0.0F, 2, 2, 4);
        this.RightHand.setRotationPoint(-3.5F, 1.0F, 2.0F);
        this.RightHand.setDynamic(true);
        this.LeftHand = new MModelRenderer(this, 10, 0);
        this.LeftHand.addBox(0.0F, -1.0F, 0.0F, 2, 2, 4);
        this.LeftHand.setRotationPoint(3.5F, 1.0F, 2.0F);
        this.LeftHand.setDynamic(true);
        this.RightLeg = new MModelRenderer(this, "RightLeg");
        this.RightLeg.setRotationPoint(-2.0F, 4.0F, 4.5F);
        this.RightLeg.addBox("Shape11", -2.5F, 4.0F, -2.5F, 4, 1, 4);
        this.RightLeg.addBox("Shape9", -0.5F, 0.0F, -0.5F, 1, 4, 1);
        this.RightLeg.setDynamic(true);
        this.LeftLeg = new MModelRenderer(this, "LeftLeg");
        this.LeftLeg.setRotationPoint(2.0F, 4.0F, 4.5F);
        this.LeftLeg.addBox("Shape12", -1.5F, 4.0F, -2.5F, 4, 1, 4);
        this.LeftLeg.addBox("Shape10", -0.5F, 0.0F, -0.5F, 1, 4, 1);
        this.LeftLeg.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/chicken_baby.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.26F) * 0.05F;
        float f1 = MathHelper.cos(time * 0.1F);
        float f2 = 0.0F;

        if (time % 70.0F > 50.0F)
        {
            f2 = MathHelper.cos(time % 70.0F * 0.15F + 0.4F) * 1.2F;
        }

        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.15F, -0.05F, 0.15F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.LeftLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 2.0F;
        this.RightLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 2.0F;
        this.LeftHand.rotationY = -f2;
        this.RightHand.rotationY = f2;
    }

    public String getName()
    {
        return "\u0423\u0442\u0451\u043d\u043e\u043a";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.WHITE + "\u0418\u0437 \u0438\u0433\u0440\u044b: " + EnumChatFormatting.BOLD + "Crossy Road");
    }
}
