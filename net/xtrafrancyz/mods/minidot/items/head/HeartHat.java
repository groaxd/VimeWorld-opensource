package net.xtrafrancyz.mods.minidot.items.head;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.Rainbow;

public class HeartHat extends BaseItem
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
    private String color;
    private boolean rainbow2;

    public HeartHat(String color)
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.color = color;
        this.rainbow2 = color.equals("rainbow2");

        if (Shape1 == null)
        {
            Shape1 = new MModelRenderer(this, 23, 0);
            Shape1.addBox(-0.5F, -17.0F, -0.5F, 1, 8, 1);
            Shape2 = new MModelRenderer(this, 18, 0);
            Shape2.addBox(-1.5F, -18.0F, -0.5F, 1, 8, 1);
            Shape3 = new MModelRenderer(this, 13, 0);
            Shape3.addBox(-2.5F, -18.0F, -0.5F, 1, 7, 1);
            Shape4 = new MModelRenderer(this, 8, 0);
            Shape4.addBox(-3.5F, -17.0F, -0.5F, 1, 5, 1);
            Shape5 = new MModelRenderer(this, 3, 0);
            Shape5.addBox(-4.5F, -16.0F, -0.5F, 1, 3, 1);
            Shape6 = new MModelRenderer(this, 28, 0);
            Shape6.addBox(0.5F, -18.0F, -0.5F, 1, 8, 1);
            Shape7 = new MModelRenderer(this, 33, 0);
            Shape7.addBox(1.5F, -18.0F, -0.5F, 1, 7, 1);
            Shape8 = new MModelRenderer(this, 38, 0);
            Shape8.addBox(2.5F, -17.0F, -0.5F, 1, 5, 1);
            Shape9 = new MModelRenderer(this, 43, 0);
            Shape9.addBox(3.5F, -16.0F, -0.5F, 1, 3, 1);

            for (MModelRenderer mmodelrenderer : this.getAllModels())
            {
                mmodelrenderer.setDynamic(true);
            }

            this.recollectModels();
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -0.3F, 0.0F);
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
        float f = time % 1000.0F * 0.5F;

        for (MModelRenderer mmodelrenderer : this.getDynamicModels())
        {
            mmodelrenderer.offsetY = MathHelper.cos(f) * 0.006F;
            --f;
        }
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        if (this.rainbow2)
        {
            float[] afloat = Rainbow.PALETTE[(int)(time * 7.0F) % 1536];
            GlStateManager.color(afloat[0], afloat[1], afloat[2], 1.0F);
        }

        super.render(modelPlayer, player, time, pi);

        if (this.rainbow2)
        {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        if (this.rainbow2)
        {
            float[] afloat = Rainbow.PALETTE[(int)(time * 7.0F) % 1536];
            GlStateManager.color(afloat[0], afloat[1], afloat[2], 1.0F);
        }

        GlStateManager.translate(0.0F, 0.3F, 0.0F);
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
        float f = time % 1000.0F * 0.5F;

        for (MModelRenderer mmodelrenderer : this.getDynamicModels())
        {
            mmodelrenderer.offsetY = MathHelper.cos(f) * 0.008F;
            --f;
        }

        super.renderAsItem(time);
    }

    protected void setModelRotation(ModelRenderer parent)
    {
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case 93508654:
                if (s.equals("basic"))
                {
                    b0 = 0;
                }

                break;

            case 116104508:
                if (s.equals("rainbow2"))
                {
                    b0 = 1;
                }

                break;

            case 973576630:
                if (s.equals("rainbow"))
                {
                    b0 = 2;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0421\u0435\u0440\u0434\u0435\u0447\u043a\u043e";

            case 1:
                return "\u0420\u0430\u0437\u043d\u043e\u0446\u0432\u0435\u0442\u043d\u043e\u0435 \u0441\u0435\u0440\u0434\u0435\u0447\u043a\u043e";

            case 2:
                return "\u0420\u0430\u0434\u0443\u0436\u043d\u043e\u0435 \u0441\u0435\u0440\u0434\u0435\u0447\u043a\u043e";

            default:
                return "\u0419\u0443\u0445";
        }
    }

    public String getCreator()
    {
        return this.color.equals("rainbow") ? "ANACTAC" : null;
    }

    static
    {
        colors.put("basic", new ResourceLocation("minidot", "head/heart.png"));
        colors.put("rainbow", new ResourceLocation("minidot", "head/heart_rainbow.png"));
        colors.put("rainbow2", new ResourceLocation("minidot", "head/heart_white.png"));
    }
}
