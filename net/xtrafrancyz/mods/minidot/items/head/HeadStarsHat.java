package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
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

public class HeadStarsHat extends BaseItem
{
    private final MModelRenderer model_scene;
    private final MModelRenderer stars;
    private final MModelRenderer bone9;
    private final MModelRenderer bone8;
    private final MModelRenderer bone7;
    private final MModelRenderer bone6;
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer hammer2;
    private final IAnimation animation;

    public HeadStarsHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.model_scene = new MModelRenderer(this);
        this.model_scene.setRotationPoint(-1.0F, 33.0F, -1.0F);
        this.stars = new MModelRenderer(this);
        this.stars.setRotationPoint(1.0F, -33.0F, 1.0F);
        this.model_scene.addChild(this.stars);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, -1.0F, -4.0F);
        this.setRotation(this.bone9, 0.0F, 1.5708F, 0.0F);
        this.stars.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 0, 0.0F, -1.0F, -1.5F, 0, 2, 3, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, -1.0F, 4.0F);
        this.setRotation(this.bone8, 0.0F, 1.5708F, 0.0F);
        this.stars.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 0, 0.0F, -1.0F, -1.5F, 0, 2, 3, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(3.0F, -1.0F, -3.0F);
        this.setRotation(this.bone7, 0.0F, 0.7854F, 0.0F);
        this.stars.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 0, 0.0F, -1.0F, -1.5F, 0, 2, 3, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(4.0F, -1.0F, 0.0F);
        this.stars.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 0, 0.0F, -1.0F, -1.5F, 0, 2, 3, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(3.0F, -1.0F, 3.0F);
        this.setRotation(this.bone5, 0.0F, -0.7854F, 0.0F);
        this.stars.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 0, 0.0F, -1.0F, -1.5F, 0, 2, 3, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-3.0F, -1.0F, -3.0F);
        this.setRotation(this.bone4, 0.0F, -0.7854F, 0.0F);
        this.stars.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 0, 0.0F, -1.0F, -1.5F, 0, 2, 3, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-3.0F, -1.0F, 3.0F);
        this.setRotation(this.bone3, 0.0F, 0.7854F, 0.0F);
        this.stars.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 0, 0.0F, -1.0F, -1.5F, 0, 2, 3, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-4.0F, -1.0F, 0.0F);
        this.stars.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, 0.0F, -1.0F, -1.5F, 0, 2, 3, 0.0F, false));
        this.hammer2 = new MModelRenderer(this);
        this.hammer2.setRotationPoint(1.25F, -42.0F, 16.0F);
        this.model_scene.addChild(this.hammer2);
        this.hammer2.cubeList.add(new ModelBox(this.hammer2, 16, 14, -2.5F, -4.5F, -13.0F, 4, 3, 4, -0.5F, false));
        this.hammer2.cubeList.add(new ModelBox(this.hammer2, 0, 14, -2.5F, -4.5F, -13.0F, 4, 8, 4, -0.7F, false));
        this.hammer2.cubeList.add(new ModelBox(this.hammer2, 15, 0, -2.5F, 0.5F, -13.0F, 4, 3, 4, -0.5F, false));
        this.hammer2.cubeList.add(new ModelBox(this.hammer2, 0, 0, -1.0F, -1.0F, -13.0F, 1, 1, 13, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/headstarshat.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/headstarshat_animation.json"));
        this.animation = bbanimationloader.mustGet("headstarshat.animation", this);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.06F + (float)number * 0.5F) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        double d0 = 0.8048D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, 0.1D, 0.0D);
        super.renderAsItem(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, -0.549D, 0.0D);
        this.animation.tick(time);
    }

    public String getName()
    {
        return "\u0417\u0432\u0435\u0437\u0434\u043e\u0447\u043a\u0438 \u043d\u0430 \u0433\u043e\u043b\u043e\u0432\u0435";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
