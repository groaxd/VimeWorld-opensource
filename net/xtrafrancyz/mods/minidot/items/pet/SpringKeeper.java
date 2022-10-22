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

public class SpringKeeper extends BasePet
{
    private final MModelRenderer one;
    private final MModelRenderer eleven;
    private final MModelRenderer two;
    private final MModelRenderer twelve;
    private final MModelRenderer three;
    private final MModelRenderer four;
    private final MModelRenderer five;
    private final MModelRenderer six;
    private final MModelRenderer seven;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer rykzak;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final IAnimation animation;

    public SpringKeeper()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.one = new MModelRenderer(this);
        this.one.cubeList.add(new ModelBox(this.one, 14, 19, -3.0F, -2.0F, -4.0F, 5, 2, 5, 0.0F, false));
        this.eleven = new MModelRenderer(this);
        this.eleven.setRotationPoint(-2.0F, -1.0F, -5.0F);
        this.setRotation(this.eleven, 0.0F, 0.2618F, 0.0F);
        this.one.addChild(this.eleven);
        this.eleven.cubeList.add(new ModelBox(this.eleven, 0, 24, -1.5F, -1.0055F, -1.0F, 2, 2, 2, 0.0F, false));
        this.two = new MModelRenderer(this);
        this.two.setRotationPoint(-0.5F, -0.25F, -2.0F);
        this.setRotation(this.two, 0.0F, 0.0F, -0.1745F);
        this.eleven.addChild(this.two);
        this.two.cubeList.add(new ModelBox(this.two, 13, 0, -1.0F, -1.5F, -0.75F, 2, 3, 2, -0.2F, false));
        this.twelve = new MModelRenderer(this);
        this.twelve.setRotationPoint(1.0F, -1.0F, -5.0F);
        this.setRotation(this.twelve, 0.0F, -0.2618F, 0.0F);
        this.one.addChild(this.twelve);
        this.twelve.cubeList.add(new ModelBox(this.twelve, 22, 0, -0.5F, -1.0055F, -1.0F, 2, 2, 2, 0.0F, false));
        this.three = new MModelRenderer(this);
        this.three.setRotationPoint(0.5F, -0.25F, -2.0F);
        this.setRotation(this.three, 0.0F, 0.0F, 0.0436F);
        this.twelve.addChild(this.three);
        this.three.cubeList.add(new ModelBox(this.three, 13, 0, -1.0F, -1.5F, -0.75F, 2, 3, 2, -0.2F, false));
        this.four = new MModelRenderer(this);
        this.five = new MModelRenderer(this);
        this.four.addChild(this.five);
        this.five.cubeList.add(new ModelBox(this.five, 14, 7, -2.5F, -7.0F, -4.0F, 4, 5, 5, 0.0F, false));
        this.six = new MModelRenderer(this);
        this.six.setRotationPoint(-5.0F, -4.75F, -1.5F);
        this.setRotation(this.six, 0.0F, 0.0F, 0.3491F);
        this.five.addChild(this.six);
        this.six.cubeList.add(new ModelBox(this.six, 0, 12, 0.425F, -3.1F, -3.0F, 3, 5, 6, 0.0F, false));
        this.seven = new MModelRenderer(this);
        this.seven.setRotationPoint(3.0F, -4.75F, -1.5F);
        this.setRotation(this.seven, 0.0F, 0.0F, -0.3491F);
        this.five.addChild(this.seven);
        this.seven.cubeList.add(new ModelBox(this.seven, 0, 0, -2.575F, -2.775F, -3.0F, 3, 5, 6, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 0.0F, -0.3F);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -1.275F, -3.5F, -4.5F, 1, 1, 1, -0.23F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -0.225F, -3.5F, -4.5F, 1, 1, 1, -0.23F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 15, -1.8F, -3.5F, -4.5F, 1, 1, 1, -0.23F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 12, -0.225F, -4.025F, -4.5F, 1, 1, 1, -0.23F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -0.225F, -4.55F, -4.5F, 1, 1, 1, -0.23F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -0.75F, -4.55F, -4.5F, 1, 1, 1, -0.23F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 3, -1.275F, -4.55F, -4.5F, 1, 1, 1, -0.23F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -1.8F, -4.025F, -4.5F, 1, 1, 1, -0.23F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -1.8F, -4.55F, -4.5F, 1, 1, 1, -0.23F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -0.75F, -3.5F, -4.5F, 1, 1, 1, -0.23F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-0.75F, -10.25F, -2.25F);
        this.setRotation(this.bone, 0.0226F, -0.0863F, -0.0863F);
        this.bone.cubeList.add(new ModelBox(this.bone, 3, 44, -2.5F, -1.75F, -2.25F, 5, 5, 5, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(3.0F, -10.25F, -2.0F);
        this.setRotation(this.bone3, 0.0F, 0.0F, 1.9199F);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 29, 1.6544F, -0.409F, -2.755F, 3, 2, 6, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-2.75F, -7.5F, -2.0F);
        this.setRotation(this.bone4, 0.0F, 0.0F, -1.9199F);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 18, 29, -1.55F, -0.675F, -2.8F, 3, 2, 6, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-5.0F, -7.5F, -2.0F);
        this.setRotation(this.bone5, 0.0F, 0.0F, ((float)Math.PI * 2F / 9F));
        this.bone5.cubeList.add(new ModelBox(this.bone5, 46, 19, 0.125F, -1.575F, -1.0F, 2, 4, 2, 0.0F, false));
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 58, -0.5F, 2.425F, -1.5F, 3, 3, 3, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(3.75F, -7.3F, -1.75F);
        this.setRotation(this.bone6, -3.0123F, 0.0503F, 2.496F);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 46, 19, 0.125F, -1.575F, -1.0F, 2, 4, 2, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 58, -0.5F, 2.425F, -1.5F, 3, 3, 3, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.75F, 4.0F, 1.5F);
        this.setRotation(this.bone10, 0.0876F, -0.0869F, -0.0076F);
        this.bone6.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 32, 0, -0.5F, -0.5F, -8.5F, 1, 1, 15, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 35, 52, -0.75F, -0.75F, 2.0F, 1, 1, 3, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 35, 52, -0.75F, -0.75F, 2.0F, 1, 1, 3, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 35, 52, -0.75F, -0.25F, 2.0F, 1, 1, 3, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 35, 52, -0.25F, -0.75F, 2.0F, 1, 1, 3, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 35, 52, -0.25F, -0.75F, 2.0F, 1, 1, 3, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 35, 52, -0.25F, -0.25F, 2.0F, 1, 1, 3, 0.0F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.0F, 0.125F, 7.775F);
        this.setRotation(this.bone11, -0.2531F, 0.0F, 0.0F);
        this.bone10.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 43, 30, -0.5F, -0.275F, -1.4F, 1, 1, 3, 0.0F, false));
        this.bone11.cubeList.add(new ModelBox(this.bone11, 52, 27, -0.5F, 0.225F, 0.6F, 1, 3, 1, 0.0F, false));
        this.bone11.cubeList.add(new ModelBox(this.bone11, 57, 31, -0.5F, 2.225F, -0.9F, 1, 1, 2, 0.0F, false));
        this.rykzak = new MModelRenderer(this);
        this.rykzak.cubeList.add(new ModelBox(this.rykzak, 50, 60, -3.0F, -6.75F, 1.0F, 5, 2, 2, 0.0F, false));
        this.rykzak.cubeList.add(new ModelBox(this.rykzak, 26, 58, -5.0F, -9.5F, 0.5F, 9, 3, 3, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-1.25F, -13.0F, -2.5F);
        this.setRotation(this.bone7, 0.0F, 0.4363F, -0.0873F);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 36, 49, -3.5F, -0.75F, -3.05F, 7, 2, 7, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 40, 42, -2.5F, -2.75F, -2.0F, 5, 2, 5, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 40, 34, -2.0F, -6.75F, -1.5F, 4, 4, 4, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-2.0F, -6.725F, -1.5F);
        this.setRotation(this.bone8, 1.047F, 0.0265F, -1.5861F);
        this.bone7.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 48, 31, -3.25F, -3.025F, -2.0F, 3, 4, 3, 0.0F, false));
        this.bone8.cubeList.add(new ModelBox(this.bone8, 50, 43, -2.75F, -5.0F, -1.5F, 2, 2, 2, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-2.25F, -2.5F, 1.0F);
        this.setRotation(this.bone9, 0.0F, 0.0F, 0.7854F);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 57, 51, -1.5F, -5.0F, -6.0F, 1, 4, 1, -0.27F, false));
        this.bone12 = new MModelRenderer(this);
        this.setRotation(this.bone12, 0.0F, 0.0F, -1.5708F);
        this.bone9.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 60, 44, 3.0F, -2.5F, -6.0F, 1, 4, 1, -0.27F, false));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(5.5F, -5.5F, -16.5F);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 25, 44, -1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F, false));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-16.5F, 1.5F, 0.5F);
        this.bone13.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 12, 56, 12.5F, -1.5F, -4.0F, 8, 0, 1, 0.0F, false));
        this.bone14.cubeList.add(new ModelBox(this.bone14, 12, 56, 12.5F, -1.5F, 2.0F, 8, 0, 1, 0.0F, false));
        this.bone14.cubeList.add(new ModelBox(this.bone14, 14, 57, 12.5F, -1.5F, -3.0F, 1, 0, 5, 0.0F, false));
        this.bone14.cubeList.add(new ModelBox(this.bone14, 14, 57, 19.5F, -1.5F, -3.0F, 1, 0, 5, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/springkeeper.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/springkeeper_animation.json"));
        this.animation = bbanimationloader.mustGet("springkeeper.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(1.3D, -0.21D + (double)f, 0.4D);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.231D, 0.1155D);
        double d0 = 0.74D;
        GlStateManager.scale(d0, d0, d0);
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
        return "\u0425\u0440\u0430\u043d\u0438\u0442\u0435\u043b\u044c \u0432\u0435\u0441\u043d\u044b";
    }

    public String getCreator()
    {
        return "turkim4n";
    }
}
