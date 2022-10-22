package net.minecraft.client;

import com.creativemd.cmdcam.CMDCam;
import com.creativemd.cmdcam.CamEventHandler;
import com.creativemd.cmdcam.CamEventHandler.Action;
import com.creativemd.cmdcam.CamEventHandler.Phase;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.imageio.ImageIO;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMemoryErrorScreen;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSleepMP;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.achievement.GuiAchievement;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.gui.stream.GuiStreamUnavailable;
import net.minecraft.client.main.GameConfiguration;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerLoginClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.client.resources.FoliageColorReloadListener;
import net.minecraft.client.resources.GrassColorReloadListener;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.resources.ResourceIndex;
import net.minecraft.client.resources.ResourcePackRepository;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.client.resources.data.AnimationMetadataSectionSerializer;
import net.minecraft.client.resources.data.FontMetadataSection;
import net.minecraft.client.resources.data.FontMetadataSectionSerializer;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.client.resources.data.LanguageMetadataSection;
import net.minecraft.client.resources.data.LanguageMetadataSectionSerializer;
import net.minecraft.client.resources.data.PackMetadataSection;
import net.minecraft.client.resources.data.PackMetadataSectionSerializer;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.client.resources.data.TextureMetadataSectionSerializer;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.stream.IStream;
import net.minecraft.client.stream.NullStream;
import net.minecraft.client.stream.TwitchStream;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Bootstrap;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.login.client.C00PacketLoginStart;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.profiler.IPlayerUsage;
import net.minecraft.profiler.PlayerUsageSnooper;
import net.minecraft.profiler.Profiler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.IStatStringFormat;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.FrameTimer;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.LoggingPrintStream;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MinecraftError;
import net.minecraft.util.MouseHelper;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ScreenShotHelper;
import net.minecraft.util.Session;
import net.minecraft.util.Timer;
import net.minecraft.util.Util;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.storage.AnvilSaveConverter;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import net.xtrafrancyz.VimeSkinStorage;
import net.xtrafrancyz.covered.HashGovna;
import net.xtrafrancyz.covered.ObfValue;
import net.xtrafrancyz.mods.discord.DiscordMod;
import net.xtrafrancyz.mods.minidot.MiniDot;
import net.xtrafrancyz.mods.minidot.MiniDotLayer;
import net.xtrafrancyz.mods.pvp.PvPMod;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.TexteriaOptions;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.OpenGLException;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;
import ru.vimeworld.brainstorm.NativeCommonGameUtils;

public class Minecraft implements IThreadListener, IPlayerUsage
{
    private static final ObfValue.OInteger OBFVAL_xsxte = ObfValue.create(34921);
    private static final ObfValue.OInteger OBFVAL_MjVeL = ObfValue.create(30);
    private static final ObfValue.OInteger OBFVAL_9G18Y = ObfValue.create(48);
    private static final ObfValue.OInteger OBFVAL_zphTO = ObfValue.create(34);
    private static final ObfValue.OInteger OBFVAL_GPFs6 = ObfValue.create(50);
    private static final ObfValue.OInteger OBFVAL_B9rxA = ObfValue.create(8);
    private static final ObfValue.OLong OBFVAL_ZePcJ = ObfValue.create(-1L);
    private static final ObfValue.OLong OBFVAL_o4aJW = ObfValue.create(1000L);
    private static final ObfValue.OLong OBFVAL_uJddM = ObfValue.create(5000L);
    private static final ObfValue.OLong OBFVAL_xkyYA = ObfValue.create(6000L);
    private static final ObfValue.OInteger OBFVAL_HIaAA = ObfValue.create(16777215);
    private static final ObfValue.OLong OBFVAL_xN7hH = ObfValue.create(20L);
    private static final ObfValue.OInteger OBFVAL_JogWL = ObfValue.create(255);
    private static final ObfValue.OFloat OBFVAL_0YCud = ObfValue.create(-2000.0F);
    private static final ObfValue.OFloat OBFVAL_yhl7C = ObfValue.create(0.00390625F);
    private static final ObfValue.OFloat OBFVAL_YmCww = ObfValue.create(10.0F);
    private static final ObfValue.OInteger OBFVAL_kZqXr = ObfValue.create(32868);
    private static final ObfValue.ODouble OBFVAL_hFLHY = ObfValue.create(1000.0D);
    private static final ObfValue.OInteger OBFVAL_mIuZA = ObfValue.create(5121);
    private static final ObfValue.OInteger OBFVAL_XvNfX = ObfValue.create(5);
    private static final ObfValue.ODouble OBFVAL_CwFdh = ObfValue.create(100.0D);
    private static final ObfValue.OInteger OBFVAL_LuQVk = ObfValue.create(59);
    private static final ObfValue.OLong OBFVAL_58dol = ObfValue.create(Long.MIN_VALUE);
    private static final ObfValue.OInteger OBFVAL_rF01F = ObfValue.create(4096);
    private static final ObfValue.OInteger OBFVAL_4Xw4q = ObfValue.create(35071);
    private static final ObfValue.OInteger OBFVAL_BTUpx = ObfValue.create(256);
    private static final ObfValue.OFloat OBFVAL_MO4kh = ObfValue.create(0.1F);
    private static final ObfValue.OInteger OBFVAL_TLfJ3 = ObfValue.create(7);
    private static final ObfValue.OInteger OBFVAL_fSh4u = ObfValue.create(5888);
    private static final ObfValue.OInteger OBFVAL_FT1i3 = ObfValue.create(515);
    private static final ObfValue.OInteger OBFVAL_5tIJZ = ObfValue.create(7938);
    private static final ObfValue.OInteger OBFVAL_17g4P = ObfValue.create(160);
    private static final ObfValue.OInteger OBFVAL_IvTer = ObfValue.create(100);
    private static final ObfValue.OFloat OBFVAL_HPR5I = ObfValue.create(20.0F);
    private static final ObfValue.OFloat OBFVAL_6Twix = ObfValue.create(0.2F);
    private static final ObfValue.OInteger OBFVAL_euAvh = ObfValue.create(-2);
    private static final ObfValue.OInteger OBFVAL_FnUvo = ObfValue.create(7425);
    private static final ObfValue.OLong OBFVAL_Ddv0e = ObfValue.create(1000000L);
    private static final ObfValue.OFloat OBFVAL_Qtyw0 = ObfValue.create(0.005F);
    private static final ObfValue.OInteger OBFVAL_BXTnG = ObfValue.create(16);
    private static final ObfValue.OInteger OBFVAL_qKWb8 = ObfValue.create(33);
    private static final ObfValue.ODouble OBFVAL_gak10 = ObfValue.create(4.0D);
    private static final ObfValue.ODouble OBFVAL_dWXXr = ObfValue.create(3000.0D);
    private static final ObfValue.OInteger OBFVAL_pSqMs = ObfValue.create(9);
    private static final ObfValue.OLong OBFVAL_Ox8HM = ObfValue.create(200L);
    private static final ObfValue.OInteger OBFVAL_GIHDe = ObfValue.create(6408);
    private static final ObfValue.OLong OBFVAL_Fy1Vo = ObfValue.create(50L);
    private static final ObfValue.OInteger OBFVAL_EWyrW = ObfValue.create(10);
    private static final ObfValue.OInteger OBFVAL_U6bOR = ObfValue.create(25);
    private static final ObfValue.OLong OBFVAL_XltG1 = ObfValue.create(76L);
    private static final ObfValue.OInteger OBFVAL_Mnkt1 = ObfValue.create(35658);
    private static final ObfValue.OFloat OBFVAL_rmpdQ = ObfValue.create(1.1F);
    private static final ObfValue.OLong OBFVAL_CsJjh = ObfValue.create(10000L);
    private static final ObfValue.OInteger OBFVAL_xMlG8 = ObfValue.create(20);
    private static final ObfValue.OLong OBFVAL_Zx1JK = ObfValue.create(9L);
    private static final ObfValue.OInteger OBFVAL_wnhCo = ObfValue.create(35660);
    private static final ObfValue.OInteger OBFVAL_JLQnv = ObfValue.create(1029);
    private static final ObfValue.OInteger OBFVAL_1rD6j = ObfValue.create(31);
    private static final ObfValue.OInteger OBFVAL_hLKIM = ObfValue.create(62);
    private static final ObfValue.OLong OBFVAL_nhDP7 = ObfValue.create(60L);
    private static final ObfValue.OFloat OBFVAL_7gzsB = ObfValue.create(0.5F);
    private static final ObfValue.OInteger OBFVAL_6oHr0 = ObfValue.create(11);
    private static final ObfValue.OInteger OBFVAL_OO4DM = ObfValue.create(5889);
    private static final ObfValue.OInteger OBFVAL_fNZrn = ObfValue.create(32);
    private static final ObfValue.OInteger OBFVAL_Au1rt = ObfValue.create(4);
    private static final ObfValue.OInteger OBFVAL_auWOp = ObfValue.create(200);
    private static final ObfValue.OInteger OBFVAL_jcHol = ObfValue.create(3);
    private static final ObfValue.ODouble OBFVAL_cNcFY = ObfValue.create(Math.PI);
    private static final ObfValue.OFloat OBFVAL_dLDHC = ObfValue.create(16.0F);
    private static final ObfValue.OInteger OBFVAL_kK58l = ObfValue.create(34930);
    private static final ObfValue.OFloat OBFVAL_2MBBy = ObfValue.create(0.6F);
    private static final ObfValue.OInteger OBFVAL_qINNY = ObfValue.create(6);
    private static final ObfValue.OInteger OBFVAL_8EUUQ = ObfValue.create(47);
    private static final ObfValue.OInteger OBFVAL_abP4s = ObfValue.create(7936);
    private static final ObfValue.OInteger OBFVAL_A1vox = ObfValue.create(16384);
    private static final ObfValue.OInteger OBFVAL_52VoM = ObfValue.create(61);
    private static final ObfValue.OInteger OBFVAL_yk0Sm = ObfValue.create(10000);
    private static final ObfValue.OInteger OBFVAL_uoYre = ObfValue.create(2);
    private static final ObfValue.OInteger OBFVAL_lsuE7 = ObfValue.create(46);
    private static final ObfValue.OInteger OBFVAL_It7m9 = ObfValue.create(16640);
    private static final ObfValue.ODouble OBFVAL_qpfgV = ObfValue.create(2.0D);
    private static final ObfValue.OInteger OBFVAL_Qhaat = ObfValue.create(24);
    private static final ObfValue.OInteger OBFVAL_iX48Y = ObfValue.create(35);
    private static final ObfValue.OInteger OBFVAL_fmKdc = ObfValue.create(35657);
    private static final ObfValue.OLong OBFVAL_mNR4y = ObfValue.create(600L);
    private static final ObfValue.OInteger OBFVAL_Pedgc = ObfValue.create(516);
    private static final Logger logger = LogManager.getLogger();
    private static final ResourceLocation locationMojangPng = new ResourceLocation("textures/gui/title/mojang.png");
    public static final boolean isRunningOnMac = Util.getOSType() == Util.EnumOS.OSX;

    /** A 10MiB preallocation to ensure the heap is reasonably sized. */
    public static byte[] memoryReserve = new byte[10485760];
    private static final List<DisplayMode> macDisplayModes = Lists.newArrayList(new DisplayMode[] {new DisplayMode(2560, 1600), new DisplayMode(2880, 1800)});
    private final File fileResourcepacks;
    private final PropertyMap twitchDetails;
    private final PropertyMap field_181038_N;
    private ServerData currentServerData;

    /** The RenderEngine instance used by Minecraft */
    private TextureManager renderEngine;

    /**
     * Set to 'this' in Minecraft constructor; used by some settings get methods
     */
    private static Minecraft theMinecraft;
    public PlayerControllerMP playerController;
    private boolean fullscreen;
    private boolean enableGLErrorChecking = true;
    private boolean hasCrashed;

    /** Instance of CrashReport. */
    private CrashReport crashReporter;
    public int displayWidth;
    public int displayHeight;
    public Timer timer;

    /** Instance of PlayerUsageSnooper. */
    private PlayerUsageSnooper usageSnooper;
    public WorldClient theWorld;
    public RenderGlobal renderGlobal;
    private RenderManager renderManager;
    private RenderItem renderItem;
    private ItemRenderer itemRenderer;
    public EntityPlayerSP thePlayer;
    public Entity renderViewEntity;
    public Entity pointedEntity;
    public EffectRenderer effectRenderer;
    private final Session session;
    private boolean isGamePaused;

    /** The font renderer used for displaying and measuring text */
    public FontRenderer fontRendererObj;
    public FontRenderer standardGalacticFontRenderer;

    /** The GuiScreen that's being displayed at the moment. */
    public GuiScreen currentScreen;
    public LoadingScreenRenderer loadingScreen;
    public EntityRenderer entityRenderer;

    /** Mouse left click counter */
    public int leftClickCounter;

    /** Display width */
    private int tempDisplayWidth;

    /** Display height */
    private int tempDisplayHeight;

    /** Instance of IntegratedServer. */
    private IntegratedServer theIntegratedServer;

    /** Gui achievement */
    public GuiAchievement guiAchievement;
    public GuiIngame ingameGUI;

    /** Skip render world */
    public boolean skipRenderWorld;

    /** The ray trace hit that the mouse is over. */
    public MovingObjectPosition objectMouseOver;

    /** The game settings that currently hold effect. */
    public GameSettings gameSettings;

    /** Mouse helper instance. */
    public MouseHelper mouseHelper;
    public final File mcDataDir;
    public final File fileAssets;
    private final String launchedVersion;
    private final Proxy proxy;
    private ISaveFormat saveLoader;

    /**
     * This is set to fpsCounter every debug screen update, and is shown on the debug screen. It's also sent as part of
     * the usage snooping.
     */
    private static int debugFPS;

    /**
     * When you place a block, it's set to 6, decremented once per tick, when it's 0, you can place another block.
     */
    public int rightClickDelayTimer;
    private String serverName;
    private int serverPort;

    /**
     * Does the actual gameplay have focus. If so then mouse and keys will effect the player instead of menus.
     */
    public boolean inGameHasFocus;
    long systemTime;

    /** Join player counter */
    private int joinPlayerCounter;
    public final FrameTimer field_181542_y;
    long field_181543_z;
    private final boolean jvm64bit;
    private final boolean isDemo;
    private NetworkManager myNetworkManager;
    private boolean integratedServerIsRunning;

    /** The profiler instance */
    public final Profiler mcProfiler;

    /**
     * Keeps track of how long the debug crash keycombo (F3+C) has been pressed for, in order to crash after 10 seconds.
     */
    private long debugCrashKeyPressTime;
    private IReloadableResourceManager mcResourceManager;
    private final IMetadataSerializer metadataSerializer_;
    private final List<IResourcePack> defaultResourcePacks;
    public final DefaultResourcePack mcDefaultResourcePack;
    private ResourcePackRepository mcResourcePackRepository;
    private LanguageManager mcLanguageManager;
    private IStream stream;
    private Framebuffer framebufferMc;
    private TextureMap textureMapBlocks;
    private SoundHandler mcSoundHandler;
    private MusicTicker mcMusicTicker;
    private ResourceLocation mojangLogo;
    private final MinecraftSessionService sessionService;
    private SkinManager skinManager;
    private final Queue < FutureTask<? >> scheduledTasks;
    private final Thread mcThread;
    private ModelManager modelManager;

    /**
     * The BlockRenderDispatcher instance that will be used based off gamesettings
     */
    private BlockRendererDispatcher blockRenderDispatcher;

    /**
     * Set to true to keep the game loop running. Set to false by shutdown() to allow the game loop to exit cleanly.
     */
    volatile boolean running;

    /** String that shows the debug information */
    public String debug;
    public boolean renderChunksMany;

    /** Approximate time (in ms) of last update to debug string */
    long debugUpdateTime;

    /** holds the current fps */
    int fpsCounter;
    long prevFrameTime;

    /** Profiler currently displayed in the debug screen pie chart */
    private String debugProfilerName;
    public static final Set<String> registeredPluginChannels = new HashSet();
    public long lastLeftClick;
    public long lastRightClick;
    public AWTWindow awtWindow;
    public boolean badConnection;
    private ObfValue.OInteger ashLastCheckTicks;
    private long ashLastCheckTime;
    private long ashLastCheckTime2;
    private int ashDetections;
    private int ashDetections2;
    private long ashLastNanoTime;
    private long ashLastLwjglTime;
    public ObfValue.OInteger globalTickCounter;
    public VimeSkinStorage skinStorage;
    public long lastResourceRefresh;
    boolean reported;

    public Minecraft(GameConfiguration gameConfig)
    {
        this.timer = new Timer(OBFVAL_HPR5I.get());
        this.usageSnooper = new PlayerUsageSnooper("client", this, MinecraftServer.getCurrentTimeMillis());
        this.systemTime = getSystemTime();
        this.field_181542_y = new FrameTimer();
        this.field_181543_z = System.nanoTime();
        this.mcProfiler = new Profiler();
        this.debugCrashKeyPressTime = OBFVAL_ZePcJ.get();
        this.metadataSerializer_ = new IMetadataSerializer();
        this.defaultResourcePacks = Lists.<IResourcePack>newArrayList();
        this.scheduledTasks = Queues. < FutureTask<? >> newArrayDeque();
        this.mcThread = Thread.currentThread();
        this.running = true;
        this.debug = "";
        this.renderChunksMany = true;
        this.debugUpdateTime = getSystemTime();
        this.prevFrameTime = OBFVAL_ZePcJ.get();
        this.debugProfilerName = "root";
        this.lastLeftClick = OBFVAL_58dol.get();
        this.lastRightClick = OBFVAL_58dol.get();
        this.ashLastCheckTicks = new ObfValue.OInteger(0);
        this.globalTickCounter = new ObfValue.OInteger(0);
        this.reported = false;
        theMinecraft = this;
        this.mcDataDir = gameConfig.folderInfo.mcDataDir;
        this.fileAssets = gameConfig.folderInfo.assetsDir;
        this.fileResourcepacks = gameConfig.folderInfo.resourcePacksDir;
        this.launchedVersion = gameConfig.gameInfo.version;
        this.twitchDetails = gameConfig.userInfo.userProperties;
        this.field_181038_N = gameConfig.userInfo.field_181172_c;
        this.skinStorage = new VimeSkinStorage(new File(this.fileAssets, "skins-index.bin"), new File(this.fileAssets, "skins"));
        this.mcDefaultResourcePack = new DefaultResourcePack((new ResourceIndex(gameConfig.folderInfo.assetsDir, gameConfig.folderInfo.assetIndex)).getResourceMap());
        this.proxy = gameConfig.userInfo.proxy == null ? Proxy.NO_PROXY : gameConfig.userInfo.proxy;
        this.sessionService = (new YggdrasilAuthenticationService(this.proxy, UUID.randomUUID().toString())).createMinecraftSessionService();
        this.session = gameConfig.userInfo.session;
        logger.info("Setting user: " + this.session.getUsername());

        if (Boolean.getBoolean("VimeWorld.logSession"))
        {
            logger.info("(Session ID is " + this.session.getSessionID() + ")");
        }

        this.isDemo = gameConfig.gameInfo.isDemo;
        this.displayWidth = gameConfig.displayInfo.width > 0 ? gameConfig.displayInfo.width : 1;
        this.displayHeight = gameConfig.displayInfo.height > 0 ? gameConfig.displayInfo.height : 1;
        this.tempDisplayWidth = gameConfig.displayInfo.width;
        this.tempDisplayHeight = gameConfig.displayInfo.height;
        this.fullscreen = gameConfig.displayInfo.fullscreen;
        this.jvm64bit = isJvm64bit();
        this.theIntegratedServer = new IntegratedServer(this);

        if (gameConfig.serverInfo.serverName != null)
        {
            this.serverName = gameConfig.serverInfo.serverName;
            this.serverPort = gameConfig.serverInfo.serverPort;
        }

        ImageIO.setUseCache(false);
        Bootstrap.register();
        System.setErr(new LoggingPrintStream("STDERR", System.err));
    }

    public void run()
    {
        this.running = true;

        try
        {
            this.startGame();
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Initializing game");
            crashreport.makeCategory("Initialization");
            this.displayCrashReport(this.addGraphicsAndWorldToCrashReport(crashreport));
            return;
        }

        try
        {
            HashGovna.afterTimer();

            while (this.running)
            {
                if (this.hasCrashed && this.crashReporter != null)
                {
                    this.displayCrashReport(this.crashReporter);
                }
                else
                {
                    try
                    {
                        this.runGameLoop();
                    }
                    catch (OutOfMemoryError var10)
                    {
                        this.freeMemory();
                        this.displayGuiScreen(new GuiMemoryErrorScreen());
                        System.gc();
                    }
                }
            }

            return;
        }
        catch (MinecraftError var12)
        {
            ;
        }
        catch (ReportedException reportedexception)
        {
            this.addGraphicsAndWorldToCrashReport(reportedexception.getCrashReport());
            this.freeMemory();
            logger.fatal((String)"Reported exception thrown!", (Throwable)reportedexception);
            this.displayCrashReport(reportedexception.getCrashReport());
        }
        catch (Throwable throwable1)
        {
            CrashReport crashreport1 = this.addGraphicsAndWorldToCrashReport(new CrashReport("Unexpected error", throwable1));
            this.freeMemory();
            logger.fatal("Unreported exception thrown!", throwable1);
            this.displayCrashReport(crashreport1);
        }
        finally
        {
            this.shutdownMinecraftApplet();
        }
    }

    /**
     * Starts the game: initializes the canvas, the title, the settings, etcetera.
     */
    private void startGame() throws LWJGLException, IOException
    {
        this.gameSettings = new GameSettings(this, this.mcDataDir);
        this.defaultResourcePacks.add(this.mcDefaultResourcePack);
        this.startTimerHackThread();

        if (this.gameSettings.overrideHeight > 0 && this.gameSettings.overrideWidth > 0)
        {
            this.displayWidth = this.gameSettings.overrideWidth;
            this.displayHeight = this.gameSettings.overrideHeight;
        }

        logger.info("LWJGL Version: " + Sys.getVersion());
        this.awtWindow = new AWTWindow(this, this.mcDefaultResourcePack);
        this.setWindowIcon();
        this.setInitialDisplayMode();
        this.createDisplay();
        OpenGlHelper.initializeTextures();
        this.framebufferMc = new Framebuffer(this.displayWidth, this.displayHeight, true);
        this.framebufferMc.setFramebufferColor(0.0F, 0.0F, 0.0F, 0.0F);
        this.registerMetadataSerializers();
        this.mcResourcePackRepository = new ResourcePackRepository(this.fileResourcepacks, new File(this.mcDataDir, "server-resource-packs"), this.mcDefaultResourcePack, this.metadataSerializer_, this.gameSettings);
        this.mcResourceManager = new SimpleReloadableResourceManager(this.metadataSerializer_);
        this.mcLanguageManager = new LanguageManager(this.metadataSerializer_, this.gameSettings.language);
        this.mcResourceManager.registerReloadListener(this.mcLanguageManager);
        this.refreshResources();
        this.renderEngine = new TextureManager(this.mcResourceManager);
        this.mcResourceManager.registerReloadListener(this.renderEngine);
        this.drawSplashScreen(this.renderEngine);
        this.initStream();
        this.skinManager = new SkinManager(this.renderEngine, new File(this.fileAssets, "skins"), this.sessionService);
        this.saveLoader = new AnvilSaveConverter(new File(this.mcDataDir, "saves"));
        this.mcSoundHandler = new SoundHandler(this.mcResourceManager, this.gameSettings);
        this.mcResourceManager.registerReloadListener(this.mcSoundHandler);
        this.mcMusicTicker = new MusicTicker(this);
        this.fontRendererObj = new FontRenderer(this.gameSettings, new ResourceLocation("textures/font/ascii.png"), this.renderEngine, false);

        if (this.gameSettings.language != null)
        {
            this.fontRendererObj.setUnicodeFlag(this.isUnicode());
            this.fontRendererObj.setBidiFlag(this.mcLanguageManager.isCurrentLanguageBidirectional());
        }

        this.standardGalacticFontRenderer = new FontRenderer(this.gameSettings, new ResourceLocation("textures/font/ascii_sga.png"), this.renderEngine, false);
        this.mcResourceManager.registerReloadListener(this.fontRendererObj);
        this.mcResourceManager.registerReloadListener(this.standardGalacticFontRenderer);
        this.mcResourceManager.registerReloadListener(new GrassColorReloadListener());
        this.mcResourceManager.registerReloadListener(new FoliageColorReloadListener());
        AchievementList.openInventory.setStatStringFormatter(new IStatStringFormat()
        {
            public String formatString(String p_74535_1_)
            {
                try
                {
                    return String.format(p_74535_1_, new Object[] {GameSettings.getKeyDisplayString(Minecraft.this.gameSettings.keyBindInventory.getKeyCode())});
                }
                catch (Exception exception)
                {
                    return "Error: " + exception.getLocalizedMessage();
                }
            }
        });
        this.mouseHelper = new MouseHelper();
        this.checkGLError("Pre startup");
        GlStateManager.enableTexture2D();
        GlStateManager.shadeModel(OBFVAL_FnUvo.get());
        GlStateManager.clearDepth(1.0D);
        GlStateManager.enableDepth();
        GlStateManager.depthFunc(OBFVAL_FT1i3.get());
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(OBFVAL_Pedgc.get(), OBFVAL_MO4kh.get());
        GlStateManager.cullFace(OBFVAL_JLQnv.get());
        GlStateManager.matrixMode(OBFVAL_OO4DM.get());
        GlStateManager.loadIdentity();
        GlStateManager.matrixMode(OBFVAL_fSh4u.get());
        this.checkGLError("Startup");
        this.textureMapBlocks = new TextureMap("textures");
        this.textureMapBlocks.setMipmapLevels(this.gameSettings.mipmapLevels);
        this.renderEngine.loadTickableTexture(TextureMap.locationBlocksTexture, this.textureMapBlocks);
        this.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
        this.textureMapBlocks.setBlurMipmapDirect(false, this.gameSettings.mipmapLevels > 0);
        this.modelManager = new ModelManager(this.textureMapBlocks);
        this.mcResourceManager.registerReloadListener(this.modelManager);
        this.renderItem = new RenderItem(this.renderEngine, this.modelManager);
        this.renderManager = new RenderManager(this.renderEngine, this.renderItem);
        this.itemRenderer = new ItemRenderer(this);
        this.mcResourceManager.registerReloadListener(this.renderItem);
        this.entityRenderer = new EntityRenderer(this, this.mcResourceManager);
        this.mcResourceManager.registerReloadListener(this.entityRenderer);
        this.blockRenderDispatcher = new BlockRendererDispatcher(this.modelManager.getBlockModelShapes(), this.gameSettings);
        this.mcResourceManager.registerReloadListener(this.blockRenderDispatcher);
        this.renderGlobal = new RenderGlobal(this);
        this.mcResourceManager.registerReloadListener(this.renderGlobal);
        this.guiAchievement = new GuiAchievement(this);
        GlStateManager.viewport(0, 0, this.displayWidth, this.displayHeight);
        this.effectRenderer = new EffectRenderer(this.theWorld, this.renderEngine);
        this.checkGLError("Post startup");
        this.ingameGUI = new GuiIngame(this);

        if (this.serverName != null)
        {
            this.displayGuiScreen(new GuiConnecting(new GuiMainMenu(), this, this.serverName, this.serverPort));
        }
        else
        {
            this.displayGuiScreen(new GuiMainMenu());
        }

        this.renderEngine.deleteTexture(this.mojangLogo);
        this.mojangLogo = null;
        this.loadingScreen = new LoadingScreenRenderer(this);

        if (this.gameSettings.fullScreen && !this.fullscreen)
        {
            this.toggleFullscreen();
        }

        try
        {
            Display.setVSyncEnabled(this.gameSettings.enableVsync);
        }
        catch (OpenGLException var2)
        {
            this.gameSettings.enableVsync = false;
            this.gameSettings.saveOptions();
        }

        this.renderGlobal.makeEntityOutlineShader();
        Texteria.instance.init(this);
        MiniDot.instance.init(this);
        PvPMod.instance.init(this);
        DiscordMod.instance.init(this);
        CMDCam.init();
        EnumConnectionState.getById(0);
    }

    private void registerMetadataSerializers()
    {
        this.metadataSerializer_.registerMetadataSectionType(new TextureMetadataSectionSerializer(), TextureMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new FontMetadataSectionSerializer(), FontMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new AnimationMetadataSectionSerializer(), AnimationMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new PackMetadataSectionSerializer(), PackMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new LanguageMetadataSectionSerializer(), LanguageMetadataSection.class);
    }

    private void initStream()
    {
        try
        {
            this.stream = new TwitchStream(this, (Property)Iterables.getFirst(this.twitchDetails.get("twitch_access_token"), null));
        }
        catch (Throwable throwable)
        {
            this.stream = new NullStream(throwable);
            logger.error("Couldn\'t initialize twitch stream");
        }
    }

    private void createDisplay() throws LWJGLException
    {
        Display.setResizable(false);
        Display.setTitle("VimeWorld");

        try
        {
            Display.create((new PixelFormat()).withDepthBits(OBFVAL_Qhaat.get()).withStencilBits(OBFVAL_B9rxA.get()));
        }
        catch (LWJGLException lwjglexception)
        {
            logger.error((String)"Couldn\'t set pixel format", (Throwable)lwjglexception);

            try
            {
                Thread.sleep(OBFVAL_o4aJW.get());
            }
            catch (InterruptedException var3)
            {
                ;
            }

            if (this.fullscreen)
            {
                this.updateDisplayMode();
            }

            Display.create();
        }
    }

    private void setInitialDisplayMode() throws LWJGLException
    {
        if (this.fullscreen)
        {
            Display.setFullscreen(true);
            DisplayMode displaymode = Display.getDisplayMode();
            this.displayWidth = Math.max(1, displaymode.getWidth());
            this.displayHeight = Math.max(1, displaymode.getHeight());
        }

        this.awtWindow.updateDisplay();
    }

    private void setWindowIcon()
    {
        Util.EnumOS util$enumos = Util.getOSType();

        if (util$enumos != Util.EnumOS.OSX)
        {
            InputStream inputstream = null;
            InputStream inputstream1 = null;

            try
            {
                inputstream = this.mcDefaultResourcePack.getInputStreamAssets(new ResourceLocation("icons/icon_16x16.png"));
                inputstream1 = this.mcDefaultResourcePack.getInputStreamAssets(new ResourceLocation("icons/icon_32x32.png"));

                if (inputstream != null && inputstream1 != null)
                {
                    ByteBuffer[] abytebuffer = new ByteBuffer[OBFVAL_uoYre.get()];
                    abytebuffer[0] = this.readImageToBuffer(inputstream);
                    abytebuffer[1] = this.readImageToBuffer(inputstream1);
                    Display.setIcon(abytebuffer);
                }
            }
            catch (IOException ioexception)
            {
                logger.error((String)"Couldn\'t set icon", (Throwable)ioexception);
            }
            finally
            {
                IOUtils.closeQuietly(inputstream);
                IOUtils.closeQuietly(inputstream1);
            }
        }
    }

    private static boolean isJvm64bit()
    {
        String[] astring1 = new String[OBFVAL_jcHol.get()];
        astring1[0] = "sun.arch.data.model";
        astring1[1] = "com.ibm.vm.bitmode";
        astring1[OBFVAL_uoYre.get()] = "os.arch";
        String[] astring = astring1;

        for (String s : astring)
        {
            String s1 = System.getProperty(s);

            if (s1 != null && s1.contains("64"))
            {
                return true;
            }
        }

        return false;
    }

    public Framebuffer getFramebuffer()
    {
        return this.framebufferMc;
    }

    public String getVersion()
    {
        return this.launchedVersion;
    }

    private void startTimerHackThread()
    {
        Thread thread = new Thread("Timer hack thread")
        {
            public void run()
            {
                while (Minecraft.this.running)
                {
                    try
                    {
                        Thread.sleep(2147483647L);
                    }
                    catch (InterruptedException var2)
                    {
                        ;
                    }
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
    }

    public void crashed(CrashReport crash)
    {
        this.hasCrashed = true;
        this.crashReporter = crash;
    }

    /**
     * Wrapper around displayCrashReportInternal
     */
    public void displayCrashReport(CrashReport crashReportIn)
    {
        File file1 = new File(getMinecraft().mcDataDir, "crash-reports");
        File file2 = new File(file1, "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-client.txt");
        Bootstrap.printToSYSOUT(crashReportIn.getCompleteReport());

        if (crashReportIn.getFile() != null)
        {
            Bootstrap.printToSYSOUT("#@!@# Game crashed! Crash report saved to: #@!@# " + crashReportIn.getFile());
            System.exit(-1);
        }
        else if (crashReportIn.saveToFile(file2))
        {
            Bootstrap.printToSYSOUT("#@!@# Game crashed! Crash report saved to: #@!@# " + file2.getAbsolutePath());
            System.exit(-1);
        }
        else
        {
            Bootstrap.printToSYSOUT("#@?@# Game crashed! Crash report could not be saved. #@?@#");
            System.exit(OBFVAL_euAvh.get());
        }
    }

    public boolean isUnicode()
    {
        return this.mcLanguageManager.isCurrentLocaleUnicode() || this.gameSettings.forceUnicodeFont;
    }

    public void refreshResources()
    {
        List<IResourcePack> list = Lists.newArrayList(this.defaultResourcePacks);

        for (ResourcePackRepository.Entry resourcepackrepository$entry : this.mcResourcePackRepository.getRepositoryEntries())
        {
            list.add(resourcepackrepository$entry.getResourcePack());
        }

        if (this.mcResourcePackRepository.getResourcePackInstance() != null)
        {
            list.add(this.mcResourcePackRepository.getResourcePackInstance());
        }

        try
        {
            this.mcResourceManager.reloadResources(list);
        }
        catch (RuntimeException runtimeexception)
        {
            logger.info((String)"Caught error stitching, removing all assigned resourcepacks", (Throwable)runtimeexception);
            list.clear();
            list.addAll(this.defaultResourcePacks);
            this.mcResourcePackRepository.setRepositories(Collections.<ResourcePackRepository.Entry>emptyList());
            this.mcResourceManager.reloadResources(list);
            this.gameSettings.resourcePacks.clear();
            this.gameSettings.field_183018_l.clear();
            this.gameSettings.saveOptions();
        }

        this.mcLanguageManager.parseLanguageMetadata(list);

        if (this.renderGlobal != null)
        {
            this.renderGlobal.loadRenderers();
        }
    }

    private ByteBuffer readImageToBuffer(InputStream imageStream) throws IOException
    {
        BufferedImage bufferedimage = ImageIO.read(imageStream);
        int[] aint = bufferedimage.getRGB(0, 0, bufferedimage.getWidth(), bufferedimage.getHeight(), (int[])null, 0, bufferedimage.getWidth());
        ByteBuffer bytebuffer = ByteBuffer.allocate(OBFVAL_Au1rt.get() * aint.length);

        for (int i : aint)
        {
            bytebuffer.putInt(i << OBFVAL_B9rxA.get() | i >> OBFVAL_Qhaat.get() & OBFVAL_JogWL.get());
        }

        bytebuffer.flip();
        return bytebuffer;
    }

    private void updateDisplayMode() throws LWJGLException
    {
        Set<DisplayMode> set = Sets.<DisplayMode>newHashSet();
        Collections.addAll(set, Display.getAvailableDisplayModes());
        DisplayMode displaymode = Display.getDesktopDisplayMode();

        if (!set.contains(displaymode) && Util.getOSType() == Util.EnumOS.OSX)
        {
            label53:

            for (DisplayMode displaymode1 : macDisplayModes)
            {
                boolean flag = true;

                for (DisplayMode displaymode2 : set)
                {
                    if (displaymode2.getBitsPerPixel() == OBFVAL_fNZrn.get() && displaymode2.getWidth() == displaymode1.getWidth() && displaymode2.getHeight() == displaymode1.getHeight())
                    {
                        flag = false;
                        break;
                    }
                }

                if (!flag)
                {
                    Iterator iterator = set.iterator();
                    DisplayMode displaymode3;

                    while (true)
                    {
                        if (!iterator.hasNext())
                        {
                            continue label53;
                        }

                        displaymode3 = (DisplayMode)iterator.next();

                        if (displaymode3.getBitsPerPixel() == OBFVAL_fNZrn.get() && displaymode3.getWidth() == displaymode1.getWidth() / OBFVAL_uoYre.get() && displaymode3.getHeight() == displaymode1.getHeight() / OBFVAL_uoYre.get())
                        {
                            break;
                        }
                    }

                    displaymode = displaymode3;
                }
            }
        }

        this.displayWidth = displaymode.getWidth();
        this.displayHeight = displaymode.getHeight();
        this.awtWindow.updateDisplay();
    }

    private void drawSplashScreen(TextureManager textureManagerInstance) throws LWJGLException
    {
        ScaledResolution scaledresolution = new ScaledResolution(this);
        int i = scaledresolution.getScaleFactor();
        Framebuffer framebuffer = new Framebuffer(scaledresolution.getScaledWidth() * i, scaledresolution.getScaledHeight() * i, true);
        framebuffer.bindFramebuffer(false);
        GlStateManager.matrixMode(OBFVAL_OO4DM.get());
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0D, (double)scaledresolution.getScaledWidth(), (double)scaledresolution.getScaledHeight(), 0.0D, OBFVAL_hFLHY.get(), OBFVAL_dWXXr.get());
        GlStateManager.matrixMode(OBFVAL_fSh4u.get());
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0F, 0.0F, OBFVAL_0YCud.get());
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        GlStateManager.disableDepth();
        GlStateManager.enableTexture2D();
        InputStream inputstream = null;

        try
        {
            inputstream = this.mcDefaultResourcePack.getInputStream(locationMojangPng);
            this.mojangLogo = textureManagerInstance.getDynamicTextureLocation("logo", new DynamicTexture(ImageIO.read(inputstream)));
            textureManagerInstance.bindTexture(this.mojangLogo);
        }
        catch (IOException ioexception1)
        {
            logger.error((String)("Unable to load logo: " + locationMojangPng), (Throwable)ioexception1);
        }
        finally
        {
            IOUtils.closeQuietly(inputstream);
        }

        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(OBFVAL_TLfJ3.get(), DefaultVertexFormats.POSITION_TEX_COLOR);
        worldrenderer.pos(0.0D, (double)this.displayHeight, 0.0D).tex(0.0D, 0.0D).color(OBFVAL_JogWL.get(), OBFVAL_JogWL.get(), OBFVAL_JogWL.get(), OBFVAL_JogWL.get()).endVertex();
        worldrenderer.pos((double)this.displayWidth, (double)this.displayHeight, 0.0D).tex(0.0D, 0.0D).color(OBFVAL_JogWL.get(), OBFVAL_JogWL.get(), OBFVAL_JogWL.get(), OBFVAL_JogWL.get()).endVertex();
        worldrenderer.pos((double)this.displayWidth, 0.0D, 0.0D).tex(0.0D, 0.0D).color(OBFVAL_JogWL.get(), OBFVAL_JogWL.get(), OBFVAL_JogWL.get(), OBFVAL_JogWL.get()).endVertex();
        worldrenderer.pos(0.0D, 0.0D, 0.0D).tex(0.0D, 0.0D).color(OBFVAL_JogWL.get(), OBFVAL_JogWL.get(), OBFVAL_JogWL.get(), OBFVAL_JogWL.get()).endVertex();
        tessellator.draw();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        int j = OBFVAL_BTUpx.get();
        int k = OBFVAL_BTUpx.get();
        this.func_181536_a((scaledresolution.getScaledWidth() - j) / OBFVAL_uoYre.get(), (scaledresolution.getScaledHeight() - k) / OBFVAL_uoYre.get(), 0, 0, j, k, OBFVAL_JogWL.get(), OBFVAL_JogWL.get(), OBFVAL_JogWL.get(), OBFVAL_JogWL.get());
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        framebuffer.unbindFramebuffer();
        framebuffer.framebufferRender(scaledresolution.getScaledWidth() * i, scaledresolution.getScaledHeight() * i);
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(OBFVAL_Pedgc.get(), OBFVAL_MO4kh.get());
        this.updateDisplay();
    }

    public void func_181536_a(int p_181536_1_, int p_181536_2_, int p_181536_3_, int p_181536_4_, int p_181536_5_, int p_181536_6_, int p_181536_7_, int p_181536_8_, int p_181536_9_, int p_181536_10_)
    {
        float f = OBFVAL_yhl7C.get();
        float f1 = OBFVAL_yhl7C.get();
        WorldRenderer worldrenderer = Tessellator.getInstance().getWorldRenderer();
        worldrenderer.begin(OBFVAL_TLfJ3.get(), DefaultVertexFormats.POSITION_TEX_COLOR);
        worldrenderer.pos((double)p_181536_1_, (double)(p_181536_2_ + p_181536_6_), 0.0D).tex((double)((float)p_181536_3_ * f), (double)((float)(p_181536_4_ + p_181536_6_) * f1)).color(p_181536_7_, p_181536_8_, p_181536_9_, p_181536_10_).endVertex();
        worldrenderer.pos((double)(p_181536_1_ + p_181536_5_), (double)(p_181536_2_ + p_181536_6_), 0.0D).tex((double)((float)(p_181536_3_ + p_181536_5_) * f), (double)((float)(p_181536_4_ + p_181536_6_) * f1)).color(p_181536_7_, p_181536_8_, p_181536_9_, p_181536_10_).endVertex();
        worldrenderer.pos((double)(p_181536_1_ + p_181536_5_), (double)p_181536_2_, 0.0D).tex((double)((float)(p_181536_3_ + p_181536_5_) * f), (double)((float)p_181536_4_ * f1)).color(p_181536_7_, p_181536_8_, p_181536_9_, p_181536_10_).endVertex();
        worldrenderer.pos((double)p_181536_1_, (double)p_181536_2_, 0.0D).tex((double)((float)p_181536_3_ * f), (double)((float)p_181536_4_ * f1)).color(p_181536_7_, p_181536_8_, p_181536_9_, p_181536_10_).endVertex();
        Tessellator.getInstance().draw();
    }

    /**
     * Returns the save loader that is currently being used
     */
    public ISaveFormat getSaveLoader()
    {
        return this.saveLoader;
    }

    /**
     * Sets the argument GuiScreen as the main (topmost visible) screen.
     */
    public void displayGuiScreen(GuiScreen guiScreenIn)
    {
        if (this.currentScreen != null)
        {
            this.currentScreen.onGuiClosed();
        }

        if (guiScreenIn == null && this.theWorld == null)
        {
            guiScreenIn = new GuiMainMenu();
        }
        else if (guiScreenIn == null && this.thePlayer.getHealth() <= 0.0F)
        {
            guiScreenIn = new GuiGameOver();
        }

        if (guiScreenIn instanceof GuiMainMenu || guiScreenIn instanceof GuiMultiplayer)
        {
            this.gameSettings.showDebugInfo = false;
            this.ingameGUI.getChatGUI().clearChatMessages();
        }

        this.currentScreen = (GuiScreen)guiScreenIn;

        if (guiScreenIn != null)
        {
            this.setIngameNotInFocus();
            ScaledResolution scaledresolution = new ScaledResolution(this);
            int i = scaledresolution.getScaledWidth();
            int j = scaledresolution.getScaledHeight();
            ((GuiScreen)guiScreenIn).setWorldAndResolution(this, i, j);
            this.skipRenderWorld = false;

            if (!((GuiScreen)guiScreenIn).allowUserInput)
            {
                KeyBinding.unPressAllKeys();
            }
        }
        else
        {
            if (this.isSingleplayer() && !this.theIntegratedServer.getPublic())
            {
                this.mcSoundHandler.resumeSounds();
            }

            this.setIngameFocus();
        }
    }

    /**
     * Checks for an OpenGL error. If there is one, prints the error ID and error string.
     */
    private void checkGLError(String message)
    {
        if (this.enableGLErrorChecking)
        {
            int i = GL11.glGetError();

            if (i != 0)
            {
                String s = GLU.gluErrorString(i);
                logger.error("########## GL ERROR ##########");
                logger.error("@ " + message);
                logger.error(i + ": " + s);
            }
        }
    }

    /**
     * Shuts down the minecraft applet by stopping the resource downloads, and clearing up GL stuff; called when the
     * application (or web page) is exited.
     */
    public void shutdownMinecraftApplet()
    {
        try
        {
            this.stream.shutdownStream();
            logger.info("Stopping!");

            try
            {
                this.loadWorld((WorldClient)null);
            }
            catch (Throwable var5)
            {
                ;
            }

            DiscordMod.instance.stop();
            Texteria.instance.stop();
            this.skinStorage.shutdown();
            this.mcSoundHandler.unloadSounds();
        }
        finally
        {
            Display.destroy();

            if (!this.hasCrashed)
            {
                System.exit(0);
            }
        }

        System.gc();
    }

    /**
     * Called repeatedly from run()
     */
    private void runGameLoop() throws IOException
    {
        long i = System.nanoTime();
        this.mcProfiler.startSection("root");

        if (Display.isCreated() && Display.isCloseRequested())
        {
            this.shutdown();
        }

        HashGovna.beforeTimer();

        if (this.isGamePaused && this.theWorld != null)
        {
            float f = this.timer.renderPartialTicks.get();
            this.timer.updateTimer();
            this.timer.renderPartialTicks.set(f);
        }
        else
        {
            this.timer.updateTimer();
        }

        HashGovna.afterTimer();
        HashGovna.beforeTick();
        this.mcProfiler.startSection("scheduledExecutables");

        synchronized (this.scheduledTasks)
        {
            while (!this.scheduledTasks.isEmpty())
            {
                Util.func_181617_a((FutureTask)this.scheduledTasks.poll(), logger);
            }
        }

        this.mcProfiler.endSection();
        long l1 = System.nanoTime();
        this.mcProfiler.startSection("tick");
        int j = this.timer.elapsedTicks.get();

        for (int k = 0; k < j; ++k)
        {
            this.runTick();
        }

        MiniDotLayer.globalPartialTicks = this.timer.renderPartialTicks.get();
        HashGovna.afterTick();
        this.badConnection = false;

        if (this.theWorld != null && this.thePlayer != null && this.theWorld.isRemote && System.currentTimeMillis() - this.getNetHandler().getNetworkManager().lastPacketTime > OBFVAL_mNR4y.get())
        {
            this.badConnection = true;
        }

        if (j > 0)
        {
            long i2 = System.currentTimeMillis();

            if (i2 - this.ashLastCheckTime > OBFVAL_uJddM.get())
            {
                long l = (i2 - this.ashLastCheckTime) / OBFVAL_Fy1Vo.get();
                long i1 = (long)(this.globalTickCounter.get() - this.ashLastCheckTicks.get());

                if (i1 > l + OBFVAL_xN7hH.get())
                {
                    disconnectAndMessage("\u0411\u044b\u043b\u043e \u043e\u0431\u043d\u0430\u0440\u0443\u0436\u0435\u043d\u043e \u0432\u043c\u0435\u0448\u0430\u0442\u0435\u043b\u044c\u0441\u0442\u0432\u043e \u0432 \u0438\u0433\u0440\u0443.\n\u0418\u0437\u043c\u0435\u043d\u0435\u043d\u0430 \u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u0445\u043e\u0434\u0430 \u0432\u0440\u0435\u043c\u0435\u043d\u0438 [1].");
                }
                else if (i1 > l + OBFVAL_Zx1JK.get())
                {
                    ++this.ashDetections;

                    if (this.ashDetections > OBFVAL_uoYre.get())
                    {
                        disconnectAndMessage("\u0411\u044b\u043b\u043e \u043e\u0431\u043d\u0430\u0440\u0443\u0436\u0435\u043d\u043e \u0432\u043c\u0435\u0448\u0430\u0442\u0435\u043b\u044c\u0441\u0442\u0432\u043e \u0432 \u0438\u0433\u0440\u0443.\n\u0418\u0437\u043c\u0435\u043d\u0435\u043d\u0430 \u0441\u043a\u043e\u0440\u043e\u0441\u0442\u044c \u0445\u043e\u0434\u0430 \u0432\u0440\u0435\u043c\u0435\u043d\u0438 [2].");
                    }
                }
                else
                {
                    this.ashDetections = 0;
                }

                this.ashLastCheckTicks.set(this.globalTickCounter.get());
                this.ashLastCheckTime = i2;
            }
            else if (i2 < this.ashLastCheckTime)
            {
                disconnectAndMessage("\u0412\u0440\u0435\u043c\u044f \u0431\u044b\u043b\u043e \u043f\u0435\u0440\u0435\u0432\u0435\u0434\u0435\u043d\u043e \u043d\u0430\u0437\u0430\u0434.\n\u042f \u0441\u043b\u043e\u043c\u0430\u043b\u0441\u044f.");
            }

            if (i2 - this.ashLastCheckTime2 > OBFVAL_o4aJW.get())
            {
                if (this.ashLastNanoTime == 0L)
                {
                    this.ashLastNanoTime = System.nanoTime() / OBFVAL_Ddv0e.get();
                    this.ashLastLwjglTime = Sys.getTime();
                }
                else
                {
                    long k2 = System.nanoTime() / OBFVAL_Ddv0e.get();
                    long i3 = Sys.getTime();
                    long j1 = this.ashLastNanoTime - k2;
                    long k1 = this.ashLastLwjglTime - i3;

                    if (Math.abs(j1 - k1) > OBFVAL_Fy1Vo.get())
                    {
                        ++this.ashDetections2;

                        if (this.ashDetections2 > OBFVAL_uoYre.get())
                        {
                            disconnectAndMessage("\u041f\u043e\u0447\u0435\u043c\u0443 \u0432\u0440\u0435\u043c\u044f \u043d\u0435 \u0441\u043e\u0432\u043f\u0430\u0434\u0430\u0435\u0442?\n\u042f \u043d\u0435 \u043c\u043e\u0433\u0443 \u0442\u0430\u043a \u0440\u0430\u0431\u043e\u0442\u0430\u0442\u044c.");
                        }
                    }
                    else
                    {
                        this.ashDetections2 = 0;
                    }

                    this.ashLastNanoTime = k2;
                    this.ashLastLwjglTime = i3;
                }

                this.ashLastCheckTime2 = i2;
            }

            try
            {
                NativeCommonGameUtils.protectionTick();
            }
            catch (UnsatisfiedLinkError var16)
            {
                ;
            }
        }

        this.mcProfiler.endStartSection("preRenderErrors");
        long j2 = System.nanoTime() - l1;
        this.checkGLError("Pre render");
        this.mcProfiler.endStartSection("sound");
        this.mcSoundHandler.setListener(this.thePlayer, this.timer.renderPartialTicks.get());
        this.mcProfiler.endSection();
        this.mcProfiler.startSection("render");
        GlStateManager.pushMatrix();
        GlStateManager.clear(OBFVAL_It7m9.get());
        this.framebufferMc.bindFramebuffer(true);
        this.mcProfiler.startSection("display");
        GlStateManager.enableTexture2D();

        if (this.thePlayer != null && this.thePlayer.isEntityInsideOpaqueBlock())
        {
            this.gameSettings.thirdPersonView = 0;
        }

        this.mcProfiler.endSection();

        if (!this.skipRenderWorld)
        {
            CamEventHandler.onRenderTick(Phase.START, this.timer.renderPartialTicks.get());
            this.mcProfiler.endStartSection("gameRenderer");
            this.entityRenderer.func_181560_a(this.timer.renderPartialTicks.get(), i);
            this.mcProfiler.endSection();
            CamEventHandler.onRenderTick(Phase.END, this.timer.renderPartialTicks.get());
        }

        this.mcProfiler.endSection();

        if (this.gameSettings.showDebugInfo && this.gameSettings.showDebugProfilerChart && !this.gameSettings.hideGUI)
        {
            if (!this.mcProfiler.profilingEnabled)
            {
                this.mcProfiler.clearProfiling();
            }

            this.mcProfiler.profilingEnabled = true;
            this.displayDebugInfo(j2);
        }
        else
        {
            this.mcProfiler.profilingEnabled = false;
            this.prevFrameTime = System.nanoTime();
        }

        this.guiAchievement.updateAchievementWindow();
        this.framebufferMc.unbindFramebuffer();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        this.framebufferMc.framebufferRender(this.displayWidth, this.displayHeight);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        this.entityRenderer.renderStreamIndicator(this.timer.renderPartialTicks.get());
        GlStateManager.popMatrix();
        this.mcProfiler.startSection("root");
        this.updateDisplay();
        Thread.yield();
        this.mcProfiler.startSection("stream");
        this.mcProfiler.startSection("update");
        this.stream.func_152935_j();
        this.mcProfiler.endStartSection("submit");
        this.stream.func_152922_k();
        this.mcProfiler.endSection();
        this.mcProfiler.endSection();
        this.checkGLError("Post render");
        ++this.fpsCounter;
        this.isGamePaused = this.isSingleplayer() && this.currentScreen != null && this.currentScreen.doesGuiPauseGame() && !this.theIntegratedServer.getPublic();
        long l2 = System.nanoTime();
        this.field_181542_y.func_181747_a(l2 - this.field_181543_z);
        this.field_181543_z = l2;

        while (getSystemTime() >= this.debugUpdateTime + OBFVAL_o4aJW.get())
        {
            debugFPS = this.fpsCounter;
            Object[] aobject = new Object[OBFVAL_B9rxA.get()];
            aobject[0] = Integer.valueOf(debugFPS);
            aobject[1] = Integer.valueOf(RenderChunk.renderChunksUpdated);
            aobject[OBFVAL_uoYre.get()] = RenderChunk.renderChunksUpdated != 1 ? "s" : "";
            aobject[OBFVAL_jcHol.get()] = (float)this.gameSettings.limitFramerate == GameSettings.Options.FRAMERATE_LIMIT.getValueMax() ? "inf" : Integer.valueOf(this.gameSettings.limitFramerate);
            aobject[OBFVAL_Au1rt.get()] = this.gameSettings.enableVsync ? " vsync" : "";
            aobject[OBFVAL_XvNfX.get()] = this.gameSettings.fancyGraphics ? "" : " fast";
            aobject[OBFVAL_qINNY.get()] = this.gameSettings.clouds == 0 ? "" : (this.gameSettings.clouds == 1 ? " fast-clouds" : " fancy-clouds");
            aobject[OBFVAL_TLfJ3.get()] = OpenGlHelper.useVbo() ? " vbo" : "";
            this.debug = String.format("\u00a7e%d fps\u00a7r (%d chunk update%s) T: %s%s%s%s%s", aobject);
            RenderChunk.renderChunksUpdated = 0;
            this.debugUpdateTime += OBFVAL_o4aJW.get();
            this.fpsCounter = 0;
            this.usageSnooper.addMemoryStatsToSnooper();

            if (!this.usageSnooper.isSnooperRunning())
            {
                this.usageSnooper.startSnooper();
            }
        }

        if (this.isFramerateLimitBelowMax())
        {
            this.mcProfiler.startSection("fpslimit_wait");
            Display.sync(this.getLimitFramerate());
            this.mcProfiler.endSection();
        }

        this.mcProfiler.endSection();
    }

    public void updateDisplay()
    {
        this.mcProfiler.startSection("display_update");
        Display.update();
        this.mcProfiler.endSection();
        this.checkWindowResize();
    }

    protected void checkWindowResize()
    {
        if (!this.fullscreen && Display.wasResized())
        {
            int i = this.displayWidth;
            int j = this.displayHeight;
            this.displayWidth = Display.getWidth();
            this.displayHeight = Display.getHeight();

            if (this.displayWidth != i || this.displayHeight != j)
            {
                if (this.displayWidth <= 0)
                {
                    this.displayWidth = 1;
                }

                if (this.displayHeight <= 0)
                {
                    this.displayHeight = 1;
                }

                this.resize(this.displayWidth, this.displayHeight);
            }
        }
    }

    public int getLimitFramerate()
    {
        return this.theWorld == null && this.currentScreen != null ? OBFVAL_MjVeL.get() : this.gameSettings.limitFramerate;
    }

    public boolean isFramerateLimitBelowMax()
    {
        return (float)this.getLimitFramerate() < GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
    }

    public void freeMemory()
    {
        try
        {
            memoryReserve = new byte[0];
            this.renderGlobal.deleteAllDisplayLists();
        }
        catch (Throwable var3)
        {
            ;
        }

        try
        {
            System.gc();
            this.loadWorld((WorldClient)null);
        }
        catch (Throwable var2)
        {
            ;
        }

        System.gc();
    }

    /**
     * Update debugProfilerName in response to number keys in debug screen
     */
    private void updateDebugProfilerName(int keyCount)
    {
        List<Profiler.Result> list = this.mcProfiler.getProfilingData(this.debugProfilerName);

        if (list != null && !list.isEmpty())
        {
            Profiler.Result profiler$result = (Profiler.Result)list.remove(0);

            if (keyCount == 0)
            {
                if (profiler$result.field_76331_c.length() > 0)
                {
                    int i = this.debugProfilerName.lastIndexOf(".");

                    if (i >= 0)
                    {
                        this.debugProfilerName = this.debugProfilerName.substring(0, i);
                    }
                }
            }
            else
            {
                --keyCount;

                if (keyCount < list.size() && !((Profiler.Result)list.get(keyCount)).field_76331_c.equals("unspecified"))
                {
                    if (this.debugProfilerName.length() > 0)
                    {
                        this.debugProfilerName = this.debugProfilerName + ".";
                    }

                    this.debugProfilerName = this.debugProfilerName + ((Profiler.Result)list.get(keyCount)).field_76331_c;
                }
            }
        }
    }

    /**
     * Parameter appears to be unused
     */
    private void displayDebugInfo(long elapsedTicksTime)
    {
        if (this.mcProfiler.profilingEnabled)
        {
            List<Profiler.Result> list = this.mcProfiler.getProfilingData(this.debugProfilerName);
            Profiler.Result profiler$result = (Profiler.Result)list.remove(0);
            GlStateManager.clear(OBFVAL_BTUpx.get());
            GlStateManager.matrixMode(OBFVAL_OO4DM.get());
            GlStateManager.enableColorMaterial();
            GlStateManager.loadIdentity();
            GlStateManager.ortho(0.0D, (double)this.displayWidth, (double)this.displayHeight, 0.0D, OBFVAL_hFLHY.get(), OBFVAL_dWXXr.get());
            GlStateManager.matrixMode(OBFVAL_fSh4u.get());
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0F, 0.0F, OBFVAL_0YCud.get());
            GL11.glLineWidth(1.0F);
            GlStateManager.disableTexture2D();
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();
            int i = OBFVAL_17g4P.get();
            int j = this.displayWidth - i - OBFVAL_EWyrW.get();
            int k = this.displayHeight - i * OBFVAL_uoYre.get();
            GlStateManager.enableBlend();
            worldrenderer.begin(OBFVAL_TLfJ3.get(), DefaultVertexFormats.POSITION_COLOR);
            worldrenderer.pos((double)((float)j - (float)i * OBFVAL_rmpdQ.get()), (double)((float)k - (float)i * OBFVAL_2MBBy.get() - OBFVAL_dLDHC.get()), 0.0D).color(OBFVAL_auWOp.get(), 0, 0, 0).endVertex();
            worldrenderer.pos((double)((float)j - (float)i * OBFVAL_rmpdQ.get()), (double)(k + i * OBFVAL_uoYre.get()), 0.0D).color(OBFVAL_auWOp.get(), 0, 0, 0).endVertex();
            worldrenderer.pos((double)((float)j + (float)i * OBFVAL_rmpdQ.get()), (double)(k + i * OBFVAL_uoYre.get()), 0.0D).color(OBFVAL_auWOp.get(), 0, 0, 0).endVertex();
            worldrenderer.pos((double)((float)j + (float)i * OBFVAL_rmpdQ.get()), (double)((float)k - (float)i * OBFVAL_2MBBy.get() - OBFVAL_dLDHC.get()), 0.0D).color(OBFVAL_auWOp.get(), 0, 0, 0).endVertex();
            tessellator.draw();
            GlStateManager.disableBlend();
            double d0 = 0.0D;

            for (int l = 0; l < list.size(); ++l)
            {
                Profiler.Result profiler$result1 = (Profiler.Result)list.get(l);
                int i1 = MathHelper.floor_double(profiler$result1.field_76332_a / OBFVAL_gak10.get()) + 1;
                worldrenderer.begin(OBFVAL_qINNY.get(), DefaultVertexFormats.POSITION_COLOR);
                int j1 = profiler$result1.func_76329_a();
                int k1 = j1 >> OBFVAL_BXTnG.get() & OBFVAL_JogWL.get();
                int l1 = j1 >> OBFVAL_B9rxA.get() & OBFVAL_JogWL.get();
                int i2 = j1 & OBFVAL_JogWL.get();
                worldrenderer.pos((double)j, (double)k, 0.0D).color(k1, l1, i2, OBFVAL_JogWL.get()).endVertex();

                for (int j2 = i1; j2 >= 0; --j2)
                {
                    float f = (float)((d0 + profiler$result1.field_76332_a * (double)j2 / (double)i1) * OBFVAL_cNcFY.get() * OBFVAL_qpfgV.get() / OBFVAL_CwFdh.get());
                    float f1 = MathHelper.sin(f) * (float)i;
                    float f2 = MathHelper.cos(f) * (float)i * OBFVAL_7gzsB.get();
                    worldrenderer.pos((double)((float)j + f1), (double)((float)k - f2), 0.0D).color(k1, l1, i2, OBFVAL_JogWL.get()).endVertex();
                }

                tessellator.draw();
                worldrenderer.begin(OBFVAL_XvNfX.get(), DefaultVertexFormats.POSITION_COLOR);

                for (int i3 = i1; i3 >= 0; --i3)
                {
                    float f3 = (float)((d0 + profiler$result1.field_76332_a * (double)i3 / (double)i1) * OBFVAL_cNcFY.get() * OBFVAL_qpfgV.get() / OBFVAL_CwFdh.get());
                    float f4 = MathHelper.sin(f3) * (float)i;
                    float f5 = MathHelper.cos(f3) * (float)i * OBFVAL_7gzsB.get();
                    worldrenderer.pos((double)((float)j + f4), (double)((float)k - f5), 0.0D).color(k1 >> 1, l1 >> 1, i2 >> 1, OBFVAL_JogWL.get()).endVertex();
                    worldrenderer.pos((double)((float)j + f4), (double)((float)k - f5 + OBFVAL_YmCww.get()), 0.0D).color(k1 >> 1, l1 >> 1, i2 >> 1, OBFVAL_JogWL.get()).endVertex();
                }

                tessellator.draw();
                d0 += profiler$result1.field_76332_a;
            }

            DecimalFormat decimalformat = new DecimalFormat("##0.00");
            GlStateManager.enableTexture2D();
            String s = "";

            if (!profiler$result.field_76331_c.equals("unspecified"))
            {
                s = s + "[0] ";
            }

            if (profiler$result.field_76331_c.length() == 0)
            {
                s = s + "ROOT ";
            }
            else
            {
                s = s + profiler$result.field_76331_c + " ";
            }

            int k2 = OBFVAL_HIaAA.get();
            this.fontRendererObj.drawStringWithShadow(s, (float)(j - i), (float)(k - i / OBFVAL_uoYre.get() - OBFVAL_BXTnG.get()), k2);
            this.fontRendererObj.drawStringWithShadow(s = decimalformat.format(profiler$result.field_76330_b) + "%", (float)(j + i - this.fontRendererObj.getStringWidth(s)), (float)(k - i / OBFVAL_uoYre.get() - OBFVAL_BXTnG.get()), k2);

            for (int l2 = 0; l2 < list.size(); ++l2)
            {
                Profiler.Result profiler$result2 = (Profiler.Result)list.get(l2);
                String s1 = "";

                if (profiler$result2.field_76331_c.equals("unspecified"))
                {
                    s1 = s1 + "[?] ";
                }
                else
                {
                    s1 = s1 + "[" + (l2 + 1) + "] ";
                }

                s1 = s1 + profiler$result2.field_76331_c;
                this.fontRendererObj.drawStringWithShadow(s1, (float)(j - i), (float)(k + i / OBFVAL_uoYre.get() + l2 * OBFVAL_B9rxA.get() + OBFVAL_xMlG8.get()), profiler$result2.func_76329_a());
                this.fontRendererObj.drawStringWithShadow(s1 = decimalformat.format(profiler$result2.field_76332_a) + "%", (float)(j + i - OBFVAL_GPFs6.get() - this.fontRendererObj.getStringWidth(s1)), (float)(k + i / OBFVAL_uoYre.get() + l2 * OBFVAL_B9rxA.get() + OBFVAL_xMlG8.get()), profiler$result2.func_76329_a());
                this.fontRendererObj.drawStringWithShadow(s1 = decimalformat.format(profiler$result2.field_76330_b) + "%", (float)(j + i - this.fontRendererObj.getStringWidth(s1)), (float)(k + i / OBFVAL_uoYre.get() + l2 * OBFVAL_B9rxA.get() + OBFVAL_xMlG8.get()), profiler$result2.func_76329_a());
            }
        }
    }

    /**
     * Called when the window is closing. Sets 'running' to false which allows the game loop to exit cleanly.
     */
    public void shutdown()
    {
        this.running = false;
    }

    /**
     * Will set the focus to ingame if the Minecraft window is the active with focus. Also clears any GUI screen
     * currently displayed
     */
    public void setIngameFocus()
    {
        if (Display.isActive() && !this.inGameHasFocus)
        {
            this.inGameHasFocus = true;
            this.mouseHelper.grabMouseCursor();
            this.displayGuiScreen((GuiScreen)null);
            this.leftClickCounter = OBFVAL_yk0Sm.get();
        }
    }

    /**
     * Resets the player keystate, disables the ingame focus, and ungrabs the mouse cursor.
     */
    public void setIngameNotInFocus()
    {
        if (this.inGameHasFocus)
        {
            KeyBinding.unPressAllKeys();
            this.inGameHasFocus = false;
            this.mouseHelper.ungrabMouseCursor();
        }
    }

    /**
     * Displays the ingame menu
     */
    public void displayInGameMenu()
    {
        if (this.currentScreen == null)
        {
            this.displayGuiScreen(new GuiIngameMenu());

            if (this.isSingleplayer() && !this.theIntegratedServer.getPublic())
            {
                this.mcSoundHandler.pauseSounds();
            }
        }
    }

    private void sendClickBlockToController(boolean leftClick)
    {
        if (!leftClick)
        {
            this.leftClickCounter = 0;
        }

        if (this.leftClickCounter <= 0 && !this.thePlayer.isUsingItem())
        {
            if (leftClick && this.objectMouseOver != null && this.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                BlockPos blockpos = this.objectMouseOver.getBlockPos();

                if (this.theWorld.getBlockState(blockpos).getBlock().getMaterial() != Material.air && this.playerController.onPlayerDamageBlock(blockpos, this.objectMouseOver.sideHit))
                {
                    this.effectRenderer.addBlockHitEffects(blockpos, this.objectMouseOver.sideHit);
                    this.thePlayer.swingItem();
                }
            }
            else
            {
                this.playerController.resetBlockRemoving();
            }
        }
    }

    private void clickMouse()
    {
        if (this.leftClickCounter <= 0)
        {
            if (!TexteriaOptions.disableCpsLimit.get())
            {
                long i = this.gameSettings.keyBindAttack.getPressedEventNanos() / OBFVAL_Ddv0e.get();

                if (i - OBFVAL_XltG1.get() < this.lastLeftClick)
                {
                    return;
                }

                this.lastLeftClick = i;
            }

            PvPMod.leftMouseCounter.onClick();
            this.thePlayer.swingItem();

            if (this.objectMouseOver == null)
            {
                logger.error("Null returned as \'hitResult\', this shouldn\'t happen!");

                if (this.playerController.isNotCreative())
                {
                    this.leftClickCounter = OBFVAL_EWyrW.get();
                }
            }
            else
            {
                switch (this.objectMouseOver.typeOfHit)
                {
                    case ENTITY:
                        this.playerController.attackEntity(this.thePlayer, this.objectMouseOver.entityHit);
                        break;

                    case BLOCK:
                        BlockPos blockpos = this.objectMouseOver.getBlockPos();

                        if (this.theWorld.getBlockState(blockpos).getBlock().getMaterial() != Material.air)
                        {
                            this.playerController.clickBlock(blockpos, this.objectMouseOver.sideHit);
                            break;
                        }

                    case MISS:
                    default:
                        if (this.playerController.isNotCreative())
                        {
                            this.leftClickCounter = OBFVAL_EWyrW.get();
                        }
                }
            }
        }
    }

    @SuppressWarnings("incomplete-switch")

    /**
     * Called when user clicked he's mouse right button (place)
     */
    private void rightClickMouse()
    {
        if (!this.playerController.func_181040_m())
        {
            if (!TexteriaOptions.disableCpsLimit.get())
            {
                long i = this.gameSettings.keyBindUseItem.getPressedEventNanos() / OBFVAL_Ddv0e.get();

                if (i != 0L && i - OBFVAL_XltG1.get() < this.lastRightClick)
                {
                    return;
                }

                this.lastRightClick = i;
            }

            PvPMod.rightMouseCounter.onClick();
            this.rightClickDelayTimer = OBFVAL_Au1rt.get();
            boolean flag = true;
            ItemStack itemstack = this.thePlayer.inventory.getCurrentItem();

            if (this.objectMouseOver == null)
            {
                logger.warn("Null returned as \'hitResult\', this shouldn\'t happen!");
            }
            else
            {
                switch (this.objectMouseOver.typeOfHit)
                {
                    case ENTITY:
                        if (this.playerController.func_178894_a(this.thePlayer, this.objectMouseOver.entityHit, this.objectMouseOver))
                        {
                            flag = false;
                        }
                        else if (this.playerController.interactWithEntitySendPacket(this.thePlayer, this.objectMouseOver.entityHit))
                        {
                            flag = false;
                        }

                        break;

                    case BLOCK:
                        BlockPos blockpos = this.objectMouseOver.getBlockPos();

                        if (this.theWorld.getBlockState(blockpos).getBlock().getMaterial() != Material.air)
                        {
                            int j = itemstack != null ? itemstack.stackSize : 0;
                            CamEventHandler.onPlayerInteract(this.thePlayer, Action.RIGHT_CLICK_BLOCK, this.theWorld, blockpos, this.objectMouseOver.sideHit);

                            if (this.playerController.onPlayerRightClick(this.thePlayer, this.theWorld, itemstack, blockpos, this.objectMouseOver.sideHit, this.objectMouseOver.hitVec))
                            {
                                flag = false;
                                this.thePlayer.swingItem();
                            }

                            if (itemstack == null)
                            {
                                return;
                            }

                            if (itemstack.stackSize == 0)
                            {
                                this.thePlayer.inventory.mainInventory[this.thePlayer.inventory.currentItem] = null;
                            }
                            else if (itemstack.stackSize != j || this.playerController.isInCreativeMode())
                            {
                                this.entityRenderer.itemRenderer.resetEquippedProgress();
                            }
                        }
                }
            }

            if (flag)
            {
                ItemStack itemstack1 = this.thePlayer.inventory.getCurrentItem();
                CamEventHandler.onPlayerInteract(this.thePlayer, Action.RIGHT_CLICK_AIR, this.theWorld, (BlockPos)null, (EnumFacing)null);

                if (itemstack1 != null && this.playerController.sendUseItem(this.thePlayer, this.theWorld, itemstack1))
                {
                    this.entityRenderer.itemRenderer.resetEquippedProgress2();
                }
            }
        }
    }

    /**
     * Toggles fullscreen mode.
     */
    public void toggleFullscreen()
    {
        try
        {
            this.fullscreen = !this.fullscreen;
            this.gameSettings.fullScreen = this.fullscreen;

            if (this.fullscreen)
            {
                this.updateDisplayMode();
                this.displayWidth = Display.getDisplayMode().getWidth();
                this.displayHeight = Display.getDisplayMode().getHeight();

                if (this.displayWidth <= 0)
                {
                    this.displayWidth = 1;
                }

                if (this.displayHeight <= 0)
                {
                    this.displayHeight = 1;
                }
            }
            else
            {
                this.displayWidth = this.tempDisplayWidth;
                this.displayHeight = this.tempDisplayHeight;

                if (this.displayWidth <= 0)
                {
                    this.displayWidth = 1;
                }

                if (this.displayHeight <= 0)
                {
                    this.displayHeight = 1;
                }
            }

            this.awtWindow.updateDisplay();

            if (this.currentScreen != null)
            {
                this.resize(this.displayWidth, this.displayHeight);
            }
            else
            {
                this.updateFramebufferSize();
            }

            Display.setFullscreen(this.fullscreen);
            Display.setVSyncEnabled(this.gameSettings.enableVsync);
            this.updateDisplay();
            KeyBinding.unPressAllKeys();
        }
        catch (Exception exception)
        {
            logger.error((String)"Couldn\'t toggle fullscreen", (Throwable)exception);
        }
    }

    /**
     * Called to resize the current screen.
     */
    private void resize(int width, int height)
    {
        this.displayWidth = Math.max(1, width);
        this.displayHeight = Math.max(1, height);

        if (this.currentScreen != null)
        {
            ScaledResolution scaledresolution = new ScaledResolution(this);
            this.currentScreen.onResize(this, scaledresolution.getScaledWidth(), scaledresolution.getScaledHeight());
        }

        this.loadingScreen = new LoadingScreenRenderer(this);
        this.updateFramebufferSize();
    }

    public void updateFramebufferSize()
    {
        this.framebufferMc.createBindFramebuffer(this.displayWidth, this.displayHeight);

        if (this.entityRenderer != null)
        {
            this.entityRenderer.updateShaderGroupSize(this.displayWidth, this.displayHeight);
        }
    }

    public MusicTicker func_181535_r()
    {
        return this.mcMusicTicker;
    }

    /**
     * Runs the current tick.
     */
    public void runTick() throws IOException
    {
        this.globalTickCounter.inc();
        ObfValue.tick();

        if (this.rightClickDelayTimer > 0)
        {
            --this.rightClickDelayTimer;
        }

        this.mcProfiler.startSection("gui");

        if (!this.isGamePaused)
        {
            this.ingameGUI.updateTick();
        }

        this.mcProfiler.endSection();
        this.entityRenderer.getMouseOver(1.0F);
        this.mcProfiler.startSection("gameMode");

        if (!this.isGamePaused && this.theWorld != null)
        {
            this.playerController.updateController();
        }

        this.mcProfiler.endStartSection("textures");

        if (!this.isGamePaused)
        {
            this.renderEngine.tick();
        }

        if (this.currentScreen == null && this.thePlayer != null)
        {
            if (this.thePlayer.getHealth() <= 0.0F)
            {
                this.displayGuiScreen((GuiScreen)null);
            }
            else if (this.thePlayer.isPlayerSleeping() && this.theWorld != null)
            {
                this.displayGuiScreen(new GuiSleepMP());
            }
        }
        else if (this.currentScreen != null && this.currentScreen instanceof GuiSleepMP && !this.thePlayer.isPlayerSleeping())
        {
            this.displayGuiScreen((GuiScreen)null);
        }

        if (this.currentScreen != null)
        {
            this.leftClickCounter = OBFVAL_yk0Sm.get();
        }

        if (this.currentScreen != null)
        {
            try
            {
                this.currentScreen.handleInput();
            }
            catch (Throwable throwable11)
            {
                CrashReport crashreport = CrashReport.makeCrashReport(throwable11, "Updating screen events");
                CrashReportCategory crashreportcategory = crashreport.makeCategory("Affected screen");
                crashreportcategory.addCrashSectionCallable("Screen name", new Callable<String>()
                {
                    public String call() throws Exception
                    {
                        return Minecraft.this.currentScreen.getClass().getCanonicalName();
                    }
                });
                throw new ReportedException(crashreport);
            }

            if (this.currentScreen != null)
            {
                try
                {
                    this.currentScreen.updateScreen();
                }
                catch (Throwable throwable)
                {
                    CrashReport crashreport1 = CrashReport.makeCrashReport(throwable, "Ticking screen");
                    CrashReportCategory crashreportcategory1 = crashreport1.makeCategory("Affected screen");
                    crashreportcategory1.addCrashSectionCallable("Screen name", new Callable<String>()
                    {
                        public String call() throws Exception
                        {
                            return Minecraft.this.currentScreen.getClass().getCanonicalName();
                        }
                    });
                    throw new ReportedException(crashreport1);
                }
            }
        }

        if (this.currentScreen == null || this.currentScreen.allowUserInput)
        {
            this.mcProfiler.endStartSection("mouse");

            while (Mouse.next())
            {
                if (!Texteria.instance.handleMouseEvent())
                {
                    int i = Mouse.getEventButton();
                    KeyBinding.setKeyBindState(i - OBFVAL_IvTer.get(), Mouse.getEventButtonState());

                    if (Mouse.getEventButtonState())
                    {
                        if (this.thePlayer.isSpectator() && i == OBFVAL_uoYre.get())
                        {
                            this.ingameGUI.getSpectatorGui().func_175261_b();
                        }
                        else
                        {
                            KeyBinding.onTick(i - OBFVAL_IvTer.get(), Mouse.getEventNanoseconds());
                        }
                    }

                    long i1 = getSystemTime() - this.systemTime;

                    if (i1 <= OBFVAL_Ox8HM.get())
                    {
                        int j = Mouse.getEventDWheel();

                        if (j != 0)
                        {
                            if (this.thePlayer.isSpectator())
                            {
                                j = j < 0 ? -1 : 1;

                                if (this.ingameGUI.getSpectatorGui().func_175262_a())
                                {
                                    this.ingameGUI.getSpectatorGui().func_175259_b(-j);
                                }
                                else
                                {
                                    float f = MathHelper.clamp_float(this.thePlayer.capabilities.getFlySpeed() + (float)j * OBFVAL_Qtyw0.get(), 0.0F, OBFVAL_6Twix.get());
                                    this.thePlayer.capabilities.setFlySpeed(f);
                                }
                            }
                            else
                            {
                                this.thePlayer.inventory.changeCurrentItem(j);
                            }
                        }

                        if (this.currentScreen == null)
                        {
                            if (!this.inGameHasFocus && Mouse.getEventButtonState())
                            {
                                this.setIngameFocus();
                            }
                        }
                        else if (this.currentScreen != null)
                        {
                            this.currentScreen.handleMouseInput();
                        }
                    }
                }
            }

            if (this.leftClickCounter > 0)
            {
                --this.leftClickCounter;
            }

            this.mcProfiler.endStartSection("keyboard");

            while (Keyboard.next())
            {
                if (!Texteria.instance.handleKeyboardEvent())
                {
                    int k = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + OBFVAL_BTUpx.get() : Keyboard.getEventKey();
                    KeyBinding.setKeyBindState(k, Keyboard.getEventKeyState());

                    if (Keyboard.getEventKeyState())
                    {
                        KeyBinding.onTick(k, Keyboard.getEventNanoseconds());
                    }

                    if (this.debugCrashKeyPressTime > 0L)
                    {
                        if (getSystemTime() - this.debugCrashKeyPressTime >= OBFVAL_xkyYA.get())
                        {
                            throw new ReportedException(new CrashReport("Manually triggered debug crash", new Throwable()));
                        }

                        if (!Keyboard.isKeyDown(OBFVAL_lsuE7.get()) || !Keyboard.isKeyDown(OBFVAL_52VoM.get()))
                        {
                            this.debugCrashKeyPressTime = OBFVAL_ZePcJ.get();
                        }
                    }
                    else if (Keyboard.isKeyDown(OBFVAL_lsuE7.get()) && Keyboard.isKeyDown(OBFVAL_52VoM.get()))
                    {
                        this.debugCrashKeyPressTime = getSystemTime();
                    }

                    this.dispatchKeypresses();

                    if (Keyboard.getEventKeyState())
                    {
                        if (k == OBFVAL_hLKIM.get() && this.entityRenderer != null)
                        {
                            this.entityRenderer.switchUseShader();
                        }

                        if (this.currentScreen != null)
                        {
                            this.currentScreen.handleKeyboardInput();
                        }
                        else
                        {
                            if (k == 1)
                            {
                                this.displayInGameMenu();
                                break;
                            }

                            if (k == OBFVAL_fNZrn.get() && Keyboard.isKeyDown(OBFVAL_52VoM.get()) && this.ingameGUI != null)
                            {
                                this.ingameGUI.getChatGUI().clearChatMessages();
                            }

                            if ((k == OBFVAL_1rD6j.get() || k == OBFVAL_xMlG8.get()) && Keyboard.isKeyDown(OBFVAL_52VoM.get()))
                            {
                                long j1 = System.currentTimeMillis();

                                if (j1 - this.lastResourceRefresh < OBFVAL_CsJjh.get())
                                {
                                    if (this.theWorld != null)
                                    {
                                        this.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("\u041f\u043e\u0434\u043e\u0436\u0434\u0438\u0442\u0435 \u043d\u0435\u043c\u043d\u043e\u0433\u043e..."));
                                    }
                                }
                                else
                                {
                                    this.lastResourceRefresh = j1;
                                    this.refreshResources();
                                }
                            }

                            if (k == OBFVAL_qKWb8.get() && Keyboard.isKeyDown(OBFVAL_52VoM.get()))
                            {
                                this.gameSettings.setOptionValue(GameSettings.Options.RENDER_DISTANCE, GuiScreen.isShiftKeyDown() ? -1 : 1);
                            }

                            if (k == OBFVAL_MjVeL.get() && Keyboard.isKeyDown(OBFVAL_52VoM.get()))
                            {
                                ;
                            }

                            if (k == OBFVAL_iX48Y.get() && Keyboard.isKeyDown(OBFVAL_52VoM.get()))
                            {
                                this.gameSettings.advancedItemTooltips = !this.gameSettings.advancedItemTooltips;
                                this.gameSettings.saveOptions();
                            }

                            if (k == OBFVAL_9G18Y.get() && Keyboard.isKeyDown(OBFVAL_52VoM.get()))
                            {
                                this.renderManager.setDebugBoundingBox(!this.renderManager.isDebugBoundingBox());
                            }

                            if (k == OBFVAL_zphTO.get() && Keyboard.isKeyDown(OBFVAL_52VoM.get()))
                            {
                                this.renderManager.debugChunkBorders = !this.renderManager.debugChunkBorders;
                            }

                            if (k == OBFVAL_U6bOR.get() && Keyboard.isKeyDown(OBFVAL_52VoM.get()))
                            {
                                this.gameSettings.pauseOnLostFocus = !this.gameSettings.pauseOnLostFocus;
                                this.gameSettings.saveOptions();
                            }

                            if (k == OBFVAL_LuQVk.get())
                            {
                                this.gameSettings.hideGUI = !this.gameSettings.hideGUI;
                            }

                            if (k == OBFVAL_52VoM.get())
                            {
                                this.gameSettings.showDebugInfo = !this.gameSettings.showDebugInfo;
                                this.gameSettings.showDebugProfilerChart = GuiScreen.isShiftKeyDown();
                                this.gameSettings.field_181657_aC = GuiScreen.isAltKeyDown();
                            }

                            if (this.gameSettings.keyBindTogglePerspective.isPressed())
                            {
                                ++this.gameSettings.thirdPersonView;

                                if (this.gameSettings.thirdPersonView > OBFVAL_uoYre.get())
                                {
                                    this.gameSettings.thirdPersonView = 0;
                                }

                                if (this.gameSettings.thirdPersonView == 0)
                                {
                                    this.entityRenderer.loadEntityShader(this.getRenderViewEntity());
                                }
                                else if (this.gameSettings.thirdPersonView == 1)
                                {
                                    this.entityRenderer.loadEntityShader((Entity)null);
                                }

                                this.renderGlobal.setDisplayListEntitiesDirty();
                            }

                            if (this.gameSettings.keyBindSmoothCamera.isPressed())
                            {
                                this.gameSettings.smoothCamera = !this.gameSettings.smoothCamera;
                            }
                        }

                        if (this.gameSettings.showDebugInfo && this.gameSettings.showDebugProfilerChart)
                        {
                            if (k == OBFVAL_6oHr0.get())
                            {
                                this.updateDebugProfilerName(0);
                            }

                            for (int k1 = 0; k1 < OBFVAL_pSqMs.get(); ++k1)
                            {
                                if (k == OBFVAL_uoYre.get() + k1)
                                {
                                    this.updateDebugProfilerName(k1 + 1);
                                }
                            }
                        }
                    }
                }
            }

            for (int l = 0; l < OBFVAL_pSqMs.get(); ++l)
            {
                if (this.gameSettings.keyBindsHotbar[l].isPressed())
                {
                    if (this.thePlayer.isSpectator())
                    {
                        this.ingameGUI.getSpectatorGui().func_175260_a(l);
                    }
                    else
                    {
                        this.thePlayer.inventory.currentItem = l;
                    }
                }
            }

            boolean flag = this.gameSettings.chatVisibility != EntityPlayer.EnumChatVisibility.HIDDEN;

            while (this.gameSettings.keyBindInventory.isPressed())
            {
                if (this.playerController.isRidingHorse())
                {
                    this.thePlayer.sendHorseInventory();
                }
                else
                {
                    this.getNetHandler().addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.OPEN_INVENTORY_ACHIEVEMENT));
                    this.displayGuiScreen(new GuiInventory(this.thePlayer));
                }
            }

            while (this.gameSettings.keyBindDrop.isPressed())
            {
                if (!this.thePlayer.isSpectator())
                {
                    this.thePlayer.dropOneItem(GuiScreen.isCtrlKeyDown());
                }
            }

            while (this.gameSettings.keyBindChat.isPressed() && flag)
            {
                this.displayGuiScreen(new GuiChat());
            }

            if (this.currentScreen == null && this.gameSettings.keyBindCommand.isPressed() && flag)
            {
                this.displayGuiScreen(new GuiChat("/"));
            }

            if (this.thePlayer.isUsingItem())
            {
                if (!this.gameSettings.keyBindUseItem.isKeyDown())
                {
                    this.playerController.onStoppedUsingItem(this.thePlayer);
                }

                while (this.gameSettings.keyBindAttack.isPressed())
                {
                    ;
                }

                while (this.gameSettings.keyBindUseItem.isPressed())
                {
                    ;
                }

                while (this.gameSettings.keyBindPickBlock.isPressed())
                {
                    ;
                }
            }
            else
            {
                while (this.gameSettings.keyBindAttack.isPressed())
                {
                    this.clickMouse();
                }

                while (this.gameSettings.keyBindUseItem.isPressed())
                {
                    this.rightClickMouse();
                }

                while (this.gameSettings.keyBindPickBlock.isPressed())
                {
                    this.middleClickMouse();
                }
            }

            if (this.gameSettings.keyBindUseItem.isKeyDown() && this.rightClickDelayTimer == 0 && !this.thePlayer.isUsingItem())
            {
                this.rightClickMouse();
            }

            this.sendClickBlockToController(this.currentScreen == null && this.gameSettings.keyBindAttack.isKeyDown() && this.inGameHasFocus);
        }

        if (this.theWorld != null)
        {
            if (this.thePlayer != null)
            {
                ++this.joinPlayerCounter;

                if (this.joinPlayerCounter == OBFVAL_MjVeL.get())
                {
                    this.joinPlayerCounter = 0;
                    this.theWorld.joinEntityInSurroundings(this.thePlayer);
                }
            }

            this.mcProfiler.endStartSection("gameRenderer");

            if (!this.isGamePaused)
            {
                this.entityRenderer.updateRenderer();
            }

            this.mcProfiler.endStartSection("levelRenderer");

            if (!this.isGamePaused)
            {
                this.renderGlobal.updateClouds();
            }

            this.mcProfiler.endStartSection("level");

            if (!this.isGamePaused)
            {
                if (this.theWorld.getLastLightningBolt() > 0)
                {
                    this.theWorld.setLastLightningBolt(this.theWorld.getLastLightningBolt() - 1);
                }

                this.theWorld.updateEntities();
            }

            this.playerController.endOfTick();
        }
        else if (this.entityRenderer.isShaderActive())
        {
            this.entityRenderer.func_181022_b();
        }

        if (!this.isGamePaused)
        {
            this.mcMusicTicker.update();
            this.mcSoundHandler.update();
        }

        if (this.theWorld != null)
        {
            if (!this.isGamePaused)
            {
                this.theWorld.setAllowedSpawnTypes(this.theWorld.getDifficulty() != EnumDifficulty.PEACEFUL, true);

                try
                {
                    this.theWorld.tick();
                }
                catch (Throwable throwable2)
                {
                    CrashReport crashreport2 = CrashReport.makeCrashReport(throwable2, "Exception in world tick");

                    if (this.theWorld == null)
                    {
                        CrashReportCategory crashreportcategory2 = crashreport2.makeCategory("Affected level");
                        crashreportcategory2.addCrashSection("Problem", "Level is null!");
                    }
                    else
                    {
                        this.theWorld.addWorldInfoToCrashReport(crashreport2);
                    }

                    throw new ReportedException(crashreport2);
                }
            }

            this.mcProfiler.endStartSection("animateTick");

            if (!this.isGamePaused && this.theWorld != null)
            {
                this.theWorld.doVoidFogParticles(MathHelper.floor_double(this.thePlayer.posX), MathHelper.floor_double(this.thePlayer.posY), MathHelper.floor_double(this.thePlayer.posZ));
            }

            this.mcProfiler.endStartSection("particles");

            if (!this.isGamePaused)
            {
                this.effectRenderer.updateEffects();
            }
        }
        else if (this.myNetworkManager != null)
        {
            this.mcProfiler.endStartSection("pendingConnection");
            this.myNetworkManager.processReceivedPackets();
        }

        this.mcProfiler.endSection();
        this.systemTime = getSystemTime();
    }

    /**
     * Arguments: World foldername,  World ingame name, WorldSettings
     */
    public void launchIntegratedServer(String folderName, String worldName, WorldSettings worldSettingsIn)
    {
        this.loadWorld((WorldClient)null);
        System.gc();
        ISaveHandler isavehandler = this.saveLoader.getSaveLoader(folderName, false);
        WorldInfo worldinfo = isavehandler.loadWorldInfo();

        if (worldinfo == null && worldSettingsIn != null)
        {
            worldinfo = new WorldInfo(worldSettingsIn, folderName);
            isavehandler.saveWorldInfo(worldinfo);
        }

        if (worldSettingsIn == null)
        {
            worldSettingsIn = new WorldSettings(worldinfo);
        }

        try
        {
            this.theIntegratedServer = new IntegratedServer(this, folderName, worldName, worldSettingsIn);
            this.theIntegratedServer.startServerThread();
            this.integratedServerIsRunning = true;
        }
        catch (Throwable throwable1)
        {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable1, "Starting integrated server");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("Starting integrated server");
            crashreportcategory.addCrashSection("Level ID", folderName);
            crashreportcategory.addCrashSection("Level Name", worldName);
            throw new ReportedException(crashreport);
        }

        this.loadingScreen.displaySavingString(I18n.format("menu.loadingLevel", new Object[0]));

        while (!this.theIntegratedServer.serverIsInRunLoop())
        {
            String s = this.theIntegratedServer.getUserMessage();

            if (s != null)
            {
                this.loadingScreen.displayLoadingString(I18n.format(s, new Object[0]));
            }
            else
            {
                this.loadingScreen.displayLoadingString("");
            }

            try
            {
                Thread.sleep(OBFVAL_Ox8HM.get());
            }
            catch (InterruptedException var9)
            {
                ;
            }
        }

        this.displayGuiScreen((GuiScreen)null);
        SocketAddress socketaddress = this.theIntegratedServer.getNetworkSystem().addLocalEndpoint();
        NetworkManager networkmanager = NetworkManager.provideLocalClient(socketaddress);
        networkmanager.setNetHandler(new NetHandlerLoginClient(networkmanager, this, (GuiScreen)null));
        networkmanager.sendPacket(new C00Handshake(OBFVAL_8EUUQ.get(), socketaddress.toString(), 0, EnumConnectionState.LOGIN));
        networkmanager.sendPacket(new C00PacketLoginStart(this.getSession().getProfile()));
        this.myNetworkManager = networkmanager;
    }

    /**
     * unloads the current world first
     */
    public void loadWorld(WorldClient worldClientIn)
    {
        this.loadWorld(worldClientIn, "");
    }

    /**
     * par2Str is displayed on the loading screen to the user unloads the current world first
     */
    public void loadWorld(WorldClient worldClientIn, String loadingMessage)
    {
        if (worldClientIn == null)
        {
            NetHandlerPlayClient nethandlerplayclient = this.getNetHandler();

            if (nethandlerplayclient != null)
            {
                nethandlerplayclient.cleanup();
            }

            if (this.theIntegratedServer != null && this.theIntegratedServer.isAnvilFileSet())
            {
                this.theIntegratedServer.initiateShutdown();
                this.theIntegratedServer.setStaticInstance();
            }

            this.theIntegratedServer = null;
            this.guiAchievement.clearAchievements();
            this.entityRenderer.getMapItemRenderer().clearLoadedMaps();
        }

        this.renderViewEntity = null;
        this.myNetworkManager = null;

        if (this.loadingScreen != null)
        {
            this.loadingScreen.resetProgressAndMessage(loadingMessage);
            this.loadingScreen.displayLoadingString("");
        }

        if (worldClientIn == null && this.theWorld != null)
        {
            this.mcResourcePackRepository.func_148529_f();
            this.ingameGUI.func_181029_i();
            this.setServerData((ServerData)null);
            this.integratedServerIsRunning = false;
        }

        this.mcSoundHandler.stopSounds();
        this.theWorld = worldClientIn;
        Texteria.instance.onWorldChanged();

        if (worldClientIn != null)
        {
            if (this.renderGlobal != null)
            {
                this.renderGlobal.setWorldAndLoadRenderers(worldClientIn);
            }

            if (this.effectRenderer != null)
            {
                this.effectRenderer.clearEffects(worldClientIn);
            }

            if (this.thePlayer == null)
            {
                this.thePlayer = this.playerController.func_178892_a(worldClientIn, new StatFileWriter());
                this.playerController.flipPlayer(this.thePlayer);
            }

            this.thePlayer.preparePlayerToSpawn();
            worldClientIn.spawnEntityInWorld(this.thePlayer);
            this.thePlayer.movementInput = new MovementInputFromOptions(this.gameSettings);
            this.playerController.setPlayerCapabilities(this.thePlayer);
            this.renderViewEntity = this.thePlayer;
        }
        else
        {
            this.saveLoader.flushCache();
            this.thePlayer = null;
            Texteria.instance.handleDisconnect();
            MiniDot.instance.handleDisconnect();
        }

        System.gc();
        this.systemTime = 0L;
    }

    public void setDimensionAndSpawnPlayer(int dimension)
    {
        this.theWorld.setInitialSpawnLocation();
        this.theWorld.removeAllEntities();
        int i = 0;
        String s = null;

        if (this.thePlayer != null)
        {
            i = this.thePlayer.getEntityId();
            this.theWorld.removeEntity(this.thePlayer);
            s = this.thePlayer.getClientBrand();
        }

        this.renderViewEntity = null;
        EntityPlayerSP entityplayersp = this.thePlayer;
        this.thePlayer = this.playerController.func_178892_a(this.theWorld, this.thePlayer == null ? new StatFileWriter() : this.thePlayer.getStatFileWriter());
        this.thePlayer.getDataWatcher().updateWatchedObjectsFromList(entityplayersp.getDataWatcher().getAllWatched());
        this.thePlayer.dimension = dimension;
        this.renderViewEntity = this.thePlayer;
        this.thePlayer.preparePlayerToSpawn();
        this.thePlayer.setClientBrand(s);
        this.theWorld.spawnEntityInWorld(this.thePlayer);
        this.playerController.flipPlayer(this.thePlayer);
        this.thePlayer.movementInput = new MovementInputFromOptions(this.gameSettings);
        this.thePlayer.setEntityId(i);
        this.playerController.setPlayerCapabilities(this.thePlayer);
        this.thePlayer.setReducedDebug(entityplayersp.hasReducedDebug());

        if (this.currentScreen instanceof GuiGameOver)
        {
            this.displayGuiScreen((GuiScreen)null);
        }
    }

    /**
     * Gets whether this is a demo or not.
     */
    public final boolean isDemo()
    {
        return this.isDemo;
    }

    public NetHandlerPlayClient getNetHandler()
    {
        return this.thePlayer != null ? this.thePlayer.sendQueue : null;
    }

    public static boolean isGuiEnabled()
    {
        return theMinecraft == null || !theMinecraft.gameSettings.hideGUI;
    }

    public static boolean isFancyGraphicsEnabled()
    {
        return theMinecraft != null && theMinecraft.gameSettings.fancyGraphics;
    }

    /**
     * Returns if ambient occlusion is enabled
     */
    public static boolean isAmbientOcclusionEnabled()
    {
        return theMinecraft != null && theMinecraft.gameSettings.ambientOcclusion != 0;
    }

    /**
     * Called when user clicked he's mouse middle button (pick block)
     */
    private void middleClickMouse()
    {
        if (this.objectMouseOver != null)
        {
            boolean flag = this.thePlayer.capabilities.isCreativeMode;
            int i = 0;
            boolean flag1 = false;
            TileEntity tileentity = null;
            Item item;

            if (this.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                BlockPos blockpos = this.objectMouseOver.getBlockPos();
                Block block = this.theWorld.getBlockState(blockpos).getBlock();

                if (block.getMaterial() == Material.air)
                {
                    return;
                }

                item = block.getItem(this.theWorld, blockpos);

                if (item == null)
                {
                    return;
                }

                if (flag && GuiScreen.isCtrlKeyDown())
                {
                    tileentity = this.theWorld.getTileEntity(blockpos);
                }

                Block block1 = item instanceof ItemBlock && !block.isFlowerPot() ? Block.getBlockFromItem(item) : block;
                i = block1.getDamageValue(this.theWorld, blockpos);
                flag1 = item.getHasSubtypes();
            }
            else
            {
                if (this.objectMouseOver.typeOfHit != MovingObjectPosition.MovingObjectType.ENTITY || this.objectMouseOver.entityHit == null || !flag)
                {
                    return;
                }

                if (this.objectMouseOver.entityHit instanceof EntityPainting)
                {
                    item = Items.painting;
                }
                else if (this.objectMouseOver.entityHit instanceof EntityLeashKnot)
                {
                    item = Items.lead;
                }
                else if (this.objectMouseOver.entityHit instanceof EntityItemFrame)
                {
                    EntityItemFrame entityitemframe = (EntityItemFrame)this.objectMouseOver.entityHit;
                    ItemStack itemstack = entityitemframe.getDisplayedItem();

                    if (itemstack == null)
                    {
                        item = Items.item_frame;
                    }
                    else
                    {
                        item = itemstack.getItem();
                        i = itemstack.getMetadata();
                        flag1 = true;
                    }
                }
                else if (this.objectMouseOver.entityHit instanceof EntityMinecart)
                {
                    EntityMinecart entityminecart = (EntityMinecart)this.objectMouseOver.entityHit;

                    switch (entityminecart.getMinecartType())
                    {
                        case FURNACE:
                            item = Items.furnace_minecart;
                            break;

                        case CHEST:
                            item = Items.chest_minecart;
                            break;

                        case TNT:
                            item = Items.tnt_minecart;
                            break;

                        case HOPPER:
                            item = Items.hopper_minecart;
                            break;

                        case COMMAND_BLOCK:
                            item = Items.command_block_minecart;
                            break;

                        default:
                            item = Items.minecart;
                    }
                }
                else if (this.objectMouseOver.entityHit instanceof EntityBoat)
                {
                    item = Items.boat;
                }
                else if (this.objectMouseOver.entityHit instanceof EntityArmorStand)
                {
                    item = Items.armor_stand;
                }
                else
                {
                    item = Items.spawn_egg;
                    i = EntityList.getEntityID(this.objectMouseOver.entityHit);
                    flag1 = true;

                    if (!EntityList.entityEggs.containsKey(Integer.valueOf(i)))
                    {
                        return;
                    }
                }
            }

            InventoryPlayer inventoryplayer = this.thePlayer.inventory;

            if (tileentity == null)
            {
                inventoryplayer.setCurrentItem(item, i, flag1, flag);
            }
            else
            {
                ItemStack itemstack1 = this.func_181036_a(item, i, tileentity);
                inventoryplayer.setInventorySlotContents(inventoryplayer.currentItem, itemstack1);
            }

            if (flag)
            {
                int j = this.thePlayer.inventoryContainer.inventorySlots.size() - OBFVAL_pSqMs.get() + inventoryplayer.currentItem;
                this.playerController.sendSlotPacket(inventoryplayer.getStackInSlot(inventoryplayer.currentItem), j);
            }
        }
    }

    private ItemStack func_181036_a(Item p_181036_1_, int p_181036_2_, TileEntity p_181036_3_)
    {
        ItemStack itemstack = new ItemStack(p_181036_1_, 1, p_181036_2_);
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        p_181036_3_.writeToNBT(nbttagcompound);

        if (p_181036_1_ == Items.skull && nbttagcompound.hasKey("Owner"))
        {
            NBTTagCompound nbttagcompound2 = nbttagcompound.getCompoundTag("Owner");
            NBTTagCompound nbttagcompound3 = new NBTTagCompound();
            nbttagcompound3.setTag("SkullOwner", nbttagcompound2);
            itemstack.setTagCompound(nbttagcompound3);
            return itemstack;
        }
        else
        {
            itemstack.setTagInfo("BlockEntityTag", nbttagcompound);
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            NBTTagList nbttaglist = new NBTTagList();
            nbttaglist.appendTag(new NBTTagString("(+NBT)"));
            nbttagcompound1.setTag("Lore", nbttaglist);
            itemstack.setTagInfo("display", nbttagcompound1);
            return itemstack;
        }
    }

    /**
     * adds core server Info (GL version , Texture pack, isModded, type), and the worldInfo to the crash report
     */
    public CrashReport addGraphicsAndWorldToCrashReport(CrashReport theCrash)
    {
        theCrash.getCategory().addCrashSectionCallable("Launched Version", new Callable<String>()
        {
            public String call() throws Exception
            {
                return Minecraft.this.launchedVersion;
            }
        });
        theCrash.getCategory().addCrashSectionCallable("LWJGL", new Callable<String>()
        {
            public String call() throws Exception
            {
                return Sys.getVersion();
            }
        });
        theCrash.getCategory().addCrashSectionCallable("OpenGL", new Callable<String>()
        {
            public String call()
            {
                return GL11.glGetString(GL11.GL_RENDERER) + " GL version " + GL11.glGetString(GL11.GL_VERSION) + ", " + GL11.glGetString(GL11.GL_VENDOR);
            }
        });
        theCrash.getCategory().addCrashSectionCallable("GL Caps", new Callable<String>()
        {
            public String call()
            {
                return OpenGlHelper.getLogText();
            }
        });
        theCrash.getCategory().addCrashSectionCallable("Using VBOs", new Callable<String>()
        {
            public String call()
            {
                return Minecraft.this.gameSettings.useVbo ? "Yes" : "No";
            }
        });
        theCrash.getCategory().addCrashSectionCallable("Is Modded", new Callable<String>()
        {
            public String call() throws Exception
            {
                String s = ClientBrandRetriever.getClientModName();
                return !s.equals("vanilla") ? "Definitely; Client brand changed to \'" + s + "\'" : (Minecraft.class.getSigners() == null ? "Very likely; Jar signature invalidated" : "Probably not. Jar signature remains and client brand is untouched.");
            }
        });
        theCrash.getCategory().addCrashSectionCallable("Type", new Callable<String>()
        {
            public String call() throws Exception
            {
                return "Client (map_client.txt)";
            }
        });
        theCrash.getCategory().addCrashSectionCallable("Resource Packs", new Callable<String>()
        {
            public String call() throws Exception
            {
                StringBuilder stringbuilder = new StringBuilder();

                for (String s : Minecraft.this.gameSettings.resourcePacks)
                {
                    if (stringbuilder.length() > 0)
                    {
                        stringbuilder.append(", ");
                    }

                    stringbuilder.append(s);

                    if (Minecraft.this.gameSettings.field_183018_l.contains(s))
                    {
                        stringbuilder.append(" (incompatible)");
                    }
                }

                return stringbuilder.toString();
            }
        });
        theCrash.getCategory().addCrashSectionCallable("Current Language", new Callable<String>()
        {
            public String call() throws Exception
            {
                return Minecraft.this.mcLanguageManager.getCurrentLanguage().toString();
            }
        });
        theCrash.getCategory().addCrashSectionCallable("Profiler Position", new Callable<String>()
        {
            public String call() throws Exception
            {
                return Minecraft.this.mcProfiler.profilingEnabled ? Minecraft.this.mcProfiler.getNameOfLastSection() : "N/A (disabled)";
            }
        });
        theCrash.getCategory().addCrashSectionCallable("CPU", new Callable<String>()
        {
            public String call()
            {
                return OpenGlHelper.func_183029_j();
            }
        });

        if (this.theWorld != null)
        {
            this.theWorld.addWorldInfoToCrashReport(theCrash);
        }

        return theCrash;
    }

    /**
     * Return the singleton Minecraft instance for the game
     */
    public static Minecraft getMinecraft()
    {
        return theMinecraft;
    }

    public ListenableFuture<Object> scheduleResourcesRefresh()
    {
        return this.addScheduledTask(new Runnable()
        {
            public void run()
            {
                Minecraft.this.refreshResources();
            }
        });
    }

    public void addServerStatsToSnooper(PlayerUsageSnooper playerSnooper)
    {
        playerSnooper.addClientStat("fps", Integer.valueOf(debugFPS));
        playerSnooper.addClientStat("vsync_enabled", Boolean.valueOf(this.gameSettings.enableVsync));
        playerSnooper.addClientStat("display_frequency", Integer.valueOf(Display.getDisplayMode().getFrequency()));
        playerSnooper.addClientStat("display_type", this.fullscreen ? "fullscreen" : "windowed");
        playerSnooper.addClientStat("run_time", Long.valueOf((MinecraftServer.getCurrentTimeMillis() - playerSnooper.getMinecraftStartTimeMillis()) / OBFVAL_nhDP7.get() * OBFVAL_o4aJW.get()));
        playerSnooper.addClientStat("current_action", this.func_181538_aA());
        String s = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN ? "little" : "big";
        playerSnooper.addClientStat("endianness", s);
        playerSnooper.addClientStat("resource_packs", Integer.valueOf(this.mcResourcePackRepository.getRepositoryEntries().size()));
        int i = 0;

        for (ResourcePackRepository.Entry resourcepackrepository$entry : this.mcResourcePackRepository.getRepositoryEntries())
        {
            playerSnooper.addClientStat("resource_pack[" + i++ + "]", resourcepackrepository$entry.getResourcePackName());
        }

        if (this.theIntegratedServer != null && this.theIntegratedServer.getPlayerUsageSnooper() != null)
        {
            playerSnooper.addClientStat("snooper_partner", this.theIntegratedServer.getPlayerUsageSnooper().getUniqueID());
        }
    }

    private String func_181538_aA()
    {
        return this.theIntegratedServer != null ? (this.theIntegratedServer.getPublic() ? "hosting_lan" : "singleplayer") : (this.currentServerData != null ? (this.currentServerData.func_181041_d() ? "playing_lan" : "multiplayer") : "out_of_game");
    }

    public void addServerTypeToSnooper(PlayerUsageSnooper playerSnooper)
    {
        playerSnooper.addStatToSnooper("opengl_version", GL11.glGetString(OBFVAL_5tIJZ.get()));
        playerSnooper.addStatToSnooper("opengl_vendor", GL11.glGetString(OBFVAL_abP4s.get()));
        playerSnooper.addStatToSnooper("client_brand", ClientBrandRetriever.getClientModName());
        playerSnooper.addStatToSnooper("launched_version", this.launchedVersion);
        ContextCapabilities contextcapabilities = GLContext.getCapabilities();
        playerSnooper.addStatToSnooper("gl_caps[ARB_arrays_of_arrays]", Boolean.valueOf(contextcapabilities.GL_ARB_arrays_of_arrays));
        playerSnooper.addStatToSnooper("gl_caps[ARB_base_instance]", Boolean.valueOf(contextcapabilities.GL_ARB_base_instance));
        playerSnooper.addStatToSnooper("gl_caps[ARB_blend_func_extended]", Boolean.valueOf(contextcapabilities.GL_ARB_blend_func_extended));
        playerSnooper.addStatToSnooper("gl_caps[ARB_clear_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_clear_buffer_object));
        playerSnooper.addStatToSnooper("gl_caps[ARB_color_buffer_float]", Boolean.valueOf(contextcapabilities.GL_ARB_color_buffer_float));
        playerSnooper.addStatToSnooper("gl_caps[ARB_compatibility]", Boolean.valueOf(contextcapabilities.GL_ARB_compatibility));
        playerSnooper.addStatToSnooper("gl_caps[ARB_compressed_texture_pixel_storage]", Boolean.valueOf(contextcapabilities.GL_ARB_compressed_texture_pixel_storage));
        playerSnooper.addStatToSnooper("gl_caps[ARB_compute_shader]", Boolean.valueOf(contextcapabilities.GL_ARB_compute_shader));
        playerSnooper.addStatToSnooper("gl_caps[ARB_copy_buffer]", Boolean.valueOf(contextcapabilities.GL_ARB_copy_buffer));
        playerSnooper.addStatToSnooper("gl_caps[ARB_copy_image]", Boolean.valueOf(contextcapabilities.GL_ARB_copy_image));
        playerSnooper.addStatToSnooper("gl_caps[ARB_depth_buffer_float]", Boolean.valueOf(contextcapabilities.GL_ARB_depth_buffer_float));
        playerSnooper.addStatToSnooper("gl_caps[ARB_compute_shader]", Boolean.valueOf(contextcapabilities.GL_ARB_compute_shader));
        playerSnooper.addStatToSnooper("gl_caps[ARB_copy_buffer]", Boolean.valueOf(contextcapabilities.GL_ARB_copy_buffer));
        playerSnooper.addStatToSnooper("gl_caps[ARB_copy_image]", Boolean.valueOf(contextcapabilities.GL_ARB_copy_image));
        playerSnooper.addStatToSnooper("gl_caps[ARB_depth_buffer_float]", Boolean.valueOf(contextcapabilities.GL_ARB_depth_buffer_float));
        playerSnooper.addStatToSnooper("gl_caps[ARB_depth_clamp]", Boolean.valueOf(contextcapabilities.GL_ARB_depth_clamp));
        playerSnooper.addStatToSnooper("gl_caps[ARB_depth_texture]", Boolean.valueOf(contextcapabilities.GL_ARB_depth_texture));
        playerSnooper.addStatToSnooper("gl_caps[ARB_draw_buffers]", Boolean.valueOf(contextcapabilities.GL_ARB_draw_buffers));
        playerSnooper.addStatToSnooper("gl_caps[ARB_draw_buffers_blend]", Boolean.valueOf(contextcapabilities.GL_ARB_draw_buffers_blend));
        playerSnooper.addStatToSnooper("gl_caps[ARB_draw_elements_base_vertex]", Boolean.valueOf(contextcapabilities.GL_ARB_draw_elements_base_vertex));
        playerSnooper.addStatToSnooper("gl_caps[ARB_draw_indirect]", Boolean.valueOf(contextcapabilities.GL_ARB_draw_indirect));
        playerSnooper.addStatToSnooper("gl_caps[ARB_draw_instanced]", Boolean.valueOf(contextcapabilities.GL_ARB_draw_instanced));
        playerSnooper.addStatToSnooper("gl_caps[ARB_explicit_attrib_location]", Boolean.valueOf(contextcapabilities.GL_ARB_explicit_attrib_location));
        playerSnooper.addStatToSnooper("gl_caps[ARB_explicit_uniform_location]", Boolean.valueOf(contextcapabilities.GL_ARB_explicit_uniform_location));
        playerSnooper.addStatToSnooper("gl_caps[ARB_fragment_layer_viewport]", Boolean.valueOf(contextcapabilities.GL_ARB_fragment_layer_viewport));
        playerSnooper.addStatToSnooper("gl_caps[ARB_fragment_program]", Boolean.valueOf(contextcapabilities.GL_ARB_fragment_program));
        playerSnooper.addStatToSnooper("gl_caps[ARB_fragment_shader]", Boolean.valueOf(contextcapabilities.GL_ARB_fragment_shader));
        playerSnooper.addStatToSnooper("gl_caps[ARB_fragment_program_shadow]", Boolean.valueOf(contextcapabilities.GL_ARB_fragment_program_shadow));
        playerSnooper.addStatToSnooper("gl_caps[ARB_framebuffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_framebuffer_object));
        playerSnooper.addStatToSnooper("gl_caps[ARB_framebuffer_sRGB]", Boolean.valueOf(contextcapabilities.GL_ARB_framebuffer_sRGB));
        playerSnooper.addStatToSnooper("gl_caps[ARB_geometry_shader4]", Boolean.valueOf(contextcapabilities.GL_ARB_geometry_shader4));
        playerSnooper.addStatToSnooper("gl_caps[ARB_gpu_shader5]", Boolean.valueOf(contextcapabilities.GL_ARB_gpu_shader5));
        playerSnooper.addStatToSnooper("gl_caps[ARB_half_float_pixel]", Boolean.valueOf(contextcapabilities.GL_ARB_half_float_pixel));
        playerSnooper.addStatToSnooper("gl_caps[ARB_half_float_vertex]", Boolean.valueOf(contextcapabilities.GL_ARB_half_float_vertex));
        playerSnooper.addStatToSnooper("gl_caps[ARB_instanced_arrays]", Boolean.valueOf(contextcapabilities.GL_ARB_instanced_arrays));
        playerSnooper.addStatToSnooper("gl_caps[ARB_map_buffer_alignment]", Boolean.valueOf(contextcapabilities.GL_ARB_map_buffer_alignment));
        playerSnooper.addStatToSnooper("gl_caps[ARB_map_buffer_range]", Boolean.valueOf(contextcapabilities.GL_ARB_map_buffer_range));
        playerSnooper.addStatToSnooper("gl_caps[ARB_multisample]", Boolean.valueOf(contextcapabilities.GL_ARB_multisample));
        playerSnooper.addStatToSnooper("gl_caps[ARB_multitexture]", Boolean.valueOf(contextcapabilities.GL_ARB_multitexture));
        playerSnooper.addStatToSnooper("gl_caps[ARB_occlusion_query2]", Boolean.valueOf(contextcapabilities.GL_ARB_occlusion_query2));
        playerSnooper.addStatToSnooper("gl_caps[ARB_pixel_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_pixel_buffer_object));
        playerSnooper.addStatToSnooper("gl_caps[ARB_seamless_cube_map]", Boolean.valueOf(contextcapabilities.GL_ARB_seamless_cube_map));
        playerSnooper.addStatToSnooper("gl_caps[ARB_shader_objects]", Boolean.valueOf(contextcapabilities.GL_ARB_shader_objects));
        playerSnooper.addStatToSnooper("gl_caps[ARB_shader_stencil_export]", Boolean.valueOf(contextcapabilities.GL_ARB_shader_stencil_export));
        playerSnooper.addStatToSnooper("gl_caps[ARB_shader_texture_lod]", Boolean.valueOf(contextcapabilities.GL_ARB_shader_texture_lod));
        playerSnooper.addStatToSnooper("gl_caps[ARB_shadow]", Boolean.valueOf(contextcapabilities.GL_ARB_shadow));
        playerSnooper.addStatToSnooper("gl_caps[ARB_shadow_ambient]", Boolean.valueOf(contextcapabilities.GL_ARB_shadow_ambient));
        playerSnooper.addStatToSnooper("gl_caps[ARB_stencil_texturing]", Boolean.valueOf(contextcapabilities.GL_ARB_stencil_texturing));
        playerSnooper.addStatToSnooper("gl_caps[ARB_sync]", Boolean.valueOf(contextcapabilities.GL_ARB_sync));
        playerSnooper.addStatToSnooper("gl_caps[ARB_tessellation_shader]", Boolean.valueOf(contextcapabilities.GL_ARB_tessellation_shader));
        playerSnooper.addStatToSnooper("gl_caps[ARB_texture_border_clamp]", Boolean.valueOf(contextcapabilities.GL_ARB_texture_border_clamp));
        playerSnooper.addStatToSnooper("gl_caps[ARB_texture_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_texture_buffer_object));
        playerSnooper.addStatToSnooper("gl_caps[ARB_texture_cube_map]", Boolean.valueOf(contextcapabilities.GL_ARB_texture_cube_map));
        playerSnooper.addStatToSnooper("gl_caps[ARB_texture_cube_map_array]", Boolean.valueOf(contextcapabilities.GL_ARB_texture_cube_map_array));
        playerSnooper.addStatToSnooper("gl_caps[ARB_texture_non_power_of_two]", Boolean.valueOf(contextcapabilities.GL_ARB_texture_non_power_of_two));
        playerSnooper.addStatToSnooper("gl_caps[ARB_uniform_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_uniform_buffer_object));
        playerSnooper.addStatToSnooper("gl_caps[ARB_vertex_blend]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_blend));
        playerSnooper.addStatToSnooper("gl_caps[ARB_vertex_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_buffer_object));
        playerSnooper.addStatToSnooper("gl_caps[ARB_vertex_program]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_program));
        playerSnooper.addStatToSnooper("gl_caps[ARB_vertex_shader]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_shader));
        playerSnooper.addStatToSnooper("gl_caps[EXT_bindable_uniform]", Boolean.valueOf(contextcapabilities.GL_EXT_bindable_uniform));
        playerSnooper.addStatToSnooper("gl_caps[EXT_blend_equation_separate]", Boolean.valueOf(contextcapabilities.GL_EXT_blend_equation_separate));
        playerSnooper.addStatToSnooper("gl_caps[EXT_blend_func_separate]", Boolean.valueOf(contextcapabilities.GL_EXT_blend_func_separate));
        playerSnooper.addStatToSnooper("gl_caps[EXT_blend_minmax]", Boolean.valueOf(contextcapabilities.GL_EXT_blend_minmax));
        playerSnooper.addStatToSnooper("gl_caps[EXT_blend_subtract]", Boolean.valueOf(contextcapabilities.GL_EXT_blend_subtract));
        playerSnooper.addStatToSnooper("gl_caps[EXT_draw_instanced]", Boolean.valueOf(contextcapabilities.GL_EXT_draw_instanced));
        playerSnooper.addStatToSnooper("gl_caps[EXT_framebuffer_multisample]", Boolean.valueOf(contextcapabilities.GL_EXT_framebuffer_multisample));
        playerSnooper.addStatToSnooper("gl_caps[EXT_framebuffer_object]", Boolean.valueOf(contextcapabilities.GL_EXT_framebuffer_object));
        playerSnooper.addStatToSnooper("gl_caps[EXT_framebuffer_sRGB]", Boolean.valueOf(contextcapabilities.GL_EXT_framebuffer_sRGB));
        playerSnooper.addStatToSnooper("gl_caps[EXT_geometry_shader4]", Boolean.valueOf(contextcapabilities.GL_EXT_geometry_shader4));
        playerSnooper.addStatToSnooper("gl_caps[EXT_gpu_program_parameters]", Boolean.valueOf(contextcapabilities.GL_EXT_gpu_program_parameters));
        playerSnooper.addStatToSnooper("gl_caps[EXT_gpu_shader4]", Boolean.valueOf(contextcapabilities.GL_EXT_gpu_shader4));
        playerSnooper.addStatToSnooper("gl_caps[EXT_multi_draw_arrays]", Boolean.valueOf(contextcapabilities.GL_EXT_multi_draw_arrays));
        playerSnooper.addStatToSnooper("gl_caps[EXT_packed_depth_stencil]", Boolean.valueOf(contextcapabilities.GL_EXT_packed_depth_stencil));
        playerSnooper.addStatToSnooper("gl_caps[EXT_paletted_texture]", Boolean.valueOf(contextcapabilities.GL_EXT_paletted_texture));
        playerSnooper.addStatToSnooper("gl_caps[EXT_rescale_normal]", Boolean.valueOf(contextcapabilities.GL_EXT_rescale_normal));
        playerSnooper.addStatToSnooper("gl_caps[EXT_separate_shader_objects]", Boolean.valueOf(contextcapabilities.GL_EXT_separate_shader_objects));
        playerSnooper.addStatToSnooper("gl_caps[EXT_shader_image_load_store]", Boolean.valueOf(contextcapabilities.GL_EXT_shader_image_load_store));
        playerSnooper.addStatToSnooper("gl_caps[EXT_shadow_funcs]", Boolean.valueOf(contextcapabilities.GL_EXT_shadow_funcs));
        playerSnooper.addStatToSnooper("gl_caps[EXT_shared_texture_palette]", Boolean.valueOf(contextcapabilities.GL_EXT_shared_texture_palette));
        playerSnooper.addStatToSnooper("gl_caps[EXT_stencil_clear_tag]", Boolean.valueOf(contextcapabilities.GL_EXT_stencil_clear_tag));
        playerSnooper.addStatToSnooper("gl_caps[EXT_stencil_two_side]", Boolean.valueOf(contextcapabilities.GL_EXT_stencil_two_side));
        playerSnooper.addStatToSnooper("gl_caps[EXT_stencil_wrap]", Boolean.valueOf(contextcapabilities.GL_EXT_stencil_wrap));
        playerSnooper.addStatToSnooper("gl_caps[EXT_texture_3d]", Boolean.valueOf(contextcapabilities.GL_EXT_texture_3d));
        playerSnooper.addStatToSnooper("gl_caps[EXT_texture_array]", Boolean.valueOf(contextcapabilities.GL_EXT_texture_array));
        playerSnooper.addStatToSnooper("gl_caps[EXT_texture_buffer_object]", Boolean.valueOf(contextcapabilities.GL_EXT_texture_buffer_object));
        playerSnooper.addStatToSnooper("gl_caps[EXT_texture_integer]", Boolean.valueOf(contextcapabilities.GL_EXT_texture_integer));
        playerSnooper.addStatToSnooper("gl_caps[EXT_texture_lod_bias]", Boolean.valueOf(contextcapabilities.GL_EXT_texture_lod_bias));
        playerSnooper.addStatToSnooper("gl_caps[EXT_texture_sRGB]", Boolean.valueOf(contextcapabilities.GL_EXT_texture_sRGB));
        playerSnooper.addStatToSnooper("gl_caps[EXT_vertex_shader]", Boolean.valueOf(contextcapabilities.GL_EXT_vertex_shader));
        playerSnooper.addStatToSnooper("gl_caps[EXT_vertex_weighting]", Boolean.valueOf(contextcapabilities.GL_EXT_vertex_weighting));
        playerSnooper.addStatToSnooper("gl_caps[gl_max_vertex_uniforms]", Integer.valueOf(GL11.glGetInteger(OBFVAL_Mnkt1.get())));
        GL11.glGetError();
        playerSnooper.addStatToSnooper("gl_caps[gl_max_fragment_uniforms]", Integer.valueOf(GL11.glGetInteger(OBFVAL_fmKdc.get())));
        GL11.glGetError();
        playerSnooper.addStatToSnooper("gl_caps[gl_max_vertex_attribs]", Integer.valueOf(GL11.glGetInteger(OBFVAL_xsxte.get())));
        GL11.glGetError();
        playerSnooper.addStatToSnooper("gl_caps[gl_max_vertex_texture_image_units]", Integer.valueOf(GL11.glGetInteger(OBFVAL_wnhCo.get())));
        GL11.glGetError();
        playerSnooper.addStatToSnooper("gl_caps[gl_max_texture_image_units]", Integer.valueOf(GL11.glGetInteger(OBFVAL_kK58l.get())));
        GL11.glGetError();
        playerSnooper.addStatToSnooper("gl_caps[gl_max_texture_image_units]", Integer.valueOf(GL11.glGetInteger(OBFVAL_4Xw4q.get())));
        GL11.glGetError();
        playerSnooper.addStatToSnooper("gl_max_texture_size", Integer.valueOf(getGLMaximumTextureSize()));
    }

    /**
     * Used in the usage snooper.
     */
    public static int getGLMaximumTextureSize()
    {
        for (int i = OBFVAL_A1vox.get(); i > 0; i >>= 1)
        {
            GL11.glTexImage2D(OBFVAL_kZqXr.get(), 0, OBFVAL_GIHDe.get(), i, i, 0, OBFVAL_GIHDe.get(), OBFVAL_mIuZA.get(), (ByteBuffer)((ByteBuffer)null));
            int j = GL11.glGetTexLevelParameteri(OBFVAL_kZqXr.get(), 0, OBFVAL_rF01F.get());

            if (j != 0)
            {
                return i;
            }
        }

        return -1;
    }

    /**
     * Returns whether snooping is enabled or not.
     */
    public boolean isSnooperEnabled()
    {
        return this.gameSettings.snooperEnabled;
    }

    /**
     * Set the current ServerData instance.
     */
    public void setServerData(ServerData serverDataIn)
    {
        this.currentServerData = serverDataIn;
    }

    public ServerData getCurrentServerData()
    {
        return this.currentServerData;
    }

    public boolean isIntegratedServerRunning()
    {
        return this.integratedServerIsRunning;
    }

    /**
     * Returns true if there is only one player playing, and the current server is the integrated one.
     */
    public boolean isSingleplayer()
    {
        return this.integratedServerIsRunning && this.theIntegratedServer != null;
    }

    /**
     * Returns the currently running integrated server
     */
    public IntegratedServer getIntegratedServer()
    {
        return this.theIntegratedServer;
    }

    public static void stopIntegratedServer()
    {
        if (theMinecraft != null)
        {
            IntegratedServer integratedserver = theMinecraft.getIntegratedServer();

            if (integratedserver != null)
            {
                integratedserver.stopServer();
            }
        }
    }

    /**
     * Returns the PlayerUsageSnooper instance.
     */
    public PlayerUsageSnooper getPlayerUsageSnooper()
    {
        return this.usageSnooper;
    }

    /**
     * Gets the system time in milliseconds.
     */
    public static long getSystemTime()
    {
        return Sys.getTime() * OBFVAL_o4aJW.get() / Sys.getTimerResolution();
    }

    /**
     * Returns whether we're in full screen or not.
     */
    public boolean isFullScreen()
    {
        return this.fullscreen;
    }

    public Session getSession()
    {
        return this.session;
    }

    public PropertyMap getTwitchDetails()
    {
        return this.twitchDetails;
    }

    public PropertyMap func_181037_M()
    {
        if (this.field_181038_N.isEmpty())
        {
            GameProfile gameprofile = this.getSessionService().fillProfileProperties(this.session.getProfile(), false);
            this.field_181038_N.putAll(gameprofile.getProperties());
        }

        return this.field_181038_N;
    }

    public Proxy getProxy()
    {
        return this.proxy;
    }

    public TextureManager getTextureManager()
    {
        return this.renderEngine;
    }

    public IResourceManager getResourceManager()
    {
        return this.mcResourceManager;
    }

    public ResourcePackRepository getResourcePackRepository()
    {
        return this.mcResourcePackRepository;
    }

    public LanguageManager getLanguageManager()
    {
        return this.mcLanguageManager;
    }

    public TextureMap getTextureMapBlocks()
    {
        return this.textureMapBlocks;
    }

    public boolean isJava64bit()
    {
        return this.jvm64bit;
    }

    public boolean isGamePaused()
    {
        return this.isGamePaused;
    }

    public SoundHandler getSoundHandler()
    {
        return this.mcSoundHandler;
    }

    public MusicTicker.MusicType getAmbientMusicType()
    {
        return this.thePlayer != null ? (this.thePlayer.worldObj.provider instanceof WorldProviderHell ? MusicTicker.MusicType.NETHER : (this.thePlayer.worldObj.provider instanceof WorldProviderEnd ? (BossStatus.bossName != null && BossStatus.statusBarTime > 0 ? MusicTicker.MusicType.END_BOSS : MusicTicker.MusicType.END) : (this.thePlayer.capabilities.isCreativeMode && this.thePlayer.capabilities.allowFlying ? MusicTicker.MusicType.CREATIVE : MusicTicker.MusicType.GAME))) : MusicTicker.MusicType.MENU;
    }

    public IStream getTwitchStream()
    {
        return this.stream;
    }

    public void dispatchKeypresses()
    {
        int i = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() : Keyboard.getEventKey();

        if (i != 0 && !Keyboard.isRepeatEvent() && (!(this.currentScreen instanceof GuiControls) || ((GuiControls)this.currentScreen).time <= getSystemTime() - OBFVAL_xN7hH.get()))
        {
            if (Keyboard.getEventKeyState())
            {
                if (i == this.gameSettings.keyBindStreamStartStop.getKeyCode())
                {
                    if (this.getTwitchStream().isBroadcasting())
                    {
                        this.getTwitchStream().stopBroadcasting();
                    }
                    else if (this.getTwitchStream().isReadyToBroadcast())
                    {
                        this.displayGuiScreen(new GuiYesNo(new GuiYesNoCallback()
                        {
                            public void confirmClicked(boolean result, int id)
                            {
                                if (result)
                                {
                                    Minecraft.this.getTwitchStream().func_152930_t();
                                }

                                Minecraft.this.displayGuiScreen((GuiScreen)null);
                            }
                        }, I18n.format("stream.confirm_start", new Object[0]), "", 0));
                    }
                    else if (this.getTwitchStream().func_152928_D() && this.getTwitchStream().func_152936_l())
                    {
                        if (this.theWorld != null)
                        {
                            this.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("Not ready to start streaming yet!"));
                        }
                    }
                    else
                    {
                        GuiStreamUnavailable.func_152321_a(this.currentScreen);
                    }
                }
                else if (i == this.gameSettings.keyBindStreamPauseUnpause.getKeyCode())
                {
                    if (this.getTwitchStream().isBroadcasting())
                    {
                        if (this.getTwitchStream().isPaused())
                        {
                            this.getTwitchStream().unpause();
                        }
                        else
                        {
                            this.getTwitchStream().pause();
                        }
                    }
                }
                else if (i == this.gameSettings.keyBindStreamCommercials.getKeyCode())
                {
                    if (this.getTwitchStream().isBroadcasting())
                    {
                        this.getTwitchStream().requestCommercial();
                    }
                }
                else if (i == this.gameSettings.keyBindStreamToggleMic.getKeyCode())
                {
                    this.stream.muteMicrophone(true);
                }
                else if (i == this.gameSettings.keyBindFullscreen.getKeyCode())
                {
                    this.toggleFullscreen();
                }
                else if (i == this.gameSettings.keyBindScreenshot.getKeyCode())
                {
                    this.ingameGUI.getChatGUI().printChatMessage(ScreenShotHelper.saveScreenshot(this.mcDataDir, this.displayWidth, this.displayHeight, this.framebufferMc));
                }
            }
            else if (i == this.gameSettings.keyBindStreamToggleMic.getKeyCode())
            {
                this.stream.muteMicrophone(false);
            }
        }
    }

    public MinecraftSessionService getSessionService()
    {
        return this.sessionService;
    }

    public SkinManager getSkinManager()
    {
        return this.skinManager;
    }

    public Entity getRenderViewEntity()
    {
        return this.renderViewEntity;
    }

    public void setRenderViewEntity(Entity viewingEntity)
    {
        this.renderViewEntity = viewingEntity;
        this.entityRenderer.loadEntityShader(viewingEntity);
    }

    public <V> ListenableFuture<V> addScheduledTask(Callable<V> callableToSchedule)
    {
        Validate.notNull(callableToSchedule);

        if (!this.isCallingFromMinecraftThread())
        {
            ListenableFutureTask<V> listenablefuturetask = ListenableFutureTask.<V>create(callableToSchedule);

            synchronized (this.scheduledTasks)
            {
                this.scheduledTasks.add(listenablefuturetask);
                return listenablefuturetask;
            }
        }
        else
        {
            try
            {
                return Futures.<V>immediateFuture(callableToSchedule.call());
            }
            catch (Exception exception)
            {
                return Futures.immediateFailedCheckedFuture(exception);
            }
        }
    }

    public ListenableFuture<Object> addScheduledTask(Runnable runnableToSchedule)
    {
        Validate.notNull(runnableToSchedule);
        return this.<Object>addScheduledTask(Executors.callable(runnableToSchedule));
    }

    public boolean isCallingFromMinecraftThread()
    {
        return Thread.currentThread() == this.mcThread;
    }

    public BlockRendererDispatcher getBlockRendererDispatcher()
    {
        return this.blockRenderDispatcher;
    }

    public RenderManager getRenderManager()
    {
        return this.renderManager;
    }

    public RenderItem getRenderItem()
    {
        return this.renderItem;
    }

    public ItemRenderer getItemRenderer()
    {
        return this.itemRenderer;
    }

    public static int getDebugFPS()
    {
        return debugFPS;
    }

    public FrameTimer func_181539_aj()
    {
        return this.field_181542_y;
    }

    public static Map<String, String> getSessionInfo()
    {
        Map<String, String> map = Maps.<String, String>newHashMap();
        map.put("X-Minecraft-Username", getMinecraft().getSession().getUsername());
        map.put("X-Minecraft-UUID", getMinecraft().getSession().getPlayerID());
        map.put("X-Minecraft-Version", "1.8.8");
        return map;
    }

    public static void disconnectAndMessage(String p_disconnectAndMessage_0_)
    {
        NetHandlerPlayClient nethandlerplayclient = getMinecraft().getNetHandler();

        if (nethandlerplayclient != null)
        {
            nethandlerplayclient.getNetworkManager().closeChannel(new ChatComponentText(p_disconnectAndMessage_0_));
        }
    }

    static
    {
        ObfValue.beginGeneration();
        ObfValue.endGeneration(new byte[] {(byte)50, (byte)8, (byte) - 79, (byte)9, (byte) - 101, (byte)81, (byte) - 10, (byte)55});
    }
}
