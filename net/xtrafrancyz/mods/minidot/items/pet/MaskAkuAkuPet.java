package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class MaskAkuAkuPet extends BasePet
{
    private final MModelRenderer Head;
    private final MModelRenderer bone5;
    private final MModelRenderer bone9;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final MModelRenderer bone17;
    private final MModelRenderer bone19;
    private final MModelRenderer bone21;
    private final MModelRenderer bone23;
    private final MModelRenderer bone28;
    private final MModelRenderer bone29;
    private final MModelRenderer bone30;
    private final MModelRenderer bone31;
    private final MModelRenderer bone25;
    private final MModelRenderer bone32;
    private final MModelRenderer bone33;
    private final MModelRenderer bone34;
    private final MModelRenderer bone35;
    private final MModelRenderer Yellow;
    private final MModelRenderer bone36;
    private final MModelRenderer bone39;
    private final MModelRenderer bone37;

    public MaskAkuAkuPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.Head.setTextureOffset(0, 0).addBox(-8.0F, -25.0F, -4.0F, 17, 25, 5, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(2.3F, 5.9F, 0.9F);
        this.Head.addChild(this.bone5);
        this.setRotation(this.bone5, -0.7156F, 0.8639F, -0.6196F);
        this.bone5.setTextureOffset(38, 50).addBox(5.29F, -12.2F, 0.9F, 2, 5, 2, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-0.5F, 5.3F, 2.0F);
        this.Head.addChild(this.bone9);
        this.setRotation(this.bone9, 0.0F, 0.0F, 0.2793F);
        this.bone9.setTextureOffset(44, 5).addBox(0.0217F, -14.9359F, -1.5F, 5, 2, 3, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, 6.0F, -3.0F);
        this.Head.addChild(this.bone6);
        this.setRotation(this.bone6, -0.3665F, 0.0F, 0.0F);
        this.bone6.setTextureOffset(0, 30).addBox(-7.0F, -10.0F, 0.0F, 15, 2, 2, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-2.9F, 5.9F, 3.9F);
        this.Head.addChild(this.bone7);
        this.setRotation(this.bone7, -0.3927F, -1.1956F, 0.4363F);
        this.bone7.setTextureOffset(30, 50).addBox(-6.4F, -11.9F, 0.9F, 2, 5, 2, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, 6.0F, -3.0F);
        this.Head.addChild(this.bone8);
        this.setRotation(this.bone8, 0.0F, 0.0F, -0.2269F);
        this.bone8.setTextureOffset(39, 0).addBox(-3.7515F, -15.0102F, 3.5F, 5, 2, 3, 0.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(5.5F, 6.3F, 2.0F);
        this.Head.addChild(this.bone10);
        this.setRotation(this.bone10, 0.0F, 0.0F, -0.4363F);
        this.bone10.setTextureOffset(44, 25).addBox(0.8F, -14.7F, -1.5F, 4, 2, 3, 0.0F);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-4.7F, 6.0F, 2.0F);
        this.Head.addChild(this.bone11);
        this.setRotation(this.bone11, 0.0F, 0.0F, 0.3752F);
        this.bone11.setTextureOffset(44, 20).addBox(-3.1F, -14.8F, -1.5F, 4, 2, 3, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.Head.addChild(this.bone);
        this.bone.setTextureOffset(0, 34).addBox(-5.0F, -13.0F, 0.4F, 12, 4, 1, 0.0F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(5.3F, 6.6F, -2.3F);
        this.Head.addChild(this.bone12);
        this.setRotation(this.bone12, 0.2618F, -0.7679F, -0.2094F);
        this.bone12.setTextureOffset(0, 39).addBox(-1.0F, -21.0F, 5.0F, 4, 6, 4, 0.0F);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-4.1F, 6.0F, 0.0F);
        this.Head.addChild(this.bone13);
        this.setRotation(this.bone13, 0.0F, 0.0F, 0.1571F);
        this.bone13.setTextureOffset(22, 37).addBox(-8.4F, -27.6F, -1.0F, 8, 2, 4, 0.0F);
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-0.2F, 6.2F, 0.0F);
        this.Head.addChild(this.bone14);
        this.bone14.setTextureOffset(30, 30).addBox(1.2F, -30.0F, -1.0F, 9, 3, 4, 0.0F);
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.Head.addChild(this.bone15);
        this.bone15.setTextureOffset(17, 55).addBox(1.0F, -26.9F, 1.0F, 1, 4, 1, 0.0F);
        this.bone15.setTextureOffset(13, 55).addBox(-1.4F, -26.0F, 1.0F, 1, 4, 1, 0.0F);
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.Head.addChild(this.bone17);
        this.bone17.setTextureOffset(12, 41).addBox(-2.1F, -22.0F, 1.0F, 1, 1, 1, 0.0F);
        this.bone17.setTextureOffset(12, 41).addBox(-7.65F, -22.0F, 1.0F, 1, 1, 1, 0.0F);
        this.bone17.setTextureOffset(16, 41).addBox(1.6419F, -22.9703F, 1.0F, 1, 1, 1, 0.0F);
        this.bone17.setTextureOffset(16, 41).addBox(8.2419F, -22.9703F, 0.9F, 1, 1, 1, 0.0F);
        this.bone17.setTextureOffset(0, 0).addBox(8.5419F, -26.8703F, 0.8F, 1, 4, 1, 0.0F);
        this.bone17.setTextureOffset(12, 39).addBox(2.6419F, -22.3703F, 1.0F, 6, 1, 1, 0.0F);
        this.bone17.setTextureOffset(46, 51).addBox(-6.9F, -21.4F, 1.0F, 5, 1, 1, 0.0F);
        this.bone19 = new MModelRenderer(this);
        this.bone19.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.Head.addChild(this.bone19);
        this.bone19.setTextureOffset(32, 43).addBox(-7.3F, -27.2F, 0.4F, 6, 6, 1, 0.0F);
        this.bone19.setTextureOffset(16, 43).addBox(1.7F, -27.2F, 0.1F, 7, 5, 1, 0.0F);
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(15.8F, -1.2F, 0.0F);
        this.Head.addChild(this.bone21);
        this.setRotation(this.bone21, 0.0F, 0.0F, -0.5585F);
        this.bone21.setTextureOffset(0, 39).addBox(-6.5F, -33.7F, -1.0F, 2, 3, 0, 0.0F);
        this.bone23 = new MModelRenderer(this);
        this.bone23.setRotationPoint(16.2F, -4.6F, 6.6F);
        this.Head.addChild(this.bone23);
        this.setRotation(this.bone23, 0.2618F, 0.0F, -0.5585F);
        this.bone23.setTextureOffset(0, 49).addBox(-10.2409F, -38.9381F, 0.6897F, 5, 7, 0, 0.0F);
        this.bone28 = new MModelRenderer(this);
        this.bone28.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.Head.addChild(this.bone28);
        this.bone28.setTextureOffset(9, 55).addBox(-8.1F, -24.0F, 0.8F, 1, 5, 1, 0.0F);
        this.bone29 = new MModelRenderer(this);
        this.bone29.setRotationPoint(0.5F, 6.0F, 3.6F);
        this.Head.addChild(this.bone29);
        this.bone29.setTextureOffset(20, 49).addBox(-2.6F, -7.3F, -2.2F, 5, 6, 0, 0.0F);
        this.bone30 = new MModelRenderer(this);
        this.bone30.setRotationPoint(-0.6F, 6.8F, 1.9F);
        this.Head.addChild(this.bone30);
        this.setRotation(this.bone30, 0.0F, 0.6807F, 0.0F);
        this.bone30.setTextureOffset(20, 49).addBox(2.9F, -8.2F, 1.8F, 5, 6, 0, 0.0F);
        this.bone31 = new MModelRenderer(this);
        this.bone31.setRotationPoint(-0.6F, 6.7F, 0.0F);
        this.Head.addChild(this.bone31);
        this.setRotation(this.bone31, 0.0F, -0.5411F, 0.0F);
        this.bone31.setTextureOffset(20, 49).addBox(-5.3F, -7.9F, 1.701F, 5, 6, 0, 0.0F);
        this.bone25 = new MModelRenderer(this);
        this.bone25.setRotationPoint(29.3F, -23.3F, 11.6F);
        this.Head.addChild(this.bone25);
        this.setRotation(this.bone25, 0.4538F, 0.0F, -0.5585F);
        this.bone25.setTextureOffset(54, 14).addBox(-30.3599F, -36.2686F, -0.296F, 3, 4, 0, 0.0F);
        this.bone32 = new MModelRenderer(this);
        this.bone32.setRotationPoint(0.0F, 6.0F, 3.2F);
        this.Head.addChild(this.bone32);
        this.bone32.setTextureOffset(10, 49).addBox(-4.1F, -6.1F, -3.599F, 5, 6, 0, 0.0F);
        this.bone32.setTextureOffset(10, 49).addBox(0.3F, -6.1F, -3.599F, 5, 6, 0, 0.0F);
        this.bone33 = new MModelRenderer(this);
        this.bone33.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.Head.addChild(this.bone33);
        this.bone33.setTextureOffset(52, 0).addBox(-3.8F, -34.0F, -1.2F, 4, 3, 0, 0.0F);
        this.bone34 = new MModelRenderer(this);
        this.bone34.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.Head.addChild(this.bone34);
        this.setRotation(this.bone34, 0.5411F, 0.0F, 0.0F);
        this.bone34.setTextureOffset(44, 10).addBox(-4.2F, -39.7612F, 16.4826F, 5, 10, 0, 0.0F);
        this.bone35 = new MModelRenderer(this);
        this.bone35.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.Head.addChild(this.bone35);
        this.setRotation(this.bone35, 0.5061F, 0.0F, 0.0F);
        this.bone35.setTextureOffset(46, 53).addBox(-4.2F, -45.3123F, 15.0859F, 3, 5, 0, 0.0F);
        this.Yellow = new MModelRenderer(this);
        this.Yellow.setRotationPoint(0.0F, 6.1F, 1.2F);
        this.Head.addChild(this.Yellow);
        this.setRotation(this.Yellow, 0.1047F, 0.0F, 0.0F);
        this.Yellow.setTextureOffset(26, 34).addBox(2.0F, -34.0F, 1.0F, 2, 3, 0, 0.0F);
        this.bone36 = new MModelRenderer(this);
        this.bone36.setRotationPoint(2.0F, -34.1F, -0.1F);
        this.Yellow.addChild(this.bone36);
        this.setRotation(this.bone36, 0.3142F, 0.0F, 0.0F);
        this.bone36.setTextureOffset(46, 44).addBox(-1.3F, -6.565F, 1.0153F, 5, 7, 0, 0.0F);
        this.bone39 = new MModelRenderer(this);
        this.bone39.setRotationPoint(-12.6F, -8.0F, 17.8F);
        this.Head.addChild(this.bone39);
        this.setRotation(this.bone39, 0.5411F, 0.0698F, 0.5585F);
        this.bone39.setTextureOffset(46, 37).addBox(5.9787F, -39.4045F, -3.027F, 5, 7, 0, 0.0F);
        this.bone39.setTextureOffset(52, 53).addBox(6.8787F, -32.4045F, -3.027F, 3, 4, 0, 0.0F);
        this.bone39.setTextureOffset(52, 30).addBox(6.8787F, -43.4045F, -3.027F, 3, 4, 0, 0.0F);
        this.bone37 = new MModelRenderer(this);
        this.bone37.setRotationPoint(4.0F, -38.0F, -6.0F);
        this.Head.addChild(this.bone37);
        this.setRotation(this.bone37, 0.1745F, 0.0F, 0.0F);
        this.bone37.setTextureOffset(54, 10).addBox(-2.1F, 0.0408F, 1.1086F, 3, 4, 0, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/akuaku.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.translate(0.65F, -0.5F - f, 0.25F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        float f1 = 0.45F;
        GlStateManager.scale(f1, f1, f1);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.05F, 0.0F);
        float f = 0.5F;
        GlStateManager.scale(f, f, f);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "GetoGdeto";
    }

    public String getName()
    {
        return "Aku Aku";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Crash Bandicoot");
    }
}
