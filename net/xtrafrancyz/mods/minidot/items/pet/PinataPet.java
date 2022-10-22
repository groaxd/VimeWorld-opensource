package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class PinataPet extends BasePet
{
    private final MModelRenderer BLLeg;
    private final MModelRenderer BRLeg;
    private final MModelRenderer FLLeg;
    private final MModelRenderer FRLeg;
    private final MModelRenderer Body;

    public PinataPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("BLLeg.Shape40", 58, 0);
        this.setTextureOffset("BLLeg.Shape41", 58, 5);
        this.setTextureOffset("BLLeg.Shape42", 53, 0);
        this.setTextureOffset("BRLeg.Shape43", 53, 0);
        this.setTextureOffset("BRLeg.Shape44", 58, 0);
        this.setTextureOffset("BRLeg.Shape45", 58, 5);
        this.setTextureOffset("FLLeg.Shape34", 58, 0);
        this.setTextureOffset("FLLeg.Shape35", 58, 5);
        this.setTextureOffset("FLLeg.Shape36", 53, 0);
        this.setTextureOffset("FRLeg.Shape37", 58, 0);
        this.setTextureOffset("FRLeg.Shape38", 58, 5);
        this.setTextureOffset("FRLeg.Shape39", 53, 0);
        this.setTextureOffset("Body.Shape1", 17, 19);
        this.setTextureOffset("Body.Shape2", 0, 17);
        this.setTextureOffset("Body.Shape3", 60, 16);
        this.setTextureOffset("Body.Shape4", 56, 9);
        this.setTextureOffset("Body.Shape5", 37, 2);
        this.setTextureOffset("Body.Shape6", 28, 0);
        this.setTextureOffset("Body.Shape7", 31, 21);
        this.setTextureOffset("Body.Shape8", 36, 13);
        this.setTextureOffset("Body.Shape9", 0, 0);
        this.setTextureOffset("Body.Shape10", 48, 22);
        this.setTextureOffset("Body.Shape11", 48, 22);
        this.setTextureOffset("Body.Shape12", 60, 16);
        this.setTextureOffset("Body.Shape13", 22, 24);
        this.setTextureOffset("Body.Shape14", 56, 12);
        this.setTextureOffset("Body.Shape15", 31, 18);
        this.setTextureOffset("Body.Shape16", 35, 0);
        this.setTextureOffset("Body.Shape17", 27, 4);
        this.setTextureOffset("Body.Shape18", 23, 0);
        this.setTextureOffset("Body.Shape19", 22, 3);
        this.setTextureOffset("Body.Shape20", 15, 29);
        this.setTextureOffset("Body.Shape21", 0, 24);
        this.setTextureOffset("Body.Shape22", 15, 24);
        this.setTextureOffset("Body.Shape23", 18, 16);
        this.setTextureOffset("Body.Shape24", 24, 19);
        this.setTextureOffset("Body.Shape25", 18, 12);
        this.setTextureOffset("Body.Shape26", 0, 11);
        this.setTextureOffset("Body.Shape27", 11, 12);
        this.setTextureOffset("Body.Shape28", 27, 9);
        this.setTextureOffset("Body.Shape29", 30, 12);
        this.setTextureOffset("Body.Shape30", 25, 13);
        this.setTextureOffset("Body.Shape31", 48, 0);
        this.setTextureOffset("Body.Shape32", 25, 16);
        this.setTextureOffset("Body.Shape33", 48, 0);
        this.BLLeg = new MModelRenderer(this, "BLLeg");
        this.BLLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotation(this.BLLeg, 0.0F, 0.0F, 0.0F);
        this.BLLeg.mirror = true;
        this.BLLeg.addBox("Shape40", 1.0F, 2.0F, 2.0F, 2, 3, 1);
        this.BLLeg.addBox("Shape41", 1.0F, 3.0F, 3.0F, 2, 2, 1);
        this.BLLeg.addBox("Shape42", 1.0F, 2.0F, 3.0F, 1, 1, 1);
        this.BRLeg = new MModelRenderer(this, "BRLeg");
        this.BRLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotation(this.BRLeg, 0.0F, 0.0F, 0.0F);
        this.BRLeg.mirror = true;
        this.BRLeg.addBox("Shape43", -3.0F, 2.0F, 3.0F, 1, 1, 1);
        this.BRLeg.addBox("Shape44", -4.0F, 2.0F, 2.0F, 2, 3, 1);
        this.BRLeg.addBox("Shape45", -4.0F, 3.0F, 3.0F, 2, 2, 1);
        this.FLLeg = new MModelRenderer(this, "FLLeg");
        this.FLLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotation(this.FLLeg, 0.0F, 0.0F, 0.0F);
        this.FLLeg.mirror = true;
        this.FLLeg.addBox("Shape34", 1.0F, 2.0F, -4.0F, 2, 3, 1);
        this.FLLeg.addBox("Shape35", 1.0F, 3.0F, -5.0F, 2, 2, 1);
        this.FLLeg.addBox("Shape36", 1.0F, 2.0F, -5.0F, 1, 1, 1);
        this.FRLeg = new MModelRenderer(this, "FRLeg");
        this.FRLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotation(this.FRLeg, 0.0F, 0.0F, 0.0F);
        this.FRLeg.mirror = true;
        this.FRLeg.addBox("Shape37", -4.0F, 2.0F, -4.0F, 2, 3, 1);
        this.FRLeg.addBox("Shape38", -4.0F, 3.0F, -5.0F, 2, 2, 1);
        this.FRLeg.addBox("Shape39", -3.0F, 2.0F, -5.0F, 1, 1, 1);
        this.Body = new MModelRenderer(this, "Body");
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
        this.Body.mirror = true;
        this.Body.addBox("Shape1", -2.0F, -11.0F, -6.0F, 1, 2, 2);
        this.Body.addBox("Shape2", -2.0F, -9.0F, -9.0F, 3, 1, 5);
        this.Body.addBox("Shape3", -3.0F, -3.0F, -5.0F, 1, 3, 1);
        this.Body.addBox("Shape4", -2.0F, 0.0F, 3.0F, 3, 1, 1);
        this.Body.addBox("Shape5", -2.0F, -8.0F, -6.0F, 3, 8, 3);
        this.Body.addBox("Shape6", -1.0F, -3.0F, 4.0F, 1, 1, 2);
        this.Body.addBox("Shape7", -2.0F, -4.0F, 2.0F, 3, 1, 1);
        this.Body.addBox("Shape8", -3.0F, 0.0F, -4.0F, 5, 1, 7);
        this.Body.addBox("Shape9", -3.0F, -3.0F, -4.0F, 5, 3, 8);
        this.Body.addBox("Shape10", -4.0F, -3.0F, -4.0F, 1, 3, 7);
        this.Body.addBox("Shape11", 2.0F, -3.0F, -4.0F, 1, 3, 7);
        this.Body.addBox("Shape12", 1.0F, -3.0F, -5.0F, 1, 3, 1);
        this.Body.addBox("Shape13", -3.0F, -4.0F, -4.0F, 5, 1, 6);
        this.Body.addBox("Shape14", -2.0F, 0.0F, -5.0F, 3, 1, 1);
        this.Body.addBox("Shape15", -1.0F, -4.0F, 3.0F, 1, 1, 1);
        this.Body.addBox("Shape16", -3.0F, -2.0F, 4.0F, 5, 1, 1);
        this.Body.addBox("Shape17", -2.0F, -2.0F, 5.0F, 3, 3, 1);
        this.Body.addBox("Shape18", -1.0F, 1.0F, 5.0F, 1, 1, 1);
        this.Body.addBox("Shape19", -1.0F, -2.0F, 6.0F, 1, 3, 1);
        this.Body.addBox("Shape20", -1.0F, -6.0F, -10.0F, 1, 1, 1);
        this.Body.addBox("Shape21", -2.0F, -8.0F, -10.0F, 3, 2, 4);
        this.Body.addBox("Shape22", -2.0F, -6.0F, -9.0F, 3, 1, 3);
        this.Body.addBox("Shape23", -2.0F, -12.0F, -6.0F, 1, 1, 1);
        this.Body.addBox("Shape24", 0.0F, -11.0F, -6.0F, 1, 2, 2);
        this.Body.addBox("Shape25", -1.0F, -8.0F, -3.0F, 1, 1, 2);
        this.Body.addBox("Shape26", -1.0F, -10.0F, -7.0F, 1, 1, 4);
        this.Body.addBox("Shape27", -1.0F, -9.0F, -4.0F, 1, 1, 2);
        this.Body.addBox("Shape28", -2.0F, -5.0F, -3.0F, 3, 1, 1);
        this.Body.addBox("Shape29", -1.0F, -6.0F, -3.0F, 1, 1, 2);
        this.Body.addBox("Shape30", -1.0F, -7.0F, -3.0F, 1, 1, 1);
        this.Body.addBox("Shape31", -1.0F, -3.0F, -7.0F, 1, 1, 1);
        this.Body.addBox("Shape32", 0.0F, -12.0F, -6.0F, 1, 1, 1);
        this.Body.addBox("Shape33", -1.0F, -5.0F, -7.0F, 1, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "pets/pinatapet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.scale(1.4F, 1.4F, 1.4F);
        GlStateManager.translate(0.5F, -0.3F + f, 0.4F);
        this.BRLeg.offsetY = -f1 / 2.0F;
        this.FLLeg.offsetY = -f1 / 2.0F;
        this.FRLeg.offsetY = f1 / 2.0F;
        this.BLLeg.offsetY = f1 / 2.0F;
        this.BRLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 6.0F;
        this.FLLeg.rotationX = this.BRLeg.rotationX;
        this.BLLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 6.0F;
        this.FRLeg.rotationX = this.BLLeg.rotationX;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        GlStateManager.translate(0.0F, 0.08F, 0.0F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "ANACTAC";
    }

    public String getName()
    {
        return "\u041b\u043e\u0448\u0430\u0434\u043a\u0430";
    }
}
