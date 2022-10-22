package net.xtrafrancyz.mods.minidot.items.mask;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SCPSculptureMask extends BaseItem
{
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;

    public SCPSculptureMask()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bone.setTextureOffset(0, 9).addBox(-3.0F, -1.0F, -5.0F, 6, 1, 1, 0.0F);
        this.bone.setTextureOffset(0, 7).addBox(-3.0F, -8.0F, -5.0F, 6, 1, 1, 0.0F);
        this.bone.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, -5.0F, 8, 6, 1, 0.0F);
        this.bone.setTextureOffset(10, 11).addBox(1.0F, -6.0F, -5.35F, 2, 2, 1, 0.0F);
        this.bone.setTextureOffset(4, 11).addBox(-3.0F, -6.0F, -5.35F, 2, 2, 1, 0.0F);
        this.bone.setTextureOffset(0, 11).addBox(-0.5F, -7.0F, -5.25F, 1, 4, 1, 0.0F);
        this.bone.setTextureOffset(13, 8).addBox(-1.0F, -2.25F, -5.25F, 2, 1, 1, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(2.75F, -1.25F, -5.75F);
        this.bone.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 0.0F, -0.0873F);
        this.bone2.setTextureOffset(8, 14).addBox(-1.0F, -2.0F, 0.55F, 1, 2, 1, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-2.75F, -1.25F, -5.75F);
        this.bone.addChild(this.bone3);
        this.setRotation(this.bone3, 0.0F, 0.0F, 0.0873F);
        this.bone3.setTextureOffset(4, 14).addBox(0.0F, -2.0F, 0.55F, 1, 2, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "masks/scpsculpturemask.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -1.5F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -1.45F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u0421\u043a\u0443\u043b\u044c\u043f\u0442\u0443\u0440\u044b";
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
