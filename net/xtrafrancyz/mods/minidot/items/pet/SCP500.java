package net.xtrafrancyz.mods.minidot.items.pet;

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
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class SCP500 extends BasePet
{
    private final MModelRenderer SCP_500_Panacea;
    private final MModelRenderer can;
    private final MModelRenderer pills;
    private final MModelRenderer pill4;
    private final MModelRenderer pill3;
    private final MModelRenderer pill2;
    private final MModelRenderer pill1;
    private final IAnimation animation;

    public SCP500()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.SCP_500_Panacea = new MModelRenderer(this);
        this.SCP_500_Panacea.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.can = new MModelRenderer(this);
        this.can.setRotationPoint(1.5F, 3.0F, 0.0F);
        this.SCP_500_Panacea.addChild(this.can);
        this.can.cubeList.add(new ModelBox(this.can, 0, 8, -4.0F, -10.0F, -3.0F, 5, 7, 5, 0.0F));
        this.can.cubeList.add(new ModelBox(this.can, 15, 8, -4.0F, -8.0F, -3.1F, 5, 3, 0, 0.0F));
        this.can.cubeList.add(new ModelBox(this.can, 0, 0, -4.5F, -11.5F, -3.5F, 6, 2, 6, 0.0F));
        this.pills = new MModelRenderer(this);
        this.pills.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.SCP_500_Panacea.addChild(this.pills);
        this.pill4 = new MModelRenderer(this);
        this.pill4.setRotationPoint(0.0F, -0.25F, -5.5F);
        this.pills.addChild(this.pill4);
        this.pill4.cubeList.add(new ModelBox(this.pill4, 0, 8, -0.5F, -1.5F, -0.5F, 1, 3, 1, 0.0F));
        this.pill3 = new MModelRenderer(this);
        this.pill3.setRotationPoint(-5.5F, -0.25F, -0.5F);
        this.pills.addChild(this.pill3);
        this.pill3.cubeList.add(new ModelBox(this.pill3, 0, 8, -0.5F, -1.5F, -0.5F, 1, 3, 1, 0.0F));
        this.pill2 = new MModelRenderer(this);
        this.pill2.setRotationPoint(0.0F, -0.25F, 4.5F);
        this.pills.addChild(this.pill2);
        this.pill2.cubeList.add(new ModelBox(this.pill2, 0, 8, -0.5F, -1.5F, -0.5F, 1, 3, 1, 0.0F));
        this.pill1 = new MModelRenderer(this);
        this.pill1.setRotationPoint(5.5F, -0.25F, -0.5F);
        this.pills.addChild(this.pill1);
        this.pill1.cubeList.add(new ModelBox(this.pill1, 0, 8, -0.5F, -1.5F, -0.5F, 1, 3, 1, 0.0F));
        this.setTexture(new ResourceLocation("minidot", "pets/scp500.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/scp500_animation.json"));
        this.animation = bbanimationloader.mustGet("pills.looping", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.04F;
        GlStateManager.translate(0.75F, -1.0F + f, 0.25F);
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
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
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        GlStateManager.translate(0.0F, -0.65F, 0.0F);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u0430\u043d\u0430\u0446\u0435\u044f";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "SCP Foundation");
    }
}
