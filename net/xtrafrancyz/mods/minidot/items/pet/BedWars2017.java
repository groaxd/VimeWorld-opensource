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

public class BedWars2017 extends BasePet
{
    private final String type;
    private static MModelRenderer Shape16;
    private static MModelRenderer Shape1;
    private static MModelRenderer Shape2;
    private static MModelRenderer Shape19;
    private static MModelRenderer Shape3;
    private static MModelRenderer Shape4;
    private static MModelRenderer Piece1;
    private static MModelRenderer Piece2;

    public BedWars2017(String type)
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.type = type;

        if (Shape1 == null)
        {
            this.setTextureOffset("Piece1.Shape21", 0, 8);
            this.setTextureOffset("Piece1.Shape22", 0, 8);
            this.setTextureOffset("Piece1.Shape23", 0, 8);
            this.setTextureOffset("Piece1.Shape24", 0, 8);
            this.setTextureOffset("Piece1.Shape25", 0, 8);
            this.setTextureOffset("Piece1.Shape26", 0, 8);
            this.setTextureOffset("Piece1.Shape27", 0, 8);
            this.setTextureOffset("Piece1.Shape28", 0, 8);
            this.setTextureOffset("Piece1.Shape29", 0, 8);
            this.setTextureOffset("Piece1.Shape30", 0, 8);
            this.setTextureOffset("Piece1.Shape31", 0, 8);
            this.setTextureOffset("Piece1.Shape32", 0, 8);
            this.setTextureOffset("Piece1.Shape21", 0, 8);
            this.setTextureOffset("Piece1.Shape21", 0, 8);
            this.setTextureOffset("Piece2.Shape5", 81, 35);
            this.setTextureOffset("Piece2.Shape6", 47, 16);
            this.setTextureOffset("Piece2.Shape7", 50, 32);
            this.setTextureOffset("Piece2.Shape8", 0, 39);
            this.setTextureOffset("Piece2.Shape18", 50, 0);
            this.setTextureOffset("Piece2.Shape9", 37, 48);
            this.setTextureOffset("Piece2.Shape17", 0, 52);
            this.setTextureOffset("Piece2.Shape10", 37, 48);
            this.setTextureOffset("Piece2.Shape15", 3, 31);
            this.setTextureOffset("Piece2.Shape11", 16, 0);
            this.setTextureOffset("Piece2.Shape14", 3, 31);
            this.setTextureOffset("Piece2.Shape12", 37, 48);
            this.setTextureOffset("Piece2.Shape13", 37, 48);
            Shape16 = new MModelRenderer(this, 0, 52);
            Shape16.addBox(-4.5F, 0.0F, -4.5F, 9, 3, 9);
            Shape16.setRotationPoint(0.0F, 0.0F, 0.0F);
            Shape16.setTextureSize(128, 64);
            Shape16.mirror = true;
            this.setRotation(Shape16, 0.0F, ((float)Math.PI / 4F), 0.0F);
            Shape1 = new MModelRenderer(this, 0, 52);
            Shape1.addBox(-4.5F, 0.0F, -4.5F, 9, 3, 9);
            Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
            Shape1.setTextureSize(128, 64);
            Shape1.mirror = true;
            this.setRotation(Shape1, 0.0F, -0.0174533F, 0.0F);
            Shape2 = new MModelRenderer(this, 0, 52);
            Shape2.addBox(-3.0F, -3.0F, -3.0F, 6, 3, 6);
            Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
            Shape2.setTextureSize(128, 64);
            Shape2.mirror = true;
            this.setRotation(Shape2, 0.0F, -0.0174533F, 0.0F);
            Shape19 = new MModelRenderer(this, 0, 52);
            Shape19.addBox(-3.0F, -3.0F, -3.0F, 6, 3, 6);
            Shape19.setRotationPoint(0.0F, 0.0F, 0.0F);
            Shape19.setTextureSize(128, 64);
            Shape19.mirror = true;
            this.setRotation(Shape19, 0.0F, ((float)Math.PI / 4F), 0.0F);
            Shape3 = new MModelRenderer(this, 0, 52);
            Shape3.addBox(-1.5F, -9.0F, -1.5F, 3, 9, 3);
            Shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
            Shape3.setTextureSize(128, 64);
            Shape3.mirror = true;
            this.setRotation(Shape3, 0.0F, -0.0174533F, 0.0F);
            Shape4 = new MModelRenderer(this, 0, 52);
            Shape4.addBox(-1.5F, -6.0F, -1.5F, 3, 3, 3);
            Shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
            Shape4.setTextureSize(128, 64);
            Shape4.mirror = true;
            this.setRotation(Shape4, 0.0F, ((float)Math.PI / 4F), 0.0F);
            Piece1 = new MModelRenderer(this, "Piece1");
            Piece1.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.setRotation(Piece1, 0.0F, 0.0F, -0.4089656F);
            Piece1.mirror = true;
            Piece1.addBox("Shape21", 14.4F, -15.4F, -6.1333F, 1, 1, 3);
            Piece1.addBox("Shape22", 14.4F, -13.4F, -6.1333F, 1, 1, 3);
            Piece1.addBox("Shape23", 14.4F, -11.4F, -6.1333F, 1, 1, 3);
            Piece1.addBox("Shape24", 14.4F, -15.4F, 3.5333F, 1, 1, 3);
            Piece1.addBox("Shape25", 14.4F, -15.4F, 1.8667F, 1, 5, 1);
            Piece1.addBox("Shape26", 14.4F, -15.4F, -2.1333F, 1, 1, 3);
            Piece1.addBox("Shape27", 14.4F, -14.4F, 5.5333F, 1, 4, 1);
            Piece1.addBox("Shape28", 14.4F, -14.4F, -4.1333F, 1, 1, 1);
            Piece1.addBox("Shape29", 14.4F, -12.4F, -6.1333F, 1, 1, 1);
            Piece1.addBox("Shape30", 14.4F, -14.4F, -0.1333F, 1, 3, 1);
            Piece1.addBox("Shape31", 14.4F, -11.4F, -2.1333F, 1, 1, 3);
            Piece1.addBox("Shape32", 14.4F, -14.4F, -2.1333F, 1, 3, 1);
            Piece1.addBox("Shape21", 0.0F, 0.0F, 0.0F, 1, 1, 3);
            Piece1.addBox("Shape21", 0.0F, 0.0F, 0.0F, 1, 1, 3);
            Piece2 = new MModelRenderer(this, "Piece2");
            Piece2.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.setRotation(Piece2, 0.0F, 0.0F, -0.4089656F);
            Piece2.mirror = true;
            Piece2.addBox("Shape5", -3.59F, -15.0F, -5.7F, 3, 6, 12);
            Piece2.addBox("Shape6", -1.0F, -14.1F, -5.7F, 13, 3, 12);
            Piece2.addBox("Shape7", 11.7F, -18.0F, -5.7F, 3, 9, 12);
            Piece2.addBox("Shape8", -0.6F, -10.5F, -4.5F, 9, 3, 9);
            Piece2.addBox("Shape18", -2.6F, -12.0F, -5.7F, 15, 3, 12);
            Piece2.addBox("Shape9", -3.6F, -15.9F, -6.3F, 3, 9, 3);
            Piece2.addBox("Shape17", 0.3F, -10.0F, -3.0F, 6, 3, 6);
            Piece2.addBox("Shape10", -3.6F, -15.9F, 3.9F, 3, 9, 3);
            Piece2.addBox("Shape15", -1.0F, -12.9F, 3.6F, 13, 3, 3);
            Piece2.addBox("Shape11", 7.8F, -16.2F, -5.2F, 6, 6, 11);
            Piece2.addBox("Shape14", -1.0F, -12.9F, -6.0F, 13, 3, 3);
            Piece2.addBox("Shape12", 11.71F, -19.9F, -6.3F, 3, 13, 3);
            Piece2.addBox("Shape13", 11.71F, -19.9F, 3.9F, 3, 13, 3);
        }

        this.setTexture(new ResourceLocation("minidot:pets/bedwars_2017_" + type + ".png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        float f1 = time * 1.5F;
        GlStateManager.scale(0.75F, 0.75F, 0.75F);
        GlStateManager.translate(0.8F, -0.3F + f, 0.5F);
        GlStateManager.rotate(90.0F + f1, 0.0F, 1.0F, 0.0F);
        Shape1.rotationY = time * 0.08F;
        Shape16.rotationY = time * 0.08F;
        Shape2.rotationY = -time * 0.08F;
        Shape19.rotationY = -time * 0.08F;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.25F, 0.0F);
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
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
                    b0 = 1;
                }

                break;

            case -902311155:
                if (s.equals("silver"))
                {
                    b0 = 2;
                }

                break;

            case 3178592:
                if (s.equals("gold"))
                {
                    b0 = 3;
                }

                break;

            case 853620882:
                if (s.equals("classic"))
                {
                    b0 = 0;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u041a\u0440\u043e\u0432\u0430\u0442\u043a\u0430";

            case 1:
                return "\u0411\u0440\u043e\u043d\u0437\u043e\u0432\u0430\u044f \u043a\u0440\u043e\u0432\u0430\u0442\u043a\u0430";

            case 2:
                return "\u0421\u0435\u0440\u0435\u0431\u0440\u044f\u043d\u0430\u044f \u043a\u0440\u043e\u0432\u0430\u0442\u043a\u0430";

            case 3:
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
                    b0 = 1;
                }

                break;

            case -902311155:
                if (s.equals("silver"))
                {
                    b0 = 2;
                }

                break;

            case 3178592:
                if (s.equals("gold"))
                {
                    b0 = 3;
                }

                break;

            case 853620882:
                if (s.equals("classic"))
                {
                    b0 = 0;
                }
        }

        switch (b0)
        {
            case 0:
                return Collections.<String>singletonList("\u0417\u0430 \u0443\u0447\u0430\u0441\u0442\u0438\u0435 \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars Hard [\u0417\u0438\u043c\u0430 2017]");

            case 1:
                return Collections.<String>singletonList("\u0417\u0430 \u0442\u0440\u0435\u0442\u044c\u0435 \u043c\u0435\u0441\u0442\u043e \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars Hard [\u0417\u0438\u043c\u0430 2017]");

            case 2:
                return Collections.<String>singletonList("\u0417\u0430 \u0432\u0442\u043e\u0440\u043e\u0435 \u043c\u0435\u0441\u0442\u043e \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars Hard [\u0417\u0438\u043c\u0430 2017]");

            case 3:
                return Collections.<String>singletonList("\u0417\u0430 \u043f\u043e\u0431\u0435\u0434\u0443 \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars Hard [\u0417\u0438\u043c\u0430 2017]");

            default:
                return null;
        }
    }
}
