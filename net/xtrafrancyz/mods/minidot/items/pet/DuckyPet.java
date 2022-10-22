package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class DuckyPet extends BasePet
{
    private final MModelRenderer Piece1;

    public DuckyPet()
    {
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape1", 20, 12);
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 0, 0);
        this.setTextureOffset("Piece1.Shape10", 0, 0);
        this.setTextureOffset("Piece1.Shape11", 0, 0);
        this.setTextureOffset("Piece1.Shape12", 0, 0);
        this.setTextureOffset("Piece1.Shape13", 0, 11);
        this.setTextureOffset("Piece1.Shape14", 0, 0);
        this.setTextureOffset("Piece1.Shape15", 0, 0);
        this.setTextureOffset("Piece1.Shape16", 0, 0);
        this.setTextureOffset("Piece1.Shape17", 0, 0);
        this.setTextureOffset("Piece1.Shape18", 0, 0);
        this.setTextureOffset("Piece1.Shape19", 0, 0);
        this.setTextureOffset("Piece1.Shape20", 0, 0);
        this.setTextureOffset("Piece1.Shape21", 0, 0);
        this.setTextureOffset("Piece1.Shape22", 0, 0);
        this.setTextureOffset("Piece1.Shape23", 0, 0);
        this.setTextureOffset("Piece1.Shape24", 0, 0);
        this.setTextureOffset("Piece1.Shape25", 0, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape1", -2.0F, -5.0F, -7.0F, 4, 2, 2);
        this.Piece1.addBox("Shape2", -2.0F, -8.0F, -5.0F, 4, 1, 2);
        this.Piece1.addBox("Shape3", 2.0F, -7.0F, -4.0F, 1, 4, 1);
        this.Piece1.addBox("Shape4", -1.0F, 0.0F, -4.0F, 2, 1, 1);
        this.Piece1.addBox("Shape5", -2.0F, -2.0F, -3.0F, 4, 3, 6);
        this.Piece1.addBox("Shape6", -2.0F, 1.0F, -2.0F, 4, 1, 4);
        this.Piece1.addBox("Shape7", -2.0F, -3.0F, 3.0F, 4, 2, 1);
        this.Piece1.addBox("Shape8", -1.0F, -1.0F, 3.0F, 2, 1, 1);
        this.Piece1.addBox("Shape9", -1.0F, 1.0F, 2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape10", -2.0F, -7.0F, -4.0F, 4, 7, 2);
        this.Piece1.addBox("Shape11", -1.0F, -6.0F, -2.0F, 2, 3, 1);
        this.Piece1.addBox("Shape12", -1.0F, 1.0F, -3.0F, 2, 1, 1);
        this.Piece1.addBox("Shape13", -3.0F, -7.0F, -5.0F, 6, 4, 1);
        this.Piece1.addBox("Shape14", -2.0F, -5.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape15", -1.0F, -3.0F, 2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape16", 2.0F, -6.0F, -3.0F, 1, 2, 1);
        this.Piece1.addBox("Shape17", 1.0F, -5.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape18", -3.0F, -1.0F, -3.0F, 1, 1, 5);
        this.Piece1.addBox("Shape19", -3.0F, -2.0F, -2.0F, 1, 1, 2);
        this.Piece1.addBox("Shape20", 2.0F, -1.0F, -3.0F, 1, 1, 5);
        this.Piece1.addBox("Shape21", -3.0F, 0.0F, -2.0F, 1, 1, 3);
        this.Piece1.addBox("Shape22", 2.0F, -2.0F, -2.0F, 1, 1, 2);
        this.Piece1.addBox("Shape23", 2.0F, 0.0F, -2.0F, 1, 1, 3);
        this.Piece1.addBox("Shape24", -3.0F, -6.0F, -3.0F, 1, 2, 1);
        this.Piece1.addBox("Shape25", -3.0F, -7.0F, -4.0F, 1, 4, 1);
        this.setTexture(new ResourceLocation("minidot", "pets/duckypet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(0.6F, -0.3F + f, 0.4F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.15F, 0.0F);
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "ANACTAC";
    }

    public String getName()
    {
        return "\u0423\u0442\u043e\u0447\u043a\u0430";
    }
}
