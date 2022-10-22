package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskMouth extends BaseItem
{
    private final MModelRenderer Piece1;

    public MaskMouth()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape2", 0, 21);
        this.setTextureOffset("Piece1.Shape18", 0, 12);
        this.setTextureOffset("Piece1.Shape19", 0, 12);
        this.setTextureOffset("Piece1.Shape13", 10, 8);
        this.setTextureOffset("Piece1.Shape11", 10, 8);
        this.setTextureOffset("Piece1.Shape5", 0, 15);
        this.setTextureOffset("Piece1.Shape6", 5, 3);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 5, 3);
        this.setTextureOffset("Piece1.Shape8", 5, 3);
        this.setTextureOffset("Piece1.Shape9", 5, 3);
        this.setTextureOffset("Piece1.Shape10", 5, 3);
        this.setTextureOffset("Piece1.Shape12", 10, 8);
        this.setTextureOffset("Piece1.Shape13", 10, 8);
        this.setTextureOffset("Piece1.Shape14", 10, 8);
        this.setTextureOffset("Piece1.Shape15", 10, 8);
        this.setTextureOffset("Piece1.Shape16", 10, 8);
        this.setTextureOffset("Piece1.Shape17", 10, 8);
        this.setTextureOffset("Piece1.Shape20", 0, 12);
        this.setTextureOffset("Piece1.Shape21", 0, 12);
        this.setTextureOffset("Piece1.Shape22", 0, 12);
        this.setTextureOffset("Piece1.Shape23", 0, 12);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.Piece1.addBox("Shape2", -4.0F, -6.0F, -1.0F, 8, 10, 1);
        this.Piece1.addBox("Shape18", -3.0F, -3.0F, -3.0F, 1, 1, 1);
        this.Piece1.addBox("Shape19", -2.0F, 0.0F, -3.0F, 1, 1, 1);
        this.Piece1.addBox("Shape13", 4.0F, -3.0F, -3.0F, 1, 3, 1);
        this.Piece1.addBox("Shape11", -2.0F, -5.0F, -3.0F, 4, 1, 1);
        this.Piece1.addBox("Shape5", -3.0F, 0.0F, -2.0F, 6, 4, 1);
        this.Piece1.addBox("Shape6", -4.0F, -5.0F, -2.0F, 1, 8, 1);
        this.Piece1.addBox("Shape3", 4.0F, -5.0F, -1.0F, 1, 8, 1);
        this.Piece1.addBox("Shape4", -5.0F, -5.0F, -1.0F, 1, 8, 1);
        this.Piece1.addBox("Shape7", 4.0F, -4.0F, -2.0F, 1, 6, 1);
        this.Piece1.addBox("Shape8", 3.0F, -5.0F, -2.0F, 1, 8, 1);
        this.Piece1.addBox("Shape9", -5.0F, -4.0F, -2.0F, 1, 6, 1);
        this.Piece1.addBox("Shape10", -3.0F, -6.0F, -2.0F, 6, 3, 1);
        this.Piece1.addBox("Shape12", -4.0F, -4.0F, -3.0F, 8, 1, 1);
        this.Piece1.addBox("Shape13", 3.0F, -3.0F, -3.0F, 1, 4, 1);
        this.Piece1.addBox("Shape14", -4.0F, 1.0F, -3.0F, 8, 1, 1);
        this.Piece1.addBox("Shape15", -2.0F, 2.0F, -3.0F, 4, 1, 1);
        this.Piece1.addBox("Shape16", -4.0F, -3.0F, -3.0F, 1, 4, 1);
        this.Piece1.addBox("Shape17", -5.0F, -3.0F, -3.0F, 1, 3, 1);
        this.Piece1.addBox("Shape20", 2.0F, 0.0F, -3.0F, 1, 1, 1);
        this.Piece1.addBox("Shape21", 0.0F, 0.0F, -3.0F, 1, 1, 1);
        this.Piece1.addBox("Shape22", 1.0F, -3.0F, -3.0F, 1, 1, 1);
        this.Piece1.addBox("Shape23", -1.0F, -3.0F, -3.0F, 1, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "masks/3d_mouth.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.1F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u0420\u0442\u0430";
    }

    public String getCreator()
    {
        return "ANACTAC";
    }
}
