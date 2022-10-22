package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SlimeHat extends BaseItem
{
    private final MModelRenderer Shape1;
    private final MModelRenderer Shape2;
    private final MModelRenderer Shape3;
    private final MModelRenderer Shape4;
    private final MModelRenderer Shape5;
    private final MModelRenderer Shape6;
    private final MModelRenderer Shape7;

    public SlimeHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.Shape1 = new MModelRenderer(this, 0, 0);
        this.Shape1.addBox(-4.0F, -9.0F, -4.0F, 8, 1, 8);
        this.Shape2 = new MModelRenderer(this, 32, 0);
        this.Shape2.addBox(-1.133333F, -13.0F, 0.3333333F, 4, 4, 4);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0F, 0.4476924F, 0.0F);
        this.Shape3 = new MModelRenderer(this, 48, 0);
        this.Shape3.addBox(-3.466667F, -11.0F, -2.0F, 2, 2, 2);
        this.setRotation(this.Shape3, 0.0F, -0.3346075F, 0.0F);
        this.Shape4 = new MModelRenderer(this, 56, 0);
        this.Shape4.addBox(1.133333F, -10.0F, -2.466667F, 1, 1, 1);
        this.setRotation(this.Shape4, 0.0F, 0.1487144F, 0.0F);
        this.Shape5 = new MModelRenderer(this, 60, 0);
        this.Shape5.addBox(-3.0F, -11.0F, 2.0F, 1, 2, 1);
        this.setRotation(this.Shape5, 0.0F, -0.1570796F, 0.0F);
        this.Shape6 = new MModelRenderer(this, 0, 16);
        this.Shape6.addBox(-4.0F, -14.0F, 1.0F, 3, 3, 3);
        this.setRotation(this.Shape6, 0.0F, -0.1570796F, 0.0F);
        this.Shape7 = new MModelRenderer(this, 0, 22);
        this.Shape7.addBox(-3.0F, -15.0F, 2.0F, 1, 1, 1);
        this.setRotation(this.Shape7, 0.0F, -0.1570796F, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "head/slimeshat.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.25D, 0.0D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u043b\u0430\u0439\u043c\u044b";
    }
}
