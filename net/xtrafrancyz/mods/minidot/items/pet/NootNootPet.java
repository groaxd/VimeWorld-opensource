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

public class NootNootPet extends BasePet
{
    private final MModelRenderer root;
    private final MModelRenderer base;
    private final MModelRenderer head;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer eyes;
    private final MModelRenderer body;
    private final MModelRenderer arms;
    private final MModelRenderer r_arm;
    private final MModelRenderer l_arm;
    private final MModelRenderer legs;
    private final MModelRenderer r_leg;
    private final MModelRenderer l_leg;
    private final IAnimation animation;

    public NootNootPet()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.root = new MModelRenderer(this);
        this.root.setRotationPoint(0.0F, 4.0F, 3.0F);
        this.base = new MModelRenderer(this);
        this.base.setRotationPoint(0.5F, -6.0F, -1.5F);
        this.root.addChild(this.base);
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(0.0F, -7.0F, 0.5F);
        this.base.addChild(this.head);
        this.head.cubeList.add(new ModelBox(this.head, 13, 11, -2.5F, -4.0F, -2.0F, 5, 4, 4, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, -1.0F, -2.0F);
        this.head.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 10, 19, -1.0F, -1.0F, -3.25F, 2, 2, 4, -0.4F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.0F, 0.0F, -2.5F);
        this.bone6.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 11, -1.0F, -1.0F, -1.0F, 2, 2, 1, -0.2F, false));
        this.eyes = new MModelRenderer(this);
        this.eyes.setRotationPoint(0.0F, -1.675F, -2.05F);
        this.head.addChild(this.eyes);
        this.eyes.cubeList.add(new ModelBox(this.eyes, 0, 26, -2.5F, -1.325F, 0.0F, 5, 2, 0, 0.0F, false));
        this.body = new MModelRenderer(this);
        this.body.setRotationPoint(-0.5F, 2.0F, 1.5F);
        this.base.addChild(this.body);
        this.body.cubeList.add(new ModelBox(this.body, 0, 0, -2.0F, -9.0F, -3.0F, 5, 7, 4, 0.0F, false));
        this.arms = new MModelRenderer(this);
        this.body.addChild(this.arms);
        this.r_arm = new MModelRenderer(this);
        this.r_arm.setRotationPoint(-2.0F, -8.0F, -1.0F);
        this.setRotation(this.r_arm, 0.0F, 0.0F, 0.0873F);
        this.arms.addChild(this.r_arm);
        this.r_arm.cubeList.add(new ModelBox(this.r_arm, 18, 0, -1.0872F, -0.9962F, -2.0F, 1, 7, 4, 0.0F, false));
        this.l_arm = new MModelRenderer(this);
        this.l_arm.setRotationPoint(3.0F, -8.0F, -1.0F);
        this.setRotation(this.l_arm, 0.0F, 0.0F, -0.0873F);
        this.arms.addChild(this.l_arm);
        this.l_arm.cubeList.add(new ModelBox(this.l_arm, 0, 14, 0.0872F, -0.9962F, -2.0F, 1, 7, 4, 0.0F, false));
        this.legs = new MModelRenderer(this);
        this.legs.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.root.addChild(this.legs);
        this.r_leg = new MModelRenderer(this);
        this.r_leg.setRotationPoint(-0.75F, 0.0F, 1.0F);
        this.setRotation(this.r_leg, 0.0F, 0.2618F, 0.0F);
        this.legs.addChild(this.r_leg);
        this.r_leg.cubeList.add(new ModelBox(this.r_leg, 0, 11, -1.25F, 0.0F, -7.0F, 3, 0, 7, 0.0F, false));
        this.r_leg.cubeList.add(new ModelBox(this.r_leg, 0, 0, 0.25F, -2.0F, -3.0F, 0, 2, 1, 0.0F, false));
        this.l_leg = new MModelRenderer(this);
        this.l_leg.setRotationPoint(1.75F, 0.0F, 1.0F);
        this.setRotation(this.l_leg, 0.0F, -0.2618F, 0.0F);
        this.legs.addChild(this.l_leg);
        this.l_leg.cubeList.add(new ModelBox(this.l_leg, 0, 11, -1.75F, 0.0F, -7.0F, 3, 0, 7, 0.0F, true));
        this.l_leg.cubeList.add(new ModelBox(this.l_leg, 0, 0, -0.25F, -2.0F, -3.0F, 0, 2, 1, 0.0F, true));
        super.setTexture(new ResourceLocation("minidot", "pets/nootnootpet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/nootnootpet_animation.json"));
        this.animation = bbanimationloader.mustGet("nootnootpet.animation", this);
    }

    public void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.animation.tick(time);
        float f = MathHelper.sin(time * 0.16F) * 0.04F;
        GlStateManager.translate(0.6F, -0.25F + f, 0.2F);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.301D, -0.0729D);
        double d0 = 1.2323D;
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
        return "Noot Noot";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
