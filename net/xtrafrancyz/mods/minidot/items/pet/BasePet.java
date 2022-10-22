package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.xtrafrancyz.mods.minidot.MiniDotLayer;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import org.lwjgl.opengl.GL11;

public abstract class BasePet extends BaseItem
{
    protected BasePet()
    {
        super(ItemType.PET);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        smoothRotation(player, pi);
        this.processMotion(modelPlayer, player, time);
        GlStateManager.scale(0.5555556F, 0.5555556F, 0.5555556F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.5555556F, 0.5555556F, 0.5555556F);
        super.renderAsItem(time);
    }

    private static void smoothRotation(EntityPlayer player, MiniDotPlayer pi)
    {
        float f;

        if (MiniDotLayer.receivedPartialTicks == 1.0F && MiniDotLayer.globalPartialTicks != 1.0F)
        {
            f = 0.0F;
        }
        else
        {
            f = MiniDotLayer.globalPartialTicks;
        }

        float f1 = interpolateRotation(player.prevRenderYawOffset, player.renderYawOffset, f);
        pi.prevPetBodyYawOffset = interpolateRotation(pi.prevPetBodyYawOffset, f1, 0.015F);
        GL11.glRotatef(pi.prevPetBodyYawOffset - f1, -0.2F, 1.0F, 0.0F);
    }

    private static float interpolateRotation(float par1, float par2, float par3)
    {
        float f;

        for (f = par2 - par1; f < -180.0F; f += 360.0F)
        {
            ;
        }

        while (f >= 180.0F)
        {
            f -= 360.0F;
        }

        return par1 + par3 * f;
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
    }
}
