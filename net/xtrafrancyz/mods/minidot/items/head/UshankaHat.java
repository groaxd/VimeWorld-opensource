package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class UshankaHat extends BaseHelm
{
    private final MModelRenderer Hat;
    private final MModelRenderer Shape7;
    private final MModelRenderer Shape8;
    private final MModelRenderer Shape9;
    private final MModelRenderer Shape10;

    public UshankaHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.setTextureOffset("Hat.Shape1", 0, 16);
        this.setTextureOffset("Hat.Shape2", 38, 26);
        this.setTextureOffset("Hat.Shape3", 42, 24);
        this.setTextureOffset("Hat.Shape4", 16, 23);
        this.setTextureOffset("Hat.Shape5", 2, 18);
        this.setTextureOffset("Hat.Shape6", 0, 17);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -5.0F, -9.0F, -4.0F, 10, 4, 9);
        this.Hat.addBox("Shape2", -5.0F, -8.0F, -5.0F, 10, 3, 1);
        this.Hat.addBox("Shape3", -4.0F, -9.0F, -5.0F, 8, 1, 1);
        this.Hat.addBox("Shape4", -5.0F, -5.0F, 4.0F, 10, 4, 1);
        this.Hat.addBox("Shape5", -5.0F, -5.0F, -4.0F, 1, 4, 8);
        this.Hat.addBox("Shape6", 4.0F, -5.0F, -4.0F, 1, 4, 8);
        this.Shape7 = new MModelRenderer(this, 51, 16);
        this.Shape7.addBox(-5.001F, -4.0F, -6.0F, 1, 3, 3);
        this.setRotation(this.Shape7, 0.3346145F, 0.0F, 0.0F);
        this.Shape8 = new MModelRenderer(this, 38, 16);
        this.Shape8.addBox(4.001F, -4.0F, -6.0F, 1, 3, 3);
        this.setRotation(this.Shape8, 0.3346075F, 0.0F, 0.0F);
        this.Shape9 = new MModelRenderer(this, 39, 19);
        this.Shape9.addBox(5.0F, -3.0F, -7.0F, 1, 2, 2);
        this.setRotation(this.Shape9, 0.3346145F, 0.0F, 0.0F);
        this.Shape10 = new MModelRenderer(this, 44, 17);
        this.Shape10.addBox(-6.0F, -3.0F, -7.0F, 1, 2, 2);
        this.setRotation(this.Shape10, 0.3346145F, 0.0F, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "head/ushanka.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.1F, 0.0F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u0430\u043f\u043a\u0430-\u0443\u0448\u0430\u043d\u043a\u0430";
    }

    public String getCreator()
    {
        return "Makarov_Lazy";
    }
}
