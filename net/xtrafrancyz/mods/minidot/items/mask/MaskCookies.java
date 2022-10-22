package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskCookies extends BaseItem
{
    private final MModelRenderer Piece1;

    public MaskCookies()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape2", 0, 2);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 11);
        this.setTextureOffset("Piece1.Shape5", 23, 3);
        this.setTextureOffset("Piece1.Shape6", 23, 3);
        this.setTextureOffset("Piece1.Shape7", 23, 3);
        this.setTextureOffset("Piece1.Shape8", 23, 3);
        this.setTextureOffset("Piece1.Shape9", 23, 0);
        this.setTextureOffset("Piece1.Shape10", 23, 0);
        this.setTextureOffset("Piece1.Shape11", 0, 14);
        this.setTextureOffset("Piece1.Shape12", 0, 14);
        this.setTextureOffset("Piece1.Shape13", 0, 14);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.addBox("Shape2", -5.0F, -5.0F, -1.0F, 10, 8, 1);
        this.Piece1.addBox("Shape3", -4.0F, -6.0F, -1.0F, 8, 1, 1);
        this.Piece1.addBox("Shape4", -4.0F, 3.0F, -1.0F, 8, 1, 1);
        this.Piece1.addBox("Shape5", -4.0F, -3.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape6", -3.0F, -4.0F, -2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape7", 3.0F, -3.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape8", 1.0F, -4.0F, -2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape9", 1.0F, -2.0F, -2.0F, 1, 2, 1);
        this.Piece1.addBox("Shape10", -2.0F, -2.0F, -2.0F, 1, 2, 1);
        this.Piece1.addBox("Shape11", -2.0F, 2.0F, -2.0F, 4, 1, 1);
        this.Piece1.addBox("Shape12", 2.0F, 1.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape13", -3.0F, 1.0F, -2.0F, 1, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "masks/3d_cookies.png"));
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
        return "\u041c\u0430\u0441\u043a\u0430 \u041f\u0435\u0447\u0435\u043d\u044e\u0445\u0438";
    }
}
