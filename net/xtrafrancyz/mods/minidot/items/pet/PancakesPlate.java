package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class PancakesPlate extends BasePet
{
    private final MModelRenderer pancakes_plate;
    private final MModelRenderer plate;
    private final MModelRenderer pancakes;
    private final MModelRenderer one;
    private final MModelRenderer two;
    private final MModelRenderer three;
    private final MModelRenderer four;
    private final MModelRenderer Butter;
    private final MModelRenderer bone;

    public PancakesPlate()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.pancakes_plate = new MModelRenderer(this);
        this.pancakes_plate.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.plate = new MModelRenderer(this);
        this.plate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pancakes_plate.addChild(this.plate);
        this.plate.cubeList.add(new ModelBox(this.plate, 26, 18, -5.5F, -3.75F, 5.0F, 11, 1, 1, 0.0F));
        this.plate.cubeList.add(new ModelBox(this.plate, 0, 0, -5.0F, -3.0F, -5.0F, 10, 1, 10, 0.0F));
        this.plate.cubeList.add(new ModelBox(this.plate, 13, 12, 5.0F, -3.75F, -5.5F, 1, 1, 11, 0.0F));
        this.plate.cubeList.add(new ModelBox(this.plate, 0, 11, -6.0F, -3.75F, -5.5F, 1, 1, 11, 0.0F));
        this.plate.cubeList.add(new ModelBox(this.plate, 26, 20, -5.5F, -3.75F, -6.0F, 11, 1, 1, 0.0F));
        this.pancakes = new MModelRenderer(this);
        this.pancakes.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.pancakes_plate.addChild(this.pancakes);
        this.one = new MModelRenderer(this);
        this.one.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.pancakes.addChild(this.one);
        this.one.cubeList.add(new ModelBox(this.one, 30, 0, -4.0F, -4.0F, -3.0F, 8, 1, 6, 0.0F));
        this.one.cubeList.add(new ModelBox(this.one, 15, 34, -4.0F, -4.0F, -4.0F, 6, 1, 1, 0.0F));
        this.one.cubeList.add(new ModelBox(this.one, 23, 36, -2.0F, -4.0F, 3.0F, 5, 1, 1, 0.0F));
        this.one.cubeList.add(new ModelBox(this.one, 37, 37, -5.0F, -4.0F, -2.0F, 1, 1, 3, 0.0F));
        this.one.cubeList.add(new ModelBox(this.one, 0, 37, 4.0F, -4.0F, -1.0F, 1, 1, 3, 0.0F));
        this.two = new MModelRenderer(this);
        this.two.setRotationPoint(0.25F, -5.0F, 0.0F);
        this.pancakes.addChild(this.two);
        this.two.cubeList.add(new ModelBox(this.two, 26, 11, -4.0F, -4.0F, -3.0F, 8, 1, 6, 0.0F));
        this.two.cubeList.add(new ModelBox(this.two, 27, 32, -2.0F, -4.0F, -4.0F, 6, 1, 1, 0.0F));
        this.two.cubeList.add(new ModelBox(this.two, 11, 36, -3.0F, -4.0F, 3.0F, 5, 1, 1, 0.0F));
        this.two.cubeList.add(new ModelBox(this.two, 32, 36, 4.0F, -4.0F, -2.0F, 1, 1, 3, 0.0F));
        this.two.cubeList.add(new ModelBox(this.two, 13, 15, -5.0F, -4.0F, -1.0F, 1, 1, 3, 0.0F));
        this.three = new MModelRenderer(this);
        this.three.setRotationPoint(0.25F, -6.0F, 0.25F);
        this.pancakes.addChild(this.three);
        this.three.cubeList.add(new ModelBox(this.three, 22, 25, -4.0F, -4.0F, -3.0F, 8, 1, 6, 0.0F));
        this.three.cubeList.add(new ModelBox(this.three, 13, 32, -4.0F, -4.0F, 3.0F, 6, 1, 1, 0.0F));
        this.three.cubeList.add(new ModelBox(this.three, 0, 35, -2.0F, -4.0F, -4.0F, 5, 1, 1, 0.0F));
        this.three.cubeList.add(new ModelBox(this.three, 0, 15, -5.0F, -4.0F, -1.0F, 1, 1, 3, 0.0F));
        this.three.cubeList.add(new ModelBox(this.three, 13, 11, 4.0F, -4.0F, -2.0F, 1, 1, 3, 0.0F));
        this.four = new MModelRenderer(this);
        this.four.setRotationPoint(0.0F, -7.0F, -0.25F);
        this.pancakes.addChild(this.four);
        this.four.cubeList.add(new ModelBox(this.four, 0, 24, -4.0F, -4.0F, -3.0F, 8, 1, 6, 0.0F));
        this.four.cubeList.add(new ModelBox(this.four, 30, 7, -2.0F, -4.0F, -4.0F, 6, 1, 1, 0.0F));
        this.four.cubeList.add(new ModelBox(this.four, 29, 34, -3.0F, -4.0F, 3.0F, 5, 1, 1, 0.0F));
        this.four.cubeList.add(new ModelBox(this.four, 0, 11, 4.0F, -4.0F, -2.0F, 1, 1, 3, 0.0F));
        this.four.cubeList.add(new ModelBox(this.four, 0, 3, -5.0F, -4.0F, -1.0F, 1, 1, 3, 0.0F));
        this.Butter = new MModelRenderer(this);
        this.Butter.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pancakes_plate.addChild(this.Butter);
        this.Butter.cubeList.add(new ModelBox(this.Butter, 0, 7, -2.0F, -7.3F, -4.7F, 2, 1, 2, -0.2F));
        this.Butter.cubeList.add(new ModelBox(this.Butter, 5, 3, -1.1F, -7.1F, -4.8F, 1, 2, 1, -0.2F));
        this.Butter.cubeList.add(new ModelBox(this.Butter, 6, 7, -0.6F, -5.1F, -4.5F, 1, 1, 1, -0.2F));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(1.0F, 0.25F, -1.75F);
        this.Butter.addChild(this.bone);
        this.setRotation(this.bone, 0.0F, 0.3054F, 0.0F);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -3.0F, -8.25F, 0.0F, 3, 1, 2, 0.0F));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 31, -4.5F, -7.45F, -0.25F, 5, 1, 3, 0.0F));
        this.bone.cubeList.add(new ModelBox(this.bone, 36, 23, -1.75F, -7.45F, -1.25F, 3, 1, 1, 0.0F));
        this.bone.cubeList.add(new ModelBox(this.bone, 13, 19, 0.5F, -7.45F, 0.25F, 3, 1, 1, 0.0F));
        this.bone.cubeList.add(new ModelBox(this.bone, 18, 11, 3.0F, -5.7F, -0.5F, 1, 1, 1, -0.2F));
        this.bone.cubeList.add(new ModelBox(this.bone, 7, 18, 2.75F, -6.7F, -0.25F, 1, 1, 1, -0.2F));
        this.bone.cubeList.add(new ModelBox(this.bone, 5, 16, 1.5F, -7.7F, -1.0F, 1, 1, 1, -0.2F));
        this.bone.cubeList.add(new ModelBox(this.bone, 7, 14, 0.5F, -7.95F, 2.5F, 1, 1, 1, -0.2F));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 19, -2.75F, -7.7F, 2.75F, 2, 1, 2, -0.2F));
        this.bone.cubeList.add(new ModelBox(this.bone, 5, 11, -5.75F, -7.7F, -1.0F, 1, 1, 2, -0.2F));
        this.setTexture(new ResourceLocation("minidot", "pets/pancakesplate.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        GlStateManager.translate(0.55F, -1.0F + f, 0.3F);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.8F, 0.0F);
        GlStateManager.scale(1.3F, 1.3F, 1.3F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0422\u0430\u0440\u0435\u043b\u043a\u0430 \u0431\u043b\u0438\u043d\u043e\u0432";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
