package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class IceHat extends BaseItem
{
    private final MModelRenderer Shape1;

    public IceHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.Shape1 = new MModelRenderer(this, 0, 0);
        this.Shape1.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
        this.setTexture(new ResourceLocation("minidot", "head/icehat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.025F, 0.0F);

        if (player.getCurrentArmor(3) != null)
        {
            GlStateManager.scale(1.04F, 1.04F, 1.04F);
        }
        else
        {
            GlStateManager.scale(1.15F, 1.15F, 1.15F);
        }
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.08F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0411\u043b\u043e\u043a \u043b\u044c\u0434\u0430";
    }
}
