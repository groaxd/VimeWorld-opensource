package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BearsEarsHat extends BaseItem
{
    private final MModelRenderer Hat;

    public BearsEarsHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 8;
        this.setTextureOffset("Hat.Shape1", 0, 0);
        this.setTextureOffset("Hat.Shape2", 0, 0);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -6.0F, -11.0F, -1.0F, 4, 4, 1);
        this.Hat.addBox("Shape2", 2.0F, -11.0F, -1.0F, 4, 4, 1);
        this.setTexture(new ResourceLocation("minidot", "head/bear_ears.png"));
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.2F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0423\u0448\u043a\u0438 \u041c\u0438\u0448\u043a\u0438";
    }

    public String getCreator()
    {
        return "cool_lemur";
    }
}
