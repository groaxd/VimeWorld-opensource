package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskChick extends BaseItem
{
    private final MModelRenderer Piece1;

    public MaskChick()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape2", 0, 21);
        this.setTextureOffset("Piece1.Shape11", 12, 3);
        this.setTextureOffset("Piece1.Shape13", 12, 3);
        this.setTextureOffset("Piece1.Shape14", 0, 12);
        this.setTextureOffset("Piece1.Shape15", 12, 3);
        this.setTextureOffset("Piece1.Shape16", 0, 12);
        this.setTextureOffset("Piece1.Shape24", 12, 3);
        this.setTextureOffset("Piece1.Shape23", 0, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.addBox("Shape2", -5.0F, -6.0F, -1.0F, 10, 10, 1);
        this.Piece1.addBox("Shape11", -2.0F, 3.0F, -2.0F, 4, 1, 1);
        this.Piece1.addBox("Shape13", -5.0F, -3.0F, -2.0F, 1, 4, 1);
        this.Piece1.addBox("Shape14", -1.0F, 1.0F, -3.0F, 2, 2, 1);
        this.Piece1.addBox("Shape15", 4.0F, -3.0F, -2.0F, 1, 4, 1);
        this.Piece1.addBox("Shape16", -1.0F, 1.0F, -4.0F, 2, 1, 1);
        this.Piece1.addBox("Shape24", -2.0F, -6.0F, -2.0F, 4, 1, 1);
        this.Piece1.addBox("Shape23", -4.0F, -5.0F, -2.0F, 8, 8, 1);
        this.setTexture(new ResourceLocation("minidot", "masks/3d_chick.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.1F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u0446\u044b\u043f\u043b\u0435\u043d\u043a\u0430";
    }

    public String getCreator()
    {
        return "ANACTAC";
    }
}
