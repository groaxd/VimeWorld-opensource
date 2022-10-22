package net.xtrafrancyz.mods.minidot.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.xtrafrancyz.mods.minidot.MiniDotLayer;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemCollection;
import net.xtrafrancyz.mods.minidot.items.ItemRegistry;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.head.BaseHelm;
import net.xtrafrancyz.mods.texteria.util.TRenderUtil;
import net.xtrafrancyz.util.ByteMap;

public class ModalSelectItemGui extends ModalGui
{
    private BaseItem[] items = null;
    public final ItemType type;
    public int selectedItem = -1;
    public int wearedItem = -1;
    private final int SIZE;
    private final int PER_PAGE;
    private final int BLOCK_SIZE;
    private final int PADDING;
    private int page = 0;
    private int pages = 0;
    private GuiButton btnSelectBuy;
    private GuiButton btnLeft;
    private GuiButton btnRight;
    private boolean loading = false;
    private static Map<ItemType, ModalSelectItemGui.ScreenState> cachedStates = new HashMap();
    private ModalSelectItemGui.ScreenState state;

    public ModalSelectItemGui(ItemType type)
    {
        this.type = type;

        if (type == ItemType.MASK)
        {
            this.SIZE = 4;
            this.PADDING = 4;
            this.BLOCK_SIZE = 127 / this.SIZE;
        }
        else
        {
            this.SIZE = 3;
            this.PADDING = 3;
            this.BLOCK_SIZE = 133 / this.SIZE;
        }

        this.PER_PAGE = this.SIZE * this.SIZE;
    }

    public void initGui()
    {
        int i = this.parent.guiTop + 15;
        int j = this.parent.guiLeft + 99;
        this.parent.addButton(this.btnSelectBuy = new GuiButton(1001, j - 92, i + 144 + 2, 81, 18, "\u041d\u0430\u0434\u0435\u0442\u044c"));
        this.parent.addButton(this.btnLeft = new GuiButton(1002, j + 107, i + 144 + 2, 18, 18, "<<"));
        this.parent.addButton(this.btnRight = new GuiButton(1003, j + 126, i + 144 + 2, 18, 18, ">>"));
        List<BaseItem> list = ItemRegistry.getItems(this.type);
        list.removeIf((item) ->
        {
            return !this.md.isVisible(item);
        });
        this.items = (BaseItem[])list.toArray(new BaseItem[0]);
        this.pages = MathHelper.ceiling_float_int((float)this.items.length / (float)this.PER_PAGE);

        if (this.pages > 0)
        {
            --this.pages;
        }

        this.state = (ModalSelectItemGui.ScreenState)cachedStates.get(this.type);

        if (this.state == null)
        {
            this.state = new ModalSelectItemGui.ScreenState();
            cachedStates.put(this.type, this.state);
            BaseItem baseitem = (BaseItem)this.md.getLocalPlayer().items.get(this.type.slot);

            if (baseitem != null)
            {
                for (int k = 0; k < this.items.length; ++k)
                {
                    if (this.items[k].equals(baseitem))
                    {
                        this.selectedItem = k;
                        this.wearedItem = k;
                        break;
                    }
                }
            }
        }
        else
        {
            this.page = this.state.page;
            this.selectedItem = this.state.selected;
            BaseItem baseitem1 = (BaseItem)this.md.getLocalPlayer().items.get(this.type.slot);

            if (baseitem1 != null)
            {
                for (int l = 0; l < this.items.length; ++l)
                {
                    if (this.items[l].equals(baseitem1))
                    {
                        this.wearedItem = l;
                        break;
                    }
                }
            }
        }

        if (this.selectedItem == -1)
        {
            this.btnSelectBuy.enabled = false;
        }
        else
        {
            this.updateButtonText();
            this.parent.previewPlayerData.items.put(this.type.slot, this.items[this.selectedItem]);
        }

        if (this.page == 0)
        {
            this.btnLeft.enabled = false;
        }

        if (this.page == this.pages)
        {
            this.btnRight.enabled = false;
        }
    }

    protected void onDraw(int mouseX, int mouseY)
    {
        int int = this.getHoveredItem(mouseX, mouseY);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.enableRescaleNormal();
        GlStateManager.alphaFunc(516, 0.01F);
        Gui.drawRect(0, 0, 144, 144, -8224126);

        for (int int = this.page * this.PER_PAGE; int < (this.page + 1) * this.PER_PAGE && int < this.items.length; ++int)
        {
            int int = this.PADDING + (this.BLOCK_SIZE + this.PADDING) * (int % this.SIZE);
            int int = this.PADDING + (this.BLOCK_SIZE + this.PADDING) * ((int - this.page * this.PER_PAGE) / this.SIZE);
            BaseItem baseitem = this.items[int];

            if (int == this.selectedItem)
            {
                Gui.drawRect(int - 1, int - 1, int + this.BLOCK_SIZE + 1, int + this.BLOCK_SIZE + 1, 1728053247);
            }

            boolean boolean = this.md.isAvailable(baseitem);

            if (baseitem.getCollection().getBackground() != null)
            {
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                Minecraft.getMinecraft().getTextureManager().bindTexture(baseitem.getCollection().getBackground());
                TRenderUtil.drawTexturedRect(int, int, 0.0F, 0.0F, (float)this.BLOCK_SIZE, (float)this.BLOCK_SIZE, (float)this.BLOCK_SIZE, (float)this.BLOCK_SIZE);
            }
            else if (baseitem.getCollection() != ItemCollection.NONE)
            {
                int int = baseitem.getCollection().getBackgroundColor();

                if (int == 0)
                {
                    int = -3356787;
                }

                Gui.drawRect(int, int, int + this.BLOCK_SIZE, int + this.BLOCK_SIZE, int);
                Gui.drawRect(int + 2, int + 2, int + this.BLOCK_SIZE - 2, int + this.BLOCK_SIZE - 2, int == int ? 285212672 : 570425344);
            }
            else
            {
                Gui.drawRect(int, int, int + this.BLOCK_SIZE, int + this.BLOCK_SIZE, int == int ? 1728053247 : 1157627903);
            }

            GlStateManager.pushMatrix();
            GlStateManager.translate((float)int + (float)this.BLOCK_SIZE * 0.5F, (float)int + (float)this.BLOCK_SIZE * 0.5F, 50.0F);
            GlStateManager.scale(-40.0F, 40.0F, 40.0F);
            GlStateManager.rotate(-20.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            RenderHelper.enableGUIStandardItemLighting();
            float float = (float)Minecraft.getMinecraft().globalTickCounter.get() + MiniDotLayer.globalPartialTicks;
            baseitem.itemMotion(float, int);
            baseitem.renderAsItem(float);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.popMatrix();
            ModalSelectItemGui.Once modalselectitemgui$once = new ModalSelectItemGui.Once(() ->
            {
                GlStateManager.pushMatrix();
                GlStateManager.translate(0.0F, 0.0F, 1000.0F);
            });

            if (baseitem.isNew())
            {
                modalselectitemgui$once.run();
                Gui.drawRect(int + this.BLOCK_SIZE - 17, int, int + this.BLOCK_SIZE, int + 7, 1426063360);
                this.parent.drawString(EnumChatFormatting.BOLD + "NEW", int + this.BLOCK_SIZE - 15, int - 1, -6684928);
            }

            if (!boolean && baseitem.discount != 0)
            {
                modalselectitemgui$once.run();
                String string = EnumChatFormatting.BOLD + "-" + baseitem.discount + "%";
                int int = this.parent.getStringWidth(string);
                Gui.drawRect(int, this.BLOCK_SIZE + int - 7, int + int, this.BLOCK_SIZE + int, 1426063360);
                this.parent.drawString(string, int + 1, this.BLOCK_SIZE + int - 8, -256);
            }

            if (int == this.wearedItem)
            {
                modalselectitemgui$once.run();
                Gui.drawRect(int, int + this.BLOCK_SIZE - 10, int + this.BLOCK_SIZE, int + this.BLOCK_SIZE, 1711276032);
                this.parent.drawStringCentered(EnumChatFormatting.BOLD + "\u041d\u0430\u0434\u0435\u0442\u043e", int + this.BLOCK_SIZE / 2 + 1, int + this.BLOCK_SIZE - 10, -1);
            }
            else if (boolean)
            {
                modalselectitemgui$once.run();
                Gui.drawRect(int + 1, int + this.BLOCK_SIZE - 10, int + 10, int + this.BLOCK_SIZE - 1, -8728710);
            }

            if (modalselectitemgui$once.isDone())
            {
                GlStateManager.popMatrix();
            }
        }

        this.parent.drawStringCentered(this.page + 1 + "/" + (this.pages + 1), 94, 151, -13421773);

        if (int != -1)
        {
            BaseItem baseitem1 = this.items[int];
            ArrayList<String> arraylist = new ArrayList();
            arraylist.add("" + EnumChatFormatting.YELLOW + EnumChatFormatting.BOLD + baseitem1.getName());

            if (baseitem1.getCreator() != null)
            {
                arraylist.add("\u0421\u043e\u0437\u0434\u0430\u0442\u0435\u043b\u044c: " + EnumChatFormatting.AQUA + baseitem1.getCreator());
            }

            if (baseitem1.getDescription() != null && !baseitem1.getDescription().isEmpty())
            {
                arraylist.addAll(baseitem1.getDescription());
            }

            if (baseitem1.getCollection().getName() != null)
            {
                arraylist.add(baseitem1.getCollection().getName());
            }

            if (baseitem1 instanceof BaseHelm)
            {
                arraylist.add(EnumChatFormatting.GOLD + "\u041d\u0435 \u043f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442\u0441\u044f, \u0435\u0441\u043b\u0438 \u043d\u0430\u0434\u0435\u0442 \u0448\u043b\u0435\u043c");
            }

            this.parent.drawHoveringText(this.parent.guiLeft + 99 + mouseX, this.parent.guiTop + 15 + mouseY, arraylist);
        }
    }

    private int getHoveredItem(int mouseX, int mouseY)
    {
        if (!this.isInTranslatedBounds(mouseX, mouseY))
        {
            return -1;
        }
        else
        {
            for (int int = this.page * this.PER_PAGE; int < (this.page + 1) * this.PER_PAGE && int < this.items.length; ++int)
            {
                int int = this.PADDING + (this.BLOCK_SIZE + this.PADDING) * (int % this.SIZE);
                int int = this.PADDING + (this.BLOCK_SIZE + this.PADDING) * ((int - this.page * this.PER_PAGE) / this.SIZE);

                if (mouseX >= int && mouseX < int + this.BLOCK_SIZE && mouseY >= int && mouseY < int + this.BLOCK_SIZE)
                {
                    return int;
                }
            }

            return -1;
        }
    }

    protected boolean onMouseClicked(int mouseX, int mouseY, int mouseButton)
    {
        if (this.loading)
        {
            return false;
        }
        else
        {
            int int = this.getHoveredItem(mouseX, mouseY);

            if (int != -1)
            {
                this.selectedItem = int;
                this.state.selected = int;
                this.parent.previewPlayerData.items.put(this.type.slot, this.items[this.selectedItem]);
                this.updateButtonText();
            }

            return false;
        }
    }

    private void updateButtonText()
    {
        if (this.loading)
        {
            this.btnSelectBuy.enabled = false;
            this.parent.btnBack.enabled = false;
            this.btnSelectBuy.displayString = "\u0417\u0430\u0433\u0440\u0443\u0437\u043a\u0430...";
        }
        else
        {
            this.parent.btnBack.enabled = true;
            this.btnSelectBuy.enabled = true;
            MiniDotPlayer minidotplayer = this.md.getLocalPlayer();

            if (this.items[this.selectedItem].equals(minidotplayer.items.get(this.type.slot)))
            {
                this.btnSelectBuy.displayString = "\u0421\u043d\u044f\u0442\u044c";
            }
            else if (this.md.isAvailable(this.items[this.selectedItem]))
            {
                this.btnSelectBuy.displayString = "\u041d\u0430\u0434\u0435\u0442\u044c";
            }
            else
            {
                this.btnSelectBuy.displayString = "\u0420\u0430\u0437\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u0442\u044c";
            }
        }
    }

    public void scroll(int num)
    {
        if (num > 0)
        {
            if (this.page == 0)
            {
                return;
            }

            --this.page;
            this.btnRight.enabled = true;

            if (this.page == 0)
            {
                this.btnLeft.enabled = false;
            }

            this.state.page = this.page;
        }
        else if (num < 0)
        {
            if (this.page == this.pages)
            {
                return;
            }

            ++this.page;
            this.btnLeft.enabled = true;

            if (this.page == this.pages)
            {
                this.btnRight.enabled = false;
            }

            this.state.page = this.page;
        }
    }

    public void actionPerformed(GuiButton btn)
    {
        MiniDotPlayer minidotplayer = this.md.getLocalPlayer();

        switch (btn.id)
        {
            case 1001:
                if (this.items[this.selectedItem].equals(minidotplayer.items.get(this.type.slot)))
                {
                    minidotplayer.items.remove(this.type.slot);
                    this.wearedItem = -1;
                    this.sendDressedItems();
                }
                else if (this.md.isAvailable(this.items[this.selectedItem]))
                {
                    minidotplayer.items.put(this.type.slot, this.items[this.selectedItem]);
                    this.wearedItem = this.selectedItem;
                    this.sendDressedItems();
                }
                else
                {
                    this.sendBuyRequest(this.items[this.selectedItem]);
                    this.loading = true;
                }

                this.updateButtonText();
                break;

            case 1002:
                this.scroll(1);
                break;

            case 1003:
                this.scroll(-1);
        }
    }

    private void sendDressedItems()
    {
        ByteMap bytemap = new ByteMap();
        bytemap.put("%", "wear");
        Map<String, BaseItem> map = this.md.getLocalPlayer().items;
        int[] aint = new int[map.size()];
        Iterator<BaseItem> iterator = map.values().iterator();

        for (int int = 0; iterator.hasNext(); ++int)
        {
            aint[int] = ((BaseItem)iterator.next()).id;
        }

        bytemap.put("items", aint);
        this.md.sendPacket(bytemap);
    }

    private void sendBuyRequest(BaseItem item)
    {
        ByteMap bytemap = new ByteMap();
        bytemap.put("%", "buy-request");
        bytemap.put("item", Integer.valueOf(item.id));
        this.md.sendPacket(bytemap);
    }

    private static class Once
    {
        private boolean done = false;
        private Runnable task;

        public Once(Runnable task)
        {
            this.task = task;
        }

        public void run()
        {
            if (!this.done)
            {
                this.task.run();
                this.done = true;
            }
        }

        public boolean isDone()
        {
            return this.done;
        }
    }

    private static class ScreenState
    {
        public int page;
        public int selected;

        private ScreenState()
        {
            this.page = 0;
            this.selected = -1;
        }
    }
}
