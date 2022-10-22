package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ScoutHat extends BaseItem
{
    private final MModelRenderer Piece1;

    public ScoutHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape21", 7, 24);
        this.setTextureOffset("Piece1.Shape1", 12, 17);
        this.setTextureOffset("Piece1.Shape20", 7, 13);
        this.setTextureOffset("Piece1.Shape2", 0, 19);
        this.setTextureOffset("Piece1.Shape19", 12, 13);
        this.setTextureOffset("Piece1.Shape3", 42, 20);
        this.setTextureOffset("Piece1.Shape18", 0, 13);
        this.setTextureOffset("Piece1.Shape4", 44, 24);
        this.setTextureOffset("Piece1.Shape17", 7, 24);
        this.setTextureOffset("Piece1.Shape5", 0, 19);
        this.setTextureOffset("Piece1.Shape16", 0, 25);
        this.setTextureOffset("Piece1.Shape6", 54, 26);
        this.setTextureOffset("Piece1.Shape15", 54, 26);
        this.setTextureOffset("Piece1.Shape7", 20, 19);
        this.setTextureOffset("Piece1.Shape14", 46, 22);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape13", 28, 21);
        this.setTextureOffset("Piece1.Shape9", 42, 20);
        this.setTextureOffset("Piece1.Shape12", 0, 19);
        this.setTextureOffset("Piece1.Shape10", 46, 22);
        this.setTextureOffset("Piece1.Shape11", 0, 19);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.addBox("Shape21", -4.0F, -14.0F, -2.0F, 1, 2, 1);
        this.Piece1.addBox("Shape1", -6.0F, -9.0F, -7.0F, 12, 1, 14);
        this.Piece1.addBox("Shape20", -3.0F, -14.0F, -3.0F, 1, 2, 1);
        this.Piece1.addBox("Shape2", -7.0F, -9.0F, -6.0F, 1, 1, 12);
        this.Piece1.addBox("Shape19", 2.0F, -14.0F, -3.0F, 1, 2, 1);
        this.Piece1.addBox("Shape3", -6.0F, -10.0F, -5.0F, 1, 1, 10);
        this.Piece1.addBox("Shape18", 3.0F, -15.0F, -3.0F, 2, 3, 1);
        this.Piece1.addBox("Shape4", -2.0F, -13.0F, -3.0F, 4, 1, 6);
        this.Piece1.addBox("Shape17", 3.0F, -14.0F, -2.0F, 1, 2, 1);
        this.Piece1.addBox("Shape5", 6.0F, -9.0F, -6.0F, 1, 1, 12);
        this.Piece1.addBox("Shape16", -5.0F, -15.0F, -3.0F, 2, 3, 1);
        this.Piece1.addBox("Shape6", 2.0F, -13.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape15", -3.0F, -13.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape7", -5.0F, -10.0F, -6.0F, 10, 1, 12);
        this.Piece1.addBox("Shape14", -5.0F, -12.0F, -4.0F, 1, 1, 8);
        this.Piece1.addBox("Shape8", -5.0F, -11.0F, -5.0F, 10, 1, 10);
        this.Piece1.addBox("Shape13", -4.0F, -12.0F, -5.0F, 8, 1, 10);
        this.Piece1.addBox("Shape9", 5.0F, -10.0F, -5.0F, 1, 1, 10);
        this.Piece1.addBox("Shape12", 1.0F, -13.0F, -6.0F, 3, 3, 1);
        this.Piece1.addBox("Shape10", 4.0F, -12.0F, -4.0F, 1, 1, 8);
        this.Piece1.addBox("Shape11", -4.0F, -13.0F, -6.0F, 3, 3, 1);
        this.setTexture(new ResourceLocation("minidot", "head/hat_scout.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.1F, 0.25F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.35F, 0.25F);
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "ANACTAC";
    }

    public String getName()
    {
        return "\u0428\u0430\u043f\u043a\u0430 \u0441\u043a\u0430\u0443\u0442\u0430";
    }
}
