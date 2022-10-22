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

public class MarioMushroom extends BasePet
{
    private final MModelRenderer Mushroom;
    private final MModelRenderer Hat;
    private final MModelRenderer Foot;
    private final MModelRenderer Eyes;
    private final String color;
    private final IAnimation animation;

    public MarioMushroom(String color)
    {
        this.color = color;
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Mushroom = new MModelRenderer(this);
        this.Mushroom.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Hat = new MModelRenderer(this);
        this.Hat.setRotationPoint(0.0F, 1.5F, -0.75F);
        this.Mushroom.addChild(this.Hat);
        this.setRotation(this.Hat, -0.1745F, 0.0F, 0.0F);
        this.Hat.setTextureOffset(0, 20).addBox(-3.0F, -8.0F, -4.0F, 6, 4, 8, 0.0F);
        this.Hat.setTextureOffset(8, 14).addBox(-3.0F, -4.5F, 2.0F, 6, 1, 1, 0.0F);
        this.Hat.setTextureOffset(8, 14).addBox(-3.0F, -4.5F, -3.0F, 6, 1, 1, 0.0F);
        this.Hat.setTextureOffset(8, 14).addBox(-3.0F, -8.5F, -3.0F, 6, 1, 1, 0.0F);
        this.Hat.setTextureOffset(8, 14).addBox(-3.0F, -8.5F, 2.0F, 6, 1, 1, 0.0F);
        this.Hat.setTextureOffset(20, 26).addBox(-2.5F, -4.5001F, -3.5F, 5, 1, 1, 0.0F);
        this.Hat.setTextureOffset(20, 26).addBox(-2.5F, -4.5001F, 2.5F, 5, 1, 1, 0.0F);
        this.Hat.setTextureOffset(20, 26).addBox(-2.5F, -8.5001F, 2.5F, 5, 1, 1, 0.0F);
        this.Hat.setTextureOffset(20, 26).addBox(-2.5F, -8.5001F, -3.5F, 5, 1, 1, 0.0F);
        this.Hat.setTextureOffset(8, 21).addBox(-3.5F, -8.5001F, -2.5F, 7, 1, 5, 0.0F);
        this.Hat.setTextureOffset(8, 22).addBox(-2.0F, -9.0001F, -2.0F, 4, 1, 4, 0.001F);
        this.Hat.setTextureOffset(23, 17).addBox(-1.0F, -9.5001F, -1.0F, 2, 1, 2, 0.0F);
        this.Hat.setTextureOffset(23, 25).addBox(0.5F, -9.5F, -1.0F, 1, 1, 2, 0.0F);
        this.Hat.setTextureOffset(23, 24).addBox(-1.5F, -9.5F, -1.0F, 1, 1, 2, 0.0F);
        this.Hat.setTextureOffset(26, 26).addBox(-1.0F, -9.5F, -1.5F, 2, 1, 1, 0.0F);
        this.Hat.setTextureOffset(22, 26).addBox(-1.0F, -9.5F, 0.5F, 2, 1, 1, 0.0F);
        this.Hat.setTextureOffset(18, 22).addBox(-2.5F, -9.0F, -2.0F, 1, 1, 4, 0.0F);
        this.Hat.setTextureOffset(19, 22).addBox(1.5F, -9.0F, -2.0F, 1, 1, 4, 0.0F);
        this.Hat.setTextureOffset(22, 26).addBox(-2.0F, -9.0F, -2.5F, 4, 1, 1, 0.0F);
        this.Hat.setTextureOffset(22, 26).addBox(-2.0F, -9.0F, 1.5F, 4, 1, 1, 0.0F);
        this.Hat.setTextureOffset(3, 26).addBox(-3.5F, -4.5001F, -2.5F, 7, 1, 5, 0.0F);
        this.Hat.setTextureOffset(15, 9).addBox(2.5F, -8.0001F, -3.5F, 1, 4, 7, 0.0F);
        this.Hat.setTextureOffset(15, 9).addBox(-3.5F, -8.0001F, -3.5F, 1, 4, 7, 0.0F);
        this.Hat.setTextureOffset(0, 10).addBox(3.0F, -8.0F, -3.0F, 1, 4, 6, 0.0F);
        this.Hat.setTextureOffset(0, 10).addBox(-4.0F, -8.0F, -3.0F, 1, 4, 6, 0.0F);
        this.Foot = new MModelRenderer(this);
        this.Foot.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Mushroom.addChild(this.Foot);
        this.Foot.setTextureOffset(15, 1).addBox(-2.0F, -1.0F, -2.0F, 4, 1, 4, 0.0F);
        this.Foot.setTextureOffset(0, 3).addBox(-2.0F, -2.5F, -2.5F, 4, 2, 5, 0.0F);
        this.Foot.setTextureOffset(14, 1).addBox(-2.5F, -2.5F, -2.0F, 5, 2, 4, 0.0F);
        this.Eyes = new MModelRenderer(this);
        this.Eyes.setRotationPoint(0.0F, -1.75F, -2.0F);
        this.Mushroom.addChild(this.Eyes);
        this.Eyes.setTextureOffset(0, 26).addBox(-1.25F, -0.5F, -0.5003F, 1, 1, 1, 0.001F);
        this.Eyes.setTextureOffset(0, 26).addBox(0.25F, -0.5F, -0.5003F, 1, 1, 1, 0.001F);
        this.setTexture(new ResourceLocation("minidot", "pets/mariomushroom_" + color + ".png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/mariomushroom_animation.json"));
        this.animation = bbanimationloader.mustGet("animation.model.new", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.04F;
        GlStateManager.translate(0.75F, -1.1F + f, 0.25F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
        GlStateManager.translate(0.0F, -0.7F, 0.0F);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case 112785:
                if (s.equals("red"))
                {
                    b0 = 0;
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
                return "\u0413\u0440\u0438\u0431 Power Up";

            case 1:
                return "\u0413\u0440\u0438\u0431 1-UP";

            default:
                return "\u0413\u0440\u0438\u0431 \u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439";
        }
    }

    public String getCreator()
    {
        return "EvilBendy";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Super Mario Bros");
    }
}
