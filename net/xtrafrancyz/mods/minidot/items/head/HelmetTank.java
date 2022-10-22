package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HelmetTank extends BaseHelm
{
    private final MModelRenderer All;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;

    public HelmetTank()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.All = new MModelRenderer(this);
        this.All.cubeList.add(new ModelBox(this.All, 34, 8, -4.0F, -8.0F, -4.5F, 8, 2, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 18, 27, -3.0F, -6.5F, -4.49F, 6, 1, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 18, 25, -3.0F, -7.5F, -5.0F, 6, 1, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 1, 3, -3.9F, -9.5F, -3.0F, 2, 1, 7, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 24, 2, -3.9F, -8.5F, -4.0F, 2, 1, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 24, 0, -3.9F, -8.5F, 4.0F, 2, 1, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 12, 2, -1.0F, -9.7F, -3.0F, 2, 1, 7, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 18, 29, -1.0F, -8.7F, -4.0F, 2, 1, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 0, 22, -1.0F, -8.7F, 4.0F, 2, 1, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 24, 0, 1.9F, -9.5F, -3.0F, 2, 1, 7, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 24, 4, 1.9F, -8.5F, -4.0F, 2, 1, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 0, 6, 1.9F, -8.5F, 4.0F, 2, 1, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 44, 15, -4.0F, -8.0F, 4.5F, 8, 8, 1, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 0, 16, -4.0F, -9.0F, -3.5F, 8, 1, 8, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 24, 8, 4.0F, -8.0F, -3.5F, 1, 8, 8, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 0, 0, 5.0F, -6.0F, -1.5F, 1, 3, 3, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 0, 0, -6.0F, -6.0F, -1.5F, 1, 3, 3, 0.0F, false));
        this.All.cubeList.add(new ModelBox(this.All, 24, 8, -5.0F, -8.0F, -3.5F, 1, 8, 8, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, -3.1F);
        this.setRotation(this.bone, 0.6109F, 0.0F, 0.0F);
        this.All.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 35, 0, 3.99F, -2.0F, -3.0F, 1, 2, 4, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 35, 0, -4.99F, -2.0F, -3.0F, 1, 2, 4, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 0.0F, -3.1F);
        this.setRotation(this.bone2, 0.6109F, 0.0F, 0.0F);
        this.All.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 28, 29, 3.99F, -1.0F, -4.0F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 24, 29, -4.99F, -1.0F, -4.0F, 1, 1, 1, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "head/helmet_tank.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.0F, 1.07F, 1.127F);
        GlStateManager.translate(0.0F, 0.0F, -0.031F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.75F, 0.75F, 0.75F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u043b\u0435\u043c \u0442\u0430\u043d\u043a\u0438\u0441\u0442\u0430";
    }

    public String getCreator()
    {
        return "Veltorn";
    }
}
