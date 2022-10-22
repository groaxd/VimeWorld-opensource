package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class CoffeeHat extends BaseItem
{
    private final MModelRenderer Hat;

    public CoffeeHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Hat.Shape1", 0, 0);
        this.setTextureOffset("Hat.Shape2", 4, 0);
        this.setTextureOffset("Hat.Shape3", 8, 0);
        this.setTextureOffset("Hat.Shape4", 12, 0);
        this.setTextureOffset("Hat.Shape5", 16, 0);
        this.setTextureOffset("Hat.Shape6", 20, 0);
        this.setTextureOffset("Hat.Shape7", 24, 0);
        this.setTextureOffset("Hat.Shape8", 28, 0);
        this.setTextureOffset("Hat.Shape9", 32, 0);
        this.setTextureOffset("Hat.Shape10", 36, 0);
        this.setTextureOffset("Hat.Shape11", 0, 6);
        this.setTextureOffset("Hat.Shape12", 4, 5);
        this.setTextureOffset("Hat.Shape13", 8, 4);
        this.setTextureOffset("Hat.Shape14", 0, 0);
        this.setTextureOffset("Hat.Shape15", 0, 0);
        this.setTextureOffset("Hat.Shape16", 0, 0);
        this.setTextureOffset("Hat.Shape17", 0, 0);
        this.setTextureOffset("Hat.Shape18", 0, 0);
        this.setTextureOffset("Hat.Shape19", 0, 0);
        this.setTextureOffset("Hat.Shape20", 0, 0);
        this.setTextureOffset("Hat.Shape21", 0, 0);
        this.setTextureOffset("Hat.Shape22", 0, 0);
        this.setTextureOffset("Hat.Shape23", 0, 0);
        this.setTextureOffset("Hat.Shape24", 0, 0);
        this.setTextureOffset("Hat.Shape25", 0, 0);
        this.setTextureOffset("Hat.Shape26", 10, 11);
        this.setTextureOffset("Hat.Shape27", 13, 15);
        this.setTextureOffset("Hat.Shape28", 23, 11);
        this.setTextureOffset("Hat.Shape29", 0, 12);
        this.setTextureOffset("Hat.Shape30", 0, 13);
        this.setTextureOffset("Hat.Shape31", 0, 0);
        this.setTextureOffset("Hat.Shape32", 0, 0);
        this.setTextureOffset("Hat.Shape33", 0, 11);
        this.setTextureOffset("Hat.Shape34", 0, 15);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -5.0F, -9.0F, -5.0F, 10, 1, 10);
        this.Hat.addBox("Shape2", -5.0F, -8.0F, 4.0F, 1, 3, 1);
        this.Hat.addBox("Shape3", -5.0F, -8.0F, 3.0F, 1, 2, 1);
        this.Hat.addBox("Shape4", -5.0F, -8.0F, 1.0F, 1, 3, 1);
        this.Hat.addBox("Shape5", -5.0F, -8.0F, 0.0F, 1, 2, 1);
        this.Hat.addBox("Shape6", -5.0F, -8.0F, -1.0F, 1, 4, 1);
        this.Hat.addBox("Shape7", -5.0F, -8.0F, -2.0F, 1, 1, 1);
        this.Hat.addBox("Shape8", -5.0F, -8.0F, -3.0F, 1, 3, 1);
        this.Hat.addBox("Shape9", -5.0F, -8.0F, -5.0F, 1, 4, 1);
        this.Hat.addBox("Shape10", -4.0F, -8.0F, -5.0F, 1, 2, 1);
        this.Hat.addBox("Shape11", 3.0F, -8.0F, -5.0F, 1, 3, 1);
        this.Hat.addBox("Shape12", 4.0F, -8.0F, -5.0F, 1, 1, 1);
        this.Hat.addBox("Shape13", 4.0F, -8.0F, -4.0F, 1, 1, 1);
        this.Hat.addBox("Shape14", 4.0F, -8.0F, -2.0F, 1, 2, 1);
        this.Hat.addBox("Shape15", 4.0F, -8.0F, -1.0F, 1, 3, 1);
        this.Hat.addBox("Shape16", 4.0F, -8.0F, 1.0F, 1, 2, 1);
        this.Hat.addBox("Shape17", 4.0F, -8.0F, 2.0F, 1, 3, 1);
        this.Hat.addBox("Shape18", 4.0F, -8.0F, 3.0F, 1, 1, 1);
        this.Hat.addBox("Shape19", 4.0F, -8.0F, 4.0F, 1, 4, 1);
        this.Hat.addBox("Shape20", -3.0F, -8.0F, 4.0F, 1, 3, 1);
        this.Hat.addBox("Shape21", -5.0F, -8.0F, -4.0F, 1, 1, 1);
        this.Hat.addBox("Shape22", -2.0F, -8.0F, 4.0F, 1, 1, 1);
        this.Hat.addBox("Shape23", 0.0F, -8.0F, 4.0F, 1, 2, 1);
        this.Hat.addBox("Shape24", 1.0F, -8.0F, 4.0F, 1, 1, 1);
        this.Hat.addBox("Shape25", 3.0F, -8.0F, 4.0F, 1, 3, 1);
        this.Hat.addBox("Shape26", 0.0F, -15.0F, 2.0F, 5, 3, 1);
        this.Hat.addBox("Shape27", 0.0F, -16.0F, -1.0F, 5, 1, 3);
        this.Hat.addBox("Shape28", 5.0F, -15.0F, -1.0F, 1, 3, 3);
        this.Hat.addBox("Shape29", 1.0F, -16.5F, 0.0F, 1, 1, 1);
        this.Hat.addBox("Shape30", 1.0F, -17.5F, 0.0F, 3, 1, 1);
        this.Hat.addBox("Shape31", 0.0F, -13.0F, -1.0F, 5, 1, 3);
        this.Hat.addBox("Shape32", -1.0F, -13.0F, -1.0F, 1, 5, 3);
        this.Hat.addBox("Shape33", 0.0F, -15.0F, -2.0F, 5, 3, 1);
        this.Hat.addBox("Shape34", 0.0F, -12.0F, -1.0F, 5, 1, 3);
        this.setTexture(new ResourceLocation("minidot", "head/coffeehat.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.2F, 0.0F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "MisterBuble";
    }

    public String getName()
    {
        return "\u0427\u0430\u0448\u043a\u0430 \u043a\u043e\u0444\u0435";
    }
}
