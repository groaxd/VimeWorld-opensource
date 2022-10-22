package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class HollowKnightPet extends BasePet
{
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;

    public HollowKnightPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, 0.0F, 0.275F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.4572F, -5.4939F, 1.375F);
        this.setRotation(this.bone4, 0.0F, 0.0F, 1.0516F);
        this.bone5.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 16, 9, 0.6428F, -2.9311F, -0.275F, 1, 3, 1, -0.275F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 16, 0, -3.4072F, -2.9061F, -0.275F, 4, 2, 1, -0.425F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 31, 8, -5.5072F, -2.4061F, -0.275F, 3, 1, 1, -0.425F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 31, 8, -5.5072F, -2.2561F, -0.275F, 3, 1, 1, -0.425F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 31, 8, -4.5072F, -2.1061F, -0.275F, 2, 1, 1, -0.425F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 31, 8, -5.5072F, -2.5561F, -0.275F, 3, 1, 1, -0.425F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 31, 8, -4.5072F, -2.7061F, -0.275F, 2, 1, 1, -0.425F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 24, 0.101F, -1.4534F, -0.275F, 1, 6, 1, -0.3F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 22, 21, 1.2346F, -1.3034F, -0.275F, 1, 6, 1, -0.3F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 0.0F, -0.275F);
        this.bone5.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 26, 0, -1.0F, -6.875F, -1.075F, 2, 4, 1, -0.4F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 4, 24, -1.725F, -6.875F, -0.775F, 2, 4, 1, -0.4F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 12, 29, -1.9568F, -4.0969F, -0.894F, 2, 3, 1, -0.475F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 26, 25, -2.3273F, -4.1551F, -0.4684F, 2, 3, 1, -0.575F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 26, 21, -2.8668F, -4.2123F, -0.4407F, 2, 3, 1, -0.475F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 31, 18, -0.5306F, -4.2138F, -1.0168F, 2, 3, 1, -0.45F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 16, 24, -0.25F, -6.725F, -1.0F, 2, 4, 1, -0.4F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 9, 0.486F, -4.436F, -0.9735F, 1, 3, 1, -0.425F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 10, 0.611F, -3.686F, -0.9735F, 1, 2, 1, -0.425F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 31, 0.761F, -3.911F, -0.9735F, 1, 2, 1, -0.425F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 34, 0.886F, -3.336F, -0.9735F, 1, 1, 1, -0.425F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 28, 33, 0.886F, -3.486F, -0.9735F, 1, 1, 1, -0.425F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 16, 0.886F, -3.636F, -0.9735F, 1, 1, 1, -0.425F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 10, 24, 0.896F, -6.8942F, -0.6113F, 2, 4, 1, -0.4F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 22, 15, 0.2526F, -7.7938F, 0.2914F, 2, 5, 1, -0.4F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 3, 0.2988F, -3.1103F, 0.3074F, 2, 2, 1, -0.45F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 0, 0.2988F, -3.9853F, 0.3074F, 2, 2, 1, -0.45F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 20, 9, -0.6862F, -7.8644F, 1.0026F, 2, 5, 1, -0.4F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 26, 9, -0.3946F, -4.0968F, 0.8494F, 2, 3, 1, -0.45F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 26, 5, -1.5652F, -4.1259F, 0.8999F, 2, 3, 1, -0.45F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 31, 31, -2.1308F, -4.0698F, 0.5F, 2, 2, 1, -0.45F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 31, 28, -2.1308F, -3.0198F, 0.5F, 2, 2, 1, -0.45F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 20, 3, -1.6967F, -7.7467F, 1.0844F, 2, 5, 1, -0.4F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 16, 18, -2.1787F, -7.764F, 0.4457F, 2, 5, 1, -0.4F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 8, 29, -2.9426F, -7.7434F, -0.7911F, 1, 5, 1, -0.4F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 4, 29, -2.7426F, -7.7434F, -0.7911F, 1, 5, 1, -0.4F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 21, 28, -2.5676F, -7.7434F, -0.7911F, 1, 5, 1, -0.4F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 28, 13, -2.3676F, -7.2434F, -0.7911F, 1, 5, 1, -0.4F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 25, 29, 0.7863F, -4.3718F, -0.382F, 2, 3, 1, -0.45F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone5.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 9, -3.0F, -11.425F, -1.8F, 6, 5, 4, -0.025F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -3.0F, -11.425F, -1.8F, 6, 5, 4, 0.025F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 32, 25, 2.2F, -12.8F, -1.175F, 1, 2, 1, 0.05F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 17, 32, 2.6296F, -14.5276F, -1.175F, 1, 2, 1, 0.025F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 32, 13, -3.6296F, -14.5276F, -1.175F, 1, 2, 1, 0.025F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 15, 35, -3.4636F, -15.1453F, -1.175F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 35, 12, 2.4636F, -15.1453F, -1.175F, 1, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 7, 35, 2.7136F, -15.6203F, -1.175F, 1, 1, 1, -0.2F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 3, 35, -3.7136F, -15.6203F, -1.175F, 1, 1, 1, -0.2F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 31, 34, -3.1386F, -15.6203F, -1.175F, 1, 1, 1, -0.3F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 20, 34, 2.1386F, -15.6203F, -1.175F, 1, 1, 1, -0.3F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 32, 22, -3.2F, -12.8F, -1.175F, 1, 2, 1, 0.05F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, -0.275F);
        this.bone5.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 8, 18, -1.5F, -6.625F, 0.025F, 3, 5, 1, -0.25F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 18, -1.5F, -6.625F, -0.475F, 3, 5, 1, -0.25F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 36, -1.25F, -2.4F, -0.275F, 1, 1, 1, -0.1F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 27, 35, -0.9648F, -2.4154F, -0.275F, 1, 1, 1, -0.15F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 35, 15, -1.1148F, -2.8904F, -0.275F, 1, 1, 1, -0.15F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 35, 24, -0.0352F, -2.4154F, -0.275F, 1, 1, 1, -0.15F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 34, 35, 0.25F, -2.4F, -0.275F, 1, 1, 1, -0.1F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 12, 33, -1.375F, -2.4F, -0.275F, 1, 2, 1, -0.1F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 24, 33, 0.375F, -2.4F, -0.275F, 1, 2, 1, -0.1F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/hollowknightpet.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.translate(0.6D, -0.2D, 0.0D);
        double d0 = (double)MathHelper.sin(time * 0.1F) * 0.03D;
        GlStateManager.translate(0.0D, d0, 0.0D);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.1D, 0.0D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u043e\u043b\u044b\u0439 \u0440\u044b\u0446\u0430\u0440\u044c";
    }

    public String getCreator()
    {
        return "GUllT";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Hollow Knight");
    }
}
