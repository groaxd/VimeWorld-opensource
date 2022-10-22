package net.xtrafrancyz.mods.minidot.items.mask;

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

public class ShooterMask extends BaseItem
{
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;

    public ShooterMask()
    {
        super(ItemType.MASK);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bone2 = new MModelRenderer(this);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -5.0F, -18.0F, -5.0F, 10, 8, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 22, 2, -5.0F, -19.0F, -5.0F, 10, 1, 1, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 22, 0, -5.0F, -10.0F, -5.0F, 10, 1, 1, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone2.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 21, 4.3F, -12.0F, -5.3F, 1, 2, 2, -0.2F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 9, 12, 4.3F, -18.0F, -5.3F, 1, 2, 2, -0.2F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 18, 17, -5.3F, -12.0F, -2.3F, 1, 2, 7, -0.2F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 12, -5.3F, -18.0F, -2.3F, 1, 2, 7, -0.2F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 15, 5, 4.3F, -12.0F, -2.3F, 1, 2, 7, -0.2F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 9, 14, 4.3F, -18.0F, -2.3F, 1, 2, 7, -0.2F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 18, 17, -5.3F, -12.0F, -5.3F, 1, 2, 2, -0.2F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 12, -5.3F, -18.0F, -5.3F, 1, 2, 2, -0.2F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 18, 14, -5.0F, -12.0F, 4.3F, 10, 2, 1, -0.2F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 9, -5.0F, -18.0F, 4.3F, 10, 2, 1, -0.2F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 25, -5.3F, -12.4F, -3.8F, 1, 1, 2, -0.27F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 24, 7, -5.3F, -16.6F, -3.8F, 1, 1, 2, -0.27F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 24, 4, -5.3F, -18.4F, -3.8F, 1, 1, 2, -0.27F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 10, 23, 4.3F, -18.4F, -3.8F, 1, 1, 2, -0.27F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 4, 23, 4.3F, -16.6F, -3.8F, 1, 1, 2, -0.27F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 9, 16, 4.3F, -12.4F, -3.8F, 1, 1, 2, -0.27F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 16, 4.3F, -10.6F, -3.8F, 1, 1, 2, -0.27F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 14, 24, -5.3F, -10.6F, -3.8F, 1, 1, 2, -0.27F, false));
        super.setTexture(new ResourceLocation("minidot", "masks/shootermask.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.55F, 0.0F);
        float f = 0.67F;
        GlStateManager.scale(f, f, f);
        super.renderAsItem(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.63F, 0.0F);
        float f = 0.99F;
        GlStateManager.scale(f, f, f);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u0441\u0442\u0440\u0435\u043b\u043a\u0430";
    }

    public String getCreator()
    {
        return "GetoGdeto";
    }

    public List<String> getDescription()
    {
        return MNaming.fromAnime("\u041d\u0435\u0431\u0435\u0441\u043d\u043e\u0435 \u0432\u0442\u043e\u0440\u0436\u0435\u043d\u0438\u0435");
    }
}
