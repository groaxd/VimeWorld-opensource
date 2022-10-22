package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ChickenHat extends BaseItem
{
    private final MModelRenderer Piece1;

    public ChickenHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape14", 0, 20);
        this.setTextureOffset("Piece1.Shape1", 0, 20);
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 0, 0);
        this.setTextureOffset("Piece1.Shape10", 0, 0);
        this.setTextureOffset("Piece1.Shape11", 7, 13);
        this.setTextureOffset("Piece1.Shape12", 0, 13);
        this.setTextureOffset("Piece1.Shape13", 0, 17);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape14", -1.0F, -12.0F, -4.0F, 2, 1, 1);
        this.Piece1.addBox("Shape1", -1.0F, -14.0F, -3.0F, 2, 2, 2);
        this.Piece1.addBox("Shape2", -4.0F, -11.0F, -4.0F, 8, 3, 9);
        this.Piece1.addBox("Shape3", -3.0F, -13.0F, 6.0F, 1, 3, 1);
        this.Piece1.addBox("Shape4", -4.0F, -12.0F, -3.0F, 8, 1, 7);
        this.Piece1.addBox("Shape5", -5.0F, -11.0F, -3.0F, 1, 3, 7);
        this.Piece1.addBox("Shape6", 4.0F, -11.0F, -3.0F, 1, 3, 7);
        this.Piece1.addBox("Shape7", -2.0F, -10.0F, 5.0F, 4, 2, 1);
        this.Piece1.addBox("Shape8", -2.0F, -12.0F, 6.0F, 1, 3, 1);
        this.Piece1.addBox("Shape9", 1.0F, -12.0F, 6.0F, 1, 3, 1);
        this.Piece1.addBox("Shape10", 2.0F, -13.0F, 6.0F, 1, 3, 1);
        this.Piece1.addBox("Shape11", 1.0F, -11.0F, -5.0F, 2, 2, 1);
        this.Piece1.addBox("Shape12", -3.0F, -11.0F, -5.0F, 2, 2, 1);
        this.Piece1.addBox("Shape13", -1.0F, -9.0F, -5.0F, 2, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "head/chicken_hat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.125F, -0.04F);
        GlStateManager.scale(1.15F, 1.01F, 1.1F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.3F, 0.0F);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u0430\u043f\u043a\u0430 \u0446\u044b\u043f\u044b";
    }

    public String getCreator()
    {
        return "ANACTAC";
    }
}
