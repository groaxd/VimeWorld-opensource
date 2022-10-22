package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class VikingHat extends BaseHelm
{
    private final MModelRenderer Hat;
    private final MModelRenderer Shape9;
    private final MModelRenderer Shape10;
    private final MModelRenderer Shape11;
    private final MModelRenderer Shape12;

    public VikingHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Hat.Shape1", 0, 0);
        this.setTextureOffset("Hat.Shape2", 0, 0);
        this.setTextureOffset("Hat.Shape3", 0, 0);
        this.setTextureOffset("Hat.Shape4", 0, 0);
        this.setTextureOffset("Hat.Shape5", 0, 0);
        this.setTextureOffset("Hat.Shape6", 0, 0);
        this.setTextureOffset("Hat.Shape7", 8, 22);
        this.setTextureOffset("Hat.Shape8", 8, 22);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -5.0F, 0.0F, -6.0F, 10, 1, 10);
        this.Hat.addBox("Shape2", 4.0F, 1.0F, -6.0F, 1, 8, 10);
        this.Hat.addBox("Shape3", -5.0F, 1.0F, -6.0F, 1, 8, 10);
        this.Hat.addBox("Shape4", -4.0F, 1.0F, -6.0F, 8, 3, 1);
        this.Hat.addBox("Shape5", -4.0F, 1.0F, 3.0F, 8, 8, 1);
        this.Hat.addBox("Shape6", -1.0F, 4.0F, -6.0F, 2, 3, 1);
        this.Hat.addBox("Shape7", 5.0F, 3.0F, -3.0F, 3, 4, 4);
        this.Hat.addBox("Shape8", -8.0F, 3.0F, -3.0F, 3, 4, 4);
        this.Shape9 = new MModelRenderer(this, 5, 23);
        this.Shape9.addBox(-1.0F, 2.0F, 0.0F, 3, 3, 3);
        this.Shape9.setRotationPoint(-7.0F, 5.0F, -4.5F);
        this.setRotation(this.Shape9, ((float)Math.PI / 2F), 0.0F, -1.364028F);
        this.Shape10 = new MModelRenderer(this, 5, 24);
        this.Shape10.addBox(-2.466667F, -1.0F, -4.0F, 2, 2, 2);
        this.Shape10.setRotationPoint(-10.0F, 2.0F, 2.0F);
        this.setRotation(this.Shape10, 0.0F, 0.0F, -1.330168F);
        this.Shape11 = new MModelRenderer(this, 5, 23);
        this.Shape11.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
        this.Shape11.setRotationPoint(7.0F, 3.0F, -2.5F);
        this.setRotation(this.Shape11, ((float)Math.PI / 2F), 0.0F, 1.364027F);
        this.Shape12 = new MModelRenderer(this, 5, 24);
        this.Shape12.addBox(0.1F, 0.0F, 0.0F, 2, 2, 2);
        this.Shape12.setRotationPoint(11.5F, 2.0F, -2.0F);
        this.setRotation(this.Shape12, 0.0F, 0.0F, 1.330168F);
        this.setTexture(new ResourceLocation("minidot", "head/vikinghat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -0.6F, 0.07F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.45F, 0.1F);
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u043b\u0435\u043c \u0412\u0438\u043a\u0438\u043d\u0433\u043e\u0432";
    }

    public String getCreator()
    {
        return "Edone6";
    }
}
