package net.xtrafrancyz.mods.minidot.items.mask;

import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class MarinetteMask extends BaseItem
{
    private final MModelRenderer mask_ladybug;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;

    public MarinetteMask()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.mask_ladybug = new MModelRenderer(this);
        this.mask_ladybug.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.mask_ladybug.setTextureOffset(0, 6).addBox(-4.5F, -3.5F, -5.0F, 4, 1, 1, 0.0F);
        this.mask_ladybug.setTextureOffset(0, 4).addBox(0.5F, -6.5F, -5.0F, 4, 1, 1, 0.0F);
        this.mask_ladybug.setTextureOffset(0, 0).addBox(-4.5F, -6.5F, -5.0F, 4, 1, 1, 0.0F);
        this.mask_ladybug.setTextureOffset(15, 7).addBox(-0.5F, -4.0F, -5.75F, 1, 1, 1, 0.0F);
        this.mask_ladybug.setTextureOffset(16, 13).addBox(-1.25F, -3.5F, -5.5F, 1, 1, 1, 0.0F);
        this.mask_ladybug.setTextureOffset(4, 14).addBox(0.25F, -3.5F, -5.5F, 1, 1, 1, 0.0F);
        this.mask_ladybug.setTextureOffset(16, 9).addBox(-0.5F, -6.0F, -5.0F, 1, 2, 1, 0.0F);
        this.mask_ladybug.setTextureOffset(12, 12).addBox(3.75F, -6.0F, -4.75F, 1, 3, 1, 0.0F);
        this.mask_ladybug.setTextureOffset(8, 12).addBox(-4.75F, -6.0F, -4.75F, 1, 3, 1, 0.0F);
        this.mask_ladybug.setTextureOffset(0, 2).addBox(0.5F, -3.5F, -5.0F, 4, 1, 1, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(5.25F, -4.35F, -5.0F);
        this.mask_ladybug.addChild(this.bone);
        this.setRotation(this.bone, 0.0F, 0.0F, 0.3054F);
        this.bone.setTextureOffset(0, 12).addBox(-4.0F, -1.0F, 0.1F, 3, 1, 1, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-5.25F, -4.35F, -5.0F);
        this.mask_ladybug.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 0.0F, -0.3054F);
        this.bone2.setTextureOffset(8, 10).addBox(1.0F, -1.0F, 0.1F, 3, 1, 1, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-1.0F, -4.35F, -5.0F);
        this.mask_ladybug.addChild(this.bone3);
        this.setRotation(this.bone3, 0.0F, 0.0F, -0.3054F);
        this.bone3.setTextureOffset(0, 10).addBox(1.0F, -1.0F, 0.1F, 3, 1, 1, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(1.0F, -4.35F, -5.0F);
        this.mask_ladybug.addChild(this.bone4);
        this.setRotation(this.bone4, 0.0F, 0.0F, 0.3054F);
        this.bone4.setTextureOffset(9, 5).addBox(-4.0F, -1.0F, 0.1F, 3, 1, 1, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(1.0F, -4.65F, -5.0F);
        this.mask_ladybug.addChild(this.bone5);
        this.setRotation(this.bone5, 0.0F, 0.0F, -0.3054F);
        this.bone5.setTextureOffset(9, 3).addBox(-4.0F, 0.0F, 0.1F, 3, 1, 1, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(5.0F, -4.65F, -5.0F);
        this.mask_ladybug.addChild(this.bone6);
        this.setRotation(this.bone6, 0.0F, 0.0F, -0.3054F);
        this.bone6.setTextureOffset(9, 1).addBox(-4.0F, 0.0F, 0.1F, 3, 1, 1, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-5.0F, -4.65F, -5.0F);
        this.mask_ladybug.addChild(this.bone7);
        this.setRotation(this.bone7, 0.0F, 0.0F, 0.3054F);
        this.bone7.setTextureOffset(8, 8).addBox(1.0F, 0.0F, 0.1F, 3, 1, 1, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-1.0F, -4.65F, -5.0F);
        this.mask_ladybug.addChild(this.bone8);
        this.setRotation(this.bone8, 0.0F, 0.0F, 0.3054F);
        this.bone8.setTextureOffset(0, 8).addBox(1.0F, 0.0F, 0.1F, 3, 1, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "masks/marinettemask.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -1.435F, -0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -1.4F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u041b\u0435\u0434\u0438 \u0411\u0430\u0433";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }

    public List<String> getDescription()
    {
        return MNaming.fromMult("\u041b\u0435\u0434\u0438 \u0411\u0430\u0433 \u0438 \u0421\u0443\u043f\u0435\u0440-\u041a\u043e\u0442");
    }
}
