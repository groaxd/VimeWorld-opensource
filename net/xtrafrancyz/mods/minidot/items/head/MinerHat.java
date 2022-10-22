package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MinerHat extends BaseItem
{
    private final MModelRenderer Hat;

    public MinerHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Hat.Shape1", 0, 13);
        this.setTextureOffset("Hat.Shape2", 0, 0);
        this.setTextureOffset("Hat.Shape3", 0, 24);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -4.5F, -9.0F, -4.5F, 9, 1, 9);
        this.Hat.addBox("Shape2", -3.5F, -13.0F, -3.0F, 7, 4, 7);
        this.Hat.addBox("Shape3", -2.0F, -13.0F, -5.0F, 4, 4, 2);
        this.setTexture(new ResourceLocation("minidot", "head/minerhat.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.3F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u0430\u0445\u0442\u0435\u0440\u0441\u043a\u0430\u044f \u043a\u0430\u0441\u043a\u0430";
    }
}
