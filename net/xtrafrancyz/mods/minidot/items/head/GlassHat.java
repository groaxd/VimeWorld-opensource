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
import net.xtrafrancyz.mods.minidot.util.Rainbow;

public class GlassHat extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Shape1;
    private String color;
    private boolean rainbow;

    public GlassHat(String color)
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.color = color;
        this.rainbow = color.equals("rainbow");

        if (Shape1 == null)
        {
            Shape1 = new MModelRenderer(this, 0, 0);
            Shape1.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.025F, 0.0F);

        if (player.getCurrentArmor(3) != null)
        {
            GlStateManager.scale(1.04F, 1.04F, 1.04F);
        }
        else
        {
            GlStateManager.scale(1.15F, 1.15F, 1.15F);
        }
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        if (this.rainbow)
        {
            float[] afloat = Rainbow.PALETTE[(int)(time * 7.0F) % 1536];
            GlStateManager.color(afloat[0], afloat[1], afloat[2], 1.0F);
        }

        super.render(modelPlayer, player, time, pi);

        if (this.rainbow)
        {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public void renderAsItem(float time)
    {
        if (this.rainbow)
        {
            float[] afloat = Rainbow.PALETTE[(int)(time * 7.0F) % 1536];
            GlStateManager.color(afloat[0], afloat[1], afloat[2], 1.0F);
        }

        GlStateManager.translate(0.0F, -0.08F, 0.0F);
        super.renderAsItem(time);

        if (this.rainbow)
        {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -1039745817:
                if (s.equals("normal"))
                {
                    b0 = 0;
                }

                break;

            case 973576630:
                if (s.equals("rainbow"))
                {
                    b0 = 1;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0411\u043b\u043e\u043a \u0441\u0442\u0435\u043a\u043b\u0430";

            case 1:
                return "\u0411\u043b\u043e\u043a \u0440\u0430\u0437\u043d\u043e\u0446\u0432\u0435\u0442\u043d\u043e\u0433\u043e \u0441\u0442\u0435\u043a\u043b\u0430";

            default:
                return "\u0419\u0443\u0445";
        }
    }

    static
    {
        colors.put("normal", new ResourceLocation("minidot", "head/glasshat.png"));
        colors.put("rainbow", colors.get("normal"));
    }
}
