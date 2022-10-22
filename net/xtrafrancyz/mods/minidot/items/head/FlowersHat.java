package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class FlowersHat extends BaseItem
{
    private final MModelRenderer F1;
    private final MModelRenderer F2;
    private final MModelRenderer F3;

    public FlowersHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("F1.Shape1", 0, 0);
        this.setTextureOffset("F1.Shape11", 27, 4);
        this.setTextureOffset("F2.Shape2", 0, 0);
        this.setTextureOffset("F2.Shape21", 27, 11);
        this.setTextureOffset("F3.Shape3", 0, 0);
        this.setTextureOffset("F3.Shape31", 27, 0);
        this.F1 = new MModelRenderer(this, "F1");
        this.F1.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.F1, 0.0F, 0.0F, 0.3316126F);
        this.F1.addBox("Shape1", 1.5F, -5.3F, -1.0F, 1, 5, 1);
        this.F1.addBox("Shape11", 0.5F, -7.3F, -1.1F, 3, 3, 1);
        this.F1.setDynamic(true);
        this.F2 = new MModelRenderer(this, "F2");
        this.F2.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.F2, 0.0F, 0.0F, -0.122173F);
        this.F2.addBox("Shape2", -2.0F, -4.0F, 0.1F, 1, 5, 1);
        this.F2.addBox("Shape21", -3.0F, -6.0F, 0.0F, 3, 3, 1);
        this.F2.setDynamic(true);
        this.F3 = new MModelRenderer(this, "F3");
        this.F3.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.setRotation(this.F3, 0.0F, 0.0F, 0.1396263F);
        this.F3.addBox("Shape3", 0.0F, -5.0F, 1.1F, 1, 5, 1);
        this.F3.addBox("Shape31", -1.0F, -7.0F, 1.0F, 3, 3, 1);
        this.F3.setDynamic(true);
        this.setTexture(new ResourceLocation("minidot", "head/flowershat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.F3.rotationZ = MathHelper.cos(time * 0.03F) * 0.06F - 0.02F;
        this.F2.rotationZ = MathHelper.sin(time * 0.05F) * 0.04F - 0.01F;
        this.F1.rotationZ = MathHelper.sin(time * 0.03F) * 0.02F - 0.04F;
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.25F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0426\u0432\u0435\u0442\u044b";
    }
}
