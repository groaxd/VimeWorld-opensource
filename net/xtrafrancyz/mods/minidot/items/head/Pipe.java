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

public class Pipe extends BaseItem
{
    private final MModelRenderer Piece1;
    private final MModelRenderer Piece2;
    private final MModelRenderer Piece3;

    public Pipe()
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape2", 1, 5);
        this.setTextureOffset("Piece1.Shape3", 0, 7);
        this.setTextureOffset("Piece1.Shape4", 0, 13);
        this.setTextureOffset("Piece1.Shape5", 6, 13);
        this.setTextureOffset("Piece1.Shape6", 0, 9);
        this.setTextureOffset("Piece1.Shape7", 6, 9);
        this.setTextureOffset("Piece1.Shape8", 0, 4);
        this.setTextureOffset("Piece1.Shape9", 0, 0);
        this.setTextureOffset("Piece1.Shape10", 0, 0);
        this.setTextureOffset("Piece1.Shape11", 0, 0);
        this.setTextureOffset("Piece1.Shape12", 0, 0);
        this.setTextureOffset("Piece1.Shape13", 0, 0);
        this.setTextureOffset("Piece1.Shape14", 0, 11);
        this.setTextureOffset("Piece1.Shape15", 0, 11);
        this.setTextureOffset("Piece1.Shape16", 8, 11);
        this.setTextureOffset("Piece1.Shape17", 8, 11);
        this.setTextureOffset("Piece2.Shape25", 9, 0);
        this.setTextureOffset("Piece2.Shape23", 9, 0);
        this.setTextureOffset("Piece2.Shape24", 9, 0);
        this.setTextureOffset("Piece2.Shape26", 9, 0);
        this.setTextureOffset("Piece2.Shape27", 9, 0);
        this.setTextureOffset("Piece3.Shape22", 9, 0);
        this.setTextureOffset("Piece3.Shape21", 9, 0);
        this.setTextureOffset("Piece3.Shape18", 9, 0);
        this.setTextureOffset("Piece3.Shape19", 9, 0);
        this.setTextureOffset("Piece3.Shape20", 9, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.addBox("Shape2", -4.0F, 2.0F, -3.0F, 2, 1, 1);
        this.Piece1.addBox("Shape3", -3.0F, 2.0F, -4.0F, 1, 1, 1);
        this.Piece1.addBox("Shape4", -2.0F, 0.0F, -1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape5", -1.0F, 0.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape6", -3.0F, 1.0F, -2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape7", -2.0F, 1.0F, -3.0F, 1, 1, 1);
        this.Piece1.addBox("Shape8", -5.0F, 3.0F, -5.0F, 2, 1, 2);
        this.Piece1.addBox("Shape9", -5.0F, 2.0F, -5.0F, 1, 1, 1);
        this.Piece1.addBox("Shape10", -6.0F, 1.0F, -6.0F, 2, 1, 2);
        this.Piece1.addBox("Shape11", -6.0F, 2.0F, -6.0F, 1, 1, 1);
        this.Piece1.addBox("Shape12", -6.0F, 1.0F, -7.0F, 1, 1, 1);
        this.Piece1.addBox("Shape13", -7.0F, 1.0F, -6.0F, 1, 1, 1);
        this.Piece1.addBox("Shape14", -7.0F, 0.0F, -5.0F, 3, 1, 1);
        this.Piece1.addBox("Shape15", -7.0F, 0.0F, -7.0F, 3, 1, 1);
        this.Piece1.addBox("Shape16", -7.0F, 0.0F, -6.0F, 1, 1, 1);
        this.Piece1.addBox("Shape17", -5.0F, 0.0F, -6.0F, 1, 1, 1);
        this.Piece2 = new MModelRenderer(this, "Piece2");
        this.Piece2.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.Piece2.addBox("Shape25", -7.0F, -2.3F, -5.0F, 1, 1, 1);
        this.Piece2.addBox("Shape23", -6.0F, -2.3F, -6.0F, 1, 1, 1);
        this.Piece2.addBox("Shape24", -7.0F, -3.3F, -6.0F, 1, 3, 1);
        this.Piece2.addBox("Shape26", -7.0F, -2.3F, -7.0F, 1, 1, 1);
        this.Piece2.addBox("Shape27", -8.0F, -2.3F, -6.0F, 1, 1, 1);
        this.Piece3 = new MModelRenderer(this, "Piece3");
        this.Piece3.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.Piece3.addBox("Shape22", -3.0F, -5.0F, -5.0F, 1, 1, 1);
        this.Piece3.addBox("Shape21", -5.0F, -5.0F, -5.0F, 1, 1, 1);
        this.Piece3.addBox("Shape18", -4.0F, -6.0F, -5.0F, 1, 3, 1);
        this.Piece3.addBox("Shape19", -4.0F, -5.0F, -6.0F, 1, 1, 1);
        this.Piece3.addBox("Shape20", -4.0F, -5.0F, -4.0F, 1, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "head/pipe.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.04F, 0.0F);
        this.Piece2.offsetY = 1.5F;
        this.Piece2.offsetY = -f / 4.0F;
        this.Piece3.offsetY = -f1 / 2.0F;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.3F, -0.1F, 0.6F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0422\u0440\u0443\u0431\u043a\u0430";
    }
}
