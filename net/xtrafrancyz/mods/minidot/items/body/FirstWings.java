package net.xtrafrancyz.mods.minidot.items.body;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelBase;
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

public class FirstWings extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Right1;
    private static MModelRenderer Left1;
    private static MModelRenderer Left2;
    private static MModelRenderer Left3;
    private static MModelRenderer Left4;
    private static MModelRenderer Left5;
    private static MModelRenderer Right2;
    private static MModelRenderer Right3;
    private static MModelRenderer Right4;
    private static MModelRenderer Right5;
    private String color;
    private boolean rainbow;

    public FirstWings(String color)
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.color = color;
        this.rainbow = color.equals("rainbow");

        if (Left1 == null)
        {
            Left1 = new FirstWings.CustomModelRenderer(this, 24, 0);
            Left1.addBox(-1.0F, 0.0F, -2.0F, 1, 3, 6);
            Left1.setRotationPoint(3.0F, -9.0F, 7.0F);
            Left2 = new FirstWings.CustomModelRenderer(this, 0, 0);
            Left2.addBox(-1.0F, 3.8F, 5.0F, 1, 29, 1);
            Left2.setRotationPoint(3.0F, -9.0F, 7.0F);
            Left3 = new FirstWings.CustomModelRenderer(this, 6, 0);
            Left3.addBox(-1.0F, 2.9F, 3.0F, 1, 24, 1);
            Left3.setRotationPoint(3.0F, -9.0F, 7.0F);
            Left4 = new FirstWings.CustomModelRenderer(this, 12, 0);
            Left4.addBox(-1.0F, 3.0F, 1.0F, 1, 19, 1);
            Left4.setRotationPoint(3.0F, -9.0F, 7.0F);
            Left5 = new FirstWings.CustomModelRenderer(this, 18, 0);
            Left5.addBox(-1.0F, 2.9F, -1.0F, 1, 14, 1);
            Left5.setRotationPoint(3.0F, -9.0F, 7.0F);
            this.setRotation(Left1, 0.6108652F, 0.5235988F, 0.0F);
            this.setRotation(Left2, ((float)Math.PI / 4F), 0.5235988F, 0.0F);
            this.setRotation(Left3, ((float)Math.PI * 2F / 9F), 0.5235988F, 0.0F);
            this.setRotation(Left4, 0.6108652F, 0.5235988F, 0.0F);
            this.setRotation(Left5, 0.5235988F, 0.5235988F, 0.0F);
            Right1 = new FirstWings.CustomModelRenderer(this, 24, 0);
            Right1.addBox(0.0F, 0.0F, -2.0F, 1, 3, 6);
            Right1.setRotationPoint(-3.0F, -9.0F, 7.0F);
            Right2 = new FirstWings.CustomModelRenderer(this, 0, 0);
            Right2.addBox(0.0F, 3.8F, 5.0F, 1, 29, 1);
            Right2.setRotationPoint(-3.0F, -9.0F, 7.0F);
            Right3 = new FirstWings.CustomModelRenderer(this, 6, 0);
            Right3.addBox(0.0F, 2.9F, 3.0F, 1, 24, 1);
            Right3.setRotationPoint(-3.0F, -9.0F, 7.0F);
            Right4 = new FirstWings.CustomModelRenderer(this, 12, 0);
            Right4.addBox(0.0F, 3.0F, 1.0F, 1, 19, 1);
            Right4.setRotationPoint(-3.0F, -9.0F, 7.0F);
            Right5 = new FirstWings.CustomModelRenderer(this, 18, 0);
            Right5.addBox(0.0F, 2.9F, -1.0F, 1, 14, 1);
            Right5.setRotationPoint(-3.0F, -9.0F, 7.0F);
            this.setRotation(Right1, 0.6108652F, -0.5235988F, 0.0F);
            this.setRotation(Right2, ((float)Math.PI / 4F), -0.5235988F, 0.0F);
            this.setRotation(Right3, ((float)Math.PI * 2F / 9F), -0.5235988F, 0.0F);
            this.setRotation(Right4, 0.6108652F, -0.5235988F, 0.0F);
            this.setRotation(Right5, 0.5235988F, -0.5235988F, 0.0F);

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
        float f = MathHelper.cos(time * 0.26F) * 0.06F - 0.03F;
        Left1.rotationY = f;
        Left2.rotationY = f;
        Left3.rotationY = f;
        Left4.rotationY = f;
        Left5.rotationY = f;
        Right1.rotationY = -f;
        Right2.rotationY = -f;
        Right3.rotationY = -f;
        Right4.rotationY = -f;
        Right5.rotationY = -f;
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

        double d0 = 0.8D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, 0.12D, 0.0D);
        super.renderAsItem(time);

        if (this.rainbow)
        {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public String getName()
    {
        return this.color.equals("blue") ? "\u0421\u0438\u043d\u0438\u0435 \u043a\u0440\u044b\u043b\u044c\u044f" : (this.color.equals("pink") ? "\u0420\u043e\u0437\u043e\u0432\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f" : (this.color.equals("green") ? "\u0417\u0435\u043b\u0435\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f" : (this.color.equals("white") ? "\u0411\u0435\u043b\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f" : (this.color.equals("black") ? "\u0427\u0435\u0440\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f" : (this.color.equals("rainbow") ? "\u0420\u0430\u0437\u043d\u043e\u0446\u0432\u0435\u0442\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f" : "\u0419\u0443\u0445")))));
    }

    static
    {
        colors.put("blue", new ResourceLocation("minidot", "body/wings_blue.png"));
        colors.put("pink", new ResourceLocation("minidot", "body/wings_pink.png"));
        colors.put("green", new ResourceLocation("minidot", "body/wings_green.png"));
        colors.put("white", new ResourceLocation("minidot", "body/wings_white.png"));
        colors.put("black", new ResourceLocation("minidot", "body/wings_black.png"));
        colors.put("rainbow", colors.get("white"));
    }

    private static class CustomModelRenderer extends MModelRenderer
    {
        public CustomModelRenderer(ModelBase par1ModelBase, int x, int y)
        {
            super(par1ModelBase, x, y);
        }

        public void setRotationPoint(float x, float y, float z)
        {
            y = 0.0F;
            z = z - 5.0F;
            super.setRotationPoint(x, y, z);
        }

        public ModelRenderer addBox(float par1, float par2, float par3, int par4, int par5, int par6)
        {
            par2 = par2 / 1.5F;
            par3 = par3 / 1.5F;
            par5 = (int)((float)par5 / 1.5F);
            return super.addBox(par1, par2, par3, par4, par5, par6);
        }
    }
}
