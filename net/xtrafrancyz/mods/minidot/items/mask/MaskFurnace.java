package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskFurnace extends BaseItem
{
    private final MModelRenderer Piece1;

    public MaskFurnace()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 18, 0);
        this.setTextureOffset("Piece1.Shape4", 18, 0);
        this.setTextureOffset("Piece1.Shape5", 18, 0);
        this.setTextureOffset("Piece1.Shape6", 18, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 11);
        this.setTextureOffset("Piece1.Shape8", 0, 10);
        this.setTextureOffset("Piece1.Shape9", 18, 0);
        this.setTextureOffset("Piece1.Shape10", 18, 0);
        this.setTextureOffset("Piece1.Shape11", 18, 0);
        this.setTextureOffset("Piece1.Shape12", 18, 0);
        this.setTextureOffset("Piece1.Shape13", 18, 0);
        this.setTextureOffset("Piece1.Shape14", 18, 0);
        this.setTextureOffset("Piece1.Shape15", 18, 0);
        this.setTextureOffset("Piece1.Shape17", 18, 0);
        this.setTextureOffset("Piece1.Shape18", 18, 0);
        this.setTextureOffset("Piece1.Shape19", 18, 0);
        this.setTextureOffset("Piece1.Shape20", 18, 0);
        this.setTextureOffset("Piece1.Shape21", 18, 0);
        this.setTextureOffset("Piece1.Shape22", 18, 0);
        this.setTextureOffset("Piece1.Shape23", 18, 0);
        this.setTextureOffset("Piece1.Shape24", 1, 1);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.addBox("Shape2", -4.0F, -5.0F, -1.0F, 8, 9, 1);
        this.Piece1.addBox("Shape3", -5.0F, -4.0F, -1.0F, 1, 7, 1);
        this.Piece1.addBox("Shape4", 4.0F, -4.0F, -1.0F, 1, 7, 1);
        this.Piece1.addBox("Shape5", 1.0F, -6.0F, -1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape6", -4.0F, -6.0F, -1.0F, 3, 1, 1);
        this.Piece1.addBox("Shape7", -4.0F, -2.0F, -2.0F, 8, 1, 1);
        this.Piece1.addBox("Shape8", -4.0F, 3.0F, -3.0F, 8, 1, 2);
        this.Piece1.addBox("Shape9", 4.0F, -3.0F, -2.0F, 1, 6, 1);
        this.Piece1.addBox("Shape10", -5.0F, -3.0F, -2.0F, 1, 6, 1);
        this.Piece1.addBox("Shape11", -4.0F, -5.0F, -2.0F, 1, 3, 1);
        this.Piece1.addBox("Shape12", -1.0F, -5.0F, -2.0F, 2, 3, 1);
        this.Piece1.addBox("Shape13", 3.0F, -5.0F, -2.0F, 1, 3, 1);
        this.Piece1.addBox("Shape14", 1.0F, -6.0F, -2.0F, 2, 2, 1);
        this.Piece1.addBox("Shape15", -3.0F, -6.0F, -2.0F, 2, 2, 1);
        this.Piece1.addBox("Shape17", -1.0F, 2.0F, -3.0F, 2, 1, 2);
        this.Piece1.addBox("Shape18", 0.0F, -1.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape19", 2.0F, -1.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape20", -3.0F, -1.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape21", -4.0F, 2.0F, -3.0F, 1, 1, 2);
        this.Piece1.addBox("Shape22", 3.0F, 2.0F, -3.0F, 1, 1, 2);
        this.Piece1.addBox("Shape23", -2.0F, -4.0F, -2.0F, 1, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "masks/3d_furnace.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.4F);
        GlStateManager.translate(0.0F, 0.0F, -0.3F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.1F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u041f\u0435\u0447\u043a\u0438";
    }
}
