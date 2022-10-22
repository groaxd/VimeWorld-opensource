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

public class SmallDiadem extends BaseItem
{
    private final MModelRenderer bb_main;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final MModelRenderer bone9;
    private final MModelRenderer bone11;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone10;
    private final MModelRenderer bone;
    private final MModelRenderer bone13;
    private final MModelRenderer bone12;
    private final MModelRenderer bone14;
    private final MModelRenderer bone16;
    private final MModelRenderer bone15;
    private final MModelRenderer bone17;
    private final MModelRenderer bone18;
    private final MModelRenderer bone19;
    private final MModelRenderer bone20;
    private final MModelRenderer bone21;
    private final MModelRenderer bone22;
    private final MModelRenderer bone23;
    private final MModelRenderer bone24;
    private final MModelRenderer bone25;
    private final MModelRenderer bone26;
    private final MModelRenderer bone27;
    private final MModelRenderer bone28;

    public SmallDiadem()
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.bb_main = new MModelRenderer(this);
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 4, -1.5F, -8.8F, -4.0F, 3, 1, 1, -0.2F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-1.2F, -8.3F, -3.1F);
        this.setRotation(this.bone2, -3.1416F, -0.829F, -3.1416F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-0.1F, 0.0F, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone3.addChild(this.bone5);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.4F, -8.6F, -3.5F);
        this.setRotation(this.bone4, 0.0F, 0.0F, 0.3665F);
        this.bone5.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 6, 6, -0.4644F, -1.1458F, -0.5F, 1, 2, 1, -0.3F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.6F, -10.2F, -3.5F);
        this.setRotation(this.bone9, 0.0F, 0.0F, -0.3491F);
        this.bone3.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 6, 6, -0.7049F, -0.746F, -0.5F, 1, 2, 1, -0.2999F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.1F, -10.7F, -3.5F);
        this.setRotation(this.bone11, 0.0F, 0.0F, -0.7854F);
        this.bone3.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 7, 1, -0.3971F, -0.5917F, -0.5F, 1, 1, 1, -0.1F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.1F, 0.0F, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone6.addChild(this.bone7);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-0.4F, -8.6F, -3.5F);
        this.setRotation(this.bone8, 0.0F, 0.0F, -0.3665F);
        this.bone7.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 6, 6, -0.5356F, -1.1458F, -0.5F, 1, 2, 1, -0.3F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-0.6F, -10.2F, -3.5F);
        this.setRotation(this.bone10, 0.0F, 0.0F, 0.3491F);
        this.bone6.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 6, 6, -0.2951F, -0.746F, -0.5F, 1, 2, 1, -0.2999F, false));
        this.bone = new MModelRenderer(this);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(0.5F, -10.1F, -3.5F);
        this.setRotation(this.bone13, 0.0F, 0.0F, -1.0123F);
        this.bone.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 6, 6, -0.3908F, -0.6371F, -0.5F, 1, 2, 1, -0.2998F, false));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(1.2F, -9.0F, -3.5F);
        this.setRotation(this.bone12, 0.0F, 0.0F, 0.1571F);
        this.bone.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 6, 6, -0.4644F, -1.1458F, -0.5F, 1, 2, 1, -0.3F, false));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(1.9F, -9.5F, -3.5F);
        this.setRotation(this.bone14, -2.7709F, 0.9718F, -2.6556F);
        this.bone.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 0, 6, -1.3883F, -0.5209F, -1.0233F, 2, 1, 1, -0.3F, false));
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(2.3F, -8.5F, -1.8F);
        this.setRotation(this.bone16, -2.2734F, 0.5959F, -1.9843F);
        this.bone.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 0, 6, -0.6229F, -0.5041F, -0.4973F, 2, 1, 1, -0.3F, false));
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(1.7F, -8.2F, -2.7F);
        this.setRotation(this.bone15, 3.1146F, 0.9652F, 3.1227F);
        this.bone.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 0, 0, -1.6787F, -0.5999F, -0.5107F, 3, 1, 1, -0.2F, false));
        this.bone17 = new MModelRenderer(this);
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(-0.5F, -10.1F, -3.5F);
        this.setRotation(this.bone18, 0.0F, 0.0F, 1.0123F);
        this.bone17.addChild(this.bone18);
        this.bone18.cubeList.add(new ModelBox(this.bone18, 6, 6, -0.6092F, -0.6371F, -0.5F, 1, 2, 1, -0.2998F, false));
        this.bone19 = new MModelRenderer(this);
        this.bone19.setRotationPoint(-1.2F, -9.0F, -3.5F);
        this.setRotation(this.bone19, 0.0F, 0.0F, -0.1571F);
        this.bone17.addChild(this.bone19);
        this.bone19.cubeList.add(new ModelBox(this.bone19, 6, 6, -0.5356F, -1.1458F, -0.5F, 1, 2, 1, -0.3F, false));
        this.bone20 = new MModelRenderer(this);
        this.bone20.setRotationPoint(-1.9F, -9.5F, -3.5F);
        this.setRotation(this.bone20, -2.7709F, -0.9718F, 2.6556F);
        this.bone17.addChild(this.bone20);
        this.bone20.cubeList.add(new ModelBox(this.bone20, 0, 6, -0.6117F, -0.5209F, -1.0233F, 2, 1, 1, -0.3F, false));
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(-2.3F, -8.5F, -1.8F);
        this.setRotation(this.bone21, -2.2734F, -0.5959F, 1.9843F);
        this.bone17.addChild(this.bone21);
        this.bone21.cubeList.add(new ModelBox(this.bone21, 0, 6, -1.3771F, -0.5041F, -0.4973F, 2, 1, 1, -0.3F, false));
        this.bone22 = new MModelRenderer(this);
        this.bone22.setRotationPoint(-1.7F, -8.2F, -2.7F);
        this.setRotation(this.bone22, 3.1146F, -0.9652F, -3.1227F);
        this.bone17.addChild(this.bone22);
        this.bone22.cubeList.add(new ModelBox(this.bone22, 0, 2, -1.3213F, -0.5999F, -0.5107F, 3, 1, 1, -0.2F, false));
        this.bone23 = new MModelRenderer(this);
        this.bone24 = new MModelRenderer(this);
        this.bone24.setRotationPoint(0.5F, -10.1F, -3.5F);
        this.setRotation(this.bone24, 0.0F, 0.0F, -1.0123F);
        this.bone23.addChild(this.bone24);
        this.bone24.cubeList.add(new ModelBox(this.bone24, 6, 6, -0.3908F, -0.6371F, -0.5F, 1, 2, 1, -0.3F, false));
        this.bone25 = new MModelRenderer(this);
        this.bone25.setRotationPoint(1.2F, -9.0F, -3.5F);
        this.setRotation(this.bone25, 0.0F, 0.0F, 0.1571F);
        this.bone23.addChild(this.bone25);
        this.bone25.cubeList.add(new ModelBox(this.bone25, 6, 6, -0.4644F, -1.1458F, -0.5F, 1, 2, 1, -0.3F, false));
        this.bone26 = new MModelRenderer(this);
        this.bone26.setRotationPoint(1.9F, -9.5F, -3.5F);
        this.setRotation(this.bone26, -2.7709F, 0.9718F, -2.6556F);
        this.bone23.addChild(this.bone26);
        this.bone26.cubeList.add(new ModelBox(this.bone26, 0, 6, -1.3883F, -0.5209F, -1.0233F, 2, 1, 1, -0.3F, false));
        this.bone27 = new MModelRenderer(this);
        this.bone27.setRotationPoint(2.3F, -8.5F, -1.8F);
        this.setRotation(this.bone27, -2.2734F, 0.5959F, -1.9843F);
        this.bone23.addChild(this.bone27);
        this.bone27.cubeList.add(new ModelBox(this.bone27, 0, 6, -0.6229F, -0.5041F, -0.4973F, 2, 1, 1, -0.3F, false));
        this.bone28 = new MModelRenderer(this);
        this.bone28.setRotationPoint(1.7F, -8.2F, -2.7F);
        this.setRotation(this.bone28, 3.1146F, 0.9652F, 3.1227F);
        this.bone23.addChild(this.bone28);
        this.bone28.cubeList.add(new ModelBox(this.bone28, 0, 0, -1.6787F, -0.5999F, -0.5107F, 3, 1, 1, -0.2F, false));
        super.setTexture(new ResourceLocation("minidot", "head/diadem.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.30250000000000005D, 0.16225D);
        double d0 = 1.58D;
        GlStateManager.scale(d0, d0, d0);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0414\u0438\u0430\u0434\u0435\u043c\u0430";
    }

    public String getCreator()
    {
        return "Ceme4ka7";
    }
}
