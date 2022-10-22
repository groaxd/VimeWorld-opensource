package net.xtrafrancyz.mods.minidot.items.head;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class DogEarsHat extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Piece1;
    private String color;

    public DogEarsHat(String color)
    {
        super(ItemType.HEAD);
        this.textureWidth = 8;
        this.textureHeight = 8;
        this.color = color;

        if (Piece1 == null)
        {
            this.setTextureOffset("Piece1.Shape7", 0, 5);
            this.setTextureOffset("Piece1.Shape6", 0, 0);
            this.setTextureOffset("Piece1.Shape8", 0, 5);
            this.setTextureOffset("Piece1.Shape5", 0, 0);
            this.setTextureOffset("Piece1.Shape9", 0, 0);
            this.setTextureOffset("Piece1.Shape4", 0, 0);
            this.setTextureOffset("Piece1.Shape10", 0, 0);
            this.setTextureOffset("Piece1.Shape3", 0, 0);
            this.setTextureOffset("Piece1.Shape11", 0, 0);
            this.setTextureOffset("Piece1.Shape2", 0, 0);
            this.setTextureOffset("Piece1.Shape1", 0, 0);
            this.setTextureOffset("Piece1.Shape12", 0, 0);
            Piece1 = new MModelRenderer(this, "Piece1");
            Piece1.addBox("Shape7", 3.0F, -10.0F, 0.0F, 1, 2, 1);
            Piece1.addBox("Shape6", -4.0F, -11.0F, -1.0F, 1, 1, 2);
            Piece1.addBox("Shape8", -4.0F, -10.0F, 0.0F, 1, 2, 1);
            Piece1.addBox("Shape5", -5.0F, -11.0F, -2.0F, 1, 1, 2);
            Piece1.addBox("Shape9", -4.0F, -10.0F, 1.0F, 1, 2, 1);
            Piece1.addBox("Shape4", 3.0F, -11.0F, -1.0F, 1, 1, 2);
            Piece1.addBox("Shape10", 3.0F, -10.0F, 1.0F, 1, 2, 1);
            Piece1.addBox("Shape3", 4.0F, -11.0F, -2.0F, 1, 1, 2);
            Piece1.addBox("Shape11", 2.0F, -10.0F, 0.0F, 1, 2, 1);
            Piece1.addBox("Shape2", 4.0F, -11.0F, 0.0F, 1, 4, 1);
            Piece1.addBox("Shape1", -5.0F, -11.0F, 0.0F, 1, 4, 1);
            Piece1.addBox("Shape12", -3.0F, -10.0F, 0.0F, 1, 2, 1);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.2F, 0.0F);
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
                    b0 = 3;
                }

                break;

            case -976943172:
                if (s.equals("purple"))
                {
                    b0 = 2;
                }

                break;

            case 112785:
                if (s.equals("red"))
                {
                    b0 = 6;
                }

                break;

            case 3181155:
                if (s.equals("gray"))
                {
                    b0 = 5;
                }

                break;

            case 94011702:
                if (s.equals("brown"))
                {
                    b0 = 1;
                }

                break;

            case 98619139:
                if (s.equals("green"))
                {
                    b0 = 4;
                }

                break;

            case 113101865:
                if (s.equals("white"))
                {
                    b0 = 0;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0411\u0435\u043b\u044b\u0435 \u0443\u0448\u0438 \u0441\u043e\u0431\u0430\u043a\u0438";

            case 1:
                return "\u041a\u043e\u0440\u0438\u0447\u043d\u0435\u0432\u044b\u0435 \u0443\u0448\u0438 \u0441\u043e\u0431\u0430\u043a\u0438";

            case 2:
                return "\u0424\u0438\u043e\u043b\u0435\u0442\u043e\u0432\u044b\u0435 \u0443\u0448\u0438 \u0441\u043e\u0431\u0430\u043a\u0438";

            case 3:
                return "\u041e\u0440\u0430\u043d\u0436\u0435\u0432\u044b\u0435 \u0443\u0448\u0438 \u0441\u043e\u0431\u0430\u043a\u0438";

            case 4:
                return "\u0417\u0435\u043b\u0435\u043d\u044b\u0435 \u0443\u0448\u0438 \u0441\u043e\u0431\u0430\u043a\u0438";

            case 5:
                return "\u0421\u0435\u0440\u044b\u0435 \u0443\u0448\u0438 \u0441\u043e\u0431\u0430\u043a\u0438";

            case 6:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0435 \u0443\u0448\u0438 \u0441\u043e\u0431\u0430\u043a\u0438";

            default:
                return "\u0425\u0443\u0439";
        }
    }

    public String getCreator()
    {
        return "ANACTAC";
    }

    static
    {
        colors.put("white", new ResourceLocation("minidot", "head/dogears_white.png"));
        colors.put("brown", new ResourceLocation("minidot", "head/dogears_brown.png"));
        colors.put("orange", new ResourceLocation("minidot", "head/dogears_orange.png"));
        colors.put("purple", new ResourceLocation("minidot", "head/dogears_purple.png"));
        colors.put("green", new ResourceLocation("minidot", "head/dogears_green.png"));
        colors.put("red", new ResourceLocation("minidot", "head/dogears_red.png"));
        colors.put("gray", new ResourceLocation("minidot", "head/dogears_gray.png"));
    }
}
