package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskZlatovlaska extends BaseItem
{
    private final MModelRenderer Piece1;
    private final MModelRenderer Piece2;

    public MaskZlatovlaska()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 14);
        this.setTextureOffset("Piece1.Shape4", 0, 11);
        this.setTextureOffset("Piece1.Shape5", 0, 9);
        this.setTextureOffset("Piece2.Shape10", 0, 9);
        this.setTextureOffset("Piece2.Shape6", 0, 9);
        this.setTextureOffset("Piece2.Shape7", 0, 9);
        this.setTextureOffset("Piece2.Shape8", 0, 9);
        this.setTextureOffset("Piece2.Shape9", 0, 9);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.Piece1.addBox("Shape2", -5.0F, -5.0F, -1.0F, 10, 7, 1);
        this.Piece1.addBox("Shape3", -4.0F, 2.0F, -1.0F, 8, 1, 1);
        this.Piece1.addBox("Shape4", -2.0F, 3.0F, -1.0F, 4, 1, 1);
        this.Piece1.addBox("Shape5", -4.0F, -6.0F, -1.0F, 8, 1, 1);
        this.Piece2 = new MModelRenderer(this, "Piece2");
        this.Piece2.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.Piece2.addBox("Shape10", -5.0F, -4.0F, -2.0F, 2, 1, 1);
        this.Piece2.addBox("Shape6", -4.0F, -6.0F, -2.0F, 8, 1, 1);
        this.Piece2.addBox("Shape7", -5.0F, -5.0F, -2.0F, 4, 1, 1);
        this.Piece2.addBox("Shape8", 1.0F, -5.0F, -2.0F, 4, 1, 1);
        this.Piece2.addBox("Shape9", 3.0F, -4.0F, -2.0F, 2, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "masks/3d_zlatovlaska.png"));
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
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u0417\u043b\u0430\u0442\u043e\u0432\u043b\u0430\u0441\u043a\u0438";
    }

    public String getCreator()
    {
        return "ThisDorry";
    }
}
