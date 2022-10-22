package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BrainBasketPet extends BasePet
{
    private final MModelRenderer bone;
    private final MModelRenderer brain;
    private final MModelRenderer brain2;
    private final MModelRenderer brain3;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer brain4;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final MModelRenderer brain5;
    private final MModelRenderer brain6;
    private final MModelRenderer bone16;
    private final MModelRenderer bone17;
    private final MModelRenderer bone18;
    private final MModelRenderer brain7;
    private final MModelRenderer brain8;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone2;

    public BrainBasketPet()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 19, -3.5F, -1.0F, -0.0858F, 7, 1, 3, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 19, -3.5F, -1.0F, -2.9142F, 7, 1, 3, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 7, -5.5F, -3.0F, -3.5F, 11, 0, 7, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 23, -3.5F, -2.5F, 2.6213F, 7, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 23, -3.5F, -4.5F, 3.3284F, 7, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 23, -3.5F, -2.5F, -3.6213F, 7, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 23, -3.5F, -4.5F, -4.3284F, 7, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 20, 0, -0.5F, -7.0F, -4.1213F, 1, 3, 1, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 20, 0, -0.5F, -9.1213F, -2.0F, 1, 1, 4, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 20, 0, -0.5F, -7.0F, 3.1213F, 1, 3, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 11, 3, -4.9142F, -1.0F, -1.5F, 2, 1, 3, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 17, 14, -5.6213F, -2.5F, -1.5F, 1, 2, 3, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 2, -6.3284F, -4.5F, -1.5F, 1, 2, 3, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 2, 5.3284F, -4.5F, -1.5F, 1, 2, 3, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 17, 14, 4.6213F, -2.5F, -1.5F, 1, 2, 3, 0.0F, true));
        this.bone.cubeList.add(new ModelBox(this.bone, 11, 3, 2.9142F, -1.0F, -1.5F, 2, 1, 3, 0.0F, true));
        this.brain = new MModelRenderer(this);
        this.brain.setRotationPoint(0.0F, -0.4F, 0.35F);
        this.setRotation(this.brain, 0.1745F, -0.1745F, -0.2618F);
        this.bone.addChild(this.brain);
        this.brain.cubeList.add(new ModelBox(this.brain, 0, 14, -2.75F, -5.5F, -2.75F, 4, 2, 3, 0.0F, false));
        this.brain.cubeList.add(new ModelBox(this.brain, 14, 28, -2.1F, -5.75F, -2.25F, 3, 1, 2, 0.0F, false));
        this.brain.cubeList.add(new ModelBox(this.brain, 0, 14, -3.0F, -5.25F, -2.0F, 1, 1, 2, 0.0F, false));
        this.brain2 = new MModelRenderer(this);
        this.brain2.setRotationPoint(0.0F, -0.4F, 0.35F);
        this.setRotation(this.brain2, 0.1745F, 1.4835F, -0.0873F);
        this.bone.addChild(this.brain2);
        this.brain2.cubeList.add(new ModelBox(this.brain2, 0, 14, -3.1F, -5.0F, -1.75F, 4, 2, 3, 0.0F, false));
        this.brain2.cubeList.add(new ModelBox(this.brain2, 14, 28, -2.85F, -5.25F, -1.25F, 3, 1, 2, 0.0F, true));
        this.brain3 = new MModelRenderer(this);
        this.brain3.setRotationPoint(0.0F, -0.4F, 0.35F);
        this.setRotation(this.brain3, 0.1745F, -0.3491F, 0.3491F);
        this.bone.addChild(this.brain3);
        this.brain3.cubeList.add(new ModelBox(this.brain3, 0, 14, -5.6F, -2.75F, 0.25F, 4, 2, 3, 0.0F, false));
        this.brain3.cubeList.add(new ModelBox(this.brain3, 14, 28, -4.85F, -3.0F, 0.75F, 3, 1, 2, 0.0F, false));
        this.brain3.cubeList.add(new ModelBox(this.brain3, 16, 23, -5.85F, -2.25F, 0.75F, 1, 1, 2, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-5.1F, -2.25F, 4.0F);
        this.setRotation(this.bone5, -0.2618F, 0.0F, 0.0F);
        this.brain3.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 11, 14, 0.5F, 0.0616F, -0.7044F, 1, 1, 2, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.setRotation(this.bone6, -1.1345F, 0.0F, 0.0F);
        this.bone5.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 11, 14, 0.5F, -1.1482F, 0.6034F, 1, 1, 1, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.setRotation(this.bone7, 0.0F, 0.3491F, 0.0F);
        this.bone6.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 11, 14, -0.0785F, -1.1482F, 1.6777F, 1, 1, 1, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-5.1F, -2.25F, 4.0F);
        this.setRotation(this.bone9, -0.2618F, -1.8326F, 0.0F);
        this.brain3.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 11, 14, -4.5307F, -0.9311F, 1.1089F, 1, 1, 2, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.setRotation(this.bone10, -1.1345F, 0.0F, 0.0F);
        this.bone9.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 11, 14, -4.5307F, -3.2111F, 0.47F, 1, 1, 1, 0.0F, false));
        this.bone11 = new MModelRenderer(this);
        this.setRotation(this.bone11, 0.0F, -0.4363F, 0.0F);
        this.bone10.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 11, 14, -3.5787F, -3.2111F, 2.8244F, 1, 1, 1, 0.0F, false));
        this.bone12 = new MModelRenderer(this);
        this.setRotation(this.bone12, -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.bone11.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 11, 14, -3.5787F, -4.9181F, 0.8656F, 1, 1, 2, 0.0F, false));
        this.brain4 = new MModelRenderer(this);
        this.brain4.setRotationPoint(0.0F, -0.4F, 0.35F);
        this.setRotation(this.brain4, 0.1745F, -0.0873F, -0.3491F);
        this.bone.addChild(this.brain4);
        this.brain4.cubeList.add(new ModelBox(this.brain4, 0, 14, 2.15F, -3.0F, -1.5F, 4, 2, 3, 0.0F, false));
        this.brain4.cubeList.add(new ModelBox(this.brain4, 14, 28, 2.9F, -3.25F, -1.0F, 3, 1, 2, 0.0F, false));
        this.brain4.cubeList.add(new ModelBox(this.brain4, 16, 23, 5.399F, -2.75F, -1.0F, 1, 1, 2, 0.0F, true));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(5.4F, -2.0F, 3.75F);
        this.setRotation(this.bone13, -0.2618F, 0.9599F, 0.0F);
        this.brain4.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 11, 14, 0.9659F, 0.0313F, -2.0486F, 1, 1, 2, 0.0F, false));
        this.bone14 = new MModelRenderer(this);
        this.setRotation(this.bone14, -1.1345F, 0.0F, 0.0F);
        this.bone13.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 11, 14, 0.9659F, 0.0573F, 0.0078F, 1, 1, 2, 0.0F, false));
        this.bone15 = new MModelRenderer(this);
        this.setRotation(this.bone15, -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.bone14.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 11, 14, 0.9659F, -1.2467F, 1.5749F, 1, 1, 2, 0.0F, false));
        this.brain5 = new MModelRenderer(this);
        this.brain5.setRotationPoint(0.0F, -0.4F, 0.35F);
        this.setRotation(this.brain5, 0.2618F, -1.309F, -0.3491F);
        this.bone.addChild(this.brain5);
        this.brain5.cubeList.add(new ModelBox(this.brain5, 0, 14, 0.15F, -4.25F, -3.0F, 4, 2, 3, 0.0F, false));
        this.brain5.cubeList.add(new ModelBox(this.brain5, 14, 28, 0.4F, -4.501F, -2.5F, 3, 1, 2, 0.0F, false));
        this.brain6 = new MModelRenderer(this);
        this.brain6.setRotationPoint(0.0F, -0.4F, 0.35F);
        this.setRotation(this.brain6, 0.2618F, 0.7854F, -0.3491F);
        this.bone.addChild(this.brain6);
        this.brain6.cubeList.add(new ModelBox(this.brain6, 0, 14, 1.4F, -2.25F, 0.55F, 4, 2, 3, 0.0F, false));
        this.brain6.cubeList.add(new ModelBox(this.brain6, 14, 28, 1.9F, -2.5F, 1.05F, 3, 1, 2, 0.0F, true));
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(5.4F, -2.0F, 3.75F);
        this.setRotation(this.bone16, 0.2618F, 2.618F, 0.8727F);
        this.brain6.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 11, 14, 2.6123F, -0.3534F, 1.8165F, 1, 1, 2, 0.0F, false));
        this.bone17 = new MModelRenderer(this);
        this.setRotation(this.bone17, -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.bone16.addChild(this.bone17);
        this.bone17.cubeList.add(new ModelBox(this.bone17, 11, 14, 2.6123F, -2.7239F, 2.6964F, 1, 1, 1, 0.0F, false));
        this.bone18 = new MModelRenderer(this);
        this.setRotation(this.bone18, -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.bone17.addChild(this.bone18);
        this.bone18.cubeList.add(new ModelBox(this.bone18, 11, 14, 2.6123F, -4.4627F, 1.0807F, 1, 1, 1, 0.0F, false));
        this.brain7 = new MModelRenderer(this);
        this.brain7.setRotationPoint(0.0F, -0.4F, 0.35F);
        this.setRotation(this.brain7, 0.1745F, 1.2217F, -1.2217F);
        this.bone.addChild(this.brain7);
        this.brain7.cubeList.add(new ModelBox(this.brain7, 0, 14, 0.9F, -0.75F, 1.8F, 4, 2, 2, 0.0F, false));
        this.brain7.cubeList.add(new ModelBox(this.brain7, 14, 28, 1.4F, 0.5F, 1.55F, 3, 1, 2, 0.0F, false));
        this.brain7.cubeList.add(new ModelBox(this.brain7, 15, 26, 1.65F, -0.25F, 3.051F, 3, 1, 1, 0.0F, true));
        this.brain7.cubeList.add(new ModelBox(this.brain7, 0, 14, 4.15F, 0.0F, 2.55F, 1, 1, 1, 0.0F, true));
        this.brain8 = new MModelRenderer(this);
        this.brain8.setRotationPoint(0.0F, -0.15F, 0.35F);
        this.setRotation(this.brain8, 0.0F, 0.0873F, 0.2618F);
        this.bone.addChild(this.brain8);
        this.brain8.cubeList.add(new ModelBox(this.brain8, 0, 26, -2.1F, -5.75F, -1.2F, 4, 2, 3, 0.0F, false));
        this.brain8.cubeList.add(new ModelBox(this.brain8, 15, 26, -1.35F, -5.5F, -1.45F, 3, 1, 1, 0.0F, true));
        this.brain8.cubeList.add(new ModelBox(this.brain8, 14, 28, -1.85F, -6.0001F, -0.7F, 3, 1, 2, 0.0F, false));
        this.brain8.cubeList.add(new ModelBox(this.brain8, 16, 23, -2.3499F, -5.5F, -0.7F, 1, 1, 2, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.setRotation(this.bone3, -0.7854F, 0.0F, 0.0F);
        this.bone.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 20, 0, -0.5F, -5.0355F, -6.4497F, 1, 3, 1, -5.0E-4F, true));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.setRotation(this.bone4, 0.7854F, 0.0F, 0.0F);
        this.bone.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 20, 0, -0.5F, -3.6213F, 6.864F, 1, 3, 1, -5.0E-4F, false));
        this.bone2 = new MModelRenderer(this);
        this.setRotation(this.bone2, 0.0F, -0.7854F, 0.0F);
        this.bone.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 0, -4.5355F, -1.0F, 0.4142F, 2, 1, 2, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 22, 23, -5.0355F, -2.501F, -0.0858F, 1, 2, 3, 0.0F, true));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 22, 19, -5.5355F, -4.5F, -0.5858F, 1, 2, 4, 0.0F, true));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 22, 14, -2.9142F, -2.501F, 4.0355F, 3, 2, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 22, 14, -0.0858F, -2.501F, -5.0355F, 3, 2, 1, 0.0F, true));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 22, 22, -0.5858F, -4.5F, -5.5355F, 4, 2, 1, 0.0F, true));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 22, 22, -3.4142F, -4.5F, 4.5355F, 4, 2, 1, 0.0F, true));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 23, 23, 4.0355F, -2.501F, -2.9142F, 1, 2, 3, 0.0F, true));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 22, 19, 4.5355F, -4.5F, -3.4142F, 1, 2, 4, 0.0F, true));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 0, 0.4142F, -1.0F, -4.5355F, 2, 1, 2, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 0, -2.4142F, -1.0F, 2.5355F, 2, 1, 2, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 0, 2.5355F, -1.0F, -2.4142F, 2, 1, 2, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "pets/brain_basket.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(0.8F, -0.3F + f, 0.3F);
        GlStateManager.rotate(time * 1.5F, 0.0F, 1.0F, 0.0F);
        GlStateManager.scale(1.25F, 1.25F, 1.25F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.4F, 1.4F, 1.4F);
        GlStateManager.translate(0.0F, 0.15F, 0.0F);
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
        return "\u041a\u043e\u0440\u0437\u0438\u043d\u043a\u0430 \u0441 \u043c\u043e\u0437\u0433\u0430\u043c\u0438";
    }
}
