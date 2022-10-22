package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
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
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class CalamitasPet extends BasePet
{
    private final MModelRenderer Calamitas;
    private final MModelRenderer skull;
    private final MModelRenderer jaw;
    private final MModelRenderer hands;
    private final MModelRenderer left;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone15;
    private final MModelRenderer bone14;
    private final MModelRenderer bone16;
    private final MModelRenderer bone17;
    private final MModelRenderer rightHand;
    private final MModelRenderer bone18;
    private final MModelRenderer bone19;
    private final MModelRenderer bone20;
    private final MModelRenderer bone21;
    private final MModelRenderer bone22;
    private final MModelRenderer bone23;
    private final MModelRenderer calamitas_herself;
    private final MModelRenderer bone5;
    private final MModelRenderer hands2;
    private final MModelRenderer left3;
    private final MModelRenderer bone8;
    private final MModelRenderer rightHandcalamitas;
    private final MModelRenderer bone9;
    private final MModelRenderer head2;
    private final MModelRenderer bone7;
    private final MModelRenderer bone6;
    private final MModelRenderer head;
    private final MModelRenderer horns;
    private final MModelRenderer left2;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer righthorn;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer metal_thing;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final IAnimation animation;

    public CalamitasPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Calamitas = new MModelRenderer(this);
        this.skull = new MModelRenderer(this);
        this.Calamitas.addChild(this.skull);
        this.skull.cubeList.add(new ModelBox(this.skull, 14, 22, 2.4F, -8.0F, -1.0F, 0, 7, 5, 0.0F, false));
        this.skull.cubeList.add(new ModelBox(this.skull, 24, 22, -2.4F, -8.0F, -1.0F, 0, 7, 5, 0.0F, false));
        this.jaw = new MModelRenderer(this);
        this.jaw.setRotationPoint(0.0F, -1.0F, 4.0F);
        this.skull.addChild(this.jaw);
        this.jaw.cubeList.add(new ModelBox(this.jaw, 0, 34, -1.5F, 1.0F, -7.5F, 3, 1, 4, 0.0F, false));
        this.jaw.cubeList.add(new ModelBox(this.jaw, 0, 0, -2.5F, 0.0F, -8.0F, 5, 1, 8, 0.0F, false));
        this.jaw.cubeList.add(new ModelBox(this.jaw, 34, 29, -3.0F, -1.75F, -0.5F, 6, 2, 1, 0.0F, false));
        this.jaw.cubeList.add(new ModelBox(this.jaw, 36, 6, -2.5F, -1.0F, -8.0F, 5, 1, 2, 0.0F, false));
        this.hands = new MModelRenderer(this);
        this.skull.addChild(this.hands);
        this.left = new MModelRenderer(this);
        this.left.setRotationPoint(4.0F, -5.5F, 0.5F);
        this.setRotation(this.left, 0.0152F, 0.0879F, -0.3028F);
        this.hands.addChild(this.left);
        this.left.cubeList.add(new ModelBox(this.left, 43, 19, 0.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F, false));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(4.0F, 0.25F, -0.25F);
        this.setRotation(this.bone12, 0.4911F, 0.8491F, 0.687F);
        this.left.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 34, 15, -1.0F, -1.0F, -1.0F, 5, 2, 2, 0.0F, false));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(5.75F, 1.75F, -3.25F);
        this.setRotation(this.bone13, 0.2727F, -0.1393F, 0.4608F);
        this.left.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 20, 45, -1.25F, -1.75F, -1.0F, 3, 3, 1, 0.0F, false));
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(-4.75F, -1.5F, 3.25F);
        this.setRotation(this.bone15, 0.0F, 0.1745F, 0.0F);
        this.bone13.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 44, 44, 3.5F, 1.0F, -6.25F, 1, 1, 3, 0.0F, false));
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-5.0F, 0.25F, 2.75F);
        this.setRotation(this.bone14, -0.3957F, 0.1209F, -0.0503F);
        this.bone13.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 36, 44, 4.0F, -1.0F, -6.25F, 1, 1, 3, 0.0F, false));
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(5.5F, 0.25F, 2.75F);
        this.setRotation(this.bone16, -0.3957F, -0.1209F, 0.0503F);
        this.bone13.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 0, 44, -5.0F, -1.0F, -6.25F, 1, 1, 3, 0.0F, false));
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(5.75F, 0.1F, 2.15F);
        this.setRotation(this.bone17, -0.4152F, 0.0F, 0.0F);
        this.bone13.addChild(this.bone17);
        this.bone17.cubeList.add(new ModelBox(this.bone17, 12, 43, -6.0F, -1.0F, -6.25F, 1, 1, 3, 0.0F, false));
        this.rightHand = new MModelRenderer(this);
        this.rightHand.setRotationPoint(-4.0F, -5.5F, 0.5F);
        this.setRotation(this.rightHand, 0.0152F, -0.0879F, 0.3028F);
        this.hands.addChild(this.rightHand);
        this.rightHand.cubeList.add(new ModelBox(this.rightHand, 23, 4, -4.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F, false));
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(-4.0F, 0.25F, -0.25F);
        this.setRotation(this.bone18, 0.4911F, -0.8491F, -0.687F);
        this.rightHand.addChild(this.bone18);
        this.bone18.cubeList.add(new ModelBox(this.bone18, 10, 34, -4.0F, -1.0F, -1.0F, 5, 2, 2, 0.0F, false));
        this.bone19 = new MModelRenderer(this);
        this.bone19.setRotationPoint(-5.75F, 1.75F, -3.25F);
        this.setRotation(this.bone19, 0.2727F, 0.1393F, -0.4608F);
        this.rightHand.addChild(this.bone19);
        this.bone19.cubeList.add(new ModelBox(this.bone19, 42, 0, -1.75F, -1.75F, -1.0F, 3, 3, 1, 0.0F, false));
        this.bone20 = new MModelRenderer(this);
        this.bone20.setRotationPoint(4.75F, -1.5F, 3.25F);
        this.setRotation(this.bone20, 0.0F, -0.1745F, 0.0F);
        this.bone19.addChild(this.bone20);
        this.bone20.cubeList.add(new ModelBox(this.bone20, 7, 41, -4.5F, 1.0F, -6.25F, 1, 1, 3, 0.0F, false));
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(5.0F, 0.25F, 2.75F);
        this.setRotation(this.bone21, -0.3957F, -0.1209F, 0.0503F);
        this.bone19.addChild(this.bone21);
        this.bone21.cubeList.add(new ModelBox(this.bone21, 18, 4, -5.0F, -1.0F, -6.25F, 1, 1, 3, 0.0F, false));
        this.bone22 = new MModelRenderer(this);
        this.bone22.setRotationPoint(-5.5F, 0.25F, 2.75F);
        this.setRotation(this.bone22, -0.3957F, 0.1209F, -0.0503F);
        this.bone19.addChild(this.bone22);
        this.bone22.cubeList.add(new ModelBox(this.bone22, 0, 4, 4.0F, -1.0F, -6.25F, 1, 1, 3, 0.0F, false));
        this.bone23 = new MModelRenderer(this);
        this.bone23.setRotationPoint(-5.75F, 0.1F, 2.15F);
        this.setRotation(this.bone23, -0.4152F, 0.0F, 0.0F);
        this.bone19.addChild(this.bone23);
        this.bone23.cubeList.add(new ModelBox(this.bone23, 0, 0, 5.0F, -1.0F, -6.25F, 1, 1, 3, 0.0F, false));
        this.calamitas_herself = new MModelRenderer(this);
        this.calamitas_herself.setRotationPoint(0.0F, 0.25F, 0.0F);
        this.skull.addChild(this.calamitas_herself);
        this.calamitas_herself.cubeList.add(new ModelBox(this.calamitas_herself, 12, 38, -1.5F, -4.0F, -2.0F, 3, 3, 2, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, 1.0F, -2.5F);
        this.setRotation(this.bone5, -0.7854F, 0.0F, 0.0F);
        this.calamitas_herself.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 46, 4, -1.5F, -3.75F, -3.0F, 3, 1, 1, 0.1F, false));
        this.hands2 = new MModelRenderer(this);
        this.hands2.setRotationPoint(0.0F, -3.0F, -1.0F);
        this.calamitas_herself.addChild(this.hands2);
        this.left3 = new MModelRenderer(this);
        this.left3.setRotationPoint(1.5F, -0.25F, -0.5F);
        this.setRotation(this.left3, 0.3748F, -0.7275F, -0.0308F);
        this.hands2.addChild(this.left3);
        this.left3.cubeList.add(new ModelBox(this.left3, 45, 29, -0.25F, -0.5F, -2.75F, 1, 1, 3, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.25F, -0.6F, -3.15F);
        this.setRotation(this.bone8, ((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.left3.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 14, 25, -1.0F, -1.25F, -0.1F, 2, 2, 0, 0.0F, false));
        this.rightHandcalamitas = new MModelRenderer(this);
        this.rightHandcalamitas.setRotationPoint(-1.5F, -0.25F, -0.5F);
        this.setRotation(this.rightHandcalamitas, 0.3748F, 0.7275F, 0.0308F);
        this.hands2.addChild(this.rightHandcalamitas);
        this.rightHandcalamitas.cubeList.add(new ModelBox(this.rightHandcalamitas, 5, 45, -0.75F, -0.5F, -2.75F, 1, 1, 3, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-0.25F, -0.65F, -3.15F);
        this.setRotation(this.bone9, ((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.rightHandcalamitas.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 7, 39, -1.0F, -1.2F, -0.1F, 2, 2, 0, 0.0F, false));
        this.head2 = new MModelRenderer(this);
        this.head2.setRotationPoint(0.0F, -4.0F, -1.5F);
        this.calamitas_herself.addChild(this.head2);
        this.head2.cubeList.add(new ModelBox(this.head2, 34, 19, -1.5F, -3.0F, -1.5F, 3, 3, 3, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(1.25F, 1.55F, 4.5F);
        this.setRotation(this.bone7, 0.6431F, 0.1865F, -0.0299F);
        this.head2.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 48, 34, -2.5F, -9.25F, -2.5F, 2, 2, 0, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-1.25F, 1.55F, 4.5F);
        this.setRotation(this.bone6, 0.6431F, -0.1865F, 0.0299F);
        this.head2.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 48, 36, 0.5F, -9.25F, -2.5F, 2, 2, 0, 0.0F, true));
        this.head = new MModelRenderer(this);
        this.head.setRotationPoint(0.0F, -4.0F, 5.0F);
        this.setRotation(this.head, 0.9599F, 0.0F, 0.0F);
        this.skull.addChild(this.head);
        this.head.cubeList.add(new ModelBox(this.head, 18, 16, -3.5F, -10.0F, 0.0F, 7, 10, 1, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 20, 14, -0.5F, -10.0F, 1.0F, 1, 1, 1, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 26, 40, -2.0F, -10.0F, 1.0F, 1, 1, 2, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 17, 9, 1.0F, -10.0F, 1.0F, 1, 1, 2, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 34, 25, -2.0F, -9.0F, 2.0F, 4, 1, 3, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 0, 9, -3.5F, -4.0F, 2.0F, 7, 4, 3, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 0, 25, -3.0F, -9.0F, 1.0F, 6, 8, 1, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 0, 16, -4.0F, -9.0F, 5.0F, 8, 8, 1, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 33, 33, -3.0F, -7.0F, 6.0F, 6, 7, 1, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 23, 6, -2.5F, -8.0F, 2.0F, 5, 6, 3, 0.0F, false));
        this.head.cubeList.add(new ModelBox(this.head, 36, 41, -2.5F, -10.0F, -1.0F, 5, 2, 1, 0.0F, false));
        this.horns = new MModelRenderer(this);
        this.head.addChild(this.horns);
        this.left2 = new MModelRenderer(this);
        this.left2.setRotationPoint(2.25F, -5.0F, 6.25F);
        this.setRotation(this.left2, -0.5597F, 0.2587F, -0.2957F);
        this.horns.addChild(this.left2);
        this.left2.cubeList.add(new ModelBox(this.left2, 29, 41, -1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-4.0F, 5.0F, -4.0F);
        this.setRotation(this.bone, -0.9599F, 0.0F, 0.0F);
        this.left2.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 19, 40, 3.0F, -9.1755F, -0.8999F, 2, 2, 3, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-4.0F, 5.0F, -2.0F);
        this.setRotation(this.bone2, -0.1309F, 0.0F, 0.0F);
        this.left2.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 34, 3.0F, -5.0383F, 4.7263F, 2, 2, 4, 0.0F, false));
        this.righthorn = new MModelRenderer(this);
        this.righthorn.setRotationPoint(-2.25F, -5.0F, 6.25F);
        this.setRotation(this.righthorn, -0.5597F, -0.2587F, 0.2957F);
        this.horns.addChild(this.righthorn);
        this.righthorn.cubeList.add(new ModelBox(this.righthorn, 39, 9, -1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(4.0F, 5.0F, -4.0F);
        this.setRotation(this.bone3, -0.9599F, 0.0F, 0.0F);
        this.righthorn.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 39, -5.0F, -9.1755F, -0.8999F, 2, 2, 3, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(4.0F, 5.0F, -2.0F);
        this.setRotation(this.bone4, -0.1309F, 0.0F, 0.0F);
        this.righthorn.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 34, 0, -5.0F, -5.0383F, 4.7263F, 2, 2, 4, 0.0F, false));
        this.metal_thing = new MModelRenderer(this);
        this.Calamitas.addChild(this.metal_thing);
        this.metal_thing.cubeList.add(new ModelBox(this.metal_thing, 18, 0, -4.0F, -3.25F, 4.0F, 8, 2, 2, 0.0F, false));
        this.metal_thing.cubeList.add(new ModelBox(this.metal_thing, 0, 34, -0.5F, -6.25F, 5.5F, 1, 3, 1, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-1.75F, 0.25F, 1.5F);
        this.setRotation(this.bone10, -0.2699F, 0.4346F, -0.3679F);
        this.metal_thing.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 45, 26, 2.0F, -1.25F, 4.0F, 4, 1, 1, 0.0F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(1.75F, 0.25F, 1.5F);
        this.setRotation(this.bone11, -0.2699F, -0.4346F, 0.3679F);
        this.metal_thing.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 45, 24, -6.0F, -1.25F, 4.0F, 4, 1, 1, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/calamitaspet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/calamitaspet_animation.json"));
        this.animation = bbanimationloader.mustGet("calamitas", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.animation.tick(time);
        float f = MathHelper.sin(time * 0.1F) * 0.09F;
        GlStateManager.translate(1.2D, -0.3D + (double)f, 0.45D);
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.translate(0.0D, 0.25D, 0.0D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0430\u043b\u0430\u043c\u0438\u0442\u0430\u0441";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Terraria");
    }
}
