package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class ConsolePet extends BasePet
{
    private static final ResourceLocation tex = new ResourceLocation("minidot", "pets/console.png");
    private static final ResourceLocation tex1 = new ResourceLocation("minidot", "pets/console1.png");
    private final MModelRenderer Shape1;

    public ConsolePet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Shape1 = new MModelRenderer(this, 0, 0);
        this.Shape1.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
        this.Shape1.setRotationPoint(-4.0F, 0.0F, -4.0F);
        this.setTexture(tex);
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(0.6F, -0.5F + f, 0.4F);

        if (time % 20.0F > 10.0F)
        {
            this.setTexture(tex);
        }
        else
        {
            this.setTexture(tex1);
        }
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.2F, 0.0F);
        GlStateManager.scale(1.4F, 1.4F, 1.4F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041a\u043e\u043d\u0441\u043e\u043b\u044c\u043a\u0430";
    }
}
