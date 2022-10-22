package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import java.util.function.Consumer;
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
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class TriggerTeddy extends BasePet
{
    private final MModelRenderer TriggerTeddy;
    private final MModelRenderer leg_right;
    private final MModelRenderer leg_left;
    private final MModelRenderer arm_left;
    private final MModelRenderer arm_right;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer head;
    private final MModelRenderer skull;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer costume;
    private final IAnimation animation;
    private final IAnimation secret;
    private boolean secretReseted;

    public TriggerTeddy()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.TriggerTeddy = new MModelRenderer(this);
        this.TriggerTeddy.cubeList.add(new ModelBox(this.TriggerTeddy, 7, 31, 1.75F, -5.25F, -2.9F, 1, 1, 1, 0.0F, false));
        this.TriggerTeddy.cubeList.add(new ModelBox(this.TriggerTeddy, 27, 30, 2.0F, -6.25F, -2.65F, 1, 1, 1, 0.0F, false));
        this.TriggerTeddy.cubeList.add(new ModelBox(this.TriggerTeddy, 20, 13, -2.5F, -8.0F, -2.5F, 5, 6, 3, 0.0F, false));
        this.TriggerTeddy.cubeList.add(new ModelBox(this.TriggerTeddy, 0, 32, -0.5F, -7.25F, -3.5F, 1, 1, 1, 0.0F, false));
        this.leg_right = new MModelRenderer(this);
        this.leg_right.setRotationPoint(-2.0F, -2.25F, -1.0F);
        this.setRotation(this.leg_right, -0.2182F, 0.0F, -0.1309F);
        this.TriggerTeddy.addChild(this.leg_right);
        this.leg_right.cubeList.add(new ModelBox(this.leg_right, 26, 6, -1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F, false));
        this.leg_right.cubeList.add(new ModelBox(this.leg_right, 15, 31, -1.5F, 1.0F, -1.5F, 1, 1, 1, 0.0F, false));
        this.leg_right.cubeList.add(new ModelBox(this.leg_right, 11, 31, -1.25F, 1.5F, -1.25F, 1, 1, 1, 0.0F, false));
        this.leg_left = new MModelRenderer(this);
        this.leg_left.setRotationPoint(2.0F, -2.25F, -1.0F);
        this.setRotation(this.leg_left, -0.2182F, 0.0F, 0.1309F);
        this.TriggerTeddy.addChild(this.leg_left);
        this.leg_left.cubeList.add(new ModelBox(this.leg_left, 8, 23, -1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F, false));
        this.arm_left = new MModelRenderer(this);
        this.arm_left.setRotationPoint(2.25F, -7.75F, -1.0F);
        this.setRotation(this.arm_left, -0.1745F, 0.0F, -0.3054F);
        this.TriggerTeddy.addChild(this.arm_left);
        this.arm_left.cubeList.add(new ModelBox(this.arm_left, 0, 23, 0.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F, false));
        this.arm_right = new MModelRenderer(this);
        this.arm_right.setRotationPoint(-2.25F, -7.75F, -1.0F);
        this.setRotation(this.arm_right, -0.1745F, 0.0F, 0.3054F);
        this.TriggerTeddy.addChild(this.arm_right);
        this.arm_right.cubeList.add(new ModelBox(this.arm_right, 18, 22, -2.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.5F, -6.75F, -3.0F);
        this.setRotation(this.bone3, 0.0F, 0.0F, 0.3927F);
        this.TriggerTeddy.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 31, 30, 0.0F, -1.0F, 0.0F, 2, 2, 0, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-0.5F, -6.75F, -3.0F);
        this.setRotation(this.bone4, 0.0F, 0.0F, -0.3927F);
        this.TriggerTeddy.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 19, 31, -2.0F, -1.0F, 0.0F, 2, 2, 0, 0.0F, false));
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(0.0F, -8.0F, -1.0F);
        this.TriggerTeddy.addChild(this.head);
        this.skull = new MModelRenderer(this);
        this.skull.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.head.addChild(this.skull);
        this.skull.cubeList.add(new ModelBox(this.skull, 0, 13, -2.5F, -5.0F, -2.5F, 5, 5, 5, 0.0F, false));
        this.skull.cubeList.add(new ModelBox(this.skull, 23, 30, -0.5F, -0.25F, -0.5F, 1, 1, 1, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(2.5F, -2.5F, -0.25F);
        this.setRotation(this.bone, 0.3491F, 0.2182F, 0.0F);
        this.skull.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 14, 27, -0.5F, -1.0F, -0.5F, 1, 2, 2, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-2.5F, -2.5F, -0.25F);
        this.setRotation(this.bone2, 0.3491F, -0.2182F, 0.0F);
        this.skull.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -0.5F, -1.0F, -0.5F, 1, 2, 2, 0.0F, false));
        this.costume = new MModelRenderer(this);
        this.costume.setRotationPoint(0.0F, -0.25F, 0.0F);
        this.head.addChild(this.costume);
        this.costume.cubeList.add(new ModelBox(this.costume, 0, 0, -3.5F, -7.0F, -3.0F, 7, 7, 6, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 26, 26, -4.5F, -8.5F, 0.0F, 3, 3, 1, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 26, 22, 1.5F, -8.5F, 0.0F, 3, 3, 1, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 28, 0, -2.0F, -0.75F, -3.5F, 4, 1, 1, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 20, 0, -4.0F, -7.75F, -1.5F, 2, 2, 4, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 20, 2, -3.5F, -8.25F, -1.75F, 1, 1, 1, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 20, 0, -4.5F, -7.25F, -1.75F, 1, 1, 1, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 15, 15, -4.75F, -6.25F, 0.5F, 1, 1, 1, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 0, 15, -4.25F, -8.0F, 1.25F, 1, 1, 1, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 0, 13, -2.75F, -8.25F, 0.25F, 1, 1, 1, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 28, 2, -0.25F, -0.5F, -4.0F, 2, 1, 1, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 0, 4, -1.25F, -0.25F, -3.75F, 2, 1, 1, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 14, 23, -1.75F, -1.0F, -4.0F, 1, 1, 1, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 6, 23, 1.25F, -0.25F, -3.75F, 1, 1, 1, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 15, 13, -1.5F, -2.75F, -4.0F, 3, 1, 1, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 7, 29, -1.0F, -3.0F, -4.25F, 2, 1, 1, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 4, 30, -0.5F, -3.5F, -4.5F, 1, 1, 1, 0.0F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 0, 30, 1.5F, -4.25F, -3.0F, 1, 1, 1, 0.2F, false));
        this.costume.cubeList.add(new ModelBox(this.costume, 20, 29, -2.5F, -4.25F, -3.0F, 1, 1, 1, 0.2F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/triggerteddy.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/triggerteddy_animation.json"));
        this.animation = bbanimationloader.mustGet("idle", this);
        this.secret = bbanimationloader.mustGet("secret", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        double d0 = (double)MathHelper.sin(time * 0.1F) * 0.03D;
        GlStateManager.translate(1.0D, -0.2D + d0, 0.5D);
        GlStateManager.scale(0.9D, 0.9D, 0.9D);

        if (player.getHealth() <= 5.5F)
        {
            if (this.secret.isFinished())
            {
                this.secret.reset();
            }

            this.secret.tick(time);
            this.secretReseted = false;
        }
        else
        {
            if (!this.secretReseted)
            {
                this.secret.reset();
                this.forEachDynamicModel((modelRenderer) ->
                {
                    modelRenderer.rotationX = 0.0F;
                    modelRenderer.scaleX = 1.0F;
                    modelRenderer.rotationY = 0.0F;
                    modelRenderer.scaleY = 1.0F;
                    modelRenderer.rotationZ = 0.0F;
                    modelRenderer.scaleZ = 1.0F;
                });
                this.secretReseted = true;
            }

            this.animation.tick(time);
        }
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.25D, 0.1D);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0422\u0440\u0438\u0433\u0433\u0435\u0440 \u041c\u0438\u0448\u043a\u0430";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Dark Deception");
    }
}
