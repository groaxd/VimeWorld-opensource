package net.xtrafrancyz.mods.minidot.items.head;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class MarvelScarletTiara extends BaseItem
{
    private final MModelRenderer MarvelScarletTiara;
    private final MModelRenderer OnePart;
    private final MModelRenderer bone;
    private final MModelRenderer bone5;
    private final MModelRenderer bone10;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone11;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone29;
    private final MModelRenderer TwoPart;
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
    private final MModelRenderer bone26;
    private final MModelRenderer bone27;
    private final MModelRenderer bone28;
    private final MModelRenderer bone30;

    public MarvelScarletTiara()
    {
        super(ItemType.HEAD);
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.MarvelScarletTiara = new MModelRenderer(this);
        this.MarvelScarletTiara.setRotationPoint(0.0F, 4.0F, 4.0F);
        this.OnePart = new MModelRenderer(this);
        this.MarvelScarletTiara.addChild(this.OnePart);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-0.75F, 0.75F, -0.75F);
        this.setRotation(this.bone, 0.0F, 0.2618F, 0.2182F);
        this.OnePart.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 5, 5, -3.0F, -10.0F, -5.25F, 2, 2, 1, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-2.0F, 0.75F, 0.0F);
        this.setRotation(this.bone5, -0.3917F, 1.1063F, -0.105F);
        this.OnePart.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 3, 2.6184F, -8.9026F, -5.7806F, 2, 2, 1, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-3.0F, 0.75F, 0.0F);
        this.OnePart.addChild(this.bone10);
        this.bone6 = new MModelRenderer(this);
        this.setRotation(this.bone6, -0.3917F, 1.1063F, -0.105F);
        this.bone10.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 4, 11, 2.6184F, -8.9026F, -5.7806F, 1, 2, 1, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.setRotation(this.bone7, 0.0F, 1.1044F, 0.0F);
        this.bone10.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 11, 1, 2.2118F, -8.6585F, -3.5101F, 1, 2, 1, -0.1F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.325F, 1.0F, -0.65F);
        this.setRotation(this.bone8, -0.1714F, 1.0969F, -0.1922F);
        this.bone10.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 10, 10, 2.2118F, -8.6585F, -3.5101F, 1, 2, 1, -0.17F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.575F, 2.0F, -0.65F);
        this.setRotation(this.bone9, -0.1714F, 1.0969F, -0.1922F);
        this.bone10.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 10, 2.2118F, -8.6585F, -3.5101F, 1, 2, 1, -0.3F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-2.5F, -16.75F, 0.0F);
        this.OnePart.addChild(this.bone11);
        this.bone13 = new MModelRenderer(this);
        this.setRotation(this.bone13, 0.0F, 1.1044F, 0.0F);
        this.bone11.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 7, 8, 2.2118F, 6.6585F, -3.5101F, 1, 2, 1, -0.1F, false));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(0.325F, -1.0F, -0.65F);
        this.setRotation(this.bone14, 0.1714F, 1.0969F, 0.1922F);
        this.bone11.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 3, 8, 2.2118F, 6.6585F, -3.5101F, 1, 2, 1, -0.17F, false));
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(1.325F, -2.0F, -0.225F);
        this.setRotation(this.bone15, 0.0711F, 1.0969F, 0.1922F);
        this.bone11.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 7, 2, 2.2118F, 6.6585F, -3.7601F, 1, 2, 1, -0.3F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 0.75F, 0.0F);
        this.setRotation(this.bone2, 0.0F, 0.0F, 0.6545F);
        this.OnePart.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 6, 0, -6.7192F, -7.4229F, -5.25F, 2, 1, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 2.0F, -4.0F);
        this.setRotation(this.bone3, 0.0F, 0.6109F, 0.6545F);
        this.OnePart.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 0, -6.4692F, -7.4229F, -5.0F, 2, 1, 2, 0.0F, false));
        this.bone29 = new MModelRenderer(this);
        this.bone29.setRotationPoint(2.075F, 0.0F, -0.65F);
        this.setRotation(this.bone29, 0.0467F, 1.0969F, -0.1922F);
        this.OnePart.addChild(this.bone29);
        this.bone29.cubeList.add(new ModelBox(this.bone29, 0, 6, 2.2118F, -8.1585F, -3.2601F, 1, 2, 1, -0.3F, false));
        this.TwoPart = new MModelRenderer(this);
        this.MarvelScarletTiara.addChild(this.TwoPart);
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(0.75F, 0.75F, -0.75F);
        this.setRotation(this.bone16, 0.0F, -0.2618F, -0.2182F);
        this.TwoPart.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 5, 5, 1.0F, -10.0F, -5.25F, 2, 2, 1, 0.0F, true));
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(2.0F, 0.75F, 0.0F);
        this.setRotation(this.bone17, -0.3917F, -1.1063F, 0.105F);
        this.TwoPart.addChild(this.bone17);
        this.bone17.cubeList.add(new ModelBox(this.bone17, 0, 3, -4.6184F, -8.9026F, -5.7806F, 2, 2, 1, 0.0F, true));
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(3.0F, 0.75F, 0.0F);
        this.TwoPart.addChild(this.bone18);
        this.bone19 = new MModelRenderer(this);
        this.setRotation(this.bone19, -0.3917F, -1.1063F, 0.105F);
        this.bone18.addChild(this.bone19);
        this.bone19.cubeList.add(new ModelBox(this.bone19, 4, 11, -3.6184F, -8.9026F, -5.7806F, 1, 2, 1, 0.0F, true));
        this.bone20 = new MModelRenderer(this);
        this.setRotation(this.bone20, 0.0F, -1.1044F, 0.0F);
        this.bone18.addChild(this.bone20);
        this.bone20.cubeList.add(new ModelBox(this.bone20, 11, 1, -3.2118F, -8.6585F, -3.5101F, 1, 2, 1, -0.1F, true));
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(-0.325F, 1.0F, -0.65F);
        this.setRotation(this.bone21, -0.1714F, -1.0969F, 0.1922F);
        this.bone18.addChild(this.bone21);
        this.bone21.cubeList.add(new ModelBox(this.bone21, 10, 10, -3.2118F, -8.6585F, -3.5101F, 1, 2, 1, -0.17F, true));
        this.bone22 = new MModelRenderer(this);
        this.bone22.setRotationPoint(-0.575F, 2.0F, -0.65F);
        this.setRotation(this.bone22, -0.1714F, -1.0969F, 0.1922F);
        this.bone18.addChild(this.bone22);
        this.bone22.cubeList.add(new ModelBox(this.bone22, 0, 10, -3.2118F, -8.6585F, -3.5101F, 1, 2, 1, -0.3F, true));
        this.bone23 = new MModelRenderer(this);
        this.bone23.setRotationPoint(2.5F, -16.75F, 0.0F);
        this.TwoPart.addChild(this.bone23);
        this.bone24 = new MModelRenderer(this);
        this.setRotation(this.bone24, 0.0F, -1.1044F, 0.0F);
        this.bone23.addChild(this.bone24);
        this.bone24.cubeList.add(new ModelBox(this.bone24, 7, 8, -3.2118F, 6.6585F, -3.5101F, 1, 2, 1, -0.1F, true));
        this.bone25 = new MModelRenderer(this);
        this.bone25.setRotationPoint(-0.325F, -1.0F, -0.65F);
        this.setRotation(this.bone25, 0.1714F, -1.0969F, -0.1922F);
        this.bone23.addChild(this.bone25);
        this.bone25.cubeList.add(new ModelBox(this.bone25, 3, 8, -3.2118F, 6.6585F, -3.5101F, 1, 2, 1, -0.17F, true));
        this.bone26 = new MModelRenderer(this);
        this.bone26.setRotationPoint(-1.325F, -2.0F, -0.225F);
        this.setRotation(this.bone26, 0.0711F, -1.0969F, -0.1922F);
        this.bone23.addChild(this.bone26);
        this.bone26.cubeList.add(new ModelBox(this.bone26, 7, 2, -3.2118F, 6.6585F, -3.7601F, 1, 2, 1, -0.3F, true));
        this.bone27 = new MModelRenderer(this);
        this.bone27.setRotationPoint(0.0F, 0.75F, 0.0F);
        this.setRotation(this.bone27, 0.0F, 0.0F, -0.6545F);
        this.TwoPart.addChild(this.bone27);
        this.bone27.cubeList.add(new ModelBox(this.bone27, 6, 0, 4.7192F, -7.4229F, -5.25F, 2, 1, 1, 0.001F, true));
        this.bone28 = new MModelRenderer(this);
        this.bone28.setRotationPoint(0.0F, 2.0F, -4.0F);
        this.setRotation(this.bone28, 0.0F, -0.6109F, -0.6545F);
        this.TwoPart.addChild(this.bone28);
        this.bone28.cubeList.add(new ModelBox(this.bone28, 0, 0, 4.4692F, -7.4229F, -5.0F, 2, 1, 2, 0.0F, true));
        this.bone30 = new MModelRenderer(this);
        this.bone30.setRotationPoint(-2.075F, 0.0F, -0.65F);
        this.setRotation(this.bone30, 0.0467F, -1.0969F, 0.1922F);
        this.TwoPart.addChild(this.bone30);
        this.bone30.cubeList.add(new ModelBox(this.bone30, 0, 6, -3.2118F, -8.1585F, -3.2601F, 1, 2, 1, -0.3F, true));
        super.setTexture(new ResourceLocation("minidot", "head/marvelscarlettiara.png"));
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.cos(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, -0.1D, -0.3D);
    }

    public void renderAsItem(float time)
    {
        double d0 = 1.1D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, -0.1D, 0.0D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0422\u0438\u0430\u0440\u0430 \u0410\u043b\u043e\u0439 \u0412\u0435\u0434\u044c\u043c\u044b";
    }

    public String getCreator()
    {
        return "Rander_";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.RED + "" + EnumChatFormatting.BOLD + "MARVEL");
    }
}
