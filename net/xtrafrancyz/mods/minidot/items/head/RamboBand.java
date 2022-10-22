package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class RamboBand extends BaseItem
{
    private final MModelRenderer Shape1;
    private final MModelRenderer Shape2;
    private final MModelRenderer Shape3;
    private final MModelRenderer Shape4;
    private final MModelRenderer Piece1;

    public RamboBand()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.setTextureOffset("Piece1.Shape8", 0, 0);
        this.setTextureOffset("Piece1.Shape9", 0, 0);
        this.setTextureOffset("Piece1.Shape10", 0, 0);
        this.setTextureOffset("Piece1.Shape11", 0, 0);
        this.setTextureOffset("Piece1.Shape12", 0, 0);
        this.setTextureOffset("Piece1.Shape13", 0, 0);
        this.Shape1 = new MModelRenderer(this, 0, 0);
        this.Shape1.addBox(0.9333333F, -4.933333F, 4.6F, 1, 2, 1);
        this.setRotation(this.Shape1, 0.2268928F, 0.0F, -0.2094395F);
        this.Shape2 = new MModelRenderer(this, 0, 0);
        this.Shape2.addBox(-3.266667F, -4.266667F, 4.4F, 1, 2, 1);
        this.setRotation(this.Shape2, 0.2268928F, 0.0F, 0.5410521F);
        this.Shape3 = new MModelRenderer(this, 0, 0);
        this.Shape3.addBox(0.06666667F, -3.933333F, 4.1F, 1, 3, 1);
        this.setRotation(this.Shape3, 0.0872665F, 0.0F, 0.0F);
        this.Shape4 = new MModelRenderer(this, 0, 0);
        this.Shape4.addBox(-1.733333F, -4.066667F, 4.066667F, 1, 2, 1);
        this.setRotation(this.Shape4, 0.0698132F, 0.0F, 0.1745329F);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.addBox("Shape5", -4.25F, -7.0F, 3.25F, 8, 1, 1);
        this.Piece1.addBox("Shape6", -3.75F, -7.0F, -4.2502F, 8, 1, 1);
        this.Piece1.addBox("Shape7", -4.2502F, -7.0F, -4.25F, 1, 1, 8);
        this.Piece1.addBox("Shape8", 3.25F, -7.0F, -3.7498F, 1, 1, 8);
        this.Piece1.addBox("Shape9", -0.5F, -6.5F, 3.5F, 1, 1, 1);
        this.Piece1.addBox("Shape10", -3.75F, -6.5F, -4.2502F, 8, 1, 1);
        this.Piece1.addBox("Shape11", -4.2502F, -6.5F, -4.25F, 1, 1, 8);
        this.Piece1.addBox("Shape12", -4.25F, -6.5F, 3.25F, 8, 1, 1);
        this.Piece1.addBox("Shape13", 3.25F, -6.5F, -3.7498F, 1, 1, 8);
        this.setTexture(new ResourceLocation("minidot", "head/ramboband.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.05F, 0.0F);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u043e\u0432\u044f\u0437\u043a\u0430 \u0420\u044d\u043c\u0431\u043e";
    }

    public String getCreator()
    {
        return "Ursun";
    }
}
