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

public class DeerHornsCurvedHat extends BaseItem
{
    private final MModelRenderer NewLeft;
    private final MModelRenderer leftnew;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone26;
    private final MModelRenderer NewRight;
    private final MModelRenderer bone;
    private final MModelRenderer bone4;
    private final MModelRenderer bone15;
    private final MModelRenderer bone16;
    private final MModelRenderer bone17;
    private final MModelRenderer bone18;
    private final MModelRenderer bone19;
    private final MModelRenderer bone20;
    private final MModelRenderer bone21;
    private final MModelRenderer bone22;
    private final MModelRenderer bone23;
    private final MModelRenderer bone24;
    private final MModelRenderer bone25;
    private final MModelRenderer bone27;

    public DeerHornsCurvedHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 8;
        this.useDisplayLists = true;
        this.NewLeft = new MModelRenderer(this);
        this.leftnew = new MModelRenderer(this);
        this.leftnew.setRotationPoint(3.0F, 2.0F, 2.0F);
        this.setRotation(this.leftnew, 0.0F, 0.0F, -1.4835F);
        this.NewLeft.addChild(this.leftnew);
        this.leftnew.cubeList.add(new ModelBox(this.leftnew, 0, 3, 10.6348F, 4.5083F, -3.0F, 4, 1, 1, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(3.0F, 2.0F, 2.0F);
        this.setRotation(this.bone2, 0.0F, 0.0F, -0.7854F);
        this.NewLeft.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 5, 9.6874F, -3.6163F, -3.0F, 2, 1, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(3.0F, 2.0F, 2.0F);
        this.NewLeft.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 3, 1.0F, -9.7F, -3.0F, 4, 1, 1, -0.003F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(3.0F, 2.0F, 2.0F);
        this.setRotation(this.bone5, ((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.NewLeft.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 3, 5.4142F, -11.6763F, 4.2032F, 1, 2, 1, -0.005F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(3.9923F, 1.215F, 2.0F);
        this.NewLeft.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 1, 3, 4.7706F, -14.314F, -3.0F, 1, 1, 1, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(3.9923F, 1.215F, 2.0F);
        this.setRotation(this.bone7, 0.0F, 0.0F, -0.3491F);
        this.NewLeft.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 3, 9.3182F, -13.4771F, -3.0F, 1, 2, 1, -0.005F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(3.9923F, 1.215F, 2.0F);
        this.setRotation(this.bone8, 0.0F, 0.0F, -0.8727F);
        this.NewLeft.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 3, 12.0582F, -6.6624F, -3.0F, 1, 3, 1, -0.005F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(3.9923F, 1.215F, 2.0F);
        this.setRotation(this.bone9, 0.0F, 0.0F, 0.8727F);
        this.NewLeft.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 3, -4.6614F, -13.1501F, -3.0F, 1, 3, 1, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.9877F, -0.3436F, 2.0F);
        this.NewLeft.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 1, 3, 9.7246F, -10.699F, -3.0F, 1, 1, 1, -0.005F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.9877F, -0.3436F, 2.0F);
        this.setRotation(this.bone11, -0.5236F, 0.0F, 0.0F);
        this.NewLeft.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 0, 3, 7.4265F, -8.7296F, -6.6174F, 1, 3, 1, 0.0F, false));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(0.9877F, -0.3436F, 2.0F);
        this.NewLeft.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 1, 3, 7.4265F, -11.3687F, -1.5F, 1, 1, 1, -0.005F, false));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(0.9877F, -0.3436F, 2.0F);
        this.setRotation(this.bone13, 0.0F, 0.0F, 0.4363F);
        this.NewLeft.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 0, 3, -0.3789F, -9.9403F, -3.0F, 1, 2, 1, -0.005F, false));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(0.9877F, -0.3436F, 2.0F);
        this.setRotation(this.bone14, 0.0F, 0.0F, ((float)Math.PI * 2F / 9F));
        this.NewLeft.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 1, 3, -2.9387F, -10.5035F, -3.0F, 1, 1, 1, 0.0F, false));
        this.bone26 = new MModelRenderer(this);
        this.bone26.setRotationPoint(3.0F, 2.0F, 3.0F);
        this.setRotation(this.bone26, 0.0F, 0.0F, 0.7854F);
        this.NewLeft.addChild(this.bone26);
        this.bone26.cubeList.add(new ModelBox(this.bone26, 0, 3, -3.3234F, -10.3945F, -4.0F, 2, 1, 1, -0.005F, false));
        this.NewRight = new MModelRenderer(this);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-3.0F, 2.0F, 5.0F);
        this.NewRight.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 3, -5.0F, -9.7F, -6.0F, 4, 1, 1, -0.003F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-3.0F, 2.0F, 5.0F);
        this.setRotation(this.bone4, 0.0F, 0.0F, -0.7854F);
        this.NewRight.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 3, 2.6163F, -11.6874F, -6.0F, 1, 2, 1, 0.0F, false));
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(-3.0F, 2.0F, 5.0F);
        this.setRotation(this.bone15, 0.0F, 0.0F, -((float)Math.PI * 2F / 9F));
        this.NewRight.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 1, 3, 4.9866F, -11.0053F, -6.0F, 1, 1, 1, 0.0F, false));
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(-3.0F, 2.0F, 5.0F);
        this.setRotation(this.bone16, 0.0F, 0.0F, -0.4363F);
        this.NewRight.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 0, 3, 2.1931F, -11.2138F, -6.0F, 1, 2, 1, -0.005F, false));
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(-3.0F, 2.0F, 5.0F);
        this.setRotation(this.bone17, 0.0F, 0.0F, -0.0873F);
        this.NewRight.addChild(this.bone17);
        this.bone17.cubeList.add(new ModelBox(this.bone17, 0, 3, -5.5083F, -14.6348F, -6.0F, 1, 4, 1, 0.0F, false));
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(-3.0F, 2.0F, 5.0F);
        this.NewRight.addChild(this.bone18);
        this.bone18.cubeList.add(new ModelBox(this.bone18, 1, 3, -6.7628F, -15.099F, -6.0F, 1, 1, 1, 0.0F, false));
        this.bone19 = new MModelRenderer(this);
        this.bone19.setRotationPoint(-3.0F, 2.0F, 5.0F);
        this.setRotation(this.bone19, 0.0F, 0.0F, 0.3491F);
        this.NewRight.addChild(this.bone19);
        this.bone19.cubeList.add(new ModelBox(this.bone19, 0, 3, -11.5191F, -13.8754F, -6.0F, 1, 2, 1, -0.005F, false));
        this.bone20 = new MModelRenderer(this);
        this.bone20.setRotationPoint(-3.0F, 2.0F, 5.0F);
        this.setRotation(this.bone20, 0.0F, 0.0F, -0.8727F);
        this.NewRight.addChild(this.bone20);
        this.bone20.cubeList.add(new ModelBox(this.bone20, 0, 3, 3.625F, -14.4149F, -6.0F, 1, 3, 1, 0.0F, false));
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(-3.0F, 2.0F, 5.0F);
        this.setRotation(this.bone21, ((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.NewRight.addChild(this.bone21);
        this.bone21.cubeList.add(new ModelBox(this.bone21, 0, 3, -6.4142F, -13.6047F, 1.905F, 1, 2, 1, -0.005F, false));
        this.bone22 = new MModelRenderer(this);
        this.bone22.setRotationPoint(-3.0F, 2.0F, 5.0F);
        this.setRotation(this.bone22, -0.5236F, 0.0F, 0.0F);
        this.NewRight.addChild(this.bone22);
        this.bone22.cubeList.add(new ModelBox(this.bone22, 0, 3, -6.4142F, -9.2592F, -10.3872F, 1, 3, 1, 0.0F, false));
        this.bone23 = new MModelRenderer(this);
        this.bone23.setRotationPoint(-3.0F, 2.0F, 3.0F);
        this.setRotation(this.bone23, 0.0F, 0.0F, 0.8727F);
        this.NewRight.addChild(this.bone23);
        this.bone23.cubeList.add(new ModelBox(this.bone23, 0, 3, -14.2973F, -6.4069F, -4.0F, 1, 3, 1, -0.005F, false));
        this.bone24 = new MModelRenderer(this);
        this.bone24.setRotationPoint(-3.0F, 2.0F, 3.0F);
        this.NewRight.addChild(this.bone24);
        this.bone24.cubeList.add(new ModelBox(this.bone24, 1, 3, -8.7123F, -13.0426F, -4.0F, 1, 1, 1, -0.005F, false));
        this.bone25 = new MModelRenderer(this);
        this.bone25.setRotationPoint(-3.0F, 2.0F, 3.0F);
        this.NewRight.addChild(this.bone25);
        this.bone25.cubeList.add(new ModelBox(this.bone25, 1, 3, -6.4142F, -13.7123F, -2.5F, 1, 1, 1, -0.005F, false));
        this.bone27 = new MModelRenderer(this);
        this.bone27.setRotationPoint(-3.0F, 2.0F, 5.0F);
        this.setRotation(this.bone27, 0.0F, 0.0F, -0.7854F);
        this.NewRight.addChild(this.bone27);
        this.bone27.cubeList.add(new ModelBox(this.bone27, 0, 3, 1.3234F, -10.3945F, -6.0F, 2, 1, 1, -0.005F, false));
        this.setTexture(new ResourceLocation("minidot", "head/deerhorns_curved_hat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.5F, 0.7F, 0.7F);
        GlStateManager.translate(0.0F, 0.35F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041e\u043b\u0435\u043d\u044c\u0438 \u0440\u043e\u0433\u0430";
    }
}
