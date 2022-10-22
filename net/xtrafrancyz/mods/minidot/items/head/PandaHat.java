package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class PandaHat extends BaseHelm
{
    private final MModelRenderer Hat;

    public PandaHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Hat.Shape1", 32, 21);
        this.setTextureOffset("Hat.Shape2", 0, 0);
        this.setTextureOffset("Hat.Shape3", 32, 1);
        this.setTextureOffset("Hat.Shape4", 32, 1);
        this.setTextureOffset("Hat.Shape5", 10, 18);
        this.setTextureOffset("Hat.Shape6", 0, 21);
        this.setTextureOffset("Hat.Shape7", 0, 21);
        this.setTextureOffset("Hat.Shape8", 10, 26);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -4.0F, -8.5F, 4.5F, 8, 8, 1);
        this.Hat.addBox("Shape2", -5.0F, -9.0F, -5.0F, 10, 1, 10);
        this.Hat.addBox("Shape3", 4.0F, -8.0F, -5.0F, 1, 7, 10);
        this.Hat.addBox("Shape4", -5.0F, -8.0F, -5.0F, 1, 7, 10);
        this.Hat.addBox("Shape5", -4.0F, -8.5F, -6.0F, 8, 4, 2);
        this.Hat.addBox("Shape6", 3.5F, -11.0F, -4.0F, 3, 3, 1);
        this.Hat.addBox("Shape7", -6.5F, -11.0F, -4.0F, 3, 3, 1);
        this.Hat.addBox("Shape8", -2.0F, -5.5F, -7.0F, 4, 2, 2);
        this.setTexture(new ResourceLocation("minidot", "head/pandahat.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.05F, 0.0F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u0430\u043f\u043a\u0430 \u043f\u0430\u043d\u0434\u044b";
    }
}
