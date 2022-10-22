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

public class SteepGlasses extends BaseItem
{
    private final MModelRenderer Piece1;

    public SteepGlasses()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 0, 0);
        this.setTextureOffset("Piece1.Shape10", 0, 5);
        this.setTextureOffset("Piece1.Shape11", 6, 5);
        this.setTextureOffset("Piece1.Shape12", 0, 5);
        this.setTextureOffset("Piece1.Shape13", 0, 5);
        this.setTextureOffset("Piece1.Shape14", 0, 5);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.addBox("Shape2", -4.0F, -4.0F, -1.0F, 8, 1, 1);
        this.Piece1.addBox("Shape3", -5.0F, -3.0F, -1.0F, 1, 3, 1);
        this.Piece1.addBox("Shape4", 4.0F, -3.0F, -1.0F, 1, 3, 1);
        this.Piece1.addBox("Shape5", 1.0F, -1.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape6", -4.0F, 0.0F, -1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape7", 2.0F, 0.0F, -1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape8", -1.0F, -2.0F, -1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape9", -2.0F, -1.0F, -1.0F, 1, 1, 1);
        this.Piece1.addBox("Shape10", -1.0F, -3.0F, -1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape11", -4.0F, -3.0F, -1.0F, 2, 3, 1);
        this.Piece1.addBox("Shape12", 2.0F, -3.0F, -1.0F, 2, 3, 1);
        this.Piece1.addBox("Shape13", 1.0F, -3.0F, -1.0F, 1, 2, 1);
        this.Piece1.addBox("Shape14", -2.0F, -3.0F, -1.0F, 1, 2, 1);
        this.setTexture(new ResourceLocation("minidot", "head/steep_glasses.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.03F, 0.0F);
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
        return "\u041a\u0440\u0443\u0442\u044b\u0435 \u043e\u0447\u043a\u0438";
    }
}
