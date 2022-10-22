package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class BoscoPet extends BasePet
{
    private final MModelRenderer mainGroup;
    private final MModelRenderer bone8;
    private final MModelRenderer bone7;
    private final MModelRenderer bone20;
    private final MModelRenderer bone18;
    private final MModelRenderer bone19;
    private final MModelRenderer bone17;
    private final MModelRenderer bone16;
    private final MModelRenderer bone14;
    private final MModelRenderer bone13;
    private final MModelRenderer bone12;
    private final MModelRenderer bone11;
    private final MModelRenderer bone10;
    private final MModelRenderer bone9;
    private final MModelRenderer bone6;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer bone15;
    private final MModelRenderer bone;

    public BoscoPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.mainGroup = new MModelRenderer(this);
        this.mainGroup.setRotationPoint(0.3F, 19.0F, -4.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-3.505F, -0.205F, 0.0F);
        this.mainGroup.addChild(this.bone8);
        this.bone8.setTextureOffset(0, 34).addBox(0.2121F, -11.5021F, 0.01F, 1, 1, 7, 0.0F);
        this.bone8.setTextureOffset(0, 34).addBox(4.7979F, -11.5021F, 0.01F, 1, 1, 7, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.0F, 0.0F, -0.5F);
        this.mainGroup.addChild(this.bone7);
        this.bone7.setTextureOffset(0, 0).addBox(-5.0F, -3.0787F, 6.1787F, 1, 4, 3, 0.0F);
        this.bone7.setTextureOffset(52, 16).addBox(0.7071F, -3.9071F, 10.3F, 3, 1, 1, 0.0F);
        this.bone7.setTextureOffset(52, 16).addBox(-4.7071F, -3.9071F, 10.3F, 3, 1, 1, 0.0F);
        this.bone7.setTextureOffset(37, 10).addBox(1.0F, -0.4F, 6.7F, 2, 1, 4, 0.0F);
        this.bone7.setTextureOffset(37, 10).addBox(-4.0F, -0.4F, 6.7F, 2, 1, 4, 0.0F);
        this.bone7.setTextureOffset(0, 16).addBox(0.0F, -3.2F, 10.3F, 1, 3, 1, 0.0F);
        this.bone7.setTextureOffset(24, 10).addBox(2.0F, -4.0F, 9.8F, 1, 4, 1, -0.2F);
        this.bone7.setTextureOffset(24, 10).addBox(-3.0F, -4.0F, 9.8F, 1, 4, 1, -0.2F);
        this.bone7.setTextureOffset(24, 10).addBox(1.0F, -4.0F, 9.8F, 1, 4, 1, -0.2F);
        this.bone7.setTextureOffset(24, 10).addBox(-4.0F, -4.0F, 9.8F, 1, 4, 1, -0.2F);
        this.bone7.setTextureOffset(0, 16).addBox(-2.0F, -3.2F, 10.3F, 1, 3, 1, 0.0F);
        this.bone7.setTextureOffset(45, 7).addBox(-5.0F, -4.2F, 7.3F, 1, 3, 4, 0.0F);
        this.bone7.setTextureOffset(0, 0).addBox(3.0F, -3.0787F, 6.1787F, 1, 4, 3, 0.0F);
        this.bone7.setTextureOffset(45, 7).addBox(3.0F, -4.2F, 7.3F, 1, 3, 4, 0.0F);
        this.bone20 = new MModelRenderer(this);
        this.bone20.setRotationPoint(-5.9F, 8.4F, 3.6F);
        this.mainGroup.addChild(this.bone20);
        this.bone20.setTextureOffset(35, 44).addBox(4.9F, -14.2F, -3.8F, 1, 1, 1, 0.0F);
        this.bone20.setTextureOffset(44, 32).addBox(4.9F, -14.2F, -3.3F, 1, 1, 1, 0.25F);
        this.bone20.setTextureOffset(37, 10).addBox(4.9F, -17.9F, -4.0F, 1, 2, 1, -0.1F);
        this.bone20.setTextureOffset(18, 36).addBox(4.9F, -17.9F, -3.2F, 1, 2, 1, 0.1F);
        this.bone20.setTextureOffset(0, 39).addBox(4.4F, -17.4F, -4.0F, 2, 1, 1, -0.1F);
        this.bone20.setTextureOffset(28, 31).addBox(4.4F, -17.4F, -3.2F, 2, 1, 1, 0.1F);
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(-9.0F, 0.0F, 0.0F);
        this.mainGroup.addChild(this.bone18);
        this.bone18.setTextureOffset(0, 0).addBox(5.0F, -11.0F, 0.0F, 2, 8, 8, 0.0F);
        this.bone18.setTextureOffset(0, 0).addBox(10.0F, -11.0F, 0.0F, 2, 8, 8, 0.0F);
        this.bone18.setTextureOffset(6, 53).addBox(9.2F, -1.0F, 0.5F, 2, 2, 2, 0.0F);
        this.bone18.setTextureOffset(6, 53).addBox(6.0F, -1.0F, 0.5F, 2, 2, 2, 0.0F);
        this.bone18.setTextureOffset(41, 51).addBox(10.5F, -1.0F, 0.5F, 2, 2, 2, -0.5F);
        this.bone18.setTextureOffset(41, 51).addBox(4.5F, -1.0F, 0.5F, 2, 2, 2, -0.5F);
        this.bone18.setTextureOffset(36, 16).addBox(5.0F, -5.2385F, 7.8117F, 7, 2, 2, 0.0F);
        this.bone18.setTextureOffset(46, 32).addBox(7.0F, -3.2385F, 7.8117F, 3, 4, 2, 0.0F);
        this.bone18.setTextureOffset(0, 24).addBox(6.5F, -3.6F, 0.0F, 4, 2, 8, 0.0F);
        this.bone18.setTextureOffset(25, 42).addBox(6.5F, -10.6F, 1.0F, 4, 8, 1, 0.0F);
        this.bone18.setTextureOffset(24, 10).addBox(6.5F, -11.3071F, 1.7071F, 4, 1, 5, 0.0F);
        this.bone18.setTextureOffset(24, 0).addBox(7.0F, -1.7F, 0.0F, 3, 2, 8, 0.0F);
        this.bone18.setTextureOffset(29, 54).addBox(7.0F, 0.1822F, 0.4979F, 3, 2, 1, 0.0F);
        this.bone18.setTextureOffset(0, 42).addBox(12.0F, -1.7F, 0.5F, 2, 7, 2, 0.0F);
        this.bone18.setTextureOffset(14, 53).addBox(12.0F, -2.2F, 0.5F, 2, 1, 2, -0.1F);
        this.bone18.setTextureOffset(14, 53).addBox(3.0F, -2.2F, 0.5F, 2, 1, 2, -0.1F);
        this.bone18.setTextureOffset(0, 42).addBox(3.0F, -1.7F, 0.5F, 2, 7, 2, 0.0F);
        this.bone19 = new MModelRenderer(this);
        this.bone19.setRotationPoint(-3.0F, -3.0F, -0.5F);
        this.mainGroup.addChild(this.bone19);
        this.setRotation(this.bone19, 0.0F, 0.0F, 0.7854F);
        this.bone19.setTextureOffset(41, 12).addBox(1.9799F, -3.2627F, 10.3F, 1, 1, 1, 0.0F);
        this.bone19.setTextureOffset(41, 12).addBox(0.2728F, -1.5556F, 10.3F, 1, 1, 1, 0.0F);
        this.bone19.setTextureOffset(41, 12).addBox(2.3941F, 0.5657F, 10.0F, 1, 1, 1, 0.0F);
        this.bone19.setTextureOffset(41, 12).addBox(4.1012F, -1.1414F, 10.0F, 1, 1, 1, 0.0F);
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(-6.0F, 0.0F, -2.0F);
        this.mainGroup.addChild(this.bone17);
        this.setRotation(this.bone17, 0.0F, 0.0F, 0.7854F);
        this.bone17.setTextureOffset(14, 44).addBox(-2.6249F, -10.9687F, 1.55F, 1, 1, 1, -0.15F);
        this.bone17.setTextureOffset(38, 0).addBox(-2.6249F, -11.2516F, 2.15F, 1, 1, 1, -0.15F);
        this.bone17.setTextureOffset(14, 44).addBox(-3.1906F, -10.3959F, 1.55F, 1, 1, 1, -0.15F);
        this.bone17.setTextureOffset(38, 0).addBox(-3.4734F, -10.403F, 2.15F, 1, 1, 1, -0.15F);
        this.bone17.setTextureOffset(14, 44).addBox(-2.0521F, -10.3959F, 1.55F, 1, 1, 1, -0.15F);
        this.bone17.setTextureOffset(38, 0).addBox(-1.7692F, -10.403F, 2.15F, 1, 1, 1, -0.15F);
        this.bone17.setTextureOffset(13, 44).addBox(-2.6178F, -9.8303F, 1.55F, 1, 1, 1, -0.15F);
        this.bone17.setTextureOffset(38, 0).addBox(-2.6249F, -9.5474F, 2.15F, 1, 1, 1, -0.15F);
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(-0.5F, 0.2F, -0.6F);
        this.mainGroup.addChild(this.bone16);
        this.setRotation(this.bone16, 0.2618F, 0.0F, 0.0F);
        this.bone16.setTextureOffset(53, 28).addBox(4.0F, 3.4F, 0.6F, 2, 1, 2, -0.1F);
        this.bone16.setTextureOffset(53, 28).addBox(-6.0F, 3.4F, 0.6F, 2, 1, 2, -0.1F);
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(0.0F, -5.0F, -8.0F);
        this.mainGroup.addChild(this.bone14);
        this.setRotation(this.bone14, -0.7854F, 0.0F, 0.0F);
        this.bone14.setTextureOffset(48, 14).addBox(-2.5F, -11.3238F, 2.4042F, 4, 1, 1, 0.0F);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(0.0F, 3.9F, -0.1F);
        this.mainGroup.addChild(this.bone13);
        this.setRotation(this.bone13, 0.3491F, 0.0F, 0.0F);
        this.bone13.setTextureOffset(33, 49).addBox(3.0F, -2.7945F, -2.7075F, 2, 3, 2, 0.0F);
        this.bone13.setTextureOffset(50, 3).addBox(3.0F, -0.7945F, -2.9075F, 2, 2, 2, -0.45F);
        this.bone13.setTextureOffset(50, 3).addBox(-6.0F, -0.7945F, -2.9075F, 2, 2, 2, -0.45F);
        this.bone13.setTextureOffset(51, 4).addBox(3.5F, 0.3055F, -2.4075F, 1, 1, 2, -0.2F);
        this.bone13.setTextureOffset(51, 4).addBox(-5.5F, 0.3055F, -2.4075F, 1, 1, 2, -0.2F);
        this.bone13.setTextureOffset(33, 49).addBox(-6.0F, -2.7945F, -2.7075F, 2, 3, 2, 0.0F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(0.0F, 0.9F, -0.1F);
        this.mainGroup.addChild(this.bone12);
        this.bone12.setTextureOffset(47, 25).addBox(3.0F, -1.7F, -3.5F, 2, 3, 2, 0.0F);
        this.bone12.setTextureOffset(47, 25).addBox(-6.0F, -1.7F, -3.5F, 2, 3, 2, 0.0F);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.0F, 0.0F, -1.5F);
        this.mainGroup.addChild(this.bone11);
        this.setRotation(this.bone11, 0.4363F, 0.0F, 0.0F);
        this.bone11.setTextureOffset(0, 23).addBox(3.0F, -1.4464F, -0.4562F, 2, 7, 2, -0.2F);
        this.bone11.setTextureOffset(0, 23).addBox(-6.0F, -1.4464F, -0.4562F, 2, 7, 2, -0.2F);
        this.bone11.setTextureOffset(0, 51).addBox(3.0F, -2.0464F, -1.1562F, 2, 2, 2, -0.2F);
        this.bone11.setTextureOffset(0, 51).addBox(3.0F, 2.9536F, -0.9562F, 2, 2, 2, -0.2F);
        this.bone11.setTextureOffset(0, 51).addBox(-6.0F, 2.9536F, -0.9562F, 2, 2, 2, -0.2F);
        this.bone11.setTextureOffset(0, 51).addBox(-6.0F, -2.0464F, -1.1562F, 2, 2, 2, -0.2F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.mainGroup.addChild(this.bone10);
        this.setRotation(this.bone10, 0.0F, 0.0F, 0.7854F);
        this.bone10.setTextureOffset(41, 40).addBox(-0.7544F, -2.9971F, 4.8117F, 2, 2, 4, 0.0F);
        this.bone10.setTextureOffset(38, 34).addBox(-3.7042F, -0.0473F, 4.8117F, 2, 2, 4, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mainGroup.addChild(this.bone9);
        this.bone9.setTextureOffset(38, 0).addBox(0.99F, -3.2385F, 4.8117F, 2, 3, 4, 0.0F);
        this.bone9.setTextureOffset(38, 0).addBox(-3.99F, -3.2385F, 4.8117F, 2, 3, 4, 0.0F);
        this.bone9.setTextureOffset(0, 55).addBox(1.0F, -3.2385F, 8.8117F, 2, 3, 1, 0.0F);
        this.bone9.setTextureOffset(0, 55).addBox(-4.0F, -3.2385F, 8.8117F, 2, 3, 1, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.mainGroup.addChild(this.bone6);
        this.setRotation(this.bone6, -0.7854F, 0.0F, 0.0F);
        this.bone6.setTextureOffset(0, 34).addBox(3.0F, -4.9497F, 8.3238F, 1, 3, 2, 0.0F);
        this.bone6.setTextureOffset(0, 34).addBox(-5.0F, -4.9497F, 8.3238F, 1, 3, 2, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mainGroup.addChild(this.bone4);
        this.setRotation(this.bone4, -0.1745F, 0.0F, 0.0F);
        this.bone4.setTextureOffset(37, 26).addBox(-2.0F, -1.5757F, -0.2778F, 3, 2, 4, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mainGroup.addChild(this.bone5);
        this.setRotation(this.bone5, 0.4363F, 0.0F, 0.0F);
        this.bone5.setTextureOffset(44, 20).addBox(-2.0F, 0.1882F, -0.471F, 3, 2, 3, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mainGroup.addChild(this.bone3);
        this.setRotation(this.bone3, 0.2618F, 0.0F, 0.0F);
        this.bone3.setTextureOffset(12, 0).addBox(-4.0F, -8.5206F, 8.8332F, 7, 6, 2, 1.0E-4F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-4.0F, -0.7F, 0.0F);
        this.mainGroup.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 0.0F, 0.7854F);
        this.bone2.setTextureOffset(0, 34).addBox(-3.3335F, -12.2329F, 0.01F, 1, 1, 7, 0.0F);
        this.bone2.setTextureOffset(0, 34).addBox(-7.2832F, -8.2832F, 0.01F, 1, 1, 7, 0.0F);
        this.bone2.setTextureOffset(16, 26).addBox(-1.6263F, -3.6263F, 0.01F, 2, 2, 8, 0.0F);
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(10.495F, -3.205F, -1.0F);
        this.mainGroup.addChild(this.bone15);
        this.setRotation(this.bone15, -0.7854F, 0.0F, 0.0F);
        this.bone15.setTextureOffset(54, 31).addBox(-9.5021F, -11.6687F, -0.355F, 2, 1, 2, 0.0F);
        this.bone15.setTextureOffset(54, 31).addBox(-14.5021F, -11.6687F, -0.355F, 2, 1, 2, 0.0F);
        this.bone15.setTextureOffset(46, 0).addBox(-12.995F, -11.1788F, -0.2793F, 4, 1, 2, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -0.7F, 0.0F);
        this.mainGroup.addChild(this.bone);
        this.setRotation(this.bone, 0.0F, 0.0F, 0.7854F);
        this.bone.setTextureOffset(16, 26).addBox(-1.505F, -3.7477F, 0.01F, 2, 2, 8, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/boscopet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.translate(0.7F, -0.9F + f, 0.35F);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.65F, 0.0F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0411\u043e\u0441\u043a\u043e";
    }

    public String getCreator()
    {
        return "Veltorn";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Deep Rock Galactic");
    }
}
