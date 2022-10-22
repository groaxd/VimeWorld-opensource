package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskHannya extends BaseItem
{
    private final MModelRenderer bone;
    private final MModelRenderer Shape6;
    private final MModelRenderer Shape10;
    private final MModelRenderer Shape8;
    private final MModelRenderer Shape9;
    private final MModelRenderer Shape11;
    private final MModelRenderer Shape12;
    private final MModelRenderer Shape17;
    private final MModelRenderer Shape30;

    public MaskHannya()
    {
        super(ItemType.MASK);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.bone.cubeList.add(new ModelBox(this.bone, 15, 10, 3.0F, -4.0F, -6.0F, 2, 2, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 24, 0, -2.0F, -9.0F, -6.0F, 4, 1, 2, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 24, 3, -3.0F, 0.0F, -6.0F, 6, 1, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 24, 5, -3.0F, 0.0F, -5.0F, 6, 1, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 15, 0, 4.0F, -5.0F, -5.0F, 1, 3, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 11, 0, -5.0F, -5.0F, -5.0F, 1, 3, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 15, -4.0F, -8.0F, -6.0F, 8, 3, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 30, 7, 3.0F, -8.0F, -5.0F, 1, 6, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 30, 7, -4.0F, -8.0F, -5.0F, 1, 6, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 39, 0, -1.0F, -4.0F, -6.0F, 2, 2, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 20, 0, -5.0F, -4.0F, -6.0F, 2, 2, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 50, 0, -1.0F, -3.0F, -7.0F, 2, 1, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 15, 25, -3.5F, -6.7F, -5.0F, 3, 2, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 14, 25, -0.5F, -6.7F, -5.0F, 4, 2, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 15, 5, 2.0F, -1.0F, -6.0F, 1, 1, 2, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 15, 7, -3.0F, -1.0F, -6.0F, 1, 1, 2, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 5, 12, -0.5F, -5.0F, -6.5F, 1, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 5, -3.0F, -8.0F, -6.5F, 6, 3, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 10, -1.0F, 0.0F, -6.5F, 2, 2, 3, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 25, -2.0F, -2.5F, -6.0F, 4, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 14, 25, -2.0F, -2.5F, -5.0F, 4, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 23, 12, 1.5F, -5.5F, -5.0F, 1, 1, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 23, 10, -2.5F, -5.5F, -5.0F, 1, 1, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, 0.5F, -3.0F, -5.0F, 1, 1, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 2, -1.5F, -3.0F, -5.0F, 1, 1, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 25, 17, 3.4333F, -2.0F, -5.0F, 1, 1, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 20, 17, -4.4F, -2.0F, -5.0F, 1, 1, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 48, 12, 3.0F, -9.0F, -7.0F, 1, 2, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 52, 12, -4.0F, -9.0F, -7.0F, 1, 2, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 43, 22, 3.1F, -11.0F, -6.5F, 1, 2, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 43, 26, -4.1F, -11.0F, -6.5F, 1, 2, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 49, 26, -4.2F, -11.5F, -6.0F, 1, 1, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 49, 23, 3.2F, -11.5F, -6.0F, 1, 1, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 12, 25, -3.0F, -8.5F, -5.0F, 6, 2, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 29, 27, -3.0F, -5.0F, -4.2F, 6, 5, 0, 0.0F, true));
        this.Shape6 = new MModelRenderer(this);
        this.setRotation(this.Shape6, 0.0F, 0.0F, 0.192F);
        this.Shape6.cubeList.add(new ModelBox(this.Shape6, 31, 21, 1.9725F, -5.6714F, -6.0F, 1, 3, 1, 0.0F, false));
        this.Shape10 = new MModelRenderer(this);
        this.setRotation(this.Shape10, 0.0F, 0.0F, -0.192F);
        this.Shape10.cubeList.add(new ModelBox(this.Shape10, 36, 21, -2.9725F, -5.6714F, -6.0F, 1, 3, 1, 0.0F, true));
        this.Shape8 = new MModelRenderer(this);
        this.setRotation(this.Shape8, 0.0F, 0.0F, 0.2967F);
        this.Shape8.cubeList.add(new ModelBox(this.Shape8, 0, 28, 2.2405F, -3.0821F, -6.0F, 1, 2, 2, 0.0F, true));
        this.Shape9 = new MModelRenderer(this);
        this.setRotation(this.Shape9, 0.0F, 0.0F, -0.2967F);
        this.Shape9.cubeList.add(new ModelBox(this.Shape9, 0, 28, -3.2405F, -3.0821F, -6.0F, 1, 2, 2, 0.0F, true));
        this.Shape11 = new MModelRenderer(this);
        this.setRotation(this.Shape11, 0.0F, 0.0F, -0.1222F);
        this.Shape11.cubeList.add(new ModelBox(this.Shape11, 0, 19, 1.2868F, -2.4584F, -6.0F, 3, 1, 2, 0.0F, true));
        this.Shape12 = new MModelRenderer(this);
        this.setRotation(this.Shape12, 0.0F, 0.0F, 0.1222F);
        this.Shape12.cubeList.add(new ModelBox(this.Shape12, 0, 22, -4.2969F, -2.4667F, -6.0F, 3, 1, 2, 0.0F, true));
        this.Shape17 = new MModelRenderer(this);
        this.setRotation(this.Shape17, -0.2793F, 0.0F, 0.0F);
        this.Shape17.cubeList.add(new ModelBox(this.Shape17, 45, 0, -0.5F, -2.0119F, -7.3114F, 1, 1, 1, 0.0F, false));
        this.Shape30 = new MModelRenderer(this);
        this.setRotation(this.Shape30, 0.0F, 0.0F, 0.8203F);
        this.Shape30.cubeList.add(new ModelBox(this.Shape30, 47, 5, -0.7589F, -3.0245F, -5.0F, 1, 1, 1, 0.0F, true));
        this.Shape30.cubeList.add(new ModelBox(this.Shape30, 51, 5, -3.054F, -0.5697F, -5.0F, 1, 1, 1, 0.0F, true));
        this.setTexture(new ResourceLocation("minidot", "masks/3d_hannya.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);

        if (player.getCurrentArmor(3) != null)
        {
            GlStateManager.scale(1.001F, 1.001F, 1.001F);
        }
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.1F, 0.0F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "WeinElite";
    }

    public String getName()
    {
        return "\u0414\u0435\u043c\u043e\u043d \u0425\u0430\u043d\u043d\u044f";
    }
}
