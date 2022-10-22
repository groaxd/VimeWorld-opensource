package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ChestPet extends BasePet
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Piece1;
    private static MModelRenderer Piece2;
    private String color;

    public ChestPet(String color)
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.color = color;

        if (Piece1 == null)
        {
            this.setTextureOffset("Piece1.Shape1", 0, 19);
            this.setTextureOffset("Piece1.Shape2", 70, 41);
            this.setTextureOffset("Piece1.Shape3", 75, 31);
            this.setTextureOffset("Piece1.Shape4", 65, 33);
            this.setTextureOffset("Piece2.Shape5", 0, 0);
            this.setTextureOffset("Piece2.Shape6", 14, 57);
            this.setTextureOffset("Piece2.Shape7", 17, 45);
            this.setTextureOffset("Piece2.Shape8", 7, 48);
            this.setTextureOffset("Piece2.Shape9", 0, 0);
            Piece1 = new MModelRenderer(this, "Piece1");
            Piece1.addBox("Shape1", -7.0F, 0.0F, -7.0F, 14, 10, 14);
            Piece1.addBox("Shape2", -6.5F, -2.0F, -6.5F, 13, 2, 0);
            Piece1.addBox("Shape3", 6.5F, -2.0F, -6.5F, 0, 2, 8);
            Piece1.addBox("Shape4", -6.5F, -2.0F, -6.5F, 0, 2, 6);
            Piece2 = new MModelRenderer(this, "Piece2");
            Piece2.setRotationPoint(0.0F, 0.0F, 7.0F);
            Piece2.addBox("Shape5", -7.0F, -5.0F, -14.0F, 14, 5, 14);
            Piece2.addBox("Shape6", -6.5F, 0.0F, -13.5F, 13, 2, 0);
            Piece2.addBox("Shape7", 6.5F, 0.0F, -13.5F, 0, 2, 10);
            Piece2.addBox("Shape8", -6.5F, 0.0F, -13.5F, 0, 2, 7);
            Piece2.addBox("Shape9", -1.0F, -2.0F, -15.0F, 2, 4, 1);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(0.8F, -0.5F + f, 0.3F);
        GlStateManager.rotate(1.5F, 0.0F, 1.0F, 0.0F);
        GlStateManager.scale(0.75F, 0.75F, 0.75F);
        float f1 = 0.0F;

        if (time % 70.0F > 50.0F)
        {
            f1 = MathHelper.cos(time % 70.0F * 0.267F) * 0.5F - 0.5F;
        }

        Piece2.rotationX = f1;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, -0.1F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -1039745817:
                if (s.equals("normal"))
                {
                    b0 = 0;
                }

                break;

            case 112785:
                if (s.equals("red"))
                {
                    b0 = 1;
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
                return "C\u0443\u043d\u0434\u0443\u043a";

            case 1:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0439 \u0441\u0443\u043d\u0434\u0443\u043a";

            case 2:
                return "\u0417\u0435\u043b\u0435\u043d\u044b\u0439 \u0441\u0443\u043d\u0434\u0443\u043a";

            default:
                return "\u0425\u0443\u0439";
        }
    }

    static
    {
        colors.put("normal", new ResourceLocation("minidot", "pets/normal_chest.png"));
        colors.put("red", new ResourceLocation("minidot", "pets/christmas_chest.png"));
        colors.put("green", new ResourceLocation("minidot", "pets/christmas_chest2.png"));
    }
}
