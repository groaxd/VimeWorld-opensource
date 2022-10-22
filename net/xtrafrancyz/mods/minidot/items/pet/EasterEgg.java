package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class EasterEgg extends BasePet
{
    private final MModelRenderer egg;
    private final String color;

    public EasterEgg(String color)
    {
        this.color = color;
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.egg = new MModelRenderer(this);
        this.egg.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.egg.setTextureOffset(15, 0).addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2, 0.0F);
        this.egg.setTextureOffset(0, 14).addBox(-1.0F, -7.5F, -1.0F, 2, 1, 2, 0.2F);
        this.egg.setTextureOffset(12, 10).addBox(-2.0F, -1.6F, -2.0F, 4, 1, 4, 0.0F);
        this.egg.setTextureOffset(0, 8).addBox(-2.0F, -6.6F, -2.0F, 4, 2, 4, 0.0F);
        this.egg.setTextureOffset(0, 0).addBox(-2.5F, -4.6F, -2.5F, 5, 3, 5, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/easteregg_" + color + ".png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        float f1 = time * 1.5F;
        GlStateManager.translate(0.65F, -1.25F + f, 0.3F);
        GlStateManager.scale(1.4F, 1.4F, 1.4F);
        GlStateManager.rotate(90.0F + f1, 0.0F, 1.0F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -1.4F, 0.0F);
        GlStateManager.scale(2.0F, 2.0F, 2.0F);
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
                    b0 = 1;
                }

                break;

            case 112785:
                if (s.equals("red"))
                {
                    b0 = 2;
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
                return "\u0411\u0435\u043b\u043e\u0435 \u043f\u0430\u0441\u0445\u0430\u043b\u044c\u043d\u043e\u0435 \u044f\u0439\u0446\u043e";

            case 1:
                return "\u041e\u0440\u0430\u043d\u0436\u0435\u0432\u043e\u0435 \u043f\u0430\u0441\u0445\u0430\u043b\u044c\u043d\u043e\u0435 \u044f\u0439\u0446\u043e";

            case 2:
                return "\u041a\u0440\u0430\u0441\u043d\u043e\u0435 \u043f\u0430\u0441\u0445\u0430\u043b\u044c\u043d\u043e\u0435 \u044f\u0439\u0446\u043e";

            case 3:
                return "\u0421\u0438\u043d\u0435\u0435 \u043f\u0430\u0441\u0445\u0430\u043b\u044c\u043d\u043e\u0435 \u044f\u0439\u0446\u043e";

            case 4:
                return "\u0417\u0435\u043b\u0451\u043d\u043e\u0435 \u043f\u0430\u0441\u0445\u0430\u043b\u044c\u043d\u043e\u0435 \u044f\u0439\u0446\u043e";

            default:
                return "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u043e\u0435 \u043f\u0430\u0441\u0445\u0430\u043b\u044c\u043d\u043e\u0435 \u044f\u0439\u0446\u043e";
        }
    }
}
