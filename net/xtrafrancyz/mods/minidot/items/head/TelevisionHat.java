package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class TelevisionHat extends BaseHelm
{
    private final MModelRenderer bone2;
    private final MModelRenderer glass;
    private final MModelRenderer buttons;
    private final MModelRenderer antenas;
    private final MModelRenderer bone;
    private final MModelRenderer bone3;
    private final MModelRenderer box;

    public TelevisionHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.bone2 = new MModelRenderer(this);
        this.glass = new MModelRenderer(this);
        this.glass.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.bone2.addChild(this.glass);
        this.glass.cubeList.add(new ModelBox(this.glass, 24, 14, -3.7F, -17.5F, -4.25F, 7, 6, 1, 0.0F, false));
        this.buttons = new MModelRenderer(this);
        this.buttons.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.bone2.addChild(this.buttons);
        this.buttons.cubeList.add(new ModelBox(this.buttons, 0, 26, -3.2F, -11.5F, -4.8F, 1, 1, 4, -0.2F, false));
        this.buttons.cubeList.add(new ModelBox(this.buttons, 0, 26, -2.0F, -11.5F, -4.8F, 1, 1, 4, -0.2F, false));
        this.buttons.cubeList.add(new ModelBox(this.buttons, 4, 14, 2.5F, -11.4F, -4.75F, 1, 1, 1, -0.1F, false));
        this.antenas = new MModelRenderer(this);
        this.antenas.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.bone2.addChild(this.antenas);
        this.antenas.cubeList.add(new ModelBox(this.antenas, 25, 0, -2.1F, -18.5F, -2.0F, 4, 1, 4, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-6.3F, -1.75F, 0.0F);
        this.setRotation(this.bone, 0.0F, 0.0F, 0.5236F);
        this.antenas.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 10, 26, -3.2562F, -22.472F, -0.5F, 1, 5, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-12.3F, -19.25F, 0.0F);
        this.setRotation(this.bone3, 0.0F, 0.0F, -0.5236F);
        this.antenas.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 10, 26, 9.6358F, 2.0878F, -0.5F, 1, 5, 1, 0.0F, false));
        this.box = new MModelRenderer(this);
        this.box.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.bone2.addChild(this.box);
        this.box.cubeList.add(new ModelBox(this.box, 0, 14, -4.2F, -11.0F, -4.0F, 8, 1, 8, 0.0F, false));
        this.box.cubeList.add(new ModelBox(this.box, 0, 0, -4.7F, -18.0F, -2.5F, 9, 7, 7, 0.0F, false));
        this.box.cubeList.add(new ModelBox(this.box, 22, 23, -4.7F, -18.0F, -4.5F, 9, 1, 2, 0.0F, false));
        this.box.cubeList.add(new ModelBox(this.box, 0, 23, -4.7F, -12.0F, -4.5F, 9, 1, 2, 0.0F, false));
        this.box.cubeList.add(new ModelBox(this.box, 0, 14, 3.3F, -17.0F, -4.5F, 1, 5, 2, 0.0F, false));
        this.box.cubeList.add(new ModelBox(this.box, 0, 0, -4.7F, -17.0F, -4.5F, 1, 5, 2, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "head/television_hat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.1F, 1.12F, 1.1F);
        GlStateManager.translate(0.01F, 0.025F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0422\u0435\u043b\u0435\u0432\u0438\u0437\u043e\u0440";
    }

    public String getCreator()
    {
        return "Wenston & xRolaaan";
    }
}
