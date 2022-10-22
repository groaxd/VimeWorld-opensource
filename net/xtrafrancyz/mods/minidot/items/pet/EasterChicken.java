package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class EasterChicken extends BasePet
{
    private final MModelRenderer Chicken;
    private final MModelRenderer Body;
    private final MModelRenderer Nose;
    private final MModelRenderer Arms;
    private final MModelRenderer Left;
    private final MModelRenderer Right;
    private final MModelRenderer Hair;
    private final MModelRenderer First;
    private final MModelRenderer Second;
    private final MModelRenderer Third;
    private final MModelRenderer Eyes;
    private final MModelRenderer Egg;

    public EasterChicken()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.Chicken = new MModelRenderer(this);
        this.Body = new MModelRenderer(this);
        this.Chicken.addChild(this.Body);
        this.Body.cubeList.add(new ModelBox(this.Body, 0, 15, -2.0F, -9.0F, -2.0F, 4, 4, 4, 0.0F, false));
        this.Nose = new MModelRenderer(this);
        this.Chicken.addChild(this.Nose);
        this.Nose.cubeList.add(new ModelBox(this.Nose, 18, 0, -1.0F, -8.0F, -4.0F, 2, 1, 2, 0.0F, false));
        this.Arms = new MModelRenderer(this);
        this.Arms.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.Chicken.addChild(this.Arms);
        this.Left = new MModelRenderer(this);
        this.setRotation(this.Left, 0.0F, 0.3491F, 0.3491F);
        this.Arms.addChild(this.Left);
        this.Left.cubeList.add(new ModelBox(this.Left, 16, 18, -2.272F, -11.4905F, -1.7628F, 3, 1, 2, 0.0F, false));
        this.Right = new MModelRenderer(this);
        this.setRotation(this.Right, 0.0F, -0.3491F, -0.3491F);
        this.Arms.addChild(this.Right);
        this.Right.cubeList.add(new ModelBox(this.Right, 12, 15, -0.728F, -11.4905F, -1.7628F, 3, 1, 2, 0.0F, false));
        this.Hair = new MModelRenderer(this);
        this.Hair.setRotationPoint(0.0F, 0.0F, -0.1F);
        this.Chicken.addChild(this.Hair);
        this.First = new MModelRenderer(this);
        this.setRotation(this.First, 0.2094F, 0.0F, 0.0F);
        this.Hair.addChild(this.First);
        this.First.cubeList.add(new ModelBox(this.First, 0, 3, 0.0F, -10.6858F, 0.0354F, 0, 2, 1, 0.0F, false));
        this.Second = new MModelRenderer(this);
        this.setRotation(this.Second, -0.0698F, 0.0F, 0.0F);
        this.Hair.addChild(this.Second);
        this.Second.cubeList.add(new ModelBox(this.Second, 4, 0, 0.0F, -11.927F, -1.5195F, 0, 3, 1, 0.0F, false));
        this.Third = new MModelRenderer(this);
        this.Third.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.setRotation(this.Third, -0.2443F, 0.0F, 0.0F);
        this.Hair.addChild(this.Third);
        this.Third.cubeList.add(new ModelBox(this.Third, 2, 3, 0.0F, -8.9754F, -4.9726F, 0, 1, 1, 0.0F, false));
        this.Eyes = new MModelRenderer(this);
        this.Chicken.addChild(this.Eyes);
        this.Eyes.cubeList.add(new ModelBox(this.Eyes, 0, 2, 0.999F, -8.0F, -2.25F, 1, 1, 1, 0.0F, false));
        this.Eyes.cubeList.add(new ModelBox(this.Eyes, 0, 2, -1.999F, -8.0F, -2.25F, 1, 1, 1, 0.0F, false));
        this.Egg = new MModelRenderer(this);
        this.Chicken.addChild(this.Egg);
        this.Egg.cubeList.add(new ModelBox(this.Egg, 15, 9, -2.0F, -1.0F, -2.0F, 4, 1, 4, 0.0F, false));
        this.Egg.cubeList.add(new ModelBox(this.Egg, 0, 0, -3.0F, -5.0F, -3.0F, 6, 3, 6, 0.0F, false));
        this.Egg.cubeList.add(new ModelBox(this.Egg, 0, 9, -2.5F, -2.0F, -2.5F, 5, 1, 5, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "pets/easter_chicken_pet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.translate(0.7F, -0.2F + f, 0.3F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.3F, 0.0F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0426\u044b\u043f\u043b\u0451\u043d\u043e\u043a \u0432 \u044f\u0439\u0446\u0435";
    }

    public String getCreator()
    {
        return "Wenston";
    }
}
