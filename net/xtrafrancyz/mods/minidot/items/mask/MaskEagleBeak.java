package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskEagleBeak extends BaseItem
{
    private final MModelRenderer Piece1;

    public MaskEagleBeak()
    {
        super(ItemType.MASK);
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape2", 0, 10);
        this.setTextureOffset("Piece1.Shape3", 0, 8);
        this.setTextureOffset("Piece1.Shape4", 0, 8);
        this.setTextureOffset("Piece1.Shape5", 10, 7);
        this.setTextureOffset("Piece1.Shape6", 10, 7);
        this.setTextureOffset("Piece1.Shape7", 0, 8);
        this.setTextureOffset("Piece1.Shape8", 0, 8);
        this.setTextureOffset("Piece1.Shape9", 0, 8);
        this.setTextureOffset("Piece1.Shape10", 0, 8);
        this.setTextureOffset("Piece1.Shape11", 0, 0);
        this.setTextureOffset("Piece1.Shape12", 0, 0);
        this.setTextureOffset("Piece1.Shape13", 0, 11);
        this.setTextureOffset("Piece1.Shape14", 0, 11);
        this.setTextureOffset("Piece1.Shape15", 0, 4);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.addBox("Shape2", -2.0F, -3.0F, -1.0F, 4, 2, 1);
        this.Piece1.addBox("Shape3", 1.0F, -4.0F, -1.0F, 3, 1, 1);
        this.Piece1.addBox("Shape4", -4.0F, -4.0F, -1.0F, 3, 1, 1);
        this.Piece1.addBox("Shape5", -4.0F, -3.0F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape6", 2.0F, -3.0F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape7", -5.0F, -5.0F, -1.0F, 1, 7, 1);
        this.Piece1.addBox("Shape8", 4.0F, -5.0F, -1.0F, 1, 7, 1);
        this.Piece1.addBox("Shape9", -4.0F, -1.0F, -1.0F, 3, 1, 1);
        this.Piece1.addBox("Shape10", 1.0F, -1.0F, -1.0F, 3, 1, 1);
        this.Piece1.addBox("Shape11", -1.0F, -1.0F, -3.0F, 2, 1, 3);
        this.Piece1.addBox("Shape12", -2.0F, 0.0F, -3.0F, 4, 2, 3);
        this.Piece1.addBox("Shape13", 2.0F, 0.0F, -1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape14", -4.0F, 0.0F, -1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape15", -1.0F, 0.0F, -4.0F, 2, 3, 1);
        this.setTexture(new ResourceLocation("minidot", "masks/3d_eaglebeak.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.04F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.1F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u043e\u0440\u043b\u0430";
    }
}
