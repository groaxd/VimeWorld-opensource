package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ElectricHornsHat extends BaseItem
{
    private final MModelRenderer Hat;
    private final MModelRenderer Hat2;
    private final MModelRenderer Hat3;

    public ElectricHornsHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.useDisplayLists = true;
        this.setTextureOffset("Hat.Shape9", 8, 0);
        this.setTextureOffset("Hat.Shape10", 10, 5);
        this.setTextureOffset("Hat.Shape28", 8, 0);
        this.setTextureOffset("Hat.Shape29", 10, 5);
        this.setTextureOffset("Hat2.Shape90", 0, 6);
        this.setTextureOffset("Hat2.Shape91", 3, 10);
        this.setTextureOffset("Hat2.Shape92", 0, 6);
        this.setTextureOffset("Hat2.Shape93", 3, 10);
        this.setTextureOffset("Hat2.Shape0", 0, 6);
        this.setTextureOffset("Hat2.Shape1", 3, 11);
        this.setTextureOffset("Hat2.Shape2", 3, 11);
        this.setTextureOffset("Hat2.Shape3", 0, 6);
        this.setTextureOffset("Hat2.Shape19", 0, 0);
        this.setTextureOffset("Hat2.Shape20", 0, 2);
        this.setTextureOffset("Hat2.Shape21", 0, 6);
        this.setTextureOffset("Hat2.Shape22", 0, 4);
        this.setTextureOffset("Hat2.Shape23", 0, 8);
        this.setTextureOffset("Hat2.Shape24", 0, 10);
        this.setTextureOffset("Hat2.Shape25", 0, 14);
        this.setTextureOffset("Hat2.Shape26", 0, 12);
        this.setTextureOffset("Hat2.Shape27", 4, 0);
        this.setTextureOffset("Hat3.Shape80", 3, 10);
        this.setTextureOffset("Hat3.Shape81", 3, 10);
        this.setTextureOffset("Hat3.Shape82", 0, 6);
        this.setTextureOffset("Hat3.Shape83", 0, 6);
        this.setTextureOffset("Hat3.Shape70", 3, 11);
        this.setTextureOffset("Hat3.Shape71", 0, 6);
        this.setTextureOffset("Hat3.Shape72", 0, 6);
        this.setTextureOffset("Hat3.Shape73", 3, 11);
        this.setTextureOffset("Hat3.Shape60", 0, 0);
        this.setTextureOffset("Hat3.Shape61", 0, 2);
        this.setTextureOffset("Hat3.Shape62", 0, 6);
        this.setTextureOffset("Hat3.Shape63", 0, 4);
        this.setTextureOffset("Hat3.Shape64", 0, 8);
        this.setTextureOffset("Hat3.Shape5", 0, 10);
        this.setTextureOffset("Hat3.Shape6", 0, 14);
        this.setTextureOffset("Hat3.Shape7", 0, 12);
        this.setTextureOffset("Hat3.Shape8", 4, 0);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape9", -4.5F, -8.5F, -2.0F, 3, 1, 4);
        this.Hat.addBox("Shape10", -4.5F, -7.5F, -2.0F, 1, 2, 4);
        this.Hat.addBox("Shape28", 1.5F, -8.5F, -2.0F, 3, 1, 4);
        this.Hat.addBox("Shape29", 3.5F, -7.5F, -2.0F, 1, 2, 4);
        this.Hat2 = new MModelRenderer(this, "Hat2");
        this.setRotation(this.Hat2, 0.0F, 0.0F, 0.5235988F);
        this.Hat2.addBox("Shape90", 0.7F, -12.1F, -2.0F, 1, 0, 4);
        this.Hat2.addBox("Shape91", -1.3F, -12.1F, -2.0F, 2, 0, 1);
        this.Hat2.addBox("Shape92", -2.3F, -12.1F, -2.0F, 1, 0, 4);
        this.Hat2.addBox("Shape93", -1.3F, -12.1F, 1.0F, 2, 0, 1);
        this.Hat2.addBox("Shape0", -2.8F, -10.6F, -1.5F, 1, 0, 4);
        this.Hat2.addBox("Shape1", -1.8F, -10.6F, 1.5F, 4, 0, 1);
        this.Hat2.addBox("Shape2", -2.8F, -10.6F, -2.5F, 4, 0, 1);
        this.Hat2.addBox("Shape3", 1.2F, -10.6F, -2.5F, 1, 0, 4);
        this.Hat2.addBox("Shape19", -1.05F, -15.1F, -0.75F, 1, 1, 1);
        this.Hat2.addBox("Shape20", -0.55F, -15.1F, -0.75F, 1, 1, 1);
        this.Hat2.addBox("Shape21", -0.55F, -14.6F, -0.75F, 1, 1, 1);
        this.Hat2.addBox("Shape22", -1.05F, -14.6F, -0.75F, 1, 1, 1);
        this.Hat2.addBox("Shape23", -1.05F, -15.1F, -0.25F, 1, 1, 1);
        this.Hat2.addBox("Shape24", -0.55F, -15.1F, -0.25F, 1, 1, 1);
        this.Hat2.addBox("Shape25", -0.55F, -14.6F, -0.25F, 1, 1, 1);
        this.Hat2.addBox("Shape26", -1.05F, -14.6F, -0.25F, 1, 1, 1);
        this.Hat2.addBox("Shape27", -0.8F, -13.6F, -0.5F, 1, 5, 1);
        this.Hat3 = new MModelRenderer(this, "Hat3");
        this.setRotation(this.Hat3, 0.0F, 0.0F, -0.5235988F);
        this.Hat3.addBox("Shape80", -0.8F, -12.1F, -2.0F, 2, 0, 1);
        this.Hat3.addBox("Shape81", -0.8F, -12.1F, 1.0F, 2, 0, 1);
        this.Hat3.addBox("Shape82", 1.2F, -12.1F, -2.0F, 1, 0, 4);
        this.Hat3.addBox("Shape83", -1.8F, -12.1F, -2.0F, 1, 0, 4);
        this.Hat3.addBox("Shape70", -2.2F, -10.6F, -2.5F, 4, 0, 1);
        this.Hat3.addBox("Shape71", -2.2F, -10.6F, -1.5F, 1, 0, 4);
        this.Hat3.addBox("Shape72", 1.8F, -10.6F, -2.5F, 1, 0, 4);
        this.Hat3.addBox("Shape73", -1.2F, -10.6F, 1.5F, 4, 0, 1);
        this.Hat3.addBox("Shape60", 0.05F, -15.1F, -0.75F, 1, 1, 1);
        this.Hat3.addBox("Shape61", -0.45F, -15.1F, -0.75F, 1, 1, 1);
        this.Hat3.addBox("Shape62", -0.45F, -14.6F, -0.75F, 1, 1, 1);
        this.Hat3.addBox("Shape63", 0.05F, -14.6F, -0.75F, 1, 1, 1);
        this.Hat3.addBox("Shape64", 0.05F, -15.1F, -0.25F, 1, 1, 1);
        this.Hat3.addBox("Shape5", -0.45F, -15.1F, -0.25F, 1, 1, 1);
        this.Hat3.addBox("Shape6", -0.45F, -14.6F, -0.25F, 1, 1, 1);
        this.Hat3.addBox("Shape7", 0.05F, -14.6F, -0.25F, 1, 1, 1);
        this.Hat3.addBox("Shape8", -0.2F, -13.6F, -0.5F, 1, 5, 1);
        this.setTexture(new ResourceLocation("minidot", "head/electric_horns.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.01F, 1.01F, 1.01F);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.2F, 0.0F);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "_Mik_";
    }

    public String getName()
    {
        return "\u042d\u043b\u0435\u043a\u0442\u0440\u043e\u0436\u043a\u0438";
    }
}
