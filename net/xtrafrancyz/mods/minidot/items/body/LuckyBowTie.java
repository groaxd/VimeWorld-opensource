package net.xtrafrancyz.mods.minidot.items.body;

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

public class LuckyBowTie extends BaseItem
{
    private final MModelRenderer bowtie;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer right;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer left;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;

    public LuckyBowTie()
    {
        super(ItemType.BODY);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bowtie = new MModelRenderer(this);
        this.bowtie.cubeList.add(new ModelBox(this.bowtie, 12, 0, -1.0F, -12.0F, -2.0F, 2, 2, 2, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-1.0F, -8.25F, -1.25F);
        this.setRotation(this.bone5, 0.0F, 0.0F, 0.1745F);
        this.bowtie.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 12, -1.0F, -2.0F, 0.0F, 2, 8, 0, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(1.0F, -8.25F, -1.15F);
        this.setRotation(this.bone6, 0.0F, 0.0F, -0.1745F);
        this.bowtie.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 10, 6, -1.0F, -2.0F, 0.0F, 2, 8, 0, 0.0F, false));
        this.right = new MModelRenderer(this);
        this.right.setRotationPoint(0.5F, -11.0F, -1.0F);
        this.setRotation(this.right, 0.0F, 0.0F, 0.7418F);
        this.bowtie.addChild(this.right);
        this.right.cubeList.add(new ModelBox(this.right, 12, 4, 2.7543F, -1.8431F, -0.5F, 2, 1, 1, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.setRotation(this.bone, 0.0F, 0.0F, -0.5672F);
        this.right.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 3, 0.0F, -1.0F, -0.6F, 5, 2, 1, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.setRotation(this.bone2, 0.0F, 0.0F, 0.1745F);
        this.right.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 9, 0.5356F, -1.6559F, -0.5F, 4, 2, 1, 0.0F, false));
        this.left = new MModelRenderer(this);
        this.left.setRotationPoint(-0.5F, -11.0F, -1.0F);
        this.setRotation(this.left, 0.0F, 0.0F, -0.7418F);
        this.bowtie.addChild(this.left);
        this.left.cubeList.add(new ModelBox(this.left, 4, 12, -4.7543F, -1.8431F, -0.5F, 2, 1, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.setRotation(this.bone3, 0.0F, 0.0F, 0.5672F);
        this.left.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 0, -5.0F, -1.0F, -0.6F, 5, 2, 1, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.setRotation(this.bone4, 0.0F, 0.0F, -0.1745F);
        this.left.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 6, -4.5356F, -1.6559F, -0.5F, 4, 2, 1, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "body/luckybowtie.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, 0.5D, -0.08D - (player.inventory.armorItemInSlot(2) != null ? 0.1D : 0.0D));
        double d0 = 0.64D;
        GlStateManager.scale(d0, d0, d0);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.8400000000000001D, 0.536D);
        double d0 = 1.3D;
        GlStateManager.scale(d0, d0, d0);
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
        return "\u0411\u0430\u0431\u043e\u0447\u043a\u0430 \u041b\u0430\u043a\u0438";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Dark Deception");
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
