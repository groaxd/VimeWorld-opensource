package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Scythe extends BaseItem
{
    private final MModelRenderer scythe;

    public Scythe()
    {
        super(ItemType.BODY);
        this.textureWidth = 48;
        this.textureHeight = 48;
        this.scythe = new MModelRenderer(this);
        this.scythe.setRotationPoint(-6.0F, 18.1F, 2.6F);
        this.setRotation(this.scythe, 0.0F, 0.0F, -2.4784F);
        this.scythe.setTextureOffset(0, 16).addBox(0.0F, 2.1F, -4.0F, 2, 25, 2, -0.6F);
        this.scythe.setTextureOffset(0, 7).addBox(-0.5F, 0.7F, -4.5F, 3, 3, 3, -1.0F);
        this.scythe.setTextureOffset(0, 0).addBox(-0.5F, 22.2F, -4.5F, 3, 4, 3, -0.9F);
        this.scythe.setTextureOffset(0, 7).addBox(-0.5F, 24.4F, -4.5F, 3, 6, 3, -0.8F);
        this.scythe.setTextureOffset(12, 5).addBox(-11.0812F, 25.2606F, -4.5F, 8, 2, 3, -1.4F);
        this.scythe.setTextureOffset(10, 43).addBox(-10.4794F, 26.0593F, -4.5F, 16, 2, 3, -1.4F);
        this.scythe.setTextureOffset(12, 38).addBox(-9.6776F, 26.8579F, -4.5F, 15, 2, 3, -1.4F);
        this.scythe.setTextureOffset(8, 23).addBox(-2.0812F, 25.2606F, -4.5F, 7, 2, 3, -1.4F);
        this.scythe.setTextureOffset(8, 17).addBox(-7.8803F, 27.6579F, -4.5F, 13, 2, 3, -1.4F);
        this.scythe.setTextureOffset(12, 0).addBox(-11.1812F, 23.6606F, -4.5F, 2, 2, 3, -1.4F);
        this.scythe.setTextureOffset(26, 0).addBox(-11.9812F, 24.4606F, -4.5F, 7, 2, 3, -1.4F);
        this.scythe.setTextureOffset(8, 28).addBox(1.5606F, 23.9801F, -4.5F, 4, 7, 3, -1.35F);
        this.setTexture(new ResourceLocation("minidot", "body/scythe.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(-0.1F, 0.0F, 0.2F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(195.0F + MathHelper.cos(rotation * 0.07F + (float)number) * 10.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(-0.2F, 0.1F, 0.3F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u043e\u0441\u0430 \u0441\u043c\u0435\u0440\u0442\u0438";
    }

    public String getCreator()
    {
        return "Kilyandra";
    }
}
