package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.model.ModelBox;
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

public class DraculasCloak extends BaseItem
{
    private final MModelRenderer DraculasCloak;
    private final MModelRenderer Cape;
    private final MModelRenderer Base;
    private final MModelRenderer AdditionRight;
    private final MModelRenderer AdditionLeft;
    private final MModelRenderer Hooded;
    private final MModelRenderer bone4;
    private final MModelRenderer bone9;
    private final IAnimation animation;

    public DraculasCloak()
    {
        super(ItemType.BODY);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.DraculasCloak = new MModelRenderer(this);
        this.DraculasCloak.setRotationPoint(0.0F, -5.0F, -1.0F);
        this.Cape = new MModelRenderer(this);
        this.Cape.setRotationPoint(0.0F, -12.0F, 2.0F);
        this.setRotation(this.Cape, -0.3491F, 0.0F, 0.0F);
        this.DraculasCloak.addChild(this.Cape);
        this.Base = new MModelRenderer(this);
        this.Base.setRotationPoint(0.0F, 0.5F, -0.5F);
        this.setRotation(this.Base, 0.5672F, 0.0F, 0.0F);
        this.Cape.addChild(this.Base);
        this.Base.cubeList.add(new ModelBox(this.Base, 0, 8, -4.0F, -0.1959F, 0.7039F, 8, 16, 0, 0.0F, false));
        this.AdditionRight = new MModelRenderer(this);
        this.AdditionRight.setRotationPoint(0.0F, 0.5F, -0.5F);
        this.setRotation(this.AdditionRight, 0.6237F, -0.2876F, 0.0625F);
        this.Cape.addChild(this.AdditionRight);
        this.AdditionRight.cubeList.add(new ModelBox(this.AdditionRight, 16, 3, -4.0F, 0.0041F, 0.7039F, 5, 16, 0, 0.0F, false));
        this.AdditionLeft = new MModelRenderer(this);
        this.AdditionLeft.setRotationPoint(0.0F, 0.7F, -0.5F);
        this.setRotation(this.AdditionLeft, 0.6237F, 0.2876F, -0.0625F);
        this.Cape.addChild(this.AdditionLeft);
        this.AdditionLeft.cubeList.add(new ModelBox(this.AdditionLeft, 16, 3, -1.0F, -0.1959F, 0.7039F, 5, 16, 0, 0.0F, true));
        this.Hooded = new MModelRenderer(this);
        this.Hooded.setRotationPoint(0.0F, -9.25F, -2.025F);
        this.DraculasCloak.addChild(this.Hooded);
        this.bone4 = new MModelRenderer(this);
        this.setRotation(this.bone4, 0.0F, 0.0F, 0.7418F);
        this.Hooded.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 3, -4.0F, -3.0F, -8.0E-4F, 7, 3, 0, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.setRotation(this.bone9, 0.0F, 0.0F, -0.7418F);
        this.Hooded.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 0, -3.0F, -3.0F, 0.0F, 7, 3, 0, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "body/draculascloak.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/draculascloak_animation.json"));
        this.animation = bbanimationloader.mustGet("animation.model.new", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, 1.26D, 0.09D);
        float f = 1.15F;
        GlStateManager.scale(f, f, f);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.8D, 0.3D);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u043b\u0430\u0449 \u0414\u0440\u0430\u043a\u0443\u043b\u044b";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
