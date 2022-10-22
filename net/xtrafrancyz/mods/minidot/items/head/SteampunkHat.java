package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class SteampunkHat extends BaseItem
{
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer Remen;
    private final MModelRenderer Ost;
    private final MModelRenderer Shest1;
    private final MModelRenderer Shest2;
    private final MModelRenderer Shest3;
    private final MModelRenderer Shest4;
    private final MModelRenderer Shest5;
    private final MModelRenderer bb_main;
    private final IAnimation anim;

    public SteampunkHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-7.0F, 24.0F, 0.0F);
        this.bone3.setTextureOffset(40, 118).addBox(2.0F, -9.0F, -8.0F, 3, 3, 1, 0.0F);
        this.bone3.setTextureOffset(50, 118).addBox(5.0F, -9.0F, -8.0F, 1, 3, 1, 0.0F);
        this.bone3.setTextureOffset(55, 119).addBox(2.0F, -10.0F, -8.0F, 3, 1, 1, 0.0F);
        this.bone3.setTextureOffset(64, 118).addBox(1.0F, -9.0F, -8.0F, 1, 3, 1, 0.0F);
        this.bone3.setTextureOffset(70, 119).addBox(2.0F, -6.0F, -8.0F, 3, 1, 1, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bone2.setTextureOffset(0, 124).addBox(2.0F, -9.0F, -8.0F, 3, 3, 1, 0.0F);
        this.bone2.setTextureOffset(10, 124).addBox(5.0F, -9.0F, -8.0F, 1, 3, 1, 0.0F);
        this.bone2.setTextureOffset(16, 126).addBox(2.0F, -10.0F, -8.0F, 3, 1, 1, 0.0F);
        this.bone2.setTextureOffset(26, 124).addBox(1.0F, -9.0F, -8.0F, 1, 3, 1, 0.0F);
        this.bone2.setTextureOffset(31, 126).addBox(2.0F, -6.0F, -8.0F, 3, 1, 1, 0.0F);
        this.Remen = new MModelRenderer(this);
        this.Remen.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Remen.setTextureOffset(96, 0).addBox(7.0F, -8.0F, -8.0F, 1, 1, 16, 0.0F);
        this.Remen.setTextureOffset(122, 38).addBox(6.0F, -9.0F, -8.0F, 1, 3, 1, 0.0F);
        this.Remen.setTextureOffset(98, 41).addBox(-8.0F, -8.0F, 7.0F, 15, 1, 1, 0.0F);
        this.Remen.setTextureOffset(96, 17).addBox(-8.0F, -8.0F, -8.0F, 1, 1, 15, 0.0F);
        this.Remen.setTextureOffset(34, 118).addBox(-7.0F, -9.0F, -8.0F, 1, 3, 1, 0.0F);
        this.Ost = new MModelRenderer(this);
        this.Ost.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Ost.setTextureOffset(68, 126).addBox(1.0F, -5.0F, -8.0F, 5, 1, 1, 0.0F);
        this.Ost.setTextureOffset(8, 120).addBox(5.0F, -6.0F, -8.0F, 2, 1, 1, 0.0F);
        this.Ost.setTextureOffset(95, 126).addBox(-2.0F, -6.0F, -8.0F, 4, 1, 1, 0.0F);
        this.Ost.setTextureOffset(25, 118).addBox(-1.0F, -9.0F, -8.0F, 2, 3, 1, 0.0F);
        this.Ost.setTextureOffset(68, 126).addBox(-6.0F, -5.0F, -8.0F, 5, 1, 1, 0.0F);
        this.Ost.setTextureOffset(0, 120).addBox(-7.0F, -6.0F, -8.0F, 2, 1, 1, 0.0F);
        this.Ost.setTextureOffset(16, 120).addBox(5.0F, -10.0F, -8.0F, 2, 1, 1, 0.0F);
        this.Ost.setTextureOffset(40, 126).addBox(1.0F, -11.0F, -8.0F, 5, 1, 1, 0.0F);
        this.Ost.setTextureOffset(106, 126).addBox(-2.0F, -10.0F, -8.0F, 4, 1, 1, 0.0F);
        this.Ost.setTextureOffset(40, 126).addBox(-6.0F, -11.0F, -8.0F, 5, 1, 1, 0.0F);
        this.Ost.setTextureOffset(117, 126).addBox(-7.0F, -10.0F, -8.0F, 2, 1, 1, 0.0F);
        this.Shest1 = new MModelRenderer(this);
        this.Shest1.setRotationPoint(6.5F, 10.75F, -3.0F);
        this.Shest1.setTextureOffset(86, 119).addBox(0.0F, 0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Shest1.setTextureOffset(92, 119).addBox(0.0F, -0.5F, 0.5F, 1, 1, 1, 0.0F);
        this.Shest1.setTextureOffset(97, 119).addBox(0.0F, -0.5F, -1.5F, 1, 1, 1, 0.0F);
        this.Shest1.setTextureOffset(80, 119).addBox(0.0F, -1.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Shest2 = new MModelRenderer(this);
        this.Shest2.setRotationPoint(6.5F, 12.5F, -0.5F);
        this.Shest2.setTextureOffset(102, 119).addBox(0.0F, 0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Shest2.setTextureOffset(108, 119).addBox(0.0F, -0.5F, 0.5F, 1, 1, 1, 0.0F);
        this.Shest2.setTextureOffset(113, 119).addBox(0.0F, -0.5F, -1.5F, 1, 1, 1, 0.0F);
        this.Shest2.setTextureOffset(118, 119).addBox(0.0F, -1.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Shest3 = new MModelRenderer(this);
        this.Shest3.setRotationPoint(6.5F, 13.5F, -4.5F);
        this.Shest3.setTextureOffset(86, 119).addBox(0.0F, 0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Shest3.setTextureOffset(92, 119).addBox(0.0F, -0.5F, 0.5F, 1, 1, 1, 0.0F);
        this.Shest3.setTextureOffset(97, 119).addBox(0.0F, -0.5F, -1.5F, 1, 1, 1, 0.0F);
        this.Shest3.setTextureOffset(80, 119).addBox(0.0F, -1.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Shest4 = new MModelRenderer(this);
        this.Shest4.setRotationPoint(7.5F, 8.0F, 2.0F);
        this.Shest4.setTextureOffset(98, 115).addBox(-1.0F, -2.5F, -0.5F, 1, 2, 1, 0.0F);
        this.Shest4.setTextureOffset(104, 115).addBox(-1.0F, 0.5F, -0.5F, 1, 2, 1, 0.0F);
        this.Shest4.setTextureOffset(110, 115).addBox(-1.0F, -0.5F, 0.5F, 1, 1, 2, 0.0F);
        this.Shest4.setTextureOffset(118, 115).addBox(-1.0F, -0.5F, -2.5F, 1, 1, 2, 0.0F);
        this.Shest4.setTextureOffset(118, 112).addBox(-1.0F, -1.5F, -3.5F, 1, 1, 1, 0.0F);
        this.Shest4.setTextureOffset(113, 112).addBox(-1.0F, 0.5F, 2.5F, 1, 1, 1, 0.0F);
        this.Shest4.setTextureOffset(107, 112).addBox(-1.0F, -1.5F, 2.5F, 1, 1, 1, 0.0F);
        this.Shest4.setTextureOffset(101, 112).addBox(-1.0F, -3.5F, -1.5F, 1, 1, 1, 0.0F);
        this.Shest4.setTextureOffset(96, 111).addBox(-1.0F, -3.5F, 0.5F, 1, 1, 1, 0.0F);
        this.Shest4.setTextureOffset(89, 112).addBox(-1.0F, 2.5F, -1.5F, 1, 1, 1, 0.0F);
        this.Shest4.setTextureOffset(84, 111).addBox(-1.0F, 0.5F, -3.5F, 1, 1, 1, 0.0F);
        this.Shest4.setTextureOffset(79, 111).addBox(-1.0F, 2.5F, 0.5F, 1, 1, 1, 0.0F);
        this.Shest5 = new MModelRenderer(this);
        this.Shest5.setRotationPoint(-7.5F, 10.5F, 0.5F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, -1.5F, -1.5F, 1, 1, 3, 0.0F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, 0.5F, -1.5F, 1, 1, 3, 0.0F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, -0.5F, -1.5F, 1, 1, 1, 0.0F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, -0.5F, 0.5F, 1, 1, 1, 0.0F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, -4.5F, -0.5F, 1, 3, 1, 0.0F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, 1.5F, -0.5F, 1, 3, 1, 0.0F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, -0.5F, -4.5F, 1, 1, 3, 0.0F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, -0.5F, 1.5F, 1, 1, 3, 0.0F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, -2.5F, 1.5F, 1, 1, 1, 0.0F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, -2.5F, -2.5F, 1, 1, 1, 0.0F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, 1.5F, -2.5F, 1, 1, 1, 0.0F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, -3.5F, 2.5F, 1, 1, 1, 0.0F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, -3.5F, -3.5F, 1, 1, 1, 0.0F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, 2.5F, 2.5F, 1, 1, 1, 0.0F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, 1.5F, 1.5F, 1, 1, 1, 0.0F);
        this.Shest5.setTextureOffset(112, 93).addBox(0.0F, 2.5F, -3.5F, 1, 1, 1, 0.0F);
        this.bb_main = new MModelRenderer(this);
        this.bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bb_main.setTextureOffset(0, 0).addBox(-9.0F, -4.0F, -9.0F, 18, 4, 18, 0.0F);
        this.bb_main.setTextureOffset(0, 24).addBox(-7.0F, -20.0F, -7.0F, 14, 16, 14, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "head/steampunkhat.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/steampunkhat_animation.json"));
        this.anim = bbanimationloader.mustGet("Shest1", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        this.anim.tick(time);
        GlStateManager.scale(0.55F, 0.55F, 0.55F);
        GlStateManager.translate(0.0F, -2.35F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        GlStateManager.translate(0.0F, -1.3F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u0442\u0438\u043c\u043f\u0430\u043d\u043a \u0448\u043b\u044f\u043f\u0430";
    }

    public String getCreator()
    {
        return "vladnest";
    }
}
