package net.xtrafrancyz.mods.minidot.items.head;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BoneEarsHat extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Piece1;
    private String color;

    public BoneEarsHat(String color)
    {
        super(ItemType.HEAD);
        this.textureWidth = 8;
        this.textureHeight = 8;
        this.color = color;

        if (Piece1 == null)
        {
            this.setTextureOffset("Piece1.Shape23", 0, 5);
            this.setTextureOffset("Piece1.Shape1", 0, 0);
            this.setTextureOffset("Piece1.Shape21", 0, 5);
            this.setTextureOffset("Piece1.Shape2", 0, 0);
            this.setTextureOffset("Piece1.Shape22", 0, 5);
            this.setTextureOffset("Piece1.Shape3", 0, 0);
            this.setTextureOffset("Piece1.Shape20", 0, 5);
            this.setTextureOffset("Piece1.Shape4", 0, 0);
            this.setTextureOffset("Piece1.Shape19", 0, 0);
            this.setTextureOffset("Piece1.Shape5", 0, 0);
            this.setTextureOffset("Piece1.Shape18", 0, 0);
            this.setTextureOffset("Piece1.Shape6", 0, 0);
            this.setTextureOffset("Piece1.Shape17", 0, 0);
            this.setTextureOffset("Piece1.Shape7", 0, 0);
            this.setTextureOffset("Piece1.Shape16", 0, 0);
            this.setTextureOffset("Piece1.Shape8", 0, 0);
            this.setTextureOffset("Piece1.Shape15", 0, 0);
            this.setTextureOffset("Piece1.Shape9", 0, 0);
            this.setTextureOffset("Piece1.Shape14", 0, 0);
            this.setTextureOffset("Piece1.Shape10", 0, 0);
            this.setTextureOffset("Piece1.Shape12", 0, 0);
            this.setTextureOffset("Piece1.Shape11", 0, 0);
            Piece1 = new MModelRenderer(this, "Piece1");
            Piece1.mirror = true;
            Piece1.addBox("Shape23", -4.0F, -13.0F, 1.0F, 1, 2, 1);
            Piece1.addBox("Shape1", 2.0F, -9.0F, 2.0F, 2, 1, 1);
            Piece1.addBox("Shape21", 3.0F, -13.0F, 1.0F, 1, 2, 1);
            Piece1.addBox("Shape2", 2.0F, -11.0F, 2.0F, 1, 2, 1);
            Piece1.addBox("Shape22", -4.0F, -11.0F, 2.0F, 1, 2, 1);
            Piece1.addBox("Shape3", 2.0F, -10.0F, 3.0F, 1, 2, 1);
            Piece1.addBox("Shape20", 3.0F, -11.0F, 2.0F, 1, 2, 1);
            Piece1.addBox("Shape4", 3.0F, -11.0F, 3.0F, 1, 3, 1);
            Piece1.addBox("Shape19", -4.0F, -13.0F, 2.0F, 1, 2, 1);
            Piece1.addBox("Shape5", 4.0F, -11.0F, 2.0F, 1, 2, 1);
            Piece1.addBox("Shape18", -4.0F, -14.0F, 1.0F, 1, 1, 1);
            Piece1.addBox("Shape6", 3.0F, -13.0F, 2.0F, 1, 2, 1);
            Piece1.addBox("Shape17", -5.0F, -13.0F, 1.0F, 1, 2, 1);
            Piece1.addBox("Shape7", 4.0F, -13.0F, 1.0F, 1, 2, 1);
            Piece1.addBox("Shape16", -3.0F, -14.0F, 1.0F, 1, 3, 1);
            Piece1.addBox("Shape8", 2.0F, -13.0F, 1.0F, 1, 2, 1);
            Piece1.addBox("Shape15", -4.0F, -11.0F, 3.0F, 1, 3, 1);
            Piece1.addBox("Shape9", 2.0F, -14.0F, 1.0F, 2, 1, 1);
            Piece1.addBox("Shape14", -3.0F, -10.0F, 3.0F, 1, 2, 1);
            Piece1.addBox("Shape10", -4.0F, -9.0F, 2.0F, 2, 1, 1);
            Piece1.addBox("Shape12", -5.0F, -11.0F, 2.0F, 1, 2, 1);
            Piece1.addBox("Shape11", -3.0F, -11.0F, 2.0F, 1, 2, 1);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.35F, 0.0F);
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
                    b0 = 1;
                }

                break;

            case 3441014:
                if (s.equals("pink"))
                {
                    b0 = 2;
                }

                break;

            case 93733468:
                if (s.equals("biege"))
                {
                    b0 = 4;
                }

                break;

            case 93818879:
                if (s.equals("black"))
                {
                    b0 = 3;
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
                return "\u0411\u0435\u043b\u044b\u0435 \u0443\u0448\u0438";

            case 1:
                return "\u0424\u0438\u043e\u043b\u0435\u0442\u043e\u0432\u044b\u0435 \u0443\u0448\u0438";

            case 2:
                return "\u0420\u043e\u0437\u043e\u0432\u044b\u0435 \u0443\u0448\u0438";

            case 3:
                return "\u0427\u0435\u0440\u043d\u044b\u0435 \u0443\u0448\u0438";

            case 4:
                return "\u0411\u0435\u0436\u0435\u0432\u044b\u0435 \u0443\u0448\u0438";

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
        colors.put("white", new ResourceLocation("minidot", "head/boneears_white.png"));
        colors.put("purple", new ResourceLocation("minidot", "head/boneears_purple.png"));
        colors.put("pink", new ResourceLocation("minidot", "head/boneears_pink.png"));
        colors.put("black", new ResourceLocation("minidot", "head/boneears_black.png"));
        colors.put("biege", new ResourceLocation("minidot", "head/boneears_biege.png"));
    }
}
