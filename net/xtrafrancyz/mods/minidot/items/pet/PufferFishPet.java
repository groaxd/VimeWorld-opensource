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

public class PufferFishPet extends BasePet
{
    private final MModelRenderer yshi;
    private final MModelRenderer yshki;
    private final MModelRenderer yshkitwo;
    private final MModelRenderer body;
    private final MModelRenderer igli;
    private final MModelRenderer bone8;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone9;
    private final IAnimation animation;

    public PufferFishPet()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.yshi = new MModelRenderer(this);
        this.yshki = new MModelRenderer(this);
        this.yshki.setRotationPoint(-4.0F, -11.0F, -2.0F);
        this.setRotation(this.yshki, 0.0F, 0.0F, -0.3927F);
        this.yshi.addChild(this.yshki);
        this.yshki.cubeList.add(new ModelBox(this.yshki, 0, 2, -2.0F, 0.0F, -1.0F, 2, 0, 2, 0.0F, false));
        this.yshkitwo = new MModelRenderer(this);
        this.yshkitwo.setRotationPoint(4.0F, -11.0F, -2.0F);
        this.setRotation(this.yshkitwo, 0.0F, 0.0F, 0.3927F);
        this.yshi.addChild(this.yshkitwo);
        this.yshkitwo.cubeList.add(new ModelBox(this.yshkitwo, 0, 0, 0.0F, 0.0F, -1.0F, 2, 0, 2, 0.0F, false));
        this.body = new MModelRenderer(this);
        this.body.cubeList.add(new ModelBox(this.body, 0, 0, -4.0F, -12.0F, -4.0F, 8, 8, 8, 0.0F, false));
        this.igli = new MModelRenderer(this);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, -4.0F, 4.0F);
        this.setRotation(this.bone8, 0.3927F, 0.0F, 0.0F);
        this.igli.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 4, 7, -4.0F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));
        this.bone8.cubeList.add(new ModelBox(this.bone8, 6, 7, 3.0F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -12.0F, -4.0F);
        this.setRotation(this.bone, 0.3927F, 0.0F, 0.0F);
        this.igli.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 17, -3.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 5, -1.0F, -1.0F, 0.0F, 2, 1, 0, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 16, 16, 2.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(4.0F, -8.0F, -4.0F);
        this.setRotation(this.bone2, 0.0F, 0.3927F, 0.0F);
        this.igli.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, 0.0F, -4.0F, 0.0F, 1, 2, 0, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 16, 0.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 2, 0.0F, 1.0F, 0.0F, 1, 2, 0, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-4.0F, -8.0F, -4.0F);
        this.setRotation(this.bone3, 0.0F, -0.3927F, 0.0F);
        this.igli.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 4, 5, -1.0F, -4.0F, 0.0F, 1, 2, 0, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 6, -1.0F, 1.0F, 0.0F, 1, 2, 0, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 2, 16, -1.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, -4.0F, -4.0F);
        this.setRotation(this.bone4, -0.3927F, 0.0F, 0.0F);
        this.igli.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 6, 16, -3.0F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 4, 16, 2.0F, 0.0F, 0.0F, 1, 1, 0, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 4, -1.0F, 0.0F, 0.0F, 2, 1, 0, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-4.0F, -8.0F, 4.0F);
        this.setRotation(this.bone5, 0.0F, 0.3927F, 0.0F);
        this.igli.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 2, 6, -1.0F, 1.0F, 0.0F, 1, 2, 0, 0.0F, false));
        this.bone5.cubeList.add(new ModelBox(this.bone5, 6, 0, -1.0F, -4.0F, 0.0F, 1, 2, 0, 0.0F, false));
        this.bone5.cubeList.add(new ModelBox(this.bone5, 8, 16, -1.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(4.0F, -8.0F, 4.0F);
        this.setRotation(this.bone6, 0.0F, -0.3927F, 0.0F);
        this.igli.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 6, 2, 0.0F, 1.0F, 0.0F, 1, 2, 0, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 6, 5, 0.0F, -4.0F, 0.0F, 1, 2, 0, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 10, 16, 0.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.0F, -12.0F, 4.0F);
        this.setRotation(this.bone7, -0.3927F, 0.0F, 0.0F);
        this.igli.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 14, 16, -3.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 4, 4, -1.0F, -1.0F, 0.0F, 2, 1, 0, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 12, 16, 2.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, -12.0F, 0.0F);
        this.igli.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 17, -3.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F, false));
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 5, -1.0F, -1.0F, 0.0F, 2, 1, 0, 0.0F, false));
        this.bone9.cubeList.add(new ModelBox(this.bone9, 16, 16, 2.0F, -1.0F, 0.0F, 1, 1, 0, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/pufferfishpet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/pufferfishpet_animation.json"));
        this.animation = bbanimationloader.mustGet("pufferfishpet.animation", this);
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
        GlStateManager.translate(0.0F, 0.322F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0418\u0433\u043b\u043e\u0431\u0440\u044e\u0445";
    }

    public String getCreator()
    {
        return "SteepyHARD";
    }
}
