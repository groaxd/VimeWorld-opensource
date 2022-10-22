package net.xtrafrancyz.mods.minidot.items.body;

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

public class Scarf extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Shape1;
    private static MModelRenderer Shape2;
    private static MModelRenderer Shape3;
    private static MModelRenderer Shape4;
    private static MModelRenderer Shape5;
    private static MModelRenderer Shape6;
    private static MModelRenderer Shape7;
    private final String color;

    public Scarf(String color)
    {
        super(ItemType.BODY);
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.color = color;

        if (Shape1 == null)
        {
            Shape1 = new MModelRenderer(this, 0, 0);
            Shape1.addBox(-3.5F, -0.3F, -3.0F, 7, 2, 1);
            Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
            Shape1.setTextureSize(16, 16);
            Shape1.mirror = true;
            this.setRotation(Shape1, 0.1047198F, 0.0F, 0.0F);
            Shape2 = new MModelRenderer(this, 0, 0);
            Shape2.addBox(-3.5F, -0.4F, 2.0F, 7, 2, 1);
            Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
            Shape2.setTextureSize(16, 16);
            Shape2.mirror = true;
            this.setRotation(Shape2, -0.1047198F, 0.0F, 0.0F);
            Shape3 = new MModelRenderer(this, 1, 3);
            Shape3.addBox(-4.0F, -0.5F, -2.5F, 1, 2, 5);
            Shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
            Shape3.setTextureSize(16, 16);
            Shape3.mirror = true;
            this.setRotation(Shape3, 0.0F, 0.0F, -0.122173F);
            Shape4 = new MModelRenderer(this, 1, 3);
            Shape4.addBox(3.0F, -0.4666667F, -2.5F, 1, 2, 5);
            Shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
            Shape4.setTextureSize(16, 16);
            Shape4.mirror = true;
            this.setRotation(Shape4, 0.0F, 0.0F, 0.122173F);
            Shape5 = new MModelRenderer(this, 0, 3);
            Shape5.addBox(-2.433333F, 1.266667F, -2.5F, 2, 3, 1);
            Shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
            Shape5.setTextureSize(16, 16);
            Shape5.mirror = true;
            this.setRotation(Shape5, -0.0698132F, 0.0F, 0.0523599F);
            Shape6 = new MModelRenderer(this, 1, 3);
            Shape6.addBox(-1.566667F, 1.733333F, -2.5F, 1, 2, 1);
            Shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
            Shape6.setTextureSize(16, 16);
            Shape6.mirror = true;
            this.setRotation(Shape6, -0.0174533F, 0.0F, -0.122173F);
            Shape7 = new MModelRenderer(this, 0, 0);
            Shape7.addBox(-3.0F, 0.4F, 2.0F, 6, 1, 1);
            Shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
            Shape7.setTextureSize(16, 16);
            Shape7.mirror = true;
            this.setRotation(Shape7, -0.2792527F, 0.0F, 0.0F);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.setModelRotation(modelPlayer.bipedBody);

        if (player.getCurrentArmor(2) != null)
        {
            GlStateManager.translate(0.0F, -0.05F, 0.0F);
        }

        this.setRotationAngles(this.rotateX, this.rotateY, this.rotateZ);

        if (modelPlayer.isSneak)
        {
            GlStateManager.translate(0.0F, 0.203125F, -0.1F);
        }

        if (player.getCurrentArmor(2) != null)
        {
            GlStateManager.scale(1.1F, 1.1F, 1.15F);
        }
        else
        {
            GlStateManager.scale(1.1F, 1.1F, 1.1F);
        }
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
        GlStateManager.translate(0.0F, 0.25F, 0.4F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case 112785:
                if (s.equals("red"))
                {
                    b0 = 0;
                }

                break;

            case 3027034:
                if (s.equals("blue"))
                {
                    b0 = 3;
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
                return "\u0421\u0438\u043d\u0438\u0439 \u0448\u0430\u0440\u0444";

            default:
                return "\u0419\u0443\u0445";
        }
    }

    public String getCreator()
    {
        return "Ursun";
    }

    static
    {
        colors.put("red", new ResourceLocation("minidot", "body/scarf_red.png"));
        colors.put("white", new ResourceLocation("minidot", "body/scarf_white.png"));
        colors.put("green", new ResourceLocation("minidot", "body/scarf_green.png"));
        colors.put("blue", new ResourceLocation("minidot", "body/scarf_blue.png"));
    }
}
