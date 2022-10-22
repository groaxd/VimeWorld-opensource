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

public class DealWithItHat extends BaseItem
{
    private final MModelRenderer Piece1;

    public DealWithItHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Boss0", 0, 6);
        this.setTextureOffset("Piece1.Boss1", 0, 4);
        this.setTextureOffset("Piece1.Boss2", 0, 2);
        this.setTextureOffset("Piece1.Boss3", 0, 4);
        this.setTextureOffset("Piece1.Boss4", 0, 2);
        this.setTextureOffset("Piece1.Boss5", 0, 8);
        this.setTextureOffset("Piece1.Boss6", 0, 0);
        this.setTextureOffset("Piece1.Boss7", 0, 8);
        this.setTextureOffset("Piece1.Boss8", 0, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.mirror = true;
        this.Piece1.addBox("Boss0", -5.0F, -4.0F, -5.0F, 10, 1, 1);
        this.Piece1.addBox("Boss1", -4.0F, -3.5F, -5.0F, 3, 1, 1);
        this.Piece1.addBox("Boss2", -3.5F, -3.0F, -5.0F, 2, 1, 1);
        this.Piece1.addBox("Boss3", 1.0F, -3.5F, -5.0F, 3, 1, 1);
        this.Piece1.addBox("Boss4", 1.5F, -3.0F, -5.0F, 2, 1, 1);
        this.Piece1.addBox("Boss5", -5.0F, -4.0F, -4.0F, 1, 1, 6);
        this.Piece1.addBox("Boss6", -5.0F, -3.0F, 1.0F, 1, 1, 1);
        this.Piece1.addBox("Boss7", 4.0F, -4.0F, -4.0F, 1, 1, 6);
        this.Piece1.addBox("Boss8", 4.0F, -3.0F, 1.0F, 1, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "head/deal_with_it.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.01F, 1.0F, 1.0F);
        GlStateManager.translate(0.0F, -0.03F, 0.02F);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.04F + (float)number) * 30.0F, 0.0F, 0.2F, 0.0F);
        GlStateManager.translate(0.0F, -0.17F, 0.0F);
    }

    public String getCreator()
    {
        return "_Mik_";
    }

    public String getName()
    {
        return "Deal With It";
    }
}
