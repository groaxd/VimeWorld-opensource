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

public class SantaHat extends BaseItem
{
    private final MModelRenderer hat;
    private final MModelRenderer beard;

    public SantaHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.hat = new MModelRenderer(this);
        this.hat.cubeList.add(new ModelBox(this.hat, 0, 25, -4.0F, -1.0F, -5.0F, 8, 4, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 14, 17, 3.0F, -3.0F, -4.5F, 1, 3, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 14, 17, 3.3F, -7.0F, -4.3F, 1, 5, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 14, 17, -4.3F, -7.0F, -4.3F, 1, 5, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 18, 17, -3.0F, -7.0F, -4.5F, 2, 1, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 18, 19, 1.0F, -7.0F, -4.5F, 2, 1, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 10, 21, -4.0F, -3.0F, -4.5F, 1, 3, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 18, 23, -3.0F, -2.0F, -5.0F, 2, 1, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 18, 21, 1.0F, -2.0F, -5.0F, 2, 1, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 0, 23, -2.0F, -3.0F, -5.0F, 4, 1, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 0, 21, -2.0F, -1.0F, -5.6F, 4, 1, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 0, 21, -2.0F, 3.0F, -5.5F, 4, 1, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 0, 30, -3.0F, 3.0F, -5.0F, 6, 1, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 1, 17, -2.0F, 4.0F, -5.0F, 4, 1, 1, 0.0F, false));
        this.hat.cubeList.add(new ModelBox(this.hat, 0, 17, -3.0F, 0.0F, -6.0F, 6, 3, 1, 0.0F, false));
        this.beard = new MModelRenderer(this);
        this.beard.cubeList.add(new ModelBox(this.beard, 0, 14, -4.0F, -9.0F, 4.0F, 8, 2, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 0, 14, -4.0F, -9.0F, -5.0F, 8, 2, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 6, 4, -3.0F, -11.0F, -4.0F, 6, 2, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 6, 4, -3.0F, -11.0F, 3.0F, 6, 2, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 10, 7, 4.0F, -9.0F, -4.0F, 1, 2, 8, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 0, 4, 3.0F, -11.0F, -4.0F, 1, 2, 8, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 2, 0, -3.0F, -12.0F, -3.0F, 6, 1, 6, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 0, 0, -4.0F, -11.0F, -4.0F, 1, 2, 8, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 10, 7, -5.0F, -9.0F, -4.0F, 1, 2, 8, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 14, 0, 3.0F, -12.0F, 1.0F, 1, 1, 2, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 0, 8, 2.5F, -12.0F, 0.5F, 1, 1, 1, -0.001F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 9, 3, 0.5F, -12.0F, 2.5F, 1, 1, 1, -0.001F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 2, 8, 2.5F, -11.6F, 2.5F, 1, 1, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 4, 8, 3.5F, -10.0F, 3.5F, 1, 1, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 0, 8, 4.5F, -8.0F, 4.5F, 1, 1, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 8, 2, 1.0F, -12.0F, 3.0F, 2, 1, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 14, 0, 4.0F, -11.0F, 2.0F, 1, 2, 2, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 11, 8, 3.5F, -11.0F, 1.5F, 1, 2, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 11, 4, 1.5F, -11.0F, 3.5F, 1, 2, 1, -0.001F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 10, 2, 2.0F, -11.0F, 4.0F, 2, 2, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 14, 0, 3.0F, -9.0F, 5.0F, 2, 3, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 8, 2, 2.5F, -9.0F, 4.5F, 1, 2, 1, -0.001F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 15, 0, 4.5F, -9.0F, 2.5F, 1, 2, 1, -0.001F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 10, 2, 5.0F, -9.0F, 3.0F, 1, 3, 2, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 11, 4, 4.0F, -9.0F, 4.0F, 1, 4, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 10, 7, 4.5F, -7.0F, 5.0F, 2, 3, 1, -0.001F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 8, 0, 5.0F, -7.0F, 4.5F, 1, 3, 2, -0.003F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 0, 0, 4.0F, -4.0F, 4.5F, 1, 2, 2, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 0, 0, 6.0F, -4.0F, 4.5F, 1, 2, 2, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 0, 0, 4.5F, -4.0F, 4.0F, 2, 2, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 0, 0, 4.5F, -4.0F, 6.0F, 2, 2, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 0, 1, 4.5F, -2.5F, 4.5F, 2, 1, 2, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 0, 0, 4.5F, -4.5F, 4.5F, 2, 1, 2, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 12, 14, 3.5F, -9.0F, -4.5F, 1, 2, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 13, 14, -4.5F, -9.0F, -4.5F, 1, 2, 1, 0.0F, false));
        this.beard.cubeList.add(new ModelBox(this.beard, 8, 14, -4.5F, -9.0F, 3.5F, 1, 2, 1, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "head/santa_hat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.01F, 1.0F, 1.005F);
        this.beard.isHidden = player.getCurrentArmor(3) != null;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
        this.beard.isHidden = false;
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u0430\u043d\u0442\u0430";
    }
}
