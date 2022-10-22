package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class WardenPet extends BasePet
{
    private final MModelRenderer warden;
    private final MModelRenderer body;
    private final MModelRenderer hands;
    private final MModelRenderer right;
    private final MModelRenderer left;
    private final MModelRenderer head;
    private final MModelRenderer horns;
    private final MModelRenderer horns2;
    private final MModelRenderer legs;
    private final MModelRenderer left2;
    private final MModelRenderer right3;
    private final IAnimation animation;

    public WardenPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.warden = new MModelRenderer(this);
        this.warden.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.setRotation(this.warden, -3.1416F, 0.0F, 3.1416F);
        this.body = new MModelRenderer(this);
        this.body.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.warden.addChild(this.body);
        this.body.cubeList.add(new ModelBox(this.body, 0, 12, -3.0F, -7.0F, -2.0F, 6, 7, 4, 0.0F, false));
        this.hands = new MModelRenderer(this);
        this.hands.setRotationPoint(0.0F, -6.5F, 0.0F);
        this.body.addChild(this.hands);
        this.right = new MModelRenderer(this);
        this.right.setRotationPoint(3.0F, 0.5F, 0.0F);
        this.hands.addChild(this.right);
        this.right.cubeList.add(new ModelBox(this.right, 17, 22, 0.0F, -0.5F, -1.5F, 2, 7, 3, 0.0F, false));
        this.left = new MModelRenderer(this);
        this.left.setRotationPoint(-3.0F, 0.5F, 0.0F);
        this.hands.addChild(this.left);
        this.left.cubeList.add(new ModelBox(this.left, 20, 12, -2.0F, -0.5F, -1.5F, 2, 7, 3, 0.0F, false));
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.body.addChild(this.head);
        this.head.cubeList.add(new ModelBox(this.head, 0, 0, -3.5F, -7.0F, -2.5F, 7, 7, 5, 0.0F, false));
        this.horns = new MModelRenderer(this);
        this.horns.setRotationPoint(3.5F, -4.5F, 0.0F);
        this.head.addChild(this.horns);
        this.horns.cubeList.add(new ModelBox(this.horns, 27, 22, 0.0F, -3.5F, 0.0F, 5, 5, 0, 0.0F, false));
        this.horns2 = new MModelRenderer(this);
        this.horns2.setRotationPoint(-3.5F, -4.5F, 0.0F);
        this.head.addChild(this.horns2);
        this.horns2.cubeList.add(new ModelBox(this.horns2, 24, 6, -5.0F, -3.5F, 0.0F, 5, 5, 0, 0.0F, false));
        this.legs = new MModelRenderer(this);
        this.warden.addChild(this.legs);
        this.left2 = new MModelRenderer(this);
        this.left2.setRotationPoint(1.5F, -2.0F, 0.0F);
        this.legs.addChild(this.left2);
        this.left2.cubeList.add(new ModelBox(this.left2, 24, 0, -1.0F, 0.0F, -1.5F, 2, 3, 3, 0.0F, false));
        this.right3 = new MModelRenderer(this);
        this.right3.setRotationPoint(-1.5F, -2.0F, 0.0F);
        this.legs.addChild(this.right3);
        this.right3.cubeList.add(new ModelBox(this.right3, 0, 23, -1.0F, 0.0F, -1.5F, 2, 3, 3, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/wardenpet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/wardenpet_animation.json"));
        this.animation = bbanimationloader.mustGet("wardenpet.animation", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        double d0 = Math.sin((double)(time * 0.05F)) * 0.10000000149011612D;
        GlStateManager.translate(1.25D, -0.16D + d0, 0.4D);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.32532500000000003D, 0.0D);
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
        return "\u041d\u0430\u0434\u0437\u0438\u0440\u0430\u0442\u0435\u043b\u044c";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
