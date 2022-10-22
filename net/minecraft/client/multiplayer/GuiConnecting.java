package net.minecraft.client.multiplayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.network.NetHandlerLoginClient;
import net.minecraft.client.resources.I18n;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.login.client.C00PacketLoginStart;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shadersmod.client.Shaders;

public class GuiConnecting extends GuiScreen
{
    private static final AtomicInteger CONNECTION_ID = new AtomicInteger(0);
    private static final Logger logger = LogManager.getLogger();
    private NetworkManager networkManager;
    private boolean cancel;
    private final GuiScreen previousGuiScreen;

    public GuiConnecting(GuiScreen p_i1181_1_, Minecraft mcIn, ServerData p_i1181_3_)
    {
        this.mc = mcIn;
        this.previousGuiScreen = p_i1181_1_;
        mcIn.loadWorld((WorldClient)null);
        mcIn.setServerData(p_i1181_3_);
        this.connect(p_i1181_3_.serverIP);
    }

    public GuiConnecting(GuiScreen p_i1182_1_, Minecraft mcIn, String hostName, int port)
    {
        this.mc = mcIn;
        this.previousGuiScreen = p_i1182_1_;
        mcIn.loadWorld((WorldClient)null);
        this.connect(hostName + ":" + port);
    }

    private ServerAddress getConnectAddress(String p_getConnectAddress_1_)
    {
        if (p_getConnectAddress_1_.equals("vimeworld.net") || p_getConnectAddress_1_.equals("vimeworld.net:25565"))
        {
            HttpURLConnection httpurlconnection = null;
            ServerAddress serveraddress;

            try
            {
                httpurlconnection = (HttpURLConnection)(new URL("https://mg-balancer.vimeworld.com")).openConnection();
                httpurlconnection.setConnectTimeout(2000);
                httpurlconnection.setReadTimeout(2000);
                httpurlconnection.setDoInput(true);
                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
                StringBuilder stringbuilder = new StringBuilder();
                String s;

                while ((s = bufferedreader.readLine()) != null)
                {
                    stringbuilder.append(s);
                }

                serveraddress = ServerAddress.func_78860_a(stringbuilder.toString());
            }
            catch (Exception var10)
            {
                return ServerAddress.func_78860_a(p_getConnectAddress_1_);
            }
            finally
            {
                if (httpurlconnection != null)
                {
                    httpurlconnection.disconnect();
                }
            }

            return serveraddress;
        }
        else
        {
            return ServerAddress.func_78860_a(p_getConnectAddress_1_);
        }
    }

    private void connect(final String p_connect_1_)
    {
        if (Shaders.allowAnyShaders)
        {
            (new Thread(() ->
            {
                this.mc.displayGuiScreen(new GuiDisconnected(this.previousGuiScreen, "connect.failed", new ChatComponentText("\u0417\u0430\u043f\u0440\u0435\u0449\u0435\u043d\u043e \u043f\u043e\u0434\u043a\u043b\u044e\u0447\u0430\u0442\u044c\u0441\u044f \u043d\u0430 \u0441\u0435\u0440\u0432\u0435\u0440 \u0441 \u043b\u044e\u0431\u044b\u043c\u0438 \u0448\u0435\u0439\u0434\u0435\u0440\u0430\u043c\u0438.")));
            })).start();
        }
        else
        {
            logger.info("Connecting to " + p_connect_1_);
            (new Thread("Server Connector #" + CONNECTION_ID.incrementAndGet())
            {
                public void run()
                {
                    ServerAddress serveraddress = GuiConnecting.this.getConnectAddress(p_connect_1_);
                    InetAddress inetaddress = null;

                    try
                    {
                        if (GuiConnecting.this.cancel)
                        {
                            return;
                        }

                        inetaddress = InetAddress.getByName(serveraddress.getIP());
                        GuiConnecting.this.networkManager = NetworkManager.func_181124_a(inetaddress, serveraddress.getPort(), GuiConnecting.this.mc.gameSettings.func_181148_f());

                        if (GuiConnecting.this.cancel)
                        {
                            GuiConnecting.this.networkManager.closeChannel(new ChatComponentText("Aborted"));
                            return;
                        }

                        GuiConnecting.this.networkManager.setNetHandler(new NetHandlerLoginClient(GuiConnecting.this.networkManager, GuiConnecting.this.mc, GuiConnecting.this.previousGuiScreen));
                        String string = inetaddress.getHostAddress();
                        GuiConnecting.this.networkManager.sendPacket(new C00Handshake(47, string, serveraddress.getPort(), EnumConnectionState.LOGIN));
                        GuiConnecting.this.networkManager.sendPacket(new C00PacketLoginStart(GuiConnecting.this.mc.getSession().getProfile()));
                    }
                    catch (UnknownHostException unknownhostexception)
                    {
                        if (GuiConnecting.this.cancel)
                        {
                            return;
                        }

                        GuiConnecting.logger.error((String)"Couldn\'t connect to server", (Throwable)unknownhostexception);
                        GuiConnecting.this.mc.displayGuiScreen(new GuiDisconnected(GuiConnecting.this.previousGuiScreen, "connect.failed", new ChatComponentTranslation("disconnect.genericReason", new Object[] {"Unknown host"})));
                    }
                    catch (Exception exception)
                    {
                        if (GuiConnecting.this.cancel)
                        {
                            return;
                        }

                        GuiConnecting.logger.error((String)"Couldn\'t connect to server", (Throwable)exception);
                        String string1 = exception.toString();

                        if (inetaddress != null)
                        {
                            String string2 = inetaddress.toString() + ":" + serveraddress.getPort();
                            string1 = string1.replaceAll(string2, "");
                        }

                        GuiConnecting.this.mc.displayGuiScreen(new GuiDisconnected(GuiConnecting.this.previousGuiScreen, "connect.failed", new ChatComponentTranslation("disconnect.genericReason", new Object[] {string1})));
                    }
                }
            }).start();
        }
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        if (this.networkManager != null)
        {
            if (this.networkManager.isChannelOpen())
            {
                this.networkManager.processReceivedPackets();
            }
            else
            {
                this.networkManager.checkDisconnected();
            }
        }
    }

    /**
     * Fired when a key is typed (except F11 which toggles full screen). This is the equivalent of
     * KeyListener.keyTyped(KeyEvent e). Args : character (character on the key), keyCode (lwjgl Keyboard key code)
     */
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, I18n.format("gui.cancel", new Object[0])));
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if (button.id == 0)
        {
            this.cancel = true;

            if (this.networkManager != null)
            {
                this.networkManager.closeChannel(new ChatComponentText("Aborted"));
            }

            this.mc.displayGuiScreen(this.previousGuiScreen);
        }
    }

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();

        if (this.networkManager == null)
        {
            this.drawCenteredString(this.fontRendererObj, I18n.format("connect.connecting", new Object[0]), this.width / 2, this.height / 2 - 50, 16777215);
        }
        else
        {
            this.drawCenteredString(this.fontRendererObj, I18n.format("connect.authorizing", new Object[0]), this.width / 2, this.height / 2 - 50, 16777215);
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
