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

public class FireTubes extends BaseItem
{
    private final MModelRenderer All;
    private final MModelRenderer bone19;
    private final MModelRenderer bone20;
    private final MModelRenderer bone21;
    private final MModelRenderer bone22;
    private final MModelRenderer bone23;
    private final MModelRenderer bone24;
    private final MModelRenderer bone25;
    private final MModelRenderer Left3;
    private final MModelRenderer bone;
    private final MModelRenderer bone26;
    private final MModelRenderer bone27;
    private final MModelRenderer bone28;
    private final MModelRenderer bone29;
    private final MModelRenderer bone30;
    private final MModelRenderer Left2;
    private final MModelRenderer bone38;
    private final MModelRenderer bone31;
    private final MModelRenderer bone32;
    private final MModelRenderer Left1;
    private final MModelRenderer bone39;
    private final MModelRenderer bone33;
    private final MModelRenderer bone34;
    private final MModelRenderer bone35;
    private final MModelRenderer bone36;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer Right3;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer Right2;
    private final MModelRenderer bone15;
    private final MModelRenderer bone16;
    private final MModelRenderer bone17;
    private final MModelRenderer Right1;
    private final MModelRenderer bone18;
    private final MModelRenderer bone37;
    private final MModelRenderer bone40;
    private final MModelRenderer bone41;
    private final MModelRenderer bone42;
    private final IAnimation animation;

    public FireTubes()
    {
        super(ItemType.BODY);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.All = new MModelRenderer(this);
        this.bone19 = new MModelRenderer(this);
        this.All.addChild(this.bone19);
        this.bone20 = new MModelRenderer(this);
        this.bone19.addChild(this.bone20);
        this.bone20.cubeList.add(new ModelBox(this.bone20, 14, 9, 0.7F, -4.0F, 1.8F, 2, 2, 1, -0.1F, false));
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(1.8F, -3.0F, 2.5F);
        this.setRotation(this.bone21, 0.0714F, 0.1549F, 0.0247F);
        this.bone20.addChild(this.bone21);
        this.bone21.cubeList.add(new ModelBox(this.bone21, 14, 9, -0.7056F, -1.0F, 4.8367F, 2, 2, 1, -0.2F, false));
        this.bone22 = new MModelRenderer(this);
        this.bone22.setRotationPoint(2.5F, -3.0F, 4.4F);
        this.setRotation(this.bone22, 0.0806F, 0.503F, 0.0526F);
        this.bone20.addChild(this.bone22);
        this.bone22.cubeList.add(new ModelBox(this.bone22, 14, 9, -1.5349F, -1.1245F, -0.0104F, 2, 2, 1, -0.2F, false));
        this.bone23 = new MModelRenderer(this);
        this.bone23.setRotationPoint(1.8F, -3.0F, 2.5F);
        this.setRotation(this.bone23, 0.0714F, 0.1549F, 0.0247F);
        this.bone20.addChild(this.bone23);
        this.bone23.cubeList.add(new ModelBox(this.bone23, 0, 7, -1.1F, -1.0F, -0.4F, 2, 2, 3, -0.3F, false));
        this.bone24 = new MModelRenderer(this);
        this.bone24.setRotationPoint(2.5F, -3.0F, 4.4F);
        this.setRotation(this.bone24, 0.0806F, 0.503F, 0.0526F);
        this.bone20.addChild(this.bone24);
        this.bone24.cubeList.add(new ModelBox(this.bone24, 6, 0, -1.5349F, -1.1245F, -0.4104F, 2, 2, 2, -0.3001F, true));
        this.bone25 = new MModelRenderer(this);
        this.bone25.setRotationPoint(1.8F, -3.0F, 2.5F);
        this.setRotation(this.bone25, 0.0714F, 0.1549F, 0.0247F);
        this.bone20.addChild(this.bone25);
        this.bone25.cubeList.add(new ModelBox(this.bone25, 14, 0, -0.7056F, -1.0F, 2.8367F, 2, 2, 3, -0.3F, false));
        this.Left3 = new MModelRenderer(this);
        this.Left3.setRotationPoint(0.3F, 0.0F, 5.15F);
        this.bone25.addChild(this.Left3);
        this.Left3.cubeList.add(new ModelBox(this.Left3, 0, 0, -0.5056F, -1.5F, -0.3133F, 1, 3, 4, -0.5F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, 1.65F);
        this.setRotation(this.bone, 0.0F, 0.0F, 1.5708F);
        this.Left3.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -0.5056F, -1.5F, -1.9633F, 1, 3, 4, -0.5F, false));
        this.bone26 = new MModelRenderer(this);
        this.bone26.setRotationPoint(0.3F, 0.0F, 0.0F);
        this.bone19.addChild(this.bone26);
        this.bone26.cubeList.add(new ModelBox(this.bone26, 14, 9, 0.6F, -7.0F, 1.8F, 2, 2, 1, -0.1F, false));
        this.bone27 = new MModelRenderer(this);
        this.bone27.setRotationPoint(1.7F, -6.0F, 4.3F);
        this.setRotation(this.bone27, 0.1439F, 0.5529F, 0.0814F);
        this.bone26.addChild(this.bone27);
        this.bone27.cubeList.add(new ModelBox(this.bone27, 6, 0, -0.9898F, -1.2196F, -0.0114F, 2, 2, 2, -0.3001F, true));
        this.bone27.cubeList.add(new ModelBox(this.bone27, 14, 9, -0.9898F, -1.2196F, 0.3886F, 2, 2, 1, -0.2F, false));
        this.bone28 = new MModelRenderer(this);
        this.bone28.setRotationPoint(1.7F, -6.0F, 5.5F);
        this.setRotation(this.bone28, 0.1238F, 0.1549F, 0.0247F);
        this.bone26.addChild(this.bone28);
        this.bone28.cubeList.add(new ModelBox(this.bone28, 6, 0, -0.2013F, -1.366F, -0.1997F, 2, 2, 2, -0.3F, false));
        this.bone29 = new MModelRenderer(this);
        this.bone29.setRotationPoint(1.7F, -6.0F, 2.5F);
        this.setRotation(this.bone29, 0.1238F, 0.1549F, 0.0247F);
        this.bone26.addChild(this.bone29);
        this.bone29.cubeList.add(new ModelBox(this.bone29, 0, 7, -1.1F, -1.0F, -0.4F, 2, 2, 3, -0.3F, false));
        this.bone30 = new MModelRenderer(this);
        this.bone30.setRotationPoint(1.7F, -6.0F, 4.3F);
        this.setRotation(this.bone30, 0.1439F, 0.5529F, 0.0814F);
        this.bone26.addChild(this.bone30);
        this.bone30.cubeList.add(new ModelBox(this.bone30, 0, 12, -1.4255F, -1.2196F, 2.1303F, 2, 2, 3, -0.29F, true));
        this.bone30.cubeList.add(new ModelBox(this.bone30, 14, 9, -1.4255F, -1.2196F, 4.1303F, 2, 2, 1, -0.2F, false));
        this.Left2 = new MModelRenderer(this);
        this.Left2.setRotationPoint(-0.4F, -0.2F, 4.45F);
        this.bone30.addChild(this.Left2);
        this.Left2.cubeList.add(new ModelBox(this.Left2, 0, 0, -0.5255F, -1.5196F, -0.3197F, 1, 3, 4, -0.5F, false));
        this.bone38 = new MModelRenderer(this);
        this.bone38.setRotationPoint(-0.2F, 0.2F, 0.35F);
        this.setRotation(this.bone38, 0.0F, 0.0F, 1.5708F);
        this.Left2.addChild(this.bone38);
        this.bone38.cubeList.add(new ModelBox(this.bone38, 0, 0, -0.7255F, -1.7196F, -0.6697F, 1, 3, 4, -0.5F, false));
        this.bone31 = new MModelRenderer(this);
        this.bone19.addChild(this.bone31);
        this.bone31.cubeList.add(new ModelBox(this.bone31, 14, 9, 0.4F, -10.0F, 1.8F, 2, 2, 1, -0.1F, false));
        this.bone32 = new MModelRenderer(this);
        this.bone32.setRotationPoint(4.7F, -10.9F, 7.0F);
        this.setRotation(this.bone32, 0.3554F, 0.1384F, -0.1676F);
        this.bone31.addChild(this.bone32);
        this.bone32.cubeList.add(new ModelBox(this.bone32, 7, 9, -0.9593F, -0.9686F, -0.387F, 2, 2, 3, -0.3F, false));
        this.bone32.cubeList.add(new ModelBox(this.bone32, 14, 9, -0.9593F, -0.9686F, 1.613F, 2, 2, 1, -0.2F, false));
        this.Left1 = new MModelRenderer(this);
        this.Left1.setRotationPoint(0.0576F, 0.1218F, 1.9485F);
        this.bone32.addChild(this.Left1);
        this.Left1.cubeList.add(new ModelBox(this.Left1, 0, 0, -0.5169F, -1.5904F, -0.3355F, 1, 3, 4, -0.5F, false));
        this.bone39 = new MModelRenderer(this);
        this.bone39.setRotationPoint(-0.1F, 0.0F, 1.4F);
        this.setRotation(this.bone39, 0.0F, 0.0F, 1.5708F);
        this.Left1.addChild(this.bone39);
        this.bone39.cubeList.add(new ModelBox(this.bone39, 0, 0, -0.5169F, -1.5904F, -1.7355F, 1, 3, 4, -0.5F, false));
        this.bone33 = new MModelRenderer(this);
        this.bone33.setRotationPoint(4.0F, -10.3F, 6.1F);
        this.setRotation(this.bone33, 0.4939F, 0.6492F, 0.0926F);
        this.bone31.addChild(this.bone33);
        this.bone33.cubeList.add(new ModelBox(this.bone33, 6, 0, -1.0741F, -1.0323F, -0.0725F, 2, 2, 2, -0.3F, true));
        this.bone34 = new MModelRenderer(this);
        this.bone34.setRotationPoint(1.8F, -9.4F, 4.3F);
        this.setRotation(this.bone34, 0.5962F, 0.8283F, 0.2486F);
        this.bone31.addChild(this.bone34);
        this.bone34.cubeList.add(new ModelBox(this.bone34, 7, 4, -1.1745F, -0.7325F, 0.6175F, 2, 2, 3, -0.29F, true));
        this.bone34.cubeList.add(new ModelBox(this.bone34, 14, 9, -1.1745F, -0.7325F, 1.6175F, 2, 2, 1, -0.2F, false));
        this.bone35 = new MModelRenderer(this);
        this.bone35.setRotationPoint(1.8F, -9.4F, 4.3F);
        this.setRotation(this.bone35, 0.3344F, 0.8283F, 0.2486F);
        this.bone31.addChild(this.bone35);
        this.bone35.cubeList.add(new ModelBox(this.bone35, 6, 0, -1.1745F, -1.0029F, -0.5634F, 2, 2, 2, -0.3F, true));
        this.bone36 = new MModelRenderer(this);
        this.bone36.setRotationPoint(1.7F, -9.0F, 2.5F);
        this.setRotation(this.bone36, 0.2296F, 0.153F, 0.0356F);
        this.bone31.addChild(this.bone36);
        this.bone36.cubeList.add(new ModelBox(this.bone36, 0, 7, -1.3302F, -0.9847F, -0.5002F, 2, 2, 3, -0.3F, false));
        this.bone2 = new MModelRenderer(this);
        this.All.addChild(this.bone2);
        this.bone3 = new MModelRenderer(this);
        this.bone2.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 14, 9, -2.7F, -4.0F, 1.8F, 2, 2, 1, -0.1F, true));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-1.8F, -3.0F, 2.5F);
        this.setRotation(this.bone4, 0.0714F, -0.1549F, -0.0247F);
        this.bone3.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 14, 9, -1.2944F, -1.0F, 4.8367F, 2, 2, 1, -0.2F, true));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-2.5F, -3.0F, 4.4F);
        this.setRotation(this.bone5, 0.0806F, -0.503F, -0.0526F);
        this.bone3.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 14, 9, -0.4651F, -1.1245F, -0.0104F, 2, 2, 1, -0.2F, true));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-1.8F, -3.0F, 2.5F);
        this.setRotation(this.bone6, 0.0714F, -0.1549F, -0.0247F);
        this.bone3.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 7, -0.9F, -1.0F, -0.4F, 2, 2, 3, -0.3F, true));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-2.5F, -3.0F, 4.4F);
        this.setRotation(this.bone7, 0.0806F, -0.503F, -0.0526F);
        this.bone3.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 6, 0, -0.4651F, -1.1245F, -0.4104F, 2, 2, 2, -0.3001F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-1.8F, -3.0F, 2.5F);
        this.setRotation(this.bone8, 0.0714F, -0.1549F, -0.0247F);
        this.bone3.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 14, 0, -1.2944F, -1.0F, 2.8367F, 2, 2, 3, -0.3F, true));
        this.Right3 = new MModelRenderer(this);
        this.Right3.setRotationPoint(-0.3F, 0.0F, 5.2F);
        this.bone8.addChild(this.Right3);
        this.Right3.cubeList.add(new ModelBox(this.Right3, 0, 0, -0.4944F, -1.5F, -0.3633F, 1, 3, 4, -0.5F, true));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, 0.0F, 1.6F);
        this.setRotation(this.bone9, 0.0F, 0.0F, -1.5708F);
        this.Right3.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 0, -0.4944F, -1.5F, -1.9633F, 1, 3, 4, -0.5F, true));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-0.3F, 0.0F, 0.0F);
        this.bone2.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 14, 9, -2.6F, -7.0F, 1.8F, 2, 2, 1, -0.1F, true));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-1.7F, -6.0F, 4.3F);
        this.setRotation(this.bone11, 0.1439F, -0.5529F, -0.0814F);
        this.bone10.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 6, 0, -1.0102F, -1.2196F, -0.0114F, 2, 2, 2, -0.3001F, false));
        this.bone11.cubeList.add(new ModelBox(this.bone11, 14, 9, -1.0102F, -1.2196F, 0.3886F, 2, 2, 1, -0.2F, true));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(-1.7F, -6.0F, 5.5F);
        this.setRotation(this.bone12, 0.1238F, -0.1549F, -0.0247F);
        this.bone10.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 6, 0, -1.7987F, -1.366F, -0.1997F, 2, 2, 2, -0.3F, true));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-1.7F, -6.0F, 2.5F);
        this.setRotation(this.bone13, 0.1238F, -0.1549F, -0.0247F);
        this.bone10.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 0, 7, -0.9F, -1.0F, -0.4F, 2, 2, 3, -0.3F, true));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-1.7F, -6.0F, 4.3F);
        this.setRotation(this.bone14, 0.1439F, -0.5529F, -0.0814F);
        this.bone10.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 0, 12, -0.5745F, -1.2196F, 2.1303F, 2, 2, 3, -0.29F, false));
        this.bone14.cubeList.add(new ModelBox(this.bone14, 14, 9, -0.5745F, -1.2196F, 4.1303F, 2, 2, 1, -0.2F, true));
        this.Right2 = new MModelRenderer(this);
        this.Right2.setRotationPoint(0.4F, -0.2F, 4.5F);
        this.bone14.addChild(this.Right2);
        this.Right2.cubeList.add(new ModelBox(this.Right2, 0, 0, -0.4745F, -1.5196F, -0.3697F, 1, 3, 4, -0.5F, true));
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(0.2F, 0.2F, 0.3F);
        this.setRotation(this.bone15, 0.0F, 0.0F, -1.5708F);
        this.Right2.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 0, 0, -0.2745F, -1.7196F, -0.6697F, 1, 3, 4, -0.5F, true));
        this.bone16 = new MModelRenderer(this);
        this.bone2.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 14, 9, -2.4F, -10.0F, 1.8F, 2, 2, 1, -0.1F, true));
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(-4.7F, -10.9F, 7.0F);
        this.setRotation(this.bone17, 0.3554F, -0.1384F, 0.1676F);
        this.bone16.addChild(this.bone17);
        this.bone17.cubeList.add(new ModelBox(this.bone17, 7, 9, -1.0407F, -0.9686F, -0.387F, 2, 2, 3, -0.3F, true));
        this.bone17.cubeList.add(new ModelBox(this.bone17, 14, 9, -1.0407F, -0.9686F, 1.613F, 2, 2, 1, -0.2F, true));
        this.Right1 = new MModelRenderer(this);
        this.Right1.setRotationPoint(-0.0576F, 0.1218F, 1.9985F);
        this.bone17.addChild(this.Right1);
        this.Right1.cubeList.add(new ModelBox(this.Right1, 0, 0, -0.4831F, -1.5904F, -0.3855F, 1, 3, 4, -0.5F, true));
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(0.1F, 0.0F, 1.35F);
        this.setRotation(this.bone18, 0.0F, 0.0F, -1.5708F);
        this.Right1.addChild(this.bone18);
        this.bone18.cubeList.add(new ModelBox(this.bone18, 0, 0, -0.4831F, -1.5904F, -1.7355F, 1, 3, 4, -0.5F, true));
        this.bone37 = new MModelRenderer(this);
        this.bone37.setRotationPoint(-4.0F, -10.3F, 6.1F);
        this.setRotation(this.bone37, 0.4939F, -0.6492F, -0.0926F);
        this.bone16.addChild(this.bone37);
        this.bone37.cubeList.add(new ModelBox(this.bone37, 6, 0, -0.9259F, -1.0323F, -0.0725F, 2, 2, 2, -0.3F, false));
        this.bone40 = new MModelRenderer(this);
        this.bone40.setRotationPoint(-1.8F, -9.4F, 4.3F);
        this.setRotation(this.bone40, 0.5962F, -0.8283F, -0.2486F);
        this.bone16.addChild(this.bone40);
        this.bone40.cubeList.add(new ModelBox(this.bone40, 7, 4, -0.8255F, -0.7325F, 0.6175F, 2, 2, 3, -0.29F, false));
        this.bone40.cubeList.add(new ModelBox(this.bone40, 14, 9, -0.8255F, -0.7325F, 1.6175F, 2, 2, 1, -0.2F, true));
        this.bone41 = new MModelRenderer(this);
        this.bone41.setRotationPoint(-1.8F, -9.4F, 4.3F);
        this.setRotation(this.bone41, 0.3344F, -0.8283F, -0.2486F);
        this.bone16.addChild(this.bone41);
        this.bone41.cubeList.add(new ModelBox(this.bone41, 6, 0, -0.8255F, -1.0029F, -0.5634F, 2, 2, 2, -0.3F, false));
        this.bone42 = new MModelRenderer(this);
        this.bone42.setRotationPoint(-1.7F, -9.0F, 2.5F);
        this.setRotation(this.bone42, 0.2296F, -0.153F, -0.0356F);
        this.bone16.addChild(this.bone42);
        this.bone42.cubeList.add(new ModelBox(this.bone42, 0, 7, -0.6698F, -0.9847F, -0.5002F, 2, 2, 3, -0.3F, true));
        super.setTexture(new ResourceLocation("minidot", "body/firetubes.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/firetubes_animation.json"));
        this.animation = bbanimationloader.mustGet("firetubes.animation", this);
    }

    public void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.67F, 0.0F);
        this.animation.tick(time);
    }

    public void renderAsItem(float time)
    {
        float f = 1.162F;
        GlStateManager.scale(f, f, f);
        GlStateManager.translate(0.0D, 0.65D, 0.17000000178813934D);
        this.animation.tick(time);
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
        return "\u041e\u0433\u043d\u0435\u043d\u043d\u044b\u0435 \u0442\u0440\u0443\u0431\u044b";
    }

    public String getCreator()
    {
        return "Ceme4ka7 & woors";
    }
}
