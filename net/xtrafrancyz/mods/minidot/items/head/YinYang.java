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

public class YinYang extends BaseItem
{
    private final MModelRenderer Piece1;

    public YinYang()
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape6", 7, 3);
        this.setTextureOffset("Piece1.Shape7", 0, 7);
        this.setTextureOffset("Piece1.Shape8", 7, 3);
        this.setTextureOffset("Piece1.Shape9", 4, 11);
        this.setTextureOffset("Piece1.Shape10", 7, 3);
        this.setTextureOffset("Piece1.Shape11", 0, 0);
        this.setTextureOffset("Piece1.Shape12", 0, 3);
        this.setTextureOffset("Piece1.Shape13", 0, 0);
        this.setTextureOffset("Piece1.Shape14", 0, 0);
        this.setTextureOffset("Piece1.Shape15", 0, 0);
        this.setTextureOffset("Piece1.Shape16", 6, 3);
        this.setTextureOffset("Piece1.Shape17", 7, 3);
        this.setTextureOffset("Piece1.Shape18", 7, 3);
        this.setTextureOffset("Piece1.Shape19", 7, 3);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.addBox("Shape2", -2.0F, 3.0F, -1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape3", -5.0F, 1.0F, -1.0F, 3, 1, 1);
        this.Piece1.addBox("Shape4", -4.0F, 2.0F, -1.0F, 3, 1, 1);
        this.Piece1.addBox("Shape5", -5.0F, 0.0F, -1.0F, 4, 1, 1);
        this.Piece1.addBox("Shape6", 0.0F, -2.0F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape7", 2.0F, -2.0F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape8", 4.0F, -2.0F, -1.0F, 1, 2, 1);
        this.Piece1.addBox("Shape9", 0.0F, 0.0F, -1.0F, 5, 1, 1);
        this.Piece1.addBox("Shape10", 1.0F, 1.0F, -1.0F, 3, 1, 1);
        this.Piece1.addBox("Shape11", -2.0F, -2.0F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape12", -4.0F, -2.0F, -1.0F, 2, 2, 1);
        this.Piece1.addBox("Shape13", -5.0F, -2.0F, -1.0F, 1, 2, 1);
        this.Piece1.addBox("Shape14", -5.0F, -3.0F, -1.0F, 5, 1, 1);
        this.Piece1.addBox("Shape15", -4.0F, -4.0F, -1.0F, 3, 1, 1);
        this.Piece1.addBox("Shape16", 1.0F, -3.0F, -1.0F, 4, 1, 1);
        this.Piece1.addBox("Shape17", 2.0F, -4.0F, -1.0F, 3, 1, 1);
        this.Piece1.addBox("Shape18", 1.0F, -5.0F, -1.0F, 3, 1, 1);
        this.Piece1.addBox("Shape19", 0.0F, -6.0F, -1.0F, 2, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "head/yinyang.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
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
        return "\u0418\u043d\u044c \u0438 \u042f\u043d\u044c";
    }
}
