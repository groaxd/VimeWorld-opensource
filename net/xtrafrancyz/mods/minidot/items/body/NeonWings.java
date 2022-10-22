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

public class NeonWings extends BaseItem
{
    private static int displayList;
    private static boolean compiled;
    private static MModelRenderer[] wing;
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private String color;

    public NeonWings(String color)
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.color = color;

        if (wing == null)
        {
            wing = new MModelRenderer[26];
            wing[12] = new MModelRenderer(this, 36, 0);
            wing[12].addBox(-4.0F, 0.0F, 8.0F, 2, 3, 2);
            wing[12].mirror = true;
            this.setRotation(wing[12], 0.0F, 0.0F, 0.0F);
            wing[20] = new MModelRenderer(this, 38, 6);
            wing[20].addBox(-4.0F, 0.0F, 24.0F, 2, 3, 4);
            wing[20].mirror = true;
            this.setRotation(wing[20], 0.0F, 0.0F, 0.0F);
            wing[16] = new MModelRenderer(this, 1, 16);
            wing[16].addBox(-3.5F, 0.5F, 10.0F, 1, 2, 14);
            wing[16].mirror = true;
            this.setRotation(wing[16], 0.0F, 0.0F, 0.0F);
            wing[24] = new MModelRenderer(this, 46, 3);
            wing[24].addBox(-3.5F, 1.0F, 28.0F, 1, 1, 1);
            wing[24].mirror = true;
            this.setRotation(wing[24], 0.0F, 0.0F, 0.0F);
            wing[11] = new MModelRenderer(this, 36, 0);
            wing[11].addBox(-4.0F, -2.4F, 8.0F, 2, 3, 2);
            wing[11].mirror = true;
            this.setRotation(wing[11], 0.0872665F, 0.0F, 0.0F);
            wing[15] = new MModelRenderer(this, 0, 15);
            wing[15].addBox(-3.5F, -1.9F, 10.0F, 1, 2, 15);
            wing[15].mirror = true;
            this.setRotation(wing[15], 0.0872665F, 0.0F, 0.0F);
            wing[19] = new MModelRenderer(this, 50, 5);
            wing[19].addBox(-4.0F, -2.4F, 25.0F, 2, 3, 5);
            wing[19].mirror = true;
            this.setRotation(wing[19], 0.0872665F, 0.0F, 0.0F);
            wing[23] = new MModelRenderer(this, 46, 3);
            wing[23].addBox(-3.5F, -1.5F, 30.0F, 1, 1, 1);
            wing[23].mirror = true;
            this.setRotation(wing[23], 0.0872665F, 0.0F, 0.0F);
            wing[13] = new MModelRenderer(this, 36, 0);
            wing[13].addBox(-4.0F, 1.6F, 8.4F, 2, 3, 2);
            wing[13].mirror = true;
            this.setRotation(wing[13], -0.1745329F, 0.0F, 0.0F);
            wing[17] = new MModelRenderer(this, 4, 19);
            wing[17].addBox(-3.5F, 2.1F, 10.4F, 1, 2, 11);
            wing[17].mirror = true;
            this.setRotation(wing[17], -0.1745329F, 0.0F, 0.0F);
            wing[21] = new MModelRenderer(this, 54, 13);
            wing[21].addBox(-4.0F, 1.6F, 21.4F, 2, 3, 3);
            wing[21].mirror = true;
            this.setRotation(wing[21], -0.1745329F, 0.0F, 0.0F);
            wing[25] = new MModelRenderer(this, 46, 3);
            wing[25].addBox(-3.5F, 2.6F, 24.4F, 1, 1, 1);
            wing[25].mirror = true;
            this.setRotation(wing[25], -0.1745329F, 0.0F, 0.0F);
            wing[14] = new MModelRenderer(this, 36, 0);
            wing[14].addBox(-4.0F, 3.0F, 9.1F, 2, 3, 2);
            wing[14].mirror = true;
            this.setRotation(wing[14], -0.3490659F, 0.0F, 0.0F);
            wing[18] = new MModelRenderer(this, 7, 22);
            wing[18].addBox(-3.5F, 3.5F, 11.1F, 1, 2, 8);
            wing[18].mirror = true;
            this.setRotation(wing[18], -0.3490659F, 0.0F, 0.0F);
            wing[22] = new MModelRenderer(this, 54, 13);
            wing[22].addBox(-4.0F, 3.0F, 19.1F, 2, 3, 3);
            wing[22].mirror = true;
            this.setRotation(wing[22], -0.3490659F, 0.0F, 0.0F);
            wing[0] = new MModelRenderer(this, 46, 3);
            wing[0].addBox(-3.5F, 4.0F, 22.1F, 1, 1, 1);
            wing[0].mirror = true;
            this.setRotation(wing[0], -0.3490659F, 0.0F, 0.0F);
            wing[7] = new MModelRenderer(this, 44, 0);
            wing[7].addBox(-3.5F, -1.5F, 6.0F, 1, 1, 2);
            wing[7].mirror = true;
            this.setRotation(wing[7], 0.0872665F, 0.0F, 0.0F);
            wing[8] = new MModelRenderer(this, 44, 0);
            wing[8].addBox(-3.5F, 1.0F, 6.0F, 1, 1, 2);
            wing[8].mirror = true;
            this.setRotation(wing[8], 0.0F, 0.0F, 0.0F);
            wing[9] = new MModelRenderer(this, 44, 0);
            wing[9].addBox(-3.5F, 2.6F, 6.4F, 1, 1, 2);
            wing[9].mirror = true;
            this.setRotation(wing[9], -0.1745329F, 0.0F, 0.0F);
            wing[10] = new MModelRenderer(this, 44, 0);
            wing[10].addBox(-3.5F, 4.0F, 7.1F, 1, 1, 2);
            wing[10].mirror = true;
            this.setRotation(wing[10], -0.3490659F, 0.0F, 0.0F);
            wing[2] = new MModelRenderer(this, 50, 0);
            wing[2].addBox(-3.5F, -2.5F, 5.0F, 1, 3, 1);
            wing[2].mirror = true;
            this.setRotation(wing[2], 0.0872665F, 0.0F, 0.0F);
            wing[3] = new MModelRenderer(this, 50, 0);
            wing[3].addBox(-3.5F, 0.0F, 5.0F, 1, 3, 1);
            wing[3].mirror = true;
            this.setRotation(wing[3], 0.0F, 0.0F, 0.0F);
            wing[1] = new MModelRenderer(this, 54, 0);
            wing[1].addBox(-3.5F, -2.5F, 1.0F, 1, 1, 4);
            wing[1].mirror = true;
            this.setRotation(wing[1], 0.0872665F, 0.0F, 0.0F);
            wing[4] = new MModelRenderer(this, 50, 0);
            wing[4].addBox(-3.5F, 1.6F, 5.4F, 1, 3, 1);
            wing[4].mirror = true;
            this.setRotation(wing[4], -0.1745329F, 0.0F, 0.0F);
            wing[6] = new MModelRenderer(this, 54, 0);
            wing[6].addBox(-3.5F, 5.0F, 2.1F, 1, 1, 4);
            wing[6].mirror = true;
            this.setRotation(wing[6], -0.3490659F, 0.0F, 0.0F);
            wing[5] = new MModelRenderer(this, 50, 0);
            wing[5].addBox(-3.5F, 3.0F, 6.1F, 1, 3, 1);
            wing[5].mirror = true;
            this.setRotation(wing[5], -0.3490659F, 0.0F, 0.0F);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.cos(time * 0.15F) * 6.0F;
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.pushMatrix();
        this.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.2F, 0.1F);
        GlStateManager.scale(0.85F, 0.75F, 0.7F);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.1F, 0.0F, 0.0F);
        GlStateManager.rotate(10.0F, 1.0F, 0.5F, 0.0F);
        GlStateManager.rotate(f, 0.0F, 0.2F, 0.0F);
        GlStateManager.translate(0.2F, 0.0F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(-0.1F, 0.0F, 0.0F);
        GlStateManager.rotate(-10.0F, -1.0F, 0.5F, 0.0F);
        GlStateManager.rotate(f, 0.0F, -0.2F, 0.0F);
        GlStateManager.translate(0.1F, 0.0F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.popMatrix();
    }

    public void renderAsItem(float time)
    {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.translate(0.05F, -0.05F, -0.3F);
        GlStateManager.scale(0.55F, 0.47F, 0.38F);
        GlStateManager.pushMatrix();
        GlStateManager.rotate(10.0F, 1.0F, 2.0F, 0.0F);
        GlStateManager.translate(0.2F, 0.0F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.rotate(-10.0F, -1.0F, 2.0F, 0.0F);
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
        return "_Mik_";
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
                    b0 = 1;
                }

                break;

            case -734239628:
                if (s.equals("yellow"))
                {
                    b0 = 4;
                }

                break;

            case 112785:
                if (s.equals("red"))
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
        }

        switch (b0)
        {
            case 0:
                return "\u0421\u0438\u043d\u0438\u0435 \u043d\u0435\u043e\u043d\u043e\u0432\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";

            case 1:
                return "\u0424\u0438\u043e\u043b\u0435\u0442\u043e\u0432\u044b\u0435 \u043d\u0435\u043e\u043d\u043e\u0432\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";

            case 2:
                return "\u0417\u0435\u043b\u0435\u043d\u044b\u0435 \u043d\u0435\u043e\u043d\u043e\u0432\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";

            case 3:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0435 \u043d\u0435\u043e\u043d\u043e\u0432\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";

            case 4:
                return "\u0416\u0435\u043b\u0442\u044b\u0435 \u043d\u0435\u043e\u043d\u043e\u0432\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f";

            default:
                return "\u0419\u0443\u0445";
        }
    }

    static
    {
        colors.put("blue", new ResourceLocation("minidot", "body/neonwings_blue.png"));
        colors.put("purple", new ResourceLocation("minidot", "body/neonwings_purple.png"));
        colors.put("red", new ResourceLocation("minidot", "body/neonwings_red.png"));
        colors.put("yellow", new ResourceLocation("minidot", "body/neonwings_yellow.png"));
        colors.put("green", new ResourceLocation("minidot", "body/neonwings_green.png"));
    }
}
