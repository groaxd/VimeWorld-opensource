package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ChristmasHat2 extends BaseItem
{
    private final MModelRenderer Piece1;

    public ChristmasHat2()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape1", 0, 15);
        this.setTextureOffset("Piece1.Shape2", 0, 15);
        this.setTextureOffset("Piece1.Shape3", 0, 15);
        this.setTextureOffset("Piece1.Shape4", 0, 15);
        this.setTextureOffset("Piece1.Shape5", 0, 15);
        this.setTextureOffset("Piece1.Shape6", 0, 15);
        this.setTextureOffset("Piece1.Shape7", 0, 15);
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
        this.setTextureOffset("Piece1.Shape24", 56, 0);
        this.setTextureOffset("Piece1.Shape25", 0, 0);
        this.setTextureOffset("Piece1.Shape26", 0, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape1", -4.0F, -10.0F, -8.0F, 8, 2, 15);
        this.Piece1.addBox("Shape2", 4.0F, -10.0F, -7.0F, 1, 2, 13);
        this.Piece1.addBox("Shape3", 5.0F, -10.0F, -6.0F, 1, 2, 11);
        this.Piece1.addBox("Shape4", 6.0F, -10.0F, -4.0F, 1, 2, 8);
        this.Piece1.addBox("Shape5", -5.0F, -10.0F, -7.0F, 1, 2, 13);
        this.Piece1.addBox("Shape6", -6.0F, -10.0F, -6.0F, 1, 2, 11);
        this.Piece1.addBox("Shape7", -7.0F, -10.0F, -4.0F, 1, 2, 8);
        this.Piece1.addBox("Shape8", -5.0F, -11.0F, -6.0F, 10, 1, 11);
        this.Piece1.addBox("Shape9", -4.0F, -11.0F, -7.0F, 8, 1, 1);
        this.Piece1.addBox("Shape10", -4.0F, -11.0F, 5.0F, 8, 1, 1);
        this.Piece1.addBox("Shape11", -6.0F, -11.0F, -4.0F, 1, 1, 8);
        this.Piece1.addBox("Shape12", 5.0F, -11.0F, -4.0F, 1, 1, 8);
        this.Piece1.addBox("Shape13", -3.0F, -13.0F, -6.0F, 6, 2, 1);
        this.Piece1.addBox("Shape14", -4.0F, -13.0F, -5.0F, 8, 2, 10);
        this.Piece1.addBox("Shape15", -5.0F, -13.0F, -4.0F, 1, 2, 8);
        this.Piece1.addBox("Shape16", 4.0F, -13.0F, -4.0F, 1, 2, 8);
        this.Piece1.addBox("Shape17", -3.0F, -14.0F, -4.0F, 6, 1, 9);
        this.Piece1.addBox("Shape18", -3.0F, -15.0F, -1.0F, 1, 1, 4);
        this.Piece1.addBox("Shape19", -4.0F, -14.0F, -3.0F, 1, 1, 6);
        this.Piece1.addBox("Shape20", -2.0F, -15.0F, -2.0F, 4, 2, 8);
        this.Piece1.addBox("Shape21", 3.0F, -14.0F, -3.0F, 1, 1, 6);
        this.Piece1.addBox("Shape22", 2.0F, -15.0F, -1.0F, 1, 1, 4);
        this.Piece1.addBox("Shape23", -1.0F, -15.0F, 6.0F, 2, 3, 1);
        this.Piece1.addBox("Shape24", -1.0F, -13.0F, 7.0F, 2, 2, 2);
        this.Piece1.addBox("Shape25", -1.0F, -14.0F, 7.0F, 2, 1, 1);
        this.Piece1.addBox("Shape26", -2.0F, -16.0F, 0.0F, 4, 1, 3);
        this.setTexture(new ResourceLocation("minidot", "head/christmashat2.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -0.15F, 0.03F);
        GlStateManager.scale(0.751F, 0.7F, 0.75F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.3F, 0.0F);
        GlStateManager.scale(0.751F, 0.7F, 0.75F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u0430\u043f\u043a\u0430 \u0421\u0430\u043d\u0442\u044b";
    }
}
