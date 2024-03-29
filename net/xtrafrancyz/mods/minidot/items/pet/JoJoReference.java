package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class JoJoReference extends BasePet
{
    private final MModelRenderer bone;
    private final MModelRenderer cube_r1;
    private final MModelRenderer cube_r2;
    private final MModelRenderer cube_r3;
    private final MModelRenderer cube_r4;
    private final MModelRenderer cube_r5;
    private final MModelRenderer cube_r6;
    private final MModelRenderer cube_r7;
    private final MModelRenderer bone2;
    private final MModelRenderer cube_r8;
    private final MModelRenderer cube_r9;
    private final MModelRenderer cube_r10;
    private final MModelRenderer cube_r11;
    private final MModelRenderer cube_r12;
    private final MModelRenderer cube_r13;
    private final MModelRenderer cube_r14;
    private final MModelRenderer bone3;
    private final MModelRenderer cube_r15;
    private final MModelRenderer cube_r16;
    private final MModelRenderer cube_r17;
    private final MModelRenderer cube_r18;
    private final MModelRenderer cube_r19;
    private final MModelRenderer cube_r20;
    private final MModelRenderer cube_r21;
    private final MModelRenderer bone4;
    private final MModelRenderer cube_r22;
    private final MModelRenderer cube_r23;
    private final MModelRenderer cube_r24;
    private final MModelRenderer cube_r25;
    private final MModelRenderer cube_r26;
    private final MModelRenderer cube_r27;
    private final MModelRenderer cube_r28;
    private final IAnimation anim;

    public JoJoReference()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.575F, 24.0F, 0.0F);
        this.bone.setTextureOffset(7, 7).addBox(-0.775F, -4.675F, 0.0F, 3, 1, 1, -0.3F);
        this.cube_r1 = new MModelRenderer(this);
        this.cube_r1.setRotationPoint(0.725F, -4.025F, 0.5F);
        this.bone.addChild(this.cube_r1);
        this.setRotation(this.cube_r1, 0.0F, 0.0F, -0.0916F);
        this.cube_r1.setTextureOffset(7, 5).addBox(-1.5F, -0.4F, -0.5F, 3, 1, 1, -0.3F);
        this.cube_r2 = new MModelRenderer(this);
        this.cube_r2.setRotationPoint(1.725F, -5.9F, 0.5F);
        this.bone.addChild(this.cube_r2);
        this.setRotation(this.cube_r2, 0.0F, 0.0F, 0.0873F);
        this.cube_r2.setTextureOffset(3, 19).addBox(-0.6F, -0.725F, -0.5F, 1, 3, 1, -0.325F);
        this.cube_r2.setTextureOffset(14, 19).addBox(-0.35F, -0.725F, -0.5F, 1, 3, 1, -0.325F);
        this.cube_r3 = new MModelRenderer(this);
        this.cube_r3.setRotationPoint(0.985F, -5.1868F, 0.5F);
        this.bone.addChild(this.cube_r3);
        this.setRotation(this.cube_r3, 0.0F, 0.0F, 1.1476F);
        this.cube_r3.setTextureOffset(19, 1).addBox(-1.325F, -1.4F, -0.5F, 1, 3, 1, -0.3F);
        this.cube_r3.setTextureOffset(28, 17).addBox(-1.325F, -1.8F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r3.setTextureOffset(28, 19).addBox(-1.1F, -1.8F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r3.setTextureOffset(7, 19).addBox(-1.1F, -1.725F, -0.5F, 1, 3, 1, -0.3F);
        this.cube_r4 = new MModelRenderer(this);
        this.cube_r4.setRotationPoint(0.0835F, -5.9238F, 0.5F);
        this.bone.addChild(this.cube_r4);
        this.setRotation(this.cube_r4, 0.0F, 0.0F, 2.2864F);
        this.cube_r4.setTextureOffset(18, 5).addBox(-0.975F, -0.4F, -0.5F, 2, 1, 1, -0.325F);
        this.cube_r5 = new MModelRenderer(this);
        this.cube_r5.setRotationPoint(1.3239F, -7.0865F, 0.5F);
        this.bone.addChild(this.cube_r5);
        this.setRotation(this.cube_r5, 0.0F, 0.0F, 2.3213F);
        this.cube_r5.setTextureOffset(27, 9).addBox(-1.5F, -1.875F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r5.setTextureOffset(25, 27).addBox(-1.65F, -1.0F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r5.setTextureOffset(3, 27).addBox(-1.65F, -1.775F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r5.setTextureOffset(10, 28).addBox(-1.8F, -0.9F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r5.setTextureOffset(7, 27).addBox(-1.25F, -1.875F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r5.setTextureOffset(27, 23).addBox(-1.4F, -1.0F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r5.setTextureOffset(27, 11).addBox(-1.4F, -1.775F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r5.setTextureOffset(28, 13).addBox(-1.55F, -0.9F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r5.setTextureOffset(19, 27).addBox(-0.925F, -1.875F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r5.setTextureOffset(0, 28).addBox(-1.075F, -1.0F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r5.setTextureOffset(13, 27).addBox(-1.075F, -1.775F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r5.setTextureOffset(28, 15).addBox(-1.225F, -0.9F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r6 = new MModelRenderer(this);
        this.cube_r6.setRotationPoint(-0.2267F, -5.3812F, 0.5F);
        this.bone.addChild(this.cube_r6);
        this.setRotation(this.cube_r6, 0.0F, 0.0F, 2.09F);
        this.cube_r6.setTextureOffset(18, 9).addBox(-1.625F, -0.55F, -0.5F, 2, 1, 1, -0.325F);
        this.cube_r7 = new MModelRenderer(this);
        this.cube_r7.setRotationPoint(-0.1914F, -5.4246F, 0.5F);
        this.bone.addChild(this.cube_r7);
        this.setRotation(this.cube_r7, 0.0F, 0.0F, 1.789F);
        this.cube_r7.setTextureOffset(16, 28).addBox(-0.45F, -0.475F, -0.5F, 1, 1, 1, -0.3F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-2.875F, 19.775F, 1.85F);
        this.bone2.setTextureOffset(7, 3).addBox(-0.775F, -4.675F, 0.0F, 3, 1, 1, -0.3F);
        this.cube_r8 = new MModelRenderer(this);
        this.cube_r8.setRotationPoint(0.725F, -4.025F, 0.5F);
        this.bone2.addChild(this.cube_r8);
        this.setRotation(this.cube_r8, 0.0F, 0.0F, -0.0916F);
        this.cube_r8.setTextureOffset(7, 1).addBox(-1.5F, -0.4F, -0.5F, 3, 1, 1, -0.3F);
        this.cube_r9 = new MModelRenderer(this);
        this.cube_r9.setRotationPoint(1.725F, -5.9F, 0.5F);
        this.bone2.addChild(this.cube_r9);
        this.setRotation(this.cube_r9, 0.0F, 0.0F, 0.0873F);
        this.cube_r9.setTextureOffset(15, 15).addBox(-0.6F, -0.725F, -0.5F, 1, 3, 1, -0.325F);
        this.cube_r9.setTextureOffset(18, 18).addBox(-0.35F, -0.725F, -0.5F, 1, 3, 1, -0.325F);
        this.cube_r10 = new MModelRenderer(this);
        this.cube_r10.setRotationPoint(0.985F, -5.1868F, 0.5F);
        this.bone2.addChild(this.cube_r10);
        this.setRotation(this.cube_r10, 0.0F, 0.0F, 1.1476F);
        this.cube_r10.setTextureOffset(0, 16).addBox(-1.325F, -1.4F, -0.5F, 1, 3, 1, -0.3F);
        this.cube_r10.setTextureOffset(13, 25).addBox(-1.325F, -1.8F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r10.setTextureOffset(26, 25).addBox(-1.1F, -1.8F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r10.setTextureOffset(11, 16).addBox(-1.1F, -1.725F, -0.5F, 1, 3, 1, -0.3F);
        this.cube_r11 = new MModelRenderer(this);
        this.cube_r11.setRotationPoint(0.0835F, -5.9238F, 0.5F);
        this.bone2.addChild(this.cube_r11);
        this.setRotation(this.cube_r11, 0.0F, 0.0F, 2.2864F);
        this.cube_r11.setTextureOffset(16, 12).addBox(-0.975F, -0.4F, -0.5F, 2, 1, 1, -0.325F);
        this.cube_r12 = new MModelRenderer(this);
        this.cube_r12.setRotationPoint(1.3239F, -7.0865F, 0.5F);
        this.bone2.addChild(this.cube_r12);
        this.setRotation(this.cube_r12, 0.0F, 0.0F, 2.3213F);
        this.cube_r12.setTextureOffset(25, 14).addBox(-1.5F, -1.875F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r12.setTextureOffset(25, 16).addBox(-1.65F, -1.0F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r12.setTextureOffset(25, 18).addBox(-1.65F, -1.775F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r12.setTextureOffset(19, 25).addBox(-1.8F, -0.9F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r12.setTextureOffset(25, 20).addBox(-1.25F, -1.875F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r12.setTextureOffset(0, 26).addBox(-1.4F, -1.0F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r12.setTextureOffset(26, 0).addBox(-1.4F, -1.775F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r12.setTextureOffset(26, 3).addBox(-1.55F, -0.9F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r12.setTextureOffset(26, 5).addBox(-0.925F, -1.875F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r12.setTextureOffset(26, 7).addBox(-1.075F, -1.0F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r12.setTextureOffset(10, 26).addBox(-1.075F, -1.775F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r12.setTextureOffset(16, 26).addBox(-1.225F, -0.9F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r13 = new MModelRenderer(this);
        this.cube_r13.setRotationPoint(-0.2267F, -5.3812F, 0.5F);
        this.bone2.addChild(this.cube_r13);
        this.setRotation(this.cube_r13, 0.0F, 0.0F, 2.09F);
        this.cube_r13.setTextureOffset(4, 17).addBox(-1.625F, -0.55F, -0.5F, 2, 1, 1, -0.325F);
        this.cube_r14 = new MModelRenderer(this);
        this.cube_r14.setRotationPoint(-0.1914F, -5.4246F, 0.5F);
        this.bone2.addChild(this.cube_r14);
        this.setRotation(this.cube_r14, 0.0F, 0.0F, 1.789F);
        this.cube_r14.setTextureOffset(22, 26).addBox(-0.45F, -0.475F, -0.5F, 1, 1, 1, -0.3F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-4.95F, 25.175F, -0.025F);
        this.bone3.setTextureOffset(0, 6).addBox(-0.775F, -4.675F, 0.0F, 3, 1, 1, -0.3F);
        this.cube_r15 = new MModelRenderer(this);
        this.cube_r15.setRotationPoint(0.725F, -4.025F, 0.5F);
        this.bone3.addChild(this.cube_r15);
        this.setRotation(this.cube_r15, 0.0F, 0.0F, -0.0916F);
        this.cube_r15.setTextureOffset(0, 4).addBox(-1.5F, -0.4F, -0.5F, 3, 1, 1, -0.3F);
        this.cube_r16 = new MModelRenderer(this);
        this.cube_r16.setRotationPoint(1.725F, -5.9F, 0.5F);
        this.bone3.addChild(this.cube_r16);
        this.setRotation(this.cube_r16, 0.0F, 0.0F, 0.0873F);
        this.cube_r16.setTextureOffset(12, 12).addBox(-0.6F, -0.725F, -0.5F, 1, 3, 1, -0.325F);
        this.cube_r16.setTextureOffset(15, 6).addBox(-0.35F, -0.725F, -0.5F, 1, 3, 1, -0.325F);
        this.cube_r17 = new MModelRenderer(this);
        this.cube_r17.setRotationPoint(0.985F, -5.1868F, 0.5F);
        this.bone3.addChild(this.cube_r17);
        this.setRotation(this.cube_r17, 0.0F, 0.0F, 1.1476F);
        this.cube_r17.setTextureOffset(8, 13).addBox(-1.325F, -1.4F, -0.5F, 1, 3, 1, -0.3F);
        this.cube_r17.setTextureOffset(23, 4).addBox(-1.325F, -1.8F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r17.setTextureOffset(7, 25).addBox(-1.1F, -1.8F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r17.setTextureOffset(15, 2).addBox(-1.1F, -1.725F, -0.5F, 1, 3, 1, -0.3F);
        this.cube_r18 = new MModelRenderer(this);
        this.cube_r18.setRotationPoint(0.0835F, -5.9238F, 0.5F);
        this.bone3.addChild(this.cube_r18);
        this.setRotation(this.cube_r18, 0.0F, 0.0F, 2.2864F);
        this.cube_r18.setTextureOffset(13, 10).addBox(-0.975F, -0.4F, -0.5F, 2, 1, 1, -0.325F);
        this.cube_r19 = new MModelRenderer(this);
        this.cube_r19.setRotationPoint(1.3239F, -7.0865F, 0.5F);
        this.bone3.addChild(this.cube_r19);
        this.setRotation(this.cube_r19, 0.0F, 0.0F, 2.3213F);
        this.cube_r19.setTextureOffset(23, 6).addBox(-1.5F, -1.875F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r19.setTextureOffset(7, 23).addBox(-1.65F, -1.0F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r19.setTextureOffset(23, 8).addBox(-1.65F, -1.775F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r19.setTextureOffset(13, 23).addBox(-1.8F, -0.9F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r19.setTextureOffset(20, 23).addBox(-1.25F, -1.875F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r19.setTextureOffset(0, 24).addBox(-1.4F, -1.0F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r19.setTextureOffset(10, 24).addBox(-1.4F, -1.775F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r19.setTextureOffset(24, 10).addBox(-1.55F, -0.9F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r19.setTextureOffset(24, 12).addBox(-0.925F, -1.875F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r19.setTextureOffset(16, 24).addBox(-1.075F, -1.0F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r19.setTextureOffset(24, 22).addBox(-1.075F, -1.775F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r19.setTextureOffset(23, 24).addBox(-1.225F, -0.9F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r20 = new MModelRenderer(this);
        this.cube_r20.setRotationPoint(-0.2267F, -5.3812F, 0.5F);
        this.bone3.addChild(this.cube_r20);
        this.setRotation(this.cube_r20, 0.0F, 0.0F, 2.09F);
        this.cube_r20.setTextureOffset(14, 0).addBox(-1.625F, -0.55F, -0.5F, 2, 1, 1, -0.325F);
        this.cube_r21 = new MModelRenderer(this);
        this.cube_r21.setRotationPoint(-0.1914F, -5.4246F, 0.5F);
        this.bone3.addChild(this.cube_r21);
        this.setRotation(this.cube_r21, 0.0F, 0.0F, 1.789F);
        this.cube_r21.setTextureOffset(3, 25).addBox(-0.45F, -0.475F, -0.5F, 1, 1, 1, -0.3F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(1.75F, 18.15F, 1.7F);
        this.bone4.setTextureOffset(0, 2).addBox(-0.775F, -4.675F, 0.0F, 3, 1, 1, -0.3F);
        this.cube_r22 = new MModelRenderer(this);
        this.cube_r22.setRotationPoint(0.725F, -4.025F, 0.5F);
        this.bone4.addChild(this.cube_r22);
        this.setRotation(this.cube_r22, 0.0F, 0.0F, -0.0916F);
        this.cube_r22.setTextureOffset(0, 0).addBox(-1.5F, -0.4F, -0.5F, 3, 1, 1, -0.3F);
        this.cube_r23 = new MModelRenderer(this);
        this.cube_r23.setRotationPoint(1.725F, -5.9F, 0.5F);
        this.bone4.addChild(this.cube_r23);
        this.setRotation(this.cube_r23, 0.0F, 0.0F, 0.0873F);
        this.cube_r23.setTextureOffset(0, 8).addBox(-0.6F, -0.725F, -0.5F, 1, 3, 1, -0.325F);
        this.cube_r23.setTextureOffset(4, 12).addBox(-0.35F, -0.725F, -0.5F, 1, 3, 1, -0.325F);
        this.cube_r24 = new MModelRenderer(this);
        this.cube_r24.setRotationPoint(0.985F, -5.1868F, 0.5F);
        this.bone4.addChild(this.cube_r24);
        this.setRotation(this.cube_r24, 0.0F, 0.0F, 1.1476F);
        this.cube_r24.setTextureOffset(4, 8).addBox(-1.325F, -1.4F, -0.5F, 1, 3, 1, -0.3F);
        this.cube_r24.setTextureOffset(18, 14).addBox(-1.325F, -1.8F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r24.setTextureOffset(3, 23).addBox(-1.1F, -1.8F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r24.setTextureOffset(0, 12).addBox(-1.1F, -1.725F, -0.5F, 1, 3, 1, -0.3F);
        this.cube_r25 = new MModelRenderer(this);
        this.cube_r25.setRotationPoint(0.0835F, -5.9238F, 0.5F);
        this.bone4.addChild(this.cube_r25);
        this.setRotation(this.cube_r25, 0.0F, 0.0F, 2.2864F);
        this.cube_r25.setTextureOffset(8, 9).addBox(-0.975F, -0.4F, -0.5F, 2, 1, 1, -0.325F);
        this.cube_r26 = new MModelRenderer(this);
        this.cube_r26.setRotationPoint(1.3239F, -7.0865F, 0.5F);
        this.bone4.addChild(this.cube_r26);
        this.setRotation(this.cube_r26, 0.0F, 0.0F, 2.3213F);
        this.cube_r26.setTextureOffset(19, 7).addBox(-1.5F, -1.875F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r26.setTextureOffset(19, 16).addBox(-1.65F, -1.0F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r26.setTextureOffset(21, 11).addBox(-1.65F, -1.775F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r26.setTextureOffset(21, 13).addBox(-1.8F, -0.9F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r26.setTextureOffset(21, 21).addBox(-1.25F, -1.875F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r26.setTextureOffset(0, 22).addBox(-1.4F, -1.0F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r26.setTextureOffset(22, 0).addBox(-1.4F, -1.775F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r26.setTextureOffset(10, 22).addBox(-1.55F, -0.9F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r26.setTextureOffset(22, 15).addBox(-0.925F, -1.875F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r26.setTextureOffset(17, 22).addBox(-1.075F, -1.0F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r26.setTextureOffset(22, 17).addBox(-1.075F, -1.775F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r26.setTextureOffset(22, 19).addBox(-1.225F, -0.9F, -0.5F, 1, 1, 1, -0.3F);
        this.cube_r27 = new MModelRenderer(this);
        this.cube_r27.setRotationPoint(-0.2267F, -5.3812F, 0.5F);
        this.bone4.addChild(this.cube_r27);
        this.setRotation(this.cube_r27, 0.0F, 0.0F, 2.09F);
        this.cube_r27.setTextureOffset(7, 11).addBox(-1.625F, -0.55F, -0.5F, 2, 1, 1, -0.325F);
        this.cube_r28 = new MModelRenderer(this);
        this.cube_r28.setRotationPoint(-0.1914F, -5.4246F, 0.5F);
        this.bone4.addChild(this.cube_r28);
        this.setRotation(this.cube_r28, 0.0F, 0.0F, 1.789F);
        this.cube_r28.setTextureOffset(23, 2).addBox(-0.45F, -0.475F, -0.5F, 1, 1, 1, -0.3F);
        this.setTexture(new ResourceLocation("minidot", "pets/jojoreference.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/jojoreference_animation.json"));
        this.anim = bbanimationloader.mustGet("jojoreference.anim", this);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.translate(0.65F, -1.2F - f, 0.2F);
        float f1 = 1.6F;
        GlStateManager.scale(f1, f1, f1);
        this.anim.tick(time);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(MathHelper.sin(rotation * 0.06F + (float)number * 0.5F) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, -0.8D, 0.0D);
        float f = 1.6F;
        GlStateManager.scale(f, f, f);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "GUllT";
    }

    public String getName()
    {
        return "JoJo Reference";
    }
}
