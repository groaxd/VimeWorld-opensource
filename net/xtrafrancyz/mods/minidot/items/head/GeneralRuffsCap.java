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

public class GeneralRuffsCap extends BaseItem
{
    private final MModelRenderer hat;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;

    public GeneralRuffsCap()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.hat = new MModelRenderer(this);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 1.75F, 0.25F);
        this.setRotation(this.bone, -0.1745F, 0.0F, 0.0F);
        this.hat.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 27, -4.5F, -10.75F, -6.25F, 9, 2, 7, 0.0F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, -1.0F, -2.75F);
        this.setRotation(this.bone2, -0.3491F, 0.0F, 0.0F);
        this.hat.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 16, -4.5F, -8.75F, -4.5F, 9, 1, 10, 0.001F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 0, -5.5F, -12.75F, -5.5F, 11, 4, 12, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 8, 4.5F, -8.75F, 1.25F, 1, 2, 2, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 6, 6, -5.5F, -8.75F, 1.25F, 1, 2, 2, 0.0F, false));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(-0.5F, 0.25F, -3.75F);
        this.hat.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 6, -1.0F, -13.0F, -0.94F, 3, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 2, -2.0F, -15.0F, -0.94F, 5, 1, 1, 0.0F, false));
        this.bone3.cubeList.add(new ModelBox(this.bone3, 0, 4, -1.5F, -14.0F, -0.94F, 4, 1, 1, 0.0F, false));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(0.0F, -12.0F, 0.0F);
        this.setRotation(this.bone4, -0.0873F, 0.0F, 0.0F);
        this.bone3.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 0, -2.0F, -1.5F, -0.94F, 5, 1, 1, 0.0F, false));
        this.bone4.cubeList.add(new ModelBox(this.bone4, 25, 27, -2.5F, -2.5F, -0.94F, 6, 1, 1, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/generalruffscap.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.35F, 0.0F);
        float f = 0.88F;
        GlStateManager.scale(f, f, f);
        super.renderAsItem(time);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, 0.12F, 0.0F);
    }

    public String getName()
    {
        return "\u0424\u0443\u0440\u0430\u0436\u043a\u0430 \u0413\u0435\u043d\u0435\u0440\u0430\u043b\u0430 \u0413\u0430\u0432\u0441\u0430";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Brawl Stars");
    }

    public String getCreator()
    {
        return "Shanic";
    }
}
