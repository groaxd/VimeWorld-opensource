package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class JackTheGhost extends BasePet
{
    private final MModelRenderer Project;
    private final MModelRenderer Jack;
    private final MModelRenderer cape;
    private final MModelRenderer Body;
    private final MModelRenderer chest1;
    private final MModelRenderer chest2;
    private final MModelRenderer chest3;
    private final MModelRenderer Head;
    private final MModelRenderer eyes_glow1;
    private final MModelRenderer eyes_glow2;
    private final MModelRenderer tail;
    private final MModelRenderer left_leg;
    private final MModelRenderer right_leg;
    private final MModelRenderer right_arm;
    private final MModelRenderer left_arm;
    private final MModelRenderer GHOSTS;
    private final MModelRenderer Ghost;
    private final MModelRenderer Ghost2;
    private final MModelRenderer Ghost3;
    private final MModelRenderer Soul;
    private final IAnimation animation;

    public JackTheGhost()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Project = new MModelRenderer(this);
        this.Jack = new MModelRenderer(this);
        this.Project.addChild(this.Jack);
        this.cape = new MModelRenderer(this);
        this.cape.setRotationPoint(0.0F, -29.0F, 6.0F);
        this.Jack.addChild(this.cape);
        this.cape.cubeList.add(new ModelBox(this.cape, 0, 43, -4.0F, 0.0F, -0.49F, 8, 17, 1, 0.0F, false));
        this.Body = new MModelRenderer(this);
        this.Body.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.Jack.addChild(this.Body);
        this.Body.cubeList.add(new ModelBox(this.Body, 54, 56, -1.0F, -26.01F, 1.01F, 2, 14, 2, 0.0F, false));
        this.Body.cubeList.add(new ModelBox(this.Body, 56, 46, -4.0F, -14.01F, 1.0F, 8, 2, 2, 0.0F, false));
        this.Body.cubeList.add(new ModelBox(this.Body, 0, 20, -5.0F, -26.01F, -1.5F, 10, 16, 7, 0.0F, false));
        this.chest1 = new MModelRenderer(this);
        this.chest1.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.Body.addChild(this.chest1);
        this.chest1.cubeList.add(new ModelBox(this.chest1, 56, 42, -4.0F, -14.01F, -1.0F, 8, 2, 2, 0.0F, false));
        this.chest1.cubeList.add(new ModelBox(this.chest1, 42, 16, -4.0F, -14.01F, -3.0F, 1, 2, 2, 0.0F, false));
        this.chest1.cubeList.add(new ModelBox(this.chest1, 42, 12, 3.0F, -14.01F, -3.0F, 1, 2, 2, 0.0F, false));
        this.chest2 = new MModelRenderer(this);
        this.chest2.setRotationPoint(0.0F, 3.0F, 2.0F);
        this.Body.addChild(this.chest2);
        this.chest2.cubeList.add(new ModelBox(this.chest2, 34, 56, -4.0F, -17.01F, -1.0F, 8, 2, 2, 0.0F, false));
        this.chest2.cubeList.add(new ModelBox(this.chest2, 40, 0, 3.0F, -17.01F, -3.0F, 1, 2, 2, 0.0F, false));
        this.chest2.cubeList.add(new ModelBox(this.chest2, 27, 20, -4.0F, -17.01F, -3.0F, 1, 2, 2, 0.0F, false));
        this.chest3 = new MModelRenderer(this);
        this.chest3.setRotationPoint(0.0F, 6.0F, 2.0F);
        this.Body.addChild(this.chest3);
        this.chest3.cubeList.add(new ModelBox(this.chest3, 52, 32, -4.0F, -20.01F, -1.0F, 8, 2, 2, 0.0F, false));
        this.chest3.cubeList.add(new ModelBox(this.chest3, 31, 22, -4.0F, -20.01F, -3.0F, 1, 2, 2, 0.0F, false));
        this.chest3.cubeList.add(new ModelBox(this.chest3, 34, 32, 3.0F, -20.01F, -3.0F, 1, 2, 2, 0.0F, false));
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(0.0F, -34.0F, 2.0F);
        this.Jack.addChild(this.Head);
        this.Head.cubeList.add(new ModelBox(this.Head, 0, 0, -5.0F, -5.01F, -5.0F, 11, 10, 10, 0.0F, false));
        this.eyes_glow1 = new MModelRenderer(this);
        this.eyes_glow1.setRotationPoint(3.5F, 28.5F, -3.0F);
        this.Head.addChild(this.eyes_glow1);
        this.eyes_glow1.cubeList.add(new ModelBox(this.eyes_glow1, 31, 20, -9.0F, -29.0F, -2.2F, 3, 1, 0, 0.0F, false));
        this.eyes_glow1.cubeList.add(new ModelBox(this.eyes_glow1, 27, 26, -10.0F, -30.0F, -2.2F, 3, 1, 0, 0.0F, false));
        this.eyes_glow1.cubeList.add(new ModelBox(this.eyes_glow1, 6, 1, -10.0F, -31.0F, -2.2F, 2, 1, 0, 0.0F, false));
        this.eyes_glow1.cubeList.add(new ModelBox(this.eyes_glow1, 0, 1, -9.0F, -32.0F, -2.2F, 1, 1, 0, 0.0F, false));
        this.eyes_glow2 = new MModelRenderer(this);
        this.eyes_glow2.setRotationPoint(4.5F, 28.5F, -3.0F);
        this.Head.addChild(this.eyes_glow2);
        this.eyes_glow2.cubeList.add(new ModelBox(this.eyes_glow2, 0, 26, -1.0F, -29.0F, -2.2F, 3, 1, 0, 0.0F, false));
        this.eyes_glow2.cubeList.add(new ModelBox(this.eyes_glow2, 0, 9, 0.0F, -30.0F, -2.2F, 3, 1, 0, 0.0F, false));
        this.eyes_glow2.cubeList.add(new ModelBox(this.eyes_glow2, 6, 0, 1.0F, -31.0F, -2.2F, 2, 1, 0, 0.0F, false));
        this.eyes_glow2.cubeList.add(new ModelBox(this.eyes_glow2, 0, 0, 1.0F, -32.0F, -2.2F, 1, 1, 0, 0.0F, false));
        this.tail = new MModelRenderer(this);
        this.tail.setRotationPoint(0.0F, 31.0F, 0.0F);
        this.Head.addChild(this.tail);
        this.tail.cubeList.add(new ModelBox(this.tail, 0, 20, -1.0F, -40.0F, -1.0F, 2, 5, 1, 0.0F, false));
        this.tail.cubeList.add(new ModelBox(this.tail, 0, 7, 1.0F, -40.0F, -1.0F, 2, 1, 1, 0.0F, false));
        this.left_leg = new MModelRenderer(this);
        this.left_leg.setRotationPoint(-3.0F, -12.7F, 2.0F);
        this.Jack.addChild(this.left_leg);
        this.left_leg.cubeList.add(new ModelBox(this.left_leg, 18, 55, -2.0F, -0.29F, -2.0F, 4, 7, 4, 0.0F, false));
        this.left_leg.cubeList.add(new ModelBox(this.left_leg, 42, 60, -1.0F, -0.3F, -1.0F, 2, 10, 2, 0.0F, false));
        this.right_leg = new MModelRenderer(this);
        this.right_leg.setRotationPoint(3.0F, -13.0F, 2.0F);
        this.Jack.addChild(this.right_leg);
        this.right_leg.cubeList.add(new ModelBox(this.right_leg, 34, 60, -1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F, false));
        this.right_leg.cubeList.add(new ModelBox(this.right_leg, 52, 12, -2.0F, 0.01F, -2.0F, 4, 7, 4, 0.0F, false));
        this.right_arm = new MModelRenderer(this);
        this.right_arm.setRotationPoint(-5.0F, -28.0F, 0.0F);
        this.Jack.addChild(this.right_arm);
        this.right_arm.cubeList.add(new ModelBox(this.right_arm, 34, 60, -4.0F, -0.01F, -0.5F, 2, 10, 2, 0.0F, false));
        this.right_arm.cubeList.add(new ModelBox(this.right_arm, 18, 43, -5.01F, -1.0F, -2.5F, 5, 6, 6, 0.0F, false));
        this.left_arm = new MModelRenderer(this);
        this.left_arm.setRotationPoint(6.0F, -28.0F, 0.0F);
        this.Jack.addChild(this.left_arm);
        this.left_arm.cubeList.add(new ModelBox(this.left_arm, 40, 44, -0.99F, -1.0F, -2.5F, 5, 6, 6, 0.0F, false));
        this.left_arm.cubeList.add(new ModelBox(this.left_arm, 34, 60, 1.0F, -0.01F, -0.5F, 2, 10, 2, 0.0F, false));
        this.GHOSTS = new MModelRenderer(this);
        this.Project.addChild(this.GHOSTS);
        this.Ghost = new MModelRenderer(this);
        this.Ghost.setRotationPoint(16.0F, -33.0F, 6.0F);
        this.GHOSTS.addChild(this.Ghost);
        this.Ghost.cubeList.add(new ModelBox(this.Ghost, 42, 0, -3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F, false));
        this.Ghost2 = new MModelRenderer(this);
        this.Ghost2.setRotationPoint(-11.0F, -42.0F, 12.0F);
        this.GHOSTS.addChild(this.Ghost2);
        this.Ghost2.cubeList.add(new ModelBox(this.Ghost2, 34, 32, -3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F, false));
        this.Ghost3 = new MModelRenderer(this);
        this.Ghost3.setRotationPoint(-15.0F, -12.0F, 3.0F);
        this.GHOSTS.addChild(this.Ghost3);
        this.Ghost3.cubeList.add(new ModelBox(this.Ghost3, 34, 20, -3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F, false));
        this.Soul = new MModelRenderer(this);
        this.Soul.setRotationPoint(15.6F, -32.7F, 7.0F);
        this.Soul.cubeList.add(new ModelBox(this.Soul, 62, 69, -1.6F, -3.3F, -1.0F, 3, 1, 2, 0.0F, false));
        this.Soul.cubeList.add(new ModelBox(this.Soul, 62, 66, -1.6F, -0.3F, -1.0F, 3, 1, 2, 0.0F, false));
        this.Soul.cubeList.add(new ModelBox(this.Soul, 62, 63, -0.6F, 0.7F, -1.0F, 2, 1, 2, 0.0F, false));
        this.Soul.cubeList.add(new ModelBox(this.Soul, 62, 58, -0.6F, 1.7F, -1.0F, 1, 2, 2, 0.0F, false));
        this.Soul.cubeList.add(new ModelBox(this.Soul, 68, 58, -2.6F, -2.3F, -1.0F, 5, 2, 2, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/jacktheghost.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/jacktheghost_animation.json"));
        this.animation = bbanimationloader.mustGet("jack.flying", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        double d0 = (double)MathHelper.sin(time * 0.1F) * 0.03D;
        GlStateManager.translate(1.2D, 0.2D + d0, 0.3D);
        double d1 = 0.5D;
        GlStateManager.scale(d1, d1, d1);
        this.animation.tick(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.55D, 0.0D);
        double d0 = 0.5D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u0440\u0438\u0437\u0440\u0430\u043a \u0414\u0436\u0435\u043a";
    }

    public String getCreator()
    {
        return "Sir_Kelt";
    }
}
