package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class WitchHat extends BaseItem
{
    private final MModelRenderer Piece1;

    public WitchHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 0, 0);
        this.setTextureOffset("Piece1.Shape10", 0, 0);
        this.setTextureOffset("Piece1.Shape11", 0, 0);
        this.setTextureOffset("Piece1.Shape12", 0, 0);
        this.setTextureOffset("Piece1.Shape13", 0, 0);
        this.setTextureOffset("Piece1.Shape14", 0, 0);
        this.setTextureOffset("Piece1.Shape15", 0, 0);
        this.setTextureOffset("Piece1.Shape16", 0, 0);
        this.setTextureOffset("Piece1.Shape17", 0, 0);
        this.setTextureOffset("Piece1.Shape18", 0, 0);
        this.setTextureOffset("Piece1.Shape19", 0, 0);
        this.setTextureOffset("Piece1.Shape20", 0, 0);
        this.setTextureOffset("Piece1.Shape21", 0, 0);
        this.setTextureOffset("Piece1.Shape22", 0, 0);
        this.setTextureOffset("Piece1.Shape23", 0, 0);
        this.setTextureOffset("Piece1.Shape24", 0, 0);
        this.setTextureOffset("Piece1.Shape25", 0, 0);
        this.setTextureOffset("Piece1.Shape26", 0, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(-0.5F, 0.0F, -0.5F);
        this.Piece1.addBox("Shape2", -7.0F, -11.0F, -4.0F, 15, 1, 9);
        this.Piece1.addBox("Shape3", -6.0F, -11.0F, -6.0F, 13, 1, 2);
        this.Piece1.addBox("Shape4", -4.0F, -11.0F, -7.0F, 9, 1, 1);
        this.Piece1.addBox("Shape5", -6.0F, -11.0F, 5.0F, 13, 1, 2);
        this.Piece1.addBox("Shape6", -4.0F, -11.0F, 7.0F, 9, 1, 1);
        this.Piece1.addBox("Shape7", -2.0F, -14.0F, -3.0F, 5, 3, 8);
        this.Piece1.addBox("Shape8", -3.0F, -14.0F, -2.0F, 7, 3, 6);
        this.Piece1.addBox("Shape9", -1.0F, -19.0F, 0.0F, 3, 5, 4);
        this.Piece1.addBox("Shape10", -1.0F, -20.0F, 2.0F, 3, 1, 3);
        this.Piece1.addBox("Shape11", 0.0F, -20.0F, 5.0F, 1, 2, 1);
        this.Piece1.addBox("Shape12", -3.0F, -12.0F, 4.0F, 7, 1, 1);
        this.Piece1.addBox("Shape13", -2.0F, -12.0F, 5.0F, 5, 1, 1);
        this.Piece1.addBox("Shape14", -4.0F, -12.0F, -1.0F, 9, 1, 5);
        this.Piece1.addBox("Shape15", 0.0F, -19.0F, 6.0F, 1, 2, 1);
        this.Piece1.addBox("Shape16", -1.0F, -15.0F, 4.0F, 3, 1, 1);
        this.Piece1.addBox("Shape17", -2.0F, -15.0F, 3.0F, 5, 1, 1);
        this.Piece1.addBox("Shape18", -1.0F, -19.0F, 4.0F, 3, 2, 1);
        this.Piece1.addBox("Shape19", -3.0F, -16.0F, 0.0F, 7, 2, 2);
        this.Piece1.addBox("Shape20", -2.0F, -16.0F, -1.0F, 5, 2, 1);
        this.Piece1.addBox("Shape21", -1.0F, -16.0F, -2.0F, 3, 2, 1);
        this.Piece1.addBox("Shape22", -1.0F, -18.0F, -1.0F, 3, 2, 1);
        this.Piece1.addBox("Shape23", -2.0F, -18.0F, 0.0F, 5, 4, 3);
        this.Piece1.addBox("Shape24", -3.0F, -17.0F, 1.0F, 7, 1, 2);
        this.Piece1.addBox("Shape25", -2.0F, -19.0F, 3.0F, 5, 2, 1);
        this.Piece1.addBox("Shape26", -2.0F, -19.0F, 1.0F, 5, 1, 2);
        this.setTexture(new ResourceLocation("minidot", "head/witch_hat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.4F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u043b\u044f\u043f\u0430 \u0432\u0435\u0434\u044c\u043c\u044b";
    }
}
