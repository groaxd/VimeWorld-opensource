package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskGuards extends BaseItem
{
    private final MModelRenderer Piece1;

    public MaskGuards()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 9);
        this.setTextureOffset("Piece1.Shape4", 0, 9);
        this.setTextureOffset("Piece1.Shape5", 0, 9);
        this.setTextureOffset("Piece1.Shape6", 0, 13);
        this.setTextureOffset("Piece1.Shape7", 0, 13);
        this.setTextureOffset("Piece1.Shape8", 0, 9);
        this.setTextureOffset("Piece1.Shape9", 0, 9);
        this.setTextureOffset("Piece1.Shape10", 0, 9);
        this.setTextureOffset("Piece1.Shape11", 0, 9);
        this.setTextureOffset("Piece1.Shape12", 22, 3);
        this.setTextureOffset("Piece1.Shape13", 22, 3);
        this.setTextureOffset("Piece1.Shape14", 22, 5);
        this.setTextureOffset("Piece1.Shape15", 0, 9);
        this.setTextureOffset("Piece1.Shape16", 22, 0);
        this.setTextureOffset("Piece1.Shape17", 22, 0);
        this.setTextureOffset("Piece1.Shape18", 22, 0);
        this.setTextureOffset("Piece1.Shape19", 22, 0);
        this.setTextureOffset("Piece1.Shape20", 22, 0);
        this.setTextureOffset("Piece1.Shape21", 22, 0);
        this.setTextureOffset("Piece1.Shape22", 22, 0);
        this.setTextureOffset("Piece1.Shape23", 22, 0);
        this.setTextureOffset("Piece1.Shape24", 0, 9);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.addBox("Shape2", -5.0F, -5.0F, -1.0F, 10, 8, 1);
        this.Piece1.addBox("Shape3", -4.0F, -6.0F, -1.0F, 8, 1, 1);
        this.Piece1.addBox("Shape4", -4.0F, 3.0F, -1.0F, 8, 1, 1);
        this.Piece1.addBox("Shape5", -4.0F, -5.0F, -2.0F, 8, 1, 1);
        this.Piece1.addBox("Shape6", -3.0F, -4.0F, -2.0F, 2, 2, 1);
        this.Piece1.addBox("Shape7", 1.0F, -4.0F, -2.0F, 2, 2, 1);
        this.Piece1.addBox("Shape8", 4.0F, -4.0F, -2.0F, 1, 2, 1);
        this.Piece1.addBox("Shape9", -5.0F, -4.0F, -2.0F, 1, 2, 1);
        this.Piece1.addBox("Shape10", -4.0F, -2.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape11", 3.0F, -2.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape12", -1.0F, -2.0F, -2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape13", -1.0F, 3.0F, -2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape14", -2.0F, -1.0F, -2.0F, 4, 4, 1);
        this.Piece1.addBox("Shape15", 2.0F, -1.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape16", 4.0F, 0.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape17", 3.0F, 1.0F, -2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape18", 2.0F, 2.0F, -2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape19", 1.0F, 3.0F, -2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape20", -3.0F, 3.0F, -2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape21", -4.0F, 2.0F, -2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape22", -5.0F, 1.0F, -2.0F, 2, 1, 1);
        this.Piece1.addBox("Shape23", -5.0F, 0.0F, -2.0F, 1, 1, 1);
        this.Piece1.addBox("Shape24", -3.0F, -1.0F, -2.0F, 1, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "masks/3d_guards.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 1.0F);
        GlStateManager.translate(0.0F, 0.0F, 0.05F);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.1F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u0421\u0442\u0440\u0430\u0436\u0430 \u0433\u0430\u043b\u0430\u043a\u0442\u0438\u043a\u0438";
    }
}
