package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MayaHat extends BaseItem
{
    private final MModelRenderer Piece1;

    public MayaHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape1", 42, 0);
        this.setTextureOffset("Piece1.Shape2", 41, 0);
        this.setTextureOffset("Piece1.Shape3", 42, 0);
        this.setTextureOffset("Piece1.Shape4", 42, 0);
        this.setTextureOffset("Piece1.Shape5", 42, 0);
        this.setTextureOffset("Piece1.Shape6", 42, 0);
        this.setTextureOffset("Piece1.Shape7", 42, 0);
        this.setTextureOffset("Piece1.Shape8", 42, 0);
        this.setTextureOffset("Piece1.Shape9", 12, 27);
        this.setTextureOffset("Piece1.Shape10", 14, 22);
        this.setTextureOffset("Piece1.Shape11", 39, 0);
        this.setTextureOffset("Piece1.Shape12", 41, 0);
        this.setTextureOffset("Piece1.Shape13", 0, 27);
        this.setTextureOffset("Piece1.Shape14", 0, 28);
        this.setTextureOffset("Piece1.Shape15", 0, 28);
        this.setTextureOffset("Piece1.Shape16", 0, 28);
        this.setTextureOffset("Piece1.Shape17", 0, 28);
        this.setTextureOffset("Piece1.Shape18", 0, 28);
        this.setTextureOffset("Piece1.Shape19", 42, 0);
        this.setTextureOffset("Piece1.Shape20", 42, 0);
        this.setTextureOffset("Piece1.Shape21", 42, 0);
        this.setTextureOffset("Piece1.Shape22", 42, 0);
        this.setTextureOffset("Piece1.Shape23", 42, 0);
        this.setTextureOffset("Piece1.Shape24", 42, 0);
        this.setTextureOffset("Piece1.Shape25", 42, 0);
        this.setTextureOffset("Piece1.Shape26", 42, 0);
        this.setTextureOffset("Piece1.Shape27", 42, 0);
        this.setTextureOffset("Piece1.Shape28", 47, 21);
        this.setTextureOffset("Piece1.Shape29", 35, 20);
        this.setTextureOffset("Piece1.Shape30", 35, 22);
        this.setTextureOffset("Piece1.Shape31", 47, 20);
        this.setTextureOffset("Piece1.Shape32", 38, 22);
        this.setTextureOffset("Piece1.Shape35", 55, 22);
        this.setTextureOffset("Piece1.Shape33", 51, 22);
        this.setTextureOffset("Piece1.Shape34", 55, 22);
        this.setTextureOffset("Piece1.Shape36", 55, 22);
        this.setTextureOffset("Piece1.Shape37", 35, 22);
        this.setTextureOffset("Piece1.Shape38", 35, 22);
        this.setTextureOffset("Piece1.Shape39", 35, 22);
        this.setTextureOffset("Piece1.Shape40", 35, 22);
        this.setTextureOffset("Piece1.Shape41", 35, 22);
        this.setTextureOffset("Piece1.Shape42", 35, 22);
        this.setTextureOffset("Piece1.Shape43", 55, 22);
        this.setTextureOffset("Piece1.Shape44", 55, 22);
        this.setTextureOffset("Piece1.Shape45", 55, 22);
        this.setTextureOffset("Piece1.Shape46", 35, 22);
        this.setTextureOffset("Piece1.Shape47", 35, 22);
        this.setTextureOffset("Piece1.Shape48", 35, 22);
        this.setTextureOffset("Piece1.Shape49", 55, 22);
        this.setTextureOffset("Piece1.Shape50", 55, 22);
        this.setTextureOffset("Piece1.Shape51", 55, 22);
        this.setTextureOffset("Piece1.Shape52", 55, 22);
        this.setTextureOffset("Piece1.Shape53", 55, 22);
        this.setTextureOffset("Piece1.Shape54", 55, 22);
        this.setTextureOffset("Piece1.Shape55", 55, 22);
        this.setTextureOffset("Piece1.Shape56", 32, 22);
        this.setTextureOffset("Piece1.Shape57", 35, 22);
        this.setTextureOffset("Piece1.Shape58", 35, 22);
        this.setTextureOffset("Piece1.Shape59", 35, 22);
        this.setTextureOffset("Piece1.Shape60", 35, 22);
        this.setTextureOffset("Piece1.Shape61", 55, 22);
        this.setTextureOffset("Piece1.Shape62", 35, 22);
        this.setTextureOffset("Piece1.Shape63", 55, 22);
        this.setTextureOffset("Piece1.Shape64", 35, 22);
        this.setTextureOffset("Piece1.Shape65", 55, 22);
        this.setTextureOffset("Piece1.Shape66", 55, 22);
        this.setTextureOffset("Piece1.Shape67", 35, 22);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape1", -3.0F, -9.0F, -3.0F, 6, 1, 1);
        this.Piece1.addBox("Shape2", -3.0F, -9.0F, 2.0F, 6, 1, 1);
        this.Piece1.addBox("Shape3", -2.0F, -12.0F, -3.0F, 1, 3, 1);
        this.Piece1.addBox("Shape4", 1.0F, -12.0F, -3.0F, 1, 3, 1);
        this.Piece1.addBox("Shape5", -1.0F, -12.0F, -3.0F, 2, 1, 1);
        this.Piece1.addBox("Shape6", -2.0F, -12.0F, 2.0F, 4, 1, 1);
        this.Piece1.addBox("Shape7", -2.0F, -11.0F, 2.0F, 1, 2, 1);
        this.Piece1.addBox("Shape8", 1.0F, -11.0F, 2.0F, 1, 2, 1);
        this.Piece1.addBox("Shape9", -1.0F, -11.0F, -3.3F, 2, 2, 1);
        this.Piece1.addBox("Shape10", -1.0F, -11.0F, 2.3F, 2, 2, 1);
        this.Piece1.addBox("Shape11", -4.0F, -10.0F, -2.0F, 8, 2, 4);
        this.Piece1.addBox("Shape12", -3.0F, -12.0F, -2.0F, 6, 2, 4);
        this.Piece1.addBox("Shape13", 2.0F, -10.0F, 1.3F, 1, 1, 1);
        this.Piece1.addBox("Shape14", -3.0F, -10.0F, 1.3F, 1, 1, 1);
        this.Piece1.addBox("Shape15", -3.0F, -10.0F, -2.3F, 1, 1, 1);
        this.Piece1.addBox("Shape16", 2.0F, -10.0F, -2.3F, 1, 1, 1);
        this.Piece1.addBox("Shape17", -1.0F, -13.0F, -2.3F, 2, 1, 1);
        this.Piece1.addBox("Shape18", -1.0F, -13.0F, 1.3F, 2, 1, 1);
        this.Piece1.addBox("Shape19", -2.0F, -13.0F, -1.0F, 4, 1, 2);
        this.Piece1.addBox("Shape20", -1.0F, -14.0F, 1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape21", -1.0F, -14.0F, -2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape22", -2.0F, -13.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape23", 1.0F, -13.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape24", 1.0F, -13.0F, 1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape25", -2.0F, -13.0F, 1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape26", 3.0F, -11.0F, -1.5F, 1, 1, 3);
        this.Piece1.addBox("Shape27", -4.0F, -11.0F, -1.5F, 1, 1, 3);
        this.Piece1.addBox("Shape28", 0.0F, -15.0F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape29", -2.0F, -15.0F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape30", -3.0F, -18.0F, -1.0F, 1, 4, 1);
        this.Piece1.addBox("Shape31", 2.0F, -18.0F, -1.0F, 1, 4, 1);
        this.Piece1.addBox("Shape32", -2.0F, -16.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape35", -6.0F, -14.0F, -1.0F, 3, 1, 1);
        this.Piece1.addBox("Shape33", 1.0F, -16.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape34", -4.0F, -13.0F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape36", -5.0F, -13.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape37", 2.0F, -13.0F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape38", 3.0F, -14.0F, -1.0F, 3, 1, 1);
        this.Piece1.addBox("Shape39", 4.0F, -13.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape40", -6.0F, -10.5F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape41", -7.0F, -11.5F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape42", -8.0F, -11.5F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape43", 4.0F, -10.5F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape44", 5.0F, -11.5F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape45", 7.0F, -11.5F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape46", -5.0F, -12.0F, 0.0F, 2, 3, 1);
        this.Piece1.addBox("Shape47", -6.0F, -13.0F, 0.0F, 2, 2, 1);
        this.Piece1.addBox("Shape48", -7.0F, -13.0F, 0.0F, 1, 1, 1);
        this.Piece1.addBox("Shape49", 3.0F, -12.0F, 0.0F, 2, 3, 1);
        this.Piece1.addBox("Shape50", 4.0F, -13.0F, 0.0F, 2, 2, 1);
        this.Piece1.addBox("Shape51", 6.0F, -13.0F, 0.0F, 1, 1, 1);
        this.Piece1.addBox("Shape52", -4.0F, -15.0F, 0.0F, 2, 3, 1);
        this.Piece1.addBox("Shape53", -5.0F, -16.0F, 0.0F, 2, 2, 1);
        this.Piece1.addBox("Shape54", -6.0F, -18.0F, 0.0F, 1, 1, 1);
        this.Piece1.addBox("Shape55", -6.0F, -17.0F, 0.0F, 2, 2, 1);
        this.Piece1.addBox("Shape56", 2.0F, -15.0F, 0.0F, 2, 3, 1);
        this.Piece1.addBox("Shape57", 3.0F, -16.0F, 0.0F, 2, 2, 1);
        this.Piece1.addBox("Shape58", 4.0F, -17.0F, 0.0F, 2, 2, 1);
        this.Piece1.addBox("Shape59", 5.0F, -18.0F, 0.0F, 1, 1, 1);
        this.Piece1.addBox("Shape60", 0.0F, -17.0F, 0.0F, 2, 4, 1);
        this.Piece1.addBox("Shape61", -2.0F, -17.0F, 0.0F, 2, 4, 1);
        this.Piece1.addBox("Shape62", 1.0F, -18.0F, 0.0F, 2, 2, 1);
        this.Piece1.addBox("Shape63", -3.0F, -18.0F, 0.0F, 2, 2, 1);
        this.Piece1.addBox("Shape64", 2.0F, -19.0F, 0.0F, 2, 2, 1);
        this.Piece1.addBox("Shape65", -4.0F, -19.0F, 0.0F, 2, 2, 1);
        this.Piece1.addBox("Shape66", -4.0F, -20.0F, 0.0F, 1, 1, 1);
        this.Piece1.addBox("Shape67", 3.0F, -20.0F, 0.0F, 1, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "head/maya_hat.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.4F, 0.0F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "Santerimies";
    }

    public String getName()
    {
        return "\u041a\u043e\u0440\u043e\u043d\u0430 \u041c\u0430\u0439\u044f";
    }
}
