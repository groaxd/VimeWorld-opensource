package net.xtrafrancyz.mods.pvp.gui.hud;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.xtrafrancyz.mods.pvp.PvPMod;
import net.xtrafrancyz.mods.pvp.PvpOptions;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.gui.GuiElementWrapper;

public class TArmorStatusHudElement extends THudElement
{
    public static final String TID = "##TArmorStatusHud";
    public static final GuiElementWrapper WRAPPER;
    private static final int PAD = 2;
    private final Minecraft mc = Minecraft.getMinecraft();
    private final List<TArmorStatusHudElement.HudElement> elements = new ArrayList();
    private int width;
    private int height;

    private TArmorStatusHudElement()
    {
        super("##TArmorStatusHud");
    }

    public float getWidth()
    {
        return (float)this.width;
    }

    public float getHeight()
    {
        return (float)this.height;
    }

    public void render(long time)
    {
        this.elements.clear();

        for (int i = 3; i >= -1; --i)
        {
            ItemStack itemstack = null;

            if (i >= 0)
            {
                itemstack = this.mc.thePlayer.inventory.armorInventory[i];
            }
            else if (PvpOptions.armorStatus == 2)
            {
                itemstack = this.mc.thePlayer.getCurrentEquippedItem();
            }

            if (itemstack != null)
            {
                this.elements.add(new TArmorStatusHudElement.HudElement(itemstack, 16, 16));
            }
        }

        this.width = 0;
        this.height = 0;

        for (TArmorStatusHudElement.HudElement tarmorstatushudelement$hudelement1 : this.elements)
        {
            if (PvpOptions.armorDirection)
            {
                if (tarmorstatushudelement$hudelement1.elementWidth > this.width)
                {
                    this.width = tarmorstatushudelement$hudelement1.elementWidth;
                }

                this.height += tarmorstatushudelement$hudelement1.elementHeight;
            }
            else
            {
                this.width += tarmorstatushudelement$hudelement1.elementWidth;

                if (tarmorstatushudelement$hudelement1.elementHeight > this.height)
                {
                    this.height = tarmorstatushudelement$hudelement1.elementHeight;
                }
            }
        }

        this.width += PvpOptions.armorDirection ? 2 * (PvpOptions.armorTextType == 0 ? 1 : 2) : 2 * (this.elements.size() + 1);

        if (this.elements.size() > 0)
        {
            if (PvpOptions.armorDirection)
            {
                int j = 0;

                for (TArmorStatusHudElement.HudElement tarmorstatushudelement$hudelement : this.elements)
                {
                    tarmorstatushudelement$hudelement.renderToHud(time, 0, j);
                    j += tarmorstatushudelement$hudelement.elementHeight;
                }
            }
            else
            {
                int k = 2;

                for (TArmorStatusHudElement.HudElement tarmorstatushudelement$hudelement2 : this.elements)
                {
                    tarmorstatushudelement$hudelement2.renderToHud(time, k, 0);
                    k += tarmorstatushudelement$hudelement2.elementWidth + 2;
                }
            }
        }
    }

    private void renderItem(long time, ItemStack itemStack, int x, int y)
    {
        Minecraft minecraft = Minecraft.getMinecraft();
        GlStateManager.enableDepth();
        RenderHelper.enableGUIStandardItemLighting();
        minecraft.getRenderItem().renderItemAndEffectIntoGUI(itemStack, x, y);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableDepth();
        minecraft.getTextureManager().bindTexture(Gui.icons);
        GlStateManager.tryBlendFuncSeparate(770, 771, 0, 1);
        GlStateManager.shadeModel(7425);
    }

    private void renderItemOverlays(long time, ItemStack itemStack, int x, int y)
    {
        if (PvpOptions.armorItemAmount && itemStack.stackSize > 1)
        {
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            GlStateManager.disableBlend();
            String s = String.valueOf(itemStack.stackSize);
            Minecraft minecraft = Minecraft.getMinecraft();
            FontRenderer fontrenderer = minecraft.fontRendererObj;
            this.drawText(time, s, (float)(x + 19 - 2 - fontrenderer.getStringWidth(s)), (float)(y + 6 + 3), 1.0F, false, PvpOptions.armorTextAnimation, PvpOptions.armorTextColor, true);
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
        }

        boolean flag = itemStack.isItemDamaged();

        if (PvpOptions.armorDurabilityBar && flag)
        {
            int i = (int)Math.round(13.0D - (double)itemStack.getItemDamage() * 13.0D / (double)itemStack.getMaxDamage());
            int j = (int)Math.round(255.0D - (double)itemStack.getItemDamage() * 255.0D / (double)itemStack.getMaxDamage());
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            GlStateManager.disableTexture2D();
            GlStateManager.disableAlpha();
            GlStateManager.disableBlend();
            drawColoredRect(x + 2, y + 13, 13, 2, 0, 0, 0, 255);
            drawColoredRect(x + 2, y + 13, 12, 1, (255 - j) / 4, 64, 0, 255);
            drawColoredRect(x + 2, y + 13, i, 1, 255 - j, j, 0, 255);
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.enableTexture2D();
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
        }

        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableDepth();
        GlStateManager.disableAlpha();
    }

    private static void drawColoredRect(int x, int y, int width, int height, int red, int green, int blue, int alpha)
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos((double)x, (double)y, 0.0D).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos((double)x, (double)(y + height), 0.0D).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos((double)(x + width), (double)(y + height), 0.0D).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos((double)(x + width), (double)y, 0.0D).color(red, green, blue, alpha).endVertex();
        tessellator.draw();
    }

    public static void applyOptions()
    {
        PvPMod.addOrRemove(WRAPPER, PvpOptions.armorStatus != 0);
    }

    static
    {
        WRAPPER = new GuiElementWrapper(new TArmorStatusHudElement(), Texteria.instance.gui);
    }

    public class HudElement
    {
        public final ItemStack itemStack;
        private final int iconWidth;
        private final int iconHeight;
        private String text = "";
        private int textWidth;
        private int textHeight;
        private int elementWidth;
        private int elementHeight;

        public HudElement(ItemStack itemStack, int iconWidth, int iconHeight)
        {
            this.itemStack = itemStack;
            this.iconWidth = iconWidth;
            this.iconHeight = iconHeight;
            this.initSize();
        }

        private void initSize()
        {
            if (PvpOptions.armorTextType != 0 && this.itemStack.isItemStackDamageable())
            {
                int i = this.itemStack.getMaxDamage();
                int j = i - this.itemStack.getItemDamage();

                if (PvpOptions.armorTextType == 1)
                {
                    this.text = String.valueOf(j);
                }
                else if (PvpOptions.armorTextType == 2)
                {
                    this.text = j * 100 / i + "%";
                }

                this.textWidth = this.text.isEmpty() ? 0 : TArmorStatusHudElement.this.mc.fontRendererObj.getStringWidth(this.text);
                this.textHeight = this.text.isEmpty() ? 0 : TArmorStatusHudElement.this.mc.fontRendererObj.FONT_HEIGHT;
            }

            if (PvpOptions.armorDirection)
            {
                this.elementWidth = this.iconWidth + 2 + this.textWidth;
                this.elementHeight = Math.max(this.textHeight, this.iconHeight);
            }
            else
            {
                this.elementWidth = Math.max(this.textWidth, this.iconWidth);
                this.elementHeight = this.textHeight + this.iconHeight;
            }
        }

        public void renderToHud(long time, int x, int y)
        {
            int i;
            int j;
            int k;
            int l;

            if (PvpOptions.armorDirection)
            {
                if (PvpOptions.armorTextDirection)
                {
                    i = TArmorStatusHudElement.this.width - this.iconWidth - 2;
                    j = (this.elementHeight - this.iconHeight) / 2;
                    k = 2;
                    l = (this.elementHeight - this.textHeight) / 2;
                }
                else
                {
                    i = 2;
                    j = (this.elementHeight - this.iconHeight) / 2;
                    k = 2 + this.iconWidth + 2;
                    l = (this.elementHeight - this.textHeight) / 2;
                }
            }
            else if (PvpOptions.armorTextDirection)
            {
                i = (this.elementWidth - this.iconWidth) / 2;
                j = TArmorStatusHudElement.this.height - this.iconHeight;
                k = (this.elementWidth - this.textWidth) / 2;
                l = 0;
            }
            else
            {
                i = (this.elementWidth - this.iconWidth) / 2;
                j = 0;
                k = (this.elementWidth - this.textWidth) / 2;
                l = this.iconHeight;
            }

            TArmorStatusHudElement.access$500(TArmorStatusHudElement.this, time, this.itemStack, x + i, y + j);
            TArmorStatusHudElement.access$600(TArmorStatusHudElement.this, time, this.itemStack, x + i, y + j);

            if (this.text.length() > 0)
            {
                TArmorStatusHudElement.this.drawText(time, this.text, (float)(x + k), (float)(y + l), 1.0F, false, PvpOptions.armorTextAnimation, PvpOptions.armorTextColor, true);
            }
        }
    }
}
