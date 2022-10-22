package net.xtrafrancyz.mods.minidot.items.head;

import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class StolasHat extends BaseItem
{
    private final MModelRenderer Stolas_hat;
    private final MModelRenderer bone;
    private final MModelRenderer owl_symbol_or_smth;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;

    public StolasHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Stolas_hat = new MModelRenderer(this);
        this.Stolas_hat.cubeList.add(new ModelBox(this.Stolas_hat, 0, 0, -4.5F, -3.0F, -4.5F, 9, 1, 9, 0.0F, false));
        this.Stolas_hat.cubeList.add(new ModelBox(this.Stolas_hat, 24, 10, -3.0F, -5.0F, -3.0F, 6, 2, 6, 0.0F, false));
        this.Stolas_hat.cubeList.add(new ModelBox(this.Stolas_hat, 25, 23, -3.5F, -8.0F, -3.5F, 7, 3, 7, 0.0F, false));
        this.Stolas_hat.cubeList.add(new ModelBox(this.Stolas_hat, 0, 10, -4.0F, -13.0F, -4.0F, 8, 5, 8, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -3.0F, -3.5F);
        this.setRotation(this.bone, 0.1309F, 0.0F, 0.0F);
        this.Stolas_hat.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 27, 0, -3.0F, -5.0F, 0.0F, 6, 5, 0, 0.0F, false));
        this.owl_symbol_or_smth = new MModelRenderer(this);
        this.owl_symbol_or_smth.setRotationPoint(0.0F, 0.75F, 0.0F);
        this.Stolas_hat.addChild(this.owl_symbol_or_smth);
        this.owl_symbol_or_smth.cubeList.add(new ModelBox(this.owl_symbol_or_smth, 0, 23, -8.0F, -8.5F, -4.51F, 16, 7, 0, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(2.25F, -3.0F, -4.5F);
        this.setRotation(this.bone2, 0.0F, 0.0F, -0.1745F);
        this.owl_symbol_or_smth.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 2, -1.25F, -1.0F, -0.02F, 3, 2, 0, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-2.25F, -3.0F, -4.5F);
        this.setRotation(this.bone3, 0.0F, 0.0F, 0.1745F);
        this.owl_symbol_or_smth.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 0, -1.75F, -1.0F, -0.02F, 3, 2, 0, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/stolashat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, -0.325D, 0.0D);
        double d0 = 1.15D;
        GlStateManager.scale(d0, d0, d0);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        double d0 = 0.8D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, 0.1D, 0.0D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u043b\u044f\u043f\u0430 \u0421\u0442\u043e\u043b\u0430\u0441\u0430";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }

    public List<String> getDescription()
    {
        return MNaming.fromMult("\u0410\u0434\u0441\u043a\u0438\u0439 \u0431\u043e\u0441\u0441");
    }
}
