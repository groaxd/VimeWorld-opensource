package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BabyYodaPet extends BasePet
{
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone8;
    private final MModelRenderer bone6;
    private final MModelRenderer bone9;
    private final MModelRenderer bone7;

    public BabyYodaPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.useDisplayLists = true;
        this.bone = new MModelRenderer(this);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -5.0F, -4.0F, -2.0F, 10, 4, 8, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 12, -5.0F, -10.0F, -2.0F, 10, 3, 8, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.setRotation(this.bone2, -0.0698F, 0.0F, -0.0349F);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 15, 1.7F, -13.5F, -2.2F, 2, 2, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 12, -2.3F, -13.5F, -2.2F, 2, 2, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 24, 28, -3.3F, -14.6F, -2.0F, 8, 5, 6, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.setRotation(this.bone3, 0.0F, 0.0F, -0.1396F);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 24, 24, -8.3F, -14.4F, 1.7F, 8, 1, 0, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 24, 25, -6.3F, -13.4F, 2.0F, 6, 1, 0, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 18, -3.3F, -12.4F, 2.0F, 3, 1, 0, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.75F, 0.0F, 0.0F);
        this.setRotation(this.bone4, 0.0F, 0.0F, 0.0873F);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 24, 24, 1.7F, -14.4F, 1.7F, 8, 1, 0, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 24, 26, 1.7F, -13.4F, 2.0F, 6, 1, 0, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 19, 1.7F, -12.4F, 2.0F, 3, 1, 0, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(5.0F, -1.5F, 0.0F);
        this.setRotation(this.bone5, 0.0F, 0.0F, -0.2618F);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 28, 0, -11.0F, -9.0F, 0.0F, 5, 4, 4, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(1.3542F, -1.1901F, 0.0F);
        this.setRotation(this.bone8, 0.0F, 0.0F, -0.1222F);
        this.bone5.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 0, 0, -13.0F, -8.0F, 1.0F, 2, 2, 2, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-4.0F, -1.25F, 0.0F);
        this.setRotation(this.bone6, 0.0F, 0.0F, 0.2618F);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 28, 12, 5.0F, -9.0F, 0.0F, 5, 4, 4, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-1.3542F, -1.1901F, 0.0F);
        this.setRotation(this.bone9, 0.0F, 0.0F, 0.1222F);
        this.bone6.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 4, 10.0F, -8.0F, 1.0F, 2, 2, 2, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.setRotation(this.bone7, 0.0F, 0.0F, -0.0698F);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 23, -4.15F, -8.05F, -1.25F, 9, 5, 6, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "pets/baby_yoda_pet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
        GlStateManager.translate(0.87F, -0.2F + f, 0.3F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.25F, -0.05F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041c\u0430\u043b\u044b\u0448 \u0419\u043e\u0434\u0430";
    }

    public String getCreator()
    {
        return "Wenston";
    }
}
