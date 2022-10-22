package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ShrekEars extends BaseItem
{
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;

    public ShrekEars()
    {
        super(ItemType.HEAD);
        this.textureWidth = 8;
        this.textureHeight = 8;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -0.0F, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.setRotation(this.bone2, 0.0F, 0.0F, 0.9599F);
        this.bone.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, 0.75F, -6.5F, -0.5F, 1, 3, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(1.25F, -6.0F, 0.0F);
        this.setRotation(this.bone3, 1.5533F, 0.0F, 0.0F);
        this.bone2.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 0, -1.0F, -0.5F, 0.0F, 2, 1, 1, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.05F, 0.0F, 0.0F);
        this.setRotation(this.bone4, 0.0F, 0.6109F, 0.0F);
        this.bone3.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 0, -0.2218F, -0.5F, -0.4551F, 1, 1, 1, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-0.95F, 0.0F, 0.0F);
        this.setRotation(this.bone5, 0.0F, -((float)Math.PI * 2F / 9F), 0.0F);
        this.bone3.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 0, -0.0383F, -0.5F, -0.9679F, 1, 1, 1, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.setRotation(this.bone6, 0.0F, 0.0F, -0.9599F);
        this.bone.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 0, -1.75F, -6.5F, -0.5F, 1, 3, 1, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-1.25F, -6.0F, 0.0F);
        this.setRotation(this.bone7, 1.5533F, 0.0F, 0.0F);
        this.bone6.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 0, -1.0F, -0.5F, 0.0F, 2, 1, 1, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-0.05F, 0.0F, 0.0F);
        this.setRotation(this.bone8, 0.0F, -0.6109F, 0.0F);
        this.bone7.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 0, -0.7782F, -0.5F, -0.4551F, 1, 1, 1, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.95F, 0.0F, 0.0F);
        this.setRotation(this.bone9, 0.0F, ((float)Math.PI * 2F / 9F), 0.0F);
        this.bone7.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 0, -0.9617F, -0.5F, -0.9679F, 1, 1, 1, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "head/shrek_ears.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.05F, 0.0F);
        super.renderAsItem(time);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    public String getName()
    {
        return "\u0423\u0448\u0438 \u0428\u0440\u0435\u043a\u0430";
    }
}
