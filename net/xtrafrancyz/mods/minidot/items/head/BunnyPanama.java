package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BunnyPanama extends BaseItem
{
    private final MModelRenderer main;
    private final MModelRenderer panama;
    private final MModelRenderer bunny;
    private final MModelRenderer ears;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer leaves;
    private final MModelRenderer bone8;
    private final MModelRenderer bone7;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone12;
    private final MModelRenderer bone11;

    public BunnyPanama()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.main = new MModelRenderer(this);
        this.main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.panama = new MModelRenderer(this);
        this.panama.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.main.addChild(this.panama);
        this.panama.setTextureOffset(0, 0).addBox(-4.5F, -8.6F, -4.5F, 9, 1, 9, -0.1F);
        this.panama.setTextureOffset(0, 0).addBox(-4.5F, -9.4F, -4.5F, 9, 1, 9, -0.1F);
        this.panama.setTextureOffset(24, 12).addBox(-3.5F, -8.6F, -5.3F, 7, 1, 1, -0.1F);
        this.panama.setTextureOffset(24, 10).addBox(-3.5F, -8.6F, 4.3F, 7, 1, 1, -0.1F);
        this.panama.setTextureOffset(0, 22).addBox(4.3F, -8.6F, -3.5F, 1, 1, 7, -0.1F);
        this.panama.setTextureOffset(21, 17).addBox(-5.3F, -8.6F, -3.5F, 1, 1, 7, -0.1F);
        this.bunny = new MModelRenderer(this);
        this.bunny.setRotationPoint(0.0F, -0.9F, 0.2F);
        this.main.addChild(this.bunny);
        this.bunny.setTextureOffset(12, 16).addBox(-2.0F, -12.5F, -2.0F, 4, 4, 4, 0.0F);
        this.bunny.setTextureOffset(27, 0).addBox(-1.5F, -10.5F, -2.5F, 3, 2, 1, 0.1F);
        this.bunny.setTextureOffset(12, 16).addBox(1.5F, -10.5F, -2.5F, 1, 2, 1, 0.0F);
        this.bunny.setTextureOffset(0, 6).addBox(-1.5F, -9.9F, -3.0F, 3, 1, 1, 0.1F);
        this.bunny.setTextureOffset(0, 22).addBox(-1.0F, -10.3F, -3.2F, 2, 1, 1, 0.2F);
        this.bunny.setTextureOffset(0, 24).addBox(-0.2F, -9.5F, -3.5F, 1, 1, 1, -0.2F);
        this.bunny.setTextureOffset(0, 24).addBox(-0.9F, -9.5F, -3.5F, 1, 1, 1, -0.2F);
        this.bunny.setTextureOffset(9, 23).addBox(-0.5F, -10.8F, -3.8F, 1, 1, 1, -0.2F);
        this.bunny.setTextureOffset(5, 0).addBox(-2.5F, -10.5F, -2.5F, 1, 2, 1, 0.0F);
        this.bunny.setTextureOffset(24, 25).addBox(-1.5F, -11.5F, 1.5F, 3, 3, 1, 0.0F);
        this.bunny.setTextureOffset(16, 24).addBox(1.5F, -11.5F, -1.5F, 1, 3, 3, 0.0F);
        this.bunny.setTextureOffset(0, 0).addBox(-2.5F, -11.5F, -1.5F, 1, 3, 3, 0.0F);
        this.bunny.setTextureOffset(0, 0).addBox(-1.0F, -12.0F, 0.0F, 1, 1, 1, 0.0F);
        this.ears = new MModelRenderer(this);
        this.ears.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bunny.addChild(this.ears);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(1.4F, -11.5F, -0.2F);
        this.ears.addChild(this.bone4);
        this.setRotation(this.bone4, 0.0F, -0.5236F, 0.2618F);
        this.bone4.setTextureOffset(0, 14).addBox(-0.9F, -0.9577F, -0.4031F, 2, 1, 1, -0.05F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.bone4.addChild(this.bone5);
        this.setRotation(this.bone5, 0.1309F, 0.0F, 0.0F);
        this.bone5.setTextureOffset(0, 12).addBox(-2.9F, -13.6759F, 1.277F, 2, 1, 1, -0.05F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.bone4.addChild(this.bone6);
        this.setRotation(this.bone6, 0.5236F, 0.0F, 0.0F);
        this.bone6.setTextureOffset(0, 10).addBox(-0.9F, 0.3039F, -1.1781F, 2, 1, 1, -0.05F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-1.6F, -11.5F, -0.2F);
        this.ears.addChild(this.bone);
        this.setRotation(this.bone, 0.0F, 0.5236F, -0.3054F);
        this.bone.setTextureOffset(0, 20).addBox(-0.9F, -0.9577F, -0.4031F, 2, 1, 1, -0.05F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.bone.addChild(this.bone2);
        this.setRotation(this.bone2, 0.1309F, 0.0F, 0.0F);
        this.bone2.setTextureOffset(0, 16).addBox(-2.9F, -13.6759F, 1.277F, 2, 1, 1, -0.05F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.bone.addChild(this.bone3);
        this.setRotation(this.bone3, 0.5236F, 0.0F, 0.0F);
        this.bone3.setTextureOffset(0, 18).addBox(-0.9F, 0.3039F, -1.1781F, 2, 1, 1, -0.05F);
        this.leaves = new MModelRenderer(this);
        this.leaves.setRotationPoint(0.0F, -0.8F, 0.0F);
        this.main.addChild(this.leaves);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(5.6F, 0.4F, 0.0F);
        this.leaves.addChild(this.bone8);
        this.setRotation(this.bone8, 0.0F, 0.0F, 0.0873F);
        this.bone8.setTextureOffset(12, 10).addBox(-4.3F, -8.8F, -3.2F, 3, 0, 6, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leaves.addChild(this.bone7);
        this.setRotation(this.bone7, 0.0F, 0.0F, -0.0873F);
        this.bone7.setTextureOffset(0, 16).addBox(-4.3F, -8.9F, -3.2F, 3, 0, 6, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-0.1F, 0.2F, 5.4F);
        this.leaves.addChild(this.bone9);
        this.setRotation(this.bone9, 0.0F, -1.5708F, 0.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-5.6F, -0.4F, 0.0F);
        this.bone9.addChild(this.bone10);
        this.setRotation(this.bone10, 0.0F, 0.0F, -0.0873F);
        this.bone10.setTextureOffset(6, 10).addBox(-4.3F, -8.7F, -3.2F, 3, 0, 6, 0.0F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone10.addChild(this.bone12);
        this.setRotation(this.bone12, 0.0F, -0.7854F, 0.0F);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.0F, 0.1F, 0.0F);
        this.bone9.addChild(this.bone11);
        this.setRotation(this.bone11, 0.0F, 0.0F, 0.0873F);
        this.bone11.setTextureOffset(0, 10).addBox(-4.3F, -8.8F, -3.2F, 3, 0, 6, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "head/bunnypanama.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -1.6F, 0.0F);
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -1.2F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u0430\u043d\u0430\u043c\u0430 \u0441 \u043a\u0440\u043e\u043b\u0438\u043a\u043e\u043c";
    }
}
