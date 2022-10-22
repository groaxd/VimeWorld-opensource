package net.xtrafrancyz.mods.minidot.items.head;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BandageHat extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private MModelRenderer hat;
    private String color;

    public BandageHat(String color)
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.color = color;
        this.hat = new MModelRenderer(this);
        this.hat.cubeList.add(new ModelBox(this.hat, 24, 12, -5.5F, -9.0F, -5.5F, 11, 2, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 0, 12, -5.5F, -9.0F, 4.5F, 11, 2, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 22, 0, -5.5F, -9.0F, -5.0F, 1, 2, 10, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 0, 0, 4.5F, -9.0F, -5.0F, 1, 2, 10, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 0, 15, 1.0F, -9.5F, 4.5F, 2, 1, 2, 0.0F, false));
        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.82F, 0.82F, 0.82F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
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
                    b0 = 1;
                }

                break;

            case 3027034:
                if (s.equals("blue"))
                {
                    b0 = 3;
                }

                break;

            case 3441014:
                if (s.equals("pink"))
                {
                    b0 = 2;
                }

                break;

            case 93818879:
                if (s.equals("black"))
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
                return "\u0411\u0435\u043b\u0430\u044f \u043f\u043e\u0432\u044f\u0437\u043a\u0430";

            case 1:
                return "\u041e\u0440\u0430\u043d\u0436\u0435\u0432\u0430\u044f \u043f\u043e\u0432\u044f\u0437\u043a\u0430";

            case 2:
                return "\u0420\u043e\u0437\u043e\u0432\u0430\u044f \u043f\u043e\u0432\u044f\u0437\u043a\u0430";

            case 3:
                return "\u0413\u043e\u043b\u0443\u0431\u0430\u044f \u043f\u043e\u0432\u044f\u0437\u043a\u0430";

            case 4:
                return "\u0427\u0435\u0440\u043d\u0430\u044f \u043f\u043e\u0432\u044f\u0437\u043a\u0430";

            default:
                return "\u0425\u0443\u0439";
        }
    }

    static
    {
        colors.put("white", new ResourceLocation("minidot", "head/bandage_hat_white.png"));
        colors.put("orange", new ResourceLocation("minidot", "head/bandage_hat_orange.png"));
        colors.put("pink", new ResourceLocation("minidot", "head/bandage_hat_pink.png"));
        colors.put("blue", new ResourceLocation("minidot", "head/bandage_hat_blue.png"));
        colors.put("black", new ResourceLocation("minidot", "head/bandage_hat_black.png"));
    }
}
