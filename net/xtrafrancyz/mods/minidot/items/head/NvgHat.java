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

public class NvgHat extends BaseItem
{
    private final MModelRenderer bone;
    private final MModelRenderer bone2;

    public NvgHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bone = new MModelRenderer(this);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 61, -8.0F, -10.0F, -13.0F, 6, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 59, -7.0F, -8.0F, -13.0F, 4, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 56, -7.0F, -11.0F, -13.0F, 4, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 58, -6.0F, -12.0F, -13.0F, 2, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 58, -6.0F, -7.0F, -13.0F, 2, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 58, 4.0F, -7.0F, -13.0F, 2, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 58, 4.0F, -12.0F, -13.0F, 2, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 56, 3.0F, -11.0F, -13.0F, 4, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 59, 3.0F, -8.0F, -13.0F, 4, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 61, 2.0F, -10.0F, -13.0F, 6, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 31, -7.0F, -7.0F, -12.0F, 4, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 37, -8.0F, -8.0F, -12.0F, 6, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 41, -9.0F, -10.0F, -12.0F, 8, 2, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 45, -8.0F, -11.0F, -12.0F, 6, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 52, -6.0F, -13.0F, -12.0F, 2, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 48, -7.0F, -12.0F, -12.0F, 4, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 26, -6.0F, -6.0F, -12.0F, 2, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 31, 3.0F, -7.0F, -12.0F, 4, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 26, 4.0F, -6.0F, -12.0F, 2, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 52, 4.0F, -13.0F, -12.0F, 2, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 48, 3.0F, -12.0F, -12.0F, 4, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 41, 1.0F, -10.0F, -12.0F, 8, 2, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 45, 2.0F, -11.0F, -12.0F, 6, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 37, 2.0F, -8.0F, -12.0F, 6, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 17, 56, -10.0F, -14.0F, -10.0F, 20, 7, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 8, 16, -10.0F, -14.0F, -9.0F, 1, 7, 3, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 16, 9.0F, -14.0F, -9.0F, 1, 7, 3, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 30, 25, 9.0F, -14.0F, -6.0F, 1, 5, 16, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 30, 4, -10.0F, -14.0F, -6.0F, 1, 5, 16, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 32, 51, -6.0F, -17.0F, -10.0F, 12, 3, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 7, 9, -9.0F, -14.0F, 9.0F, 18, 5, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 32, 47, -5.0F, -19.0F, -10.0F, 10, 2, 1, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.bone.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 22, 46, -1.0F, -17.0F, -3.0F, 2, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 21, 49, -2.0F, -16.0F, -3.0F, 4, 2, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 21, 53, -1.0F, -14.0F, -3.0F, 2, 1, 1, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "head/nvg_hat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.445F, 0.445F, 0.445F);
        GlStateManager.translate(0.0F, 0.08F, 0.0F);
        this.bone2.isHidden = player.getCurrentArmor(3) != null;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.4F, 0.4F, 0.4F);
        GlStateManager.translate(0.0F, 0.45F, 0.0F);
        this.bone2.isHidden = false;
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "NVG";
    }

    public String getCreator()
    {
        return "vladnest";
    }
}
