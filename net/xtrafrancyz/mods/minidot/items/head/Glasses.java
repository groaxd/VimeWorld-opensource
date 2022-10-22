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

public class Glasses extends BaseItem
{
    private final MModelRenderer Piece1;

    public Glasses()
    {
        super(ItemType.HEAD);
        this.textureWidth = 8;
        this.textureHeight = 8;
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 0, 3);
        this.setTextureOffset("Piece1.Shape10", 0, 3);
        this.setTextureOffset("Piece1.Shape11", 0, 3);
        this.setTextureOffset("Piece1.Shape12", 0, 3);
        this.setTextureOffset("Piece1.Shape13", 0, 3);
        this.setTextureOffset("Piece1.Shape14", 0, 3);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.addBox("Shape2", -1.0F, -2.0F, -1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape3", -2.0F, -3.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape4", 1.0F, -3.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape5", -5.0F, -3.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape6", 4.0F, -3.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape7", -4.0F, -4.0F, -1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape8", 2.0F, -4.0F, -1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape9", -4.0F, -3.0F, -1.0F, 2, 4, 1);
        this.Piece1.addBox("Shape10", 2.0F, -3.0F, -1.0F, 2, 4, 1);
        this.Piece1.addBox("Shape11", -2.0F, -2.0F, -1.0F, 1, 2, 1);
        this.Piece1.addBox("Shape12", -5.0F, -2.0F, -1.0F, 1, 2, 1);
        this.Piece1.addBox("Shape13", 4.0F, -2.0F, -1.0F, 1, 2, 1);
        this.Piece1.addBox("Shape14", 1.0F, -2.0F, -1.0F, 1, 2, 1);
        this.setTexture(new ResourceLocation("minidot", "head/glasses_1.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.04F, 0.0F);
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
        return "\u041e\u0447\u043a\u0438";
    }
}
