package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HelmetFlash extends BaseHelm
{
    private final MModelRenderer Helm;
    private final MModelRenderer Ears;
    private final MModelRenderer EarsAngle;

    public HelmetFlash()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Helm = new MModelRenderer(this);
        this.Helm.cubeList.add(new ModelBox(this.Helm, 0, 0, 4.0F, -2.0F, -4.0F, 1, 2, 8, 0.0F, true));
        this.Helm.cubeList.add(new ModelBox(this.Helm, 0, 0, -5.0F, -2.0F, -4.0F, 1, 2, 8, 0.0F, true));
        this.Helm.cubeList.add(new ModelBox(this.Helm, 0, 0, -4.0F, -8.0F, -5.0F, 8, 4, 1, 0.0F, true));
        this.Helm.cubeList.add(new ModelBox(this.Helm, 0, 0, -4.0F, -3.0F, -5.0F, 3, 1, 1, 0.0F, true));
        this.Helm.cubeList.add(new ModelBox(this.Helm, 0, 0, -1.0F, -4.0F, -5.0F, 2, 1, 1, 0.0F, true));
        this.Helm.cubeList.add(new ModelBox(this.Helm, 0, 0, 1.0F, -3.0F, -5.0F, 3, 1, 1, 0.0F, true));
        this.Helm.cubeList.add(new ModelBox(this.Helm, 0, 0, -5.0F, -8.0F, -4.0F, 1, 5, 8, 0.0F, true));
        this.Helm.cubeList.add(new ModelBox(this.Helm, 0, 0, 4.0F, -3.0F, -3.0F, 1, 1, 7, 0.0F, true));
        this.Helm.cubeList.add(new ModelBox(this.Helm, 0, 0, 4.0F, -8.0F, -4.0F, 1, 5, 8, 0.0F, true));
        this.Helm.cubeList.add(new ModelBox(this.Helm, 0, 0, 3.0F, -4.0F, -5.0F, 1, 1, 1, 0.0F, true));
        this.Helm.cubeList.add(new ModelBox(this.Helm, 0, 0, -4.0F, -4.0F, -5.0F, 1, 1, 1, 0.0F, true));
        this.Helm.cubeList.add(new ModelBox(this.Helm, 0, 0, -4.0F, -1.0F, -5.0F, 8, 1, 1, 0.0F, true));
        this.Helm.cubeList.add(new ModelBox(this.Helm, 0, 0, -4.0F, -9.0F, -4.0F, 8, 1, 8, 0.0F, true));
        this.Helm.cubeList.add(new ModelBox(this.Helm, 0, 0, -4.0F, -8.0F, 4.0F, 8, 8, 1, 0.0F, true));
        this.Helm.cubeList.add(new ModelBox(this.Helm, 0, 0, -5.0F, -3.0F, -3.0F, 1, 1, 7, 0.0F, true));
        this.Ears = new MModelRenderer(this);
        this.Ears.cubeList.add(new ModelBox(this.Ears, 25, 0, 4.5F, -6.0F, 0.0F, 1, 1, 2, 0.0F, true));
        this.Ears.cubeList.add(new ModelBox(this.Ears, 25, 0, 4.5F, -3.0F, 0.0F, 1, 1, 2, 0.0F, true));
        this.Ears.cubeList.add(new ModelBox(this.Ears, 25, 0, 4.5F, -5.0F, -1.0F, 1, 2, 1, 0.0F, true));
        this.Ears.cubeList.add(new ModelBox(this.Ears, 25, 0, 4.5F, -5.0F, 2.0F, 1, 2, 1, 0.0F, true));
        this.Ears.cubeList.add(new ModelBox(this.Ears, 25, 0, -5.5F, -5.0F, -1.0F, 1, 2, 1, 0.0F, true));
        this.Ears.cubeList.add(new ModelBox(this.Ears, 25, 0, -5.5F, -5.0F, 2.0F, 1, 2, 1, 0.0F, true));
        this.Ears.cubeList.add(new ModelBox(this.Ears, 25, 0, -5.5F, -6.0F, 0.0F, 1, 1, 2, 0.0F, true));
        this.Ears.cubeList.add(new ModelBox(this.Ears, 25, 0, -5.5F, -3.0F, 0.0F, 1, 1, 2, 0.0F, true));
        this.EarsAngle = new MModelRenderer(this);
        this.setRotation(this.EarsAngle, 0.4189F, 0.0F, 0.0F);
        this.EarsAngle.cubeList.add(new ModelBox(this.EarsAngle, 25, 0, 5.5F, -3.8F, 2.0F, 1, 1, 2, 0.0F, true));
        this.EarsAngle.cubeList.add(new ModelBox(this.EarsAngle, 25, 0, 5.5F, -5.8F, 4.0F, 1, 1, 2, 0.0F, true));
        this.EarsAngle.cubeList.add(new ModelBox(this.EarsAngle, 25, 0, 5.5F, -4.8F, 3.0F, 1, 1, 2, 0.0F, true));
        this.EarsAngle.cubeList.add(new ModelBox(this.EarsAngle, 25, 0, -6.5F, -3.8F, 2.0F, 1, 1, 2, 0.0F, true));
        this.EarsAngle.cubeList.add(new ModelBox(this.EarsAngle, 25, 0, -6.5F, -4.8F, 3.0F, 1, 1, 2, 0.0F, true));
        this.EarsAngle.cubeList.add(new ModelBox(this.EarsAngle, 25, 0, -6.5F, -5.8F, 4.0F, 1, 1, 2, 0.0F, true));
        this.setTexture(new ResourceLocation("minidot", "head/helmet_flash.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "Veltorn";
    }

    public String getName()
    {
        return "\u0428\u043b\u0435\u043c \u0424\u043b\u044d\u0448\u0430";
    }
}
