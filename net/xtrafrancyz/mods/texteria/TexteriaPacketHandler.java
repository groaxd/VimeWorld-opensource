package net.xtrafrancyz.mods.texteria;

import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S3FPacketCustomPayload;
import net.xtrafrancyz.mods.texteria.elements.Element2D;
import net.xtrafrancyz.mods.texteria.gui.GuiElementWrapper;
import net.xtrafrancyz.mods.texteria.gui.TexteriaGui;
import net.xtrafrancyz.mods.texteria.gui.TexteriaGuiScreen;
import net.xtrafrancyz.mods.texteria.gui.TexteriaGuiScreenContainer;
import net.xtrafrancyz.mods.texteria.gui.Visibility;
import net.xtrafrancyz.mods.texteria.sound.TSound;
import net.xtrafrancyz.mods.texteria.world.TexteriaWorld;
import net.xtrafrancyz.mods.texteria.world.aabb.BoundingBox;
import net.xtrafrancyz.mods.texteria.world.elements.Beam;
import net.xtrafrancyz.mods.texteria.world.elements.DirectDraw;
import net.xtrafrancyz.mods.texteria.world.elements.Element3D;
import net.xtrafrancyz.mods.texteria.world.elements.Line;
import net.xtrafrancyz.mods.texteria.world.elements.WorldGroup;
import net.xtrafrancyz.mods.texteria.world.particle.Particle;
import net.xtrafrancyz.mods.texteria.world.particle.ParticleConfig;
import net.xtrafrancyz.util.ByteMap;
import net.xtrafrancyz.util.CommonUtils;

public class TexteriaPacketHandler
{
    private static final boolean printPackets = Boolean.getBoolean("Texteria.printPackets");
    private final Texteria texteria;
    private final TexteriaGui gui;
    private final TexteriaWorld world;

    public TexteriaPacketHandler(Texteria texteria)
    {
        this.texteria = texteria;
        this.gui = texteria.gui;
        this.world = texteria.world;
    }

    public void handleTexteriaPacket(S3FPacketCustomPayload packet)
    {
        Texteria.time = System.currentTimeMillis();

        try
        {
            PacketBuffer packetbuffer = packet.getBufferData();
            int i = packetbuffer.readableBytes();
            int j = packetbuffer.readVarIntFromBuffer();

            if (printPackets)
            {
                Texteria.printDebug("Received packet length {} with {} actions", new Object[] {Integer.valueOf(i), Integer.valueOf(j)});
            }

            for (int k = 0; k < j; ++k)
            {
                byte[] abyte = new byte[packetbuffer.readVarIntFromBuffer()];
                packetbuffer.readBytes(abyte);
                ByteMap bytemap = null;

                try
                {
                    this.handleAction(new ByteMap(abyte));
                }
                catch (Exception exception)
                {
                    Texteria.log.warn((String)("Could not handle Texteria action (" + bytemap + ")"), (Throwable)exception);
                }
            }
        }
        catch (Exception exception1)
        {
            Texteria.log.warn((String)"Can\'t handle Texteria packet", (Throwable)exception1);
        }
    }

    private void handleAction(ByteMap map) throws Exception
    {
        if (printPackets)
        {
            Texteria.printDebug("Handle action {}", new Object[] {map.toString()});
        }

        String s = map.getString("%");
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -2137498640:
                if (s.equals("keyboard:bind"))
                {
                    b0 = 23;
                }

                break;

            case -1823286276:
                if (s.equals("keyboard:reset"))
                {
                    b0 = 25;
                }

                break;

            case -1396981145:
                if (s.equals("bb:add"))
                {
                    b0 = 18;
                }

                break;

            case -1378331476:
                if (s.equals("3d:edit:in"))
                {
                    b0 = 16;
                }

                break;

            case -1270519733:
                if (s.equals("add:bulk"))
                {
                    b0 = 2;
                }

                break;

            case -990465795:
                if (s.equals("3d:add:to"))
                {
                    b0 = 15;
                }

                break;

            case -928755742:
                if (s.equals("rm:all"))
                {
                    b0 = 6;
                }

                break;

            case -856935711:
                if (s.equals("animate"))
                {
                    b0 = 8;
                }

                break;

            case -726874522:
                if (s.equals("add:group"))
                {
                    b0 = 3;
                }

                break;

            case -687468681:
                if (s.equals("keyboard:remove"))
                {
                    b0 = 24;
                }

                break;

            case -496672533:
                if (s.equals("3d:rm:all"))
                {
                    b0 = 14;
                }

                break;

            case -376740161:
                if (s.equals("sound:play"))
                {
                    b0 = 26;
                }

                break;

            case -376642675:
                if (s.equals("sound:stop"))
                {
                    b0 = 27;
                }

                break;

            case -356623100:
                if (s.equals("bb:edit"))
                {
                    b0 = 20;
                }

                break;

            case -341064690:
                if (s.equals("resource"))
                {
                    b0 = 29;
                }

                break;

            case 52223:
                if (s.equals("3dp"))
                {
                    b0 = 10;
                }

                break;

            case 96417:
                if (s.equals("add"))
                {
                    b0 = 1;
                }

                break;

            case 102715:
                if (s.equals("gui"))
                {
                    b0 = 9;
                }

                break;

            case 116079:
                if (s.equals("url"))
                {
                    b0 = 21;
                }

                break;

            case 3108362:
                if (s.equals("edit"))
                {
                    b0 = 7;
                }

                break;

            case 50138052:
                if (s.equals("3d:rm"))
                {
                    b0 = 13;
                }

                break;

            case 93483957:
                if (s.equals("bb:rm"))
                {
                    b0 = 19;
                }

                break;

            case 108404047:
                if (s.equals("reset"))
                {
                    b0 = 0;
                }

                break;

            case 108587706:
                if (s.equals("rm:id"))
                {
                    b0 = 4;
                }

                break;

            case 208141966:
                if (s.equals("keyboard:add"))
                {
                    b0 = 22;
                }

                break;

            case 824656000:
                if (s.equals("rm:group"))
                {
                    b0 = 5;
                }

                break;

            case 937635155:
                if (s.equals("3d:edit"))
                {
                    b0 = 12;
                }

                break;

            case 1372807133:
                if (s.equals("option:set"))
                {
                    b0 = 28;
                }

                break;

            case 1554263096:
                if (s.equals("3d:add"))
                {
                    b0 = 11;
                }

                break;

            case 1783175584:
                if (s.equals("3d:rm:from"))
                {
                    b0 = 17;
                }
        }

        switch (b0)
        {
            case 0:
                this.texteria.handleDisconnect();
                break;

            case 1:
                this.gui.addElement(new GuiElementWrapper(map, this.gui));
                break;

            case 2:
                for (ByteMap bytemap1 : map.getMapArray("e"))
                {
                    this.gui.addElement(new GuiElementWrapper(bytemap1, this.gui));
                }

                return;

            case 3:
                Visibility visibility = Visibility.DEFAULT;

                if (map.containsKey("vis"))
                {
                    visibility = new Visibility(map.getMapArray("vis"));
                }

                ByteMap[] abytemap = map.getMapArray("e");

                for (ByteMap bytemap : abytemap)
                {
                    GuiElementWrapper guielementwrapper = new GuiElementWrapper(bytemap, this.gui);
                    guielementwrapper.visibility = visibility;
                    this.gui.addElement(guielementwrapper);
                }

                return;

            case 4:
                this.gui.removeElement(map.getString("id"));
                break;

            case 5:
                String s3 = map.getString("group");

                if (s3.endsWith("*"))
                {
                    s3 = s3.substring(0, s3.length() - 1);
                }

                this.gui.removeGroup(s3);
                break;

            case 6:
                this.gui.clear();
                break;

            case 7:
                Element2D element2d1 = this.gui.getElement(map.getString("id"));

                if (element2d1 != null)
                {
                    element2d1.edit(map.getMap("data"));
                }

                break;

            case 8:
                Element2D element2d = this.gui.getElement(map.getString("id"));

                if (element2d != null)
                {
                    element2d.playAnimation(map.getMap("data"));
                }

                break;

            case 9:
                TexteriaGuiScreenContainer texteriaguiscreencontainer = new TexteriaGuiScreenContainer(map);
                texteriaguiscreencontainer.screen = new TexteriaGuiScreen(map, texteriaguiscreencontainer);
                texteriaguiscreencontainer.wrapper = new GuiElementWrapper(texteriaguiscreencontainer, this.gui);
                texteriaguiscreencontainer.load();
                this.gui.addElement(texteriaguiscreencontainer.wrapper);
                Minecraft.getMinecraft().displayGuiScreen(texteriaguiscreencontainer.screen);
                break;

            case 10:
                int j = map.getInt("am", 1);
                ParticleConfig particleconfig = new ParticleConfig(map);

                for (int i = 0; i < j; ++i)
                {
                    this.world.particles.add(new Particle(particleconfig));
                }

                return;

            case 11:
                String s2 = map.getString("type", "group");
                byte element = -1;

                switch (s2.hashCode())
                {
                    case -1331586071:
                        if (s2.equals("direct"))
                        {
                            element = 3;
                        }

                        break;

                    case 3019695:
                        if (s2.equals("beam"))
                        {
                            element = 1;
                        }

                        break;

                    case 3321844:
                        if (s2.equals("line"))
                        {
                            element = 2;
                        }

                        break;

                    case 98629247:
                        if (s2.equals("group"))
                        {
                            element = 0;
                        }
                }

                Element3D element3d1;

                switch (element)
                {
                    case 0:
                        element3d1 = new WorldGroup(map);
                        break;

                    case 1:
                        element3d1 = new Beam(map);
                        break;

                    case 2:
                        element3d1 = new Line(map);
                        break;

                    case 3:
                        element3d1 = new DirectDraw(map);
                        break;

                    default:
                        Texteria.log.warn("Unknown 3d:add type: " + s2);
                        return;
                }

                this.world.elements.add(element3d1);
                break;

            case 12:
                Element3D element3d4 = this.world.elements.get(map.getString("id", map.getString("group")));

                if (element3d4 != null)
                {
                    element3d4.edit(map.getMap("data"));
                }

                break;

            case 13:
                String s1 = map.getString("id", map.getString("group"));

                if (s1.endsWith("*"))
                {
                    s1 = s1.substring(0, s1.length() - 1);
                    this.world.elements.removeStartsWith(s1);
                }
                else
                {
                    this.world.elements.remove(s1);
                }

                break;

            case 14:
                this.world.elements.clear();
                break;

            case 15:
                Element3D element3d3 = this.world.elements.get(map.getString("group"));

                if (element3d3 instanceof WorldGroup)
                {
                    ((WorldGroup)element3d3).addElement(Element2D.construct(map.getMap("e"), (WorldGroup)element3d3));
                }

                break;

            case 16:
                Element3D element3d2 = this.world.elements.get(map.getString("group"));

                if (element3d2 instanceof WorldGroup)
                {
                    ((WorldGroup)element3d2).editElement(map.getString("id"), map.getMap("data"));
                }

                break;

            case 17:
                Element3D element3d = this.world.elements.get(map.getString("group"));

                if (element3d instanceof WorldGroup)
                {
                    ((WorldGroup)element3d).removeElement(map.getString("id"));
                }

                break;

            case 18:
                this.world.boxes.add(map.getString("id"), new BoundingBox(map));
                break;

            case 19:
                this.world.boxes.remove(map.getString("id"));
                break;

            case 20:
                this.world.boxes.edit(map.getString("id"), map.getMap("d"));
                break;

            case 21:
                CommonUtils.openUrl(map.getString("url"));
                break;

            case 22:
                map.put("type", "script");

            case 23:
                this.texteria.keyboard.bind(map.getInt("key"), map);
                break;

            case 24:
                this.texteria.keyboard.remove(map.getInt("key"), map.getString("id"));
                break;

            case 25:
                this.texteria.keyboard.clear();
                break;

            case 26:
                this.texteria.sound.play(new TSound(map));
                break;

            case 27:
                this.texteria.sound.stop(map.getString("id"));
                break;

            case 28:
                TexteriaOptions.set(map);
                break;

            case 29:
                this.texteria.resourceManager.handlePacket(map);
        }
    }
}
