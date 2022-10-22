package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class AncientHammer extends BaseItem
{
    private final MModelRenderer bone13;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer bone4;
    private final MModelRenderer bone;

    public AncientHammer()
    {
        super(ItemType.BODY);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-2.9F, 0.0F, 0.0F);
        this.setRotation(this.bone13, 0.0F, 0.0F, 0.4363F);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 0, 0, -0.6F, -12.0F, -0.5F, 1, 11, 1, 0.1F, false));
        this.bone13.cubeList.add(new ModelBox(this.bone13, 12, 8, -0.6F, -3.4F, -0.5F, 1, 2, 1, 0.15F, false));
        this.bone13.cubeList.add(new ModelBox(this.bone13, 3, 19, -0.6F, -12.0F, -0.5F, 1, 1, 1, 0.3F, false));
        this.bone13.cubeList.add(new ModelBox(this.bone13, 19, 12, -2.8F, -13.4F, -0.5F, 3, 1, 1, 0.6F, false));
        this.bone13.cubeList.add(new ModelBox(this.bone13, 12, 6, -1.4F, -14.6F, -0.5F, 2, 1, 1, 0.75F, false));
        this.bone13.cubeList.add(new ModelBox(this.bone13, 0, 18, 0.8F, -14.2F, -0.5F, 1, 1, 1, 0.74F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(5.6F, -3.5F, 3.8F);
        this.setRotation(this.bone3, 0.0F, -1.5708F, -0.4363F);
        this.bone13.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 12, -5.6F, -14.1008F, 0.3958F, 3, 5, 1, -0.399F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(5.6F, -3.5F, 3.8F);
        this.setRotation(this.bone2, 0.0F, -1.5708F, -0.4363F);
        this.bone13.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 12, -5.0F, -14.1008F, 0.3958F, 3, 5, 1, -0.401F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-4.4F, -2.75F, 3.8F);
        this.setRotation(this.bone4, 0.0F, -1.5708F, 0.4363F);
        this.bone13.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 12, -5.0F, -14.1008F, 0.3958F, 3, 5, 1, -0.403F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-4.4F, -2.75F, 3.8F);
        this.setRotation(this.bone, 0.0F, -1.5708F, 0.4363F);
        this.bone13.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 12, -5.6F, -14.1008F, 0.3958F, 3, 5, 1, -0.402F, false));
        super.setTexture(new ResourceLocation("minidot", "body/ancienthammer.png"));
    }

    public void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.85F, 0.17F);
    }

    public void renderAsItem(float time)
    {
        float f = 1.23F;
        GlStateManager.scale(f, f, f);
        GlStateManager.translate(0.0F, 0.6767F, 0.36850002F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0414\u0440\u0435\u0432\u043d\u0438\u0439 \u043c\u043e\u043b\u043e\u0442";
    }

    public String getCreator()
    {
        return "denisss456";
    }
}
