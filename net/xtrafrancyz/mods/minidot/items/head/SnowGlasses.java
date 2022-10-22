package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SnowGlasses extends BaseItem
{
    private final MModelRenderer Hat;
    private final MModelRenderer Hat2;

    public SnowGlasses()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.setTextureOffset("Hat.Shape1", 60, 10);
        this.setTextureOffset("Hat.Shape2", 48, 10);
        this.setTextureOffset("Hat.Shape3", 48, 10);
        this.setTextureOffset("Hat.Shape4", 60, 10);
        this.setTextureOffset("Hat.Shape5", 48, 10);
        this.setTextureOffset("Hat.Shape6", 48, 10);
        this.setTextureOffset("Hat.Shape13", 48, 0);
        this.setTextureOffset("Hat.Shape14", 58, 0);
        this.setTextureOffset("Hat.Shape15", 46, 0);
        this.setTextureOffset("Hat.Shape16", 48, 0);
        this.setTextureOffset("Hat.Shape17", 58, 0);
        this.setTextureOffset("Hat.Shape18", 60, 0);
        this.setTextureOffset("Hat.Shape19", 33, 3);
        this.setTextureOffset("Hat2.Shape7", 48, 10);
        this.setTextureOffset("Hat2.Shape8", 48, 10);
        this.setTextureOffset("Hat2.Shape9", 48, 10);
        this.setTextureOffset("Hat2.Shape10", 48, 10);
        this.setTextureOffset("Hat2.Shape11", 48, 10);
        this.setTextureOffset("Hat2.Shape12", 48, 10);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", 3.2F, -5.2F, -4.7F, 1, 3, 1);
        this.Hat.addBox("Shape2", -3.5F, -5.9F, -4.7F, 7, 1, 1);
        this.Hat.addBox("Shape3", 0.5F, -2.5F, -4.7F, 3, 1, 1);
        this.Hat.addBox("Shape4", -4.2F, -5.2F, -4.7F, 1, 3, 1);
        this.Hat.addBox("Shape5", -3.5F, -2.5F, -4.7F, 3, 1, 1);
        this.Hat.addBox("Shape6", -0.5F, -2.9F, -4.7F, 1, 1, 1);
        this.Hat.addBox("Shape13", -4.3F, -4.7F, -4.2F, 1, 2, 7);
        this.Hat.addBox("Shape14", 3.3F, -4.7F, 2.2F, 1, 2, 2);
        this.Hat.addBox("Shape15", -4.2F, -4.7F, 3.3F, 8, 2, 1);
        this.Hat.addBox("Shape16", 3.3F, -4.7F, -4.2F, 1, 2, 7);
        this.Hat.addBox("Shape17", -4.3F, -4.7F, 2.2F, 1, 2, 2);
        this.Hat.addBox("Shape18", 3.2F, -4.7F, 3.3F, 1, 2, 1);
        this.Hat.addBox("Shape19", -3.5F, -5.2F, -4.4F, 7, 3, 0);
        this.Hat2 = new MModelRenderer(this, "Hat2");
        this.setRotation(this.Hat2, 0.0F, 0.0F, -((float)Math.PI / 4F));
        this.Hat2.addBox("Shape7", 1.4F, -1.7F, -4.7F, 1, 1, 1);
        this.Hat2.addBox("Shape8", 0.7F, -2.4F, -4.7F, 1, 1, 1);
        this.Hat2.addBox("Shape9", 5.6F, -1.7F, -4.7F, 1, 1, 1);
        this.Hat2.addBox("Shape10", 3.5F, 0.4F, -4.7F, 1, 1, 1);
        this.Hat2.addBox("Shape11", -1.4F, -4.5F, -4.7F, 1, 1, 1);
        this.Hat2.addBox("Shape12", 0.7F, -6.6F, -4.7F, 1, 1, 1);
        this.setTexture(new ResourceLocation("minidot", "head/snowglasses.png"));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.15F, 0.1F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041e\u0447\u043a\u0438 \u0441\u043d\u043e\u0443\u0431\u043e\u0440\u0434\u0438\u0441\u0442\u0430";
    }

    public String getCreator()
    {
        return "_RusiK_";
    }
}
