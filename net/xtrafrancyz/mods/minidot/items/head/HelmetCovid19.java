package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HelmetCovid19 extends BaseHelm
{
    private final MModelRenderer head;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer bone13;
    private final MModelRenderer bone14;
    private final MModelRenderer bone15;
    private final MModelRenderer bone16;
    private final MModelRenderer bone17;

    public HelmetCovid19()
    {
        super(ItemType.HEAD);
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.useDisplayLists = true;
        this.head = new MModelRenderer(this);
        this.bone2 = new MModelRenderer(this);
        this.head.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -4.0F, -13.0F, -2.0F, 8, 1, 6, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 46, 0, -4.8452F, -11.1874F, -3.0F, 1, 7, 8, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 16, 50, -3.0F, -12.0F, 4.8F, 6, 8, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 28, 0, 3.8452F, -11.1874F, -3.0F, 1, 7, 8, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone2.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 57, 63, 3.4F, -11.2F, 4.4F, 1, 7, 0, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 14, 101, 3.6F, -10.2F, 4.6F, 1, 5, 0, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 14, 101, -4.6F, -10.2F, 4.6F, 1, 5, 0, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 28, 55, -4.4F, -11.2F, 4.4F, 1, 7, 0, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 28, 97, 3.3F, -12.2F, -3.0F, 1, 1, 2, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 28, 94, -4.3F, -12.2F, -3.0F, 1, 1, 2, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 22, 97, -4.2F, -12.2F, 2.89F, 1, 1, 2, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 22, 94, 3.2F, -12.2F, 2.89F, 1, 1, 2, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 56, 15, 4.2F, -10.7F, -2.41F, 1, 6, 7, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 40, 15, -5.2F, -10.7F, -2.41F, 1, 6, 7, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 14, 39, -3.0F, -13.3F, -1.0F, 6, 1, 4, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 52, 63, -2.0F, -11.4F, 5.1F, 4, 7, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 71, -2.0F, -11.0F, 5.2F, 4, 6, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 16, 106, -4.1381F, -4.4803F, -3.99F, 1, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 12, 106, 3.1381F, -4.4803F, -4.001F, 1, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 89, -3.2F, -4.05F, -4.0F, 3, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 87, 0.2F, -4.05F, -4.0F, 3, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 34, 59, -4.0F, -12.0F, -4.0F, 8, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 34, 76, -2.5F, -3.85F, -4.001F, 5, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 87, -1.5F, -4.4929F, -4.2929F, 3, 2, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 20, 78, 3.8452F, -11.1874F, -4.0F, 1, 7, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 12, 87, 3.8451F, -10.6874F, -4.1F, 1, 6, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 16, 78, -4.8452F, -11.1874F, -4.0F, 1, 7, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 8, 87, -4.8453F, -10.6874F, -4.1F, 1, 6, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 20, 87, -4.8453F, -10.1874F, -4.3F, 1, 5, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 16, 87, 3.8547F, -10.1874F, -4.3F, 1, 5, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 28, 87, -4.9452F, -10.2F, -3.999F, 1, 5, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 24, 87, 3.9548F, -10.2F, -3.899F, 1, 5, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 18, 94, 4.1548F, -9.7F, -3.899F, 1, 4, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 10, 94, 3.9548F, -9.7F, -4.199F, 1, 4, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 14, 94, -5.1452F, -9.7F, -3.999F, 1, 4, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 6, 94, -4.9452F, -9.7F, -4.199F, 1, 4, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 36, 69, -3.6F, -11.999F, -4.1F, 7, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 10, 71, -3.1F, -12.1F, -4.4F, 6, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 39, -5.4F, -10.1F, -1.9F, 1, 5, 6, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 54, 28, 4.4F, -10.1F, -1.9F, 1, 5, 6, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 18, 59, -2.6F, -13.4F, -0.6F, 5, 1, 3, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 8, 78, -1.0F, -5.2F, -5.0F, 2, 2, 2, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 94, -1.55F, -4.9F, -4.7F, 1, 1, 2, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 24, 101, -1.25F, -5.1F, -4.3F, 1, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 36, 28, -3.9999F, -11.0001F, -3.9F, 8, 7, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 16, 101, -0.45F, -5.4F, -4.0F, 1, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 20, 103, 0.15F, -5.1F, -4.3F, 1, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 20, 101, 0.25F, -3.9F, -4.6F, 1, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 16, 103, -1.25F, -3.9F, -4.6F, 1, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 91, 0.6F, -4.9F, -4.6F, 1, 1, 2, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 106, -0.7F, -4.901F, -5.2001F, 1, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 103, -0.3F, -4.91F, -5.2011F, 1, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 101, -0.3F, -4.51F, -5.211F, 1, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 28, 103, -0.7F, -4.501F, -5.21F, 1, 1, 1, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.setRotation(this.bone5, -1.0472F, 0.0F, 0.0F);
        this.head.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 59, -4.0F, -4.7679F, -12.2583F, 8, 2, 1, 0.0F, false));
        this.bone5.cubeList.add(new ModelBox(this.bone5, 52, 59, -3.5F, -4.7679F, -12.3583F, 7, 2, 1, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.setRotation(this.bone4, 0.0F, 0.0F, 0.7854F);
        this.head.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 50, -0.6464F, -7.0004F, -2.41F, 1, 1, 7, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 50, -7.0104F, -0.6364F, -2.41F, 1, 1, 7, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-3.0F, 0.0F, 0.0F);
        this.setRotation(this.bone6, 0.0F, 0.0F, 0.4363F);
        this.head.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 44, 50, -6.4003F, -11.3594F, -2.0F, 1, 2, 6, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 36, 63, -6.4831F, -10.6594F, -1.6001F, 1, 1, 5, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 24, 63, -6.4731F, -11.0594F, -1.6F, 1, 1, 5, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.setRotation(this.bone7, 0.0F, 0.0F, -0.4363F);
        this.head.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 63, 8.2192F, -9.6915F, -1.501F, 1, 1, 5, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 12, 63, 8.2195F, -9.3915F, -1.5F, 1, 1, 5, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 30, 50, 8.1193F, -10.0915F, -2.0F, 1, 2, 6, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.setRotation(this.bone8, 1.0472F, 0.0F, 0.0F);
        this.head.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 58, 50, -4.0F, -3.0359F, 12.2583F, 8, 2, 1, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.setRotation(this.bone9, 0.0F, 0.0F, 0.7854F);
        this.head.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 15, -0.5348F, -6.387F, -4.001F, 1, 1, 9, 0.0F, false));
        this.bone9.cubeList.add(new ModelBox(this.bone9, 18, 28, -0.4641F, -6.4577F, -3.5F, 1, 1, 8, 0.0F, false));
        this.bone9.cubeList.add(new ModelBox(this.bone9, 20, 15, -6.387F, -0.5348F, -4.0F, 1, 1, 9, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.setRotation(this.bone10, 0.0F, 0.0F, 0.7854F);
        this.head.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 20, 106, -5.4846F, -11.3368F, 4.0F, 1, 1, 1, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 38, 94, -5.4846F, -11.3368F, -4.0F, 1, 1, 2, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 28, 101, -0.949F, -5.387F, -4.001F, 1, 1, 1, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 6, 101, -11.3368F, -5.4846F, -4.0F, 1, 1, 2, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 0, 101, -11.3368F, -5.4846F, 3.0F, 1, 1, 2, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 24, 103, -2.1213F, -4.3841F, -4.2F, 1, 1, 1, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 34, 71, -11.5258F, -7.2832F, -1.0F, 1, 1, 4, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 24, 71, -7.2832F, -11.5258F, -1.0F, 1, 1, 4, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 8, 106, -5.387F, -0.949F, -3.99F, 1, 1, 1, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 50, 39, -4.8891F, -11.243F, -2.41F, 1, 1, 7, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 50, 39, -11.253F, -4.879F, -2.41F, 1, 1, 7, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 4, 106, -4.4194F, -2.086F, -4.2F, 1, 1, 1, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 0, 28, -6.387F, -0.3934F, -3.3F, 1, 1, 8, 0.0F, false));
        this.bone11 = new MModelRenderer(this);
        this.setRotation(this.bone11, 0.7854F, 0.0F, 0.0F);
        this.head.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 6, 104, -1.0F, -5.7983F, -1.2728F, 2, 1, 1, 0.0F, false));
        this.bone11.cubeList.add(new ModelBox(this.bone11, 10, 75, -3.0F, -7.2832F, 10.5258F, 6, 1, 1, 0.0F, false));
        this.bone12 = new MModelRenderer(this);
        this.setRotation(this.bone12, -0.7854F, 0.0F, 0.0F);
        this.head.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 10, 73, -3.0F, -8.6974F, -10.1116F, 6, 1, 1, 0.0F, false));
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.setRotation(this.bone13, 0.7854F, 0.0F, 0.0F);
        this.head.addChild(this.bone13);
        this.bone13.cubeList.add(new ModelBox(this.bone13, 34, 61, -4.0F, -6.7983F, 13.0007F, 8, 1, 1, 0.0F, false));
        this.bone14 = new MModelRenderer(this);
        this.setRotation(this.bone14, 0.0F, -0.1745F, 0.0F);
        this.head.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 0, 78, -2.9473F, -12.0F, 5.2328F, 1, 8, 1, 0.0F, false));
        this.bone15 = new MModelRenderer(this);
        this.setRotation(this.bone15, 0.0F, 0.1745F, 0.0F);
        this.head.addChild(this.bone15);
        this.bone15.cubeList.add(new ModelBox(this.bone15, 4, 78, 1.9473F, -12.0F, 5.2328F, 1, 8, 1, 0.0F, false));
        this.bone16 = new MModelRenderer(this);
        this.setRotation(this.bone16, 0.0F, 0.7854F, 0.0F);
        this.head.addChild(this.bone16);
        this.bone16.cubeList.add(new ModelBox(this.bone16, 38, 78, -2.9698F, -11.4F, 4.7983F, 1, 7, 1, 0.0F, false));
        this.bone16.cubeList.add(new ModelBox(this.bone16, 34, 78, -5.7983F, -11.4F, 1.9698F, 1, 7, 1, 0.0F, false));
        this.bone17 = new MModelRenderer(this);
        this.setRotation(this.bone17, 0.7854F, 0.0F, 0.0F);
        this.head.addChild(this.bone17);
        this.bone17.cubeList.add(new ModelBox(this.bone17, 24, 80, -2.0F, 0.2021F, 6.4246F, 4, 1, 1, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "head/helmet_covid19.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        GlStateManager.translate(0.0F, 0.255F, -0.05F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.15F, -0.05F);
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u0442\u0430\u0440\u0430\u044f \u0417\u0430\u0449\u0438\u0442\u043d\u0430\u044f \u041c\u0430\u0441\u043a\u0430";
    }

    public String getCreator()
    {
        return "WeinElite";
    }
}
