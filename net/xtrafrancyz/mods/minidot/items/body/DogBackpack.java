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

public class DogBackpack extends BaseItem
{
    private final MModelRenderer object;
    private final MModelRenderer backpack;
    private final MModelRenderer boneseven;
    private final MModelRenderer straps;
    private final MModelRenderer bonethree;
    private final MModelRenderer bonefour;
    private final MModelRenderer bonesix;
    private final MModelRenderer bonesixteen;
    private final MModelRenderer boneseventeen;
    private final MModelRenderer strapsAndtongue;
    private final MModelRenderer tongue;
    private final MModelRenderer boneeleven;
    private final MModelRenderer bonenine;
    private final MModelRenderer bonetwelve;
    private final MModelRenderer boneone;
    private final MModelRenderer bone;
    private final MModelRenderer bonefive;
    private final MModelRenderer boneeight;
    private final MModelRenderer bonefifteen;
    private final MModelRenderer nose;
    private final MModelRenderer eyes;
    private final MModelRenderer bonetwob;
    private final MModelRenderer bonetwoa;
    private final MModelRenderer ears;
    private final MModelRenderer bonethirtteen;
    private final MModelRenderer bonefourteen;
    private final IAnimation animation;
    private final String color;

    public DogBackpack(String color)
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.color = color;
        this.object = new MModelRenderer(this);
        this.object.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.backpack = new MModelRenderer(this);
        this.backpack.setRotationPoint(-3.0F, -23.0F, 4.25F);
        this.object.addChild(this.backpack);
        this.backpack.cubeList.add(new ModelBox(this.backpack, 16, 17, -0.5001F, 0.149F, -0.0357F, 7, 3, 1, -0.001F, false));
        this.backpack.cubeList.add(new ModelBox(this.backpack, 16, 10, 0.0F, 6.0F, -2.25F, 6, 1, 2, 0.0F, false));
        this.backpack.cubeList.add(new ModelBox(this.backpack, 0, 9, -0.4991F, -0.9127F, -2.3455F, 7, 1, 2, -0.001F, false));
        this.backpack.cubeList.add(new ModelBox(this.backpack, 0, 0, -0.5F, 0.0F, -2.5F, 7, 6, 3, 0.0F, false));
        this.backpack.cubeList.add(new ModelBox(this.backpack, 0, 17, -0.5001F, 0.399F, -0.0357F, 7, 3, 1, -0.01F, false));
        this.backpack.cubeList.add(new ModelBox(this.backpack, 0, 12, -0.4991F, -0.9127F, -2.0955F, 7, 1, 2, 1.0E-4F, false));
        this.boneseven = new MModelRenderer(this);
        this.setRotation(this.boneseven, 0.7854F, 0.0F, 0.0F);
        this.backpack.addChild(this.boneseven);
        this.boneseven.cubeList.add(new ModelBox(this.boneseven, 17, 14, -0.4991F, -0.7128F, -0.4221F, 7, 1, 1, 0.001F, false));
        this.boneseven.cubeList.add(new ModelBox(this.boneseven, 17, 0, -0.4991F, -0.2128F, -0.4221F, 7, 1, 1, 1.0E-4F, false));
        this.straps = new MModelRenderer(this);
        this.straps.setRotationPoint(-3.0F, -21.25F, -2.25F);
        this.object.addChild(this.straps);
        this.straps.cubeList.add(new ModelBox(this.straps, 0, 21, 0.75F, -4.25F, -0.25F, 1, 2, 1, -0.202F, false));
        this.straps.cubeList.add(new ModelBox(this.straps, 0, 21, 0.75F, -4.25F, -0.25F, 1, 1, 5, -0.199F, true));
        this.straps.cubeList.add(new ModelBox(this.straps, 0, 21, 0.75F, -4.25F, 3.75F, 1, 2, 1, -0.201F, false));
        this.straps.cubeList.add(new ModelBox(this.straps, 0, 21, 4.25F, -4.25F, -0.25F, 1, 1, 5, -0.199F, false));
        this.straps.cubeList.add(new ModelBox(this.straps, 0, 21, 4.25F, -4.25F, -0.25F, 1, 2, 1, -0.202F, true));
        this.straps.cubeList.add(new ModelBox(this.straps, 0, 21, 4.25F, -4.25F, 3.75F, 1, 2, 1, -0.201F, true));
        this.bonethree = new MModelRenderer(this);
        this.setRotation(this.bonethree, 0.0F, 0.0F, 0.3491F);
        this.straps.addChild(this.bonethree);
        this.bonethree.cubeList.add(new ModelBox(this.bonethree, 15, 21, -0.1827F, -3.033F, -0.249F, 1, 7, 1, -0.2F, true));
        this.bonefour = new MModelRenderer(this);
        this.bonefour.setRotationPoint(6.0F, 0.0F, 0.0F);
        this.setRotation(this.bonefour, 0.0F, 0.0F, -0.3491F);
        this.straps.addChild(this.bonefour);
        this.bonefour.cubeList.add(new ModelBox(this.bonefour, 15, 21, -0.8173F, -3.033F, -0.249F, 1, 7, 1, -0.2F, false));
        this.bonesix = new MModelRenderer(this);
        this.bonesix.setRotationPoint(2.75F, 3.5F, 2.5F);
        this.setRotation(this.bonesix, -0.1745F, 0.0F, 0.0F);
        this.straps.addChild(this.bonesix);
        this.bonesixteen = new MModelRenderer(this);
        this.bonesixteen.setRotationPoint(-3.75F, 0.9648F, -0.4297F);
        this.bonesix.addChild(this.bonesixteen);
        this.bonesixteen.cubeList.add(new ModelBox(this.bonesixteen, 16, 4, -0.5083F, -1.075F, -2.237F, 1, 1, 5, -0.2F, false));
        this.boneseventeen = new MModelRenderer(this);
        this.boneseventeen.setRotationPoint(4.25F, 0.9648F, -0.4297F);
        this.bonesix.addChild(this.boneseventeen);
        this.boneseventeen.cubeList.add(new ModelBox(this.boneseventeen, 16, 4, -0.4917F, -1.075F, -2.237F, 1, 1, 5, -0.2F, true));
        this.boneseventeen.cubeList.add(new ModelBox(this.boneseventeen, 16, 4, -0.4917F, -1.075F, -2.237F, 1, 1, 5, -0.2F, true));
        this.boneseventeen.cubeList.add(new ModelBox(this.boneseventeen, 0, 15, -7.9917F, -1.075F, 1.763F, 8, 1, 1, -0.201F, false));
        this.strapsAndtongue = new MModelRenderer(this);
        this.strapsAndtongue.setRotationPoint(0.0F, 0.25F, 0.0F);
        this.object.addChild(this.strapsAndtongue);
        this.strapsAndtongue.cubeList.add(new ModelBox(this.strapsAndtongue, 26, 2, 1.5F, -20.25F, 4.0F, 1, 1, 1, 0.0F, false));
        this.strapsAndtongue.cubeList.add(new ModelBox(this.strapsAndtongue, 26, 2, -2.5F, -20.25F, 4.0F, 1, 1, 1, 0.0F, false));
        this.strapsAndtongue.cubeList.add(new ModelBox(this.strapsAndtongue, 23, 24, 1.5F, -19.25F, 4.0F, 1, 2, 1, -0.1F, false));
        this.strapsAndtongue.cubeList.add(new ModelBox(this.strapsAndtongue, 23, 24, -2.5F, -19.25F, 4.0F, 1, 2, 1, -0.1F, false));
        this.tongue = new MModelRenderer(this);
        this.tongue.setRotationPoint(0.0F, -19.0F, 5.0F);
        this.strapsAndtongue.addChild(this.tongue);
        this.tongue.cubeList.add(new ModelBox(this.tongue, 26, 26, -0.5F, -1.25F, -1.0F, 1, 2, 1, 0.0F, false));
        this.boneeleven = new MModelRenderer(this);
        this.boneeleven.setRotationPoint(-2.25F, -19.5F, 5.25F);
        this.setRotation(this.boneeleven, 0.0F, 0.0F, 0.48F);
        this.strapsAndtongue.addChild(this.boneeleven);
        this.boneeleven.cubeList.add(new ModelBox(this.boneeleven, 25, 21, -0.2217F, -0.2663F, -1.001F, 1, 1, 1, -0.199F, false));
        this.bonenine = new MModelRenderer(this);
        this.bonenine.setRotationPoint(-1.75F, -19.5F, 5.0F);
        this.setRotation(this.bonenine, 0.0F, 0.0F, -0.48F);
        this.strapsAndtongue.addChild(this.bonenine);
        this.bonenine.cubeList.add(new ModelBox(this.bonenine, 25, 21, -0.75F, -0.25F, -0.75F, 1, 1, 1, -0.201F, true));
        this.bonetwelve = new MModelRenderer(this);
        this.bonetwelve.setRotationPoint(2.25F, -19.5F, 5.0F);
        this.setRotation(this.bonetwelve, 0.0F, 0.0F, -0.48F);
        this.strapsAndtongue.addChild(this.bonetwelve);
        this.bonetwelve.cubeList.add(new ModelBox(this.bonetwelve, 25, 21, -0.7796F, -0.2639F, -0.749F, 1, 1, 1, -0.201F, true));
        this.boneone = new MModelRenderer(this);
        this.boneone.setRotationPoint(1.75F, -19.5F, 5.0F);
        this.setRotation(this.boneone, 0.0F, 0.0F, 0.48F);
        this.strapsAndtongue.addChild(this.boneone);
        this.boneone.cubeList.add(new ModelBox(this.boneone, 25, 21, -0.25F, -0.25F, -0.75F, 1, 1, 1, -0.199F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -2.25F, -0.75F);
        this.strapsAndtongue.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 23, 4, 1.0F, -16.0F, 5.15F, 2, 1, 1, -0.401F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 23, 6, 2.0F, -17.0F, 5.15F, 1, 2, 1, -0.4F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 20, 2, 1.0F, -17.0F, 5.15F, 2, 1, 1, -0.401F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 23, 6, 1.0F, -17.0F, 5.15F, 1, 2, 1, -0.4F, false));
        this.bonefive = new MModelRenderer(this);
        this.bonefive.setRotationPoint(-4.0F, -2.25F, -0.75F);
        this.strapsAndtongue.addChild(this.bonefive);
        this.bonefive.cubeList.add(new ModelBox(this.bonefive, 23, 4, 1.0F, -16.0F, 5.15F, 2, 1, 1, -0.401F, false));
        this.bonefive.cubeList.add(new ModelBox(this.bonefive, 19, 24, 2.0F, -17.0F, 5.15F, 1, 2, 1, -0.4F, false));
        this.bonefive.cubeList.add(new ModelBox(this.bonefive, 20, 2, 1.0F, -17.0F, 5.15F, 2, 1, 1, -0.401F, false));
        this.bonefive.cubeList.add(new ModelBox(this.bonefive, 23, 6, 1.0F, -17.0F, 5.15F, 1, 2, 1, -0.4F, false));
        this.boneeight = new MModelRenderer(this);
        this.boneeight.setRotationPoint(-2.0F, -18.5F, 5.25F);
        this.setRotation(this.boneeight, 0.6109F, 0.0F, 0.0F);
        this.strapsAndtongue.addChild(this.boneeight);
        this.boneeight.cubeList.add(new ModelBox(this.boneeight, 23, 6, -0.5F, -1.25F, -0.85F, 1, 2, 1, -0.4F, false));
        this.bonefifteen = new MModelRenderer(this);
        this.bonefifteen.setRotationPoint(2.0F, -18.5F, 5.25F);
        this.setRotation(this.bonefifteen, 0.6109F, 0.0F, 0.0F);
        this.strapsAndtongue.addChild(this.bonefifteen);
        this.bonefifteen.cubeList.add(new ModelBox(this.bonefifteen, 23, 6, -0.5F, -1.25F, -0.85F, 1, 2, 1, -0.4F, false));
        this.nose = new MModelRenderer(this);
        this.nose.setRotationPoint(0.0F, -21.0F, 5.0F);
        this.object.addChild(this.nose);
        this.nose.cubeList.add(new ModelBox(this.nose, 0, 24, -0.5F, -0.25F, -0.25F, 1, 1, 1, -0.2F, false));
        this.eyes = new MModelRenderer(this);
        this.eyes.setRotationPoint(0.0F, -20.5F, 5.25F);
        this.object.addChild(this.eyes);
        this.bonetwob = new MModelRenderer(this);
        this.bonetwob.setRotationPoint(0.0F, 20.5F, -5.25F);
        this.eyes.addChild(this.bonetwob);
        this.bonetwob.cubeList.add(new ModelBox(this.bonetwob, 11, 26, 1.25F, -22.25F, 4.5F, 1, 2, 1, -0.2F, false));
        this.bonetwoa = new MModelRenderer(this);
        this.bonetwoa.setRotationPoint(-1.75F, 0.0F, 0.0F);
        this.eyes.addChild(this.bonetwoa);
        this.bonetwoa.cubeList.add(new ModelBox(this.bonetwoa, 11, 26, -0.5F, -1.75F, -0.75F, 1, 2, 1, -0.2F, false));
        this.ears = new MModelRenderer(this);
        this.ears.setRotationPoint(-2.75F, -23.25F, 5.0F);
        this.object.addChild(this.ears);
        this.bonethirtteen = new MModelRenderer(this);
        this.setRotation(this.bonethirtteen, -0.76F, -0.5553F, 0.3663F);
        this.ears.addChild(this.bonethirtteen);
        this.bonethirtteen.cubeList.add(new ModelBox(this.bonethirtteen, 19, 21, -1.25F, -0.5F, -1.25F, 2, 1, 2, -0.2F, false));
        this.bonethirtteen.cubeList.add(new ModelBox(this.bonethirtteen, 7, 21, -1.25F, -0.5F, -2.0F, 2, 2, 2, -0.3F, false));
        this.bonefourteen = new MModelRenderer(this);
        this.bonefourteen.setRotationPoint(5.5F, 0.0F, 0.0F);
        this.setRotation(this.bonefourteen, -0.76F, 0.5553F, -0.3663F);
        this.ears.addChild(this.bonefourteen);
        this.bonefourteen.cubeList.add(new ModelBox(this.bonefourteen, 19, 21, -0.75F, -0.5F, -1.25F, 2, 1, 2, -0.2F, true));
        this.bonefourteen.cubeList.add(new ModelBox(this.bonefourteen, 7, 21, -0.75F, -0.5F, -2.0F, 2, 2, 2, -0.3F, false));
        super.setTexture(new ResourceLocation("minidot", "body/dogbackpack_" + color + ".png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/dogbackpack_animation.json"));
        this.animation = bbanimationloader.mustGet("dogbackpack.animation", this);
    }

    public void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, 0.519D, 0.0D);
        this.animation.tick(time);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.75D, 0.4D);
        double d0 = 1.4788D;
        GlStateManager.scale(d0, d0, d0);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case 3254239:
                if (s.equals("jack"))
                {
                    b0 = 2;
                }

                break;

            case 94011702:
                if (s.equals("brown"))
                {
                    b0 = 0;
                }

                break;

            case 113101865:
                if (s.equals("white"))
                {
                    b0 = 1;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u041a\u043e\u0440\u0438\u0447\u043d\u0435\u0432\u0430\u044f \u0441\u043e\u0431\u0430\u0447\u043a\u0430-\u0440\u044e\u043a\u0437\u0430\u043a";

            case 1:
                return "\u0411\u0435\u043b\u0430\u044f \u0441\u043e\u0431\u0430\u0447\u043a\u0430-\u0440\u044e\u043a\u0437\u0430\u043a";

            case 2:
                return "\u0411\u0435\u0436\u0435\u0432\u0430\u044f \u0441\u043e\u0431\u0430\u0447\u043a\u0430-\u0440\u044e\u043a\u0437\u0430\u043a";

            default:
                return "\u0421\u0442\u0440\u0430\u043d\u043d\u0430\u044f \u0441\u043e\u0431\u0430\u0447\u043a\u0430-\u0440\u044e\u043a\u0437\u0430\u043a";
        }
    }

    public String getCreator()
    {
        return "Florina";
    }
}
