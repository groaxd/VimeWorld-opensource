package net.xtrafrancyz.mods.minidot.items.head;

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

public class FallenAngelNimbus extends BaseItem
{
    private final MModelRenderer Fallenangelhalo;
    private final MModelRenderer halo;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer flame;
    private final MModelRenderer particles;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final MModelRenderer bone16;
    private final MModelRenderer bone17;
    private final MModelRenderer bone18;
    private final MModelRenderer bone19;
    private final MModelRenderer bone10;
    private final MModelRenderer bone9;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final IAnimation animation;

    public FallenAngelNimbus()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Fallenangelhalo = new MModelRenderer(this);
        this.Fallenangelhalo.setRotationPoint(0.0F, -5.0F, 0.25F);
        this.setRotation(this.Fallenangelhalo, 0.0F, 0.0F, 1.5708F);
        this.halo = new MModelRenderer(this);
        this.halo.setRotationPoint(-1.0F, 0.0F, -0.25F);
        this.Fallenangelhalo.addChild(this.halo);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.setRotation(this.bone, -0.7854F, 0.0F, 0.0F);
        this.halo.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 5, 9, -0.75F, -4.0F, -1.3431F, 1, 1, 3, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.halo.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 8, 0, -0.75F, -3.7782F, -1.435F, 1, 1, 3, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.setRotation(this.bone3, -0.7854F, 0.0F, 0.0F);
        this.halo.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 8, -0.75F, 2.6863F, -1.3431F, 1, 1, 3, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.halo.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 5, 5, -0.75F, 2.7782F, -1.435F, 1, 1, 3, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.setRotation(this.bone5, -0.7854F, 0.0F, 0.0F);
        this.halo.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 12, 12, -0.75F, -1.6569F, -3.6863F, 1, 3, 1, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.halo.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 12, 8, -0.75F, -1.3431F, -3.5563F, 1, 3, 1, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.setRotation(this.bone7, -0.7854F, 0.0F, 0.0F);
        this.halo.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 12, -0.75F, -1.6569F, 3.0F, 1, 3, 1, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.halo.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 10, 4, -0.75F, -1.3431F, 3.0F, 1, 3, 1, 0.0F, false));
        this.flame = new MModelRenderer(this);
        this.flame.setRotationPoint(-2.5F, 0.0F, -0.1F);
        this.Fallenangelhalo.addChild(this.flame);
        this.flame.cubeList.add(new ModelBox(this.flame, 0, 4, 0.25F, -1.9993F, -3.7801F, 2, 4, 0, 0.0F, false));
        this.flame.cubeList.add(new ModelBox(this.flame, 0, 0, 0.25F, -2.0F, 4.0F, 2, 4, 0, 0.0F, false));
        this.flame.cubeList.add(new ModelBox(this.flame, 0, 4, 0.25F, 3.9159F, -1.9149F, 2, 0, 4, 0.0F, false));
        this.flame.cubeList.add(new ModelBox(this.flame, 0, 0, 0.25F, -3.9135F, -1.9149F, 2, 0, 4, 0.0F, false));
        this.particles = new MModelRenderer(this);
        this.particles.setRotationPoint(2.25F, 0.0F, 0.5F);
        this.flame.addChild(this.particles);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-1.0F, -1.0F, 3.3F);
        this.particles.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 5, 6, -0.5F, -0.5F, -0.05F, 1, 1, 0, 0.0F, false));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-1.0F, -1.0F, -4.25F);
        this.particles.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 5, 6, -0.5F, -0.5F, 0.05F, 1, 1, 0, 0.0F, false));
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(-1.0F, 1.75F, -4.2F);
        this.particles.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 5, 6, -0.5F, -0.5F, 0.0F, 1, 1, 0, 0.0F, false));
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(-1.0F, -3.75F, 0.65F);
        this.particles.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 5, 6, -0.5F, 0.0F, -0.5F, 1, 0, 1, 0.0F, false));
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(-1.0F, -3.75F, -1.35F);
        this.particles.addChild(this.bone17);
        this.bone17.cubeList.add(new ModelBox(this.bone17, 0, 2, -0.5F, 0.0F, -0.5F, 1, 0, 1, 0.0F, false));
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(-1.0F, 3.75F, -1.35F);
        this.particles.addChild(this.bone18);
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 2, -0.5F, 0.0F, -0.5F, 1, 0, 1, 0.0F, false));
        this.bone19 = new MModelRenderer(this);
        this.bone19.setRotationPoint(-1.0F, 3.75F, 0.65F);
        this.particles.addChild(this.bone19);
        this.bone19.cubeList.add(new ModelBox(this.bone19, 3, 6, -0.5F, 0.0F, -0.5F, 1, 0, 1, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(1.5F, 0.0F, 0.5F);
        this.setRotation(this.bone10, -0.7854F, 0.0F, 0.0F);
        this.flame.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 14, 4, -1.25F, -0.7061F, -4.3713F, 2, 2, 0, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(1.5F, 0.0F, 0.5F);
        this.setRotation(this.bone9, 0.7854F, 0.0F, 0.0F);
        this.flame.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 8, 13, -1.25F, -1.2929F, 3.7845F, 2, 2, 0, 0.0F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(1.5F, 0.0F, 0.5F);
        this.setRotation(this.bone11, -0.7854F, 0.0F, 0.0F);
        this.flame.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 4, 13, -1.25F, -0.7061F, 3.7855F, 2, 2, 0, 0.0F, false));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(1.5F, 0.0F, 0.5F);
        this.setRotation(this.bone12, 0.7854F, 0.0F, 0.0F);
        this.flame.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 13, 0, -1.25F, -1.2929F, -4.3733F, 2, 2, 0, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/fallenangelnimbus.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/fallenangelnimbus_animation.json"));
        this.animation = bbanimationloader.mustGet("nimb.default", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, -0.3D, 0.0D);
        double d0 = 1.2D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tick(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        double d0 = 1.3D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, 0.1D, 0.0D);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041d\u0438\u043c\u0431 \u043f\u0430\u0434\u0448\u0435\u0433\u043e \u0430\u043d\u0433\u0435\u043b\u0430";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
