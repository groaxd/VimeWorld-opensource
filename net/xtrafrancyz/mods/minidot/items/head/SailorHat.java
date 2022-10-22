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

public class SailorHat extends BaseItem
{
    private final MModelRenderer bb_main;

    public SailorHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bb_main = new MModelRenderer(this);
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 0, -3.0F, -10.0F, -3.0F, 6, 2, 6, 0.0F, false));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 8, -3.0F, -10.1F, -3.0F, 6, 1, 6, 0.23F, false));
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 15, -1.0F, -11.1F, -1.0F, 2, 2, 2, 0.1F, false));
        super.setTexture(new ResourceLocation("minidot", "head/sailorhat.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.25F, 0.0F);
        super.renderAsItem(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.17F, 0.0F);
        float f = 1.3F;
        GlStateManager.scale(f, f, f);
    }

    public String getName()
    {
        return "\u0428\u0430\u043f\u043a\u0430 \u043c\u043e\u0440\u044f\u043a\u0430";
    }

    public String getCreator()
    {
        return "F1_KLa4";
    }
}
