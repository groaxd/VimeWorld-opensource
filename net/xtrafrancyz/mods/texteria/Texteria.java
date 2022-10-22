package net.xtrafrancyz.mods.texteria;

import io.netty.buffer.Unpooled;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.util.StringUtils;
import net.xtrafrancyz.VimeStorage;
import net.xtrafrancyz.mods.texteria.elements.Element2D;
import net.xtrafrancyz.mods.texteria.elements.Image;
import net.xtrafrancyz.mods.texteria.elements.Text;
import net.xtrafrancyz.mods.texteria.elements.TextClock;
import net.xtrafrancyz.mods.texteria.gui.GuiElementWrapper;
import net.xtrafrancyz.mods.texteria.gui.GuiRenderLayer;
import net.xtrafrancyz.mods.texteria.gui.TexteriaGui;
import net.xtrafrancyz.mods.texteria.keyboard.TexteriaKeyboard;
import net.xtrafrancyz.mods.texteria.resources.TexteriaResourceManager;
import net.xtrafrancyz.mods.texteria.scripting.ScriptManager;
import net.xtrafrancyz.mods.texteria.sound.TexteriaSound;
import net.xtrafrancyz.mods.texteria.world.TexteriaWorld;
import net.xtrafrancyz.mods.texteria.world.elements.Element3D;
import net.xtrafrancyz.util.ByteMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Texteria implements IResourceManagerReloadListener
{
    public static final boolean debug = Boolean.getBoolean("Texteria.debug");
    public static final Texteria instance = new Texteria();
    public static final Logger log = LogManager.getLogger("Texteria");
    public static final String STORAGE_RELATIVE_PATH = "texteria/cache";
    public static long time = System.currentTimeMillis();
    public TexteriaGui gui;
    public TexteriaWorld world;
    public ScriptManager scriptManager;
    public VimeStorage storage;
    public TexteriaResourceManager resourceManager;
    public TexteriaKeyboard keyboard;
    TexteriaSound sound;
    public TexteriaPacketHandler packetHandler;
    private Minecraft mc;

    public void init(Minecraft mc)
    {
        this.mc = mc;
        File file1 = new File(Minecraft.getMinecraft().mcDataDir, "texteria");
        this.storage = new VimeStorage(new File(file1, "cacheIndex.bin"), new File(file1, "cache"));
        this.resourceManager = new TexteriaResourceManager();
        this.scriptManager = new ScriptManager(this);
        this.gui = new TexteriaGui(mc);
        this.world = new TexteriaWorld(mc);
        this.keyboard = new TexteriaKeyboard();
        this.sound = new TexteriaSound(mc);

        if (mc.getResourceManager() instanceof IReloadableResourceManager)
        {
            ((IReloadableResourceManager)mc.getResourceManager()).registerReloadListener(this);
        }

        this.packetHandler = new TexteriaPacketHandler(this);
        Minecraft.registeredPluginChannels.add("Texteria");
    }

    public void onResourceManagerReload(IResourceManager resourceManager)
    {
        this.gui.onResourceManagerReload();

        for (Element3D element3d : this.world.elements.getAll())
        {
            element3d.reload();
        }

        this.sound.onResourceManagerReload();
    }

    public void onWorldChanged()
    {
        if (this.mc != null)
        {
            this.sound.clear();
        }
    }

    public void handleDisconnect()
    {
        TexteriaOptions.reset();
        this.onWorldChanged();

        if (this.mc != null)
        {
            this.gui.clearNow();
            this.world.elements.clearNow();
            this.world.particles.clearNow();
            this.world.boxes.clearNow();
            this.keyboard.clear();
        }
    }

    public void stop()
    {
        this.storage.shutdown();
    }

    public boolean handleMouseEvent()
    {
        if (this.mc.theWorld == null)
        {
            return false;
        }
        else
        {
            int i = Mouse.getEventDWheel();
            boolean flag = Mouse.getEventButtonState();

            if (i == 0 && !flag)
            {
                return false;
            }
            else
            {
                i = Integer.compare(i, 0);
                boolean flag1 = false;
                int j = 0;

                if (flag)
                {
                    j = Mouse.getEventButton();
                }

                if (this.mc.currentScreen == null)
                {
                    Element3D[] aelement3d = this.world.elements.getCachedSortedVisible();

                    for (int k = aelement3d.length - 1; k >= 0; --k)
                    {
                        Element3D element3d = aelement3d[k];

                        if (element3d.hover)
                        {
                            if (flag)
                            {
                                flag1 = element3d.mouseClick(j);
                            }

                            if (i != 0)
                            {
                                flag1 = flag1 || element3d.mouseWheel(i);
                            }

                            if (flag1)
                            {
                                break;
                            }
                        }
                    }
                }
                else
                {
                    for (GuiRenderLayer guirenderlayer : GuiRenderLayer.REVERSED_RENDER_ORDER)
                    {
                        List<GuiElementWrapper> list = (List)this.gui.elements.get(guirenderlayer);
                        ListIterator<GuiElementWrapper> listiterator = list.listIterator(list.size());

                        while (listiterator.hasPrevious() && !flag1)
                        {
                            GuiElementWrapper guielementwrapper = (GuiElementWrapper)listiterator.previous();

                            if (guielementwrapper.visible && guielementwrapper.element.hover)
                            {
                                if (flag)
                                {
                                    flag1 = guielementwrapper.element.mouseClick(0, 0, j);
                                }

                                if (i != 0)
                                {
                                    flag1 = flag1 || guielementwrapper.element.mouseWheel(i);
                                }
                            }
                        }
                    }
                }

                return flag1;
            }
        }
    }

    public boolean handleKeyboardEvent()
    {
        if (debug)
        {
            int i = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey();

            if (i == 36 && Keyboard.isKeyDown(157))
            {
                Image.debugSaveAtlases();
            }
        }

        return this.keyboard.handleKeyboardEvent();
    }

    public static void printDebug(String str)
    {
        if (debug)
        {
            log.info("[Texteria] " + str);
        }
    }

    public static void printDebug(String str, Object... args)
    {
        if (debug)
        {
            log.info("[Texteria] " + str, args);
        }
    }

    public static void sendCallbackPacket(ByteMap data)
    {
        ByteMap bytemap = new ByteMap();
        bytemap.put("%", "callback");
        bytemap.put("data", data);
        sendPacket(bytemap);
    }

    public static void sendPacket(ByteMap map)
    {
        Minecraft.getMinecraft().getNetHandler().addToSendQueue(new C17PacketCustomPayload("Texteria", new PacketBuffer(Unpooled.wrappedBuffer(map.toByteArray()))));
    }

    public static String tryGetServerId(String fallback)
    {
        Element2D element2d = instance.gui.getElement("vn.s");

        if (element2d instanceof Text)
        {
            String s = StringUtils.stripControlCodes(((Text)element2d).text[0]);
            return s.contains(" ") ? s.split(" ", 2)[0] : s;
        }
        else
        {
            return fallback;
        }
    }

    public static String tryGetServerTime(String fallback)
    {
        Element2D element2d = instance.gui.getElement("vn.s");

        if (element2d instanceof Text)
        {
            if (element2d instanceof TextClock)
            {
                ((TextClock)element2d).updateClock();
            }

            String s = StringUtils.stripControlCodes(((Text)element2d).text[0]);
            return s.contains(" ") ? s.split(" ", 2)[1] : fallback;
        }
        else
        {
            return fallback;
        }
    }
}
