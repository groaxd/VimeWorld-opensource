package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class AnvilHat extends BaseItem
{
    private final MModelRenderer Hat;

    public AnvilHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.setTextureOffset("Hat.Shape1", 0, 0);
        this.setTextureOffset("Hat.Shape2", 0, 0);
        this.setTextureOffset("Hat.Shape3", 0, 0);
        this.setTextureOffset("Hat.Shape4", 0, 0);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -2.0F, -9.0F, -1.5F, 4, 1, 3);
        this.Hat.addBox("Shape2", -1.0F, -11.0F, -0.5F, 2, 3, 1);
        this.Hat.addBox("Shape3", -1.5F, -9.3F, -1.0F, 3, 1, 2);
        this.Hat.addBox("Shape4", -2.5F, -12.53F, -1.5F, 5, 2, 3);
        this.setTexture(new ResourceLocation("minidot", "head/anvil.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.3F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041d\u0430\u043a\u043e\u0432\u0430\u043b\u0435\u043d\u043a\u0430";
    }
}
