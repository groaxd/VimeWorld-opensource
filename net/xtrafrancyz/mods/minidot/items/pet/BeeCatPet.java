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

public class BeeCatPet extends BasePet
{
    private final MModelRenderer cat_bee;
    private final MModelRenderer body;
    private final MModelRenderer arms;
    private final MModelRenderer right_arm;
    private final MModelRenderer left_arm;
    private final MModelRenderer legs;
    private final MModelRenderer left_leg;
    private final MModelRenderer right_leg;
    private final MModelRenderer ears;
    private final MModelRenderer right_ear;
    private final MModelRenderer left_ear;
    private final MModelRenderer wings;
    private final MModelRenderer left_wing;
    private final MModelRenderer right_wing;
    private final MModelRenderer tail;
    private final MModelRenderer tail_end;
    private final MModelRenderer horns;
    private final MModelRenderer right_horn;
    private final MModelRenderer left_horn;
    private final IAnimation animation;

    public BeeCatPet()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.cat_bee = new MModelRenderer(this);
        this.body = new MModelRenderer(this);
        this.cat_bee.addChild(this.body);
        this.body.cubeList.add(new ModelBox(this.body, 0, 25, -2.0F, -7.0F, -3.0F, 3, 2, 1, 0.0F, false));
        this.body.cubeList.add(new ModelBox(this.body, 0, 0, -4.0F, -11.0F, -2.0F, 7, 11, 6, 0.0F, false));
        this.arms = new MModelRenderer(this);
        this.body.addChild(this.arms);
        this.right_arm = new MModelRenderer(this);
        this.right_arm.setRotationPoint(3.0F, -3.75F, 1.0F);
        this.arms.addChild(this.right_arm);
        this.right_arm.cubeList.add(new ModelBox(this.right_arm, 20, 0, -0.5F, -1.25F, -1.0F, 2, 2, 2, 0.0F, true));
        this.left_arm = new MModelRenderer(this);
        this.left_arm.setRotationPoint(-4.0F, -4.0F, 1.0F);
        this.arms.addChild(this.left_arm);
        this.left_arm.cubeList.add(new ModelBox(this.left_arm, 20, 0, -1.5F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.legs = new MModelRenderer(this);
        this.body.addChild(this.legs);
        this.left_leg = new MModelRenderer(this);
        this.left_leg.setRotationPoint(-2.25F, 0.0F, 1.0F);
        this.legs.addChild(this.left_leg);
        this.left_leg.cubeList.add(new ModelBox(this.left_leg, 16, 17, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.right_leg = new MModelRenderer(this);
        this.right_leg.setRotationPoint(1.25F, 0.0F, 1.0F);
        this.legs.addChild(this.right_leg);
        this.right_leg.cubeList.add(new ModelBox(this.right_leg, 16, 17, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, true));
        this.ears = new MModelRenderer(this);
        this.body.addChild(this.ears);
        this.right_ear = new MModelRenderer(this);
        this.right_ear.setRotationPoint(2.25F, -9.75F, 0.0F);
        this.setRotation(this.right_ear, 0.0F, 0.0F, -0.6545F);
        this.ears.addChild(this.right_ear);
        this.right_ear.cubeList.add(new ModelBox(this.right_ear, 20, 21, -1.0F, -2.0F, 0.0F, 3, 3, 1, 0.0F, false));
        this.left_ear = new MModelRenderer(this);
        this.left_ear.setRotationPoint(-3.25F, -9.75F, 0.0F);
        this.setRotation(this.left_ear, 0.0F, 0.0F, 0.6545F);
        this.ears.addChild(this.left_ear);
        this.left_ear.cubeList.add(new ModelBox(this.left_ear, 24, 17, -2.0F, -2.0F, 0.0F, 3, 3, 1, 0.0F, false));
        this.wings = new MModelRenderer(this);
        this.body.addChild(this.wings);
        this.left_wing = new MModelRenderer(this);
        this.left_wing.setRotationPoint(0.5F, -6.0F, 4.0F);
        this.wings.addChild(this.left_wing);
        this.left_wing.cubeList.add(new ModelBox(this.left_wing, 0, 13, 0.0F, -4.0F, 0.0F, 0, 8, 4, 0.0F, false));
        this.right_wing = new MModelRenderer(this);
        this.right_wing.setRotationPoint(-1.5F, -6.0F, 4.0F);
        this.wings.addChild(this.right_wing);
        this.right_wing.cubeList.add(new ModelBox(this.right_wing, 0, 13, 0.0F, -4.0F, 0.0F, 0, 8, 4, 0.0F, false));
        this.tail = new MModelRenderer(this);
        this.tail.setRotationPoint(-0.5F, -1.0F, 4.0F);
        this.body.addChild(this.tail);
        this.tail_end = new MModelRenderer(this);
        this.tail_end.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.tail.addChild(this.tail_end);
        this.tail_end.cubeList.add(new ModelBox(this.tail_end, 8, 17, -1.0F, -2.25F, -6.0F, 2, 2, 4, -0.2F, false));
        this.horns = new MModelRenderer(this);
        this.horns.setRotationPoint(-0.5F, -11.0F, -1.0F);
        this.setRotation(this.horns, 1.4399F, 0.0F, 0.0F);
        this.body.addChild(this.horns);
        this.right_horn = new MModelRenderer(this);
        this.right_horn.setRotationPoint(1.5F, 0.0F, -1.0F);
        this.setRotation(this.right_horn, -0.829F, 0.0F, 0.0F);
        this.horns.addChild(this.right_horn);
        this.right_horn.cubeList.add(new ModelBox(this.right_horn, 8, 20, 0.0F, -7.0F, 0.0F, 0, 7, 3, 0.0F, true));
        this.left_horn = new MModelRenderer(this);
        this.left_horn.setRotationPoint(-1.5F, 0.0F, -1.0F);
        this.setRotation(this.left_horn, -0.829F, 0.0F, 0.0F);
        this.horns.addChild(this.left_horn);
        this.left_horn.cubeList.add(new ModelBox(this.left_horn, 8, 20, 0.0F, -7.0F, 0.0F, 0, 7, 3, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/beecatpet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/beecatpet_animation.json"));
        this.animation = bbanimationloader.mustGet("beecatpet.animation", this);
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
        GlStateManager.translate(0.6F, -0.3F + f, 0.2F);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.2112F, 0.0F);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u043e\u0442\u043e-\u041f\u0447\u0451\u043b";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
