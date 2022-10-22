package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class LaserHat extends BaseItem
{
    private final MModelRenderer Piece1;
    private final MModelRenderer Shape14;

    public LaserHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape1", 0, 8);
        this.setTextureOffset("Piece1.Shape2", 0, 1);
        this.setTextureOffset("Piece1.Shape3", 12, 2);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 12, 2);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 0, 1);
        this.setTextureOffset("Piece1.Shape10", 13, 3);
        this.setTextureOffset("Piece1.Shape11", 0, 0);
        this.setTextureOffset("Piece1.Shape12", 13, 3);
        this.setTextureOffset("Piece1.Shape13", 0, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape1", -4.0F, -5.0F, -5.0F, 8, 2, 1);
        this.Piece1.addBox("Shape2", 4.6F, -5.0F, -2.0F, 1, 2, 2);
        this.Piece1.addBox("Shape3", -5.0F, -5.0F, -4.0F, 1, 2, 2);
        this.Piece1.addBox("Shape4", 4.2F, -5.0F, -3.0F, 1, 2, 4);
        this.Piece1.addBox("Shape5", 4.0F, -5.0F, -4.0F, 1, 2, 2);
        this.Piece1.addBox("Shape6", 4.2F, -5.5F, -2.5F, 1, 3, 3);
        this.Piece1.addBox("Shape7", -5.2F, -5.5F, -2.5F, 1, 3, 3);
        this.Piece1.addBox("Shape8", 4.2F, -6.0F, -2.0F, 1, 4, 2);
        this.Piece1.addBox("Shape9", -5.6F, -5.0F, -2.0F, 1, 2, 2);
        this.Piece1.addBox("Shape10", 3.5F, -5.0F, -4.5F, 1, 2, 1);
        this.Piece1.addBox("Shape11", -5.2F, -5.0F, -3.0F, 1, 2, 4);
        this.Piece1.addBox("Shape12", -4.5F, -5.0F, -4.5F, 1, 2, 1);
        this.Piece1.addBox("Shape13", -5.2F, -6.0F, -2.0F, 1, 4, 2);
        this.Shape14 = new MModelRenderer(this, 0, 12);
        this.Shape14.addBox(-4.0F, -4.5F, -5.3F, 8, 1, 1);
        this.Shape14.setTextureSize(32, 16);
        this.Shape14.scaleModifier = 0.99F;
        this.setTexture(new ResourceLocation("minidot", "head/laserhat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.01F, 1.01F, 1.01F);
        GlStateManager.translate(0.0F, 0.02F, 0.0F);

        if (player.getCurrentArmor(3) != null)
        {
            GlStateManager.scale(0.85F, 0.85F, 0.85F);
        }
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public String getName()
    {
        return "\u041b\u0430\u0437\u0435\u0440\u043d\u044b\u0435 \u043e\u0447\u043a\u0438";
    }

    public String getCreator()
    {
        return "Veltorn";
    }
}
