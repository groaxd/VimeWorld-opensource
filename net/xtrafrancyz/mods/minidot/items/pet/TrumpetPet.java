package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class TrumpetPet extends BasePet
{
    private final MModelRenderer tube;
    private final MModelRenderer tube5;
    private final MModelRenderer doot;
    private final MModelRenderer doot7;
    private final MModelRenderer doot1;
    private final MModelRenderer finger1;
    private final MModelRenderer finger2;
    private final MModelRenderer finger3;
    private final MModelRenderer finger4;
    private final MModelRenderer finger5;
    private final MModelRenderer base;
    private final MModelRenderer finger1top;
    private final MModelRenderer finger2top;
    private final MModelRenderer finger3top;
    private final MModelRenderer finger4top;
    private final MModelRenderer finger5top;
    private final MModelRenderer jaw1;
    private final MModelRenderer Head;
    private final IAnimation animation;

    public TrumpetPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.useDisplayLists = true;
        this.tube = new MModelRenderer(this);
        this.tube.setRotationPoint(-11.0F, -28.0F, -1.0F);
        this.tube.cubeList.add(new ModelBox(this.tube, 0, 34, -0.5F, 3.5F, -14.1F, 1, 1, 10, 0.0F, true));
        this.tube.cubeList.add(new ModelBox(this.tube, 0, 48, -0.5F, 4.0F, -14.6333F, 1, 2, 1, -5.0E-4F, true));
        this.tube.cubeList.add(new ModelBox(this.tube, 0, 46, -0.5F, 5.5F, -14.1F, 1, 1, 7, 0.0F, true));
        this.tube.cubeList.add(new ModelBox(this.tube, 0, 47, -0.5F, 3.0F, -7.6333F, 1, 3, 1, -5.0E-4F, true));
        this.tube5 = new MModelRenderer(this);
        this.tube5.setRotationPoint(-11.0F, -25.25F, -13.6F);
        this.tube5.cubeList.add(new ModelBox(this.tube5, 0, 33, -0.5F, -0.5F, -5.5F, 1, 1, 11, 0.0F, true));
        this.doot = new MModelRenderer(this);
        this.doot.setRotationPoint(-11.0F, -25.2F, -19.5056F);
        this.doot.cubeList.add(new ModelBox(this.doot, 0, 34, -1.0F, -1.0F, 0.4056F, 2, 2, 2, 0.0F, true));
        this.doot7 = new MModelRenderer(this);
        this.doot7.setRotationPoint(-11.0F, -25.2F, -19.5056F);
        this.doot7.cubeList.add(new ModelBox(this.doot7, 0, 39, -2.5F, -1.5F, -0.8611F, 1, 3, 1, 0.0F, true));
        this.doot7.cubeList.add(new ModelBox(this.doot7, 0, 55, -2.5F, -2.5F, -0.8611F, 5, 1, 1, 0.0F, true));
        this.doot7.cubeList.add(new ModelBox(this.doot7, 0, 39, 1.5F, -1.5F, -0.8611F, 1, 3, 1, 0.0F, true));
        this.doot7.cubeList.add(new ModelBox(this.doot7, 0, 55, -2.5F, 1.5F, -0.8611F, 5, 1, 1, 0.0F, true));
        this.doot1 = new MModelRenderer(this);
        this.doot1.setRotationPoint(-11.0F, -25.2F, -19.5056F);
        this.doot1.cubeList.add(new ModelBox(this.doot1, 15, 34, -1.5F, -1.5F, -0.4611F, 3, 3, 1, 0.0F, true));
        this.finger1 = new MModelRenderer(this);
        this.finger1.setRotationPoint(-11.0F, -28.0F, -1.0F);
        this.setRotation(this.finger1, -0.2974F, 0.0F, 0.0F);
        this.finger1.cubeList.add(new ModelBox(this.finger1, 0, 0, 0.5F, 6.0F, -7.6333F, 1, 3, 1, 0.0F, true));
        this.finger2 = new MModelRenderer(this);
        this.finger2.setRotationPoint(-11.0F, -28.0F, -1.0F);
        this.setRotation(this.finger2, -0.1302F, 0.0F, 0.0F);
        this.finger2.cubeList.add(new ModelBox(this.finger2, 0, 0, 0.5F, 5.0F, -9.8333F, 1, 3, 1, 0.0F, true));
        this.finger3 = new MModelRenderer(this);
        this.finger3.setRotationPoint(-11.0F, -28.0F, -1.0F);
        this.setRotation(this.finger3, 0.0744F, 0.0F, 0.0F);
        this.finger3.cubeList.add(new ModelBox(this.finger3, 0, 0, 0.5F, 2.8F, -11.8333F, 1, 3, 1, 0.0F, true));
        this.finger4 = new MModelRenderer(this);
        this.finger4.setRotationPoint(-11.0F, -28.0F, -1.0F);
        this.setRotation(this.finger4, 0.1487F, 0.0F, 0.0F);
        this.finger4.cubeList.add(new ModelBox(this.finger4, 0, 0, 0.5F, 2.2667F, -13.0333F, 1, 3, 1, 0.0F, true));
        this.finger5 = new MModelRenderer(this);
        this.finger5.setRotationPoint(-11.0F, -28.0F, -1.0F);
        this.setRotation(this.finger5, 0.2603F, 0.0F, 0.0F);
        this.finger5.cubeList.add(new ModelBox(this.finger5, 0, 0, 0.5F, 1.2F, -14.2333F, 1, 2, 1, 0.0F, true));
        this.base = new MModelRenderer(this);
        this.base.setRotationPoint(-11.0F, -28.0F, -1.0F);
        this.setRotation(this.base, 0.0372F, 0.0F, 0.1115F);
        this.base.cubeList.add(new ModelBox(this.base, 0, 6, 1.5667F, 5.2667F, -12.7F, 1, 2, 3, 0.0F, true));
        this.finger1top = new MModelRenderer(this);
        this.finger1top.setRotationPoint(-11.0F, -28.0F, -1.0F);
        this.setRotation(this.finger1top, -0.2974F, 0.0F, -0.3718F);
        this.finger1top.cubeList.add(new ModelBox(this.finger1top, 0, 0, -1.1667F, 5.0F, -7.6333F, 1, 1, 1, 0.0F, true));
        this.finger2top = new MModelRenderer(this);
        this.finger2top.setRotationPoint(-11.0F, -28.0F, -1.0F);
        this.setRotation(this.finger2top, -0.1302F, 0.0F, -0.2974F);
        this.finger2top.cubeList.add(new ModelBox(this.finger2top, 0, 0, -0.5667F, 2.1333F, -9.8333F, 1, 3, 1, 0.0F, true));
        this.finger3top = new MModelRenderer(this);
        this.finger3top.setRotationPoint(-11.0F, -28.0F, -1.0F);
        this.setRotation(this.finger3top, 0.0744F, 0.0F, -0.2603F);
        this.finger3top.cubeList.add(new ModelBox(this.finger3top, 0, 0, -0.3667F, -0.2667F, -11.8333F, 1, 3, 1, 0.0F, true));
        this.finger4top = new MModelRenderer(this);
        this.finger4top.setRotationPoint(-11.0F, -28.0F, -1.0F);
        this.setRotation(this.finger4top, 0.1487F, 0.0F, -0.2231F);
        this.finger4top.cubeList.add(new ModelBox(this.finger4top, 0, 0, -0.3F, -0.7333F, -13.0333F, 1, 3, 1, 0.0F, true));
        this.finger5top = new MModelRenderer(this);
        this.finger5top.setRotationPoint(-11.0F, -28.0F, -1.0F);
        this.setRotation(this.finger5top, 0.2603F, 0.0F, -0.2231F);
        this.finger5top.cubeList.add(new ModelBox(this.finger5top, 0, 0, -0.3667F, -0.8F, -14.2333F, 1, 2, 1, 0.0F, true));
        this.jaw1 = new MModelRenderer(this);
        this.jaw1.setRotationPoint(-11.0F, -24.4F, -3.6F);
        this.setRotation(this.jaw1, 0.522F, 0.0F, 0.0F);
        this.jaw1.cubeList.add(new ModelBox(this.jaw1, 20, 11, -2.0F, -0.5F, -2.5F, 4, 1, 5, -5.0E-4F, true));
        this.Head = new MModelRenderer(this);
        this.Head.cubeList.add(new ModelBox(this.Head, 26, 0, -13.0F, -26.0F, -5.2F, 4, 2, 5, 0.0F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 12, -13.5F, -26.0F, -3.1F, 5, 2, 3, 0.0F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 22, 23, -8.2F, -27.0F, -4.7F, 1, 1, 3, 0.0F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 40, 5, -13.5F, -32.4F, -4.0F, 5, 1, 5, 0.0F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 29, 25, -14.5F, -27.0F, -5.0F, 7, 1, 6, -5.0E-4F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 33, 19, -15.0F, -31.0F, -1.5F, 8, 3, 3, -5.0E-4F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 33, 11, -15.0F, -31.0F, -4.5F, 8, 2, 6, 0.0F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 22, 23, -14.75F, -27.0F, -4.7F, 1, 1, 3, 0.0F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 22, 19, -10.35F, -26.6333F, -5.1995F, 2, 1, 2, 0.0F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 22, 19, -13.65F, -26.6333F, -5.1995F, 2, 1, 2, 0.0F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 19, -14.5F, -27.6333F, -5.2F, 3, 1, 1, 0.0F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 34, 11, -14.0F, -31.8F, -4.5F, 6, 1, 6, 0.0F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 5, 0, -15.0F, -29.9F, -5.2F, 1, 3, 1, -5.0E-4F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 17, -15.0F, -30.75F, -5.2F, 8, 1, 1, 0.0F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 5, 0, -8.0F, -29.9F, -5.2F, 1, 3, 1, -5.0E-4F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 34, 11, -14.5F, -31.3F, -4.5F, 7, 1, 6, -5.0E-4F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 23, -12.0F, -30.6333F, -5.1995F, 2, 3, 1, 0.0F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 19, -10.5F, -27.6333F, -5.2F, 3, 1, 1, 0.0F, true));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 21, -14.5F, -31.0F, -5.0F, 7, 4, 7, 0.0F, true));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/trumpet_animation.json"));
        this.animation = bbanimationloader.mustGet("Trumpet", this);
        this.setTexture(new ResourceLocation("minidot", "pets/trumpet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.translate(1.2F, 0.5F + f, 0.4F);
        this.animation.tickDelayed(time, 3.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.4F, 1.0F, 0.25F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0438\u0441\u0442\u0435\u0440 \u0414\u0443\u0434\u0435\u0446";
    }

    public String getCreator()
    {
        return "Ursun";
    }
}
