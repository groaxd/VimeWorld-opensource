package net.xtrafrancyz.mods.minidot.items.head;

import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class ReindeerHat extends BaseHelm
{
    private final MModelRenderer Reindeer_hat;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final MModelRenderer bone16;
    private final MModelRenderer horns;
    private final MModelRenderer bone7;
    private final MModelRenderer bone4;
    private final MModelRenderer bone3;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone8;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;

    public ReindeerHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Reindeer_hat = new MModelRenderer(this);
        this.Reindeer_hat.setRotationPoint(0.0F, 25.0F, 0.0F);
        this.setRotation(this.Reindeer_hat, 0.0F, 3.1416F, 0.0F);
        this.Reindeer_hat.cubeList.add(new ModelBox(this.Reindeer_hat, 0, 0, -5.0F, -9.0F, -5.0F, 10, 1, 10, 0.0F));
        this.Reindeer_hat.cubeList.add(new ModelBox(this.Reindeer_hat, 24, 23, 4.25F, -8.0F, -2.0F, 1, 3, 4, 0.0F));
        this.Reindeer_hat.cubeList.add(new ModelBox(this.Reindeer_hat, 0, 0, -5.25F, -8.0F, -2.0F, 1, 3, 4, 0.0F));
        this.Reindeer_hat.cubeList.add(new ModelBox(this.Reindeer_hat, 30, 23, -5.25F, -5.25F, -0.5F, 1, 1, 1, 0.0F));
        this.Reindeer_hat.cubeList.add(new ModelBox(this.Reindeer_hat, 30, 7, 4.25F, -5.25F, -0.5F, 1, 1, 1, 0.0F));
        this.Reindeer_hat.cubeList.add(new ModelBox(this.Reindeer_hat, 0, 11, -4.5F, -12.0F, -4.5F, 9, 3, 9, 0.0F));
        this.Reindeer_hat.cubeList.add(new ModelBox(this.Reindeer_hat, 27, 17, 1.0F, -11.75F, 4.5003F, 3, 2, 0, 0.0F));
        this.Reindeer_hat.cubeList.add(new ModelBox(this.Reindeer_hat, 4, 7, -4.0F, -11.75F, 4.5003F, 3, 2, 0, 0.0F));
        this.Reindeer_hat.cubeList.add(new ModelBox(this.Reindeer_hat, 5, 18, -0.5F, -9.95F, 4.5F, 1, 1, 1, 0.4F));
        this.Reindeer_hat.cubeList.add(new ModelBox(this.Reindeer_hat, 0, 23, -4.0F, -12.5F, -4.0F, 8, 1, 8, 0.0F));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(-5.0F, 1.0F, -5.0F);
        this.Reindeer_hat.addChild(this.bone13);
        this.setRotation(this.bone13, -0.3927F, 0.0F, 0.0F);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 27, 14, -0.25F, -7.6913F, 0.4755F, 1, 1, 2, 0.0F));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(5.0F, 1.0F, -5.0F);
        this.Reindeer_hat.addChild(this.bone14);
        this.setRotation(this.bone14, -0.3927F, 0.0F, 0.0F);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 27, 11, -0.75F, -7.6913F, 0.4755F, 1, 1, 2, 0.0F));
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(5.0F, 1.0F, 5.0F);
        this.Reindeer_hat.addChild(this.bone15);
        this.setRotation(this.bone15, 0.3927F, 0.0F, 0.0F);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 0, 16, -0.75F, -7.6913F, -2.4755F, 1, 1, 2, 0.0F));
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(-5.0F, 1.0F, 5.0F);
        this.Reindeer_hat.addChild(this.bone16);
        this.setRotation(this.bone16, 0.3927F, 0.0F, 0.0F);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 0, 7, -0.25F, -7.6913F, -2.4755F, 1, 1, 2, 0.0F));
        this.horns = new MModelRenderer(this);
        this.horns.setRotationPoint(4.0F, 0.0F, -0.5F);
        this.Reindeer_hat.addChild(this.horns);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.horns.addChild(this.bone7);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-3.0F, 0.0F, 0.0F);
        this.bone7.addChild(this.bone4);
        this.setRotation(this.bone4, 0.0F, 0.0F, 0.2182F);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 30, 0, -1.0F, -15.5F, 0.0F, 1, 3, 1, 0.0F));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-0.7F, -11.9F, 0.0F);
        this.bone4.addChild(this.bone3);
        this.setRotation(this.bone3, 0.0F, 0.0F, 0.2182F);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 24, 23, -1.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone7.addChild(this.bone9);
        this.setRotation(this.bone9, 0.0F, 0.0F, -((float)Math.PI * 2F / 9F));
        this.bone9.cubeList.add(new ModelBox(this.bone9, 30, 4, 8.6F, -13.65F, 0.0F, 1, 2, 1, 0.0F));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-8.0F, 0.0F, 0.0F);
        this.bone7.addChild(this.bone10);
        this.setRotation(this.bone10, 0.0F, 0.0F, ((float)Math.PI * 2F / 9F));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 4, 28, -3.9F, -18.15F, 0.0F, 1, 2, 1, 0.0F));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-8.0F, 0.0F, 0.0F);
        this.horns.addChild(this.bone5);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.bone5.addChild(this.bone6);
        this.setRotation(this.bone6, 0.0F, 0.0F, -0.2182F);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 6, 0, 0.0F, -15.5F, 0.0F, 1, 3, 1, 0.0F));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.7F, -11.9F, 0.0F);
        this.bone6.addChild(this.bone8);
        this.setRotation(this.bone8, 0.0F, 0.0F, -0.2182F);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 0, 0.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone5.addChild(this.bone11);
        this.setRotation(this.bone11, 0.0F, 0.0F, ((float)Math.PI * 2F / 9F));
        this.bone11.cubeList.add(new ModelBox(this.bone11, 0, 28, -9.6F, -13.65F, 0.0F, 1, 2, 1, 0.0F));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(8.0F, 0.0F, 0.0F);
        this.bone5.addChild(this.bone12);
        this.setRotation(this.bone12, 0.0F, 0.0F, -((float)Math.PI * 2F / 9F));
        this.bone12.cubeList.add(new ModelBox(this.bone12, 5, 15, 2.9F, -18.15F, 0.0F, 1, 2, 1, 0.0F));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-1.0F, -0.5F, -4.5F);
        this.Reindeer_hat.addChild(this.bone);
        this.setRotation(this.bone, 0.0F, 0.0F, 0.4363F);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 23, 0.0F, -14.0F, 4.0F, 2, 4, 1, 0.0F));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(1.0F, -0.5F, -4.5F);
        this.Reindeer_hat.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 0.0F, -0.4363F);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 11, -2.0F, -14.0F, 4.0F, 2, 4, 1, 0.0F));
        this.setTexture(new ResourceLocation("minidot", "head/reindeerhat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -1.45F, 0.0F);
        GlStateManager.scale(1.05F, 1.05F, 1.05F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -1.0F, 0.0F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public String getName()
    {
        return "\u0428\u0430\u043f\u043a\u0430 \u041e\u043b\u0435\u043d\u044f";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Unturned");
    }
}
