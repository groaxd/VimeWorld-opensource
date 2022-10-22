package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class LanternPet extends BasePet
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private final MModelRenderer bb_main;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private String color;

    public LanternPet(String color)
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.color = color;
        this.bb_main = new MModelRenderer(this);
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 13, -4.0F, -2.0F, -4.0F, 8, 1, 8, 0.0F, false));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 13, -4.0F, -9.0F, -4.0F, 8, 1, 8, 0.0F, false));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 22, -2.5F, -10.5F, -2.5F, 5, 2, 5, 0.0F, false));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 23, 0, 0.9284F, -11.75F, -0.5F, 1, 2, 1, 0.0F, false));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 28, 0, -0.4858F, -13.1642F, -0.5F, 1, 1, 1, 0.0F, false));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 23, 0, -1.9F, -11.75F, -0.5F, 1, 2, 1, 0.0F, true));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 0, -3.5F, -8.0F, -3.5F, 7, 6, 7, 0.0F, false));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 0, 2.75F, -8.0F, -3.75F, 1, 6, 1, 0.0F, false));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 0, -3.75F, -8.0F, -3.75F, 1, 6, 1, 0.0F, true));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 0, -3.75F, -8.0F, 2.75F, 1, 6, 1, 0.0F, true));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 0, 2.75F, -8.0F, 2.75F, 1, 6, 1, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.setRotation(this.bone, 0.0F, 0.0F, 0.7854F);
        this.bone.cubeList.add(new ModelBox(this.bone, 28, 0, -9.652F, -8.965F, -0.5F, 1, 2, 1, 0.0F, true));
        this.bone2 = new MModelRenderer(this);
        this.setRotation(this.bone2, 0.0F, 0.0F, -0.7854F);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 28, 0, 8.6721F, -8.9449F, -0.5F, 1, 2, 1, 0.0F, false));
        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        float f1 = time * 1.5F;
        GlStateManager.translate(0.7F, -0.3F + f, 0.5F);
        GlStateManager.rotate(90.0F + f1, 0.0F, 1.0F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.25F, 0.0F);
        super.renderAsItem(time);
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
                    b0 = 1;
                }

                break;

            case 3027034:
                if (s.equals("blue"))
                {
                    b0 = 0;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0421\u0432\u0435\u0442\u0438\u043b\u044c\u043d\u0438\u043a \u0434\u0443\u0448";

            case 1:
                return "\u0421\u0432\u0435\u0442\u0438\u043b\u044c\u043d\u0438\u043a";

            default:
                return "\u0425\u0443\u0439";
        }
    }

    public String getCreator()
    {
        return "xRolaaan";
    }

    static
    {
        colors.put("blue", new ResourceLocation("minidot", "pets/lantern_blue.png"));
        colors.put("yellow", new ResourceLocation("minidot", "pets/lantern_yellow.png"));
    }
}
