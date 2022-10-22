package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BeaverHat extends BaseHelm
{
    private final MModelRenderer beaver;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone;

    public BeaverHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.beaver = new MModelRenderer(this);
        this.beaver.cubeList.add(new ModelBox(this.beaver, 0, 11, 3.5F, -13.6F, 0.0F, 2, 2, 1, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 8, 0, 3.0F, -9.0F, -5.0F, 1, 1, 9, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 8, 0, -4.0F, -9.0F, -5.0F, 1, 1, 9, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 5, 5, -3.0F, -9.0F, 3.0F, 6, 1, 1, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 5, 4, -3.0F, -9.0F, -5.0F, 6, 1, 2, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 9, 3, -1.1022F, -9.0F, -5.7765F, 2, 1, 1, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 9, 3, 0.1022F, -9.0F, -5.7765F, 1, 1, 1, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 0, 0, -0.5F, -9.7F, -6.45F, 1, 1, 1, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 4, 4, -4.0F, -11.0F, -3.5F, 8, 2, 1, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 4, 4, -4.0F, -11.0F, 3.0F, 8, 2, 1, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 11, 2, 3.0F, -11.0F, -2.5F, 1, 2, 6, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 11, 2, -4.0F, -11.0F, -2.5F, 1, 2, 6, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 0, 0, -4.0F, -12.5867F, -2.2825F, 8, 2, 5, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 3, 3, -4.0F, -12.5867F, 2.0F, 8, 2, 2, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 0, 2, -1.0F, -8.0F, -5.5F, 1, 1, 1, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 0, 2, -1.0F, -7.6F, -5.5F, 1, 1, 1, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 0, 2, 0.1F, -8.0F, -5.5F, 1, 1, 1, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 0, 2, 0.1F, -7.6F, -5.5F, 1, 1, 1, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 0, 9, -3.5F, -11.3F, -3.8F, 3, 1, 1, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 0, 7, 0.5F, -11.3F, -3.8F, 3, 1, 1, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 11, 14, 1.0F, -10.3F, -3.7F, 2, 1, 1, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 0, 14, -3.0F, -10.3F, -3.7F, 2, 1, 1, 0.0F, false));
        this.beaver.cubeList.add(new ModelBox(this.beaver, 11, 11, -5.4F, -13.6F, 0.0F, 2, 2, 1, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, -2.0F, -2.0F);
        this.setRotation(this.bone2, 0.0F, -0.2618F, 0.0F);
        this.beaver.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 8, 3, 0.0872F, -7.0F, -3.9331F, 3, 1, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, -2.0F, -2.0F);
        this.setRotation(this.bone3, 0.0F, 0.2618F, 0.0F);
        this.beaver.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 8, 4, -3.0872F, -7.0F, -3.9331F, 3, 1, 1, 0.0F, true));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -5.0F, -10.0F);
        this.setRotation(this.bone, 0.9163F, 0.0F, 0.0F);
        this.beaver.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 3, 4, -4.0F, 1.5042F, 8.7171F, 8, 1, 2, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "head/beaver_hat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.2F, 1.2F, 1.3F);
        GlStateManager.translate(0.0F, 0.27F, -0.03F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.22F, 0.05F);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u043b\u044f\u043f\u0430 \u0411\u043e\u0431\u0440\u0430";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }
}
