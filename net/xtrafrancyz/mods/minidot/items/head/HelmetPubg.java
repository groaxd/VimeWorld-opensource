package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class HelmetPubg extends BaseHelm
{
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;

    public HelmetPubg()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bone3 = new MModelRenderer(this);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-3.5F, -4.0F, -4.0F);
        this.bone3.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 25, 7.0F, -4.0F, 0.0F, 1, 4, 8, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 36, 7.2F, 0.0F, 2.0F, 1, 1, 6, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 30, 33, -1.2F, 0.0F, 2.0F, 1, 1, 6, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 38, -1.2F, -0.5F, 1.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 12, 37, 7.2F, -0.5F, 1.5F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 10, 25, -0.5F, -4.0F, 7.5F, 8, 4, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 10, 30, -0.5F, 0.0F, 7.7F, 8, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 28, 6.9F, 0.0F, 7.4F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 4, 16, -0.9F, 0.0F, 7.4F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 34, 13, -0.5F, -4.0F, -0.5F, 8, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 16, -0.5F, -4.4F, 0.0F, 8, 1, 8, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 24, 0, -0.5F, -5.0F, 1.0F, 8, 1, 6, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 24, 24, 0.5F, -5.0F, 0.0F, 6, 1, 8, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 24, 8, -1.0F, -4.0F, 0.0F, 1, 4, 8, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(4.0F, -0.5F, -13.1F);
        this.setRotation(this.bone, -0.0873F, 0.0F, 0.0F);
        this.bone3.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 34, 10, -8.0F, -7.2161F, 7.9011F, 8, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 34, 10, -8.0F, -7.0169F, 7.9186F, 8, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 4, 25, -1.0F, -5.2161F, 7.9011F, 1, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 34, 7, -7.0F, -2.2161F, 7.9011F, 6, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 34, 7, -1.0F, -3.2161F, 7.9011F, 1, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 34, 7, -8.0F, -3.2161F, 7.9011F, 1, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 4, 0, -8.51F, -7.2422F, 8.2F, 1, 6, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 4, 21, -8.71F, -7.2211F, 9.1053F, 1, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 21, -0.31F, -7.2211F, 9.1053F, 1, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 38, 33, -8.01F, -1.246F, 8.2872F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 24, 38, -0.99F, -1.246F, 8.2872F, 1, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -0.49F, -7.2422F, 8.2F, 1, 6, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 20, 36, -7.0F, -1.2161F, 7.9011F, 6, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 39, -7.0F, -0.7441F, 8.2436F, 6, 1, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 25, -8.0F, -5.2161F, 7.9011F, 1, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 16, -7.7F, -5.1188F, 6.6622F, 1, 3, 2, -0.25F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 18, 33, -7.5F, -5.3188F, 6.6622F, 7, 1, 2, -0.25F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 24, 20, -7.5F, -2.9188F, 6.6622F, 7, 1, 2, -0.25F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 24, 0, -1.3F, -5.1188F, 6.6622F, 1, 3, 2, -0.25F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 28, 30, -1.1F, -4.8585F, 6.9822F, 1, 1, 1, -0.25F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 28, 25, -7.9F, -4.8585F, 6.9822F, 1, 1, 1, -0.25F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 28, 28, -9.1F, -7.0514F, 9.0992F, 1, 1, 1, -0.25F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 4, 28, 0.1F, -7.0514F, 9.0992F, 1, 1, 1, -0.25F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 4, 30, -1.1F, -3.4551F, 7.0046F, 1, 1, 1, -0.25F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 30, -7.9F, -3.4551F, 7.0046F, 1, 1, 1, -0.25F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 37, -7.0F, -4.6188F, 7.1622F, 6, 2, 0, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "head/helmet_pubg.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.1F, 1.1F, 1.1F);
        GlStateManager.translate(0.0F, 0.01F, 0.01F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        GlStateManager.translate(0.0F, -0.03F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u043b\u0435\u043c \u0441\u0432\u0430\u0440\u0449\u0438\u043a\u0430";
    }

    public String getCreator()
    {
        return "Veltorn";
    }
}
