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

public class Piglin extends BaseItem
{
    private final MModelRenderer Project;
    private final MModelRenderer Dust;
    private final MModelRenderer d1;
    private final MModelRenderer d2;
    private final MModelRenderer d3;
    private final MModelRenderer Backback;
    private final MModelRenderer Piglin;
    private final MModelRenderer Body;
    private final MModelRenderer RightArm;
    private final MModelRenderer Flintandsteel;
    private final MModelRenderer Gold;
    private final MModelRenderer LeftArm;
    private final MModelRenderer Torch;
    private final MModelRenderer off;
    private final MModelRenderer one;
    private final MModelRenderer flame1;
    private final MModelRenderer two;
    private final MModelRenderer flame2;
    private final MModelRenderer three;
    private final MModelRenderer flame3;
    private final MModelRenderer RightLeg;
    private final MModelRenderer LeftLeg;
    private final MModelRenderer Head;
    private final MModelRenderer moth;
    private final MModelRenderer Ear1;
    private final MModelRenderer Ear2;
    private final IAnimation animation;

    public Piglin()
    {
        super(ItemType.BODY);
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Project = new MModelRenderer(this);
        this.Project.setRotationPoint(-6.0F, 0.0F, 0.0F);
        this.Dust = new MModelRenderer(this);
        this.Dust.setRotationPoint(6.0F, -24.0F, 0.0F);
        this.Project.addChild(this.Dust);
        this.d1 = new MModelRenderer(this);
        this.d1.setRotationPoint(-2.5F, -0.5F, -10.5F);
        this.Dust.addChild(this.d1);
        this.d1.cubeList.add(new ModelBox(this.d1, 31, 14, -0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F, false));
        this.d2 = new MModelRenderer(this);
        this.d2.setRotationPoint(-2.5F, -0.5F, -10.5F);
        this.Dust.addChild(this.d2);
        this.d2.cubeList.add(new ModelBox(this.d2, 31, 14, 2.5F, -0.5F, 1.5F, 1, 1, 1, 0.0F, false));
        this.d3 = new MModelRenderer(this);
        this.d3.setRotationPoint(-0.5F, -0.5F, -7.5F);
        this.Dust.addChild(this.d3);
        this.d3.cubeList.add(new ModelBox(this.d3, 31, 14, -0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F, false));
        this.Backback = new MModelRenderer(this);
        this.Backback.setRotationPoint(6.0F, 0.0F, 0.0F);
        this.Project.addChild(this.Backback);
        this.Backback.cubeList.add(new ModelBox(this.Backback, 0, 45, -5.0F, -13.0F, -10.0F, 10, 13, 1, 0.0F, false));
        this.Backback.cubeList.add(new ModelBox(this.Backback, 67, 64, -5.0F, -13.0F, -9.0F, 1, 13, 5, 0.0F, false));
        this.Backback.cubeList.add(new ModelBox(this.Backback, 16, 61, 4.0F, -13.0F, -9.0F, 1, 13, 5, 0.0F, false));
        this.Backback.cubeList.add(new ModelBox(this.Backback, 36, 0, -4.0F, -5.0F, -9.0F, 8, 5, 5, 0.0F, false));
        this.Backback.cubeList.add(new ModelBox(this.Backback, 11, 79, -5.0F, -13.0F, -4.0F, 10, 13, 3, 0.0F, false));
        this.Backback.cubeList.add(new ModelBox(this.Backback, 64, 22, -5.0F, -7.0F, -11.0F, 10, 7, 1, 0.0F, false));
        this.Backback.cubeList.add(new ModelBox(this.Backback, 45, 68, -7.0F, -8.0F, -8.0F, 2, 7, 5, 0.0F, false));
        this.Backback.cubeList.add(new ModelBox(this.Backback, 70, 0, 5.0F, -6.0F, -7.0F, 2, 5, 4, 0.0F, false));
        this.Piglin = new MModelRenderer(this);
        this.Piglin.setRotationPoint(6.5F, -19.0F, 0.0F);
        this.Project.addChild(this.Piglin);
        this.Body = new MModelRenderer(this);
        this.Body.setRotationPoint(-0.5F, -5.0F, 0.0F);
        this.Piglin.addChild(this.Body);
        this.Body.cubeList.add(new ModelBox(this.Body, 24, 29, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, false));
        this.Body.cubeList.add(new ModelBox(this.Body, 0, 29, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.26F, false));
        this.RightArm = new MModelRenderer(this);
        this.RightArm.setRotationPoint(-5.5F, -3.0F, 0.0F);
        this.Piglin.addChild(this.RightArm);
        this.RightArm.cubeList.add(new ModelBox(this.RightArm, 60, 36, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
        this.RightArm.cubeList.add(new ModelBox(this.RightArm, 0, 59, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F, false));
        this.Flintandsteel = new MModelRenderer(this);
        this.Flintandsteel.setRotationPoint(25.5F, 4.5F, 0.5F);
        this.RightArm.addChild(this.Flintandsteel);
        this.Flintandsteel.cubeList.add(new ModelBox(this.Flintandsteel, 67, 82, -11.0F, 1.0F, -3.0F, 13, 15, 1, 0.0F, false));
        this.Gold = new MModelRenderer(this);
        this.Gold.setRotationPoint(21.0F, 13.0F, 0.0F);
        this.RightArm.addChild(this.Gold);
        this.Gold.cubeList.add(new ModelBox(this.Gold, 0, 16, -8.0F, -6.0F, 0.5F, 17, 12, 1, 0.0F, false));
        this.Gold.cubeList.add(new ModelBox(this.Gold, 20, 31, -6.0F, 4.0F, 0.0F, 1, 1, 1, 0.0F, false));
        this.Gold.cubeList.add(new ModelBox(this.Gold, 20, 31, -7.0F, 3.0F, 0.0F, 1, 1, 1, 0.0F, false));
        this.Gold.cubeList.add(new ModelBox(this.Gold, 44, 26, -8.0F, -2.0F, 0.0F, 1, 5, 1, 0.0F, false));
        this.Gold.cubeList.add(new ModelBox(this.Gold, 0, 4, -7.0F, -3.0F, 0.0F, 3, 1, 1, 0.0F, false));
        this.Gold.cubeList.add(new ModelBox(this.Gold, 0, 4, -4.0F, -4.0F, 0.0F, 3, 1, 1, 0.0F, false));
        this.Gold.cubeList.add(new ModelBox(this.Gold, 0, 4, -1.0F, -5.0F, 0.0F, 3, 1, 1, 0.0F, false));
        this.Gold.cubeList.add(new ModelBox(this.Gold, 28, 5, 2.0F, -6.0F, 0.0F, 2, 1, 1, 0.0F, false));
        this.Gold.cubeList.add(new ModelBox(this.Gold, 20, 31, 4.0F, -5.0F, 0.0F, 1, 1, 1, 0.0F, false));
        this.Gold.cubeList.add(new ModelBox(this.Gold, 20, 31, 5.0F, -4.0F, 0.0F, 1, 1, 1, 0.0F, false));
        this.Gold.cubeList.add(new ModelBox(this.Gold, 24, 31, 6.0F, -3.0F, 0.0F, 1, 1, 1, 0.0F, false));
        this.Gold.cubeList.add(new ModelBox(this.Gold, 38, 45, 7.0F, -2.0F, 0.0F, 1, 4, 1, 0.0F, false));
        this.Gold.cubeList.add(new ModelBox(this.Gold, 20, 29, 5.0F, 2.0F, 0.0F, 2, 1, 1, 0.0F, false));
        this.Gold.cubeList.add(new ModelBox(this.Gold, 0, 6, 2.0F, 3.0F, 0.0F, 3, 1, 1, 0.0F, false));
        this.Gold.cubeList.add(new ModelBox(this.Gold, 0, 6, -1.0F, 4.0F, 0.0F, 3, 1, 1, 0.0F, false));
        this.Gold.cubeList.add(new ModelBox(this.Gold, 36, 24, -5.0F, 5.0F, 0.0F, 4, 1, 1, 0.0F, false));
        this.LeftArm = new MModelRenderer(this);
        this.LeftArm.setRotationPoint(4.5F, -3.0F, 0.0F);
        this.Piglin.addChild(this.LeftArm);
        this.LeftArm.cubeList.add(new ModelBox(this.LeftArm, 58, 6, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
        this.LeftArm.cubeList.add(new ModelBox(this.LeftArm, 34, 57, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F, false));
        this.Torch = new MModelRenderer(this);
        this.Torch.setRotationPoint(15.5F, 4.5F, 0.5F);
        this.LeftArm.addChild(this.Torch);
        this.Torch.cubeList.add(new ModelBox(this.Torch, 59, 72, -1.5F, -7.5F, -0.5F, 2, 8, 2, 0.0F, false));
        this.off = new MModelRenderer(this);
        this.off.setRotationPoint(0.5F, 0.5F, -0.5F);
        this.Torch.addChild(this.off);
        this.off.cubeList.add(new ModelBox(this.off, 59, 82, -2.0F, -10.0F, 0.0F, 2, 2, 2, 0.0F, false));
        this.one = new MModelRenderer(this);
        this.one.setRotationPoint(0.5F, 0.5F, -0.5F);
        this.Torch.addChild(this.one);
        this.one.cubeList.add(new ModelBox(this.one, 59, 94, -2.0F, -10.0F, 0.0F, 2, 2, 2, 0.0F, false));
        this.flame1 = new MModelRenderer(this);
        this.flame1.setRotationPoint(-1.0F, -10.0F, 1.0F);
        this.one.addChild(this.flame1);
        this.flame1.cubeList.add(new ModelBox(this.flame1, 47, 98, -2.0F, -8.0F, 0.0F, 4, 8, 1, 0.0F, false));
        this.flame1.cubeList.add(new ModelBox(this.flame1, 47, 98, -2.4F, -8.0F, 0.5F, 4, 8, 1, 0.0F, false));
        this.two = new MModelRenderer(this);
        this.two.setRotationPoint(0.5F, 0.5F, -0.5F);
        this.Torch.addChild(this.two);
        this.two.cubeList.add(new ModelBox(this.two, 59, 90, -2.0F, -10.0F, 0.0F, 2, 2, 2, 0.0F, false));
        this.flame2 = new MModelRenderer(this);
        this.flame2.setRotationPoint(-1.0F, -10.0F, 1.0F);
        this.two.addChild(this.flame2);
        this.flame2.cubeList.add(new ModelBox(this.flame2, 47, 89, -2.0F, -8.0F, 0.0F, 4, 8, 1, 0.0F, false));
        this.flame2.cubeList.add(new ModelBox(this.flame2, 47, 89, -2.4F, -8.0F, 0.5F, 4, 8, 1, 0.0F, false));
        this.three = new MModelRenderer(this);
        this.three.setRotationPoint(0.5F, 0.5F, -0.5F);
        this.Torch.addChild(this.three);
        this.three.cubeList.add(new ModelBox(this.three, 59, 86, -2.0F, -10.0F, 0.0F, 2, 2, 2, 0.0F, false));
        this.flame3 = new MModelRenderer(this);
        this.flame3.setRotationPoint(-1.0F, -10.0F, 1.0F);
        this.three.addChild(this.flame3);
        this.flame3.cubeList.add(new ModelBox(this.flame3, 47, 80, -2.0F, -8.0F, 0.0F, 4, 8, 1, 0.0F, false));
        this.flame3.cubeList.add(new ModelBox(this.flame3, 47, 80, -2.4F, -8.0F, 0.5F, 4, 8, 1, 0.0F, false));
        this.RightLeg = new MModelRenderer(this);
        this.RightLeg.setRotationPoint(-2.4F, 7.0F, 0.0F);
        this.Piglin.addChild(this.RightLeg);
        this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 56, 53, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
        this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 48, 24, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F, false));
        this.LeftLeg = new MModelRenderer(this);
        this.LeftLeg.setRotationPoint(1.4F, 7.0F, 0.0F);
        this.Piglin.addChild(this.LeftLeg);
        this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 22, 45, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
        this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 44, 41, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.251F, false));
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(-0.5F, -5.0F, 0.0F);
        this.Piglin.addChild(this.Head);
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 0, -5.0F, -8.0F, -4.0F, 10, 8, 8, 0.0F, false));
        this.moth = new MModelRenderer(this);
        this.moth.setRotationPoint(0.0F, -1.7F, -4.5F);
        this.Head.addChild(this.moth);
        this.moth.cubeList.add(new ModelBox(this.moth, 28, 0, -2.0F, -2.3F, -0.5F, 4, 4, 1, 0.0F, false));
        this.moth.cubeList.add(new ModelBox(this.moth, 0, 29, 2.0F, -0.3F, -0.5F, 1, 2, 1, 0.0F, false));
        this.moth.cubeList.add(new ModelBox(this.moth, 36, 26, -3.0F, -0.3F, -0.5F, 1, 2, 1, 0.0F, false));
        this.Ear1 = new MModelRenderer(this);
        this.Ear1.setRotationPoint(5.5F, -6.0F, 0.0F);
        this.setRotation(this.Ear1, 0.0F, 0.0F, -0.3054F);
        this.Head.addChild(this.Ear1);
        this.Ear1.cubeList.add(new ModelBox(this.Ear1, 72, 30, -0.8F, -0.3F, -2.0F, 1, 5, 4, 0.0F, false));
        this.Ear2 = new MModelRenderer(this);
        this.Ear2.setRotationPoint(-5.5F, -6.0F, 0.0F);
        this.setRotation(this.Ear2, 0.0F, 0.0F, 0.3054F);
        this.Head.addChild(this.Ear2);
        this.Ear2.cubeList.add(new ModelBox(this.Ear2, 28, 69, -0.2F, -0.3F, -2.0F, 1, 5, 4, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "body/piglin.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/piglin_animation.json"));
        this.animation = bbanimationloader.mustGet("piglin.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.6D, 0.08D);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.49699999999999994D, 0.175D);
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
        return "\u041f\u0438\u0433\u043b\u0438\u043d";
    }

    public String getCreator()
    {
        return "Sir_Kelt";
    }
}
