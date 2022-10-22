package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskTiki extends BaseItem
{
    private final MModelRenderer Piece1;

    public MaskTiki()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 21);
        this.setTextureOffset("Piece1.Shape4", 0, 16);
        this.setTextureOffset("Piece1.Shape5", 9, 12);
        this.setTextureOffset("Piece1.Shape6", 9, 8);
        this.setTextureOffset("Piece1.Shape7", 0, 11);
        this.setTextureOffset("Piece1.Shape8", 0, 11);
        this.setTextureOffset("Piece1.Shape9", 0, 25);
        this.setTextureOffset("Piece1.Shape10", 0, 8);
        this.setTextureOffset("Piece1.Shape11", 0, 8);
        this.setTextureOffset("Piece1.Shape12", 0, 8);
        this.setTextureOffset("Piece1.Shape13", 0, 8);
        this.setTextureOffset("Piece1.Shape14", 18, 12);
        this.setTextureOffset("Piece1.Shape15", 23, 17);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.Piece1.addBox("Shape2", -5.0F, -6.0F, -2.0F, 10, 5, 2);
        this.Piece1.addBox("Shape3", -4.0F, -1.0F, -2.0F, 8, 1, 2);
        this.Piece1.addBox("Shape4", -5.0F, 0.0F, -1.0F, 10, 3, 1);
        this.Piece1.addBox("Shape5", -5.0F, 3.0F, -2.0F, 2, 1, 2);
        this.Piece1.addBox("Shape6", 3.0F, 3.0F, -2.0F, 2, 1, 2);
        this.Piece1.addBox("Shape7", -5.0F, 0.0F, -2.0F, 1, 3, 1);
        this.Piece1.addBox("Shape8", 4.0F, 0.0F, -2.0F, 1, 3, 1);
        this.Piece1.addBox("Shape9", -4.0F, 2.0F, -2.0F, 8, 1, 1);
        this.Piece1.addBox("Shape10", -4.0F, 0.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape11", -2.0F, 1.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape12", -1.0F, 0.0F, -2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape13", 2.0F, 0.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape14", 0.0F, 1.0F, -3.0F, 3, 1, 2);
        this.Piece1.addBox("Shape15", 0.0F, 2.0F, -3.0F, 3, 2, 1);
        this.setTexture(new ResourceLocation("minidot", "masks/3d_tiki.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.0F, -0.072F);
        GlStateManager.scale(0.8F, 0.8F, 0.54F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.1F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u0422\u0438\u043a\u0438";
    }

    public String getCreator()
    {
        return "ThisDorry";
    }
}
