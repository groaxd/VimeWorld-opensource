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

public class ExoWings extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer wing = null;
    private String color;

    public ExoWings(String color)
    {
        super(ItemType.BODY);
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.color = color;

        if (wing == null)
        {
            this.setTextureOffset("Right.Right0", 0, 12);
            this.setTextureOffset("Right.Right1", 116, 8);
            this.setTextureOffset("Right.Right2", 110, 35);
            this.setTextureOffset("Right.Right3", 100, 28);
            this.setTextureOffset("Right.Right4", 112, 28);
            this.setTextureOffset("Right.Right5", 124, 0);
            this.setTextureOffset("Right.Right6", 124, 0);
            this.setTextureOffset("Right.Right7", 108, 28);
            this.setTextureOffset("Right.Right8", 104, 28);
            this.setTextureOffset("Right.Right9", 116, 35);
            this.setTextureOffset("Right.Right10", 120, 28);
            this.setTextureOffset("Right.Right11", 122, 35);
            this.setTextureOffset("Right.Right12", 124, 28);
            this.setTextureOffset("Right.Right13", 122, 35);
            this.setTextureOffset("Right.Right14", 116, 28);
            this.setTextureOffset("Right.Right15", 124, 0);
            this.setTextureOffset("Right.Right16", 124, 0);
            this.setTextureOffset("Right.Right17", 120, 8);
            this.setTextureOffset("Right.Right18", 110, 0);
            this.setTextureOffset("Right.Right19", 124, 0);
            this.setTextureOffset("Right.Right20", 124, 0);
            this.setTextureOffset("Right.Right21", 118, 0);
            this.setTextureOffset("Right.Right22", 98, 0);
            this.setTextureOffset("Right.Right23", 124, 0);
            this.setTextureOffset("Right.Right24", 124, 0);
            this.setTextureOffset("Right.Right25", 124, 8);
            this.setTextureOffset("Right.Right26", 124, 0);
            this.setTextureOffset("Right.Right27", 124, 0);
            this.setTextureOffset("Right.Right28", 124, 0);
            this.setTextureOffset("Right.Right29", 124, 0);
            this.setTextureOffset("Right.Right30", 124, 0);
            this.setTextureOffset("Right.Right31", 124, 0);
            this.setTextureOffset("Right.Right32", 124, 0);
            this.setTextureOffset("Right.Right33", 124, 0);
            this.setTextureOffset("Right.Right34", 124, 0);
            this.setTextureOffset("Right.Right35", 124, 0);
            this.setTextureOffset("Right.Right36", 124, 0);
            this.setTextureOffset("Right.Right37", 118, 0);
            this.setTextureOffset("Right.Right38", 110, 0);
            this.setTextureOffset("Right.Right39", 124, 21);
            this.setTextureOffset("Right.Right40", 108, 8);
            this.setTextureOffset("Right.Right41", 120, 21);
            this.setTextureOffset("Right.Right42", 124, 8);
            this.setTextureOffset("Right.Right43", 112, 8);
            this.setTextureOffset("Right.Right44", 82, 0);
            this.setTextureOffset("Right.Right45", 110, 0);
            this.setTextureOffset("Right.Right46", 124, 0);
            this.setTextureOffset("Right.Right47", 124, 0);
            this.setTextureOffset("Right.Right48", 124, 0);
            this.setTextureOffset("Right.Right49", 110, 0);
            this.setTextureOffset("Right.Right50", 118, 0);
            this.setTextureOffset("Right.Right51", 124, 0);
            this.setTextureOffset("Right.Right52", 124, 0);
            this.setTextureOffset("Right.Right53", 124, 0);
            this.setTextureOffset("Right.Right54", 124, 0);
            this.setTextureOffset("Right.Right55", 124, 0);
            this.setTextureOffset("Right.Right56", 118, 0);
            this.setTextureOffset("Right.Right57", 118, 0);
            this.setTextureOffset("Right.Right58", 118, 0);
            wing = new MModelRenderer(this, "Right");
            wing.setRotationPoint(-2.5F, 0.0F, 0.0F);
            wing.mirror = true;
            wing.addBox("Right0", 0.0F, -11.0F, 0.0F, 0, 27, 25);
            wing.addBox("Right1", -0.5F, 0.0F, 0.0F, 1, 5, 1);
            wing.addBox("Right2", -0.5F, -1.0F, 1.0F, 1, 5, 2);
            wing.addBox("Right3", -0.5F, 0.0F, 3.0F, 1, 6, 1);
            wing.addBox("Right4", -0.5F, 4.0F, 2.0F, 1, 3, 1);
            wing.addBox("Right5", -0.5F, 7.0F, 1.0F, 1, 1, 1);
            wing.addBox("Right6", -0.5F, 6.0F, 0.0F, 1, 1, 1);
            wing.addBox("Right7", -0.5F, -1.0F, 4.0F, 1, 4, 1);
            wing.addBox("Right8", -0.5F, -2.0F, 5.0F, 1, 4, 1);
            wing.addBox("Right9", -0.5F, -3.0F, 6.0F, 1, 3, 2);
            wing.addBox("Right10", -0.5F, 0.0F, 6.0F, 1, 1, 1);
            wing.addBox("Right11", -0.5F, -4.0F, 8.0F, 1, 2, 2);
            wing.addBox("Right12", -0.5F, -2.0F, 8.0F, 1, 1, 1);
            wing.addBox("Right13", -0.5F, -5.0F, 10.0F, 1, 2, 2);
            wing.addBox("Right14", -0.5F, -6.0F, 12.0F, 1, 2, 1);
            wing.addBox("Right15", -0.5F, -6.0F, 13.0F, 1, 1, 1);
            wing.addBox("Right16", -0.5F, 2.0F, 6.0F, 1, 1, 1);
            wing.addBox("Right17", -0.5F, 1.0F, 7.0F, 1, 3, 1);
            wing.addBox("Right18", -0.5F, 0.0F, 8.0F, 1, 1, 3);
            wing.addBox("Right19", -0.5F, -1.0F, 10.0F, 1, 1, 1);
            wing.addBox("Right20", -0.5F, -2.0F, 11.0F, 1, 1, 1);
            wing.addBox("Right21", -0.5F, -3.0F, 12.0F, 1, 1, 2);
            wing.addBox("Right22", -0.5F, -4.0F, 14.0F, 1, 1, 5);
            wing.addBox("Right23", -0.5F, -5.0F, 16.0F, 1, 1, 1);
            wing.addBox("Right24", -0.5F, -6.0F, 17.0F, 1, 1, 1);
            wing.addBox("Right25", -0.5F, -8.0F, 18.0F, 1, 2, 1);
            wing.addBox("Right26", -0.5F, -9.0F, 20.0F, 1, 1, 1);
            wing.addBox("Right27", -0.5F, -10.0F, 24.0F, 1, 1, 1);
            wing.addBox("Right28", -0.5F, -9.0F, 23.0F, 1, 1, 1);
            wing.addBox("Right29", -0.5F, -8.0F, 22.0F, 1, 1, 1);
            wing.addBox("Right30", -0.5F, -7.0F, 21.0F, 1, 1, 1);
            wing.addBox("Right31", -0.5F, -6.0F, 20.0F, 1, 1, 1);
            wing.addBox("Right32", -0.5F, -5.0F, 19.0F, 1, 1, 1);
            wing.addBox("Right33", -0.5F, -3.0F, 17.0F, 1, 1, 1);
            wing.addBox("Right34", -0.5F, -2.0F, 16.0F, 1, 1, 1);
            wing.addBox("Right35", -0.5F, -1.0F, 15.0F, 1, 1, 1);
            wing.addBox("Right36", -0.5F, 0.0F, 14.0F, 1, 1, 1);
            wing.addBox("Right37", -0.5F, 1.0F, 15.0F, 1, 1, 2);
            wing.addBox("Right38", -0.5F, 1.0F, 11.0F, 1, 1, 3);
            wing.addBox("Right39", -0.5F, 2.0F, 9.0F, 1, 1, 1);
            wing.addBox("Right40", -0.5F, 3.0F, 5.0F, 1, 12, 1);
            wing.addBox("Right41", -0.5F, 5.0F, 6.0F, 1, 6, 1);
            wing.addBox("Right42", -0.5F, 10.0F, 7.0F, 1, 2, 1);
            wing.addBox("Right43", -0.5F, 4.0F, 8.0F, 1, 6, 1);
            wing.addBox("Right44", -0.5F, 4.0F, 9.0F, 1, 1, 7);
            wing.addBox("Right45", -0.5F, 3.0F, 11.0F, 1, 1, 3);
            wing.addBox("Right46", -0.5F, 2.0F, 11.0F, 1, 1, 1);
            wing.addBox("Right47", -0.5F, 5.0F, 12.0F, 1, 1, 1);
            wing.addBox("Right48", -0.5F, 6.0F, 13.0F, 1, 1, 1);
            wing.addBox("Right49", -0.5F, 5.0F, 16.0F, 1, 1, 3);
            wing.addBox("Right50", -0.5F, 4.0F, 19.0F, 1, 1, 2);
            wing.addBox("Right51", -0.5F, 3.0F, 21.0F, 1, 1, 1);
            wing.addBox("Right52", -0.5F, 2.0F, 22.0F, 1, 1, 1);
            wing.addBox("Right53", -0.5F, 1.0F, 23.0F, 1, 1, 1);
            wing.addBox("Right54", -0.5F, 6.0F, 9.0F, 1, 1, 1);
            wing.addBox("Right55", -0.5F, 7.0F, 10.0F, 1, 1, 1);
            wing.addBox("Right56", -0.5F, 8.0F, 11.0F, 1, 1, 2);
            wing.addBox("Right57", -0.5F, 9.0F, 13.0F, 1, 1, 2);
            wing.addBox("Right58", -0.5F, 10.0F, 15.0F, 1, 1, 2);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.cos(time * 0.15F) * 6.0F;
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.pushMatrix();
        GlStateManager.enableCull();
        this.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.1F, 0.11F);
        GlStateManager.cullFace(1028);
        GlStateManager.pushMatrix();
        GlStateManager.scale(-1.0F, 1.0F, 0.7F);
        GlStateManager.translate(-0.15F, 0.0F, 0.0F);
        GlStateManager.rotate(10.0F + f, 0.0F, -0.2F, 0.0F);
        GlStateManager.translate(0.15F, 0.0F, 0.0F);
        wing.render(0.052500002F);
        GlStateManager.popMatrix();
        GlStateManager.cullFace(1029);
        GlStateManager.pushMatrix();
        GlStateManager.scale(1.0F, 1.0F, 0.7F);
        GlStateManager.translate(-0.15F, 0.0F, 0.0F);
        GlStateManager.rotate(10.0F + f, 0.0F, -0.2F, 0.0F);
        GlStateManager.translate(0.15F, 0.0F, 0.0F);
        wing.render(0.052500002F);
        GlStateManager.popMatrix();
        GlStateManager.disableCull();
        GlStateManager.popMatrix();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.0F, -0.3F);
        GlStateManager.scale(0.7F, 0.6F, 0.45F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.tex);
        GlStateManager.pushMatrix();
        GlStateManager.scale(-1.0F, 1.0F, 1.0F);
        GlStateManager.rotate(-10.0F, -1.0F, 2.0F, 0.0F);
        GlStateManager.translate(0.0F, 0.0F, 0.2F);
        wing.render(0.052500002F);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.rotate(-10.0F, -1.0F, 2.0F, 0.0F);
        GlStateManager.translate(0.0F, 0.0F, 0.2F);
        wing.render(0.052500002F);
        GlStateManager.popMatrix();
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
                return "\u0421\u0438\u043d\u0438\u0435 \u044d\u043a\u0437\u043e\u043a\u0440\u044b\u043b\u044c\u044f";

            case 1:
                return "\u0411\u0435\u043b\u044b\u0435 \u044d\u043a\u0437\u043e\u043a\u0440\u044b\u043b\u044c\u044f";

            case 2:
                return "\u0417\u0435\u043b\u0435\u043d\u044b\u0435 \u044d\u043a\u0437\u043e\u043a\u0440\u044b\u043b\u044c\u044f";

            case 3:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0435 \u044d\u043a\u0437\u043e\u043a\u0440\u044b\u043b\u044c\u044f";

            case 4:
                return "\u0416\u0435\u043b\u0442\u044b\u0435 \u044d\u043a\u0437\u043e\u043a\u0440\u044b\u043b\u044c\u044f";

            default:
                return "\u0419\u0443\u0445";
        }
    }

    static
    {
        colors.put("blue", new ResourceLocation("minidot", "body/exowings_blue.png"));
        colors.put("white", new ResourceLocation("minidot", "body/exowings_white.png"));
        colors.put("red", new ResourceLocation("minidot", "body/exowings_red.png"));
        colors.put("yellow", new ResourceLocation("minidot", "body/exowings_yellow.png"));
        colors.put("green", new ResourceLocation("minidot", "body/exowings_green.png"));
    }
}
