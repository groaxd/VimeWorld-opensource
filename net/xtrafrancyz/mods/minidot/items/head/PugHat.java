package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class PugHat extends BaseItem
{
    private final MModelRenderer Piece1;
    private final MModelRenderer Shape24;

    public PugHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape1", 0, 0);
        this.setTextureOffset("Piece1.Shape2", 45, 6);
        this.setTextureOffset("Piece1.Shape3", 50, 6);
        this.setTextureOffset("Piece1.Shape4", 55, 6);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 0, 15);
        this.setTextureOffset("Piece1.Shape10", 15, 15);
        this.setTextureOffset("Piece1.Shape11", 34, 0);
        this.setTextureOffset("Piece1.Shape12", 0, 0);
        this.setTextureOffset("Piece1.Shape13", 0, 0);
        this.setTextureOffset("Piece1.Shape14", 0, 0);
        this.setTextureOffset("Piece1.Shape15", 34, 0);
        this.setTextureOffset("Piece1.Shape16", 0, 0);
        this.setTextureOffset("Piece1.Shape17", 0, 0);
        this.setTextureOffset("Piece1.Shape18", 47, 13);
        this.setTextureOffset("Piece1.Shape19", 16, 25);
        this.setTextureOffset("Piece1.Shape20", 0, 0);
        this.setTextureOffset("Piece1.Shape21", 0, 0);
        this.setTextureOffset("Piece1.Shape22", 0, 24);
        this.setTextureOffset("Piece1.Shape23", 0, 29);
        this.setTextureOffset("Piece1.Shape25", 0, 0);
        this.setTextureOffset("Piece1.Shape26", 0, 0);
        this.setTextureOffset("Piece1.Shape27", 45, 0);
        this.setTextureOffset("Piece1.Shape28", 0, 0);
        this.setTextureOffset("Piece1.Shape29", 45, 0);
        this.setTextureOffset("Piece1.Shape30", 45, 10);
        this.setTextureOffset("Piece1.Shape31", 45, 10);
        this.setTextureOffset("Piece1.Shape32", 47, 13);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape1", -3.0F, -12.0F, -4.0F, 6, 4, 10);
        this.Piece1.addBox("Shape2", 0.0F, -13.0F, 6.0F, 1, 2, 1);
        this.Piece1.addBox("Shape3", -1.0F, -14.0F, 6.0F, 1, 2, 1);
        this.Piece1.addBox("Shape4", -2.0F, -14.0F, 6.0F, 1, 1, 1);
        this.Piece1.addBox("Shape5", -4.0F, -10.0F, -5.0F, 1, 2, 11);
        this.Piece1.addBox("Shape6", 3.0F, -10.0F, -5.0F, 1, 2, 11);
        this.Piece1.addBox("Shape7", -5.0F, -10.0F, 3.0F, 1, 2, 3);
        this.Piece1.addBox("Shape8", 4.0F, -10.0F, 3.0F, 1, 2, 3);
        this.Piece1.addBox("Shape9", -6.0F, -10.0F, -8.0F, 2, 2, 5);
        this.Piece1.addBox("Shape10", 4.0F, -10.0F, -8.0F, 2, 2, 5);
        this.Piece1.addBox("Shape11", 3.0F, -16.0F, -4.0F, 1, 6, 4);
        this.Piece1.addBox("Shape12", 3.0F, -15.0F, -5.0F, 1, 4, 1);
        this.Piece1.addBox("Shape13", 3.0F, -15.0F, 0.0F, 1, 4, 1);
        this.Piece1.addBox("Shape14", -4.0F, -15.0F, -5.0F, 1, 4, 1);
        this.Piece1.addBox("Shape15", -4.0F, -16.0F, -4.0F, 1, 6, 4);
        this.Piece1.addBox("Shape16", -4.0F, -15.0F, 0.0F, 1, 4, 1);
        this.Piece1.addBox("Shape17", -2.0F, -17.0F, -5.0F, 4, 1, 6);
        this.Piece1.addBox("Shape18", -4.5F, -13.0F, -3.0F, 1, 1, 2);
        this.Piece1.addBox("Shape19", -3.0F, -15.0F, -6.0F, 6, 5, 2);
        this.Piece1.addBox("Shape20", -2.0F, -16.0F, 1.0F, 4, 1, 1);
        this.Piece1.addBox("Shape21", -2.0F, -10.0F, -6.0F, 4, 1, 2);
        this.Piece1.addBox("Shape22", -2.0F, -13.0F, -7.0F, 4, 3, 1);
        this.Piece1.addBox("Shape23", -1.0F, -10.0F, -8.0F, 2, 1, 2);
        this.Piece1.addBox("Shape25", -2.0F, -16.0F, -6.0F, 4, 1, 1);
        this.Piece1.addBox("Shape26", -3.0F, -15.0F, 1.0F, 6, 3, 1);
        this.Piece1.addBox("Shape27", -3.0F, -17.0F, -4.0F, 1, 1, 4);
        this.Piece1.addBox("Shape28", -3.0F, -16.0F, -5.0F, 6, 1, 6);
        this.Piece1.addBox("Shape29", 2.0F, -17.0F, -4.0F, 1, 1, 4);
        this.Piece1.addBox("Shape30", -4.5F, -15.0F, -4.0F, 1, 2, 4);
        this.Piece1.addBox("Shape31", 3.5F, -15.0F, -4.0F, 1, 2, 4);
        this.Piece1.addBox("Shape32", 3.5F, -13.0F, -3.0F, 1, 1, 2);
        this.Shape24 = new MModelRenderer(this, 1, 29);
        this.Shape24.addBox(-1.0F, -10.0F, -8.0F, 2, 2, 1);
        this.setTexture(new ResourceLocation("minidot", "head/pughat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        float f = MathHelper.sin(time * 0.76F) * 0.01F;
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
        GlStateManager.translate(0.0F, -0.22F, 0.03F);
        this.Shape24.offsetY = f / 2.0F;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.4F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u043e\u043f\u0441";
    }

    public String getCreator()
    {
        return "ThisDorry";
    }
}
