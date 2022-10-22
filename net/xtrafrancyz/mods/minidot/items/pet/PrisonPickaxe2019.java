package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class PrisonPickaxe2019 extends BasePet
{
    private final String type;
    private static MModelRenderer pick;

    public PrisonPickaxe2019(String type)
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.type = type;

        if (pick == null)
        {
            pick = new MModelRenderer(this);
            pick.setRotationPoint(0.0F, 0.5F, 0.0F);
            pick.cubeList.add(new ModelBox(pick, 8, 12, 5.0F, -8.0F, -1.5F, 1, 3, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 0, 12, 4.0F, -9.0F, -1.5F, 1, 3, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 0, 12, 2.0F, -11.0F, -1.5F, 1, 3, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 8, 12, 3.0F, -10.0F, -1.5F, 1, 3, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 1, 16, 6.0F, -7.0F, -1.5F, 1, 2, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 8, 12, 1.0F, -12.0F, -1.5F, 1, 3, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 0, 12, 0.0F, -13.0F, -1.5F, 1, 3, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 8, 12, -1.0F, -14.0F, -1.5F, 1, 3, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 0, 12, -2.0F, -15.0F, -1.5F, 1, 3, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 7, 21, -3.0F, -14.0F, -1.5F, 1, 1, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 28, 15, -3.0F, -15.0F, -1.5F, 1, 1, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 0, 29, -3.0F, -16.0F, -1.5F, 2, 1, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 20, 23, -2.0F, -17.0F, -1.5F, 5, 1, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 0, 29, -4.0F, -15.0F, -1.5F, 1, 2, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 20, 26, -5.0F, -14.0F, -1.5F, 1, 5, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 20, 0, -1.0F, -16.0F, -1.5F, 4, 1, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 20, 0, -2.0F, -18.0F, -1.5F, 5, 1, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 20, 0, 3.0F, -17.0F, -1.5F, 1, 1, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 20, 0, -3.0F, -17.0F, -1.5F, 1, 1, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 0, 0, -5.0F, -17.0F, -1.5F, 2, 2, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 20, 0, -5.0F, -15.0F, -1.5F, 1, 1, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 20, 0, -5.0F, -9.0F, -1.5F, 1, 1, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 20, 0, -4.0F, -13.0F, -1.5F, 1, 4, 1, 0.0F, true));
            pick.cubeList.add(new ModelBox(pick, 20, 0, -6.0F, -14.0F, -1.5F, 1, 5, 1, 0.0F, true));
        }

        this.setTexture(new ResourceLocation("minidot:pets/pickaxe_" + type + ".png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        float f1 = time * 1.5F;
        GlStateManager.translate(0.7F, -0.2F + f, 0.4F);
        GlStateManager.rotate(90.0F + f1, 0.0F, 1.0F, 0.0F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.translate(0.0F, 0.45F, 0.0F);
        GlStateManager.rotate(0.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
    }

    public String getName()
    {
        String s = this.type;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -1634062812:
                if (s.equals("emerald"))
                {
                    b0 = 4;
                }

                break;

            case 3241160:
                if (s.equals("iron"))
                {
                    b0 = 1;
                }

                break;

            case 3511770:
                if (s.equals("ruby"))
                {
                    b0 = 6;
                }

                break;

            case 3655341:
                if (s.equals("wood"))
                {
                    b0 = 3;
                }

                break;

            case 109770853:
                if (s.equals("stone"))
                {
                    b0 = 2;
                }

                break;

            case 973576630:
                if (s.equals("rainbow"))
                {
                    b0 = 5;
                }

                break;

            case 1655054676:
                if (s.equals("diamond"))
                {
                    b0 = 0;
                }

                break;

            case 2061338818:
                if (s.equals("sapphire"))
                {
                    b0 = 7;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0410\u043b\u043c\u0430\u0437\u043d\u0430\u044f \u043a\u0438\u0440\u043a\u0430";

            case 1:
                return "\u0416\u0435\u043b\u0435\u0437\u043d\u0430\u044f \u043a\u0438\u0440\u043a\u0430";

            case 2:
                return "\u041a\u0430\u043c\u0435\u043d\u043d\u0430\u044f \u043a\u0438\u0440\u043a\u0430";

            case 3:
                return "\u0414\u0435\u0440\u0435\u0432\u044f\u043d\u043d\u0430\u044f \u043a\u0438\u0440\u043a\u0430";

            case 4:
                return "\u0418\u0437\u0443\u043c\u0440\u0443\u0434\u043d\u0430\u044f \u043a\u0438\u0440\u043a\u0430";

            case 5:
                return "\u0420\u0430\u0434\u0443\u0436\u043d\u0430\u044f \u043a\u0438\u0440\u043a\u0430";

            case 6:
                return "\u0420\u0443\u0431\u0438\u043d\u043e\u0432\u0430\u044f \u043a\u0438\u0440\u043a\u0430";

            case 7:
                return "\u0421\u0430\u043f\u0444\u0438\u0440\u043e\u0432\u0430\u044f \u043a\u0438\u0440\u043a\u0430";

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
            case -1634062812:
                if (s.equals("emerald"))
                {
                    b0 = 7;
                }

                break;

            case 3241160:
                if (s.equals("iron"))
                {
                    b0 = 2;
                }

                break;

            case 3511770:
                if (s.equals("ruby"))
                {
                    b0 = 5;
                }

                break;

            case 3655341:
                if (s.equals("wood"))
                {
                    b0 = 6;
                }

                break;

            case 109770853:
                if (s.equals("stone"))
                {
                    b0 = 4;
                }

                break;

            case 973576630:
                if (s.equals("rainbow"))
                {
                    b0 = 1;
                }

                break;

            case 1655054676:
                if (s.equals("diamond"))
                {
                    b0 = 0;
                }

                break;

            case 2061338818:
                if (s.equals("sapphire"))
                {
                    b0 = 3;
                }
        }

        switch (b0)
        {
            case 0:
            case 1:
                return Collections.<String>singletonList("\u0412\u044b\u0434\u0430\u0451\u0442\u0441\u044f \u0432 \u043d\u0430\u0433\u0440\u0430\u0434\u0443 \u0437\u0430 1-5 \u043c\u0435\u0441\u0442\u043e \u043d\u0430 Prison");

            case 2:
            case 3:
                return Collections.<String>singletonList("\u0412\u044b\u0434\u0430\u0451\u0442\u0441\u044f \u0432 \u043d\u0430\u0433\u0440\u0430\u0434\u0443 \u0437\u0430 6-25 \u043c\u0435\u0441\u0442\u043e \u043d\u0430 Prison");

            case 4:
            case 5:
                return Collections.<String>singletonList("\u0412\u044b\u0434\u0430\u0451\u0442\u0441\u044f \u0432 \u043d\u0430\u0433\u0440\u0430\u0434\u0443 \u0437\u0430 26-50 \u043c\u0435\u0441\u0442\u043e \u043d\u0430 Prison");

            case 6:
            case 7:
                return Collections.<String>singletonList("\u0412\u044b\u0434\u0430\u0451\u0442\u0441\u044f \u0432 \u043d\u0430\u0433\u0440\u0430\u0434\u0443 \u0437\u0430 51-100 \u043c\u0435\u0441\u0442\u043e \u043d\u0430 Prison");

            default:
                return null;
        }
    }
}
