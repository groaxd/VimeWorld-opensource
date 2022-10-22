package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HamsterHat extends BaseItem
{
    private final MModelRenderer Hat;

    public HamsterHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Hat.Shape1", 60, 0);
        this.setTextureOffset("Hat.Shape2", 60, 0);
        this.setTextureOffset("Hat.Shape3", 60, 0);
        this.setTextureOffset("Hat.Shape4", 60, 0);
        this.setTextureOffset("Hat.Shape5", 44, 0);
        this.setTextureOffset("Hat.Shape6", 40, 0);
        this.setTextureOffset("Hat.Shape7", 48, 8);
        this.setTextureOffset("Hat.Shape8", 39, 3);
        this.setTextureOffset("Hat.Shape9", 39, 3);
        this.setTextureOffset("Hat.Shape10", 40, 8);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", 1.0F, -9.0F, -3.0F, 1, 1, 1);
        this.Hat.addBox("Shape2", 1.0F, -9.0F, 1.0F, 1, 1, 1);
        this.Hat.addBox("Shape3", -2.0F, -9.0F, -3.0F, 1, 1, 1);
        this.Hat.addBox("Shape4", -2.0F, -9.0F, 1.0F, 1, 1, 1);
        this.Hat.addBox("Shape5", -2.0F, -13.0F, -3.0F, 4, 4, 5);
        this.Hat.addBox("Shape6", -1.0F, -12.0F, 1.5F, 2, 1, 1);
        this.Hat.addBox("Shape7", -2.0F, -13.0F, -5.0F, 4, 4, 3);
        this.Hat.addBox("Shape8", 1.0F, -13.7F, -4.6F, 1, 1, 1);
        this.Hat.addBox("Shape9", -2.0F, -13.7F, -4.7F, 1, 1, 1);
        this.Hat.addBox("Shape10", -1.5F, -12.0F, -5.5F, 3, 2, 1);
        this.setTexture(new ResourceLocation("minidot", "head/hamsterhat.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.3F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0425\u043e\u043c\u044f\u043a";
    }

    public String getCreator()
    {
        return "Makarov_Lazy";
    }
}
