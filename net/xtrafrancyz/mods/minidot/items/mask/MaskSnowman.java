package net.xtrafrancyz.mods.minidot.items.mask;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MaskSnowman extends BaseItem
{
    private final MModelRenderer Piece1;

    public MaskSnowman()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 19, 0);
        this.setTextureOffset("Piece1.Shape4", 19, 0);
        this.setTextureOffset("Piece1.Shape5", 1, 12);
        this.setTextureOffset("Piece1.Shape6", 0, 12);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.Piece1.addBox("Shape2", -4.0F, -6.0F, -1.0F, 8, 10, 1);
        this.Piece1.addBox("Shape3", 4.0F, -5.0F, -1.0F, 1, 8, 1);
        this.Piece1.addBox("Shape4", -5.0F, -5.0F, -1.0F, 1, 8, 1);
        this.Piece1.addBox("Shape5", -1.0F, -1.0F, -2.0F, 2, 2, 1);
        this.Piece1.addBox("Shape6", -1.0F, 0.0F, -4.0F, 2, 1, 2);
        this.setTexture(new ResourceLocation("minidot", "masks/3d_snowman.png"));
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
        return "\u041c\u0430\u0441\u043a\u0430 \u0421\u043d\u0435\u0433\u043e\u0432\u0438\u043a\u0430";
    }
}
