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

public class GiftPet extends BasePet
{
    private final MModelRenderer Pet;
    private final MModelRenderer RightLeg;
    private final MModelRenderer LeftLeg;

    public GiftPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.setTextureOffset("Pet.top", 0, 22);
        this.setTextureOffset("Pet.Box", 19, 0);
        this.setTextureOffset("Pet.Ribbon1", 0, 0);
        this.setTextureOffset("Pet.Ribbon2", 0, 0);
        this.setTextureOffset("Pet.Ribbon3", 0, 0);
        this.setTextureOffset("Pet.Ribbon4", 0, 0);
        this.setTextureOffset("Pet.Ribbon5", 0, 0);
        this.setTextureOffset("Pet.Ribbon6", 0, 0);
        this.setTextureOffset("Pet.Ribbon7", 0, 0);
        this.setTextureOffset("Pet.Ribbon8", 0, 0);
        this.setTextureOffset("Pet.Ribbon9", 0, 0);
        this.setTextureOffset("Pet.Ribbon10", 0, 0);
        this.setTextureOffset("Pet.Ribbon11", 0, 0);
        this.setTextureOffset("Pet.Ribbon12", 0, 0);
        this.setTextureOffset("RightLeg.RightLeg2", 1, 45);
        this.setTextureOffset("RightLeg.RightLeg3", 1, 45);
        this.setTextureOffset("RightLeg.RightLeg4", 1, 45);
        this.setTextureOffset("RightLeg.RightLeg1", 1, 45);
        this.setTextureOffset("LeftLeg.LeftLeg2", 1, 45);
        this.setTextureOffset("LeftLeg.LeftLeg3", 1, 45);
        this.setTextureOffset("LeftLeg.LeftLeg4", 1, 45);
        this.setTextureOffset("LeftLeg.LeftLeg1", 1, 45);
        this.Pet = new MModelRenderer(this, "Pet");
        this.Pet.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotation(this.Pet, 0.0F, 0.0F, 0.0F);
        this.Pet.mirror = true;
        this.Pet.addBox("top", -6.0F, -7.0F, -6.0F, 12, 2, 12);
        this.Pet.addBox("Box", -5.0F, -6.0F, -5.0F, 10, 10, 10);
        this.Pet.addBox("Ribbon1", -2.0F, -9.0F, -1.0F, 1, 2, 2);
        this.Pet.addBox("Ribbon2", -4.0F, -9.0F, -1.0F, 1, 2, 2);
        this.Pet.addBox("Ribbon3", -3.0F, -9.0F, -1.0F, 1, 1, 2);
        this.Pet.addBox("Ribbon4", -1.0F, -9.0F, 1.0F, 2, 2, 1);
        this.Pet.addBox("Ribbon5", -1.0F, -9.0F, 2.0F, 2, 1, 1);
        this.Pet.addBox("Ribbon6", -1.0F, -9.0F, 3.0F, 2, 2, 1);
        this.Pet.addBox("Ribbon7", 1.0F, -9.0F, -1.0F, 1, 2, 2);
        this.Pet.addBox("Ribbon8", 2.0F, -9.0F, -1.0F, 1, 1, 2);
        this.Pet.addBox("Ribbon9", 3.0F, -9.0F, -1.0F, 1, 2, 2);
        this.Pet.addBox("Ribbon10", -1.0F, -9.0F, -2.0F, 2, 2, 1);
        this.Pet.addBox("Ribbon11", -1.0F, -9.0F, -3.0F, 2, 1, 1);
        this.Pet.addBox("Ribbon12", -1.0F, -9.0F, -4.0F, 2, 2, 1);
        this.RightLeg = new MModelRenderer(this, "RightLeg");
        this.RightLeg.setRotationPoint(-2.5F, 4.0F, 0.5F);
        this.RightLeg.addBox("RightLeg2", 0.5F, 3.0F, -3.5F, 1, 1, 5);
        this.RightLeg.addBox("RightLeg3", -0.5F, 3.0F, -1.5F, 1, 1, 3);
        this.RightLeg.addBox("RightLeg4", -1.5F, 3.0F, -3.5F, 1, 1, 5);
        this.RightLeg.addBox("RightLeg1", -0.5F, 0.0F, -0.5F, 1, 3, 1);
        this.RightLeg.setDynamic(true);
        this.LeftLeg = new MModelRenderer(this, "LeftLeg");
        this.LeftLeg.setRotationPoint(2.5F, 4.0F, 0.5F);
        this.LeftLeg.addBox("LeftLeg2", 0.5F, 3.0F, -3.5F, 1, 1, 5);
        this.LeftLeg.addBox("LeftLeg3", -0.5F, 3.0F, -1.5F, 1, 1, 3);
        this.LeftLeg.addBox("LeftLeg4", -1.5F, 3.0F, -3.5F, 1, 1, 5);
        this.LeftLeg.addBox("LeftLeg1", -0.5F, 0.0F, -0.5F, 1, 3, 1);
        this.LeftLeg.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/gift.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.26F) * 0.05F;
        float f1 = MathHelper.cos(time * 0.1F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, 0.0F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        this.LeftLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 2.0F;
        this.RightLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 2.0F;
    }

    public String getName()
    {
        return "\u041f\u043e\u0434\u0430\u0440\u043e\u0447\u0435\u043a";
    }

    public String getCreator()
    {
        return "DJMaSyaNya";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.WHITE + "\u0418\u0437 \u0438\u0433\u0440\u044b: " + EnumChatFormatting.BOLD + "Crossy Road");
    }
}
