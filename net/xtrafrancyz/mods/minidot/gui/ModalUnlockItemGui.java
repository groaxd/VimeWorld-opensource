package net.xtrafrancyz.mods.minidot.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.EnumChatFormatting;
import net.xtrafrancyz.mods.minidot.MiniDotLayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemRegistry;
import net.xtrafrancyz.util.ByteMap;
import net.xtrafrancyz.util.CommonUtils;

public class ModalUnlockItemGui extends ModalGui
{
    public final int price;
    public final int coins;
    public final BaseItem item;
    private final int BLOCK_SIZE = 75;
    private final int x = 36;
    private final int y = 12;
    private GuiButton btnUnblock;

    public ModalUnlockItemGui(int item, int coins, int price)
    {
        this.price = price;
        this.coins = coins;
        this.item = (BaseItem)ItemRegistry.ITEMS.get(Integer.valueOf(item));
    }

    public void initGui()
    {
        this.parent.btnBack.displayString = "\u041e\u0442\u043c\u0435\u043d\u0430";
        this.parent.btnBack.xPosition = this.parent.guiLeft + 10;
        this.parent.btnBack.setWidth(236);
        int i = this.parent.guiTop + 15;
        int j = this.parent.guiLeft + 99;
        this.parent.addButton(this.btnUnblock = new GuiButton(1101, j + 24, i + 144 - 22, 100, 20, "\u0420\u0430\u0437\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u0442\u044c"));
        this.parent.previewPlayerData.items.put(this.item.getType().slot, this.item);
    }

    protected void onDraw(int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enableRescaleNormal();
        Gui.drawRect(36, 12, 111, 87, -1);
        GlStateManager.pushMatrix();
        GlStateManager.translate(73.0F, 49.0F, 100.0F);
        GlStateManager.scale(-57.0F, 57.0F, 57.0F);
        GlStateManager.rotate(20.0F, -0.1F, 0.0F, 0.0F);
        float f = (float)Minecraft.getMinecraft().globalTickCounter.get() + MiniDotLayer.globalPartialTicks;
        this.item.itemMotion(f, 0);
        this.item.renderAsItem(f);
        GlStateManager.popMatrix();

        if (this.item.discount != 0)
        {
            this.parent.drawString("\u0421\u0442\u043e\u0438\u043c\u043e\u0441\u0442\u044c \u0432\u0435\u0449\u0438:", 3, 90, -13421773);
            this.parent.drawString(EnumChatFormatting.STRIKETHROUGH + CommonUtils.plurals(this.price, "\u043a\u043e\u0438\u043d", "\u043a\u043e\u0438\u043d\u0430", "\u043a\u043e\u0438\u043d\u043e\u0432") + EnumChatFormatting.RESET, 66, 90, -22016);
            this.parent.drawString("\u0421\u043a\u0438\u0434\u043a\u0430 " + EnumChatFormatting.BOLD + this.item.discount + EnumChatFormatting.RESET + "%:", 3, 100, -13421773);
            this.parent.drawString(CommonUtils.plurals((100 - this.item.discount) * this.price / 100, "\u043a\u043e\u0438\u043d", "\u043a\u043e\u0438\u043d\u0430", "\u043a\u043e\u0438\u043d\u043e\u0432"), 66, 100, -16733696);
            this.parent.drawString("\u0423 \u0412\u0430\u0441 \u043a\u043e\u0438\u043d\u043e\u0432:", 3, 110, -13421773);
            this.parent.drawString(this.coins + " \u0448\u0442.", 66, 110, -16733696);
        }
        else
        {
            this.parent.drawString("\u0421\u0442\u043e\u0438\u043c\u043e\u0441\u0442\u044c \u0432\u0435\u0449\u0438:", 3, 95, -13421773);
            this.parent.drawString(this.price + " \u043a\u043e\u0438\u043d\u043e\u0432", 66, 95, -16733696);
            this.parent.drawString("\u0423 \u0412\u0430\u0441 \u043a\u043e\u0438\u043d\u043e\u0432:", 3, 105, -13421773);
            this.parent.drawString(this.coins + " \u0448\u0442.", 66, 105, -16733696);
        }

        this.parent.drawStringCentered("" + EnumChatFormatting.DARK_AQUA + EnumChatFormatting.BOLD + this.item.getName(), 72, 0, -13421773);
    }

    public void actionPerformed(GuiButton btn)
    {
        if (btn.id == 1101)
        {
            this.btnUnblock.displayString = "\u0417\u0430\u0433\u0440\u0443\u0437\u043a\u0430...";
            this.btnUnblock.enabled = false;
            this.parent.btnBack.enabled = false;
            this.sendBuyItem(this.item);
        }
    }

    private void sendBuyItem(BaseItem item)
    {
        ByteMap bytemap = new ByteMap();
        bytemap.put("%", "buy");
        bytemap.put("item", Integer.valueOf(item.id));
        this.md.sendPacket(bytemap);
    }
}
