package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BunnyHelm extends BaseHelm
{
    private final MModelRenderer main;
    private final MModelRenderer bunny;
    private final MModelRenderer ears;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;

    public BunnyHelm()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.main = new MModelRenderer(this);
        this.main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bunny = new MModelRenderer(this);
        this.bunny.setRotationPoint(0.0F, 0.0F, 0.1F);
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
        this.setTexture(new ResourceLocation("minidot", "head/bunnypanama.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(2.3F, 2.3F, 2.3F);
        GlStateManager.translate(0.0F, -0.95F, -0.005F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -1.6F, 0.0F);
        GlStateManager.scale(1.4F, 1.4F, 1.4F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u043b\u0435\u043c \u043a\u0440\u043e\u043b\u0438\u043a\u0430";
    }
}
