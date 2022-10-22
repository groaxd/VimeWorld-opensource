package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskPenguin extends BaseItem
{
    private final MModelRenderer Piece1;
    private final MModelRenderer Piece2;

    public MaskPenguin()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape1", 0, 0);
        this.setTextureOffset("Piece2.Shape2", 0, 12);
        this.setTextureOffset("Piece2.Shape3", 22, 0);
        this.setTextureOffset("Piece2.Shape4", 24, 3);
        this.setTextureOffset("Piece1.Shape5", 24, 6);
        this.setTextureOffset("Piece1.Shape6", 24, 10);
        this.setTextureOffset("Piece1.Shape7", 22, 12);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.Piece1.addBox("Shape1", -5.0F, -6.0F, -1.0F, 10, 10, 1);
        this.Piece1.addBox("Shape5", -1.0F, 0.0F, -2.0F, 2, 3, 1);
        this.Piece1.addBox("Shape6", -1.0F, 0.0F, -3.0F, 2, 1, 1);
        this.Piece1.addBox("Shape7", -1.0F, 1.0F, -5.0F, 2, 1, 3);
        this.Piece2 = new MModelRenderer(this, "Piece2");
        this.Piece2.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.Piece2.addBox("Shape2", -5.0F, -6.0F, -2.0F, 10, 1, 1);
        this.Piece2.addBox("Shape3", -2.0F, -5.0F, -2.0F, 4, 2, 1);
        this.Piece2.addBox("Shape4", -1.0F, -3.0F, -2.0F, 2, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "masks/3d_penguin.png"));
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
        return "\u041c\u0430\u0441\u043a\u0430 \u043f\u0438\u043d\u0433\u0432\u0438\u043d\u0430";
    }
}
