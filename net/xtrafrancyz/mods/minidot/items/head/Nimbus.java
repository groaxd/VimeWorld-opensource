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

public class Nimbus extends BaseItem
{
    private final MModelRenderer Piece1;

    public Nimbus()
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 8;
        this.setTextureOffset("Piece1.Shape1", 0, 0);
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 5);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 5);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape1", -3.5F, -11.0F, -3.4F, 1, 1, 1);
        this.Piece1.addBox("Shape2", 3.0F, -11.0F, -3.0F, 1, 1, 6);
        this.Piece1.addBox("Shape3", -3.0F, -11.0F, -4.0F, 6, 1, 1);
        this.Piece1.addBox("Shape4", 2.5F, -11.0F, 2.6F, 1, 1, 1);
        this.Piece1.addBox("Shape5", -3.0F, -11.0F, 3.0F, 6, 1, 1);
        this.Piece1.addBox("Shape6", 2.5F, -11.0F, -3.4F, 1, 1, 1);
        this.Piece1.addBox("Shape7", -3.5F, -11.0F, 2.6F, 1, 1, 1);
        this.Piece1.addBox("Shape8", -4.0F, -11.0F, -3.0F, 1, 1, 6);
        this.setTexture(new ResourceLocation("minidot", "head/nimbus.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        float f = MathHelper.sin(time * 0.1F) * 0.01F;
        this.Piece1.rotationY = time * 0.015F;
        this.Piece1.offsetY = f;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.3F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041d\u0438\u043c\u0431";
    }

    public String getCreator()
    {
        return "Veltorn";
    }
}
