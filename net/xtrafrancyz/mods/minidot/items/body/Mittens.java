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

public class Mittens extends BaseItem
{
    private final MModelRenderer bone;

    public Mittens()
    {
        super(ItemType.BODY);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.bone.cubeList.add(new ModelBox(this.bone, 7, 9, 1.0F, -14.0F, -0.75F, 1, 1, 1, -0.1001F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 3, -3.25F, -12.0F, -0.75F, 1, 1, 1, -0.1001F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 9, 2.25F, -12.0F, -0.75F, 1, 1, 1, -0.1001F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 6, -3.0F, -13.75F, -1.0F, 1, 2, 1, -0.1005F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -3.5F, -13.75F, -1.0F, 1, 2, 1, -0.1F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 15, 5, 2.5F, -13.75F, -1.0F, 1, 2, 1, -0.1005F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 17, 2, 2.0F, -13.75F, -1.0F, 1, 2, 1, -0.1F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 10, 13, 1.75F, -14.25F, -0.75F, 2, 3, 1, -0.1F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 16, 8, -2.0F, -14.0F, -0.75F, 1, 1, 1, -0.1001F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 10, 10, -4.25F, -15.0F, -1.25F, 3, 1, 2, -0.3001F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 12, -4.25F, -14.75F, -1.25F, 3, 1, 2, -0.3F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 7, 2, 1.25F, -15.0F, -1.25F, 3, 1, 2, -0.3001F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 7, 6, 1.25F, -14.75F, -1.25F, 3, 1, 2, -0.3F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 15, -3.75F, -14.25F, -0.75F, 2, 3, 1, -0.1F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 6, 15, -3.25F, -18.5F, -0.5F, 1, 5, 1, -0.3F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 16, 13, 2.25F, -18.5F, -0.5F, 1, 5, 1, -0.3F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 7, 0, -3.0F, -18.5F, 3.5F, 6, 1, 1, -0.3F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, 2.25F, -18.5F, -0.5F, 1, 1, 5, -0.3001F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 6, -3.25F, -18.5F, -0.5F, 1, 1, 5, -0.3001F, false));
        super.setTexture(new ResourceLocation("minidot", "body/mittens.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 1.65D, 0.6D);
        double d0 = 1.7D;
        GlStateManager.scale(d0, d0, d0);
        super.renderAsItem(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, 1.11D, 0.0D);

        if (player.inventory.armorItemInSlot(2) != null)
        {
            GlStateManager.scale(1.4F, 1.4F, 1.4F);
            GlStateManager.translate(0.0D, 0.32D, 0.0D);
        }
    }

    public String getName()
    {
        return "\u0412\u0430\u0440\u0435\u0436\u043a\u0438";
    }

    public String getCreator()
    {
        return "Florina";
    }
}
