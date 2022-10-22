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
import org.lwjgl.opengl.GL11;

public class WumpusPet extends BasePet
{
    private final MModelRenderer leftleg;
    private final MModelRenderer bone2;
    private final MModelRenderer lefthand;
    private final MModelRenderer righthand;
    private final MModelRenderer bone5;
    private final MModelRenderer pyatak;
    private final MModelRenderer ear;
    private final MModelRenderer listok;
    private final MModelRenderer rightleg;

    public WumpusPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.leftleg = new MModelRenderer(this);
        this.leftleg.setRotationPoint(1.0F, -4.0F, 0.0F);
        this.leftleg.cubeList.add(new ModelBox(this.leftleg, 12, 24, -1.0F, -1.0F, -2.0F, 3, 5, 3, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 12, -5.0F, -12.0F, -3.0F, 9, 8, 5, 0.0F, false));
        this.lefthand = new MModelRenderer(this);
        this.lefthand.setRotationPoint(3.0F, -10.7F, 0.0F);
        this.setRotation(this.lefthand, 0.0F, 0.0F, -0.2618F);
        this.lefthand.cubeList.add(new ModelBox(this.lefthand, 24, 25, 1.0F, -1.0F, -1.5F, 2, 8, 2, 0.0F, false));
        this.righthand = new MModelRenderer(this);
        this.righthand.setRotationPoint(-5.0F, -11.1F, 0.0F);
        this.setRotation(this.righthand, 0.0F, 0.0F, 0.1745F);
        this.righthand.cubeList.add(new ModelBox(this.righthand, 24, 25, -2.0F, -0.8F, -1.5F, 2, 8, 2, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 1, 37, -5.5F, -22.0F, -3.5F, 10, 6, 6, 0.0F, false));
        this.pyatak = new MModelRenderer(this);
        this.pyatak.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.pyatak.cubeList.add(new ModelBox(this.pyatak, 33, 33, -3.0F, -19.5F, -4.4F, 5, 3, 1, -0.15F, false));
        this.ear = new MModelRenderer(this);
        this.ear.cubeList.add(new ModelBox(this.ear, 0, 6, -8.0F, -17.0F, -1.0F, 15, 4, 1, 0.0F, false));
        this.listok = new MModelRenderer(this);
        this.listok.setRotationPoint(2.0F, -17.2F, 0.0F);
        this.setRotation(this.listok, 0.0F, 0.0F, 0.2182F);
        this.listok.cubeList.add(new ModelBox(this.listok, 35, 9, -5.5F, -1.0F, 0.0F, 6, 0, 1, 0.0F, false));
        this.listok.cubeList.add(new ModelBox(this.listok, 39, 10, -4.25F, -1.0F, -1.0F, 4, 0, 1, 0.0F, false));
        this.listok.cubeList.add(new ModelBox(this.listok, 39, 10, -4.25F, -1.0F, 1.0F, 4, 0, 1, 0.0F, false));
        this.rightleg = new MModelRenderer(this);
        this.rightleg.setRotationPoint(-2.5F, -4.0F, 0.0F);
        this.rightleg.cubeList.add(new ModelBox(this.rightleg, 0, 24, -1.5F, -1.0F, -2.0F, 3, 5, 3, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/wumpuspet.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        double d0 = Math.sin((double)(time * 0.05F)) * 0.10000000149011612D;
        GlStateManager.translate(0.4D, 0.67D + d0, -0.23D);
        double d1 = 0.91D;
        GlStateManager.scale(d1, d1, d1);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.26F) * 0.05F;
        float f2 = MathHelper.cos(time * 0.16F);
        GL11.glTranslatef(0.6F, -0.5F + f, 0.3F);
        GL11.glRotatef(f2 * 4.0F, 0.0F, 0.6F, 0.0F);
        this.rightleg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 2.0F + f1;
        this.rightleg.rotationY = f * 2.0F;
        this.leftleg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 2.0F - f1;
        this.leftleg.rotationZ = f * 2.0F;
        this.lefthand.rotationX = modelPlayer.bipedLeftArm.rotateAngleX / 1.2F + f2 * 0.1F;
        this.lefthand.rotationY = -f2 * f * 2.0F;
        this.lefthand.rotationZ = f2 * f * 4.0F;
        this.righthand.rotationX = -this.lefthand.rotationX;
        this.righthand.rotationY = -this.lefthand.rotationY;
        this.righthand.rotationZ = this.lefthand.rotationZ;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.32532500000000003D, 0.0D);
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
        return "\u0412\u0430\u043c\u043f\u0443\u0441";
    }

    public String getCreator()
    {
        return "Mena3abanulu";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList("\u0412\u0438\u0440\u0442\u0443\u0430\u043b\u044c\u043d\u044b\u0439 \u0433\u0438\u0434 " + EnumChatFormatting.BLUE + "Discord");
    }
}
