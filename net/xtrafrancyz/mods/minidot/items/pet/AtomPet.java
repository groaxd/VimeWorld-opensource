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

public class AtomPet extends BasePet
{
    private final MModelRenderer bone;
    private final MModelRenderer bone5;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final IAnimation animation;

    public AtomPet()
    {
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -8.5F, 0.0F);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 4, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.25F, -9.0F, 0.0F);
        this.setRotation(this.bone2, 0.0F, -1.5708F, 0.0F);
        this.bone5.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 2, -0.5F, 0.0F, -6.5F, 1, 1, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.5F, 9.0F, 0.5F);
        this.bone2.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 8, 0.0F, -8.5F, -7.0F, 3, 0, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 8, 9, 4.8284F, -8.501F, -4.1716F, 1, 0, 3, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.setRotation(this.bone4, 0.0F, -0.7854F, 0.0F);
        this.bone3.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 6, 8, -2.8284F, -8.501F, -7.0711F, 4, 0, 1, 0.0F, false));
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(-0.5F, -9.0F, 0.0F);
        this.setRotation(this.bone12, 0.0F, -1.5708F, -1.5708F);
        this.bone5.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 0, 2, -0.5F, 0.0F, -6.5F, 1, 1, 1, 0.0F, false));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(0.5F, 9.0F, 0.5F);
        this.bone12.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 0, 8, 0.0F, -8.5F, -7.0F, 3, 0, 1, 0.0F, false));
        this.bone13.cubeList.add(new ModelBox(this.bone13, 8, 9, 4.8284F, -8.501F, -4.1716F, 1, 0, 3, 0.0F, false));
        this.bone14 = new MModelRenderer(this);
        this.setRotation(this.bone14, 0.0F, -0.7854F, 0.0F);
        this.bone13.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 6, 8, -2.8284F, -8.501F, -7.0711F, 4, 0, 1, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, -9.0F, 0.0F);
        this.setRotation(this.bone6, 0.0F, 1.5708F, -0.8727F);
        this.bone5.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 2, -0.25F, 0.0F, -6.5F, 1, 1, 1, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.75F, 9.0F, 0.5F);
        this.bone6.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 8, 0.0F, -8.5F, -7.0F, 3, 0, 1, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 8, 9, 4.8284F, -8.501F, -4.1716F, 1, 0, 3, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.setRotation(this.bone8, 0.0F, -0.7854F, 0.0F);
        this.bone7.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 6, 8, -2.8284F, -8.501F, -7.0711F, 4, 0, 1, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.0F, -8.3F, 0.0F);
        this.setRotation(this.bone9, 0.0F, 0.0F, -2.4435F);
        this.bone5.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 2, -0.25F, 0.0F, -6.5F, 1, 1, 1, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.75F, 9.0F, 0.5F);
        this.bone9.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 0, 8, 0.0F, -8.5F, -7.0F, 3, 0, 1, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 8, 9, 4.8284F, -8.501F, -4.1716F, 1, 0, 3, 0.0F, false));
        this.bone11 = new MModelRenderer(this);
        this.setRotation(this.bone11, 0.0F, -0.7854F, 0.0F);
        this.bone10.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 6, 8, -2.8284F, -8.501F, -7.0711F, 4, 0, 1, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/atompet.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/atompet_animation.json"));
        this.animation = bbanimationloader.mustGet("animation.model.new", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.translate(0.6D, 0.0D, 0.3D);
        double d0 = (double)MathHelper.sin(time * 0.1F) * 0.03D;
        GlStateManager.translate(0.0D, d0, 0.0D);
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.4D, 0.0D);
        double d0 = 1.2D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0410\u0442\u043e\u043c";
    }

    public String getCreator()
    {
        return "EvilBendy";
    }
}
