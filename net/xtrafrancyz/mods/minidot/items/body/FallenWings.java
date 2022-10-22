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

public class FallenWings extends BaseItem
{
    private final MModelRenderer TheFallenWings;
    private final MModelRenderer TheFirstWing;
    private final MModelRenderer PartOne1;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer FlatCube1;
    private final MModelRenderer PartTwo2;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer FlatCube2;
    private final MModelRenderer Spikes1;
    private final MModelRenderer bone40;
    private final MModelRenderer bone41;
    private final MModelRenderer bone42;
    private final MModelRenderer TheSecondWing;
    private final MModelRenderer SecondWing;
    private final MModelRenderer PartOne;
    private final MModelRenderer bone21;
    private final MModelRenderer bone22;
    private final MModelRenderer FlatCube3;
    private final MModelRenderer PartTwo;
    private final MModelRenderer bone29;
    private final MModelRenderer bone30;
    private final MModelRenderer bone31;
    private final MModelRenderer FlatCube4;
    private final MModelRenderer Spikes4;
    private final MModelRenderer bone34;
    private final MModelRenderer bone37;
    private final MModelRenderer bone38;
    private final IAnimation animation;

    public FallenWings()
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.TheFallenWings = new MModelRenderer(this);
        this.TheFallenWings.setRotationPoint(-0.25F, -2.75F, 3.0F);
        this.setRotation(this.TheFallenWings, 0.2309F, 0.0F, 0.0F);
        this.TheFirstWing = new MModelRenderer(this);
        this.TheFirstWing.setRotationPoint(-1.0F, 0.5F, -2.0F);
        this.setRotation(this.TheFirstWing, 0.0F, 0.48F, 0.0F);
        this.TheFallenWings.addChild(this.TheFirstWing);
        this.PartOne1 = new MModelRenderer(this);
        this.PartOne1.setRotationPoint(0.25F, 4.25F, 0.0F);
        this.TheFirstWing.addChild(this.PartOne1);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-2.0F, -9.0F, 2.0F);
        this.setRotation(this.bone, 1.3652F, -0.9335F, -0.2192F);
        this.PartOne1.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 20, 0, 0.0F, -1.0F, -5.0F, 1, 1, 11, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-4.0F, -14.0F, 2.0F);
        this.setRotation(this.bone2, 1.3652F, -0.9335F, -0.2192F);
        this.PartOne1.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 16, 0, 0.5145F, 0.4051F, -1.3452F, 1, 7, 1, 0.0F, false));
        this.FlatCube1 = new MModelRenderer(this);
        this.FlatCube1.setRotationPoint(-4.0F, -14.0F, 2.75F);
        this.setRotation(this.FlatCube1, 1.3652F, -0.9335F, -0.2192F);
        this.PartOne1.addChild(this.FlatCube1);
        this.FlatCube1.cubeList.add(new ModelBox(this.FlatCube1, 0, 7, 0.5145F, -0.5949F, -9.3452F, 0, 7, 10, 0.0F, false));
        this.PartTwo2 = new MModelRenderer(this);
        this.PartTwo2.setRotationPoint(-6.25F, -5.5F, 6.25F);
        this.TheFirstWing.addChild(this.PartTwo2);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(13.0F, 3.25F, 2.0F);
        this.setRotation(this.bone5, 0.7927F, -0.6813F, -2.3783F);
        this.PartTwo2.addChild(this.bone5);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-2.0F, -9.0F, 2.0F);
        this.setRotation(this.bone6, 1.3652F, -0.9335F, -0.2192F);
        this.bone5.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 9, 13, 2.4125F, -13.3803F, -4.2315F, 1, 1, 11, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-4.0F, -14.0F, 2.0F);
        this.setRotation(this.bone7, 1.3652F, -0.9335F, -0.2192F);
        this.bone5.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 0, 2.927F, -11.9752F, -0.5768F, 1, 7, 1, 0.0F, false));
        this.FlatCube2 = new MModelRenderer(this);
        this.FlatCube2.setRotationPoint(-4.0F, -14.0F, 2.75F);
        this.setRotation(this.FlatCube2, 1.3652F, -0.9335F, -0.2192F);
        this.bone5.addChild(this.FlatCube2);
        this.FlatCube2.cubeList.add(new ModelBox(this.FlatCube2, 0, 0, 2.927F, -12.9752F, -8.5768F, 0, 7, 10, 0.0F, false));
        this.Spikes1 = new MModelRenderer(this);
        this.Spikes1.setRotationPoint(-7.0F, 1.5F, -6.0F);
        this.setRotation(this.Spikes1, -0.1818F, -0.838F, -0.9919F);
        this.PartTwo2.addChild(this.Spikes1);
        this.bone40 = new MModelRenderer(this);
        this.bone40.setRotationPoint(19.3933F, -10.9644F, 4.5431F);
        this.setRotation(this.bone40, 1.3652F, -0.9335F, -0.2192F);
        this.Spikes1.addChild(this.bone40);
        this.bone40.cubeList.add(new ModelBox(this.bone40, 5, 5, -16.7963F, 14.4064F, -4.1727F, 1, 1, 3, 0.0F, false));
        this.bone41 = new MModelRenderer(this);
        this.bone41.setRotationPoint(19.3933F, -11.9644F, 4.5431F);
        this.setRotation(this.bone41, 1.3652F, -0.9335F, -0.2192F);
        this.Spikes1.addChild(this.bone41);
        this.bone41.cubeList.add(new ModelBox(this.bone41, 10, 4, -16.9257F, 14.7769F, -3.0925F, 1, 1, 2, -0.1F, false));
        this.bone42 = new MModelRenderer(this);
        this.bone42.setRotationPoint(16.6433F, -16.7144F, 5.0431F);
        this.setRotation(this.bone42, 1.7252F, -0.9404F, -0.6635F);
        this.Spikes1.addChild(this.bone42);
        this.bone42.cubeList.add(new ModelBox(this.bone42, 0, 0, -17.9257F, 14.7769F, -3.0925F, 2, 0, 4, 0.0F, false));
        this.TheSecondWing = new MModelRenderer(this);
        this.TheSecondWing.setRotationPoint(1.0F, 0.25F, -2.0F);
        this.setRotation(this.TheSecondWing, 0.0F, -0.48F, 0.0F);
        this.TheFallenWings.addChild(this.TheSecondWing);
        this.SecondWing = new MModelRenderer(this);
        this.SecondWing.setRotationPoint(-0.5F, 0.25F, 0.0F);
        this.TheSecondWing.addChild(this.SecondWing);
        this.PartOne = new MModelRenderer(this);
        this.PartOne.setRotationPoint(0.75F, 4.25F, 0.0F);
        this.SecondWing.addChild(this.PartOne);
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(2.0F, -9.0F, 2.0F);
        this.setRotation(this.bone21, 1.3652F, 0.9335F, 0.2192F);
        this.PartOne.addChild(this.bone21);
        this.bone21.cubeList.add(new ModelBox(this.bone21, 20, 0, -1.0F, -1.0F, -5.0F, 1, 1, 11, 0.0F, true));
        this.bone22 = new MModelRenderer(this);
        this.bone22.setRotationPoint(4.0F, -14.0F, 2.0F);
        this.setRotation(this.bone22, 1.3652F, 0.9335F, 0.2192F);
        this.PartOne.addChild(this.bone22);
        this.bone22.cubeList.add(new ModelBox(this.bone22, 16, 0, -1.5145F, 0.4051F, -1.3452F, 1, 7, 1, 0.0F, true));
        this.FlatCube3 = new MModelRenderer(this);
        this.FlatCube3.setRotationPoint(4.0F, -14.0F, 2.75F);
        this.setRotation(this.FlatCube3, 1.3652F, 0.9335F, 0.2192F);
        this.PartOne.addChild(this.FlatCube3);
        this.FlatCube3.cubeList.add(new ModelBox(this.FlatCube3, 0, 7, -0.5145F, -0.5949F, -9.3452F, 0, 7, 10, 0.0F, true));
        this.PartTwo = new MModelRenderer(this);
        this.PartTwo.setRotationPoint(7.25F, -5.5F, 6.25F);
        this.SecondWing.addChild(this.PartTwo);
        this.bone29 = new MModelRenderer(this);
        this.bone29.setRotationPoint(1.25F, -0.5F, 0.5F);
        this.setRotation(this.bone29, 0.7927F, 0.6813F, 2.3783F);
        this.PartTwo.addChild(this.bone29);
        this.bone30 = new MModelRenderer(this);
        this.bone30.setRotationPoint(11.0669F, 2.6243F, 3.429F);
        this.setRotation(this.bone30, 1.3652F, 0.9335F, 0.2192F);
        this.bone29.addChild(this.bone30);
        this.bone30.cubeList.add(new ModelBox(this.bone30, 9, 13, -3.4125F, -13.3803F, -4.2315F, 1, 1, 11, 0.0F, true));
        this.bone31 = new MModelRenderer(this);
        this.bone31.setRotationPoint(13.0669F, -2.3757F, 3.429F);
        this.setRotation(this.bone31, 1.3652F, 0.9335F, 0.2192F);
        this.bone29.addChild(this.bone31);
        this.bone31.cubeList.add(new ModelBox(this.bone31, 0, 0, -3.927F, -11.9752F, -0.5768F, 1, 7, 1, 0.0F, true));
        this.FlatCube4 = new MModelRenderer(this);
        this.FlatCube4.setRotationPoint(13.0669F, -2.3757F, 4.179F);
        this.setRotation(this.FlatCube4, 1.3652F, 0.9335F, 0.2192F);
        this.bone29.addChild(this.FlatCube4);
        this.FlatCube4.cubeList.add(new ModelBox(this.FlatCube4, 0, 0, -2.927F, -12.9752F, -8.5768F, 0, 7, 10, 0.0F, true));
        this.Spikes4 = new MModelRenderer(this);
        this.Spikes4.setRotationPoint(7.0F, 1.5F, -6.0F);
        this.setRotation(this.Spikes4, -0.1818F, 0.838F, 0.9919F);
        this.PartTwo.addChild(this.Spikes4);
        this.bone34 = new MModelRenderer(this);
        this.bone34.setRotationPoint(-19.3933F, -10.9644F, 4.5431F);
        this.setRotation(this.bone34, 1.3652F, 0.9335F, 0.2192F);
        this.Spikes4.addChild(this.bone34);
        this.bone34.cubeList.add(new ModelBox(this.bone34, 5, 5, 15.7963F, 14.4064F, -4.1727F, 1, 1, 3, 0.0F, true));
        this.bone37 = new MModelRenderer(this);
        this.bone37.setRotationPoint(-19.3933F, -11.9644F, 4.5431F);
        this.setRotation(this.bone37, 1.3652F, 0.9335F, 0.2192F);
        this.Spikes4.addChild(this.bone37);
        this.bone37.cubeList.add(new ModelBox(this.bone37, 10, 4, 15.9257F, 14.7769F, -3.0925F, 1, 1, 2, -0.1F, true));
        this.bone38 = new MModelRenderer(this);
        this.bone38.setRotationPoint(-16.6433F, -16.7144F, 5.0431F);
        this.setRotation(this.bone38, 1.7252F, 0.9404F, 0.6635F);
        this.Spikes4.addChild(this.bone38);
        this.bone38.cubeList.add(new ModelBox(this.bone38, 0, 0, 15.9257F, 14.7769F, -3.0925F, 2, 0, 4, 0.0F, true));
        super.setTexture(new ResourceLocation("minidot", "body/fallenwings.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/fallenwings_animation.json"));
        this.animation = bbanimationloader.mustGet("wings.default", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, 0.65D, 0.0D);
        float f = 0.9F;
        GlStateManager.scale(f, f, f);

        if (player.getCurrentArmor(2) != null)
        {
            GlStateManager.translate(0.0D, 0.0D, 0.05D);
        }

        this.animation.tick(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.45D, 0.2D);
        double d0 = 0.7D;
        GlStateManager.scale(d0, d0, d0);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0440\u044b\u043b\u044c\u044f \u043f\u0430\u0434\u0448\u0435\u0433\u043e";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
