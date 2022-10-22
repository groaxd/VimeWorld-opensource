package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class FanPet extends BasePet
{
    private final MModelRenderer main;
    private final MModelRenderer stand;
    private final MModelRenderer fan;
    private final MModelRenderer one;
    private final MModelRenderer one2;
    private final MModelRenderer one3;
    private final MModelRenderer corner;
    private final MModelRenderer case2;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer caze;
    private final MModelRenderer bone4;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final IAnimation animation;

    public FanPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.main = new MModelRenderer(this);
        this.main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.main.setTextureOffset(0, 21).addBox(-0.5F, -7.8F, -0.5F, 1, 7, 1, -0.2F);
        this.stand = new MModelRenderer(this);
        this.stand.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.main.addChild(this.stand);
        this.stand.setTextureOffset(0, 0).addBox(-1.5F, -1.0F, -1.4F, 3, 1, 3, 0.0F);
        this.stand.setTextureOffset(22, 18).addBox(1.5F, -1.0F, -0.9F, 1, 1, 2, 0.0F);
        this.stand.setTextureOffset(18, 22).addBox(-2.5F, -1.0F, -0.9F, 1, 1, 2, 0.0F);
        this.stand.setTextureOffset(30, 7).addBox(-1.0F, -1.0F, -2.4F, 2, 1, 1, 0.0F);
        this.stand.setTextureOffset(5, 30).addBox(-1.0F, -1.0F, 1.6F, 2, 1, 1, 0.0F);
        this.fan = new MModelRenderer(this);
        this.fan.setRotationPoint(0.0F, -7.3F, 0.3F);
        this.main.addChild(this.fan);
        this.fan.setTextureOffset(28, 33).addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.one = new MModelRenderer(this);
        this.one.setRotationPoint(0.1F, -0.1F, 0.0F);
        this.fan.addChild(this.one);
        this.setRotation(this.one, 0.0F, 0.0F, -0.6109F);
        this.one.setTextureOffset(22, 14).addBox(-3.0F, -0.45F, -0.5F, 3, 1, 1, -0.1F);
        this.one.setTextureOffset(29, 15).addBox(-3.0F, 0.35F, -0.5F, 2, 1, 1, -0.1F);
        this.one.setTextureOffset(29, 13).addBox(-3.0F, -1.25F, -0.5F, 2, 1, 1, -0.1F);
        this.one.setTextureOffset(33, 25).addBox(-3.8F, -0.45F, -0.5F, 1, 1, 1, -0.1F);
        this.one2 = new MModelRenderer(this);
        this.one2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.fan.addChild(this.one2);
        this.setRotation(this.one2, 0.0F, 0.0F, 1.5708F);
        this.one2.setTextureOffset(12, 22).addBox(-3.0F, -0.45F, -0.5F, 3, 1, 1, -0.1F);
        this.one2.setTextureOffset(29, 5).addBox(-3.0F, 0.35F, -0.5F, 2, 1, 1, -0.1F);
        this.one2.setTextureOffset(29, 3).addBox(-3.0F, -1.25F, -0.5F, 2, 1, 1, -0.1F);
        this.one2.setTextureOffset(32, 29).addBox(-3.8F, -0.45F, -0.5F, 1, 1, 1, -0.1F);
        this.one3 = new MModelRenderer(this);
        this.one3.setRotationPoint(-0.2F, 0.0F, 0.0F);
        this.fan.addChild(this.one3);
        this.setRotation(this.one3, 0.0F, 0.0F, -2.5307F);
        this.one3.setTextureOffset(21, 0).addBox(-3.0F, -0.45F, -0.5F, 3, 1, 1, -0.1F);
        this.one3.setTextureOffset(29, 0).addBox(-3.0F, 0.35F, -0.5F, 2, 1, 1, -0.1F);
        this.one3.setTextureOffset(0, 29).addBox(-3.0F, -1.25F, -0.5F, 2, 1, 1, -0.1F);
        this.one3.setTextureOffset(18, 4).addBox(-3.8F, -0.45F, -0.5F, 1, 1, 1, -0.1F);
        this.corner = new MModelRenderer(this);
        this.corner.setRotationPoint(0.0F, 0.0F, -0.2F);
        this.main.addChild(this.corner);
        this.corner.setTextureOffset(7, 9).addBox(-1.0F, -12.2F, -1.3F, 2, 1, 3, -0.1F);
        this.corner.setTextureOffset(0, 12).addBox(-1.0F, -3.5F, -1.3F, 2, 1, 3, -0.1F);
        this.corner.setTextureOffset(5, 18).addBox(4.0F, -8.2F, -1.3F, 1, 2, 3, -0.1F);
        this.corner.setTextureOffset(12, 16).addBox(-5.0F, -8.2F, -1.3F, 1, 2, 3, -0.1F);
        this.corner.setTextureOffset(0, 16).addBox(-4.2F, -10.0F, -1.3F, 1, 2, 3, -0.1F);
        this.corner.setTextureOffset(19, 8).addBox(-3.6F, -10.8F, -1.3F, 1, 1, 3, -0.1F);
        this.corner.setTextureOffset(19, 4).addBox(2.6F, -10.8F, -1.3F, 1, 1, 3, -0.1F);
        this.corner.setTextureOffset(17, 18).addBox(2.6F, -4.6F, -1.3F, 1, 1, 3, -0.1F);
        this.corner.setTextureOffset(16, 0).addBox(-3.6F, -4.6F, -1.3F, 1, 1, 3, -0.1F);
        this.corner.setTextureOffset(7, 13).addBox(3.2F, -6.4F, -1.3F, 1, 2, 3, -0.1F);
        this.corner.setTextureOffset(14, 6).addBox(3.2F, -10.0F, -1.3F, 1, 2, 3, -0.1F);
        this.corner.setTextureOffset(14, 11).addBox(-4.2F, -6.4F, -1.3F, 1, 2, 3, -0.1F);
        this.corner.setTextureOffset(9, 1).addBox(-2.8F, -4.3F, -1.3F, 2, 1, 3, -0.1F);
        this.corner.setTextureOffset(0, 4).addBox(0.8F, -11.4F, -1.3F, 2, 1, 3, -0.1F);
        this.corner.setTextureOffset(7, 5).addBox(-2.8F, -11.4F, -1.3F, 2, 1, 3, -0.1F);
        this.corner.setTextureOffset(0, 8).addBox(0.8F, -4.3F, -1.3F, 2, 1, 3, -0.1F);
        this.case2 = new MModelRenderer(this);
        this.case2.setRotationPoint(0.0F, -7.3F, 1.1F);
        this.main.addChild(this.case2);
        this.setRotation(this.case2, -3.1416F, 0.0F, 3.1416F);
        this.case2.setTextureOffset(17, 25).addBox(-0.5F, -1.5F, 2.4F, 1, 3, 1, 0.005F);
        this.case2.setTextureOffset(17, 16).addBox(-1.5F, -0.5F, 2.4F, 3, 1, 1, 0.0F);
        this.case2.setTextureOffset(10, 31).addBox(-0.5F, 2.2F, 2.0F, 1, 2, 1, -0.3F);
        this.case2.setTextureOffset(31, 9).addBox(-0.5F, 0.8F, 2.4F, 1, 2, 1, -0.3F);
        this.case2.setTextureOffset(30, 17).addBox(-0.5F, -4.3F, 2.0F, 1, 2, 1, -0.3F);
        this.case2.setTextureOffset(17, 29).addBox(-0.5F, -2.9F, 2.4F, 1, 2, 1, -0.3F);
        this.case2.setTextureOffset(24, 4).addBox(-4.4F, -0.4F, 2.0F, 2, 1, 1, -0.3F);
        this.case2.setTextureOffset(24, 2).addBox(-3.0F, -0.4F, 2.4F, 2, 1, 1, -0.3F);
        this.case2.setTextureOffset(4, 23).addBox(1.0F, -0.4F, 2.4F, 2, 1, 1, -0.3F);
        this.case2.setTextureOffset(22, 22).addBox(2.4F, -0.4F, 2.0F, 2, 1, 1, -0.3F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.case2.addChild(this.bone7);
        this.setRotation(this.bone7, 0.0F, 0.0F, -0.7854F);
        this.bone7.setTextureOffset(0, 31).addBox(-0.5F, 2.2F, -1.0F, 1, 2, 1, -0.3F);
        this.bone7.setTextureOffset(4, 25).addBox(-0.5F, -0.2F, -0.6F, 1, 3, 1, -0.3F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.case2.addChild(this.bone8);
        this.setRotation(this.bone8, 0.0F, 0.0F, 2.3126F);
        this.bone8.setTextureOffset(29, 30).addBox(-0.5F, 2.2F, -1.0F, 1, 2, 1, -0.3F);
        this.bone8.setTextureOffset(23, 24).addBox(-0.5F, -0.2F, -0.6F, 1, 3, 1, -0.3F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.case2.addChild(this.bone9);
        this.setRotation(this.bone9, 0.0F, 0.0F, -2.3126F);
        this.bone9.setTextureOffset(30, 26).addBox(-0.5F, 2.2F, -1.0F, 1, 2, 1, -0.3F);
        this.bone9.setTextureOffset(13, 24).addBox(-0.5F, -0.2F, -0.6F, 1, 3, 1, -0.3F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.case2.addChild(this.bone10);
        this.setRotation(this.bone10, 0.0F, 0.0F, 0.7854F);
        this.bone10.setTextureOffset(21, 30).addBox(-0.5F, 2.2F, -1.0F, 1, 2, 1, -0.3F);
        this.bone10.setTextureOffset(9, 24).addBox(-0.5F, -0.2F, -0.6F, 1, 3, 1, -0.3F);
        this.caze = new MModelRenderer(this);
        this.caze.setRotationPoint(0.0F, 0.0F, -0.2F);
        this.main.addChild(this.caze);
        this.caze.setTextureOffset(13, 28).addBox(-0.5F, -8.8F, 1.4F, 1, 3, 1, 0.005F);
        this.caze.setTextureOffset(19, 12).addBox(-1.5F, -7.8F, 1.4F, 3, 1, 1, 0.0F);
        this.caze.setTextureOffset(22, 33).addBox(-0.5F, -5.1F, 1.0F, 1, 2, 1, -0.3F);
        this.caze.setTextureOffset(33, 19).addBox(-0.5F, -6.5F, 1.4F, 1, 2, 1, -0.3F);
        this.caze.setTextureOffset(32, 32).addBox(-0.5F, -11.6F, 1.0F, 1, 2, 1, -0.3F);
        this.caze.setTextureOffset(18, 32).addBox(-0.5F, -10.2F, 1.4F, 1, 2, 1, -0.3F);
        this.caze.setTextureOffset(20, 28).addBox(-4.4F, -7.7F, 1.0F, 2, 1, 1, -0.3F);
        this.caze.setTextureOffset(7, 28).addBox(-3.0F, -7.7F, 1.4F, 2, 1, 1, -0.3F);
        this.caze.setTextureOffset(26, 11).addBox(1.0F, -7.7F, 1.4F, 2, 1, 1, -0.3F);
        this.caze.setTextureOffset(27, 20).addBox(2.4F, -7.7F, 1.0F, 2, 1, 1, -0.3F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, -7.3F, 2.0F);
        this.caze.addChild(this.bone4);
        this.setRotation(this.bone4, 0.0F, 0.0F, -0.7854F);
        this.bone4.setTextureOffset(31, 22).addBox(-0.5F, 2.2F, -1.0F, 1, 2, 1, -0.3F);
        this.bone4.setTextureOffset(26, 7).addBox(-0.5F, -0.2F, -0.6F, 1, 3, 1, -0.3F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, -7.3F, 2.0F);
        this.caze.addChild(this.bone3);
        this.setRotation(this.bone3, 0.0F, 0.0F, 2.3126F);
        this.bone3.setTextureOffset(25, 31).addBox(-0.5F, 2.2F, -1.0F, 1, 2, 1, -0.3F);
        this.bone3.setTextureOffset(26, 16).addBox(-0.5F, -0.2F, -0.6F, 1, 3, 1, -0.3F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, -7.3F, 2.0F);
        this.caze.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 0.0F, -2.3126F);
        this.bone2.setTextureOffset(4, 32).addBox(-0.5F, 2.2F, -1.0F, 1, 2, 1, -0.3F);
        this.bone2.setTextureOffset(27, 23).addBox(-0.5F, -0.2F, -0.6F, 1, 3, 1, -0.3F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -7.3F, 2.0F);
        this.caze.addChild(this.bone);
        this.setRotation(this.bone, 0.0F, 0.0F, 0.7854F);
        this.bone.setTextureOffset(14, 32).addBox(-0.5F, 2.2F, -1.0F, 1, 2, 1, -0.3F);
        this.bone.setTextureOffset(26, 27).addBox(-0.5F, -0.2F, -0.6F, 1, 3, 1, -0.3F);
        this.setTexture(new ResourceLocation("minidot", "pets/fan_pet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/fan_pet_animation.json"));
        this.animation = bbanimationloader.mustGet("fan", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.05F;
        GlStateManager.translate(0.6F, -1.1F + f, 0.25F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.04F + (float)number) * 30.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.4F, 1.4F, 1.4F);
        GlStateManager.translate(0.0F, -0.6F, 0.0F);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0412\u0435\u043d\u0442\u0438\u043b\u044f\u0442\u043e\u0440";
    }
}
