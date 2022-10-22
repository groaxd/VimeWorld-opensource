package net.xtrafrancyz.mods.minidot.items.head;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class AntmanHelm extends BaseHelm
{
    private final MModelRenderer Antman_helm;
    private final MModelRenderer upper_helm;
    private final MModelRenderer antenas;
    private final MModelRenderer left_antena;
    private final MModelRenderer left;
    private final MModelRenderer left2;
    private final MModelRenderer left3;
    private final MModelRenderer left4;
    private final MModelRenderer left5;
    private final MModelRenderer right_antena;
    private final MModelRenderer right6;
    private final MModelRenderer right7;
    private final MModelRenderer right8;
    private final MModelRenderer right9;
    private final MModelRenderer right10;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;

    public AntmanHelm()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Antman_helm = new MModelRenderer(this);
        this.Antman_helm.cubeList.add(new ModelBox(this.Antman_helm, 0, 0, -4.5F, -1.0F, -4.5F, 9, 1, 9, 0.0F, false));
        this.Antman_helm.cubeList.add(new ModelBox(this.Antman_helm, 26, 10, -4.5F, -1.9F, 3.9F, 9, 1, 1, 0.0F, false));
        this.Antman_helm.cubeList.add(new ModelBox(this.Antman_helm, 8, 27, -4.9F, -1.9F, -0.5F, 1, 1, 5, 0.0F, false));
        this.Antman_helm.cubeList.add(new ModelBox(this.Antman_helm, 27, 0, 3.9F, -1.9F, -0.5F, 1, 1, 5, 0.0F, false));
        this.Antman_helm.cubeList.add(new ModelBox(this.Antman_helm, 26, 15, -2.5F, -1.75F, -5.0F, 5, 1, 1, 0.0F, false));
        this.Antman_helm.cubeList.add(new ModelBox(this.Antman_helm, 27, 32, -1.0F, -2.25F, -5.75F, 2, 2, 2, 0.0F, false));
        this.Antman_helm.cubeList.add(new ModelBox(this.Antman_helm, 27, 6, -2.0F, -2.5F, -4.75F, 4, 1, 1, 0.0F, false));
        this.upper_helm = new MModelRenderer(this);
        this.upper_helm.setRotationPoint(0.0F, -1.0F, 4.25F);
        this.Antman_helm.addChild(this.upper_helm);
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 19, 32, -1.5F, -3.0F, -8.7F, 3, 3, 1, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 5, 0, -0.5F, -4.0F, -8.5F, 1, 1, 1, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 8, 27, 3.25F, -3.1F, -7.5F, 1, 4, 1, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 27, 0, -4.25F, -3.1F, -7.5F, 1, 4, 1, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 19, 38, 3.25F, -7.0F, -7.5F, 1, 3, 1, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 15, 27, -4.25F, -7.0F, -7.5F, 1, 3, 1, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 0, 27, -4.75F, -5.0F, -8.0F, 1, 3, 2, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 20, 19, 3.75F, -5.0F, -8.0F, 1, 3, 2, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 26, 12, -4.0F, -5.0F, -7.4F, 8, 3, 0, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 0, 27, 4.0F, -7.0F, -6.5F, 1, 7, 6, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 20, 19, -5.0F, -7.0F, -6.5F, 1, 7, 6, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 0, 19, -4.5F, -7.0F, -0.75F, 9, 7, 1, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 0, 10, -4.5F, -7.75F, -8.0F, 9, 1, 8, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 28, 19, -1.5F, -7.0F, -8.8F, 3, 3, 1, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 34, 25, 1.5F, -7.5F, -8.5F, 2, 3, 1, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 34, 0, -3.5F, -7.5F, -8.5F, 2, 3, 1, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 36, 7, -3.5F, -2.5F, -8.5F, 2, 2, 1, 0.0F, false));
        this.upper_helm.cubeList.add(new ModelBox(this.upper_helm, 35, 17, 1.5F, -2.5F, -8.5F, 2, 2, 1, 0.0F, false));
        this.antenas = new MModelRenderer(this);
        this.antenas.setRotationPoint(-4.0F, -0.75F, -7.75F);
        this.upper_helm.addChild(this.antenas);
        this.left_antena = new MModelRenderer(this);
        this.antenas.addChild(this.left_antena);
        this.left_antena.cubeList.add(new ModelBox(this.left_antena, 0, 10, -1.75F, -4.0F, 1.5F, 1, 3, 3, 0.0F, false));
        this.left = new MModelRenderer(this);
        this.setRotation(this.left, -0.0273F, 0.7412F, -0.0571F);
        this.left_antena.addChild(this.left);
        this.left.cubeList.add(new ModelBox(this.left, 38, 5, -2.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F, false));
        this.left2 = new MModelRenderer(this);
        this.left2.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.setRotation(this.left2, 0.1553F, 0.456F, 0.3415F);
        this.left.addChild(this.left2);
        this.left2.cubeList.add(new ModelBox(this.left2, 26, 36, -1.6295F, -0.5926F, -0.4435F, 2, 1, 1, 0.0F, false));
        this.left3 = new MModelRenderer(this);
        this.left3.setRotationPoint(-1.25F, 0.5F, 0.0F);
        this.setRotation(this.left3, 0.2763F, 0.4661F, 0.5457F);
        this.left2.addChild(this.left3);
        this.left3.cubeList.add(new ModelBox(this.left3, 33, 31, -3.2147F, -1.5051F, -0.684F, 3, 2, 1, 0.0F, false));
        this.left4 = new MModelRenderer(this);
        this.left4.setRotationPoint(-3.0F, -1.75F, 1.5F);
        this.setRotation(this.left4, 0.3428F, -0.2024F, 0.6467F);
        this.left2.addChild(this.left4);
        this.left4.cubeList.add(new ModelBox(this.left4, 36, 20, -2.2147F, -0.5051F, -0.684F, 2, 1, 1, 0.0F, false));
        this.left5 = new MModelRenderer(this);
        this.setRotation(this.left5, -0.1117F, 0.4157F, 0.3262F);
        this.left4.addChild(this.left5);
        this.left5.cubeList.add(new ModelBox(this.left5, 28, 23, -4.4979F, 0.3281F, -1.2689F, 3, 1, 1, 0.0F, false));
        this.right_antena = new MModelRenderer(this);
        this.right_antena.setRotationPoint(8.0F, 0.0F, 0.0F);
        this.antenas.addChild(this.right_antena);
        this.right_antena.cubeList.add(new ModelBox(this.right_antena, 0, 0, 0.75F, -4.0F, 1.5F, 1, 3, 3, 0.0F, false));
        this.right6 = new MModelRenderer(this);
        this.setRotation(this.right6, -0.0273F, -0.7412F, 0.0571F);
        this.right_antena.addChild(this.right6);
        this.right6.cubeList.add(new ModelBox(this.right6, 20, 36, 0.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F, false));
        this.right7 = new MModelRenderer(this);
        this.right7.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.setRotation(this.right7, 0.1553F, -0.456F, -0.3415F);
        this.right6.addChild(this.right7);
        this.right7.cubeList.add(new ModelBox(this.right7, 35, 22, -0.3705F, -0.5926F, -0.4435F, 2, 1, 1, 0.0F, false));
        this.right8 = new MModelRenderer(this);
        this.right8.setRotationPoint(1.25F, 0.5F, 0.0F);
        this.setRotation(this.right8, 0.2763F, -0.4661F, -0.5457F);
        this.right7.addChild(this.right8);
        this.right8.cubeList.add(new ModelBox(this.right8, 0, 6, 0.2147F, -1.5051F, -0.684F, 3, 2, 1, 0.0F, false));
        this.right9 = new MModelRenderer(this);
        this.right9.setRotationPoint(3.0F, -1.75F, 1.5F);
        this.setRotation(this.right9, 0.3428F, 0.2024F, -0.6467F);
        this.right7.addChild(this.right9);
        this.right9.cubeList.add(new ModelBox(this.right9, 34, 29, 0.2147F, -0.5051F, -0.684F, 2, 1, 1, 0.0F, false));
        this.right10 = new MModelRenderer(this);
        this.setRotation(this.right10, -0.1117F, -0.4157F, -0.3262F);
        this.right9.addChild(this.right10);
        this.right10.cubeList.add(new ModelBox(this.right10, 0, 16, 1.4979F, 0.3281F, -1.2689F, 3, 1, 1, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-3.55F, 0.0F, -7.8F);
        this.setRotation(this.bone2, 0.0F, 0.829F, 0.0F);
        this.upper_helm.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 14, 35, -1.0F, -2.25F, -0.5F, 2, 3, 1, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(3.55F, 0.0F, -7.8F);
        this.setRotation(this.bone, 0.0F, -0.829F, 0.0F);
        this.upper_helm.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 34, 35, -1.0F, -2.25F, -0.5F, 2, 3, 1, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/antmanhelm.png"));
    }

    public void renderAsItem(float time)
    {
        super.renderAsItem(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, 0.04D, -0.04D);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public String getName()
    {
        return "\u0428\u043b\u0435\u043c \u0427\u0435\u043b\u043e\u0432\u0435\u043a\u0430-\u041c\u0443\u0440\u0430\u0432\u044c\u044f";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.RED + "" + EnumChatFormatting.BOLD + "MARVEL");
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
