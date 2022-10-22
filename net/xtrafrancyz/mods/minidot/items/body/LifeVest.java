package net.xtrafrancyz.mods.minidot.items.body;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class LifeVest extends BaseItem
{
    private static MModelRenderer bone;
    private final String color;

    public LifeVest(String color)
    {
        super(ItemType.BODY);
        this.color = color;
        this.textureWidth = 64;
        this.textureHeight = 64;
        bone = new MModelRenderer(this);
        bone.setRotationPoint(0.0F, -8.0F, 0.0F);
        bone.cubeList.add(new ModelBox(bone, 0, 38, 4.2F, 6.0F, 0.5F, 1, 1, 4, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 36, 30, -4.0F, -4.0F, -1.0F, 2, 2, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 20, 27, 2.0F, -4.0F, -1.0F, 2, 2, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 42, 27, -4.0F, -2.0F, -1.0F, 3, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 42, 25, 1.0F, -2.0F, -1.0F, 3, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 34, 43, 4.0F, 2.0F, -0.2F, 1, 6, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 30, 43, 4.0F, 2.0F, 3.2F, 1, 6, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 40, 16, 3.5F, -4.0F, -0.2F, 1, 1, 4, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 4, 43, -5.0F, 2.0F, -0.2F, 1, 6, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 18, 17, -5.0F, 2.0F, 3.2F, 1, 6, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 16, -4.0F, -3.0F, 4.0F, 8, 11, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 41, 6, 1.0F, -4.0F, 4.0F, 3, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 40, 21, -4.0F, -4.0F, 4.0F, 3, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 28, 0.1F, -1.11F, -1.0F, 4, 9, 1, -0.05F, false));
        bone.cubeList.add(new ModelBox(bone, 26, 27, -4.1F, -1.1F, -1.0F, 4, 9, 1, -0.05F, false));
        bone.cubeList.add(new ModelBox(bone, 32, 0, 2.0F, -4.3F, 0.0F, 2, 1, 4, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 26, 19, -4.0F, -4.3F, 0.0F, 2, 1, 4, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 40, 11, 3.5F, -4.0F, 0.2F, 1, 1, 4, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 40, 1, -4.5F, -4.0F, 0.2F, 1, 1, 4, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 38, 40, -4.5F, -4.0F, -0.2F, 1, 1, 4, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 43, -1.0F, -1.11F, -0.9F, 1, 9, 1, -0.05F, false));
        bone.cubeList.add(new ModelBox(bone, 26, 42, 0.0F, -1.11F, -0.9F, 1, 9, 1, -0.05F, false));
        bone.cubeList.add(new ModelBox(bone, 40, 0, 0.1F, -1.21F, -0.9F, 1, 1, 1, -0.05F, false));
        bone.cubeList.add(new ModelBox(bone, 38, 40, -1.1F, -1.21F, -0.9F, 1, 1, 1, -0.05F, false));
        bone.cubeList.add(new ModelBox(bone, 6, 40, -2.0F, -2.11F, -0.9F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 40, 1.0F, -2.11F, -0.9F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 26, 39, -1.9F, -2.01F, -0.9F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 38, 35, 0.9F, -2.01F, -0.9F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 26, 19, 1.9F, -4.01F, -0.9F, 1, 2, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 0, -2.9F, -4.01F, -0.9F, 1, 2, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 22, 32, 3.1F, -4.01F, -0.9F, 1, 12, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 18, 32, -4.1F, -4.01F, -0.9F, 1, 12, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 44, 23, 2.0F, -4.11F, -0.9F, 2, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 43, 8, -4.0F, -4.11F, -0.9F, 2, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 20, 2, 0.1F, 6.99F, -0.9F, 4, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 20, 0, -4.1F, 6.99F, -0.9F, 4, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 32, 15, 1.0F, -4.11F, 3.9F, 3, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 10, 28, -4.0F, -4.11F, 3.9F, 3, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 32, 38, -1.9F, -4.01F, 3.9F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 6, 38, 0.9F, -4.01F, 3.9F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 24, 4, -1.0F, -3.11F, 3.9F, 2, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 14, 32, 3.1F, -4.01F, 3.9F, 1, 12, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 10, 32, -4.1F, -4.01F, 3.9F, 1, 12, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 26, 17, -4.0F, 0.0F, -1.4F, 8, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 26, 13, -4.0F, 3.0F, -1.4F, 8, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 26, 11, -4.0F, 6.0F, -1.4F, 8, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 26, 9, -4.0F, 0.0F, 4.5F, 8, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 20, 25, -4.0F, 3.0F, 4.5F, 8, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 24, 7, -4.0F, 6.0F, 4.5F, 8, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 12, 25, 3.5F, 3.0F, -1.0F, 1, 1, 6, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 24, 0, 3.5F, 6.0F, -1.0F, 1, 1, 6, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 18, 10, -4.5F, 3.0F, -1.0F, 1, 1, 6, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 18, 18, -4.5F, 6.0F, -1.0F, 1, 1, 6, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 38, 35, 4.2F, 3.0F, -0.5F, 1, 1, 4, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 38, 30, 4.2F, 6.0F, -0.5F, 1, 1, 4, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 32, 38, 4.2F, 3.0F, 0.5F, 1, 1, 4, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 26, 37, -5.2F, 3.0F, -0.5F, 1, 1, 4, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 36, 25, -5.2F, 3.0F, 0.5F, 1, 1, 4, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 34, 20, -5.2F, 6.0F, -0.5F, 1, 1, 4, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 32, 33, -5.2F, 6.0F, 0.5F, 1, 1, 4, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 38, -4.2F, 0.0F, -1.0F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 26, 37, 3.2F, 0.0F, -1.0F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 36, 27, 3.2F, 0.0F, 4.0F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 34, 21, -4.2F, 0.0F, 4.0F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 34, 19, -1.0F, 3.0F, -1.6F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 32, 2, -1.0F, 0.0F, -1.6F, 1, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 32, 0, -1.0F, 6.0F, -1.6F, 1, 1, 1, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "body/lifevest_" + color + ".png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.setModelRotation(modelPlayer.bipedBody);
        GlStateManager.translate(0.0F, 0.72F, -0.125F);
        bone.isHidden = player.getCurrentArmor(2) != null;
        this.setRotationAngles(this.rotateX, this.rotateY, this.rotateZ);

        if (modelPlayer.isSneak)
        {
            GlStateManager.translate(0.0F, 0.307F, 0.215F);
        }
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.57F, 0.3F);
        bone.isHidden = false;
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
                    b0 = 0;
                }

                break;

            case 112785:
                if (s.equals("red"))
                {
                    b0 = 1;
                }

                break;

            case 3181155:
                if (s.equals("gray"))
                {
                    b0 = 2;
                }

                break;

            case 98619139:
                if (s.equals("green"))
                {
                    b0 = 3;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0416\u0435\u043b\u0442\u044b\u0439 \u0441\u043f\u0430\u0441\u0430\u0442\u0435\u043b\u044c\u043d\u044b\u0439 \u0436\u0438\u043b\u0435\u0442";

            case 1:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0439 \u0441\u043f\u0430\u0441\u0430\u0442\u0435\u043b\u044c\u043d\u044b\u0439 \u0436\u0438\u043b\u0435\u0442";

            case 2:
                return "\u0421\u0435\u0440\u044b\u0439 \u0441\u043f\u0430\u0441\u0430\u0442\u0435\u043b\u044c\u043d\u044b\u0439 \u0436\u0438\u043b\u0435\u0442";

            case 3:
                return "\u0417\u0435\u043b\u0435\u043d\u044b\u0439 \u0441\u043f\u0430\u0441\u0430\u0442\u0435\u043b\u044c\u043d\u044b\u0439 \u0436\u0438\u043b\u0435\u0442";

            default:
                return "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 \u0441\u043f\u0430\u0441\u0430\u0442\u0435\u043b\u044c\u043d\u044b\u0439 \u0436\u0438\u043b\u0435\u0442...";
        }
    }

    public String getCreator()
    {
        return "Veltorn";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.GOLD + "\u041d\u0435 \u043f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442\u0441\u044f, \u0435\u0441\u043b\u0438 \u043d\u0430\u0434\u0435\u0442 \u043d\u0430\u0433\u0440\u0443\u0434\u043d\u0438\u043a");
    }
}
