package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SombreroHat extends BaseItem
{
    private final MModelRenderer Hat;
    private final MModelRenderer Shape1;
    private final MModelRenderer Shape2;

    public SombreroHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.setTextureOffset("Hat.Shape3", 30, 2);
        this.setTextureOffset("Hat.Shape4", 0, 19);
        this.setTextureOffset("Hat.Shape5", 0, 1);
        this.setTextureOffset("Hat.Shape6", 0, 8);
        this.setTextureOffset("Hat.Shape7", 0, 0);
        this.setTextureOffset("Hat.Shape8", 42, 21);
        this.setTextureOffset("Hat.Shape9", 0, 0);
        this.setTextureOffset("Hat.Shape10", 42, 0);
        this.setTextureOffset("Hat.Shape11", 0, 0);
        this.setTextureOffset("Hat.Shape12", 0, 0);
        this.setTextureOffset("Hat.Shape13", 42, 21);
        this.setTextureOffset("Hat.Shape14", 0, 0);
        this.setTextureOffset("Hat.Shape15", 0, 0);
        this.setTextureOffset("Hat.Shape16", 42, 0);
        this.setTextureOffset("Hat.Shape17", 0, 0);
        this.setTextureOffset("Hat.Shape18", 0, 0);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape3", -3.0F, -10.0F, -3.0F, 6, 2, 6);
        this.Hat.addBox("Shape4", -3.0F, -8.5F, -6.0F, 6, 1, 12);
        this.Hat.addBox("Shape5", -6.0F, -8.5F, -3.0F, 12, 1, 6);
        this.Hat.addBox("Shape6", -5.0F, -8.5F, -5.0F, 10, 1, 10);
        this.Hat.addBox("Shape7", 5.0F, -9.5F, -5.0F, 1, 1, 2);
        this.Hat.addBox("Shape8", 6.0F, -9.5F, -3.0F, 1, 1, 6);
        this.Hat.addBox("Shape9", 3.0F, -9.5F, -6.0F, 2, 1, 1);
        this.Hat.addBox("Shape10", -3.0F, -9.5F, -7.0F, 6, 1, 1);
        this.Hat.addBox("Shape11", -5.0F, -9.5F, -6.0F, 2, 1, 1);
        this.Hat.addBox("Shape12", -6.0F, -9.5F, -5.0F, 1, 1, 2);
        this.Hat.addBox("Shape13", -7.0F, -9.5F, -3.0F, 1, 1, 6);
        this.Hat.addBox("Shape14", -6.0F, -9.5F, 3.0F, 1, 1, 2);
        this.Hat.addBox("Shape15", -5.0F, -9.5F, 5.0F, 2, 1, 1);
        this.Hat.addBox("Shape16", -3.0F, -9.5F, 6.0F, 6, 1, 1);
        this.Hat.addBox("Shape17", 3.0F, -9.5F, 5.0F, 2, 1, 1);
        this.Hat.addBox("Shape18", 5.0F, -9.5F, 3.0F, 1, 1, 2);
        this.Shape1 = new MModelRenderer(this, 45, 10);
        this.Shape1.addBox(-2.0F, -12.0F, -2.0F, 4, 3, 4);
        this.setRotation(this.Shape1, 0.0371786F, 0.0371786F, 0.0371786F);
        this.Shape2 = new MModelRenderer(this, 31, 11);
        this.Shape2.addBox(0.5F, 0.0F, -0.5F, 2, 2, 2);
        this.Shape2.setRotationPoint(-1.0F, -13.5F, -1.0F);
        this.setRotation(this.Shape2, 0.0371786F, 0.0720852F, 0.0895385F);
        this.setTexture(new ResourceLocation("minidot", "head/sombrerohat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.0F, 1.07F, 1.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.15F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u043e\u043c\u0431\u0440\u0435\u0440\u043e";
    }
}
