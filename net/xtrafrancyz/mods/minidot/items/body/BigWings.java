package net.xtrafrancyz.mods.minidot.items.body;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.Rainbow;

public class BigWings extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Left = null;
    private String color;
    private boolean rainbow;

    public BigWings(String color)
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.color = color;
        this.rainbow = color.equals("rainbow");

        if (Left == null)
        {
            this.setTextureOffset("Left.LWing", 0, -15);
            this.setTextureOffset("Left.Shape2123", 0, 0);
            this.setTextureOffset("Left.Shape4123", 0, 0);
            this.setTextureOffset("Left.Shape5123", 8, 0);
            this.setTextureOffset("Left.Shape6123", 0, 0);
            this.setTextureOffset("Left.Shape7123", 8, 0);
            this.setTextureOffset("Left.Shape8123", 8, 0);
            this.setTextureOffset("Left.Shape1123", 8, 0);
            this.setTextureOffset("Left.Shape9123", 0, 0);
            this.setTextureOffset("Left.Shape10123", 8, 0);
            this.setTextureOffset("Left.Shape11123", 8, 0);
            this.setTextureOffset("Left.Shape12123", 8, 0);
            this.setTextureOffset("Left.Shape13123", 8, 0);
            this.setTextureOffset("Left.Shape15123", 8, 0);
            this.setTextureOffset("Left.Shape17123", 8, 0);
            this.setTextureOffset("Left.Shape18123", 8, 0);
            this.setTextureOffset("Left.Shape19123", 8, 0);
            this.setTextureOffset("Left.Shape20123", 8, 0);
            this.setTextureOffset("Left.Shape21123", 8, 0);
            this.setTextureOffset("Left.Shape3123", 0, 0);
            this.setTextureOffset("Left.Shape14123", 0, 0);
            this.setTextureOffset("Left.Shape16123", 0, 0);
            this.setTextureOffset("Left.Shape22123", 0, 0);
            this.setTextureOffset("Left.Shape24123", 0, 0);
            this.setTextureOffset("Left.Shape23123", 0, 0);
            this.setTextureOffset("Left.Shape25123", 0, 0);
            this.setTextureOffset("Left.Shape27123", 8, 0);
            this.setTextureOffset("Left.Shape26123", 0, 0);
            this.setTextureOffset("Left.Shape28123", 8, 0);
            this.setTextureOffset("Left.Shape29123", 8, 0);
            this.setTextureOffset("Left.Shape30123", 8, 0);
            this.setTextureOffset("Left.Shape31123", 8, 0);
            this.setTextureOffset("Left.Shape32123", 0, 0);
            this.setTextureOffset("Left.Shape33123", 0, 0);
            this.setTextureOffset("Left.Shape34123", 8, 0);
            this.setTextureOffset("Left.Shape35123", 8, 0);
            this.setTextureOffset("Left.Shape36123", 8, 0);
            this.setTextureOffset("Left.Shape37123", 0, 0);
            this.setTextureOffset("Left.Shape38123", 0, 0);
            this.setTextureOffset("Left.Shape39123", 0, 0);
            this.setTextureOffset("Left.Shape40123", 8, 0);
            this.setTextureOffset("Left.Shape41123", 8, 0);
            this.setTextureOffset("Left.Shape42123", 8, 0);
            this.setTextureOffset("Left.Shape43123", 8, 0);
            this.setTextureOffset("Left.Shape44123", 0, 0);
            this.setTextureOffset("Left.Shape45123", 0, 0);
            this.setTextureOffset("Left.Shape46123", 8, 0);
            this.setTextureOffset("Left.Shape47123", 8, 0);
            this.setTextureOffset("Left.Shape48123", 0, 0);
            this.setTextureOffset("Left.Shape49123", 0, 0);
            this.setTextureOffset("Left.Shape50123", 0, 0);
            this.setTextureOffset("Left.Shape51123", 0, 0);
            this.setTextureOffset("Left.Shape52123", 0, 0);
            this.setTextureOffset("Left.Shape53123", 8, 0);
            this.setTextureOffset("Left.Shape54123", 8, 0);
            this.setTextureOffset("Left.Shape55123", 0, 0);
            this.setTextureOffset("Left.Shape56123", 8, 0);
            this.setTextureOffset("Left.Shape57123", 0, 0);
            this.setTextureOffset("Left.Shape58123", 8, 0);
            this.setTextureOffset("Left.Shape59123", 0, 0);
            this.setTextureOffset("Left.Shape60123", 8, 0);
            this.setTextureOffset("Left.Shape61123", 0, 0);
            this.setTextureOffset("Left.Shape62123", 0, 0);
            this.setTextureOffset("Left.Shape63123", 0, 0);
            this.setTextureOffset("Left.Shape64123", 0, 0);
            this.setTextureOffset("Left.Shape65123", 0, 0);
            this.setTextureOffset("Left.Shape66123", 0, 0);
            this.setTextureOffset("Left.Shape67123", 0, 0);
            this.setTextureOffset("Left.Shape68123", 8, 0);
            this.setTextureOffset("Left.Shape69123", 8, 0);
            this.setTextureOffset("Left.Shape70123", 8, 0);
            this.setTextureOffset("Left.Shape71123", 8, 0);
            this.setTextureOffset("Left.Shape72123", 8, 0);
            this.setTextureOffset("Left.Shape73123", 8, 0);
            Left = new MModelRenderer(this, "Left");
            Left.mirror = true;
            Left.addBox("LWing", 1.0F, -5.0F, 5.0F, 0, 17, 30);
            Left.addBox("LWing", 1.0F, -5.0F, 5.0F, 0, 17, 30);
            Left.addBox("Shape2123", 0.5F, -5.0F, 16.0F, 1, 1, 2);
            Left.addBox("Shape4123", 0.5F, -4.0F, 14.0F, 1, 1, 1);
            Left.addBox("Shape5123", 0.5F, -4.0F, 15.0F, 1, 1, 1);
            Left.addBox("Shape6123", 0.5F, -4.0F, 19.0F, 1, 1, 1);
            Left.addBox("Shape7123", 0.5F, -5.0F, 18.0F, 1, 1, 1);
            Left.addBox("Shape8123", 0.5F, -4.0F, 20.0F, 1, 1, 1);
            Left.addBox("Shape1123", 0.5F, -3.0F, 21.0F, 1, 1, 1);
            Left.addBox("Shape9123", 0.5F, -2.0F, 22.0F, 1, 1, 1);
            Left.addBox("Shape10123", 0.5F, -2.0F, 23.0F, 1, 1, 1);
            Left.addBox("Shape11123", 0.5F, -1.0F, 24.0F, 1, 1, 1);
            Left.addBox("Shape12123", 0.5F, 0.0F, 25.0F, 1, 1, 1);
            Left.addBox("Shape13123", 0.5F, 7.0F, 34.0F, 1, 1, 1);
            Left.addBox("Shape15123", 0.5F, 6.0F, 32.0F, 1, 1, 2);
            Left.addBox("Shape17123", 0.5F, 5.0F, 30.0F, 1, 1, 2);
            Left.addBox("Shape18123", 0.5F, 4.0F, 29.0F, 1, 1, 1);
            Left.addBox("Shape19123", 0.5F, 3.0F, 28.0F, 1, 1, 1);
            Left.addBox("Shape20123", 0.5F, 1.0F, 26.0F, 1, 1, 1);
            Left.addBox("Shape21123", 0.5F, 2.0F, 27.0F, 1, 1, 1);
            Left.addBox("Shape3123", 0.5F, 8.0F, 31.0F, 1, 1, 3);
            Left.addBox("Shape14123", 0.5F, 8.0F, 30.0F, 1, 1, 1);
            Left.addBox("Shape16123", 0.5F, 7.0F, 27.0F, 1, 1, 3);
            Left.addBox("Shape22123", 0.5F, 6.0F, 26.0F, 1, 1, 1);
            Left.addBox("Shape24123", 0.5F, 8.0F, 28.0F, 1, 1, 1);
            Left.addBox("Shape23123", 0.5F, 5.0F, 25.0F, 1, 1, 1);
            Left.addBox("Shape25123", 0.5F, 11.0F, 28.0F, 1, 1, 2);
            Left.addBox("Shape27123", 0.5F, 6.0F, 27.0F, 1, 1, 1);
            Left.addBox("Shape26123", 0.5F, 10.0F, 26.0F, 1, 1, 2);
            Left.addBox("Shape28123", 0.5F, 4.0F, 24.0F, 1, 1, 1);
            Left.addBox("Shape29123", 0.5F, 3.0F, 23.0F, 1, 1, 1);
            Left.addBox("Shape30123", 0.5F, 9.0F, 29.0F, 1, 1, 1);
            Left.addBox("Shape31123", 0.5F, 10.0F, 30.0F, 1, 1, 1);
            Left.addBox("Shape32123", 0.5F, 9.0F, 25.0F, 1, 1, 1);
            Left.addBox("Shape33123", 0.5F, 8.0F, 24.0F, 1, 1, 1);
            Left.addBox("Shape34123", 0.5F, 10.0F, 24.0F, 1, 1, 1);
            Left.addBox("Shape35123", 0.5F, 6.0F, 22.0F, 1, 1, 1);
            Left.addBox("Shape36123", 0.5F, 7.0F, 23.0F, 1, 1, 1);
            Left.addBox("Shape37123", 0.5F, 11.0F, 23.0F, 1, 1, 2);
            Left.addBox("Shape38123", 0.5F, 10.0F, 22.0F, 1, 1, 1);
            Left.addBox("Shape39123", 0.5F, 9.0F, 21.0F, 1, 1, 1);
            Left.addBox("Shape40123", 0.5F, 8.0F, 20.0F, 1, 1, 1);
            Left.addBox("Shape41123", 0.5F, 7.0F, 19.0F, 1, 1, 1);
            Left.addBox("Shape42123", 0.5F, 10.0F, 20.0F, 1, 1, 1);
            Left.addBox("Shape43123", 0.5F, 10.0F, 18.0F, 1, 1, 1);
            Left.addBox("Shape44123", 0.5F, 11.0F, 18.0F, 1, 1, 2);
            Left.addBox("Shape45123", 0.5F, 9.0F, 17.0F, 1, 2, 1);
            Left.addBox("Shape46123", 0.5F, 8.0F, 16.0F, 1, 1, 1);
            Left.addBox("Shape47123", 0.5F, 10.0F, 16.0F, 1, 1, 1);
            Left.addBox("Shape48123", 0.5F, 11.0F, 15.0F, 1, 1, 1);
            Left.addBox("Shape49123", 0.5F, 9.0F, 14.0F, 1, 2, 1);
            Left.addBox("Shape50123", 0.5F, 11.0F, 13.0F, 1, 1, 1);
            Left.addBox("Shape51123", 0.5F, 10.0F, 12.0F, 1, 1, 1);
            Left.addBox("Shape52123", 0.5F, 9.0F, 11.0F, 1, 1, 1);
            Left.addBox("Shape53123", 0.5F, 8.0F, 11.0F, 1, 1, 1);
            Left.addBox("Shape54123", 0.5F, 9.0F, 10.0F, 1, 1, 1);
            Left.addBox("Shape55123", 0.5F, 10.0F, 8.0F, 1, 1, 2);
            Left.addBox("Shape56123", 0.5F, 9.0F, 8.0F, 1, 1, 1);
            Left.addBox("Shape57123", 0.5F, 9.0F, 7.0F, 1, 1, 1);
            Left.addBox("Shape58123", 0.5F, 8.0F, 7.0F, 1, 1, 1);
            Left.addBox("Shape59123", 0.5F, 7.0F, 6.0F, 1, 2, 1);
            Left.addBox("Shape60123", 0.5F, 6.0F, 6.0F, 1, 1, 1);
            Left.addBox("Shape61123", 0.5F, 3.0F, 5.0F, 1, 4, 1);
            Left.addBox("Shape62123", 0.5F, 2.0F, 6.0F, 1, 1, 1);
            Left.addBox("Shape63123", 0.5F, -3.0F, 12.0F, 1, 1, 2);
            Left.addBox("Shape64123", 0.5F, -2.0F, 10.0F, 1, 1, 2);
            Left.addBox("Shape65123", 0.5F, 1.0F, 7.0F, 1, 1, 1);
            Left.addBox("Shape66123", 0.5F, 0.0F, 8.0F, 1, 1, 1);
            Left.addBox("Shape67123", 0.5F, -1.0F, 9.0F, 1, 1, 1);
            Left.addBox("Shape68123", 0.5F, 2.0F, 10.0F, 1, 1, 1);
            Left.addBox("Shape69123", 0.5F, 1.0F, 11.0F, 1, 1, 2);
            Left.addBox("Shape70123", 0.5F, 0.0F, 13.0F, 1, 1, 2);
            Left.addBox("Shape71123", 0.5F, -1.0F, 15.0F, 1, 1, 2);
            Left.addBox("Shape72123", 0.5F, -2.0F, 17.0F, 1, 1, 2);
            Left.addBox("Shape73123", 0.5F, -1.0F, 19.0F, 1, 1, 1);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        if (this.rainbow)
        {
            float[] afloat = Rainbow.PALETTE[(int)(time * 7.0F) % 1536];
            GlStateManager.color(afloat[0], afloat[1], afloat[2], 1.0F);
        }

        float f = MathHelper.cos(time * 0.26F) * 2.0F;
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.pushMatrix();
        GlStateManager.enableCull();
        GlStateManager.scale(1.0F, 1.0F, 0.8F);
        this.preRender(modelPlayer, player, time, pi);
        GlStateManager.pushMatrix();
        GlStateManager.rotate(25.0F - f, 0.5F, 2.0F, 0.0F);
        GlStateManager.translate(-0.05F, 0.0F, -0.1F);
        Left.render(0.052500002F);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.rotate(-25.0F + f, -0.5F, 2.0F, 0.0F);
        GlStateManager.translate(-0.06F, 0.0F, -0.1F);
        Left.render(0.052500002F);
        GlStateManager.popMatrix();
        GlStateManager.disableCull();
        GlStateManager.popMatrix();

        if (this.rainbow)
        {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public void renderAsItem(float time)
    {
        if (this.rainbow)
        {
            float[] afloat = Rainbow.PALETTE[(int)((double)time * 0.2D) % 1536];
            GlStateManager.color(afloat[0], afloat[1], afloat[2], 1.0F);
        }

        GlStateManager.translate(0.0F, 0.1F, -0.4F);
        GlStateManager.scale(0.7F, 0.7F, 0.4F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.pushMatrix();
        GlStateManager.rotate(35.0F, 1.5F, 1.0F, 0.0F);
        GlStateManager.translate(-0.05F, 0.0F, -0.1F);
        Left.render(0.052500002F);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.rotate(-35.0F, -1.5F, 1.0F, 0.0F);
        GlStateManager.translate(-0.06F, 0.0F, -0.1F);
        Left.render(0.052500002F);
        GlStateManager.popMatrix();

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
            case -1008851410:
                if (s.equals("orange"))
                {
                    b0 = 2;
                }

                break;

            case 93818879:
                if (s.equals("black"))
                {
                    b0 = 0;
                }

                break;

            case 113101865:
                if (s.equals("white"))
                {
                    b0 = 1;
                }

                break;

            case 973576630:
                if (s.equals("rainbow"))
                {
                    b0 = 3;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0411\u043e\u043b\u044c\u0448\u0438\u0435 \u0447\u0435\u0440\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";

            case 1:
                return "\u0411\u043e\u043b\u044c\u0448\u0438\u0435 \u0431\u0435\u043b\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";

            case 2:
                return "\u0411\u043e\u043b\u044c\u0448\u0438\u0435 \u043e\u0440\u0430\u043d\u0436\u0435\u0432\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";

            case 3:
                return "\u0411\u043e\u043b\u044c\u0448\u0438\u0435 \u0440\u0430\u0437\u043d\u043e\u0446\u0432\u0435\u0442\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";

            default:
                return "\u0419\u0443\u0445";
        }
    }

    static
    {
        colors.put("black", new ResourceLocation("minidot", "body/black_bigwings.png"));
        colors.put("white", new ResourceLocation("minidot", "body/white_bigwings.png"));
        colors.put("orange", new ResourceLocation("minidot", "body/orange_bigwings.png"));
        colors.put("rainbow", colors.get("white"));
    }
}
