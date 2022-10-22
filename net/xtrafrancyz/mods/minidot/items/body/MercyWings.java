package net.xtrafrancyz.mods.minidot.items.body;

import java.util.HashMap;
import java.util.List;
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
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class MercyWings extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer[] wing;
    private static int displayList;
    private static boolean compiled;
    private String color;

    public MercyWings(String color)
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.color = color;

        if (wing == null)
        {
            wing = new MModelRenderer[21];
            wing[0] = new MModelRenderer(this, 31, 4);
            wing[0].addBox(-0.5F, -1.5F, 0.0F, 1, 2, 2);
            wing[0].mirror = true;
            this.setRotation(wing[0], -0.5204921F, -0.7330383F, 0.0F);
            wing[1] = new MModelRenderer(this, 26, 0);
            wing[1].addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1);
            wing[1].mirror = true;
            this.setRotation(wing[1], 0.2602503F, 0.0F, 0.0F);
            wing[2] = new MModelRenderer(this, 33, 9);
            wing[2].addBox(-0.5F, -5.5F, 2.4F, 1, 3, 1);
            wing[2].mirror = true;
            this.setRotation(wing[2], -0.2230717F, -0.7330383F, 0.0F);
            wing[3] = new MModelRenderer(this, 26, 9);
            wing[3].addBox(-0.4666667F, -4.5F, -0.5F, 1, 4, 2);
            wing[3].mirror = true;
            this.setRotation(wing[3], -0.8922867F, -0.7330383F, 0.0F);
            wing[4] = new MModelRenderer(this, 26, 4);
            wing[4].addBox(-0.5F, -1.5F, 0.8F, 1, 3, 1);
            wing[4].mirror = true;
            this.setRotation(wing[4], -1.412787F, -0.7330383F, 0.0F);
            wing[5] = new MModelRenderer(this, 26, 0);
            wing[5].addBox(-1.0F, 0.0F, -0.5F, 2, 2, 1);
            wing[5].mirror = true;
            this.setRotation(wing[5], -0.2443461F, 0.0F, 0.0F);
            wing[6] = new MModelRenderer(this, 14, 0);
            wing[6].addBox(-0.7F, 4.5F, 2.0F, 1, 2, 1);
            wing[6].mirror = true;
            this.setRotation(wing[6], 1.972222F, -0.7330383F, 0.0F);
            wing[7] = new MModelRenderer(this, 14, 0);
            wing[7].addBox(-0.3F, 4.5F, 2.0F, 1, 2, 1);
            wing[7].mirror = true;
            this.setRotation(wing[7], 1.972222F, -0.7330383F, 0.0F);
            wing[8] = new MModelRenderer(this, 19, 4);
            wing[8].addBox(-0.7F, 4.0F, 4.0F, 1, 3, 1);
            wing[8].mirror = true;
            this.setRotation(wing[8], 1.747395F, -0.7330383F, 0.0F);
            wing[9] = new MModelRenderer(this, 19, 4);
            wing[9].addBox(-0.3F, 4.0F, 4.0F, 1, 3, 1);
            wing[9].mirror = true;
            this.setRotation(wing[9], 1.747395F, -0.7330383F, 0.0F);
            wing[10] = new MModelRenderer(this, 19, 0);
            wing[10].addBox(-0.3F, 2.5F, 4.0F, 1, 1, 2);
            wing[10].mirror = true;
            this.setRotation(wing[10], 1.487144F, -0.7330383F, 0.0F);
            wing[11] = new MModelRenderer(this, 19, 0);
            wing[11].addBox(-0.7F, 2.5F, 4.0F, 1, 1, 2);
            wing[11].mirror = true;
            this.setRotation(wing[11], 1.487144F, -0.7330383F, 0.0F);
            wing[12] = new MModelRenderer(this, 12, 4);
            wing[12].addBox(-0.25F, -4.0F, 6.0F, 1, 2, 2);
            wing[12].mirror = true;
            this.setRotation(wing[12], 0.2974289F, -0.7330383F, 0.0F);
            wing[13] = new MModelRenderer(this, 12, 4);
            wing[13].addBox(-0.75F, -4.0F, 6.0F, 1, 2, 2);
            wing[13].mirror = true;
            this.setRotation(wing[13], 0.2974289F, -0.7330383F, 0.0F);
            wing[14] = new MModelRenderer(this, 9, 0);
            wing[14].addBox(-0.5F, -8.0F, 2.0F, 1, 2, 1);
            wing[14].mirror = true;
            this.setRotation(wing[14], -0.2974289F, -0.7330383F, 0.0F);
            wing[15] = new MModelRenderer(this, 0, 8);
            wing[15].addBox(-0.5F, -2.6F, 7.533333F, 1, 1, 5);
            wing[15].mirror = true;
            this.setRotation(wing[15], 0.7063936F, -0.7330383F, 0.0F);
            wing[16] = new MModelRenderer(this, 0, 6);
            wing[16].addBox(0.0F, -8.7F, 7.0F, 0, 2, 11);
            wing[16].mirror = true;
            this.setRotation(wing[16], 0.0523599F, -0.7330383F, 0.0F);
            wing[17] = new MModelRenderer(this, 0, 7);
            wing[17].addBox(0.05F, -8.5F, 4.0F, 0, 2, 13);
            wing[17].mirror = true;
            this.setRotation(wing[17], -0.1487144F, -0.7330383F, 0.0F);
            wing[18] = new MModelRenderer(this, 0, 10);
            wing[18].addBox(0.0F, -8.0F, 2.5F, 0, 2, 13);
            wing[18].mirror = true;
            this.setRotation(wing[18], -0.3717861F, -0.7330383F, 0.0F);
            wing[19] = new MModelRenderer(this, 0, 15);
            wing[19].addBox(0.05F, -7.0F, 1.0F, 0, 2, 11);
            wing[19].mirror = true;
            this.setRotation(wing[19], -0.5948578F, -0.7330383F, 0.0F);
            wing[20] = new MModelRenderer(this, 0, 20);
            wing[20].addBox(0.0F, -6.0F, -0.4666667F, 0, 2, 9);
            wing[20].mirror = true;
            this.setRotation(wing[20], -0.9294653F, -0.7330383F, 0.0F);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.cos(time * 0.15F) * 8.0F;
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.pushMatrix();
        GlStateManager.enableCull();
        this.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.2F, 0.13F);
        GlStateManager.scale(1.0F, 1.2F, 0.9F);
        GlStateManager.cullFace(1028);
        GlStateManager.pushMatrix();
        GlStateManager.scale(-1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-0.12F, 0.0F, 0.03F);
        GlStateManager.rotate(16.0F, -1.0F, 1.0F, 0.0F);
        GlStateManager.rotate(f, 0.0F, -0.2F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.cullFace(1029);
        GlStateManager.pushMatrix();
        GlStateManager.translate(-0.12F, 0.0F, 0.03F);
        GlStateManager.rotate(16.0F, -1.0F, 1.0F, 0.0F);
        GlStateManager.rotate(f, 0.0F, -0.2F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.disableCull();
        GlStateManager.popMatrix();
    }

    public void renderAsItem(float time)
    {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.translate(0.0F, 0.14F, -0.3F);
        GlStateManager.scale(0.5F, 0.67F, 0.67F);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.1F, 0.0F, 0.0F);
        GlStateManager.rotate(-90.0F, 0.0F, -0.2F, 0.0F);
        this.renderModels();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(-0.1F, 0.0F, 0.0F);
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
        return "Ursun";
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

            case -976943172:
                if (s.equals("purple"))
                {
                    b0 = 2;
                }

                break;

            case -734239628:
                if (s.equals("yellow"))
                {
                    b0 = 3;
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
                    b0 = 4;
                }

                break;

            case 3178592:
                if (s.equals("gold"))
                {
                    b0 = 5;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0410\u043d\u0433\u0435\u043b\u0430";

            case 1:
                return "\u041e\u0440\u0430\u043d\u0436\u0435\u0432\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0410\u043d\u0433\u0435\u043b\u0430";

            case 2:
                return "\u0424\u0438\u043e\u043b\u0435\u0442\u043e\u0432\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0410\u043d\u0433\u0435\u043b\u0430";

            case 3:
                return "\u0416\u0435\u043b\u0442\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0410\u043d\u0433\u0435\u043b\u0430";

            case 4:
                return "\u0421\u0438\u043d\u0438\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0410\u043d\u0433\u0435\u043b\u0430";

            case 5:
                return "\u0417\u043e\u043b\u043e\u0442\u044b\u0435 \u043a\u0440\u044b\u043b\u044c\u044f \u0410\u043d\u0433\u0435\u043b\u0430";

            default:
                return "\u041f\u0438\u0437\u0434\u0430";
        }
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Overwatch");
    }

    static
    {
        colors.put("red", new ResourceLocation("minidot:body/mercy_wings_red.png"));
        colors.put("yellow", new ResourceLocation("minidot:body/mercy_wings_yellow.png"));
        colors.put("purple", new ResourceLocation("minidot:body/mercy_wings_purple.png"));
        colors.put("orange", new ResourceLocation("minidot:body/mercy_wings_orange.png"));
        colors.put("blue", new ResourceLocation("minidot:body/mercy_wings_blue.png"));
        colors.put("gold", new ResourceLocation("minidot:body/mercy_wings_gold.png"));
    }
}
