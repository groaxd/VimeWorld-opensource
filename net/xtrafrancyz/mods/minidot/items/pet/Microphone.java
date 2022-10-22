package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class Microphone extends BasePet
{
    private final MModelRenderer Microphone;
    private final MModelRenderer Ring;
    private final MModelRenderer Rukoyat;
    private final MModelRenderer Sphere;
    private final MModelRenderer Button;
    private final MModelRenderer RedNote;
    private final MModelRenderer GreenNote;
    private final MModelRenderer BlueNote;
    private final String color;
    private final IAnimation anim;

    public Microphone(String color)
    {
        this.color = color;
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Microphone = new MModelRenderer(this);
        this.Microphone.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Ring = new MModelRenderer(this);
        this.Ring.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Microphone.addChild(this.Ring);
        this.Ring.setTextureOffset(7, 26).addBox(-3.0001F, -12.5001F, -1.0F, 1, 1, 2, 0.0F);
        this.Ring.setTextureOffset(5, 22).addBox(2.0001F, -12.5001F, -1.0F, 1, 1, 2, 0.0F);
        this.Ring.setTextureOffset(14, 32).addBox(-3.0F, -12.5F, -1.75F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(10, 32).addBox(-2.75F, -12.5001F, -2.25F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(4, 32).addBox(-2.25F, -12.5F, -2.75F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(31, 19).addBox(-1.75F, -12.5001F, -3.0F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(32, 13).addBox(-3.0F, -12.5F, 0.75F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(28, 8).addBox(2.0F, -12.5F, 0.75F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(13, 22).addBox(2.0F, -12.5F, -1.75F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(28, 4).addBox(-1.0F, -12.5F, 2.0001F, 2, 1, 1, 0.0F);
        this.Ring.setTextureOffset(20, 27).addBox(-1.0F, -12.5F, -3.0001F, 2, 1, 1, 0.0F);
        this.Ring.setTextureOffset(31, 17).addBox(-2.75F, -12.5001F, 1.25F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(28, 16).addBox(1.75F, -12.5001F, 1.25F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(5, 19).addBox(1.75F, -12.5001F, -2.25F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(31, 15).addBox(-2.25F, -12.5F, 1.75F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(31, 6).addBox(1.25F, -12.5F, 1.75F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(10, 10).addBox(1.25F, -12.5F, -2.75F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(31, 11).addBox(-1.75F, -12.5001F, 2.0F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(31, 9).addBox(0.75F, -12.5001F, 2.0F, 1, 1, 1, 0.0F);
        this.Ring.setTextureOffset(6, 0).addBox(0.75F, -12.5001F, -3.0F, 1, 1, 1, 0.0F);
        this.Rukoyat = new MModelRenderer(this);
        this.Rukoyat.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.Microphone.addChild(this.Rukoyat);
        this.Rukoyat.setTextureOffset(6, 10).addBox(0.5F, -9.0F, -1.0F, 1, 7, 2, 0.0F);
        this.Rukoyat.setTextureOffset(0, 9).addBox(-1.5F, -9.0F, -1.0F, 1, 7, 2, 0.0F);
        this.Rukoyat.setTextureOffset(25, 20).addBox(-1.0F, -2.5F, -1.0F, 2, 1, 2, 0.0F);
        this.Rukoyat.setTextureOffset(0, 2).addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
        this.Rukoyat.setTextureOffset(17, 16).addBox(-1.0F, -9.0F, -1.5F, 2, 7, 1, 0.0F);
        this.Rukoyat.setTextureOffset(36, 0).addBox(-2.0F, -10.0F, -2.0F, 4, 1, 4, 0.0F);
        this.Rukoyat.setTextureOffset(17, 4).addBox(-1.0F, -9.0F, 0.5F, 2, 7, 1, 0.0F);
        this.Sphere = new MModelRenderer(this);
        this.Sphere.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Microphone.addChild(this.Sphere);
        this.Sphere.setTextureOffset(13, 24).addBox(-2.0F, -10.5F, -1.5F, 1, 1, 3, 0.0F);
        this.Sphere.setTextureOffset(20, 21).addBox(-2.0F, -14.5F, -1.5F, 1, 1, 3, 0.0F);
        this.Sphere.setTextureOffset(28, 2).addBox(-1.5F, -10.5F, 1.0F, 3, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(18, 25).addBox(-1.5F, -14.5F, 1.0F, 3, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(8, 4).addBox(-1.5F, -14.5F, -2.0F, 3, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(5, 6).addBox(-1.5F, -14.75F, -1.5F, 3, 1, 3, 0.0F);
        this.Sphere.setTextureOffset(0, 28).addBox(-1.5F, -11.0F, 1.5F, 3, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(25, 26).addBox(-1.5F, -14.0F, 1.5F, 3, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(27, 24).addBox(-1.5F, -11.0F, -2.5F, 3, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(0, 26).addBox(-1.5F, -14.0F, -2.5F, 3, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(23, 8).addBox(1.5F, -11.0F, -1.5F, 1, 1, 3, 0.0F);
        this.Sphere.setTextureOffset(0, 30).addBox(1.5F, -13.5F, -2.0F, 1, 3, 1, 0.0F);
        this.Sphere.setTextureOffset(28, 12).addBox(1.5F, -13.5F, 1.0F, 1, 3, 1, 0.0F);
        this.Sphere.setTextureOffset(8, 22).addBox(1.5F, -14.0F, -1.5F, 1, 1, 3, 0.0F);
        this.Sphere.setTextureOffset(29, 28).addBox(-2.5F, -13.5F, -2.0F, 1, 3, 1, 0.0F);
        this.Sphere.setTextureOffset(25, 28).addBox(-2.5F, -13.5F, 1.0F, 1, 3, 1, 0.0F);
        this.Sphere.setTextureOffset(9, 16).addBox(-2.75F, -13.5F, -1.5F, 1, 3, 3, 0.0F);
        this.Sphere.setTextureOffset(12, 10).addBox(1.75F, -13.5F, -1.5F, 1, 3, 3, 0.0F);
        this.Sphere.setTextureOffset(20, 29).addBox(-2.0F, -13.5F, 1.5F, 1, 3, 1, 0.0F);
        this.Sphere.setTextureOffset(16, 28).addBox(1.0F, -13.5F, 1.5F, 1, 3, 1, 0.0F);
        this.Sphere.setTextureOffset(20, 12).addBox(-1.5F, -13.5F, 1.75F, 3, 3, 1, 0.0F);
        this.Sphere.setTextureOffset(20, 0).addBox(-1.5F, -13.5F, -2.75F, 3, 3, 1, 0.0F);
        this.Sphere.setTextureOffset(7, 29).addBox(-2.0F, -13.5F, -2.5F, 1, 3, 1, 0.0F);
        this.Sphere.setTextureOffset(12, 28).addBox(1.0F, -13.5F, -2.5F, 1, 3, 1, 0.0F);
        this.Sphere.setTextureOffset(23, 4).addBox(-2.5F, -11.0F, -1.5F, 1, 1, 3, 0.0F);
        this.Sphere.setTextureOffset(0, 22).addBox(-2.5F, -14.0F, -1.5F, 1, 1, 3, 0.0F);
        this.Sphere.setTextureOffset(33, 29).addBox(-2.0F, -11.0F, 1.0F, 1, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(32, 27).addBox(-2.0F, -14.0F, 1.0F, 1, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(17, 33).addBox(-2.0F, -11.0F, -2.0F, 1, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(7, 33).addBox(1.0F, -11.0F, -2.0F, 1, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(31, 32).addBox(1.0F, -11.0F, 1.0F, 1, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(27, 32).addBox(1.0F, -14.0F, 1.0F, 1, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(23, 32).addBox(1.0F, -14.0F, -2.0F, 1, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(32, 22).addBox(-2.0F, -14.0F, -2.0F, 1, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(28, 0).addBox(-1.5F, -10.5F, -2.0F, 3, 1, 1, 0.0F);
        this.Sphere.setTextureOffset(23, 16).addBox(1.0F, -10.5F, -1.5F, 1, 1, 3, 0.0F);
        this.Sphere.setTextureOffset(0, 18).addBox(1.0F, -14.5F, -1.5F, 1, 1, 3, 0.0F);
        this.Button = new MModelRenderer(this);
        this.Button.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Microphone.addChild(this.Button);
        this.Button.setTextureOffset(0, 0).addBox(-0.5F, -6.5F, -1.75F, 1, 1, 1, 0.0F);
        this.RedNote = new MModelRenderer(this);
        this.RedNote.setRotationPoint(-5.0F, -15.5F, 0.0F);
        this.Microphone.addChild(this.RedNote);
        this.RedNote.setTextureOffset(0, 5).addBox(-1.5F, -1.5F, 0.0F, 3, 3, 0, 0.0F);
        this.GreenNote = new MModelRenderer(this);
        this.GreenNote.setRotationPoint(0.0F, -18.5F, 0.0F);
        this.Microphone.addChild(this.GreenNote);
        this.GreenNote.setTextureOffset(0, 34).addBox(-1.5F, -1.5F, 0.0F, 3, 3, 0, 0.0F);
        this.BlueNote = new MModelRenderer(this);
        this.BlueNote.setRotationPoint(5.0F, -15.5F, 0.0F);
        this.Microphone.addChild(this.BlueNote);
        this.BlueNote.setTextureOffset(7, 35).addBox(-1.5F, -1.5F, 0.0F, 3, 3, 0, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/microphone_" + color + ".png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/microphone_animation.json"));
        this.anim = bbanimationloader.mustGet("microphone.anim", this);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.translate(0.6F, -0.9F - f, 0.3F);
        float f1 = 0.85F;
        GlStateManager.scale(f1, f1, f1);
        this.anim.tick(time);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, -0.5D, 0.0D);
        float f = 1.2F;
        GlStateManager.scale(f, f, f);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "EvilBendy";
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -734239628:
                if (s.equals("yellow"))
                {
                    b0 = 3;
                }

                break;

            case 112785:
                if (s.equals("red"))
                {
                    b0 = 0;
                }

                break;

            case 3027034:
                if (s.equals("blue"))
                {
                    b0 = 2;
                }

                break;

            case 98619139:
                if (s.equals("green"))
                {
                    b0 = 1;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0439 \u043c\u0438\u043a\u0440\u043e\u0444\u043e\u043d";

            case 1:
                return "\u0417\u0435\u043b\u0451\u043d\u044b\u0439 \u043c\u0438\u043a\u0440\u043e\u0444\u043e\u043d";

            case 2:
                return "\u0421\u0438\u043d\u0438\u0439 \u043c\u0438\u043a\u0440\u043e\u0444\u043e\u043d";

            case 3:
                return "\u0416\u0451\u043b\u0442\u044b\u0439 \u043c\u0438\u043a\u0440\u043e\u0444\u043e\u043d";

            default:
                return "\u041c\u0438\u043a\u0440\u043e\u0444\u043e\u043d";
        }
    }
}
