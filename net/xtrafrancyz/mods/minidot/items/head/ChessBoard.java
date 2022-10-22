package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ChessBoard extends BaseItem
{
    private final MModelRenderer bb_main;
    private final MModelRenderer bokaone;
    private final MModelRenderer bokatwo;
    private final MModelRenderer bokathree;
    private final MModelRenderer bokafo;
    private final MModelRenderer sashka;
    private final MModelRenderer sashkatwo;
    private final MModelRenderer sashkathree;
    private final MModelRenderer blackone;
    private final MModelRenderer blacktwo;
    private final MModelRenderer blackthree;

    public ChessBoard()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bb_main = new MModelRenderer(this);
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 16, -4.0F, -9.0F, -4.0F, 8, 1, 8, 0.0F, false));
        this.bokaone = new MModelRenderer(this);
        this.bokaone.setRotationPoint(0.0F, -9.0F, -4.0F);
        this.setRotation(this.bokaone, 1.1781F, 0.0F, 0.0F);
        this.bokaone.cubeList.add(new ModelBox(this.bokaone, 16, 25, -4.0F, 0.0F, -2.0F, 8, 0, 2, 0.0F, false));
        this.bokatwo = new MModelRenderer(this);
        this.bokatwo.setRotationPoint(4.0F, -9.0F, 0.0F);
        this.setRotation(this.bokatwo, 0.0F, 0.0F, 1.1781F);
        this.bokatwo.cubeList.add(new ModelBox(this.bokatwo, 16, 0, 0.0F, 0.0F, -4.0F, 2, 0, 8, 0.0F, false));
        this.bokathree = new MModelRenderer(this);
        this.bokathree.setRotationPoint(0.0F, -9.0F, 4.0F);
        this.setRotation(this.bokathree, -1.1781F, 0.0F, 0.0F);
        this.bokathree.cubeList.add(new ModelBox(this.bokathree, 0, 25, -4.0F, 0.0F, 0.0F, 8, 0, 2, 0.0F, false));
        this.bokafo = new MModelRenderer(this);
        this.bokafo.setRotationPoint(-4.0F, -9.0F, 0.0F);
        this.setRotation(this.bokafo, 0.0F, 0.0F, -1.1781F);
        this.bokafo.cubeList.add(new ModelBox(this.bokafo, 16, 16, -2.0F, 0.0F, -4.0F, 2, 0, 8, 0.0F, false));
        this.sashka = new MModelRenderer(this);
        this.sashka.setRotationPoint(-2.0F, 2.3F, 2.0F);
        this.sashka.cubeList.add(new ModelBox(this.sashka, 15, 63, -1.0F, -14.6F, 0.5F, 1, 1, 0, 0.0F, false));
        this.sashka.cubeList.add(new ModelBox(this.sashka, 7, 62, -1.0F, -12.3F, 0.0F, 1, 1, 1, 0.0F, false));
        this.sashka.cubeList.add(new ModelBox(this.sashka, 3, 62, -1.0F, -13.9F, 0.0F, 1, 1, 1, 0.0F, false));
        this.sashka.cubeList.add(new ModelBox(this.sashka, 0, 62, -0.5F, -13.0F, 0.0F, 0, 1, 1, 0.0F, false));
        this.sashka.cubeList.add(new ModelBox(this.sashka, 12, 62, -0.5F, -14.6F, 0.0F, 0, 1, 1, 0.0F, false));
        this.sashkatwo = new MModelRenderer(this);
        this.sashkatwo.setRotationPoint(-2.0F, 2.3F, 5.0F);
        this.sashkatwo.cubeList.add(new ModelBox(this.sashkatwo, 15, 63, -1.0F, -14.6F, -4.5F, 1, 1, 0, 0.0F, false));
        this.sashkatwo.cubeList.add(new ModelBox(this.sashkatwo, 7, 62, -1.0F, -12.3F, -5.0F, 1, 1, 1, 0.0F, false));
        this.sashkatwo.cubeList.add(new ModelBox(this.sashkatwo, 3, 62, -1.0F, -13.9F, -5.0F, 1, 1, 1, 0.0F, false));
        this.sashkatwo.cubeList.add(new ModelBox(this.sashkatwo, 0, 62, -0.5F, -13.0F, -5.0F, 0, 1, 1, 0.0F, false));
        this.sashkatwo.cubeList.add(new ModelBox(this.sashkatwo, 12, 62, -0.5F, -14.6F, -5.0F, 0, 1, 1, 0.0F, false));
        this.sashkathree = new MModelRenderer(this);
        this.sashkathree.setRotationPoint(-2.5F, -8.95F, -1.5F);
        this.sashkathree.cubeList.add(new ModelBox(this.sashkathree, 15, 63, -0.5F, -3.35F, 0.0F, 1, 1, 0, 0.0F, false));
        this.sashkathree.cubeList.add(new ModelBox(this.sashkathree, 7, 62, -0.5F, -1.05F, -0.5F, 1, 1, 1, 0.0F, false));
        this.sashkathree.cubeList.add(new ModelBox(this.sashkathree, 3, 62, -0.5F, -2.65F, -0.5F, 1, 1, 1, 0.0F, false));
        this.sashkathree.cubeList.add(new ModelBox(this.sashkathree, 0, 62, 0.0F, -1.75F, -0.5F, 0, 1, 1, 0.0F, false));
        this.sashkathree.cubeList.add(new ModelBox(this.sashkathree, 12, 62, 0.0F, -3.35F, -0.5F, 0, 1, 1, 0.0F, false));
        this.blackone = new MModelRenderer(this);
        this.blackone.setRotationPoint(3.0F, 2.3F, 7.0F);
        this.blackone.cubeList.add(new ModelBox(this.blackone, 15, 60, -1.0F, -14.6F, -4.5F, 1, 1, 0, 0.0F, false));
        this.blackone.cubeList.add(new ModelBox(this.blackone, 7, 59, -1.0F, -12.3F, -5.0F, 1, 1, 1, 0.0F, false));
        this.blackone.cubeList.add(new ModelBox(this.blackone, 3, 59, -1.0F, -13.9F, -5.0F, 1, 1, 1, 0.0F, false));
        this.blackone.cubeList.add(new ModelBox(this.blackone, 0, 59, -0.5F, -13.0F, -5.0F, 0, 1, 1, 0.0F, false));
        this.blackone.cubeList.add(new ModelBox(this.blackone, 12, 59, -0.5F, -14.6F, -5.0F, 0, 1, 1, 0.0F, false));
        this.blacktwo = new MModelRenderer(this);
        this.blacktwo.setRotationPoint(2.25F, -8.95F, 0.5F);
        this.blacktwo.cubeList.add(new ModelBox(this.blacktwo, 15, 60, -0.25F, -3.35F, 0.0F, 1, 1, 0, 0.0F, false));
        this.blacktwo.cubeList.add(new ModelBox(this.blacktwo, 7, 59, -0.25F, -1.05F, -0.5F, 1, 1, 1, 0.0F, false));
        this.blacktwo.cubeList.add(new ModelBox(this.blacktwo, 3, 59, -0.25F, -2.65F, -0.5F, 1, 1, 1, 0.0F, false));
        this.blacktwo.cubeList.add(new ModelBox(this.blacktwo, 0, 59, 0.25F, -1.75F, -0.5F, 0, 1, 1, 0.0F, false));
        this.blacktwo.cubeList.add(new ModelBox(this.blacktwo, 12, 59, 0.25F, -3.35F, -0.5F, 0, 1, 1, 0.0F, false));
        this.blackthree = new MModelRenderer(this);
        this.blackthree.setRotationPoint(3.0F, 2.3F, 5.0F);
        this.blackthree.cubeList.add(new ModelBox(this.blackthree, 15, 60, -1.0F, -14.6F, -6.5F, 1, 1, 0, 0.0F, false));
        this.blackthree.cubeList.add(new ModelBox(this.blackthree, 7, 59, -1.0F, -12.3F, -7.0F, 1, 1, 1, 0.0F, false));
        this.blackthree.cubeList.add(new ModelBox(this.blackthree, 3, 59, -1.0F, -13.9F, -7.0F, 1, 1, 1, 0.0F, false));
        this.blackthree.cubeList.add(new ModelBox(this.blackthree, 0, 59, -0.5F, -13.0F, -7.0F, 0, 1, 1, 0.0F, false));
        this.blackthree.cubeList.add(new ModelBox(this.blackthree, 12, 59, -0.5F, -14.6F, -7.0F, 0, 1, 1, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/chessboard.png"));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.2112F, 0.0F);
        super.renderAsItem(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
    }

    public String getName()
    {
        return "\u0428\u0430\u0445\u043c\u0430\u0442\u043d\u0430\u044f \u0434\u043e\u0441\u043a\u0430";
    }

    public String getCreator()
    {
        return "SteepyHARD";
    }
}
