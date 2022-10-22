package net.minecraft.client.settings;

import com.creativemd.cmdcam.key.CMDCamKeyHandler;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.stream.TwitchStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.network.play.client.C15PacketClientSettings;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.xtrafrancyz.covered.ObfValue;
import optifine.ClearWater;
import optifine.Config;
import optifine.CustomColors;
import optifine.CustomSky;
import optifine.DynamicLights;
import optifine.Lang;
import optifine.NaturalTextures;
import optifine.RandomMobs;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import shadersmod.client.Shaders;

public class GameSettings
{
    private static final ObfValue.OInteger OBFVAL_a7Nza = ObfValue.create(9);
    private static final ObfValue.OInteger OBFVAL_DXAeR = ObfValue.create(24);
    private static final ObfValue.OInteger OBFVAL_jsyyR = ObfValue.create(87);
    private static final ObfValue.OInteger OBFVAL_ZGOVI = ObfValue.create(4000);
    private static final ObfValue.OInteger OBFVAL_xHKcu = ObfValue.create(21);
    private static final ObfValue.OInteger OBFVAL_Qyn8N = ObfValue.create(4);
    private static final ObfValue.OInteger OBFVAL_R9fpX = ObfValue.create(-98);
    private static final ObfValue.OFloat OBFVAL_q92qJ = ObfValue.create(0.81F);
    private static final ObfValue.OInteger OBFVAL_8qc8d = ObfValue.create(58);
    private static final ObfValue.OFloat OBFVAL_4Xfmz = ObfValue.create(70.0F);
    private static final ObfValue.OInteger OBFVAL_0TXuY = ObfValue.create(46);
    private static final ObfValue.OFloat OBFVAL_5pPS8 = ObfValue.create(40.0F);
    private static final ObfValue.OFloat OBFVAL_xwhmC = ObfValue.create(0.31690142F);
    private static final ObfValue.OInteger OBFVAL_qx2Gc = ObfValue.create(64);
    private static final ObfValue.OInteger OBFVAL_tcTGe = ObfValue.create(-100);
    private static final ObfValue.OFloat OBFVAL_ZZBbi = ObfValue.create(0.44366196F);
    private static final ObfValue.OFloat OBFVAL_81iPD = ObfValue.create(200.0F);
    private static final ObfValue.OFloat OBFVAL_sqMCa = ObfValue.create(400.0F);
    private static final ObfValue.OInteger OBFVAL_49oMU = ObfValue.create(16);
    private static final ObfValue.OInteger OBFVAL_45IKc = ObfValue.create(13);
    private static final ObfValue.OFloat OBFVAL_ZyvQA = ObfValue.create(0.5412844F);
    private static final ObfValue.OInteger OBFVAL_DkIkE = ObfValue.create(60);
    private static final ObfValue.OInteger OBFVAL_e3WYb = ObfValue.create(101);
    private static final ObfValue.OInteger OBFVAL_nEYHR = ObfValue.create(23);
    private static final ObfValue.OInteger OBFVAL_1uadt = ObfValue.create(40);
    private static final ObfValue.OFloat OBFVAL_GO5Oo = ObfValue.create(100.0F);
    private static final ObfValue.OInteger OBFVAL_sIiuW = ObfValue.create(19);
    private static final ObfValue.OInteger OBFVAL_uhfoz = ObfValue.create(11);
    private static final ObfValue.OFloat OBFVAL_H6XKu = ObfValue.create(110.0F);
    private static final ObfValue.OFloat OBFVAL_jMTdC = ObfValue.create(32.0F);
    private static final ObfValue.OInteger OBFVAL_cphMo = ObfValue.create(400);
    private static final ObfValue.OInteger OBFVAL_5pHRY = ObfValue.create(40000);
    private static final ObfValue.OInteger OBFVAL_uoEmP = ObfValue.create(63);
    private static final ObfValue.OInteger OBFVAL_A5IO2 = ObfValue.create(31);
    private static final ObfValue.OInteger OBFVAL_dSUah = ObfValue.create(7);
    private static final ObfValue.OInteger OBFVAL_qBjrJ = ObfValue.create(22);
    private static final ObfValue.OInteger OBFVAL_2Dz3u = ObfValue.create(42);
    private static final ObfValue.OInteger OBFVAL_3YDHA = ObfValue.create(20);
    private static final ObfValue.OInteger OBFVAL_W8MAh = ObfValue.create(6);
    private static final ObfValue.OInteger OBFVAL_WJyFb = ObfValue.create(100);
    private static final ObfValue.OFloat OBFVAL_k0IUs = ObfValue.create(0.5F);
    private static final ObfValue.OFloat OBFVAL_L0jh5 = ObfValue.create(0.8F);
    private static final ObfValue.OInteger OBFVAL_K6hCW = ObfValue.create(32);
    private static final ObfValue.OInteger OBFVAL_cPaTy = ObfValue.create(10);
    private static final ObfValue.OInteger OBFVAL_aiwjg = ObfValue.create(128);
    private static final ObfValue.OInteger OBFVAL_daUoz = ObfValue.create(65);
    private static final ObfValue.OInteger OBFVAL_rkM2H = ObfValue.create(5);
    private static final ObfValue.OInteger OBFVAL_Wesap = ObfValue.create(8);
    private static final ObfValue.OInteger OBFVAL_uuSba = ObfValue.create(256);
    private static final ObfValue.OInteger OBFVAL_gZjO1 = ObfValue.create(17);
    private static final ObfValue.OInteger OBFVAL_HsLub = ObfValue.create(30);
    private static final ObfValue.OInteger OBFVAL_LXDQI = ObfValue.create(120);
    private static final ObfValue.OInteger OBFVAL_pzNvu = ObfValue.create(14);
    private static final ObfValue.OInteger OBFVAL_uKPuf = ObfValue.create(-99);
    private static final ObfValue.OFloat OBFVAL_t9f7h = ObfValue.create(10.0F);
    private static final ObfValue.OInteger OBFVAL_ycoNk = ObfValue.create(3);
    private static final ObfValue.OFloat OBFVAL_QQigx = ObfValue.create(90.0F);
    private static final ObfValue.OInteger OBFVAL_yUuuQ = ObfValue.create(53);
    private static final ObfValue.OInteger OBFVAL_yHsKT = ObfValue.create(255);
    private static final ObfValue.OInteger OBFVAL_8tmgL = ObfValue.create(12);
    private static final ObfValue.OInteger OBFVAL_nE2PN = ObfValue.create(18);
    private static final ObfValue.OInteger OBFVAL_Sv3mU = ObfValue.create(15);
    private static final ObfValue.OFloat OBFVAL_b7fPY = ObfValue.create(0.2F);
    private static final ObfValue.OInteger OBFVAL_JnlTQ = ObfValue.create(29);
    private static final ObfValue.OInteger OBFVAL_LrwhV = ObfValue.create(2);
    private static final ObfValue.OInteger OBFVAL_G4ok4 = ObfValue.create(57);
    private static final Logger logger = LogManager.getLogger();
    private static final Gson gson = new Gson();
    private static final ParameterizedType typeListString = new ParameterizedType()
    {
        private static final String __OBFID = "CL_00000651";
        public Type[] getActualTypeArguments()
        {
            return new Type[] {String.class};
        }
        public Type getRawType()
        {
            return List.class;
        }
        public Type getOwnerType()
        {
            return null;
        }
    };

    /** GUI scale values */
    private static final String[] GUISCALES = new String[] {"options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"};
    private static final String[] PARTICLES = new String[] {"options.particles.all", "options.particles.decreased", "options.particles.minimal"};
    private static final String[] AMBIENT_OCCLUSIONS = new String[] {"options.ao.off", "options.ao.min", "options.ao.max"};
    private static final String[] STREAM_COMPRESSIONS = new String[] {"options.stream.compression.low", "options.stream.compression.medium", "options.stream.compression.high"};
    private static final String[] STREAM_CHAT_MODES = new String[] {"options.stream.chat.enabled.streaming", "options.stream.chat.enabled.always", "options.stream.chat.enabled.never"};
    private static final String[] STREAM_CHAT_FILTER_MODES = new String[] {"options.stream.chat.userFilter.all", "options.stream.chat.userFilter.subs", "options.stream.chat.userFilter.mods"};
    private static final String[] STREAM_MIC_MODES = new String[] {"options.stream.mic_toggle.mute", "options.stream.mic_toggle.talk"};
    private static final String[] field_181149_aW = new String[] {"options.off", "options.graphics.fast", "options.graphics.fancy"};
    public float mouseSensitivity;
    public boolean invertMouse;
    public int renderDistanceChunks;
    public boolean viewBobbing;
    public boolean anaglyph;
    public boolean fboEnable;
    public int limitFramerate;

    /** Clouds flag */
    public int clouds;
    public boolean fancyGraphics;

    /** Smooth Lighting */
    public int ambientOcclusion;
    public List<String> resourcePacks;
    public List<String> field_183018_l;
    public EntityPlayer.EnumChatVisibility chatVisibility;
    public boolean chatColours;
    public boolean chatLinks;
    public boolean chatLinksPrompt;
    public float chatOpacity;
    public boolean snooperEnabled;
    public boolean fullScreen;
    public boolean enableVsync;
    public boolean useVbo;
    public boolean allowBlockAlternatives;
    public boolean reducedDebugInfo;
    public boolean hideServerAddress;

    /**
     * Whether to show advanced information on item tooltips, toggled by F3+H
     */
    public boolean advancedItemTooltips;

    /** Whether to pause when the game loses focus, toggled by F3+P */
    public boolean pauseOnLostFocus;
    private final Set setModelParts;
    public boolean touchscreen;
    public int overrideWidth;
    public int overrideHeight;
    public boolean heldItemTooltips;
    public float chatScale;
    public float chatWidth;
    public float chatHeightUnfocused;
    public float chatHeightFocused;
    public boolean showInventoryAchievementHint;
    public int mipmapLevels;
    private Map mapSoundLevels;
    public float streamBytesPerPixel;
    public float streamMicVolume;
    public float streamGameVolume;
    public float streamKbps;
    public float streamFps;
    public int streamCompression;
    public boolean streamSendMetadata;
    public String streamPreferredServer;
    public int streamChatEnabled;
    public int streamChatUserFilter;
    public int streamMicToggleBehavior;
    public boolean field_181150_U;
    public boolean field_181151_V;
    public KeyBinding keyBindForward;
    public KeyBinding keyBindLeft;
    public KeyBinding keyBindBack;
    public KeyBinding keyBindRight;
    public KeyBinding keyBindJump;
    public KeyBinding keyBindSneak;
    public KeyBinding keyBindSprint;
    public KeyBinding keyBindInventory;
    public KeyBinding keyBindUseItem;
    public KeyBinding keyBindDrop;
    public KeyBinding keyBindAttack;
    public KeyBinding keyBindPickBlock;
    public KeyBinding keyBindChat;
    public KeyBinding keyBindPlayerList;
    public KeyBinding keyBindCommand;
    public KeyBinding keyBindScreenshot;
    public KeyBinding keyBindTogglePerspective;
    public KeyBinding keyBindSmoothCamera;
    public KeyBinding keyBindFullscreen;
    public KeyBinding keyBindSpectatorOutlines;
    public KeyBinding keyBindStreamStartStop;
    public KeyBinding keyBindStreamPauseUnpause;
    public KeyBinding keyBindStreamCommercials;
    public KeyBinding keyBindStreamToggleMic;
    public KeyBinding[] keyBindsHotbar;
    public KeyBinding[] keyBindings;
    protected Minecraft mc;
    private File optionsFile;
    public EnumDifficulty difficulty;
    public boolean hideGUI;
    public int thirdPersonView;

    /** true if debug info should be displayed instead of version */
    public boolean showDebugInfo;
    public boolean showDebugProfilerChart;
    public boolean field_181657_aC;

    /** The lastServer string. */
    public String lastServer;

    /** Smooth Camera Toggle */
    public boolean smoothCamera;
    public boolean debugCamEnable;
    public float fovSetting;
    public float gammaSetting;
    public float saturation;

    /** GUI scale */
    public int guiScale;

    /** Determines amount of particles. 0 = All, 1 = Decreased, 2 = Minimal */
    public int particleSetting;

    /** Game settings language */
    public String language;
    public boolean forceUnicodeFont;
    private static final String __OBFID = "CL_00000650";
    public int ofFogType;
    public float ofFogStart;
    public int ofMipmapType;
    public boolean ofOcclusionFancy;
    public boolean ofSmoothFps;
    public boolean ofSmoothWorld;
    public boolean ofLazyChunkLoading;
    public float ofAoLevel;
    public int ofAaLevel;
    public int ofAfLevel;
    public int ofClouds;
    public float ofCloudsHeight;
    public int ofTrees;
    public int ofRain;
    public int ofDroppedItems;
    public int ofBetterGrass;
    public int ofAutoSaveTicks;
    public boolean ofLagometer;
    public boolean ofProfiler;
    public boolean ofShowFps;
    public boolean ofWeather;
    public boolean ofSky;
    public boolean ofStars;
    public boolean ofSunMoon;
    public int ofVignette;
    public int ofChunkUpdates;
    public boolean ofChunkUpdatesDynamic;
    public int ofTime;
    public boolean ofClearWater;
    public boolean ofBetterSnow;
    public String ofFullscreenMode;
    public boolean ofSwampColors;
    public boolean ofRandomMobs;
    public boolean ofSmoothBiomes;
    public boolean ofCustomFonts;
    public boolean ofCustomColors;
    public boolean ofCustomSky;
    public boolean ofShowCapes;
    public int ofConnectedTextures;
    public boolean ofCustomItems;
    public boolean ofNaturalTextures;
    public boolean ofFastMath;
    public boolean ofFastRender;
    public int ofTranslucentBlocks;
    public boolean ofDynamicFov;
    public int ofDynamicLights;
    public int ofAnimatedWater;
    public int ofAnimatedLava;
    public boolean ofAnimatedFire;
    public boolean ofAnimatedPortal;
    public boolean ofAnimatedRedstone;
    public boolean ofAnimatedExplosion;
    public boolean ofAnimatedFlame;
    public boolean ofAnimatedSmoke;
    public boolean ofVoidParticles;
    public boolean ofWaterParticles;
    public boolean ofRainSplash;
    public boolean ofPortalParticles;
    public boolean ofPotionParticles;
    public boolean ofFireworkParticles;
    public boolean ofDrippingWaterLava;
    public boolean ofAnimatedTerrain;
    public boolean ofAnimatedTextures;
    public static final int DEFAULT = 0;
    public static final int FAST = 1;
    public static final int FANCY = 2;
    public static final int OFF = 3;
    public static final int SMART = 4;
    public static final int ANIM_ON = 0;
    public static final int ANIM_GENERATED = 1;
    public static final int ANIM_OFF = 2;
    public static final String DEFAULT_STR = "Default";
    private static final int[] OF_TREES_VALUES = new int[] {0, 1, 4, 2};
    private static final int[] OF_DYNAMIC_LIGHTS = new int[] {3, 1, 2};
    private static final String[] KEYS_DYNAMIC_LIGHTS = new String[] {"options.off", "options.graphics.fast", "options.graphics.fancy"};
    public KeyBinding ofKeyBindZoom;
    private File optionsFileOF;

    public GameSettings(Minecraft mcIn, File p_i46326_2_)
    {
        this.mouseSensitivity = OBFVAL_k0IUs.get();
        this.renderDistanceChunks = -1;
        this.viewBobbing = true;
        this.fboEnable = true;
        this.limitFramerate = OBFVAL_LXDQI.get();
        this.clouds = OBFVAL_LrwhV.get();
        this.fancyGraphics = true;
        this.ambientOcclusion = OBFVAL_LrwhV.get();
        this.resourcePacks = Lists.<String>newArrayList();
        this.field_183018_l = Lists.<String>newArrayList();
        this.chatVisibility = EntityPlayer.EnumChatVisibility.FULL;
        this.chatColours = true;
        this.chatLinks = true;
        this.chatLinksPrompt = true;
        this.chatOpacity = 1.0F;
        this.snooperEnabled = true;
        this.enableVsync = true;
        this.useVbo = false;
        this.allowBlockAlternatives = true;
        this.reducedDebugInfo = false;
        this.pauseOnLostFocus = true;
        this.setModelParts = Sets.newHashSet(EnumPlayerModelParts.values());
        this.heldItemTooltips = true;
        this.chatScale = 1.0F;
        this.chatWidth = 1.0F;
        this.chatHeightUnfocused = OBFVAL_ZZBbi.get();
        this.chatHeightFocused = 1.0F;
        this.showInventoryAchievementHint = true;
        this.mipmapLevels = OBFVAL_Qyn8N.get();
        this.mapSoundLevels = Maps.newEnumMap(SoundCategory.class);
        this.streamBytesPerPixel = OBFVAL_k0IUs.get();
        this.streamMicVolume = 1.0F;
        this.streamGameVolume = 1.0F;
        this.streamKbps = OBFVAL_ZyvQA.get();
        this.streamFps = OBFVAL_xwhmC.get();
        this.streamCompression = 1;
        this.streamSendMetadata = true;
        this.streamPreferredServer = "";
        this.streamChatEnabled = 0;
        this.streamChatUserFilter = 0;
        this.streamMicToggleBehavior = 0;
        this.field_181150_U = true;
        this.field_181151_V = true;
        this.keyBindForward = new KeyBinding("key.forward", OBFVAL_gZjO1.get(), "key.categories.movement");
        this.keyBindLeft = new KeyBinding("key.left", OBFVAL_HsLub.get(), "key.categories.movement");
        this.keyBindBack = new KeyBinding("key.back", OBFVAL_A5IO2.get(), "key.categories.movement");
        this.keyBindRight = new KeyBinding("key.right", OBFVAL_K6hCW.get(), "key.categories.movement");
        this.keyBindJump = new KeyBinding("key.jump", OBFVAL_G4ok4.get(), "key.categories.movement");
        this.keyBindSneak = new KeyBinding("key.sneak", OBFVAL_2Dz3u.get(), "key.categories.movement");
        this.keyBindSprint = new KeyBinding("key.sprint", OBFVAL_JnlTQ.get(), "key.categories.movement");
        this.keyBindInventory = new KeyBinding("key.inventory", OBFVAL_nE2PN.get(), "key.categories.inventory");
        this.keyBindUseItem = new KeyBinding("key.use", OBFVAL_uKPuf.get(), "key.categories.gameplay");
        this.keyBindDrop = new KeyBinding("key.drop", OBFVAL_49oMU.get(), "key.categories.gameplay");
        this.keyBindAttack = new KeyBinding("key.attack", OBFVAL_tcTGe.get(), "key.categories.gameplay");
        this.keyBindPickBlock = new KeyBinding("key.pickItem", OBFVAL_R9fpX.get(), "key.categories.gameplay");
        this.keyBindChat = new KeyBinding("key.chat", OBFVAL_3YDHA.get(), "key.categories.multiplayer");
        this.keyBindPlayerList = new KeyBinding("key.playerlist", OBFVAL_Sv3mU.get(), "key.categories.multiplayer");
        this.keyBindCommand = new KeyBinding("key.command", OBFVAL_yUuuQ.get(), "key.categories.multiplayer");
        this.keyBindScreenshot = new KeyBinding("key.screenshot", OBFVAL_DkIkE.get(), "key.categories.misc");
        this.keyBindTogglePerspective = new KeyBinding("key.togglePerspective", OBFVAL_uoEmP.get(), "key.categories.misc");
        this.keyBindSmoothCamera = new KeyBinding("key.smoothCamera", 0, "key.categories.misc");
        this.keyBindFullscreen = new KeyBinding("key.fullscreen", OBFVAL_jsyyR.get(), "key.categories.misc");
        this.keyBindSpectatorOutlines = new KeyBinding("key.spectatorOutlines", 0, "key.categories.misc");
        this.keyBindStreamStartStop = new KeyBinding("key.streamStartStop", OBFVAL_qx2Gc.get(), "key.categories.stream");
        this.keyBindStreamPauseUnpause = new KeyBinding("key.streamPauseUnpause", OBFVAL_daUoz.get(), "key.categories.stream");
        this.keyBindStreamCommercials = new KeyBinding("key.streamCommercial", 0, "key.categories.stream");
        this.keyBindStreamToggleMic = new KeyBinding("key.streamToggleMic", 0, "key.categories.stream");
        KeyBinding[] akeybinding = new KeyBinding[OBFVAL_a7Nza.get()];
        akeybinding[0] = new KeyBinding("key.hotbar.1", OBFVAL_LrwhV.get(), "key.categories.inventory");
        akeybinding[1] = new KeyBinding("key.hotbar.2", OBFVAL_ycoNk.get(), "key.categories.inventory");
        akeybinding[OBFVAL_LrwhV.get()] = new KeyBinding("key.hotbar.3", OBFVAL_Qyn8N.get(), "key.categories.inventory");
        akeybinding[OBFVAL_ycoNk.get()] = new KeyBinding("key.hotbar.4", OBFVAL_rkM2H.get(), "key.categories.inventory");
        akeybinding[OBFVAL_Qyn8N.get()] = new KeyBinding("key.hotbar.5", OBFVAL_W8MAh.get(), "key.categories.inventory");
        akeybinding[OBFVAL_rkM2H.get()] = new KeyBinding("key.hotbar.6", OBFVAL_dSUah.get(), "key.categories.inventory");
        akeybinding[OBFVAL_W8MAh.get()] = new KeyBinding("key.hotbar.7", OBFVAL_Wesap.get(), "key.categories.inventory");
        akeybinding[OBFVAL_dSUah.get()] = new KeyBinding("key.hotbar.8", OBFVAL_a7Nza.get(), "key.categories.inventory");
        akeybinding[OBFVAL_Wesap.get()] = new KeyBinding("key.hotbar.9", OBFVAL_cPaTy.get(), "key.categories.inventory");
        this.keyBindsHotbar = akeybinding;
        this.ofFogType = 1;
        this.ofFogStart = OBFVAL_L0jh5.get();
        this.ofMipmapType = 0;
        this.ofOcclusionFancy = false;
        this.ofSmoothFps = false;
        this.ofSmoothWorld = Config.isSingleProcessor();
        this.ofLazyChunkLoading = Config.isSingleProcessor();
        this.ofAoLevel = 1.0F;
        this.ofAaLevel = 0;
        this.ofAfLevel = 1;
        this.ofClouds = 0;
        this.ofCloudsHeight = 0.0F;
        this.ofTrees = 0;
        this.ofRain = 0;
        this.ofDroppedItems = 0;
        this.ofBetterGrass = OBFVAL_ycoNk.get();
        this.ofAutoSaveTicks = OBFVAL_ZGOVI.get();
        this.ofLagometer = false;
        this.ofProfiler = false;
        this.ofShowFps = false;
        this.ofWeather = true;
        this.ofSky = true;
        this.ofStars = true;
        this.ofSunMoon = true;
        this.ofVignette = 0;
        this.ofChunkUpdates = 1;
        this.ofChunkUpdatesDynamic = false;
        this.ofTime = 0;
        this.ofClearWater = false;
        this.ofBetterSnow = false;
        this.ofFullscreenMode = "Default";
        this.ofSwampColors = true;
        this.ofRandomMobs = true;
        this.ofSmoothBiomes = true;
        this.ofCustomFonts = true;
        this.ofCustomColors = true;
        this.ofCustomSky = true;
        this.ofShowCapes = true;
        this.ofConnectedTextures = OBFVAL_LrwhV.get();
        this.ofCustomItems = true;
        this.ofNaturalTextures = false;
        this.ofFastMath = false;
        this.ofFastRender = true;
        this.ofTranslucentBlocks = 0;
        this.ofDynamicFov = true;
        this.ofDynamicLights = OBFVAL_ycoNk.get();
        this.ofAnimatedWater = 0;
        this.ofAnimatedLava = 0;
        this.ofAnimatedFire = true;
        this.ofAnimatedPortal = true;
        this.ofAnimatedRedstone = true;
        this.ofAnimatedExplosion = true;
        this.ofAnimatedFlame = true;
        this.ofAnimatedSmoke = true;
        this.ofVoidParticles = true;
        this.ofWaterParticles = true;
        this.ofRainSplash = true;
        this.ofPortalParticles = true;
        this.ofPotionParticles = true;
        this.ofFireworkParticles = true;
        this.ofDrippingWaterLava = true;
        this.ofAnimatedTerrain = true;
        this.ofAnimatedTextures = true;
        akeybinding = new KeyBinding[OBFVAL_DXAeR.get()];
        akeybinding[0] = this.keyBindAttack;
        akeybinding[1] = this.keyBindUseItem;
        akeybinding[OBFVAL_LrwhV.get()] = this.keyBindForward;
        akeybinding[OBFVAL_ycoNk.get()] = this.keyBindLeft;
        akeybinding[OBFVAL_Qyn8N.get()] = this.keyBindBack;
        akeybinding[OBFVAL_rkM2H.get()] = this.keyBindRight;
        akeybinding[OBFVAL_W8MAh.get()] = this.keyBindJump;
        akeybinding[OBFVAL_dSUah.get()] = this.keyBindSneak;
        akeybinding[OBFVAL_Wesap.get()] = this.keyBindSprint;
        akeybinding[OBFVAL_a7Nza.get()] = this.keyBindDrop;
        akeybinding[OBFVAL_cPaTy.get()] = this.keyBindInventory;
        akeybinding[OBFVAL_uhfoz.get()] = this.keyBindChat;
        akeybinding[OBFVAL_8tmgL.get()] = this.keyBindPlayerList;
        akeybinding[OBFVAL_45IKc.get()] = this.keyBindPickBlock;
        akeybinding[OBFVAL_pzNvu.get()] = this.keyBindCommand;
        akeybinding[OBFVAL_Sv3mU.get()] = this.keyBindScreenshot;
        akeybinding[OBFVAL_49oMU.get()] = this.keyBindTogglePerspective;
        akeybinding[OBFVAL_gZjO1.get()] = this.keyBindSmoothCamera;
        akeybinding[OBFVAL_nE2PN.get()] = this.keyBindStreamStartStop;
        akeybinding[OBFVAL_sIiuW.get()] = this.keyBindStreamPauseUnpause;
        akeybinding[OBFVAL_3YDHA.get()] = this.keyBindStreamCommercials;
        akeybinding[OBFVAL_xHKcu.get()] = this.keyBindStreamToggleMic;
        akeybinding[OBFVAL_qBjrJ.get()] = this.keyBindFullscreen;
        akeybinding[OBFVAL_nEYHR.get()] = this.keyBindSpectatorOutlines;
        this.keyBindings = (KeyBinding[])ArrayUtils.addAll(akeybinding, this.keyBindsHotbar);
        this.difficulty = EnumDifficulty.NORMAL;
        this.lastServer = "";
        this.fovSetting = OBFVAL_4Xfmz.get();
        this.language = "en_US";
        this.forceUnicodeFont = false;
        this.mc = mcIn;
        this.optionsFile = new File(p_i46326_2_, "options.txt");
        this.optionsFileOF = new File(p_i46326_2_, "optionsof.txt");
        this.limitFramerate = (int)GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
        this.ofKeyBindZoom = new KeyBinding("of.key.zoom", OBFVAL_0TXuY.get(), "key.categories.misc");
        this.keyBindings = (KeyBinding[])ArrayUtils.add(this.keyBindings, this.ofKeyBindZoom);
        this.keyBindings = CMDCamKeyHandler.hook(this.keyBindings);
        GameSettings.Options.RENDER_DISTANCE.setValueMax(OBFVAL_jMTdC.get());
        this.renderDistanceChunks = OBFVAL_Wesap.get();
        this.loadOptions();
        Config.initGameSettings(this);
    }

    public GameSettings()
    {
        this.mouseSensitivity = OBFVAL_k0IUs.get();
        this.renderDistanceChunks = -1;
        this.viewBobbing = true;
        this.fboEnable = true;
        this.limitFramerate = OBFVAL_LXDQI.get();
        this.clouds = OBFVAL_LrwhV.get();
        this.fancyGraphics = true;
        this.ambientOcclusion = OBFVAL_LrwhV.get();
        this.resourcePacks = Lists.<String>newArrayList();
        this.field_183018_l = Lists.<String>newArrayList();
        this.chatVisibility = EntityPlayer.EnumChatVisibility.FULL;
        this.chatColours = true;
        this.chatLinks = true;
        this.chatLinksPrompt = true;
        this.chatOpacity = 1.0F;
        this.snooperEnabled = true;
        this.enableVsync = true;
        this.useVbo = false;
        this.allowBlockAlternatives = true;
        this.reducedDebugInfo = false;
        this.pauseOnLostFocus = true;
        this.setModelParts = Sets.newHashSet(EnumPlayerModelParts.values());
        this.heldItemTooltips = true;
        this.chatScale = 1.0F;
        this.chatWidth = 1.0F;
        this.chatHeightUnfocused = OBFVAL_ZZBbi.get();
        this.chatHeightFocused = 1.0F;
        this.showInventoryAchievementHint = true;
        this.mipmapLevels = OBFVAL_Qyn8N.get();
        this.mapSoundLevels = Maps.newEnumMap(SoundCategory.class);
        this.streamBytesPerPixel = OBFVAL_k0IUs.get();
        this.streamMicVolume = 1.0F;
        this.streamGameVolume = 1.0F;
        this.streamKbps = OBFVAL_ZyvQA.get();
        this.streamFps = OBFVAL_xwhmC.get();
        this.streamCompression = 1;
        this.streamSendMetadata = true;
        this.streamPreferredServer = "";
        this.streamChatEnabled = 0;
        this.streamChatUserFilter = 0;
        this.streamMicToggleBehavior = 0;
        this.field_181150_U = true;
        this.field_181151_V = true;
        this.keyBindForward = new KeyBinding("key.forward", OBFVAL_gZjO1.get(), "key.categories.movement");
        this.keyBindLeft = new KeyBinding("key.left", OBFVAL_HsLub.get(), "key.categories.movement");
        this.keyBindBack = new KeyBinding("key.back", OBFVAL_A5IO2.get(), "key.categories.movement");
        this.keyBindRight = new KeyBinding("key.right", OBFVAL_K6hCW.get(), "key.categories.movement");
        this.keyBindJump = new KeyBinding("key.jump", OBFVAL_G4ok4.get(), "key.categories.movement");
        this.keyBindSneak = new KeyBinding("key.sneak", OBFVAL_2Dz3u.get(), "key.categories.movement");
        this.keyBindSprint = new KeyBinding("key.sprint", OBFVAL_JnlTQ.get(), "key.categories.movement");
        this.keyBindInventory = new KeyBinding("key.inventory", OBFVAL_nE2PN.get(), "key.categories.inventory");
        this.keyBindUseItem = new KeyBinding("key.use", OBFVAL_uKPuf.get(), "key.categories.gameplay");
        this.keyBindDrop = new KeyBinding("key.drop", OBFVAL_49oMU.get(), "key.categories.gameplay");
        this.keyBindAttack = new KeyBinding("key.attack", OBFVAL_tcTGe.get(), "key.categories.gameplay");
        this.keyBindPickBlock = new KeyBinding("key.pickItem", OBFVAL_R9fpX.get(), "key.categories.gameplay");
        this.keyBindChat = new KeyBinding("key.chat", OBFVAL_3YDHA.get(), "key.categories.multiplayer");
        this.keyBindPlayerList = new KeyBinding("key.playerlist", OBFVAL_Sv3mU.get(), "key.categories.multiplayer");
        this.keyBindCommand = new KeyBinding("key.command", OBFVAL_yUuuQ.get(), "key.categories.multiplayer");
        this.keyBindScreenshot = new KeyBinding("key.screenshot", OBFVAL_DkIkE.get(), "key.categories.misc");
        this.keyBindTogglePerspective = new KeyBinding("key.togglePerspective", OBFVAL_uoEmP.get(), "key.categories.misc");
        this.keyBindSmoothCamera = new KeyBinding("key.smoothCamera", 0, "key.categories.misc");
        this.keyBindFullscreen = new KeyBinding("key.fullscreen", OBFVAL_jsyyR.get(), "key.categories.misc");
        this.keyBindSpectatorOutlines = new KeyBinding("key.spectatorOutlines", 0, "key.categories.misc");
        this.keyBindStreamStartStop = new KeyBinding("key.streamStartStop", OBFVAL_qx2Gc.get(), "key.categories.stream");
        this.keyBindStreamPauseUnpause = new KeyBinding("key.streamPauseUnpause", OBFVAL_daUoz.get(), "key.categories.stream");
        this.keyBindStreamCommercials = new KeyBinding("key.streamCommercial", 0, "key.categories.stream");
        this.keyBindStreamToggleMic = new KeyBinding("key.streamToggleMic", 0, "key.categories.stream");
        KeyBinding[] akeybinding = new KeyBinding[OBFVAL_a7Nza.get()];
        akeybinding[0] = new KeyBinding("key.hotbar.1", OBFVAL_LrwhV.get(), "key.categories.inventory");
        akeybinding[1] = new KeyBinding("key.hotbar.2", OBFVAL_ycoNk.get(), "key.categories.inventory");
        akeybinding[OBFVAL_LrwhV.get()] = new KeyBinding("key.hotbar.3", OBFVAL_Qyn8N.get(), "key.categories.inventory");
        akeybinding[OBFVAL_ycoNk.get()] = new KeyBinding("key.hotbar.4", OBFVAL_rkM2H.get(), "key.categories.inventory");
        akeybinding[OBFVAL_Qyn8N.get()] = new KeyBinding("key.hotbar.5", OBFVAL_W8MAh.get(), "key.categories.inventory");
        akeybinding[OBFVAL_rkM2H.get()] = new KeyBinding("key.hotbar.6", OBFVAL_dSUah.get(), "key.categories.inventory");
        akeybinding[OBFVAL_W8MAh.get()] = new KeyBinding("key.hotbar.7", OBFVAL_Wesap.get(), "key.categories.inventory");
        akeybinding[OBFVAL_dSUah.get()] = new KeyBinding("key.hotbar.8", OBFVAL_a7Nza.get(), "key.categories.inventory");
        akeybinding[OBFVAL_Wesap.get()] = new KeyBinding("key.hotbar.9", OBFVAL_cPaTy.get(), "key.categories.inventory");
        this.keyBindsHotbar = akeybinding;
        this.ofFogType = 1;
        this.ofFogStart = OBFVAL_L0jh5.get();
        this.ofMipmapType = 0;
        this.ofOcclusionFancy = false;
        this.ofSmoothFps = false;
        this.ofSmoothWorld = Config.isSingleProcessor();
        this.ofLazyChunkLoading = Config.isSingleProcessor();
        this.ofAoLevel = 1.0F;
        this.ofAaLevel = 0;
        this.ofAfLevel = 1;
        this.ofClouds = 0;
        this.ofCloudsHeight = 0.0F;
        this.ofTrees = 0;
        this.ofRain = 0;
        this.ofDroppedItems = 0;
        this.ofBetterGrass = OBFVAL_ycoNk.get();
        this.ofAutoSaveTicks = OBFVAL_ZGOVI.get();
        this.ofLagometer = false;
        this.ofProfiler = false;
        this.ofShowFps = false;
        this.ofWeather = true;
        this.ofSky = true;
        this.ofStars = true;
        this.ofSunMoon = true;
        this.ofVignette = 0;
        this.ofChunkUpdates = 1;
        this.ofChunkUpdatesDynamic = false;
        this.ofTime = 0;
        this.ofClearWater = false;
        this.ofBetterSnow = false;
        this.ofFullscreenMode = "Default";
        this.ofSwampColors = true;
        this.ofRandomMobs = true;
        this.ofSmoothBiomes = true;
        this.ofCustomFonts = true;
        this.ofCustomColors = true;
        this.ofCustomSky = true;
        this.ofShowCapes = true;
        this.ofConnectedTextures = OBFVAL_LrwhV.get();
        this.ofCustomItems = true;
        this.ofNaturalTextures = false;
        this.ofFastMath = false;
        this.ofFastRender = true;
        this.ofTranslucentBlocks = 0;
        this.ofDynamicFov = true;
        this.ofDynamicLights = OBFVAL_ycoNk.get();
        this.ofAnimatedWater = 0;
        this.ofAnimatedLava = 0;
        this.ofAnimatedFire = true;
        this.ofAnimatedPortal = true;
        this.ofAnimatedRedstone = true;
        this.ofAnimatedExplosion = true;
        this.ofAnimatedFlame = true;
        this.ofAnimatedSmoke = true;
        this.ofVoidParticles = true;
        this.ofWaterParticles = true;
        this.ofRainSplash = true;
        this.ofPortalParticles = true;
        this.ofPotionParticles = true;
        this.ofFireworkParticles = true;
        this.ofDrippingWaterLava = true;
        this.ofAnimatedTerrain = true;
        this.ofAnimatedTextures = true;
        akeybinding = new KeyBinding[OBFVAL_DXAeR.get()];
        akeybinding[0] = this.keyBindAttack;
        akeybinding[1] = this.keyBindUseItem;
        akeybinding[OBFVAL_LrwhV.get()] = this.keyBindForward;
        akeybinding[OBFVAL_ycoNk.get()] = this.keyBindLeft;
        akeybinding[OBFVAL_Qyn8N.get()] = this.keyBindBack;
        akeybinding[OBFVAL_rkM2H.get()] = this.keyBindRight;
        akeybinding[OBFVAL_W8MAh.get()] = this.keyBindJump;
        akeybinding[OBFVAL_dSUah.get()] = this.keyBindSneak;
        akeybinding[OBFVAL_Wesap.get()] = this.keyBindSprint;
        akeybinding[OBFVAL_a7Nza.get()] = this.keyBindDrop;
        akeybinding[OBFVAL_cPaTy.get()] = this.keyBindInventory;
        akeybinding[OBFVAL_uhfoz.get()] = this.keyBindChat;
        akeybinding[OBFVAL_8tmgL.get()] = this.keyBindPlayerList;
        akeybinding[OBFVAL_45IKc.get()] = this.keyBindPickBlock;
        akeybinding[OBFVAL_pzNvu.get()] = this.keyBindCommand;
        akeybinding[OBFVAL_Sv3mU.get()] = this.keyBindScreenshot;
        akeybinding[OBFVAL_49oMU.get()] = this.keyBindTogglePerspective;
        akeybinding[OBFVAL_gZjO1.get()] = this.keyBindSmoothCamera;
        akeybinding[OBFVAL_nE2PN.get()] = this.keyBindStreamStartStop;
        akeybinding[OBFVAL_sIiuW.get()] = this.keyBindStreamPauseUnpause;
        akeybinding[OBFVAL_3YDHA.get()] = this.keyBindStreamCommercials;
        akeybinding[OBFVAL_xHKcu.get()] = this.keyBindStreamToggleMic;
        akeybinding[OBFVAL_qBjrJ.get()] = this.keyBindFullscreen;
        akeybinding[OBFVAL_nEYHR.get()] = this.keyBindSpectatorOutlines;
        this.keyBindings = (KeyBinding[])ArrayUtils.addAll(akeybinding, this.keyBindsHotbar);
        this.difficulty = EnumDifficulty.NORMAL;
        this.lastServer = "";
        this.fovSetting = OBFVAL_4Xfmz.get();
        this.language = "en_US";
        this.forceUnicodeFont = false;
    }

    /**
     * Represents a key or mouse button as a string. Args: key
     */
    public static String getKeyDisplayString(int p_74298_0_)
    {
        return p_74298_0_ < 0 ? I18n.format("key.mouseButton", new Object[] {Integer.valueOf(p_74298_0_ + OBFVAL_e3WYb.get())}): (p_74298_0_ < OBFVAL_uuSba.get() ? Keyboard.getKeyName(p_74298_0_) : String.format("%c", new Object[] {Character.valueOf((char)(p_74298_0_ - OBFVAL_uuSba.get()))}).toUpperCase());
    }

    /**
     * Returns whether the specified key binding is currently being pressed.
     */
    public static boolean isKeyDown(KeyBinding p_100015_0_)
    {
        int i = p_100015_0_.getKeyCode();
        return i >= OBFVAL_tcTGe.get() && i <= OBFVAL_yHsKT.get() ? (p_100015_0_.getKeyCode() == 0 ? false : (p_100015_0_.getKeyCode() < 0 ? Mouse.isButtonDown(p_100015_0_.getKeyCode() + OBFVAL_WJyFb.get()) : Keyboard.isKeyDown(p_100015_0_.getKeyCode()))) : false;
    }

    /**
     * Sets a key binding and then saves all settings.
     */
    public void setOptionKeyBinding(KeyBinding p_151440_1_, int p_151440_2_)
    {
        p_151440_1_.setKeyCode(p_151440_2_);
        this.saveOptions();
    }

    /**
     * If the specified option is controlled by a slider (float value), this will set the float value.
     */
    public void setOptionFloatValue(GameSettings.Options p_74304_1_, float p_74304_2_)
    {
        this.setOptionFloatValueOF(p_74304_1_, p_74304_2_);

        if (p_74304_1_ == GameSettings.Options.SENSITIVITY)
        {
            this.mouseSensitivity = p_74304_2_;
        }

        if (p_74304_1_ == GameSettings.Options.FOV)
        {
            this.fovSetting = p_74304_2_;
        }

        if (p_74304_1_ == GameSettings.Options.GAMMA)
        {
            this.gammaSetting = p_74304_2_;
        }

        if (p_74304_1_ == GameSettings.Options.FRAMERATE_LIMIT)
        {
            this.limitFramerate = (int)p_74304_2_;
            this.enableVsync = false;

            if (this.limitFramerate <= 0)
            {
                this.limitFramerate = (int)GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
                this.enableVsync = true;
            }

            this.updateVSync();
        }

        if (p_74304_1_ == GameSettings.Options.CHAT_OPACITY)
        {
            this.chatOpacity = p_74304_2_;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }

        if (p_74304_1_ == GameSettings.Options.CHAT_HEIGHT_FOCUSED)
        {
            this.chatHeightFocused = p_74304_2_;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }

        if (p_74304_1_ == GameSettings.Options.CHAT_HEIGHT_UNFOCUSED)
        {
            this.chatHeightUnfocused = p_74304_2_;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }

        if (p_74304_1_ == GameSettings.Options.CHAT_WIDTH)
        {
            this.chatWidth = p_74304_2_;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }

        if (p_74304_1_ == GameSettings.Options.CHAT_SCALE)
        {
            this.chatScale = p_74304_2_;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }

        if (p_74304_1_ == GameSettings.Options.MIPMAP_LEVELS)
        {
            int i = this.mipmapLevels;
            this.mipmapLevels = (int)p_74304_2_;

            if ((float)i != p_74304_2_)
            {
                this.mc.getTextureMapBlocks().setMipmapLevels(this.mipmapLevels);
                this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
                this.mc.getTextureMapBlocks().setBlurMipmapDirect(false, this.mipmapLevels > 0);
                this.mc.scheduleResourcesRefresh();
            }
        }

        if (p_74304_1_ == GameSettings.Options.BLOCK_ALTERNATIVES)
        {
            this.allowBlockAlternatives = !this.allowBlockAlternatives;
            this.mc.renderGlobal.loadRenderers();
        }

        if (p_74304_1_ == GameSettings.Options.RENDER_DISTANCE)
        {
            this.renderDistanceChunks = (int)p_74304_2_;
            this.mc.renderGlobal.setDisplayListEntitiesDirty();
        }

        if (p_74304_1_ == GameSettings.Options.STREAM_BYTES_PER_PIXEL)
        {
            this.streamBytesPerPixel = p_74304_2_;
        }

        if (p_74304_1_ == GameSettings.Options.STREAM_VOLUME_MIC)
        {
            this.streamMicVolume = p_74304_2_;
            this.mc.getTwitchStream().updateStreamVolume();
        }

        if (p_74304_1_ == GameSettings.Options.STREAM_VOLUME_SYSTEM)
        {
            this.streamGameVolume = p_74304_2_;
            this.mc.getTwitchStream().updateStreamVolume();
        }

        if (p_74304_1_ == GameSettings.Options.STREAM_KBPS)
        {
            this.streamKbps = p_74304_2_;
        }

        if (p_74304_1_ == GameSettings.Options.STREAM_FPS)
        {
            this.streamFps = p_74304_2_;
        }
    }

    /**
     * For non-float options. Toggles the option on/off, or cycles through the list i.e. render distances.
     */
    public void setOptionValue(GameSettings.Options p_74306_1_, int p_74306_2_)
    {
        this.setOptionValueOF(p_74306_1_, p_74306_2_);

        if (p_74306_1_ == GameSettings.Options.INVERT_MOUSE)
        {
            this.invertMouse = !this.invertMouse;
        }

        if (p_74306_1_ == GameSettings.Options.GUI_SCALE)
        {
            this.guiScale = this.guiScale + p_74306_2_ & OBFVAL_ycoNk.get();
        }

        if (p_74306_1_ == GameSettings.Options.PARTICLES)
        {
            this.particleSetting = (this.particleSetting + p_74306_2_) % OBFVAL_ycoNk.get();
        }

        if (p_74306_1_ == GameSettings.Options.VIEW_BOBBING)
        {
            this.viewBobbing = !this.viewBobbing;
        }

        if (p_74306_1_ == GameSettings.Options.RENDER_CLOUDS)
        {
            this.clouds = (this.clouds + p_74306_2_) % OBFVAL_ycoNk.get();
        }

        if (p_74306_1_ == GameSettings.Options.FORCE_UNICODE_FONT)
        {
            this.forceUnicodeFont = !this.forceUnicodeFont;
            this.mc.fontRendererObj.setUnicodeFlag(this.mc.getLanguageManager().isCurrentLocaleUnicode() || this.forceUnicodeFont);
        }

        if (p_74306_1_ == GameSettings.Options.FBO_ENABLE)
        {
            this.fboEnable = !this.fboEnable;
        }

        if (p_74306_1_ == GameSettings.Options.ANAGLYPH)
        {
            if (!this.anaglyph && Config.isShaders())
            {
                Config.showGuiMessage(Lang.get("of.message.an.shaders1"), Lang.get("of.message.an.shaders2"));
                return;
            }

            this.anaglyph = !this.anaglyph;
            this.mc.refreshResources();
        }

        if (p_74306_1_ == GameSettings.Options.GRAPHICS)
        {
            this.fancyGraphics = !this.fancyGraphics;
            this.updateRenderClouds();
            this.mc.renderGlobal.loadRenderers();
        }

        if (p_74306_1_ == GameSettings.Options.AMBIENT_OCCLUSION)
        {
            this.ambientOcclusion = (this.ambientOcclusion + p_74306_2_) % OBFVAL_ycoNk.get();
            this.mc.renderGlobal.loadRenderers();
        }

        if (p_74306_1_ == GameSettings.Options.CHAT_VISIBILITY)
        {
            this.chatVisibility = EntityPlayer.EnumChatVisibility.getEnumChatVisibility((this.chatVisibility.getChatVisibility() + p_74306_2_) % OBFVAL_ycoNk.get());
        }

        if (p_74306_1_ == GameSettings.Options.STREAM_COMPRESSION)
        {
            this.streamCompression = (this.streamCompression + p_74306_2_) % OBFVAL_ycoNk.get();
        }

        if (p_74306_1_ == GameSettings.Options.STREAM_SEND_METADATA)
        {
            this.streamSendMetadata = !this.streamSendMetadata;
        }

        if (p_74306_1_ == GameSettings.Options.STREAM_CHAT_ENABLED)
        {
            this.streamChatEnabled = (this.streamChatEnabled + p_74306_2_) % OBFVAL_ycoNk.get();
        }

        if (p_74306_1_ == GameSettings.Options.STREAM_CHAT_USER_FILTER)
        {
            this.streamChatUserFilter = (this.streamChatUserFilter + p_74306_2_) % OBFVAL_ycoNk.get();
        }

        if (p_74306_1_ == GameSettings.Options.STREAM_MIC_TOGGLE_BEHAVIOR)
        {
            this.streamMicToggleBehavior = (this.streamMicToggleBehavior + p_74306_2_) % OBFVAL_LrwhV.get();
        }

        if (p_74306_1_ == GameSettings.Options.CHAT_COLOR)
        {
            this.chatColours = !this.chatColours;
        }

        if (p_74306_1_ == GameSettings.Options.CHAT_LINKS)
        {
            this.chatLinks = !this.chatLinks;
        }

        if (p_74306_1_ == GameSettings.Options.CHAT_LINKS_PROMPT)
        {
            this.chatLinksPrompt = !this.chatLinksPrompt;
        }

        if (p_74306_1_ == GameSettings.Options.SNOOPER_ENABLED)
        {
            this.snooperEnabled = !this.snooperEnabled;
        }

        if (p_74306_1_ == GameSettings.Options.TOUCHSCREEN)
        {
            this.touchscreen = !this.touchscreen;
        }

        if (p_74306_1_ == GameSettings.Options.USE_FULLSCREEN)
        {
            this.fullScreen = !this.fullScreen;

            if (this.mc.isFullScreen() != this.fullScreen)
            {
                this.mc.toggleFullscreen();
            }
        }

        if (p_74306_1_ == GameSettings.Options.ENABLE_VSYNC)
        {
            this.enableVsync = !this.enableVsync;
            Display.setVSyncEnabled(this.enableVsync);
        }

        if (p_74306_1_ == GameSettings.Options.USE_VBO)
        {
            this.useVbo = !this.useVbo;
            this.mc.renderGlobal.loadRenderers();
        }

        if (p_74306_1_ == GameSettings.Options.BLOCK_ALTERNATIVES)
        {
            this.allowBlockAlternatives = !this.allowBlockAlternatives;
            this.mc.renderGlobal.loadRenderers();
        }

        if (p_74306_1_ == GameSettings.Options.REDUCED_DEBUG_INFO)
        {
            this.reducedDebugInfo = !this.reducedDebugInfo;
        }

        if (p_74306_1_ == GameSettings.Options.ENTITY_SHADOWS)
        {
            this.field_181151_V = !this.field_181151_V;
        }

        this.saveOptions();
    }

    public float getOptionFloatValue(GameSettings.Options p_74296_1_)
    {
        return p_74296_1_ == GameSettings.Options.CLOUD_HEIGHT ? this.ofCloudsHeight : (p_74296_1_ == GameSettings.Options.AO_LEVEL ? this.ofAoLevel : (p_74296_1_ == GameSettings.Options.AA_LEVEL ? (float)this.ofAaLevel : (p_74296_1_ == GameSettings.Options.AF_LEVEL ? (float)this.ofAfLevel : (p_74296_1_ == GameSettings.Options.MIPMAP_TYPE ? (float)this.ofMipmapType : (p_74296_1_ == GameSettings.Options.FRAMERATE_LIMIT ? ((float)this.limitFramerate == GameSettings.Options.FRAMERATE_LIMIT.getValueMax() && this.enableVsync ? 0.0F : (float)this.limitFramerate) : (p_74296_1_ == GameSettings.Options.FOV ? this.fovSetting : (p_74296_1_ == GameSettings.Options.GAMMA ? this.gammaSetting : (p_74296_1_ == GameSettings.Options.SATURATION ? this.saturation : (p_74296_1_ == GameSettings.Options.SENSITIVITY ? this.mouseSensitivity : (p_74296_1_ == GameSettings.Options.CHAT_OPACITY ? this.chatOpacity : (p_74296_1_ == GameSettings.Options.CHAT_HEIGHT_FOCUSED ? this.chatHeightFocused : (p_74296_1_ == GameSettings.Options.CHAT_HEIGHT_UNFOCUSED ? this.chatHeightUnfocused : (p_74296_1_ == GameSettings.Options.CHAT_SCALE ? this.chatScale : (p_74296_1_ == GameSettings.Options.CHAT_WIDTH ? this.chatWidth : (p_74296_1_ == GameSettings.Options.FRAMERATE_LIMIT ? (float)this.limitFramerate : (p_74296_1_ == GameSettings.Options.MIPMAP_LEVELS ? (float)this.mipmapLevels : (p_74296_1_ == GameSettings.Options.RENDER_DISTANCE ? (float)this.renderDistanceChunks : (p_74296_1_ == GameSettings.Options.STREAM_BYTES_PER_PIXEL ? this.streamBytesPerPixel : (p_74296_1_ == GameSettings.Options.STREAM_VOLUME_MIC ? this.streamMicVolume : (p_74296_1_ == GameSettings.Options.STREAM_VOLUME_SYSTEM ? this.streamGameVolume : (p_74296_1_ == GameSettings.Options.STREAM_KBPS ? this.streamKbps : (p_74296_1_ == GameSettings.Options.STREAM_FPS ? this.streamFps : 0.0F))))))))))))))))))))));
    }

    public boolean getOptionOrdinalValue(GameSettings.Options p_74308_1_)
    {
        switch (GameSettings.GameSettings$GameSettings$2.field_151477_a[p_74308_1_.ordinal()])
        {
            case 1:
                return this.invertMouse;

            case 2:
                return this.viewBobbing;

            case 3:
                return this.anaglyph;

            case 4:
                return this.fboEnable;

            case 5:
                return this.chatColours;

            case 6:
                return this.chatLinks;

            case 7:
                return this.chatLinksPrompt;

            case 8:
                return this.snooperEnabled;

            case 9:
                return this.fullScreen;

            case 10:
                return this.enableVsync;

            case 11:
                return this.useVbo;

            case 12:
                return this.touchscreen;

            case 13:
                return this.streamSendMetadata;

            case 14:
                return this.forceUnicodeFont;

            case 15:
                return this.allowBlockAlternatives;

            case 16:
                return this.reducedDebugInfo;

            case 17:
                return this.field_181151_V;

            default:
                return false;
        }
    }

    /**
     * Returns the translation of the given index in the given String array. If the index is smaller than 0 or greater
     * than/equal to the length of the String array, it is changed to 0.
     */
    private static String getTranslation(String[] p_74299_0_, int p_74299_1_)
    {
        if (p_74299_1_ < 0 || p_74299_1_ >= p_74299_0_.length)
        {
            p_74299_1_ = 0;
        }

        return I18n.format(p_74299_0_[p_74299_1_], new Object[0]);
    }

    /**
     * Gets a key binding.
     */
    public String getKeyBinding(GameSettings.Options p_74297_1_)
    {
        String s = this.getKeyBindingOF(p_74297_1_);

        if (s != null)
        {
            return s;
        }
        else
        {
            String s1 = I18n.format(p_74297_1_.getEnumString(), new Object[0]) + ": ";

            if (p_74297_1_.getEnumFloat())
            {
                float f1 = this.getOptionFloatValue(p_74297_1_);
                float f = p_74297_1_.normalizeValue(f1);
                return p_74297_1_ == GameSettings.Options.SENSITIVITY ? (f == 0.0F ? s1 + I18n.format("options.sensitivity.min", new Object[0]) : (f == 1.0F ? s1 + I18n.format("options.sensitivity.max", new Object[0]) : s1 + (int)(f * OBFVAL_81iPD.get()) + "%")) : (p_74297_1_ == GameSettings.Options.FOV ? (f1 == OBFVAL_4Xfmz.get() ? s1 + I18n.format("options.fov.min", new Object[0]) : (f1 == OBFVAL_H6XKu.get() ? s1 + I18n.format("options.fov.max", new Object[0]) : s1 + (int)f1)) : (p_74297_1_ == GameSettings.Options.FRAMERATE_LIMIT ? (f1 == p_74297_1_.valueMax ? s1 + I18n.format("options.framerateLimit.max", new Object[0]) : s1 + (int)f1 + " fps") : (p_74297_1_ == GameSettings.Options.RENDER_CLOUDS ? (f1 == p_74297_1_.valueMin ? s1 + I18n.format("options.cloudHeight.min", new Object[0]) : s1 + ((int)f1 + OBFVAL_aiwjg.get())) : (p_74297_1_ == GameSettings.Options.GAMMA ? (f == 0.0F ? s1 + I18n.format("options.gamma.min", new Object[0]) : (f == 1.0F ? s1 + I18n.format("options.gamma.max", new Object[0]) : s1 + "+" + (int)(f * OBFVAL_GO5Oo.get()) + "%")) : (p_74297_1_ == GameSettings.Options.SATURATION ? s1 + (int)(f * OBFVAL_sqMCa.get()) + "%" : (p_74297_1_ == GameSettings.Options.CHAT_OPACITY ? s1 + (int)(f * OBFVAL_QQigx.get() + OBFVAL_t9f7h.get()) + "%" : (p_74297_1_ == GameSettings.Options.CHAT_HEIGHT_UNFOCUSED ? s1 + GuiNewChat.calculateChatboxHeight(f) + "px" : (p_74297_1_ == GameSettings.Options.CHAT_HEIGHT_FOCUSED ? s1 + GuiNewChat.calculateChatboxHeight(f) + "px" : (p_74297_1_ == GameSettings.Options.CHAT_WIDTH ? s1 + GuiNewChat.calculateChatboxWidth(f) + "px" : (p_74297_1_ == GameSettings.Options.RENDER_DISTANCE ? s1 + (int)f1 + " chunks" : (p_74297_1_ == GameSettings.Options.MIPMAP_LEVELS ? (f1 == 0.0F ? s1 + I18n.format("options.off", new Object[0]) : s1 + (int)f1) : (p_74297_1_ == GameSettings.Options.STREAM_FPS ? s1 + TwitchStream.formatStreamFps(f) + " fps" : (p_74297_1_ == GameSettings.Options.STREAM_KBPS ? s1 + TwitchStream.formatStreamKbps(f) + " Kbps" : (p_74297_1_ == GameSettings.Options.STREAM_BYTES_PER_PIXEL ? s1 + String.format("%.3f bpp", new Object[] {Float.valueOf(TwitchStream.formatStreamBps(f))}): (f == 0.0F ? s1 + I18n.format("options.off", new Object[0]) : s1 + (int)(f * OBFVAL_GO5Oo.get()) + "%")))))))))))))));
            }
            else if (p_74297_1_.getEnumBoolean())
            {
                boolean flag = this.getOptionOrdinalValue(p_74297_1_);
                return flag ? s1 + I18n.format("options.on", new Object[0]) : s1 + I18n.format("options.off", new Object[0]);
            }
            else if (p_74297_1_ == GameSettings.Options.GUI_SCALE)
            {
                return s1 + getTranslation(GUISCALES, this.guiScale);
            }
            else if (p_74297_1_ == GameSettings.Options.CHAT_VISIBILITY)
            {
                return s1 + I18n.format(this.chatVisibility.getResourceKey(), new Object[0]);
            }
            else if (p_74297_1_ == GameSettings.Options.PARTICLES)
            {
                return s1 + getTranslation(PARTICLES, this.particleSetting);
            }
            else if (p_74297_1_ == GameSettings.Options.AMBIENT_OCCLUSION)
            {
                return s1 + getTranslation(AMBIENT_OCCLUSIONS, this.ambientOcclusion);
            }
            else if (p_74297_1_ == GameSettings.Options.STREAM_COMPRESSION)
            {
                return s1 + getTranslation(STREAM_COMPRESSIONS, this.streamCompression);
            }
            else if (p_74297_1_ == GameSettings.Options.STREAM_CHAT_ENABLED)
            {
                return s1 + getTranslation(STREAM_CHAT_MODES, this.streamChatEnabled);
            }
            else if (p_74297_1_ == GameSettings.Options.STREAM_CHAT_USER_FILTER)
            {
                return s1 + getTranslation(STREAM_CHAT_FILTER_MODES, this.streamChatUserFilter);
            }
            else if (p_74297_1_ == GameSettings.Options.STREAM_MIC_TOGGLE_BEHAVIOR)
            {
                return s1 + getTranslation(STREAM_MIC_MODES, this.streamMicToggleBehavior);
            }
            else if (p_74297_1_ == GameSettings.Options.RENDER_CLOUDS)
            {
                return s1 + getTranslation(field_181149_aW, this.clouds);
            }
            else if (p_74297_1_ == GameSettings.Options.GRAPHICS)
            {
                if (this.fancyGraphics)
                {
                    return s1 + I18n.format("options.graphics.fancy", new Object[0]);
                }
                else
                {
                    String s2 = "options.graphics.fast";
                    return s1 + I18n.format("options.graphics.fast", new Object[0]);
                }
            }
            else
            {
                return s1;
            }
        }
    }

    /**
     * Loads the options from the options file. It appears that this has replaced the previous 'loadOptions'
     */
    public void loadOptions()
    {
        try
        {
            if (!this.optionsFile.exists())
            {
                return;
            }

            BufferedReader bufferedreader = new BufferedReader(new FileReader(this.optionsFile));
            String s = "";
            this.mapSoundLevels.clear();

            while ((s = bufferedreader.readLine()) != null)
            {
                try
                {
                    String[] astring = s.split(":");

                    if (astring[0].equals("mouseSensitivity"))
                    {
                        this.mouseSensitivity = this.parseFloat(astring[1]);
                    }

                    if (astring[0].equals("fov"))
                    {
                        this.fovSetting = this.parseFloat(astring[1]) * OBFVAL_5pPS8.get() + OBFVAL_4Xfmz.get();
                    }

                    if (astring[0].equals("gamma"))
                    {
                        this.gammaSetting = this.parseFloat(astring[1]);
                    }

                    if (astring[0].equals("saturation"))
                    {
                        this.saturation = this.parseFloat(astring[1]);
                    }

                    if (astring[0].equals("invertYMouse"))
                    {
                        this.invertMouse = astring[1].equals("true");
                    }

                    if (astring[0].equals("renderDistance"))
                    {
                        this.renderDistanceChunks = Integer.parseInt(astring[1]);
                    }

                    if (astring[0].equals("guiScale"))
                    {
                        this.guiScale = Integer.parseInt(astring[1]);
                    }

                    if (astring[0].equals("particles"))
                    {
                        this.particleSetting = Integer.parseInt(astring[1]);
                    }

                    if (astring[0].equals("bobView"))
                    {
                        this.viewBobbing = astring[1].equals("true");
                    }

                    if (astring[0].equals("anaglyph3d"))
                    {
                        this.anaglyph = astring[1].equals("true");
                    }

                    if (astring[0].equals("maxFps"))
                    {
                        this.limitFramerate = Integer.parseInt(astring[1]);
                        this.enableVsync = false;

                        if (this.limitFramerate <= 0)
                        {
                            this.limitFramerate = (int)GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
                            this.enableVsync = true;
                        }

                        this.updateVSync();
                    }

                    if (astring[0].equals("fboEnable"))
                    {
                        this.fboEnable = astring[1].equals("true");
                    }

                    if (astring[0].equals("difficulty"))
                    {
                        this.difficulty = EnumDifficulty.getDifficultyEnum(Integer.parseInt(astring[1]));
                    }

                    if (astring[0].equals("fancyGraphics"))
                    {
                        this.fancyGraphics = astring[1].equals("true");
                        this.updateRenderClouds();
                    }

                    if (astring[0].equals("ao"))
                    {
                        if (astring[1].equals("true"))
                        {
                            this.ambientOcclusion = OBFVAL_LrwhV.get();
                        }
                        else if (astring[1].equals("false"))
                        {
                            this.ambientOcclusion = 0;
                        }
                        else
                        {
                            this.ambientOcclusion = Integer.parseInt(astring[1]);
                        }
                    }

                    if (astring[0].equals("renderClouds"))
                    {
                        if (astring[1].equals("true"))
                        {
                            this.clouds = OBFVAL_LrwhV.get();
                        }
                        else if (astring[1].equals("false"))
                        {
                            this.clouds = 0;
                        }
                        else if (astring[1].equals("fast"))
                        {
                            this.clouds = 1;
                        }
                    }

                    if (astring[0].equals("resourcePacks"))
                    {
                        this.resourcePacks = (List)gson.fromJson((String)s.substring(s.indexOf(OBFVAL_8qc8d.get()) + 1), typeListString);

                        if (this.resourcePacks == null)
                        {
                            this.resourcePacks = Lists.<String>newArrayList();
                        }
                    }

                    if (astring[0].equals("incompatibleResourcePacks"))
                    {
                        this.field_183018_l = (List)gson.fromJson((String)s.substring(s.indexOf(OBFVAL_8qc8d.get()) + 1), typeListString);

                        if (this.field_183018_l == null)
                        {
                            this.field_183018_l = Lists.<String>newArrayList();
                        }
                    }

                    if (astring[0].equals("lastServer") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.lastServer = s.substring(s.indexOf(OBFVAL_8qc8d.get()) + 1);
                    }

                    if (astring[0].equals("lang") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.language = astring[1];
                    }

                    if (astring[0].equals("chatVisibility"))
                    {
                        this.chatVisibility = EntityPlayer.EnumChatVisibility.getEnumChatVisibility(Integer.parseInt(astring[1]));
                    }

                    if (astring[0].equals("chatColors"))
                    {
                        this.chatColours = astring[1].equals("true");
                    }

                    if (astring[0].equals("chatLinks"))
                    {
                        this.chatLinks = astring[1].equals("true");
                    }

                    if (astring[0].equals("chatLinksPrompt"))
                    {
                        this.chatLinksPrompt = astring[1].equals("true");
                    }

                    if (astring[0].equals("chatOpacity"))
                    {
                        this.chatOpacity = this.parseFloat(astring[1]);
                    }

                    if (astring[0].equals("snooperEnabled"))
                    {
                        this.snooperEnabled = astring[1].equals("true");
                    }

                    if (astring[0].equals("fullscreen"))
                    {
                        this.fullScreen = astring[1].equals("true");
                    }

                    if (astring[0].equals("enableVsync"))
                    {
                        this.enableVsync = astring[1].equals("true");
                        this.updateVSync();
                    }

                    if (astring[0].equals("useVbo"))
                    {
                        this.useVbo = astring[1].equals("true");
                    }

                    if (astring[0].equals("hideServerAddress"))
                    {
                        this.hideServerAddress = astring[1].equals("true");
                    }

                    if (astring[0].equals("advancedItemTooltips"))
                    {
                        this.advancedItemTooltips = astring[1].equals("true");
                    }

                    if (astring[0].equals("pauseOnLostFocus"))
                    {
                        this.pauseOnLostFocus = astring[1].equals("true");
                    }

                    if (astring[0].equals("touchscreen"))
                    {
                        this.touchscreen = astring[1].equals("true");
                    }

                    if (astring[0].equals("overrideHeight"))
                    {
                        this.overrideHeight = Integer.parseInt(astring[1]);
                    }

                    if (astring[0].equals("overrideWidth"))
                    {
                        this.overrideWidth = Integer.parseInt(astring[1]);
                    }

                    if (astring[0].equals("heldItemTooltips"))
                    {
                        this.heldItemTooltips = astring[1].equals("true");
                    }

                    if (astring[0].equals("chatHeightFocused"))
                    {
                        this.chatHeightFocused = this.parseFloat(astring[1]);
                    }

                    if (astring[0].equals("chatHeightUnfocused"))
                    {
                        this.chatHeightUnfocused = this.parseFloat(astring[1]);
                    }

                    if (astring[0].equals("chatScale"))
                    {
                        this.chatScale = this.parseFloat(astring[1]);
                    }

                    if (astring[0].equals("chatWidth"))
                    {
                        this.chatWidth = this.parseFloat(astring[1]);
                    }

                    if (astring[0].equals("showInventoryAchievementHint"))
                    {
                        this.showInventoryAchievementHint = astring[1].equals("true");
                    }

                    if (astring[0].equals("mipmapLevels"))
                    {
                        this.mipmapLevels = Integer.parseInt(astring[1]);
                    }

                    if (astring[0].equals("streamBytesPerPixel"))
                    {
                        this.streamBytesPerPixel = this.parseFloat(astring[1]);
                    }

                    if (astring[0].equals("streamMicVolume"))
                    {
                        this.streamMicVolume = this.parseFloat(astring[1]);
                    }

                    if (astring[0].equals("streamSystemVolume"))
                    {
                        this.streamGameVolume = this.parseFloat(astring[1]);
                    }

                    if (astring[0].equals("streamKbps"))
                    {
                        this.streamKbps = this.parseFloat(astring[1]);
                    }

                    if (astring[0].equals("streamFps"))
                    {
                        this.streamFps = this.parseFloat(astring[1]);
                    }

                    if (astring[0].equals("streamCompression"))
                    {
                        this.streamCompression = Integer.parseInt(astring[1]);
                    }

                    if (astring[0].equals("streamSendMetadata"))
                    {
                        this.streamSendMetadata = astring[1].equals("true");
                    }

                    if (astring[0].equals("streamPreferredServer") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.streamPreferredServer = s.substring(s.indexOf(OBFVAL_8qc8d.get()) + 1);
                    }

                    if (astring[0].equals("streamChatEnabled"))
                    {
                        this.streamChatEnabled = Integer.parseInt(astring[1]);
                    }

                    if (astring[0].equals("streamChatUserFilter"))
                    {
                        this.streamChatUserFilter = Integer.parseInt(astring[1]);
                    }

                    if (astring[0].equals("streamMicToggleBehavior"))
                    {
                        this.streamMicToggleBehavior = Integer.parseInt(astring[1]);
                    }

                    if (astring[0].equals("forceUnicodeFont"))
                    {
                        this.forceUnicodeFont = astring[1].equals("true");
                    }

                    if (astring[0].equals("allowBlockAlternatives"))
                    {
                        this.allowBlockAlternatives = astring[1].equals("true");
                    }

                    if (astring[0].equals("reducedDebugInfo"))
                    {
                        this.reducedDebugInfo = astring[1].equals("true");
                    }

                    if (astring[0].equals("useNativeTransport"))
                    {
                        this.field_181150_U = astring[1].equals("true");
                    }

                    if (astring[0].equals("entityShadows"))
                    {
                        this.field_181151_V = astring[1].equals("true");
                    }

                    for (KeyBinding keybinding : this.keyBindings)
                    {
                        if (astring[0].equals("key_" + keybinding.getKeyDescription()))
                        {
                            keybinding.setKeyCode(Integer.parseInt(astring[1]));
                        }
                    }

                    for (SoundCategory soundcategory : SoundCategory.values())
                    {
                        if (astring[0].equals("soundCategory_" + soundcategory.getCategoryName()))
                        {
                            this.mapSoundLevels.put(soundcategory, Float.valueOf(this.parseFloat(astring[1])));
                        }
                    }

                    for (EnumPlayerModelParts enumplayermodelparts : EnumPlayerModelParts.values())
                    {
                        if (astring[0].equals("modelPart_" + enumplayermodelparts.getPartName()))
                        {
                            this.setModelPartEnabled(enumplayermodelparts, astring[1].equals("true"));
                        }
                    }
                }
                catch (Exception exception)
                {
                    logger.warn("Skipping bad option: " + s);
                    exception.printStackTrace();
                }
            }

            KeyBinding.resetKeyBindingArrayAndHash();
            bufferedreader.close();
        }
        catch (Exception exception1)
        {
            logger.error((String)"Failed to load options", (Throwable)exception1);
        }

        this.loadOfOptions();
    }

    /**
     * Parses a string into a float.
     */
    private float parseFloat(String p_74305_1_)
    {
        return p_74305_1_.equals("true") ? 1.0F : (p_74305_1_.equals("false") ? 0.0F : Float.parseFloat(p_74305_1_));
    }

    /**
     * Saves the options to the options file.
     */
    public void saveOptions()
    {
        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(this.optionsFile));
            printwriter.println("invertYMouse:" + this.invertMouse);
            printwriter.println("mouseSensitivity:" + this.mouseSensitivity);
            printwriter.println("fov:" + (this.fovSetting - OBFVAL_4Xfmz.get()) / OBFVAL_5pPS8.get());
            printwriter.println("gamma:" + this.gammaSetting);
            printwriter.println("saturation:" + this.saturation);
            printwriter.println("renderDistance:" + this.renderDistanceChunks);
            printwriter.println("guiScale:" + this.guiScale);
            printwriter.println("particles:" + this.particleSetting);
            printwriter.println("bobView:" + this.viewBobbing);
            printwriter.println("anaglyph3d:" + this.anaglyph);
            printwriter.println("maxFps:" + this.limitFramerate);
            printwriter.println("fboEnable:" + this.fboEnable);
            printwriter.println("difficulty:" + this.difficulty.getDifficultyId());
            printwriter.println("fancyGraphics:" + this.fancyGraphics);
            printwriter.println("ao:" + this.ambientOcclusion);

            switch (this.clouds)
            {
                case 0:
                    printwriter.println("renderClouds:false");
                    break;

                case 1:
                    printwriter.println("renderClouds:fast");
                    break;

                case 2:
                    printwriter.println("renderClouds:true");
            }

            printwriter.println("resourcePacks:" + gson.toJson((Object)this.resourcePacks));
            printwriter.println("incompatibleResourcePacks:" + gson.toJson((Object)this.field_183018_l));
            printwriter.println("lastServer:" + this.lastServer);
            printwriter.println("lang:" + this.language);
            printwriter.println("chatVisibility:" + this.chatVisibility.getChatVisibility());
            printwriter.println("chatColors:" + this.chatColours);
            printwriter.println("chatLinks:" + this.chatLinks);
            printwriter.println("chatLinksPrompt:" + this.chatLinksPrompt);
            printwriter.println("chatOpacity:" + this.chatOpacity);
            printwriter.println("snooperEnabled:" + this.snooperEnabled);
            printwriter.println("fullscreen:" + this.fullScreen);
            printwriter.println("enableVsync:" + this.enableVsync);
            printwriter.println("useVbo:" + this.useVbo);
            printwriter.println("hideServerAddress:" + this.hideServerAddress);
            printwriter.println("advancedItemTooltips:" + this.advancedItemTooltips);
            printwriter.println("pauseOnLostFocus:" + this.pauseOnLostFocus);
            printwriter.println("touchscreen:" + this.touchscreen);
            printwriter.println("overrideWidth:" + this.overrideWidth);
            printwriter.println("overrideHeight:" + this.overrideHeight);
            printwriter.println("heldItemTooltips:" + this.heldItemTooltips);
            printwriter.println("chatHeightFocused:" + this.chatHeightFocused);
            printwriter.println("chatHeightUnfocused:" + this.chatHeightUnfocused);
            printwriter.println("chatScale:" + this.chatScale);
            printwriter.println("chatWidth:" + this.chatWidth);
            printwriter.println("showInventoryAchievementHint:" + this.showInventoryAchievementHint);
            printwriter.println("mipmapLevels:" + this.mipmapLevels);
            printwriter.println("streamBytesPerPixel:" + this.streamBytesPerPixel);
            printwriter.println("streamMicVolume:" + this.streamMicVolume);
            printwriter.println("streamSystemVolume:" + this.streamGameVolume);
            printwriter.println("streamKbps:" + this.streamKbps);
            printwriter.println("streamFps:" + this.streamFps);
            printwriter.println("streamCompression:" + this.streamCompression);
            printwriter.println("streamSendMetadata:" + this.streamSendMetadata);
            printwriter.println("streamPreferredServer:" + this.streamPreferredServer);
            printwriter.println("streamChatEnabled:" + this.streamChatEnabled);
            printwriter.println("streamChatUserFilter:" + this.streamChatUserFilter);
            printwriter.println("streamMicToggleBehavior:" + this.streamMicToggleBehavior);
            printwriter.println("forceUnicodeFont:" + this.forceUnicodeFont);
            printwriter.println("allowBlockAlternatives:" + this.allowBlockAlternatives);
            printwriter.println("reducedDebugInfo:" + this.reducedDebugInfo);
            printwriter.println("useNativeTransport:" + this.field_181150_U);
            printwriter.println("entityShadows:" + this.field_181151_V);

            for (KeyBinding keybinding : this.keyBindings)
            {
                printwriter.println("key_" + keybinding.getKeyDescription() + ":" + keybinding.getKeyCode());
            }

            for (SoundCategory soundcategory : SoundCategory.values())
            {
                printwriter.println("soundCategory_" + soundcategory.getCategoryName() + ":" + this.getSoundLevel(soundcategory));
            }

            for (EnumPlayerModelParts enumplayermodelparts : EnumPlayerModelParts.values())
            {
                printwriter.println("modelPart_" + enumplayermodelparts.getPartName() + ":" + this.setModelParts.contains(enumplayermodelparts));
            }

            printwriter.close();
        }
        catch (Exception exception)
        {
            logger.error((String)"Failed to save options", (Throwable)exception);
        }

        this.saveOfOptions();
        this.sendSettingsToServer();
    }

    public float getSoundLevel(SoundCategory p_151438_1_)
    {
        return this.mapSoundLevels.containsKey(p_151438_1_) ? ((Float)this.mapSoundLevels.get(p_151438_1_)).floatValue() : 1.0F;
    }

    public void setSoundLevel(SoundCategory p_151439_1_, float p_151439_2_)
    {
        this.mc.getSoundHandler().setSoundLevel(p_151439_1_, p_151439_2_);
        this.mapSoundLevels.put(p_151439_1_, Float.valueOf(p_151439_2_));
    }

    /**
     * Send a client info packet with settings information to the server
     */
    public void sendSettingsToServer()
    {
        if (this.mc.thePlayer != null)
        {
            int i = 0;

            for (Object object : this.setModelParts)
            {
                i |= ((EnumPlayerModelParts)object).getPartMask();
            }

            this.mc.thePlayer.sendQueue.addToSendQueue(new C15PacketClientSettings(this.language, this.renderDistanceChunks, this.chatVisibility, this.chatColours, i));
        }
    }

    public Set getModelParts()
    {
        return ImmutableSet.copyOf(this.setModelParts);
    }

    public void setModelPartEnabled(EnumPlayerModelParts p_178878_1_, boolean p_178878_2_)
    {
        if (p_178878_2_)
        {
            this.setModelParts.add(p_178878_1_);
        }
        else
        {
            this.setModelParts.remove(p_178878_1_);
        }

        this.sendSettingsToServer();
    }

    public void switchModelPartEnabled(EnumPlayerModelParts p_178877_1_)
    {
        if (!this.getModelParts().contains(p_178877_1_))
        {
            this.setModelParts.add(p_178877_1_);
        }
        else
        {
            this.setModelParts.remove(p_178877_1_);
        }

        this.sendSettingsToServer();
    }

    public int func_181147_e()
    {
        return this.renderDistanceChunks >= OBFVAL_Qyn8N.get() ? this.clouds : 0;
    }

    public boolean func_181148_f()
    {
        return this.field_181150_U;
    }

    private void setOptionFloatValueOF(GameSettings.Options p_setOptionFloatValueOF_1_, float p_setOptionFloatValueOF_2_)
    {
        if (p_setOptionFloatValueOF_1_ == GameSettings.Options.CLOUD_HEIGHT)
        {
            this.ofCloudsHeight = p_setOptionFloatValueOF_2_;
            this.mc.renderGlobal.resetClouds();
        }

        if (p_setOptionFloatValueOF_1_ == GameSettings.Options.AO_LEVEL)
        {
            this.ofAoLevel = p_setOptionFloatValueOF_2_;
            this.mc.renderGlobal.loadRenderers();
        }

        if (p_setOptionFloatValueOF_1_ == GameSettings.Options.AA_LEVEL)
        {
            int i = (int)p_setOptionFloatValueOF_2_;

            if (i > 0 && Config.isShaders())
            {
                Config.showGuiMessage(Lang.get("of.message.aa.shaders1"), Lang.get("of.message.aa.shaders2"));
                return;
            }

            int[] aint1 = new int[OBFVAL_dSUah.get()];
            aint1[0] = 0;
            aint1[1] = OBFVAL_LrwhV.get();
            aint1[OBFVAL_LrwhV.get()] = OBFVAL_Qyn8N.get();
            aint1[OBFVAL_ycoNk.get()] = OBFVAL_W8MAh.get();
            aint1[OBFVAL_Qyn8N.get()] = OBFVAL_Wesap.get();
            aint1[OBFVAL_rkM2H.get()] = OBFVAL_8tmgL.get();
            aint1[OBFVAL_W8MAh.get()] = OBFVAL_49oMU.get();
            int[] aint = aint1;
            this.ofAaLevel = 0;

            for (int j = 0; j < aint.length; ++j)
            {
                if (i >= aint[j])
                {
                    this.ofAaLevel = aint[j];
                }
            }

            this.ofAaLevel = Config.limit(this.ofAaLevel, 0, OBFVAL_49oMU.get());
        }

        if (p_setOptionFloatValueOF_1_ == GameSettings.Options.AF_LEVEL)
        {
            int k = (int)p_setOptionFloatValueOF_2_;

            if (k > 1 && Config.isShaders())
            {
                Config.showGuiMessage(Lang.get("of.message.af.shaders1"), Lang.get("of.message.af.shaders2"));
                return;
            }

            for (this.ofAfLevel = 1; this.ofAfLevel * OBFVAL_LrwhV.get() <= k; this.ofAfLevel *= OBFVAL_LrwhV.get())
            {
                ;
            }

            this.ofAfLevel = Config.limit(this.ofAfLevel, 1, OBFVAL_49oMU.get());
            this.mc.refreshResources();
        }

        if (p_setOptionFloatValueOF_1_ == GameSettings.Options.MIPMAP_TYPE)
        {
            int l = (int)p_setOptionFloatValueOF_2_;
            this.ofMipmapType = Config.limit(l, 0, OBFVAL_ycoNk.get());
            this.mc.refreshResources();
        }
    }

    private void setOptionValueOF(GameSettings.Options p_setOptionValueOF_1_, int p_setOptionValueOF_2_)
    {
        if (p_setOptionValueOF_1_ == GameSettings.Options.FOG_FANCY)
        {
            switch (this.ofFogType)
            {
                case 1:
                    this.ofFogType = OBFVAL_LrwhV.get();

                    if (!Config.isFancyFogAvailable())
                    {
                        this.ofFogType = OBFVAL_ycoNk.get();
                    }

                    break;

                case 2:
                    this.ofFogType = OBFVAL_ycoNk.get();
                    break;

                case 3:
                    this.ofFogType = 1;
                    break;

                default:
                    this.ofFogType = 1;
            }
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.FOG_START)
        {
            this.ofFogStart += OBFVAL_b7fPY.get();

            if (this.ofFogStart > OBFVAL_q92qJ.get())
            {
                this.ofFogStart = OBFVAL_b7fPY.get();
            }
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.SMOOTH_FPS)
        {
            this.ofSmoothFps = !this.ofSmoothFps;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.SMOOTH_WORLD)
        {
            this.ofSmoothWorld = !this.ofSmoothWorld;
            Config.updateThreadPriorities();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.CLOUDS)
        {
            ++this.ofClouds;

            if (this.ofClouds > OBFVAL_ycoNk.get())
            {
                this.ofClouds = 0;
            }

            this.updateRenderClouds();
            this.mc.renderGlobal.resetClouds();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.TREES)
        {
            this.ofTrees = nextValue(this.ofTrees, OF_TREES_VALUES);
            this.mc.renderGlobal.loadRenderers();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.DROPPED_ITEMS)
        {
            ++this.ofDroppedItems;

            if (this.ofDroppedItems > OBFVAL_LrwhV.get())
            {
                this.ofDroppedItems = 0;
            }
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.RAIN)
        {
            ++this.ofRain;

            if (this.ofRain > OBFVAL_ycoNk.get())
            {
                this.ofRain = 0;
            }
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.ANIMATED_WATER)
        {
            ++this.ofAnimatedWater;

            if (this.ofAnimatedWater == 1)
            {
                ++this.ofAnimatedWater;
            }

            if (this.ofAnimatedWater > OBFVAL_LrwhV.get())
            {
                this.ofAnimatedWater = 0;
            }
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.ANIMATED_LAVA)
        {
            ++this.ofAnimatedLava;

            if (this.ofAnimatedLava == 1)
            {
                ++this.ofAnimatedLava;
            }

            if (this.ofAnimatedLava > OBFVAL_LrwhV.get())
            {
                this.ofAnimatedLava = 0;
            }
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.ANIMATED_FIRE)
        {
            this.ofAnimatedFire = !this.ofAnimatedFire;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.ANIMATED_PORTAL)
        {
            this.ofAnimatedPortal = !this.ofAnimatedPortal;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.ANIMATED_REDSTONE)
        {
            this.ofAnimatedRedstone = !this.ofAnimatedRedstone;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.ANIMATED_EXPLOSION)
        {
            this.ofAnimatedExplosion = !this.ofAnimatedExplosion;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.ANIMATED_FLAME)
        {
            this.ofAnimatedFlame = !this.ofAnimatedFlame;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.ANIMATED_SMOKE)
        {
            this.ofAnimatedSmoke = !this.ofAnimatedSmoke;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.VOID_PARTICLES)
        {
            this.ofVoidParticles = !this.ofVoidParticles;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.WATER_PARTICLES)
        {
            this.ofWaterParticles = !this.ofWaterParticles;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.PORTAL_PARTICLES)
        {
            this.ofPortalParticles = !this.ofPortalParticles;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.POTION_PARTICLES)
        {
            this.ofPotionParticles = !this.ofPotionParticles;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.FIREWORK_PARTICLES)
        {
            this.ofFireworkParticles = !this.ofFireworkParticles;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.DRIPPING_WATER_LAVA)
        {
            this.ofDrippingWaterLava = !this.ofDrippingWaterLava;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.ANIMATED_TERRAIN)
        {
            this.ofAnimatedTerrain = !this.ofAnimatedTerrain;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.ANIMATED_TEXTURES)
        {
            this.ofAnimatedTextures = !this.ofAnimatedTextures;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.RAIN_SPLASH)
        {
            this.ofRainSplash = !this.ofRainSplash;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.LAGOMETER)
        {
            this.ofLagometer = !this.ofLagometer;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.SHOW_FPS)
        {
            this.ofShowFps = !this.ofShowFps;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.AUTOSAVE_TICKS)
        {
            this.ofAutoSaveTicks *= OBFVAL_cPaTy.get();

            if (this.ofAutoSaveTicks > OBFVAL_5pHRY.get())
            {
                this.ofAutoSaveTicks = OBFVAL_1uadt.get();
            }
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.BETTER_GRASS)
        {
            ++this.ofBetterGrass;

            if (this.ofBetterGrass > OBFVAL_ycoNk.get())
            {
                this.ofBetterGrass = 1;
            }

            this.mc.renderGlobal.loadRenderers();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.CONNECTED_TEXTURES)
        {
            ++this.ofConnectedTextures;

            if (this.ofConnectedTextures > OBFVAL_ycoNk.get())
            {
                this.ofConnectedTextures = 1;
            }

            if (this.ofConnectedTextures != OBFVAL_LrwhV.get())
            {
                this.mc.refreshResources();
            }
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.WEATHER)
        {
            this.ofWeather = !this.ofWeather;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.SKY)
        {
            this.ofSky = !this.ofSky;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.STARS)
        {
            this.ofStars = !this.ofStars;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.SUN_MOON)
        {
            this.ofSunMoon = !this.ofSunMoon;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.VIGNETTE)
        {
            ++this.ofVignette;

            if (this.ofVignette > OBFVAL_LrwhV.get())
            {
                this.ofVignette = 0;
            }
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.CHUNK_UPDATES)
        {
            ++this.ofChunkUpdates;

            if (this.ofChunkUpdates > OBFVAL_rkM2H.get())
            {
                this.ofChunkUpdates = 1;
            }
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.CHUNK_UPDATES_DYNAMIC)
        {
            this.ofChunkUpdatesDynamic = !this.ofChunkUpdatesDynamic;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.TIME)
        {
            ++this.ofTime;

            if (this.ofTime > OBFVAL_LrwhV.get())
            {
                this.ofTime = 0;
            }
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.CLEAR_WATER)
        {
            this.ofClearWater = !this.ofClearWater;
            this.updateWaterOpacity();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.PROFILER)
        {
            this.ofProfiler = !this.ofProfiler;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.BETTER_SNOW)
        {
            this.ofBetterSnow = !this.ofBetterSnow;
            this.mc.renderGlobal.loadRenderers();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.SWAMP_COLORS)
        {
            this.ofSwampColors = !this.ofSwampColors;
            CustomColors.updateUseDefaultGrassFoliageColors();
            this.mc.renderGlobal.loadRenderers();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.RANDOM_MOBS)
        {
            this.ofRandomMobs = !this.ofRandomMobs;
            RandomMobs.resetTextures();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.SMOOTH_BIOMES)
        {
            this.ofSmoothBiomes = !this.ofSmoothBiomes;
            CustomColors.updateUseDefaultGrassFoliageColors();
            this.mc.renderGlobal.loadRenderers();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.CUSTOM_FONTS)
        {
            this.ofCustomFonts = !this.ofCustomFonts;
            this.mc.fontRendererObj.onResourceManagerReload(Config.getResourceManager());
            this.mc.standardGalacticFontRenderer.onResourceManagerReload(Config.getResourceManager());
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.CUSTOM_COLORS)
        {
            this.ofCustomColors = !this.ofCustomColors;
            CustomColors.update();
            this.mc.renderGlobal.loadRenderers();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.CUSTOM_ITEMS)
        {
            this.ofCustomItems = !this.ofCustomItems;
            this.mc.refreshResources();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.CUSTOM_SKY)
        {
            this.ofCustomSky = !this.ofCustomSky;
            CustomSky.update();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.SHOW_CAPES)
        {
            this.ofShowCapes = !this.ofShowCapes;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.NATURAL_TEXTURES)
        {
            this.ofNaturalTextures = !this.ofNaturalTextures;
            NaturalTextures.update();
            this.mc.renderGlobal.loadRenderers();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.FAST_MATH)
        {
            this.ofFastMath = !this.ofFastMath;
            MathHelper.fastMath = this.ofFastMath;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.FAST_RENDER)
        {
            if (!this.ofFastRender && Config.isShaders())
            {
                Config.showGuiMessage(Lang.get("of.message.fr.shaders1"), Lang.get("of.message.fr.shaders2"));
                return;
            }

            this.ofFastRender = !this.ofFastRender;

            if (this.ofFastRender)
            {
                this.mc.entityRenderer.func_181022_b();
            }

            Config.updateFramebufferSize();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.TRANSLUCENT_BLOCKS)
        {
            if (this.ofTranslucentBlocks == 0)
            {
                this.ofTranslucentBlocks = 1;
            }
            else if (this.ofTranslucentBlocks == 1)
            {
                this.ofTranslucentBlocks = OBFVAL_LrwhV.get();
            }
            else if (this.ofTranslucentBlocks == OBFVAL_LrwhV.get())
            {
                this.ofTranslucentBlocks = 0;
            }
            else
            {
                this.ofTranslucentBlocks = 0;
            }

            this.mc.renderGlobal.loadRenderers();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.LAZY_CHUNK_LOADING)
        {
            this.ofLazyChunkLoading = !this.ofLazyChunkLoading;
            Config.updateAvailableProcessors();

            if (!Config.isSingleProcessor())
            {
                this.ofLazyChunkLoading = false;
            }

            this.mc.renderGlobal.loadRenderers();
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.FULLSCREEN_MODE)
        {
            List list = Arrays.asList(Config.getDisplayModeNames());

            if (this.ofFullscreenMode.equals("Default"))
            {
                this.ofFullscreenMode = (String)list.get(0);
            }
            else
            {
                int i = list.indexOf(this.ofFullscreenMode);

                if (i < 0)
                {
                    this.ofFullscreenMode = "Default";
                }
                else
                {
                    ++i;

                    if (i >= list.size())
                    {
                        this.ofFullscreenMode = "Default";
                    }
                    else
                    {
                        this.ofFullscreenMode = (String)list.get(i);
                    }
                }
            }
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.DYNAMIC_FOV)
        {
            this.ofDynamicFov = !this.ofDynamicFov;
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.DYNAMIC_LIGHTS)
        {
            this.ofDynamicLights = nextValue(this.ofDynamicLights, OF_DYNAMIC_LIGHTS);
            DynamicLights.removeLights(this.mc.renderGlobal);
        }

        if (p_setOptionValueOF_1_ == GameSettings.Options.HELD_ITEM_TOOLTIPS)
        {
            this.heldItemTooltips = !this.heldItemTooltips;
        }
    }

    private String getKeyBindingOF(GameSettings.Options p_getKeyBindingOF_1_)
    {
        String s = I18n.format(p_getKeyBindingOF_1_.getEnumString(), new Object[0]) + ": ";

        if (s == null)
        {
            s = p_getKeyBindingOF_1_.getEnumString();
        }

        if (p_getKeyBindingOF_1_ == GameSettings.Options.RENDER_DISTANCE)
        {
            int l = (int)this.getOptionFloatValue(p_getKeyBindingOF_1_);
            String s1 = I18n.format("options.renderDistance.tiny", new Object[0]);
            int i = OBFVAL_LrwhV.get();

            if (l >= OBFVAL_Qyn8N.get())
            {
                s1 = I18n.format("options.renderDistance.short", new Object[0]);
                i = OBFVAL_Qyn8N.get();
            }

            if (l >= OBFVAL_Wesap.get())
            {
                s1 = I18n.format("options.renderDistance.normal", new Object[0]);
                i = OBFVAL_Wesap.get();
            }

            if (l >= OBFVAL_49oMU.get())
            {
                s1 = I18n.format("options.renderDistance.far", new Object[0]);
                i = OBFVAL_49oMU.get();
            }

            if (l >= OBFVAL_K6hCW.get())
            {
                s1 = Lang.get("of.options.renderDistance.extreme");
                i = OBFVAL_K6hCW.get();
            }

            int j = this.renderDistanceChunks - i;
            String s2 = s1;

            if (j > 0)
            {
                s2 = s1 + "+";
            }

            return s + l + " " + s2 + "";
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.FOG_FANCY)
        {
            switch (this.ofFogType)
            {
                case 1:
                    return s + Lang.getFast();

                case 2:
                    return s + Lang.getFancy();

                case 3:
                    return s + Lang.getOff();

                default:
                    return s + Lang.getOff();
            }
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.FOG_START)
        {
            return s + this.ofFogStart;
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.MIPMAP_TYPE)
        {
            switch (this.ofMipmapType)
            {
                case 0:
                    return s + Lang.get("of.options.mipmap.nearest");

                case 1:
                    return s + Lang.get("of.options.mipmap.linear");

                case 2:
                    return s + Lang.get("of.options.mipmap.bilinear");

                case 3:
                    return s + Lang.get("of.options.mipmap.trilinear");

                default:
                    return s + "of.options.mipmap.nearest";
            }
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.SMOOTH_FPS)
        {
            return this.ofSmoothFps ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.SMOOTH_WORLD)
        {
            return this.ofSmoothWorld ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.CLOUDS)
        {
            switch (this.ofClouds)
            {
                case 1:
                    return s + Lang.getFast();

                case 2:
                    return s + Lang.getFancy();

                case 3:
                    return s + Lang.getOff();

                default:
                    return s + Lang.getDefault();
            }
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.TREES)
        {
            switch (this.ofTrees)
            {
                case 1:
                    return s + Lang.getFast();

                case 2:
                    return s + Lang.getFancy();

                case 3:
                default:
                    return s + Lang.getDefault();

                case 4:
                    return s + Lang.get("of.general.smart");
            }
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.DROPPED_ITEMS)
        {
            switch (this.ofDroppedItems)
            {
                case 1:
                    return s + Lang.getFast();

                case 2:
                    return s + Lang.getFancy();

                default:
                    return s + Lang.getDefault();
            }
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.RAIN)
        {
            switch (this.ofRain)
            {
                case 1:
                    return s + Lang.getFast();

                case 2:
                    return s + Lang.getFancy();

                case 3:
                    return s + Lang.getOff();

                default:
                    return s + Lang.getDefault();
            }
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.ANIMATED_WATER)
        {
            switch (this.ofAnimatedWater)
            {
                case 1:
                    return s + Lang.get("of.options.animation.dynamic");

                case 2:
                    return s + Lang.getOff();

                default:
                    return s + Lang.getOn();
            }
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.ANIMATED_LAVA)
        {
            switch (this.ofAnimatedLava)
            {
                case 1:
                    return s + Lang.get("of.options.animation.dynamic");

                case 2:
                    return s + Lang.getOff();

                default:
                    return s + Lang.getOn();
            }
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.ANIMATED_FIRE)
        {
            return this.ofAnimatedFire ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.ANIMATED_PORTAL)
        {
            return this.ofAnimatedPortal ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.ANIMATED_REDSTONE)
        {
            return this.ofAnimatedRedstone ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.ANIMATED_EXPLOSION)
        {
            return this.ofAnimatedExplosion ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.ANIMATED_FLAME)
        {
            return this.ofAnimatedFlame ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.ANIMATED_SMOKE)
        {
            return this.ofAnimatedSmoke ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.VOID_PARTICLES)
        {
            return this.ofVoidParticles ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.WATER_PARTICLES)
        {
            return this.ofWaterParticles ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.PORTAL_PARTICLES)
        {
            return this.ofPortalParticles ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.POTION_PARTICLES)
        {
            return this.ofPotionParticles ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.FIREWORK_PARTICLES)
        {
            return this.ofFireworkParticles ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.DRIPPING_WATER_LAVA)
        {
            return this.ofDrippingWaterLava ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.ANIMATED_TERRAIN)
        {
            return this.ofAnimatedTerrain ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.ANIMATED_TEXTURES)
        {
            return this.ofAnimatedTextures ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.RAIN_SPLASH)
        {
            return this.ofRainSplash ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.LAGOMETER)
        {
            return this.ofLagometer ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.SHOW_FPS)
        {
            return this.ofShowFps ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.AUTOSAVE_TICKS)
        {
            return this.ofAutoSaveTicks <= OBFVAL_1uadt.get() ? s + Lang.get("of.options.save.default") : (this.ofAutoSaveTicks <= OBFVAL_cphMo.get() ? s + Lang.get("of.options.save.20s") : (this.ofAutoSaveTicks <= OBFVAL_ZGOVI.get() ? s + Lang.get("of.options.save.3min") : s + Lang.get("of.options.save.30min")));
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.BETTER_GRASS)
        {
            switch (this.ofBetterGrass)
            {
                case 1:
                    return s + Lang.getFast();

                case 2:
                    return s + Lang.getFancy();

                default:
                    return s + Lang.getOff();
            }
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.CONNECTED_TEXTURES)
        {
            switch (this.ofConnectedTextures)
            {
                case 1:
                    return s + Lang.getFast();

                case 2:
                    return s + Lang.getFancy();

                default:
                    return s + Lang.getOff();
            }
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.WEATHER)
        {
            return this.ofWeather ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.SKY)
        {
            return this.ofSky ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.STARS)
        {
            return this.ofStars ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.SUN_MOON)
        {
            return this.ofSunMoon ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.VIGNETTE)
        {
            switch (this.ofVignette)
            {
                case 1:
                    return s + Lang.getFast();

                case 2:
                    return s + Lang.getFancy();

                default:
                    return s + Lang.getDefault();
            }
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.CHUNK_UPDATES)
        {
            return s + this.ofChunkUpdates;
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.CHUNK_UPDATES_DYNAMIC)
        {
            return this.ofChunkUpdatesDynamic ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.TIME)
        {
            return this.ofTime == 1 ? s + Lang.get("of.options.time.dayOnly") : (this.ofTime == OBFVAL_LrwhV.get() ? s + Lang.get("of.options.time.nightOnly") : s + Lang.getDefault());
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.CLEAR_WATER)
        {
            return this.ofClearWater ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.AA_LEVEL)
        {
            String s3 = "";

            if (this.ofAaLevel != Config.getAntialiasingLevel())
            {
                s3 = " (" + Lang.get("of.general.restart") + ")";
            }

            return this.ofAaLevel == 0 ? s + Lang.getOff() + s3 : s + this.ofAaLevel + s3;
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.AF_LEVEL)
        {
            return this.ofAfLevel == 1 ? s + Lang.getOff() : s + this.ofAfLevel;
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.PROFILER)
        {
            return this.ofProfiler ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.BETTER_SNOW)
        {
            return this.ofBetterSnow ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.SWAMP_COLORS)
        {
            return this.ofSwampColors ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.RANDOM_MOBS)
        {
            return this.ofRandomMobs ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.SMOOTH_BIOMES)
        {
            return this.ofSmoothBiomes ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.CUSTOM_FONTS)
        {
            return this.ofCustomFonts ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.CUSTOM_COLORS)
        {
            return this.ofCustomColors ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.CUSTOM_SKY)
        {
            return this.ofCustomSky ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.SHOW_CAPES)
        {
            return this.ofShowCapes ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.CUSTOM_ITEMS)
        {
            return this.ofCustomItems ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.NATURAL_TEXTURES)
        {
            return this.ofNaturalTextures ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.FAST_MATH)
        {
            return this.ofFastMath ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.FAST_RENDER)
        {
            return this.ofFastRender ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.TRANSLUCENT_BLOCKS)
        {
            return this.ofTranslucentBlocks == 1 ? s + Lang.getFast() : (this.ofTranslucentBlocks == OBFVAL_LrwhV.get() ? s + Lang.getFancy() : s + Lang.getDefault());
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.LAZY_CHUNK_LOADING)
        {
            return this.ofLazyChunkLoading ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.DYNAMIC_FOV)
        {
            return this.ofDynamicFov ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.DYNAMIC_LIGHTS)
        {
            int k = indexOf(this.ofDynamicLights, OF_DYNAMIC_LIGHTS);
            return s + getTranslation(KEYS_DYNAMIC_LIGHTS, k);
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.FULLSCREEN_MODE)
        {
            return this.ofFullscreenMode.equals("Default") ? s + Lang.getDefault() : s + this.ofFullscreenMode;
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.HELD_ITEM_TOOLTIPS)
        {
            return this.heldItemTooltips ? s + Lang.getOn() : s + Lang.getOff();
        }
        else if (p_getKeyBindingOF_1_ == GameSettings.Options.FRAMERATE_LIMIT)
        {
            float f = this.getOptionFloatValue(p_getKeyBindingOF_1_);
            return f == 0.0F ? s + Lang.get("of.options.framerateLimit.vsync") : (f == p_getKeyBindingOF_1_.valueMax ? s + I18n.format("options.framerateLimit.max", new Object[0]) : s + (int)f + " fps");
        }
        else
        {
            return null;
        }
    }

    public void loadOfOptions()
    {
        try
        {
            File file1 = this.optionsFileOF;

            if (!file1.exists())
            {
                file1 = this.optionsFile;
            }

            if (!file1.exists())
            {
                return;
            }

            BufferedReader bufferedreader = new BufferedReader(new FileReader(file1));
            String s = "";

            while ((s = bufferedreader.readLine()) != null)
            {
                try
                {
                    String[] astring = s.split(":");

                    if (astring[0].equals("ofRenderDistanceChunks") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.renderDistanceChunks = Integer.valueOf(astring[1]).intValue();
                        this.renderDistanceChunks = Config.limit(this.renderDistanceChunks, OBFVAL_LrwhV.get(), OBFVAL_K6hCW.get());
                    }

                    if (astring[0].equals("ofFogType") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofFogType = Integer.valueOf(astring[1]).intValue();
                        this.ofFogType = Config.limit(this.ofFogType, 1, OBFVAL_ycoNk.get());
                    }

                    if (astring[0].equals("ofFogStart") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofFogStart = Float.valueOf(astring[1]).floatValue();

                        if (this.ofFogStart < OBFVAL_b7fPY.get())
                        {
                            this.ofFogStart = OBFVAL_b7fPY.get();
                        }

                        if (this.ofFogStart > OBFVAL_q92qJ.get())
                        {
                            this.ofFogStart = OBFVAL_L0jh5.get();
                        }
                    }

                    if (astring[0].equals("ofMipmapType") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofMipmapType = Integer.valueOf(astring[1]).intValue();
                        this.ofMipmapType = Config.limit(this.ofMipmapType, 0, OBFVAL_ycoNk.get());
                    }

                    if (astring[0].equals("ofOcclusionFancy") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofOcclusionFancy = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofSmoothFps") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofSmoothFps = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofSmoothWorld") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofSmoothWorld = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofAoLevel") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofAoLevel = Float.valueOf(astring[1]).floatValue();
                        this.ofAoLevel = Config.limit(this.ofAoLevel, 0.0F, 1.0F);
                    }

                    if (astring[0].equals("ofClouds") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofClouds = Integer.valueOf(astring[1]).intValue();
                        this.ofClouds = Config.limit(this.ofClouds, 0, OBFVAL_ycoNk.get());
                        this.updateRenderClouds();
                    }

                    if (astring[0].equals("ofCloudsHeight") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofCloudsHeight = Float.valueOf(astring[1]).floatValue();
                        this.ofCloudsHeight = Config.limit(this.ofCloudsHeight, 0.0F, 1.0F);
                    }

                    if (astring[0].equals("ofTrees") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofTrees = Integer.valueOf(astring[1]).intValue();
                        this.ofTrees = limit(this.ofTrees, OF_TREES_VALUES);
                    }

                    if (astring[0].equals("ofDroppedItems") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofDroppedItems = Integer.valueOf(astring[1]).intValue();
                        this.ofDroppedItems = Config.limit(this.ofDroppedItems, 0, OBFVAL_LrwhV.get());
                    }

                    if (astring[0].equals("ofRain") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofRain = Integer.valueOf(astring[1]).intValue();
                        this.ofRain = Config.limit(this.ofRain, 0, OBFVAL_ycoNk.get());
                    }

                    if (astring[0].equals("ofAnimatedWater") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofAnimatedWater = Integer.valueOf(astring[1]).intValue();
                        this.ofAnimatedWater = Config.limit(this.ofAnimatedWater, 0, OBFVAL_LrwhV.get());
                    }

                    if (astring[0].equals("ofAnimatedLava") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofAnimatedLava = Integer.valueOf(astring[1]).intValue();
                        this.ofAnimatedLava = Config.limit(this.ofAnimatedLava, 0, OBFVAL_LrwhV.get());
                    }

                    if (astring[0].equals("ofAnimatedFire") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofAnimatedFire = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofAnimatedPortal") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofAnimatedPortal = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofAnimatedRedstone") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofAnimatedRedstone = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofAnimatedExplosion") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofAnimatedExplosion = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofAnimatedFlame") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofAnimatedFlame = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofAnimatedSmoke") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofAnimatedSmoke = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofVoidParticles") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofVoidParticles = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofWaterParticles") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofWaterParticles = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofPortalParticles") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofPortalParticles = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofPotionParticles") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofPotionParticles = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofFireworkParticles") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofFireworkParticles = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofDrippingWaterLava") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofDrippingWaterLava = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofAnimatedTerrain") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofAnimatedTerrain = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofAnimatedTextures") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofAnimatedTextures = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofRainSplash") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofRainSplash = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofLagometer") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofLagometer = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofShowFps") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofShowFps = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofAutoSaveTicks") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofAutoSaveTicks = Integer.valueOf(astring[1]).intValue();
                        this.ofAutoSaveTicks = Config.limit(this.ofAutoSaveTicks, OBFVAL_1uadt.get(), OBFVAL_5pHRY.get());
                    }

                    if (astring[0].equals("ofBetterGrass") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofBetterGrass = Integer.valueOf(astring[1]).intValue();
                        this.ofBetterGrass = Config.limit(this.ofBetterGrass, 1, OBFVAL_ycoNk.get());
                    }

                    if (astring[0].equals("ofConnectedTextures") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofConnectedTextures = Integer.valueOf(astring[1]).intValue();
                        this.ofConnectedTextures = Config.limit(this.ofConnectedTextures, 1, OBFVAL_ycoNk.get());
                    }

                    if (astring[0].equals("ofWeather") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofWeather = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofSky") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofSky = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofStars") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofStars = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofSunMoon") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofSunMoon = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofVignette") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofVignette = Integer.valueOf(astring[1]).intValue();
                        this.ofVignette = Config.limit(this.ofVignette, 0, OBFVAL_LrwhV.get());
                    }

                    if (astring[0].equals("ofChunkUpdates") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofChunkUpdates = Integer.valueOf(astring[1]).intValue();
                        this.ofChunkUpdates = Config.limit(this.ofChunkUpdates, 1, OBFVAL_rkM2H.get());
                    }

                    if (astring[0].equals("ofChunkUpdatesDynamic") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofChunkUpdatesDynamic = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofTime") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofTime = Integer.valueOf(astring[1]).intValue();
                        this.ofTime = Config.limit(this.ofTime, 0, OBFVAL_LrwhV.get());
                    }

                    if (astring[0].equals("ofClearWater") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofClearWater = Boolean.valueOf(astring[1]).booleanValue();
                        this.updateWaterOpacity();
                    }

                    if (astring[0].equals("ofAaLevel") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofAaLevel = Integer.valueOf(astring[1]).intValue();
                        this.ofAaLevel = Config.limit(this.ofAaLevel, 0, OBFVAL_49oMU.get());
                    }

                    if (astring[0].equals("ofAfLevel") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofAfLevel = Integer.valueOf(astring[1]).intValue();
                        this.ofAfLevel = Config.limit(this.ofAfLevel, 1, OBFVAL_49oMU.get());
                    }

                    if (astring[0].equals("ofProfiler") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofProfiler = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofBetterSnow") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofBetterSnow = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofSwampColors") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofSwampColors = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofRandomMobs") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofRandomMobs = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofSmoothBiomes") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofSmoothBiomes = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofCustomFonts") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofCustomFonts = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofCustomColors") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofCustomColors = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofCustomItems") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofCustomItems = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofCustomSky") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofCustomSky = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofShowCapes") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofShowCapes = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofNaturalTextures") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofNaturalTextures = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofLazyChunkLoading") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofLazyChunkLoading = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofDynamicFov") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofDynamicFov = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofDynamicLights") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofDynamicLights = Integer.valueOf(astring[1]).intValue();
                        this.ofDynamicLights = limit(this.ofDynamicLights, OF_DYNAMIC_LIGHTS);
                    }

                    if (astring[0].equals("ofFullscreenMode") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofFullscreenMode = astring[1];
                    }

                    if (astring[0].equals("ofFastMath") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofFastMath = Boolean.valueOf(astring[1]).booleanValue();
                        MathHelper.fastMath = this.ofFastMath;
                    }

                    if (astring[0].equals("ofFastRender") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofFastRender = Boolean.valueOf(astring[1]).booleanValue();
                    }

                    if (astring[0].equals("ofTranslucentBlocks") && astring.length >= OBFVAL_LrwhV.get())
                    {
                        this.ofTranslucentBlocks = Integer.valueOf(astring[1]).intValue();
                        this.ofTranslucentBlocks = Config.limit(this.ofTranslucentBlocks, 0, OBFVAL_LrwhV.get());
                    }

                    if (astring[0].equals("key_" + this.ofKeyBindZoom.getKeyDescription()))
                    {
                        this.ofKeyBindZoom.setKeyCode(Integer.parseInt(astring[1]));
                    }
                }
                catch (Exception exception)
                {
                    Config.dbg("Skipping bad option: " + s);
                    exception.printStackTrace();
                }
            }

            KeyBinding.resetKeyBindingArrayAndHash();
            bufferedreader.close();
        }
        catch (Exception exception1)
        {
            Config.warn("Failed to load options");
            exception1.printStackTrace();
        }
    }

    public void saveOfOptions()
    {
        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(this.optionsFileOF));
            printwriter.println("ofRenderDistanceChunks:" + this.renderDistanceChunks);
            printwriter.println("ofFogType:" + this.ofFogType);
            printwriter.println("ofFogStart:" + this.ofFogStart);
            printwriter.println("ofMipmapType:" + this.ofMipmapType);
            printwriter.println("ofOcclusionFancy:" + this.ofOcclusionFancy);
            printwriter.println("ofSmoothFps:" + this.ofSmoothFps);
            printwriter.println("ofSmoothWorld:" + this.ofSmoothWorld);
            printwriter.println("ofAoLevel:" + this.ofAoLevel);
            printwriter.println("ofClouds:" + this.ofClouds);
            printwriter.println("ofCloudsHeight:" + this.ofCloudsHeight);
            printwriter.println("ofTrees:" + this.ofTrees);
            printwriter.println("ofDroppedItems:" + this.ofDroppedItems);
            printwriter.println("ofRain:" + this.ofRain);
            printwriter.println("ofAnimatedWater:" + this.ofAnimatedWater);
            printwriter.println("ofAnimatedLava:" + this.ofAnimatedLava);
            printwriter.println("ofAnimatedFire:" + this.ofAnimatedFire);
            printwriter.println("ofAnimatedPortal:" + this.ofAnimatedPortal);
            printwriter.println("ofAnimatedRedstone:" + this.ofAnimatedRedstone);
            printwriter.println("ofAnimatedExplosion:" + this.ofAnimatedExplosion);
            printwriter.println("ofAnimatedFlame:" + this.ofAnimatedFlame);
            printwriter.println("ofAnimatedSmoke:" + this.ofAnimatedSmoke);
            printwriter.println("ofVoidParticles:" + this.ofVoidParticles);
            printwriter.println("ofWaterParticles:" + this.ofWaterParticles);
            printwriter.println("ofPortalParticles:" + this.ofPortalParticles);
            printwriter.println("ofPotionParticles:" + this.ofPotionParticles);
            printwriter.println("ofFireworkParticles:" + this.ofFireworkParticles);
            printwriter.println("ofDrippingWaterLava:" + this.ofDrippingWaterLava);
            printwriter.println("ofAnimatedTerrain:" + this.ofAnimatedTerrain);
            printwriter.println("ofAnimatedTextures:" + this.ofAnimatedTextures);
            printwriter.println("ofRainSplash:" + this.ofRainSplash);
            printwriter.println("ofLagometer:" + this.ofLagometer);
            printwriter.println("ofShowFps:" + this.ofShowFps);
            printwriter.println("ofAutoSaveTicks:" + this.ofAutoSaveTicks);
            printwriter.println("ofBetterGrass:" + this.ofBetterGrass);
            printwriter.println("ofConnectedTextures:" + this.ofConnectedTextures);
            printwriter.println("ofWeather:" + this.ofWeather);
            printwriter.println("ofSky:" + this.ofSky);
            printwriter.println("ofStars:" + this.ofStars);
            printwriter.println("ofSunMoon:" + this.ofSunMoon);
            printwriter.println("ofVignette:" + this.ofVignette);
            printwriter.println("ofChunkUpdates:" + this.ofChunkUpdates);
            printwriter.println("ofChunkUpdatesDynamic:" + this.ofChunkUpdatesDynamic);
            printwriter.println("ofTime:" + this.ofTime);
            printwriter.println("ofClearWater:" + this.ofClearWater);
            printwriter.println("ofAaLevel:" + this.ofAaLevel);
            printwriter.println("ofAfLevel:" + this.ofAfLevel);
            printwriter.println("ofProfiler:" + this.ofProfiler);
            printwriter.println("ofBetterSnow:" + this.ofBetterSnow);
            printwriter.println("ofSwampColors:" + this.ofSwampColors);
            printwriter.println("ofRandomMobs:" + this.ofRandomMobs);
            printwriter.println("ofSmoothBiomes:" + this.ofSmoothBiomes);
            printwriter.println("ofCustomFonts:" + this.ofCustomFonts);
            printwriter.println("ofCustomColors:" + this.ofCustomColors);
            printwriter.println("ofCustomItems:" + this.ofCustomItems);
            printwriter.println("ofCustomSky:" + this.ofCustomSky);
            printwriter.println("ofShowCapes:" + this.ofShowCapes);
            printwriter.println("ofNaturalTextures:" + this.ofNaturalTextures);
            printwriter.println("ofLazyChunkLoading:" + this.ofLazyChunkLoading);
            printwriter.println("ofDynamicFov:" + this.ofDynamicFov);
            printwriter.println("ofDynamicLights:" + this.ofDynamicLights);
            printwriter.println("ofFullscreenMode:" + this.ofFullscreenMode);
            printwriter.println("ofFastMath:" + this.ofFastMath);
            printwriter.println("ofFastRender:" + this.ofFastRender);
            printwriter.println("ofTranslucentBlocks:" + this.ofTranslucentBlocks);
            printwriter.println("key_" + this.ofKeyBindZoom.getKeyDescription() + ":" + this.ofKeyBindZoom.getKeyCode());
            printwriter.close();
        }
        catch (Exception exception)
        {
            Config.warn("Failed to save options");
            exception.printStackTrace();
        }
    }

    private void updateRenderClouds()
    {
        switch (this.ofClouds)
        {
            case 1:
                this.clouds = 1;
                break;

            case 2:
                this.clouds = OBFVAL_LrwhV.get();
                break;

            case 3:
                this.clouds = 0;
                break;

            default:
                if (this.fancyGraphics)
                {
                    this.clouds = OBFVAL_LrwhV.get();
                }
                else
                {
                    this.clouds = 1;
                }
        }
    }

    public void resetSettings()
    {
        this.renderDistanceChunks = OBFVAL_Wesap.get();
        this.viewBobbing = true;
        this.anaglyph = false;
        this.limitFramerate = (int)GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
        this.enableVsync = false;
        this.updateVSync();
        this.mipmapLevels = OBFVAL_Qyn8N.get();
        this.fancyGraphics = true;
        this.ambientOcclusion = OBFVAL_LrwhV.get();
        this.clouds = OBFVAL_LrwhV.get();
        this.fovSetting = OBFVAL_4Xfmz.get();
        this.gammaSetting = 0.0F;
        this.guiScale = 0;
        this.particleSetting = 0;
        this.heldItemTooltips = true;
        this.useVbo = false;
        this.allowBlockAlternatives = true;
        this.forceUnicodeFont = false;
        this.ofFogType = 1;
        this.ofFogStart = OBFVAL_L0jh5.get();
        this.ofMipmapType = 0;
        this.ofOcclusionFancy = false;
        this.ofSmoothFps = false;
        Config.updateAvailableProcessors();
        this.ofSmoothWorld = Config.isSingleProcessor();
        this.ofLazyChunkLoading = Config.isSingleProcessor();
        this.ofFastMath = false;
        this.ofFastRender = false;
        this.ofTranslucentBlocks = 0;
        this.ofDynamicFov = true;
        this.ofDynamicLights = OBFVAL_ycoNk.get();
        this.ofAoLevel = 1.0F;
        this.ofAaLevel = 0;
        this.ofAfLevel = 1;
        this.ofClouds = 0;
        this.ofCloudsHeight = 0.0F;
        this.ofTrees = 0;
        this.ofRain = 0;
        this.ofBetterGrass = OBFVAL_ycoNk.get();
        this.ofAutoSaveTicks = OBFVAL_ZGOVI.get();
        this.ofLagometer = false;
        this.ofShowFps = false;
        this.ofProfiler = false;
        this.ofWeather = true;
        this.ofSky = true;
        this.ofStars = true;
        this.ofSunMoon = true;
        this.ofVignette = 0;
        this.ofChunkUpdates = 1;
        this.ofChunkUpdatesDynamic = false;
        this.ofTime = 0;
        this.ofClearWater = false;
        this.ofBetterSnow = false;
        this.ofFullscreenMode = "Default";
        this.ofSwampColors = true;
        this.ofRandomMobs = true;
        this.ofSmoothBiomes = true;
        this.ofCustomFonts = true;
        this.ofCustomColors = true;
        this.ofCustomItems = true;
        this.ofCustomSky = true;
        this.ofShowCapes = true;
        this.ofConnectedTextures = OBFVAL_LrwhV.get();
        this.ofNaturalTextures = false;
        this.ofAnimatedWater = 0;
        this.ofAnimatedLava = 0;
        this.ofAnimatedFire = true;
        this.ofAnimatedPortal = true;
        this.ofAnimatedRedstone = true;
        this.ofAnimatedExplosion = true;
        this.ofAnimatedFlame = true;
        this.ofAnimatedSmoke = true;
        this.ofVoidParticles = true;
        this.ofWaterParticles = true;
        this.ofRainSplash = true;
        this.ofPortalParticles = true;
        this.ofPotionParticles = true;
        this.ofFireworkParticles = true;
        this.ofDrippingWaterLava = true;
        this.ofAnimatedTerrain = true;
        this.ofAnimatedTextures = true;
        Shaders.setShaderPack(Shaders.packNameNone);
        Shaders.configAntialiasingLevel = 0;
        Shaders.uninit();
        Shaders.storeConfig();
        this.updateWaterOpacity();
        this.mc.refreshResources();
        this.saveOptions();
    }

    public void updateVSync()
    {
        Display.setVSyncEnabled(this.enableVsync);
    }

    private void updateWaterOpacity()
    {
        if (this.mc.isIntegratedServerRunning() && this.mc.getIntegratedServer() != null)
        {
            Config.waterOpacityChanged = true;
        }

        ClearWater.updateWaterOpacity(this, this.mc.theWorld);
    }

    public void setAllAnimations(boolean p_setAllAnimations_1_)
    {
        int i = p_setAllAnimations_1_ ? 0 : OBFVAL_LrwhV.get();
        this.ofAnimatedWater = i;
        this.ofAnimatedLava = i;
        this.ofAnimatedFire = p_setAllAnimations_1_;
        this.ofAnimatedPortal = p_setAllAnimations_1_;
        this.ofAnimatedRedstone = p_setAllAnimations_1_;
        this.ofAnimatedExplosion = p_setAllAnimations_1_;
        this.ofAnimatedFlame = p_setAllAnimations_1_;
        this.ofAnimatedSmoke = p_setAllAnimations_1_;
        this.ofVoidParticles = p_setAllAnimations_1_;
        this.ofWaterParticles = p_setAllAnimations_1_;
        this.ofRainSplash = p_setAllAnimations_1_;
        this.ofPortalParticles = p_setAllAnimations_1_;
        this.ofPotionParticles = p_setAllAnimations_1_;
        this.ofFireworkParticles = p_setAllAnimations_1_;
        this.particleSetting = p_setAllAnimations_1_ ? 0 : OBFVAL_LrwhV.get();
        this.ofDrippingWaterLava = p_setAllAnimations_1_;
        this.ofAnimatedTerrain = p_setAllAnimations_1_;
        this.ofAnimatedTextures = p_setAllAnimations_1_;
    }

    private static int nextValue(int p_nextValue_0_, int[] p_nextValue_1_)
    {
        int i = indexOf(p_nextValue_0_, p_nextValue_1_);

        if (i < 0)
        {
            return p_nextValue_1_[0];
        }
        else
        {
            ++i;

            if (i >= p_nextValue_1_.length)
            {
                i = 0;
            }

            return p_nextValue_1_[i];
        }
    }

    private static int limit(int p_limit_0_, int[] p_limit_1_)
    {
        int i = indexOf(p_limit_0_, p_limit_1_);
        return i < 0 ? p_limit_1_[0] : p_limit_0_;
    }

    private static int indexOf(int p_indexOf_0_, int[] p_indexOf_1_)
    {
        for (int i = 0; i < p_indexOf_1_.length; ++i)
        {
            if (p_indexOf_1_[i] == p_indexOf_0_)
            {
                return i;
            }
        }

        return -1;
    }

    static
    {
        ObfValue.beginGeneration();
        ObfValue.endGeneration(new byte[] {(byte) - 128, (byte) - 89, (byte)7, (byte)73, (byte)47, (byte)64, (byte) - 126, (byte)13});
    }

    static final class GameSettings$GameSettings$2
    {
        static final int[] field_151477_a = new int[GameSettings.Options.values().length];
        private static final String __OBFID = "CL_00000652";

        static
        {
            try
            {
                field_151477_a[GameSettings.Options.INVERT_MOUSE.ordinal()] = 1;
            }
            catch (NoSuchFieldError var17)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.VIEW_BOBBING.ordinal()] = 2;
            }
            catch (NoSuchFieldError var16)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.ANAGLYPH.ordinal()] = 3;
            }
            catch (NoSuchFieldError var15)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.FBO_ENABLE.ordinal()] = 4;
            }
            catch (NoSuchFieldError var14)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.CHAT_COLOR.ordinal()] = 5;
            }
            catch (NoSuchFieldError var13)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.CHAT_LINKS.ordinal()] = 6;
            }
            catch (NoSuchFieldError var12)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.CHAT_LINKS_PROMPT.ordinal()] = 7;
            }
            catch (NoSuchFieldError var11)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.SNOOPER_ENABLED.ordinal()] = 8;
            }
            catch (NoSuchFieldError var10)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.USE_FULLSCREEN.ordinal()] = 9;
            }
            catch (NoSuchFieldError var9)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.ENABLE_VSYNC.ordinal()] = 10;
            }
            catch (NoSuchFieldError var8)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.USE_VBO.ordinal()] = 11;
            }
            catch (NoSuchFieldError var7)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.TOUCHSCREEN.ordinal()] = 12;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.STREAM_SEND_METADATA.ordinal()] = 13;
            }
            catch (NoSuchFieldError var5)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.FORCE_UNICODE_FONT.ordinal()] = 14;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.BLOCK_ALTERNATIVES.ordinal()] = 15;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.REDUCED_DEBUG_INFO.ordinal()] = 16;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                field_151477_a[GameSettings.Options.ENTITY_SHADOWS.ordinal()] = 17;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }

    public static enum Options
    {
        INVERT_MOUSE("INVERT_MOUSE", 0, "options.invertMouse", false, true),
        SENSITIVITY("SENSITIVITY", 1, "options.sensitivity", true, false),
        FOV("FOV", 2, "options.fov", true, false, 30.0F, 110.0F, 1.0F),
        GAMMA("GAMMA", 3, "options.gamma", true, false),
        SATURATION("SATURATION", 4, "options.saturation", true, false),
        RENDER_DISTANCE("RENDER_DISTANCE", 5, "options.renderDistance", true, false, 2.0F, 16.0F, 1.0F),
        VIEW_BOBBING("VIEW_BOBBING", 6, "options.viewBobbing", false, true),
        ANAGLYPH("ANAGLYPH", 7, "options.anaglyph", false, true),
        FRAMERATE_LIMIT("FRAMERATE_LIMIT", 8, "options.framerateLimit", true, false, 0.0F, 260.0F, 5.0F),
        FBO_ENABLE("FBO_ENABLE", 9, "options.fboEnable", false, true),
        RENDER_CLOUDS("RENDER_CLOUDS", 10, "options.renderClouds", false, false),
        GRAPHICS("GRAPHICS", 11, "options.graphics", false, false),
        AMBIENT_OCCLUSION("AMBIENT_OCCLUSION", 12, "options.ao", false, false),
        GUI_SCALE("GUI_SCALE", 13, "options.guiScale", false, false),
        PARTICLES("PARTICLES", 14, "options.particles", false, false),
        CHAT_VISIBILITY("CHAT_VISIBILITY", 15, "options.chat.visibility", false, false),
        CHAT_COLOR("CHAT_COLOR", 16, "options.chat.color", false, true),
        CHAT_LINKS("CHAT_LINKS", 17, "options.chat.links", false, true),
        CHAT_OPACITY("CHAT_OPACITY", 18, "options.chat.opacity", true, false),
        CHAT_LINKS_PROMPT("CHAT_LINKS_PROMPT", 19, "options.chat.links.prompt", false, true),
        SNOOPER_ENABLED("SNOOPER_ENABLED", 20, "options.snooper", false, true),
        USE_FULLSCREEN("USE_FULLSCREEN", 21, "options.fullscreen", false, true),
        ENABLE_VSYNC("ENABLE_VSYNC", 22, "options.vsync", false, true),
        USE_VBO("USE_VBO", 23, "options.vbo", false, true),
        TOUCHSCREEN("TOUCHSCREEN", 24, "options.touchscreen", false, true),
        CHAT_SCALE("CHAT_SCALE", 25, "options.chat.scale", true, false),
        CHAT_WIDTH("CHAT_WIDTH", 26, "options.chat.width", true, false),
        CHAT_HEIGHT_FOCUSED("CHAT_HEIGHT_FOCUSED", 27, "options.chat.height.focused", true, false),
        CHAT_HEIGHT_UNFOCUSED("CHAT_HEIGHT_UNFOCUSED", 28, "options.chat.height.unfocused", true, false),
        MIPMAP_LEVELS("MIPMAP_LEVELS", 29, "options.mipmapLevels", true, false, 0.0F, 4.0F, 1.0F),
        FORCE_UNICODE_FONT("FORCE_UNICODE_FONT", 30, "options.forceUnicodeFont", false, true),
        STREAM_BYTES_PER_PIXEL("STREAM_BYTES_PER_PIXEL", 31, "options.stream.bytesPerPixel", true, false),
        STREAM_VOLUME_MIC("STREAM_VOLUME_MIC", 32, "options.stream.micVolumne", true, false),
        STREAM_VOLUME_SYSTEM("STREAM_VOLUME_SYSTEM", 33, "options.stream.systemVolume", true, false),
        STREAM_KBPS("STREAM_KBPS", 34, "options.stream.kbps", true, false),
        STREAM_FPS("STREAM_FPS", 35, "options.stream.fps", true, false),
        STREAM_COMPRESSION("STREAM_COMPRESSION", 36, "options.stream.compression", false, false),
        STREAM_SEND_METADATA("STREAM_SEND_METADATA", 37, "options.stream.sendMetadata", false, true),
        STREAM_CHAT_ENABLED("STREAM_CHAT_ENABLED", 38, "options.stream.chat.enabled", false, false),
        STREAM_CHAT_USER_FILTER("STREAM_CHAT_USER_FILTER", 39, "options.stream.chat.userFilter", false, false),
        STREAM_MIC_TOGGLE_BEHAVIOR("STREAM_MIC_TOGGLE_BEHAVIOR", 40, "options.stream.micToggleBehavior", false, false),
        BLOCK_ALTERNATIVES("BLOCK_ALTERNATIVES", 41, "options.blockAlternatives", false, true),
        REDUCED_DEBUG_INFO("REDUCED_DEBUG_INFO", 42, "options.reducedDebugInfo", false, true),
        ENTITY_SHADOWS("ENTITY_SHADOWS", 43, "options.entityShadows", false, true),
        FOG_FANCY("", 999, "of.options.FOG_FANCY", false, false),
        FOG_START("", 999, "of.options.FOG_START", false, false),
        MIPMAP_TYPE("", 999, "of.options.MIPMAP_TYPE", true, false, 0.0F, 3.0F, 1.0F),
        SMOOTH_FPS("", 999, "of.options.SMOOTH_FPS", false, false),
        CLOUDS("", 999, "of.options.CLOUDS", false, false),
        CLOUD_HEIGHT("", 999, "of.options.CLOUD_HEIGHT", true, false),
        TREES("", 999, "of.options.TREES", false, false),
        RAIN("", 999, "of.options.RAIN", false, false),
        ANIMATED_WATER("", 999, "of.options.ANIMATED_WATER", false, false),
        ANIMATED_LAVA("", 999, "of.options.ANIMATED_LAVA", false, false),
        ANIMATED_FIRE("", 999, "of.options.ANIMATED_FIRE", false, false),
        ANIMATED_PORTAL("", 999, "of.options.ANIMATED_PORTAL", false, false),
        AO_LEVEL("", 999, "of.options.AO_LEVEL", true, false),
        LAGOMETER("", 999, "of.options.LAGOMETER", false, false),
        SHOW_FPS("", 999, "of.options.SHOW_FPS", false, false),
        AUTOSAVE_TICKS("", 999, "of.options.AUTOSAVE_TICKS", false, false),
        BETTER_GRASS("", 999, "of.options.BETTER_GRASS", false, false),
        ANIMATED_REDSTONE("", 999, "of.options.ANIMATED_REDSTONE", false, false),
        ANIMATED_EXPLOSION("", 999, "of.options.ANIMATED_EXPLOSION", false, false),
        ANIMATED_FLAME("", 999, "of.options.ANIMATED_FLAME", false, false),
        ANIMATED_SMOKE("", 999, "of.options.ANIMATED_SMOKE", false, false),
        WEATHER("", 999, "of.options.WEATHER", false, false),
        SKY("", 999, "of.options.SKY", false, false),
        STARS("", 999, "of.options.STARS", false, false),
        SUN_MOON("", 999, "of.options.SUN_MOON", false, false),
        VIGNETTE("", 999, "of.options.VIGNETTE", false, false),
        CHUNK_UPDATES("", 999, "of.options.CHUNK_UPDATES", false, false),
        CHUNK_UPDATES_DYNAMIC("", 999, "of.options.CHUNK_UPDATES_DYNAMIC", false, false),
        TIME("", 999, "of.options.TIME", false, false),
        CLEAR_WATER("", 999, "of.options.CLEAR_WATER", false, false),
        SMOOTH_WORLD("", 999, "of.options.SMOOTH_WORLD", false, false),
        VOID_PARTICLES("", 999, "of.options.VOID_PARTICLES", false, false),
        WATER_PARTICLES("", 999, "of.options.WATER_PARTICLES", false, false),
        RAIN_SPLASH("", 999, "of.options.RAIN_SPLASH", false, false),
        PORTAL_PARTICLES("", 999, "of.options.PORTAL_PARTICLES", false, false),
        POTION_PARTICLES("", 999, "of.options.POTION_PARTICLES", false, false),
        FIREWORK_PARTICLES("", 999, "of.options.FIREWORK_PARTICLES", false, false),
        PROFILER("", 999, "of.options.PROFILER", false, false),
        DRIPPING_WATER_LAVA("", 999, "of.options.DRIPPING_WATER_LAVA", false, false),
        BETTER_SNOW("", 999, "of.options.BETTER_SNOW", false, false),
        FULLSCREEN_MODE("", 999, "of.options.FULLSCREEN_MODE", false, false),
        ANIMATED_TERRAIN("", 999, "of.options.ANIMATED_TERRAIN", false, false),
        SWAMP_COLORS("", 999, "of.options.SWAMP_COLORS", false, false),
        RANDOM_MOBS("", 999, "of.options.RANDOM_MOBS", false, false),
        SMOOTH_BIOMES("", 999, "of.options.SMOOTH_BIOMES", false, false),
        CUSTOM_FONTS("", 999, "of.options.CUSTOM_FONTS", false, false),
        CUSTOM_COLORS("", 999, "of.options.CUSTOM_COLORS", false, false),
        SHOW_CAPES("", 999, "of.options.SHOW_CAPES", false, false),
        CONNECTED_TEXTURES("", 999, "of.options.CONNECTED_TEXTURES", false, false),
        CUSTOM_ITEMS("", 999, "of.options.CUSTOM_ITEMS", false, false),
        AA_LEVEL("", 999, "of.options.AA_LEVEL", true, false, 0.0F, 16.0F, 1.0F),
        AF_LEVEL("", 999, "of.options.AF_LEVEL", true, false, 1.0F, 16.0F, 1.0F),
        ANIMATED_TEXTURES("", 999, "of.options.ANIMATED_TEXTURES", false, false),
        NATURAL_TEXTURES("", 999, "of.options.NATURAL_TEXTURES", false, false),
        HELD_ITEM_TOOLTIPS("", 999, "of.options.HELD_ITEM_TOOLTIPS", false, false),
        DROPPED_ITEMS("", 999, "of.options.DROPPED_ITEMS", false, false),
        LAZY_CHUNK_LOADING("", 999, "of.options.LAZY_CHUNK_LOADING", false, false),
        CUSTOM_SKY("", 999, "of.options.CUSTOM_SKY", false, false),
        FAST_MATH("", 999, "of.options.FAST_MATH", false, false),
        FAST_RENDER("", 999, "of.options.FAST_RENDER", false, false),
        TRANSLUCENT_BLOCKS("", 999, "of.options.TRANSLUCENT_BLOCKS", false, false),
        DYNAMIC_FOV("", 999, "of.options.DYNAMIC_FOV", false, false),
        DYNAMIC_LIGHTS("", 999, "of.options.DYNAMIC_LIGHTS", false, false);

        private final boolean enumFloat;
        private final boolean enumBoolean;
        private final String enumString;
        private final float valueStep;
        private float valueMin;
        private float valueMax;
        private static final String __OBFID = "CL_00000653";

        public static GameSettings.Options getEnumOptions(int p_74379_0_)
        {
            for (GameSettings.Options gamesettings$options : values())
            {
                if (gamesettings$options.returnEnumOrdinal() == p_74379_0_)
                {
                    return gamesettings$options;
                }
            }

            return null;
        }

        private Options(String p_i3_3_, int p_i3_4_, String p_i3_5_, boolean p_i3_6_, boolean p_i3_7_)
        {
            this(p_i3_3_, p_i3_4_, p_i3_5_, p_i3_6_, p_i3_7_, 0.0F, 1.0F, 0.0F);
        }

        private Options(String p_i4_3_, int p_i4_4_, String p_i4_5_, boolean p_i4_6_, boolean p_i4_7_, float p_i4_8_, float p_i4_9_, float p_i4_10_)
        {
            this.enumString = p_i4_5_;
            this.enumFloat = p_i4_6_;
            this.enumBoolean = p_i4_7_;
            this.valueMin = p_i4_8_;
            this.valueMax = p_i4_9_;
            this.valueStep = p_i4_10_;
        }

        public boolean getEnumFloat()
        {
            return this.enumFloat;
        }

        public boolean getEnumBoolean()
        {
            return this.enumBoolean;
        }

        public int returnEnumOrdinal()
        {
            return this.ordinal();
        }

        public String getEnumString()
        {
            return this.enumString;
        }

        public float getValueMax()
        {
            return this.valueMax;
        }

        public void setValueMax(float p_148263_1_)
        {
            this.valueMax = p_148263_1_;
        }

        public float normalizeValue(float p_148266_1_)
        {
            return MathHelper.clamp_float((this.snapToStepClamp(p_148266_1_) - this.valueMin) / (this.valueMax - this.valueMin), 0.0F, 1.0F);
        }

        public float denormalizeValue(float p_148262_1_)
        {
            return this.snapToStepClamp(this.valueMin + (this.valueMax - this.valueMin) * MathHelper.clamp_float(p_148262_1_, 0.0F, 1.0F));
        }

        public float snapToStepClamp(float p_148268_1_)
        {
            p_148268_1_ = this.snapToStep(p_148268_1_);
            return MathHelper.clamp_float(p_148268_1_, this.valueMin, this.valueMax);
        }

        protected float snapToStep(float p_148264_1_)
        {
            if (this.valueStep > 0.0F)
            {
                p_148264_1_ = this.valueStep * (float)Math.round(p_148264_1_ / this.valueStep);
            }

            return p_148264_1_;
        }
    }
}
