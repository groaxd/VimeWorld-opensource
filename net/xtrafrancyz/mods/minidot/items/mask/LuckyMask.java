package net.xtrafrancyz.mods.minidot.items.mask;

import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class LuckyMask extends BaseItem
{
    private final MModelRenderer Lucky_mask;
    private final MModelRenderer nose;
    private final MModelRenderer bone4;
    private final MModelRenderer bone3;
    private final MModelRenderer bone6;
    private final MModelRenderer bone5;
    private final MModelRenderer mouth;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer eyes;
    private final MModelRenderer eye1;
    private final MModelRenderer eye2;
    private final MModelRenderer ears;
    private final MModelRenderer ear_left;
    private final MModelRenderer bone;
    private final MModelRenderer ear_right;
    private final MModelRenderer bone2;

    public LuckyMask()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Lucky_mask = new MModelRenderer(this);
        this.Lucky_mask.cubeList.add(new ModelBox(this.Lucky_mask, 0, 0, -4.0F, -10.0F, -2.0F, 8, 9, 1, 0.0F, false));
        this.Lucky_mask.cubeList.add(new ModelBox(this.Lucky_mask, 12, 20, 4.0F, -7.0F, -2.0F, 1, 5, 1, 0.0F, false));
        this.Lucky_mask.cubeList.add(new ModelBox(this.Lucky_mask, 8, 20, -5.0F, -7.0F, -2.0F, 1, 5, 1, 0.0F, false));
        this.nose = new MModelRenderer(this);
        this.nose.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.Lucky_mask.addChild(this.nose);
        this.nose.cubeList.add(new ModelBox(this.nose, 0, 10, -2.5229F, -5.75F, -3.0194F, 5, 2, 1, 0.0F, false));
        this.nose.cubeList.add(new ModelBox(this.nose, 20, 10, -1.0229F, -5.75F, -3.5194F, 2, 2, 1, 0.0F, false));
        this.nose.cubeList.add(new ModelBox(this.nose, 8, 13, -0.5F, -6.0F, -4.5F, 1, 1, 1, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.75F, -4.75F, -3.0F);
        this.setRotation(this.bone4, 0.0F, -0.48F, 0.0F);
        this.nose.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 18, 4, -1.0F, -1.0F, -1.0F, 3, 2, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-0.75F, -4.75F, -3.0F);
        this.setRotation(this.bone3, 0.0F, 0.48F, 0.0F);
        this.nose.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 18, 7, -2.0F, -1.0F, -1.0F, 3, 2, 1, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(3.75F, -4.75F, -3.0F);
        this.setRotation(this.bone6, 0.0F, -1.2217F, 0.0F);
        this.nose.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 24, 15, -0.2271F, -1.0F, 0.7306F, 1, 2, 1, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-3.75F, -4.75F, -3.0F);
        this.setRotation(this.bone5, 0.0F, 1.2217F, 0.0F);
        this.nose.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 24, 18, -0.7729F, -1.0F, 0.7306F, 1, 2, 1, 0.0F, false));
        this.mouth = new MModelRenderer(this);
        this.mouth.setRotationPoint(0.0F, 0.75F, 0.1F);
        this.Lucky_mask.addChild(this.mouth);
        this.mouth.cubeList.add(new ModelBox(this.mouth, 16, 22, 1.5242F, -4.25F, -3.0194F, 1, 2, 1, 0.0F, false));
        this.mouth.cubeList.add(new ModelBox(this.mouth, 16, 21, -1.5F, -2.9F, -2.75F, 3, 1, 0, 0.0F, false));
        this.mouth.cubeList.add(new ModelBox(this.mouth, 15, 20, -1.5F, -4.25F, -2.75F, 3, 1, 0, 0.001F, false));
        this.mouth.cubeList.add(new ModelBox(this.mouth, 20, 13, -1.0079F, -1.9644F, -3.0194F, 2, 1, 1, 0.0F, false));
        this.mouth.cubeList.add(new ModelBox(this.mouth, 21, 21, -2.5399F, -4.25F, -3.0194F, 1, 2, 1, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(1.25F, -0.25F, -1.5F);
        this.setRotation(this.bone7, 0.0F, 0.0F, 0.8727F);
        this.mouth.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 4, 22, -1.713F, -2.2617F, -1.5194F, 1, 2, 1, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-1.25F, -0.25F, -1.5F);
        this.setRotation(this.bone8, 0.0F, 0.0F, -0.8727F);
        this.mouth.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 22, 0.7029F, -2.2737F, -1.5194F, 1, 2, 1, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(4.0F, 0.0F, -0.5F);
        this.Lucky_mask.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 18, -7.5F, -8.75F, -2.0F, 3, 3, 1, 0.0F, false));
        this.bone9.cubeList.add(new ModelBox(this.bone9, 18, 0, -3.5F, -8.75F, -2.0F, 3, 3, 1, 0.0F, false));
        this.eyes = new MModelRenderer(this);
        this.bone9.addChild(this.eyes);
        this.eye1 = new MModelRenderer(this);
        this.eye1.setRotationPoint(-2.0F, -7.25F, -2.0F);
        this.eyes.addChild(this.eye1);
        this.eye1.cubeList.add(new ModelBox(this.eye1, 26, 0, -1.0F, -1.0F, -0.05F, 2, 2, 0, 0.0F, false));
        this.eye2 = new MModelRenderer(this);
        this.eye2.setRotationPoint(-6.0F, -7.25F, -2.0F);
        this.eyes.addChild(this.eye2);
        this.eye2.cubeList.add(new ModelBox(this.eye2, 26, 0, -1.0F, -1.0F, -0.05F, 2, 2, 0, 0.0F, true));
        this.ears = new MModelRenderer(this);
        this.ears.setRotationPoint(-4.0F, 0.0F, -0.5F);
        this.Lucky_mask.addChild(this.ears);
        this.ear_left = new MModelRenderer(this);
        this.ear_left.setRotationPoint(2.0F, -9.5F, -1.0F);
        this.setRotation(this.ear_left, 0.2618F, 0.0F, -0.2618F);
        this.ears.addChild(this.ear_left);
        this.ear_left.cubeList.add(new ModelBox(this.ear_left, 16, 15, -1.5F, -4.0F, -0.5F, 3, 4, 1, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.setRotation(this.bone, ((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.ear_left.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 8, 15, -1.5F, -3.6786F, -0.617F, 3, 4, 1, 0.0F, false));
        this.ear_right = new MModelRenderer(this);
        this.ear_right.setRotationPoint(6.0F, -9.5F, -1.0F);
        this.setRotation(this.ear_right, 0.2618F, 0.0F, 0.2618F);
        this.ears.addChild(this.ear_right);
        this.ear_right.cubeList.add(new ModelBox(this.ear_right, 0, 13, -1.5F, -4.0F, -0.5F, 3, 4, 1, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.setRotation(this.bone2, ((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.ear_right.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 10, -1.5F, -3.6786F, -0.617F, 3, 4, 1, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "masks/luckymask.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.2D, -0.1D);
        double d0 = 0.75D;
        GlStateManager.scale(d0, d0, d0);
        super.renderAsItem(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, 0.1D, -0.2D);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u041b\u0430\u043a\u0438";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Dark Deception");
    }
}
