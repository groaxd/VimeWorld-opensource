package net.xtrafrancyz.mods.minidot.items.head;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MarioHat extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Hat;
    private String color;

    public MarioHat(String color)
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.color = color;

        if (Hat == null)
        {
            this.setTextureOffset("Hat.Shape1", 0, 0);
            this.setTextureOffset("Hat.Shape2", 0, 4);
            this.setTextureOffset("Hat.Shape3", 0, 0);
            this.setTextureOffset("Hat.Shape4", 0, 0);
            this.setTextureOffset("Hat.Shape5", 0, 12);
            this.setTextureOffset("Hat.Shape6", 11, 12);
            this.setTextureOffset("Hat.Shape7", 0, 16);
            this.setTextureOffset("Hat.Shape8", 0, 21);
            this.setTextureOffset("Hat.Shape9", 0, 24);
            Hat = new MModelRenderer(this, "Hat");
            Hat.addBox("Shape1", -4.0F, -9.0F, -6.0F, 8, 1, 10);
            Hat.addBox("Shape2", -3.0F, -9.0F, -7.0F, 6, 1, 1);
            Hat.addBox("Shape3", -3.0F, -11.0F, -3.0F, 6, 2, 6);
            Hat.addBox("Shape4", -2.0F, -12.0F, -3.0F, 4, 1, 5);
            Hat.addBox("Shape5", -2.0F, -11.0F, -4.0F, 4, 2, 1);
            Hat.addBox("Shape6", -1.0F, -12.0F, -4.0F, 2, 1, 1);
            Hat.addBox("Shape7", -1.0F, -5.0F, -6.0F, 2, 2, 2);
            Hat.addBox("Shape8", -3.0F, -3.0F, -5.0F, 6, 1, 1);
            Hat.addBox("Shape9", -2.0F, -2.0F, -5.0F, 4, 1, 1);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case 103330018:
                if (s.equals("luigi"))
                {
                    b0 = 0;
                }

                break;

            case 103666436:
                if (s.equals("mario"))
                {
                    b0 = 1;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0428\u0430\u043f\u043a\u0430 \u041b\u0443\u0438\u0434\u0436\u0438";

            case 1:
                return "\u0428\u0430\u043f\u043a\u0430 \u041c\u0430\u0440\u0438\u043e";

            default:
                return "\u0425\u0443\u0439";
        }
    }

    static
    {
        colors.put("luigi", new ResourceLocation("minidot", "head/luigihat.png"));
        colors.put("mario", new ResourceLocation("minidot", "head/mariohat.png"));
    }
}
