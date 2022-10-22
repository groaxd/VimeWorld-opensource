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

public class RainbowDrool extends BaseItem
{
    private final MModelRenderer Piece1;

    public RainbowDrool()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape1", 0, 5);
        this.setTextureOffset("Piece1.Shape2", 2, 9);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 16, 0);
        this.setTextureOffset("Piece1.Shape11", 21, 0);
        this.setTextureOffset("Piece1.Shape12", 26, 0);
        this.setTextureOffset("Piece1.Shape13", 16, 6);
        this.setTextureOffset("Piece1.Shape14", 21, 6);
        this.setTextureOffset("Piece1.Shape15", 26, 6);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.Piece1.addBox("Shape1", -3.0F, 2.0F, -1.0F, 6, 2, 1);
        this.Piece1.addBox("Shape2", -2.0F, 1.0F, -1.0F, 4, 1, 1);
        this.Piece1.addBox("Shape3", -4.0F, -2.75F, -1.0F, 3, 3, 1);
        this.Piece1.addBox("Shape4", 1.0F, -2.75F, -1.0F, 3, 3, 1);
        this.Piece1.addBox("Shape9", -3.0F, 3.0F, -2.0F, 1, 2, 1);
        this.Piece1.addBox("Shape11", -2.0F, 2.0F, -2.0F, 1, 4, 1);
        this.Piece1.addBox("Shape12", -1.0F, 2.0F, -2.0F, 1, 4, 1);
        this.Piece1.addBox("Shape13", 0.0F, 2.0F, -2.0F, 1, 5, 1);
        this.Piece1.addBox("Shape14", 1.0F, 2.0F, -2.0F, 1, 4, 1);
        this.Piece1.addBox("Shape15", 2.0F, 3.0F, -2.0F, 1, 2, 1);
        this.setTexture(new ResourceLocation("minidot", "head/rainbow_drool.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
        GlStateManager.translate(0.0F, -0.2F, 0.3F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0420\u0430\u0434\u0443\u0436\u043d\u044b\u0435 \u0441\u043b\u044e\u043d\u0438";
    }
}
