package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class EasterBunny extends BasePet
{
    private final MModelRenderer Bunny;
    private final MModelRenderer Head;
    private final MModelRenderer Ears;
    private final MModelRenderer RightEar;
    private final MModelRenderer LeftEar;
    private final MModelRenderer Body;
    private final MModelRenderer Tail;
    private final MModelRenderer Arms;
    private final MModelRenderer RightArm;
    private final MModelRenderer LeftArm;
    private final MModelRenderer Legs;
    private final MModelRenderer LeftLeg;
    private final MModelRenderer RightLeg;

    public EasterBunny()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.Bunny = new MModelRenderer(this);
        this.Head = new MModelRenderer(this);
        this.Bunny.addChild(this.Head);
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 0, -2.0F, -9.0F, -3.0F, 4, 3, 4, 0.0F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 7, -2.5F, -6.9F, -4.0F, 5, 1, 3, 0.0F, false));
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 0, -0.5F, -7.4F, -3.5F, 1, 1, 1, 0.0F, false));
        this.Ears = new MModelRenderer(this);
        this.Head.addChild(this.Ears);
        this.RightEar = new MModelRenderer(this);
        this.setRotation(this.RightEar, 0.1745F, -0.1745F, -0.2618F);
        this.Ears.addChild(this.RightEar);
        this.RightEar.cubeList.add(new ModelBox(this.RightEar, 0, 16, -0.0292F, -12.6105F, -0.7162F, 2, 4, 1, -0.2F, false));
        this.LeftEar = new MModelRenderer(this);
        this.LeftEar.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.setRotation(this.LeftEar, 0.1745F, 0.1745F, 0.2618F);
        this.Ears.addChild(this.LeftEar);
        this.LeftEar.cubeList.add(new ModelBox(this.LeftEar, 6, 16, -1.0195F, -12.8362F, -0.5061F, 2, 4, 1, -0.2F, false));
        this.Body = new MModelRenderer(this);
        this.Body.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.Bunny.addChild(this.Body);
        this.Body.cubeList.add(new ModelBox(this.Body, 0, 11, -2.0F, -9.0F, -1.5F, 4, 3, 2, 0.0F, false));
        this.Tail = new MModelRenderer(this);
        this.Tail.setRotationPoint(0.0F, 0.25F, 1.0F);
        this.setRotation(this.Tail, -0.1745F, 0.0F, 0.0F);
        this.Bunny.addChild(this.Tail);
        this.Tail.cubeList.add(new ModelBox(this.Tail, 12, 16, -1.0F, -4.7462F, -1.5434F, 2, 1, 1, 0.0F, false));
        this.Arms = new MModelRenderer(this);
        this.Arms.setRotationPoint(0.0F, 0.0F, -0.5F);
        this.Bunny.addChild(this.Arms);
        this.RightArm = new MModelRenderer(this);
        this.RightArm.setRotationPoint(-0.25F, 0.0F, 0.0F);
        this.setRotation(this.RightArm, 0.0F, -0.1745F, 0.0F);
        this.Arms.addChild(this.RightArm);
        this.RightArm.cubeList.add(new ModelBox(this.RightArm, 13, 8, 2.0F, -5.25F, -3.0F, 1, 1, 3, 0.0F, false));
        this.LeftArm = new MModelRenderer(this);
        this.LeftArm.setRotationPoint(0.25F, 0.0F, 0.0F);
        this.setRotation(this.LeftArm, 0.0F, 0.1745F, 0.0F);
        this.Arms.addChild(this.LeftArm);
        this.LeftArm.cubeList.add(new ModelBox(this.LeftArm, 13, 4, -3.0F, -5.25F, -3.0F, 1, 1, 3, 0.0F, false));
        this.Legs = new MModelRenderer(this);
        this.Legs.setRotationPoint(0.0F, 2.25F, 0.5F);
        this.Bunny.addChild(this.Legs);
        this.LeftLeg = new MModelRenderer(this);
        this.Legs.addChild(this.LeftLeg);
        this.LeftLeg.cubeList.add(new ModelBox(this.LeftLeg, 12, 0, 0.25F, -5.25F, -3.0F, 2, 1, 3, 0.0F, false));
        this.RightLeg = new MModelRenderer(this);
        this.Legs.addChild(this.RightLeg);
        this.RightLeg.cubeList.add(new ModelBox(this.RightLeg, 12, 12, -2.25F, -5.25F, -3.0F, 2, 1, 3, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "pets/easter_bunny_pet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.translate(0.7F, -0.2F + f, 0.3F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.35F, 0.05F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u0430\u0441\u0445\u0430\u043b\u044c\u043d\u044b\u0439 \u043a\u0440\u043e\u043b\u0438\u043a";
    }

    public String getCreator()
    {
        return "Wenston";
    }
}
