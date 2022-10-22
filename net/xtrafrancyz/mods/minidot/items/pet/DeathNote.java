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

public class DeathNote extends BasePet
{
    private final MModelRenderer obshee;
    private final MModelRenderer oblojka;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer bone3;
    private final MModelRenderer list;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone14;
    private final MModelRenderer pero;
    private final IAnimation animation;

    public DeathNote()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.obshee = new MModelRenderer(this);
        this.oblojka = new MModelRenderer(this);
        this.obshee.addChild(this.oblojka);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-2.0F, -5.0F, 0.0F);
        this.oblojka.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 12, -1.0F, -11.0F, 0.25F, 9, 11, 1, -0.1F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-2.0F, -5.0F, 0.0F);
        this.oblojka.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -1.0F, -11.0F, -1.25F, 9, 11, 1, -0.1F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-2.0F, -5.0F, 0.0F);
        this.oblojka.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 20, 0, -1.25F, -11.0F, -1.0F, 1, 11, 2, -0.09F, false));
        this.list = new MModelRenderer(this);
        this.list.setRotationPoint(-0.5F, 0.0F, 0.5F);
        this.obshee.addChild(this.list);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-2.0F, -5.5F, 0.0F);
        this.list.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 26, 0, 0.0F, -10.0F, -1.0F, 2, 10, 1, -0.11F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-2.0F, -5.5F, 0.0F);
        this.list.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 26, 11, 0.0F, -10.0F, -1.0F, 2, 10, 1, -0.11F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-2.0F, -5.5F, 0.0F);
        this.list.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 24, 24, 1.75F, -10.0F, -1.0F, 2, 10, 1, -0.11F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-2.0F, -5.0F, 0.0F);
        this.list.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 18, 24, 3.5F, -10.5F, -1.0F, 2, 10, 1, -0.11F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-2.0F, -5.0F, 0.0F);
        this.list.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 24, 35, 5.25F, -10.5F, -1.0F, 2, 10, 1, -0.11F, false));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(-1.0F, -5.5F, 0.0F);
        this.list.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 20, 13, 5.25F, -10.0F, -1.0F, 2, 10, 1, -0.11F, false));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-1.0F, -5.5F, 0.0F);
        this.list.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 17, 35, 5.25F, -10.0F, -1.0F, 2, 10, 1, -0.11F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-2.0F, -5.5F, 0.0F);
        this.list.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 12, 24, 1.75F, -10.0F, -1.0F, 2, 10, 1, -0.11F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-2.0F, -5.5F, 0.0F);
        this.list.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 6, 24, 3.5F, -10.0F, -1.0F, 2, 10, 1, -0.11F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-2.0F, -5.5F, 0.0F);
        this.list.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 0, 24, 5.25F, -10.0F, -1.0F, 2, 10, 1, -0.11F, false));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(0.25F, 0.0F, -0.5F);
        this.list.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 10, 36, -2.75F, -15.5F, -0.5F, 1, 10, 1, 0.0F, false));
        this.pero = new MModelRenderer(this);
        this.pero.setRotationPoint(0.0F, 0.25F, 4.5F);
        this.obshee.addChild(this.pero);
        this.pero.cubeList.add(new ModelBox(this.pero, 32, 12, -1.0F, -7.0F, -5.0F, 1, 2, 1, -0.4F, false));
        this.pero.cubeList.add(new ModelBox(this.pero, 32, 9, -1.0F, -8.0F, -5.0F, 1, 2, 1, -0.35F, false));
        this.pero.cubeList.add(new ModelBox(this.pero, 30, 28, -1.0F, -15.5F, -5.0F, 1, 2, 1, -0.35F, false));
        this.pero.cubeList.add(new ModelBox(this.pero, 32, 6, -1.0F, -9.0F, -5.0F, 1, 2, 1, -0.3F, false));
        this.pero.cubeList.add(new ModelBox(this.pero, 30, 31, -1.0F, -15.0F, -5.0F, 1, 2, 1, -0.3F, false));
        this.pero.cubeList.add(new ModelBox(this.pero, 32, 3, -1.0F, -10.0F, -5.0F, 1, 2, 1, -0.25F, false));
        this.pero.cubeList.add(new ModelBox(this.pero, 32, 0, -1.0F, -14.5F, -5.0F, 1, 2, 1, -0.25F, false));
        this.pero.cubeList.add(new ModelBox(this.pero, 30, 22, -1.0F, -14.0F, -5.0F, 1, 5, 1, -0.2F, false));
        this.pero.cubeList.add(new ModelBox(this.pero, 32, 19, -1.5F, -13.0F, -4.5F, 1, 3, 0, 1.0E-4F, false));
        this.pero.cubeList.add(new ModelBox(this.pero, 32, 17, -2.0F, -14.0F, -4.5F, 2, 2, 0, -0.01F, false));
        this.pero.cubeList.add(new ModelBox(this.pero, 32, 15, -1.0F, -14.0F, -4.5F, 2, 2, 0, -0.001F, false));
        this.pero.cubeList.add(new ModelBox(this.pero, 20, 0, -0.5F, -12.0F, -4.5F, 1, 2, 0, 0.0F, false));
        this.pero.cubeList.add(new ModelBox(this.pero, 26, 22, -1.5F, -15.25F, -4.5F, 2, 2, 0, 1.0E-4F, false));
        this.pero.cubeList.add(new ModelBox(this.pero, 24, 0, -1.0F, -16.0F, -4.5F, 1, 1, 0, 0.001F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/deathnote.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/deathnote_animation.json"));
        this.animation = bbanimationloader.mustGet("note.default", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.translate(0.7D, 0.0D, 0.3D);
        double d0 = (double)MathHelper.sin(time * 0.1F);
        GlStateManager.translate(0.0D, d0 * 0.03D, 0.0D);
        GlStateManager.rotate(270.0F + MathHelper.cos(time * 0.07F) * 20.0F, 0.0F, 0.2F, 0.0F);
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
        double d1 = 0.9D;
        GlStateManager.scale(d1, d1, d1);
        GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.4D, 0.0D);
        double d0 = 0.9D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0422\u0435\u0442\u0440\u0430\u0434\u044c \u0441\u043c\u0435\u0440\u0442\u0438";
    }

    public String getCreator()
    {
        return "Florina";
    }
}
