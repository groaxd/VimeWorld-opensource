package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskWeeping extends BaseItem
{
    private final MModelRenderer Shape2;

    public MaskWeeping()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.Shape2 = new MModelRenderer(this, 1, 1);
        this.Shape2.addBox(-5.0F, -6.0F, -1.0F, 10, 10, 1);
        this.Shape2.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.setTexture(new ResourceLocation("minidot", "masks/weeping.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.1F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u043f\u043b\u0430\u0447\u0443\u0449\u0435\u0433\u043e";
    }

    public String getCreator()
    {
        return "ThisDorry";
    }
}
