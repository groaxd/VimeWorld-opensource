package net.xtrafrancyz.mods.minidot.items.head;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class FoxEarsHat extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Hat;
    private String color;

    public FoxEarsHat(String color)
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.color = color;

        if (Hat == null)
        {
            this.setTextureOffset("Hat.L1", 17, 10);
            this.setTextureOffset("Hat.L2", 9, 0);
            this.setTextureOffset("Hat.L3", 25, 5);
            this.setTextureOffset("Hat.L4", 0, 0);
            this.setTextureOffset("Hat.L5", 17, 0);
            this.setTextureOffset("Hat.L6", 9, 5);
            this.setTextureOffset("Hat.L7", 24, 2);
            this.setTextureOffset("Hat.R1", 17, 10);
            this.setTextureOffset("Hat.R2", 9, 0);
            this.setTextureOffset("Hat.R3", 25, 5);
            this.setTextureOffset("Hat.R4", 0, 0);
            this.setTextureOffset("Hat.R5", 17, 0);
            this.setTextureOffset("Hat.R6", 9, 5);
            this.setTextureOffset("Hat.R7", 24, 0);
            Hat = new MModelRenderer(this, "Hat");
            Hat.addBox("L1", -4.0F, -11.0F, 1.0F, 1, 3, 1);
            Hat.addBox("L2", -4.0F, -12.0F, 0.0F, 1, 1, 1);
            Hat.addBox("L3", -3.0F, -10.0F, 1.0F, 1, 2, 1);
            Hat.addBox("L4", -4.0F, -10.0F, 0.0F, 2, 2, 1);
            Hat.addBox("L5", -2.0F, -10.0F, 0.0F, 1, 2, 1);
            Hat.addBox("L6", -5.0F, -11.0F, 0.0F, 1, 3, 1);
            Hat.addBox("L7", -4.0F, -11.0F, 0.0F, 2, 1, 1);
            Hat.addBox("R1", 3.0F, -11.0F, 1.0F, 1, 3, 1);
            Hat.addBox("R2", 3.0F, -12.0F, 0.0F, 1, 1, 1);
            Hat.addBox("R3", 2.0F, -10.0F, 1.0F, 1, 2, 1);
            Hat.addBox("R4", 2.0F, -10.0F, 0.0F, 2, 2, 1);
            Hat.addBox("R5", 1.0F, -10.0F, 0.0F, 1, 2, 1);
            Hat.addBox("R6", 4.0F, -11.0F, 0.0F, 1, 3, 1);
            Hat.addBox("R7", 2.0F, -11.0F, 0.0F, 2, 1, 1);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.2F, 0.0F);
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -1008851410:
                if (s.equals("orange"))
                {
                    b0 = 2;
                }

                break;

            case -734239628:
                if (s.equals("yellow"))
                {
                    b0 = 1;
                }

                break;

            case 93818879:
                if (s.equals("black"))
                {
                    b0 = 0;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0427\u0435\u0440\u043d\u044b\u0435 \u0443\u0448\u0438";

            case 1:
                return "\u0416\u0435\u043b\u0442\u044b\u0435 \u0443\u0448\u0438";

            case 2:
                return "\u041e\u0440\u0430\u043d\u0436\u0435\u0432\u044b\u0435 \u0443\u0448\u0438";

            default:
                return "\u0425\u0443\u0439";
        }
    }

    static
    {
        colors.put("black", new ResourceLocation("minidot", "head/fox_ears_black.png"));
        colors.put("yellow", new ResourceLocation("minidot", "head/fox_ears_yellow.png"));
        colors.put("orange", new ResourceLocation("minidot", "head/fox_ears_orange.png"));
    }
}
