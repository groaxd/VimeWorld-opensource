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

public class SCP096Mask extends BaseItem
{
    private final MModelRenderer SCP096;
    private final MModelRenderer bone15;
    private final MModelRenderer bone16;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone17;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;

    public SCP096Mask()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.SCP096 = new MModelRenderer(this);
        this.SCP096.setRotationPoint(0.0F, 27.0F, -2.0F);
        this.SCP096.setTextureOffset(0, 2).addBox(-4.0F, -13.0F, 0.0F, 8, 1, 1, 0.0F);
        this.SCP096.setTextureOffset(0, 4).addBox(-2.5373F, -14.2482F, -0.101F, 5, 2, 1, -0.1001F);
        this.SCP096.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, 0.0F, 8, 1, 1, 0.0F);
        this.SCP096.setTextureOffset(0, 18).addBox(3.0F, -12.0F, 0.0F, 1, 2, 1, 0.0F);
        this.SCP096.setTextureOffset(9, 17).addBox(2.0F, -9.0F, 0.0F, 1, 3, 1, 0.0F);
        this.SCP096.setTextureOffset(9, 12).addBox(-2.0F, -5.2679F, 0.0F, 4, 1, 1, 1.0E-4F);
        this.SCP096.setTextureOffset(5, 17).addBox(-3.0F, -9.0F, 0.0F, 1, 3, 1, 0.0F);
        this.SCP096.setTextureOffset(0, 9).addBox(-2.0F, -9.0F, 0.25F, 4, 3, 1, 0.0F);
        this.SCP096.setTextureOffset(10, 10).addBox(-2.0F, -6.0F, 0.25F, 4, 1, 1, 0.0F);
        this.SCP096.setTextureOffset(12, 14).addBox(-1.0F, -12.0F, 0.0F, 2, 2, 1, 0.0F);
        this.SCP096.setTextureOffset(6, 14).addBox(1.0F, -12.0F, 0.25F, 2, 2, 1, 0.0F);
        this.SCP096.setTextureOffset(0, 13).addBox(-3.0F, -12.0F, 0.25F, 2, 2, 1, 0.0F);
        this.SCP096.setTextureOffset(18, 20).addBox(-4.0F, -12.0F, 0.0F, 1, 2, 1, 0.0F);
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(3.0F, -13.0F, 0.0F);
        this.SCP096.addChild(this.bone15);
        this.setRotation(this.bone15, 0.0F, 0.0F, 0.6109F);
        this.bone15.setTextureOffset(14, 4).addBox(-1.1808F, -0.5736F, 0.0F, 2, 1, 1, 0.0F);
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(-3.0F, -13.0F, 0.0F);
        this.SCP096.addChild(this.bone16);
        this.setRotation(this.bone16, 0.0F, 0.0F, -0.6109F);
        this.bone16.setTextureOffset(13, 8).addBox(-0.8192F, -0.5736F, 0.0F, 2, 1, 1, 0.0F);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(7.0F, -4.0F, 0.0F);
        this.SCP096.addChild(this.bone13);
        this.setRotation(this.bone13, 0.0F, 0.0F, -1.0472F);
        this.bone13.setTextureOffset(0, 16).addBox(-2.2679F, -5.4641F, 0.0F, 2, 1, 1, -1.0E-4F);
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-7.0F, -4.0F, 0.0F);
        this.SCP096.addChild(this.bone14);
        this.setRotation(this.bone14, 0.0F, 0.0F, 1.0472F);
        this.bone14.setTextureOffset(14, 6).addBox(0.2679F, -5.4641F, 0.0F, 2, 1, 1, -1.0E-4F);
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(-0.5F, -9.25F, -1.0F);
        this.SCP096.addChild(this.bone17);
        this.setRotation(this.bone17, -0.4363F, 0.0F, 0.0F);
        this.bone17.setTextureOffset(19, 7).addBox(0.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.25F, 0.0F, 0.25F);
        this.SCP096.addChild(this.bone3);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-3.5F, 0.25F, 0.75F);
        this.bone3.addChild(this.bone2);
        this.setRotation(this.bone2, 0.0F, 0.2618F, 0.0F);
        this.bone2.setTextureOffset(19, 3).addBox(-0.3343F, -13.0F, -1.0896F, 2, 1, 1, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-0.5F, 0.25F, 0.75F);
        this.bone3.addChild(this.bone);
        this.setRotation(this.bone, 0.0F, -0.2618F, 0.0F);
        this.bone.setTextureOffset(19, 5).addBox(-2.0F, -13.0F, -1.0F, 2, 1, 1, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.25F, 2.25F, 0.25F);
        this.SCP096.addChild(this.bone7);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-3.5F, 0.25F, 0.75F);
        this.bone7.addChild(this.bone8);
        this.setRotation(this.bone8, 0.0F, 0.2618F, 0.0F);
        this.bone8.setTextureOffset(18, 13).addBox(-0.3343F, -13.0F, -1.0896F, 2, 1, 1, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-0.5F, 0.25F, 0.75F);
        this.bone7.addChild(this.bone9);
        this.setRotation(this.bone9, 0.0F, -0.2618F, 0.0F);
        this.bone9.setTextureOffset(18, 18).addBox(-2.0F, -13.0F, -1.0F, 2, 1, 1, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-0.25F, 0.0F, 0.25F);
        this.SCP096.addChild(this.bone4);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(3.5F, 0.25F, 0.75F);
        this.bone4.addChild(this.bone5);
        this.setRotation(this.bone5, 0.0F, -0.2618F, 0.0F);
        this.bone5.setTextureOffset(13, 19).addBox(-1.6657F, -13.0F, -1.0896F, 2, 1, 1, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.5F, 0.25F, 0.75F);
        this.bone4.addChild(this.bone6);
        this.setRotation(this.bone6, 0.0F, 0.2618F, 0.0F);
        this.bone6.setTextureOffset(18, 15).addBox(0.0F, -13.0F, -1.0F, 2, 1, 1, 0.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-0.25F, 2.25F, 0.25F);
        this.SCP096.addChild(this.bone10);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(3.5F, 0.25F, 0.75F);
        this.bone10.addChild(this.bone11);
        this.setRotation(this.bone11, 0.0F, -0.2618F, 0.0F);
        this.bone11.setTextureOffset(17, 1).addBox(-1.6657F, -13.0F, -1.0896F, 2, 1, 1, 0.0F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(0.5F, 0.25F, 0.75F);
        this.bone10.addChild(this.bone12);
        this.setRotation(this.bone12, 0.0F, 0.2618F, 0.0F);
        this.bone12.setTextureOffset(13, 17).addBox(0.0F, -13.0F, -1.0F, 2, 1, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "masks/scp096mask.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.95F, 0.95F, 0.95F);
        GlStateManager.translate(0.0F, -1.35F, -0.2F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        GlStateManager.translate(0.0F, -1.3F, -0.2F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u0421\u043a\u0440\u043e\u043c\u043d\u0438\u043a\u0430";
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
