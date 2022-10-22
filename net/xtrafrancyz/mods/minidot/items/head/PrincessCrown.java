package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class PrincessCrown extends BaseItem
{
    private final MModelRenderer bone12;
    private final MModelRenderer bone10;
    private final MModelRenderer bone9;
    private final MModelRenderer bone8;
    private final MModelRenderer bone7;
    private final MModelRenderer bone;
    private final MModelRenderer bone11;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer bone5;
    private final MModelRenderer bone14;
    private final MModelRenderer bone4;
    private final MModelRenderer bone13;
    private final MModelRenderer bone6;

    public PrincessCrown()
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(0.8F, 0.0F, -3.0F);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 0, 4, -2.0F, -9.7F, 0.0F, 2, 2, 1, -0.3F, false));
        this.bone12.cubeList.add(new ModelBox(this.bone12, 0, 4, -2.0F, -9.7F, 3.0F, 2, 2, 1, -0.3F, false));
        this.bone12.cubeList.add(new ModelBox(this.bone12, 0, 0, 0.0F, -9.7F, 1.0F, 1, 2, 2, -0.3F, false));
        this.bone12.cubeList.add(new ModelBox(this.bone12, 0, 0, -3.0F, -9.7F, 1.0F, 1, 2, 2, -0.3F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.bone12.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 6, 4, -1.8F, -10.4F, 0.0F, 1, 2, 1, -0.31F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 6, 4, -1.5F, -11.1F, 0.0F, 1, 2, 1, -0.3F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 6, 4, -1.2F, -10.4F, 0.0F, 1, 2, 1, -0.31F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-3.0F, 0.0F, 0.0F);
        this.bone12.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 6, 4, 0.0F, -11.1F, 1.5F, 1, 2, 1, -0.3F, false));
        this.bone9.cubeList.add(new ModelBox(this.bone9, 6, 4, 0.0F, -10.4F, 1.8F, 1, 2, 1, -0.31F, false));
        this.bone9.cubeList.add(new ModelBox(this.bone9, 6, 4, 0.0F, -10.4F, 1.2F, 1, 2, 1, -0.31F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone12.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 6, 4, 0.0F, -11.1F, 1.5F, 1, 2, 1, -0.3F, false));
        this.bone8.cubeList.add(new ModelBox(this.bone8, 6, 4, 0.0F, -10.4F, 1.8F, 1, 2, 1, -0.31F, false));
        this.bone8.cubeList.add(new ModelBox(this.bone8, 6, 4, 0.0F, -10.4F, 1.2F, 1, 2, 1, -0.31F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-0.3F, -8.6F, 0.6F);
        this.setRotation(this.bone7, 0.0F, 0.7854F, 0.0F);
        this.bone12.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 0, -0.5F, -1.1F, -0.5F, 1, 2, 2, -0.3F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 6, 4, -0.5F, -2.5F, 0.0F, 1, 2, 1, -0.3F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 6, 4, -0.5F, -1.8F, 0.3F, 1, 2, 1, -0.31F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 6, 4, -0.5F, -1.8F, -0.3F, 1, 2, 1, -0.31F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-0.3F, -8.6F, 0.6F);
        this.setRotation(this.bone, 0.0F, 0.7854F, 0.0F);
        this.bone12.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -3.5F, -1.1F, -0.5F, 1, 2, 2, -0.3F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 6, 4, -3.5F, -2.4F, 0.0F, 1, 2, 1, -0.3F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 6, 4, -3.5F, -1.8F, 0.3F, 1, 2, 1, -0.31F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 6, 4, -3.5F, -1.8F, -0.3F, 1, 2, 1, -0.31F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.4F, -8.7F, 2.7F);
        this.setRotation(this.bone11, 0.0F, 0.7854F, 0.0F);
        this.bone12.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 0, 4, -1.5F, -1.0F, -0.5F, 2, 2, 1, -0.3F, false));
        this.bone11.cubeList.add(new ModelBox(this.bone11, 6, 4, -1.0F, -2.4F, -0.5F, 1, 2, 1, -0.3F, false));
        this.bone11.cubeList.add(new ModelBox(this.bone11, 6, 4, -1.3F, -1.7F, -0.5F, 1, 2, 1, -0.31F, false));
        this.bone11.cubeList.add(new ModelBox(this.bone11, 6, 4, -0.7F, -1.7F, -0.5F, 1, 2, 1, -0.31F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-0.3F, -8.6F, 0.6F);
        this.bone12.addChild(this.bone3);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.7F, -0.1F, 2.1F);
        this.setRotation(this.bone2, 0.0F, 0.7854F, 0.0F);
        this.bone3.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 4, -1.5F, -1.0F, -3.5F, 2, 2, 1, -0.3F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 6, 4, -1.0F, -2.4F, -3.5F, 1, 2, 1, -0.3F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 6, 4, -1.3F, -1.7F, -3.5F, 1, 2, 1, -0.31F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 6, 4, -0.7F, -1.7F, -3.5F, 1, 2, 1, -0.31F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone12.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 6, 4, -1.8F, -10.7F, 0.0F, 1, 2, 1, -0.31F, false));
        this.bone5.cubeList.add(new ModelBox(this.bone5, 6, 0, -1.5F, -11.7F, 0.0F, 1, 3, 1, -0.3001F, false));
        this.bone5.cubeList.add(new ModelBox(this.bone5, 6, 4, -1.2F, -10.7F, 0.0F, 1, 2, 1, -0.31F, false));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-1.1F, -10.0F, 0.3F);
        this.bone12.addChild(this.bone14);
        this.bone4 = new MModelRenderer(this);
        this.setRotation(this.bone4, 0.0F, 0.0F, 0.7854F);
        this.bone14.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 7, 8, -0.5F, -0.5F, -0.5F, 1, 1, 1, -0.3601F, false));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(0.1F, 0.1F, 0.0F);
        this.setRotation(this.bone13, 0.0F, 0.0F, 0.7854F);
        this.bone14.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 0, 7, -0.5F, -0.5F, -0.5F, 1, 1, 1, -0.36F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.2F, 0.0F, 0.0F);
        this.setRotation(this.bone6, 0.0F, 0.0F, 0.7854F);
        this.bone14.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 4, 7, -0.5F, -0.5F, -0.5F, 1, 1, 1, -0.3602F, false));
        super.setTexture(new ResourceLocation("minidot", "head/princesscrown.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.3245D, 0.04675000000000001D);
        double d0 = 1.6D;
        GlStateManager.scale(d0, d0, d0);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u043e\u0440\u043e\u043d\u0430 \u041f\u0440\u0438\u043d\u0446\u0435\u0441\u0441\u044b";
    }

    public String getCreator()
    {
        return "Ceme4ka7";
    }
}
