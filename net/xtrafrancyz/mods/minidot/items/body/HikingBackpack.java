package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class HikingBackpack extends BaseItem
{
    private final MModelRenderer backpack;
    private final MModelRenderer lamp;
    private final MModelRenderer base;
    private final MModelRenderer lock;
    private final MModelRenderer bone9;
    private final MModelRenderer bone8;
    private final MModelRenderer straps;
    private final MModelRenderer strap2;
    private final MModelRenderer bone2;
    private final MModelRenderer strap3;
    private final MModelRenderer bone4;
    private final MModelRenderer bottle;
    private final MModelRenderer sleeping_bags;
    private final IAnimation animation;

    public HikingBackpack()
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.backpack = new MModelRenderer(this);
        this.backpack.setRotationPoint(0.0F, -6.0F, 2.0F);
        this.lamp = new MModelRenderer(this);
        this.lamp.setRotationPoint(-2.0F, -3.0F, 5.0F);
        this.backpack.addChild(this.lamp);
        this.lamp.cubeList.add(new ModelBox(this.lamp, 28, 0, -1.0F, 4.0F, -1.0F, 3, 1, 3, 0.0F, false));
        this.lamp.cubeList.add(new ModelBox(this.lamp, 30, 22, -0.5F, 0.0F, -0.5F, 2, 4, 2, 0.0F, false));
        this.lamp.cubeList.add(new ModelBox(this.lamp, 24, 7, -1.0F, 0.5F, -1.0F, 3, 3, 3, -0.2F, false));
        this.lamp.cubeList.add(new ModelBox(this.lamp, 0, 29, -1.0F, -0.5F, 0.0F, 3, 5, 1, -0.199F, false));
        this.base = new MModelRenderer(this);
        this.base.setRotationPoint(0.0F, 12.0F, -3.0F);
        this.backpack.addChild(this.base);
        this.base.cubeList.add(new ModelBox(this.base, 20, 24, 4.0F, -14.5F, 3.0F, 2, 5, 3, 0.0F, false));
        this.base.cubeList.add(new ModelBox(this.base, 0, 15, -4.0F, -18.0F, 3.0F, 8, 5, 3, 0.0F, false));
        this.base.cubeList.add(new ModelBox(this.base, 0, 7, -4.0F, -13.0F, 3.0F, 8, 4, 4, 0.0F, false));
        this.base.cubeList.add(new ModelBox(this.base, 20, 32, 0.5F, -12.5F, 7.0F, 3, 3, 1, 0.0F, false));
        this.base.cubeList.add(new ModelBox(this.base, 26, 18, -3.0F, -17.0F, 6.0F, 6, 3, 1, 0.0F, false));
        this.base.cubeList.add(new ModelBox(this.base, 19, 15, -4.0F, -18.75F, 2.55F, 8, 1, 2, -0.2999F, false));
        this.lock = new MModelRenderer(this);
        this.lock.setRotationPoint(0.0F, 12.0F, -3.0F);
        this.backpack.addChild(this.lock);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, -9.6066F, 7.7618F);
        this.setRotation(this.bone9, 0.0873F, 0.0F, 0.0F);
        this.lock.addChild(this.bone9);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-4.0F, -18.0F, 6.0F);
        this.lock.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 0, 3.5F, 3.515F, 1.0235F, 1, 3, 0, 0.0F, false));
        this.straps = new MModelRenderer(this);
        this.straps.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.backpack.addChild(this.straps);
        this.strap2 = new MModelRenderer(this);
        this.strap2.setRotationPoint(6.0F, 0.0F, 0.0F);
        this.straps.addChild(this.strap2);
        this.strap2.cubeList.add(new ModelBox(this.strap2, 0, 23, -4.0F, -21.75F, -1.45F, 2, 1, 5, -0.3F, false));
        this.strap2.cubeList.add(new ModelBox(this.strap2, 14, 24, -4.0F, -21.75F, -1.45F, 2, 12, 1, -0.3F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-3.0F, -10.25F, -0.95F);
        this.setRotation(this.bone2, -0.2452F, -0.0847F, 0.0212F);
        this.strap2.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 17, 18, -1.0F, -0.4387F, -0.4082F, 2, 1, 5, -0.3F, false));
        this.strap3 = new MModelRenderer(this);
        this.strap3.setRotationPoint(-6.0F, 0.0F, 0.0F);
        this.straps.addChild(this.strap3);
        this.strap3.cubeList.add(new ModelBox(this.strap3, 0, 23, 2.0F, -21.75F, -1.45F, 2, 1, 5, -0.3F, true));
        this.strap3.cubeList.add(new ModelBox(this.strap3, 14, 24, 2.0F, -21.75F, -1.45F, 2, 12, 1, -0.3F, true));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(3.0F, -10.25F, -0.95F);
        this.setRotation(this.bone4, -0.2452F, 0.0847F, -0.0212F);
        this.strap3.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 17, 18, -1.0F, -0.4387F, -0.4082F, 2, 1, 5, -0.3F, true));
        this.bottle = new MModelRenderer(this);
        this.bottle.setRotationPoint(-4.0F, -1.5F, 1.4F);
        this.backpack.addChild(this.bottle);
        this.bottle.cubeList.add(new ModelBox(this.bottle, 28, 30, -1.9138F, 0.0F, -0.9633F, 2, 4, 2, 0.0F, false));
        this.bottle.cubeList.add(new ModelBox(this.bottle, 33, 4, -1.93F, 2.0F, -0.9633F, 2, 2, 2, 0.01F, false));
        this.sleeping_bags = new MModelRenderer(this);
        this.sleeping_bags.setRotationPoint(-0.25F, 3.0F, 2.0F);
        this.backpack.addChild(this.sleeping_bags);
        this.sleeping_bags.cubeList.add(new ModelBox(this.sleeping_bags, 0, 0, -5.75F, 0.0F, -2.0F, 12, 3, 4, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "body/hikingbackpack.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/hikingbackpack_animation.json"));
        this.animation = bbanimationloader.mustGet("hikingbackpack.animation", this);
    }

    public void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, 0.718D, 0.0D);
        this.animation.tick(time);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.55D, 0.2662D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u043e\u0445\u043e\u0434\u043d\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
