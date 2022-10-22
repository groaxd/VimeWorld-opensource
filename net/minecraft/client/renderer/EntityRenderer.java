package net.minecraft.client.renderer;

import com.creativemd.cmdcam.CamEventHandler;
import com.creativemd.cmdcam.transform.CamMouseOverHandler;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.culling.ClippingHelperImpl;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.shader.ShaderLinkHelper;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MouseFilter;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.biome.BiomeGenBase;
import net.xtrafrancyz.covered.ObfValue;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.gui.GuiRenderLayer;
import optifine.Config;
import optifine.CustomColors;
import optifine.Lagometer;
import optifine.RandomMobs;
import optifine.TextureUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Project;
import shadersmod.client.Shaders;
import shadersmod.client.ShadersRender;

public class EntityRenderer implements IResourceManagerReloadListener
{
    private static final ObfValue.OInteger OBFVAL_YEet5 = ObfValue.create(31);
    private static final ObfValue.ODouble OBFVAL_HY8Mz = ObfValue.create(0.01D);
    private static final ObfValue.OInteger OBFVAL_fOuzA = ObfValue.create(4);
    private static final ObfValue.OLong OBFVAL_I8OKh = ObfValue.create(20L);
    private static final ObfValue.OInteger OBFVAL_hDkLE = ObfValue.create(5890);
    private static final ObfValue.OFloat OBFVAL_5IxBj = ObfValue.create(0.00390625F);
    private static final ObfValue.OInteger OBFVAL_GlFuv = ObfValue.create(7425);
    private static final ObfValue.OInteger OBFVAL_zejjh = ObfValue.create(2);
    private static final ObfValue.OFloat OBFVAL_kWvDd = ObfValue.create(0.28F);
    private static final ObfValue.OInteger OBFVAL_z7Ixz = ObfValue.create(60);
    private static final ObfValue.OInteger OBFVAL_mvI7p = ObfValue.create(20);
    private static final ObfValue.OFloat OBFVAL_psDxT = ObfValue.create(256.0F);
    private static final ObfValue.ODouble OBFVAL_LAs7X = ObfValue.create(3.0D);
    private static final ObfValue.OFloat OBFVAL_CVKmX = ObfValue.create(0.65F);
    private static final ObfValue.OInteger OBFVAL_32ZJz = ObfValue.create(255);
    private static final ObfValue.OFloat OBFVAL_qiL0r = ObfValue.create(0.04F);
    private static final ObfValue.OFloat OBFVAL_ZVhLV = ObfValue.create(0.8F);
    private static final ObfValue.OInteger OBFVAL_K0DIH = ObfValue.create(34140);
    private static final ObfValue.OInteger OBFVAL_6FN5j = ObfValue.create(45238971);
    private static final ObfValue.ODouble OBFVAL_GavSc = ObfValue.create(9.0D);
    private static final ObfValue.ODouble OBFVAL_OB7Vp = ObfValue.create(0.001D);
    private static final ObfValue.OFloat OBFVAL_MyYU3 = ObfValue.create(8000.0F);
    private static final ObfValue.OFloat OBFVAL_W9ZvG = ObfValue.create(500.0F);
    private static final ObfValue.OFloat OBFVAL_zMn89 = ObfValue.create(0.0125F);
    private static final ObfValue.OFloat OBFVAL_qOaKl = ObfValue.create((float)Math.PI);
    private static final ObfValue.ODouble OBFVAL_zccFq = ObfValue.create(0.9D);
    private static final ObfValue.OFloat OBFVAL_tY6pR = ObfValue.create(40.0F);
    private static final ObfValue.OInteger OBFVAL_yTXBI = ObfValue.create(65535);
    private static final ObfValue.OLong OBFVAL_Bwr8f = ObfValue.create(312987231L);
    private static final ObfValue.OLong OBFVAL_LyCGw = ObfValue.create(50L);
    private static final ObfValue.OInteger OBFVAL_VXuQ4 = ObfValue.create(516);
    private static final ObfValue.OFloat OBFVAL_QAIST = ObfValue.create(0.7F);
    private static final ObfValue.OFloat OBFVAL_USYnj = ObfValue.create(-0.1F);
    private static final ObfValue.OFloat OBFVAL_j4Aqa = ObfValue.create(200.0F);
    private static final ObfValue.ODouble OBFVAL_jOK6q = ObfValue.create(0.005D);
    private static final ObfValue.OInteger OBFVAL_l7o1g = ObfValue.create(200);
    private static final ObfValue.OInteger OBFVAL_Rmm83 = ObfValue.create(5888);
    private static final ObfValue.OFloat OBFVAL_HAhWr = ObfValue.create(5.0F);
    private static final ObfValue.OFloat OBFVAL_lrN2J = ObfValue.create(32.0F);
    private static final ObfValue.OFloat OBFVAL_qtKgX = ObfValue.create(16.0F);
    private static final ObfValue.OInteger OBFVAL_gu21U = ObfValue.create(2918);
    private static final ObfValue.OFloat OBFVAL_KUOSH = ObfValue.create(20.0F);
    private static final ObfValue.OFloat OBFVAL_y22Lm = ObfValue.create(30.0F);
    private static final ObfValue.OInteger OBFVAL_iBoAv = ObfValue.create(64);
    private static final ObfValue.OFloat OBFVAL_7sr6W = ObfValue.create(0.05F);
    private static final ObfValue.ODouble OBFVAL_sqUZW = ObfValue.create(1.0E-4D);
    private static final ObfValue.OInteger OBFVAL_8JLrR = ObfValue.create(10243);
    private static final ObfValue.OLong OBFVAL_0CDc9 = ObfValue.create(1000000L);
    private static final ObfValue.OFloat OBFVAL_6GjzO = ObfValue.create(90.0F);
    private static final ObfValue.OFloat OBFVAL_tHt21 = ObfValue.create(-90.0F);
    private static final ObfValue.OFloat OBFVAL_Nn6nB = ObfValue.create(0.03F);
    private static final ObfValue.OInteger OBFVAL_8ZWHW = ObfValue.create(10242);
    private static final ObfValue.OInteger OBFVAL_dpSag = ObfValue.create(418711);
    private static final ObfValue.OFloat OBFVAL_UYzpE = ObfValue.create(512.0F);
    private static final ObfValue.ODouble OBFVAL_3FFlc = ObfValue.create(-1.0D);
    private static final ObfValue.OFloat OBFVAL_r5b2C = ObfValue.create(100.0F);
    private static final ObfValue.ODouble OBFVAL_uW9Bi = ObfValue.create(32.0D);
    private static final ObfValue.OInteger OBFVAL_d2m5l = ObfValue.create(34139);
    private static final ObfValue.ODouble OBFVAL_BytzI = ObfValue.create(0.25D);
    private static final ObfValue.OInteger OBFVAL_1iYyQ = ObfValue.create(10496);
    private static final ObfValue.ODouble OBFVAL_VCBJx = ObfValue.create(0.0033D);
    private static final ObfValue.OFloat OBFVAL_xgpCA = ObfValue.create(0.3F);
    private static final ObfValue.OInteger OBFVAL_USh2A = ObfValue.create(16);
    private static final ObfValue.OFloat OBFVAL_eC7QJ = ObfValue.create(50.0F);
    private static final ObfValue.OInteger OBFVAL_TOaMY = ObfValue.create(9729);
    private static final ObfValue.OInteger OBFVAL_WzWKl = ObfValue.create(100);
    private static final ObfValue.OInteger OBFVAL_H11br = ObfValue.create(16640);
    private static final ObfValue.OInteger OBFVAL_HXJ4H = ObfValue.create(3);
    private static final ObfValue.OInteger OBFVAL_MaYMb = ObfValue.create(1028);
    private static final ObfValue.OInteger OBFVAL_p2kUj = ObfValue.create(4608);
    private static final ObfValue.OFloat OBFVAL_GEV3d = ObfValue.create(0.07F);
    private static final ObfValue.OInteger OBFVAL_tKDdL = ObfValue.create(10);
    private static final ObfValue.OInteger OBFVAL_eOgDW = ObfValue.create(7424);
    private static final ObfValue.ODouble OBFVAL_EAGBM = ObfValue.create(3000.0D);
    private static final ObfValue.OInteger OBFVAL_FgjKP = ObfValue.create(32);
    private static final ObfValue.OFloat OBFVAL_mgd5c = ObfValue.create(14.0F);
    private static final ObfValue.OInteger OBFVAL_xNbMN = ObfValue.create(5);
    private static final ObfValue.OInteger OBFVAL_6s7CP = ObfValue.create(770);
    private static final ObfValue.OInteger OBFVAL_PICz1 = ObfValue.create(1000000000);
    private static final ObfValue.OInteger OBFVAL_MNK0g = ObfValue.create(7);
    private static final ObfValue.OFloat OBFVAL_RYrHR = ObfValue.create(0.01F);
    private static final ObfValue.OFloat OBFVAL_b8UoI = ObfValue.create(0.5F);
    private static final ObfValue.OFloat OBFVAL_SNlJC = ObfValue.create(8.0F);
    private static final ObfValue.OFloat OBFVAL_ZQrgv = ObfValue.create(-1.0F);
    private static final ObfValue.OFloat OBFVAL_2dGYR = ObfValue.create(0.4F);
    private static final ObfValue.OFloat OBFVAL_kqaNJ = ObfValue.create(4.0F);
    private static final ObfValue.OFloat OBFVAL_UjWd3 = ObfValue.create(70.0F);
    private static final ObfValue.OInteger OBFVAL_AqMKA = ObfValue.create(3121);
    private static final ObfValue.OFloat OBFVAL_TtfOV = ObfValue.create(0.96F);
    private static final ObfValue.OLong OBFVAL_XCp0e = ObfValue.create(10000L);
    private static final ObfValue.ODouble OBFVAL_gSz2D = ObfValue.create(1000.0D);
    private static final ObfValue.OFloat OBFVAL_0cIV7 = ObfValue.create(0.35F);
    private static final ObfValue.OFloat OBFVAL_m7d7j = ObfValue.create(128.0F);
    private static final ObfValue.ODouble OBFVAL_rs6QN = ObfValue.create(999.0D);
    private static final ObfValue.OFloat OBFVAL_JnPc7 = ObfValue.create(180.0F);
    private static final ObfValue.OInteger OBFVAL_uiG6j = ObfValue.create(90);
    private static final ObfValue.OFloat OBFVAL_nfhIC = ObfValue.create(0.1F);
    private static final ObfValue.OFloat OBFVAL_PnIcF = ObfValue.create(-2000.0F);
    private static final ObfValue.OFloat OBFVAL_3hWJt = ObfValue.create(0.25F);
    private static final ObfValue.OFloat OBFVAL_6xnuP = ObfValue.create(1.5F);
    private static final ObfValue.ODouble OBFVAL_O3n6N = ObfValue.create(128.0D);
    private static final ObfValue.OInteger OBFVAL_72gXJ = ObfValue.create(1024);
    private static final ObfValue.ODouble OBFVAL_do0DF = ObfValue.create(6.0D);
    private static final ObfValue.OFloat OBFVAL_l3q7D = ObfValue.create(0.75F);
    private static final ObfValue.OInteger OBFVAL_xUI2a = ObfValue.create(771);
    private static final ObfValue.OInteger OBFVAL_3Dp0s = ObfValue.create(10240);
    private static final ObfValue.OFloat OBFVAL_mhpPT = ObfValue.create(0.2F);
    private static final ObfValue.OInteger OBFVAL_HdUX4 = ObfValue.create(34138);
    private static final ObfValue.OInteger OBFVAL_OkLoL = ObfValue.create(15728880);
    private static final ObfValue.OFloat OBFVAL_zvxPe = ObfValue.create(0.15F);
    private static final ObfValue.OInteger OBFVAL_7r50x = ObfValue.create(13761);
    private static final ObfValue.OInteger OBFVAL_yzjb8 = ObfValue.create(24);
    private static final ObfValue.OInteger OBFVAL_WO4MG = ObfValue.create(511);
    private static final ObfValue.OFloat OBFVAL_zUQ63 = ObfValue.create(11.0F);
    private static final ObfValue.OFloat OBFVAL_nQK2S = ObfValue.create(60.0F);
    private static final ObfValue.OFloat OBFVAL_KNHYB = ObfValue.create(173.0F);
    private static final ObfValue.OInteger OBFVAL_u3u9V = ObfValue.create(2048);
    private static final ObfValue.OInteger OBFVAL_Jgz4S = ObfValue.create(8);
    private static final ObfValue.OInteger OBFVAL_WkaJq = ObfValue.create(10241);
    private static final ObfValue.OFloat OBFVAL_8ji7X = ObfValue.create(0.02F);
    private static final ObfValue.OFloat OBFVAL_TFMYx = ObfValue.create(3.0F);
    private static final ObfValue.OFloat OBFVAL_lacQB = ObfValue.create(2.0F);
    private static final ObfValue.OFloat OBFVAL_U9DUZ = ObfValue.create(0.83F);
    private static final ObfValue.OFloat OBFVAL_StqCW = ObfValue.create(0.22F);
    private static final ObfValue.OFloat OBFVAL_wXzmu = ObfValue.create(0.95F);
    private static final ObfValue.OLong OBFVAL_uqLid = ObfValue.create(500L);
    private static final ObfValue.OFloat OBFVAL_Ri74X = ObfValue.create(0.6F);
    private static final ObfValue.OInteger OBFVAL_Yojsk = ObfValue.create(5889);
    private static final ObfValue.OFloat OBFVAL_DYKsA = ObfValue.create(59.0F);
    private static final ObfValue.OInteger OBFVAL_hTQvU = ObfValue.create(3553);
    private static final ObfValue.ODouble OBFVAL_zIRzO = ObfValue.create(0.5D);
    private static final ObfValue.OInteger OBFVAL_qbi68 = ObfValue.create(256);
    private static final ObfValue.OFloat OBFVAL_7MBn1 = ObfValue.create(255.0F);
    private static final Logger logger = LogManager.getLogger();
    private static final ResourceLocation locationRainPng = new ResourceLocation("textures/environment/rain.png");
    private static final ResourceLocation locationSnowPng = new ResourceLocation("textures/environment/snow.png");
    public static boolean anaglyphEnable;

    /** Anaglyph field (0=R, 1=GB) */
    public static int anaglyphField;

    /** A reference to the Minecraft object. */
    private Minecraft mc;
    private final IResourceManager resourceManager;
    private Random random = new Random();
    private float farPlaneDistance;
    public ItemRenderer itemRenderer;
    private final MapItemRenderer theMapItemRenderer;

    /** Entity renderer update count */
    private int rendererUpdateCount;

    /** Pointed entity */
    public Entity pointedEntity;
    private MouseFilter mouseFilterXAxis = new MouseFilter();
    private MouseFilter mouseFilterYAxis = new MouseFilter();
    private float thirdPersonDistance;

    /** Third person distance temp */
    private float thirdPersonDistanceTemp;

    /** Smooth cam yaw */
    private float smoothCamYaw;

    /** Smooth cam pitch */
    private float smoothCamPitch;

    /** Smooth cam filter X */
    private float smoothCamFilterX;

    /** Smooth cam filter Y */
    private float smoothCamFilterY;

    /** Smooth cam partial ticks */
    private float smoothCamPartialTicks;

    /** FOV modifier hand */
    private float fovModifierHand;

    /** FOV modifier hand prev */
    private float fovModifierHandPrev;
    private float bossColorModifier;
    private float bossColorModifierPrev;

    /** Cloud fog mode */
    private boolean cloudFog;
    private boolean renderHand;
    private boolean drawBlockOutline;

    /** Previous frame time in milliseconds */
    private long prevFrameTime;

    /** End time of last render (ns) */
    private long renderEndNanoTime;

    /**
     * The texture id of the blocklight/skylight texture used for lighting effects
     */
    private final DynamicTexture lightmapTexture;

    /**
     * Colors computed in updateLightmap() and loaded into the lightmap emptyTexture
     */
    private final int[] lightmapColors;
    private final ResourceLocation locationLightMap;

    /**
     * Is set, updateCameraAndRender() calls updateLightmap(); set by updateTorchFlicker()
     */
    private boolean lightmapUpdateNeeded;

    /** Torch flicker X */
    private float torchFlickerX;
    private float torchFlickerDX;

    /** Rain sound counter */
    private int rainSoundCounter;
    private float[] rainXCoords;
    private float[] rainYCoords;

    /** Fog color buffer */
    private FloatBuffer fogColorBuffer;
    public float fogColorRed;
    public float fogColorGreen;
    public float fogColorBlue;

    /** Fog color 2 */
    private float fogColor2;

    /** Fog color 1 */
    private float fogColor1;
    private int debugViewDirection;
    private boolean debugView;
    private double cameraZoom;
    private double cameraYaw;
    private double cameraPitch;
    private ShaderGroup theShaderGroup;
    private static final ResourceLocation[] shaderResourceLocations = new ResourceLocation[] {new ResourceLocation("shaders/post/notch.json"), new ResourceLocation("shaders/post/fxaa.json"), new ResourceLocation("shaders/post/art.json"), new ResourceLocation("shaders/post/bumpy.json"), new ResourceLocation("shaders/post/blobs2.json"), new ResourceLocation("shaders/post/pencil.json"), new ResourceLocation("shaders/post/color_convolve.json"), new ResourceLocation("shaders/post/deconverge.json"), new ResourceLocation("shaders/post/flip.json"), new ResourceLocation("shaders/post/invert.json"), new ResourceLocation("shaders/post/ntsc.json"), new ResourceLocation("shaders/post/outline.json"), new ResourceLocation("shaders/post/phosphor.json"), new ResourceLocation("shaders/post/scan_pincushion.json"), new ResourceLocation("shaders/post/sobel.json"), new ResourceLocation("shaders/post/bits.json"), new ResourceLocation("shaders/post/desaturate.json"), new ResourceLocation("shaders/post/green.json"), new ResourceLocation("shaders/post/blur.json"), new ResourceLocation("shaders/post/wobble.json"), new ResourceLocation("shaders/post/blobs.json"), new ResourceLocation("shaders/post/antialias.json"), new ResourceLocation("shaders/post/creeper.json"), new ResourceLocation("shaders/post/spider.json")};
    public static final int shaderCount = shaderResourceLocations.length;
    private int shaderIndex;
    private boolean useShader;
    public int frameCount;
    private static final String __OBFID = "CL_00000947";
    private boolean initialized;
    private World updatedWorld;
    private boolean showDebugInfo;
    public boolean fogStandard;
    private float clipDistance;
    private long lastServerTime;
    private int lastServerTicks;
    private int serverWaitTime;
    private int serverWaitTimeCurrent;
    private float avgServerTimeDiff;
    private float avgServerTickDiff;
    private long lastErrorCheckTimeMs;
    private ShaderGroup[] fxaaShaders;
    public float camRoll;
    public float prevCamRoll;
    public double hitDistance;
    private static final int nZ9yA;

    public EntityRenderer(Minecraft mcIn, IResourceManager resourceManagerIn)
    {
        this.thirdPersonDistance = OBFVAL_kqaNJ.get();
        this.thirdPersonDistanceTemp = OBFVAL_kqaNJ.get();
        this.renderHand = true;
        this.drawBlockOutline = true;
        this.prevFrameTime = Minecraft.getSystemTime();
        this.rainXCoords = new float[OBFVAL_72gXJ.get()];
        this.rainYCoords = new float[OBFVAL_72gXJ.get()];
        this.fogColorBuffer = GLAllocation.createDirectFloatBuffer(OBFVAL_USh2A.get());
        this.debugViewDirection = 0;
        this.debugView = false;
        this.cameraZoom = 1.0D;
        this.initialized = false;
        this.updatedWorld = null;
        this.showDebugInfo = false;
        this.fogStandard = false;
        this.clipDistance = OBFVAL_m7d7j.get();
        this.lastServerTime = 0L;
        this.lastServerTicks = 0;
        this.serverWaitTime = 0;
        this.serverWaitTimeCurrent = 0;
        this.avgServerTimeDiff = 0.0F;
        this.avgServerTickDiff = 0.0F;
        this.lastErrorCheckTimeMs = 0L;
        this.fxaaShaders = new ShaderGroup[OBFVAL_tKDdL.get()];
        this.shaderIndex = shaderCount;
        this.useShader = false;
        this.frameCount = 0;
        this.mc = mcIn;
        this.resourceManager = resourceManagerIn;
        this.itemRenderer = mcIn.getItemRenderer();
        this.theMapItemRenderer = new MapItemRenderer(mcIn.getTextureManager());
        this.lightmapTexture = new DynamicTexture(OBFVAL_USh2A.get(), OBFVAL_USh2A.get());
        this.locationLightMap = mcIn.getTextureManager().getDynamicTextureLocation("lightMap", this.lightmapTexture);
        this.lightmapColors = this.lightmapTexture.getTextureData();
        this.theShaderGroup = null;

        for (int i = 0; i < OBFVAL_FgjKP.get(); ++i)
        {
            for (int j = 0; j < OBFVAL_FgjKP.get(); ++j)
            {
                float f = (float)(j - OBFVAL_USh2A.get());
                float f1 = (float)(i - OBFVAL_USh2A.get());
                float f2 = MathHelper.sqrt_float(f * f + f1 * f1);
                this.rainXCoords[i << OBFVAL_xNbMN.get() | j] = -f1 / f2;
                this.rainYCoords[i << OBFVAL_xNbMN.get() | j] = f / f2;
            }
        }
    }

    public boolean isShaderActive()
    {
        return OpenGlHelper.shadersSupported && this.theShaderGroup != null;
    }

    public void func_181022_b()
    {
        if (this.theShaderGroup != null)
        {
            this.theShaderGroup.deleteShaderGroup();
        }

        this.theShaderGroup = null;
        this.shaderIndex = shaderCount;
    }

    public void switchUseShader()
    {
        this.useShader = !this.useShader;
    }

    /**
     * What shader to use when spectating this entity
     */
    public void loadEntityShader(Entity entityIn)
    {
        if (OpenGlHelper.shadersSupported)
        {
            if (this.theShaderGroup != null)
            {
                this.theShaderGroup.deleteShaderGroup();
            }

            this.theShaderGroup = null;

            if (entityIn instanceof EntityCreeper)
            {
                this.loadShader(new ResourceLocation("shaders/post/creeper.json"));
            }
            else if (entityIn instanceof EntitySpider)
            {
                this.loadShader(new ResourceLocation("shaders/post/spider.json"));
            }
            else if (entityIn instanceof EntityEnderman)
            {
                this.loadShader(new ResourceLocation("shaders/post/invert.json"));
            }
        }
    }

    public void activateNextShader()
    {
        if (OpenGlHelper.shadersSupported && this.mc.getRenderViewEntity() instanceof EntityPlayer)
        {
            if (this.theShaderGroup != null)
            {
                this.theShaderGroup.deleteShaderGroup();
            }

            this.shaderIndex = (this.shaderIndex + 1) % (shaderResourceLocations.length + 1);

            if (this.shaderIndex != shaderCount)
            {
                this.loadShader(shaderResourceLocations[this.shaderIndex]);
            }
            else
            {
                this.theShaderGroup = null;
            }
        }
    }

    private void loadShader(ResourceLocation resourceLocationIn)
    {
        if (OpenGlHelper.isFramebufferEnabled())
        {
            try
            {
                this.theShaderGroup = new ShaderGroup(this.mc.getTextureManager(), this.resourceManager, this.mc.getFramebuffer(), resourceLocationIn);
                this.theShaderGroup.createBindFramebuffers(this.mc.displayWidth, this.mc.displayHeight);
                this.useShader = true;
            }
            catch (IOException ioexception)
            {
                logger.warn((String)("Failed to load shader: " + resourceLocationIn), (Throwable)ioexception);
                this.shaderIndex = shaderCount;
                this.useShader = false;
            }
            catch (JsonSyntaxException jsonsyntaxexception)
            {
                logger.warn((String)("Failed to load shader: " + resourceLocationIn), (Throwable)jsonsyntaxexception);
                this.shaderIndex = shaderCount;
                this.useShader = false;
            }
        }
    }

    public void onResourceManagerReload(IResourceManager resourceManager)
    {
        if (this.theShaderGroup != null)
        {
            this.theShaderGroup.deleteShaderGroup();
        }

        this.theShaderGroup = null;

        if (this.shaderIndex != shaderCount)
        {
            this.loadShader(shaderResourceLocations[this.shaderIndex]);
        }
        else
        {
            this.loadEntityShader(this.mc.getRenderViewEntity());
        }
    }

    /**
     * Updates the entity renderer
     */
    public void updateRenderer()
    {
        if (OpenGlHelper.shadersSupported && ShaderLinkHelper.getStaticShaderLinkHelper() == null)
        {
            ShaderLinkHelper.setNewStaticShaderLinkHelper();
        }

        this.updateFovModifierHand();
        this.updateTorchFlicker();
        this.fogColor2 = this.fogColor1;
        this.thirdPersonDistanceTemp = this.thirdPersonDistance;
        this.prevCamRoll = this.camRoll;

        if (this.mc.gameSettings.smoothCamera)
        {
            float f = this.mc.gameSettings.mouseSensitivity * OBFVAL_Ri74X.get() + OBFVAL_mhpPT.get();
            float f1 = f * f * f * OBFVAL_SNlJC.get();
            this.smoothCamFilterX = this.mouseFilterXAxis.smooth(this.smoothCamYaw, OBFVAL_7sr6W.get() * f1);
            this.smoothCamFilterY = this.mouseFilterYAxis.smooth(this.smoothCamPitch, OBFVAL_7sr6W.get() * f1);
            this.smoothCamPartialTicks = 0.0F;
            this.smoothCamYaw = 0.0F;
            this.smoothCamPitch = 0.0F;
        }
        else
        {
            this.smoothCamFilterX = 0.0F;
            this.smoothCamFilterY = 0.0F;
            this.mouseFilterXAxis.reset();
            this.mouseFilterYAxis.reset();
        }

        if (this.mc.getRenderViewEntity() == null)
        {
            this.mc.setRenderViewEntity(this.mc.thePlayer);
        }

        Entity entity = this.mc.getRenderViewEntity();
        double d2 = entity.posX;
        double d0 = entity.posY + (double)entity.getEyeHeight();
        double d1 = entity.posZ;
        float f2 = this.mc.theWorld.getLightBrightness(new BlockPos(d2, d0, d1));
        float f3 = (float)this.mc.gameSettings.renderDistanceChunks / OBFVAL_qtKgX.get();
        f3 = MathHelper.clamp_float(f3, 0.0F, 1.0F);
        float f4 = f2 * (1.0F - f3) + f3;
        this.fogColor1 += (f4 - this.fogColor1) * OBFVAL_nfhIC.get();
        ++this.rendererUpdateCount;
        this.itemRenderer.updateEquippedItem();
        this.addRainParticles();
        this.bossColorModifierPrev = this.bossColorModifier;

        if (BossStatus.hasColorModifier)
        {
            this.bossColorModifier += OBFVAL_7sr6W.get();

            if (this.bossColorModifier > 1.0F)
            {
                this.bossColorModifier = 1.0F;
            }

            BossStatus.hasColorModifier = false;
        }
        else if (this.bossColorModifier > 0.0F)
        {
            this.bossColorModifier -= OBFVAL_zMn89.get();
        }
    }

    public ShaderGroup getShaderGroup()
    {
        return this.theShaderGroup;
    }

    public void updateShaderGroupSize(int width, int height)
    {
        if (OpenGlHelper.shadersSupported)
        {
            if (this.theShaderGroup != null)
            {
                this.theShaderGroup.createBindFramebuffers(width, height);
            }

            this.mc.renderGlobal.createBindEntityOutlineFbs(width, height);
        }
    }

    /**
     * Finds what block or object the mouse is over at the specified partial tick time. Args: partialTickTime
     */
    public void getMouseOver(float partialTicks)
    {
        nZ9yA = -382170101 * nZ9yA;
        this.hitDistance = OBFVAL_rs6QN.get();
        CamMouseOverHandler.setupMouseHandlerBefore();
        Entity entity = this.mc.getRenderViewEntity();

        if (this.mc.theWorld != null)
        {
            nZ9yA |= -81605353;

            if (entity != null)
            {
                this.mc.mcProfiler.startSection("pick");
                Minecraft minecraft2 = this.mc;
                nZ9yA = -1131191887 - nZ9yA;
                nZ9yA *= nZ9yA;
                minecraft2.pointedEntity = null;
                boolean flag = false;
                nZ9yA = 920742405;
                double d0 = (double)this.mc.playerController.getBlockReachDistance();
                nZ9yA = -21309828 * nZ9yA;
                minecraft2 = this.mc;
                nZ9yA = -nZ9yA;
                nZ9yA += -1480404587;
                minecraft2.objectMouseOver = entity.rayTrace(d0, partialTicks);
                double d1 = d0;
                nZ9yA += 897892460;
                Vec3 eyePos = entity.getPositionEyes(partialTicks);
                nZ9yA += 1876383221;
                nZ9yA ^= -1696736237;
                boolean flag1 = this.mc.playerController.extendedReach();
                nZ9yA += -900408592;

                if (flag1)
                {
                    d0 = OBFVAL_do0DF.get();
                    d1 = OBFVAL_do0DF.get();
                }
                else
                {
                    nZ9yA = 366684666 - nZ9yA;
                    nZ9yA &= -2000591720;
                    flag = true;
                }

                if (this.mc.objectMouseOver != null)
                {
                    nZ9yA &= -963782854;
                    d1 = this.mc.objectMouseOver.hitVec.squareDistanceTo(eyePos);
                }
                else
                {
                    nZ9yA = 1455589345;
                    d1 = d1 * d1;
                }

                Vec3 vec31 = entity.getLook(partialTicks);
                nZ9yA *= -1044711883;
                double d9 = vec31.xCoord;
                nZ9yA += 101197383;
                d9 = d9 * d0;
                nZ9yA *= nZ9yA;
                double d10 = vec31.yCoord;
                nZ9yA += nZ9yA;
                d10 = d10 * d0;
                nZ9yA += nZ9yA;
                double d11 = vec31.zCoord;
                nZ9yA *= nZ9yA;
                Vec3 vec34 = eyePos.addVector(d9, d10, d11 * d0);
                nZ9yA *= nZ9yA;
                Vec3 vec32 = vec34;
                nZ9yA &= 1875677107;
                this.pointedEntity = null;
                Vec3 hitPos = null;
                nZ9yA &= -1050483132;
                nZ9yA *= 558316908;
                double distanceToEntity = d1;
                nZ9yA |= -1561288080;
                float f = 1.0F;
                WorldClient worldclient = this.mc.theWorld;
                AxisAlignedBB axisalignedbb2 = entity.getEntityBoundingBox();
                d11 = vec31.xCoord * d0;
                nZ9yA &= -1852607065;
                double d12 = vec31.yCoord * d0;
                nZ9yA -= -539713380;
                double d13 = vec31.zCoord * d0;
                nZ9yA *= nZ9yA;
                axisalignedbb2 = axisalignedbb2.addCoord(d11, d12, d13);
                d11 = (double)f;
                d12 = (double)f;
                nZ9yA -= 24195151;
                d13 = (double)f;
                nZ9yA ^= 1423229916;
                axisalignedbb2 = axisalignedbb2.expand(d11, d12, d13);
                Predicate predicate = EntitySelectors.NOT_SPECTATING;
                Predicate predicate1 = Entity::canBeCollidedWith;
                nZ9yA += 639533972;
                List<Entity> list = worldclient.getEntitiesInAABBexcluding(entity, axisalignedbb2, Predicates.and(predicate, predicate1));
                Iterator distance = list.iterator();

                while (true)
                {
                    nZ9yA += nZ9yA;

                    if (!distance.hasNext())
                    {
                        boolean flag2 = this.mc.playerController.isInCreativeMode();
                        nZ9yA = 784475299;

                        if (!flag2)
                        {
                            Entity entity2 = this.pointedEntity;
                            nZ9yA = -nZ9yA;

                            if (entity2 != null)
                            {
                                double d6 = eyePos.squareDistanceTo(hitPos);
                                nZ9yA += -2084987798;
                                this.hitDistance = d6;
                                nZ9yA |= -440380025;
                                double d4 = d6;
                                ObfValue.ODouble obfvalue$odouble = OBFVAL_GavSc;
                                nZ9yA ^= -773429702;

                                if (d4 > obfvalue$odouble.get())
                                {
                                    nZ9yA = -707181267 * nZ9yA;
                                    this.mc.objectMouseOver = new MovingObjectPosition(MovingObjectPosition.MovingObjectType.MISS, hitPos, (EnumFacing)null, new BlockPos(hitPos));
                                    nZ9yA = -nZ9yA;
                                    nZ9yA += nZ9yA;
                                    this.pointedEntity = null;
                                    nZ9yA *= nZ9yA;
                                }
                            }
                        }

                        nZ9yA += nZ9yA;
                        Entity entity3 = this.pointedEntity;
                        nZ9yA *= -198814382;

                        if (entity3 != null)
                        {
                            label1166:
                            {
                                if (distanceToEntity >= d1)
                                {
                                    nZ9yA ^= 968343927;

                                    if (this.mc.objectMouseOver != null)
                                    {
                                        break label1166;
                                    }
                                }

                                Minecraft minecraft = this.mc;
                                nZ9yA |= -1626045232;
                                minecraft.objectMouseOver = new MovingObjectPosition(this.pointedEntity, hitPos);
                                Entity entity4 = this.pointedEntity;
                                nZ9yA = 1921165156;
                                boolean flag3 = entity4 instanceof EntityLivingBase;
                                nZ9yA = -nZ9yA;

                                if (flag3 || this.pointedEntity instanceof EntityItemFrame)
                                {
                                    nZ9yA ^= 1962183952;
                                    nZ9yA = -nZ9yA;
                                    Minecraft minecraft1 = this.mc;
                                    Entity entity5 = this.pointedEntity;
                                    nZ9yA ^= 1854586948;
                                    minecraft1.pointedEntity = entity5;
                                }
                            }
                        }

                        this.mc.mcProfiler.endSection();
                        break;
                    }

                    nZ9yA |= 1472811359;
                    Entity entity1 = (Entity)distance.next();
                    float f1 = entity1.getCollisionBorderSize();
                    nZ9yA *= nZ9yA;
                    AxisAlignedBB axisalignedbb1 = entity1.getEntityBoundingBox();
                    d9 = (double)f1;
                    double d5 = (double)f1;
                    nZ9yA ^= -1840164526;
                    nZ9yA += -340953039;
                    double d7 = (double)f1;
                    nZ9yA += nZ9yA;
                    AxisAlignedBB axisalignedbb = axisalignedbb1.expand(d9, d5, d7);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(eyePos, vec32);
                    nZ9yA += nZ9yA;
                    MovingObjectPosition movingobjectposition = movingobjectposition1;
                    nZ9yA *= -1003826862;

                    if (axisalignedbb.isVecInside(eyePos))
                    {
                        nZ9yA += nZ9yA;

                        if (distanceToEntity >= 0.0D)
                        {
                            nZ9yA ^= 1169313209;
                            this.pointedEntity = entity1;
                            nZ9yA *= 1898851347;
                            Vec3 vec36;

                            if (movingobjectposition == null)
                            {
                                vec36 = eyePos;
                            }
                            else
                            {
                                nZ9yA = -73539759 * nZ9yA;
                                vec36 = movingobjectposition.hitVec;
                                nZ9yA = -nZ9yA;
                            }

                            hitPos = vec36;
                            nZ9yA ^= -863558654;
                            nZ9yA = -nZ9yA;
                            distanceToEntity = 0.0D;
                        }
                    }
                    else
                    {
                        nZ9yA = -nZ9yA;

                        if (movingobjectposition != null)
                        {
                            Vec3 vec37 = movingobjectposition.hitVec;
                            nZ9yA = -nZ9yA;
                            double d3 = eyePos.squareDistanceTo(vec37);

                            if (d3 < distanceToEntity || distanceToEntity == 0.0D)
                            {
                                if (entity1 == entity.ridingEntity)
                                {
                                    double d8;
                                    int i = (d8 = distanceToEntity - 0.0D) == 0.0D ? 0 : (d8 < 0.0D ? -1 : 1);
                                    nZ9yA = 421324287 - nZ9yA;

                                    if (i == 0)
                                    {
                                        this.pointedEntity = entity1;
                                        nZ9yA ^= -1170423810;
                                        Vec3 vec35 = movingobjectposition.hitVec;
                                        nZ9yA = -nZ9yA;
                                        hitPos = vec35;
                                    }
                                }
                                else
                                {
                                    nZ9yA &= -2029556169;
                                    this.pointedEntity = entity1;
                                    nZ9yA += -726508511;
                                    hitPos = movingobjectposition.hitVec;
                                    distanceToEntity = d3;
                                }
                            }
                        }
                    }
                }
            }
        }

        CamMouseOverHandler.setupMouseHandlerAfter();
    }

    /**
     * Update FOV modifier hand
     */
    private void updateFovModifierHand()
    {
        float float = 1.0F;

        if (this.mc.getRenderViewEntity() instanceof AbstractClientPlayer)
        {
            AbstractClientPlayer abstractclientplayer = (AbstractClientPlayer)this.mc.getRenderViewEntity();
            float = abstractclientplayer.getFovModifier();
        }

        this.fovModifierHandPrev = this.fovModifierHand;
        this.fovModifierHand += (float - this.fovModifierHand) * OBFVAL_b8UoI.get();

        if (this.fovModifierHand > OBFVAL_6xnuP.get())
        {
            this.fovModifierHand = OBFVAL_6xnuP.get();
        }

        if (this.fovModifierHand < OBFVAL_nfhIC.get())
        {
            this.fovModifierHand = OBFVAL_nfhIC.get();
        }
    }

    /**
     * Changes the field of view of the player depending on if they are underwater or not
     */
    private float getFOVModifier(float partialTicks, boolean p_78481_2_)
    {
        if (this.debugView)
        {
            return OBFVAL_6GjzO.get();
        }
        else
        {
            Entity entity = this.mc.getRenderViewEntity();
            float float = OBFVAL_UjWd3.get();

            if (p_78481_2_)
            {
                float = this.mc.gameSettings.fovSetting;

                if (Config.isDynamicFov())
                {
                    float *= this.fovModifierHandPrev + (this.fovModifierHand - this.fovModifierHandPrev) * partialTicks;
                }
            }

            boolean boolean = false;

            if (this.mc.currentScreen == null)
            {
                boolean = this.mc.gameSettings.ofKeyBindZoom.isKeyDown();
            }

            if (boolean)
            {
                if (!Config.zoomMode)
                {
                    Config.zoomMode = true;
                    this.mc.gameSettings.smoothCamera = true;
                }

                if (Config.zoomMode)
                {
                    float /= OBFVAL_kqaNJ.get();
                }
            }
            else if (Config.zoomMode)
            {
                Config.zoomMode = false;
                this.mc.gameSettings.smoothCamera = false;
                this.mouseFilterXAxis = new MouseFilter();
                this.mouseFilterYAxis = new MouseFilter();
                this.mc.renderGlobal.displayListEntitiesDirty = true;
            }

            if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).getHealth() <= 0.0F)
            {
                float float = (float)((EntityLivingBase)entity).deathTime + partialTicks;
                float /= (1.0F - OBFVAL_W9ZvG.get() / (float + OBFVAL_W9ZvG.get())) * OBFVAL_lacQB.get() + 1.0F;
            }

            Block block = ActiveRenderInfo.getBlockAtEntityViewpoint(this.mc.theWorld, entity, partialTicks);

            if (block.getMaterial() == Material.water)
            {
                float = float * OBFVAL_nQK2S.get() / OBFVAL_UjWd3.get();
            }

            return float;
        }
    }

    private void hurtCameraEffect(float partialTicks)
    {
        if (this.mc.getRenderViewEntity() instanceof EntityLivingBase)
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)this.mc.getRenderViewEntity();
            float float = (float)entitylivingbase.hurtTime - partialTicks;

            if (entitylivingbase.getHealth() <= 0.0F)
            {
                float float = (float)entitylivingbase.deathTime + partialTicks;
                GlStateManager.rotate(OBFVAL_tY6pR.get() - OBFVAL_MyYU3.get() / (float + OBFVAL_j4Aqa.get()), 0.0F, 0.0F, 1.0F);
            }

            if (float < 0.0F)
            {
                return;
            }

            float = float / (float)entitylivingbase.maxHurtTime;
            float = MathHelper.sin(float * float * float * float * OBFVAL_qOaKl.get());
            float float = entitylivingbase.attackedAtYaw;
            GlStateManager.rotate(-float, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(-float * OBFVAL_mgd5c.get(), 0.0F, 0.0F, 1.0F);
            GlStateManager.rotate(float, 0.0F, 1.0F, 0.0F);
        }
    }

    /**
     * Setups all the GL settings for view bobbing. Args: partialTickTime
     */
    private void setupViewBobbing(float partialTicks)
    {
        if (this.mc.getRenderViewEntity() instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)this.mc.getRenderViewEntity();
            float float = entityplayer.distanceWalkedModified - entityplayer.prevDistanceWalkedModified;
            float float = -(entityplayer.distanceWalkedModified + float * partialTicks);
            float float = entityplayer.prevCameraYaw + (entityplayer.cameraYaw - entityplayer.prevCameraYaw) * partialTicks;
            float float = entityplayer.prevCameraPitch + (entityplayer.cameraPitch - entityplayer.prevCameraPitch) * partialTicks;
            GlStateManager.translate(MathHelper.sin(float * OBFVAL_qOaKl.get()) * float * OBFVAL_b8UoI.get(), -Math.abs(MathHelper.cos(float * OBFVAL_qOaKl.get()) * float), 0.0F);
            GlStateManager.rotate(MathHelper.sin(float * OBFVAL_qOaKl.get()) * float * OBFVAL_TFMYx.get(), 0.0F, 0.0F, 1.0F);
            GlStateManager.rotate(Math.abs(MathHelper.cos(float * OBFVAL_qOaKl.get() - OBFVAL_mhpPT.get()) * float) * OBFVAL_HAhWr.get(), 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(float, 1.0F, 0.0F, 0.0F);
        }
    }

    /**
     * sets up player's eye (or camera in third person mode)
     */
    private void orientCamera(float partialTicks)
    {
        Entity entity = this.mc.getRenderViewEntity();
        float float = entity.getEyeHeight();
        double double = entity.prevPosX + (entity.posX - entity.prevPosX) * (double)partialTicks;
        double double = entity.prevPosY + (entity.posY - entity.prevPosY) * (double)partialTicks + (double)float;
        double double = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)partialTicks;
        float float = this.prevCamRoll + (this.camRoll - this.prevCamRoll) * partialTicks;

        if (float != 0.0F)
        {
            GL11.glRotatef(float, 0.0F, 0.0F, 1.0F);
        }

        if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPlayerSleeping())
        {
            float = (float)((double)float + 1.0D);
            GlStateManager.translate(0.0F, OBFVAL_xgpCA.get(), 0.0F);

            if (!this.mc.gameSettings.debugCamEnable)
            {
                BlockPos blockpos = new BlockPos(entity);
                IBlockState iblockstate = this.mc.theWorld.getBlockState(blockpos);
                Block block = iblockstate.getBlock();

                if (block == Blocks.bed)
                {
                    int int = ((EnumFacing)iblockstate.getValue(BlockBed.FACING)).getHorizontalIndex();
                    GlStateManager.rotate((float)(int * OBFVAL_uiG6j.get()), 0.0F, 1.0F, 0.0F);
                }

                GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks + OBFVAL_JnPc7.get(), 0.0F, OBFVAL_ZQrgv.get(), 0.0F);
                GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, OBFVAL_ZQrgv.get(), 0.0F, 0.0F);
            }
        }
        else if (this.mc.gameSettings.thirdPersonView > 0)
        {
            double double = (double)(this.thirdPersonDistanceTemp + (this.thirdPersonDistance - this.thirdPersonDistanceTemp) * partialTicks);

            if (this.mc.gameSettings.debugCamEnable)
            {
                GlStateManager.translate(0.0F, 0.0F, (float)(-double));
            }
            else
            {
                float float = entity.rotationYaw;
                float float = entity.rotationPitch;

                if (this.mc.gameSettings.thirdPersonView == OBFVAL_zejjh.get())
                {
                    float += OBFVAL_JnPc7.get();
                }

                double double = (double)(-MathHelper.sin(float / OBFVAL_JnPc7.get() * OBFVAL_qOaKl.get()) * MathHelper.cos(float / OBFVAL_JnPc7.get() * OBFVAL_qOaKl.get())) * double;
                double double = (double)(MathHelper.cos(float / OBFVAL_JnPc7.get() * OBFVAL_qOaKl.get()) * MathHelper.cos(float / OBFVAL_JnPc7.get() * OBFVAL_qOaKl.get())) * double;
                double double = (double)(-MathHelper.sin(float / OBFVAL_JnPc7.get() * OBFVAL_qOaKl.get())) * double;

                for (int int = 0; int < OBFVAL_Jgz4S.get(); ++int)
                {
                    float float = (float)((int & 1) * OBFVAL_zejjh.get() - 1);
                    float float = (float)((int >> 1 & 1) * OBFVAL_zejjh.get() - 1);
                    float float = (float)((int >> OBFVAL_zejjh.get() & 1) * OBFVAL_zejjh.get() - 1);
                    float = float * OBFVAL_nfhIC.get();
                    float = float * OBFVAL_nfhIC.get();
                    float = float * OBFVAL_nfhIC.get();
                    MovingObjectPosition movingobjectposition = this.mc.theWorld.rayTraceBlocks(new Vec3(double + (double)float, double + (double)float, double + (double)float), new Vec3(double - double + (double)float + (double)float, double - double + (double)float, double - double + (double)float));

                    if (movingobjectposition != null)
                    {
                        double double = movingobjectposition.hitVec.distanceTo(new Vec3(double, double, double));

                        if (double < double)
                        {
                            double = double;
                        }
                    }
                }

                if (this.mc.gameSettings.thirdPersonView == OBFVAL_zejjh.get())
                {
                    GlStateManager.rotate(OBFVAL_JnPc7.get(), 0.0F, 1.0F, 0.0F);
                }

                GlStateManager.rotate(entity.rotationPitch - float, 1.0F, 0.0F, 0.0F);
                GlStateManager.rotate(entity.rotationYaw - float, 0.0F, 1.0F, 0.0F);
                GlStateManager.translate(0.0F, 0.0F, (float)(-double));
                GlStateManager.rotate(float - entity.rotationYaw, 0.0F, 1.0F, 0.0F);
                GlStateManager.rotate(float - entity.rotationPitch, 1.0F, 0.0F, 0.0F);
            }
        }
        else
        {
            GlStateManager.translate(0.0F, 0.0F, OBFVAL_USYnj.get());
        }

        if (!this.mc.gameSettings.debugCamEnable)
        {
            GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 1.0F, 0.0F, 0.0F);

            if (entity instanceof EntityAnimal)
            {
                EntityAnimal entityanimal = (EntityAnimal)entity;
                GlStateManager.rotate(entityanimal.prevRotationYawHead + (entityanimal.rotationYawHead - entityanimal.prevRotationYawHead) * partialTicks + OBFVAL_JnPc7.get(), 0.0F, 1.0F, 0.0F);
            }
            else
            {
                GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks + OBFVAL_JnPc7.get(), 0.0F, 1.0F, 0.0F);
            }
        }

        GlStateManager.translate(0.0F, -float, 0.0F);
        double = entity.prevPosX + (entity.posX - entity.prevPosX) * (double)partialTicks;
        double = entity.prevPosY + (entity.posY - entity.prevPosY) * (double)partialTicks + (double)float;
        double = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)partialTicks;
        this.cloudFog = this.mc.renderGlobal.hasCloudFog(double, double, double, partialTicks);
    }

    /**
     * sets up projection, view effects, camera position/rotation
     */
    public void setupCameraTransform(float partialTicks, int pass)
    {
        this.farPlaneDistance = (float)(this.mc.gameSettings.renderDistanceChunks * OBFVAL_USh2A.get());

        if (Config.isFogFancy())
        {
            this.farPlaneDistance *= OBFVAL_wXzmu.get();
        }

        if (Config.isFogFast())
        {
            this.farPlaneDistance *= OBFVAL_U9DUZ.get();
        }

        GlStateManager.matrixMode(OBFVAL_Yojsk.get());
        GlStateManager.loadIdentity();
        float float = OBFVAL_GEV3d.get();

        if (this.mc.gameSettings.anaglyph)
        {
            GlStateManager.translate((float)(-(pass * OBFVAL_zejjh.get() - 1)) * float, 0.0F, 0.0F);
        }

        this.clipDistance = this.farPlaneDistance * OBFVAL_lacQB.get();

        if (this.clipDistance < OBFVAL_KNHYB.get())
        {
            this.clipDistance = OBFVAL_KNHYB.get();
        }

        if (this.mc.theWorld.provider.getDimensionId() == 1)
        {
            this.clipDistance = OBFVAL_psDxT.get();
        }

        if (this.cameraZoom != 1.0D)
        {
            GlStateManager.translate((float)this.cameraYaw, (float)(-this.cameraPitch), 0.0F);
            GlStateManager.scale(this.cameraZoom, this.cameraZoom, 1.0D);
        }

        Project.gluPerspective(this.getFOVModifier(partialTicks, true), (float)this.mc.displayWidth / (float)this.mc.displayHeight, OBFVAL_7sr6W.get(), this.clipDistance);
        GlStateManager.matrixMode(OBFVAL_Rmm83.get());
        GlStateManager.loadIdentity();

        if (this.mc.gameSettings.anaglyph)
        {
            GlStateManager.translate((float)(pass * OBFVAL_zejjh.get() - 1) * OBFVAL_nfhIC.get(), 0.0F, 0.0F);
        }

        this.hurtCameraEffect(partialTicks);

        if (this.mc.gameSettings.viewBobbing)
        {
            this.setupViewBobbing(partialTicks);
        }

        float float = this.mc.thePlayer.prevTimeInPortal + (this.mc.thePlayer.timeInPortal - this.mc.thePlayer.prevTimeInPortal) * partialTicks;

        if (float > 0.0F)
        {
            byte byte = (byte)OBFVAL_mvI7p.get();

            if (this.mc.thePlayer.isPotionActive(Potion.confusion))
            {
                byte = (byte)OBFVAL_MNK0g.get();
            }

            float float = OBFVAL_HAhWr.get() / (float * float + OBFVAL_HAhWr.get()) - float * OBFVAL_qiL0r.get();
            float = float * float;
            GlStateManager.rotate(((float)this.rendererUpdateCount + partialTicks) * (float)byte, 0.0F, 1.0F, 1.0F);
            GlStateManager.scale(1.0F / float, 1.0F, 1.0F);
            GlStateManager.rotate(-((float)this.rendererUpdateCount + partialTicks) * (float)byte, 0.0F, 1.0F, 1.0F);
        }

        this.orientCamera(partialTicks);

        if (this.debugView)
        {
            switch (this.debugViewDirection)
            {
                case 0:
                    GlStateManager.rotate(OBFVAL_6GjzO.get(), 0.0F, 1.0F, 0.0F);
                    break;

                case 1:
                    GlStateManager.rotate(OBFVAL_JnPc7.get(), 0.0F, 1.0F, 0.0F);
                    break;

                case 2:
                    GlStateManager.rotate(OBFVAL_tHt21.get(), 0.0F, 1.0F, 0.0F);
                    break;

                case 3:
                    GlStateManager.rotate(OBFVAL_6GjzO.get(), 1.0F, 0.0F, 0.0F);
                    break;

                case 4:
                    GlStateManager.rotate(OBFVAL_tHt21.get(), 1.0F, 0.0F, 0.0F);
            }
        }
    }

    /**
     * Render player hand
     */
    private void renderHand(float partialTicks, int xOffset)
    {
        this.renderHand(partialTicks, xOffset, true, true, false);
    }

    public void renderHand(float p_renderHand_1_, int p_renderHand_2_, boolean p_renderHand_3_, boolean p_renderHand_4_, boolean p_renderHand_5_)
    {
        if (!this.debugView)
        {
            GlStateManager.matrixMode(OBFVAL_Yojsk.get());
            GlStateManager.loadIdentity();
            float float = OBFVAL_GEV3d.get();

            if (this.mc.gameSettings.anaglyph)
            {
                GlStateManager.translate((float)(-(p_renderHand_2_ * OBFVAL_zejjh.get() - 1)) * float, 0.0F, 0.0F);
            }

            if (Config.isShaders())
            {
                Shaders.applyHandDepth();
            }

            Project.gluPerspective(this.getFOVModifier(p_renderHand_1_, false), (float)this.mc.displayWidth / (float)this.mc.displayHeight, OBFVAL_7sr6W.get(), this.farPlaneDistance * OBFVAL_lacQB.get());
            GlStateManager.matrixMode(OBFVAL_Rmm83.get());
            GlStateManager.loadIdentity();

            if (this.mc.gameSettings.anaglyph)
            {
                GlStateManager.translate((float)(p_renderHand_2_ * OBFVAL_zejjh.get() - 1) * OBFVAL_nfhIC.get(), 0.0F, 0.0F);
            }

            boolean boolean = false;

            if (p_renderHand_3_)
            {
                GlStateManager.pushMatrix();
                this.hurtCameraEffect(p_renderHand_1_);

                if (this.mc.gameSettings.viewBobbing)
                {
                    this.setupViewBobbing(p_renderHand_1_);
                }

                boolean = this.mc.getRenderViewEntity() instanceof EntityLivingBase && ((EntityLivingBase)this.mc.getRenderViewEntity()).isPlayerSleeping();

                if (this.mc.gameSettings.thirdPersonView == 0 && !boolean && !this.mc.gameSettings.hideGUI && !this.mc.playerController.isSpectator())
                {
                    this.enableLightmap();

                    if (Config.isShaders())
                    {
                        ShadersRender.renderItemFP(this.itemRenderer, p_renderHand_1_, p_renderHand_5_);
                    }
                    else
                    {
                        this.itemRenderer.renderItemInFirstPerson(p_renderHand_1_);
                    }

                    this.disableLightmap();
                }

                GlStateManager.popMatrix();
            }

            if (!p_renderHand_4_)
            {
                return;
            }

            this.disableLightmap();

            if (this.mc.gameSettings.thirdPersonView == 0 && !boolean)
            {
                this.itemRenderer.renderOverlays(p_renderHand_1_);
                this.hurtCameraEffect(p_renderHand_1_);
            }

            if (this.mc.gameSettings.viewBobbing)
            {
                this.setupViewBobbing(p_renderHand_1_);
            }
        }
    }

    public void disableLightmap()
    {
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);

        if (Config.isShaders())
        {
            Shaders.disableLightmap();
        }
    }

    public void enableLightmap()
    {
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.matrixMode(OBFVAL_hDkLE.get());
        GlStateManager.loadIdentity();
        float float = OBFVAL_5IxBj.get();
        GlStateManager.scale(float, float, float);
        GlStateManager.translate(OBFVAL_SNlJC.get(), OBFVAL_SNlJC.get(), OBFVAL_SNlJC.get());
        GlStateManager.matrixMode(OBFVAL_Rmm83.get());
        this.mc.getTextureManager().bindTexture(this.locationLightMap);
        GL11.glTexParameteri(OBFVAL_hTQvU.get(), OBFVAL_WkaJq.get(), OBFVAL_TOaMY.get());
        GL11.glTexParameteri(OBFVAL_hTQvU.get(), OBFVAL_3Dp0s.get(), OBFVAL_TOaMY.get());
        GL11.glTexParameteri(OBFVAL_hTQvU.get(), OBFVAL_8ZWHW.get(), OBFVAL_1iYyQ.get());
        GL11.glTexParameteri(OBFVAL_hTQvU.get(), OBFVAL_8JLrR.get(), OBFVAL_1iYyQ.get());
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);

        if (Config.isShaders())
        {
            Shaders.enableLightmap();
        }
    }

    /**
     * Recompute a random value that is applied to block color in updateLightmap()
     */
    private void updateTorchFlicker()
    {
        this.torchFlickerDX = (float)((double)this.torchFlickerDX + (Math.random() - Math.random()) * Math.random() * Math.random());
        this.torchFlickerDX = (float)((double)this.torchFlickerDX * OBFVAL_zccFq.get());
        this.torchFlickerX += (this.torchFlickerDX - this.torchFlickerX) * 1.0F;
        this.lightmapUpdateNeeded = true;
    }

    private void updateLightmap(float partialTicks)
    {
        if (this.lightmapUpdateNeeded)
        {
            this.mc.mcProfiler.startSection("lightTex");
            WorldClient worldclient = this.mc.theWorld;

            if (worldclient != null)
            {
                if (Config.isCustomColors() && CustomColors.updateLightmap(worldclient, this.torchFlickerX, this.lightmapColors, this.mc.thePlayer.isPotionActive(Potion.nightVision)))
                {
                    this.lightmapTexture.updateDynamicTexture();
                    this.lightmapUpdateNeeded = false;
                    this.mc.mcProfiler.endSection();
                    return;
                }

                float float = worldclient.getSunBrightness(1.0F);
                float float = float * OBFVAL_wXzmu.get() + OBFVAL_7sr6W.get();

                for (int int = 0; int < OBFVAL_qbi68.get(); ++int)
                {
                    float float = worldclient.provider.getLightBrightnessTable()[int / OBFVAL_USh2A.get()] * float;
                    float float = worldclient.provider.getLightBrightnessTable()[int % OBFVAL_USh2A.get()] * (this.torchFlickerX * OBFVAL_nfhIC.get() + OBFVAL_6xnuP.get());

                    if (worldclient.getLastLightningBolt() > 0)
                    {
                        float = worldclient.provider.getLightBrightnessTable()[int / OBFVAL_USh2A.get()];
                    }

                    float float = float * (float * OBFVAL_CVKmX.get() + OBFVAL_0cIV7.get());
                    float float = float * (float * OBFVAL_CVKmX.get() + OBFVAL_0cIV7.get());
                    float float = float * ((float * OBFVAL_Ri74X.get() + OBFVAL_2dGYR.get()) * OBFVAL_Ri74X.get() + OBFVAL_2dGYR.get());
                    float float = float * (float * float * OBFVAL_Ri74X.get() + OBFVAL_2dGYR.get());
                    float float = float + float;
                    float float = float + float;
                    float float = float + float;
                    float = float * OBFVAL_TtfOV.get() + OBFVAL_Nn6nB.get();
                    float = float * OBFVAL_TtfOV.get() + OBFVAL_Nn6nB.get();
                    float = float * OBFVAL_TtfOV.get() + OBFVAL_Nn6nB.get();

                    if (this.bossColorModifier > 0.0F)
                    {
                        float float = this.bossColorModifierPrev + (this.bossColorModifier - this.bossColorModifierPrev) * partialTicks;
                        float = float * (1.0F - float) + float * OBFVAL_QAIST.get() * float;
                        float = float * (1.0F - float) + float * OBFVAL_Ri74X.get() * float;
                        float = float * (1.0F - float) + float * OBFVAL_Ri74X.get() * float;
                    }

                    if (worldclient.provider.getDimensionId() == 1)
                    {
                        float = OBFVAL_StqCW.get() + float * OBFVAL_l3q7D.get();
                        float = OBFVAL_kWvDd.get() + float * OBFVAL_l3q7D.get();
                        float = OBFVAL_3hWJt.get() + float * OBFVAL_l3q7D.get();
                    }

                    if (this.mc.thePlayer.isPotionActive(Potion.nightVision))
                    {
                        float float = this.getNightVisionBrightness(this.mc.thePlayer, partialTicks);
                        float float = 1.0F / float;

                        if (float > 1.0F / float)
                        {
                            float = 1.0F / float;
                        }

                        if (float > 1.0F / float)
                        {
                            float = 1.0F / float;
                        }

                        float = float * (1.0F - float) + float * float * float;
                        float = float * (1.0F - float) + float * float * float;
                        float = float * (1.0F - float) + float * float * float;
                    }

                    if (float > 1.0F)
                    {
                        float = 1.0F;
                    }

                    if (float > 1.0F)
                    {
                        float = 1.0F;
                    }

                    if (float > 1.0F)
                    {
                        float = 1.0F;
                    }

                    float float = Config.limitTo1(this.mc.gameSettings.gammaSetting);
                    float float = 1.0F - float;
                    float float = 1.0F - float;
                    float float = 1.0F - float;
                    float = 1.0F - float * float * float * float;
                    float = 1.0F - float * float * float * float;
                    float = 1.0F - float * float * float * float;
                    float = float * (1.0F - float) + float * float;
                    float = float * (1.0F - float) + float * float;
                    float = float * (1.0F - float) + float * float;
                    float = float * OBFVAL_TtfOV.get() + OBFVAL_Nn6nB.get();
                    float = float * OBFVAL_TtfOV.get() + OBFVAL_Nn6nB.get();
                    float = float * OBFVAL_TtfOV.get() + OBFVAL_Nn6nB.get();

                    if (float > 1.0F)
                    {
                        float = 1.0F;
                    }

                    if (float > 1.0F)
                    {
                        float = 1.0F;
                    }

                    if (float > 1.0F)
                    {
                        float = 1.0F;
                    }

                    if (float < 0.0F)
                    {
                        float = 0.0F;
                    }

                    if (float < 0.0F)
                    {
                        float = 0.0F;
                    }

                    if (float < 0.0F)
                    {
                        float = 0.0F;
                    }

                    short short = (short)OBFVAL_32ZJz.get();
                    int int = (int)(float * OBFVAL_7MBn1.get());
                    int int = (int)(float * OBFVAL_7MBn1.get());
                    int int = (int)(float * OBFVAL_7MBn1.get());
                    this.lightmapColors[int] = short << OBFVAL_yzjb8.get() | int << OBFVAL_USh2A.get() | int << OBFVAL_Jgz4S.get() | int;
                }

                this.lightmapTexture.updateDynamicTexture();
                this.lightmapUpdateNeeded = false;
                this.mc.mcProfiler.endSection();
            }
        }
    }

    public float getNightVisionBrightness(EntityLivingBase entitylivingbaseIn, float partialTicks)
    {
        int int = entitylivingbaseIn.getActivePotionEffect(Potion.nightVision).getDuration();
        return int > OBFVAL_l7o1g.get() ? 1.0F : OBFVAL_QAIST.get() + MathHelper.sin(((float)int - partialTicks) * OBFVAL_qOaKl.get() * OBFVAL_mhpPT.get()) * OBFVAL_xgpCA.get();
    }

    public void func_181560_a(float p_181560_1_, long p_181560_2_)
    {
        this.frameInit();
        boolean boolean = Display.isActive();

        if (!boolean && this.mc.gameSettings.pauseOnLostFocus && (!this.mc.gameSettings.touchscreen || !Mouse.isButtonDown(1)))
        {
            if (Minecraft.getSystemTime() - this.prevFrameTime > OBFVAL_uqLid.get())
            {
                this.mc.displayInGameMenu();
            }
        }
        else
        {
            this.prevFrameTime = Minecraft.getSystemTime();
        }

        this.mc.mcProfiler.startSection("mouse");

        if (boolean && Minecraft.isRunningOnMac && this.mc.inGameHasFocus && !Mouse.isInsideWindow())
        {
            Mouse.setGrabbed(false);
            Mouse.setCursorPosition(Display.getWidth() / OBFVAL_zejjh.get(), Display.getHeight() / OBFVAL_zejjh.get());
            Mouse.setGrabbed(true);
        }

        if (this.mc.inGameHasFocus && boolean)
        {
            this.mc.mouseHelper.mouseXYChange();
            float float = this.mc.gameSettings.mouseSensitivity * OBFVAL_Ri74X.get() + OBFVAL_mhpPT.get();
            float float = float * float * float * OBFVAL_SNlJC.get();
            float float = (float)this.mc.mouseHelper.deltaX * float;
            float float = (float)this.mc.mouseHelper.deltaY * float;
            byte byte = 1;

            if (this.mc.gameSettings.invertMouse)
            {
                byte = -1;
            }

            if (this.mc.gameSettings.smoothCamera)
            {
                this.smoothCamYaw += float;
                this.smoothCamPitch += float;
                float float = p_181560_1_ - this.smoothCamPartialTicks;
                this.smoothCamPartialTicks = p_181560_1_;
                float = this.smoothCamFilterX * float;
                float = this.smoothCamFilterY * float;
                this.mc.thePlayer.setAngles(float, float * (float)byte);
            }
            else
            {
                this.smoothCamYaw = 0.0F;
                this.smoothCamPitch = 0.0F;
                this.mc.thePlayer.setAngles(float, float * (float)byte);
            }
        }

        this.mc.mcProfiler.endSection();

        if (!this.mc.skipRenderWorld)
        {
            anaglyphEnable = this.mc.gameSettings.anaglyph;
            final ScaledResolution scaledresolution = new ScaledResolution(this.mc);
            int int = scaledresolution.getScaledWidth();
            int int = scaledresolution.getScaledHeight();
            final int int = Mouse.getX() * int / this.mc.displayWidth;
            final int int = int - Mouse.getY() * int / this.mc.displayHeight - 1;
            int int = this.mc.gameSettings.limitFramerate;

            if (this.mc.theWorld != null)
            {
                this.mc.mcProfiler.startSection("level");
                int int = Math.min(Minecraft.getDebugFPS(), int);
                int = Math.max(int, OBFVAL_z7Ixz.get());
                long long = System.nanoTime() - p_181560_2_;
                long long = Math.max((long)(OBFVAL_PICz1.get() / int / OBFVAL_fOuzA.get()) - long, 0L);
                this.renderWorld(p_181560_1_, System.nanoTime() + long);

                if (OpenGlHelper.shadersSupported)
                {
                    this.mc.renderGlobal.renderEntityOutlineFramebuffer();

                    if (this.theShaderGroup != null && this.useShader)
                    {
                        GlStateManager.matrixMode(OBFVAL_hDkLE.get());
                        GlStateManager.pushMatrix();
                        GlStateManager.loadIdentity();
                        this.theShaderGroup.loadShaderGroup(p_181560_1_);
                        GlStateManager.popMatrix();
                    }

                    this.mc.getFramebuffer().bindFramebuffer(true);
                }

                this.renderEndNanoTime = System.nanoTime();
                this.mc.mcProfiler.endStartSection("gui");

                if (!this.mc.gameSettings.hideGUI || this.mc.currentScreen != null)
                {
                    GlStateManager.alphaFunc(OBFVAL_VXuQ4.get(), OBFVAL_nfhIC.get());
                    this.mc.ingameGUI.renderGameOverlay(p_181560_1_);

                    if (this.mc.gameSettings.ofShowFps && !this.mc.gameSettings.showDebugInfo)
                    {
                        Config.drawFps();
                    }

                    if (this.mc.gameSettings.showDebugInfo)
                    {
                        Lagometer.showLagometer(scaledresolution);
                    }
                }

                this.mc.mcProfiler.endSection();
            }
            else
            {
                GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
                GlStateManager.matrixMode(OBFVAL_Yojsk.get());
                GlStateManager.loadIdentity();
                GlStateManager.matrixMode(OBFVAL_Rmm83.get());
                GlStateManager.loadIdentity();
                this.setupOverlayRendering();
                this.renderEndNanoTime = System.nanoTime();
                TileEntityRendererDispatcher.instance.renderEngine = this.mc.getTextureManager();
            }

            if (this.mc.currentScreen != null)
            {
                GlStateManager.clear(OBFVAL_qbi68.get());

                try
                {
                    this.mc.currentScreen.drawScreen(int, int, p_181560_1_);
                }
                catch (Throwable throwable)
                {
                    CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Rendering screen");
                    CrashReportCategory crashreportcategory = crashreport.makeCategory("Screen render details");
                    crashreportcategory.addCrashSectionCallable("Screen name", () ->
                    {
                        return Minecraft.getMinecraft().currentScreen.getClass().getCanonicalName();
                    });
                    crashreportcategory.addCrashSectionCallable("Mouse location", new Callable()
                    {
                        private static final String __OBFID = "CL_00000950";
                        public String call() throws Exception
                        {
                            return String.format("Scaled: (%d, %d). Absolute: (%d, %d)", new Object[] {Integer.valueOf(int), Integer.valueOf(int), Integer.valueOf(Mouse.getX()), Integer.valueOf(Mouse.getY())});
                        }
                    });
                    crashreportcategory.addCrashSectionCallable("Screen size", new Callable()
                    {
                        private static final String __OBFID = "CL_00000951";
                        public String call() throws Exception
                        {
                            return String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", new Object[] {Integer.valueOf(scaledresolution.getScaledWidth()), Integer.valueOf(scaledresolution.getScaledHeight()), Integer.valueOf(EntityRenderer.this.mc.displayWidth), Integer.valueOf(EntityRenderer.this.mc.displayHeight), Integer.valueOf(scaledresolution.getScaleFactor())});
                        }
                    });
                    throw new ReportedException(crashreport);
                }
            }

            Texteria.instance.gui.render(GuiRenderLayer.SCREEN);
        }

        this.frameFinish();
        this.waitForServerThread();
        Lagometer.updateLagometer();

        if (this.mc.gameSettings.ofProfiler)
        {
            this.mc.gameSettings.showDebugProfilerChart = true;
        }
    }

    public void renderStreamIndicator(float partialTicks)
    {
        this.setupOverlayRendering();
        this.mc.ingameGUI.renderStreamIndicator(new ScaledResolution(this.mc));
    }

    private boolean isDrawBlockOutline()
    {
        if (!this.drawBlockOutline)
        {
            return false;
        }
        else
        {
            Entity entity = this.mc.getRenderViewEntity();
            boolean boolean = entity instanceof EntityPlayer && !this.mc.gameSettings.hideGUI;

            if (boolean && !((EntityPlayer)entity).capabilities.allowEdit)
            {
                ItemStack itemstack = ((EntityPlayer)entity).getCurrentEquippedItem();

                if (this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
                {
                    BlockPos blockpos = this.mc.objectMouseOver.getBlockPos();
                    IBlockState iblockstate = this.mc.theWorld.getBlockState(blockpos);
                    Block block = iblockstate.getBlock();

                    if (this.mc.playerController.getCurrentGameType() == WorldSettings.GameType.SPECTATOR)
                    {
                        boolean = iblockstate.getBlock().hasTileEntity() && this.mc.theWorld.getTileEntity(blockpos) instanceof IInventory;
                    }
                    else
                    {
                        boolean = itemstack != null && (itemstack.canDestroy(block) || itemstack.canPlaceOn(block));
                    }
                }
            }

            return boolean;
        }
    }

    private void renderWorldDirections(float partialTicks)
    {
        if (this.mc.gameSettings.showDebugInfo && !this.mc.gameSettings.hideGUI && !this.mc.thePlayer.hasReducedDebug() && !this.mc.gameSettings.reducedDebugInfo)
        {
            Entity entity = this.mc.getRenderViewEntity();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(OBFVAL_6s7CP.get(), OBFVAL_xUI2a.get(), 1, 0);
            GL11.glLineWidth(1.0F);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask(false);
            GlStateManager.pushMatrix();
            GlStateManager.matrixMode(OBFVAL_Rmm83.get());
            GlStateManager.loadIdentity();
            this.orientCamera(partialTicks);
            GlStateManager.translate(0.0F, entity.getEyeHeight(), 0.0F);
            RenderGlobal.func_181563_a(new AxisAlignedBB(0.0D, 0.0D, 0.0D, OBFVAL_jOK6q.get(), OBFVAL_sqUZW.get(), OBFVAL_sqUZW.get()), OBFVAL_32ZJz.get(), 0, 0, OBFVAL_32ZJz.get());
            RenderGlobal.func_181563_a(new AxisAlignedBB(0.0D, 0.0D, 0.0D, OBFVAL_sqUZW.get(), OBFVAL_sqUZW.get(), OBFVAL_jOK6q.get()), 0, 0, OBFVAL_32ZJz.get(), OBFVAL_32ZJz.get());
            RenderGlobal.func_181563_a(new AxisAlignedBB(0.0D, 0.0D, 0.0D, OBFVAL_sqUZW.get(), OBFVAL_VCBJx.get(), OBFVAL_sqUZW.get()), 0, OBFVAL_32ZJz.get(), 0, OBFVAL_32ZJz.get());
            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
        }
    }

    public void renderWorld(float partialTicks, long finishTimeNano)
    {
        this.updateLightmap(partialTicks);

        if (this.mc.getRenderViewEntity() == null)
        {
            this.mc.setRenderViewEntity(this.mc.thePlayer);
        }

        this.getMouseOver(partialTicks);

        if (Config.isShaders())
        {
            Shaders.beginRender(this.mc, partialTicks, finishTimeNano);
        }

        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(OBFVAL_VXuQ4.get(), OBFVAL_nfhIC.get());
        this.mc.mcProfiler.startSection("center");

        if (this.mc.gameSettings.anaglyph)
        {
            anaglyphField = 0;
            GlStateManager.colorMask(false, true, true, false);
            this.renderWorldPass(0, partialTicks, finishTimeNano);
            anaglyphField = 1;
            GlStateManager.colorMask(true, false, false, false);
            this.renderWorldPass(1, partialTicks, finishTimeNano);
            GlStateManager.colorMask(true, true, true, false);
        }
        else
        {
            this.renderWorldPass(OBFVAL_zejjh.get(), partialTicks, finishTimeNano);
        }

        this.mc.mcProfiler.endSection();
    }

    private void renderWorldPass(int pass, float partialTicks, long finishTimeNano)
    {
        boolean boolean = Config.isShaders();

        if (boolean)
        {
            Shaders.beginRenderPass(pass, partialTicks, finishTimeNano);
        }

        RenderGlobal renderglobal = this.mc.renderGlobal;
        EffectRenderer effectrenderer = this.mc.effectRenderer;
        boolean boolean = this.isDrawBlockOutline();
        GlStateManager.enableCull();
        this.mc.mcProfiler.endStartSection("clear");

        if (boolean)
        {
            Shaders.setViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        }
        else
        {
            GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        }

        this.updateFogColor(partialTicks);
        GlStateManager.clear(OBFVAL_H11br.get());

        if (boolean)
        {
            Shaders.clearRenderBuffer();
        }

        this.mc.mcProfiler.endStartSection("camera");
        this.setupCameraTransform(partialTicks, pass);

        if (boolean)
        {
            Shaders.setCamera(partialTicks);
        }

        ActiveRenderInfo.updateRenderInfo(this.mc.thePlayer, this.mc.gameSettings.thirdPersonView == OBFVAL_zejjh.get());
        this.mc.mcProfiler.endStartSection("frustum");
        ClippingHelperImpl.getInstance();
        this.mc.mcProfiler.endStartSection("culling");
        Frustum frustum = new Frustum();
        Entity entity = this.mc.getRenderViewEntity();
        double double = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)partialTicks;
        double double = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)partialTicks;
        double double = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)partialTicks;

        if (boolean)
        {
            ShadersRender.setFrustrumPosition(frustum, double, double, double);
        }
        else
        {
            frustum.setPosition(double, double, double);
        }

        if ((Config.isSkyEnabled() || Config.isSunMoonEnabled() || Config.isStarsEnabled()) && !Shaders.isShadowPass)
        {
            this.setupFog(-1, partialTicks);
            this.mc.mcProfiler.endStartSection("sky");
            GlStateManager.matrixMode(OBFVAL_Yojsk.get());
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(partialTicks, true), (float)this.mc.displayWidth / (float)this.mc.displayHeight, OBFVAL_7sr6W.get(), this.clipDistance);
            GlStateManager.matrixMode(OBFVAL_Rmm83.get());

            if (boolean)
            {
                Shaders.beginSky();
            }

            renderglobal.renderSky(partialTicks, pass);

            if (boolean)
            {
                Shaders.endSky();
            }

            GlStateManager.matrixMode(OBFVAL_Yojsk.get());
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(partialTicks, true), (float)this.mc.displayWidth / (float)this.mc.displayHeight, OBFVAL_7sr6W.get(), this.clipDistance);
            GlStateManager.matrixMode(OBFVAL_Rmm83.get());
        }
        else
        {
            GlStateManager.disableBlend();
        }

        this.setupFog(0, partialTicks);
        GlStateManager.shadeModel(OBFVAL_GlFuv.get());

        if (entity.posY + (double)entity.getEyeHeight() < OBFVAL_O3n6N.get() + (double)(this.mc.gameSettings.ofCloudsHeight * OBFVAL_m7d7j.get()))
        {
            this.renderCloudsCheck(renderglobal, partialTicks, pass);
        }

        this.mc.mcProfiler.endStartSection("prepareterrain");
        this.setupFog(0, partialTicks);
        this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        RenderHelper.disableStandardItemLighting();
        this.mc.mcProfiler.endStartSection("terrain_setup");

        if (boolean)
        {
            ShadersRender.setupTerrain(renderglobal, entity, (double)partialTicks, frustum, this.frameCount++, this.mc.thePlayer.isSpectator());
        }
        else
        {
            renderglobal.setupTerrain(entity, (double)partialTicks, frustum, this.frameCount++, this.mc.thePlayer.isSpectator());
        }

        if (pass == 0 || pass == OBFVAL_zejjh.get())
        {
            this.mc.mcProfiler.endStartSection("updatechunks");
            Lagometer.timerChunkUpload.start();
            this.mc.renderGlobal.updateChunks(finishTimeNano);
            Lagometer.timerChunkUpload.end();
        }

        this.mc.mcProfiler.endStartSection("terrain");
        Lagometer.timerTerrain.start();

        if (this.mc.gameSettings.ofSmoothFps && pass > 0)
        {
            this.mc.mcProfiler.endStartSection("finish");
            GL11.glFinish();
            this.mc.mcProfiler.endStartSection("terrain");
        }

        GlStateManager.matrixMode(OBFVAL_Rmm83.get());
        GlStateManager.pushMatrix();
        GlStateManager.disableAlpha();

        if (boolean)
        {
            ShadersRender.beginTerrainSolid();
        }

        renderglobal.renderBlockLayer(EnumWorldBlockLayer.SOLID, (double)partialTicks, pass, entity);
        GlStateManager.enableAlpha();

        if (boolean)
        {
            ShadersRender.beginTerrainCutoutMipped();
        }

        renderglobal.renderBlockLayer(EnumWorldBlockLayer.CUTOUT_MIPPED, (double)partialTicks, pass, entity);
        this.mc.getTextureManager().getTexture(TextureMap.locationBlocksTexture).setBlurMipmap(false, false);

        if (boolean)
        {
            ShadersRender.beginTerrainCutout();
        }

        renderglobal.renderBlockLayer(EnumWorldBlockLayer.CUTOUT, (double)partialTicks, pass, entity);
        this.mc.getTextureManager().getTexture(TextureMap.locationBlocksTexture).restoreLastBlurMipmap();

        if (boolean)
        {
            ShadersRender.endTerrain();
        }

        Lagometer.timerTerrain.end();
        GlStateManager.shadeModel(OBFVAL_eOgDW.get());
        GlStateManager.alphaFunc(OBFVAL_VXuQ4.get(), OBFVAL_nfhIC.get());

        if (!this.debugView)
        {
            GlStateManager.matrixMode(OBFVAL_Rmm83.get());
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            RenderHelper.enableStandardItemLighting();
            this.mc.mcProfiler.endStartSection("entities");
            renderglobal.renderEntities(entity, frustum, partialTicks);
            RenderHelper.disableStandardItemLighting();
            this.disableLightmap();
            GlStateManager.matrixMode(OBFVAL_Rmm83.get());
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();

            if (this.mc.objectMouseOver != null && entity.isInsideOfMaterial(Material.water) && boolean)
            {
                EntityPlayer entityplayer = (EntityPlayer)entity;
                GlStateManager.disableAlpha();
                this.mc.mcProfiler.endStartSection("outline");
                renderglobal.drawSelectionBox(entityplayer, this.mc.objectMouseOver, 0, partialTicks);
                GlStateManager.enableAlpha();
            }
        }

        GlStateManager.matrixMode(OBFVAL_Rmm83.get());
        GlStateManager.popMatrix();

        if (boolean && this.mc.objectMouseOver != null && !entity.isInsideOfMaterial(Material.water))
        {
            EntityPlayer entityplayer1 = (EntityPlayer)entity;
            GlStateManager.disableAlpha();
            this.mc.mcProfiler.endStartSection("outline");
            renderglobal.drawSelectionBox(entityplayer1, this.mc.objectMouseOver, 0, partialTicks);
            GlStateManager.enableAlpha();
        }

        if (this.mc.getRenderManager().debugChunkBorders)
        {
            this.mc.getRenderManager().renderChunkBorders(partialTicks);
        }

        if (!renderglobal.damagedBlocks.isEmpty())
        {
            this.mc.mcProfiler.endStartSection("destroyProgress");
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(OBFVAL_6s7CP.get(), 1, 1, 0);
            this.mc.getTextureManager().getTexture(TextureMap.locationBlocksTexture).setBlurMipmap(false, false);
            renderglobal.drawBlockDamageTexture(Tessellator.getInstance(), Tessellator.getInstance().getWorldRenderer(), entity, partialTicks);
            this.mc.getTextureManager().getTexture(TextureMap.locationBlocksTexture).restoreLastBlurMipmap();
            GlStateManager.disableBlend();
        }

        GlStateManager.tryBlendFuncSeparate(OBFVAL_6s7CP.get(), OBFVAL_xUI2a.get(), 1, 0);
        GlStateManager.disableBlend();

        if (!this.debugView)
        {
            this.enableLightmap();
            this.mc.mcProfiler.endStartSection("litParticles");

            if (boolean)
            {
                Shaders.beginLitParticles();
            }

            effectrenderer.renderLitParticles(entity, partialTicks);
            RenderHelper.disableStandardItemLighting();
            this.setupFog(0, partialTicks);
            this.mc.mcProfiler.endStartSection("particles");

            if (boolean)
            {
                Shaders.beginParticles();
            }

            effectrenderer.renderParticles(entity, partialTicks);

            if (boolean)
            {
                Shaders.endParticles();
            }

            this.disableLightmap();
        }

        GlStateManager.depthMask(false);
        GlStateManager.enableCull();
        this.mc.mcProfiler.endStartSection("weather");

        if (boolean)
        {
            Shaders.beginWeather();
        }

        this.renderRainSnow(partialTicks);

        if (boolean)
        {
            Shaders.endWeather();
        }

        GlStateManager.depthMask(true);
        renderglobal.renderWorldBorder(entity, partialTicks);

        if (boolean)
        {
            ShadersRender.renderHand0(this, partialTicks, pass);
            Shaders.preWater();
        }

        GlStateManager.disableBlend();
        GlStateManager.enableCull();
        GlStateManager.tryBlendFuncSeparate(OBFVAL_6s7CP.get(), OBFVAL_xUI2a.get(), 1, 0);
        GlStateManager.alphaFunc(OBFVAL_VXuQ4.get(), OBFVAL_nfhIC.get());
        this.setupFog(0, partialTicks);
        GlStateManager.enableBlend();
        GlStateManager.depthMask(false);
        this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        GlStateManager.shadeModel(OBFVAL_GlFuv.get());
        this.mc.mcProfiler.endStartSection("translucent");

        if (boolean)
        {
            Shaders.beginWater();
        }

        renderglobal.renderBlockLayer(EnumWorldBlockLayer.TRANSLUCENT, (double)partialTicks, pass, entity);

        if (boolean)
        {
            Shaders.endWater();
        }

        Texteria.instance.world.render(frustum);
        GlStateManager.shadeModel(OBFVAL_eOgDW.get());
        GlStateManager.depthMask(true);
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.disableFog();

        if (entity.posY + (double)entity.getEyeHeight() >= OBFVAL_O3n6N.get() + (double)(this.mc.gameSettings.ofCloudsHeight * OBFVAL_m7d7j.get()))
        {
            this.mc.mcProfiler.endStartSection("aboveClouds");
            this.renderCloudsCheck(renderglobal, partialTicks, pass);
        }

        CamEventHandler.worldRender(renderglobal, partialTicks);
        this.mc.mcProfiler.endStartSection("hand");

        if (this.renderHand && !Shaders.isShadowPass)
        {
            if (boolean)
            {
                ShadersRender.renderHand1(this, partialTicks, pass);
                Shaders.renderCompositeFinal();
            }

            GlStateManager.clear(OBFVAL_qbi68.get());

            if (boolean)
            {
                ShadersRender.renderFPOverlay(this, partialTicks, pass);
            }
            else
            {
                this.renderHand(partialTicks, pass);
            }

            this.renderWorldDirections(partialTicks);
        }

        if (boolean)
        {
            Shaders.endRender();
        }
    }

    private void renderCloudsCheck(RenderGlobal renderGlobalIn, float partialTicks, int pass)
    {
        if (this.mc.gameSettings.renderDistanceChunks >= OBFVAL_fOuzA.get() && !Config.isCloudsOff() && Shaders.shouldRenderClouds(this.mc.gameSettings))
        {
            this.mc.mcProfiler.endStartSection("clouds");
            GlStateManager.matrixMode(OBFVAL_Yojsk.get());
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(partialTicks, true), (float)this.mc.displayWidth / (float)this.mc.displayHeight, OBFVAL_7sr6W.get(), this.clipDistance * OBFVAL_kqaNJ.get());
            GlStateManager.matrixMode(OBFVAL_Rmm83.get());
            GlStateManager.pushMatrix();
            this.setupFog(0, partialTicks);
            renderGlobalIn.renderClouds(partialTicks, pass);
            GlStateManager.disableFog();
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(OBFVAL_Yojsk.get());
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(partialTicks, true), (float)this.mc.displayWidth / (float)this.mc.displayHeight, OBFVAL_7sr6W.get(), this.clipDistance);
            GlStateManager.matrixMode(OBFVAL_Rmm83.get());
        }
    }

    private void addRainParticles()
    {
        float float = this.mc.theWorld.getRainStrength(1.0F);

        if (!Config.isRainFancy())
        {
            float /= OBFVAL_lacQB.get();
        }

        if (float != 0.0F && Config.isRainSplash())
        {
            this.random.setSeed((long)this.rendererUpdateCount * OBFVAL_Bwr8f.get());
            Entity entity = this.mc.getRenderViewEntity();
            WorldClient worldclient = this.mc.theWorld;
            BlockPos blockpos = new BlockPos(entity);
            byte byte = (byte)OBFVAL_tKDdL.get();
            double double = 0.0D;
            double double = 0.0D;
            double double = 0.0D;
            int int = 0;
            int int = (int)(OBFVAL_r5b2C.get() * float * float);

            if (this.mc.gameSettings.particleSetting == 1)
            {
                int >>= 1;
            }
            else if (this.mc.gameSettings.particleSetting == OBFVAL_zejjh.get())
            {
                int = 0;
            }

            for (int int = 0; int < int; ++int)
            {
                BlockPos blockpos1 = worldclient.getPrecipitationHeight(blockpos.add(this.random.nextInt(byte) - this.random.nextInt(byte), 0, this.random.nextInt(byte) - this.random.nextInt(byte)));
                BiomeGenBase biomegenbase = worldclient.getBiomeGenForCoords(blockpos1);
                BlockPos blockpos2 = blockpos1.down();
                Block block = worldclient.getBlockState(blockpos2).getBlock();

                if (blockpos1.getY() <= blockpos.getY() + byte && blockpos1.getY() >= blockpos.getY() - byte && biomegenbase.canSpawnLightningBolt() && biomegenbase.getFloatTemperature(blockpos1) >= OBFVAL_zvxPe.get())
                {
                    double double = this.random.nextDouble();
                    double double = this.random.nextDouble();

                    if (block.getMaterial() == Material.lava)
                    {
                        this.mc.theWorld.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double)blockpos1.getX() + double, (double)((float)blockpos1.getY() + OBFVAL_nfhIC.get()) - block.getBlockBoundsMinY(), (double)blockpos1.getZ() + double, 0.0D, 0.0D, 0.0D, new int[0]);
                    }
                    else if (block.getMaterial() != Material.air)
                    {
                        block.setBlockBoundsBasedOnState(worldclient, blockpos2);
                        ++int;

                        if (this.random.nextInt(int) == 0)
                        {
                            double = (double)blockpos2.getX() + double;
                            double = (double)((float)blockpos2.getY() + OBFVAL_nfhIC.get()) + block.getBlockBoundsMaxY() - 1.0D;
                            double = (double)blockpos2.getZ() + double;
                        }

                        this.mc.theWorld.spawnParticle(EnumParticleTypes.WATER_DROP, (double)blockpos2.getX() + double, (double)((float)blockpos2.getY() + OBFVAL_nfhIC.get()) + block.getBlockBoundsMaxY(), (double)blockpos2.getZ() + double, 0.0D, 0.0D, 0.0D, new int[0]);
                    }
                }
            }

            if (int > 0 && this.random.nextInt(OBFVAL_HXJ4H.get()) < this.rainSoundCounter++)
            {
                this.rainSoundCounter = 0;

                if (double > (double)(blockpos.getY() + 1) && worldclient.getPrecipitationHeight(blockpos).getY() > MathHelper.floor_float((float)blockpos.getY()))
                {
                    this.mc.theWorld.playSound(double, double, double, "ambient.weather.rain", OBFVAL_nfhIC.get(), OBFVAL_b8UoI.get(), false);
                }
                else
                {
                    this.mc.theWorld.playSound(double, double, double, "ambient.weather.rain", OBFVAL_mhpPT.get(), 1.0F, false);
                }
            }
        }
    }

    /**
     * Render rain and snow
     */
    protected void renderRainSnow(float partialTicks)
    {
        float float = this.mc.theWorld.getRainStrength(partialTicks);

        if (float > 0.0F)
        {
            if (Config.isRainOff())
            {
                return;
            }

            this.enableLightmap();
            Entity entity = this.mc.getRenderViewEntity();
            WorldClient worldclient = this.mc.theWorld;
            int int = MathHelper.floor_double(entity.posX);
            int int = MathHelper.floor_double(entity.posY);
            int int = MathHelper.floor_double(entity.posZ);
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();
            GlStateManager.disableCull();
            GL11.glNormal3f(0.0F, 1.0F, 0.0F);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(OBFVAL_6s7CP.get(), OBFVAL_xUI2a.get(), 1, 0);
            GlStateManager.alphaFunc(OBFVAL_VXuQ4.get(), OBFVAL_nfhIC.get());
            double double = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)partialTicks;
            double double = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)partialTicks;
            double double = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)partialTicks;
            int int = MathHelper.floor_double(double);
            byte byte = (byte)OBFVAL_xNbMN.get();

            if (Config.isRainFancy())
            {
                byte = (byte)OBFVAL_tKDdL.get();
            }

            byte byte = -1;
            float float = (float)this.rendererUpdateCount + partialTicks;
            worldrenderer.setTranslation(-double, -double, -double);

            if (Config.isRainFancy())
            {
                byte = (byte)OBFVAL_tKDdL.get();
            }

            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            for (int int = int - byte; int <= int + byte; ++int)
            {
                for (int int = int - byte; int <= int + byte; ++int)
                {
                    int int = (int - int + OBFVAL_USh2A.get()) * OBFVAL_FgjKP.get() + int - int + OBFVAL_USh2A.get();
                    double double = (double)this.rainXCoords[int] * OBFVAL_zIRzO.get();
                    double double = (double)this.rainYCoords[int] * OBFVAL_zIRzO.get();
                    blockpos$mutableblockpos.func_181079_c(int, 0, int);
                    BiomeGenBase biomegenbase = worldclient.getBiomeGenForCoords(blockpos$mutableblockpos);

                    if (biomegenbase.canSpawnLightningBolt() || biomegenbase.getEnableSnow())
                    {
                        int int = worldclient.getPrecipitationHeight(blockpos$mutableblockpos).getY();
                        int int = int - byte;
                        int int = int + byte;

                        if (int < int)
                        {
                            int = int;
                        }

                        if (int < int)
                        {
                            int = int;
                        }

                        int int = int;

                        if (int < int)
                        {
                            int = int;
                        }

                        if (int != int)
                        {
                            this.random.setSeed((long)(int * int * OBFVAL_AqMKA.get() + int * OBFVAL_6FN5j.get() ^ int * int * OBFVAL_dpSag.get() + int * OBFVAL_7r50x.get()));
                            blockpos$mutableblockpos.func_181079_c(int, int, int);
                            float float = biomegenbase.getFloatTemperature(blockpos$mutableblockpos);

                            if (worldclient.getWorldChunkManager().getTemperatureAtHeight(float, int) >= OBFVAL_zvxPe.get())
                            {
                                if (byte != 0)
                                {
                                    if (byte >= 0)
                                    {
                                        tessellator.draw();
                                    }

                                    byte = 0;
                                    this.mc.getTextureManager().bindTexture(locationRainPng);
                                    worldrenderer.begin(OBFVAL_MNK0g.get(), DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                                }

                                double double = ((double)(this.rendererUpdateCount + int * int * OBFVAL_AqMKA.get() + int * OBFVAL_6FN5j.get() + int * int * OBFVAL_dpSag.get() + int * OBFVAL_7r50x.get() & OBFVAL_YEet5.get()) + (double)partialTicks) / OBFVAL_uW9Bi.get() * (OBFVAL_LAs7X.get() + this.random.nextDouble());
                                double double = (double)((float)int + OBFVAL_b8UoI.get()) - entity.posX;
                                double double = (double)((float)int + OBFVAL_b8UoI.get()) - entity.posZ;
                                float float = MathHelper.sqrt_double(double * double + double * double) / (float)byte;
                                float float = ((1.0F - float * float) * OBFVAL_b8UoI.get() + OBFVAL_b8UoI.get()) * float;
                                blockpos$mutableblockpos.func_181079_c(int, int, int);
                                int int = worldclient.getCombinedLight(blockpos$mutableblockpos, 0);
                                int int = int >> OBFVAL_USh2A.get() & OBFVAL_yTXBI.get();
                                int int = int & OBFVAL_yTXBI.get();
                                worldrenderer.pos((double)int - double + OBFVAL_zIRzO.get(), (double)int, (double)int - double + OBFVAL_zIRzO.get()).tex(0.0D, (double)int * OBFVAL_BytzI.get() + double).color(1.0F, 1.0F, 1.0F, float).lightmap(int, int).endVertex();
                                worldrenderer.pos((double)int + double + OBFVAL_zIRzO.get(), (double)int, (double)int + double + OBFVAL_zIRzO.get()).tex(1.0D, (double)int * OBFVAL_BytzI.get() + double).color(1.0F, 1.0F, 1.0F, float).lightmap(int, int).endVertex();
                                worldrenderer.pos((double)int + double + OBFVAL_zIRzO.get(), (double)int, (double)int + double + OBFVAL_zIRzO.get()).tex(1.0D, (double)int * OBFVAL_BytzI.get() + double).color(1.0F, 1.0F, 1.0F, float).lightmap(int, int).endVertex();
                                worldrenderer.pos((double)int - double + OBFVAL_zIRzO.get(), (double)int, (double)int - double + OBFVAL_zIRzO.get()).tex(0.0D, (double)int * OBFVAL_BytzI.get() + double).color(1.0F, 1.0F, 1.0F, float).lightmap(int, int).endVertex();
                            }
                            else
                            {
                                if (byte != 1)
                                {
                                    if (byte >= 0)
                                    {
                                        tessellator.draw();
                                    }

                                    byte = 1;
                                    this.mc.getTextureManager().bindTexture(locationSnowPng);
                                    worldrenderer.begin(OBFVAL_MNK0g.get(), DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                                }

                                double double = (double)(((float)(this.rendererUpdateCount & OBFVAL_WO4MG.get()) + partialTicks) / OBFVAL_UYzpE.get());
                                double double = this.random.nextDouble() + (double)float * OBFVAL_HY8Mz.get() * (double)((float)this.random.nextGaussian());
                                double double = this.random.nextDouble() + (double)(float * (float)this.random.nextGaussian()) * OBFVAL_OB7Vp.get();
                                double double = (double)((float)int + OBFVAL_b8UoI.get()) - entity.posX;
                                double double = (double)((float)int + OBFVAL_b8UoI.get()) - entity.posZ;
                                float float = MathHelper.sqrt_double(double * double + double * double) / (float)byte;
                                float float = ((1.0F - float * float) * OBFVAL_xgpCA.get() + OBFVAL_b8UoI.get()) * float;
                                blockpos$mutableblockpos.func_181079_c(int, int, int);
                                int int = (worldclient.getCombinedLight(blockpos$mutableblockpos, 0) * OBFVAL_HXJ4H.get() + OBFVAL_OkLoL.get()) / OBFVAL_fOuzA.get();
                                int int = int >> OBFVAL_USh2A.get() & OBFVAL_yTXBI.get();
                                int int = int & OBFVAL_yTXBI.get();
                                worldrenderer.pos((double)int - double + OBFVAL_zIRzO.get(), (double)int, (double)int - double + OBFVAL_zIRzO.get()).tex(0.0D + double, (double)int * OBFVAL_BytzI.get() + double + double).color(1.0F, 1.0F, 1.0F, float).lightmap(int, int).endVertex();
                                worldrenderer.pos((double)int + double + OBFVAL_zIRzO.get(), (double)int, (double)int + double + OBFVAL_zIRzO.get()).tex(1.0D + double, (double)int * OBFVAL_BytzI.get() + double + double).color(1.0F, 1.0F, 1.0F, float).lightmap(int, int).endVertex();
                                worldrenderer.pos((double)int + double + OBFVAL_zIRzO.get(), (double)int, (double)int + double + OBFVAL_zIRzO.get()).tex(1.0D + double, (double)int * OBFVAL_BytzI.get() + double + double).color(1.0F, 1.0F, 1.0F, float).lightmap(int, int).endVertex();
                                worldrenderer.pos((double)int - double + OBFVAL_zIRzO.get(), (double)int, (double)int - double + OBFVAL_zIRzO.get()).tex(0.0D + double, (double)int * OBFVAL_BytzI.get() + double + double).color(1.0F, 1.0F, 1.0F, float).lightmap(int, int).endVertex();
                            }
                        }
                    }
                }
            }

            if (byte >= 0)
            {
                tessellator.draw();
            }

            worldrenderer.setTranslation(0.0D, 0.0D, 0.0D);
            GlStateManager.enableCull();
            GlStateManager.disableBlend();
            GlStateManager.alphaFunc(OBFVAL_VXuQ4.get(), OBFVAL_nfhIC.get());
            this.disableLightmap();
        }
    }

    /**
     * Setup orthogonal projection for rendering GUI screen overlays
     */
    public void setupOverlayRendering()
    {
        ScaledResolution scaledresolution = new ScaledResolution(this.mc);
        GlStateManager.clear(OBFVAL_qbi68.get());
        GlStateManager.matrixMode(OBFVAL_Yojsk.get());
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0D, scaledresolution.getScaledWidth_double(), scaledresolution.getScaledHeight_double(), 0.0D, OBFVAL_gSz2D.get(), OBFVAL_EAGBM.get());
        GlStateManager.matrixMode(OBFVAL_Rmm83.get());
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0F, 0.0F, OBFVAL_PnIcF.get());
    }

    /**
     * calculates fog and calls glClearColor
     */
    private void updateFogColor(float partialTicks)
    {
        WorldClient worldclient = this.mc.theWorld;
        Entity entity = this.mc.getRenderViewEntity();
        float float = OBFVAL_3hWJt.get() + OBFVAL_l3q7D.get() * (float)this.mc.gameSettings.renderDistanceChunks / OBFVAL_lrN2J.get();
        float = 1.0F - (float)Math.pow((double)float, OBFVAL_BytzI.get());
        Vec3 vec3 = worldclient.getSkyColor(this.mc.getRenderViewEntity(), partialTicks);
        vec3 = CustomColors.getWorldSkyColor(vec3, worldclient, this.mc.getRenderViewEntity(), partialTicks);
        float float = (float)vec3.xCoord;
        float float = (float)vec3.yCoord;
        float float = (float)vec3.zCoord;
        Vec3 vec31 = worldclient.getFogColor(partialTicks);
        vec31 = CustomColors.getWorldFogColor(vec31, worldclient, this.mc.getRenderViewEntity(), partialTicks);
        this.fogColorRed = (float)vec31.xCoord;
        this.fogColorGreen = (float)vec31.yCoord;
        this.fogColorBlue = (float)vec31.zCoord;

        if (this.mc.gameSettings.renderDistanceChunks >= OBFVAL_fOuzA.get())
        {
            double double = OBFVAL_3FFlc.get();
            Vec3 vec32 = MathHelper.sin(worldclient.getCelestialAngleRadians(partialTicks)) > 0.0F ? new Vec3(double, 0.0D, 0.0D) : new Vec3(1.0D, 0.0D, 0.0D);
            float float = (float)entity.getLook(partialTicks).dotProduct(vec32);

            if (float < 0.0F)
            {
                float = 0.0F;
            }

            if (float > 0.0F)
            {
                float[] afloat = worldclient.provider.calcSunriseSunsetColors(worldclient.getCelestialAngle(partialTicks), partialTicks);

                if (afloat != null)
                {
                    float = float * afloat[OBFVAL_HXJ4H.get()];
                    this.fogColorRed = this.fogColorRed * (1.0F - float) + afloat[0] * float;
                    this.fogColorGreen = this.fogColorGreen * (1.0F - float) + afloat[1] * float;
                    this.fogColorBlue = this.fogColorBlue * (1.0F - float) + afloat[OBFVAL_zejjh.get()] * float;
                }
            }
        }

        this.fogColorRed += (float - this.fogColorRed) * float;
        this.fogColorGreen += (float - this.fogColorGreen) * float;
        this.fogColorBlue += (float - this.fogColorBlue) * float;
        float float = worldclient.getRainStrength(partialTicks);

        if (float > 0.0F)
        {
            float float = 1.0F - float * OBFVAL_b8UoI.get();
            float float = 1.0F - float * OBFVAL_2dGYR.get();
            this.fogColorRed *= float;
            this.fogColorGreen *= float;
            this.fogColorBlue *= float;
        }

        float float = worldclient.getThunderStrength(partialTicks);

        if (float > 0.0F)
        {
            float float = 1.0F - float * OBFVAL_b8UoI.get();
            this.fogColorRed *= float;
            this.fogColorGreen *= float;
            this.fogColorBlue *= float;
        }

        Block block = ActiveRenderInfo.getBlockAtEntityViewpoint(this.mc.theWorld, entity, partialTicks);

        if (this.cloudFog)
        {
            Vec3 vec33 = worldclient.getCloudColour(partialTicks);
            this.fogColorRed = (float)vec33.xCoord;
            this.fogColorGreen = (float)vec33.yCoord;
            this.fogColorBlue = (float)vec33.zCoord;
        }
        else if (block.getMaterial() == Material.water)
        {
            float float = (float)EnchantmentHelper.getRespiration(entity) * OBFVAL_mhpPT.get();

            if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPotionActive(Potion.waterBreathing))
            {
                float = float * OBFVAL_xgpCA.get() + OBFVAL_Ri74X.get();
            }

            this.fogColorRed = OBFVAL_8ji7X.get() + float;
            this.fogColorGreen = OBFVAL_8ji7X.get() + float;
            this.fogColorBlue = OBFVAL_mhpPT.get() + float;
            Vec3 vec34 = CustomColors.getUnderwaterColor(this.mc.theWorld, this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().posY + 1.0D, this.mc.getRenderViewEntity().posZ);

            if (vec34 != null)
            {
                this.fogColorRed = (float)vec34.xCoord;
                this.fogColorGreen = (float)vec34.yCoord;
                this.fogColorBlue = (float)vec34.zCoord;
            }
        }
        else if (block.getMaterial() == Material.lava)
        {
            this.fogColorRed = OBFVAL_Ri74X.get();
            this.fogColorGreen = OBFVAL_nfhIC.get();
            this.fogColorBlue = 0.0F;
        }

        float float = this.fogColor2 + (this.fogColor1 - this.fogColor2) * partialTicks;
        this.fogColorRed *= float;
        this.fogColorGreen *= float;
        this.fogColorBlue *= float;
        double double = worldclient.provider.getVoidFogYFactor();
        double double = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)partialTicks) * double;

        if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPotionActive(Potion.blindness))
        {
            int int = ((EntityLivingBase)entity).getActivePotionEffect(Potion.blindness).getDuration();

            if (int < OBFVAL_mvI7p.get())
            {
                double *= (double)(1.0F - (float)int / OBFVAL_KUOSH.get());
            }
            else
            {
                double = 0.0D;
            }
        }

        if (double < 1.0D)
        {
            if (double < 0.0D)
            {
                double = 0.0D;
            }

            double = double * double;
            this.fogColorRed = (float)((double)this.fogColorRed * double);
            this.fogColorGreen = (float)((double)this.fogColorGreen * double);
            this.fogColorBlue = (float)((double)this.fogColorBlue * double);
        }

        if (this.bossColorModifier > 0.0F)
        {
            float float = this.bossColorModifierPrev + (this.bossColorModifier - this.bossColorModifierPrev) * partialTicks;
            this.fogColorRed = this.fogColorRed * (1.0F - float) + this.fogColorRed * OBFVAL_QAIST.get() * float;
            this.fogColorGreen = this.fogColorGreen * (1.0F - float) + this.fogColorGreen * OBFVAL_Ri74X.get() * float;
            this.fogColorBlue = this.fogColorBlue * (1.0F - float) + this.fogColorBlue * OBFVAL_Ri74X.get() * float;
        }

        if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPotionActive(Potion.nightVision))
        {
            float float = this.getNightVisionBrightness((EntityLivingBase)entity, partialTicks);
            float float = 1.0F / this.fogColorRed;

            if (float > 1.0F / this.fogColorGreen)
            {
                float = 1.0F / this.fogColorGreen;
            }

            if (float > 1.0F / this.fogColorBlue)
            {
                float = 1.0F / this.fogColorBlue;
            }

            this.fogColorRed = this.fogColorRed * (1.0F - float) + this.fogColorRed * float * float;
            this.fogColorGreen = this.fogColorGreen * (1.0F - float) + this.fogColorGreen * float * float;
            this.fogColorBlue = this.fogColorBlue * (1.0F - float) + this.fogColorBlue * float * float;
        }

        if (this.mc.gameSettings.anaglyph)
        {
            float float = (this.fogColorRed * OBFVAL_y22Lm.get() + this.fogColorGreen * OBFVAL_DYKsA.get() + this.fogColorBlue * OBFVAL_zUQ63.get()) / OBFVAL_r5b2C.get();
            float float = (this.fogColorRed * OBFVAL_y22Lm.get() + this.fogColorGreen * OBFVAL_UjWd3.get()) / OBFVAL_r5b2C.get();
            float float = (this.fogColorRed * OBFVAL_y22Lm.get() + this.fogColorBlue * OBFVAL_UjWd3.get()) / OBFVAL_r5b2C.get();
            this.fogColorRed = float;
            this.fogColorGreen = float;
            this.fogColorBlue = float;
        }

        Shaders.setClearColor(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 0.0F);
    }

    /**
     * Sets up the fog to be rendered. If the arg passed in is -1 the fog starts at 0 and goes to 80% of far plane
     * distance and is used for sky rendering.
     */
    private void setupFog(int p_78468_1_, float partialTicks)
    {
        Entity entity = this.mc.getRenderViewEntity();
        boolean boolean = false;
        this.fogStandard = false;

        if (entity instanceof EntityPlayer)
        {
            boolean = ((EntityPlayer)entity).capabilities.isCreativeMode;
        }

        GL11.glFog(OBFVAL_gu21U.get(), this.setFogColorBuffer(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 1.0F));
        GL11.glNormal3f(0.0F, OBFVAL_ZQrgv.get(), 0.0F);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        Block block = ActiveRenderInfo.getBlockAtEntityViewpoint(this.mc.theWorld, entity, partialTicks);
        float float = OBFVAL_ZQrgv.get();

        if (float >= 0.0F)
        {
            GlStateManager.setFogDensity(float);
        }
        else if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPotionActive(Potion.blindness))
        {
            float float = OBFVAL_HAhWr.get();
            int int = ((EntityLivingBase)entity).getActivePotionEffect(Potion.blindness).getDuration();

            if (int < OBFVAL_mvI7p.get())
            {
                float = OBFVAL_HAhWr.get() + (this.farPlaneDistance - OBFVAL_HAhWr.get()) * (1.0F - (float)int / OBFVAL_KUOSH.get());
            }

            if (Config.isShaders())
            {
                Shaders.setFog(OBFVAL_TOaMY.get());
            }
            else
            {
                GlStateManager.setFog(OBFVAL_TOaMY.get());
            }

            if (p_78468_1_ == -1)
            {
                GlStateManager.setFogStart(0.0F);
                GlStateManager.setFogEnd(float * OBFVAL_ZVhLV.get());
            }
            else
            {
                GlStateManager.setFogStart(float * OBFVAL_3hWJt.get());
                GlStateManager.setFogEnd(float);
            }

            if (GLContext.getCapabilities().GL_NV_fog_distance && Config.isFogFancy())
            {
                GL11.glFogi(OBFVAL_HdUX4.get(), OBFVAL_d2m5l.get());
            }
        }
        else if (this.cloudFog)
        {
            if (Config.isShaders())
            {
                Shaders.setFog(OBFVAL_u3u9V.get());
            }
            else
            {
                GlStateManager.setFog(OBFVAL_u3u9V.get());
            }

            GlStateManager.setFogDensity(OBFVAL_nfhIC.get());
        }
        else if (block.getMaterial() == Material.water)
        {
            if (Config.isShaders())
            {
                Shaders.setFog(OBFVAL_u3u9V.get());
            }
            else
            {
                GlStateManager.setFog(OBFVAL_u3u9V.get());
            }

            if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPotionActive(Potion.waterBreathing))
            {
                GlStateManager.setFogDensity(OBFVAL_RYrHR.get());
            }
            else
            {
                GlStateManager.setFogDensity(OBFVAL_nfhIC.get() - (float)EnchantmentHelper.getRespiration(entity) * OBFVAL_Nn6nB.get());
            }

            if (Config.isClearWater())
            {
                GlStateManager.setFogDensity(OBFVAL_8ji7X.get());
            }
        }
        else if (block.getMaterial() == Material.lava)
        {
            if (Config.isShaders())
            {
                Shaders.setFog(OBFVAL_u3u9V.get());
            }
            else
            {
                GlStateManager.setFog(OBFVAL_u3u9V.get());
            }

            GlStateManager.setFogDensity(OBFVAL_lacQB.get());
        }
        else
        {
            float float = this.farPlaneDistance;
            this.fogStandard = true;

            if (Config.isShaders())
            {
                Shaders.setFog(OBFVAL_TOaMY.get());
            }
            else
            {
                GlStateManager.setFog(OBFVAL_TOaMY.get());
            }

            if (p_78468_1_ == -1)
            {
                GlStateManager.setFogStart(0.0F);
                GlStateManager.setFogEnd(float);
            }
            else
            {
                GlStateManager.setFogStart(float * Config.getFogStart());
                GlStateManager.setFogEnd(float);
            }

            if (GLContext.getCapabilities().GL_NV_fog_distance)
            {
                if (Config.isFogFancy())
                {
                    GL11.glFogi(OBFVAL_HdUX4.get(), OBFVAL_d2m5l.get());
                }

                if (Config.isFogFast())
                {
                    GL11.glFogi(OBFVAL_HdUX4.get(), OBFVAL_K0DIH.get());
                }
            }

            if (this.mc.theWorld.provider.doesXZShowFog((int)entity.posX, (int)entity.posZ))
            {
                GlStateManager.setFogStart(float * OBFVAL_7sr6W.get());
                GlStateManager.setFogEnd(float);
            }
        }

        GlStateManager.enableColorMaterial();
        GlStateManager.enableFog();
        GlStateManager.colorMaterial(OBFVAL_MaYMb.get(), OBFVAL_p2kUj.get());
    }

    /**
     * Update and return fogColorBuffer with the RGBA values passed as arguments
     */
    private FloatBuffer setFogColorBuffer(float red, float green, float blue, float alpha)
    {
        if (Config.isShaders())
        {
            Shaders.setFogColor(red, green, blue);
        }

        this.fogColorBuffer.clear();
        this.fogColorBuffer.put(red).put(green).put(blue).put(alpha);
        this.fogColorBuffer.flip();
        return this.fogColorBuffer;
    }

    public MapItemRenderer getMapItemRenderer()
    {
        return this.theMapItemRenderer;
    }

    private void waitForServerThread()
    {
        this.serverWaitTimeCurrent = 0;

        if (Config.isSmoothWorld() && Config.isSingleProcessor())
        {
            if (this.mc.isIntegratedServerRunning())
            {
                IntegratedServer integratedserver = this.mc.getIntegratedServer();

                if (integratedserver != null)
                {
                    boolean boolean = this.mc.isGamePaused();

                    if (!boolean && !(this.mc.currentScreen instanceof GuiDownloadTerrain))
                    {
                        if (this.serverWaitTime > 0)
                        {
                            Lagometer.timerServer.start();
                            Config.sleep((long)this.serverWaitTime);
                            Lagometer.timerServer.end();
                            this.serverWaitTimeCurrent = this.serverWaitTime;
                        }

                        long long = System.nanoTime() / OBFVAL_0CDc9.get();

                        if (this.lastServerTime != 0L && this.lastServerTicks != 0)
                        {
                            long long = long - this.lastServerTime;

                            if (long < 0L)
                            {
                                this.lastServerTime = long;
                                long = 0L;
                            }

                            if (long >= OBFVAL_LyCGw.get())
                            {
                                this.lastServerTime = long;
                                int int = integratedserver.getTickCounter();
                                int int = int - this.lastServerTicks;

                                if (int < 0)
                                {
                                    this.lastServerTicks = int;
                                    int = 0;
                                }

                                if (int < 1 && this.serverWaitTime < OBFVAL_WzWKl.get())
                                {
                                    this.serverWaitTime += OBFVAL_zejjh.get();
                                }

                                if (int > 1 && this.serverWaitTime > 0)
                                {
                                    --this.serverWaitTime;
                                }

                                this.lastServerTicks = int;
                            }
                        }
                        else
                        {
                            this.lastServerTime = long;
                            this.lastServerTicks = integratedserver.getTickCounter();
                            this.avgServerTickDiff = 1.0F;
                            this.avgServerTimeDiff = OBFVAL_eC7QJ.get();
                        }
                    }
                    else
                    {
                        if (this.mc.currentScreen instanceof GuiDownloadTerrain)
                        {
                            Config.sleep(OBFVAL_I8OKh.get());
                        }

                        this.lastServerTime = 0L;
                        this.lastServerTicks = 0;
                    }
                }
            }
        }
        else
        {
            this.lastServerTime = 0L;
            this.lastServerTicks = 0;
        }
    }

    private void frameInit()
    {
        if (!this.initialized)
        {
            TextureUtils.registerResourceListener();

            if (Config.getBitsOs() == OBFVAL_iBoAv.get() && Config.getBitsJre() == OBFVAL_FgjKP.get())
            {
                Config.setNotify64BitJava(true);
            }

            this.initialized = true;
        }

        Config.checkDisplayMode();
        World world = this.mc.theWorld;

        if (world != null)
        {
            if (Config.getNewRelease() != null)
            {
                String string = "HD_U".replace("HD_U", "HD Ultra").replace("L", "Light");
                String string1 = string + " " + Config.getNewRelease();
                ChatComponentText chatcomponenttext = new ChatComponentText(I18n.format("of.message.newVersion", new Object[] {string1}));
                this.mc.ingameGUI.getChatGUI().printChatMessage(chatcomponenttext);
                Config.setNewRelease((String)null);
            }

            if (Config.isNotify64BitJava())
            {
                Config.setNotify64BitJava(false);
                ChatComponentText chatcomponenttext1 = new ChatComponentText(I18n.format("of.message.java64Bit", new Object[0]));
                this.mc.ingameGUI.getChatGUI().printChatMessage(chatcomponenttext1);
            }
        }

        if (this.updatedWorld != world)
        {
            RandomMobs.worldChanged(this.updatedWorld, world);
            Config.updateThreadPriorities();
            this.lastServerTime = 0L;
            this.lastServerTicks = 0;
            this.updatedWorld = world;
        }

        if (!this.setFxaaShader(Shaders.configAntialiasingLevel))
        {
            Shaders.configAntialiasingLevel = 0;
        }
    }

    private void frameFinish()
    {
        if (this.mc.theWorld != null)
        {
            long long = System.currentTimeMillis();

            if (long > this.lastErrorCheckTimeMs + OBFVAL_XCp0e.get())
            {
                this.lastErrorCheckTimeMs = long;
                int int = GL11.glGetError();

                if (int != 0)
                {
                    String string = GLU.gluErrorString(int);
                    Object[] aobject = new Object[OBFVAL_zejjh.get()];
                    aobject[0] = Integer.valueOf(int);
                    aobject[1] = string;
                    ChatComponentText chatcomponenttext = new ChatComponentText(I18n.format("of.message.openglError", aobject));
                    this.mc.ingameGUI.getChatGUI().printChatMessage(chatcomponenttext);
                }
            }
        }
    }

    public boolean setFxaaShader(int p_setFxaaShader_1_)
    {
        if (!OpenGlHelper.isFramebufferEnabled())
        {
            return false;
        }
        else if (this.theShaderGroup != null && this.theShaderGroup != this.fxaaShaders[OBFVAL_zejjh.get()] && this.theShaderGroup != this.fxaaShaders[OBFVAL_fOuzA.get()])
        {
            return true;
        }
        else if (p_setFxaaShader_1_ != OBFVAL_zejjh.get() && p_setFxaaShader_1_ != OBFVAL_fOuzA.get())
        {
            if (this.theShaderGroup == null)
            {
                return true;
            }
            else
            {
                this.theShaderGroup.deleteShaderGroup();
                this.theShaderGroup = null;
                return true;
            }
        }
        else if (this.theShaderGroup != null && this.theShaderGroup == this.fxaaShaders[p_setFxaaShader_1_])
        {
            return true;
        }
        else if (this.mc.theWorld == null)
        {
            return true;
        }
        else
        {
            this.loadShader(new ResourceLocation("shaders/post/fxaa_of_" + p_setFxaaShader_1_ + "x.json"));
            this.fxaaShaders[p_setFxaaShader_1_] = this.theShaderGroup;
            return this.useShader;
        }
    }

    static
    {
        ObfValue.beginGeneration();
        ObfValue.endGeneration(new byte[] {(byte)87, (byte) - 63, (byte)45, (byte) - 44, (byte)112, (byte)74, (byte) - 48, (byte)27});
    }
}
