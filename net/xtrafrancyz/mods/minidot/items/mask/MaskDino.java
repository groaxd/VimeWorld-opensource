package net.xtrafrancyz.mods.minidot.items.mask;

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

public class MaskDino extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Piece1;
    private String color;

    public MaskDino(String color)
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.color = color;

        if (Piece1 == null)
        {
            this.setTextureOffset("Piece1.Shape2", 8, 22);
            this.setTextureOffset("Piece1.Shape12", 0, 0);
            this.setTextureOffset("Piece1.Shape11", 0, 0);
            this.setTextureOffset("Piece1.Shape10", 0, 0);
            this.setTextureOffset("Piece1.Shape9", 0, 0);
            this.setTextureOffset("Piece1.Shape8", 6, 16);
            this.setTextureOffset("Piece1.Shape7", 0, 11);
            this.setTextureOffset("Piece1.Shape5", 0, 0);
            this.setTextureOffset("Piece1.Shape3", 0, 6);
            this.setTextureOffset("Piece1.Shape4", 0, 0);
            this.setTextureOffset("Piece1.Shape6", 0, 0);
            this.setTextureOffset("Piece1.Shape13", 0, 20);
            this.setTextureOffset("Piece1.Shape14", 0, 0);
            this.setTextureOffset("Piece1.Shape15", 0, 0);
            this.setTextureOffset("Piece1.Shape16", 0, 20);
            this.setTextureOffset("Piece1.Shape17", 0, 20);
            this.setTextureOffset("Piece1.Shape18", 0, 20);
            this.setTextureOffset("Piece1.Shape19", 0, 20);
            this.setTextureOffset("Piece1.Shape20", 0, 20);
            this.setTextureOffset("Piece1.Shape21", 0, 20);
            this.setTextureOffset("Piece1.Shape22", 0, 20);
            Piece1 = new MModelRenderer(this, "Piece1");
            Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
            Piece1.addBox("Shape2", -5.0F, -6.0F, -1.0F, 10, 9, 1);
            Piece1.addBox("Shape12", -4.0F, -2.0F, -5.0F, 8, 1, 1);
            Piece1.addBox("Shape11", 3.0F, -3.0F, -5.0F, 1, 1, 1);
            Piece1.addBox("Shape10", -3.0F, -4.0F, -5.0F, 6, 1, 1);
            Piece1.addBox("Shape9", -4.0F, -4.0F, -4.0F, 8, 1, 3);
            Piece1.addBox("Shape8", -5.0F, -3.0F, -4.0F, 10, 2, 3);
            Piece1.addBox("Shape7", -4.0F, -6.0F, -2.0F, 8, 2, 1);
            Piece1.addBox("Shape5", -3.0F, 3.0F, -5.0F, 6, 1, 1);
            Piece1.addBox("Shape3", -5.0F, 2.0F, -4.0F, 10, 1, 3);
            Piece1.addBox("Shape4", -4.0F, 3.0F, -4.0F, 8, 1, 4);
            Piece1.addBox("Shape6", -4.0F, 2.0F, -5.0F, 8, 1, 1);
            Piece1.addBox("Shape13", -4.0F, 1.0F, -5.0F, 2, 1, 1);
            Piece1.addBox("Shape14", -4.0F, -3.0F, -5.0F, 1, 1, 1);
            Piece1.addBox("Shape15", -1.0F, -3.0F, -5.0F, 2, 1, 1);
            Piece1.addBox("Shape16", -4.0F, -1.0F, -5.0F, 2, 1, 1);
            Piece1.addBox("Shape17", 2.0F, -1.0F, -5.0F, 2, 1, 1);
            Piece1.addBox("Shape18", -5.0F, 1.0F, -3.0F, 1, 1, 2);
            Piece1.addBox("Shape19", 2.0F, 1.0F, -5.0F, 2, 1, 1);
            Piece1.addBox("Shape20", -5.0F, -1.0F, -3.0F, 1, 1, 2);
            Piece1.addBox("Shape21", 4.0F, 1.0F, -3.0F, 1, 1, 2);
            Piece1.addBox("Shape22", 4.0F, -1.0F, -3.0F, 1, 1, 2);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.1F, 0.0F);
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
                    b0 = 4;
                }

                break;

            case 3027034:
                if (s.equals("blue"))
                {
                    b0 = 0;
                }

                break;

            case 3441014:
                if (s.equals("pink"))
                {
                    b0 = 2;
                }

                break;

            case 98619139:
                if (s.equals("green"))
                {
                    b0 = 1;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0421\u0438\u043d\u044f\u044f \u043c\u0430\u0441\u043a\u0430 \u0434\u0438\u043d\u043e\u0437\u0430\u0432\u0440\u0438\u043a\u0430";

            case 1:
                return "\u0417\u0435\u043b\u0435\u043d\u0430\u044f \u043c\u0430\u0441\u043a\u0430 \u0434\u0438\u043d\u043e\u0437\u0430\u0432\u0440\u0438\u043a\u0430";

            case 2:
                return "\u0420\u043e\u0437\u043e\u0432\u0430\u044f \u043c\u0430\u0441\u043a\u0430 \u0434\u0438\u043d\u043e\u0437\u0430\u0432\u0440\u0438\u043a\u0430";

            case 3:
                return "\u0424\u0438\u043e\u043b\u0435\u0442\u043e\u0432\u0430\u044f \u043c\u0430\u0441\u043a\u0430 \u0434\u0438\u043d\u043e\u0437\u0430\u0432\u0440\u0438\u043a\u0430";

            case 4:
                return "\u041a\u0440\u0430\u0441\u043d\u0430\u044f \u043c\u0430\u0441\u043a\u0430 \u0434\u0438\u043d\u043e\u0437\u0430\u0432\u0440\u0438\u043a\u0430";

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
        colors.put("blue", new ResourceLocation("minidot", "masks/3d_dino_blue.png"));
        colors.put("green", new ResourceLocation("minidot", "masks/3d_dino_green.png"));
        colors.put("pink", new ResourceLocation("minidot", "masks/3d_dino_pink.png"));
        colors.put("purple", new ResourceLocation("minidot", "masks/3d_dino_purple.png"));
        colors.put("red", new ResourceLocation("minidot", "masks/3d_dino_red.png"));
    }
}
