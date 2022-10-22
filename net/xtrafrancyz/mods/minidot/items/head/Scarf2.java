package net.xtrafrancyz.mods.minidot.items.head;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Scarf2 extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Piece1;
    private static MModelRenderer Piece2;
    private final String color;

    public Scarf2(String color)
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 16;
        this.color = color;

        if (Piece1 == null)
        {
            this.setTextureOffset("Piece1.Shape1", 9, 0);
            this.setTextureOffset("Piece1.Shape2", 0, 0);
            this.setTextureOffset("Piece1.Shape3", 0, 0);
            this.setTextureOffset("Piece1.Shape4", 0, 0);
            this.setTextureOffset("Piece1.Shape5", 0, 0);
            this.setTextureOffset("Piece1.Shape6", 0, 0);
            this.setTextureOffset("Piece1.Shape7", 0, 0);
            this.setTextureOffset("Piece1.Shape8", 0, 0);
            this.setTextureOffset("Piece1.Shape11", 0, 0);
            this.setTextureOffset("Piece1.Shape12", 0, 0);
            this.setTextureOffset("Piece1.Shape13", 9, 0);
            this.setTextureOffset("Piece2.Shape9", 0, 0);
            this.setTextureOffset("Piece2.Shape10", 0, 0);
            Piece1 = new MModelRenderer(this, "Piece1");
            Piece1.addBox("Shape1", 3.5F, -1.5F, -3.5F, 1, 2, 7);
            Piece1.addBox("Shape2", 0.5F, -2.0F, 3.5F, 2, 1, 1);
            Piece1.addBox("Shape3", -4.5F, -1.5F, -4.5F, 5, 2, 1);
            Piece1.addBox("Shape4", 0.5F, -0.5F, -4.5F, 4, 1, 1);
            Piece1.addBox("Shape5", 0.0F, -1.0F, -4.5F, 1, 1, 1);
            Piece1.addBox("Shape6", -4.5F, -2.0F, 0.5F, 1, 1, 3);
            Piece1.addBox("Shape7", -4.5F, -2.0F, -3.5F, 1, 1, 1);
            Piece1.addBox("Shape8", 3.5F, -1.5F, -4.5F, 1, 1, 1);
            Piece1.addBox("Shape12", -4.5F, -1.5F, 3.5F, 9, 2, 1);
            Piece1.addBox("Shape13", -4.5F, -1.5F, -3.5F, 1, 2, 7);
            Piece1.addBox("Shape11", -4.0F, 0.0F, -4.0F, 8, 1, 8);
            Piece2 = new MModelRenderer(this, "Piece2");
            Piece2.addBox("Shape9", 1.0F, 1.0F, -3.0F, 3, 2, 1);
            Piece2.addBox("Shape10", 0.0F, 0.0F, -3.0F, 3, 2, 1);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.01F, 1.01F, 1.01F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.3F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -976943172:
                if (s.equals("purple"))
                {
                    b0 = 3;
                }

                break;

            case 112785:
                if (s.equals("red"))
                {
                    b0 = 0;
                }

                break;

            case 98619139:
                if (s.equals("green"))
                {
                    b0 = 2;
                }

                break;

            case 113101865:
                if (s.equals("white"))
                {
                    b0 = 1;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0439 \u0448\u0430\u0440\u0444";

            case 1:
                return "\u0411\u0435\u043b\u044b\u0439 \u0448\u0430\u0440\u0444";

            case 2:
                return "\u0417\u0435\u043b\u0435\u043d\u044b\u0439 \u0448\u0430\u0440\u0444";

            case 3:
                return "\u0424\u0438\u043e\u043b\u0435\u0442\u043e\u0432\u044b\u0439 \u0448\u0430\u0440\u0444";

            default:
                return "\u0419\u0443\u0445";
        }
    }

    static
    {
        colors.put("red", new ResourceLocation("minidot", "body/xmas_scarf_red.png"));
        colors.put("white", new ResourceLocation("minidot", "body/xmas_scarf_white.png"));
        colors.put("green", new ResourceLocation("minidot", "body/xmas_scarf_green.png"));
        colors.put("purple", new ResourceLocation("minidot", "body/xmas_scarf_purple.png"));
    }
}
