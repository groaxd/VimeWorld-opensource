package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class HeadSprout extends BaseItem
{
    private final MModelRenderer sprout;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer leafs2;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer leafs1;
    private final MModelRenderer bone9;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone6;
    private final MModelRenderer bone5;
    private final IAnimation anim;

    public HeadSprout()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.sprout = new MModelRenderer(this);
        this.sprout.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.sprout.setTextureOffset(0, 8).addBox(-0.5F, -7.0F, -0.5F, 1, 6, 1, 0.0F);
        this.sprout.setTextureOffset(4, 11).addBox(-0.5F, -7.9F, -0.5F, 1, 1, 1, -1.0E-4F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.sprout.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 0.0F, -0.7854F);
        this.bone2.setTextureOffset(4, 8).addBox(-1.0607F, -1.6464F, -0.5F, 1, 2, 1, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.sprout.addChild(this.bone);
        this.setRotation(this.bone, 0.0F, 0.0F, 0.7854F);
        this.bone.setTextureOffset(8, 8).addBox(0.0607F, -1.6464F, -0.5F, 1, 2, 1, 1.0E-4F);
        this.leafs2 = new MModelRenderer(this);
        this.leafs2.setRotationPoint(0.9F, -8.8F, 0.0F);
        this.sprout.addChild(this.leafs2);
        this.setRotation(this.leafs2, 0.0F, 3.1416F, 0.48F);
        this.leafs2.setTextureOffset(7, 0).addBox(-3.6F, -0.5F, -0.5F, 4, 0, 1, 0.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-2.0F, -0.1F, 0.5F);
        this.leafs2.addChild(this.bone10);
        this.setRotation(this.bone10, -0.3491F, 0.0F, 0.0F);
        this.bone10.setTextureOffset(0, 2).addBox(-1.6F, -0.3758F, -0.1372F, 3, 0, 2, 0.0F);
        this.bone10.setTextureOffset(6, 8).addBox(1.4F, -0.3758F, -0.1372F, 1, 0, 1, 0.0F);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-2.0F, -0.1F, -0.5F);
        this.leafs2.addChild(this.bone11);
        this.setRotation(this.bone11, 0.3491F, 0.0F, 0.0F);
        this.bone11.setTextureOffset(0, 0).addBox(-1.6F, -0.3758F, -1.8628F, 3, 0, 2, 0.0F);
        this.bone11.setTextureOffset(2, 8).addBox(1.4F, -0.3758F, -0.8628F, 1, 0, 1, 0.0F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(-5.2F, -0.4F, 0.0F);
        this.leafs2.addChild(this.bone12);
        this.setRotation(this.bone12, -0.3491F, 0.0F, -0.3491F);
        this.bone12.setTextureOffset(7, 4).addBox(-1.4619F, 0.255F, 0.6245F, 3, 0, 1, 0.0F);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-5.2F, -0.4F, 0.0F);
        this.leafs2.addChild(this.bone13);
        this.setRotation(this.bone13, 0.3491F, 0.0F, -0.3491F);
        this.bone13.setTextureOffset(7, 3).addBox(-1.4619F, 0.2541F, -1.6242F, 3, 0, 1, 0.0F);
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-5.2F, -0.4F, 0.0F);
        this.leafs2.addChild(this.bone14);
        this.setRotation(this.bone14, 0.0F, 0.0F, -0.3491F);
        this.bone14.setTextureOffset(7, 7).addBox(-2.4619F, 0.4523F, -0.5F, 4, 0, 1, 0.0F);
        this.leafs1 = new MModelRenderer(this);
        this.leafs1.setRotationPoint(-1.1F, -8.8F, 0.0F);
        this.sprout.addChild(this.leafs1);
        this.setRotation(this.leafs1, 0.0F, 0.0F, -0.48F);
        this.leafs1.setTextureOffset(7, 2).addBox(-3.6F, -0.5F, -0.5F, 4, 0, 1, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-2.0F, -0.1F, 0.5F);
        this.leafs1.addChild(this.bone9);
        this.setRotation(this.bone9, -0.3491F, 0.0F, 0.0F);
        this.bone9.setTextureOffset(0, 4).addBox(-1.6F, -0.3758F, -0.1372F, 3, 0, 2, 0.0F);
        this.bone9.setTextureOffset(6, 11).addBox(1.4F, -0.3758F, -0.1372F, 1, 0, 1, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-2.0F, -0.1F, -0.5F);
        this.leafs1.addChild(this.bone7);
        this.setRotation(this.bone7, 0.3491F, 0.0F, 0.0F);
        this.bone7.setTextureOffset(0, 6).addBox(-1.6F, -0.3758F, -1.8628F, 3, 0, 2, 0.0F);
        this.bone7.setTextureOffset(10, 8).addBox(1.4F, -0.3758F, -0.8628F, 1, 0, 1, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-5.2F, -0.4F, 0.0F);
        this.leafs1.addChild(this.bone8);
        this.setRotation(this.bone8, -0.3491F, 0.0F, -0.3491F);
        this.bone8.setTextureOffset(7, 5).addBox(-1.4619F, 0.255F, 0.6245F, 3, 0, 1, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-5.2F, -0.4F, 0.0F);
        this.leafs1.addChild(this.bone6);
        this.setRotation(this.bone6, 0.3491F, 0.0F, -0.3491F);
        this.bone6.setTextureOffset(7, 6).addBox(-1.4619F, 0.2541F, -1.6242F, 3, 0, 1, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-5.2F, -0.4F, 0.0F);
        this.leafs1.addChild(this.bone5);
        this.setRotation(this.bone5, 0.0F, 0.0F, -0.3491F);
        this.bone5.setTextureOffset(7, 1).addBox(-2.4619F, 0.4523F, -0.5F, 4, 0, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "head/headsprout.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/headsprout_animation.json"));
        this.anim = bbanimationloader.mustGet("leaf.rotating", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.anim.tick(time);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, -1.88F, 0.0F);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(195.0F + MathHelper.cos(rotation * 0.07F + (float)number) * 10.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.95F, 0.95F, 0.95F);
        GlStateManager.translate(0.0F, -1.5F, 0.0F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0420\u043e\u0441\u0442\u043e\u043a \u0446\u0432\u0435\u0442\u043a\u0430";
    }
}
