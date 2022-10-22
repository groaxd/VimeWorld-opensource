package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BedWars2020 extends BasePet
{
    private final String type;
    private static MModelRenderer BED;
    private static MModelRenderer bone2;
    private static MModelRenderer bone26;
    private static MModelRenderer bone51;
    private static MModelRenderer ICEBASE;
    private static MModelRenderer bone14;
    private static MModelRenderer bone15;
    private static MModelRenderer bone16;
    private static MModelRenderer bone17;
    private static MModelRenderer bone18;
    private static MModelRenderer bone19;
    private static MModelRenderer bone20;
    private static MModelRenderer bone21;
    private static MModelRenderer bone22;
    private static MModelRenderer bone23;
    private static MModelRenderer bone24;
    private static MModelRenderer bone3;
    private static MModelRenderer bone4;
    private static MModelRenderer bone5;
    private static MModelRenderer bone6;
    private static MModelRenderer bone7;
    private static MModelRenderer bone8;
    private static MModelRenderer bone11;
    private static MModelRenderer bone12;
    private static MModelRenderer bone9;
    private static MModelRenderer bone10;
    private static MModelRenderer bone13;
    private static MModelRenderer bone27;
    private static MModelRenderer bone28;
    private static MModelRenderer bone29;
    private static MModelRenderer bone30;
    private static MModelRenderer bone31;
    private static MModelRenderer bone32;
    private static MModelRenderer bone33;
    private static MModelRenderer bone34;
    private static MModelRenderer bone35;
    private static MModelRenderer bone36;
    private static MModelRenderer bone37;
    private static MModelRenderer bone38;
    private static MModelRenderer bone39;
    private static MModelRenderer bone40;
    private static MModelRenderer bone41;
    private static MModelRenderer bone42;
    private static MModelRenderer bone43;
    private static MModelRenderer bone44;
    private static MModelRenderer bone45;
    private static MModelRenderer bone46;
    private static MModelRenderer bone47;
    private static MModelRenderer bone48;
    private static MModelRenderer BASE;
    private static MModelRenderer bone50;
    private static MModelRenderer ICEHAND1;
    private static MModelRenderer bone52;
    private static MModelRenderer bone53;
    private static MModelRenderer bone54;
    private static MModelRenderer bone55;
    private static MModelRenderer bone25;
    private static MModelRenderer bone49;
    private static MModelRenderer bone58;
    private static MModelRenderer bone59;
    private static MModelRenderer bone60;
    private static MModelRenderer bone61;
    private static MModelRenderer bone56;
    private static MModelRenderer bone57;
    private static MModelRenderer ICEHAND2;
    private static MModelRenderer bone63;
    private static MModelRenderer bone65;
    private static MModelRenderer bone67;
    private static MModelRenderer bone69;
    private static MModelRenderer bone71;
    private static MModelRenderer bone73;

    public BedWars2020(String type)
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.type = type;
        this.useDisplayLists = true;

        if (BED == null)
        {
            BED = new MModelRenderer(this);
            BED.setRotationPoint(0.0F, -9.75F, 0.0F);
            this.setRotation(BED, 0.0873F, -0.0873F, 0.0873F);
            BED.cubeList.add(new ModelBox(BED, 0, 0, -3.0F, -3.0F, -4.0F, 6, 3, 8, 0.0F, false));
            BED.cubeList.add(new ModelBox(BED, 0, 23, -3.0F, -3.9F, -5.0F, 6, 4, 1, 0.0F, true));
            BED.cubeList.add(new ModelBox(BED, 10, 11, 2.0F, -5.0F, -5.5F, 2, 6, 2, -0.25F, true));
            BED.cubeList.add(new ModelBox(BED, 18, 11, 2.0F, -7.0F, 3.5F, 2, 8, 2, -0.25F, true));
            BED.cubeList.add(new ModelBox(BED, 18, 11, -4.0F, -7.0F, 3.5F, 2, 8, 2, -0.25F, false));
            BED.cubeList.add(new ModelBox(BED, 10, 11, -4.0F, -5.0F, -5.5F, 2, 6, 2, -0.25F, false));
            BED.cubeList.add(new ModelBox(BED, 0, 21, -3.0F, -5.9F, 4.0F, 6, 6, 1, 0.0F, false));
            BED.cubeList.add(new ModelBox(BED, 0, 11, 2.25F, -2.75F, -4.0F, 1, 2, 8, 0.0F, true));
            BED.cubeList.add(new ModelBox(BED, 0, 11, -3.25F, -2.75F, -4.0F, 1, 2, 8, 0.0F, false));
            bone2 = new MModelRenderer(this);
            bone2.setRotationPoint(0.0F, 6.0F, -1.0F);
            this.setRotation(bone2, 0.6109F, 0.0F, 0.0F);
            BED.addChild(bone2);
            bone2.cubeList.add(new ModelBox(bone2, 0, 28, -2.5F, -5.8F, 7.65F, 5, 2, 2, 0.0F, false));
            bone26 = new MModelRenderer(this);
            bone26.setRotationPoint(1.75F, 6.0F, -1.0F);
            BED.addChild(bone26);
            bone26.cubeList.add(new ModelBox(bone26, 26, 17, 0.0992F, -10.7832F, 5.7204F, 2, 1, 1, -0.2F, false));
            bone26.cubeList.add(new ModelBox(bone26, 26, 17, 0.0992F, -10.2832F, 5.7204F, 1, 1, 1, -0.2F, false));
            bone26.cubeList.add(new ModelBox(bone26, 26, 17, -1.2008F, -10.7832F, 5.7204F, 1, 1, 1, -0.2F, false));
            bone26.cubeList.add(new ModelBox(bone26, 26, 17, -1.2508F, -8.7832F, 5.7204F, 1, 1, 1, -0.2F, false));
            bone26.cubeList.add(new ModelBox(bone26, 26, 17, -0.6508F, -10.7832F, 5.7204F, 1, 3, 1, -0.2F, false));
            bone26.cubeList.add(new ModelBox(bone26, 26, 17, -1.8008F, -10.7832F, 5.7204F, 1, 3, 1, -0.2F, false));
            bone26.cubeList.add(new ModelBox(bone26, 26, 17, 0.0992F, -9.7832F, 5.7204F, 2, 1, 1, -0.2F, false));
            bone26.cubeList.add(new ModelBox(bone26, 26, 17, 1.0992F, -9.2832F, 5.7204F, 1, 1, 1, -0.2F, false));
            bone26.cubeList.add(new ModelBox(bone26, 26, 17, 0.0992F, -8.7832F, 5.7204F, 2, 1, 1, -0.2F, false));
            bone51 = new MModelRenderer(this);
            bone51.setRotationPoint(-2.0F, 6.0F, -1.0F);
            BED.addChild(bone51);
            bone51.cubeList.add(new ModelBox(bone51, 26, 17, 0.0992F, -10.7832F, 5.7204F, 2, 1, 1, -0.2F, false));
            bone51.cubeList.add(new ModelBox(bone51, 26, 17, 0.0992F, -10.2832F, 5.7204F, 1, 1, 1, -0.2F, false));
            bone51.cubeList.add(new ModelBox(bone51, 26, 17, -1.2008F, -10.7832F, 5.7204F, 1, 1, 1, -0.2F, false));
            bone51.cubeList.add(new ModelBox(bone51, 26, 17, -1.2508F, -8.7832F, 5.7204F, 1, 1, 1, -0.2F, false));
            bone51.cubeList.add(new ModelBox(bone51, 26, 17, -0.6508F, -10.7832F, 5.7204F, 1, 3, 1, -0.2F, false));
            bone51.cubeList.add(new ModelBox(bone51, 26, 17, -1.8008F, -10.7832F, 5.7204F, 1, 3, 1, -0.2F, false));
            bone51.cubeList.add(new ModelBox(bone51, 26, 17, 0.0992F, -9.7832F, 5.7204F, 2, 1, 1, -0.2F, false));
            bone51.cubeList.add(new ModelBox(bone51, 26, 17, 1.0992F, -9.2832F, 5.7204F, 1, 1, 1, -0.2F, false));
            bone51.cubeList.add(new ModelBox(bone51, 26, 17, 0.0992F, -8.7832F, 5.7204F, 2, 1, 1, -0.2F, false));
            ICEBASE = new MModelRenderer(this);
            bone14 = new MModelRenderer(this);
            bone14.setRotationPoint(0.0F, -14.0F, 0.0F);
            ICEBASE.addChild(bone14);
            bone15 = new MModelRenderer(this);
            bone15.setRotationPoint(-0.1F, 7.1F, 0.0F);
            this.setRotation(bone15, -0.0873F, 0.1745F, -0.1745F);
            bone14.addChild(bone15);
            bone15.cubeList.add(new ModelBox(bone15, 26, 0, 1.5F, -2.25F, -0.75F, 1, 6, 1, 0.0F, false));
            bone16 = new MModelRenderer(this);
            bone16.setRotationPoint(-0.1F, 7.1F, 0.0F);
            this.setRotation(bone16, 0.1745F, 0.1745F, -0.1745F);
            bone14.addChild(bone16);
            bone16.cubeList.add(new ModelBox(bone16, 26, 0, 1.2F, -1.0F, 0.75F, 1, 5, 1, 0.0F, true));
            bone17 = new MModelRenderer(this);
            bone17.setRotationPoint(-0.1F, 7.1F, 0.0F);
            this.setRotation(bone17, 0.0873F, 0.6109F, -0.1745F);
            bone14.addChild(bone17);
            bone17.cubeList.add(new ModelBox(bone17, 26, 0, 1.0F, -2.55F, 0.75F, 1, 6, 1, 0.0F, true));
            bone18 = new MModelRenderer(this);
            bone18.setRotationPoint(-0.1F, 7.1F, 0.0F);
            this.setRotation(bone18, -0.1745F, 0.8727F, -0.2618F);
            bone14.addChild(bone18);
            bone18.cubeList.add(new ModelBox(bone18, 26, 0, 1.5F, -2.25F, 0.0F, 1, 6, 1, 0.0F, true));
            bone19 = new MModelRenderer(this);
            bone19.setRotationPoint(-0.1F, 7.1F, 0.0F);
            this.setRotation(bone19, 0.3491F, 0.3491F, -0.1745F);
            bone14.addChild(bone19);
            bone19.cubeList.add(new ModelBox(bone19, 26, 0, 0.45F, -0.75F, 1.7F, 1, 5, 1, 0.0F, true));
            bone20 = new MModelRenderer(this);
            bone20.setRotationPoint(-0.1F, 7.1F, 0.0F);
            this.setRotation(bone20, 0.3491F, -0.5236F, -0.1745F);
            bone14.addChild(bone20);
            bone20.cubeList.add(new ModelBox(bone20, 26, 0, 0.95F, -1.0F, 0.95F, 1, 5, 1, 0.0F, false));
            bone21 = new MModelRenderer(this);
            bone21.setRotationPoint(-0.1F, 7.1F, 0.0F);
            this.setRotation(bone21, 0.4363F, -0.5236F, -0.4363F);
            bone14.addChild(bone21);
            bone21.cubeList.add(new ModelBox(bone21, 26, 0, 1.3F, -0.85F, 0.7F, 1, 5, 1, 0.0F, true));
            bone22 = new MModelRenderer(this);
            bone22.setRotationPoint(-0.1F, 7.1F, 0.0F);
            this.setRotation(bone22, -0.1745F, 0.1745F, 0.0F);
            bone14.addChild(bone22);
            bone22.cubeList.add(new ModelBox(bone22, 26, 0, 1.25F, -2.5F, -1.75F, 1, 6, 1, 0.0F, true));
            bone23 = new MModelRenderer(this);
            bone23.setRotationPoint(-0.1F, 7.1F, 0.0F);
            this.setRotation(bone23, -0.2618F, 0.1745F, -0.1745F);
            bone14.addChild(bone23);
            bone23.cubeList.add(new ModelBox(bone23, 26, 0, 0.5F, -2.0F, -2.0F, 1, 6, 1, 0.0F, false));
            bone24 = new MModelRenderer(this);
            bone24.setRotationPoint(-0.1F, 7.1F, 0.0F);
            this.setRotation(bone24, -0.2618F, 0.4363F, -0.1745F);
            bone14.addChild(bone24);
            bone24.cubeList.add(new ModelBox(bone24, 26, 0, 0.5F, -2.0F, -2.0F, 1, 6, 1, 0.0F, true));
            bone3 = new MModelRenderer(this);
            ICEBASE.addChild(bone3);
            bone4 = new MModelRenderer(this);
            bone4.setRotationPoint(-0.1F, -7.1F, 0.0F);
            this.setRotation(bone4, -0.0873F, -0.1745F, 0.1745F);
            bone3.addChild(bone4);
            bone4.cubeList.add(new ModelBox(bone4, 26, 0, 1.5F, -4.0F, -0.25F, 1, 6, 1, 0.0F, false));
            bone5 = new MModelRenderer(this);
            bone5.setRotationPoint(-0.1F, -7.1F, 0.0F);
            this.setRotation(bone5, 0.1745F, -0.1745F, 0.1745F);
            bone3.addChild(bone5);
            bone5.cubeList.add(new ModelBox(bone5, 26, 0, 1.2F, -4.0F, -1.75F, 1, 5, 1, 0.0F, false));
            bone6 = new MModelRenderer(this);
            bone6.setRotationPoint(-0.1F, -7.1F, 0.0F);
            this.setRotation(bone6, 0.0873F, -0.6109F, 0.1745F);
            bone3.addChild(bone6);
            bone6.cubeList.add(new ModelBox(bone6, 26, 0, 1.0F, -4.0F, -1.75F, 1, 6, 1, 0.0F, false));
            bone7 = new MModelRenderer(this);
            bone7.setRotationPoint(-0.1F, -7.1F, 0.0F);
            this.setRotation(bone7, -0.1745F, -0.8727F, 0.2618F);
            bone3.addChild(bone7);
            bone7.cubeList.add(new ModelBox(bone7, 26, 0, 1.5F, -4.25F, -1.0F, 1, 6, 1, 0.0F, false));
            bone8 = new MModelRenderer(this);
            bone8.setRotationPoint(-0.1F, -7.1F, 0.0F);
            this.setRotation(bone8, 0.3491F, -0.3491F, 0.1745F);
            bone3.addChild(bone8);
            bone8.cubeList.add(new ModelBox(bone8, 26, 0, 0.45F, -4.5F, -2.7F, 1, 5, 1, 0.0F, false));
            bone11 = new MModelRenderer(this);
            bone11.setRotationPoint(-0.1F, -7.1F, 0.0F);
            this.setRotation(bone11, 0.3491F, 0.5236F, 0.1745F);
            bone3.addChild(bone11);
            bone11.cubeList.add(new ModelBox(bone11, 26, 0, 0.95F, -4.5F, -1.95F, 1, 5, 1, 0.0F, false));
            bone12 = new MModelRenderer(this);
            bone12.setRotationPoint(-0.1F, -7.1F, 0.0F);
            this.setRotation(bone12, 0.4363F, 0.5236F, 0.4363F);
            bone3.addChild(bone12);
            bone12.cubeList.add(new ModelBox(bone12, 26, 0, 0.95F, -5.0F, -1.7F, 1, 5, 1, 0.0F, false));
            bone9 = new MModelRenderer(this);
            bone9.setRotationPoint(-0.1F, -7.1F, 0.0F);
            this.setRotation(bone9, -0.1745F, -0.1745F, 0.0F);
            bone3.addChild(bone9);
            bone9.cubeList.add(new ModelBox(bone9, 26, 0, 1.25F, -4.0F, 0.75F, 1, 6, 1, 0.0F, false));
            bone10 = new MModelRenderer(this);
            bone10.setRotationPoint(-0.1F, -7.1F, 0.0F);
            this.setRotation(bone10, -0.2618F, -0.1745F, 0.1745F);
            bone3.addChild(bone10);
            bone10.cubeList.add(new ModelBox(bone10, 26, 0, 0.5F, -4.0F, 1.0F, 1, 6, 1, 0.0F, false));
            bone13 = new MModelRenderer(this);
            bone13.setRotationPoint(-0.1F, -7.1F, 0.0F);
            this.setRotation(bone13, -0.2618F, -0.4363F, 0.1745F);
            bone3.addChild(bone13);
            bone13.cubeList.add(new ModelBox(bone13, 26, 0, 0.5F, -4.0F, 1.0F, 1, 6, 1, 0.0F, false));
            bone27 = new MModelRenderer(this);
            bone27.setRotationPoint(0.0F, -14.0F, 0.0F);
            ICEBASE.addChild(bone27);
            bone28 = new MModelRenderer(this);
            bone28.setRotationPoint(0.1F, 7.1F, 0.0F);
            this.setRotation(bone28, 0.0873F, 0.1745F, 0.1745F);
            bone27.addChild(bone28);
            bone28.cubeList.add(new ModelBox(bone28, 26, 0, -2.5F, -2.25F, -0.25F, 1, 6, 1, 0.0F, true));
            bone29 = new MModelRenderer(this);
            bone29.setRotationPoint(0.1F, 7.1F, 0.0F);
            this.setRotation(bone29, -0.1745F, 0.1745F, 0.1745F);
            bone27.addChild(bone29);
            bone29.cubeList.add(new ModelBox(bone29, 26, 0, -2.2F, -1.0F, -1.75F, 1, 5, 1, 0.0F, true));
            bone30 = new MModelRenderer(this);
            bone30.setRotationPoint(0.1F, 7.1F, 0.0F);
            this.setRotation(bone30, -0.0873F, 0.6109F, 0.1745F);
            bone27.addChild(bone30);
            bone30.cubeList.add(new ModelBox(bone30, 26, 0, -2.0F, -2.5F, -1.75F, 1, 6, 1, 0.0F, true));
            bone31 = new MModelRenderer(this);
            bone31.setRotationPoint(0.1F, 7.1F, 0.0F);
            this.setRotation(bone31, 0.1745F, 0.8727F, 0.2618F);
            bone27.addChild(bone31);
            bone31.cubeList.add(new ModelBox(bone31, 26, 0, -2.5F, -2.25F, -1.0F, 1, 6, 1, 0.0F, true));
            bone32 = new MModelRenderer(this);
            bone32.setRotationPoint(0.1F, 7.1F, 0.0F);
            this.setRotation(bone32, -0.3491F, 0.3491F, 0.1745F);
            bone27.addChild(bone32);
            bone32.cubeList.add(new ModelBox(bone32, 26, 0, -1.45F, -0.75F, -2.7F, 1, 5, 1, 0.0F, true));
            bone33 = new MModelRenderer(this);
            bone33.setRotationPoint(0.1F, 7.1F, 0.0F);
            this.setRotation(bone33, -0.3491F, -0.5236F, 0.1745F);
            bone27.addChild(bone33);
            bone33.cubeList.add(new ModelBox(bone33, 26, 0, -1.95F, -1.0F, -1.95F, 1, 5, 1, 0.0F, true));
            bone34 = new MModelRenderer(this);
            bone34.setRotationPoint(0.1F, 7.1F, 0.0F);
            this.setRotation(bone34, -0.4363F, -0.5236F, 0.4363F);
            bone27.addChild(bone34);
            bone34.cubeList.add(new ModelBox(bone34, 26, 0, -2.3F, -0.75F, -1.6F, 1, 5, 1, 0.0F, true));
            bone35 = new MModelRenderer(this);
            bone35.setRotationPoint(0.1F, 7.1F, 0.0F);
            this.setRotation(bone35, 0.1745F, 0.1745F, 0.0F);
            bone27.addChild(bone35);
            bone35.cubeList.add(new ModelBox(bone35, 26, 0, -2.25F, -2.25F, 0.75F, 1, 6, 1, 0.0F, true));
            bone36 = new MModelRenderer(this);
            bone36.setRotationPoint(0.1F, 7.1F, 0.0F);
            this.setRotation(bone36, 0.2618F, 0.1745F, 0.1745F);
            bone27.addChild(bone36);
            bone36.cubeList.add(new ModelBox(bone36, 26, 0, -1.5F, -2.0F, 1.0F, 1, 6, 1, 0.0F, true));
            bone37 = new MModelRenderer(this);
            bone37.setRotationPoint(0.1F, 7.1F, 0.0F);
            this.setRotation(bone37, 0.2618F, 0.4363F, 0.1745F);
            bone27.addChild(bone37);
            bone37.cubeList.add(new ModelBox(bone37, 26, 0, -1.5F, -2.0F, 1.0F, 1, 6, 1, 0.0F, true));
            bone38 = new MModelRenderer(this);
            ICEBASE.addChild(bone38);
            bone39 = new MModelRenderer(this);
            bone39.setRotationPoint(0.1F, -7.1F, 0.0F);
            this.setRotation(bone39, 0.0873F, -0.1745F, -0.1745F);
            bone38.addChild(bone39);
            bone39.cubeList.add(new ModelBox(bone39, 26, 0, -2.5F, -4.0F, -0.75F, 1, 6, 1, 0.0F, true));
            bone40 = new MModelRenderer(this);
            bone40.setRotationPoint(0.1F, -7.1F, 0.0F);
            this.setRotation(bone40, -0.1745F, -0.1745F, -0.1745F);
            bone38.addChild(bone40);
            bone40.cubeList.add(new ModelBox(bone40, 26, 0, -2.2F, -4.0F, 0.75F, 1, 5, 1, 0.0F, true));
            bone41 = new MModelRenderer(this);
            bone41.setRotationPoint(0.1F, -7.1F, 0.0F);
            this.setRotation(bone41, -0.0873F, -0.6109F, -0.1745F);
            bone38.addChild(bone41);
            bone41.cubeList.add(new ModelBox(bone41, 26, 0, -2.0F, -4.0F, 0.75F, 1, 6, 1, 0.0F, true));
            bone42 = new MModelRenderer(this);
            bone42.setRotationPoint(0.1F, -7.1F, 0.0F);
            this.setRotation(bone42, 0.1745F, -0.8727F, -0.2618F);
            bone38.addChild(bone42);
            bone42.cubeList.add(new ModelBox(bone42, 26, 0, -2.5F, -4.25F, 0.0F, 1, 6, 1, 0.0F, true));
            bone43 = new MModelRenderer(this);
            bone43.setRotationPoint(0.1F, -7.1F, 0.0F);
            this.setRotation(bone43, -0.3491F, -0.3491F, -0.1745F);
            bone38.addChild(bone43);
            bone43.cubeList.add(new ModelBox(bone43, 26, 0, -1.45F, -4.9F, 1.7F, 1, 5, 1, 0.0F, true));
            bone44 = new MModelRenderer(this);
            bone44.setRotationPoint(0.1F, -7.1F, 0.0F);
            this.setRotation(bone44, -0.3491F, 0.5236F, -0.1745F);
            bone38.addChild(bone44);
            bone44.cubeList.add(new ModelBox(bone44, 26, 0, -1.95F, -4.5F, 0.95F, 1, 5, 1, 0.0F, true));
            bone45 = new MModelRenderer(this);
            bone45.setRotationPoint(0.1F, -7.1F, 0.0F);
            this.setRotation(bone45, -0.4363F, 0.5236F, -0.4363F);
            bone38.addChild(bone45);
            bone45.cubeList.add(new ModelBox(bone45, 26, 0, -1.95F, -5.0F, 0.7F, 1, 5, 1, 0.0F, true));
            bone46 = new MModelRenderer(this);
            bone46.setRotationPoint(0.1F, -7.1F, 0.0F);
            this.setRotation(bone46, 0.1745F, -0.1745F, 0.0F);
            bone38.addChild(bone46);
            bone46.cubeList.add(new ModelBox(bone46, 26, 0, -2.25F, -4.0F, -1.75F, 1, 6, 1, 0.0F, true));
            bone47 = new MModelRenderer(this);
            bone47.setRotationPoint(0.1F, -7.1F, 0.0F);
            this.setRotation(bone47, 0.2618F, -0.1745F, -0.1745F);
            bone38.addChild(bone47);
            bone47.cubeList.add(new ModelBox(bone47, 26, 0, -1.5F, -4.0F, -2.0F, 1, 6, 1, 0.0F, true));
            bone48 = new MModelRenderer(this);
            bone48.setRotationPoint(0.1F, -7.1F, 0.0F);
            this.setRotation(bone48, 0.2618F, -0.4363F, -0.1745F);
            bone38.addChild(bone48);
            bone48.cubeList.add(new ModelBox(bone48, 26, 0, -1.5F, -4.0F, -2.0F, 1, 6, 1, 0.0F, true));
            BASE = new MModelRenderer(this);
            BASE.cubeList.add(new ModelBox(BASE, 12, 25, -3.25F, -4.2499F, -3.75F, 4, 1, 6, 0.0F, false));
            BASE.cubeList.add(new ModelBox(BASE, 12, 25, -0.75F, -4.25F, -2.25F, 4, 1, 6, 0.0F, true));
            BASE.cubeList.add(new ModelBox(BASE, 15, 23, -2.0F, -10.0F, -2.0F, 4, 5, 4, 0.0F, false));
            bone50 = new MModelRenderer(this);
            bone50.setRotationPoint(0.75F, -4.0F, -3.75F);
            this.setRotation(bone50, 0.0F, 1.0297F, 0.0F);
            BASE.addChild(bone50);
            bone50.cubeList.add(new ModelBox(bone50, 24, 22, -2.0F, -0.2502F, 0.0F, 2, 1, 2, 0.0F, false));
            bone50.cubeList.add(new ModelBox(bone50, 24, 22, -7.2032F, -0.25F, -0.3384F, 1, 1, 2, 0.0F, false));
            bone50.cubeList.add(new ModelBox(bone50, 24, 22, -0.9982F, -0.2501F, 0.9155F, 1, 1, 2, 0.0F, false));
            bone50.cubeList.add(new ModelBox(bone50, 24, 22, -7.2013F, -0.2501F, 0.577F, 2, 1, 2, 0.0F, false));
            ICEHAND1 = new MModelRenderer(this);
            bone52 = new MModelRenderer(this);
            bone52.setRotationPoint(-2.85F, -10.0F, 0.0F);
            this.setRotation(bone52, 0.0F, 0.0F, 0.2618F);
            ICEHAND1.addChild(bone52);
            bone52.cubeList.add(new ModelBox(bone52, 24, 0, -1.2352F, -3.9389F, 0.0F, 1, 4, 1, 0.0F, false));
            bone53 = new MModelRenderer(this);
            bone53.setRotationPoint(1.0F, 0.0F, 0.0F);
            this.setRotation(bone53, 0.0F, 0.0F, -1.1345F);
            bone52.addChild(bone53);
            bone53.cubeList.add(new ModelBox(bone53, 24, 0, -1.0F, -2.0F, 0.001F, 1, 4, 1, 0.0F, false));
            bone54 = new MModelRenderer(this);
            bone54.setRotationPoint(-2.6F, -10.0F, -1.15F);
            this.setRotation(bone54, -0.0873F, -0.6109F, 0.3491F);
            ICEHAND1.addChild(bone54);
            bone54.cubeList.add(new ModelBox(bone54, 24, 0, -1.2352F, -3.9389F, 0.0F, 1, 4, 1, 0.0F, false));
            bone55 = new MModelRenderer(this);
            bone55.setRotationPoint(1.0F, 0.0F, 0.0F);
            this.setRotation(bone55, 0.0F, 0.0F, -1.1345F);
            bone54.addChild(bone55);
            bone55.cubeList.add(new ModelBox(bone55, 24, 0, -1.0F, -2.0F, -1.0E-4F, 1, 3, 1, 0.0F, false));
            bone25 = new MModelRenderer(this);
            bone25.setRotationPoint(-3.65F, -10.0F, 0.45F);
            this.setRotation(bone25, 0.2967F, ((float)Math.PI * 2F / 9F), 0.4887F);
            ICEHAND1.addChild(bone25);
            bone25.cubeList.add(new ModelBox(bone25, 24, 0, -1.2352F, -2.9389F, 0.0F, 1, 3, 1, 0.0F, false));
            bone49 = new MModelRenderer(this);
            bone49.setRotationPoint(1.0F, 0.0F, 0.0F);
            this.setRotation(bone49, 0.0F, 0.0F, -1.1345F);
            bone25.addChild(bone49);
            bone49.cubeList.add(new ModelBox(bone49, 24, 0, -1.0F, -2.0F, 1.0E-4F, 1, 5, 1, 0.0F, false));
            bone58 = new MModelRenderer(this);
            bone58.setRotationPoint(-2.2F, -9.5F, -1.8F);
            this.setRotation(bone58, -0.2618F, -0.8727F, 0.4363F);
            ICEHAND1.addChild(bone58);
            bone58.cubeList.add(new ModelBox(bone58, 24, 0, -1.2352F, -3.9389F, 0.0F, 1, 4, 1, 0.0F, false));
            bone59 = new MModelRenderer(this);
            bone59.setRotationPoint(1.0F, 0.0F, 0.0F);
            this.setRotation(bone59, 0.0F, 0.0F, -1.1345F);
            bone58.addChild(bone59);
            bone59.cubeList.add(new ModelBox(bone59, 24, 0, -1.0F, -2.0F, -0.001F, 1, 3, 1, 0.0F, false));
            bone60 = new MModelRenderer(this);
            bone60.setRotationPoint(-3.15F, -9.75F, 0.45F);
            this.setRotation(bone60, 0.6109F, 1.0472F, 0.8727F);
            ICEHAND1.addChild(bone60);
            bone60.cubeList.add(new ModelBox(bone60, 24, 0, -1.9852F, -2.4389F, 0.0F, 1, 3, 1, 0.0F, false));
            bone61 = new MModelRenderer(this);
            bone61.setRotationPoint(1.0F, 0.0F, 0.0F);
            this.setRotation(bone61, 0.0F, 0.0F, -1.4835F);
            bone60.addChild(bone61);
            bone61.cubeList.add(new ModelBox(bone61, 24, 0, -0.8191F, -2.925F, 1.0E-4F, 1, 2, 1, 0.0F, false));
            bone56 = new MModelRenderer(this);
            bone56.setRotationPoint(-3.2F, -10.4F, -1.1F);
            this.setRotation(bone56, 0.0F, ((float)Math.PI * 2F / 9F), 0.2618F);
            ICEHAND1.addChild(bone56);
            bone56.cubeList.add(new ModelBox(bone56, 24, 0, -1.2352F, -3.9389F, 0.05F, 1, 4, 1, 0.0F, false));
            bone57 = new MModelRenderer(this);
            bone57.setRotationPoint(1.0F, 0.0F, 0.0F);
            this.setRotation(bone57, 0.0F, 0.0F, -1.1345F);
            bone56.addChild(bone57);
            bone57.cubeList.add(new ModelBox(bone57, 24, 0, -1.0F, -2.0F, 0.049F, 1, 1, 1, 0.0F, false));
            ICEHAND2 = new MModelRenderer(this);
            ICEHAND2.setRotationPoint(0.0F, -10.0F, 0.0F);
            this.setRotation(ICEHAND2, 0.0F, 0.0F, 0.3491F);
            bone63 = new MModelRenderer(this);
            bone63.setRotationPoint(2.85F, -2.0F, 0.0F);
            this.setRotation(bone63, 0.0F, 0.0F, 0.2618F);
            ICEHAND2.addChild(bone63);
            bone63.cubeList.add(new ModelBox(bone63, 28, 0, 0.2352F, -0.0611F, -1.0F, 1, 4, 1, 0.0F, true));
            bone65 = new MModelRenderer(this);
            bone65.setRotationPoint(2.6F, -2.0F, 1.25F);
            this.setRotation(bone65, -0.0873F, -0.6109F, 0.3491F);
            ICEHAND2.addChild(bone65);
            bone65.cubeList.add(new ModelBox(bone65, 28, 0, 0.2352F, -0.0611F, -1.0F, 1, 4, 1, 0.0F, true));
            bone67 = new MModelRenderer(this);
            bone67.setRotationPoint(3.65F, -2.0F, -0.45F);
            this.setRotation(bone67, 0.3491F, ((float)Math.PI * 2F / 9F), 0.5236F);
            ICEHAND2.addChild(bone67);
            bone67.cubeList.add(new ModelBox(bone67, 28, 0, 0.2352F, -0.0611F, -1.0F, 1, 4, 1, 0.0F, true));
            bone69 = new MModelRenderer(this);
            bone69.setRotationPoint(2.2F, -2.5F, 1.8F);
            this.setRotation(bone69, -0.2618F, -0.8727F, 0.4363F);
            ICEHAND2.addChild(bone69);
            bone69.cubeList.add(new ModelBox(bone69, 28, 0, 0.2352F, 0.9389F, -1.0F, 1, 3, 1, 0.0F, true));
            bone71 = new MModelRenderer(this);
            bone71.setRotationPoint(3.15F, -2.25F, -0.45F);
            this.setRotation(bone71, 0.6109F, 1.0472F, 0.8727F);
            ICEHAND2.addChild(bone71);
            bone71.cubeList.add(new ModelBox(bone71, 28, 0, 0.9852F, -0.5611F, -1.0F, 1, 3, 1, 0.0F, true));
            bone73 = new MModelRenderer(this);
            bone73.setRotationPoint(3.1F, -1.5F, 1.0F);
            this.setRotation(bone73, 0.0F, 0.6109F, 0.2618F);
            ICEHAND2.addChild(bone73);
            bone73.cubeList.add(new ModelBox(bone73, 28, 0, 0.2352F, -0.0611F, -1.0F, 1, 4, 1, 0.0F, true));
        }

        this.setTexture(new ResourceLocation("minidot:pets/bedwars_2020_" + type + ".png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        float f1 = time * 1.5F;
        GlStateManager.translate(0.7F, 0.0F + f, 0.5F);
        GlStateManager.rotate(90.0F + f1, 0.0F, 1.0F, 0.0F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.42F, 0.0F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.type;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -1380612710:
                if (s.equals("bronze"))
                {
                    b0 = 2;
                }

                break;

            case -902311155:
                if (s.equals("silver"))
                {
                    b0 = 3;
                }

                break;

            case 104075:
                if (s.equals("ice"))
                {
                    b0 = 5;
                }

                break;

            case 3178592:
                if (s.equals("gold"))
                {
                    b0 = 4;
                }

                break;

            case 109770853:
                if (s.equals("stone"))
                {
                    b0 = 1;
                }

                break;

            case 853620882:
                if (s.equals("classic"))
                {
                    b0 = 0;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u041a\u0440\u043e\u0432\u0430\u0442\u043a\u0430";

            case 1:
                return "\u041a\u0430\u043c\u0435\u043d\u043d\u0430\u044f \u043a\u0440\u043e\u0432\u0430\u0442\u043a\u0430";

            case 2:
                return "\u0411\u0440\u043e\u043d\u0437\u043e\u0432\u0430\u044f \u043a\u0440\u043e\u0432\u0430\u0442\u043a\u0430";

            case 3:
                return "\u0421\u0435\u0440\u0435\u0431\u0440\u044f\u043d\u0430\u044f \u043a\u0440\u043e\u0432\u0430\u0442\u043a\u0430";

            case 4:
                return "\u0417\u043e\u043b\u043e\u0442\u0430\u044f \u043a\u0440\u043e\u0432\u0430\u0442\u043a\u0430";

            case 5:
                return "\u041b\u0435\u0434\u044f\u043d\u0430\u044f \u043a\u0440\u043e\u0432\u0430\u0442\u043a\u0430";

            default:
                return "\u0419\u0443\u0445";
        }
    }

    public List<String> getDescription()
    {
        String s = this.type;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -1380612710:
                if (s.equals("bronze"))
                {
                    b0 = 2;
                }

                break;

            case -902311155:
                if (s.equals("silver"))
                {
                    b0 = 3;
                }

                break;

            case 104075:
                if (s.equals("ice"))
                {
                    b0 = 5;
                }

                break;

            case 3178592:
                if (s.equals("gold"))
                {
                    b0 = 4;
                }

                break;

            case 109770853:
                if (s.equals("stone"))
                {
                    b0 = 1;
                }

                break;

            case 853620882:
                if (s.equals("classic"))
                {
                    b0 = 0;
                }
        }

        switch (b0)
        {
            case 0:
                return Collections.<String>singletonList("\u0417\u0430 \u0443\u0447\u0430\u0441\u0442\u0438\u0435 \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars Hard [\u0417\u0438\u043c\u0430 2020]");

            case 1:
                return Collections.<String>singletonList("\u0417\u0430 \u043f\u043e\u043f\u0430\u0434\u0430\u043d\u0438\u0435 \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u043d\u0443\u044e \u0441\u0435\u0442\u043a\u0443 " + EnumChatFormatting.AQUA + "BedWars Hard [\u0417\u0438\u043c\u0430 2020]");

            case 2:
                return Collections.<String>singletonList("\u0417\u0430 \u0442\u0440\u0435\u0442\u044c\u0435 \u043c\u0435\u0441\u0442\u043e \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars Hard [\u0417\u0438\u043c\u0430 2020]");

            case 3:
                return Collections.<String>singletonList("\u0417\u0430 \u0432\u0442\u043e\u0440\u043e\u0435 \u043c\u0435\u0441\u0442\u043e \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars Hard [\u0417\u0438\u043c\u0430 2020]");

            case 4:
                return Collections.<String>singletonList("\u0417\u0430 \u043f\u043e\u0431\u0435\u0434\u0443 \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars Hard [\u0417\u0438\u043c\u0430 2020]");

            case 5:
                return Collections.<String>singletonList("\u0417\u0430 \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u044e \u0442\u0443\u0440\u043d\u0438\u0440\u0430 " + EnumChatFormatting.AQUA + "BedWars Hard [\u0417\u0438\u043c\u0430 2020]");

            default:
                return null;
        }
    }
}
