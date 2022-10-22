package net.xtrafrancyz.mods.minidot;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.pvp.PvpOptions;

public class MiniDotLayer implements LayerRenderer<AbstractClientPlayer>
{
    public static float globalPartialTicks;
    public static float receivedPartialTicks;
    private static final Minecraft mc = Minecraft.getMinecraft();
    private final MiniDot md = MiniDot.instance;
    private final ModelPlayer modelPlayer;

    public MiniDotLayer(RenderPlayer renderPlayer)
    {
        this.modelPlayer = renderPlayer.getMainModel();
    }

    public void doRenderLayer(AbstractClientPlayer player, float p2, float p3, float partialTicks, float time, float p6, float p7, float scale)
    {
        if (!player.isInvisible())
        {
            if (this.md.isEnabled())
            {
                if (PvpOptions.showModels || player.getUniqueID().equals(mc.getSession().getProfile().getId()))
                {
                    MiniDotPlayer minidotplayer = this.md.getPlayer(player.getUniqueID());

                    if (!minidotplayer.items.isEmpty())
                    {
                        receivedPartialTicks = partialTicks;
                        time = (float)Minecraft.getMinecraft().globalTickCounter.get() + globalPartialTicks;
                        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                        GlStateManager.enableRescaleNormal();
                        GlStateManager.enableBlend();
                        GlStateManager.blendFunc(770, 771);

                        for (BaseItem baseitem : minidotplayer.items.values())
                        {
                            baseitem.render(this.modelPlayer, player, time, minidotplayer);
                        }

                        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                    }
                }
            }
        }
    }

    public boolean shouldCombineTextures()
    {
        return false;
    }
}
