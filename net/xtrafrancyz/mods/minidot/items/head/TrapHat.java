package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class TrapHat extends BaseItem
{
    private final MModelRenderer Kapkan;
    private final MModelRenderer up;
    private final MModelRenderer down;
    private final MModelRenderer ventel;
    private final MModelRenderer ventel2;
    private final MModelRenderer kapkan2;
    private final MModelRenderer kapkan3;
    private final MModelRenderer kapkan4;
    private final MModelRenderer kapkan5;
    private final MModelRenderer bone14;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer kapkan6;
    private final IAnimation animation;

    public TrapHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Kapkan = new MModelRenderer(this);
        this.up = new MModelRenderer(this);
        this.up.setRotationPoint(0.0F, -0.1F, 0.0F);
        this.Kapkan.addChild(this.up);
        this.up.cubeList.add(new ModelBox(this.up, 46, 0, 3.1F, -7.5002F, -4.75F, 3, 1, 6, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 46, 0, 3.1F, -6.25F, -4.75F, 3, 1, 6, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 38, 8, 2.6F, -6.2495F, -5.2495F, 3, 1, 3, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 38, 8, 2.6F, -7.4995F, -5.2495F, 3, 1, 3, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 38, 8, -5.65F, -7.4995F, -5.2495F, 3, 1, 3, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 38, 8, -5.65F, -6.2495F, -5.2495F, 3, 1, 3, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 38, 7, -5.5F, -7.85F, -4.25F, 11, 3, 2, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 48, 3, 3.5F, -7.85F, -3.75F, 2, 3, 5, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 42, 0, 3.0F, -7.85F, -5.1499F, 2, 3, 3, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 42, 0, 1.0F, -7.85F, -5.1499F, 2, 3, 3, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 42, 0, -1.0F, -7.85F, -5.1499F, 2, 3, 3, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 56, 12, -2.0F, -7.95F, -4.9999F, 2, 3, 2, -0.8F, false));
        this.up.cubeList.add(new ModelBox(this.up, 56, 12, 0.0F, -7.95F, -4.9999F, 2, 3, 2, -0.8F, false));
        this.up.cubeList.add(new ModelBox(this.up, 56, 12, 2.0F, -7.95F, -4.9999F, 2, 3, 2, -0.8F, false));
        this.up.cubeList.add(new ModelBox(this.up, 40, 13, 2.0F, -8.45F, -4.9999F, 2, 2, 2, -0.8F, false));
        this.up.cubeList.add(new ModelBox(this.up, 40, 13, 0.0F, -8.45F, -4.9999F, 2, 2, 2, -0.8F, false));
        this.up.cubeList.add(new ModelBox(this.up, 40, 13, -2.0F, -8.45F, -4.9999F, 2, 2, 2, -0.8F, false));
        this.up.cubeList.add(new ModelBox(this.up, 40, 13, -4.0F, -8.45F, -4.9999F, 2, 2, 2, -0.8F, false));
        this.up.cubeList.add(new ModelBox(this.up, 48, 13, -4.0F, -8.2F, -4.9999F, 2, 2, 2, -0.7F, false));
        this.up.cubeList.add(new ModelBox(this.up, 48, 13, -2.0F, -8.2F, -4.9999F, 2, 2, 2, -0.7F, false));
        this.up.cubeList.add(new ModelBox(this.up, 48, 13, 0.0F, -8.2F, -4.9999F, 2, 2, 2, -0.7F, false));
        this.up.cubeList.add(new ModelBox(this.up, 48, 13, 2.0F, -8.2F, -4.9999F, 2, 2, 2, -0.7F, false));
        this.up.cubeList.add(new ModelBox(this.up, 56, 12, -4.0F, -7.95F, -4.9999F, 2, 3, 2, -0.8F, false));
        this.up.cubeList.add(new ModelBox(this.up, 42, 0, -3.0F, -7.85F, -5.1499F, 2, 3, 3, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 42, 0, -5.0F, -7.85F, -5.1499F, 2, 3, 3, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 48, 3, -5.5F, -7.85F, -3.75F, 2, 3, 5, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 46, 0, -6.1F, -6.25F, -4.75F, 3, 1, 6, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 46, 0, -6.1F, -7.5002F, -4.75F, 3, 1, 6, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 38, 7, -5.0F, -7.5F, -5.25F, 10, 1, 3, -0.75F, false));
        this.up.cubeList.add(new ModelBox(this.up, 38, 7, -5.0F, -6.25F, -5.25F, 10, 1, 3, -0.75F, false));
        this.down = new MModelRenderer(this);
        this.down.setRotationPoint(0.0F, -0.15F, 1.0F);
        this.Kapkan.addChild(this.down);
        this.down.cubeList.add(new ModelBox(this.down, 38, 7, -5.0F, -4.25F, -6.25F, 10, 1, 3, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 40, 13, -2.0F, -4.3F, -5.9999F, 2, 2, 2, -0.8F, false));
        this.down.cubeList.add(new ModelBox(this.down, 48, 13, 2.0F, -4.55F, -5.9999F, 2, 2, 2, -0.7F, false));
        this.down.cubeList.add(new ModelBox(this.down, 48, 13, -4.0F, -4.55F, -5.9999F, 2, 2, 2, -0.7F, false));
        this.down.cubeList.add(new ModelBox(this.down, 40, 13, 0.0F, -4.3F, -5.9999F, 2, 2, 2, -0.8F, false));
        this.down.cubeList.add(new ModelBox(this.down, 48, 13, -2.0F, -4.55F, -5.9999F, 2, 2, 2, -0.7F, false));
        this.down.cubeList.add(new ModelBox(this.down, 46, 0, -6.1F, -4.2502F, -5.75F, 3, 1, 6, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 48, 13, 0.0F, -4.55F, -5.9999F, 2, 2, 2, -0.7F, false));
        this.down.cubeList.add(new ModelBox(this.down, 40, 13, 2.0F, -4.3F, -5.9999F, 2, 2, 2, -0.8F, false));
        this.down.cubeList.add(new ModelBox(this.down, 40, 13, -4.0F, -4.3F, -5.9999F, 2, 2, 2, -0.8F, false));
        this.down.cubeList.add(new ModelBox(this.down, 46, 0, -6.1F, -5.5F, -5.75F, 3, 1, 6, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 42, 0, -5.0F, -5.9F, -6.1499F, 2, 3, 3, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 42, 0, -3.0F, -5.9F, -6.1499F, 2, 3, 3, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 42, 0, -1.0F, -5.9F, -6.1499F, 2, 3, 3, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 42, 0, 1.0F, -5.9F, -6.1499F, 2, 3, 3, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 42, 0, 3.0F, -5.9F, -6.1499F, 2, 3, 3, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 48, 3, -5.5F, -5.85F, -4.75F, 2, 3, 5, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 38, 8, -5.65F, -5.5005F, -6.2495F, 3, 1, 3, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 38, 8, -5.65F, -4.2505F, -6.2495F, 3, 1, 3, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 48, 3, 3.5F, -5.85F, -4.75F, 2, 3, 5, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 56, 12, 2.0F, -5.8F, -5.9999F, 2, 3, 2, -0.8F, false));
        this.down.cubeList.add(new ModelBox(this.down, 56, 12, 0.0F, -5.8F, -5.9999F, 2, 3, 2, -0.8F, false));
        this.down.cubeList.add(new ModelBox(this.down, 56, 12, -2.0F, -5.8F, -5.9999F, 2, 3, 2, -0.8F, false));
        this.down.cubeList.add(new ModelBox(this.down, 56, 12, -4.0F, -5.8F, -5.9999F, 2, 3, 2, -0.8F, false));
        this.down.cubeList.add(new ModelBox(this.down, 38, 8, 2.6F, -5.5005F, -6.2495F, 3, 1, 3, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 38, 8, 2.6F, -4.2505F, -6.2495F, 3, 1, 3, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 38, 7, -5.5F, -5.85F, -5.25F, 11, 3, 2, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 46, 0, 3.1F, -4.2502F, -5.75F, 3, 1, 6, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 46, 0, 3.1F, -5.5F, -5.75F, 3, 1, 6, -0.75F, false));
        this.down.cubeList.add(new ModelBox(this.down, 38, 7, -5.0F, -5.5F, -6.25F, 10, 1, 3, -0.75F, false));
        this.ventel = new MModelRenderer(this);
        this.ventel.setRotationPoint(7.05F, -5.75F, 1.5F);
        this.Kapkan.addChild(this.ventel);
        this.ventel.cubeList.add(new ModelBox(this.ventel, 30, 12, -0.75F, -2.0F, -2.0F, 1, 4, 4, -0.75F, false));
        this.ventel.cubeList.add(new ModelBox(this.ventel, 14, 7, -0.75F, -1.5F, 0.5F, 1, 3, 2, -0.75F, false));
        this.ventel.cubeList.add(new ModelBox(this.ventel, 58, 1, -0.75F, -1.5F, -2.5F, 1, 3, 2, -0.75F, false));
        this.ventel.cubeList.add(new ModelBox(this.ventel, 22, 15, -0.75F, -2.5F, -1.5F, 1, 2, 3, -0.75F, false));
        this.ventel.cubeList.add(new ModelBox(this.ventel, 14, 15, -0.75F, 0.5F, -1.5F, 1, 2, 3, -0.75F, false));
        this.ventel2 = new MModelRenderer(this);
        this.ventel2.setRotationPoint(-13.35F, 0.0F, 0.0F);
        this.ventel.addChild(this.ventel2);
        this.ventel2.cubeList.add(new ModelBox(this.ventel2, 30, 12, -0.5F, -2.0F, -2.0F, 1, 4, 4, -0.75F, false));
        this.ventel2.cubeList.add(new ModelBox(this.ventel2, 14, 7, -0.5F, -1.5F, 0.5F, 1, 3, 2, -0.75F, false));
        this.ventel2.cubeList.add(new ModelBox(this.ventel2, 58, 1, -0.5F, -1.5F, -2.5F, 1, 3, 2, -0.75F, false));
        this.ventel2.cubeList.add(new ModelBox(this.ventel2, 22, 15, -0.5F, -2.5F, -1.5F, 1, 2, 3, -0.75F, false));
        this.ventel2.cubeList.add(new ModelBox(this.ventel2, 14, 15, -0.5F, 0.5F, -1.5F, 1, 2, 3, -0.75F, false));
        this.kapkan2 = new MModelRenderer(this);
        this.kapkan2.setRotationPoint(0.5F, 0.0F, 0.0F);
        this.Kapkan.addChild(this.kapkan2);
        this.kapkan2.cubeList.add(new ModelBox(this.kapkan2, 46, 6, -6.55F, -8.0F, 0.05F, 3, 5, 1, -0.6F, false));
        this.kapkan2.cubeList.add(new ModelBox(this.kapkan2, 6, 5, -6.3F, -6.25F, -0.5F, 2, 1, 3, 0.0F, false));
        this.kapkan2.cubeList.add(new ModelBox(this.kapkan2, 1, 4, -6.55F, -6.75F, 0.25F, 2, 2, 2, 0.0F, false));
        this.kapkan3 = new MModelRenderer(this);
        this.Kapkan.addChild(this.kapkan3);
        this.kapkan3.cubeList.add(new ModelBox(this.kapkan3, 6, 5, 4.55F, -6.25F, -0.5F, 2, 1, 3, 0.0F, false));
        this.kapkan3.cubeList.add(new ModelBox(this.kapkan3, 1, 4, 4.3F, -8.25F, 0.25F, 2, 2, 2, 0.0F, false));
        this.kapkan3.cubeList.add(new ModelBox(this.kapkan3, 50, 6, 2.95F, -8.0F, 0.05F, 3, 5, 1, -0.6F, false));
        this.kapkan4 = new MModelRenderer(this);
        this.Kapkan.addChild(this.kapkan4);
        this.kapkan4.cubeList.add(new ModelBox(this.kapkan4, 56, 21, 3.8F, -13.65F, -1.0F, 1, 8, 3, -0.8F, false));
        this.kapkan4.cubeList.add(new ModelBox(this.kapkan4, 56, 21, -4.8F, -13.65F, -1.0F, 1, 8, 3, -0.8F, false));
        this.kapkan4.cubeList.add(new ModelBox(this.kapkan4, 38, 17, -4.95F, -13.0495F, -1.0003F, 10, 1, 3, -0.8F, false));
        this.kapkan4.cubeList.add(new ModelBox(this.kapkan4, 40, 13, 2.0F, -14.05F, -0.4999F, 2, 2, 2, -0.8F, false));
        this.kapkan4.cubeList.add(new ModelBox(this.kapkan4, 40, 13, -4.0F, -14.05F, -0.4999F, 2, 2, 2, -0.8F, false));
        this.kapkan4.cubeList.add(new ModelBox(this.kapkan4, 48, 13, -4.0F, -13.8F, -0.4999F, 2, 2, 2, -0.7F, false));
        this.kapkan4.cubeList.add(new ModelBox(this.kapkan4, 48, 13, -2.0F, -13.8F, -0.4999F, 2, 2, 2, -0.7F, false));
        this.kapkan4.cubeList.add(new ModelBox(this.kapkan4, 48, 13, 0.0F, -13.8F, -0.4999F, 2, 2, 2, -0.7F, false));
        this.kapkan4.cubeList.add(new ModelBox(this.kapkan4, 48, 13, 2.0F, -13.8F, -0.4999F, 2, 2, 2, -0.7F, false));
        this.kapkan4.cubeList.add(new ModelBox(this.kapkan4, 40, 13, -2.0F, -14.05F, -0.4999F, 2, 2, 2, -0.8F, false));
        this.kapkan4.cubeList.add(new ModelBox(this.kapkan4, 40, 13, 0.0F, -14.05F, -0.4999F, 2, 2, 2, -0.8F, false));
        this.kapkan5 = new MModelRenderer(this);
        this.kapkan5.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Kapkan.addChild(this.kapkan5);
        this.kapkan5.cubeList.add(new ModelBox(this.kapkan5, 36, 0, 5.05F, -13.25F, 0.0F, 1, 8, 1, 0.0F, false));
        this.kapkan5.cubeList.add(new ModelBox(this.kapkan5, 1, 1, 4.55F, -11.25F, -0.5F, 2, 1, 2, 0.0F, false));
        this.kapkan5.cubeList.add(new ModelBox(this.kapkan5, 6, 9, 4.55F, -11.75F, -1.4F, 2, 2, 2, -0.6F, false));
        this.kapkan5.cubeList.add(new ModelBox(this.kapkan5, 60, 10, 4.3429F, -13.9571F, -5.0E-4F, 1, 1, 1, 0.0F, false));
        this.kapkan5.cubeList.add(new ModelBox(this.kapkan5, 36, 0, 3.5429F, -13.9571F, 0.0F, 1, 1, 1, -0.8F, false));
        this.kapkan5.cubeList.add(new ModelBox(this.kapkan5, 39, 22, -5.2071F, -13.9571F, 0.0F, 9, 1, 1, 0.0F, false));
        this.kapkan5.cubeList.add(new ModelBox(this.kapkan5, 52, 24, -6.6213F, -12.5429F, 0.0F, 1, 4, 1, 0.0F, false));
        this.bone14 = new MModelRenderer(this);
        this.setRotation(this.bone14, 0.0F, 0.0F, -0.7854F);
        this.kapkan5.addChild(this.bone14);
        this.bone14.cubeList.add(new ModelBox(this.bone14, 36, 0, 12.6472F, -6.0912F, 5.0E-4F, 1, 1, 1, 0.0F, false));
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(-6.0F, -13.0F, 5.5F);
        this.setRotation(this.bone11, 0.0F, 0.0F, -0.7854F);
        this.kapkan5.addChild(this.bone11);
        this.bone11.cubeList.add(new ModelBox(this.bone11, 51, 22, -0.7626F, -0.1161F, -5.4995F, 2, 1, 1, 0.0F, false));
        this.bone12 = new MModelRenderer(this);
        this.setRotation(this.bone12, 0.0F, 0.0F, 1.0472F);
        this.kapkan5.addChild(this.bone12);
        this.bone12.cubeList.add(new ModelBox(this.bone12, 42, 24, -10.709F, 0.4628F, 5.0E-4F, 4, 1, 1, 0.0F, false));
        this.kapkan6 = new MModelRenderer(this);
        this.Kapkan.addChild(this.kapkan6);
        this.kapkan6.cubeList.add(new ModelBox(this.kapkan6, 24, 0, 4.0F, -7.5F, 0.35F, 1, 3, 5, 0.0F, false));
        this.kapkan6.cubeList.add(new ModelBox(this.kapkan6, 24, 8, -0.5F, -7.5002F, 4.75F, 5, 3, 1, 0.0F, false));
        this.kapkan6.cubeList.add(new ModelBox(this.kapkan6, 10, 13, -1.25F, -6.85F, 4.0F, 1, 3, 2, -0.75F, false));
        this.kapkan6.cubeList.add(new ModelBox(this.kapkan6, 14, 6, -5.25F, -6.85F, -0.15F, 2, 3, 6, -0.75F, false));
        this.kapkan6.cubeList.add(new ModelBox(this.kapkan6, 9, 0, -4.75F, -6.85F, 4.0F, 3, 3, 2, -0.75F, false));
        this.kapkan6.cubeList.add(new ModelBox(this.kapkan6, 19, 0, -3.5F, -7.0F, 4.15F, 3, 3, 2, -0.5F, false));
        this.kapkan6.cubeList.add(new ModelBox(this.kapkan6, 26, 20, -4.1F, -7.4F, 4.652F, 4, 4, 2, -1.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/traphat.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "head/traphat_animation.json"));
        this.animation = bbanimationloader.mustGet("trap.activate", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0D, 0.25D, 0.0D);

        if (player.isWearing(EnumPlayerModelParts.HAT))
        {
            double d0 = 1.05D;
            GlStateManager.scale(d0, d0, d0);
        }
    }

    public void renderAsItem(float time)
    {
        this.animation.tick(time);
        GlStateManager.scale(0.9D, 0.9D, 0.9D);
        GlStateManager.translate(0.0D, 0.25D, 0.0D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u0430\u043f\u043a\u0430\u043d";
    }

    public String getCreator()
    {
        return "EvilBendy";
    }
}
