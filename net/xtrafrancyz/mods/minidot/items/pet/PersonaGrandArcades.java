package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.Arrays;
import java.util.List;
import net.minecraft.client.Minecraft;
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
import org.lwjgl.util.glu.Sphere;

public class PersonaGrandArcades extends BasePet
{
    private final MModelRenderer main;
    private final MModelRenderer body;
    private final MModelRenderer top;
    private final MModelRenderer left_ear;
    private final MModelRenderer bone5;
    private final MModelRenderer right_ear;
    private final MModelRenderer bone6;
    private final MModelRenderer bottom;
    private final MModelRenderer left_leg;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer right_leg;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer face;
    private final MModelRenderer mouth;
    private final MModelRenderer mouth_one;
    private final MModelRenderer mouth_two;
    private final MModelRenderer eyes;
    private final MModelRenderer eyes_one;
    private final MModelRenderer eyes_two;
    private final MModelRenderer hands;
    private final MModelRenderer left_hand;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer right_hand;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final IAnimation animation;
    private final ResourceLocation texture = new ResourceLocation("minidot", "pets/persona_grand_arcades_sphere.png");

    public PersonaGrandArcades()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.main = new MModelRenderer(this);
        this.main.setRotationPoint(0.0F, -10.0F, 0.0F);
        this.body = new MModelRenderer(this);
        this.body.setRotationPoint(0.0F, 5.4F, 0.0F);
        this.main.addChild(this.body);
        this.body.cubeList.add(new ModelBox(this.body, 0, 0, -7.0F, -12.9F, -3.5F, 14, 13, 7, 0.0F, false));
        this.top = new MModelRenderer(this);
        this.top.setRotationPoint(0.0F, -12.4F, 0.0F);
        this.body.addChild(this.top);
        this.top.cubeList.add(new ModelBox(this.top, 0, 20, -6.0F, -1.5F, -2.5F, 12, 3, 5, 0.0F, false));
        this.left_ear = new MModelRenderer(this);
        this.left_ear.setRotationPoint(3.5F, -0.5F, 0.0F);
        this.top.addChild(this.left_ear);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-1.2F, -2.1F, 0.0F);
        this.setRotation(this.bone5, 0.0F, 0.0F, 0.3054F);
        this.left_ear.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 10, 40, -0.3F, -2.1F, -0.5F, 4, 5, 1, 0.0F, false));
        this.right_ear = new MModelRenderer(this);
        this.right_ear.setRotationPoint(-3.5F, -0.5F, 0.0F);
        this.top.addChild(this.right_ear);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(1.2F, -2.1F, 0.0F);
        this.setRotation(this.bone6, 0.0F, 0.0F, -0.3054F);
        this.right_ear.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 35, 0, -3.7F, -2.1F, -0.5F, 4, 5, 1, 0.0F, false));
        this.bottom = new MModelRenderer(this);
        this.bottom.setRotationPoint(0.0F, -0.9F, -2.5F);
        this.body.addChild(this.bottom);
        this.bottom.cubeList.add(new ModelBox(this.bottom, 0, 28, -6.0F, -1.0F, 0.0F, 12, 3, 5, 0.0F, false));
        this.left_leg = new MModelRenderer(this);
        this.left_leg.setRotationPoint(3.0F, 1.7F, 2.5F);
        this.bottom.addChild(this.left_leg);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-0.3F, 2.0F, 0.0F);
        this.setRotation(this.bone7, 0.0F, 0.0F, 0.1309F);
        this.left_leg.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 31, 38, -0.5F, -3.0F, -1.501F, 3, 5, 3, 0.0F, true));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-1.0914F, 1.8564F, 0.0F);
        this.setRotation(this.bone8, 0.0F, 0.0F, -0.2618F);
        this.left_leg.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 40, -0.5F, -3.0F, -1.5F, 2, 5, 3, 0.0F, true));
        this.right_leg = new MModelRenderer(this);
        this.right_leg.setRotationPoint(-3.0F, 1.7F, 2.5F);
        this.bottom.addChild(this.right_leg);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.3F, 2.0F, 0.0F);
        this.setRotation(this.bone9, 0.0F, 0.0F, -0.1309F);
        this.right_leg.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 31, 38, -2.5F, -3.0F, -1.501F, 3, 5, 3, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(1.0914F, 1.8564F, 0.0F);
        this.setRotation(this.bone10, 0.0F, 0.0F, 0.2618F);
        this.right_leg.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 0, 40, -1.5F, -3.0F, -1.5F, 2, 5, 3, 0.0F, false));
        this.face = new MModelRenderer(this);
        this.face.setRotationPoint(0.0F, 1.3F, 0.0F);
        this.body.addChild(this.face);
        this.mouth = new MModelRenderer(this);
        this.face.addChild(this.mouth);
        this.mouth_one = new MModelRenderer(this);
        this.mouth.addChild(this.mouth_one);
        this.mouth_one.cubeList.add(new ModelBox(this.mouth_one, 20, 40, -2.0F, -8.7F, -3.6F, 4, 4, 0, 0.0F, false));
        this.mouth_two = new MModelRenderer(this);
        this.mouth_two.setRotationPoint(0.0F, -6.7F, 0.0F);
        this.mouth.addChild(this.mouth_two);
        this.mouth_two.cubeList.add(new ModelBox(this.mouth_two, 34, 33, -4.0F, -1.0F, -2.6F, 8, 2, 0, 0.0F, false));
        this.eyes = new MModelRenderer(this);
        this.eyes.setRotationPoint(0.0F, -0.2F, -2.5F);
        this.face.addChild(this.eyes);
        this.eyes_one = new MModelRenderer(this);
        this.eyes_one.setRotationPoint(0.0F, -9.5F, -1.1F);
        this.eyes.addChild(this.eyes_one);
        this.eyes_one.cubeList.add(new ModelBox(this.eyes_one, 34, 24, -6.0F, -2.0F, 0.0F, 12, 4, 0, 0.0F, false));
        this.eyes_two = new MModelRenderer(this);
        this.eyes_two.setRotationPoint(0.0F, -9.5F, -1.1F);
        this.eyes.addChild(this.eyes_two);
        this.eyes_two.cubeList.add(new ModelBox(this.eyes_two, 29, 20, -6.0F, -2.0F, 1.0F, 12, 4, 0, 0.0F, false));
        this.hands = new MModelRenderer(this);
        this.hands.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.body.addChild(this.hands);
        this.left_hand = new MModelRenderer(this);
        this.left_hand.setRotationPoint(6.6F, -0.4F, 0.2F);
        this.setRotation(this.left_hand, 0.0F, -0.1745F, -0.6109F);
        this.hands.addChild(this.left_hand);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.7411F, 2.3929F, -0.222F);
        this.setRotation(this.bone, 0.0F, -0.2182F, 1.2217F);
        this.left_hand.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 34, 28, -3.5F, -1.0F, -1.5F, 7, 2, 3, 0.0F, true));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.6017F, 2.0098F, 0.5F);
        this.setRotation(this.bone2, 0.0F, 0.0F, 1.2217F);
        this.left_hand.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 34, 28, -3.5F, -1.0F, -1.5F, 7, 2, 3, 0.0F, true));
        this.right_hand = new MModelRenderer(this);
        this.right_hand.setRotationPoint(-6.6F, -0.4F, 0.2F);
        this.setRotation(this.right_hand, 0.0F, 0.1745F, 0.6109F);
        this.hands.addChild(this.right_hand);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-0.6017F, 2.0098F, 0.5F);
        this.setRotation(this.bone3, 0.0F, 0.0F, -1.2217F);
        this.right_hand.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 34, 28, -3.5F, -1.0F, -1.5F, 7, 2, 3, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-0.7411F, 2.3929F, -0.222F);
        this.setRotation(this.bone4, 0.0F, 0.2182F, -1.2217F);
        this.right_hand.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 34, 28, -3.5F, -1.0F, -1.5F, 7, 2, 3, 0.0F, false));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/persona_grand_arcades_animation.json"));
        this.animation = bbanimationloader.mustGet("idle", this);
        this.setTexture(new ResourceLocation("minidot", "pets/persona_grand_arcades.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.translate(0.7F, -0.3F + f, 0.3F);
        float f1 = 0.5F;
        GlStateManager.scale(f1, f1, f1);
        GlStateManager.rotate(time, 0.0F, 1.0F, 1.0F);
        this.animation.tick(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.render(modelPlayer, player, time, pi);
        GlStateManager.pushMatrix();
        GlStateManager.enableCull();
        this.preRender(modelPlayer, player, time, pi);
        this.renderSphere(time);
        GlStateManager.disableCull();
        GlStateManager.popMatrix();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
        GlStateManager.rotate(time, 0.0F, 1.0F, 1.0F);
        GlStateManager.translate(0.0F, 0.35F, 0.0F);
        this.animation.tick(time);
        super.renderAsItem(time);
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        this.renderSphere(time);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    private void renderSphere(float time)
    {
        float f = time % 360.0F;

        if (f >= 180.0F)
        {
            f = 360.0F - f;
        }

        f = f / 180.0F;
        GlStateManager.color(f, 1.0F, 1.0F, 0.5F);
        GlStateManager.translate(0.0F, -0.7F, 0.0F);
        GlStateManager.rotate(time, -0.3F, -0.7F, 0.0F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
        Sphere sphere = new Sphere();
        sphere.setTextureFlag(true);
        sphere.draw(1.1F, 7, 7);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public String getName()
    {
        return "\u041f\u0435\u0440\u0441\u043e\u043d\u0430 \u0432 \u0410\u0440\u043a\u0430\u0434\u0430\u0445";
    }

    public List<String> getDescription()
    {
        return Arrays.<String>asList(new String[] {"\u042d\u043a\u0441\u043a\u043b\u044e\u0437\u0438\u0432\u043d\u0430\u044f \u043c\u043e\u0434\u0435\u043b\u044c", "\u0438\u0437 \u0442\u0438\u0437\u0435\u0440\u0430 \u00a76\u00a7l\u0413\u0440\u0430\u043d\u0434 \u0410\u0440\u043a\u0430\u0434"});
    }
}
