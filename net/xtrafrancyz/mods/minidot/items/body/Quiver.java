package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Quiver extends BaseItem
{
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;

    public Quiver()
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.bone2 = new MModelRenderer(this);
        this.setRotation(this.bone2, 0.0F, 0.0F, -0.4363F);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 14, 2.0F, -22.0F, 2.0F, 7, 13, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 16, 16, 9.0F, -22.0F, 3.0F, 1, 13, 2, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 16, 16, 1.0F, -22.0F, 3.0F, 1, 13, 2, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 47, 15, 2.0F, -9.0F, 3.0F, 1, 5, 2, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 47, 15, 8.0F, -9.0F, 3.0F, 1, 5, 2, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 13, 3.0F, -4.0F, 3.0F, 5, 1, 2, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, 2.0F, -22.0F, 5.0F, 7, 13, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 47, 0, 8.1226F, -25.4063F, 3.5F, 1, 10, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 47, 0, 4.9226F, -26.9063F, 3.5F, 1, 10, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 47, 0, 1.8226F, -25.6063F, 3.5F, 1, 10, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 6.7226F, -25.0063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 3.5226F, -26.5063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 0.4226F, -25.2063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 9.5226F, -25.0063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 6.3226F, -26.5063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 3.2226F, -25.2063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 8.2F, -25.0063F, 2.1774F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 5.0F, -26.5063F, 2.1774F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 1.9F, -25.2063F, 2.1774F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 8.2F, -25.0063F, 4.8226F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 5.0F, -26.5063F, 4.8226F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 1.9F, -25.2063F, 4.8226F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 8.2F, -24.4063F, 3.0774F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 5.0F, -25.9063F, 3.0774F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 1.9F, -24.6063F, 3.0774F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 8.2F, -24.4063F, 3.9226F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 5.0F, -25.9063F, 3.9226F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 1.9F, -24.6063F, 3.9226F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 0, 7.6226F, -23.4063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 0, 4.4226F, -24.9063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 0, 1.3226F, -23.6063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 0, 8.6226F, -23.4063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 0, 5.4226F, -24.9063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 0, 2.3226F, -23.6063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 0, 8.2F, -23.4063F, 3.0774F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 0, 5.0F, -24.9063F, 3.0774F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 0, 1.9F, -23.6063F, 3.0774F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 0, 8.2F, -23.4063F, 3.9226F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 0, 5.0F, -24.9063F, 3.9226F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 0, 1.9F, -23.6063F, 3.9226F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 9.1226F, -24.3063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 5.9226F, -25.8063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 2.8226F, -24.5063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 8.2F, -24.3063F, 2.5774F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 5.0F, -25.8063F, 2.5774F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 1.9F, -24.5063F, 2.5774F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 8.2F, -24.3063F, 4.4226F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 5.0F, -25.8063F, 4.4226F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 1.9F, -24.5063F, 4.4226F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 7.1226F, -24.4063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 3.9226F, -25.9063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 40, 2, 0.8226F, -24.6063F, 3.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 22, 0, 3.0F, -9.0F, 2.0F, 5, 5, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 22, 22, 3.0F, -9.0F, 5.0F, 5, 5, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 34, 0, -6.0F, -24.5F, -6.5F, 2, 5, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 34, 0, -5.6F, -21.2F, -6.497F, 2, 4, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 34, 0, -4.8F, -19.5F, -6.5F, 2, 4, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 34, 0, -4.1F, -16.8F, -6.4998F, 2, 4, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 34, 0, -3.4F, -14.3F, -6.5F, 2, 4, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 47, 11, 7.5F, -4.3F, -6.5F, 1, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 49, 25, 7.5F, -4.3F, 1.5F, 1, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 49, 25, 6.5F, -4.4F, 1.5F, 1, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 35, 14, 4.5F, -4.7F, 1.5F, 2, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 43, 22, 3.4F, -5.2F, 1.499F, 2, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 43, 22, 2.4F, -6.0F, 1.5F, 2, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 26, 7.5F, -4.0F, -0.5F, 1, 2, 2, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 22, 16, 7.5F, -3.7F, -3.5F, 1, 2, 3, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 26, 7.5F, -4.0F, -5.5F, 1, 2, 2, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 47, 11, 6.5F, -4.3F, -6.5F, 1, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 57, 25, 5.0F, -4.3F, -6.5F, 2, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 43, 25, 3.6F, -4.8F, -6.4996F, 2, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 36, 25, 2.3F, -6.0F, -6.5F, 2, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 36, 25, 1.2F, -7.4F, -6.4996F, 2, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 36, 17, -0.1F, -8.3F, -6.5F, 2, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 36, 17, -1.4F, -9.5F, -6.5F, 2, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 34, 21, -2.6F, -11.5F, -6.4996F, 2, 3, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 38, 7, -6.0F, -24.5F, 1.5F, 2, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 11, -6.3F, -24.5F, -0.5F, 2, 1, 2, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 11, -6.3F, -24.5F, -5.5F, 2, 1, 2, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 22, 6, -6.5F, -24.5F, -3.5F, 2, 1, 3, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 38, 11, -5.6F, -23.5F, 1.5F, 2, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 38, 9, -5.3F, -22.5F, 1.5F, 2, 1, 1, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "body/quiver.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.setModelRotation(modelPlayer.bipedBody);
        GlStateManager.translate(-0.02F, 0.85F, 0.07F);
        GlStateManager.scale(0.575D, 0.575D, 0.575D);
        this.setRotationAngles(this.rotateX, this.rotateY, this.rotateZ);

        if (modelPlayer.isSneak)
        {
            GlStateManager.translate(0.0F, 0.42F, 0.56F);
        }
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.57F, 0.3F);
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u043e\u043b\u0447\u0430\u043d \u0441\u0442\u0440\u0435\u043b";
    }

    public String getCreator()
    {
        return "Edwaite";
    }
}
