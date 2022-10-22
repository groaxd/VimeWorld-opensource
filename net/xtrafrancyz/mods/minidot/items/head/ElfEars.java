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

public class ElfEars extends BaseItem
{
    private final MModelRenderer bone;

    public ElfEars()
    {
        super(ItemType.HEAD);
        this.textureWidth = 8;
        this.textureHeight = 8;
        this.bone = new MModelRenderer(this);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, 3.75F, -3.0F, -1.5F, 1, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, 3.75F, -4.0F, -1.5F, 1, 1, 3, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, 3.75F, -5.0F, -0.5F, 1, 1, 3, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -4.75F, -3.0F, -1.5F, 1, 1, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -4.75F, -4.0F, -1.5F, 1, 1, 3, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 0, -4.75F, -5.0F, -0.5F, 1, 1, 3, 0.0F, false));
        this.setTexture(new ResourceLocation("minidot", "head/elfears.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);

        if (player.getCurrentArmor(3) != null)
        {
            GlStateManager.scale(0.95F, 1.0F, 1.0F);
        }
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.075F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0423\u0448\u0438 \u044d\u043b\u044c\u0444\u0430";
    }
}
