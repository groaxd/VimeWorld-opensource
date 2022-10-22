package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class CatLegPet extends BasePet
{
    private final MModelRenderer Piece1;

    public CatLegPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape24", 0, 0);
        this.setTextureOffset("Piece1.Shape15", 17, 12);
        this.setTextureOffset("Piece1.Shape18", 25, 0);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape19", 25, 4);
        this.setTextureOffset("Piece1.Shape1", 0, 0);
        this.setTextureOffset("Piece1.Shape20", 0, 0);
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape21", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape22", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape23", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape25", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape26", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 35, 12);
        this.setTextureOffset("Piece1.Shape17", 25, 0);
        this.setTextureOffset("Piece1.Shape9", 22, 11);
        this.setTextureOffset("Piece1.Shape16", 26, 5);
        this.setTextureOffset("Piece1.Shape10", 0, 0);
        this.setTextureOffset("Piece1.Shape11", 24, 8);
        this.setTextureOffset("Piece1.Shape12", 0, 0);
        this.setTextureOffset("Piece1.Shape14", 0, 0);
        this.setTextureOffset("Piece1.Shape13", 25, 4);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.mirror = true;
        this.Piece1.addBox("Shape24", 1.0F, -11.0F, 1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape15", -3.0F, -5.0F, -1.0F, 1, 2, 1);
        this.Piece1.addBox("Shape18", -2.0F, -11.0F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape6", -5.0F, -9.0F, 0.0F, 1, 2, 1);
        this.Piece1.addBox("Shape19", -4.0F, -9.0F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape1", -3.0F, -11.0F, 0.0F, 7, 9, 1);
        this.Piece1.addBox("Shape20", -2.0F, -11.0F, 1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape2", 4.0F, -10.0F, 0.0F, 1, 4, 1);
        this.Piece1.addBox("Shape21", 5.0F, -9.0F, 0.0F, 1, 2, 1);
        this.Piece1.addBox("Shape3", -4.0F, -9.0F, 1.0F, 1, 2, 1);
        this.Piece1.addBox("Shape22", 4.0F, -9.0F, 1.0F, 1, 2, 1);
        this.Piece1.addBox("Shape4", -4.0F, -10.0F, 0.0F, 1, 4, 1);
        this.Piece1.addBox("Shape23", 1.0F, -12.0F, 0.0F, 2, 1, 1);
        this.Piece1.addBox("Shape5", 4.0F, -5.0F, 0.0F, 1, 2, 1);
        this.Piece1.addBox("Shape25", 1.0F, -11.0F, 1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape7", -2.0F, -3.0F, 1.0F, 5, 1, 1);
        this.Piece1.addBox("Shape26", -2.0F, -2.0F, 0.0F, 5, 1, 1);
        this.Piece1.addBox("Shape8", 3.0F, -5.0F, -1.0F, 1, 2, 1);
        this.Piece1.addBox("Shape17", 1.0F, -11.0F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape9", -2.0F, -6.0F, -1.0F, 5, 4, 1);
        this.Piece1.addBox("Shape16", 0.0F, -8.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape10", -3.0F, -10.0F, 1.0F, 7, 7, 1);
        this.Piece1.addBox("Shape11", -1.0F, -7.0F, -1.0F, 3, 1, 1);
        this.Piece1.addBox("Shape12", -4.0F, -5.0F, 0.0F, 1, 2, 1);
        this.Piece1.addBox("Shape14", -2.0F, -12.0F, 0.0F, 2, 1, 1);
        this.Piece1.addBox("Shape13", 3.0F, -9.0F, -1.0F, 2, 2, 1);
        this.setTexture(new ResourceLocation("minidot", "pets/catlegpet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(0.6F, -0.3F + f, 0.4F);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
        GlStateManager.translate(0.0F, 0.25F, 0.0F);
    }

    public String getCreator()
    {
        return "ANACTAC";
    }

    public String getName()
    {
        return "\u041a\u043e\u0448\u0430\u0447\u044c\u044f \u043b\u0430\u043f\u043a\u0430";
    }
}
