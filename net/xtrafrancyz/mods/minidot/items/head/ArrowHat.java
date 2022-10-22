package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ArrowHat extends BaseItem
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

    public ArrowHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.Shape1 = new MModelRenderer(this, 0, 2);
        this.Shape1.addBox(0.0F, -0.5F, -0.5F, 5, 1, 1);
        this.Shape1.setRotationPoint(4.0F, -5.0F, 0.0F);
        this.setRotation(this.Shape1, -0.3490659F, 0.0F, 0.0F);
        this.Shape2 = new MModelRenderer(this, 0, 4);
        this.Shape2.addBox(0.0F, -0.5F, -0.5F, 5, 1, 1);
        this.Shape2.setRotationPoint(-9.0F, -5.0F, 0.0F);
        this.setRotation(this.Shape2, -0.3490659F, 0.0F, 0.0F);
        this.Shape3 = new MModelRenderer(this, 0, 6);
        this.Shape3.addBox(-1.0F, -2.5F, -0.5F, 2, 1, 1);
        this.Shape3.setRotationPoint(-8.0F, -5.0F, 0.0F);
        this.setRotation(this.Shape3, -0.3490659F, 0.0F, 0.0F);
        this.Shape4 = new MModelRenderer(this, 0, 8);
        this.Shape4.addBox(-2.0F, -1.5F, -0.5F, 2, 1, 1);
        this.Shape4.setRotationPoint(-6.0F, -5.0F, 0.0F);
        this.setRotation(this.Shape4, -0.3490659F, 0.0F, 0.0F);
        this.Shape5 = new MModelRenderer(this, 0, 8);
        this.Shape5.addBox(-2.0F, 0.5F, -0.5F, 2, 1, 1);
        this.Shape5.setRotationPoint(-6.0F, -5.0F, 0.0F);
        this.setRotation(this.Shape5, -0.3490659F, 0.0F, 0.0F);
        this.Shape6 = new MModelRenderer(this, 0, 6);
        this.Shape6.addBox(-1.0F, 1.5F, -0.5F, 2, 1, 1);
        this.Shape6.setRotationPoint(-8.0F, -5.0F, 0.0F);
        this.setRotation(this.Shape6, -0.3490659F, 0.0F, 0.0F);
        this.Shape7 = new MModelRenderer(this, 0, 8);
        this.Shape7.addBox(-2.0F, -0.5F, 0.5F, 2, 1, 1);
        this.Shape7.setRotationPoint(-6.0F, -5.0F, 0.0F);
        this.setRotation(this.Shape7, -0.3490659F, 0.0F, 0.0F);
        this.Shape8 = new MModelRenderer(this, 0, 8);
        this.Shape8.addBox(-2.0F, -0.5F, -1.5F, 2, 1, 1);
        this.Shape8.setRotationPoint(-6.0F, -5.0F, 0.0F);
        this.setRotation(this.Shape8, -0.3490659F, 0.0F, 0.0F);
        this.Shape9 = new MModelRenderer(this, 0, 6);
        this.Shape9.addBox(-3.0F, -0.5F, -2.5F, 2, 1, 1);
        this.Shape9.setRotationPoint(-6.0F, -5.0F, 0.0F);
        this.setRotation(this.Shape9, -0.3490659F, 0.0F, 0.0F);
        this.Shape10 = new MModelRenderer(this, 0, 6);
        this.Shape10.addBox(-3.0F, -0.5F, 1.5F, 2, 1, 1);
        this.Shape10.setRotationPoint(-6.0F, -5.0F, 0.0F);
        this.setRotation(this.Shape10, -0.3490659F, 0.0F, 0.0F);
        this.Shape11 = new MModelRenderer(this, 0, 0);
        this.Shape11.addBox(0.0F, -1.5F, -0.5F, 2, 1, 1);
        this.Shape11.setRotationPoint(6.0F, -5.0F, 0.0F);
        this.setRotation(this.Shape11, -0.3490659F, 0.0F, 0.0F);
        this.Shape12 = new MModelRenderer(this, 0, 0);
        this.Shape12.addBox(0.0F, -0.5F, -1.5F, 2, 1, 1);
        this.Shape12.setRotationPoint(6.0F, -5.0F, 0.0F);
        this.setRotation(this.Shape12, -0.3490659F, 0.0F, 0.0F);
        this.Shape13 = new MModelRenderer(this, 0, 10);
        this.Shape13.addBox(0.0F, 0.5F, -0.5F, 2, 1, 1);
        this.Shape13.setRotationPoint(6.0F, -5.0F, 0.0F);
        this.setRotation(this.Shape13, -0.3490659F, 0.0F, 0.0F);
        this.Shape14 = new MModelRenderer(this, 0, 10);
        this.Shape14.addBox(0.0F, -0.5F, 0.5F, 2, 1, 1);
        this.Shape14.setRotationPoint(6.0F, -5.0F, 0.0F);
        this.setRotation(this.Shape14, -0.3490659F, 0.0F, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "head/arrowhat.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.1F, 0.0F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u0442\u0440\u0435\u043b\u0430 \u0432 \u0433\u043e\u043b\u043e\u0432\u0435";
    }
}
