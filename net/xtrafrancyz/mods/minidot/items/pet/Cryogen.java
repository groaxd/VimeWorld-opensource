package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class Cryogen extends BasePet
{
    private final MModelRenderer one;
    private final MModelRenderer two;
    private final MModelRenderer three;
    private final MModelRenderer four;
    private final MModelRenderer five;
    private final MModelRenderer six;
    private final MModelRenderer Cryogen;
    private final MModelRenderer runes;
    private final MModelRenderer cryobody;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer shield;
    private final IAnimation animation;

    public Cryogen()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shield = new MModelRenderer(this);
        this.one = new MModelRenderer(this);
        this.one.setRotationPoint(-10.5F, -3.0F, 0.5F);
        this.shield.addChild(this.one);
        this.one.cubeList.add(new ModelBox(this.one, 0, 24, -1.5F, -1.0F, -1.0F, 3, 2, 2, 0.0F, false));
        this.one.cubeList.add(new ModelBox(this.one, 24, 26, -1.0F, -1.5F, -1.5F, 2, 2, 2, 0.0F, false));
        this.one.cubeList.add(new ModelBox(this.one, 22, 30, -1.75F, 0.5F, 0.25F, 2, 1, 1, 0.0F, false));
        this.one.cubeList.add(new ModelBox(this.one, 14, 32, 0.75F, -0.25F, -1.25F, 1, 1, 1, 0.0F, false));
        this.one.cubeList.add(new ModelBox(this.one, 14, 32, 1.25F, 1.75F, -2.25F, 1, 1, 1, -0.1F, false));
        this.one.cubeList.add(new ModelBox(this.one, 14, 32, -2.25F, -2.5F, 1.5F, 1, 1, 1, -0.1F, false));
        this.one.cubeList.add(new ModelBox(this.one, 8, 32, -1.25F, -1.25F, -0.25F, 1, 1, 1, 0.0F, false));
        this.one.cubeList.add(new ModelBox(this.one, 4, 32, -0.5F, 0.75F, -0.25F, 1, 1, 1, 0.0F, false));
        this.one.cubeList.add(new ModelBox(this.one, 16, 30, -0.75F, 0.5F, -0.75F, 2, 1, 1, 0.0F, false));
        this.two = new MModelRenderer(this);
        this.two.setRotationPoint(10.5F, -2.0F, -3.5F);
        this.shield.addChild(this.two);
        this.two.cubeList.add(new ModelBox(this.two, 18, 22, -1.5F, -1.0F, -1.0F, 3, 2, 2, 0.0F, false));
        this.two.cubeList.add(new ModelBox(this.two, 26, 20, -0.25F, -1.25F, -1.5F, 2, 2, 2, 0.0F, false));
        this.two.cubeList.add(new ModelBox(this.two, 30, 8, 0.0F, 0.5F, -0.25F, 2, 1, 1, 0.0F, false));
        this.two.cubeList.add(new ModelBox(this.two, 5, 0, 0.0F, 2.0F, 1.25F, 2, 1, 1, 0.0F, false));
        this.two.cubeList.add(new ModelBox(this.two, 5, 0, -0.5F, 1.75F, 1.5F, 1, 1, 1, 0.0F, false));
        this.two.cubeList.add(new ModelBox(this.two, 0, 32, -1.75F, -1.25F, -1.25F, 1, 1, 1, 0.0F, false));
        this.two.cubeList.add(new ModelBox(this.two, 0, 32, -2.75F, 1.5F, -2.0F, 1, 1, 1, -0.1F, false));
        this.two.cubeList.add(new ModelBox(this.two, 0, 32, 1.25F, -2.75F, -2.0F, 1, 1, 1, -0.1F, false));
        this.two.cubeList.add(new ModelBox(this.two, 31, 31, -0.5F, -1.5F, -0.25F, 1, 1, 1, 0.0F, false));
        this.two.cubeList.add(new ModelBox(this.two, 31, 29, -0.75F, 0.75F, -0.5F, 1, 1, 1, 0.0F, false));
        this.two.cubeList.add(new ModelBox(this.two, 30, 6, -0.75F, 0.5F, -1.25F, 2, 1, 1, 0.0F, false));
        this.three = new MModelRenderer(this);
        this.three.setRotationPoint(6.5F, 1.0F, 9.5F);
        this.shield.addChild(this.three);
        this.three.cubeList.add(new ModelBox(this.three, 10, 20, -1.5F, -1.0F, -1.0F, 3, 2, 2, 0.0F, false));
        this.three.cubeList.add(new ModelBox(this.three, 16, 26, -1.0F, -0.5F, -1.5F, 2, 2, 2, 0.0F, false));
        this.three.cubeList.add(new ModelBox(this.three, 6, 30, -1.75F, -1.5F, 0.25F, 2, 1, 1, 0.0F, false));
        this.three.cubeList.add(new ModelBox(this.three, 11, 31, 0.75F, -0.75F, -1.25F, 1, 1, 1, 0.0F, false));
        this.three.cubeList.add(new ModelBox(this.three, 11, 31, 1.75F, 1.25F, -2.25F, 1, 1, 1, -0.2F, false));
        this.three.cubeList.add(new ModelBox(this.three, 11, 31, -2.25F, 1.75F, 0.75F, 1, 1, 1, -0.2F, false));
        this.three.cubeList.add(new ModelBox(this.three, 11, 31, -2.25F, -3.25F, -1.25F, 1, 1, 1, -0.2F, false));
        this.three.cubeList.add(new ModelBox(this.three, 31, 0, -1.25F, 0.25F, -0.25F, 1, 1, 1, 0.0F, false));
        this.three.cubeList.add(new ModelBox(this.three, 28, 30, -0.5F, -1.75F, -0.25F, 1, 1, 1, 0.0F, false));
        this.three.cubeList.add(new ModelBox(this.three, 30, 4, -0.75F, -1.5F, -0.75F, 2, 1, 1, 0.0F, false));
        this.four = new MModelRenderer(this);
        this.four.setRotationPoint(-6.5F, 1.0F, -10.5F);
        this.shield.addChild(this.four);
        this.four.cubeList.add(new ModelBox(this.four, 0, 20, -1.5F, -1.0F, -1.0F, 3, 2, 2, 0.0F, false));
        this.four.cubeList.add(new ModelBox(this.four, 26, 15, -1.0F, -0.5F, -0.5F, 2, 2, 2, 0.0F, false));
        this.four.cubeList.add(new ModelBox(this.four, 0, 30, -1.75F, -1.5F, -1.25F, 2, 1, 1, 0.0F, false));
        this.four.cubeList.add(new ModelBox(this.four, 30, 26, 0.75F, -0.75F, 0.25F, 1, 1, 1, 0.0F, false));
        this.four.cubeList.add(new ModelBox(this.four, 22, 26, -1.25F, 0.25F, -0.75F, 1, 1, 1, 0.0F, false));
        this.four.cubeList.add(new ModelBox(this.four, 23, 24, -2.75F, 1.0F, 1.25F, 1, 1, 1, 0.0F, false));
        this.four.cubeList.add(new ModelBox(this.four, 18, 27, 2.0F, -1.0F, -2.25F, 1, 1, 1, 0.0F, false));
        this.four.cubeList.add(new ModelBox(this.four, 8, 24, -0.5F, -1.75F, -0.75F, 1, 1, 1, 0.0F, false));
        this.four.cubeList.add(new ModelBox(this.four, 11, 29, -0.75F, -1.5F, -0.25F, 2, 1, 1, 0.0F, false));
        this.five = new MModelRenderer(this);
        this.five.setRotationPoint(-7.5F, -1.0F, 10.5F);
        this.shield.addChild(this.five);
        this.five.cubeList.add(new ModelBox(this.five, 18, 18, -1.5F, -1.0F, -1.0F, 3, 2, 2, 0.0F, false));
        this.five.cubeList.add(new ModelBox(this.five, 25, 0, -0.25F, -1.25F, -1.5F, 2, 2, 2, 0.0F, false));
        this.five.cubeList.add(new ModelBox(this.five, 28, 24, 0.0F, 0.5F, -0.25F, 2, 1, 1, 0.0F, false));
        this.five.cubeList.add(new ModelBox(this.five, 23, 0, -1.75F, -1.25F, -1.25F, 1, 1, 1, 0.0F, false));
        this.five.cubeList.add(new ModelBox(this.five, 8, 20, -0.5F, -1.5F, -0.25F, 1, 1, 1, 0.0F, false));
        this.five.cubeList.add(new ModelBox(this.five, 0, 12, -0.75F, 0.75F, -0.5F, 1, 1, 1, 0.0F, false));
        this.five.cubeList.add(new ModelBox(this.five, 3, 8, -1.75F, 1.75F, 1.5F, 1, 1, 1, 0.0F, false));
        this.five.cubeList.add(new ModelBox(this.five, 3, 8, -2.25F, 1.5F, 1.75F, 1, 1, 1, 0.0F, false));
        this.five.cubeList.add(new ModelBox(this.five, 3, 8, 2.0F, -2.25F, -3.0F, 1, 1, 1, -0.2F, false));
        this.five.cubeList.add(new ModelBox(this.five, 3, 8, -3.0F, 1.0F, -2.25F, 1, 1, 1, -0.2F, false));
        this.five.cubeList.add(new ModelBox(this.five, 6, 28, -0.75F, 0.5F, -1.25F, 2, 1, 1, 0.0F, false));
        this.six = new MModelRenderer(this);
        this.six.setRotationPoint(7.5F, 3.0F, -10.5F);
        this.shield.addChild(this.six);
        this.six.cubeList.add(new ModelBox(this.six, 15, 0, -1.5F, -1.0F, -1.0F, 3, 2, 2, 0.0F, false));
        this.six.cubeList.add(new ModelBox(this.six, 10, 24, -1.0F, -1.5F, -1.5F, 2, 2, 2, 0.0F, false));
        this.six.cubeList.add(new ModelBox(this.six, 0, 28, -1.75F, 0.5F, 0.25F, 2, 1, 1, 0.0F, false));
        this.six.cubeList.add(new ModelBox(this.six, 0, 10, 0.75F, -0.25F, -1.25F, 1, 1, 1, 0.0F, false));
        this.six.cubeList.add(new ModelBox(this.six, 0, 10, -3.25F, 0.75F, -1.25F, 1, 1, 1, 0.0F, false));
        this.six.cubeList.add(new ModelBox(this.six, 0, 10, -3.75F, 0.5F, -1.0F, 1, 1, 1, 0.0F, false));
        this.six.cubeList.add(new ModelBox(this.six, 0, 10, -1.75F, 1.75F, -1.75F, 1, 1, 1, -0.2F, false));
        this.six.cubeList.add(new ModelBox(this.six, 0, 2, -1.25F, -1.25F, -0.25F, 1, 1, 1, 0.0F, false));
        this.six.cubeList.add(new ModelBox(this.six, 0, 0, -0.5F, 0.75F, -0.25F, 1, 1, 1, 0.0F, false));
        this.six.cubeList.add(new ModelBox(this.six, 20, 15, -0.75F, 0.5F, -0.75F, 2, 1, 1, 0.0F, false));
        this.Cryogen = new MModelRenderer(this);
        this.Cryogen.setRotationPoint(0.5F, -10.5F, 0.5F);
        this.runes = new MModelRenderer(this);
        this.runes.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.Cryogen.addChild(this.runes);
        this.runes.cubeList.add(new ModelBox(this.runes, 45, 0, -2.5F, -2.5F, 4.75F, 5, 5, 0, 0.0F, false));
        this.runes.cubeList.add(new ModelBox(this.runes, 45, 8, -2.5F, -2.5F, -4.5F, 5, 5, 0, 0.0F, false));
        this.runes.cubeList.add(new ModelBox(this.runes, 45, 33, 4.5F, -2.5F, -2.5F, 0, 5, 5, 0.0F, false));
        this.runes.cubeList.add(new ModelBox(this.runes, 45, 44, -4.5F, -2.5F, -2.5F, 0, 5, 5, 0.0F, true));
        this.cryobody = new MModelRenderer(this);
        this.Cryogen.addChild(this.cryobody);
        this.cryobody.cubeList.add(new ModelBox(this.cryobody, 15, 5, -2.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.setRotation(this.bone, 0.0F, 0.0F, -2.8798F);
        this.cryobody.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 10, -2.5F, -2.5F, -2.6F, 5, 5, 5, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.setRotation(this.bone2, -0.4682F, 0.5585F, 3.1416F);
        this.cryobody.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -2.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F, false));
        this.Cryogen.addChild(this.shield);
        super.setTexture(new ResourceLocation("minidot", "pets/cryogen.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/cryogen_animation.json"));
        this.animation = bbanimationloader.mustGet("cryogen.animation", this);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        GlStateManager.translate(1.25D, Math.sin((double)time * 0.05D) * 0.1D, 0.4D);
        double d0 = 0.7394D;
        GlStateManager.scale(d0, d0, d0);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.2515D, 0.0D);
        double d0 = 0.845D;
        GlStateManager.scale(d0, d0, d0);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0440\u0438\u043e\u0433\u0435\u043d";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Terraria");
    }
}
