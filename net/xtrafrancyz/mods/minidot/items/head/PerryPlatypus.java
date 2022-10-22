package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class PerryPlatypus extends BaseItem
{
    private final MModelRenderer Piece1;

    public PerryPlatypus()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape1", 39, 0);
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 18);
        this.setTextureOffset("Piece1.Shape4", 11, 0);
        this.setTextureOffset("Piece1.Shape5", 3, 23);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 10);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 0, 0);
        this.setTextureOffset("Piece1.Shape10", 0, 0);
        this.setTextureOffset("Piece1.Shape11", 15, 20);
        this.setTextureOffset("Piece1.Shape12", 0, 18);
        this.setTextureOffset("Piece1.Shape13", 41, 0);
        this.setTextureOffset("Piece1.Shape14", 41, 7);
        this.setTextureOffset("Piece1.Shape15", 36, 0);
        this.setTextureOffset("Piece1.Shape16", 36, 7);
        this.setTextureOffset("Piece1.Shape17", 38, 0);
        this.setTextureOffset("Piece1.Shape18", 41, 0);
        this.setTextureOffset("Piece1.Shape19", 40, 7);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape1", -4.0F, -14.0F, -7.0F, 1, 1, 3);
        this.Piece1.addBox("Shape2", -2.0F, -12.0F, -4.0F, 4, 1, 1);
        this.Piece1.addBox("Shape3", -3.0F, -9.0F, 2.0F, 2, 1, 3);
        this.Piece1.addBox("Shape4", -3.0F, -11.0F, -4.0F, 6, 3, 6);
        this.Piece1.addBox("Shape5", -1.0F, -10.0F, -9.0F, 2, 1, 2);
        this.Piece1.addBox("Shape6", -4.0F, -9.0F, -8.0F, 1, 1, 4);
        this.Piece1.addBox("Shape7", -3.0F, -13.0F, -7.0F, 6, 4, 3);
        this.Piece1.addBox("Shape8", 4.0F, -9.0F, -7.0F, 1, 1, 3);
        this.Piece1.addBox("Shape9", 3.0F, -9.0F, -8.0F, 1, 1, 4);
        this.Piece1.addBox("Shape10", -5.0F, -9.0F, -7.0F, 1, 1, 3);
        this.Piece1.addBox("Shape11", -1.0F, -12.0F, 1.0F, 2, 1, 5);
        this.Piece1.addBox("Shape12", 1.0F, -9.0F, 2.0F, 2, 1, 3);
        this.Piece1.addBox("Shape13", -3.0F, -16.0F, -7.0F, 2, 1, 3);
        this.Piece1.addBox("Shape14", -1.0F, -15.0F, -4.0F, 2, 1, 1);
        this.Piece1.addBox("Shape15", -3.0F, -14.0F, -8.0F, 6, 1, 5);
        this.Piece1.addBox("Shape16", -3.0F, -15.0F, -7.0F, 6, 1, 3);
        this.Piece1.addBox("Shape17", 3.0F, -14.0F, -7.0F, 1, 1, 3);
        this.Piece1.addBox("Shape18", 1.0F, -16.0F, -7.0F, 2, 1, 3);
        this.Piece1.addBox("Shape19", -1.0F, -15.0F, -8.0F, 2, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "head/perryplatypus.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -0.065F, 0.1F);
        GlStateManager.scale(0.85F, 0.85F, 0.85F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.3F, 0.1F);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u0435\u0440\u0440\u0438-\u0423\u0442\u043a\u043e\u043d\u043e\u0441";
    }

    public String getCreator()
    {
        return "ANACTAC";
    }
}
