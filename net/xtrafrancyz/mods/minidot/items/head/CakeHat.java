package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class CakeHat extends BaseItem
{
    private final MModelRenderer Hat;

    public CakeHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Hat.Shape1", 0, 13);
        this.setTextureOffset("Hat.Shape2", 0, 0);
        this.setTextureOffset("Hat.Shape3", 28, 0);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -4.5F, -9.0F, -4.5F, 9, 2, 9);
        this.Hat.addBox("Shape2", -3.5F, -13.0F, -3.5F, 7, 4, 7);
        this.Hat.addBox("Shape3", -3.0F, -17.0F, -3.0F, 6, 4, 6);
        this.setTexture(new ResourceLocation("minidot", "head/cakehat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.0001F, 1.0F, 1.0001F);

        if (player.getCurrentArmor(3) != null)
        {
            GlStateManager.scale(1.04F, 1.0F, 1.04F);
        }
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.35F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u043b\u044f\u043f\u0430 \u0441 \u043a\u0435\u043a\u0441\u043e\u043c";
    }
}
