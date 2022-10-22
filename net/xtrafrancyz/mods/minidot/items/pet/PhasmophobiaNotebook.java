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

public class PhasmophobiaNotebook extends BasePet
{
    private final MModelRenderer bone10;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final MModelRenderer bone6;
    private final MModelRenderer bone3;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;

    public PhasmophobiaNotebook()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.bone10 = new MModelRenderer(this);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 8, 45, 4.0F, -16.0F, 0.0F, 1, 1, 5, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 40, 16, -1.0F, -16.0F, -1.0F, 6, 1, 1, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 0, 0, -8.0F, -22.95F, 0.0F, 12, 20, 4, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 0, 45, -8.501F, -23.0F, 0.6F, 1, 20, 3, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 0, 24, -8.5F, -23.0F, -0.1F, 13, 20, 1, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 28, 24, -8.5F, -23.0F, 3.1F, 13, 20, 1, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-5.5F, -18.75F, 3.25F);
        this.bone10.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 28, 2, -3.5F, 2.75F, 0.75F, 14, 1, 1, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-3.5F, 2.75F, -1.25F);
        this.setRotation(this.bone8, -0.0887F, 0.1296F, -0.0191F);
        this.bone7.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 32, 15, -0.4F, -0.5F, -3.1F, 1, 1, 6, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-3.5F, -3.25F, -1.25F);
        this.setRotation(this.bone9, -0.1752F, -0.0859F, 0.0152F);
        this.bone7.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 32, 8, -0.5F, -0.5F, -3.0F, 1, 1, 6, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-1.0F, -16.0F, -1.0F);
        this.setRotation(this.bone5, 0.2847F, -0.0719F, 0.6194F);
        this.bone10.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 15, 45, -1.0F, -1.0F, -0.7F, 3, 2, 2, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-3.5F, -18.5F, -0.5F);
        this.setRotation(this.bone4, 0.0F, 0.0F, 0.6545F);
        this.bone10.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 32, 4, -6.5F, -0.5F, -0.5F, 9, 1, 1, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(1.5F, 0.0F, 5.0F);
        this.setRotation(this.bone6, 0.0019F, 0.0436F, -0.0977F);
        this.bone4.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 28, 0, -8.0F, -0.5F, -0.5F, 16, 1, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(3.5F, -12.5F, -0.5F);
        this.setRotation(this.bone3, 0.2163F, -0.1293F, 0.7135F);
        this.bone10.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 32, 22, -5.5F, -0.5F, -0.5F, 7, 1, 1, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(-5.1222F, -15.9638F, 0.017F);
        this.setRotation(this.bone2, 0.251F, 0.0164F, 0.1188F);
        this.bone10.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 32, 6, -4.0F, -0.5F, -1.017F, 9, 1, 1, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(4.5F, -12.5F, 2.0F);
        this.setRotation(this.bone, 0.3491F, 0.0F, 0.0F);
        this.bone10.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 40, 9, -0.5F, -0.5F, -3.02F, 1, 1, 6, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/phasmophobianotebook.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.04F;
        GlStateManager.translate(0.7F, -0.1F + f, 0.2F);
        double d0 = 0.8D;
        GlStateManager.scale(d0, d0, d0);
        super.preRender(modelPlayer, player, time, pi);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.2F, 0.4F, 0.0F);
        double d0 = 0.8D;
        GlStateManager.scale(d0, d0, d0);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0411\u043b\u043e\u043a\u043d\u043e\u0442";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Phasmophobia");
    }

    public String getCreator()
    {
        return "FyeRon";
    }
}
