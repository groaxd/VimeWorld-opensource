package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class RoosterHat extends BaseItem
{
    private final MModelRenderer Shape1;
    private final MModelRenderer Shape2;
    private final MModelRenderer Shape3;
    private final MModelRenderer Shape4;
    private final MModelRenderer Shape5;
    private final MModelRenderer Shape6;
    private final MModelRenderer Shape7;
    private final MModelRenderer Shape8;
    private final MModelRenderer Shape9;
    private final MModelRenderer Shape10;
    private final MModelRenderer Shape11;
    private final MModelRenderer Shape12;
    private final MModelRenderer Shape13;
    private final MModelRenderer Shape14;
    private final MModelRenderer Shape15;
    private final MModelRenderer Shape16;

    public RoosterHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.Shape1 = new MModelRenderer(this, 0, 5);
        this.Shape1.addBox(-1.0F, -2.501F, -7.0F, 2, 1, 3);
        this.Shape2 = new MModelRenderer(this, 0, 10);
        this.Shape2.addBox(-1.0F, -2.5F, -5.6F, 2, 1, 3);
        this.setRotation(this.Shape2, 0.2602503F, 0.0F, 0.0F);
        this.Shape3 = new MModelRenderer(this, 0, 15);
        this.Shape3.addBox(-1.0F, -3.5F, -5.0F, 2, 1, 1);
        this.Shape3.scaleModifier = 0.99F;
        this.Shape4 = new MModelRenderer(this, 0, 18);
        this.Shape4.addBox(-1.75F, -1.2F, -5.466667F, 1, 3, 2);
        this.setRotation(this.Shape4, 0.111544F, 0.0F, 0.0F);
        this.Shape5 = new MModelRenderer(this, 0, 18);
        this.Shape5.addBox(0.75F, -1.2F, -5.466667F, 1, 3, 2);
        this.setRotation(this.Shape5, 0.1115358F, 0.0F, 0.0F);
        this.Shape6 = new MModelRenderer(this, 7, 15);
        this.Shape6.addBox(-0.499F, -13.4F, -0.4666667F, 1, 6, 3);
        this.setRotation(this.Shape6, 0.4833219F, 0.0F, 0.0F);
        this.Shape7 = new MModelRenderer(this, 15, 15);
        this.Shape7.addBox(-0.501F, -9.4F, -4.466667F, 1, 2, 7);
        this.setRotation(this.Shape7, -0.2230717F, 0.0F, 0.0F);
        this.Shape8 = new MModelRenderer(this, 20, 8);
        this.Shape8.addBox(-0.5F, -12.4F, -4.133333F, 1, 4, 2);
        this.setRotation(this.Shape8, -0.3346075F, 0.0F, 0.0F);
        this.Shape9 = new MModelRenderer(this, 20, 7);
        this.Shape9.addBox(-0.5F, -13.06667F, -3.333333F, 1, 5, 2);
        this.setRotation(this.Shape9, -0.0371786F, 0.0F, 0.0F);
        this.Shape10 = new MModelRenderer(this, 20, 7);
        this.Shape10.addBox(-0.5F, -11.2F, -4.466667F, 1, 3, 2);
        this.setRotation(this.Shape10, -0.5948578F, 0.0F, 0.0F);
        this.Shape11 = new MModelRenderer(this, 11, 7);
        this.Shape11.addBox(-0.5F, -12.4F, -1.466667F, 1, 4, 3);
        this.setRotation(this.Shape11, 0.4833219F, 0.0F, 0.0F);
        this.Shape12 = new MModelRenderer(this, 0, 0);
        this.Shape12.addBox(2.4F, -2.5F, -6.1F, 1, 1, 4);
        this.setRotation(this.Shape12, 0.0F, 0.3717861F, 0.0F);
        this.Shape13 = new MModelRenderer(this, 0, 0);
        this.Shape13.addBox(-3.4F, -2.5F, -6.1F, 1, 1, 4);
        this.setRotation(this.Shape13, 0.0F, -0.37179F, 0.0F);
        this.Shape14 = new MModelRenderer(this, 0, 0);
        this.Shape14.addBox(-1.0F, -3.966667F, -5.2F, 2, 1, 3);
        this.setRotation(this.Shape14, 0.2602503F, 0.0F, 0.0F);
        this.Shape15 = new MModelRenderer(this, 11, 0);
        this.Shape15.addBox(1.2F, -2.5F, -5.266667F, 1, 1, 3);
        this.setRotation(this.Shape15, 0.260246F, 0.1919862F, 0.0F);
        this.Shape16 = new MModelRenderer(this, 11, 0);
        this.Shape16.addBox(-2.2F, -2.5F, -5.266667F, 1, 1, 3);
        this.setRotation(this.Shape16, 0.260246F, -0.1919862F, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "head/rooster.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, -0.05F, 0.2F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "Ursun";
    }

    public String getName()
    {
        return "\u041f\u0435\u0442\u0443\u0448\u0430\u0440\u0430";
    }
}
