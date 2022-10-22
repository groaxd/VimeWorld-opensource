package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class JetPack extends BaseItem
{
    private final MModelRenderer root;
    private final MModelRenderer jetpack;
    private final MModelRenderer Left;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer Right;
    private final MModelRenderer bone4;
    private final MModelRenderer bone3;
    private final IAnimation anim;

    public JetPack()
    {
        super(ItemType.BODY);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.root = new MModelRenderer(this);
        this.root.setRotationPoint(0.0F, 15.0F, -2.7F);
        this.jetpack = new MModelRenderer(this);
        this.jetpack.setRotationPoint(0.0F, 1.0F, -0.3F);
        this.root.addChild(this.jetpack);
        this.jetpack.setTextureOffset(0, 11).addBox(-4.0F, -10.7F, -1.7F, 8, 5, 1, 0.0F);
        this.jetpack.setTextureOffset(17, 17).addBox(-2.0F, -9.9F, 0.5F, 4, 4, 3, 0.0F);
        this.Left = new MModelRenderer(this);
        this.Left.setRotationPoint(2.64F, -6.2F, 1.16F);
        this.jetpack.addChild(this.Left);
        this.Left.setTextureOffset(0, 2).addBox(-0.64F, -7.5F, -0.66F, 1, 1, 1, 0.0F);
        this.Left.setTextureOffset(18, 12).addBox(-1.64F, -6.7F, -1.66F, 3, 2, 3, 0.0F);
        this.Left.setTextureOffset(0, 0).addBox(-2.14F, -5.5F, -2.16F, 4, 7, 4, 0.0F);
        this.Left.setTextureOffset(16, 0).addBox(-2.14F, -2.3F, -2.16F, 4, 1, 4, 0.1F);
        this.Left.setTextureOffset(0, 17).addBox(-2.14F, 1.2F, -2.16F, 4, 2, 4, -0.2F);
        this.Left.setTextureOffset(0, 23).addBox(-2.14F, 1.4F, -2.16F, 4, 3, 4, -0.5F);
        this.Left.setTextureOffset(16, 5).addBox(-0.24F, -1.2F, -0.66F, 3, 4, 1, -0.4F);
        this.Left.setTextureOffset(24, 5).addBox(-0.64F, -1.2F, -0.06F, 1, 4, 3, -0.4F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-0.14F, 3.4F, -0.16F);
        this.Left.addChild(this.bone);
        this.bone.setTextureOffset(12, 17).addBox(-1.5F, 0.0F, 0.0F, 3, 3, 0, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-0.14F, 3.4F, -0.16F);
        this.Left.addChild(this.bone2);
        this.bone2.setTextureOffset(12, 14).addBox(0.0F, 0.0F, -1.5F, 0, 3, 3, 0.0F);
        this.Right = new MModelRenderer(this);
        this.Right.setRotationPoint(-2.64F, -6.2F, 1.16F);
        this.jetpack.addChild(this.Right);
        this.Right.setTextureOffset(0, 0).addBox(-0.36F, -7.5F, -0.66F, 1, 1, 1, 0.0F);
        this.Right.setTextureOffset(18, 12).addBox(-1.36F, -6.7F, -1.66F, 3, 2, 3, 0.0F);
        this.Right.setTextureOffset(0, 0).addBox(-1.86F, -5.5F, -2.16F, 4, 7, 4, 0.0F);
        this.Right.setTextureOffset(16, 0).addBox(-1.86F, -2.3F, -2.16F, 4, 1, 4, 0.1F);
        this.Right.setTextureOffset(24, 5).addBox(-0.36F, -1.2F, -0.06F, 1, 4, 3, -0.4F);
        this.Right.setTextureOffset(0, 17).addBox(-1.86F, 1.2F, -2.16F, 4, 2, 4, -0.2F);
        this.Right.setTextureOffset(0, 23).addBox(-1.86F, 1.4F, -2.16F, 4, 3, 4, -0.5F);
        this.Right.setTextureOffset(16, 5).addBox(-2.76F, -1.2F, -0.66F, 3, 4, 1, -0.4F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.14F, 3.4F, -0.16F);
        this.Right.addChild(this.bone4);
        this.bone4.setTextureOffset(12, 17).addBox(-1.5F, 0.0F, 0.0F, 3, 3, 0, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.14F, 3.4F, -0.16F);
        this.Right.addChild(this.bone3);
        this.bone3.setTextureOffset(12, 14).addBox(0.0F, 0.0F, -1.5F, 0, 3, 3, 0.0F);
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/jetpack_animation.json"));
        this.anim = bbanimationloader.mustGet("jetpack.anim", this);
        this.setTexture(new ResourceLocation("minidot", "body/jetpack.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -0.15F, 0.41F);
        this.anim.tick(time);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.1F, 0.5F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0420\u0435\u0430\u043a\u0442\u0438\u0432\u043d\u044b\u0439 \u0440\u0430\u043d\u0435\u0446";
    }

    public String getCreator()
    {
        return "chikon";
    }
}
