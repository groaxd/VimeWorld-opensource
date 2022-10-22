package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HelicopterHat extends BaseItem
{
    private final MModelRenderer Hat;
    private final MModelRenderer Shape4;
    private final MModelRenderer Shape5;

    public HelicopterHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Hat.Shape1", 2, 17);
        this.setTextureOffset("Hat.Shape2", 0, 0);
        this.setTextureOffset("Hat.Shape3", 7, 19);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -0.5F, -13.5F, -0.5F, 1, 4, 1);
        this.Hat.addBox("Shape2", -4.0F, -10.5F, -4.0F, 8, 2, 8);
        this.Hat.addBox("Shape3", -4.5F, -9.0F, -4.5F, 9, 2, 9);
        this.Shape4 = new MModelRenderer(this, 1, 23);
        this.Shape4.addBox(-3.0F, 0.0F, -0.5F, 6, 1, 1);
        this.Shape4.setRotationPoint(0.0F, -13.3F, 0.0F);
        this.setRotation(this.Shape4, 0.0F, -0.1570796F, -0.0174533F);
        this.Shape5 = new MModelRenderer(this, 1, 23);
        this.Shape5.addBox(-3.0F, 0.0F, -0.5F, 6, 1, 1);
        this.Shape5.setRotationPoint(0.0F, -13.3F, 0.0F);
        this.setRotation(this.Shape5, 0.0F, 0.1570796F, -0.0174533F);

        for (MModelRenderer mmodelrenderer : this.getAllModels())
        {
            mmodelrenderer.setDynamic(true);
        }

        this.recollectModels();
        this.setTexture(new ResourceLocation("minidot", "head/helicopterhat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.001F, 1.001F, 1.001F);
        this.Shape4.rotationY = time * 0.4F;
        this.Shape5.rotationY = time * 0.4F;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.25F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u0430\u043f\u043a\u0430-\u0432\u0435\u0440\u0442\u043e\u043b\u0435\u0442";
    }
}
