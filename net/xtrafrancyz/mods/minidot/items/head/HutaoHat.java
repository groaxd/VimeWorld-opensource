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

public class HutaoHat extends BaseItem
{
    private final MModelRenderer owner;
    private final MModelRenderer bone;
    private final MModelRenderer bonefifteen;
    private final MModelRenderer bonefourteen;
    private final MModelRenderer bonesixteen;
    private final MModelRenderer bonetwo;
    private final MModelRenderer bonethree;
    private final MModelRenderer bonefour;
    private final MModelRenderer bonefive;
    private final MModelRenderer bonetwelve;
    private final MModelRenderer bonethirteen;
    private final MModelRenderer bonesix;
    private final MModelRenderer boneseven;
    private final MModelRenderer boneeight;
    private final MModelRenderer bonenine;
    private final MModelRenderer boneten;
    private final MModelRenderer boneeleven;

    public HutaoHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.owner = new MModelRenderer(this);
        this.owner.setRotationPoint(0.0F, -7.75F, -6.0F);
        this.owner.cubeList.add(new ModelBox(this.owner, 0, 0, -4.0F, -3.5F, 2.0F, 8, 1, 8, 0.01F, false));
        this.bone = new MModelRenderer(this);
        this.setRotation(this.bone, 0.0873F, 0.0F, 0.0F);
        this.owner.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 14, 32, -4.0F, -0.0737F, 0.0142F, 8, 0, 2, 0.0F, false));
        this.bonefifteen = new MModelRenderer(this);
        this.bonefifteen.setRotationPoint(0.0F, 9.0F, 6.0F);
        this.setRotation(this.bonefifteen, -0.1745F, 0.0F, 0.0F);
        this.bone.addChild(this.bonefifteen);
        this.bonefourteen = new MModelRenderer(this);
        this.bonefourteen.setRotationPoint(4.0F, 8.0F, 6.0F);
        this.setRotation(this.bonefourteen, -1.4835F, -1.4835F, 1.5708F);
        this.bone.addChild(this.bonefourteen);
        this.bonesixteen = new MModelRenderer(this);
        this.bonesixteen.setRotationPoint(-4.0F, 8.0F, 6.0F);
        this.setRotation(this.bonesixteen, -1.4835F, 1.4835F, -1.5708F);
        this.bone.addChild(this.bonesixteen);
        this.bonetwo = new MModelRenderer(this);
        this.bonetwo.setRotationPoint(0.0F, -1.75F, 5.75F);
        this.setRotation(this.bonetwo, 0.1309F, 0.0F, 0.0F);
        this.owner.addChild(this.bonetwo);
        this.bonetwo.cubeList.add(new ModelBox(this.bonetwo, 0, 20, -4.0F, -2.0F, -4.0F, 8, 3, 2, 0.0F, false));
        this.bonethree = new MModelRenderer(this);
        this.bonethree.setRotationPoint(0.0F, -1.75F, 6.25F);
        this.setRotation(this.bonethree, -0.1309F, 0.0F, 0.0F);
        this.owner.addChild(this.bonethree);
        this.bonethree.cubeList.add(new ModelBox(this.bonethree, 18, 17, -4.0F, -2.0F, 2.0F, 8, 3, 2, 0.0F, false));
        this.bonefour = new MModelRenderer(this);
        this.bonefour.setRotationPoint(-0.25F, -1.75F, 6.0F);
        this.setRotation(this.bonefour, 0.0F, -1.5708F, -0.1309F);
        this.owner.addChild(this.bonefour);
        this.bonefour.cubeList.add(new ModelBox(this.bonefour, 0, 14, -4.0F, -2.0F, 2.0F, 8, 3, 2, 0.0F, false));
        this.bonefive = new MModelRenderer(this);
        this.bonefive.setRotationPoint(0.25F, -1.75F, 6.0F);
        this.setRotation(this.bonefive, 0.0F, 1.5708F, 0.1309F);
        this.owner.addChild(this.bonefive);
        this.bonefive.cubeList.add(new ModelBox(this.bonefive, 0, 9, -4.0F, -2.0F, 2.0F, 8, 3, 2, 0.0F, false));
        this.bonetwelve = new MModelRenderer(this);
        this.bonetwelve.setRotationPoint(1.0F, 0.5F, 1.75F);
        this.setRotation(this.bonetwelve, 0.2618F, -0.2618F, 0.0F);
        this.bonefive.addChild(this.bonetwelve);
        this.bonetwelve.cubeList.add(new ModelBox(this.bonetwelve, 0, 25, -3.25F, -3.0F, 3.95F, 2, 2, 0, 0.0F, false));
        this.bonethirteen = new MModelRenderer(this);
        this.bonethirteen.setRotationPoint(1.25F, 1.25F, 0.5F);
        this.setRotation(this.bonethirteen, 0.296F, 0.0961F, -0.0329F);
        this.bonefive.addChild(this.bonethirteen);
        this.bonethirteen.cubeList.add(new ModelBox(this.bonethirteen, 26, 0, -3.25F, -2.0F, 4.35F, 2, 2, 0, 0.0F, false));
        this.bonesix = new MModelRenderer(this);
        this.bonesix.setRotationPoint(0.0F, -1.5F, 5.0F);
        this.setRotation(this.bonesix, 0.1309F, 0.0F, 0.0F);
        this.owner.addChild(this.bonesix);
        this.bonesix.cubeList.add(new ModelBox(this.bonesix, 20, 12, -2.0F, -3.0F, -4.0F, 4, 4, 1, -0.2F, false));
        this.bonesix.cubeList.add(new ModelBox(this.bonesix, 20, 22, -1.0F, -3.6F, -4.0F, 2, 1, 1, -0.2F, false));
        this.boneseven = new MModelRenderer(this);
        this.boneseven.setRotationPoint(0.25F, -1.25F, 6.75F);
        this.setRotation(this.boneseven, 0.0F, 1.5708F, 0.0F);
        this.owner.addChild(this.boneseven);
        this.boneseven.cubeList.add(new ModelBox(this.boneseven, 6, 25, -1.0F, 0.0F, 3.5F, 1, 1, 1, 0.0F, false));
        this.boneseven.cubeList.add(new ModelBox(this.boneseven, 25, 6, -2.75F, -0.5F, 4.25F, 2, 1, 0, 0.0F, false));
        this.boneseven.cubeList.add(new ModelBox(this.boneseven, 4, 0, -0.25F, -0.5F, 4.25F, 2, 1, 0, 0.0F, false));
        this.boneeight = new MModelRenderer(this);
        this.boneeight.setRotationPoint(0.75F, 1.0F, 4.0F);
        this.setRotation(this.boneeight, 0.0F, 0.0F, 1.0036F);
        this.boneseven.addChild(this.boneeight);
        this.boneeight.cubeList.add(new ModelBox(this.boneeight, 7, 28, -1.0F, -0.25F, 0.25F, 2, 1, 0, -1.0E-4F, false));
        this.bonenine = new MModelRenderer(this);
        this.bonenine.setRotationPoint(-1.0F, 2.0F, 0.0F);
        this.setRotation(this.bonenine, 0.0F, 0.0F, 1.0908F);
        this.boneeight.addChild(this.bonenine);
        this.bonenine.cubeList.add(new ModelBox(this.bonenine, 7, 28, -1.0F, -0.5F, 0.25F, 2, 1, 0, -1.0E-4F, false));
        this.boneten = new MModelRenderer(this);
        this.boneten.setRotationPoint(-1.5F, 5.5F, 4.75F);
        this.setRotation(this.boneten, -0.1745F, -0.1745F, 0.2182F);
        this.owner.addChild(this.boneten);
        this.boneten.cubeList.add(new ModelBox(this.boneten, 0, 3, 4.0F, -11.0F, 0.0F, 1, 4, 1, -0.3F, false));
        this.boneeleven = new MModelRenderer(this);
        this.boneeleven.setRotationPoint(-3.0F, 4.0F, 8.25F);
        this.setRotation(this.boneeleven, 0.4543F, -0.3581F, 0.2864F);
        this.owner.addChild(this.boneeleven);
        this.boneeleven.cubeList.add(new ModelBox(this.boneeleven, 4, 3, 4.25F, -9.0F, 0.0F, 1, 2, 1, -0.3F, false));
        super.setTexture(new ResourceLocation("minidot", "head/hutaohat.png"));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.2112F, 0.0F);
        super.renderAsItem(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
    }

    public String getName()
    {
        return "\u0428\u043b\u044f\u043f\u0430 \u0425\u0443 \u0422\u0430\u043e";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Genshin Impact");
    }

    public String getCreator()
    {
        return "Florina";
    }
}
