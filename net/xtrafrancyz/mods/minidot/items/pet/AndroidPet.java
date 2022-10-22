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

public class AndroidPet extends BasePet
{
    private final MModelRenderer Shape6;
    private final MModelRenderer Shape7;
    private final MModelRenderer LeftHand;
    private final MModelRenderer RightHand;
    private final MModelRenderer Head;
    private final MModelRenderer LeftLeg;
    private final MModelRenderer RightLeg;

    public AndroidPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.disableAnimationInPreview = true;
        this.setTextureOffset("Head.Shape1", 34, 0);
        this.setTextureOffset("Head.Shape2", 0, 0);
        this.setTextureOffset("Head.Shape3", 0, 0);
        this.setTextureOffset("Head.Shape4", 0, 0);
        this.setTextureOffset("Head.Shape5", 0, 0);
        this.Shape6 = new MModelRenderer(this, 0, 19);
        this.Shape6.addBox(-3.0F, 0.0F, -2.5F, 6, 1, 5);
        this.Shape7 = new MModelRenderer(this, 0, 0);
        this.Shape7.addBox(-4.0F, 1.0F, -3.5F, 8, 8, 7);
        this.LeftHand = new MModelRenderer(this, 0, 0);
        this.LeftHand.addBox(0.0F, -1.0F, -1.0F, 2, 5, 2);
        this.LeftHand.setRotationPoint(4.0F, 3.0F, -0.5F);
        this.LeftHand.setDynamic(true);
        this.RightHand = new MModelRenderer(this, 0, 0);
        this.RightHand.addBox(-2.0F, -1.0F, -1.0F, 2, 5, 2);
        this.RightHand.setRotationPoint(-4.0F, 3.0F, -0.5F);
        this.RightHand.setDynamic(true);
        this.Head = new MModelRenderer(this, "Head");
        this.Head.addBox("Shape1", -4.0F, -4.0F, -3.5F, 8, 4, 7);
        this.Head.addBox("Shape2", 2.0F, -5.0F, 0.0F, 1, 1, 1);
        this.Head.addBox("Shape3", 3.0F, -6.0F, 0.0F, 1, 1, 1);
        this.Head.addBox("Shape4", -3.0F, -5.0F, 0.0F, 1, 1, 1);
        this.Head.addBox("Shape5", -4.0F, -6.0F, 0.0F, 1, 1, 1);
        this.Head.setDynamic(true);
        this.LeftLeg = new MModelRenderer(this, 0, 0);
        this.LeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2);
        this.LeftLeg.setRotationPoint(2.0F, 9.0F, -0.5F);
        this.LeftLeg.setDynamic(true);
        this.RightLeg = new MModelRenderer(this, 0, 0);
        this.RightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2);
        this.RightLeg.setRotationPoint(-2.0F, 9.0F, -0.5F);
        this.RightLeg.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "pets/android.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.02F;
        float f1 = MathHelper.cos(time * 0.1F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.Head.rotationY = modelPlayer.bipedHead.rotateAngleY;
        this.LeftHand.rotationX = modelPlayer.bipedLeftArm.rotateAngleX / 2.0F;
        this.RightHand.rotationX = modelPlayer.bipedRightArm.rotateAngleX;
        this.LeftLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 2.0F;
        this.RightLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 2.0F;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.15F, 0.0F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "ANDROID ROBOT";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.WHITE + "\u0418\u0437 \u0438\u0433\u0440\u044b: " + EnumChatFormatting.BOLD + "Crossy Road");
    }
}
