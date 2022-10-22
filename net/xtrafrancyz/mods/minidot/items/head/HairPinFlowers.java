package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class HairPinFlowers extends BaseItem
{
    private final MModelRenderer bone;
    private final MModelRenderer flowerOne;
    private final MModelRenderer leaf;
    private final MModelRenderer bonefour;
    private final MModelRenderer bonefive;
    private final MModelRenderer petal;
    private final MModelRenderer boneseven;
    private final MModelRenderer boneeight;
    private final MModelRenderer bonenine;
    private final MModelRenderer boneone;
    private final MModelRenderer boneeleven;
    private final MModelRenderer bonetwelve;
    private final MModelRenderer bonethirteen;
    private final MModelRenderer bonefourteen;
    private final MModelRenderer bonefifteen;
    private final MModelRenderer bonesixteen;
    private final MModelRenderer boneseventeen;
    private final MModelRenderer boneeighteen;
    private final MModelRenderer bonenineteen;
    private final MModelRenderer bonetwenty;
    private final MModelRenderer bonetwentyone;
    private final MModelRenderer bonefourtythree;
    private final MModelRenderer flowerTwo;
    private final MModelRenderer bonetwentythree;
    private final MModelRenderer bonetwentyfour;
    private final MModelRenderer bonetwentyfive;
    private final MModelRenderer bonetwentysix;
    private final MModelRenderer bonetwentyseven;
    private final MModelRenderer bonetwentyeight;
    private final MModelRenderer bonetwentynine;
    private final MModelRenderer bonethirty;
    private final MModelRenderer bonethirtyone;
    private final MModelRenderer bonethirtytwo;
    private final MModelRenderer bonethirtythree;
    private final MModelRenderer bonethirtyfour;
    private final MModelRenderer bonethirtyfive;
    private final MModelRenderer bonethirtysix;
    private final MModelRenderer bonethirtyseven;
    private final MModelRenderer bonethirtyeight;
    private final MModelRenderer bonethirtynine;
    private final MModelRenderer bonefourty;
    private final MModelRenderer bonefourtyone;
    private final MModelRenderer bonefourtytwo;
    private final IAnimation animation;
    private final String color;

    public HairPinFlowers(String color)
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.color = color;
        this.bone = new MModelRenderer(this);
        this.flowerOne = new MModelRenderer(this);
        this.flowerOne.setRotationPoint(4.25F, -7.25F, -3.75F);
        this.setRotation(this.flowerOne, 0.8505F, -0.3432F, 0.666F);
        this.bone.addChild(this.flowerOne);
        this.leaf = new MModelRenderer(this);
        this.leaf.setRotationPoint(-0.5F, 2.75F, 0.25F);
        this.flowerOne.addChild(this.leaf);
        this.bonefour = new MModelRenderer(this);
        this.bonefour.setRotationPoint(0.5F, -3.0F, 0.0F);
        this.setRotation(this.bonefour, 0.3884F, -1.0037F, -0.2203F);
        this.leaf.addChild(this.bonefour);
        this.bonefour.cubeList.add(new ModelBox(this.bonefour, 0, 3, -0.5F, 0.0F, -3.0F, 1, 0, 3, 0.0F, true));
        this.bonefive = new MModelRenderer(this);
        this.bonefive.setRotationPoint(0.0F, -3.0F, -0.5F);
        this.setRotation(this.bonefive, 0.1072F, -0.5623F, 0.1764F);
        this.leaf.addChild(this.bonefive);
        this.bonefive.cubeList.add(new ModelBox(this.bonefive, 0, 0, -0.5429F, 0.0F, -2.75F, 2, 0, 3, 1.0E-4F, true));
        this.petal = new MModelRenderer(this);
        this.petal.setRotationPoint(-0.5F, 0.75F, 1.25F);
        this.flowerOne.addChild(this.petal);
        this.boneseven = new MModelRenderer(this);
        this.boneseven.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.setRotation(this.boneseven, 0.4363F, 0.0F, 0.0F);
        this.petal.addChild(this.boneseven);
        this.boneeight = new MModelRenderer(this);
        this.boneseven.addChild(this.boneeight);
        this.boneeight.cubeList.add(new ModelBox(this.boneeight, 7, 6, -0.5F, 0.0F, 0.0F, 1, 0, 2, 1.0E-4F, true));
        this.bonenine = new MModelRenderer(this);
        this.setRotation(this.bonenine, 0.0F, -0.6109F, 0.0F);
        this.boneseven.addChild(this.bonenine);
        this.bonenine.cubeList.add(new ModelBox(this.bonenine, 7, 4, 0.0F, 0.0F, -0.25F, 1, 0, 2, 0.0F, true));
        this.boneone = new MModelRenderer(this);
        this.setRotation(this.boneone, 0.0F, 0.6109F, 0.0F);
        this.boneseven.addChild(this.boneone);
        this.boneone.cubeList.add(new ModelBox(this.boneone, 7, 2, -1.0F, 0.0F, -0.25F, 1, 0, 2, 0.002F, true));
        this.boneeleven = new MModelRenderer(this);
        this.boneeleven.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.setRotation(this.boneeleven, -2.7053F, 0.0F, 3.1416F);
        this.petal.addChild(this.boneeleven);
        this.bonetwelve = new MModelRenderer(this);
        this.boneeleven.addChild(this.bonetwelve);
        this.bonetwelve.cubeList.add(new ModelBox(this.bonetwelve, 2, 7, -0.5F, 0.0F, 0.0F, 1, 0, 2, 1.0E-4F, true));
        this.bonethirteen = new MModelRenderer(this);
        this.setRotation(this.bonethirteen, 0.0F, -0.6109F, 0.0F);
        this.boneeleven.addChild(this.bonethirteen);
        this.bonethirteen.cubeList.add(new ModelBox(this.bonethirteen, 7, 0, 0.0F, 0.0F, -0.25F, 1, 0, 2, 0.0F, true));
        this.bonefourteen = new MModelRenderer(this);
        this.setRotation(this.bonefourteen, 0.0F, 0.6109F, 0.0F);
        this.boneeleven.addChild(this.bonefourteen);
        this.bonefourteen.cubeList.add(new ModelBox(this.bonefourteen, 5, 6, -1.0F, 0.0F, -0.25F, 1, 0, 2, 0.002F, true));
        this.bonefifteen = new MModelRenderer(this);
        this.bonefifteen.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.setRotation(this.bonefifteen, 0.0F, 1.5708F, -0.4363F);
        this.petal.addChild(this.bonefifteen);
        this.bonesixteen = new MModelRenderer(this);
        this.bonefifteen.addChild(this.bonesixteen);
        this.bonesixteen.cubeList.add(new ModelBox(this.bonesixteen, 0, 6, -0.5F, 0.0F, 0.0F, 1, 0, 2, 1.0E-4F, true));
        this.boneseventeen = new MModelRenderer(this);
        this.setRotation(this.boneseventeen, 0.0F, -0.6109F, 0.0F);
        this.bonefifteen.addChild(this.boneseventeen);
        this.boneseventeen.cubeList.add(new ModelBox(this.boneseventeen, 5, 4, 0.0F, 0.0F, -0.25F, 1, 0, 2, 0.002F, true));
        this.boneeighteen = new MModelRenderer(this);
        this.setRotation(this.boneeighteen, 0.0F, 0.6109F, 0.0F);
        this.bonefifteen.addChild(this.boneeighteen);
        this.boneeighteen.cubeList.add(new ModelBox(this.boneeighteen, 3, 5, -1.0F, 0.0F, -0.25F, 1, 0, 2, 0.0F, true));
        this.bonenineteen = new MModelRenderer(this);
        this.bonenineteen.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.setRotation(this.bonenineteen, 0.0F, -1.5708F, 0.4363F);
        this.petal.addChild(this.bonenineteen);
        this.bonetwenty = new MModelRenderer(this);
        this.bonenineteen.addChild(this.bonetwenty);
        this.bonetwenty.cubeList.add(new ModelBox(this.bonetwenty, 5, 2, -0.5F, 0.0F, 0.0F, 1, 0, 2, 1.0E-4F, true));
        this.bonetwentyone = new MModelRenderer(this);
        this.setRotation(this.bonetwentyone, 0.0F, -0.6109F, 0.0F);
        this.bonenineteen.addChild(this.bonetwentyone);
        this.bonetwentyone.cubeList.add(new ModelBox(this.bonetwentyone, 5, 0, 0.0F, 0.0F, -0.25F, 1, 0, 2, 0.002F, true));
        this.bonefourtythree = new MModelRenderer(this);
        this.setRotation(this.bonefourtythree, 0.0F, 0.6109F, 0.0F);
        this.bonenineteen.addChild(this.bonefourtythree);
        this.bonefourtythree.cubeList.add(new ModelBox(this.bonefourtythree, 3, 3, -1.0F, 0.0F, -0.25F, 1, 0, 2, 0.0F, true));
        this.flowerTwo = new MModelRenderer(this);
        this.flowerTwo.setRotationPoint(-4.25F, -7.25F, -3.75F);
        this.setRotation(this.flowerTwo, 0.8505F, 0.3432F, -0.666F);
        this.bone.addChild(this.flowerTwo);
        this.bonetwentythree = new MModelRenderer(this);
        this.bonetwentythree.setRotationPoint(0.5F, 2.75F, 0.25F);
        this.flowerTwo.addChild(this.bonetwentythree);
        this.bonetwentyfour = new MModelRenderer(this);
        this.bonetwentyfour.setRotationPoint(-0.5F, -3.0F, 0.0F);
        this.setRotation(this.bonetwentyfour, 0.3884F, 1.0037F, 0.2203F);
        this.bonetwentythree.addChild(this.bonetwentyfour);
        this.bonetwentyfour.cubeList.add(new ModelBox(this.bonetwentyfour, 0, 3, -0.5F, 0.0F, -3.0F, 1, 0, 3, 0.0F, false));
        this.bonetwentyfive = new MModelRenderer(this);
        this.bonetwentyfive.setRotationPoint(0.0F, -3.0F, -0.5F);
        this.setRotation(this.bonetwentyfive, 0.1072F, 0.5623F, -0.1764F);
        this.bonetwentythree.addChild(this.bonetwentyfive);
        this.bonetwentyfive.cubeList.add(new ModelBox(this.bonetwentyfive, 0, 0, -1.4571F, 0.0F, -2.75F, 2, 0, 3, 1.0E-4F, false));
        this.bonetwentysix = new MModelRenderer(this);
        this.bonetwentysix.setRotationPoint(0.5F, 0.75F, 1.25F);
        this.flowerTwo.addChild(this.bonetwentysix);
        this.bonetwentyseven = new MModelRenderer(this);
        this.bonetwentyseven.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.setRotation(this.bonetwentyseven, 0.4363F, 0.0F, 0.0F);
        this.bonetwentysix.addChild(this.bonetwentyseven);
        this.bonetwentyeight = new MModelRenderer(this);
        this.bonetwentyseven.addChild(this.bonetwentyeight);
        this.bonetwentyeight.cubeList.add(new ModelBox(this.bonetwentyeight, 7, 6, -0.5F, 0.0F, 0.0F, 1, 0, 2, 1.0E-4F, false));
        this.bonetwentynine = new MModelRenderer(this);
        this.setRotation(this.bonetwentynine, 0.0F, 0.6109F, 0.0F);
        this.bonetwentyseven.addChild(this.bonetwentynine);
        this.bonetwentynine.cubeList.add(new ModelBox(this.bonetwentynine, 7, 4, -1.0F, 0.0F, -0.25F, 1, 0, 2, 0.0F, false));
        this.bonethirty = new MModelRenderer(this);
        this.setRotation(this.bonethirty, 0.0F, -0.6109F, 0.0F);
        this.bonetwentyseven.addChild(this.bonethirty);
        this.bonethirty.cubeList.add(new ModelBox(this.bonethirty, 7, 2, 0.0F, 0.0F, -0.25F, 1, 0, 2, 0.002F, false));
        this.bonethirtyone = new MModelRenderer(this);
        this.bonethirtyone.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.setRotation(this.bonethirtyone, -2.7053F, 0.0F, -3.1416F);
        this.bonetwentysix.addChild(this.bonethirtyone);
        this.bonethirtytwo = new MModelRenderer(this);
        this.bonethirtyone.addChild(this.bonethirtytwo);
        this.bonethirtytwo.cubeList.add(new ModelBox(this.bonethirtytwo, 2, 7, -0.5F, 0.0F, 0.0F, 1, 0, 2, 1.0E-4F, false));
        this.bonethirtythree = new MModelRenderer(this);
        this.setRotation(this.bonethirtythree, 0.0F, 0.6109F, 0.0F);
        this.bonethirtyone.addChild(this.bonethirtythree);
        this.bonethirtythree.cubeList.add(new ModelBox(this.bonethirtythree, 7, 0, -1.0F, 0.0F, -0.25F, 1, 0, 2, 0.0F, false));
        this.bonethirtyfour = new MModelRenderer(this);
        this.setRotation(this.bonethirtyfour, 0.0F, -0.6109F, 0.0F);
        this.bonethirtyone.addChild(this.bonethirtyfour);
        this.bonethirtyfour.cubeList.add(new ModelBox(this.bonethirtyfour, 5, 6, 0.0F, 0.0F, -0.25F, 1, 0, 2, 0.002F, false));
        this.bonethirtyfive = new MModelRenderer(this);
        this.bonethirtyfive.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.setRotation(this.bonethirtyfive, 0.0F, -1.5708F, 0.4363F);
        this.bonetwentysix.addChild(this.bonethirtyfive);
        this.bonethirtysix = new MModelRenderer(this);
        this.bonethirtyfive.addChild(this.bonethirtysix);
        this.bonethirtysix.cubeList.add(new ModelBox(this.bonethirtysix, 0, 6, -0.5F, 0.0F, 0.0F, 1, 0, 2, 1.0E-4F, false));
        this.bonethirtyseven = new MModelRenderer(this);
        this.setRotation(this.bonethirtyseven, 0.0F, 0.6109F, 0.0F);
        this.bonethirtyfive.addChild(this.bonethirtyseven);
        this.bonethirtyseven.cubeList.add(new ModelBox(this.bonethirtyseven, 5, 4, -1.0F, 0.0F, -0.25F, 1, 0, 2, 0.002F, false));
        this.bonethirtyeight = new MModelRenderer(this);
        this.setRotation(this.bonethirtyeight, 0.0F, -0.6109F, 0.0F);
        this.bonethirtyfive.addChild(this.bonethirtyeight);
        this.bonethirtyeight.cubeList.add(new ModelBox(this.bonethirtyeight, 3, 5, 0.0F, 0.0F, -0.25F, 1, 0, 2, 0.0F, false));
        this.bonethirtynine = new MModelRenderer(this);
        this.bonethirtynine.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.setRotation(this.bonethirtynine, 0.0F, 1.5708F, -0.4363F);
        this.bonetwentysix.addChild(this.bonethirtynine);
        this.bonefourty = new MModelRenderer(this);
        this.bonethirtynine.addChild(this.bonefourty);
        this.bonefourty.cubeList.add(new ModelBox(this.bonefourty, 5, 2, -0.5F, 0.0F, 0.0F, 1, 0, 2, 1.0E-4F, false));
        this.bonefourtyone = new MModelRenderer(this);
        this.setRotation(this.bonefourtyone, 0.0F, 0.6109F, 0.0F);
        this.bonethirtynine.addChild(this.bonefourtyone);
        this.bonefourtyone.cubeList.add(new ModelBox(this.bonefourtyone, 5, 0, -1.0F, 0.0F, -0.25F, 1, 0, 2, 0.002F, false));
        this.bonefourtytwo = new MModelRenderer(this);
        this.setRotation(this.bonefourtytwo, 0.0F, -0.6109F, 0.0F);
        this.bonethirtynine.addChild(this.bonefourtytwo);
        this.bonefourtytwo.cubeList.add(new ModelBox(this.bonefourtytwo, 3, 3, 0.0F, 0.0F, -0.25F, 1, 0, 2, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/hairpinflowers_" + color + ".png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/hairpinflowers_animation.json"));
        this.animation = bbanimationloader.mustGet("hairpinflowers.animation", this);
    }

    public void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0F, 0.08F, 0.25F);
        super.renderAsItem(time);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.06F + (float)number * 0.5F) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case 3027034:
                if (s.equals("blue"))
                {
                    b0 = 1;
                }

                break;

            case 3441014:
                if (s.equals("pink"))
                {
                    b0 = 0;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0420\u043e\u0437\u043e\u0432\u044b\u0435 \u0446\u0432\u0435\u0442\u043e\u0447\u043a\u0438";

            case 1:
                return "\u0421\u0438\u043d\u0438\u0435 \u0446\u0432\u0435\u0442\u043e\u0447\u043a\u0438";

            default:
                return "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0435 \u0446\u0432\u0435\u0442\u043e\u0447\u043a\u0438";
        }
    }

    public String getCreator()
    {
        return "Florina";
    }
}
