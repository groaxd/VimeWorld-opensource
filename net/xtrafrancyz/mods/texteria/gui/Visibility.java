package net.xtrafrancyz.mods.texteria.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiCommandBlock;
import net.minecraft.client.gui.GuiEnchantment;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.client.gui.GuiRepair;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.gui.inventory.GuiDispenser;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.gui.inventory.GuiScreenHorseInventory;
import net.minecraft.entity.boss.BossStatus;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.elements.Element2D;
import net.xtrafrancyz.mods.texteria.elements.container.Element2DWrapper;
import net.xtrafrancyz.mods.texteria.elements.container.IWrapper2DContainer;
import net.xtrafrancyz.util.ByteMap;
import org.lwjgl.input.Keyboard;

public class Visibility
{
    public static final Visibility DEFAULT = new Visibility(GuiRenderLayer.HUD, new Visibility.Selector[] {(new Visibility.IngameSelector()).setShow(true), (new Visibility.ChatSelector()).setShow(true)});
    public final Visibility.Selector[] selectors;
    public GuiRenderLayer layer = GuiRenderLayer.HUD;

    public Visibility(ByteMap[] maps)
    {
        List<Visibility.Selector> list = new ArrayList(maps.length);

        for (ByteMap bytemap : maps)
        {
            Visibility.Selector visibility$selector = null;
            String s = bytemap.getString("type");
            byte b0 = -1;

            switch (s.hashCode())
            {
                case -1414557169:
                    if (s.equals("always"))
                    {
                        b0 = 0;
                    }

                    break;

                case -1303953417:
                    if (s.equals("ehover"))
                    {
                        b0 = 12;
                    }

                    break;

                case -1184153961:
                    if (s.equals("ingame"))
                    {
                        b0 = 1;
                    }

                    break;

                case 3213:
                    if (s.equals("f3"))
                    {
                        b0 = 5;
                    }

                    break;

                case 3232:
                    if (s.equals("ee"))
                    {
                        b0 = 9;
                    }

                    break;

                case 101609:
                    if (s.equals("fps"))
                    {
                        b0 = 6;
                    }

                    break;

                case 102715:
                    if (s.equals("gui"))
                    {
                        b0 = 2;
                    }

                    break;

                case 104433:
                    if (s.equals("inv"))
                    {
                        b0 = 3;
                    }

                    break;

                case 114581:
                    if (s.equals("tab"))
                    {
                        b0 = 7;
                    }

                    break;

                case 3052376:
                    if (s.equals("chat"))
                    {
                        b0 = 4;
                    }

                    break;

                case 68611462:
                    if (s.equals("bossbar"))
                    {
                        b0 = 8;
                    }

                    break;

                case 99469628:
                    if (s.equals("hover"))
                    {
                        b0 = 11;
                    }

                    break;

                case 102749521:
                    if (s.equals("layer"))
                    {
                        b0 = 10;
                    }

                    break;

                case 396928109:
                    if (s.equals("evisible"))
                    {
                        b0 = 13;
                    }

                    break;

                case 503739367:
                    if (s.equals("keyboard"))
                    {
                        b0 = 14;
                    }
            }

            switch (b0)
            {
                case 0:
                    visibility$selector = new Visibility.AlwaysSelector();
                    break;

                case 1:
                    visibility$selector = new Visibility.IngameSelector();
                    break;

                case 2:
                    String s1 = bytemap.getString("name", "").toUpperCase(Locale.US);

                    try
                    {
                        visibility$selector = new Visibility.GuiSelector(Visibility.GuiSelector.Type.valueOf(s1));
                    }
                    catch (Exception var13)
                    {
                        Texteria.log.warn("GuiSelector.Type with name " + s1 + " not found");
                    }

                    break;

                case 3:
                    visibility$selector = new Visibility.InventorySelector(bytemap.getString("name"));
                    break;

                case 4:
                    visibility$selector = new Visibility.ChatSelector();
                    break;

                case 5:
                    visibility$selector = new Visibility.F3Selector();
                    break;

                case 6:
                    visibility$selector = new Visibility.FpsSelector();
                    break;

                case 7:
                    visibility$selector = new Visibility.TabSelector();
                    break;

                case 8:
                    visibility$selector = new Visibility.BossBarSelector();
                    break;

                case 9:
                    visibility$selector = new Visibility.ElementExistsSelector(bytemap.getString("id"));
                    break;

                case 10:
                    try
                    {
                        this.layer = GuiRenderLayer.valueOf(bytemap.getString("layer").toUpperCase(Locale.US));
                    }
                    catch (Exception var12)
                    {
                        Texteria.log.warn("GuiRenderLayer with name " + bytemap.getString("layer").toUpperCase(Locale.US) + " not found");
                    }

                    break;

                case 11:
                    visibility$selector = new Visibility.HoverSelector();
                    break;

                case 12:
                    visibility$selector = new Visibility.ElementHoverSelector(bytemap.getString("id"));
                    break;

                case 13:
                    visibility$selector = new Visibility.ElementVisibleSelector(bytemap.getString("id"));
                    break;

                case 14:
                    visibility$selector = new Visibility.KeyboardSelector(bytemap.getInt("key"));
                    break;

                default:
                    throw new IllegalArgumentException("");
            }

            if (visibility$selector != null)
            {
                visibility$selector.show = bytemap.getBoolean("show");
                list.add(visibility$selector);
            }
        }

        this.selectors = (Visibility.Selector[])list.toArray(new Visibility.Selector[0]);
    }

    public Visibility(GuiRenderLayer layer, Visibility.Selector... selectors)
    {
        this.layer = layer;
        this.selectors = selectors;
    }

    public static class AlwaysSelector extends Visibility.Selector
    {
        public boolean acceptable(Minecraft mc, GuiElementWrapper wrapper)
        {
            return true;
        }
    }

    public static class BossBarSelector extends Visibility.Selector
    {
        public boolean acceptable(Minecraft mc, GuiElementWrapper wrapper)
        {
            return BossStatus.bossName != null && BossStatus.statusBarTime > 0;
        }
    }

    public static class ChatSelector extends Visibility.Selector
    {
        public boolean acceptable(Minecraft mc, GuiElementWrapper wrapper)
        {
            return mc.currentScreen instanceof GuiChat;
        }
    }

    public static class ElementExistsSelector extends Visibility.Selector
    {
        private final String id;

        public ElementExistsSelector(String id)
        {
            this.id = id;
        }

        public boolean acceptable(Minecraft mc, GuiElementWrapper wrapper)
        {
            return wrapper.element.parent.getElement(this.id) != null;
        }
    }

    public static class ElementHoverSelector extends Visibility.Selector
    {
        private final String id;

        public ElementHoverSelector(String id)
        {
            this.id = id;
        }

        public boolean acceptable(Minecraft mc, GuiElementWrapper wrapper)
        {
            Element2D element2d = wrapper.element.parent.getElement(this.id);
            return element2d != null && element2d.hover;
        }
    }

    public static class ElementVisibleSelector extends Visibility.Selector
    {
        private final String id;

        public ElementVisibleSelector(String id)
        {
            this.id = id;
        }

        public boolean acceptable(Minecraft mc, GuiElementWrapper wrapper)
        {
            if (wrapper.element.parent instanceof IWrapper2DContainer)
            {
                Element2DWrapper element2dwrapper = ((IWrapper2DContainer)wrapper.element.parent).getElementWrapper(this.id);

                if (element2dwrapper instanceof GuiElementWrapper)
                {
                    return ((GuiElementWrapper)element2dwrapper).visible;
                }
            }

            return false;
        }
    }

    public static class F3Selector extends Visibility.Selector
    {
        public boolean acceptable(Minecraft mc, GuiElementWrapper wrapper)
        {
            return mc.gameSettings.showDebugInfo;
        }
    }

    public static class FpsSelector extends Visibility.Selector
    {
        public boolean acceptable(Minecraft mc, GuiElementWrapper wrapper)
        {
            return mc.gameSettings.ofShowFps && !mc.gameSettings.showDebugInfo;
        }
    }

    public static class GuiSelector extends Visibility.Selector
    {
        private final Visibility.GuiSelector.Type type;

        public GuiSelector(Visibility.GuiSelector.Type type)
        {
            this.type = type;
        }

        public boolean acceptable(Minecraft mc, GuiElementWrapper wrapper)
        {
            return mc.currentScreen != null && mc.currentScreen.getClass() == this.type.clazz;
        }

        public static enum Type
        {
            ENCHANTMENT(GuiEnchantment.class),
            HOPPER(GuiHopper.class),
            MERCHANT(GuiMerchant.class),
            ANVIL(GuiRepair.class),
            BEACON(GuiBeacon.class),
            BREWING_STAND(GuiBrewingStand.class),
            CHEST(GuiChest.class),
            CRAFTING(GuiCrafting.class),
            DISPENSER(GuiDispenser.class),
            FURNACE(GuiFurnace.class),
            HORSE(GuiScreenHorseInventory.class),
            BOOK(GuiScreenBook.class),
            COMMAND_BLOCK(GuiCommandBlock.class),
            SIGN(GuiEditSign.class),
            INVENTORY(GuiInventory.class);

            Class <? extends GuiScreen > clazz;

            private Type(Class <? extends GuiScreen > clazz)
            {
                this.clazz = clazz;
            }
        }
    }

    public static class HoverSelector extends Visibility.Selector
    {
        public boolean acceptable(Minecraft mc, GuiElementWrapper wrapper)
        {
            return wrapper.element.hover;
        }
    }

    public static class IngameSelector extends Visibility.Selector
    {
        public boolean acceptable(Minecraft mc, GuiElementWrapper wrapper)
        {
            return mc.currentScreen == null;
        }
    }

    public static class InventorySelector extends Visibility.Selector
    {
        private final String name;

        public InventorySelector(String name)
        {
            this.name = name;
        }

        public boolean acceptable(Minecraft mc, GuiElementWrapper wrapper)
        {
            return mc.currentScreen instanceof GuiChest ? ((GuiChest)mc.currentScreen).lowerChestInventory.getDisplayName().getUnformattedText().equals(this.name) : false;
        }
    }

    public static class KeyboardSelector extends Visibility.Selector
    {
        private final int key;

        public KeyboardSelector(int key)
        {
            this.key = key;
        }

        public boolean acceptable(Minecraft mc, GuiElementWrapper wrapper)
        {
            return Keyboard.isKeyDown(this.key);
        }
    }

    public abstract static class Selector
    {
        public boolean show;

        public abstract boolean acceptable(Minecraft var1, GuiElementWrapper var2);

        public Visibility.Selector setShow(boolean value)
        {
            this.show = value;
            return this;
        }
    }

    public static class TabSelector extends Visibility.Selector
    {
        public boolean acceptable(Minecraft mc, GuiElementWrapper wrapper)
        {
            return mc.ingameGUI.getTabList().isRendered();
        }
    }
}
