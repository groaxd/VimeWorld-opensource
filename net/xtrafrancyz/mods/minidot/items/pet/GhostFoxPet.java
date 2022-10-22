package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class GhostFoxPet extends BasePet
{
    private final MModelRenderer Vse;
    private final MModelRenderer Lleg;
    private final MModelRenderer Rleg;
    private final MModelRenderer Larm;
    private final MModelRenderer Effect1;
    private final MModelRenderer Effect2;
    private final MModelRenderer Effect3;
    private final MModelRenderer Rarm;
    private final MModelRenderer Tylovishe;
    private final MModelRenderer Xhost;
    private final MModelRenderer Golova;
    private final MModelRenderer Glaza;
    private final MModelRenderer YhoR;
    private final MModelRenderer YhoL;
    private final IAnimation animation;

    public GhostFoxPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Vse = new MModelRenderer(this);
        this.Vse.setRotationPoint(0.5F, 0.0F, 0.0F);
        this.setRotation(this.Vse, 0.0F, 1.5708F, 0.0F);
        this.Lleg = new MModelRenderer(this);
        this.Lleg.setRotationPoint(0.25F, -3.0F, 1.0F);
        this.Vse.addChild(this.Lleg);
        this.Lleg.cubeList.add(new ModelBox(this.Lleg, 13, 14, -0.75F, 0.0F, -1.0F, 2, 3, 2, 0.0F, false));
        this.Rleg = new MModelRenderer(this);
        this.Rleg.setRotationPoint(0.25F, -3.0F, -2.0F);
        this.Vse.addChild(this.Rleg);
        this.Rleg.cubeList.add(new ModelBox(this.Rleg, 8, 29, -0.75F, 0.0F, -1.0F, 2, 3, 2, 0.0F, false));
        this.Larm = new MModelRenderer(this);
        this.Larm.setRotationPoint(0.5F, -9.0F, 2.0F);
        this.Vse.addChild(this.Larm);
        this.Larm.cubeList.add(new ModelBox(this.Larm, 0, 29, -1.0F, -1.0F, 0.0F, 2, 4, 2, 0.0F, false));
        this.Effect1 = new MModelRenderer(this);
        this.Effect1.setRotationPoint(2.0F, -7.0F, 8.5F);
        this.Vse.addChild(this.Effect1);
        this.Effect1.cubeList.add(new ModelBox(this.Effect1, 19, 24, 0.0F, -3.0F, -2.5F, 0, 5, 5, 0.0F, false));
        this.Effect2 = new MModelRenderer(this);
        this.Effect2.setRotationPoint(2.0F, -6.75F, 13.5F);
        this.Vse.addChild(this.Effect2);
        this.Effect2.cubeList.add(new ModelBox(this.Effect2, 19, 24, 0.0F, -3.25F, -2.5F, 0, 5, 5, 0.0F, false));
        this.Effect3 = new MModelRenderer(this);
        this.Effect3.setRotationPoint(2.0F, -6.75F, 18.75F);
        this.Vse.addChild(this.Effect3);
        this.Effect3.cubeList.add(new ModelBox(this.Effect3, 19, 24, 0.0F, -3.25F, -2.75F, 0, 5, 5, 0.0F, false));
        this.Rarm = new MModelRenderer(this);
        this.Rarm.setRotationPoint(0.25F, -9.25F, -3.0F);
        this.Vse.addChild(this.Rarm);
        this.Rarm.cubeList.add(new ModelBox(this.Rarm, 26, 22, -0.75F, -0.75F, -2.0F, 2, 4, 2, 0.0F, false));
        this.Tylovishe = new MModelRenderer(this);
        this.Tylovishe.setRotationPoint(1.0F, -7.25F, -0.75F);
        this.Vse.addChild(this.Tylovishe);
        this.Tylovishe.cubeList.add(new ModelBox(this.Tylovishe, 23, 9, -2.0F, -3.75F, -2.25F, 3, 8, 5, 0.0F, false));
        this.Xhost = new MModelRenderer(this);
        this.Xhost.setRotationPoint(-2.0F, 3.25F, 0.25F);
        this.Tylovishe.addChild(this.Xhost);
        this.Xhost.cubeList.add(new ModelBox(this.Xhost, 19, 0, -6.0F, -2.0F, -1.5F, 6, 3, 3, 0.0F, false));
        this.Golova = new MModelRenderer(this);
        this.Golova.setRotationPoint(0.5F, -10.75F, 0.0F);
        this.Vse.addChild(this.Golova);
        this.Golova.cubeList.add(new ModelBox(this.Golova, 0, 36, -3.5F, -6.25F, -5.0F, 6, 6, 9, 0.0F, false));
        this.Golova.cubeList.add(new ModelBox(this.Golova, 13, 19, 2.5F, -2.25F, -2.0F, 3, 2, 3, 0.0F, false));
        this.Glaza = new MModelRenderer(this);
        this.Glaza.setRotationPoint(3.0F, -1.5F, -0.25F);
        this.Golova.addChild(this.Glaza);
        this.Glaza.cubeList.add(new ModelBox(this.Glaza, 0, 14, -1.25F, -2.75F, -5.75F, 1, 4, 11, 0.0F, false));
        this.YhoR = new MModelRenderer(this);
        this.YhoR.setRotationPoint(0.75F, -6.25F, -3.0F);
        this.Golova.addChild(this.YhoR);
        this.YhoR.cubeList.add(new ModelBox(this.YhoR, 0, 0, -0.25F, -3.0F, -1.25F, 1, 4, 3, 0.0F, false));
        this.YhoL = new MModelRenderer(this);
        this.YhoL.setRotationPoint(0.5F, -6.25F, 1.75F);
        this.Golova.addChild(this.YhoL);
        this.YhoL.cubeList.add(new ModelBox(this.YhoL, 0, 14, 0.0F, -3.0F, -1.5F, 1, 4, 3, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/ghostfoxpet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/ghostfoxpet_animation.json"));
        this.animation = bbanimationloader.mustGet("ghostfoxpet.animation", this);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.animation.tick(time);
        float f = MathHelper.sin(time * 0.16F) * 0.04F;
        GlStateManager.translate(0.65F, -0.1F + f, 0.2F);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0F, 0.35F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u0440\u0438\u0437\u0440\u0430\u0447\u043d\u0430\u044f \u043b\u0438\u0441\u0430";
    }

    public String getCreator()
    {
        return "d3putatus";
    }
}
