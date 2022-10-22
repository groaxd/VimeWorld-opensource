package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Headphones extends BaseItem
{
    private final MModelRenderer Hat;

    public Headphones()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.setTextureOffset("Hat.Shape1", 0, 0);
        this.setTextureOffset("Hat.Shape2", 2, 3);
        this.setTextureOffset("Hat.Shape3", 0, 7);
        this.setTextureOffset("Hat.Shape4", 15, 3);
        this.setTextureOffset("Hat.Shape5", 13, 7);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -5.0F, -9.0F, 0.0F, 10, 1, 1);
        this.Hat.addBox("Shape2", -5.0F, -8.0F, 0.0F, 1, 2, 1);
        this.Hat.addBox("Shape3", -5.0F, -6.0F, -1.0F, 1, 3, 3);
        this.Hat.addBox("Shape4", 4.0F, -8.0F, 0.0F, 1, 2, 1);
        this.Hat.addBox("Shape5", 4.0F, -6.0F, -1.0F, 1, 3, 3);
        this.setTexture(new ResourceLocation("minidot", "head/headphones.png"));
    }

    public String getName()
    {
        return "\u041d\u0430\u0443\u0448\u043d\u0438\u043a\u0438";
    }
}
