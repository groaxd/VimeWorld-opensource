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

public class BatterflyWingsV2 extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static int displayList;
    private static boolean compiled;
    private static MModelRenderer[] wing = null;
    private String color;

    public BatterflyWingsV2(String color)
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.useDisplayLists = true;
        this.color = color;

        if (wing == null)
        {
            wing = new MModelRenderer[28];
            wing[0] = new MModelRenderer(this, 8, -1);
            wing[1] = new MModelRenderer(this, 0, 32);
            wing[2] = new MModelRenderer(this, 0, 36);
            wing[3] = new MModelRenderer(this, 0, 32);
            wing[4] = new MModelRenderer(this, 0, 32);
            wing[5] = new MModelRenderer(this, 0, 32);
            wing[6] = new MModelRenderer(this, 0, 36);
            wing[7] = new MModelRenderer(this, 0, 39);
            wing[8] = new MModelRenderer(this, 0, 36);
            wing[9] = new MModelRenderer(this, 0, 36);
            wing[10] = new MModelRenderer(this, 0, 36);
            wing[11] = new MModelRenderer(this, 0, 32);
            wing[12] = new MModelRenderer(this, 6, 36);
            wing[13] = new MModelRenderer(this, 0, 39);
            wing[14] = new MModelRenderer(this, 6, 36);
            wing[15] = new MModelRenderer(this, 0, 39);
            wing[16] = new MModelRenderer(this, 0, 39);
            wing[17] = new MModelRenderer(this, 0, 41);
            wing[18] = new MModelRenderer(this, 0, 41);
            wing[19] = new MModelRenderer(this, 0, 36);
            wing[20] = new MModelRenderer(this, 0, 46);
            wing[21] = new MModelRenderer(this, 0, 41);
            wing[22] = new MModelRenderer(this, 0, 36);
            wing[23] = new MModelRenderer(this, 0, 36);
            wing[24] = new MModelRenderer(this, 0, 36);
            wing[25] = new MModelRenderer(this, 0, 36);
            wing[26] = new MModelRenderer(this, 0, 32);
            wing[27] = new MModelRenderer(this, 0, 32);
            wing[0].addBox(1.5F, -7.0F, -14.9F, 0, 21, 12);
            wing[1].addBox(1.0F, 3.8F, -0.6F, 1, 1, 3);
            wing[2].addBox(1.0F, 3.7F, -2.9F, 1, 1, 2);
            wing[3].addBox(1.0F, 3.1F, -6.4F, 1, 1, 3);
            wing[4].addBox(1.0F, 2.5F, -9.6F, 1, 1, 3);
            wing[5].addBox(1.0F, -0.1F, -12.9F, 1, 1, 3);
            wing[6].addBox(1.0F, -1.7F, -14.8F, 1, 1, 2);
            wing[7].addBox(1.0F, -13.9F, -6.3F, 1, 1, 1);
            wing[8].addBox(1.0F, -15.1F, -4.5F, 1, 1, 2);
            wing[9].addBox(1.0F, -13.2F, 6.6F, 1, 1, 2);
            wing[10].addBox(1.0F, -11.9F, 6.8F, 1, 1, 2);
            wing[11].addBox(1.0F, -12.9F, 1.8F, 1, 1, 3);
            wing[12].addBox(1.0F, 3.0F, -12.8F, 1, 2, 1);
            wing[13].addBox(1.0F, 4.2F, -12.3F, 1, 1, 1);
            wing[14].addBox(1.0F, 4.5F, -12.4F, 1, 2, 1);
            wing[15].addBox(1.0F, 1.9F, -13.8F, 1, 1, 1);
            wing[16].addBox(1.0F, 6.5F, -12.0F, 1, 1, 1);
            wing[17].addBox(1.0F, 5.5F, -11.6F, 1, 1, 4);
            wing[18].addBox(1.0F, 6.1F, -7.1F, 1, 1, 4);
            wing[19].addBox(1.0F, 6.5F, -2.0F, 1, 1, 2);
            wing[20].addBox(1.0F, 4.0F, -2.9F, 1, 7, 1);
            wing[21].addBox(1.0F, -2.4F, -12.9F, 1, 1, 4);
            wing[22].addBox(1.0F, -8.5F, -11.9F, 1, 1, 2);
            wing[23].addBox(1.0F, -12.0F, -10.3F, 1, 1, 2);
            wing[24].addBox(1.0F, -15.2F, -6.3F, 1, 1, 2);
            wing[25].addBox(1.0F, -15.2F, 4.2F, 1, 1, 2);
            wing[26].addBox(1.0F, 9.9F, -11.4F, 1, 1, 3);
            wing[27].addBox(1.0F, 6.4F, -11.6F, 1, 1, 3);
            this.setRotation(wing[0], 0.0F, (float)Math.PI, 0.0F);
            this.setRotation(wing[1], -1.047198F, (float)Math.PI, 0.0F);
            this.setRotation(wing[2], -0.9599311F, (float)Math.PI, 0.0F);
            this.setRotation(wing[3], -((float)Math.PI / 4F), (float)Math.PI, 0.0F);
            this.setRotation(wing[4], -((float)Math.PI * 2F / 9F), (float)Math.PI, 0.0F);
            this.setRotation(wing[5], -0.4363323F, (float)Math.PI, 0.0F);
            this.setRotation(wing[6], -((float)Math.PI / 10F), (float)Math.PI, 0.0F);
            this.setRotation(wing[7], ((float)Math.PI / 4F), (float)Math.PI, 0.0F);
            this.setRotation(wing[8], 1.047198F, (float)Math.PI, 0.0F);
            this.setRotation(wing[9], 1.919862F, (float)Math.PI, 0.0F);
            this.setRotation(wing[10], 2.094395F, (float)Math.PI, 0.0F);
            this.setRotation(wing[11], 1.919862F, (float)Math.PI, 0.0F);
            this.setRotation(wing[12], -0.0872665F, (float)Math.PI, 0.0F);
            this.setRotation(wing[13], -0.1745329F, (float)Math.PI, 0.0F);
            this.setRotation(wing[14], -0.1745329F, (float)Math.PI, 0.0F);
            this.setRotation(wing[15], 0.1745329F, (float)Math.PI, 0.0F);
            this.setRotation(wing[16], -0.1745329F, (float)Math.PI, 0.0F);
            this.setRotation(wing[17], -0.0872665F, (float)Math.PI, 0.0F);
            this.setRotation(wing[18], -0.1745329F, (float)Math.PI, 0.0F);
            this.setRotation(wing[19], -0.3490659F, (float)Math.PI, 0.0F);
            this.setRotation(wing[20], 0.0F, (float)Math.PI, 0.0F);
            this.setRotation(wing[21], 0.8726646F, (float)Math.PI, 0.0F);
            this.setRotation(wing[22], 1.396263F, (float)Math.PI, 0.0F);
            this.setRotation(wing[23], 1.745329F, (float)Math.PI, 0.0F);
            this.setRotation(wing[24], 2.181662F, (float)Math.PI, 0.0F);
            this.setRotation(wing[25], 2.96706F, (float)Math.PI, 0.0F);
            this.setRotation(wing[26], 0.3490659F, (float)Math.PI, 0.0F);
            this.setRotation(wing[27], ((float)Math.PI * 2F / 9F), (float)Math.PI, 0.0F);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.cos(time * 0.46F) * 4.0F;
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.pushMatrix();
        GlStateManager.enableCull();
        this.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.0F, 0.03F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.05F, 0.0F, 0.0F);
        GlStateManager.rotate(25.0F - f, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0.1F, 0.0F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(-0.05F, 0.0F, 0.0F);
        GlStateManager.rotate(-25.0F + f, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0.05F, 0.0F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.disableCull();
        GlStateManager.popMatrix();
    }

    public void renderAsItem(float time)
    {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.translate(0.0F, -0.1F, -0.2F);
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.05F, 0.0F, 0.0F);
        GlStateManager.rotate(25.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0.1F, 0.0F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(-0.05F, 0.0F, 0.0F);
        GlStateManager.rotate(-25.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0.05F, 0.0F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
    }

    protected void renderModels()
    {
        if (super.compiled)
        {
            super.renderModels();
        }
        else
        {
            if (compiled)
            {
                super.compiled = true;
                super.displayList = displayList;
                this.recollectModels();
            }

            super.renderModels();

            if (!compiled)
            {
                compiled = true;
                displayList = super.displayList;
            }
        }
    }

    public String getCreator()
    {
        return "APTEM";
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
                    b0 = 3;
                }

                break;

            case 3027034:
                if (s.equals("blue"))
                {
                    b0 = 0;
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
                return "\u0421\u0438\u043d\u0438\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0431\u0430\u0431\u043e\u0447\u043a\u0438";

            case 1:
                return "\u0411\u0435\u043b\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0431\u0430\u0431\u043e\u0447\u043a\u0438";

            case 2:
                return "\u0417\u0435\u043b\u0435\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0431\u0430\u0431\u043e\u0447\u043a\u0438";

            case 3:
                return "\u041e\u0440\u0430\u043d\u0436\u0435\u0432\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0431\u0430\u0431\u043e\u0447\u043a\u0438";

            default:
                return "\u0419\u0443\u0445";
        }
    }

    static
    {
        colors.put("blue", new ResourceLocation("minidot", "body/batterfly_wings_blue.png"));
        colors.put("white", new ResourceLocation("minidot", "body/batterfly_wings_white.png"));
        colors.put("green", new ResourceLocation("minidot", "body/batterfly_wings_green.png"));
        colors.put("orange", new ResourceLocation("minidot", "body/batterfly_wings_orange.png"));
    }
}
