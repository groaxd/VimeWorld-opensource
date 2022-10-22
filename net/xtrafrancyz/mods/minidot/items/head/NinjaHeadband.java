package net.xtrafrancyz.mods.minidot.items.head;

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

public class NinjaHeadband extends BaseItem
{
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer levaya;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer pravaya;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bb_main;
    private final String color;
    private final IAnimation anim;

    public NinjaHeadband(String color)
    {
        super(ItemType.HEAD);
        this.color = color;
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 17.9F, 9.1F);
        this.setRotation(this.bone, 0.1745F, 0.0F, 0.0F);
        this.bone.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(4.5F, 20.5F, 0.5F);
        this.setRotation(this.bone2, 0.0F, -0.7854F, 0.0F);
        this.bone2.setTextureOffset(0, 13).addBox(-1.4192F, -3.5F, -0.7121F, 1, 2, 1, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-4.5F, 20.5F, 0.5F);
        this.setRotation(this.bone3, 0.0F, 0.7854F, 0.0F);
        this.bone3.setTextureOffset(10, 3).addBox(0.0192F, -3.5F, -0.7121F, 1, 2, 1, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-4.5F, 20.5F, 7.5F);
        this.setRotation(this.bone4, 0.0F, -0.7854F, 0.0F);
        this.bone4.setTextureOffset(4, 10).addBox(0.0192F, -3.5F, -0.2879F, 1, 2, 1, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(4.5F, 20.5F, 7.5F);
        this.setRotation(this.bone5, 0.0F, 0.7854F, 0.0F);
        this.bone5.setTextureOffset(0, 10).addBox(-1.4192F, -3.5F, -0.2879F, 1, 2, 1, 0.0F);
        this.levaya = new MModelRenderer(this);
        this.levaya.setRotationPoint(0.0F, 18.0F, 9.5F);
        this.setRotation(this.levaya, 0.1745F, 1.309F, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, 0.5F, 0.1F);
        this.levaya.addChild(this.bone6);
        this.bone6.setTextureOffset(4, 5).addBox(0.0F, -1.0F, 0.0F, 0, 1, 2, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.bone6.addChild(this.bone7);
        this.bone7.setTextureOffset(0, 5).addBox(0.0F, -1.0F, 0.0F, 0, 1, 2, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.bone7.addChild(this.bone8);
        this.bone8.setTextureOffset(4, 3).addBox(0.0F, -1.0F, 0.0F, 0, 1, 2, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.bone8.addChild(this.bone9);
        this.bone9.setTextureOffset(0, 1).addBox(0.0F, -1.0F, 0.0F, 0, 1, 3, 0.0F);
        this.pravaya = new MModelRenderer(this);
        this.pravaya.setRotationPoint(-0.4F, 18.0F, 9.5F);
        this.setRotation(this.pravaya, -0.0873F, 0.8727F, 0.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.0F, 0.5F, 0.1F);
        this.pravaya.addChild(this.bone10);
        this.bone10.setTextureOffset(4, 4).addBox(0.0F, -1.0F, 0.0F, 0, 1, 2, 0.0F);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.bone10.addChild(this.bone11);
        this.bone11.setTextureOffset(0, 4).addBox(0.0F, -1.0F, 0.0F, 0, 1, 2, 0.0F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.bone11.addChild(this.bone12);
        this.bone12.setTextureOffset(0, 3).addBox(0.0F, -1.0F, 0.0F, 0, 1, 2, 0.0F);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.bone12.addChild(this.bone13);
        this.bone13.setTextureOffset(0, 0).addBox(0.0F, -1.0F, 0.0F, 0, 1, 3, 0.0F);
        this.bb_main = new MModelRenderer(this);
        this.bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bb_main.setTextureOffset(10, 0).addBox(-4.0F, -7.0F, -1.0F, 8, 2, 1, 0.0F);
        this.bb_main.setTextureOffset(0, 10).addBox(4.0F, -7.0F, 0.0F, 1, 2, 8, 0.0F);
        this.bb_main.setTextureOffset(0, 0).addBox(-5.0F, -7.0F, 0.0F, 1, 2, 8, 0.0F);
        this.bb_main.setTextureOffset(10, 10).addBox(-4.0F, -7.0F, 8.0F, 8, 2, 1, 0.0F);
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/ninja_headband_animation.json"));
        this.anim = bbanimationloader.mustGet("ninja_headband", this);
        this.setTexture(new ResourceLocation("minidot", color.equals("red") ? "head/ninja_headband_red.png" : "head/ninja_headband_black.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -1.5F, -0.25F);
        GlStateManager.scale(1.05F, 1.05F, 1.05F);

        if (player.inventory.armorItemInSlot(3) != null)
        {
            GlStateManager.scale(1.05F, 1.05F, 1.05F);
            GlStateManager.translate(0.0F, -0.1F, 0.0F);
        }

        this.anim.tick(time);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        GlStateManager.translate(0.0F, -1.3F, -0.3F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public String getName()
    {
        return this.color.equals("red") ? "\u041a\u0440\u0430\u0441\u043d\u0430\u044f \u043f\u043e\u0432\u044f\u0437\u043a\u0430" : "\u0427\u0435\u0440\u043d\u0430\u044f \u043f\u043e\u0432\u044f\u0437\u043a\u0430";
    }

    public String getCreator()
    {
        return "chikon";
    }
}
