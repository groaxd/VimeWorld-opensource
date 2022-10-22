package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class IndianaJonesHat extends BaseItem
{
    private final MModelRenderer Hat;

    public IndianaJonesHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Hat.Shape1", 0, 11);
        this.setTextureOffset("Hat.Shape2", 0, 0);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -6.0F, -8.0F, -6.0F, 12, 1, 12);
        this.Hat.addBox("Shape2", -4.0F, -11.0F, -4.0F, 8, 3, 8);
        this.setTexture(new ResourceLocation("minidot", "head/indianajoneshat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.0F, 1.07F, 1.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.15F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u043b\u044f\u043f\u0430 \u0418\u043d\u0434\u0438\u0430\u043d\u044b \u0414\u0436\u043e\u043d\u0441\u0430";
    }
}
