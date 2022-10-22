package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Trident extends BaseItem
{
    private final MModelRenderer bone2;

    public Trident()
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-2.0F, -14.5F, 2.0F);
        this.setRotation(this.bone2, -1.5708F, 0.0F, 2.5307F);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 7, -4.0F, -1.0F, 10.0F, 1, 1, 3, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 5, -4.0F, -1.0F, 9.0F, 5, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 5, 7, -3.0F, -1.0F, 8.0F, 3, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -2.0F, -1.0F, -12.0F, 1, 1, 20, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 6, 0, 0.0F, -1.0F, 10.0F, 1, 1, 3, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -2.0F, -1.0F, 10.0F, 1, 1, 4, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "body/trident.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.95D, 0.225D);
        double d0 = 0.9207D;
        GlStateManager.scale(d0, d0, d0);
        super.renderAsItem(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 1.35F, 0.0F);
    }

    public String getName()
    {
        return "\u0422\u0440\u0435\u0437\u0443\u0431\u0435\u0446";
    }

    public String getCreator()
    {
        return "woors";
    }
}
