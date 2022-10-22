package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class BodyFlower extends BaseItem
{
    private final MModelRenderer flower;
    private final MModelRenderer flowersLep;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone8;
    private final MModelRenderer bone7;
    private final MModelRenderer bone6;
    private final MModelRenderer bone5;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final IAnimation anim;
    private final String color;

    public BodyFlower(String color)
    {
        super(ItemType.BODY);
        this.color = color;
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.flower = new MModelRenderer(this);
        this.flower.setRotationPoint(0.0F, 24.0F, 2.0F);
        this.flower.setTextureOffset(0, 11).addBox(-0.2F, -12.8F, -2.2F, 1, 4, 1, 0.0F);
        this.flower.setTextureOffset(0, 0).addBox(-0.8F, -14.6F, -4.3F, 2, 2, 2, 0.1F);
        this.flower.setTextureOffset(6, 9).addBox(0.3F, -12.8F, -3.4F, 2, 2, 1, 0.0F);
        this.flower.setTextureOffset(8, 0).addBox(-1.8F, -16.0F, -3.5F, 2, 2, 1, 0.0F);
        this.flower.setTextureOffset(0, 8).addBox(0.2F, -16.4F, -3.3F, 2, 2, 1, 0.0F);
        this.flower.setTextureOffset(0, 4).addBox(-1.7F, -12.8F, -3.6F, 2, 2, 1, 0.0F);
        this.flower.setTextureOffset(7, 3).addBox(1.0F, -14.6F, -3.5F, 2, 2, 1, 0.0F);
        this.flower.setTextureOffset(5, 6).addBox(-2.5F, -14.6F, -3.7F, 2, 2, 1, 0.0F);
        this.flowersLep = new MModelRenderer(this);
        this.flowersLep.setRotationPoint(0.6F, 1.8F, -0.3F);
        this.flower.addChild(this.flowersLep);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-0.3F, -15.2F, -2.8F);
        this.flowersLep.addChild(this.bone9);
        this.setRotation(this.bone9, 0.0F, 0.0F, -3.098F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(1.1F, -2.8F, 0.0F);
        this.bone9.addChild(this.bone10);
        this.setRotation(this.bone10, 0.0F, 0.3927F, -1.4399F);
        this.bone10.setTextureOffset(11, 8).addBox(-0.7F, -1.2F, -0.1F, 2, 2, 0, 0.0F);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-1.5F, -3.4F, -0.3F);
        this.bone9.addChild(this.bone11);
        this.setRotation(this.bone11, 0.0F, -0.5236F, 1.309F);
        this.bone11.setTextureOffset(11, 6).addBox(-0.7F, -1.2F, -0.1F, 2, 2, 0, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.8F, -18.0F, -2.8F);
        this.flowersLep.addChild(this.bone8);
        this.setRotation(this.bone8, 0.0F, 0.3927F, -1.4399F);
        this.bone8.setTextureOffset(4, 12).addBox(-0.7F, -1.2F, -0.1F, 2, 2, 0, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-1.8F, -18.6F, -3.1F);
        this.flowersLep.addChild(this.bone7);
        this.setRotation(this.bone7, 0.0F, -0.5236F, 1.309F);
        this.bone7.setTextureOffset(8, 12).addBox(-0.7F, -1.2F, -0.1F, 2, 2, 0, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-3.6F, -15.0F, -2.8F);
        this.flowersLep.addChild(this.bone6);
        this.setRotation(this.bone6, 0.0F, -0.3491F, 0.0F);
        this.bone6.setTextureOffset(12, 12).addBox(-0.7F, -1.2F, -0.1F, 2, 2, 0, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(2.4F, -15.0F, -2.7F);
        this.flowersLep.addChild(this.bone5);
        this.setRotation(this.bone5, 0.0F, 0.3491F, 0.0F);
        this.bone5.setTextureOffset(12, 10).addBox(-0.7F, -1.2F, -0.1F, 2, 2, 0, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(1.8F, -13.2F, -2.6F);
        this.flowersLep.addChild(this.bone3);
        this.setRotation(this.bone3, 0.0F, 0.3927F, 0.2618F);
        this.bone3.setTextureOffset(13, 3).addBox(-0.7F, -1.2F, -0.1F, 2, 2, 0, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-3.3F, -17.0F, -2.9F);
        this.flowersLep.addChild(this.bone4);
        this.setRotation(this.bone4, 0.0F, -0.3927F, 0.2618F);
        this.bone4.setTextureOffset(4, 14).addBox(-0.7F, -1.2F, -0.1F, 2, 2, 0, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-3.2F, -13.2F, -2.9F);
        this.flowersLep.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, -0.3927F, -0.2618F);
        this.bone2.setTextureOffset(8, 14).addBox(-0.7F, -1.2F, -0.1F, 2, 2, 0, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(2.1F, -16.8F, -2.6F);
        this.flowersLep.addChild(this.bone);
        this.setRotation(this.bone, 0.0F, 0.3927F, -0.4363F);
        this.bone.setTextureOffset(12, 14).addBox(-0.7F, -1.2F, -0.1F, 2, 2, 0, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "body/bodyflower_" + color + ".png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "body/bodyflower_animation.json"));
        this.anim = bbanimationloader.mustGet("flower.leaping", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.4F, 0.4F, 0.4F);

        if (player.inventory.armorItemInSlot(2) == null)
        {
            GlStateManager.translate(0.3F, -0.2F, -0.35F);
        }
        else
        {
            GlStateManager.translate(0.3F, -0.2F, -0.55F);
        }

        this.anim.tick(time);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.cos(rotation * 0.07F + (float)number) * 10.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.4F, 1.4F, 1.4F);
        GlStateManager.translate(0.0F, -0.25F, 0.2F);
        this.anim.tick(time);
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
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -976943172:
                if (s.equals("purple"))
                {
                    b0 = 4;
                }

                break;

            case 112785:
                if (s.equals("red"))
                {
                    b0 = 1;
                }

                break;

            case 3027034:
                if (s.equals("blue"))
                {
                    b0 = 2;
                }

                break;

            case 3441014:
                if (s.equals("pink"))
                {
                    b0 = 3;
                }

                break;

            case 113101865:
                if (s.equals("white"))
                {
                    b0 = 0;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0411\u0435\u043b\u044b\u0439 \u0446\u0432\u0435\u0442\u043e\u043a";

            case 1:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0439 \u0446\u0432\u0435\u0442\u043e\u043a";

            case 2:
                return "\u0421\u0438\u043d\u0438\u0439 \u0446\u0432\u0435\u0442\u043e\u043a";

            case 3:
                return "\u0420\u043e\u0437\u043e\u0432\u044b\u0439 \u0446\u0432\u0435\u0442\u043e\u043a";

            case 4:
                return "\u0424\u0438\u043e\u043b\u0435\u0442\u043e\u0432\u044b\u0439 \u0446\u0432\u0435\u0442\u043e\u043a";

            default:
                return "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 \u0446\u0432\u0435\u0442\u043e\u043a";
        }
    }
}
