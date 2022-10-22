package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class TurtleHat extends BaseItem
{
    private final MModelRenderer Hat;

    public TurtleHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Hat.Shape1", 60, 0);
        this.setTextureOffset("Hat.Shape2", 60, 0);
        this.setTextureOffset("Hat.Shape3", 60, 0);
        this.setTextureOffset("Hat.Shape4", 60, 0);
        this.setTextureOffset("Hat.Shape5", 41, 0);
        this.setTextureOffset("Hat.Shape6", 44, 16);
        this.setTextureOffset("Hat.Shape7", 45, 5);
        this.setTextureOffset("Hat.Shape8", 44, 6);
        this.setTextureOffset("Hat.Shape9", 54, 11);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", 1.5F, -10.0F, 1.5F, 1, 2, 1);
        this.Hat.addBox("Shape2", 1.5F, -10.0F, -2.5F, 1, 2, 1);
        this.Hat.addBox("Shape3", -2.5F, -10.0F, 1.5F, 1, 2, 1);
        this.Hat.addBox("Shape4", -2.5F, -10.0F, -2.5F, 1, 2, 1);
        this.Hat.addBox("Shape5", -2.0F, -10.4F, -2.0F, 4, 1, 4);
        this.Hat.addBox("Shape6", -2.5F, -11.0F, -2.5F, 5, 1, 5);
        this.Hat.addBox("Shape7", -2.0F, -12.0F, -2.0F, 4, 1, 4);
        this.Hat.addBox("Shape8", -1.5F, -12.5F, -1.5F, 3, 1, 3);
        this.Hat.addBox("Shape9", -1.0F, -10.9F, -5.0F, 2, 2, 3);
        this.setTexture(new ResourceLocation("minidot", "head/turtlehat.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.25F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0427\u0435\u0440\u0435\u043f\u0430\u0445\u0430";
    }

    public String getCreator()
    {
        return "Makarov_Lazy";
    }
}
