package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class CreeperHat extends BaseHelm
{
    private final MModelRenderer Hat;

    public CreeperHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Hat.Shape1", 9, 21);
        this.setTextureOffset("Hat.Shape2", 0, 0);
        this.setTextureOffset("Hat.Shape3", 0, 0);
        this.setTextureOffset("Hat.Shape4", -2, 6);
        this.setTextureOffset("Hat.Shape5", 0, 0);
        this.setTextureOffset("Hat.Shape6", 3, 1);
        this.setTextureOffset("Hat.Shape7", 3, 26);
        this.setTextureOffset("Hat.Shape8", 0, 9);
        this.setTextureOffset("Hat.Shape9", 17, 26);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -5.0F, -9.0F, 4.0F, 10, 6, 1);
        this.Hat.addBox("Shape2", -5.0F, -9.0F, 1.0F, 1, 6, 3);
        this.Hat.addBox("Shape3", -5.0F, -9.0F, -5.0F, 1, 5, 6);
        this.Hat.addBox("Shape4", 4.0F, -9.0F, -5.0F, 1, 5, 6);
        this.Hat.addBox("Shape5", 4.0F, -9.0F, 1.0F, 1, 6, 3);
        this.Hat.addBox("Shape6", -4.0F, -9.0F, -4.0F, 8, 1, 8);
        this.Hat.addBox("Shape7", 2.0F, -9.0F, -5.0F, 2, 4, 1);
        this.Hat.addBox("Shape8", -4.0F, -9.0F, -5.0F, 2, 4, 1);
        this.Hat.addBox("Shape9", -2.0F, -9.0F, -5.0F, 4, 3, 1);
        this.setTexture(new ResourceLocation("minidot", "head/creeperhat.png"));
    }

    public String getName()
    {
        return "\u0428\u0430\u043f\u043a\u0430 \u043a\u0440\u0438\u043f\u0435\u0440\u0430";
    }
}
