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

public class PuppyBoxPet extends BasePet
{
    private final MModelRenderer Yo;
    private final MModelRenderer sobaka;
    private final MModelRenderer Head;
    private final MModelRenderer bone17;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone13;
    private final MModelRenderer bone;
    private final MModelRenderer bone4;
    private final MModelRenderer bone10;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final MModelRenderer bone16;
    private final MModelRenderer korobka;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone18;
    private final MModelRenderer bone19;
    private final IAnimation animation;

    public PuppyBoxPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Yo = new MModelRenderer(this);
        this.Yo.setRotationPoint(-0.5F, 3.0F, -3.0F);
        this.sobaka = new MModelRenderer(this);
        this.sobaka.setRotationPoint(0.0F, -9.7F, 0.2F);
        this.Yo.addChild(this.sobaka);
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(0.4F, -1.0F, 2.2F);
        this.setRotation(this.Head, -0.0873F, 0.0F, 0.0F);
        this.sobaka.addChild(this.Head);
        this.Head.cubeList.add(new ModelBox(this.Head, 24, 4, -1.9F, -4.0F, -2.2F, 4, 4, 4, 0.0F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 0, -1.4F, -3.5F, 1.3F, 3, 3, 1, 0.0F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 32, 24, -1.4F, -4.8F, -1.8F, 3, 1, 3, 0.0F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 12, 24, -1.9F, -0.1F, -1.8F, 4, 1, 4, -0.1F, false));
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(0.1F, -1.9F, -2.0F);
        this.setRotation(this.bone17, 0.0873F, 0.0F, 0.0F);
        this.Head.addChild(this.bone17);
        this.bone17.cubeList.add(new ModelBox(this.bone17, 0, 4, -1.0F, -0.1F, -1.8F, 2, 2, 2, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-0.4F, -4.0F, -0.2F);
        this.setRotation(this.bone2, 0.4363F, -0.0873F, -0.5236F);
        this.Head.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 12, -2.0F, -2.5F, 0.0F, 2, 3, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-2.4F, -2.0F, -1.2F);
        this.setRotation(this.bone3, 0.0F, 0.0F, -0.1745F);
        this.Head.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 20, -0.5F, 0.1F, 0.0F, 1, 2, 2, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(2.6F, -2.0F, -1.2F);
        this.setRotation(this.bone5, 0.0F, 0.0F, 0.1745F);
        this.Head.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 16, -0.5F, 0.1F, 0.0F, 1, 2, 2, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.6F, -4.0F, -0.2F);
        this.setRotation(this.bone6, 0.4363F, 0.0873F, 0.5236F);
        this.Head.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 8, 0.0F, -2.5F, 0.0F, 2, 3, 1, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-0.4F, 1.0F, -2.2F);
        this.Head.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 36, 4, -1.3F, -4.0F, -0.3F, 1, 1, 1, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(2.6F, 1.0F, -2.2F);
        this.Head.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 57, 0, -1.7F, -4.0F, -0.3F, 1, 1, 1, 0.0F, false));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(0.5F, -1.0F, 2.3F);
        this.setRotation(this.bone13, 0.3491F, 0.0F, 0.0F);
        this.sobaka.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 0, 24, -1.5F, 0.0F, -1.6F, 3, 5, 3, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-2.0F, 1.2F, -0.5F);
        this.setRotation(this.bone, 0.2618F, 0.0F, 0.0F);
        this.bone13.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 56, 5, -0.5F, -0.5F, -1.5F, 1, 1, 2, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.setRotation(this.bone4, -0.0873F, 0.0F, 0.0F);
        this.bone.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 57, 8, -0.5F, -2.5F, -0.5F, 1, 3, 1, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.0F, -2.2224F, -0.1944F);
        this.setRotation(this.bone10, 1.309F, 0.0F, 0.0F);
        this.bone4.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 4, 16, -0.5F, -0.4776F, -0.5056F, 1, 1, 1, 0.2F, false));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(2.0F, 1.2F, -0.5F);
        this.setRotation(this.bone14, 0.2618F, 0.0F, 0.0F);
        this.bone13.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 56, 2, -0.5F, -0.5F, -1.5F, 1, 1, 2, 0.0F, false));
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.setRotation(this.bone15, -0.0873F, 0.0F, 0.0F);
        this.bone14.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 24, 4, -0.5F, -2.5F, -0.5F, 1, 3, 1, 0.0F, false));
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(0.0F, -2.2224F, -0.1944F);
        this.setRotation(this.bone16, 1.309F, 0.0F, 0.0F);
        this.bone15.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 4, 20, -0.5F, -0.4776F, -0.5056F, 1, 1, 1, 0.2F, false));
        this.korobka = new MModelRenderer(this);
        this.Yo.addChild(this.korobka);
        this.korobka.cubeList.add(new ModelBox(this.korobka, 0, 0, -3.5F, -3.0F, -1.0F, 8, 0, 8, 0.0F, false));
        this.korobka.cubeList.add(new ModelBox(this.korobka, 24, 12, -3.5F, -10.0F, 7.0F, 8, 7, 0, 0.0F, false));
        this.korobka.cubeList.add(new ModelBox(this.korobka, 48, 7, -3.5F, -10.0F, -1.0F, 0, 7, 8, 0.0F, false));
        this.korobka.cubeList.add(new ModelBox(this.korobka, 40, 0, -3.5F, -10.0F, -1.0F, 8, 7, 0, 0.0F, false));
        this.korobka.cubeList.add(new ModelBox(this.korobka, 40, 0, 4.5F, -10.0F, -1.0F, 0, 7, 8, 0.0F, false));
        this.korobka.cubeList.add(new ModelBox(this.korobka, 0, 8, -3.5F, -6.6F, -1.0F, 8, 0, 8, 0.0F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-3.5F, -10.0F, -1.0F);
        this.setRotation(this.bone11, 0.0F, 0.0F, 2.5307F);
        this.korobka.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 8, 16, 0.0F, 0.0F, 0.0F, 4, 0, 8, 0.0F, false));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(4.5F, -10.0F, -1.0F);
        this.setRotation(this.bone12, 0.0F, 0.0F, -2.5307F);
        this.korobka.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 0, 16, -4.0F, 0.0F, 0.0F, 4, 0, 8, 0.0F, false));
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(4.5F, -10.0F, -1.0F);
        this.setRotation(this.bone18, 2.5307F, 0.0F, -3.1416F);
        this.korobka.addChild(this.bone18);
        this.bone18.cubeList.add(new ModelBox(this.bone18, 20, 0, 0.0F, 0.0F, 0.0F, 8, 0, 4, 0.0F, false));
        this.bone19 = new MModelRenderer(this);
        this.bone19.setRotationPoint(4.5F, -10.0F, 7.0F);
        this.setRotation(this.bone19, -2.5307F, 0.0F, -3.1416F);
        this.korobka.addChild(this.bone19);
        this.bone19.cubeList.add(new ModelBox(this.bone19, 20, 20, 0.0F, 0.0F, -4.0F, 8, 0, 4, 0.0F, false));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/puppy_box_animation.json"));
        this.animation = bbanimationloader.mustGet("DogBoxAnimation", this);
        this.setTexture(new ResourceLocation("minidot", "pets/puppy_box.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.02F;
        float f1 = MathHelper.cos(time * 0.1F);
        GlStateManager.translate(0.7F, -0.15F + f, 0.3F);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, 0.0F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
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
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        GlStateManager.translate(0.0F, 0.25F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0429\u0435\u043d\u043e\u0447\u0435\u043a \u0432 \u043a\u043e\u0440\u043e\u0431\u043a\u0435";
    }

    public String getCreator()
    {
        return "chikon";
    }
}
