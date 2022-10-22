package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BrainSlug extends BaseItem
{
    private final MModelRenderer Hat;
    private final MModelRenderer Shape3;
    private final MModelRenderer Shape4;
    private final MModelRenderer Shape5;
    private final MModelRenderer Shape6;
    private final MModelRenderer Shape7;

    public BrainSlug()
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 8;
        this.useDisplayLists = true;
        this.setTextureOffset("Hat.Shape1", 0, 0);
        this.setTextureOffset("Hat.Shape2", 0, 0);
        this.setTextureOffset("Hat.Shape8", 12, 0);
        this.setTextureOffset("Hat.Shape9", 12, 0);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", 4.0F, -8.0F, 0.0F, 1, 1, 1);
        this.Hat.addBox("Shape2", -0.6F, -11.0F, -1.0F, 3, 3, 3);
        this.Hat.addBox("Shape8", -0.8F, -11.2F, -1.2F, 1, 1, 1);
        this.Hat.addBox("Shape9", 1.6F, -11.2F, -1.2F, 1, 1, 1);
        this.Shape3 = new MModelRenderer(this, 0, 0);
        this.Shape3.addBox(2.2F, -9.0F, -0.6F, 2, 1, 1);
        this.setRotation(this.Shape3, 0.0F, -0.1396263F, 0.0F);
        this.Shape4 = new MModelRenderer(this, 0, 0);
        this.Shape4.addBox(0.7F, -9.0F, -4.0F, 1, 1, 3);
        this.setRotation(this.Shape4, 0.0F, -0.2230717F, 0.0F);
        this.Shape5 = new MModelRenderer(this, 0, 0);
        this.Shape5.addBox(-3.5F, -9.0F, -0.7F, 3, 1, 1);
        this.setRotation(this.Shape5, 0.0F, -0.669215F, 0.0F);
        this.Shape6 = new MModelRenderer(this, 0, 0);
        this.Shape6.addBox(-3.5F, -9.0F, 0.7F, 3, 1, 1);
        this.setRotation(this.Shape6, 0.0F, 0.5948578F, 0.0F);
        this.Shape7 = new MModelRenderer(this, 0, 0);
        this.Shape7.addBox(0.5F, -9.0F, 2.0F, 1, 1, 3);
        this.setRotation(this.Shape7, 0.0F, 0.4461433F, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "head/brainslug.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.15F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u043e\u0437\u0433\u043e\u0432\u043e\u0439 \u0441\u043b\u0438\u0437\u0435\u043d\u044c";
    }
}
