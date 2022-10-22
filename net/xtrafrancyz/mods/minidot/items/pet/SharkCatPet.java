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

public class SharkCatPet extends BasePet
{
    private final MModelRenderer cat_shark;
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
    private final MModelRenderer fin;
    private final MModelRenderer tail;
    private final MModelRenderer tail_end;
    private final MModelRenderer tail_end1;
    private final MModelRenderer tail_end2;
    private final IAnimation animation;

    public SharkCatPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.cat_shark = new MModelRenderer(this);
        this.body = new MModelRenderer(this);
        this.cat_shark.addChild(this.body);
        this.body.cubeList.add(new ModelBox(this.body, 24, 23, -2.0F, -7.0F, -3.0F, 3, 2, 1, 0.0F, false));
        this.body.cubeList.add(new ModelBox(this.body, 0, 0, -4.0F, -11.0F, -2.0F, 7, 11, 6, 0.0F, false));
        this.arms = new MModelRenderer(this);
        this.body.addChild(this.arms);
        this.right_arm = new MModelRenderer(this);
        this.right_arm.setRotationPoint(3.0F, -3.75F, 1.0F);
        this.arms.addChild(this.right_arm);
        this.right_arm.cubeList.add(new ModelBox(this.right_arm, 28, 0, -0.5F, -1.25F, -1.0F, 2, 2, 2, 0.0F, true));
        this.left_arm = new MModelRenderer(this);
        this.left_arm.setRotationPoint(-4.0F, -4.0F, 1.0F);
        this.arms.addChild(this.left_arm);
        this.left_arm.cubeList.add(new ModelBox(this.left_arm, 28, 0, -1.5F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.legs = new MModelRenderer(this);
        this.body.addChild(this.legs);
        this.left_leg = new MModelRenderer(this);
        this.left_leg.setRotationPoint(-2.25F, 0.0F, 1.0F);
        this.legs.addChild(this.left_leg);
        this.left_leg.cubeList.add(new ModelBox(this.left_leg, 36, 0, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.right_leg = new MModelRenderer(this);
        this.right_leg.setRotationPoint(1.25F, 0.0F, 1.0F);
        this.legs.addChild(this.right_leg);
        this.right_leg.cubeList.add(new ModelBox(this.right_leg, 36, 0, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, true));
        this.ears = new MModelRenderer(this);
        this.body.addChild(this.ears);
        this.right_ear = new MModelRenderer(this);
        this.right_ear.setRotationPoint(2.25F, -9.75F, 0.0F);
        this.setRotation(this.right_ear, 0.0F, 0.0F, -0.6545F);
        this.ears.addChild(this.right_ear);
        this.right_ear.cubeList.add(new ModelBox(this.right_ear, 20, 0, -1.0F, -2.0F, 0.0F, 3, 3, 1, 0.0F, false));
        this.left_ear = new MModelRenderer(this);
        this.left_ear.setRotationPoint(-3.25F, -9.75F, 0.0F);
        this.setRotation(this.left_ear, 0.0F, 0.0F, 0.6545F);
        this.ears.addChild(this.left_ear);
        this.left_ear.cubeList.add(new ModelBox(this.left_ear, 24, 19, -2.0F, -2.0F, 0.0F, 3, 3, 1, 0.0F, false));
        this.fin = new MModelRenderer(this);
        this.fin.setRotationPoint(-0.5F, -6.0F, 4.0F);
        this.body.addChild(this.fin);
        this.fin.cubeList.add(new ModelBox(this.fin, 0, 13, 0.0F, -4.0F, 0.0F, 0, 8, 4, 0.0F, false));
        this.tail = new MModelRenderer(this);
        this.tail.setRotationPoint(-0.5F, -1.0F, 4.0F);
        this.body.addChild(this.tail);
        this.tail.cubeList.add(new ModelBox(this.tail, 11, 17, -1.0F, -1.0F, -5.0F, 2, 2, 9, 0.0F, false));
        this.tail_end = new MModelRenderer(this);
        this.tail_end.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.tail.addChild(this.tail_end);
        this.tail_end.cubeList.add(new ModelBox(this.tail_end, 24, 10, -1.0F, -1.0F, -4.0F, 2, 2, 7, -0.2F, false));
        this.tail_end1 = new MModelRenderer(this);
        this.tail_end1.setRotationPoint(0.0F, 1.0F, 2.5F);
        this.setRotation(this.tail_end1, 0.0F, 0.7418F, 0.0F);
        this.tail_end.addChild(this.tail_end1);
        this.tail_end1.cubeList.add(new ModelBox(this.tail_end1, 8, 24, 0.0F, -3.0F, 0.0F, 0, 4, 4, 0.0F, false));
        this.tail_end2 = new MModelRenderer(this);
        this.tail_end2.setRotationPoint(0.0F, 1.0F, 2.5F);
        this.setRotation(this.tail_end2, 0.0F, -0.7418F, 0.0F);
        this.tail_end.addChild(this.tail_end2);
        this.tail_end2.cubeList.add(new ModelBox(this.tail_end2, 0, 21, 0.0F, -3.0F, 0.0F, 0, 4, 4, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/sharkcatpet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/sharkcatpet_animation.json"));
        this.animation = bbanimationloader.mustGet("sharkcatpet.animation", this);
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
        this.animation.tick(time);
        GlStateManager.translate(0.0F, 0.2112F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u043e\u0442\u043e-\u0410\u043a\u0443\u043b";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
