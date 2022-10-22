package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Spinner extends BasePet
{
    static MModelRenderer[] spinner;
    static MModelRenderer[] base;
    static int displayList;
    static boolean compiled;
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private String color;

    public Spinner(String color)
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.color = color;

        if (spinner == null)
        {
            spinner = new MModelRenderer[69];
            base = new MModelRenderer[2];
            base[1] = new MModelRenderer(this, 18, 0);
            base[1].addBox(-2.5F, -1.5F, -1.0F, 5, 3, 4);
            base[1].setDynamic(true);
            base[0] = new MModelRenderer(this, 18, 0);
            base[0].addBox(-1.5F, -2.5F, -1.0F, 3, 5, 4);
            base[0].setDynamic(true);
            spinner[21] = new MModelRenderer(this, 18, 0);
            spinner[21].addBox(-7.0F, -4.0F, 0.0F, 3, 1, 2);
            this.setRotation(spinner[21], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[40] = new MModelRenderer(this, 0, 0);
            spinner[40].addBox(-2.0F, -8.0F, 0.0F, 1, 5, 2);
            this.setRotation(spinner[40], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[22] = new MModelRenderer(this, 18, 0);
            spinner[22].addBox(-7.0F, -8.0F, 0.0F, 3, 1, 2);
            this.setRotation(spinner[22], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[39] = new MModelRenderer(this, 0, 0);
            spinner[39].addBox(-10.0F, -8.0F, 0.0F, 1, 5, 2);
            this.setRotation(spinner[39], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[23] = new MModelRenderer(this, 18, 0);
            spinner[23].addBox(-8.0F, -7.0F, 0.0F, 1, 3, 2);
            this.setRotation(spinner[23], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[38] = new MModelRenderer(this, 0, 0);
            spinner[38].addBox(-9.0F, -9.0F, 0.0F, 1, 1, 2);
            this.setRotation(spinner[38], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[25] = new MModelRenderer(this, 0, 0);
            spinner[25].addBox(-9.0F, -8.0F, -0.5F, 1, 5, 3);
            this.setRotation(spinner[25], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[37] = new MModelRenderer(this, 0, 0);
            spinner[37].addBox(-3.0F, -9.0F, 0.0F, 1, 1, 2);
            this.setRotation(spinner[37], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[26] = new MModelRenderer(this, 0, 0);
            spinner[26].addBox(-3.0F, -8.0F, -0.5F, 1, 5, 3);
            this.setRotation(spinner[26], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[36] = new MModelRenderer(this, 0, 0);
            spinner[36].addBox(-3.0F, -3.0F, 0.0F, 1, 1, 2);
            this.setRotation(spinner[36], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[27] = new MModelRenderer(this, 0, 0);
            spinner[27].addBox(-4.0F, -9.0F, -0.5F, 1, 2, 3);
            this.setRotation(spinner[27], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[35] = new MModelRenderer(this, 0, 0);
            spinner[35].addBox(-9.0F, -3.0F, 0.0F, 1, 1, 2);
            this.setRotation(spinner[35], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[28] = new MModelRenderer(this, 0, 0);
            spinner[28].addBox(-8.0F, -9.0F, -0.5F, 1, 2, 3);
            this.setRotation(spinner[28], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[34] = new MModelRenderer(this, 0, 0);
            spinner[34].addBox(-8.0F, -10.0F, 0.0F, 5, 1, 2);
            this.setRotation(spinner[34], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[29] = new MModelRenderer(this, 0, 0);
            spinner[29].addBox(-8.0F, -4.0F, -0.5F, 1, 2, 3);
            this.setRotation(spinner[29], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[33] = new MModelRenderer(this, 0, 0);
            spinner[33].addBox(-8.0F, -2.0F, 0.0F, 5, 1, 2);
            this.setRotation(spinner[33], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[30] = new MModelRenderer(this, 0, 0);
            spinner[30].addBox(-4.0F, -4.0F, -0.5F, 1, 2, 3);
            this.setRotation(spinner[30], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[64] = new MModelRenderer(this, 18, 0);
            spinner[64].addBox(-4.0F, -7.0F, 0.0F, 1, 3, 2);
            this.setRotation(spinner[64], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[32] = new MModelRenderer(this, 0, 0);
            spinner[32].addBox(-7.0F, -9.0F, -0.5F, 3, 1, 3);
            this.setRotation(spinner[32], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[31] = new MModelRenderer(this, 0, 0);
            spinner[31].addBox(-7.0F, -3.0F, -0.5F, 3, 1, 3);
            this.setRotation(spinner[31], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[1] = new MModelRenderer(this, 18, 0);
            spinner[1].addBox(4.0F, -4.0F, 0.0F, 3, 1, 2);
            this.setRotation(spinner[1], 0.0F, 0.0F, -2.879793F);
            spinner[2] = new MModelRenderer(this, 18, 0);
            spinner[2].addBox(4.0F, -8.0F, 0.0F, 3, 1, 2);
            this.setRotation(spinner[2], 0.0F, 0.0F, -2.879793F);
            spinner[3] = new MModelRenderer(this, 18, 0);
            spinner[3].addBox(3.0F, -7.0F, 0.0F, 1, 3, 2);
            this.setRotation(spinner[3], 0.0F, 0.0F, -2.879793F);
            spinner[4] = new MModelRenderer(this, 18, 0);
            spinner[4].addBox(7.0F, -7.0F, 0.0F, 1, 3, 2);
            this.setRotation(spinner[4], 0.0F, 0.0F, -2.879793F);
            spinner[5] = new MModelRenderer(this, 0, 0);
            spinner[5].addBox(2.0F, -8.0F, -0.5F, 1, 5, 3);
            this.setRotation(spinner[5], 0.0F, 0.0F, -2.879793F);
            spinner[6] = new MModelRenderer(this, 0, 0);
            spinner[6].addBox(8.0F, -8.0F, -0.5F, 1, 5, 3);
            this.setRotation(spinner[6], 0.0F, 0.0F, -2.879793F);
            spinner[7] = new MModelRenderer(this, 0, 0);
            spinner[7].addBox(7.0F, -9.0F, -0.5F, 1, 2, 3);
            this.setRotation(spinner[7], 0.0F, 0.0F, -2.879793F);
            spinner[8] = new MModelRenderer(this, 0, 0);
            spinner[8].addBox(3.0F, -9.0F, -0.5F, 1, 2, 3);
            this.setRotation(spinner[8], 0.0F, 0.0F, -2.879793F);
            spinner[9] = new MModelRenderer(this, 0, 0);
            spinner[9].addBox(3.0F, -4.0F, -0.5F, 1, 2, 3);
            this.setRotation(spinner[9], 0.0F, 0.0F, -2.879793F);
            spinner[10] = new MModelRenderer(this, 0, 0);
            spinner[10].addBox(7.0F, -4.0F, -0.5F, 1, 2, 3);
            this.setRotation(spinner[10], 0.0F, 0.0F, -2.879793F);
            spinner[11] = new MModelRenderer(this, 0, 0);
            spinner[11].addBox(4.0F, -3.0F, -0.5F, 3, 1, 3);
            this.setRotation(spinner[11], 0.0F, 0.0F, -2.879793F);
            spinner[12] = new MModelRenderer(this, 0, 0);
            spinner[12].addBox(4.0F, -9.0F, -0.5F, 3, 1, 3);
            this.setRotation(spinner[12], 0.0F, 0.0F, -2.879793F);
            spinner[13] = new MModelRenderer(this, 0, 0);
            spinner[13].addBox(3.0F, -2.0F, 0.0F, 5, 1, 2);
            this.setRotation(spinner[13], 0.0F, 0.0F, -2.879793F);
            spinner[14] = new MModelRenderer(this, 0, 0);
            spinner[14].addBox(3.0F, -10.0F, 0.0F, 5, 1, 2);
            this.setRotation(spinner[14], 0.0F, 0.0F, -2.879793F);
            spinner[15] = new MModelRenderer(this, 0, 0);
            spinner[15].addBox(8.0F, -9.0F, 0.0F, 1, 1, 2);
            this.setRotation(spinner[15], 0.0F, 0.0F, -2.879793F);
            spinner[16] = new MModelRenderer(this, 0, 0);
            spinner[16].addBox(8.0F, -3.0F, 0.0F, 1, 1, 2);
            this.setRotation(spinner[16], 0.0F, 0.0F, -2.879793F);
            spinner[17] = new MModelRenderer(this, 0, 0);
            spinner[17].addBox(2.0F, -3.0F, 0.0F, 1, 1, 2);
            this.setRotation(spinner[17], 0.0F, 0.0F, -2.879793F);
            spinner[18] = new MModelRenderer(this, 0, 0);
            spinner[18].addBox(2.0F, -9.0F, 0.0F, 1, 1, 2);
            this.setRotation(spinner[18], 0.0F, 0.0F, -2.879793F);
            spinner[19] = new MModelRenderer(this, 0, 0);
            spinner[19].addBox(1.0F, -8.0F, 0.0F, 1, 5, 2);
            this.setRotation(spinner[19], 0.0F, 0.0F, -2.879793F);
            spinner[20] = new MModelRenderer(this, 0, 0);
            spinner[20].addBox(9.0F, -8.0F, 0.0F, 1, 5, 2);
            this.setRotation(spinner[20], 0.0F, 0.0F, -2.879793F);
            spinner[41] = new MModelRenderer(this, 18, 0);
            spinner[41].addBox(-8.0F, -7.0F, 0.0F, 1, 3, 2);
            this.setRotation(spinner[41], 0.0F, 0.0F, 2.879793F);
            spinner[61] = new MModelRenderer(this, 0, 0);
            spinner[61].addBox(-8.0F, -10.0F, 0.0F, 5, 1, 2);
            this.setRotation(spinner[61], 0.0F, 0.0F, 2.879793F);
            spinner[42] = new MModelRenderer(this, 18, 0);
            spinner[42].addBox(-7.0F, -8.0F, 0.0F, 3, 1, 2);
            this.setRotation(spinner[42], 0.0F, 0.0F, 2.879793F);
            spinner[60] = new MModelRenderer(this, 0, 0);
            spinner[60].addBox(-4.0F, -9.0F, -0.5F, 1, 2, 3);
            this.setRotation(spinner[60], 0.0F, 0.0F, 2.879793F);
            spinner[43] = new MModelRenderer(this, 0, 0);
            spinner[43].addBox(-7.0F, -9.0F, -0.5F, 3, 1, 3);
            this.setRotation(spinner[43], 0.0F, 0.0F, 2.879793F);
            spinner[59] = new MModelRenderer(this, 0, 0);
            spinner[59].addBox(-3.0F, -9.0F, 0.0F, 1, 1, 2);
            this.setRotation(spinner[59], 0.0F, 0.0F, 2.879793F);
            spinner[44] = new MModelRenderer(this, 0, 0);
            spinner[44].addBox(-8.0F, -9.0F, -0.5F, 1, 2, 3);
            this.setRotation(spinner[44], 0.0F, 0.0F, 2.879793F);
            spinner[58] = new MModelRenderer(this, 0, 0);
            spinner[58].addBox(-3.0F, -3.0F, 0.0F, 1, 1, 2);
            this.setRotation(spinner[58], 0.0F, 0.0F, 2.879793F);
            spinner[45] = new MModelRenderer(this, 0, 0);
            spinner[45].addBox(-9.0F, -9.0F, 0.0F, 1, 1, 2);
            this.setRotation(spinner[45], 0.0F, 0.0F, 2.879793F);
            spinner[57] = new MModelRenderer(this, 0, 0);
            spinner[57].addBox(-2.0F, -8.0F, 0.0F, 1, 5, 2);
            this.setRotation(spinner[57], 0.0F, 0.0F, 2.879793F);
            spinner[46] = new MModelRenderer(this, 0, 0);
            spinner[46].addBox(-9.0F, -8.0F, -0.5F, 1, 5, 3);
            this.setRotation(spinner[46], 0.0F, 0.0F, 2.879793F);
            spinner[56] = new MModelRenderer(this, 0, 0);
            spinner[56].addBox(-3.0F, -8.0F, -0.5F, 1, 5, 3);
            this.setRotation(spinner[56], 0.0F, 0.0F, 2.879793F);
            spinner[47] = new MModelRenderer(this, 0, 0);
            spinner[47].addBox(-10.0F, -8.0F, 0.0F, 1, 5, 2);
            this.setRotation(spinner[47], 0.0F, 0.0F, 2.879793F);
            spinner[54] = new MModelRenderer(this, 0, 0);
            spinner[54].addBox(-4.0F, -4.0F, -0.5F, 1, 2, 3);
            this.setRotation(spinner[54], 0.0F, 0.0F, 2.879793F);
            spinner[48] = new MModelRenderer(this, 0, 0);
            spinner[48].addBox(-9.0F, -3.0F, 0.0F, 1, 1, 2);
            this.setRotation(spinner[48], 0.0F, 0.0F, 2.879793F);
            spinner[53] = new MModelRenderer(this, 18, 0);
            spinner[53].addBox(-4.0F, -7.0F, 0.0F, 1, 3, 2);
            this.setRotation(spinner[53], 0.0F, 0.0F, 2.879793F);
            spinner[49] = new MModelRenderer(this, 0, 0);
            spinner[49].addBox(-8.0F, -4.0F, -0.5F, 1, 2, 3);
            this.setRotation(spinner[49], 0.0F, 0.0F, 2.879793F);
            spinner[52] = new MModelRenderer(this, 18, 0);
            spinner[52].addBox(-7.0F, -4.0F, 0.0F, 3, 1, 2);
            this.setRotation(spinner[52], 0.0F, 0.0F, 2.879793F);
            spinner[50] = new MModelRenderer(this, 0, 0);
            spinner[50].addBox(-7.0F, -3.0F, -0.5F, 3, 1, 3);
            this.setRotation(spinner[50], 0.0F, 0.0F, 2.879793F);
            spinner[51] = new MModelRenderer(this, 0, 0);
            spinner[51].addBox(-8.0F, -2.0F, 0.0F, 5, 1, 2);
            this.setRotation(spinner[51], 0.0F, 0.0F, 2.879793F);
            spinner[0] = new MModelRenderer(this, 0, 0);
            spinner[0].addBox(-1.0F, -4.0F, 0.0F, 2, 4, 2);
            spinner[68] = new MModelRenderer(this, 0, 0);
            spinner[68].addBox(0.0F, -1.5F, 0.0F, 4, 3, 2);
            this.setRotation(spinner[68], 0.0F, 0.0F, 2.617994F);
            spinner[67] = new MModelRenderer(this, 0, 0);
            spinner[67].addBox(0.0F, -1.5F, 0.0F, 4, 3, 2);
            this.setRotation(spinner[67], 0.0F, 0.0F, 0.5235988F);
            spinner[24] = new MModelRenderer(this, 0, 0);
            spinner[24].addBox(0.0F, 1.2F, 0.0F, 4, 2, 2);
            this.setRotation(spinner[24], 0.0F, 0.0F, 0.2617994F);
            spinner[66] = new MModelRenderer(this, 0, 0);
            spinner[66].addBox(-3.2F, 0.0F, 0.0F, 2, 4, 2);
            this.setRotation(spinner[66], 0.0F, 0.0F, ((float)Math.PI / 4F));
            spinner[62] = new MModelRenderer(this, 0, 0);
            spinner[62].addBox(-3.2F, 0.0F, 0.0F, 2, 4, 2);
            this.setRotation(spinner[62], 0.0F, 0.0F, 2.879793F);
            spinner[63] = new MModelRenderer(this, 0, 0);
            spinner[63].addBox(1.2F, 0.0F, 0.0F, 2, 4, 2);
            this.setRotation(spinner[63], 0.0F, 0.0F, -((float)Math.PI / 4F));
            spinner[55] = new MModelRenderer(this, 0, 0);
            spinner[55].addBox(-4.0F, 1.2F, 0.0F, 4, 2, 2);
            this.setRotation(spinner[55], 0.0F, 0.0F, -0.2617994F);
            spinner[65] = new MModelRenderer(this, 0, 0);
            spinner[65].addBox(1.2F, 0.0F, 0.0F, 2, 4, 2);
            this.setRotation(spinner[65], 0.0F, 0.0F, -2.879793F);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = time * 0.09F;
        base[0].rotationZ = -f;
        base[1].rotationZ = -f;
        GlStateManager.translate(0.6F, -0.5F, 0.5F);
        GlStateManager.rotate(-time * 1.5F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(time * 5.5F, 0.0F, 0.0F, 1.0F);
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.rotate(time * 5.5F, 0.0F, 0.0F, 1.0F);
        super.renderAsItem(time);
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

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -734239628:
                if (s.equals("yellow"))
                {
                    b0 = 2;
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
                    b0 = 3;
                }

                break;

            case 98619139:
                if (s.equals("green"))
                {
                    b0 = 1;
                }

                break;

            case 113101865:
                if (s.equals("white"))
                {
                    b0 = 4;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0439 \u0441\u043f\u0438\u043d\u043d\u0435\u0440";

            case 1:
                return "\u0417\u0435\u043b\u0435\u043d\u044b\u0439 \u0441\u043f\u0438\u043d\u043d\u0435\u0440";

            case 2:
                return "\u0416\u0435\u043b\u0442\u044b\u0439 \u0441\u043f\u0438\u043d\u043d\u0435\u0440";

            case 3:
                return "\u0421\u0438\u043d\u0438\u0439 \u0441\u043f\u0438\u043d\u043d\u0435\u0440";

            case 4:
                return "\u0411\u0435\u043b\u044b\u0439 \u0441\u043f\u0438\u043d\u043d\u0435\u0440";

            default:
                return "\u041f\u0438\u0437\u0434\u0430";
        }
    }

    static
    {
        colors.put("yellow", new ResourceLocation("minidot", "pets/spinner_yellow.png"));
        colors.put("green", new ResourceLocation("minidot", "pets/spinner_green.png"));
        colors.put("white", new ResourceLocation("minidot", "pets/spinner_white.png"));
        colors.put("blue", new ResourceLocation("minidot", "pets/spinner_blue.png"));
        colors.put("red", new ResourceLocation("minidot", "pets/spinner_red.png"));
    }
}
