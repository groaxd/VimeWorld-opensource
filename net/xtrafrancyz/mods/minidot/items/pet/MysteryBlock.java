package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class MysteryBlock extends BasePet
{
    private final MModelRenderer block;
    private final MModelRenderer bone;
    private final MModelRenderer bone22;
    private final MModelRenderer bone23;
    private final MModelRenderer bone24;
    private final MModelRenderer bone25;
    private final MModelRenderer bone38;
    private final MModelRenderer bone37;
    private final MModelRenderer bone36;
    private final MModelRenderer bone35;
    private final MModelRenderer bone34;
    private final MModelRenderer bone33;
    private final MModelRenderer bone32;
    private final MModelRenderer bone31;
    private final MModelRenderer bone30;
    private final MModelRenderer bone29;
    private final MModelRenderer bone28;
    private final MModelRenderer bone27;
    private final MModelRenderer bone26;
    private final MModelRenderer bone39;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final MModelRenderer bone16;
    private final MModelRenderer bone17;
    private final MModelRenderer bone18;
    private final MModelRenderer bone19;
    private final MModelRenderer bone20;
    private final MModelRenderer bone21;
    private final MModelRenderer money;
    private final IAnimation anim;

    public MysteryBlock()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.block = new MModelRenderer(this);
        this.block.setRotationPoint(0.0F, 26.0F, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -2.5F, 0.0F);
        this.block.addChild(this.bone);
        this.bone.setTextureOffset(0, 54).addBox(-4.5F, -11.0F, -4.5F, 9, 1, 9, 0.0F);
        this.bone.setTextureOffset(0, 54).addBox(-4.5F, -1.0F, -4.5F, 9, 1, 9, 0.0F);
        this.bone.setTextureOffset(44, 36).addBox(-5.5F, -10.0F, -4.5F, 1, 9, 9, 0.0F);
        this.bone.setTextureOffset(44, 36).addBox(4.5F, -10.0F, -4.5F, 1, 9, 9, 0.0F);
        this.bone.setTextureOffset(44, 54).addBox(-4.5F, -10.0F, -5.5F, 9, 9, 1, 0.0F);
        this.bone.setTextureOffset(44, 54).addBox(-4.5F, -10.0F, 4.5F, 9, 9, 1, 0.0F);
        this.bone22 = new MModelRenderer(this);
        this.bone22.setRotationPoint(0.0F, 0.0F, -0.5F);
        this.bone.addChild(this.bone22);
        this.bone22.setTextureOffset(36, 62).addBox(-4.25F, -9.75F, -5.25F, 1, 1, 1, 0.0F);
        this.bone22.setTextureOffset(36, 62).addBox(3.25F, -9.75F, -5.25F, 1, 1, 1, 0.0F);
        this.bone22.setTextureOffset(36, 62).addBox(3.25F, -2.25F, -5.25F, 1, 1, 1, 0.0F);
        this.bone22.setTextureOffset(36, 62).addBox(-4.25F, -2.25F, -5.25F, 1, 1, 1, 0.0F);
        this.bone23 = new MModelRenderer(this);
        this.bone23.setRotationPoint(-0.5F, 0.0F, 0.0F);
        this.bone.addChild(this.bone23);
        this.setRotation(this.bone23, 0.0F, 1.5708F, 0.0F);
        this.bone23.setTextureOffset(36, 62).addBox(-4.25F, -9.75F, -5.25F, 1, 1, 1, 0.0F);
        this.bone23.setTextureOffset(36, 62).addBox(3.25F, -9.75F, -5.25F, 1, 1, 1, 0.0F);
        this.bone23.setTextureOffset(36, 62).addBox(3.25F, -2.25F, -5.25F, 1, 1, 1, 0.0F);
        this.bone23.setTextureOffset(36, 62).addBox(-4.25F, -2.25F, -5.25F, 1, 1, 1, 0.0F);
        this.bone24 = new MModelRenderer(this);
        this.bone24.setRotationPoint(0.0F, 0.0F, 0.5F);
        this.bone.addChild(this.bone24);
        this.setRotation(this.bone24, 0.0F, 3.1416F, 0.0F);
        this.bone24.setTextureOffset(36, 62).addBox(-4.25F, -9.75F, -5.25F, 1, 1, 1, 0.0F);
        this.bone24.setTextureOffset(36, 62).addBox(3.25F, -9.75F, -5.25F, 1, 1, 1, 0.0F);
        this.bone24.setTextureOffset(36, 62).addBox(3.25F, -2.25F, -5.25F, 1, 1, 1, 0.0F);
        this.bone24.setTextureOffset(36, 62).addBox(-4.25F, -2.25F, -5.25F, 1, 1, 1, 0.0F);
        this.bone25 = new MModelRenderer(this);
        this.bone25.setRotationPoint(0.5F, 0.0F, 0.0F);
        this.bone.addChild(this.bone25);
        this.setRotation(this.bone25, 0.0F, -1.5708F, 0.0F);
        this.bone25.setTextureOffset(36, 62).addBox(-4.25F, -9.75F, -5.25F, 1, 1, 1, 0.0F);
        this.bone25.setTextureOffset(36, 62).addBox(3.25F, -9.75F, -5.25F, 1, 1, 1, 0.0F);
        this.bone25.setTextureOffset(36, 62).addBox(3.25F, -2.25F, -5.25F, 1, 1, 1, 0.0F);
        this.bone25.setTextureOffset(35, 62).addBox(-4.25F, -2.25F, -5.25F, 1, 1, 1, 0.0F);
        this.bone38 = new MModelRenderer(this);
        this.bone38.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.block.addChild(this.bone38);
        this.bone37 = new MModelRenderer(this);
        this.bone37.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone38.addChild(this.bone37);
        this.setRotation(this.bone37, 0.0F, 2.3562F, 0.0F);
        this.bone37.setTextureOffset(40, 54).addBox(-0.7071F, -12.5F, 6.0711F, 1, 9, 1, 0.0F);
        this.bone37.setTextureOffset(40, 54).addBox(-0.2929F, -12.5F, 6.0711F, 1, 9, 1, 0.0F);
        this.bone36 = new MModelRenderer(this);
        this.bone36.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone38.addChild(this.bone36);
        this.setRotation(this.bone36, 0.0F, -0.7854F, 0.0F);
        this.bone36.setTextureOffset(40, 54).addBox(-0.7071F, -12.5F, 6.0711F, 1, 9, 1, 0.0F);
        this.bone36.setTextureOffset(40, 54).addBox(-0.2929F, -12.5F, 6.0711F, 1, 9, 1, 0.0F);
        this.bone35 = new MModelRenderer(this);
        this.bone35.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.bone38.addChild(this.bone35);
        this.setRotation(this.bone35, 0.0F, 0.7854F, 0.0F);
        this.bone35.setTextureOffset(40, 54).addBox(1.4142F, -12.5F, -9.1924F, 1, 9, 1, 0.0F);
        this.bone35.setTextureOffset(40, 54).addBox(1.8284F, -12.5F, -9.1924F, 1, 9, 1, 0.0F);
        this.bone34 = new MModelRenderer(this);
        this.bone34.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone38.addChild(this.bone34);
        this.setRotation(this.bone34, 0.0F, 0.7854F, 0.0F);
        this.bone34.setTextureOffset(40, 54).addBox(-0.7071F, -12.5F, 6.0711F, 1, 9, 1, 0.0F);
        this.bone34.setTextureOffset(40, 54).addBox(-0.2929F, -12.5F, 6.0711F, 1, 9, 1, 0.0F);
        this.bone33 = new MModelRenderer(this);
        this.bone33.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone38.addChild(this.bone33);
        this.setRotation(this.bone33, 0.7854F, 0.0F, 0.0F);
        this.bone33.setTextureOffset(44, 34).addBox(-4.5F, 0.4142F, 4.9497F, 9, 1, 1, 0.0F);
        this.bone33.setTextureOffset(44, 34).addBox(-4.5F, 0.4142F, 5.364F, 9, 1, 1, 0.0F);
        this.bone32 = new MModelRenderer(this);
        this.bone32.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone38.addChild(this.bone32);
        this.setRotation(this.bone32, -0.7854F, 0.0F, 0.0F);
        this.bone32.setTextureOffset(44, 34).addBox(-4.5F, 0.4142F, -6.364F, 9, 1, 1, 0.0F);
        this.bone32.setTextureOffset(44, 34).addBox(-4.5F, 0.4142F, -5.9497F, 9, 1, 1, 0.0F);
        this.bone31 = new MModelRenderer(this);
        this.bone31.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone38.addChild(this.bone31);
        this.setRotation(this.bone31, 0.0F, 0.0F, -0.7854F);
        this.bone31.setTextureOffset(44, 24).addBox(-1.4142F, -6.364F, -4.5F, 1, 1, 9, 0.0F);
        this.bone31.setTextureOffset(44, 24).addBox(-1.4142F, -5.9497F, -4.5F, 1, 1, 9, 0.0F);
        this.bone30 = new MModelRenderer(this);
        this.bone30.setRotationPoint(13.0F, 0.0F, 0.0F);
        this.bone38.addChild(this.bone30);
        this.setRotation(this.bone30, 0.0F, 0.0F, 0.7854F);
        this.bone30.setTextureOffset(44, 24).addBox(-8.7782F, 2.8284F, -4.5F, 1, 1, 9, 0.0F);
        this.bone30.setTextureOffset(44, 24).addBox(-8.7782F, 3.2426F, -4.5F, 1, 1, 9, 0.0F);
        this.bone29 = new MModelRenderer(this);
        this.bone29.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone38.addChild(this.bone29);
        this.setRotation(this.bone29, 0.7854F, 0.0F, 0.0F);
        this.bone29.setTextureOffset(44, 34).addBox(-4.5F, -12.7279F, 4.9497F, 9, 1, 1, 0.0F);
        this.bone29.setTextureOffset(44, 34).addBox(-4.5F, -12.7279F, 5.364F, 9, 1, 1, 0.0F);
        this.bone28 = new MModelRenderer(this);
        this.bone28.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone38.addChild(this.bone28);
        this.setRotation(this.bone28, -0.7854F, 0.0F, 0.0F);
        this.bone28.setTextureOffset(44, 34).addBox(-4.5F, -12.7279F, -6.364F, 9, 1, 1, 0.0F);
        this.bone28.setTextureOffset(44, 34).addBox(-4.5F, -12.7279F, -5.9497F, 9, 1, 1, 0.0F);
        this.bone27 = new MModelRenderer(this);
        this.bone27.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone38.addChild(this.bone27);
        this.setRotation(this.bone27, 0.0F, 0.0F, -0.7854F);
        this.bone27.setTextureOffset(44, 24).addBox(11.7279F, -6.364F, -4.5F, 1, 1, 9, 0.0F);
        this.bone27.setTextureOffset(44, 24).addBox(11.7279F, -5.9497F, -4.5F, 1, 1, 9, 0.0F);
        this.bone26 = new MModelRenderer(this);
        this.bone26.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone38.addChild(this.bone26);
        this.setRotation(this.bone26, 0.0F, 0.0F, 0.7854F);
        this.bone26.setTextureOffset(44, 24).addBox(-12.7279F, -6.364F, -4.5F, 1, 1, 9, 0.0F);
        this.bone26.setTextureOffset(44, 24).addBox(-12.7279F, -5.9497F, -4.5F, 1, 1, 9, 0.0F);
        this.bone39 = new MModelRenderer(this);
        this.bone39.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.block.addChild(this.bone39);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-0.5F, -0.25F, 0.0F);
        this.bone39.addChild(this.bone7);
        this.setRotation(this.bone7, 0.0F, 1.5708F, 0.0F);
        this.bone7.setTextureOffset(27, 53).addBox(-1.0F, -5.0F, -5.5F, 2, 1, 1, 0.0F);
        this.bone7.setTextureOffset(8, 51).addBox(-1.0F, -7.5F, -5.5F, 2, 2, 1, 0.0F);
        this.bone7.setTextureOffset(27, 57).addBox(1.0F, -9.0F, -5.5F, 2, 1, 1, 0.0F);
        this.bone7.setTextureOffset(3, 54).addBox(1.0F, -10.5F, -5.5F, 2, 2, 1, 0.0F);
        this.bone7.setTextureOffset(0, 60).addBox(-3.0F, -10.5F, -5.5F, 2, 2, 1, 0.0F);
        this.bone7.setTextureOffset(27, 55).addBox(0.0F, -8.5F, -5.5F, 2, 1, 1, 0.0F);
        this.bone7.setTextureOffset(27, 61).addBox(-2.0F, -11.5F, -5.5F, 4, 1, 1, 0.0F);
        this.bone7.setTextureOffset(33, 55).addBox(0.0F, -8.0F, -5.5F, 2, 1, 1, 0.0F);
        this.bone7.setTextureOffset(27, 59).addBox(-2.0F, -11.0F, -5.5F, 4, 1, 1, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone7.addChild(this.bone8);
        this.setRotation(this.bone8, 0.0F, 0.0F, -0.7854F);
        this.bone8.setTextureOffset(0, 53).addBox(5.0104F, -6.0104F, -5.5F, 1, 1, 1, 0.0F);
        this.bone8.setTextureOffset(4, 52).addBox(4.5962F, -6.0104F, -5.5F, 1, 1, 1, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.bone7.addChild(this.bone9);
        this.setRotation(this.bone9, 0.0F, 0.0F, -0.7854F);
        this.bone9.setTextureOffset(36, 58).addBox(4.6569F, -6.6569F, -5.5F, 1, 1, 1, 0.0F);
        this.bone9.setTextureOffset(33, 57).addBox(4.2426F, -6.6569F, -5.5F, 1, 1, 1, 0.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.bone7.addChild(this.bone10);
        this.setRotation(this.bone10, 0.0F, 0.0F, -0.7854F);
        this.bone10.setTextureOffset(0, 58).addBox(7.1317F, -8.1317F, -5.5F, 1, 1, 1, 0.0F);
        this.bone10.setTextureOffset(0, 56).addBox(6.7175F, -8.1317F, -5.5F, 1, 1, 1, 0.0F);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(3.0F, -0.5F, 0.0F);
        this.bone7.addChild(this.bone11);
        this.setRotation(this.bone11, 0.0F, 0.0F, 0.7854F);
        this.bone11.setTextureOffset(5, 57).addBox(-8.0711F, -7.0711F, -5.5F, 1, 1, 1, 0.0F);
        this.bone11.setTextureOffset(5, 59).addBox(-8.4853F, -7.0711F, -5.5F, 1, 1, 1, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, -0.25F, 0.5F);
        this.bone39.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 3.1416F, 0.0F);
        this.bone2.setTextureOffset(27, 53).addBox(-1.0F, -5.0F, -5.5F, 2, 1, 1, 0.0F);
        this.bone2.setTextureOffset(8, 51).addBox(-1.0F, -7.5F, -5.5F, 2, 2, 1, 0.0F);
        this.bone2.setTextureOffset(27, 57).addBox(1.0F, -9.0F, -5.5F, 2, 1, 1, 0.0F);
        this.bone2.setTextureOffset(3, 54).addBox(1.0F, -10.5F, -5.5F, 2, 2, 1, 0.0F);
        this.bone2.setTextureOffset(0, 60).addBox(-3.0F, -10.5F, -5.5F, 2, 2, 1, 0.0F);
        this.bone2.setTextureOffset(27, 55).addBox(0.0F, -8.5F, -5.5F, 2, 1, 1, 0.0F);
        this.bone2.setTextureOffset(27, 61).addBox(-2.0F, -11.5F, -5.5F, 4, 1, 1, 0.0F);
        this.bone2.setTextureOffset(33, 55).addBox(0.0F, -8.0F, -5.5F, 2, 1, 1, 0.0F);
        this.bone2.setTextureOffset(27, 59).addBox(-2.0F, -11.0F, -5.5F, 4, 1, 1, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone2.addChild(this.bone3);
        this.setRotation(this.bone3, 0.0F, 0.0F, -0.7854F);
        this.bone3.setTextureOffset(0, 53).addBox(5.0104F, -6.0104F, -5.5F, 1, 1, 1, 0.0F);
        this.bone3.setTextureOffset(4, 52).addBox(4.5962F, -6.0104F, -5.5F, 1, 1, 1, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.bone2.addChild(this.bone4);
        this.setRotation(this.bone4, 0.0F, 0.0F, -0.7854F);
        this.bone4.setTextureOffset(36, 58).addBox(4.6569F, -6.6569F, -5.5F, 1, 1, 1, 0.0F);
        this.bone4.setTextureOffset(33, 57).addBox(4.2426F, -6.6569F, -5.5F, 1, 1, 1, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.bone2.addChild(this.bone5);
        this.setRotation(this.bone5, 0.0F, 0.0F, -0.7854F);
        this.bone5.setTextureOffset(0, 58).addBox(7.1317F, -8.1317F, -5.5F, 1, 1, 1, 0.0F);
        this.bone5.setTextureOffset(0, 56).addBox(6.7175F, -8.1317F, -5.5F, 1, 1, 1, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(3.0F, -0.5F, 0.0F);
        this.bone2.addChild(this.bone6);
        this.setRotation(this.bone6, 0.0F, 0.0F, 0.7854F);
        this.bone6.setTextureOffset(5, 57).addBox(-8.0711F, -7.0711F, -5.5F, 1, 1, 1, 0.0F);
        this.bone6.setTextureOffset(5, 59).addBox(-8.4853F, -7.0711F, -5.5F, 1, 1, 1, 0.0F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(0.5F, -0.25F, 0.0F);
        this.bone39.addChild(this.bone12);
        this.setRotation(this.bone12, 0.0F, -1.5708F, 0.0F);
        this.bone12.setTextureOffset(27, 53).addBox(-1.0F, -5.0F, -5.5F, 2, 1, 1, 0.0F);
        this.bone12.setTextureOffset(8, 51).addBox(-1.0F, -7.5F, -5.5F, 2, 2, 1, 0.0F);
        this.bone12.setTextureOffset(27, 57).addBox(1.0F, -9.0F, -5.5F, 2, 1, 1, 0.0F);
        this.bone12.setTextureOffset(3, 54).addBox(1.0F, -10.5F, -5.5F, 2, 2, 1, 0.0F);
        this.bone12.setTextureOffset(0, 60).addBox(-3.0F, -10.5F, -5.5F, 2, 2, 1, 0.0F);
        this.bone12.setTextureOffset(27, 55).addBox(0.0F, -8.5F, -5.5F, 2, 1, 1, 0.0F);
        this.bone12.setTextureOffset(27, 61).addBox(-2.0F, -11.5F, -5.5F, 4, 1, 1, 0.0F);
        this.bone12.setTextureOffset(33, 55).addBox(0.0F, -8.0F, -5.5F, 2, 1, 1, 0.0F);
        this.bone12.setTextureOffset(27, 59).addBox(-2.0F, -11.0F, -5.5F, 4, 1, 1, 0.0F);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone12.addChild(this.bone13);
        this.setRotation(this.bone13, 0.0F, 0.0F, -0.7854F);
        this.bone13.setTextureOffset(0, 53).addBox(5.0104F, -6.0104F, -5.5F, 1, 1, 1, 0.0F);
        this.bone13.setTextureOffset(4, 52).addBox(4.5962F, -6.0104F, -5.5F, 1, 1, 1, 0.0F);
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.bone12.addChild(this.bone14);
        this.setRotation(this.bone14, 0.0F, 0.0F, -0.7854F);
        this.bone14.setTextureOffset(36, 58).addBox(4.6569F, -6.6569F, -5.5F, 1, 1, 1, 0.0F);
        this.bone14.setTextureOffset(33, 57).addBox(4.2426F, -6.6569F, -5.5F, 1, 1, 1, 0.0F);
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.bone12.addChild(this.bone15);
        this.setRotation(this.bone15, 0.0F, 0.0F, -0.7854F);
        this.bone15.setTextureOffset(0, 58).addBox(7.1317F, -8.1317F, -5.5F, 1, 1, 1, 0.0F);
        this.bone15.setTextureOffset(0, 56).addBox(6.7175F, -8.1317F, -5.5F, 1, 1, 1, 0.0F);
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(3.0F, -0.5F, 0.0F);
        this.bone12.addChild(this.bone16);
        this.setRotation(this.bone16, 0.0F, 0.0F, 0.7854F);
        this.bone16.setTextureOffset(5, 57).addBox(-8.0711F, -7.0711F, -5.5F, 1, 1, 1, 0.0F);
        this.bone16.setTextureOffset(5, 59).addBox(-8.4853F, -7.0711F, -5.5F, 1, 1, 1, 0.0F);
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(0.0F, -0.25F, -0.5F);
        this.bone39.addChild(this.bone17);
        this.bone17.setTextureOffset(27, 53).addBox(-1.0F, -5.0F, -5.5F, 2, 1, 1, 0.0F);
        this.bone17.setTextureOffset(8, 51).addBox(-1.0F, -7.5F, -5.5F, 2, 2, 1, 0.0F);
        this.bone17.setTextureOffset(27, 57).addBox(1.0F, -9.0F, -5.5F, 2, 1, 1, 0.0F);
        this.bone17.setTextureOffset(3, 54).addBox(1.0F, -10.5F, -5.5F, 2, 2, 1, 0.0F);
        this.bone17.setTextureOffset(0, 60).addBox(-3.0F, -10.5F, -5.5F, 2, 2, 1, 0.0F);
        this.bone17.setTextureOffset(27, 55).addBox(0.0F, -8.5F, -5.5F, 2, 1, 1, 0.0F);
        this.bone17.setTextureOffset(27, 61).addBox(-2.0F, -11.5F, -5.5F, 4, 1, 1, 0.0F);
        this.bone17.setTextureOffset(33, 55).addBox(0.0F, -8.0F, -5.5F, 2, 1, 1, 0.0F);
        this.bone17.setTextureOffset(27, 59).addBox(-2.0F, -11.0F, -5.5F, 4, 1, 1, 0.0F);
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone17.addChild(this.bone18);
        this.setRotation(this.bone18, 0.0F, 0.0F, -0.7854F);
        this.bone18.setTextureOffset(0, 53).addBox(5.0104F, -6.0104F, -5.5F, 1, 1, 1, 0.0F);
        this.bone18.setTextureOffset(4, 52).addBox(4.5962F, -6.0104F, -5.5F, 1, 1, 1, 0.0F);
        this.bone19 = new MModelRenderer(this);
        this.bone19.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.bone17.addChild(this.bone19);
        this.setRotation(this.bone19, 0.0F, 0.0F, -0.7854F);
        this.bone19.setTextureOffset(36, 58).addBox(4.6569F, -6.6569F, -5.5F, 1, 1, 1, 0.0F);
        this.bone19.setTextureOffset(33, 57).addBox(4.2426F, -6.6569F, -5.5F, 1, 1, 1, 0.0F);
        this.bone20 = new MModelRenderer(this);
        this.bone20.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.bone17.addChild(this.bone20);
        this.setRotation(this.bone20, 0.0F, 0.0F, -0.7854F);
        this.bone20.setTextureOffset(0, 58).addBox(7.1317F, -8.1317F, -5.5F, 1, 1, 1, 0.0F);
        this.bone20.setTextureOffset(0, 56).addBox(6.7175F, -8.1317F, -5.5F, 1, 1, 1, 0.0F);
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(3.0F, -0.5F, 0.0F);
        this.bone17.addChild(this.bone21);
        this.setRotation(this.bone21, 0.0F, 0.0F, 0.7854F);
        this.bone21.setTextureOffset(5, 57).addBox(-8.0711F, -7.0711F, -5.5F, 1, 1, 1, 0.0F);
        this.bone21.setTextureOffset(5, 59).addBox(-8.4853F, -7.0711F, -5.5F, 1, 1, 1, 0.0F);
        this.money = new MModelRenderer(this);
        this.money.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.money.setTextureOffset(50, 1).addBox(-1.0F, 3.5F, -1.0F, 2, 1, 2, 0.0F);
        this.money.setTextureOffset(54, 11).addBox(-1.0F, 3.0F, -0.5F, 2, 1, 1, 0.0F);
        this.money.setTextureOffset(54, 14).addBox(-1.0F, -4.0F, -0.5F, 2, 1, 1, 0.0F);
        this.money.setTextureOffset(54, 20).addBox(-2.0F, 2.0F, -0.5F, 4, 1, 1, 0.0F);
        this.money.setTextureOffset(54, 22).addBox(-2.0F, -3.0F, -0.5F, 4, 1, 1, 0.0F);
        this.money.setTextureOffset(56, 2).addBox(-1.0F, -4.5F, -1.0F, 2, 1, 2, 0.0F);
        this.money.setTextureOffset(52, 17).addBox(-2.0F, 3.0F, -1.0F, 1, 1, 2, 0.0F);
        this.money.setTextureOffset(58, 5).addBox(-2.0F, -4.0F, -1.0F, 1, 1, 2, 0.0F);
        this.money.setTextureOffset(47, 27).addBox(1.5F, -3.5F, -1.0F, 1, 1, 2, 0.0F);
        this.money.setTextureOffset(48, 11).addBox(1.5F, 2.5F, -1.0F, 1, 1, 2, 0.0F);
        this.money.setTextureOffset(52, 8).addBox(-2.5F, 2.5F, -1.0F, 1, 1, 2, 0.0F);
        this.money.setTextureOffset(58, 8).addBox(-2.5F, -3.5F, -1.0F, 1, 1, 2, 0.0F);
        this.money.setTextureOffset(48, 4).addBox(1.0F, 3.0F, -1.0F, 1, 1, 2, 0.0F);
        this.money.setTextureOffset(47, 24).addBox(1.0F, -4.0F, -1.0F, 1, 1, 2, 0.0F);
        this.money.setTextureOffset(52, 5).addBox(-3.0F, 2.0F, -1.0F, 1, 1, 2, 0.0F);
        this.money.setTextureOffset(58, 11).addBox(-3.0F, -3.0F, -1.0F, 1, 1, 2, 0.0F);
        this.money.setTextureOffset(48, 16).addBox(2.0F, 2.0F, -1.0F, 1, 1, 2, 0.0F);
        this.money.setTextureOffset(47, 30).addBox(2.0F, -3.0F, -1.0F, 1, 1, 2, 0.0F);
        this.money.setTextureOffset(44, 7).addBox(2.5F, -2.0F, -1.0F, 1, 4, 2, 0.0F);
        this.money.setTextureOffset(58, 14).addBox(-3.5F, -2.0F, -1.0F, 1, 4, 2, 0.0F);
        this.money.setTextureOffset(58, 23).addBox(-2.5F, -2.0F, -0.5F, 2, 4, 1, 0.0F);
        this.money.setTextureOffset(58, 28).addBox(0.5F, -2.0F, -0.5F, 2, 4, 1, 0.0F);
        this.money.setTextureOffset(56, 29).addBox(-0.5F, -2.0F, 0.0F, 1, 4, 0, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/mysteryblock.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/mysteryblock_animation.json"));
        this.anim = bbanimationloader.mustGet("mysteryblock.anim", this);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.translate(0.6F, -0.8F + f, 0.3F);
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
        this.anim.tickDelayed(time, 10.0F);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.6F, 0.0F);
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        this.anim.tickDelayed(time, 10.0F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "EvilBendy";
    }

    public String getName()
    {
        return "\u0417\u0430\u0433\u0430\u0434\u043e\u0447\u043d\u044b\u0439 \u0431\u043b\u043e\u043a";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Super Mario Bros");
    }
}
