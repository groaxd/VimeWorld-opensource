package net.xtrafrancyz.mods.pvp.gui.hud;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.ToIntFunction;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.pvp.PvPMod;
import net.xtrafrancyz.mods.pvp.PvpOptions;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.gui.GuiElementWrapper;
import net.xtrafrancyz.mods.texteria.util.TRenderUtil;

public class TEffectHudElement extends THudElement
{
    public static final String TID = "##TEffectHud";
    public static final GuiElementWrapper WRAPPER;
    private static final ResourceLocation INVENTORY_TEXTURE = new ResourceLocation("textures/gui/container/inventory.png");
    private static final boolean BLINK = true;
    private static final int BLINK_SECONDS = 10;
    private final Minecraft mc = Minecraft.getMinecraft();
    private int textWidth;

    public TEffectHudElement()
    {
        super("##TEffectHud");
        this.x.set(4.0F);
        this.y.set(2.0F);
        this.computeTextWidth();
    }

    public void reload()
    {
        super.reload();
        this.computeTextWidth();
    }

    private void computeTextWidth()
    {
        this.textWidth = this.mc.fontRendererObj.getStringWidth("1:00");
    }

    public float getWidth()
    {
        return (float)(21 + PvpOptions.effectTextSize * this.textWidth);
    }

    public float getHeight()
    {
        int i = this.mc.thePlayer.getActivePotionEffects().size();
        return i == 0 ? 0.0F : (float)(i * 18 + (i - 1) * 2);
    }

    public void render(long time)
    {
        Collection<PotionEffect> collection = this.mc.thePlayer.getActivePotionEffects();

        if (!collection.isEmpty())
        {
            PotionEffect[] apotioneffect = (PotionEffect[])collection.toArray(new PotionEffect[0]);
            Arrays.sort(apotioneffect, Comparator.comparingInt(PotionEffect::getDuration).reversed());
            int i = 0;

            for (PotionEffect potioneffect : apotioneffect)
            {
                Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
                int j = potioneffect.getDuration() / 20;
                GlStateManager.pushMatrix();
                int k = PvpOptions.effectTextColor;

                if (j < 10)
                {
                    float f = (MathHelper.cos((float)Math.toRadians((double)time * 0.4D % 360.0D)) + 1.0F) * 0.5F;
                    k = this.setAlpha(k, Math.max(5, (int)(f * 255.0F)));
                    GlStateManager.color(1.0F, 1.0F, 1.0F, f);
                }
                else
                {
                    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                }

                int l = potion.getStatusIconIndex();
                this.mc.getTextureManager().bindTexture(INVENTORY_TEXTURE);
                TRenderUtil.drawTexturedRect(0, i, (float)(l % 8 * 18), (float)(198 + l / 8 * 18), 18.0F, 18.0F, 256.0F, 256.0F);
                GlStateManager.popMatrix();
                String s = j < 600 ? j / 60 + ":" + toString(j % 60, 2) : "*:**";
                this.drawText(time, s, 21.0F, (float)(i + (PvpOptions.effectTextSize == 1 ? 5 : 0)), (float)PvpOptions.effectTextSize, false, PvpOptions.effectTextAnimation, k, true);
                i += 20;
            }
        }
    }

    private static String toString(int num, int needed)
    {
        StringBuilder stringbuilder = new StringBuilder(num + "");

        while (stringbuilder.length() < needed)
        {
            stringbuilder.insert(0, (String)"0");
        }

        return stringbuilder.length() > needed ? stringbuilder.substring(0, needed) : stringbuilder.toString();
    }

    public static void applyOptions()
    {
        WRAPPER.element.scaleX.set((float)PvpOptions.effectScale * 0.5F);
        WRAPPER.element.scaleY.set((float)PvpOptions.effectScale * 0.5F);
        PvPMod.addOrRemove(WRAPPER, PvpOptions.effectEnabled);
    }

    static
    {
        WRAPPER = new GuiElementWrapper(new TEffectHudElement(), Texteria.instance.gui);
    }
}
