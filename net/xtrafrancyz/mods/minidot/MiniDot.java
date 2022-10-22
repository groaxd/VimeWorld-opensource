package net.xtrafrancyz.mods.minidot;

import io.netty.buffer.Unpooled;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.network.play.server.S3FPacketCustomPayload;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.xtrafrancyz.mods.minidot.gui.MGuiMain;
import net.xtrafrancyz.mods.minidot.gui.ModalSelectItemGui;
import net.xtrafrancyz.mods.minidot.gui.ModalUnlockItemGui;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemCollection;
import net.xtrafrancyz.mods.minidot.items.ItemRegistry;
import net.xtrafrancyz.util.ByteMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MiniDot
{
    public static final MiniDot instance = new MiniDot();
    public static final Logger log = LogManager.getLogger("MiniDot");
    private boolean enabled = false;
    private Minecraft mc;
    private final Map<UUID, MiniDotPlayer> playersData = new HashMap();
    private final Set<BaseItem> availableItems = new HashSet();
    private final Set<String> openCollections = new HashSet();

    public void init(Minecraft mc)
    {
        this.mc = mc;
        Minecraft.registeredPluginChannels.add("MiniDot");
    }

    public MiniDotPlayer getPlayer(UUID uuid)
    {
        return (MiniDotPlayer)this.playersData.computeIfAbsent(uuid, (u) ->
        {
            return new MiniDotPlayer();
        });
    }

    public MiniDotPlayer getLocalPlayer()
    {
        return this.getPlayer(this.mc.getSession().getProfile().getId());
    }

    public void setLocalPlayer(MiniDotPlayer player)
    {
        this.playersData.put(this.mc.getSession().getProfile().getId(), player);
    }

    public boolean isAvailable(BaseItem item)
    {
        return this.availableItems.contains(item);
    }

    public boolean isVisible(BaseItem item)
    {
        ItemCollection itemcollection = item.getCollection();
        return itemcollection.isVisible() || this.availableItems.contains(item) || this.openCollections.contains(itemcollection.name().toLowerCase());
    }

    public boolean isEnabled()
    {
        return this.enabled;
    }

    public void handleDisconnect()
    {
        if (this.mc != null)
        {
            this.availableItems.clear();
            this.openCollections.clear();

            for (BaseItem baseitem : ItemRegistry.ITEMS.values())
            {
                baseitem.discount = 0;
            }

            this.playersData.clear();
            this.enabled = false;
        }
    }

    public void handleJoinGame()
    {
        this.enabled = this.mc.isIntegratedServerRunning();
    }

    public void handleMiniDotPacket(S3FPacketCustomPayload packet)
    {
        this.enabled = true;
        ByteMap bytemap = new ByteMap(packet.getBufferData());
        String string = bytemap.getString("%", "");
        byte bytex = -1;

        switch (string.hashCode())
        {
            case -934610812:
                if (string.equals("remove"))
                {
                    bytex = 4;
                }

                break;

            case -733902135:
                if (string.equals("available"))
                {
                    bytex = 0;
                }

                break;

            case -690212803:
                if (string.equals("registry"))
                {
                    bytex = 1;
                }

                break;

            case 113762:
                if (string.equals("set"))
                {
                    bytex = 2;
                }

                break;

            case 1895567272:
                if (string.equals("buy-response"))
                {
                    bytex = 6;
                }

                break;

            case 1983818166:
                if (string.equals("set-all"))
                {
                    bytex = 3;
                }

                break;

            case 2107309864:
                if (string.equals("item-info"))
                {
                    bytex = 5;
                }
        }

        switch (bytex)
        {
            case 0:
                this.availableItems.clear();

                for (int int : bytemap.getIntArray("list"))
                {
                    BaseItem baseitem3 = (BaseItem)ItemRegistry.ITEMS.get(Integer.valueOf(int));

                    if (baseitem3 != null)
                    {
                        this.availableItems.add(baseitem3);
                    }
                }

                return;

            case 1:
                this.openCollections.clear();
                String[] astring = bytemap.getStringArray("openCollections");

                if (astring != null)
                {
                    this.openCollections.addAll(Arrays.<String>asList(astring));
                }

                for (BaseItem baseitem2 : ItemRegistry.ITEMS.values())
                {
                    baseitem2.discount = 0;
                }

                int[] aint = bytemap.getIntArray("d.items");
                int[] aint1 = bytemap.getIntArray("d.discount");

                if (aint != null)
                {
                    for (int int = 0; int < aint.length; ++int)
                    {
                        BaseItem baseitem1 = (BaseItem)ItemRegistry.ITEMS.get(Integer.valueOf(aint[int]));

                        if (baseitem1 != null)
                        {
                            baseitem1.discount = aint1[int];
                        }
                    }
                }

                break;

            case 2:
                this.readPlayer(bytemap);
                break;

            case 3:
                this.playersData.clear();

                for (ByteMap bytemap1 : bytemap.getMapArray("data"))
                {
                    this.readPlayer(bytemap1);
                }

                return;

            case 4:
                this.playersData.remove(bytemap.getUUID("uuid"));
                break;

            case 5:
                String string2 = bytemap.getString("status");
                byte byte = -1;

                switch (string2.hashCode())
                {
                    case -733902135:
                        if (string2.equals("available"))
                        {
                            byte = 1;
                        }

                        break;

                    case 3151468:
                        if (string2.equals("free"))
                        {
                            byte = 2;
                        }

                        break;

                    case 253684815:
                        if (string2.equals("not-available"))
                        {
                            byte = 3;
                        }

                        break;

                    case 1582872719:
                        if (string2.equals("notfound"))
                        {
                            byte = 0;
                        }

                        break;

                    case 1978314576:
                        if (string2.equals("selling"))
                        {
                            byte = 4;
                        }
                }

                switch (byte)
                {
                    case 0:
                        this.printErrorMessage("\u0412\u044b \u0445\u043e\u0442\u0438\u0442\u0435 \u043a\u0443\u043f\u0438\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442, \u043a\u043e\u0442\u043e\u0440\u043e\u0433\u043e \u0435\u0449\u0435 \u043d\u0435\u0442 \u043d\u0430 \u0441\u0435\u0440\u0432\u0435\u0440\u0435.");
                        return;

                    case 1:
                        this.printErrorMessage("\u0412\u044b \u0445\u043e\u0442\u0438\u0442\u0435 \u043a\u0443\u043f\u0438\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442, \u043a\u043e\u0442\u043e\u0440\u044b\u0439 \u0443 \u0432\u0430\u0441 \u0443\u0436\u0435 \u0435\u0441\u0442\u044c.");
                        return;

                    case 2:
                        this.printErrorMessage("\u0412\u044b \u0445\u043e\u0442\u0438\u0442\u0435 \u043a\u0443\u043f\u0438\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442, \u043d\u043e \u043e\u043d \u0431\u0435\u0441\u043f\u043b\u0430\u0442\u043d\u044b\u0439.");
                        return;

                    case 3:
                        this.printErrorMessage("\u042d\u0442\u043e\u0442 \u043f\u0440\u0435\u0434\u043c\u0435\u0442 \u043d\u0435\u043b\u044c\u0437\u044f \u043a\u0443\u043f\u0438\u0442\u044c.");
                        return;

                    case 4:
                        this.ensureMIGuiOpen().setModal(new ModalUnlockItemGui(bytemap.getInt("item"), bytemap.getInt("balance"), bytemap.getInt("price")));
                        return;

                    default:
                        return;
                }

            case 6:
                String openCollections = bytemap.getString("status");
                byte ditems = -1;

                switch (openCollections.hashCode())
                {
                    case -1867169789:
                        if (openCollections.equals("success"))
                        {
                            ditems = 5;
                        }

                        break;

                    case -733902135:
                        if (openCollections.equals("available"))
                        {
                            ditems = 1;
                        }

                        break;

                    case 3151468:
                        if (openCollections.equals("free"))
                        {
                            ditems = 2;
                        }

                        break;

                    case 253684815:
                        if (openCollections.equals("not-available"))
                        {
                            ditems = 4;
                        }

                        break;

                    case 273931268:
                        if (openCollections.equals("insufficient-funds"))
                        {
                            ditems = 3;
                        }

                        break;

                    case 1582872719:
                        if (openCollections.equals("notfound"))
                        {
                            ditems = 0;
                        }
                }

                switch (ditems)
                {
                    case 0:
                        this.printErrorMessage("\u0412\u044b \u0445\u043e\u0442\u0438\u0442\u0435 \u043a\u0443\u043f\u0438\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442, \u043a\u043e\u0442\u043e\u0440\u043e\u0433\u043e \u0435\u0449\u0435 \u043d\u0435\u0442 \u043d\u0430 \u0441\u0435\u0440\u0432\u0435\u0440\u0435.");
                        break;

                    case 1:
                        this.printErrorMessage("\u0412\u044b \u0445\u043e\u0442\u0438\u0442\u0435 \u043a\u0443\u043f\u0438\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442, \u043a\u043e\u0442\u043e\u0440\u044b\u0439 \u0443 \u0432\u0430\u0441 \u0443\u0436\u0435 \u0435\u0441\u0442\u044c.");
                        break;

                    case 2:
                        this.printErrorMessage("\u0412\u044b \u0445\u043e\u0442\u0438\u0442\u0435 \u043a\u0443\u043f\u0438\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442, \u043d\u043e \u043e\u043d \u0431\u0435\u0441\u043f\u043b\u0430\u0442\u043d\u044b\u0439.");
                        break;

                    case 3:
                        this.printErrorMessage("\u0414\u043b\u044f \u043f\u043e\u043a\u0443\u043f\u043a\u0438 \u043d\u0435\u0434\u043e\u0441\u0442\u0430\u0442\u043e\u0447\u043d\u043e \u0434\u0435\u043d\u0435\u0433.");
                        break;

                    case 4:
                        this.printErrorMessage("\u042d\u0442\u043e\u0442 \u043f\u0440\u0435\u0434\u043c\u0435\u0442 \u043d\u0435\u043b\u044c\u0437\u044f \u043a\u0443\u043f\u0438\u0442\u044c.");
                        break;

                    case 5:
                        BaseItem baseitem = (BaseItem)ItemRegistry.ITEMS.get(Integer.valueOf(bytemap.getInt("item")));
                        this.ensureMIGuiOpen().setModal(new ModalSelectItemGui(baseitem.getType()));
                }
        }
    }

    private void readPlayer(ByteMap map)
    {
        MiniDotPlayer minidotplayer = this.getPlayer(map.getUUID("uuid"));
        minidotplayer.items.clear();

        for (int int : map.getIntArray("dressed"))
        {
            BaseItem baseitem = (BaseItem)ItemRegistry.ITEMS.get(Integer.valueOf(int));

            if (baseitem != null)
            {
                minidotplayer.items.put(baseitem.getType().slot, baseitem);
            }
        }
    }

    private MGuiMain ensureMIGuiOpen()
    {
        if (!(this.mc.currentScreen instanceof MGuiMain))
        {
            this.mc.displayGuiScreen(new MGuiMain());
        }

        return (MGuiMain)this.mc.currentScreen;
    }

    private void printErrorMessage(String message)
    {
        this.mc.thePlayer.closeScreen();
        this.mc.thePlayer.addChatMessage((new ChatComponentText("\u041e\u0448\u0438\u0431\u043a\u0430. " + message)).setChatStyle((new ChatStyle()).setColor(EnumChatFormatting.RED)));
    }

    public void sendPacket(ByteMap map)
    {
        if (this.mc.isIntegratedServerRunning())
        {
            String string = map.getString("%");
            byte byte = -1;

            switch (string.hashCode())
            {
                case 1029271112:
                    if (string.equals("buy-request"))
                    {
                        byte = 0;
                    }

                default:
                    switch (byte)
                    {
                        case 0:
                            BaseItem baseitem = (BaseItem)ItemRegistry.ITEMS.get(Integer.valueOf(map.getInt("item")));
                            this.availableItems.add(baseitem);
                            this.ensureMIGuiOpen().setModal(new ModalSelectItemGui(baseitem.getType()));
                    }
            }
        }
        else
        {
            this.mc.getNetHandler().addToSendQueue(new C17PacketCustomPayload("MiniDot", new PacketBuffer(Unpooled.wrappedBuffer(map.toByteArray()))));
        }
    }
}
