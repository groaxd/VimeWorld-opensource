package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskPinocchio extends BaseItem
{
    private final MModelRenderer Piece1;
    private final MModelRenderer Piece2;

    public MaskPinocchio()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 5, 12);
        this.setTextureOffset("Piece1.Shape3", 0, 12);
        this.setTextureOffset("Piece1.Shape7", 10, 15);
        this.setTextureOffset("Piece1.Shape8", 0, 22);
        this.setTextureOffset("Piece1.Shape9", 3, 24);
        this.setTextureOffset("Piece2.Shape5", 10, 12);
        this.setTextureOffset("Piece2.Shape6", 10, 12);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.Piece1.addBox("Shape2", -4.0F, -6.0F, -1.0F, 8, 10, 1);
        this.Piece1.addBox("Shape4", 4.0F, -5.0F, -1.0F, 1, 8, 1);
        this.Piece1.addBox("Shape3", -5.0F, -5.0F, -1.0F, 1, 8, 1);
        this.Piece1.addBox("Shape7", -2.0F, 2.0F, -2.0F, 4, 3, 1);
        this.Piece1.addBox("Shape8", -1.0F, 0.0F, -6.0F, 2, 1, 4);
        this.Piece1.addBox("Shape9", -1.0F, -1.0F, -2.0F, 2, 2, 1);
        this.Piece2 = new MModelRenderer(this, "Piece2");
        this.Piece2.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.Piece2.addBox("Shape5", -4.0F, -5.0F, -1.5F, 3, 1, 1);
        this.Piece2.addBox("Shape6", 1.0F, -5.0F, -1.5F, 3, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "masks/3d_pinocchio.png"));
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
        return "\u041c\u0430\u0441\u043a\u0430 \u041f\u0438\u043d\u043e\u043a\u043a\u0438\u043e";
    }
}
