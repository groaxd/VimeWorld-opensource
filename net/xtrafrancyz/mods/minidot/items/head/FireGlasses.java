package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class FireGlasses extends BaseItem
{
    private final MModelRenderer glass;

    public FireGlasses()
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.glass = new MModelRenderer(this);
        this.glass.cubeList.add(new ModelBox(this.glass, 6, 0, -3.0F, -6.0F, -5.0F, 2, 4, 1, 0.0F, false));
        this.glass.cubeList.add(new ModelBox(this.glass, 0, 0, 1.0F, -6.0F, -5.0F, 2, 4, 1, 0.0F, false));
        this.glass.cubeList.add(new ModelBox(this.glass, 0, 10, -1.0F, -5.0F, -5.0F, 2, 2, 1, 0.0F, false));
        this.glass.cubeList.add(new ModelBox(this.glass, 4, 5, -4.0F, -7.0F, -5.0F, 1, 4, 1, 0.0F, false));
        this.glass.cubeList.add(new ModelBox(this.glass, 10, 10, -5.0F, -8.0F, -5.0F, 1, 3, 1, 0.0F, false));
        this.glass.cubeList.add(new ModelBox(this.glass, 6, 10, 4.0F, -8.0F, -5.0F, 1, 3, 1, 0.0F, false));
        this.glass.cubeList.add(new ModelBox(this.glass, 0, 5, 3.0F, -7.0F, -5.0F, 1, 4, 1, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "head/glasses_2.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, -0.04F, -0.055F);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.0F, 0.3F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041e\u0433\u043d\u0435\u043d\u043d\u044b\u0435 \u043e\u0447\u043a\u0438";
    }
}
