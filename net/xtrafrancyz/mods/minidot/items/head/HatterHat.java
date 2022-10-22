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

public class HatterHat extends BaseItem
{
    private final MModelRenderer bone4;
    private final MModelRenderer Back;
    private final MModelRenderer bone3;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer Osnova;
    private final MModelRenderer Karta;

    public HatterHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.Back = new MModelRenderer(this);
        this.bone4.addChild(this.Back);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.5F, -4.1F, -3.5F);
        this.setRotation(this.bone3, -0.3491F, 0.2618F, 0.0F);
        this.Back.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 5, 57, -3.85F, -9.81F, 8.5342F, 1, 1, 2, -0.25F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-3.0F, -1.0F, -0.4F);
        this.setRotation(this.bone, -0.3491F, 0.0F, 0.0F);
        this.Back.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 5, 57, 1.875F, -11.8F, 4.9917F, 1, 1, 3, -0.25F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 5, 57, 3.125F, -11.8F, 4.9917F, 1, 1, 3, -0.25F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(6.1F, -4.1F, -1.8F);
        this.setRotation(this.bone2, -0.3491F, -0.2618F, 0.0F);
        this.Back.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 5, 57, -4.0F, -9.81F, 8.5342F, 1, 1, 2, -0.25F, false));
        this.Osnova = new MModelRenderer(this);
        this.Osnova.setRotationPoint(0.5F, -4.1F, -3.5F);
        this.bone4.addChild(this.Osnova);
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 5, 57, -1.625F, -5.15F, 13.5F, 1, 4, 1, -0.1F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 0, 18, 3.5F, -4.9F, 4.5F, 1, 1, 8, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 16, 16, -5.5F, -4.9F, 4.5F, 1, 1, 8, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 30, 17, -6.0F, -5.15F, 5.5F, 1, 1, 6, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 24, 46, -5.0F, -5.15F, 4.0F, 1, 1, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 20, 46, 3.0F, -5.15F, 4.0F, 1, 1, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 8, 46, 4.75F, -5.65F, 5.75F, 1, 1, 1, -0.25F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 44, 27, -6.5F, -5.65F, 5.75F, 1, 1, 1, -0.25F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 45, 41, 4.75F, -5.65F, 10.25F, 1, 1, 1, -0.25F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 44, 29, -6.5F, -5.65F, 10.25F, 1, 1, 1, -0.25F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 16, 46, 3.0F, -5.15F, 12.0F, 1, 1, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 12, 46, -5.0F, -5.15F, 12.0F, 1, 1, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 26, 0, 4.25F, -5.15F, 5.5F, 1, 1, 6, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 0, 39, 4.75F, -5.9F, 6.5F, 1, 1, 4, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 38, 28, -6.5F, -5.9F, 6.5F, 1, 1, 4, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 36, 33, -3.5F, -5.15F, 3.0F, 6, 1, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 36, 14, -3.5F, -5.15F, 13.0F, 6, 1, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 0, 0, -4.5F, -4.9F, 3.5F, 8, 1, 10, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 0, 11, -3.5F, -13.65F, 5.5F, 6, 1, 6, -0.25F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 32, 11, -3.5F, -13.65F, 4.5F, 6, 1, 2, -0.25F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 26, 7, -3.5F, -13.65F, 10.5F, 6, 1, 2, -0.25F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 22, 26, 1.5F, -13.65F, 5.5F, 2, 1, 6, -0.25F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 44, 8, 2.0F, -13.65F, 5.0F, 1, 1, 1, -0.25F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 22, 14, -4.0F, -13.65F, 5.0F, 1, 1, 1, -0.25F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 36, 35, 2.0F, -13.65F, 11.0F, 1, 1, 1, -0.25F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 10, 24, -4.0F, -13.65F, 11.0F, 1, 1, 1, -0.25F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 12, 25, -4.5F, -13.65F, 5.5F, 2, 1, 6, -0.25F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 0, 27, 1.5F, -12.9F, 6.5F, 1, 8, 4, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 42, 42, 1.0F, -12.9F, 6.0F, 1, 8, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 30, 39, 1.0F, -12.9F, 10.0F, 1, 8, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 38, 42, -3.0F, -12.9F, 6.0F, 1, 8, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 34, 42, -3.0F, -12.9F, 10.0F, 1, 8, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 26, 11, -3.5F, -12.9F, 6.5F, 1, 8, 4, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 32, 53, -2.5F, -12.9F, 5.5F, 4, 8, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 20, 41, -2.5F, -12.9F, 5.0F, 4, 4, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 42, 35, -2.5F, -9.65F, 5.17F, 4, 1, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 6, 27, -2.5F, -6.65F, 5.17F, 4, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 30, 33, 1.83F, -6.65F, 6.5F, 1, 2, 4, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 10, 18, -3.83F, -6.65F, 6.5F, 1, 2, 4, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 18, 11, -2.5F, -6.65F, 10.83F, 4, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 38, 16, 1.83F, -9.65F, 6.5F, 1, 1, 4, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 38, 6, -3.83F, -9.65F, 6.5F, 1, 1, 4, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 40, 0, -2.5F, -12.9F, 4.75F, 4, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 36, 36, 2.25F, -12.9F, 6.5F, 1, 2, 4, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 34, 0, -4.25F, -12.9F, 6.5F, 1, 2, 4, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 38, 24, -2.5F, -12.9F, 11.25F, 4, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 44, 16, -3.25F, -12.9F, 10.75F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 30, 33, 1.25F, -12.9F, 10.75F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 35, 56, -3.25F, -12.9F, 5.25F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 34, 0, 1.25F, -12.9F, 5.25F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 42, 37, -3.75F, -12.9F, 10.25F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 26, 33, 1.75F, -12.9F, 10.25F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 35, 57, -3.75F, -12.9F, 5.75F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 38, 16, 1.75F, -12.9F, 5.75F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 38, 21, -2.5F, -9.65F, 10.81F, 4, 1, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 44, 3, -3.0F, -12.9F, 5.5F, 1, 4, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 16, 18, -3.0F, -6.65F, 5.5F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 32, 55, 1.0F, -12.9F, 5.5F, 1, 4, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 32, 25, 1.0F, -6.65F, 5.5F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 0, 44, -3.0F, -12.9F, 10.5F, 1, 4, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 18, 14, -3.0F, -6.65F, 10.5F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 20, 18, 1.0F, -12.9F, 10.5F, 1, 4, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 0, 27, 1.0F, -6.65F, 10.5F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 33, 55, -3.5F, -12.9F, 6.0F, 1, 4, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 10, 18, -3.5F, -6.65F, 6.0F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 31, 55, 1.5F, -12.9F, 6.0F, 1, 4, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 20, 33, 1.5F, -6.65F, 6.0F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 26, 0, -3.5F, -12.9F, 10.0F, 1, 4, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 0, 23, -3.5F, -6.65F, 10.0F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 22, 25, 1.5F, -12.9F, 10.0F, 1, 4, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 4, 23, 1.5F, -6.65F, 10.0F, 1, 2, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 10, 41, -2.5F, -12.9F, 11.0F, 4, 4, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 20, 33, 2.0F, -12.9F, 6.5F, 1, 4, 4, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 32, 24, -4.0F, -12.9F, 6.5F, 1, 4, 4, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 0, 0, -2.5F, -12.9F, 10.5F, 4, 8, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 5, 57, -1.625F, -6.9F, 11.0F, 1, 1, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 5, 57, -0.375F, -6.9F, 11.0F, 1, 1, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 5, 57, -1.5F, -6.4F, 11.0F, 2, 1, 1, 0.0F, false));
        this.Osnova.cubeList.add(new ModelBox(this.Osnova, 5, 57, -0.375F, -5.15F, 13.5F, 1, 4, 1, -0.1F, false));
        this.Karta = new MModelRenderer(this);
        this.Karta.setRotationPoint(0.1F, -4.0F, -2.9F);
        this.setRotation(this.Karta, -0.2618F, 0.0F, 0.3491F);
        this.bone4.addChild(this.Karta);
        this.Karta.cubeList.add(new ModelBox(this.Karta, 0, 11, -0.0243F, -11.664F, 4.634F, 1, 3, 2, -0.25F, false));
        this.setTexture(new ResourceLocation("minidot", "head/hatter_hat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.75F, 0.75F, 0.75F);
        GlStateManager.translate(0.0F, 0.4F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u043b\u044f\u043f\u0430 \u0411\u043e\u043b\u0432\u0430\u043d\u0449\u0438\u043a\u0430";
    }

    public String getCreator()
    {
        return "Veltorn";
    }
}
