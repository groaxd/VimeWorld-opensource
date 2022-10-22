package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class RespiratorHat extends BaseItem
{
    private final MModelRenderer Hat;
    private final MModelRenderer Shape2;
    private final MModelRenderer Shape3;
    private final MModelRenderer Shape4;
    private final MModelRenderer Shape5;
    private final MModelRenderer Shape6;
    private final MModelRenderer Shape7;
    private final MModelRenderer Shape12;
    private final MModelRenderer Shape13;
    private final MModelRenderer Shape23;
    private final MModelRenderer Shape30;

    public RespiratorHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.setTextureOffset("Hat.Shape1", 0, 16);
        this.setTextureOffset("Hat.Shape8", 0, 16);
        this.setTextureOffset("Hat.Shape9", 0, 16);
        this.setTextureOffset("Hat.Shape10", 0, 16);
        this.setTextureOffset("Hat.Shape11", 0, 16);
        this.setTextureOffset("Hat.Shape14", 0, 4);
        this.setTextureOffset("Hat.Shape15", 0, 5);
        this.setTextureOffset("Hat.Shape16", 0, 5);
        this.setTextureOffset("Hat.Shape17", 0, 0);
        this.setTextureOffset("Hat.Shape18", 0, 7);
        this.setTextureOffset("Hat.Shape19", 0, 3);
        this.setTextureOffset("Hat.Shape20", 0, 4);
        this.setTextureOffset("Hat.Shape21", 0, 4);
        this.setTextureOffset("Hat.Shape22", 0, 0);
        this.setTextureOffset("Hat.Shape24", 0, 7);
        this.setTextureOffset("Hat.Shape25", 0, 6);
        this.setTextureOffset("Hat.Shape26", 0, 7);
        this.setTextureOffset("Hat.Shape27", 0, 7);
        this.setTextureOffset("Hat.Shape28", 0, 7);
        this.setTextureOffset("Hat.Shape29", 0, 7);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -1.0F, -2.0F, -6.0F, 2, 3, 2);
        this.Hat.addBox("Shape8", -3.0F, -2.5F, -5.0F, 6, 1, 1);
        this.Hat.addBox("Shape9", -4.0F, -4.5F, -5.0F, 1, 2, 1);
        this.Hat.addBox("Shape10", 3.0F, -4.5F, -5.0F, 1, 2, 1);
        this.Hat.addBox("Shape11", -3.0F, -5.5F, -5.0F, 6, 1, 1);
        this.Hat.addBox("Shape14", -4.1F, -1.0F, -4.1F, 0, 1, 4);
        this.Hat.addBox("Shape15", -4.1F, -2.0F, -1.0F, 0, 1, 3);
        this.Hat.addBox("Shape16", -4.1F, -3.0F, 1.1F, 0, 1, 3);
        this.Hat.addBox("Shape17", -4.1F, -4.0F, -3.9F, 0, 1, 8);
        this.Hat.addBox("Shape18", 1.1F, -1.0F, -4.1F, 3, 1, 0);
        this.Hat.addBox("Shape19", 4.1F, -1.0F, -4.1F, 0, 1, 4);
        this.Hat.addBox("Shape20", 4.1F, -2.0F, -0.9F, 0, 1, 3);
        this.Hat.addBox("Shape21", 4.1F, -3.0F, 1.1F, 0, 1, 3);
        this.Hat.addBox("Shape22", 4.1F, -4.0F, -3.9F, 0, 1, 8);
        this.Hat.addBox("Shape24", -4.1F, -4.0F, -4.1F, 1, 1, 0);
        this.Hat.addBox("Shape25", -4.1F, -4.0F, -4.1F, 0, 1, 1);
        this.Hat.addBox("Shape26", 3.1F, -4.0F, -4.1F, 1, 1, 0);
        this.Hat.addBox("Shape27", 4.1F, -4.0F, -4.1F, 0, 1, 1);
        this.Hat.addBox("Shape28", 3.1F, -4.0F, 4.1F, 1, 2, 0);
        this.Hat.addBox("Shape29", -4.1F, -4.0F, 4.1F, 1, 2, 0);
        this.Shape2 = new MModelRenderer(this, 0, 16);
        this.Shape2.addBox(2.8F, -2.0F, -4.5F, 1, 3, 2);
        this.setRotation(this.Shape2, 0.0F, 0.5235988F, 0.0F);
        this.Shape3 = new MModelRenderer(this, 5, 13);
        this.Shape3.addBox(2.5F, -1.0F, -4.7F, 1, 1, 1);
        this.setRotation(this.Shape3, 0.0F, 0.3490659F, 0.0F);
        this.Shape4 = new MModelRenderer(this, 0, 0);
        this.Shape4.addBox(3.5F, -1.5F, -5.2F, 1, 2, 2);
        this.setRotation(this.Shape4, 0.0F, 0.3490659F, 0.0F);
        this.Shape5 = new MModelRenderer(this, 5, 13);
        this.Shape5.addBox(-3.5F, -1.0F, -4.7F, 1, 1, 1);
        this.setRotation(this.Shape5, 0.0F, -0.3490659F, 0.0F);
        this.Shape6 = new MModelRenderer(this, 0, 0);
        this.Shape6.addBox(-4.5F, -1.5F, -5.2F, 1, 2, 2);
        this.setRotation(this.Shape6, 0.0F, -0.3490659F, 0.0F);
        this.Shape7 = new MModelRenderer(this, 0, 16);
        this.Shape7.addBox(-1.0F, -4.4F, -4.6F, 2, 1, 2);
        this.setRotation(this.Shape7, 0.4363323F, 0.0F, 0.0F);
        this.Shape12 = new MModelRenderer(this, 0, 9);
        this.Shape12.addBox(-3.0F, -4.5F, -5.5F, 6, 2, 0);
        this.Shape12.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.Shape13 = new MModelRenderer(this, 0, 7);
        this.Shape13.addBox(-4.1F, -1.0F, -5.1F, 3, 1, 0);
        this.Shape13.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.Shape23 = new MModelRenderer(this, 0, 7);
        this.Shape23.addBox(-7.0F, -4.0F, 4.1F, 8, 2, 0);
        this.Shape23.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.Shape30 = new MModelRenderer(this, 0, 16);
        this.Shape30.addBox(-4.0F, -2.0F, -5.6F, 1, 3, 2);
        this.Shape30.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.setRotation(this.Shape30, 0.0F, -0.4712389F, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "head/respirator.png"));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.25F, 0.1F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u0440\u043e\u0442\u0438\u0432\u043e\u0433\u0430\u0437";
    }
}
