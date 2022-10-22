package net.xtrafrancyz.mods.minidot.items.head;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HelmetMouse extends BaseHelm
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Piece1;
    private static MModelRenderer Shape45;
    private static MModelRenderer Shape51;
    private String color;

    public HelmetMouse(String color)
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.color = color;

        if (Piece1 == null)
        {
            this.setTextureOffset("Piece1.Shape2", 0, 0);
            this.setTextureOffset("Piece1.Shape3", 0, 0);
            this.setTextureOffset("Piece1.Shape4", 0, 0);
            this.setTextureOffset("Piece1.Shape5", 0, 0);
            this.setTextureOffset("Piece1.Shape6", 0, 0);
            this.setTextureOffset("Piece1.Shape7", 0, 0);
            this.setTextureOffset("Piece1.Shape8", 0, 0);
            this.setTextureOffset("Piece1.Shape9", 0, 0);
            this.setTextureOffset("Piece1.Shape10", 0, 0);
            this.setTextureOffset("Piece1.Shape11", 0, 0);
            this.setTextureOffset("Piece1.Shape12", 0, 0);
            this.setTextureOffset("Piece1.Shape13", 0, 0);
            this.setTextureOffset("Piece1.Shape14", 0, 0);
            this.setTextureOffset("Piece1.Shape15", 0, 0);
            this.setTextureOffset("Piece1.Shape16", 0, 0);
            this.setTextureOffset("Piece1.Shape17", 0, 0);
            this.setTextureOffset("Piece1.Shape18", 0, 0);
            this.setTextureOffset("Piece1.Shape19", 0, 0);
            this.setTextureOffset("Piece1.Shape20", 0, 0);
            this.setTextureOffset("Piece1.Shape21", 0, 0);
            this.setTextureOffset("Piece1.Shape22", 0, 0);
            this.setTextureOffset("Piece1.Shape23", 0, 0);
            this.setTextureOffset("Piece1.Shape24", 0, 0);
            this.setTextureOffset("Piece1.Shape25", 0, 0);
            this.setTextureOffset("Piece1.Shape26", 0, 0);
            this.setTextureOffset("Piece1.Shape27", 0, 0);
            this.setTextureOffset("Piece1.Shape28", 0, 0);
            this.setTextureOffset("Piece1.Shape29", 0, 0);
            this.setTextureOffset("Piece1.Shape30", 0, 18);
            this.setTextureOffset("Piece1.Shape31", 0, 18);
            this.setTextureOffset("Piece1.Shape32", 0, 0);
            this.setTextureOffset("Piece1.Shape33", 0, 0);
            this.setTextureOffset("Piece1.Shape34", 46, 25);
            this.setTextureOffset("Piece1.Shape35", 46, 29);
            this.setTextureOffset("Piece1.Shape36", 0, 0);
            this.setTextureOffset("Piece1.Shape37", 50, 0);
            this.setTextureOffset("Piece1.Shape38", 50, 0);
            this.setTextureOffset("Piece1.Shape39", 50, 0);
            this.setTextureOffset("Piece1.Shape41", 50, 0);
            this.setTextureOffset("Piece1.Shape42", 50, 0);
            this.setTextureOffset("Piece1.Shape43", 50, 0);
            this.setTextureOffset("Piece1.Shape44", 50, 0);
            this.setTextureOffset("Piece1.Shape46", 50, 0);
            this.setTextureOffset("Piece1.Shape48", 50, 0);
            this.setTextureOffset("Piece1.Shape49", 50, 0);
            this.setTextureOffset("Piece1.Shape50", 50, 0);
            this.setTextureOffset("Piece1.Shape54", 50, 0);
            this.setTextureOffset("Piece1.Shape55", 50, 0);
            this.setTextureOffset("Piece1.Shape56", 50, 0);
            this.setTextureOffset("Piece1.Shape58", 50, 0);
            this.setTextureOffset("Piece1.Shape59", 50, 0);
            Piece1 = new MModelRenderer(this, "Piece1");
            Piece1.addBox("Shape2", 5.0F, -10.0F, 5.0F, 1, 10, 1);
            Piece1.addBox("Shape3", -5.0F, -10.0F, 5.0F, 10, 10, 2);
            Piece1.addBox("Shape4", -6.0F, -10.0F, 5.0F, 1, 10, 1);
            Piece1.addBox("Shape5", -3.0F, -13.0F, 5.0F, 6, 1, 1);
            Piece1.addBox("Shape6", -5.0F, -11.0F, 5.0F, 10, 1, 1);
            Piece1.addBox("Shape7", -6.0F, -11.0F, -3.0F, 12, 1, 8);
            Piece1.addBox("Shape8", -4.0F, -13.0F, -5.0F, 8, 3, 10);
            Piece1.addBox("Shape9", -3.0F, -12.0F, 6.0F, 6, 1, 1);
            Piece1.addBox("Shape10", -4.0F, -11.0F, 6.0F, 8, 1, 1);
            Piece1.addBox("Shape11", -4.0F, -12.0F, 5.0F, 8, 1, 1);
            Piece1.addBox("Shape12", -3.0F, -14.0F, -4.0F, 6, 1, 9);
            Piece1.addBox("Shape13", -7.0F, -10.0F, -4.0F, 2, 8, 9);
            Piece1.addBox("Shape14", 5.0F, -10.0F, -4.0F, 2, 8, 9);
            Piece1.addBox("Shape15", 6.0F, -2.0F, 4.0F, 1, 2, 1);
            Piece1.addBox("Shape16", -7.0F, -2.0F, 4.0F, 1, 2, 1);
            Piece1.addBox("Shape17", -6.0F, -10.0F, -5.0F, 1, 9, 1);
            Piece1.addBox("Shape18", -6.0F, -2.0F, -5.0F, 1, 1, 2);
            Piece1.addBox("Shape19", -7.0F, -9.0F, -5.0F, 1, 9, 1);
            Piece1.addBox("Shape20", -6.0F, -9.0F, -6.0F, 1, 9, 1);
            Piece1.addBox("Shape21", 6.0F, -9.0F, -5.0F, 1, 9, 1);
            Piece1.addBox("Shape22", 5.0F, -2.0F, -5.0F, 1, 1, 2);
            Piece1.addBox("Shape23", 5.0F, -9.0F, -6.0F, 1, 9, 1);
            Piece1.addBox("Shape24", 5.0F, -10.0F, -5.0F, 1, 9, 1);
            Piece1.addBox("Shape25", -5.0F, -2.0F, -6.0F, 1, 1, 1);
            Piece1.addBox("Shape26", -5.0F, -1.0F, -6.0F, 2, 1, 1);
            Piece1.addBox("Shape27", 4.0F, -2.0F, -6.0F, 1, 1, 1);
            Piece1.addBox("Shape28", 3.0F, -1.0F, -6.0F, 2, 1, 1);
            Piece1.addBox("Shape29", -5.0F, -10.0F, -6.0F, 10, 2, 1);
            Piece1.addBox("Shape30", 4.0F, -12.0F, -5.0F, 1, 2, 7);
            Piece1.addBox("Shape31", -5.0F, -12.0F, -5.0F, 1, 2, 7);
            Piece1.addBox("Shape32", -4.0F, -10.0F, -7.0F, 8, 2, 1);
            Piece1.addBox("Shape33", -2.0F, -8.0F, -8.0F, 4, 1, 3);
            Piece1.addBox("Shape34", -4.0F, -12.0F, -6.0F, 8, 2, 1);
            Piece1.addBox("Shape35", -3.0F, -10.0F, -8.0F, 6, 2, 1);
            Piece1.addBox("Shape36", -2.0F, -11.0F, -7.0F, 4, 1, 1);
            Piece1.addBox("Shape37", 3.0F, -17.0F, -1.0F, 1, 4, 3);
            Piece1.addBox("Shape38", 5.0F, -12.0F, -1.0F, 4, 1, 3);
            Piece1.addBox("Shape39", 4.0F, -13.0F, -1.0F, 1, 1, 3);
            Piece1.addBox("Shape41", 5.0F, -19.0F, -1.0F, 4, 1, 3);
            Piece1.addBox("Shape42", 9.0F, -18.0F, -1.0F, 1, 1, 3);
            Piece1.addBox("Shape43", 10.0F, -17.0F, -1.0F, 1, 4, 3);
            Piece1.addBox("Shape44", 9.0F, -13.0F, -1.0F, 1, 1, 3);
            Piece1.addBox("Shape46", 4.0F, -18.0F, -1.0F, 1, 1, 3);
            Piece1.addBox("Shape48", -4.0F, -17.0F, -1.0F, 1, 4, 3);
            Piece1.addBox("Shape49", -5.0F, -13.0F, -1.0F, 1, 1, 3);
            Piece1.addBox("Shape50", -9.0F, -12.0F, -1.0F, 4, 1, 3);
            Piece1.addBox("Shape54", -5.0F, -18.0F, -1.0F, 1, 1, 3);
            Piece1.addBox("Shape55", -9.0F, -19.0F, -1.0F, 4, 1, 3);
            Piece1.addBox("Shape56", -10.0F, -18.0F, -1.0F, 1, 1, 3);
            Piece1.addBox("Shape58", -11.0F, -17.0F, -1.0F, 1, 4, 3);
            Piece1.addBox("Shape59", -10.0F, -13.0F, -1.0F, 1, 1, 3);
            Shape45 = new MModelRenderer(this, 37, 15);
            Shape45.addBox(4.1F, -18.25F, 0.0F, 6, 6, 1);
            Shape45.scaleModifier = 0.98F;
            Shape51 = new MModelRenderer(this, 37, 15);
            Shape51.addBox(-10.1F, -18.25F, 0.0F, 6, 6, 1);
            Shape51.scaleModifier = 0.98F;
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
        GlStateManager.translate(0.0F, 0.1F, 0.0F);
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "ThisDorry";
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

            case 3027034:
                if (s.equals("blue"))
                {
                    b0 = 0;
                }

                break;

            case 3441014:
                if (s.equals("pink"))
                {
                    b0 = 1;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0413\u043e\u043b\u0443\u0431\u0430\u044f \u0448\u0430\u043f\u043a\u0430 \u043c\u044b\u0448\u043a\u0438";

            case 1:
                return "\u0420\u043e\u0437\u043e\u0432\u0430\u044f \u0448\u0430\u043f\u043a\u0430 \u043c\u044b\u0448\u043a\u0438";

            case 2:
                return "\u041e\u0440\u0430\u043d\u0436\u0435\u0432\u0430\u044f \u0448\u0430\u043f\u043a\u0430 \u043c\u044b\u0448\u043a\u0438";

            default:
                return "\u0425\u0443\u0439";
        }
    }

    static
    {
        colors.put("blue", new ResourceLocation("minidot", "head/helmet_mouse_blue.png"));
        colors.put("pink", new ResourceLocation("minidot", "head/helmet_mouse_pink.png"));
        colors.put("orange", new ResourceLocation("minidot", "head/helmet_mouse_orange.png"));
    }
}
