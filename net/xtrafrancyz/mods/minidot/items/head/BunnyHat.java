package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BunnyHat extends BaseItem
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
    private final MModelRenderer Shape17;
    private final MModelRenderer Shape18;
    private final MModelRenderer Shape19;
    private final MModelRenderer Shape20;

    public BunnyHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.useDisplayLists = true;
        this.Shape1 = new MModelRenderer(this, 16, 0);
        this.Shape1.addBox(-1.5F, -11.0F, -4.0F, 3, 3, 3);
        this.setRotation(this.Shape1, 0.0698132F, 0.0F, 0.0F);
        this.Shape2 = new MModelRenderer(this, 0, 6);
        this.Shape2.addBox(-1.6F, -9.0F, -3.933333F, 1, 1, 3);
        this.setRotation(this.Shape2, 0.0698132F, 0.4014257F, 0.0F);
        this.Shape3 = new MModelRenderer(this, 10, 12);
        this.Shape3.addBox(-2.5F, -10.26667F, -1.2F, 1, 2, 2);
        this.setRotation(this.Shape3, -0.2443461F, -0.0523599F, 0.0F);
        this.Shape4 = new MModelRenderer(this, 1, 7);
        this.Shape4.addBox(-2.5F, -9.266666F, 0.8F, 1, 1, 2);
        this.setRotation(this.Shape4, -0.122173F, -0.0523599F, 0.0F);
        this.Shape5 = new MModelRenderer(this, 8, 8);
        this.Shape5.addBox(-2.5F, -9.266666F, 2.8F, 1, 3, 1);
        this.setRotation(this.Shape5, -0.0872665F, -0.0523599F, 0.0F);
        this.Shape6 = new MModelRenderer(this, 0, 14);
        this.Shape6.addBox(-0.5F, -10.8F, -1.733333F, 1, 1, 1);
        this.setRotation(this.Shape6, -0.3490659F, 0.0F, 0.0F);
        this.Shape7 = new MModelRenderer(this, 12, 0);
        this.Shape7.addBox(-1.5F, -13.0F, -3.0F, 1, 3, 1);
        this.setRotation(this.Shape7, 0.0698132F, 0.0F, 0.1919862F);
        this.Shape8 = new MModelRenderer(this, 12, 6);
        this.Shape8.addBox(1.1F, -12.46667F, -2.6F, 1, 2, 1);
        this.setRotation(this.Shape8, 0.122173F, 0.0F, -0.2443461F);
        this.Shape9 = new MModelRenderer(this, 12, 9);
        this.Shape9.addBox(1.1F, -12.33333F, -3.833333F, 1, 1, 1);
        this.setRotation(this.Shape9, 0.0349066F, 0.0F, -0.2443461F);
        this.Shape10 = new MModelRenderer(this, 8, 6);
        this.Shape10.addBox(-1.6F, -9.333333F, -3.8F, 1, 1, 1);
        this.setRotation(this.Shape10, 0.1570796F, 0.4014257F, 0.0F);
        this.Shape11 = new MModelRenderer(this, 0, 6);
        this.Shape11.addBox(0.4F, -9.0F, -4.266667F, 1, 1, 3);
        this.setRotation(this.Shape11, 0.0523599F, -0.4014257F, 0.0F);
        this.Shape12 = new MModelRenderer(this, 8, 6);
        this.Shape12.addBox(0.4F, -9.4F, -3.533333F, 1, 1, 1);
        this.setRotation(this.Shape12, 0.1919862F, -0.4014257F, 0.0F);
        this.Shape13 = new MModelRenderer(this, 0, 10);
        this.Shape13.addBox(-1.0F, -9.4F, -4.133333F, 2, 1, 1);
        this.setRotation(this.Shape13, 0.0698132F, 0.0F, 0.0F);
        this.Shape14 = new MModelRenderer(this, 0, 0);
        this.Shape14.addBox(-0.5F, -2.533333F, -10.4F, 1, 1, 1);
        this.setRotation(this.Shape14, -0.9250245F, 0.0F, 0.0F);
        this.Shape15 = new MModelRenderer(this, 0, 2);
        this.Shape15.addBox(-1.5F, -10.0F, 0.7333333F, 3, 2, 1);
        this.setRotation(this.Shape15, -0.122173F, 0.0F, 0.0F);
        this.Shape16 = new MModelRenderer(this, 10, 12);
        this.Shape16.addBox(1.5F, -10.26667F, -1.2F, 1, 2, 2);
        this.setRotation(this.Shape16, -0.2443461F, 0.0523599F, 0.0F);
        this.Shape17 = new MModelRenderer(this, 1, 7);
        this.Shape17.addBox(1.5F, -9.3F, 0.8F, 1, 1, 2);
        this.setRotation(this.Shape17, -0.122173F, 0.0523599F, 0.0F);
        this.Shape18 = new MModelRenderer(this, 8, 8);
        this.Shape18.addBox(1.5F, -9.266666F, 2.8F, 1, 3, 1);
        this.setRotation(this.Shape18, -0.0872665F, 0.0698132F, 0.0F);
        this.Shape19 = new MModelRenderer(this, 0, 12);
        this.Shape19.addBox(-1.5F, -10.06667F, 0.4F, 3, 1, 3);
        this.setRotation(this.Shape19, 0.1396263F, 0.0F, 0.0F);
        this.Shape20 = new MModelRenderer(this, 0, 0);
        this.Shape20.addBox(-2.0F, -10.0F, -2.0F, 4, 2, 4);
        this.setTexture(new ResourceLocation("minidot", "head/bunnyhat.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.2F, 0.0F);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0440\u043e\u043b\u0438\u043a";
    }

    public String getCreator()
    {
        return "Ursun";
    }
}
