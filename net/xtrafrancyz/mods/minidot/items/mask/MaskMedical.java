package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskMedical extends BaseItem
{
    private final MModelRenderer bone2;

    public MaskMedical()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 0.0F, 0.1F);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -4.0F, -3.0F, -5.0F, 8, 3, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 0, -4.0F, -0.5F, -4.5F, 8, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 0, 3.5F, -3.0F, -4.5F, 1, 3, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 0, -4.5F, -3.0F, -4.5F, 1, 3, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 0, 4.2F, -3.0F, -3.5F, 0, 1, 5, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 0, -4.2F, -3.0F, -3.5F, 0, 1, 5, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 0, 4.2F, -2.0F, 0.5F, 0, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 0, -4.2F, -2.0F, 0.5F, 0, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 0, 4.2F, -1.5F, -1.5F, 0, 1, 2, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 0, -4.2F, -1.5F, -1.5F, 0, 1, 2, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 0, 4.2F, -1.0F, -3.5F, 0, 1, 2, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 0, -4.2F, -1.0F, -3.5F, 0, 1, 2, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "masks/mask_medical.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.1F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0435\u0434\u0438\u0446\u0438\u043d\u0441\u043a\u0430\u044f \u043c\u0430\u0441\u043a\u0430";
    }
}
