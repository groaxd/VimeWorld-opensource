package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class Iceologer extends BasePet
{
    private final MModelRenderer Project;
    private final MModelRenderer icologer;
    private final MModelRenderer cape;
    private final MModelRenderer head;
    private final MModelRenderer nose;
    private final MModelRenderer eye2;
    private final MModelRenderer eye1;
    private final MModelRenderer b2;
    private final MModelRenderer b1;
    private final MModelRenderer up_head;
    private final MModelRenderer Body;
    private final MModelRenderer up_body;
    private final MModelRenderer left_leg;
    private final MModelRenderer right_leg;
    private final MModelRenderer allhands;
    private final MModelRenderer left_hand;
    private final MModelRenderer a1;
    private final MModelRenderer right_hand;
    private final MModelRenderer a2;
    private final MModelRenderer Blocks2;
    private final MModelRenderer particle3;
    private final MModelRenderer particle2;
    private final MModelRenderer particle1;
    private final MModelRenderer all_start;
    private final MModelRenderer start_1;
    private final MModelRenderer start_2;
    private final MModelRenderer start_3;
    private final MModelRenderer start;
    private final MModelRenderer blocks;
    private final IAnimation animation;

    public Iceologer()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Project = new MModelRenderer(this);
        this.Project.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.icologer = new MModelRenderer(this);
        this.Project.addChild(this.icologer);
        this.cape = new MModelRenderer(this);
        this.cape.setRotationPoint(-1.0F, -19.5F, 5.0F);
        this.icologer.addChild(this.cape);
        this.cape.cubeList.add(new ModelBox(this.cape, 54, 104, -5.0F, -1.5F, -0.5F, 10, 17, 1, 0.0F, false));
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(-1.0F, -26.0F, 1.0F);
        this.icologer.addChild(this.head);
        this.head.cubeList.add(new ModelBox(this.head, 64, 72, -4.0F, -5.0F, -4.0F, 8, 10, 8, 0.0F, false));
        this.nose = new MModelRenderer(this);
        this.nose.setRotationPoint(0.0F, 3.0F, -5.0F);
        this.head.addChild(this.nose);
        this.nose.cubeList.add(new ModelBox(this.nose, 88, 72, -1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F, false));
        this.eye2 = new MModelRenderer(this);
        this.eye2.setRotationPoint(2.0F, 1.4F, -3.8F);
        this.head.addChild(this.eye2);
        this.eye2.cubeList.add(new ModelBox(this.eye2, 6, 112, -0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F, false));
        this.eye1 = new MModelRenderer(this);
        this.eye1.setRotationPoint(-2.0F, 1.4F, -3.8F);
        this.head.addChild(this.eye1);
        this.eye1.cubeList.add(new ModelBox(this.eye1, 6, 112, -0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F, false));
        this.b2 = new MModelRenderer(this);
        this.b2.setRotationPoint(2.3F, 0.1F, -4.2F);
        this.setRotation(this.b2, 0.0F, 0.0F, -0.2182F);
        this.head.addChild(this.b2);
        this.b2.cubeList.add(new ModelBox(this.b2, 10, 88, -0.7299F, -1.4659F, 0.0F, 2, 1, 1, 0.0F, false));
        this.b2.cubeList.add(new ModelBox(this.b2, 10, 90, -1.7299F, -0.4659F, 0.0F, 3, 1, 1, 0.0F, false));
        this.b1 = new MModelRenderer(this);
        this.b1.setRotationPoint(-2.25F, -0.4F, -3.8F);
        this.setRotation(this.b1, 0.0F, 0.0F, 0.2182F);
        this.head.addChild(this.b1);
        this.b1.cubeList.add(new ModelBox(this.b1, 10, 92, -1.25F, -1.0F, -0.5F, 2, 1, 1, 0.0F, false));
        this.b1.cubeList.add(new ModelBox(this.b1, 10, 94, -1.25F, 0.0F, -0.5F, 3, 1, 1, 0.0F, false));
        this.up_head = new MModelRenderer(this);
        this.head.addChild(this.up_head);
        this.up_head.cubeList.add(new ModelBox(this.up_head, 96, 20, -5.0F, -6.0F, -5.0F, 10, 11, 0, 0.0F, false));
        this.up_head.cubeList.add(new ModelBox(this.up_head, 20, 78, 5.0F, -6.0F, -5.0F, 0, 11, 10, 0.0F, false));
        this.up_head.cubeList.add(new ModelBox(this.up_head, 38, 0, -5.0F, -6.0F, -5.0F, 10, 0, 10, 0.0F, false));
        this.up_head.cubeList.add(new ModelBox(this.up_head, 87, 91, -5.0F, -6.0F, -5.0F, 0, 11, 10, 0.003F, false));
        this.up_head.cubeList.add(new ModelBox(this.up_head, 0, 99, -5.0F, -6.0F, 5.0F, 10, 11, 0, 0.0F, false));
        this.Body = new MModelRenderer(this);
        this.Body.setRotationPoint(-1.0F, -15.0F, 1.0F);
        this.icologer.addChild(this.Body);
        this.Body.cubeList.add(new ModelBox(this.Body, 54, 124, -5.0F, -7.0F, 5.09F, 10, 3, 1, 0.0F, false));
        this.Body.cubeList.add(new ModelBox(this.Body, 82, 112, -7.01F, -7.0F, -2.9F, 2, 3, 9, 0.0F, false));
        this.Body.cubeList.add(new ModelBox(this.Body, 18, 115, 5.01F, -7.0F, -2.9F, 2, 3, 9, 0.0F, false));
        this.Body.cubeList.add(new ModelBox(this.Body, 68, 0, -4.0F, -6.0F, -2.0F, 8, 12, 4, 0.0F, false));
        this.up_body = new MModelRenderer(this);
        this.up_body.setRotationPoint(1.0F, 15.0F, -1.0F);
        this.Body.addChild(this.up_body);
        this.up_body.cubeList.add(new ModelBox(this.up_body, 40, 88, -6.0F, -21.0F, 4.0F, 10, 14, 0, 0.0F, false));
        this.up_body.cubeList.add(new ModelBox(this.up_body, 42, 10, -6.0F, -21.0F, -2.0F, 10, 0, 6, 0.0F, false));
        this.up_body.cubeList.add(new ModelBox(this.up_body, 0, 58, 4.0F, -21.0F, -2.0F, 0, 14, 6, 0.0F, false));
        this.up_body.cubeList.add(new ModelBox(this.up_body, 0, 26, -6.0F, -21.0F, -2.0F, 0, 14, 6, 0.0F, false));
        this.up_body.cubeList.add(new ModelBox(this.up_body, 60, 90, -6.0F, -21.0F, -2.0F, 10, 14, 0, 0.0F, false));
        this.left_leg = new MModelRenderer(this);
        this.left_leg.setRotationPoint(1.0F, -9.0F, 1.0F);
        this.icologer.addChild(this.left_leg);
        this.left_leg.cubeList.add(new ModelBox(this.left_leg, 96, 48, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
        this.right_leg = new MModelRenderer(this);
        this.right_leg.setRotationPoint(-3.0F, -9.0F, 1.0F);
        this.icologer.addChild(this.right_leg);
        this.right_leg.cubeList.add(new ModelBox(this.right_leg, 0, 0, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
        this.allhands = new MModelRenderer(this);
        this.allhands.setRotationPoint(-2.0F, -18.75F, 1.0F);
        this.icologer.addChild(this.allhands);
        this.left_hand = new MModelRenderer(this);
        this.left_hand.setRotationPoint(5.0F, 0.0F, 0.0F);
        this.setRotation(this.left_hand, 0.0F, 0.0F, -0.2618F);
        this.allhands.addChild(this.left_hand);
        this.left_hand.cubeList.add(new ModelBox(this.left_hand, 100, 72, 0.0F, -1.25F, -2.0F, 4, 12, 4, 0.0F, false));
        this.a1 = new MModelRenderer(this);
        this.a1.setRotationPoint(2.0F, 6.25F, 0.0F);
        this.left_hand.addChild(this.a1);
        this.a1.cubeList.add(new ModelBox(this.a1, 80, 92, -3.0F, -0.5F, -3.0F, 6, 3, 6, 0.0F, false));
        this.right_hand = new MModelRenderer(this);
        this.right_hand.setRotationPoint(-3.0F, 0.25F, 0.0F);
        this.setRotation(this.right_hand, 0.0F, 0.0F, 0.2618F);
        this.allhands.addChild(this.right_hand);
        this.right_hand.cubeList.add(new ModelBox(this.right_hand, 20, 99, -4.0F, -1.5F, -2.0F, 4, 12, 4, 0.0F, false));
        this.a2 = new MModelRenderer(this);
        this.a2.setRotationPoint(-2.0F, 6.0F, 0.0F);
        this.right_hand.addChild(this.a2);
        this.a2.cubeList.add(new ModelBox(this.a2, 96, 11, -3.0F, -0.5F, -3.0F, 6, 3, 6, 0.0F, false));
        this.Blocks2 = new MModelRenderer(this);
        this.Blocks2.setRotationPoint(-0.4F, -49.8F, 6.6F);
        this.Project.addChild(this.Blocks2);
        this.particle3 = new MModelRenderer(this);
        this.particle3.setRotationPoint(27.0F, 3.0F, 4.0F);
        this.Blocks2.addChild(this.particle3);
        this.particle3.cubeList.add(new ModelBox(this.particle3, 96, 105, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
        this.particle2 = new MModelRenderer(this);
        this.particle2.setRotationPoint(27.0F, -5.0F, 4.0F);
        this.Blocks2.addChild(this.particle2);
        this.particle2.cubeList.add(new ModelBox(this.particle2, 96, 105, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
        this.particle1 = new MModelRenderer(this);
        this.particle1.setRotationPoint(35.0F, 3.0F, 4.0F);
        this.Blocks2.addChild(this.particle1);
        this.particle1.cubeList.add(new ModelBox(this.particle1, 96, 105, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
        this.all_start = new MModelRenderer(this);
        this.all_start.setRotationPoint(-0.6F, 21.8F, -31.6F);
        this.Blocks2.addChild(this.all_start);
        this.start_1 = new MModelRenderer(this);
        this.start_1.setRotationPoint(35.6F, -2.8F, 35.6F);
        this.all_start.addChild(this.start_1);
        this.start_1.cubeList.add(new ModelBox(this.start_1, 96, 105, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
        this.start_2 = new MModelRenderer(this);
        this.start_2.setRotationPoint(27.6F, -10.8F, 35.6F);
        this.all_start.addChild(this.start_2);
        this.start_2.cubeList.add(new ModelBox(this.start_2, 96, 105, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
        this.start_3 = new MModelRenderer(this);
        this.start_3.setRotationPoint(35.6F, -10.8F, 35.6F);
        this.all_start.addChild(this.start_3);
        this.start_3.cubeList.add(new ModelBox(this.start_3, 96, 105, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
        this.start = new MModelRenderer(this);
        this.start.setRotationPoint(-0.4F, 24.2F, 10.6F);
        this.all_start.addChild(this.start);
        this.start.cubeList.add(new ModelBox(this.start, 96, 105, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));
        this.blocks = new MModelRenderer(this);
        this.blocks.setRotationPoint(-0.4F, -49.8F, 6.6F);
        this.Project.addChild(this.blocks);
        this.blocks.cubeList.add(new ModelBox(this.blocks, 0, 64, -17.6F, -3.2F, -17.6F, 16, 8, 16, 0.0F, false));
        this.blocks.cubeList.add(new ModelBox(this.blocks, 48, 48, -1.6F, 4.8F, -1.6F, 16, 8, 16, 0.0F, false));
        this.blocks.cubeList.add(new ModelBox(this.blocks, 48, 16, -1.6F, -11.2F, -17.6F, 16, 16, 16, 0.0F, false));
        this.blocks.cubeList.add(new ModelBox(this.blocks, 0, 32, -1.6F, -11.2F, -1.6F, 16, 16, 16, 0.0F, false));
        this.blocks.cubeList.add(new ModelBox(this.blocks, 0, 0, -17.6F, -11.2F, -1.6F, 16, 16, 16, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/iceologer.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/iceologer_animation.json"));
        this.animation = bbanimationloader.mustGet("iceologer.animation", this);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        GlStateManager.translate(1.25D, 0.16D, 0.4D);
        double d0 = 0.4929D;
        GlStateManager.scale(d0, d0, d0);
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        double d0 = 0.3873D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, 1.514D, 0.0D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041b\u0435\u0434\u043e\u043b\u043e\u0433";
    }

    public String getCreator()
    {
        return "Sir_Kelt";
    }
}
