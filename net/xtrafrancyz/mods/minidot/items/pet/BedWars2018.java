package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BedWars2018 extends BasePet
{
    private final String type;
    private static MModelRenderer Shape1;
    private static MModelRenderer Shape2;
    private static MModelRenderer Shape3;
    private static MModelRenderer Shape4;
    private static MModelRenderer Shape5;
    private static MModelRenderer Shape6;
    private static MModelRenderer Shape7;
    private static MModelRenderer Shape8;
    private static MModelRenderer Shape9;
    private static MModelRenderer Shape10;
    private static MModelRenderer Shape11;
    private static MModelRenderer Shape12;
    private static MModelRenderer Shape13;
    private static MModelRenderer Shape14;
    private static MModelRenderer Shape15;
    private static MModelRenderer Shape16;
    private static MModelRenderer Shape17;
    private static MModelRenderer Shape18;
    private static MModelRenderer Shape19;
    private static MModelRenderer Shape20;
    private static MModelRenderer Shape21;
    private static MModelRenderer Shape22;
    private static MModelRenderer Shape23;
    private static MModelRenderer Shape24;
    private static MModelRenderer Shape25;
    private static MModelRenderer Shape26;
    private static MModelRenderer Shape27;
    private static MModelRenderer Shape28;
    private static MModelRenderer Shape29;
    private static MModelRenderer Shape30;
    private static MModelRenderer Shape31;
    private static MModelRenderer Shape32;
    private static MModelRenderer Shape33;
    private static MModelRenderer Shape34;
    private static MModelRenderer Shape35;
    private static MModelRenderer Shape36;
    private static MModelRenderer Shape37;
    private static MModelRenderer Shape38;
    private static MModelRenderer Shape39;
    private static MModelRenderer Shape40;
    private static MModelRenderer Shape41;
    private static MModelRenderer Shape42;
    private static MModelRenderer Shape43;
    private static MModelRenderer Shape44;
    private static MModelRenderer Shape45;
    private static MModelRenderer Shape46;
    private static MModelRenderer Shape47;
    private static MModelRenderer Shape48;
    private static MModelRenderer Shape49;
    private static MModelRenderer Shape50;
    private static MModelRenderer Shape51;
    private static MModelRenderer Shape52;
    private static MModelRenderer Shape53;
    private static MModelRenderer Shape54;
    private static MModelRenderer Shape55;
    private static MModelRenderer Shape56;
    private static MModelRenderer Shape57;
    private static MModelRenderer Shape58;
    private static MModelRenderer Shape59;
    private static MModelRenderer Shape60;
    private static MModelRenderer Shape61;
    private static MModelRenderer Shape62;
    private static MModelRenderer Shape63;
    private static MModelRenderer Shape64;
    private static MModelRenderer Shape65;
    private static MModelRenderer Shape66;
    private static MModelRenderer Shape67;

    public BedWars2018(String type)
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.type = type;
        this.useDisplayLists = true;

        if (Shape1 == null)
        {
            Shape1 = new MModelRenderer(this, 0, 24);
            Shape1.addBox(-4.0F, -2.0F, -7.0F, 8, 3, 5);
            this.setRotation(Shape1, -0.2792527F, 0.0F, 0.0F);
            Shape2 = new MModelRenderer(this, 1, 25);
            Shape2.addBox(-4.0F, -2.0F, 2.0F, 8, 3, 4);
            this.setRotation(Shape2, 0.2792527F, 0.0F, 0.0F);
            Shape3 = new MModelRenderer(this, 5, 28);
            Shape3.addBox(-4.0F, -1.0F, 0.5F, 3, 2, 2);
            this.setRotation(Shape3, 0.2792527F, 0.0F, 0.0F);
            Shape4 = new MModelRenderer(this, 5, 28);
            Shape4.addBox(0.3333333F, -2.0F, 1.0F, 1, 2, 1);
            this.setRotation(Shape4, 0.2792527F, 0.0F, 0.0F);
            Shape5 = new MModelRenderer(this, 5, 28);
            Shape5.addBox(2.0F, -1.0F, 0.5F, 2, 2, 2);
            this.setRotation(Shape5, 0.2792527F, 0.0F, 0.0F);
            Shape6 = new MModelRenderer(this, 5, 28);
            Shape6.addBox(-4.0F, -2.0F, -2.0F, 2, 1, 1);
            this.setRotation(Shape6, -0.2792527F, 0.0F, 0.0F);
            Shape7 = new MModelRenderer(this, 5, 28);
            Shape7.addBox(-1.0F, 0.0F, -2.0F, 3, 1, 1);
            this.setRotation(Shape7, -0.2792527F, 0.0F, 0.0F);
            Shape8 = new MModelRenderer(this, 5, 28);
            Shape8.addBox(1.666667F, -2.0F, -2.0F, 2, 1, 2);
            this.setRotation(Shape8, -0.2792527F, 0.0F, 0.0F);
            Shape9 = new MModelRenderer(this, 5, 28);
            Shape9.addBox(-0.6666667F, -2.0F, 1.0F, 1, 1, 1);
            this.setRotation(Shape9, 0.2792527F, 0.0F, 0.0F);
            Shape10 = new MModelRenderer(this, 5, 28);
            Shape10.addBox(-1.0F, -1.0F, -2.0F, 2, 1, 1);
            this.setRotation(Shape10, -0.2792527F, 0.0F, 0.0F);
            Shape11 = new MModelRenderer(this, 44, 24);
            Shape11.addBox(-4.5F, -5.0F, 6.45F, 9, 7, 1);
            this.setRotation(Shape11, 0.2792527F, 0.0F, 0.0F);
            Shape12 = new MModelRenderer(this, 26, 26);
            Shape12.addBox(-4.5F, -3.0F, -7.25F, 9, 5, 1);
            this.setRotation(Shape12, -0.2792527F, 0.0F, 0.0F);
            Shape13 = new MModelRenderer(this, 0, 16);
            Shape13.addBox(-5.1F, -3.3F, -7.75F, 2, 6, 2);
            this.setRotation(Shape13, -0.2792527F, 0.0F, 0.0F);
            Shape14 = new MModelRenderer(this, 0, 16);
            Shape14.addBox(3.1F, -3.3F, -7.75F, 2, 6, 2);
            this.setRotation(Shape14, -0.2792527F, 0.0F, 0.0F);
            Shape15 = new MModelRenderer(this, 8, 13);
            Shape15.addBox(-5.1F, -6.3F, 5.5F, 2, 9, 2);
            this.setRotation(Shape15, 0.2792527F, 0.0F, 0.0F);
            Shape16 = new MModelRenderer(this, 8, 13);
            Shape16.addBox(3.1F, -6.3F, 5.5F, 2, 9, 2);
            this.setRotation(Shape16, 0.2792527F, 0.0F, 0.0F);
            Shape17 = new MModelRenderer(this, 16, 19);
            Shape17.addBox(-3.5F, -1.866667F, 3.5F, 7, 2, 3);
            this.setRotation(Shape17, 0.5766816F, 0.0F, 0.0F);
            Shape18 = new MModelRenderer(this, 31, 0);
            Shape18.addBox(-1.0F, -4.0F, -3.5F, 2, 3, 1);
            this.setRotation(Shape18, -0.4089647F, 0.0F, 0.0F);
            Shape19 = new MModelRenderer(this, 31, 0);
            Shape19.addBox(-1.0F, -4.0F, -3.5F, 2, 2, 1);
            this.setRotation(Shape19, -0.1858931F, 0.0F, 0.0F);
            Shape20 = new MModelRenderer(this, 31, 0);
            Shape20.addBox(-1.0F, -3.733333F, 2.033333F, 2, 2, 1);
            this.setRotation(Shape20, 0.3717861F, 0.0F, 0.0F);
            Shape21 = new MModelRenderer(this, 31, 0);
            Shape21.addBox(-1.0F, -4.133333F, 1.3F, 2, 2, 1);
            Shape22 = new MModelRenderer(this, 35, 0);
            Shape22.addBox(-0.5F, -5.666667F, 5.166667F, 1, 3, 1);
            this.setRotation(Shape22, 0.5576792F, 0.0F, 0.0F);
            Shape23 = new MModelRenderer(this, 34, 0);
            Shape23.addBox(-0.5F, -10.0F, 3.3F, 1, 3, 1);
            this.setRotation(Shape23, 0.8922867F, -0.0174533F, 0.0F);
            Shape24 = new MModelRenderer(this, 33, 0);
            Shape24.addBox(-0.5F, -9.4F, -0.03333334F, 1, 3, 1);
            this.setRotation(Shape24, 0.5227726F, -0.0174533F, 0.0F);
            Shape25 = new MModelRenderer(this, 46, 17);
            Shape25.addBox(-0.5F, -7.866667F, -8.0F, 1, 2, 1);
            this.setRotation(Shape25, -0.3019729F, 0.0F, 0.0F);
            Shape26 = new MModelRenderer(this, 31, 0);
            Shape26.addBox(-1.0F, -12.1F, -2.833333F, 2, 3, 1);
            this.setRotation(Shape26, -0.3566048F, 0.0F, 0.0F);
            Shape27 = new MModelRenderer(this, 31, 0);
            Shape27.addBox(-1.0F, -12.3F, 0.8333333F, 2, 3, 1);
            this.setRotation(Shape27, 0.0244346F, 0.0F, 0.0F);
            Shape28 = new MModelRenderer(this, 50, 17);
            Shape28.addBox(-0.75F, -8.7F, -8.633333F, 1, 1, 2);
            this.setRotation(Shape28, -0.3194262F, 0.0F, 0.0F);
            Shape29 = new MModelRenderer(this, 31, 0);
            Shape29.addBox(-1.0F, -12.05F, -3.7F, 2, 3, 1);
            this.setRotation(Shape29, -0.122173F, 0.0F, 0.0F);
            Shape30 = new MModelRenderer(this, 31, 0);
            Shape30.addBox(-1.0F, -12.55F, -0.03333334F, 2, 3, 1);
            this.setRotation(Shape30, 0.2505012F, 0.0F, 0.0F);
            Shape31 = new MModelRenderer(this, 56, 17);
            Shape31.addBox(-0.5F, -14.33333F, -6.8F, 1, 5, 1);
            this.setRotation(Shape31, -0.1763092F, 0.0F, 0.0F);
            Shape32 = new MModelRenderer(this, 56, 17);
            Shape32.addBox(-0.5F, -13.13333F, -8.4F, 1, 5, 1);
            this.setRotation(Shape32, -0.3508422F, 0.0F, 0.0F);
            Shape33 = new MModelRenderer(this, 56, 17);
            Shape33.addBox(-0.5F, -14.86667F, 5.666667F, 1, 1, 1);
            this.setRotation(Shape33, 0.6348041F, 0.0F, 0.0F);
            Shape34 = new MModelRenderer(this, 56, 17);
            Shape34.addBox(-0.5F, -14.45F, 5.8F, 1, 1, 1);
            this.setRotation(Shape34, 0.6348041F, 0.0F, 0.0F);
            Shape35 = new MModelRenderer(this, 56, 17);
            Shape35.addBox(-0.5F, -14.86667F, 5.8F, 1, 1, 1);
            this.setRotation(Shape35, 0.6348041F, 0.0F, 0.0F);
            Shape36 = new MModelRenderer(this, 40, 12);
            Shape36.addBox(-4.0F, -2.2F, -6.3F, 8, 1, 4);
            this.setRotation(Shape36, -0.2792527F, 0.0F, 0.0F);
            Shape37 = new MModelRenderer(this, 40, 12);
            Shape37.addBox(-4.0F, -2.266667F, 2.2F, 8, 1, 4);
            this.setRotation(Shape37, 0.2792527F, 0.0F, 0.0F);
            Shape38 = new MModelRenderer(this, 36, 6);
            Shape38.addBox(-4.3F, -2.05F, -6.3F, 1, 2, 4);
            this.setRotation(Shape38, -0.2792527F, 0.0F, 0.0F);
            Shape39 = new MModelRenderer(this, 36, 6);
            Shape39.addBox(3.3F, -2.05F, -6.3F, 1, 2, 4);
            this.setRotation(Shape39, -0.2792527F, 0.0F, 0.0F);
            Shape40 = new MModelRenderer(this, 36, 6);
            Shape40.addBox(-4.3F, -2.05F, 2.2F, 1, 2, 4);
            this.setRotation(Shape40, 0.2792527F, 0.0F, 0.0F);
            Shape41 = new MModelRenderer(this, 36, 6);
            Shape41.addBox(3.3F, -2.05F, 2.2F, 1, 2, 4);
            this.setRotation(Shape41, 0.2792527F, 0.0F, 0.0F);
            Shape42 = new MModelRenderer(this, 44, 24);
            Shape42.addBox(-4.5F, -5.0F, 5.8F, 9, 7, 1);
            this.setRotation(Shape42, 0.2792527F, 0.0F, 0.0F);
            Shape43 = new MModelRenderer(this, 18, 0);
            Shape43.addBox(-2.0F, 3.0F, -2.0F, 4, 3, 4);
            this.setRotation(Shape43, 0.0F, ((float)Math.PI / 4F), 0.0F);
            Shape44 = new MModelRenderer(this, 0, 5);
            Shape44.addBox(-3.0F, 5.5F, -3.0F, 6, 2, 6);
            this.setRotation(Shape44, 0.0F, ((float)Math.PI / 4F), 0.0F);
            Shape45 = new MModelRenderer(this, 50, 17);
            Shape45.addBox(-0.25F, -8.7F, -8.633333F, 1, 1, 2);
            this.setRotation(Shape45, -0.3194262F, 0.0F, 0.0F);
            Shape46 = new MModelRenderer(this, 0, 0);
            Shape46.addBox(3.0F, -4.3F, 7.0F, 1, 3, 1);
            this.setRotation(Shape46, 0.2792527F, 0.0F, 0.0F);
            Shape47 = new MModelRenderer(this, 0, 0);
            Shape47.addBox(1.5F, -4.3F, 7.0F, 1, 5, 1);
            this.setRotation(Shape47, 0.2792527F, 0.0F, 0.0F);
            Shape48 = new MModelRenderer(this, 0, 0);
            Shape48.addBox(-0.25F, -4.3F, 7.0F, 1, 5, 1);
            this.setRotation(Shape48, 0.2792527F, 0.0F, 0.0F);
            Shape49 = new MModelRenderer(this, 0, 0);
            Shape49.addBox(4.0F, -2.3F, 7.0F, 1, 3, 1);
            this.setRotation(Shape49, 0.2792527F, 0.0F, 0.0F);
            Shape50 = new MModelRenderer(this, 0, 0);
            Shape50.addBox(-1.75F, -4.3F, 7.0F, 1, 5, 1);
            this.setRotation(Shape50, 0.2792527F, 0.0F, 0.0F);
            Shape51 = new MModelRenderer(this, 0, 0);
            Shape51.addBox(-3.25F, -4.3F, 7.0F, 1, 5, 1);
            this.setRotation(Shape51, 0.2792527F, 0.0F, 0.0F);
            Shape52 = new MModelRenderer(this, 0, 0);
            Shape52.addBox(-5.0F, -4.3F, 7.0F, 1, 5, 1);
            this.setRotation(Shape52, 0.2792527F, 0.0F, 0.0F);
            Shape53 = new MModelRenderer(this, 0, 0);
            Shape53.addBox(4.0F, -4.3F, 7.0F, 1, 1, 1);
            this.setRotation(Shape53, 0.2792527F, 0.0F, 0.0F);
            Shape54 = new MModelRenderer(this, 0, 0);
            Shape54.addBox(3.0F, -0.3F, 7.0F, 1, 1, 1);
            this.setRotation(Shape54, 0.2792527F, 0.0F, 0.0F);
            Shape55 = new MModelRenderer(this, 0, 0);
            Shape55.addBox(-4.25F, -4.3F, 7.0F, 1, 1, 1);
            this.setRotation(Shape55, 0.2792527F, 0.0F, 0.0F);
            Shape56 = new MModelRenderer(this, 0, 0);
            Shape56.addBox(-4.25F, -2.3F, 7.0F, 1, 1, 1);
            this.setRotation(Shape56, 0.2792527F, 0.0F, 0.0F);
            Shape57 = new MModelRenderer(this, 0, 0);
            Shape57.addBox(-4.25F, -0.3F, 7.0F, 1, 1, 1);
            this.setRotation(Shape57, 0.2792527F, 0.0F, 0.0F);
            Shape58 = new MModelRenderer(this, 0, 0);
            Shape58.addBox(0.5F, -4.3F, 7.0F, 1, 1, 1);
            this.setRotation(Shape58, 0.2792527F, 0.0F, 0.0F);
            Shape59 = new MModelRenderer(this, 0, 0);
            Shape59.addBox(0.5F, -0.3F, 7.0F, 1, 1, 1);
            this.setRotation(Shape59, 0.2792527F, 0.0F, 0.0F);
            Shape60 = new MModelRenderer(this, 0, 28);
            Shape60.addBox(-2.0F, 1.0F, -5.0F, 4, 1, 3);
            this.setRotation(Shape60, -0.2792527F, 0.0F, 0.0F);
            Shape61 = new MModelRenderer(this, 0, 28);
            Shape61.addBox(-2.0F, 1.0F, 2.0F, 4, 1, 3);
            this.setRotation(Shape61, 0.2792527F, 0.0F, 0.0F);
            Shape62 = new MModelRenderer(this, 36, 12);
            Shape62.addBox(0.0F, -15.13333F, -11.4F, 0, 7, 5);
            this.setRotation(Shape62, -0.3508422F, 0.0F, 0.0F);
            Shape63 = new MModelRenderer(this, 46, 0);
            Shape63.addBox(-2.0F, -9.5F, -3.0F, 4, 5, 5);
            this.setRotation(Shape63, -0.0371786F, 0.0F, 0.0F);
            Shape64 = new MModelRenderer(this, 18, 7);
            Shape64.addBox(-1.5F, -10.0F, -3.5F, 3, 6, 6);
            this.setRotation(Shape64, -0.0371786F, 0.0F, 0.0F);
            Shape65 = new MModelRenderer(this, 0, 5);
            Shape65.addBox(-3.0F, 5.5001F, -3.0F, 6, 2, 6);
            Shape66 = new MModelRenderer(this, 18, 0);
            Shape66.addBox(-2.0F, 3.0F, -2.0F, 4, 3, 4);
            Shape67 = new MModelRenderer(this, 0, 4);
            Shape67.addBox(-3.0F, 0.0F, -3.0F, 6, 3, 6);
            this.setRotation(Shape67, -0.0371786F, 0.0F, 0.0F);
        }

        this.setTexture(new ResourceLocation("minidot:pets/bedwars_2018_" + type + ".png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        float f1 = time * 1.5F;
        GlStateManager.translate(0.8F, -0.3F + f, 0.5F);
        GlStateManager.rotate(90.0F + f1, 0.0F, 1.0F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.15F, 0.0F);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.type;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -1380612710:
                if (s.equals("bronze"))
                {
                    b0 = 2;
                }

                break;

            case -1077769574:
                if (s.equals("member"))
                {
                    b0 = 0;
                }

                break;

            case -902311155:
                if (s.equals("silver"))
                {
                    b0 = 3;
                }

                break;

            case 3178592:
                if (s.equals("gold"))
                {
                    b0 = 4;
                }

                break;

            case 1124565314:
                if (s.equals("warrior"))
                {
                    b0 = 1;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u041a\u0440\u043e\u0432\u0430\u0442\u043a\u0430";

            case 1:
                return "\u041a\u0430\u043c\u0435\u043d\u043d\u0430\u044f \u043a\u0440\u043e\u0432\u0430\u0442\u043a\u0430";

            case 2:
                return "\u0411\u0440\u043e\u043d\u0437\u043e\u0432\u0430\u044f \u043a\u0440\u043e\u0432\u0430\u0442\u043a\u0430";

            case 3:
                return "\u0421\u0435\u0440\u0435\u0431\u0440\u044f\u043d\u0430\u044f \u043a\u0440\u043e\u0432\u0430\u0442\u043a\u0430";

            case 4:
                return "\u0417\u043e\u043b\u043e\u0442\u0430\u044f \u043a\u0440\u043e\u0432\u0430\u0442\u043a\u0430";

            default:
                return "\u0419\u0443\u0445";
        }
    }

    public List<String> getDescription()
    {
        String s = this.type;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -1380612710:
                if (s.equals("bronze"))
                {
                    b0 = 2;
                }

                break;

            case -1077769574:
                if (s.equals("member"))
                {
                    b0 = 0;
                }

                break;

            case -902311155:
                if (s.equals("silver"))
                {
                    b0 = 3;
                }

                break;

            case 3178592:
                if (s.equals("gold"))
                {
                    b0 = 4;
                }

                break;

            case 1124565314:
                if (s.equals("warrior"))
                {
                    b0 = 1;
                }
        }

        switch (b0)
        {
            case 0:
                return Collections.<String>singletonList("\u0417\u0430 \u0443\u0447\u0430\u0441\u0442\u0438\u0435 \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars Hard [\u0417\u0438\u043c\u0430 2018]");

            case 1:
                return Collections.<String>singletonList("\u0417\u0430 \u043f\u043e\u043f\u0430\u0434\u0430\u043d\u0438\u0435 \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u043d\u0443\u044e \u0441\u0435\u0442\u043a\u0443 " + EnumChatFormatting.AQUA + "BedWars Hard [\u0417\u0438\u043c\u0430 2018]");

            case 2:
                return Collections.<String>singletonList("\u0417\u0430 \u0442\u0440\u0435\u0442\u044c\u0435 \u043c\u0435\u0441\u0442\u043e \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars Hard [\u0417\u0438\u043c\u0430 2018]");

            case 3:
                return Collections.<String>singletonList("\u0417\u0430 \u0432\u0442\u043e\u0440\u043e\u0435 \u043c\u0435\u0441\u0442\u043e \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars Hard [\u0417\u0438\u043c\u0430 2018]");

            case 4:
                return Collections.<String>singletonList("\u0417\u0430 \u043f\u043e\u0431\u0435\u0434\u0443 \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars Hard [\u0417\u0438\u043c\u0430 2018]");

            default:
                return null;
        }
    }
}
