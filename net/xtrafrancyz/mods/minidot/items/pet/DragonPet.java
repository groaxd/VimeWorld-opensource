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

public class DragonPet extends BasePet
{
    private final MModelRenderer ALLDRAGON;
    private final MModelRenderer BODY;
    private final MModelRenderer torso;
    private final MModelRenderer trapezoid;
    private final MModelRenderer throat;
    private final MModelRenderer backofthebody;
    private final MModelRenderer TAIL;
    private final MModelRenderer tailstart;
    private final MModelRenderer bone3;
    private final MModelRenderer tailmedium;
    private final MModelRenderer bone4;
    private final MModelRenderer tailend;
    private final MModelRenderer testamenttail;
    private final MModelRenderer bone81;
    private final MModelRenderer bone82;
    private final MModelRenderer LEGS;
    private final MModelRenderer knee;
    private final MModelRenderer hip;
    private final MModelRenderer HEEL;
    private final MModelRenderer HEEL2;
    private final MModelRenderer HEEL3;
    private final MModelRenderer LEGS2;
    private final MModelRenderer knee2;
    private final MModelRenderer hip2;
    private final MModelRenderer bone2;
    private final MModelRenderer HEEL5;
    private final MModelRenderer HEEL4;
    private final MModelRenderer WINGS;
    private final MModelRenderer bone32;
    private final MModelRenderer bone28;
    private final MModelRenderer bone27;
    private final MModelRenderer seredina;
    private final MModelRenderer bone29;
    private final MModelRenderer bone33;
    private final MModelRenderer kone3;
    private final MModelRenderer bone35;
    private final MModelRenderer bone30;
    private final MModelRenderer WINGS2;
    private final MModelRenderer bone36;
    private final MModelRenderer bone39;
    private final MModelRenderer bone40;
    private final MModelRenderer kone2;
    private final MModelRenderer bone31;
    private final MModelRenderer bone37;
    private final MModelRenderer seredina2;
    private final MModelRenderer bone34;
    private final MModelRenderer bone38;
    private final MModelRenderer LEGSFRONT;
    private final MModelRenderer bone44;
    private final MModelRenderer bone43;
    private final MModelRenderer bone42;
    private final MModelRenderer bone41;
    private final MModelRenderer LEGSFRONT2;
    private final MModelRenderer bone45;
    private final MModelRenderer bone46;
    private final MModelRenderer bone47;
    private final MModelRenderer bone48;
    private final MModelRenderer bone49;
    private final MModelRenderer SPIKES;
    private final MModelRenderer bone80;
    private final MModelRenderer bone78;
    private final MModelRenderer bone77;
    private final MModelRenderer bone79;
    private final MModelRenderer HAT;
    private final MModelRenderer bone54;
    private final MModelRenderer bone55;
    private final MModelRenderer bone56;
    private final MModelRenderer bone53;
    private final MModelRenderer bone52;
    private final MModelRenderer bone51;
    private final MModelRenderer bone61;
    private final MModelRenderer zalupa2;
    private final MModelRenderer bone64;
    private final MModelRenderer bone57;
    private final MModelRenderer zalupa1;
    private final MModelRenderer bone62;
    private final MModelRenderer bone58;
    private final MModelRenderer zalupa;
    private final MModelRenderer bone63;
    private final MModelRenderer bone59;
    private final MModelRenderer zalupa3;
    private final MModelRenderer bone65;
    private final MModelRenderer bone60;
    private final MModelRenderer bone66;
    private final MModelRenderer zalupa4;
    private final MModelRenderer bone74;
    private final MModelRenderer bone73;
    private final MModelRenderer zalupa5;
    private final MModelRenderer bone72;
    private final MModelRenderer bone71;
    private final MModelRenderer zalupa6;
    private final MModelRenderer bone70;
    private final MModelRenderer bone69;
    private final MModelRenderer zalupa7;
    private final MModelRenderer bone68;
    private final MModelRenderer bone67;
    private final MModelRenderer bone50;
    private final MModelRenderer bone83;
    private final MModelRenderer bone;
    private final IAnimation animation;
    private final String color;

    public DragonPet(String color)
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.color = color;
        this.ALLDRAGON = new MModelRenderer(this);
        this.ALLDRAGON.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.BODY = new MModelRenderer(this);
        this.ALLDRAGON.addChild(this.BODY);
        this.torso = new MModelRenderer(this);
        this.torso.setRotationPoint(-3.5F, -6.5F, -2.5F);
        this.setRotation(this.torso, 0.1309F, 0.0F, 0.0F);
        this.BODY.addChild(this.torso);
        this.torso.cubeList.add(new ModelBox(this.torso, 28, 26, -3.5F, -2.5F, -4.5F, 7, 6, 8, 0.1F, false));
        this.trapezoid = new MModelRenderer(this);
        this.trapezoid.setRotationPoint(-3.5F, -9.4176F, -3.2568F);
        this.setRotation(this.trapezoid, -0.0873F, 0.0F, 0.0F);
        this.BODY.addChild(this.trapezoid);
        this.trapezoid.cubeList.add(new ModelBox(this.trapezoid, 40, 40, -3.5F, 0.1156F, -3.1105F, 7, 1, 6, -0.1F, false));
        this.throat = new MModelRenderer(this);
        this.throat.setRotationPoint(-3.5F, -6.5F, -4.5F);
        this.setRotation(this.throat, 0.3927F, 0.0F, 0.0F);
        this.BODY.addChild(this.throat);
        this.throat.cubeList.add(new ModelBox(this.throat, 48, 0, -3.5F, -3.5186F, -3.4048F, 7, 6, 3, -0.1F, false));
        this.backofthebody = new MModelRenderer(this);
        this.backofthebody.setRotationPoint(-3.5F, -6.25F, 3.5F);
        this.setRotation(this.backofthebody, -0.2182F, 0.0F, 0.0F);
        this.BODY.addChild(this.backofthebody);
        this.backofthebody.cubeList.add(new ModelBox(this.backofthebody, 0, 38, -2.5F, -2.5199F, -3.3182F, 5, 5, 7, 0.1F, false));
        this.TAIL = new MModelRenderer(this);
        this.TAIL.setRotationPoint(-3.0F, -5.0F, 7.0F);
        this.ALLDRAGON.addChild(this.TAIL);
        this.tailstart = new MModelRenderer(this);
        this.tailstart.setRotationPoint(-0.25F, -0.25F, 2.0F);
        this.setRotation(this.tailstart, -0.2706F, 0.2527F, -0.0692F);
        this.TAIL.addChild(this.tailstart);
        this.tailstart.cubeList.add(new ModelBox(this.tailstart, 0, 8, -1.25F, -1.25F, -3.0F, 3, 3, 4, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.TAIL.addChild(this.bone3);
        this.tailmedium = new MModelRenderer(this);
        this.tailmedium.setRotationPoint(0.6986F, 0.6237F, 2.431F);
        this.setRotation(this.tailmedium, 0.0621F, 0.5865F, 0.0304F);
        this.bone3.addChild(this.tailmedium);
        this.tailmedium.cubeList.add(new ModelBox(this.tailmedium, 57, 52, -0.75F, -2.25F, -3.0F, 3, 3, 5, -0.3F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(2.75F, -0.25F, 3.5F);
        this.bone3.addChild(this.bone4);
        this.tailend = new MModelRenderer(this);
        this.tailend.setRotationPoint(-2.0514F, 0.8737F, -1.069F);
        this.setRotation(this.tailend, 0.2366F, 0.5865F, 0.0304F);
        this.bone4.addChild(this.tailend);
        this.tailend.cubeList.add(new ModelBox(this.tailend, 27, 67, -0.25F, -1.75F, 1.625F, 2, 2, 5, 0.0F, false));
        this.testamenttail = new MModelRenderer(this);
        this.testamenttail.setRotationPoint(-2.0514F, 0.8737F, 0.931F);
        this.setRotation(this.testamenttail, 0.4112F, 0.5865F, 0.0304F);
        this.bone4.addChild(this.testamenttail);
        this.testamenttail.cubeList.add(new ModelBox(this.testamenttail, 0, 42, 1.75F, -6.75F, 4.875F, 0, 8, 8, 0.0F, false));
        this.bone81 = new MModelRenderer(this);
        this.bone81.setRotationPoint(1.5851F, -2.1249F, 2.2377F);
        this.setRotation(this.bone81, -0.4179F, 0.5865F, 0.0304F);
        this.bone3.addChild(this.bone81);
        this.bone81.cubeList.add(new ModelBox(this.bone81, 8, 18, 0.0F, -1.0F, -1.5F, 0, 3, 3, 0.0F, false));
        this.bone82 = new MModelRenderer(this);
        this.bone82.setRotationPoint(3.804F, -2.2598F, 4.6884F);
        this.setRotation(this.bone82, -0.2433F, 0.5865F, 0.0304F);
        this.bone3.addChild(this.bone82);
        this.bone82.cubeList.add(new ModelBox(this.bone82, 0, 3, -0.5F, -1.5F, -1.25F, 0, 2, 3, 0.0F, false));
        this.LEGS = new MModelRenderer(this);
        this.LEGS.setRotationPoint(-1.0F, -5.25F, 4.25F);
        this.ALLDRAGON.addChild(this.LEGS);
        this.knee = new MModelRenderer(this);
        this.knee.setRotationPoint(1.0251F, 4.0742F, -0.3729F);
        this.setRotation(this.knee, 0.1372F, -0.2305F, -0.2494F);
        this.LEGS.addChild(this.knee);
        this.knee.cubeList.add(new ModelBox(this.knee, 68, 0, -0.7597F, -2.4677F, -0.9233F, 2, 3, 2, 0.0F, false));
        this.hip = new MModelRenderer(this);
        this.hip.setRotationPoint(0.0F, 1.0F, 0.75F);
        this.setRotation(this.hip, -0.211F, -0.056F, -0.2559F);
        this.LEGS.addChild(this.hip);
        this.hip.cubeList.add(new ModelBox(this.hip, 44, 57, -2.0F, -2.0F, -2.75F, 4, 4, 4, -0.4F, false));
        this.HEEL = new MModelRenderer(this);
        this.HEEL.setRotationPoint(1.25F, 4.75F, 1.0F);
        this.LEGS.addChild(this.HEEL);
        this.HEEL2 = new MModelRenderer(this);
        this.HEEL2.setRotationPoint(1.75F, 5.25F, -1.25F);
        this.setRotation(this.HEEL2, 0.2335F, -0.2685F, -0.3061F);
        this.HEEL.addChild(this.HEEL2);
        this.HEEL2.cubeList.add(new ModelBox(this.HEEL2, 58, 33, -1.669F, -6.1423F, -0.7142F, 4, 3, 4, -0.4F, false));
        this.HEEL3 = new MModelRenderer(this);
        this.HEEL3.setRotationPoint(1.75F, 5.25F, -1.25F);
        this.setRotation(this.HEEL3, 0.2335F, -0.2685F, -0.3061F);
        this.HEEL.addChild(this.HEEL3);
        this.HEEL3.cubeList.add(new ModelBox(this.HEEL3, 58, 64, -1.669F, -5.1423F, -1.91F, 4, 2, 2, -0.4F, false));
        this.LEGS2 = new MModelRenderer(this);
        this.LEGS2.setRotationPoint(-5.25F, -5.25F, 4.25F);
        this.ALLDRAGON.addChild(this.LEGS2);
        this.knee2 = new MModelRenderer(this);
        this.knee2.setRotationPoint(-1.7751F, 4.0742F, -0.3729F);
        this.setRotation(this.knee2, 0.1372F, 0.2305F, 0.2494F);
        this.LEGS2.addChild(this.knee2);
        this.knee2.cubeList.add(new ModelBox(this.knee2, 20, 67, -1.2403F, -2.4677F, -0.9233F, 2, 3, 2, 0.0F, false));
        this.hip2 = new MModelRenderer(this);
        this.hip2.setRotationPoint(-0.75F, 1.0F, 0.75F);
        this.setRotation(this.hip2, -0.211F, 0.056F, 0.2559F);
        this.LEGS2.addChild(this.hip2);
        this.hip2.cubeList.add(new ModelBox(this.hip2, 28, 55, -2.0F, -2.0F, -2.75F, 4, 4, 4, -0.4F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-2.0F, 4.75F, 1.0F);
        this.LEGS2.addChild(this.bone2);
        this.HEEL5 = new MModelRenderer(this);
        this.HEEL5.setRotationPoint(-1.75F, 5.25F, -1.25F);
        this.setRotation(this.HEEL5, 0.2335F, 0.2685F, 0.3061F);
        this.bone2.addChild(this.HEEL5);
        this.HEEL5.cubeList.add(new ModelBox(this.HEEL5, 22, 63, -2.331F, -5.1423F, -1.91F, 4, 2, 2, -0.4F, false));
        this.HEEL4 = new MModelRenderer(this);
        this.HEEL4.setRotationPoint(-1.75F, 5.25F, -1.25F);
        this.setRotation(this.HEEL4, 0.2335F, 0.2685F, 0.3061F);
        this.bone2.addChild(this.HEEL4);
        this.HEEL4.cubeList.add(new ModelBox(this.HEEL4, 0, 58, -2.331F, -6.1423F, -0.7142F, 4, 3, 4, -0.4F, false));
        this.WINGS = new MModelRenderer(this);
        this.WINGS.setRotationPoint(-1.25F, -9.25F, -4.5F);
        this.ALLDRAGON.addChild(this.WINGS);
        this.bone32 = new MModelRenderer(this);
        this.bone32.setRotationPoint(2.0F, 0.4672F, 0.1865F);
        this.setRotation(this.bone32, 0.1188F, 0.0552F, -0.4331F);
        this.WINGS.addChild(this.bone32);
        this.bone32.cubeList.add(new ModelBox(this.bone32, 18, 0, -2.0F, -1.0F, -0.75F, 9, 0, 12, 0.0F, false));
        this.bone28 = new MModelRenderer(this);
        this.bone28.setRotationPoint(7.0152F, -2.9454F, -0.2628F);
        this.setRotation(this.bone28, 0.1314F, 0.4449F, -0.3828F);
        this.WINGS.addChild(this.bone28);
        this.bone28.cubeList.add(new ModelBox(this.bone28, 62, 25, -2.75F, -1.0F, -2.25F, 4, 2, 2, -0.1F, false));
        this.bone27 = new MModelRenderer(this);
        this.bone27.setRotationPoint(2.0F, 0.4672F, 0.1865F);
        this.setRotation(this.bone27, 0.1188F, 0.0552F, -0.4331F);
        this.WINGS.addChild(this.bone27);
        this.bone27.cubeList.add(new ModelBox(this.bone27, 60, 60, -2.0F, -2.0F, -1.0F, 6, 2, 2, 0.0F, false));
        this.seredina = new MModelRenderer(this);
        this.seredina.setRotationPoint(7.75F, -3.0F, -1.75F);
        this.WINGS.addChild(this.seredina);
        this.bone29 = new MModelRenderer(this);
        this.bone29.setRotationPoint(2.152F, -1.0377F, -0.5288F);
        this.setRotation(this.bone29, 0.107F, 0.1517F, -0.5103F);
        this.seredina.addChild(this.bone29);
        this.bone29.cubeList.add(new ModelBox(this.bone29, 60, 40, -3.0F, -1.25F, -1.0F, 6, 2, 2, -0.2F, false));
        this.bone33 = new MModelRenderer(this);
        this.bone33.setRotationPoint(2.1726F, -1.1104F, -0.0345F);
        this.setRotation(this.bone33, 0.1063F, 0.1083F, -0.515F);
        this.seredina.addChild(this.bone33);
        this.bone33.cubeList.add(new ModelBox(this.bone33, 12, 12, -2.7421F, -0.2893F, -1.0021F, 6, 0, 14, 0.0F, false));
        this.kone3 = new MModelRenderer(this);
        this.kone3.setRotationPoint(12.75F, -5.5F, -2.5F);
        this.WINGS.addChild(this.kone3);
        this.bone35 = new MModelRenderer(this);
        this.bone35.setRotationPoint(3.9729F, -3.8415F, 6.6922F);
        this.setRotation(this.bone35, 0.0903F, 0.1246F, -0.6036F);
        this.kone3.addChild(this.bone35);
        this.bone35.cubeList.add(new ModelBox(this.bone35, 26, 12, -4.75F, -0.25F, -6.5F, 8, 0, 12, 0.0F, false));
        this.bone30 = new MModelRenderer(this);
        this.bone30.setRotationPoint(2.2958F, -1.0567F, 0.9788F);
        this.setRotation(this.bone30, 0.1831F, -0.3077F, -0.6628F);
        this.kone3.addChild(this.bone30);
        this.bone30.cubeList.add(new ModelBox(this.bone30, 56, 47, -3.75F, -2.0F, -1.0F, 8, 2, 2, -0.3F, false));
        this.WINGS2 = new MModelRenderer(this);
        this.WINGS2.setRotationPoint(-5.75F, -9.25F, -4.5F);
        this.ALLDRAGON.addChild(this.WINGS2);
        this.bone36 = new MModelRenderer(this);
        this.bone36.setRotationPoint(-2.0F, 0.4672F, 0.1865F);
        this.setRotation(this.bone36, 0.1188F, -0.0552F, 0.4331F);
        this.WINGS2.addChild(this.bone36);
        this.bone36.cubeList.add(new ModelBox(this.bone36, 0, 0, -7.0F, -1.0F, -0.75F, 9, 0, 12, 0.0F, false));
        this.bone39 = new MModelRenderer(this);
        this.bone39.setRotationPoint(-7.0152F, -2.9454F, -0.2628F);
        this.setRotation(this.bone39, 0.1314F, -0.4449F, 0.3828F);
        this.WINGS2.addChild(this.bone39);
        this.bone39.cubeList.add(new ModelBox(this.bone39, 28, 51, -1.25F, -1.0F, -2.25F, 4, 2, 2, -0.1F, false));
        this.bone40 = new MModelRenderer(this);
        this.bone40.setRotationPoint(-2.0F, 0.4672F, 0.1865F);
        this.setRotation(this.bone40, 0.1188F, -0.0552F, 0.4331F);
        this.WINGS2.addChild(this.bone40);
        this.bone40.cubeList.add(new ModelBox(this.bone40, 60, 13, -4.0F, -2.0F, -1.0F, 6, 2, 2, 0.0F, false));
        this.kone2 = new MModelRenderer(this);
        this.kone2.setRotationPoint(-12.5F, -5.5F, -2.5F);
        this.WINGS2.addChild(this.kone2);
        this.bone31 = new MModelRenderer(this);
        this.bone31.setRotationPoint(-4.2229F, -3.8415F, 6.6922F);
        this.setRotation(this.bone31, 0.0903F, -0.1246F, 0.6036F);
        this.kone2.addChild(this.bone31);
        this.bone31.cubeList.add(new ModelBox(this.bone31, 0, 26, -3.25F, -0.25F, -6.5F, 8, 0, 12, 0.0F, false));
        this.bone37 = new MModelRenderer(this);
        this.bone37.setRotationPoint(-2.5458F, -1.0567F, 0.9788F);
        this.setRotation(this.bone37, 0.1831F, 0.3077F, 0.6628F);
        this.kone2.addChild(this.bone37);
        this.bone37.cubeList.add(new ModelBox(this.bone37, 54, 9, -4.25F, -2.0F, -1.0F, 8, 2, 2, -0.3F, false));
        this.seredina2 = new MModelRenderer(this);
        this.seredina2.setRotationPoint(-7.5F, -3.0F, -2.25F);
        this.WINGS2.addChild(this.seredina2);
        this.bone34 = new MModelRenderer(this);
        this.bone34.setRotationPoint(-2.4226F, -1.1104F, 0.4655F);
        this.setRotation(this.bone34, 0.1063F, -0.1083F, 0.515F);
        this.seredina2.addChild(this.bone34);
        this.bone34.cubeList.add(new ModelBox(this.bone34, 0, 12, -3.2579F, -0.2893F, -1.0021F, 6, 0, 14, 0.0F, false));
        this.bone38 = new MModelRenderer(this);
        this.bone38.setRotationPoint(-2.402F, 18.9623F, 2.4712F);
        this.setRotation(this.bone38, 0.107F, -0.1517F, 0.5103F);
        this.seredina2.addChild(this.bone38);
        this.bone38.cubeList.add(new ModelBox(this.bone38, 60, 17, -13.0339F, -18.7088F, -0.1262F, 6, 2, 2, -0.2F, false));
        this.LEGSFRONT = new MModelRenderer(this);
        this.LEGSFRONT.setRotationPoint(0.0F, -4.0F, -3.0F);
        this.ALLDRAGON.addChild(this.LEGSFRONT);
        this.bone44 = new MModelRenderer(this);
        this.bone44.setRotationPoint(1.5446F, 5.5684F, -0.6011F);
        this.setRotation(this.bone44, 0.6302F, -0.4428F, -0.3174F);
        this.LEGSFRONT.addChild(this.bone44);
        this.bone44.cubeList.add(new ModelBox(this.bone44, 0, 31, -2.228F, -2.1077F, -1.0909F, 4, 2, 2, -0.4F, false));
        this.bone43 = new MModelRenderer(this);
        this.bone43.setRotationPoint(1.4658F, 3.2681F, -1.4877F);
        this.setRotation(this.bone43, 1.8956F, -0.4428F, -0.3174F);
        this.LEGSFRONT.addChild(this.bone43);
        this.bone43.cubeList.add(new ModelBox(this.bone43, 17, 38, -2.4292F, -1.2573F, -1.4171F, 4, 3, 3, -0.4F, false));
        this.bone42 = new MModelRenderer(this);
        this.bone42.setRotationPoint(0.7751F, 1.5742F, -1.3729F);
        this.setRotation(this.bone42, -0.2837F, -0.3834F, -0.2706F);
        this.LEGSFRONT.addChild(this.bone42);
        this.bone42.cubeList.add(new ModelBox(this.bone42, 48, 65, -1.4468F, -1.6787F, -0.8644F, 2, 3, 2, 0.0F, false));
        this.bone41 = new MModelRenderer(this);
        this.bone41.setRotationPoint(-0.75F, -0.4123F, -1.2322F);
        this.setRotation(this.bone41, 0.2844F, -0.2245F, 0.2455F);
        this.LEGSFRONT.addChild(this.bone41);
        this.bone41.cubeList.add(new ModelBox(this.bone41, 16, 51, -2.0F, -2.0F, -2.0F, 4, 4, 4, -0.4F, false));
        this.LEGSFRONT2 = new MModelRenderer(this);
        this.LEGSFRONT2.setRotationPoint(-7.0F, -4.0F, -3.0F);
        this.ALLDRAGON.addChild(this.LEGSFRONT2);
        this.bone45 = new MModelRenderer(this);
        this.bone45.setRotationPoint(-1.5446F, 5.5684F, -0.6011F);
        this.setRotation(this.bone45, 0.6302F, 0.4428F, 0.3174F);
        this.LEGSFRONT2.addChild(this.bone45);
        this.bone45.cubeList.add(new ModelBox(this.bone45, 0, 27, -1.772F, -2.1077F, -1.0909F, 4, 2, 2, -0.4F, false));
        this.bone46 = new MModelRenderer(this);
        this.bone46.setRotationPoint(-1.4658F, 3.2681F, -1.4877F);
        this.setRotation(this.bone46, 1.8956F, 0.4428F, 0.3174F);
        this.LEGSFRONT2.addChild(this.bone46);
        this.bone46.cubeList.add(new ModelBox(this.bone46, 0, 15, -1.5708F, -1.2573F, -1.4171F, 4, 3, 3, -0.4F, false));
        this.bone47 = new MModelRenderer(this);
        this.bone47.setRotationPoint(-0.7751F, 1.5742F, -1.3729F);
        this.setRotation(this.bone47, -0.2837F, 0.3834F, 0.2706F);
        this.LEGSFRONT2.addChild(this.bone47);
        this.bone47.cubeList.add(new ModelBox(this.bone47, 16, 59, -0.5532F, -1.6787F, -0.8644F, 2, 3, 2, 0.0F, false));
        this.bone48 = new MModelRenderer(this);
        this.bone48.setRotationPoint(0.75F, -0.4123F, -1.2322F);
        this.setRotation(this.bone48, 0.2844F, 0.2245F, -0.2455F);
        this.LEGSFRONT2.addChild(this.bone48);
        this.bone48.cubeList.add(new ModelBox(this.bone48, 50, 25, -2.0F, -2.0F, -2.0F, 4, 4, 4, -0.4F, false));
        this.bone49 = new MModelRenderer(this);
        this.bone49.setRotationPoint(-3.5F, -9.1744F, -9.3391F);
        this.setRotation(this.bone49, -0.5672F, 0.0F, 0.0F);
        this.ALLDRAGON.addChild(this.bone49);
        this.bone49.cubeList.add(new ModelBox(this.bone49, 0, 70, -2.0F, -1.5F, -2.5F, 4, 4, 7, 0.0F, false));
        this.SPIKES = new MModelRenderer(this);
        this.SPIKES.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.ALLDRAGON.addChild(this.SPIKES);
        this.bone80 = new MModelRenderer(this);
        this.bone80.setRotationPoint(-3.5F, -15.9101F, 4.0034F);
        this.setRotation(this.bone80, -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.SPIKES.addChild(this.bone80);
        this.bone80.cubeList.add(new ModelBox(this.bone80, 28, 23, 0.0F, -2.5F, -1.5F, 0, 5, 3, 0.0F, false));
        this.bone78 = new MModelRenderer(this);
        this.bone78.setRotationPoint(-3.5F, -16.9101F, -1.9966F);
        this.setRotation(this.bone78, -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.SPIKES.addChild(this.bone78);
        this.bone78.cubeList.add(new ModelBox(this.bone78, 0, 32, 0.0F, -2.5F, -1.5F, 0, 5, 3, 0.0F, false));
        this.bone77 = new MModelRenderer(this);
        this.bone77.setRotationPoint(-3.5F, -17.9101F, -6.9966F);
        this.setRotation(this.bone77, -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.SPIKES.addChild(this.bone77);
        this.bone77.cubeList.add(new ModelBox(this.bone77, 0, 37, 0.0F, -2.5F, -1.5F, 0, 5, 3, 0.0F, false));
        this.bone79 = new MModelRenderer(this);
        this.bone79.setRotationPoint(-2.9302F, -14.5859F, 9.3173F);
        this.setRotation(this.bone79, -0.6197F, 0.2527F, -0.0692F);
        this.SPIKES.addChild(this.bone79);
        this.bone79.cubeList.add(new ModelBox(this.bone79, 28, 28, 0.0F, -1.0F, -1.5F, 0, 3, 3, 0.0F, false));
        this.HAT = new MModelRenderer(this);
        this.HAT.setRotationPoint(-3.5F, -8.25F, -10.75F);
        this.ALLDRAGON.addChild(this.HAT);
        this.HAT.cubeList.add(new ModelBox(this.HAT, 42, 47, -2.0F, -4.0F, -5.75F, 4, 4, 6, 0.6F, false));
        this.bone54 = new MModelRenderer(this);
        this.bone54.setRotationPoint(1.0F, 19.0F, 20.0F);
        this.HAT.addChild(this.bone54);
        this.bone55 = new MModelRenderer(this);
        this.bone55.setRotationPoint(-3.25F, -23.8713F, -23.2227F);
        this.setRotation(this.bone55, -0.1745F, 0.0F, 0.0F);
        this.bone54.addChild(this.bone55);
        this.bone55.cubeList.add(new ModelBox(this.bone55, 0, 21, -1.0F, -1.163F, -1.6927F, 2, 2, 4, 0.0F, false));
        this.bone56 = new MModelRenderer(this);
        this.bone56.setRotationPoint(-3.25F, -23.75F, -26.0F);
        this.setRotation(this.bone56, 0.48F, 0.0F, 0.0F);
        this.bone54.addChild(this.bone56);
        this.bone56.cubeList.add(new ModelBox(this.bone56, 0, 65, -1.0F, -0.7782F, -1.1154F, 2, 2, 3, 0.0F, false));
        this.bone53 = new MModelRenderer(this);
        this.bone53.setRotationPoint(-1.0F, 19.0F, 20.0F);
        this.HAT.addChild(this.bone53);
        this.bone52 = new MModelRenderer(this);
        this.bone52.setRotationPoint(3.25F, -23.8713F, -23.2227F);
        this.setRotation(this.bone52, -0.1745F, 0.0F, 0.0F);
        this.bone53.addChild(this.bone52);
        this.bone52.cubeList.add(new ModelBox(this.bone52, 0, 0, -1.0F, -1.163F, -1.6927F, 2, 2, 4, 0.0F, false));
        this.bone51 = new MModelRenderer(this);
        this.bone51.setRotationPoint(3.25F, -23.75F, -26.0F);
        this.setRotation(this.bone51, 0.48F, 0.0F, 0.0F);
        this.bone53.addChild(this.bone51);
        this.bone51.cubeList.add(new ModelBox(this.bone51, 10, 65, -1.0F, -0.9809F, -1.0565F, 2, 2, 3, 0.0F, false));
        this.bone61 = new MModelRenderer(this);
        this.bone61.setRotationPoint(3.5F, 15.25F, 8.75F);
        this.HAT.addChild(this.bone61);
        this.zalupa2 = new MModelRenderer(this);
        this.zalupa2.setRotationPoint(-1.0F, -17.0F, -8.0F);
        this.bone61.addChild(this.zalupa2);
        this.bone64 = new MModelRenderer(this);
        this.bone64.setRotationPoint(0.8042F, -0.9472F, 1.0018F);
        this.setRotation(this.bone64, -0.827F, 0.4265F, 0.4207F);
        this.zalupa2.addChild(this.bone64);
        this.bone64.cubeList.add(new ModelBox(this.bone64, 10, 0, 0.0F, -4.0F, -0.5F, 0, 2, 1, 0.0F, false));
        this.bone57 = new MModelRenderer(this);
        this.bone57.setRotationPoint(0.8042F, -0.9472F, 1.0018F);
        this.setRotation(this.bone57, -0.827F, 0.4265F, 0.4207F);
        this.zalupa2.addChild(this.bone57);
        this.bone57.cubeList.add(new ModelBox(this.bone57, 56, 68, -0.5F, -2.0F, -0.5F, 1, 6, 1, 0.1F, false));
        this.zalupa1 = new MModelRenderer(this);
        this.zalupa1.setRotationPoint(-1.5F, -19.75F, -8.75F);
        this.bone61.addChild(this.zalupa1);
        this.bone62 = new MModelRenderer(this);
        this.bone62.setRotationPoint(0.3042F, -5.6972F, 8.7518F);
        this.setRotation(this.bone62, -0.754F, 0.2125F, 0.0476F);
        this.zalupa1.addChild(this.bone62);
        this.bone62.cubeList.add(new ModelBox(this.bone62, 2, 7, 1.7107F, 1.1372F, -2.8746F, 0, 3, 1, 0.0F, false));
        this.bone58 = new MModelRenderer(this);
        this.bone58.setRotationPoint(0.3042F, -2.6972F, 2.7518F);
        this.setRotation(this.bone58, -0.754F, 0.2125F, 0.0476F);
        this.zalupa1.addChild(this.bone58);
        this.bone58.cubeList.add(new ModelBox(this.bone58, 64, 68, -0.2893F, -2.007F, -0.6246F, 1, 6, 1, 0.1F, false));
        this.zalupa = new MModelRenderer(this);
        this.zalupa.setRotationPoint(-1.0F, -17.5F, -9.25F);
        this.bone61.addChild(this.zalupa);
        this.bone63 = new MModelRenderer(this);
        this.bone63.setRotationPoint(0.8042F, -2.4472F, 2.2518F);
        this.setRotation(this.bone63, -0.8976F, 0.3507F, 0.1586F);
        this.zalupa.addChild(this.bone63);
        this.bone63.cubeList.add(new ModelBox(this.bone63, 0, 7, 0.0F, -5.0F, -0.5F, 0, 3, 1, 0.0F, false));
        this.bone59 = new MModelRenderer(this);
        this.bone59.setRotationPoint(0.8042F, -2.4472F, 2.2518F);
        this.setRotation(this.bone59, -0.8976F, 0.3507F, 0.1586F);
        this.zalupa.addChild(this.bone59);
        this.bone59.cubeList.add(new ModelBox(this.bone59, 60, 68, -0.5F, -2.0F, -0.5F, 1, 6, 1, 0.1F, false));
        this.zalupa3 = new MModelRenderer(this);
        this.zalupa3.setRotationPoint(-1.0F, -15.0F, -8.0F);
        this.bone61.addChild(this.zalupa3);
        this.bone65 = new MModelRenderer(this);
        this.bone65.setRotationPoint(0.2498F, -0.4534F, 0.3319F);
        this.setRotation(this.bone65, -1.8097F, 0.682F, -0.0734F);
        this.zalupa3.addChild(this.bone65);
        this.bone65.cubeList.add(new ModelBox(this.bone65, 8, 5, 0.0F, -4.0F, -0.5F, 0, 2, 1, 0.0F, false));
        this.bone60 = new MModelRenderer(this);
        this.bone60.setRotationPoint(0.2498F, -0.4534F, 0.3319F);
        this.setRotation(this.bone60, -1.8097F, 0.682F, -0.0734F);
        this.zalupa3.addChild(this.bone60);
        this.bone60.cubeList.add(new ModelBox(this.bone60, 68, 51, -0.5F, -2.0F, -0.5F, 1, 5, 1, 0.1F, false));
        this.bone66 = new MModelRenderer(this);
        this.bone66.setRotationPoint(-3.5F, 15.25F, 8.75F);
        this.HAT.addChild(this.bone66);
        this.zalupa4 = new MModelRenderer(this);
        this.zalupa4.setRotationPoint(1.5F, -19.75F, -8.75F);
        this.bone66.addChild(this.zalupa4);
        this.bone74 = new MModelRenderer(this);
        this.bone74.setRotationPoint(-0.3042F, -5.6972F, 8.7518F);
        this.setRotation(this.bone74, -0.754F, -0.2125F, -0.0476F);
        this.zalupa4.addChild(this.bone74);
        this.bone74.cubeList.add(new ModelBox(this.bone74, 0, 0, -1.7107F, 1.1372F, -2.8746F, 0, 3, 1, 0.0F, false));
        this.bone73 = new MModelRenderer(this);
        this.bone73.setRotationPoint(-0.3042F, -2.6972F, 2.7518F);
        this.setRotation(this.bone73, -0.754F, -0.2125F, -0.0476F);
        this.zalupa4.addChild(this.bone73);
        this.bone73.cubeList.add(new ModelBox(this.bone73, 36, 63, -0.7107F, -2.007F, -0.6246F, 1, 6, 1, 0.1F, false));
        this.zalupa5 = new MModelRenderer(this);
        this.zalupa5.setRotationPoint(1.0F, -17.5F, -9.25F);
        this.bone66.addChild(this.zalupa5);
        this.bone72 = new MModelRenderer(this);
        this.bone72.setRotationPoint(-0.8042F, -2.4472F, 2.2518F);
        this.setRotation(this.bone72, -0.8976F, -0.3507F, -0.1586F);
        this.zalupa5.addChild(this.bone72);
        this.bone72.cubeList.add(new ModelBox(this.bone72, 2, 0, 0.0F, -5.0F, -0.5F, 0, 3, 1, 0.0F, false));
        this.bone71 = new MModelRenderer(this);
        this.bone71.setRotationPoint(-0.8042F, -2.4472F, 2.2518F);
        this.setRotation(this.bone71, -0.8976F, -0.3507F, -0.1586F);
        this.zalupa5.addChild(this.bone71);
        this.bone71.cubeList.add(new ModelBox(this.bone71, 40, 63, -0.5F, -2.0F, -0.5F, 1, 6, 1, 0.1F, false));
        this.zalupa6 = new MModelRenderer(this);
        this.zalupa6.setRotationPoint(1.0F, -17.0F, -8.0F);
        this.bone66.addChild(this.zalupa6);
        this.bone70 = new MModelRenderer(this);
        this.bone70.setRotationPoint(-0.8042F, -0.9472F, 1.0018F);
        this.setRotation(this.bone70, -0.827F, -0.4265F, -0.4207F);
        this.zalupa6.addChild(this.bone70);
        this.bone70.cubeList.add(new ModelBox(this.bone70, 6, 5, 0.0F, -4.0F, -0.5F, 0, 2, 1, 0.0F, false));
        this.bone69 = new MModelRenderer(this);
        this.bone69.setRotationPoint(-0.8042F, -0.9472F, 1.0018F);
        this.setRotation(this.bone69, -0.827F, -0.4265F, -0.4207F);
        this.zalupa6.addChild(this.bone69);
        this.bone69.cubeList.add(new ModelBox(this.bone69, 44, 65, -0.5F, -2.0F, -0.5F, 1, 6, 1, 0.1F, false));
        this.zalupa7 = new MModelRenderer(this);
        this.zalupa7.setRotationPoint(1.0F, -15.0F, -8.0F);
        this.bone66.addChild(this.zalupa7);
        this.bone68 = new MModelRenderer(this);
        this.bone68.setRotationPoint(-0.2498F, -0.4534F, 0.3319F);
        this.setRotation(this.bone68, -1.8097F, -0.682F, 0.0734F);
        this.zalupa7.addChild(this.bone68);
        this.bone68.cubeList.add(new ModelBox(this.bone68, 8, 0, 0.0F, -4.0F, -0.5F, 0, 2, 1, 0.0F, false));
        this.bone67 = new MModelRenderer(this);
        this.bone67.setRotationPoint(-0.2498F, -0.4534F, 0.3319F);
        this.setRotation(this.bone67, -1.8097F, -0.682F, 0.0734F);
        this.zalupa7.addChild(this.bone67);
        this.bone67.cubeList.add(new ModelBox(this.bone67, 40, 40, -0.5F, -2.0F, -0.5F, 1, 5, 1, 0.1F, false));
        this.bone50 = new MModelRenderer(this);
        this.bone50.setRotationPoint(0.0F, 0.4772F, -5.7395F);
        this.setRotation(this.bone50, 0.1745F, 0.0F, 0.0F);
        this.HAT.addChild(this.bone50);
        this.bone50.cubeList.add(new ModelBox(this.bone50, 46, 16, -1.5F, -0.5F, -4.0F, 3, 1, 8, 0.0F, false));
        this.bone83 = new MModelRenderer(this);
        this.bone83.setRotationPoint(0.0F, -1.4924F, -6.0868F);
        this.setRotation(this.bone83, 0.1745F, 0.0F, 0.0F);
        this.HAT.addChild(this.bone83);
        this.bone83.cubeList.add(new ModelBox(this.bone83, 24, 40, -2.0F, -1.5F, -4.0F, 4, 3, 8, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-3.25F, -14.0F, -27.0F);
        this.bone.cubeList.add(new ModelBox(this.bone, -9, 81, -3.75F, 0.0F, -4.0F, 7, 0, 9, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 14, 72, -0.25F, -3.5F, -4.0F, 0, 7, 9, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 90, -2.25F, -2.0F, -3.0F, 4, 4, 5, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/dragonpet_" + color + ".png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/dragonpet_animation.json"));
        this.animation = bbanimationloader.mustGet("dragonpet.animation", this);
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
        GlStateManager.translate(0.8F, -0.1F + f, 0.2F);
        float f1 = 0.5F;
        GlStateManager.scale(f1, f1, f1);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0F, 0.3F, 0.0F);
        float f = 0.45F;
        GlStateManager.scale(f, f, f);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case 112785:
                if (s.equals("red"))
                {
                    b0 = 2;
                }

                break;

            case 3002044:
                if (s.equals("aqua"))
                {
                    b0 = 0;
                }

                break;

            case 3178592:
                if (s.equals("gold"))
                {
                    b0 = 1;
                }

                break;

            case 113101865:
                if (s.equals("white"))
                {
                    b0 = 3;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0413\u043e\u043b\u0443\u0431\u043e\u0439 \u0434\u0440\u0430\u043a\u043e\u043d";

            case 1:
                return "\u0417\u043e\u043b\u043e\u0442\u043e\u0439 \u0434\u0440\u0430\u043a\u043e\u043d";

            case 2:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0439 \u0434\u0440\u0430\u043a\u043e\u043d";

            case 3:
                return "\u0411\u0435\u043b\u044b\u0439 \u0434\u0440\u0430\u043a\u043e\u043d";

            default:
                return "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 \u0434\u0440\u0430\u043a\u043e\u043d";
        }
    }

    public String getCreator()
    {
        return "_Mc_CMETAHKA";
    }
}
