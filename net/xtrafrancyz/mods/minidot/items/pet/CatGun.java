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

public class CatGun extends BasePet
{
    private final MModelRenderer Body;
    private final MModelRenderer LeftHand;
    private final MModelRenderer RightHand;
    private final MModelRenderer LeftLeg;
    private final MModelRenderer RightLeg;
    private final MModelRenderer Head;
    private final MModelRenderer Eyes;

    public CatGun()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.disableAnimationInPreview = true;
        this.setTextureOffset("LeftHand.LH1", 0, 10);
        this.setTextureOffset("RightHand.RH1", 0, 10);
        this.setTextureOffset("LeftLeg.LL1", 6, 10);
        this.setTextureOffset("LeftLeg.LL2", 15, 10);
        this.setTextureOffset("RightLeg.RL1", 6, 10);
        this.setTextureOffset("RightLeg.RL2", 15, 10);
        this.setTextureOffset("Head.Shape1", 32, 0);
        this.setTextureOffset("Head.Shape2", 58, 15);
        this.setTextureOffset("Head.Shape3", 49, 15);
        this.setTextureOffset("Head.Shape4", 0, 17);
        this.setTextureOffset("Head.Shape5", 40, 27);
        this.setTextureOffset("Head.Shape6", 40, 21);
        this.setTextureOffset("Head.Shape7", 40, 21);
        this.setTextureOffset("Head.Shape8", 40, 21);
        this.setTextureOffset("Head.Shape9", 40, 21);
        this.setTextureOffset("Head.Shape10", 40, 21);
        this.setTextureOffset("Head.Shape11", 40, 21);
        this.setTextureOffset("Head.Shape12", 40, 21);
        this.setTextureOffset("Head.Shape13", 40, 21);
        this.setTextureOffset("Head.Shape14", 15, 11);
        this.setTextureOffset("Head.Shape15", 52, 21);
        this.setTextureOffset("Head.Shape16", 52, 21);
        this.setTextureOffset("Head.Shape17", 15, 11);
        this.setTextureOffset("Eyes.Shape18", 40, 17);
        this.setTextureOffset("Eyes.Shape19", 40, 17);
        this.Body = new MModelRenderer(this, 0, 0);
        this.Body.addBox(-3.5F, 0.0F, -2.5F, 7, 4, 5);
        this.LeftHand = new MModelRenderer(this, "LeftHand");
        this.LeftHand.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.LeftHand.addBox("LH1", 0.5F, 0.0F, -0.5F, 1, 4, 1);
        this.LeftHand.setDynamic(true);
        this.RightHand = new MModelRenderer(this, "RightHand");
        this.RightHand.setRotationPoint(-3.0F, 0.0F, 0.0F);
        this.RightHand.addBox("RH1", -1.5F, 0.0F, -0.5F, 1, 4, 1);
        this.RightHand.setDynamic(true);
        this.LeftLeg = new MModelRenderer(this, "LeftLeg");
        this.LeftLeg.setRotationPoint(2.0F, 4.0F, 0.0F);
        this.LeftLeg.addBox("LL1", -1.0F, 0.0F, -1.0F, 2, 2, 2);
        this.LeftLeg.addBox("LL2", -1.0F, 2.0F, -2.0F, 2, 1, 3);
        this.LeftLeg.setDynamic(true);
        this.RightLeg = new MModelRenderer(this, "RightLeg");
        this.RightLeg.setRotationPoint(-2.0F, 4.0F, 0.0F);
        this.RightLeg.addBox("RL1", -1.0F, 0.0F, -1.0F, 2, 2, 2);
        this.RightLeg.addBox("RL2", -1.0F, 2.0F, -2.0F, 2, 1, 3);
        this.RightLeg.setDynamic(true);
        this.Head = new MModelRenderer(this, "Head");
        this.Head.addBox("Shape1", -4.5F, -7.0F, -3.5F, 9, 7, 7);
        this.Head.addBox("Shape2", -2.0F, 0.0F, 2.5F, 2, 3, 1);
        this.Head.addBox("Shape3", -1.5F, -4.0F, -4.5F, 3, 2, 1);
        this.Head.addBox("Shape4", -5.5F, -11.0F, -2.5F, 11, 8, 7);
        this.Head.addBox("Shape5", -5.5F, -11.0F, -3.5F, 11, 4, 1);
        this.Head.addBox("Shape6", -4.5F, -11.0F, -4.5F, 3, 1, 1);
        this.Head.addBox("Shape7", -4.5F, -8.0F, -4.5F, 3, 1, 1);
        this.Head.addBox("Shape8", -5.5F, -11.0F, -4.5F, 1, 4, 1);
        this.Head.addBox("Shape9", -1.5F, -11.0F, -4.5F, 1, 4, 1);
        this.Head.addBox("Shape10", 1.5F, -11.0F, -4.5F, 3, 1, 1);
        this.Head.addBox("Shape11", 4.5F, -11.0F, -4.5F, 1, 4, 1);
        this.Head.addBox("Shape12", 1.5F, -8.0F, -4.5F, 3, 1, 1);
        this.Head.addBox("Shape13", 0.5F, -11.0F, -4.5F, 1, 4, 1);
        this.Head.addBox("Shape14", -4.5F, -13.0F, -1.5F, 3, 1, 2);
        this.Head.addBox("Shape15", -4.5F, -12.0F, -0.5F, 3, 1, 1);
        this.Head.addBox("Shape16", 1.5F, -12.0F, -0.5F, 3, 1, 1);
        this.Head.addBox("Shape17", 1.5F, -13.0F, -1.5F, 3, 1, 2);
        this.Eyes = new MModelRenderer(this, "Eyes");
        this.Eyes.addBox("Shape18", 2.0F, -5.5F, -3.6F, 1, 1, 1);
        this.Eyes.addBox("Shape19", -3.0F, -5.5F, -3.6F, 1, 1, 1);
        this.Eyes.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/cat_gun.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.02F;
        float f1 = MathHelper.cos(time * 0.1F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.Eyes.offsetY = modelPlayer.bipedHead.rotateAngleX * 0.015F;
        this.Eyes.offsetX = -modelPlayer.bipedHead.rotateAngleY * 0.015F;
        this.LeftHand.rotationX = modelPlayer.bipedLeftArm.rotateAngleX / 2.0F;
        this.RightHand.rotationX = modelPlayer.bipedRightArm.rotateAngleX;
        this.LeftLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 2.0F;
        this.RightLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 2.0F;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.07F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u043e\u0442 \u0441\u0442\u0440\u0435\u043b\u043e\u043a";
    }

    public String getCreator()
    {
        return "MasterChiF";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.WHITE + "\u0418\u0437 \u0438\u0433\u0440\u044b: " + EnumChatFormatting.BOLD + "Crossy Road");
    }
}
