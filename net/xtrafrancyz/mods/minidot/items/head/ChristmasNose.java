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

public class ChristmasNose extends BaseItem
{
    private final MModelRenderer Shape1;
    private final MModelRenderer Shape2;

    public ChristmasNose()
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.Shape1 = new MModelRenderer(this, 0, 0);
        this.Shape1.addBox(-1.5F, -5.5F, -6.0F, 3, 3, 1);
        this.Shape2 = new MModelRenderer(this, 0, 4);
        this.Shape2.addBox(-2.0F, -6.0F, -6.5F, 4, 4, 2);
        this.setTexture(new ResourceLocation("minidot", "head/christmas_nose.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.setModelRotation(modelPlayer.bipedHead);

        if (modelPlayer.isSneak)
        {
            GlStateManager.translate(0.0F, 0.27F, 0.0F);
        }

        this.setRotationAngles(this.rotateX, this.rotateY, this.rotateZ);
        GlStateManager.scale(0.4F, 0.4F, 0.8F);
        GlStateManager.translate(0.0F, -0.2F, 0.0F);

        if (player.getCurrentArmor(3) != null)
        {
            GlStateManager.scale(1.12F, 1.12F, 0.9F);
        }

        this.Shape2.isHidden = time % 30.0F > 10.0F;
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.enableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8F);
        GlStateManager.translate(0.0F, -0.2F, 0.24F);
        super.renderAsItem(time);
        GlStateManager.disableBlend();
    }

    public String getName()
    {
        return "\u041d\u043e\u0432\u043e\u0433\u043e\u0434\u043d\u0438\u0439 \u043d\u043e\u0441";
    }
}
