package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class PanamaHat extends BaseItem
{
    private final MModelRenderer Piece1;

    public PanamaHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape1", 0, 30);
        this.setTextureOffset("Piece1.Shape2", 0, 30);
        this.setTextureOffset("Piece1.Shape3", 35, 0);
        this.setTextureOffset("Piece1.Shape4", 42, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 29);
        this.setTextureOffset("Piece1.Shape6", 11, 20);
        this.setTextureOffset("Piece1.Shape7", 32, 0);
        this.setTextureOffset("Piece1.Shape8", 8, 0);
        this.setTextureOffset("Piece1.Shape9", 26, 0);
        this.setTextureOffset("Piece1.Shape10", 26, 0);
        this.setTextureOffset("Piece1.Shape11", 32, 0);
        this.setTextureOffset("Piece1.Shape12", 30, 0);
        this.setTextureOffset("Piece1.Shape13", 36, 0);
        this.setTextureOffset("Piece1.Shape14", 31, 0);
        this.setTextureOffset("Piece1.Shape15", 36, 0);
        this.setTextureOffset("Piece1.Shape16", 0, 26);
        this.setTextureOffset("Piece1.Shape17", 0, 16);
        this.setTextureOffset("Piece1.Shape18", 0, 26);
        this.setTextureOffset("Piece1.Shape19", 0, 16);
        this.setTextureOffset("Piece1.Shape20", 0, 29);
        this.setTextureOffset("Piece1.Shape21", 0, 29);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.addBox("Shape1", 2.0F, -9.0F, 8.0F, 1, 1, 1);
        this.Piece1.addBox("Shape2", -3.0F, -9.0F, 8.0F, 1, 1, 1);
        this.Piece1.addBox("Shape3", -2.0F, -14.0F, -5.0F, 1, 1, 1);
        this.Piece1.addBox("Shape4", 1.0F, -14.0F, -5.0F, 1, 1, 1);
        this.Piece1.addBox("Shape5", -3.0F, -10.0F, 6.0F, 2, 1, 2);
        this.Piece1.addBox("Shape6", -4.0F, -13.0F, -4.0F, 8, 4, 8);
        this.Piece1.addBox("Shape7", -8.0F, -9.0F, -4.0F, 1, 1, 8);
        this.Piece1.addBox("Shape8", -7.0F, -9.0F, -7.0F, 14, 1, 14);
        this.Piece1.addBox("Shape9", -4.0F, -9.0F, 7.0F, 8, 1, 1);
        this.Piece1.addBox("Shape10", -4.0F, -9.0F, -8.0F, 8, 1, 1);
        this.Piece1.addBox("Shape11", 7.0F, -9.0F, -4.0F, 1, 1, 8);
        this.Piece1.addBox("Shape12", 1.0F, -14.0F, -4.0F, 2, 1, 8);
        this.Piece1.addBox("Shape13", 3.0F, -14.0F, -3.0F, 1, 1, 6);
        this.Piece1.addBox("Shape14", -3.0F, -14.0F, -4.0F, 2, 1, 8);
        this.Piece1.addBox("Shape15", -4.0F, -14.0F, -3.0F, 1, 1, 6);
        this.Piece1.addBox("Shape16", 4.0F, -11.0F, -2.0F, 1, 2, 4);
        this.Piece1.addBox("Shape17", -2.0F, -13.0F, -5.0F, 4, 4, 1);
        this.Piece1.addBox("Shape18", -5.0F, -11.0F, -2.0F, 1, 2, 4);
        this.Piece1.addBox("Shape19", -2.0F, -13.0F, 4.0F, 4, 4, 1);
        this.Piece1.addBox("Shape20", -1.0F, -11.0F, 5.0F, 2, 2, 1);
        this.Piece1.addBox("Shape21", 1.0F, -10.0F, 6.0F, 2, 1, 2);
        this.setTexture(new ResourceLocation("minidot", "head/panamahat.png"));
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
        return "\u041f\u0430\u043d\u0430\u043c\u0430";
    }
}
