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

public class ClownHat extends BaseItem
{
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final MModelRenderer bone3;
    private final MModelRenderer nose;

    public ClownHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.setRotation(this.bone, 0.0F, -1.5708F, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 0, -2.0F, -9.0F, -3.0F, 4, 1, 6, 0.0F, false));
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 7, -1.0F, -12.0F, -2.0F, 2, 3, 4, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone5.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 16, 16, 0.5F, -12.5F, -0.5F, 3, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 23, 11, -0.5F, -12.5F, 0.5F, 1, 1, 3, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 21, -0.5F, -13.0F, -0.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 7, 17, -3.5F, -12.5F, -0.5F, 3, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 14, 2, -0.5F, -12.5F, -3.5F, 1, 1, 3, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 18, 0.0F, -5.0F, 5.0F, 2, 2, 1, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 8, 8, -2.0F, -7.0F, 5.0F, 4, 2, 1, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 19, 20, 0.0F, -3.0F, 4.0F, 2, 1, 1, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 0, 2.0F, -7.0F, 4.0F, 1, 4, 1, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 14, -2.0F, -8.0F, 4.0F, 4, 1, 1, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 6, 19, -2.0F, -5.0F, 4.0F, 2, 1, 1, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 7, -3.0F, -7.0F, 4.0F, 1, 2, 1, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 4, 21, -1.0F, -4.0F, 4.0F, 1, 1, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 20, 18, -2.0F, -5.0F, -5.0F, 2, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 20, 2, 0.0F, -3.0F, -5.0F, 2, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 15, 21, -1.0F, -4.0F, -5.0F, 1, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 14, 18, 0.0F, -5.0F, -6.0F, 2, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 11, 20, -3.0F, -7.0F, -5.0F, 1, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 18, 7, 2.0F, -7.0F, -5.0F, 1, 4, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 12, 12, -2.0F, -7.0F, -6.0F, 4, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 14, 0, -2.0F, -8.0F, -5.0F, 4, 1, 1, 0.0F, false));
        this.nose = new MModelRenderer(this);
        this.bone.addChild(this.nose);
        this.nose.cubeList.add(new ModelBox(this.nose, 14, 2, -6.0F, -4.5F, -1.0F, 2, 2, 2, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "head/clown_hat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.01F, 1.0F, 1.005F);
        this.bone2.rotationY = time * 0.4F;

        if (player.getCurrentArmor(3) != null)
        {
            this.nose.offsetX = 0.05F;
        }
        else
        {
            this.nose.offsetX = 0.0F;
        }
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.1F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u043b\u043e\u0443\u043d";
    }

    public String getCreator()
    {
        return "Wenston";
    }
}
