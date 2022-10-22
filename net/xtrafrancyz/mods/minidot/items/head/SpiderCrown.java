package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SpiderCrown extends BaseItem
{
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;

    public SpiderCrown()
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 14, -2.0F, -1.0F, -5.0F, 4, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 14, -2.0F, -1.0F, 8.0F, 4, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 2, 14, -4.0F, -2.0F, -4.0F, 2, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 1, 14, -4.0F, -1.0F, 7.0F, 2, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 2, 14, 2.0F, -2.0F, -4.0F, 2, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 1, 14, 2.0F, -1.0F, 7.0F, 2, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 3, 14, -5.0F, -1.0F, -3.0F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 3, 14, -5.0F, -1.0F, 6.0F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 4, 14, 4.0F, -1.0F, -3.0F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 3, 14, 4.0F, -1.0F, 6.0F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 3, 13, -6.0F, -1.0F, -2.0F, 1, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 2, 13, -6.0F, -1.0F, 4.0F, 1, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 2, 13, 5.0F, -1.0F, -2.0F, 1, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 2, 13, 5.0F, -1.0F, 4.0F, 1, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 11, -7.0F, -1.0F, 0.0F, 1, 1, 4, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 11, 6.0F, -1.0F, 0.0F, 1, 1, 4, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 8, -2.0F, -8.0F, -5.0F, 1, 7, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 8, 1.0F, -8.0F, -5.0F, 1, 7, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 9, -5.0F, -7.0F, -3.0F, 1, 6, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 9, 4.0F, -7.0F, -3.0F, 1, 6, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 10, 6.0F, -6.0F, 0.0F, 1, 5, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 9, -7.0F, -6.0F, 0.0F, 1, 5, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 9, -7.0F, -6.0F, 3.0F, 1, 5, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 9, 6.0F, -6.0F, 3.0F, 1, 5, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 10, 4.0F, -6.0F, 6.0F, 1, 5, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 10, -5.0F, -6.0F, 6.0F, 1, 5, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 10, -2.0F, -6.0F, 8.0F, 1, 5, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 10, 1.0F, -6.0F, 8.0F, 1, 5, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 5.0F, -8.0F);
        this.setRotation(this.bone3, -1.6144F, 0.0F, 0.0F);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 0, -1.0F, -2.0F, -8.0F, 2, 1, 2, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/spidercrown.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, -0.5D, 0.0D);
        double d0 = 0.6825D;
        GlStateManager.scale(d0, d0, d0);
    }

    public void renderAsItem(float time)
    {
        double d0 = 0.8D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, -0.1D, 0.0D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u043e\u0440\u043e\u043d\u0430 \u043f\u0430\u0443\u043a\u0430";
    }

    public String getCreator()
    {
        return "ItzMakcyk";
    }
}
