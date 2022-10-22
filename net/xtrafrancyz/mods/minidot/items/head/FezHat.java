package net.xtrafrancyz.mods.minidot.items.head;

import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class FezHat extends BaseItem
{
    private final MModelRenderer Shape1;
    private final MModelRenderer Shape2;
    private final MModelRenderer Shape3;
    private final MModelRenderer Shape4;
    private final MModelRenderer Shape5;

    public FezHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Shape1 = new MModelRenderer(this, 19, 11);
        this.Shape1.addBox(0.8333333F, -12.73333F, -0.5333334F, 3, 1, 1);
        this.setRotation(this.Shape1, 0.0F, -0.358154F, -0.0349066F);
        this.Shape2 = new MModelRenderer(this, 19, 11);
        this.Shape2.addBox(5.2F, -11.8F, 0.0F, 1, 4, 1);
        this.setRotation(this.Shape2, 0.0F, -0.1661677F, -0.2185276F);
        this.Shape3 = new MModelRenderer(this, 19, 11);
        this.Shape3.addBox(5.6F, -11.13333F, 1.75F, 1, 4, 1);
        this.setRotation(this.Shape3, 0.1396263F, -0.1138079F, -0.2708875F);
        this.Shape4 = new MModelRenderer(this, 0, 0);
        this.Shape4.addBox(-3.5F, -10.5F, -3.5F, 7, 3, 7);
        this.Shape5 = new MModelRenderer(this, 0, 10);
        this.Shape5.addBox(-3.0F, -12.5F, -3.0F, 6, 2, 6);
        this.setTexture(new ResourceLocation("minidot", "head/fezhat.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.25F, 0.0F);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0424\u0435\u0441\u043a\u0430";
    }

    public String getCreator()
    {
        return "Ursun";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("FEZ");
    }
}
