package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class PlayerPet extends BasePet
{
    private static final Map<String, ResourceLocation> textures = new HashMap();
    private static MModelRenderer hair;
    private static MModelRenderer head;
    private static MModelRenderer body;
    private static MModelRenderer leftHand;
    private static MModelRenderer rightHand;
    private static MModelRenderer leftLeg;
    private static MModelRenderer rightLeg;
    private final String username;
    private boolean yt;

    public PlayerPet(String username)
    {
        this(username, username.toLowerCase());
    }

    public PlayerPet(String username, String texture)
    {
        this.yt = false;
        this.username = username;
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.disableAnimationInPreview = true;

        if (hair == null)
        {
            hair = new MModelRenderer(this, 32, 0);
            hair.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
            hair.mirror = true;
            hair.setDynamic(true);
            hair.scaleX = 1.1F;
            hair.scaleY = 1.15F;
            hair.scaleZ = 1.1F;
            hair.setRotationPoint(0.0F, 0.3F, 0.0F);
            head = new MModelRenderer(this, 0, 0);
            head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
            head.mirror = true;
            head.setDynamic(true);
            body = new MModelRenderer(this, 0, 17);
            body.addBox(-2.0F, 0.0F, -1.0F, 4, 4, 2);
            body.mirror = true;
            leftHand = new MModelRenderer(this, 9, 24);
            leftHand.addBox(0.0F, -0.5F, -1.0F, 2, 4, 2);
            leftHand.setRotationPoint(2.0F, 1.0F, 0.0F);
            leftHand.mirror = true;
            leftHand.setDynamic(true);
            rightHand = new MModelRenderer(this, 0, 24);
            rightHand.addBox(-2.0F, -0.5F, -1.0F, 2, 4, 2);
            rightHand.setRotationPoint(-2.0F, 1.0F, 0.0F);
            rightHand.mirror = true;
            rightHand.setDynamic(true);
            leftLeg = new MModelRenderer(this, 18, 17);
            leftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
            leftLeg.setRotationPoint(1.0F, 4.0F, 0.0F);
            leftLeg.mirror = true;
            leftLeg.setDynamic(true);
            rightLeg = new MModelRenderer(this, 28, 17);
            rightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2);
            rightLeg.setRotationPoint(-1.0F, 4.0F, 0.0F);
            rightLeg.mirror = true;
            rightLeg.setDynamic(true);
        }

        if (textures.containsKey(username.toLowerCase()))
        {
            this.setTexture((ResourceLocation)textures.get(username.toLowerCase()));
        }
        else
        {
            ResourceLocation resourcelocation = new ResourceLocation("minidot", "pets/" + texture + ".png");
            textures.put(username.toLowerCase(), resourcelocation);
            this.setTexture(resourcelocation);
        }
    }

    public PlayerPet yt()
    {
        this.yt = true;
        return this;
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        float f1 = MathHelper.sin(time * 0.26F) * 0.05F;
        float f2 = MathHelper.cos(time * 0.16F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f2 * 4.0F, 0.0F, 0.6F, 0.0F);
        head.rotationX = modelPlayer.bipedHead.rotateAngleX / 2.0F;
        head.rotationY = modelPlayer.bipedHead.rotateAngleY + 0.2F - f2 * 0.1F;
        head.rotationZ = modelPlayer.bipedHead.rotateAngleZ;
        MModelRenderer mmodelrenderer = hair;
        mmodelrenderer.rotationX = head.rotationX;
        mmodelrenderer.rotationY = head.rotationY;
        mmodelrenderer.rotationZ = head.rotationZ;
        rightLeg.rotationX = modelPlayer.bipedRightLeg.rotateAngleX / 2.0F + f1;
        rightLeg.rotationY = f * 2.0F;
        leftLeg.rotationX = modelPlayer.bipedLeftLeg.rotateAngleX / 2.0F - f1;
        leftLeg.rotationZ = f * 2.0F;
        leftHand.rotationX = modelPlayer.bipedLeftArm.rotateAngleX / 1.2F + f2 * 0.1F;
        leftHand.rotationY = -f2 * f * 2.0F;
        leftHand.rotationZ = f2 * f * 4.0F;
        rightHand.rotationX = -leftHand.rotationX;
        rightHand.rotationY = -leftHand.rotationY;
        rightHand.rotationZ = leftHand.rotationZ;
    }

    public void renderAsItem(float time)
    {
        GlStateManager.disableCull();
        GlStateManager.translate(0.0F, 0.05F, 0.0F);
        super.renderAsItem(time);
        GlStateManager.enableCull();
    }

    public List<String> getDescription()
    {
        return this.yt ? Collections.singletonList(EnumChatFormatting.BOLD + "You" + EnumChatFormatting.RED + EnumChatFormatting.BOLD + "Tube") : null;
    }

    public String getName()
    {
        return this.username;
    }
}
