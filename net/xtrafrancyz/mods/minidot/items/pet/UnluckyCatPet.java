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

public class UnluckyCatPet extends BasePet
{
    private final MModelRenderer Body;
    private final MModelRenderer Head;
    private final MModelRenderer Left_eye;
    private final MModelRenderer Right_eye;
    private final MModelRenderer Nose;
    private final MModelRenderer Tooth1;
    private final MModelRenderer Tooth2;
    private final MModelRenderer Tongue;
    private final MModelRenderer Left_ear;
    private final MModelRenderer Right_ear;
    private final MModelRenderer Snout_top;
    private final MModelRenderer Snout_bottom;
    private final MModelRenderer Snout_left;
    private final MModelRenderer Snout_right;
    private final MModelRenderer FRLeg;
    private final MModelRenderer FLLeg;
    private final MModelRenderer BLLeg;
    private final MModelRenderer BRLeg;
    private final MModelRenderer Tail;

    public UnluckyCatPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.useDisplayLists = true;
        this.setTextureOffset("FRLeg.FRL1", 54, 12);
        this.setTextureOffset("FRLeg.FRL2", 43, 12);
        this.setTextureOffset("FLLeg.FLL1", 54, 12);
        this.setTextureOffset("FLLeg.FLL2", 43, 12);
        this.setTextureOffset("BLLeg.BLL1", 56, 26);
        this.setTextureOffset("BLLeg.BLL2", 43, 46);
        this.setTextureOffset("BLLeg.BLL3", 43, 26);
        this.setTextureOffset("BRLeg.BRL1", 56, 26);
        this.setTextureOffset("BRLeg.BRL2", 43, 46);
        this.setTextureOffset("BRLeg.BRL3", 43, 26);
        this.setTextureOffset("Tail.Tail1", 3, 56);
        this.setTextureOffset("Tail.Tail2", 14, 56);
        this.setTextureOffset("Tail.Tail3", 22, 57);
        this.Body = new MModelRenderer(this, 0, 26);
        this.Body.addBox(-3.5F, -6.0F, 4.0F, 7, 8, 13);
        this.Head = new MModelRenderer(this, 10, 0);
        this.Head.addBox(-4.5F, -8.0F, 0.0F, 9, 9, 4);
        this.Left_eye = new MModelRenderer(this, 37, 0);
        this.Left_eye.addBox(0.5F, -7.0F, -1.0F, 3, 3, 1);
        this.Right_eye = new MModelRenderer(this, 37, 6);
        this.Right_eye.addBox(-3.5F, -7.0F, -1.0F, 3, 3, 1);
        this.Nose = new MModelRenderer(this, 0, 5);
        this.Nose.addBox(-0.5F, -5.0F, -1.0F, 1, 1, 1);
        this.Tooth1 = new MModelRenderer(this, 59, 6);
        this.Tooth1.addBox(-1.5F, -3.0F, -0.8F, 1, 1, 1);
        this.Tooth2 = new MModelRenderer(this, 59, 0);
        this.Tooth2.addBox(0.5F, -3.0F, -0.8F, 1, 1, 1);
        this.Tongue = new MModelRenderer(this, 0, 0);
        this.Tongue.addBox(-1.5F, -1.0F, -0.8F, 3, 1, 1);
        this.Left_ear = new MModelRenderer(this, 48, 0);
        this.Left_ear.addBox(1.5F, -10.0F, 0.0F, 3, 2, 1);
        this.Right_ear = new MModelRenderer(this, 48, 6);
        this.Right_ear.addBox(-4.5F, -10.0F, 0.0F, 3, 2, 1);
        this.Snout_top = new MModelRenderer(this, 10, 15);
        this.Snout_top.addBox(-2.5F, -4.0F, -1.0F, 5, 1, 1);
        this.Snout_bottom = new MModelRenderer(this, 10, 19);
        this.Snout_bottom.addBox(-2.5F, 0.0F, -1.0F, 5, 1, 1);
        this.Snout_left = new MModelRenderer(this, 32, 15);
        this.Snout_left.addBox(2.5F, -4.0F, -1.0F, 2, 5, 1);
        this.Snout_right = new MModelRenderer(this, 24, 15);
        this.Snout_right.addBox(-4.5F, -4.0F, -1.0F, 2, 5, 1);
        this.FRLeg = new MModelRenderer(this, "FRLeg");
        this.FRLeg.setRotationPoint(-2.5F, 1.0F, 5.0F);
        this.FRLeg.setDynamic(true);
        this.FRLeg.addBox("FRL1", -1.0F, 3.0F, -2.0F, 2, 1, 3);
        this.FRLeg.addBox("FRL2", -1.0F, 0.0F, -1.0F, 2, 3, 2);
        this.FLLeg = new MModelRenderer(this, "FLLeg");
        this.FLLeg.setRotationPoint(2.5F, 1.0F, 5.0F);
        this.FLLeg.setDynamic(true);
        this.FLLeg.addBox("FLL1", -1.0F, 3.0F, -2.0F, 2, 1, 3);
        this.FLLeg.addBox("FLL2", -1.0F, 0.0F, -1.0F, 2, 3, 2);
        this.BLLeg = new MModelRenderer(this, "BLLeg");
        this.BLLeg.setRotationPoint(2.5F, 1.0F, 16.1F);
        this.BLLeg.setDynamic(true);
        this.BLLeg.addBox("BLL1", -1.0F, 0.0F, -0.5F, 2, 3, 2);
        this.BLLeg.addBox("BLL2", -1.0F, 3.0F, -1.5F, 2, 1, 3);
        this.BLLeg.addBox("BLL3", -1.0F, -2.4F, -1.5F, 2, 4, 3);
        this.BRLeg = new MModelRenderer(this, "BRLeg");
        this.BRLeg.setRotationPoint(-2.5F, 1.0F, 16.1F);
        this.BRLeg.setDynamic(true);
        this.BRLeg.addBox("BRL1", -1.0F, 0.0F, -0.5F, 2, 3, 2);
        this.BRLeg.addBox("BRL2", -1.0F, 3.0F, -1.5F, 2, 1, 3);
        this.BRLeg.addBox("BRL3", -1.0F, -2.4F, -1.5F, 2, 4, 3);
        this.Tail = new MModelRenderer(this, "Tail");
        this.Tail.setRotationPoint(0.0F, -4.5F, 17.0F);
        this.Tail.setDynamic(true);
        this.Tail.addBox("Tail1", -0.5F, -0.5F, 0.0F, 1, 1, 3);
        this.Tail.addBox("Tail2", -0.5F, -0.5F, 3.0F, 1, 4, 1);
        this.Tail.addBox("Tail3", -0.5F, 2.5F, 4.0F, 1, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "pets/unlucky_cat.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.05F) * 0.05F;
        float f1 = MathHelper.cos(time * 0.1F);
        float f2 = MathHelper.sin(time * 0.1F) * 0.25F;
        GlStateManager.translate(0.6F, -0.5F + f, 0.18F);
        GlStateManager.rotate(f1 * 2.0F, 0.0F, 0.6F, 0.0F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        this.BRLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX;
        this.FLLeg.rotationX = this.BRLeg.rotationX;
        this.BLLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX;
        this.FRLeg.rotationX = this.BLLeg.rotationX;
        this.Tail.rotationY = f2;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.07F, -0.3F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041d\u0435\u0432\u0435\u0437\u0443\u0447\u0438\u0439 \u041a\u043e\u0442";
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
