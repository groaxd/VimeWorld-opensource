package net.xtrafrancyz.mods.pvp;

import java.util.ArrayDeque;
import java.util.Queue;
import net.minecraft.client.Minecraft;
import net.xtrafrancyz.covered.Reflect;
import net.xtrafrancyz.mods.pvp.gui.hud.TArmorStatusHudElement;
import net.xtrafrancyz.mods.pvp.gui.hud.TEffectHudElement;
import net.xtrafrancyz.mods.pvp.gui.hud.TKeystrokesHudElement;
import net.xtrafrancyz.mods.pvp.gui.hud.TNetworkInfoHudElement;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.gui.GuiElementWrapper;
import net.xtrafrancyz.mods.texteria.gui.TexteriaGui;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PvPMod
{
    public static final PvPMod instance = new PvPMod();
    public static final Logger log = LogManager.getLogger("PvPMod");
    public static PvPMod.ClickCounter leftMouseCounter = new PvPMod.ClickCounter();
    public static PvPMod.ClickCounter rightMouseCounter = new PvPMod.ClickCounter();

    public void init(Minecraft mc)
    {
        PvpOptions.load(mc);
        TEffectHudElement.applyOptions();
        TArmorStatusHudElement.applyOptions();
        TKeystrokesHudElement.applyOptions();
        TNetworkInfoHudElement.applyOptions();
    }

    public static void addOrRemove(GuiElementWrapper wrapper, boolean add)
    {
        TexteriaGui texteriagui = Texteria.instance.gui;

        if (add)
        {
            if (texteriagui.getElement(wrapper.element.id) == null)
            {
                Reflect.invoke((Object)texteriagui, "addPersistentElement", new Object[] {wrapper});
            }
        }
        else
        {
            Reflect.invoke((Object)texteriagui, "removePersistentElement", new Object[] {wrapper.element.id});
        }
    }

    public static class ClickCounter
    {
        private final Queue<Long> clicks = new ArrayDeque();

        public void onClick()
        {
            this.clicks.add(Long.valueOf(this.check() + 1000L));
        }

        public int getCPS()
        {
            this.check();
            return this.clicks.size();
        }

        private long check()
        {
            long i = Minecraft.getSystemTime();

            while (!this.clicks.isEmpty() && ((Long)this.clicks.peek()).longValue() < i)
            {
                this.clicks.remove();
            }

            return i;
        }
    }
}
