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

public class BloodyAxe extends BaseItem
{
    private final MModelRenderer Axe;
    private final MModelRenderer Stick;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer Iron;
    private final MModelRenderer bone15;
    private final MModelRenderer bone5;
    private final MModelRenderer bone10;
    private final MModelRenderer bone19;
    private final MModelRenderer bone18;
    private final MModelRenderer bone6;
    private final MModelRenderer bone20;
    private final MModelRenderer bone7;
    private final MModelRenderer bone16;
    private final MModelRenderer bone9;
    private final MModelRenderer bone17;
    private final MModelRenderer bone8;
    private final MModelRenderer Band;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer Band2;
    private final MModelRenderer bone14;
    private final MModelRenderer bone21;
    private final MModelRenderer bone22;
    private final MModelRenderer bone23;
    private final MModelRenderer bone24;

    public BloodyAxe()
    {
        super(ItemType.BODY);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Axe = new MModelRenderer(this);
        this.Axe.setRotationPoint(-1.8F, -1.8F, 0.0F);
        this.setRotation(this.Axe, 0.0F, 0.0F, 0.2094F);
        this.Stick = new MModelRenderer(this);
        this.Stick.setRotationPoint(0.2F, -2.8F, 0.0F);
        this.Axe.addChild(this.Stick);
        this.Stick.cubeList.add(new ModelBox(this.Stick, 0, 23, -2.0F, -6.6F, -1.0F, 2, 7, 2, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.3F, -1.0F, 0.0F);
        this.setRotation(this.bone, 0.0F, 0.0F, -0.0698F);
        this.Stick.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 17, -1.95F, -12.0F, -1.0F, 2, 7, 2, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.15F, -1.0F, 0.0F);
        this.setRotation(this.bone2, 0.0F, 0.0F, 0.0349F);
        this.Stick.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 8, 27, -2.14F, 0.8F, -1.0F, 2, 3, 2, 0.0F, false));
        this.Iron = new MModelRenderer(this);
        this.Iron.setRotationPoint(-1.3F, -1.7F, 0.0F);
        this.Axe.addChild(this.Iron);
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(0.1F, -11.9F, -0.6F);
        this.Iron.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 0, 6, -2.5F, -5.0F, -1.0F, 4, 3, 3, 0.0F, false));
        this.bone15.cubeList.add(new ModelBox(this.bone15, 0, 12, -1.5F, -3.4F, -1.0F, 3, 2, 3, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(3.0F, 1.2F, 0.0F);
        this.setRotation(this.bone5, 0.0F, 0.0F, 0.0524F);
        this.Iron.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 0, -0.4F, -18.05F, -1.0F, 2, 4, 2, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(2.8F, -16.0F, 0.0F);
        this.setRotation(this.bone10, 0.0F, 0.0F, -1.5184F);
        this.Iron.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 22, 5, -2.1614F, -1.2842F, -1.0F, 3, 2, 2, 0.0F, false));
        this.bone19 = new MModelRenderer(this);
        this.bone19.setRotationPoint(3.7F, -15.8F, 0.0F);
        this.setRotation(this.bone19, 0.0F, 0.0F, 0.2793F);
        this.Iron.addChild(this.bone19);
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(2.2F, -16.7F, 0.0F);
        this.setRotation(this.bone18, 0.0F, 0.0F, 1.3788F);
        this.Iron.addChild(this.bone18);
        this.bone18.cubeList.add(new ModelBox(this.bone18, 26, 0, -0.4086F, -1.2642F, -1.0F, 1, 3, 2, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(2.4F, -13.8F, 0.0F);
        this.setRotation(this.bone6, 0.0F, 0.0F, -1.2741F);
        this.Iron.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 20, 0, -0.4086F, -1.7358F, -1.0F, 1, 3, 2, 0.0F, false));
        this.bone20 = new MModelRenderer(this);
        this.bone20.setRotationPoint(-0.3086F, 0.2642F, 0.0F);
        this.setRotation(this.bone20, 0.0F, 0.0F, 0.1571F);
        this.bone6.addChild(this.bone20);
        this.bone20.cubeList.add(new ModelBox(this.bone20, 20, 0, -0.8F, -2.0F, -1.0F, 1, 3, 2, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(6.8F, -14.6F, 0.0F);
        this.setRotation(this.bone7, 0.0F, 0.0F, 0.0524F);
        this.Iron.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 14, 0, -1.4F, -2.03F, -0.5F, 2, 4, 1, 0.0F, false));
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(2.55F, -6.0F, 0.1F);
        this.setRotation(this.bone16, 0.0F, 0.0F, -0.8727F);
        this.bone7.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 14, 0, -5.3F, -0.9F, -0.6F, 1, 2, 1, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-1.45F, 2.8F, 0.1F);
        this.setRotation(this.bone9, 0.0F, 0.0F, 0.8727F);
        this.bone7.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 15, 5, -0.3F, -2.1F, -0.6F, 1, 2, 1, 0.0F, false));
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(-2.0F, -2.2F, 0.1F);
        this.setRotation(this.bone17, 0.0F, 0.0F, -1.7453F);
        this.bone7.addChild(this.bone17);
        this.bone17.cubeList.add(new ModelBox(this.bone17, 8, 0, -1.13F, -1.7F, -0.6F, 2, 3, 1, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-1.9F, 2.0F, 0.1F);
        this.setRotation(this.bone8, 0.0F, 0.0F, 1.8675F);
        this.bone7.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 8, 0, -1.1F, -1.3F, -0.6F, 2, 3, 1, 0.0F, false));
        this.Band = new MModelRenderer(this);
        this.Band.setRotationPoint(-2.3F, 0.0F, 0.0F);
        this.setRotation(this.Band, 0.0F, 0.0F, 0.1571F);
        this.bone3 = new MModelRenderer(this);
        this.Band.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 28, 16, -1.2F, -15.0F, 1.1F, 2, 1, 0, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-2.3F, -10.9F, 1.2F);
        this.setRotation(this.bone4, 0.0872F, 0.003F, -0.0348F);
        this.Band.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 28, 16, 1.2F, -4.0419F, -1.7587F, 0, 1, 2, 0.0F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.0F, -13.0F, 0.0F);
        this.setRotation(this.bone11, -0.0349F, 0.0F, 0.0F);
        this.Band.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 28, 18, -1.2F, -1.6F, -1.05F, 2, 1, 0, 0.0F, true));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(0.2F, -14.0F, -1.1F);
        this.setRotation(this.bone12, 0.0698F, 0.0F, 0.0F);
        this.Band.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 28, 14, -1.4F, -0.8F, 0.1F, 0, 1, 1, 0.0F, false));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-2.4F, -11.1F, 1.5F);
        this.setRotation(this.bone13, 0.1396F, 0.0F, 0.0F);
        this.Band.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 28, 15, 3.3F, -3.9419F, -1.9587F, 0, 1, 2, 0.0F, false));
        this.Band2 = new MModelRenderer(this);
        this.Band2.setRotationPoint(-2.3F, -0.9F, 0.0F);
        this.setRotation(this.Band2, 0.0F, 0.0F, 0.1571F);
        this.Band.addChild(this.Band2);
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(0.0F, -13.0F, 0.9F);
        this.setRotation(this.bone14, 0.1396F, 0.0F, 0.0F);
        this.Band2.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 28, 16, -1.2F, -2.0178F, 0.4196F, 2, 1, 0, 0.0F, false));
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(-2.0F, -10.9F, 1.2F);
        this.setRotation(this.bone21, 0.0868F, 0.0091F, -0.1043F);
        this.Band2.addChild(this.bone21);
        this.bone21.cubeList.add(new ModelBox(this.bone21, 28, 16, 1.1F, -4.0419F, -1.7587F, 0, 1, 2, 0.0F, false));
        this.bone22 = new MModelRenderer(this);
        this.bone22.setRotationPoint(0.8F, -12.0F, -0.1F);
        this.setRotation(this.bone22, -0.0524F, 0.0F, -0.0524F);
        this.Band2.addChild(this.bone22);
        this.bone22.cubeList.add(new ModelBox(this.bone22, 28, 18, -1.828F, -2.7164F, -1.05F, 2, 1, 0, 0.0F, true));
        this.bone23 = new MModelRenderer(this);
        this.bone23.setRotationPoint(0.2F, -14.0F, -1.1F);
        this.setRotation(this.bone23, 0.0697F, 0.0037F, -0.0522F);
        this.Band2.addChild(this.bone23);
        this.bone23.cubeList.add(new ModelBox(this.bone23, 28, 14, -1.4F, -0.8F, 0.0F, 0, 1, 1, 0.0F, false));
        this.bone24 = new MModelRenderer(this);
        this.bone24.setRotationPoint(-2.4F, -11.1F, 1.3F);
        this.setRotation(this.bone24, 0.1047F, 0.0F, 0.0F);
        this.Band2.addChild(this.bone24);
        this.bone24.cubeList.add(new ModelBox(this.bone24, 28, 15, 3.3F, -3.9419F, -1.9587F, 0, 1, 2, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "body/bloodyaxe.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        double d0 = 0.75D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, 1.3D, 0.225D);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.6D, 0.35D);
        double d0 = 0.8D;
        GlStateManager.scale(d0, d0, d0);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0440\u043e\u0432\u0430\u0432\u044b\u0439 \u0442\u043e\u043f\u043e\u0440";
    }

    public String getCreator()
    {
        return "FROSNAO";
    }
}
