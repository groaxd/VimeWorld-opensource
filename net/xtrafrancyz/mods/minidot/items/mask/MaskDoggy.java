package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskDoggy extends BaseItem
{
    private final MModelRenderer Piece1;
    private final MModelRenderer Piece2;

    public MaskDoggy()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape1", 0, 25);
        this.setTextureOffset("Piece1.Shape2", 0, 19);
        this.setTextureOffset("Piece1.Shape3", 0, 16);
        this.setTextureOffset("Piece1.Shape4", 0, 22);
        this.setTextureOffset("Piece1.Shape5", 2, 22);
        this.setTextureOffset("Piece1.Shape16", 5, 9);
        this.setTextureOffset("Piece1.Shape17", 5, 9);
        this.setTextureOffset("Piece1.Shape18", 5, 9);
        this.setTextureOffset("Piece1.Shape19", 0, 4);
        this.setTextureOffset("Piece1.Shape20", 0, 0);
        this.setTextureOffset("Piece1.Shape21", 11, 0);
        this.setTextureOffset("Piece1.Shape22", 0, 4);
        this.setTextureOffset("Piece2.Shape6", 0, 15);
        this.setTextureOffset("Piece2.Shape7", 0, 15);
        this.setTextureOffset("Piece2.Shape8", 0, 15);
        this.setTextureOffset("Piece2.Shape9", 0, 15);
        this.setTextureOffset("Piece2.Shape10", 0, 15);
        this.setTextureOffset("Piece2.Shape11", 0, 15);
        this.setTextureOffset("Piece2.Shape12", 0, 12);
        this.setTextureOffset("Piece2.Shape13", 0, 12);
        this.setTextureOffset("Piece2.Shape14", 0, 15);
        this.setTextureOffset("Piece2.Shape15", 0, 15);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.Piece1.addBox("Shape1", -5.0F, -4.0F, -1.0F, 10, 6, 1);
        this.Piece1.addBox("Shape2", -4.0F, -5.0F, -1.0F, 8, 1, 1);
        this.Piece1.addBox("Shape3", -3.0F, -6.0F, -1.0F, 6, 1, 1);
        this.Piece1.addBox("Shape4", -4.0F, 2.0F, -1.0F, 8, 1, 1);
        this.Piece1.addBox("Shape5", -3.0F, 3.0F, -1.0F, 6, 1, 1);
        this.Piece1.addBox("Shape16", -2.0F, 0.0F, -2.0F, 4, 4, 1);
        this.Piece1.addBox("Shape17", 2.0F, 1.0F, -2.0F, 1, 2, 1);
        this.Piece1.addBox("Shape18", -3.0F, 1.0F, -2.0F, 1, 2, 1);
        this.Piece1.addBox("Shape19", -2.0F, 1.0F, -3.0F, 4, 3, 1);
        this.Piece1.addBox("Shape20", -2.0F, 1.0F, -4.0F, 4, 2, 1);
        this.Piece1.addBox("Shape21", -1.0F, 3.0F, -4.0F, 2, 1, 1);
        this.Piece1.addBox("Shape22", -1.0F, 0.0F, -3.0F, 2, 1, 1);
        this.Piece2 = new MModelRenderer(this, "Piece2");
        this.Piece2.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.Piece2.addBox("Shape6", 4.0F, -5.0F, -2.0F, 1, 2, 1);
        this.Piece2.addBox("Shape7", -5.0F, -5.0F, -2.0F, 1, 2, 1);
        this.Piece2.addBox("Shape8", -4.0F, -6.0F, -2.0F, 3, 1, 1);
        this.Piece2.addBox("Shape9", 1.0F, -6.0F, -2.0F, 3, 1, 1);
        this.Piece2.addBox("Shape10", -5.0F, -6.0F, -3.0F, 3, 1, 1);
        this.Piece2.addBox("Shape11", -5.0F, -5.0F, -3.0F, 1, 1, 1);
        this.Piece2.addBox("Shape12", -4.0F, -5.0F, -2.0F, 1, 1, 1);
        this.Piece2.addBox("Shape13", 3.0F, -5.0F, -2.0F, 1, 1, 1);
        this.Piece2.addBox("Shape14", 4.0F, -5.0F, -3.0F, 1, 1, 1);
        this.Piece2.addBox("Shape15", 2.0F, -6.0F, -3.0F, 3, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "masks/3d_doggy.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        this.Piece2.isHidden = player.getCurrentArmor(3) != null;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.1F, 0.0F);
        this.Piece2.isHidden = false;
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u0441\u043e\u0431\u0430\u0447\u043a\u0438";
    }
}
