package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ChristmasHat extends BaseItem
{
    private final MModelRenderer Piece1;

    public ChristmasHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Piece1.Shape1", 0, 18);
        this.setTextureOffset("Piece1.Shape2", 0, 19);
        this.setTextureOffset("Piece1.Shape3", 0, 19);
        this.setTextureOffset("Piece1.Shape4", 1, 20);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 0, 0);
        this.setTextureOffset("Piece1.Shape10", 0, 0);
        this.setTextureOffset("Piece1.Shape11", 0, 0);
        this.setTextureOffset("Piece1.Shape12", 0, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.mirror = true;
        this.Piece1.addBox("Shape1", -4.5F, -9.0F, -4.0F, 9, 1, 9);
        this.Piece1.addBox("Shape2", 4.0F, -8.0F, -4.0F, 1, 1, 7);
        this.Piece1.addBox("Shape3", -5.0F, -8.0F, -4.0F, 1, 1, 7);
        this.Piece1.addBox("Shape4", -5.0F, -8.0F, 2.5F, 10, 3, 3);
        this.Piece1.addBox("Shape5", 4.01F, -7.0F, -3.0F, 1, 3, 6);
        this.Piece1.addBox("Shape6", 4.01F, -4.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape7", 4.01F, -3.0F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("Shape8", -5.01F, -7.0F, -3.0F, 1, 3, 6);
        this.Piece1.addBox("Shape9", -5.01F, -4.0F, -2.0F, 1, 1, 4);
        this.Piece1.addBox("Shape10", -5.01F, -3.0F, -1.0F, 1, 1, 2);
        this.Piece1.addBox("Shape11", -5.5F, -8.5F, -6.0F, 11, 2, 2);
        this.Piece1.addBox("Shape12", -5.0F, -9.5F, -6.0F, 10, 1, 2);
        this.setTexture(new ResourceLocation("minidot", "head/christmashat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.0001F, 1.0F, 1.0001F);

        if (player.getCurrentArmor(3) != null)
        {
            GlStateManager.scale(1.12F, 1.12F, 1.12F);
        }
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.05F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041d\u043e\u0432\u043e\u0433\u043e\u0434\u043d\u044f\u044f \u0448\u0430\u043f\u043a\u0430";
    }
}
