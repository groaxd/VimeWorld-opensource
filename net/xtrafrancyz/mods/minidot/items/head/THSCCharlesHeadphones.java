package net.xtrafrancyz.mods.minidot.items.head;

import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class THSCCharlesHeadphones extends BaseItem
{
    private final MModelRenderer Pilot_Hat;
    private final MModelRenderer headphones;
    private final MModelRenderer Mic;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer bone4;

    public THSCCharlesHeadphones()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Pilot_Hat = new MModelRenderer(this);
        this.headphones = new MModelRenderer(this);
        this.headphones.setRotationPoint(0.0F, 0.0F, 0.5F);
        this.Pilot_Hat.addChild(this.headphones);
        this.headphones.cubeList.add(new ModelBox(this.headphones, 6, 0, 3.684F, -9.2412F, -1.0F, 1, 2, 1, 0.0F, false));
        this.headphones.cubeList.add(new ModelBox(this.headphones, 12, 24, 3.7443F, -8.2019F, -3.7F, 1, 4, 1, -0.2F, false));
        this.headphones.cubeList.add(new ModelBox(this.headphones, 4, 23, 3.7443F, -8.2019F, 1.7F, 1, 4, 1, -0.2F, false));
        this.headphones.cubeList.add(new ModelBox(this.headphones, 32, 28, 3.7443F, -8.4519F, -3.5F, 1, 1, 6, -0.2F, false));
        this.headphones.cubeList.add(new ModelBox(this.headphones, 26, 11, 3.0278F, -7.7232F, -3.0F, 3, 5, 5, 0.0F, false));
        this.headphones.cubeList.add(new ModelBox(this.headphones, 22, 24, -6.7118F, -7.7232F, -3.0F, 3, 5, 5, 0.0F, false));
        this.headphones.cubeList.add(new ModelBox(this.headphones, 0, 11, -5.4284F, -8.2019F, -3.7F, 1, 4, 1, -0.2F, false));
        this.headphones.cubeList.add(new ModelBox(this.headphones, 30, 2, -5.4284F, -8.4519F, -3.5F, 1, 1, 6, -0.2F, false));
        this.headphones.cubeList.add(new ModelBox(this.headphones, 0, 0, -5.3681F, -9.2412F, -1.0F, 1, 2, 1, 0.0F, false));
        this.headphones.cubeList.add(new ModelBox(this.headphones, 0, 23, -5.4284F, -8.2019F, 1.7F, 1, 4, 1, -0.2F, false));
        this.headphones.cubeList.add(new ModelBox(this.headphones, 0, 35, -4.342F, -12.0603F, -1.0F, 8, 1, 1, 0.0F, false));
        this.headphones.cubeList.add(new ModelBox(this.headphones, 0, 31, -2.34F, -12.5F, -1.5F, 4, 1, 2, 0.0F, false));
        this.Mic = new MModelRenderer(this);
        this.Mic.setRotationPoint(-0.75F, 0.0F, 0.0F);
        this.headphones.addChild(this.Mic);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(6.1F, -1.1F, -5.75F);
        this.setRotation(this.bone3, 0.1634F, -0.5457F, -0.3076F);
        this.Mic.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 18, 15, -3.3956F, -0.3529F, -0.0501F, 1, 1, 1, 0.1F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 18, 11, -2.6456F, -0.3529F, -0.0501F, 3, 1, 1, -0.2F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(5.85F, -3.1F, -2.5F);
        this.setRotation(this.bone2, 0.6109F, 0.0F, 0.0F);
        this.Mic.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -0.5382F, -0.4732F, -3.75F, 1, 1, 4, -0.2F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(3.05F, -12.5F, -0.5F);
        this.setRotation(this.bone, 0.0F, 0.0F, 1.2217F);
        this.headphones.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 7, 0.6211F, -0.4209F, -0.5F, 3, 1, 1, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-3.8F, -12.5F, -0.5F);
        this.setRotation(this.bone4, 0.0F, 0.0F, -1.2217F);
        this.headphones.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 5, -3.5986F, -0.3589F, -0.5F, 3, 1, 1, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/thsc_charlesheadphones.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.02D, 0.125D, 0.02D);
    }

    public void renderAsItem(float time)
    {
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041d\u0430\u0443\u0448\u043d\u0438\u043a\u0438 \u0427\u0430\u0440\u043b\u044c\u0437\u0430";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("The Henry Stickmin Collection");
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
