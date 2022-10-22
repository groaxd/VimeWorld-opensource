package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskBender extends BaseItem
{
    private final MModelRenderer Piece1;

    public MaskBender()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape2", 0, 5);
        this.setTextureOffset("Piece1.Shape3", 0, 5);
        this.setTextureOffset("Piece1.Shape4", 0, 5);
        this.setTextureOffset("Piece1.Shape5", 0, 5);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 19, 0);
        this.setTextureOffset("Piece1.Shape8", 19, 0);
        this.setTextureOffset("Piece1.Shape9", 24, 0);
        this.setTextureOffset("Piece1.Shape10", 24, 0);
        this.setTextureOffset("Piece1.Shape11", 19, 0);
        this.setTextureOffset("Piece1.Shape12", 19, 0);
        this.setTextureOffset("Piece1.Shape13", 0, 11);
        this.setTextureOffset("Piece1.Shape14", 19, 11);
        this.setTextureOffset("Piece1.Shape15", 19, 11);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.addBox("Shape2", 4.0F, -5.0F, -2.0F, 1, 3, 2);
        this.Piece1.addBox("Shape3", -5.0F, -5.0F, -2.0F, 1, 3, 2);
        this.Piece1.addBox("Shape4", -4.0F, -6.0F, -2.0F, 8, 1, 2);
        this.Piece1.addBox("Shape5", -4.0F, -2.0F, -2.0F, 8, 1, 2);
        this.Piece1.addBox("Shape6", -4.0F, -5.0F, -1.0F, 8, 3, 1);
        this.Piece1.addBox("Shape7", 2.0F, -5.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape8", 2.0F, -3.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape9", 1.0F, -4.0F, -2.0F, 3, 1, 1);
        this.Piece1.addBox("Shape10", -4.0F, -4.0F, -2.0F, 3, 1, 1);
        this.Piece1.addBox("Shape11", -3.0F, -5.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape12", -3.0F, -3.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape13", -3.5F, 0.0F, -1.0F, 7, 3, 1);
        this.Piece1.addBox("Shape14", -4.5F, 1.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape15", 3.5F, 1.0F, -1.0F, 1, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "masks/3d_bender.png"));
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
        return "\u041c\u0430\u0441\u043a\u0430 \u0411\u0435\u043d\u0434\u0435\u0440\u0430";
    }
}
