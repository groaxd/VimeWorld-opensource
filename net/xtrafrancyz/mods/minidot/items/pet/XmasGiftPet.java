package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class XmasGiftPet extends BasePet
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Shape1;
    private static MModelRenderer Shape2;
    private static MModelRenderer Shape3;
    private static MModelRenderer Shape4;
    private static MModelRenderer Shape5;
    private static MModelRenderer Shape6;
    private static MModelRenderer Shape7;
    private static MModelRenderer Shape8;
    private static MModelRenderer Shape9;
    private static MModelRenderer Shape10;
    private static MModelRenderer Shape11;
    private static MModelRenderer Shape12;
    private static MModelRenderer Shape13;
    private static MModelRenderer Shape14;
    private static MModelRenderer Shape15;
    private static MModelRenderer Shape16;
    private String color;

    public XmasGiftPet(String color)
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.color = color;

        if (Shape1 == null)
        {
            Shape1 = new MModelRenderer(this, 0, 0);
            Shape1.addBox(-5.0F, -1.8F, -5.0F, 10, 8, 10);
            Shape1.scaleModifier = 0.95F;
            Shape2 = new MModelRenderer(this, 0, 21);
            Shape2.addBox(4.2F, -2.2F, -0.5F, 1, 8, 1);
            Shape3 = new MModelRenderer(this, 0, 21);
            Shape3.addBox(-4.8F, 5.2F, -0.5F, 10, 1, 1);
            Shape3.scaleModifier = 0.9999F;
            Shape4 = new MModelRenderer(this, 0, 21);
            Shape4.addBox(-5.2F, -2.2F, -0.5F, 10, 1, 1);
            Shape4.scaleModifier = 0.9999F;
            Shape5 = new MModelRenderer(this, 0, 21);
            Shape5.addBox(-5.2F, -1.8F, -0.5F, 1, 8, 1);
            Shape6 = new MModelRenderer(this, 0, 21);
            Shape6.addBox(-0.5F, 5.2F, -5.2F, 1, 1, 10);
            Shape7 = new MModelRenderer(this, 0, 21);
            Shape7.addBox(-0.5F, -2.2F, -4.8F, 1, 1, 10);
            Shape8 = new MModelRenderer(this, 0, 21);
            Shape8.addBox(-0.5F, -2.2F, -5.2F, 1, 8, 1);
            Shape8.scaleModifier = 0.9999F;
            Shape9 = new MModelRenderer(this, 0, 21);
            Shape9.addBox(-0.5F, -1.8F, 4.2F, 1, 8, 1);
            Shape9.scaleModifier = 0.9999F;
            Shape10 = new MModelRenderer(this, 0, 0);
            Shape10.addBox(0.5F, -4.7F, -0.5F, 1, 1, 1);
            Shape11 = new MModelRenderer(this, 0, 0);
            Shape11.addBox(-1.5F, -2.7F, -0.5F, 3, 1, 1);
            Shape12 = new MModelRenderer(this, 0, 0);
            Shape12.addBox(1.5F, -4.2F, -0.5F, 1, 2, 1);
            Shape13 = new MModelRenderer(this, 0, 0);
            Shape13.addBox(-1.5F, -4.7F, -0.5F, 1, 1, 1);
            Shape14 = new MModelRenderer(this, 0, 0);
            Shape14.addBox(-2.5F, -4.2F, -0.5F, 1, 2, 1);
            Shape15 = new MModelRenderer(this, 0, 0);
            Shape15.addBox(-0.5F, -4.2F, -0.5F, 1, 2, 1);
            Shape15.scaleModifier = 0.9999F;
            Shape16 = new MModelRenderer(this, 24, 19);
            Shape16.addBox(-5.0F, -2.0F, -5.0F, 10, 3, 10);
            Shape15.scaleModifier = 0.98F;
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.05F;
        GlStateManager.translate(0.8F, -0.5F + f, 0.3F);
        GlStateManager.rotate(time * 1.3F, 0.0F, 1.0F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        GlStateManager.translate(0.0F, -0.05F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -734239628:
                if (s.equals("yellow"))
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

            case 3027034:
                if (s.equals("blue"))
                {
                    b0 = 1;
                }

                break;

            case 98619139:
                if (s.equals("green"))
                {
                    b0 = 2;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0439 \u043f\u043e\u0434\u0430\u0440\u043e\u043a";

            case 1:
                return "\u0421\u0438\u043d\u0438\u0439 \u043f\u043e\u0434\u0430\u0440\u043e\u043a";

            case 2:
                return "\u0417\u0435\u043b\u0435\u043d\u044b\u0439 \u043f\u043e\u0434\u0430\u0440\u043e\u043a";

            case 3:
                return "\u0416\u0435\u043b\u0442\u044b\u0439 \u043f\u043e\u0434\u0430\u0440\u043e\u043a";

            default:
                return "\u0425\u0443\u0439";
        }
    }

    static
    {
        colors.put("red", new ResourceLocation("minidot", "pets/xmas_gift_red.png"));
        colors.put("blue", new ResourceLocation("minidot", "pets/xmas_gift_blue.png"));
        colors.put("green", new ResourceLocation("minidot", "pets/xmas_gift_green.png"));
        colors.put("yellow", new ResourceLocation("minidot", "pets/xmas_gift_yellow.png"));
    }
}
