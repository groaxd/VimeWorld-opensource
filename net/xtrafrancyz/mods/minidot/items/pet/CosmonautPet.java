package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class CosmonautPet extends BasePet
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer AmongGuy;
    private static MModelRenderer Body;
    private static MModelRenderer Backpack;
    private static MModelRenderer bone;
    private static MModelRenderer Legs;
    private static MModelRenderer LeftLeg;
    private static MModelRenderer RightLeg;
    private final IAnimation animation;
    private String color;

    public CosmonautPet(String color)
    {
        this.color = color;
        this.textureWidth = 32;
        this.textureHeight = 32;

        if (AmongGuy == null)
        {
            AmongGuy = new MModelRenderer(this);
            this.setRotation(AmongGuy, -3.1416F, 3.1416F, 3.1416F);
            Body = new MModelRenderer(this);
            Body.setRotationPoint(0.0F, -4.5F, 0.0F);
            AmongGuy.addChild(Body);
            Body.cubeList.add(new ModelBox(Body, 0, 0, -4.0F, -10.5F, -2.0F, 8, 12, 4, 0.0F, false));
            Backpack = new MModelRenderer(this);
            Backpack.setRotationPoint(0.0F, -3.5F, 2.0F);
            Body.addChild(Backpack);
            Backpack.cubeList.add(new ModelBox(Backpack, 0, 16, -3.0F, -4.0F, 0.0F, 6, 8, 2, 0.0F, false));
            bone = new MModelRenderer(this);
            bone.setRotationPoint(0.0F, -7.5F, -2.5F);
            Body.addChild(bone);
            bone.cubeList.add(new ModelBox(bone, 16, 16, -3.5F, -2.0F, -0.5F, 7, 4, 1, 0.0F, false));
            Legs = new MModelRenderer(this);
            Legs.setRotationPoint(0.0F, -1.0F, 0.0F);
            AmongGuy.addChild(Legs);
            LeftLeg = new MModelRenderer(this);
            LeftLeg.setRotationPoint(2.25F, -2.0F, 0.0F);
            Legs.addChild(LeftLeg);
            LeftLeg.cubeList.add(new ModelBox(LeftLeg, 16, 21, -1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F, false));
            RightLeg = new MModelRenderer(this);
            RightLeg.setRotationPoint(-2.25F, -2.0F, 0.0F);
            Legs.addChild(RightLeg);
            RightLeg.cubeList.add(new ModelBox(RightLeg, 0, 26, -1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F, false));
        }

        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/cosmonaut_au_anim.json"));
        this.animation = bbanimationloader.mustGet("animation.amongguy.walk", this);
        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.02F;
        float f1 = MathHelper.cos(time * 0.1F);
        GlStateManager.translate(0.7F, -0.2F + f, 0.3F);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.animation.tick(time);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        GlStateManager.translate(0.0F, 0.35F, 0.0F);
        this.animation.tick(time);
        super.renderAsItem(time);
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
                    b0 = 1;
                }

                break;

            case 98619139:
                if (s.equals("green"))
                {
                    b0 = 2;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0439 \u043a\u043e\u0441\u043c\u043e\u043d\u0430\u0432\u0442";

            case 1:
                return "\u0413\u043e\u043b\u0443\u0431\u043e\u0439 \u043a\u043e\u0441\u043c\u043e\u043d\u0430\u0432\u0442";

            case 2:
                return "\u0417\u0435\u043b\u0435\u043d\u044b\u0439 \u043a\u043e\u0441\u043c\u043e\u043d\u0430\u0432\u0442";

            case 3:
                return "\u0416\u0435\u043b\u0442\u044b\u0439 \u043a\u043e\u0441\u043c\u043e\u043d\u0430\u0432\u0442";

            default:
                return "\u0419\u0443\u0445";
        }
    }

    public String getCreator()
    {
        return "Wenston";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Among Us");
    }

    static
    {
        colors.put("yellow", new ResourceLocation("minidot", "pets/cosmonaut_au_yellow.png"));
        colors.put("blue", new ResourceLocation("minidot", "pets/cosmonaut_au_blue.png"));
        colors.put("green", new ResourceLocation("minidot", "pets/cosmonaut_au_green.png"));
        colors.put("red", new ResourceLocation("minidot", "pets/cosmonaut_au_red.png"));
    }
}
