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

public class SwineAct extends BaseItem
{
    private final MModelRenderer bone;
    private final MModelRenderer cube_r1;
    private final MModelRenderer cube_r2;
    private final MModelRenderer cube_r3;
    private final MModelRenderer cube_r4;
    private final MModelRenderer cube_r5;
    private final MModelRenderer cube_r6;
    private final MModelRenderer bone2;
    private final MModelRenderer cube_r7;
    private final MModelRenderer cube_r8;
    private final MModelRenderer bone3;
    private final MModelRenderer bb_main;
    private final MModelRenderer cube_r9;
    private final MModelRenderer cube_r10;
    private final IAnimation anim;

    public SwineAct()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.cube_r1 = new MModelRenderer(this);
        this.cube_r1.setRotationPoint(0.0F, -7.35F, 1.425F);
        this.bone.addChild(this.cube_r1);
        this.setRotation(this.cube_r1, 0.0611F, 0.0F, 0.0F);
        this.cube_r1.setTextureOffset(14, 0).addBox(-1.5F, -0.375F, -2.225F, 3, 2, 3, -0.375F);
        this.cube_r1.setTextureOffset(0, 9).addBox(-2.0F, -1.375F, -1.5F, 4, 3, 3, -0.1F);
        this.cube_r2 = new MModelRenderer(this);
        this.cube_r2.setRotationPoint(1.5496F, -0.875F, -0.9765F);
        this.bone.addChild(this.cube_r2);
        this.setRotation(this.cube_r2, 0.1134F, -0.3622F, 0.0F);
        this.cube_r2.setTextureOffset(16, 10).addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, -0.25F);
        this.cube_r3 = new MModelRenderer(this);
        this.cube_r3.setRotationPoint(0.0F, -4.661F, -0.6655F);
        this.bone.addChild(this.cube_r3);
        this.setRotation(this.cube_r3, 0.1837F, 0.2502F, 0.0382F);
        this.cube_r3.setTextureOffset(0, 15).addBox(-0.1346F, -0.9932F, -1.2763F, 2, 2, 3, -0.25F);
        this.cube_r4 = new MModelRenderer(this);
        this.cube_r4.setRotationPoint(0.0F, -4.661F, -0.6655F);
        this.bone.addChild(this.cube_r4);
        this.setRotation(this.cube_r4, 0.1837F, -0.2502F, -0.0382F);
        this.cube_r4.setTextureOffset(10, 16).addBox(-1.8654F, -0.9932F, -1.2763F, 2, 2, 3, -0.25F);
        this.cube_r5 = new MModelRenderer(this);
        this.cube_r5.setRotationPoint(-1.5496F, -0.875F, -0.9765F);
        this.bone.addChild(this.cube_r5);
        this.setRotation(this.cube_r5, 0.1134F, 0.3622F, 0.0F);
        this.cube_r5.setTextureOffset(17, 18).addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, -0.25F);
        this.cube_r6 = new MModelRenderer(this);
        this.cube_r6.setRotationPoint(0.0F, -2.875F, 1.5F);
        this.bone.addChild(this.cube_r6);
        this.setRotation(this.cube_r6, -0.0785F, 0.0F, 0.0F);
        this.cube_r6.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, -1.5F, 4, 6, 3, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.cube_r7 = new MModelRenderer(this);
        this.cube_r7.setRotationPoint(0.1083F, -6.0971F, -3.69F);
        this.bone2.addChild(this.cube_r7);
        this.setRotation(this.cube_r7, -0.5061F, 0.0F, 0.0F);
        this.cube_r7.setTextureOffset(11, 5).addBox(-0.6083F, -0.8163F, -4.5166F, 1, 1, 4, -0.275F);
        this.cube_r8 = new MModelRenderer(this);
        this.cube_r8.setRotationPoint(0.1083F, -6.0971F, -3.69F);
        this.bone2.addChild(this.cube_r8);
        this.setRotation(this.cube_r8, -0.7025F, 0.0F, 0.0F);
        this.cube_r8.setTextureOffset(9, 10).addBox(-0.6083F, -0.6279F, -1.41F, 1, 1, 5, -0.25F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 15.825F, -7.1125F);
        this.bone3.setTextureOffset(0, 20).addBox(-0.5F, -0.45F, -0.5125F, 1, 6, 1, -0.45F);
        this.bone3.setTextureOffset(17, 5).addBox(-1.5F, 4.3F, -0.4875F, 3, 3, 1, -0.675F);
        this.bb_main = new MModelRenderer(this);
        this.bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.cube_r9 = new MModelRenderer(this);
        this.cube_r9.setRotationPoint(0.0F, -7.48F, 1.375F);
        this.bb_main.addChild(this.cube_r9);
        this.setRotation(this.cube_r9, 0.1343F, 0.0384F, -0.2767F);
        this.cube_r9.setTextureOffset(15, 26).addBox(1.3764F, -0.962F, -1.5F, 1, 3, 3, -0.425F);
        this.cube_r10 = new MModelRenderer(this);
        this.cube_r10.setRotationPoint(0.0F, -7.48F, 1.375F);
        this.bb_main.addChild(this.cube_r10);
        this.setRotation(this.cube_r10, 0.1343F, -0.0384F, 0.2767F);
        this.cube_r10.setTextureOffset(24, 26).addBox(-2.3764F, -0.962F, -1.5F, 1, 3, 3, -0.425F);
        this.setTexture(new ResourceLocation("minidot", "head/swineact.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/swineact_animation.json"));
        this.anim = bbanimationloader.mustGet("swineact.anim", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.anim.tick(time);
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -2.0F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -1.5F, 0.0F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u0432\u0438\u043d\u0441\u043a\u0438\u0439 \u043f\u043e\u0441\u0442\u0443\u043f\u043e\u043a";
    }

    public String getCreator()
    {
        return "GUllT";
    }
}
