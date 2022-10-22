package net.xtrafrancyz.mods.minidot.items.head;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Hood extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Model_Player;
    private String color;

    public Hood(String color)
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.color = color;

        if (Model_Player == null)
        {
            this.setTextureOffset("Model_Player.Shape15", 0, 0);
            this.setTextureOffset("Model_Player.Shape14", 18, 23);
            this.setTextureOffset("Model_Player.Shape12", 18, 23);
            this.setTextureOffset("Model_Player.Shape11", 0, 9);
            this.setTextureOffset("Model_Player.Shape10", 17, 15);
            this.setTextureOffset("Model_Player.Shape7", 17, 15);
            this.setTextureOffset("Model_Player.Shape1", 0, 15);
            this.setTextureOffset("Model_Player.Shape2", 0, 15);
            Model_Player = new MModelRenderer(this, "Model_Player");
            Model_Player.setRotationPoint(0.0F, -1.0F, 0.0F);
            Model_Player.addBox("Shape15", -4.0F, 1.0F, -3.0F, 8, 1, 7);
            Model_Player.addBox("Shape14", -5.0F, -3.0F, 0.0F, 1, 1, 4);
            Model_Player.addBox("Shape12", 4.0F, -3.0F, 0.0F, 1, 1, 4);
            Model_Player.addBox("Shape11", -5.0F, -3.0F, 4.0F, 10, 4, 1);
            Model_Player.addBox("Shape10", -5.0F, -2.0F, -2.0F, 1, 1, 6);
            Model_Player.addBox("Shape7", 4.0F, -2.0F, -2.0F, 1, 1, 6);
            Model_Player.addBox("Shape1", 4.0F, -1.0F, -3.0F, 1, 3, 7);
            Model_Player.addBox("Shape2", -5.0F, -1.0F, -3.0F, 1, 3, 7);
        }

        this.setTexture((ResourceLocation)colors.get(color));
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
            case 93818879:
                if (s.equals("black"))
                {
                    b0 = 1;
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
                return "\u0411\u0435\u043b\u044b\u0439 \u0432\u043e\u0440\u043e\u0442\u043d\u0438\u043a";

            case 1:
                return "\u0421\u0435\u0440\u044b\u0439 \u0432\u043e\u0440\u043e\u0442\u043d\u0438\u043a";

            default:
                return "\u0425\u0443\u0439";
        }
    }

    static
    {
        colors.put("white", new ResourceLocation("minidot", "head/hood_white.png"));
        colors.put("black", new ResourceLocation("minidot", "head/hood_black.png"));
    }
}
