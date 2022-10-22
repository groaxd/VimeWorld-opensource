package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Katana extends BaseItem
{
    private final MModelRenderer bone4;
    private final MModelRenderer bone3;
    private final MModelRenderer bone5;
    private final MModelRenderer bone2;
    private final MModelRenderer bone;
    private final MModelRenderer bone7;
    private final MModelRenderer bone9;
    private final MModelRenderer bone6;
    private final MModelRenderer bone8;
    private final MModelRenderer bone10;

    public Katana()
    {
        super(ItemType.BODY);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, -2.0F, 11.0F);
        this.setRotation(this.bone4, 0.4363F, 0.0F, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.setRotation(this.bone3, 0.3054F, 0.0F, 0.0F);
        this.bone4.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 0, -1.0F, -42.1973F, -5.8535F, 1, 13, 2, 0.0F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(-5.75F, 0.0F, -2.25F);
        this.setRotation(this.bone5, 0.0F, -0.7854F, 0.0F);
        this.bone3.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 0, 18, -0.2164F, -30.1973F, -7.5923F, 4, 1, 4, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.setRotation(this.bone2, 0.3491F, 0.0F, 0.0F);
        this.bone4.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 6, 0, -1.0F, -29.4248F, -4.5743F, 1, 16, 2, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.setRotation(this.bone, 0.48F, 0.0F, 0.0F);
        this.bone4.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 12, 0, -1.0F, -13.907F, -2.7829F, 1, 18, 2, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(-0.05F, 3.0F, -10.2F);
        this.setRotation(this.bone7, -0.4363F, 0.0F, 0.0F);
        this.bone4.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 4, 0, -1.0F, -22.0F, -8.0F, 1, 1, 1, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 4, 0, -1.0F, -21.0F, -7.0F, 1, 1, 1, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 4, 0, -1.0F, -20.0F, -6.0F, 1, 1, 1, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 4, 0, -1.0F, -19.0F, -5.0F, 1, 1, 1, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 4, 0, -1.0F, -23.0F, -9.0F, 1, 1, 1, 0.0F, false));
        this.bone7.cubeList.add(new ModelBox(this.bone7, 4, 0, -1.0F, -24.0F, -10.0F, 1, 1, 1, 0.0F, false));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(0.05F, 3.0F, -10.2F);
        this.setRotation(this.bone9, -0.4363F, 0.0F, 0.0F);
        this.bone4.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 4, 0, -1.0F, -22.0F, -8.0F, 1, 1, 1, 0.0F, false));
        this.bone9.cubeList.add(new ModelBox(this.bone9, 4, 0, -1.0F, -21.0F, -7.0F, 1, 1, 1, 0.0F, false));
        this.bone9.cubeList.add(new ModelBox(this.bone9, 4, 0, -1.0F, -20.0F, -6.0F, 1, 1, 1, 0.0F, false));
        this.bone9.cubeList.add(new ModelBox(this.bone9, 4, 0, -1.0F, -19.0F, -5.0F, 1, 1, 1, 0.0F, false));
        this.bone9.cubeList.add(new ModelBox(this.bone9, 4, 0, -1.0F, -23.0F, -9.0F, 1, 1, 1, 0.0F, false));
        this.bone9.cubeList.add(new ModelBox(this.bone9, 4, 0, -1.0F, -24.0F, -10.0F, 1, 1, 1, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(-0.05F, -11.55F, -16.1F);
        this.setRotation(this.bone6, -0.48F, 0.0F, 0.0F);
        this.bone4.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 4, 0, -1.0F, -22.0F, -8.05F, 1, 1, 1, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 4, 0, -1.0F, -21.0F, -7.05F, 1, 1, 1, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 4, 0, -1.0F, -20.0F, -6.05F, 1, 1, 1, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 4, 0, -1.0F, -19.0F, -5.05F, 1, 1, 1, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 4, 0, -1.0F, -18.0F, -4.05F, 1, 1, 1, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 4, 0, -1.0F, -23.0F, -9.05F, 1, 1, 1, 0.0F, false));
        this.bone6.cubeList.add(new ModelBox(this.bone6, 4, 0, -1.0F, -24.0F, -10.05F, 1, 1, 1, 0.0F, false));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.05F, -11.55F, -16.1F);
        this.setRotation(this.bone8, -0.48F, 0.0F, 0.0F);
        this.bone4.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 4, 0, -1.0F, -22.0F, -8.05F, 1, 1, 1, 0.0F, false));
        this.bone8.cubeList.add(new ModelBox(this.bone8, 4, 0, -1.0F, -21.0F, -7.05F, 1, 1, 1, 0.0F, false));
        this.bone8.cubeList.add(new ModelBox(this.bone8, 4, 0, -1.0F, -20.0F, -6.05F, 1, 1, 1, 0.0F, false));
        this.bone8.cubeList.add(new ModelBox(this.bone8, 4, 0, -1.0F, -19.0F, -5.05F, 1, 1, 1, 0.0F, false));
        this.bone8.cubeList.add(new ModelBox(this.bone8, 4, 0, -1.0F, -18.0F, -4.05F, 1, 1, 1, 0.0F, false));
        this.bone8.cubeList.add(new ModelBox(this.bone8, 4, 0, -1.0F, -23.0F, -9.05F, 1, 1, 1, 0.0F, false));
        this.bone8.cubeList.add(new ModelBox(this.bone8, 4, 0, -1.0F, -24.0F, -10.05F, 1, 1, 1, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(0.0F, -15.0F, 4.0F);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 18, 0, -0.75F, -3.0F, -11.0F, 1, 5, 1, -0.7F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 18, 0, -1.25F, -4.0F, -12.0F, 1, 5, 1, -0.7F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 22, 0, -1.25F, 0.0F, -12.0F, 1, 1, 1, 0.0F, false));
        this.bone10.cubeList.add(new ModelBox(this.bone10, 22, 0, -0.75F, 1.25F, -11.0F, 1, 1, 1, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "body/katana.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
        double d0 = 0.5D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(-0.25D, 1.5D, 0.0D);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.5D, 0.15D);
        double d0 = 0.525D;
        GlStateManager.scale(d0, d0, d0);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0430\u0442\u0430\u043d\u0430";
    }

    public String getCreator()
    {
        return "EvilBendy";
    }
}
