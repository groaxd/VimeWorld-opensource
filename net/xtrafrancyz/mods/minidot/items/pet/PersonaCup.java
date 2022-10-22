package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class PersonaCup extends BasePet
{
    private final MModelRenderer top;
    private final MModelRenderer mid;
    private final MModelRenderer down;
    private final MModelRenderer rear1;
    private final MModelRenderer rear2;
    private final MModelRenderer lear1;
    private final MModelRenderer lear2;
    private final MModelRenderer rhand1;
    private final MModelRenderer rhand2;
    private final MModelRenderer lhand1;
    private final MModelRenderer lnahd2;
    private final MModelRenderer rleg1;
    private final MModelRenderer rleg2;
    private final MModelRenderer lleg1;
    private final MModelRenderer lleg2;
    private final MModelRenderer body;
    private final MModelRenderer body2;
    private final MModelRenderer body3;
    private final MModelRenderer handle;
    private final MModelRenderer handlebot;
    private final MModelRenderer topborder1;
    private final MModelRenderer topborder2;
    private final MModelRenderer topborder3;
    private final MModelRenderer topborder4;
    private final MModelRenderer grip1;
    private final MModelRenderer grip2;
    private final MModelRenderer base;
    private final MModelRenderer handletop1;
    private final MModelRenderer base1;

    public PersonaCup()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.topborder2 = new MModelRenderer(this, 41, 0);
        this.topborder2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.topborder2.addBox(-9.1F, -16.7F, -1.6F, 1, 1, 3, 0.0F);
        this.setRotation(this.topborder2, 0.09440806F, 0.50702125F, 0.47224507F);
        this.grip2 = new MModelRenderer(this, 41, 0);
        this.grip2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.grip2.addBox(-10.6F, -16.366667F, -3.7333333F, 1, 2, 2, 0.0F);
        this.setRotation(this.grip2, 0.09440806F, 0.50702125F, 0.47224507F);
        this.rear2 = new MModelRenderer(this, 26, 20);
        this.rear2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rear2.addBox(2.0F, -15.833333F, -2.0F, 1, 2, 2, 0.0F);
        this.setRotation(this.rear2, -0.30183217F, 0.5201496F, -0.3010693F);
        this.rhand2 = new MModelRenderer(this, 24, 16);
        this.rhand2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rhand2.addBox(-12.0F, -9.166667F, -0.46666667F, 3, 1, 1, 0.0F);
        this.setRotation(this.rhand2, 0.18753956F, 0.45372164F, 0.6731764F);
        this.base = new MModelRenderer(this, 48, 0);
        this.base.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.base.addBox(-12.1F, -15.7F, -2.6F, 4, 3, 4, 0.0F);
        this.setRotation(this.base, 0.09440806F, 0.50702125F, 0.47224507F);
        this.lleg2 = new MModelRenderer(this, 26, 19);
        this.lleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lleg2.addBox(-0.46666667F, -8.9F, -1.4666667F, 1, 3, 2, 0.0F);
        this.setRotation(this.lleg2, 0.040414974F, 0.546969F, 0.21812077F);
        this.topborder3 = new MModelRenderer(this, 41, 0);
        this.topborder3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.topborder3.addBox(-12.1F, -16.7F, -1.6F, 1, 1, 3, 0.0F);
        this.setRotation(this.topborder3, 0.09440806F, 0.50702125F, 0.47224507F);
        this.handle = new MModelRenderer(this, 41, 0);
        this.handle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.handle.addBox(-10.6F, -12.433333F, -1.0666667F, 1, 3, 1, 0.0F);
        this.setRotation(this.handle, 0.09440806F, 0.50702125F, 0.47224507F);
        this.topborder4 = new MModelRenderer(this, 41, 0);
        this.topborder4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.topborder4.addBox(-12.1F, -16.7F, -2.6F, 4, 1, 1, 0.0F);
        this.setRotation(this.topborder4, 0.09440806F, 0.50702125F, 0.47224507F);
        this.lear2 = new MModelRenderer(this, 26, 19);
        this.lear2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lear2.addBox(-2.0F, -16.5F, -2.0F, 1, 3, 2, 0.0F);
        this.setRotation(this.lear2, -0.011596803F, 0.5422981F, 0.26124495F);
        this.handlebot = new MModelRenderer(this, 41, 0);
        this.handlebot.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.handlebot.addBox(-11.1F, -9.633333F, -1.6F, 2, 1, 2, 0.0F);
        this.setRotation(this.handlebot, 0.09440806F, 0.50702125F, 0.47224507F);
        this.lleg1 = new MModelRenderer(this, 26, 19);
        this.lleg1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lleg1.addBox(1.8333334F, -8.366667F, -1.431F, 1, 3, 2, 0.0F);
        this.setRotation(this.lleg1, -0.18912941F, 0.546969F, -0.21812077F);
        this.base1 = new MModelRenderer(this, 38, 0);
        this.base1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.base1.addBox(-11.6F, -12.9F, -2.0666666F, 3, 1, 3, 0.0F);
        this.setRotation(this.base1, 0.09440806F, 0.50702125F, 0.47224507F);
        this.rear1 = new MModelRenderer(this, 26, 19);
        this.rear1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rear1.addBox(3.0F, -15.5F, -2.0F, 1, 3, 2, 0.0F);
        this.setRotation(this.rear1, -0.37153745F, 0.51560605F, -0.43076515F);
        this.lnahd2 = new MModelRenderer(this, 24, 16);
        this.lnahd2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lnahd2.addBox(-6.0F, -10.5F, -2.0F, 3, 1, 1, 0.0F);
        this.setRotation(this.lnahd2, 0.08243188F, 0.24413739F, 0.77205396F);
        this.topborder1 = new MModelRenderer(this, 41, 0);
        this.topborder1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.topborder1.addBox(-11.1F, -16.7F, 0.4F, 2, 1, 1, 0.0F);
        this.setRotation(this.topborder1, 0.09440806F, 0.50702125F, 0.47224507F);
        this.lear1 = new MModelRenderer(this, 26, 19);
        this.lear1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lear1.addBox(1.0F, -16.5F, -2.0F, 1, 3, 2, 0.0F);
        this.setRotation(this.lear1, -0.14871444F, 0.5576792F, 0.0F);
        this.lhand1 = new MModelRenderer(this, 24, 16);
        this.lhand1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lhand1.addBox(-9.666667F, -9.0F, -1.4666667F, 3, 1, 1, 0.0F);
        this.setRotation(this.lhand1, 0.20508282F, 0.20018525F, 1.0769038F);
        this.body3 = new MModelRenderer(this, 20, 0);
        this.body3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body3.addBox(-3.0F, -14.17F, -2.0F, 6, 6, 4, -0.6F);
        this.setRotation(this.body3, -0.14870206F, 0.5576327F, 0.0F);
        this.rleg2 = new MModelRenderer(this, 26, 19);
        this.rleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rleg2.addBox(1.7666667F, -8.833333F, -1.41F, 1, 3, 2, 0.0F);
        this.setRotation(this.rleg2, -0.33725724F, 0.4977132F, -0.51331484F);
        this.rhand1 = new MModelRenderer(this, 22, 16);
        this.rhand1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rhand1.addBox(-13.6F, -5.9F, -0.2F, 4, 1, 1, 0.0F);
        this.setRotation(this.rhand1, 0.3366726F, 0.38536838F, 0.9516386F);
        this.body2 = new MModelRenderer(this, 20, 0);
        this.body2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body2.addBox(-3.0F, -14.17F, -4.0F, 6, 6, 4, -0.6F);
        this.setRotation(this.body2, -0.14870206F, 0.5576327F, 0.0F);
        this.down = new MModelRenderer(this, 33, 8);
        this.down.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.down.addBox(-3.5F, -4.0F, -3.5F, 7, 1, 7, 0.0F);
        this.mid = new MModelRenderer(this, 0, 17);
        this.mid.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mid.addBox(-2.5F, -6.3F, -2.5F, 5, 3, 5, 0.0F);
        this.rleg1 = new MModelRenderer(this, 26, 19);
        this.rleg1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rleg1.addBox(-1.5F, -8.366667F, -1.431F, 1, 3, 2, 0.0F);
        this.setRotation(this.rleg1, -0.028054891F, 0.5559566F, 0.08757253F);
        this.body = new MModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-3.0F, -14.166667F, -3.0F, 6, 6, 4, 0.0F);
        this.setRotation(this.body, -0.14871444F, 0.5576792F, 0.0F);
        this.grip1 = new MModelRenderer(this, 41, 0);
        this.grip1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.grip1.addBox(-10.6F, -16.4F, 0.46666667F, 1, 2, 2, 0.0F);
        this.setRotation(this.grip1, 0.09440806F, 0.50702125F, 0.47224507F);
        this.top = new MModelRenderer(this, 0, 25);
        this.top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.top.addBox(-3.0F, -6.5F, -3.0F, 6, 1, 6, 0.0F);
        this.handletop1 = new MModelRenderer(this, 41, 0);
        this.handletop1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.handletop1.addBox(-11.1F, -12.633333F, -1.6F, 2, 1, 2, 0.0F);
        this.setRotation(this.handletop1, 0.09440806F, 0.50702125F, 0.47224507F);
        this.setTexture(new ResourceLocation("minidot", "pets/persona_cup.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        float f1 = time * 1.5F;
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        GlStateManager.translate(0.6F, -0.1F + f, 0.3F);
        GlStateManager.rotate(90.0F + f1, 0.0F, 1.0F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.35F, 0.0F);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0443\u0431\u043e\u043a";
    }

    public String getCreator()
    {
        return "Ursun";
    }
}
