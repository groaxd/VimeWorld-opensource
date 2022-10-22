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

public class PlungerHat extends BaseItem
{
    private final MModelRenderer Piece1;

    public PlungerHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape1", 0, 0);
        this.setTextureOffset("Piece1.Shape2", 0, 10);
        this.setTextureOffset("Piece1.Shape3", 0, 10);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 10);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 10);
        this.setTextureOffset("Piece1.Shape9", 0, 0);
        this.setTextureOffset("Piece1.Shape10", 0, 0);
        this.setTextureOffset("Piece1.Shape11", 0, 0);
        this.setTextureOffset("Piece1.Shape12", 0, 0);
        this.setTextureOffset("Piece1.Shape13", 0, 0);
        this.setTextureOffset("Piece1.Shape14", 0, 23);
        this.setTextureOffset("Piece1.Shape15", 0, 0);
        this.setTextureOffset("Piece1.Shape16", 0, 0);
        this.setTextureOffset("Piece1.Shape17", 0, 0);
        this.setTextureOffset("Piece1.Shape18", 0, 0);
        this.setTextureOffset("Piece1.Shape19", 0, 0);
        this.setTextureOffset("Piece1.Shape20", 24, 14);
        this.setTextureOffset("Piece1.Shape21", 0, 0);
        this.setTextureOffset("Piece1.Shape22", 0, 0);
        this.setTextureOffset("Piece1.Shape23", 0, 0);
        this.setTextureOffset("Piece1.Shape24", 0, 0);
        this.setTextureOffset("Piece1.Shape25", 0, 0);
        this.setTextureOffset("Piece1.Shape26", 0, 0);
        this.setTextureOffset("Piece1.Shape27", 0, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.addBox("Shape1", -4.0F, -10.0F, -3.0F, 8, 1, 6);
        this.Piece1.addBox("Shape2", 4.0F, -9.0F, -3.0F, 1, 1, 6);
        this.Piece1.addBox("Shape3", -3.0F, -9.0F, 4.0F, 6, 1, 1);
        this.Piece1.addBox("Shape4", -4.0F, -11.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape5", -5.0F, -9.0F, -3.0F, 1, 1, 6);
        this.Piece1.addBox("Shape6", -4.0F, -9.0F, -4.0F, 8, 1, 8);
        this.Piece1.addBox("Shape7", -3.0F, -11.0F, -3.0F, 6, 1, 6);
        this.Piece1.addBox("Shape8", -3.0F, -9.0F, -5.0F, 6, 1, 1);
        this.Piece1.addBox("Shape9", -3.0F, -10.0F, 3.0F, 6, 1, 1);
        this.Piece1.addBox("Shape10", -2.0F, -11.0F, 3.0F, 4, 1, 1);
        this.Piece1.addBox("Shape11", -3.0F, -10.0F, -4.0F, 6, 1, 1);
        this.Piece1.addBox("Shape12", -2.0F, -10.0F, 4.0F, 4, 1, 1);
        this.Piece1.addBox("Shape13", -5.0F, -10.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape14", -4.0F, -9.0F, -4.0F, 8, 1, 8);
        this.Piece1.addBox("Shape15", -2.0F, -11.0F, -4.0F, 4, 1, 1);
        this.Piece1.addBox("Shape16", -2.0F, -12.0F, -3.0F, 4, 1, 6);
        this.Piece1.addBox("Shape17", 4.0F, -10.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape18", 3.0F, -11.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape19", 3.0F, -11.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape20", -1.0F, -23.0F, -1.0F, 2, 10, 2);
        this.Piece1.addBox("Shape21", -2.0F, -10.0F, -5.0F, 4, 1, 1);
        this.Piece1.addBox("Shape22", 3.0F, -11.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape23", 2.0F, -12.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape24", -3.0F, -12.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape25", -2.0F, -13.0F, -1.0F, 4, 1, 2);
        this.Piece1.addBox("Shape26", -1.0F, -13.0F, -2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape27", -1.0F, -13.0F, 1.0F, 2, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "head/plungerhat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        float f = MathHelper.sin(time * 0.76F) * 0.01F;
        GlStateManager.translate(0.0F, f + -0.11F, 0.15F);
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.5F, 0.15F);
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "ANACTAC";
    }

    public String getName()
    {
        return "\u0412\u0430\u043d\u0442\u0443\u0437";
    }
}
