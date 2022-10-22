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

public class OwlPet extends BasePet
{
    private static final ResourceLocation tex = new ResourceLocation("minidot", "pets/owlpet.png");
    private static final ResourceLocation tex1 = new ResourceLocation("minidot", "pets/owlpet2.png");
    private final MModelRenderer Body;
    private final MModelRenderer LeftLeg;
    private final MModelRenderer RightLeg;
    private final MModelRenderer LeftHand;
    private final MModelRenderer RightHand;
    private final MModelRenderer Tail;
    private final MModelRenderer Head;

    public OwlPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.disableAnimationInPreview = true;
        this.setTextureOffset("LeftLeg.LL", 58, 9);
        this.setTextureOffset("LeftLeg.Lp", 59, 9);
        this.setTextureOffset("RightLeg.RL", 59, 9);
        this.setTextureOffset("RightLeg.Rp", 59, 9);
        this.setTextureOffset("LeftHand.lreka", 0, 0);
        this.setTextureOffset("RightHand.Shape7", 25, 0);
        this.setTextureOffset("RightHand.Shape2", 0, 0);
        this.setTextureOffset("Tail.Shape1", 0, 0);
        this.setTextureOffset("Head.Shape4", 25, 16);
        this.setTextureOffset("Head.Shape22", 59, 9);
        this.setTextureOffset("Head.Shape20", 48, 0);
        this.setTextureOffset("Head.Shape21", 59, 9);
        this.setTextureOffset("Head.Shape19", 46, 0);
        this.setTextureOffset("Head.Shape18", 48, 0);
        this.setTextureOffset("Head.Shape5", 0, 0);
        this.setTextureOffset("Head.Shape17", 48, 0);
        this.setTextureOffset("Head.Shape16", 46, 0);
        this.setTextureOffset("Head.Shape6", 0, 0);
        this.setTextureOffset("Head.Shape15", 48, 0);
        this.setTextureOffset("Head.Shape8", 48, 0);
        this.setTextureOffset("Head.Shape9", 48, 0);
        this.setTextureOffset("Head.Shape14", 48, 0);
        this.setTextureOffset("Head.Shape13", 46, 0);
        this.setTextureOffset("Head.Shape10", 48, 0);
        this.setTextureOffset("Head.Shape12", 46, 0);
        this.setTextureOffset("Head.Shape11", 48, 0);
        this.Body = new MModelRenderer(this, 0, 22);
        this.Body.addBox(-3.5F, 0.0F, -2.5F, 7, 4, 5);
        this.LeftLeg = new MModelRenderer(this, "LeftLeg");
        this.LeftLeg.setRotationPoint(2.0F, 4.0F, 0.0F);
        this.LeftLeg.addBox("LL", -0.5F, 0.0F, -0.5F, 1, 3, 1);
        this.LeftLeg.addBox("Lp", -0.5F, 2.0F, -1.5F, 1, 1, 1);
        this.LeftLeg.setDynamic(true);
        this.RightLeg = new MModelRenderer(this, "RightLeg");
        this.RightLeg.setRotationPoint(-2.0F, 4.0F, 0.0F);
        this.RightLeg.addBox("RL", -0.5F, 0.0F, -0.5F, 1, 3, 1);
        this.RightLeg.addBox("Rp", -0.5F, 2.0F, -1.5F, 1, 1, 1);
        this.RightLeg.setDynamic(true);
        this.LeftHand = new MModelRenderer(this, "LeftHand");
        this.LeftHand.setRotationPoint(3.0F, 2.0F, 0.0F);
        this.LeftHand.addBox("lreka", 0.5F, 0.0F, -1.0F, 1, 3, 2);
        this.RightHand = new MModelRenderer(this, "RightHand");
        this.RightHand.setRotationPoint(-3.5F, 2.0F, 0.0F);
        this.RightHand.addBox("Shape7", -4.5F, -2.0F, -3.5F, 3, 4, 3);
        this.RightHand.addBox("Shape2", -2.5F, -1.0F, -0.5F, 3, 2, 1);
        this.Tail = new MModelRenderer(this, "Tail");
        this.Tail.setRotationPoint(0.0F, 2.0F, 2.5F);
        this.Tail.addBox("Shape1", -1.5F, 0.0F, 0.0F, 3, 4, 1);
        this.Head = new MModelRenderer(this, "Head");
        this.Head.addBox("Shape4", -5.5F, -8.0F, -3.5F, 11, 8, 7);
        this.Head.addBox("Shape22", -0.5F, -3.0F, -5.5F, 1, 1, 1);
        this.Head.addBox("Shape20", -0.5F, -4.0F, -4.5F, 1, 1, 1);
        this.Head.addBox("Shape21", -0.5F, -3.0F, -4.5F, 1, 2, 1);
        this.Head.addBox("Shape19", 0.5F, -2.0F, -4.5F, 5, 1, 1);
        this.Head.addBox("Shape18", 4.5F, -5.0F, -4.5F, 1, 3, 1);
        this.Head.addBox("Shape5", -3.5F, -10.0F, -0.5F, 1, 2, 2);
        this.Head.addBox("Shape17", 0.5F, -5.0F, -4.5F, 1, 3, 1);
        this.Head.addBox("Shape16", 0.5F, -6.0F, -4.5F, 5, 1, 1);
        this.Head.addBox("Shape6", 2.5F, -10.0F, -0.5F, 1, 2, 2);
        this.Head.addBox("Shape15", -1.5F, -5.0F, -4.5F, 1, 3, 1);
        this.Head.addBox("Shape8", -6.5F, -5.0F, -1.5F, 1, 2, 1);
        this.Head.addBox("Shape9", 5.5F, -5.0F, -1.5F, 1, 2, 1);
        this.Head.addBox("Shape14", -5.5F, -5.0F, -4.5F, 1, 3, 1);
        this.Head.addBox("Shape13", -5.5F, -2.0F, -4.5F, 5, 1, 1);
        this.Head.addBox("Shape10", -6.5F, -5.0F, -4.5F, 1, 1, 3);
        this.Head.addBox("Shape12", -5.5F, -6.0F, -4.5F, 5, 1, 1);
        this.Head.addBox("Shape11", 5.5F, -5.0F, -4.5F, 1, 1, 3);
        this.Head.setDynamic(true);
        this.setTexture(tex);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.cos(time * 0.16F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.RightLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 4.0F + f1 * 0.1F;
        this.LeftLeg.rotationX = -this.RightLeg.rotationX;
        this.Head.rotationX = modelPlayer.bipedHead.rotateAngleX / 2.0F;
        this.Head.rotationY = modelPlayer.bipedHead.rotateAngleY % ((float)Math.PI * 2F) * 0.5F;
        this.Head.rotationZ = modelPlayer.bipedHead.rotateAngleZ;

        if (time % 120.0F > 50.0F)
        {
            this.setTexture(tex);
        }
        else if (time % 20.0F > 5.0F)
        {
            this.setTexture(tex1);
        }
        else
        {
            this.setTexture(tex);
        }
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.07F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u043e\u0432\u0443\u0448\u043a\u0430";
    }

    public String getCreator()
    {
        return "Santerimies";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.WHITE + "\u0418\u0437 \u0438\u0433\u0440\u044b: " + EnumChatFormatting.BOLD + "Crossy Road");
    }
}
