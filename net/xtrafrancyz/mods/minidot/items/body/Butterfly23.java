package net.xtrafrancyz.mods.minidot.items.body;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Butterfly23 extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Piece1;
    private String color;

    public Butterfly23(String color)
    {
        super(ItemType.BODY);
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.color = color;

        if (Piece1 == null)
        {
            this.setTextureOffset("Piece1.Shape1", 8, 12);
            this.setTextureOffset("Piece1.Shape2", 10, 6);
            this.setTextureOffset("Piece1.Shape3", 10, 6);
            this.setTextureOffset("Piece1.Shape4", 10, 6);
            this.setTextureOffset("Piece1.Shape5", 10, 6);
            this.setTextureOffset("Piece1.Shape6", 10, 6);
            this.setTextureOffset("Piece1.Shape7", 10, 6);
            this.setTextureOffset("Piece1.Shape8", 10, 6);
            this.setTextureOffset("Piece1.Shape9", 10, 6);
            this.setTextureOffset("Piece1.Shape10", 10, 6);
            this.setTextureOffset("Piece1.Shape11", 10, 6);
            this.setTextureOffset("Piece1.Shape12", 10, 6);
            this.setTextureOffset("Piece1.Shape13", 10, 6);
            this.setTextureOffset("Piece1.Shape14", 10, 6);
            this.setTextureOffset("Piece1.Shape15", 10, 6);
            this.setTextureOffset("Piece1.Shape16", 10, 6);
            this.setTextureOffset("Piece1.Shape17", 10, 6);
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
            Piece1 = new MModelRenderer(this, "Piece1");
            Piece1.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.setRotation(Piece1, 0.0F, 0.0F, 0.0F);
            Piece1.mirror = true;
            Piece1.addBox("Shape1", -1.0F, -2.0F, 0.5F, 3, 3, 1);
            Piece1.addBox("Shape2", -4.0F, 1.0F, 0.5F, 1, 2, 1);
            Piece1.addBox("Shape3", -7.0F, -5.0F, 0.5F, 2, 9, 1);
            Piece1.addBox("Shape4", -4.0F, -1.0F, 0.5F, 1, 1, 1);
            Piece1.addBox("Shape5", -3.0F, -3.0F, 0.5F, 1, 2, 1);
            Piece1.addBox("Shape6", -3.0F, 0.0F, 0.5F, 1, 2, 1);
            Piece1.addBox("Shape7", -4.0F, -4.0F, 0.5F, 1, 2, 1);
            Piece1.addBox("Shape8", -8.0F, -3.0F, 0.5F, 1, 5, 1);
            Piece1.addBox("Shape9", -5.0F, -4.0F, 0.5F, 1, 7, 1);
            Piece1.addBox("Shape10", 3.0F, -3.0F, 0.5F, 1, 2, 1);
            Piece1.addBox("Shape11", 4.0F, -4.0F, 0.5F, 1, 2, 1);
            Piece1.addBox("Shape12", 4.0F, -1.0F, 0.5F, 1, 1, 1);
            Piece1.addBox("Shape13", 3.0F, 0.0F, 0.5F, 1, 2, 1);
            Piece1.addBox("Shape14", 4.0F, 1.0F, 0.5F, 1, 2, 1);
            Piece1.addBox("Shape15", 5.0F, -4.0F, 0.5F, 1, 7, 1);
            Piece1.addBox("Shape16", 6.0F, -5.0F, 0.5F, 2, 9, 1);
            Piece1.addBox("Shape17", 8.0F, -3.0F, 0.5F, 1, 5, 1);
            Piece1.addBox("Shape18", 6.0F, -6.0F, 1.0F, 2, 11, 1);
            Piece1.addBox("Shape19", 3.0F, -4.0F, 1.0F, 1, 7, 1);
            Piece1.addBox("Shape20", 4.0F, -5.0F, 1.0F, 2, 9, 1);
            Piece1.addBox("Shape21", 8.0F, -5.0F, 1.0F, 1, 9, 1);
            Piece1.addBox("Shape22", 9.0F, -3.0F, 1.0F, 1, 5, 1);
            Piece1.addBox("Shape23", -9.0F, -3.0F, 1.0F, 1, 5, 1);
            Piece1.addBox("Shape24", -8.0F, -5.0F, 1.0F, 1, 9, 1);
            Piece1.addBox("Shape25", -7.0F, -6.0F, 1.0F, 2, 11, 1);
            Piece1.addBox("Shape26", -5.0F, -5.0F, 1.0F, 2, 9, 1);
            Piece1.addBox("Shape27", -2.0F, -3.0F, 1.0F, 5, 5, 1);
            Piece1.addBox("Shape28", -3.0F, -4.0F, 1.0F, 1, 7, 1);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.setModelRotation(modelPlayer.bipedBody);

        if (player.getCurrentArmor(2) != null)
        {
            GlStateManager.translate(0.0F, 0.0F, -0.06F);
        }

        this.setRotationAngles(this.rotateX, this.rotateY, this.rotateZ);

        if (modelPlayer.isSneak)
        {
            GlStateManager.translate(0.0F, 0.203125F, -0.11F);
        }

        GlStateManager.translate(0.0F, 0.1F, -0.185F);
        GlStateManager.scale(0.3F, 0.3F, 0.5F);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.7F, 0.7F, 1.0F);
        GlStateManager.translate(0.0F, 0.3F, 0.37F);
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

            case 93818879:
                if (s.equals("black"))
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
                return "\u041a\u0440\u0430\u0441\u043d\u0430\u044f \u0431\u0430\u0431\u043e\u0447\u043a\u0430";

            case 1:
                return "\u0411\u0435\u043b\u0430\u044f \u0431\u0430\u0431\u043e\u0447\u043a\u0430";

            case 2:
                return "\u0427\u0435\u0440\u043d\u0430\u044f \u0431\u0430\u0431\u043e\u0447\u043a\u0430";

            case 3:
                return "\u0424\u0438\u043e\u043b\u0435\u0442\u043e\u0432\u0430\u044f \u0431\u0430\u0431\u043e\u0447\u043a\u0430";

            default:
                return "\u0419\u0443\u0445";
        }
    }

    public String getCreator()
    {
        return "ANACTAC";
    }

    static
    {
        colors.put("red", new ResourceLocation("minidot", "body/butterfly23_red.png"));
        colors.put("white", new ResourceLocation("minidot", "body/butterfly23_white.png"));
        colors.put("black", new ResourceLocation("minidot", "body/butterfly23_black.png"));
        colors.put("purple", new ResourceLocation("minidot", "body/butterfly23_purple.png"));
    }
}
