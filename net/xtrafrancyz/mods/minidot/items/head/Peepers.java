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

public class Peepers extends BaseItem
{
    private final MModelRenderer Piece1;

    public Peepers()
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape2", 0, 6);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 14);
        this.setTextureOffset("Piece1.Shape5", 0, 12);
        this.setTextureOffset("Piece1.Shape6", 0, 12);
        this.setTextureOffset("Piece1.Shape7", 0, 14);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, -4.0F, -5.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.addBox("Shape2", -5.0F, -4.0F, -1.0F, 4, 4, 1);
        this.Piece1.addBox("Shape3", 1.0F, -4.0F, -1.0F, 4, 4, 1);
        this.Piece1.addBox("Shape4", 2.0F, -5.0F, -1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape5", 2.0F, 0.0F, -1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape6", -4.0F, 0.0F, -1.0F, 2, 1, 1);
        this.Piece1.addBox("Shape7", -4.0F, -5.0F, -1.0F, 2, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "head/peepers.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, 0.07F, 0.0F);
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
        return "\u0413\u043b\u0430\u0437\u0430";
    }
}
