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

public class FatNuggets extends BasePet
{
    private final MModelRenderer FatNuggets;
    private final MModelRenderer legs;
    private final MModelRenderer left_near;
    private final MModelRenderer right_near;
    private final MModelRenderer right_far;
    private final MModelRenderer left_far;
    private final MModelRenderer body;
    private final MModelRenderer tail;
    private final MModelRenderer spikes;
    private final MModelRenderer head;
    private final MModelRenderer ear;
    private final MModelRenderer bone2;
    private final MModelRenderer ear2;
    private final MModelRenderer bone3;
    private final MModelRenderer nose;
    private final MModelRenderer bone;
    private final MModelRenderer bone4;
    private final IAnimation animation;

    public FatNuggets()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.FatNuggets = new MModelRenderer(this);
        this.legs = new MModelRenderer(this);
        this.legs.setRotationPoint(0.0F, -3.0F, -3.0F);
        this.FatNuggets.addChild(this.legs);
        this.left_near = new MModelRenderer(this);
        this.left_near.setRotationPoint(-1.4F, 0.0F, -0.25F);
        this.legs.addChild(this.left_near);
        this.left_near.cubeList.add(new ModelBox(this.left_near, 22, 4, -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.right_near = new MModelRenderer(this);
        this.right_near.setRotationPoint(1.4F, 0.0F, -0.25F);
        this.legs.addChild(this.right_near);
        this.right_near.cubeList.add(new ModelBox(this.right_near, 20, 12, -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.right_far = new MModelRenderer(this);
        this.right_far.setRotationPoint(1.4F, 0.0F, 3.0F);
        this.legs.addChild(this.right_far);
        this.right_far.cubeList.add(new ModelBox(this.right_far, 8, 19, -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.left_far = new MModelRenderer(this);
        this.left_far.setRotationPoint(-1.4F, 0.0F, 3.0F);
        this.legs.addChild(this.left_far);
        this.left_far.cubeList.add(new ModelBox(this.left_far, 0, 19, -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.body = new MModelRenderer(this);
        this.FatNuggets.addChild(this.body);
        this.body.cubeList.add(new ModelBox(this.body, 0, 0, -2.5F, -7.0F, -4.5F, 5, 4, 6, 0.0F, false));
        this.tail = new MModelRenderer(this);
        this.tail.setRotationPoint(0.0F, -6.5F, 1.5F);
        this.body.addChild(this.tail);
        this.tail.cubeList.add(new ModelBox(this.tail, 0, 0, 0.0F, -2.25F, -0.5F, 0, 3, 3, 0.0F, false));
        this.spikes = new MModelRenderer(this);
        this.spikes.setRotationPoint(0.25F, -2.75F, 6.0F);
        this.body.addChild(this.spikes);
        this.spikes.cubeList.add(new ModelBox(this.spikes, 16, 10, -3.25F, -5.0F, -5.5F, 6, 2, 0, 0.0F, false));
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(0.0F, -6.0F, -3.0F);
        this.FatNuggets.addChild(this.head);
        this.head.cubeList.add(new ModelBox(this.head, 0, 10, -3.0F, -3.5F, -4.0F, 6, 5, 4, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 17, 16, 2.75F, -1.75F, -3.75F, 1, 3, 3, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 16, 0, -3.75F, -1.75F, -3.75F, 1, 3, 3, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 0, 27, -1.75F, -4.5F, -2.5F, 3, 1, 0, 0.0F, false));
        this.ear = new MModelRenderer(this);
        this.ear.setRotationPoint(2.25F, -3.5F, -2.0F);
        this.setRotation(this.ear, 0.219F, -0.0852F, 1.77F);
        this.head.addChild(this.ear);
        this.ear.cubeList.add(new ModelBox(this.ear, 6, 23, -0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-2.5F, 4.5F, 7.0F);
        this.setRotation(this.bone2, 0.0F, 0.0F, 0.9599F);
        this.ear.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 23, -4.1773F, -7.3666F, -8.0F, 1, 2, 2, 0.0F, false));
        this.ear2 = new MModelRenderer(this);
        this.ear2.setRotationPoint(-2.25F, -3.5F, -2.0F);
        this.setRotation(this.ear2, 0.219F, 0.0852F, -1.77F);
        this.head.addChild(this.ear2);
        this.ear2.cubeList.add(new ModelBox(this.ear2, 20, 22, -0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(2.5F, 4.5F, 7.0F);
        this.setRotation(this.bone3, 0.0F, 0.0F, -0.9599F);
        this.ear2.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 14, 22, 3.1773F, -7.3666F, -8.0F, 1, 2, 2, 0.0F, false));
        this.nose = new MModelRenderer(this);
        this.nose.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.head.addChild(this.nose);
        this.nose.cubeList.add(new ModelBox(this.nose, 0, 0, -1.0F, -1.0F, -0.75F, 2, 2, 1, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(1.75F, -1.75F, -4.1F);
        this.head.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 10, -0.5F, -1.0F, 0.0F, 1, 2, 0, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-1.75F, -1.75F, -4.1F);
        this.head.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 10, -0.5F, -1.0F, 0.0F, 1, 2, 0, 0.0F, true));
        super.setTexture(new ResourceLocation("minidot", "pets/fatnuggets.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/fatnuggets_animation.json"));
        this.animation = bbanimationloader.mustGet("fatnuggets.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        double d0 = Math.sin((double)(time * 0.05F)) * 0.10000000149011612D;
        GlStateManager.translate(1.25D, -0.25D + d0, 0.4D);
        double d1 = 1.2D;
        GlStateManager.scale(d1, d1, d1);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.253D, 0.116D);
        double d0 = 1.5D;
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
        return "\u0422\u043e\u043b\u0441\u0442\u044b\u0439 \u041d\u0430\u0433\u0433\u0435\u0442\u0441";
    }

    public List<String> getDescription()
    {
        return MNaming.fromMult("\u041e\u0442\u0435\u043b\u044c \u0425\u0430\u0437\u0431\u0438\u043d");
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
