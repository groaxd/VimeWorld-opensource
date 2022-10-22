package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class UnderwaterHat extends BaseHelm
{
    private final MModelRenderer bone;

    public UnderwaterHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bone = new MModelRenderer(this);
        this.bone.cubeList.add(new ModelBox(this.bone, 24, 31, 4.0F, -9.0F, 1.0F, 1, 8, 3, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 20, 9, -4.0F, -9.0F, 4.0F, 8, 8, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -4.0F, -1.0F, -4.0F, 8, 1, 8, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 24, 0, -4.0F, -10.0F, 1.0F, 8, 1, 3, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 32, 37, -4.0F, -9.0F, -5.0F, 2, 8, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 22, 42, -2.0F, -9.0F, -5.0F, 4, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 12, 42, -2.0F, -3.0F, -5.0F, 4, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 16, 31, 4.0F, -9.0F, -4.0F, 1, 8, 3, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 10, 19, 4.0F, -9.0F, -1.0F, 1, 3, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 18, 4.0F, -4.0F, -1.0F, 1, 3, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 10, 10, -5.0F, -9.0F, -1.0F, 1, 3, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 8, 30, -5.0F, -9.0F, -4.0F, 1, 8, 3, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 9, -5.0F, -4.0F, -1.0F, 1, 3, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 30, -5.0F, -9.0F, 1.0F, 1, 8, 3, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 20, 20, -4.0F, -10.0F, -4.0F, 8, 1, 3, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 39, 20, 1.0F, -10.0F, -1.0F, 3, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 38, 24, -4.0F, -10.0F, -1.0F, 3, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 42, 4, -2.0F, -3.001F, -5.5F, 4, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 35, 29, -2.0F, -7.999F, -5.5F, 4, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 44, 44, -2.999F, -7.0F, -5.5F, 1, 4, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 42, 12, 1.999F, -7.0F, -5.5F, 1, 4, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 42, 9, 4.5F, -4.001F, -1.0F, 1, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 21, 31, 4.5F, -6.999F, -1.0F, 1, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 24, 45, 4.5F, -6.0F, 0.999F, 1, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 20, 45, 4.5F, -6.0F, -1.999F, 1, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 13, 30, -5.5F, -6.999F, -1.0F, 1, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 16, 45, -5.5F, -6.0F, -1.999F, 1, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 12, 45, -5.5F, -6.0F, 0.999F, 1, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 5, 30, -5.5F, -4.001F, -1.0F, 1, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 23, 0.999F, -10.5F, -1.0F, 1, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 14, -1.999F, -10.5F, -1.0F, 1, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 10, 24, -1.0F, -10.5F, 0.999F, 2, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 10, 15, -1.0F, -10.5F, -1.999F, 2, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 38, 47, -2.55F, -7.55F, -5.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 27, 47, 1.45F, -7.55F, -5.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 46, 23, 1.45F, -3.55F, -5.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 46, 14, -2.55F, -3.55F, -5.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 46, 2, 4.5F, -6.5F, 0.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 35, 46, 4.5F, -6.5F, -1.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 31, 46, 4.5F, -4.5F, -1.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 28, 45, 4.5F, -4.5F, 0.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 44, 30, -5.5F, -4.5F, -1.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 44, 28, -5.5F, -4.5F, 0.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 44, 17, -5.5F, -6.5F, -1.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 22, 32, -5.5F, -6.5F, 0.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 14, 19, 0.5F, -10.5F, 0.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 4, 18, -1.5F, -10.5F, 0.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 4, 14, -1.5F, -10.5F, -1.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 4, 9, 0.5F, -10.5F, -1.5F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 17, 29, -4.0F, -9.5F, -4.5F, 8, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 28, -4.0F, -1.5F, -4.5F, 8, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 27, 18, -4.0F, -1.5F, 3.5F, 8, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 27, 27, -4.0F, -9.5F, 3.5F, 8, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 10, 19, -4.5F, -9.5F, -4.0F, 1, 1, 8, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 18, -4.5F, -1.5F, -4.0F, 1, 1, 8, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 10, 10, 3.5F, -1.5F, -4.0F, 1, 1, 8, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 9, 3.5F, -9.5F, -4.0F, 1, 1, 8, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 8, 41, 3.5F, -9.0F, -4.5F, 1, 8, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 4, 41, -4.5F, -9.0F, -4.5F, 1, 8, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 41, -4.5F, -9.0F, 3.5F, 1, 8, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 38, 9, 3.5F, -9.0F, 3.5F, 1, 8, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -2.0F, -7.0F, -5.0F, 4, 4, 0, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 4, 4, 5.0F, -6.0F, -1.0F, 0, 2, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 4, -5.0F, -6.0F, -1.0F, 0, 2, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 4, -1.0F, -10.0F, -1.0F, 2, 0, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 38, 38, 2.0F, -9.0F, -5.0F, 2, 8, 1, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "head/helmet_underwater.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.01F, 1.01F, 1.01F);
        GlStateManager.translate(0.0F, 0.01F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u0442\u0430\u0440\u044b\u0439 \u043f\u043e\u0434\u0432\u043e\u0434\u043d\u044b\u0439 \u0448\u043b\u0435\u043c";
    }

    public String getCreator()
    {
        return "Veltorn";
    }
}
