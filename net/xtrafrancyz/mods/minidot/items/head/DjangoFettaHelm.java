package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class DjangoFettaHelm extends BaseHelm
{
    private final MModelRenderer bone11;
    private final MModelRenderer bone10;
    private final MModelRenderer bone9;
    private final MModelRenderer bone8;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone16;
    private final MModelRenderer bone13;
    private final MModelRenderer bone3;
    private final MModelRenderer bone18;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final MModelRenderer bone31;
    private final MModelRenderer bone32;
    private final MModelRenderer bone33;
    private final MModelRenderer bone12;
    private final MModelRenderer bone17;
    private final MModelRenderer bone14;
    private final MModelRenderer bone19;
    private final MModelRenderer bone21;
    private final MModelRenderer bone22;
    private final MModelRenderer bone23;
    private final MModelRenderer bone24;
    private final MModelRenderer bone25;
    private final MModelRenderer bone26;
    private final MModelRenderer bone27;
    private final MModelRenderer bb_main;

    public DjangoFettaHelm()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(5.0F, 15.5F, -5.0F);
        this.setRotation(this.bone11, -1.7453F, 0.0F, 1.6581F);
        this.bone11.setTextureOffset(38, 0).addBox(0.4367F, -3.6607F, -0.1321F, 1, 3, 1, 0.0F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(5.0F, 17.5F, -5.0F);
        this.setRotation(this.bone10, -1.7453F, 0.0F, 1.3963F);
        this.bone10.setTextureOffset(38, 11).addBox(-0.2022F, -3.6706F, -0.0764F, 1, 3, 1, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-5.0F, 17.5F, -5.0F);
        this.setRotation(this.bone9, -1.7453F, 0.0F, -1.3963F);
        this.bone9.setTextureOffset(38, 21).addBox(-0.7978F, -3.6706F, -0.0764F, 1, 3, 1, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-5.0F, 15.5F, -5.0F);
        this.setRotation(this.bone8, -1.7453F, 0.0F, -1.6581F);
        this.bone8.setTextureOffset(38, 30).addBox(-1.4367F, -3.6607F, -0.1321F, 1, 3, 1, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-3.0F, 15.5F, -5.0F);
        this.setRotation(this.bone6, 0.0F, 0.0F, 1.6581F);
        this.bone6.setTextureOffset(38, 4).addBox(-0.2606F, -7.0001F, 0.5F, 1, 1, 1, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(3.0F, 15.5F, -5.0F);
        this.setRotation(this.bone7, 0.0F, 0.0F, -1.6581F);
        this.bone7.setTextureOffset(38, 15).addBox(-0.7394F, -7.0001F, 0.5F, 1, 1, 1, 0.0F);
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(-4.0F, 15.25F, 4.5F);
        this.setRotation(this.bone16, 1.5708F, 0.0F, 0.0F);
        this.bone16.setTextureOffset(14, 32).addBox(-0.65F, -6.0F, -1.6133F, 1, 6, 1, 0.0F);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(1.0F, 13.75F, 3.25F);
        this.setRotation(this.bone13, 1.5708F, 0.0F, -1.5708F);
        this.bone13.setTextureOffset(0, 0).addBox(-0.15F, -7.25F, -3.0F, 1, 8, 8, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-4.0F, 15.5F, -5.0F);
        this.setRotation(this.bone3, 0.0F, 0.0F, 1.5708F);
        this.bone3.setTextureOffset(18, 32).addBox(0.2633F, -7.0F, 0.5F, 1, 6, 1, 0.0F);
        this.bone3.setTextureOffset(0, 27).addBox(1.2633F, -8.0F, 1.25F, 4, 8, 1, 0.001F);
        this.bone3.setTextureOffset(20, 25).addBox(1.0F, -1.0F, 2.25F, 1, 1, 1, 0.0F);
        this.bone3.setTextureOffset(22, 0).addBox(1.0F, -8.0F, 2.25F, 1, 1, 1, 0.0F);
        this.bone18 = new MModelRenderer(this);
        this.bone18.setRotationPoint(0.0F, 0.0F, 10.0F);
        this.bone3.addChild(this.bone18);
        this.bone18.setTextureOffset(26, 30).addBox(0.3633F, -8.0F, -1.5F, 1, 8, 1, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(4.0F, 18.5F, -5.0F);
        this.setRotation(this.bone2, 0.0F, 0.0F, -1.7453F);
        this.bone2.setTextureOffset(11, 39).addBox(0.0133F, -2.8676F, 0.5F, 1, 3, 1, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-4.0F, 18.5F, -5.0F);
        this.setRotation(this.bone, 0.0F, 0.0F, 1.7453F);
        this.bone.setTextureOffset(38, 34).addBox(-1.0133F, -2.8676F, 0.5F, 1, 3, 1, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, 21.0F, -5.0F);
        this.setRotation(this.bone5, 0.0F, 0.0F, 0.1745F);
        this.bone5.setTextureOffset(7, 39).addBox(0.4639F, -3.1281F, 0.5F, 1, 3, 1, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, 21.0F, -5.0F);
        this.setRotation(this.bone4, 0.0F, 0.0F, -0.1745F);
        this.bone4.setTextureOffset(15, 39).addBox(-1.4639F, -3.1281F, 0.5F, 1, 3, 1, 0.0F);
        this.bone31 = new MModelRenderer(this);
        this.bone31.setRotationPoint(-3.5F, 20.0F, -3.25F);
        this.bone31.setTextureOffset(21, 38).addBox(-0.75F, -2.0F, -0.75F, 1, 3, 1, 0.001F);
        this.bone31.setTextureOffset(37, 7).addBox(-0.25F, -2.0F, -0.95F, 1, 3, 1, 0.0F);
        this.bone31.setTextureOffset(30, 37).addBox(0.75F, -2.0F, -0.95F, 1, 3, 1, 1.0E-4F);
        this.bone31.setTextureOffset(4, 36).addBox(1.0F, -2.0F, -0.95F, 1, 3, 1, 0.0F);
        this.bone31.setTextureOffset(38, 38).addBox(-0.9F, -2.0F, 0.0F, 1, 3, 1, 0.0F);
        this.bone31.setTextureOffset(36, 17).addBox(-0.9F, -2.0F, -0.25F, 1, 3, 1, 1.0E-4F);
        this.bone32 = new MModelRenderer(this);
        this.bone32.setRotationPoint(3.5F, 20.0F, -3.25F);
        this.bone32.setTextureOffset(0, 36).addBox(-0.25F, -2.0F, -0.75F, 1, 3, 1, 0.001F);
        this.bone32.setTextureOffset(34, 30).addBox(-0.75F, -2.0F, -0.95F, 1, 3, 1, 0.0F);
        this.bone32.setTextureOffset(34, 4).addBox(-1.75F, -2.0F, -0.95F, 1, 3, 1, 1.0E-4F);
        this.bone32.setTextureOffset(34, 0).addBox(-2.0F, -2.0F, -0.95F, 1, 3, 1, 0.0F);
        this.bone32.setTextureOffset(32, 17).addBox(-0.1F, -2.0F, 0.0F, 1, 3, 1, 1.0E-4F);
        this.bone32.setTextureOffset(28, 17).addBox(-0.1F, -2.0F, -0.25F, 1, 3, 1, 0.0F);
        this.bone33 = new MModelRenderer(this);
        this.bone33.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bone33.setTextureOffset(12, 21).addBox(-4.4F, -8.0F, -2.25F, 1, 5, 6, 0.0F);
        this.bone33.setTextureOffset(22, 32).addBox(-4.4F, -8.0F, 3.0F, 1, 5, 1, 1.0E-4F);
        this.bone33.setTextureOffset(34, 34).addBox(3.4F, -8.0F, 3.0F, 1, 5, 1, 1.0E-4F);
        this.bone33.setTextureOffset(20, 0).addBox(3.4F, -8.0F, -2.25F, 1, 5, 6, 0.0F);
        this.bone33.setTextureOffset(0, 16).addBox(3.3F, -11.0F, -4.0F, 1, 3, 8, 0.0F);
        this.bone33.setTextureOffset(26, 26).addBox(-4.0F, -11.0F, 3.1F, 8, 3, 1, 0.0F);
        this.bone33.setTextureOffset(20, 21).addBox(-4.0F, -11.0F, -4.1F, 8, 3, 1, 0.0F);
        this.bone33.setTextureOffset(10, 10).addBox(-4.3F, -11.0F, -4.0F, 1, 3, 8, 0.0F);
        this.bone33.setTextureOffset(20, 11).addBox(-4.0F, -8.0F, 3.15F, 8, 5, 1, 0.0F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(3.75F, 19.75F, -4.0F);
        this.bone12.setTextureOffset(10, 0).addBox(0.0583F, -3.96F, 2.3781F, 1, 5, 3, 0.0F);
        this.bone17 = new MModelRenderer(this);
        this.bone17.setRotationPoint(4.0F, 15.25F, 4.5F);
        this.setRotation(this.bone17, 1.5708F, 0.0F, 0.0F);
        this.bone17.setTextureOffset(10, 32).addBox(-0.25F, -6.0F, -1.6133F, 1, 6, 1, 0.0F);
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(-3.75F, 19.75F, -4.0F);
        this.bone14.setTextureOffset(0, 0).addBox(-1.0583F, -3.96F, 2.3781F, 1, 5, 3, 0.0F);
        this.bone19 = new MModelRenderer(this);
        this.bone19.setRotationPoint(0.0F, 17.8F, 3.3F);
        this.bone19.setTextureOffset(28, 0).addBox(-1.0F, -1.0F, 0.0F, 2, 4, 1, 0.0F);
        this.bone19.setTextureOffset(4, 22).addBox(-0.5F, -0.7F, 0.1F, 1, 1, 1, 0.0F);
        this.bone19.setTextureOffset(0, 22).addBox(-0.5F, 0.57F, 0.1F, 1, 1, 1, 0.0F);
        this.bone19.setTextureOffset(14, 21).addBox(-0.5F, 1.8F, 0.1F, 1, 1, 1, 0.0F);
        this.bone21 = new MModelRenderer(this);
        this.bone21.setRotationPoint(3.95F, 19.25F, -3.5F);
        this.bone21.setTextureOffset(18, 0).addBox(0.0583F, -2.96F, 2.3781F, 1, 4, 2, 0.0F);
        this.bone22 = new MModelRenderer(this);
        this.bone22.setRotationPoint(-3.95F, 19.25F, -3.5F);
        this.bone22.setTextureOffset(0, 16).addBox(-1.0585F, -2.96F, 2.3781F, 1, 4, 2, 0.0F);
        this.bone23 = new MModelRenderer(this);
        this.bone23.setRotationPoint(-4.15F, 17.65F, -4.0F);
        this.bone23.setTextureOffset(4, 16).addBox(-0.9583F, 0.04F, 3.3781F, 1, 1, 1, 0.0F);
        this.bone24 = new MModelRenderer(this);
        this.bone24.setRotationPoint(-4.15F, 19.25F, -3.5F);
        this.bone24.setTextureOffset(10, 21).addBox(-1.0583F, -2.96F, 2.3781F, 1, 1, 2, -0.1F);
        this.bone25 = new MModelRenderer(this);
        this.bone25.setRotationPoint(-3.95F, 15.35F, -4.0F);
        this.bone25.setTextureOffset(30, 30).addBox(-1.0583F, -4.96F, 3.3781F, 1, 6, 1, 0.0F);
        this.bone26 = new MModelRenderer(this);
        this.bone26.setRotationPoint(-3.95F, 15.35F, -4.0F);
        this.setRotation(this.bone26, 0.0F, 0.0F, -0.1745F);
        this.bone26.setTextureOffset(10, 16).addBox(-0.2704F, -5.8211F, 3.3781F, 2, 1, 1, 0.01F);
        this.bone27 = new MModelRenderer(this);
        this.bone27.setRotationPoint(-1.65F, 15.35F, -4.0F);
        this.setRotation(this.bone27, 0.0F, 0.0F, 0.0873F);
        this.bone27.setTextureOffset(15, 0).addBox(-2.1272F, -5.8699F, 3.3781F, 1, 1, 1, -0.001F);
        this.bb_main = new MModelRenderer(this);
        this.bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bb_main.setTextureOffset(0, 0).addBox(-4.0F, -11.0F, -4.0F, 8, 8, 8, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "head/djangofettahelm.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -1.5F, 0.0F);
        GlStateManager.scale(1.15F, 1.15F, 1.15F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -1.35F, 0.0F);
        super.renderAsItem(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public String getCreator()
    {
        return "DarkWack";
    }

    public String getName()
    {
        return "\u0428\u043b\u0435\u043c \u0414\u0436\u0430\u043d\u0433\u043e \u0424\u0435\u0442\u0442\u0430";
    }
}
