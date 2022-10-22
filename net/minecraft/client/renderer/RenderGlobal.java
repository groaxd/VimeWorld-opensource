package net.minecraft.client.renderer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockSign;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.client.renderer.chunk.CompiledChunk;
import net.minecraft.client.renderer.chunk.IRenderChunkFactory;
import net.minecraft.client.renderer.chunk.ListChunkFactory;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.client.renderer.chunk.VboChunkFactory;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.culling.ClippingHelperImpl;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.shader.ShaderLinkHelper;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemRecord;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ClassInheritanceMultiMap;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Matrix4f;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vector3d;
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.chunk.Chunk;
import net.xtrafrancyz.covered.ObfValue;
import net.xtrafrancyz.mods.texteria.TexteriaOptions;
import optifine.CloudRenderer;
import optifine.Config;
import optifine.CustomColors;
import optifine.CustomSky;
import optifine.DynamicLights;
import optifine.Lagometer;
import optifine.RandomMobs;
import optifine.RenderInfoLazy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;
import shadersmod.client.Shaders;
import shadersmod.client.ShadersRender;
import shadersmod.client.ShadowUtils;

public class RenderGlobal implements IWorldAccess, IResourceManagerReloadListener
{
    private static final ObfValue.OFloat OBFVAL_yE88W = ObfValue.create(0.3F);
    private static final ObfValue.ODouble OBFVAL_b6suT = ObfValue.create(0.15D);
    private static final ObfValue.OInteger OBFVAL_lEpfw = ObfValue.create(771);
    private static final ObfValue.OInteger OBFVAL_0Vdx2 = ObfValue.create(4864);
    private static final ObfValue.OFloat OBFVAL_XbQDH = ObfValue.create(3000.0F);
    private static final ObfValue.ODouble OBFVAL_P3hmd = ObfValue.create(0.029999999329447746D);
    private static final ObfValue.ODouble OBFVAL_uwArG = ObfValue.create(2.0D);
    private static final ObfValue.OFloat OBFVAL_Gj2ce = ObfValue.create(16.0F);
    private static final ObfValue.ODouble OBFVAL_SbepZ = ObfValue.create(65.0D);
    private static final ObfValue.ODouble OBFVAL_hcvrF = ObfValue.create(1024.0D);
    private static final ObfValue.OInteger OBFVAL_66xZn = ObfValue.create(32888);
    private static final ObfValue.ODouble OBFVAL_1Rfmy = ObfValue.create(-5.0D);
    private static final ObfValue.OInteger OBFVAL_OCCnN = ObfValue.create(64);
    private static final ObfValue.OInteger OBFVAL_qB6X2 = ObfValue.create(5);
    private static final ObfValue.OFloat OBFVAL_x5114 = ObfValue.create(0.9F);
    private static final ObfValue.OInteger OBFVAL_H169w = ObfValue.create(770);
    private static final ObfValue.OFloat OBFVAL_t6AqD = ObfValue.create(0.04F);
    private static final ObfValue.OLong OBFVAL_JhC4g = ObfValue.create(3000L);
    private static final ObfValue.OFloat OBFVAL_lqmyH = ObfValue.create(2.6F);
    private static final ObfValue.ODouble OBFVAL_OByWz = ObfValue.create(Double.MIN_VALUE);
    private static final ObfValue.OInteger OBFVAL_28TmD = ObfValue.create(19);
    private static final ObfValue.OFloat OBFVAL_jN9o2 = ObfValue.create(0.25F);
    private static final ObfValue.OInteger OBFVAL_D44AL = ObfValue.create(516);
    private static final ObfValue.OInteger OBFVAL_zTw8w = ObfValue.create(1013);
    private static final ObfValue.OFloat OBFVAL_haVe5 = ObfValue.create(0.00390625F);
    private static final ObfValue.ODouble OBFVAL_VrdQ1 = ObfValue.create(38416.0D);
    private static final ObfValue.OFloat OBFVAL_yhkAO = ObfValue.create(0.8F);
    private static final ObfValue.OInteger OBFVAL_3fhZL = ObfValue.create(-256);
    private static final ObfValue.ODouble OBFVAL_toMYn = ObfValue.create(0.6D);
    private static final ObfValue.OInteger OBFVAL_rxz7p = ObfValue.create(4095);
    private static final ObfValue.ODouble OBFVAL_adJne = ObfValue.create(100.0D);
    private static final ObfValue.OFloat OBFVAL_plBla = ObfValue.create(0.002F);
    private static final ObfValue.OFloat OBFVAL_lvkuM = ObfValue.create(4.0F);
    private static final ObfValue.OInteger OBFVAL_mtcao = ObfValue.create(10243);
    private static final ObfValue.OLong OBFVAL_ZFSZz = ObfValue.create(10842L);
    private static final ObfValue.OInteger OBFVAL_KiCmU = ObfValue.create(16);
    private static final ObfValue.ODouble OBFVAL_hlZEE = ObfValue.create(-7.0D);
    private static final ObfValue.OFloat OBFVAL_SJwXh = ObfValue.create(8.0F);
    private static final ObfValue.OFloat OBFVAL_bdZXd = ObfValue.create(20.0F);
    private static final ObfValue.OInteger OBFVAL_EVLGo = ObfValue.create(400);
    private static final ObfValue.OInteger OBFVAL_oUqXi = ObfValue.create(10497);
    private static final ObfValue.ODouble OBFVAL_MGZdI = ObfValue.create(0.33000001311302185D);
    private static final ObfValue.OFloat OBFVAL_bnquL = ObfValue.create(4.8828125E-4F);
    private static final ObfValue.OInteger OBFVAL_V7GWb = ObfValue.create(3553);
    private static final ObfValue.OInteger OBFVAL_q9jRb = ObfValue.create(32886);
    private static final ObfValue.OInteger OBFVAL_TMgD9 = ObfValue.create(-3);
    private static final ObfValue.ODouble OBFVAL_S9073 = ObfValue.create(16.0D);
    private static final ObfValue.ODouble OBFVAL_ZyYkI = ObfValue.create(-1.0D);
    private static final ObfValue.OInteger OBFVAL_JuWx4 = ObfValue.create(7424);
    private static final ObfValue.OInteger OBFVAL_lYbKT = ObfValue.create(248);
    private static final ObfValue.OFloat OBFVAL_vbq75 = ObfValue.create(100.0F);
    private static final ObfValue.OFloat OBFVAL_uH7g9 = ObfValue.create(2.0F);
    private static final ObfValue.OInteger OBFVAL_fKov5 = ObfValue.create(1500);
    private static final ObfValue.OInteger OBFVAL_rtaa5 = ObfValue.create(2);
    private static final ObfValue.OInteger OBFVAL_jpFTG = ObfValue.create(1024);
    private static final ObfValue.OFloat OBFVAL_dTyRj = ObfValue.create(0.6F);
    private static final ObfValue.OInteger OBFVAL_Rll3I = ObfValue.create(7425);
    private static final ObfValue.OFloat OBFVAL_XegrR = ObfValue.create(120.0F);
    private static final ObfValue.OFloat OBFVAL_jJP6Z = ObfValue.create(40.0F);
    private static final ObfValue.OFloat OBFVAL_OlhPU = ObfValue.create(-3.0F);
    private static final ObfValue.ODouble OBFVAL_INAd0 = ObfValue.create((Math.PI * 2D));
    private static final ObfValue.OFloat OBFVAL_6wjOg = ObfValue.create(0.1F);
    private static final ObfValue.ODouble OBFVAL_MmhIX = ObfValue.create(1.0E8D);
    private static final ObfValue.OFloat OBFVAL_wTpdn = ObfValue.create(1.2F);
    private static final ObfValue.OFloat OBFVAL_po7Kq = ObfValue.create(9.765625E-4F);
    private static final ObfValue.OFloat OBFVAL_cHxlf = ObfValue.create(11.0F);
    private static final ObfValue.OFloat OBFVAL_bXioY = ObfValue.create(10.0F);
    private static final ObfValue.OInteger OBFVAL_Y7VKF = ObfValue.create(4);
    private static final ObfValue.OInteger OBFVAL_bVixy = ObfValue.create(15);
    private static final ObfValue.OFloat OBFVAL_NzYEr = ObfValue.create(180.0F);
    private static final ObfValue.OInteger OBFVAL_zK1hU = ObfValue.create(-384);
    private static final ObfValue.OFloat OBFVAL_28ANh = ObfValue.create(360.0F);
    private static final ObfValue.OFloat OBFVAL_mjsL2 = ObfValue.create(0.33F);
    private static final ObfValue.ODouble OBFVAL_P5cvI = ObfValue.create(4.0D);
    private static final ObfValue.OFloat OBFVAL_4U9SJ = ObfValue.create(5.0F);
    private static final ObfValue.OInteger OBFVAL_83tiZ = ObfValue.create(Integer.MIN_VALUE);
    private static final ObfValue.OFloat OBFVAL_gZxNZ = ObfValue.create((float)Math.PI);
    private static final ObfValue.ODouble OBFVAL_dvM3q = ObfValue.create(0.5D);
    private static final ObfValue.OInteger OBFVAL_V82SS = ObfValue.create(69696);
    private static final ObfValue.OInteger OBFVAL_QgPWL = ObfValue.create(384);
    private static final ObfValue.ODouble OBFVAL_yAWjx = ObfValue.create(-0.03D);
    private static final ObfValue.OFloat OBFVAL_OWM8I = ObfValue.create(70.0F);
    private static final ObfValue.OFloat OBFVAL_qwCjR = ObfValue.create(12.0F);
    private static final ObfValue.ODouble OBFVAL_ulxLf = ObfValue.create(256.0D);
    private static final ObfValue.OFloat OBFVAL_c0cPA = ObfValue.create(128.0F);
    private static final ObfValue.ODouble OBFVAL_PmzCb = ObfValue.create(2048.0D);
    private static final ObfValue.OInteger OBFVAL_3dHZx = ObfValue.create(100);
    private static final ObfValue.OFloat OBFVAL_blNh9 = ObfValue.create(0.4F);
    private static final ObfValue.OInteger OBFVAL_MIere = ObfValue.create(5126);
    private static final ObfValue.OFloat OBFVAL_hxVZE = ObfValue.create(-1.0F);
    private static final ObfValue.ODouble OBFVAL_9Vnjm = ObfValue.create(0.01D);
    private static final ObfValue.OInteger OBFVAL_LPKYV = ObfValue.create(12);
    private static final ObfValue.ODouble OBFVAL_dmDxa = ObfValue.create(0.4D);
    private static final ObfValue.OInteger OBFVAL_AxM1T = ObfValue.create(774);
    private static final ObfValue.OInteger OBFVAL_f8Aft = ObfValue.create(7);
    private static final ObfValue.OInteger OBFVAL_zg5AC = ObfValue.create(3);
    private static final ObfValue.OFloat OBFVAL_gbjs4 = ObfValue.create(0.75F);
    private static final ObfValue.ODouble OBFVAL_vn9NC = ObfValue.create(Math.PI);
    private static final ObfValue.OFloat OBFVAL_9JUa4 = ObfValue.create(-16.0F);
    private static final ObfValue.ODouble OBFVAL_w5WAs = ObfValue.create(0.06D);
    private static final ObfValue.OFloat OBFVAL_WAHjp = ObfValue.create(255.0F);
    private static final ObfValue.OFloat OBFVAL_a40Im = ObfValue.create(-90.0F);
    private static final ObfValue.ODouble OBFVAL_0ffrj = ObfValue.create(5.0D);
    private static final ObfValue.OFloat OBFVAL_Vpsum = ObfValue.create(0.017453292F);
    private static final ObfValue.OInteger OBFVAL_eIhCQ = ObfValue.create(10242);
    private static final ObfValue.ODouble OBFVAL_z4dU5 = ObfValue.create(12.0D);
    private static final ObfValue.OInteger OBFVAL_MBTlt = ObfValue.create(256);
    private static final ObfValue.OFloat OBFVAL_YPPef = ObfValue.create(0.05F);
    private static final ObfValue.OFloat OBFVAL_vDjW0 = ObfValue.create(0.2F);
    private static final ObfValue.OInteger OBFVAL_KpvWK = ObfValue.create(6);
    private static final ObfValue.OFloat OBFVAL_zclNP = ObfValue.create(-5.0F);
    private static final ObfValue.ODouble OBFVAL_pKgBW = ObfValue.create(4.8828125E-4D);
    private static final ObfValue.OFloat OBFVAL_QlAt4 = ObfValue.create(30.0F);
    private static final ObfValue.OInteger OBFVAL_eM2sh = ObfValue.create(61);
    private static final ObfValue.ODouble OBFVAL_zEVCT = ObfValue.create(0.15707963267948966D);
    private static final ObfValue.OFloat OBFVAL_eVH5D = ObfValue.create(90.0F);
    private static final ObfValue.OInteger OBFVAL_0yfOb = ObfValue.create(32884);
    private static final ObfValue.OInteger OBFVAL_8CIc8 = ObfValue.create(20);
    private static final ObfValue.ODouble OBFVAL_onbXx = ObfValue.create(0.3D);
    private static final ObfValue.ODouble OBFVAL_71JPV = ObfValue.create(-100.0D);
    private static final ObfValue.OInteger OBFVAL_JlNub = ObfValue.create(32);
    private static final ObfValue.OInteger OBFVAL_5rFY0 = ObfValue.create(2048);
    private static final ObfValue.OFloat OBFVAL_jRv9x = ObfValue.create(0.5F);
    private static final ObfValue.ODouble OBFVAL_Nfb8N = ObfValue.create(0.0020000000949949026D);
    private static final ObfValue.OInteger OBFVAL_rgMsi = ObfValue.create(10);
    private static final ObfValue.ODouble OBFVAL_EPEKk = ObfValue.create(0.1D);
    private static final ObfValue.OFloat OBFVAL_MA0pK = ObfValue.create(0.15F);
    private static final ObfValue.OInteger OBFVAL_V67xM = ObfValue.create(768);
    private static final ObfValue.ODouble OBFVAL_F149Y = ObfValue.create(0.2D);
    private static final ObfValue.OFloat OBFVAL_gcaBK = ObfValue.create(59.0F);
    private static final ObfValue.OInteger OBFVAL_iGVQx = ObfValue.create(40);
    private static final ObfValue.OInteger OBFVAL_NJbZB = ObfValue.create(8);
    private static final ObfValue.OInteger OBFVAL_eydYI = ObfValue.create(255);
    private static final ObfValue.OFloat OBFVAL_uLKjf = ObfValue.create(0.7F);
    private static final Logger logger = LogManager.getLogger();
    private static final ResourceLocation locationMoonPhasesPng = new ResourceLocation("textures/environment/moon_phases.png");
    private static final ResourceLocation locationSunPng = new ResourceLocation("textures/environment/sun.png");
    private static final ResourceLocation locationCloudsPng = new ResourceLocation("textures/environment/clouds.png");
    private static final ResourceLocation locationEndSkyPng = new ResourceLocation("textures/environment/end_sky.png");
    private static final ResourceLocation locationForcefieldPng = new ResourceLocation("textures/misc/forcefield.png");

    /** A reference to the Minecraft object. */
    public final Minecraft mc;

    /** The RenderEngine instance used by RenderGlobal */
    private final TextureManager renderEngine;
    private final RenderManager renderManager;
    private WorldClient theWorld;
    private Set chunksToUpdate = Sets.newLinkedHashSet();

    /** List of OpenGL lists for the current render pass */
    private List renderInfos;
    private final Set field_181024_n;
    private ViewFrustum viewFrustum;

    /** The star GL Call list */
    private int starGLCallList;

    /** OpenGL sky list */
    private int glSkyList;

    /** OpenGL sky list 2 */
    private int glSkyList2;
    private VertexFormat vertexBufferFormat;
    private VertexBuffer starVBO;
    private VertexBuffer skyVBO;
    private VertexBuffer sky2VBO;

    /**
     * counts the cloud render updates. Used with mod to stagger some updates
     */
    private int cloudTickCounter;

    /**
     * Stores blocks currently being broken. Key is entity ID of the thing doing the breaking. Value is a
     * DestroyBlockProgress
     */
    public final Map damagedBlocks;

    /** Currently playing sounds.  Type:  HashMap<ChunkCoordinates, ISound> */
    private final Map mapSoundPositions;
    private final TextureAtlasSprite[] destroyBlockIcons;
    private Framebuffer entityOutlineFramebuffer;

    /** Stores the shader group for the entity_outline shader */
    private ShaderGroup entityOutlineShader;
    private double frustumUpdatePosX;
    private double frustumUpdatePosY;
    private double frustumUpdatePosZ;
    private int frustumUpdatePosChunkX;
    private int frustumUpdatePosChunkY;
    private int frustumUpdatePosChunkZ;
    private double lastViewEntityX;
    private double lastViewEntityY;
    private double lastViewEntityZ;
    private double lastViewEntityPitch;
    private double lastViewEntityYaw;
    private final ChunkRenderDispatcher renderDispatcher;
    private ChunkRenderContainer renderContainer;
    private int renderDistanceChunks;

    /** Render entities startup counter (init value=2) */
    private int renderEntitiesStartupCounter;

    /** Count entities total */
    private int countEntitiesTotal;

    /** Count entities rendered */
    private int countEntitiesRendered;

    /** Count entities hidden */
    private int countEntitiesHidden;
    private boolean debugFixTerrainFrustum;
    private ClippingHelper debugFixedClippingHelper;
    private final Vector4f[] debugTerrainMatrix;
    private final Vector3d debugTerrainFrustumPosition;
    private boolean vboEnabled;
    IRenderChunkFactory renderChunkFactory;
    private double prevRenderSortX;
    private double prevRenderSortY;
    private double prevRenderSortZ;
    public boolean displayListEntitiesDirty;
    private static final String __OBFID = "CL_00000954";
    private CloudRenderer cloudRenderer;
    public Entity renderedEntity;
    public Set chunksToResortTransparency;
    public Set chunksToUpdateForced;
    private Deque visibilityDeque;
    private List renderInfosEntities;
    private List renderInfosTileEntities;
    private List renderInfosNormal;
    private List renderInfosEntitiesNormal;
    private List renderInfosTileEntitiesNormal;
    private List renderInfosShadow;
    private List renderInfosEntitiesShadow;
    private List renderInfosTileEntitiesShadow;
    private int renderDistance;
    private int renderDistanceSq;
    private static final Set SET_ALL_FACINGS = Collections.unmodifiableSet(new HashSet(Arrays.asList(EnumFacing.values())));
    private int countTileEntitiesRendered;

    public RenderGlobal(Minecraft mcIn)
    {
        this.renderInfos = Lists.newArrayListWithCapacity(OBFVAL_V82SS.get());
        this.field_181024_n = Sets.newHashSet();
        this.starGLCallList = -1;
        this.glSkyList = -1;
        this.glSkyList2 = -1;
        this.damagedBlocks = Maps.newHashMap();
        this.mapSoundPositions = Maps.newHashMap();
        this.destroyBlockIcons = new TextureAtlasSprite[OBFVAL_rgMsi.get()];
        this.frustumUpdatePosX = OBFVAL_OByWz.get();
        this.frustumUpdatePosY = OBFVAL_OByWz.get();
        this.frustumUpdatePosZ = OBFVAL_OByWz.get();
        this.frustumUpdatePosChunkX = OBFVAL_83tiZ.get();
        this.frustumUpdatePosChunkY = OBFVAL_83tiZ.get();
        this.frustumUpdatePosChunkZ = OBFVAL_83tiZ.get();
        this.lastViewEntityX = OBFVAL_OByWz.get();
        this.lastViewEntityY = OBFVAL_OByWz.get();
        this.lastViewEntityZ = OBFVAL_OByWz.get();
        this.lastViewEntityPitch = OBFVAL_OByWz.get();
        this.lastViewEntityYaw = OBFVAL_OByWz.get();
        this.renderDispatcher = new ChunkRenderDispatcher();
        this.renderDistanceChunks = -1;
        this.renderEntitiesStartupCounter = OBFVAL_rtaa5.get();
        this.debugFixTerrainFrustum = false;
        this.debugTerrainMatrix = new Vector4f[OBFVAL_NJbZB.get()];
        this.debugTerrainFrustumPosition = new Vector3d();
        this.vboEnabled = false;
        this.displayListEntitiesDirty = true;
        this.chunksToResortTransparency = new LinkedHashSet();
        this.chunksToUpdateForced = new LinkedHashSet();
        this.visibilityDeque = new ArrayDeque();
        this.renderInfosEntities = new ArrayList(OBFVAL_jpFTG.get());
        this.renderInfosTileEntities = new ArrayList(OBFVAL_jpFTG.get());
        this.renderInfosNormal = new ArrayList(OBFVAL_jpFTG.get());
        this.renderInfosEntitiesNormal = new ArrayList(OBFVAL_jpFTG.get());
        this.renderInfosTileEntitiesNormal = new ArrayList(OBFVAL_jpFTG.get());
        this.renderInfosShadow = new ArrayList(OBFVAL_jpFTG.get());
        this.renderInfosEntitiesShadow = new ArrayList(OBFVAL_jpFTG.get());
        this.renderInfosTileEntitiesShadow = new ArrayList(OBFVAL_jpFTG.get());
        this.renderDistance = 0;
        this.renderDistanceSq = 0;
        this.cloudRenderer = new CloudRenderer(mcIn);
        this.mc = mcIn;
        this.renderManager = mcIn.getRenderManager();
        this.renderEngine = mcIn.getTextureManager();
        this.renderEngine.bindTexture(locationForcefieldPng);
        GL11.glTexParameteri(OBFVAL_V7GWb.get(), OBFVAL_eIhCQ.get(), OBFVAL_oUqXi.get());
        GL11.glTexParameteri(OBFVAL_V7GWb.get(), OBFVAL_mtcao.get(), OBFVAL_oUqXi.get());
        GlStateManager.bindTexture(0);
        this.updateDestroyBlockIcons();
        this.vboEnabled = OpenGlHelper.useVbo();

        if (this.vboEnabled)
        {
            this.renderContainer = new VboRenderList();
            this.renderChunkFactory = new VboChunkFactory();
        }
        else
        {
            this.renderContainer = new RenderList();
            this.renderChunkFactory = new ListChunkFactory();
        }

        this.vertexBufferFormat = new VertexFormat();
        this.vertexBufferFormat.func_181721_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.POSITION, OBFVAL_zg5AC.get()));
        this.generateStars();
        this.generateSky();
        this.generateSky2();
    }

    public void onResourceManagerReload(IResourceManager resourceManager)
    {
        this.updateDestroyBlockIcons();
    }

    private void updateDestroyBlockIcons()
    {
        TextureMap texturemap = this.mc.getTextureMapBlocks();

        for (int i = 0; i < this.destroyBlockIcons.length; ++i)
        {
            this.destroyBlockIcons[i] = texturemap.getAtlasSprite("minecraft:blocks/destroy_stage_" + i);
        }
    }

    /**
     * Creates the entity outline shader to be stored in RenderGlobal.entityOutlineShader
     */
    public void makeEntityOutlineShader()
    {
        if (OpenGlHelper.shadersSupported)
        {
            if (ShaderLinkHelper.getStaticShaderLinkHelper() == null)
            {
                ShaderLinkHelper.setNewStaticShaderLinkHelper();
            }

            ResourceLocation resourcelocation = new ResourceLocation("shaders/post/entity_outline.json");

            try
            {
                this.entityOutlineShader = new ShaderGroup(this.mc.getTextureManager(), this.mc.getResourceManager(), this.mc.getFramebuffer(), resourcelocation);
                this.entityOutlineShader.createBindFramebuffers(this.mc.displayWidth, this.mc.displayHeight);
                this.entityOutlineFramebuffer = this.entityOutlineShader.getFramebufferRaw("final");
            }
            catch (IOException ioexception)
            {
                logger.warn((String)("Failed to load shader: " + resourcelocation), (Throwable)ioexception);
                this.entityOutlineShader = null;
                this.entityOutlineFramebuffer = null;
            }
            catch (JsonSyntaxException jsonsyntaxexception)
            {
                logger.warn((String)("Failed to load shader: " + resourcelocation), (Throwable)jsonsyntaxexception);
                this.entityOutlineShader = null;
                this.entityOutlineFramebuffer = null;
            }
        }
        else
        {
            this.entityOutlineShader = null;
            this.entityOutlineFramebuffer = null;
        }
    }

    public void renderEntityOutlineFramebuffer()
    {
        if (this.isRenderEntityOutlines())
        {
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(OBFVAL_H169w.get(), OBFVAL_lEpfw.get(), 0, 1);
            this.entityOutlineFramebuffer.framebufferRenderExt(this.mc.displayWidth, this.mc.displayHeight, false);
            GlStateManager.disableBlend();
        }
    }

    protected boolean isRenderEntityOutlines()
    {
        return !Config.isFastRender() && !Config.isShaders() && !Config.isAntialiasing() ? this.entityOutlineFramebuffer != null && this.entityOutlineShader != null && this.mc.thePlayer != null : false;
    }

    private void generateSky2()
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();

        if (this.sky2VBO != null)
        {
            this.sky2VBO.deleteGlBuffers();
        }

        if (this.glSkyList2 >= 0)
        {
            GLAllocation.deleteDisplayLists(this.glSkyList2);
            this.glSkyList2 = -1;
        }

        if (this.vboEnabled)
        {
            this.sky2VBO = new VertexBuffer(this.vertexBufferFormat);
            this.renderSky(worldrenderer, OBFVAL_9JUa4.get(), true);
            worldrenderer.finishDrawing();
            worldrenderer.reset();
            this.sky2VBO.func_181722_a(worldrenderer.getByteBuffer());
        }
        else
        {
            this.glSkyList2 = GLAllocation.generateDisplayLists(1);
            GL11.glNewList(this.glSkyList2, OBFVAL_0Vdx2.get());
            this.renderSky(worldrenderer, OBFVAL_9JUa4.get(), true);
            tessellator.draw();
            GL11.glEndList();
        }
    }

    private void generateSky()
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();

        if (this.skyVBO != null)
        {
            this.skyVBO.deleteGlBuffers();
        }

        if (this.glSkyList >= 0)
        {
            GLAllocation.deleteDisplayLists(this.glSkyList);
            this.glSkyList = -1;
        }

        if (this.vboEnabled)
        {
            this.skyVBO = new VertexBuffer(this.vertexBufferFormat);
            this.renderSky(worldrenderer, OBFVAL_Gj2ce.get(), false);
            worldrenderer.finishDrawing();
            worldrenderer.reset();
            this.skyVBO.func_181722_a(worldrenderer.getByteBuffer());
        }
        else
        {
            this.glSkyList = GLAllocation.generateDisplayLists(1);
            GL11.glNewList(this.glSkyList, OBFVAL_0Vdx2.get());
            this.renderSky(worldrenderer, OBFVAL_Gj2ce.get(), false);
            tessellator.draw();
            GL11.glEndList();
        }
    }

    private void renderSky(WorldRenderer worldRendererIn, float p_174968_2_, boolean p_174968_3_)
    {
        boolean flag = true;
        boolean flag1 = true;
        worldRendererIn.begin(OBFVAL_f8Aft.get(), DefaultVertexFormats.POSITION);

        for (int i = OBFVAL_zK1hU.get(); i <= OBFVAL_QgPWL.get(); i += 64)
        {
            for (int j = OBFVAL_zK1hU.get(); j <= OBFVAL_QgPWL.get(); j += 64)
            {
                float f = (float)i;
                float f1 = (float)(i + OBFVAL_OCCnN.get());

                if (p_174968_3_)
                {
                    f1 = (float)i;
                    f = (float)(i + OBFVAL_OCCnN.get());
                }

                worldRendererIn.pos((double)f, (double)p_174968_2_, (double)j).endVertex();
                worldRendererIn.pos((double)f1, (double)p_174968_2_, (double)j).endVertex();
                worldRendererIn.pos((double)f1, (double)p_174968_2_, (double)(j + OBFVAL_OCCnN.get())).endVertex();
                worldRendererIn.pos((double)f, (double)p_174968_2_, (double)(j + OBFVAL_OCCnN.get())).endVertex();
            }
        }
    }

    private void generateStars()
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();

        if (this.starVBO != null)
        {
            this.starVBO.deleteGlBuffers();
        }

        if (this.starGLCallList >= 0)
        {
            GLAllocation.deleteDisplayLists(this.starGLCallList);
            this.starGLCallList = -1;
        }

        if (this.vboEnabled)
        {
            this.starVBO = new VertexBuffer(this.vertexBufferFormat);
            this.renderStars(worldrenderer);
            worldrenderer.finishDrawing();
            worldrenderer.reset();
            this.starVBO.func_181722_a(worldrenderer.getByteBuffer());
        }
        else
        {
            this.starGLCallList = GLAllocation.generateDisplayLists(1);
            GlStateManager.pushMatrix();
            GL11.glNewList(this.starGLCallList, OBFVAL_0Vdx2.get());
            this.renderStars(worldrenderer);
            tessellator.draw();
            GL11.glEndList();
            GlStateManager.popMatrix();
        }
    }

    private void renderStars(WorldRenderer worldRendererIn)
    {
        Random random = new Random(OBFVAL_ZFSZz.get());
        worldRendererIn.begin(OBFVAL_f8Aft.get(), DefaultVertexFormats.POSITION);

        for (int i = 0; i < OBFVAL_fKov5.get(); ++i)
        {
            double d0 = (double)(random.nextFloat() * OBFVAL_uH7g9.get() - 1.0F);
            double d1 = (double)(random.nextFloat() * OBFVAL_uH7g9.get() - 1.0F);
            double d2 = (double)(random.nextFloat() * OBFVAL_uH7g9.get() - 1.0F);
            double d3 = (double)(OBFVAL_MA0pK.get() + random.nextFloat() * OBFVAL_6wjOg.get());
            double d4 = d0 * d0 + d1 * d1 + d2 * d2;

            if (d4 < 1.0D && d4 > OBFVAL_9Vnjm.get())
            {
                d4 = 1.0D / Math.sqrt(d4);
                d0 = d0 * d4;
                d1 = d1 * d4;
                d2 = d2 * d4;
                double d5 = d0 * OBFVAL_adJne.get();
                double d6 = d1 * OBFVAL_adJne.get();
                double d7 = d2 * OBFVAL_adJne.get();
                double d8 = Math.atan2(d0, d2);
                double d9 = Math.sin(d8);
                double d10 = Math.cos(d8);
                double d11 = Math.atan2(Math.sqrt(d0 * d0 + d2 * d2), d1);
                double d12 = Math.sin(d11);
                double d13 = Math.cos(d11);
                double d14 = random.nextDouble() * OBFVAL_vn9NC.get() * OBFVAL_uwArG.get();
                double d15 = Math.sin(d14);
                double d16 = Math.cos(d14);

                for (int j = 0; j < OBFVAL_Y7VKF.get(); ++j)
                {
                    double d17 = 0.0D;
                    double d18 = (double)((j & OBFVAL_rtaa5.get()) - 1) * d3;
                    double d19 = (double)((j + 1 & OBFVAL_rtaa5.get()) - 1) * d3;
                    double d20 = 0.0D;
                    double d21 = d18 * d16 - d19 * d15;
                    double d22 = d19 * d16 + d18 * d15;
                    double d23 = d21 * d12 + 0.0D * d13;
                    double d24 = 0.0D * d12 - d21 * d13;
                    double d25 = d24 * d9 - d22 * d10;
                    double d26 = d22 * d9 + d24 * d10;
                    worldRendererIn.pos(d5 + d25, d6 + d23, d7 + d26).endVertex();
                }
            }
        }
    }

    /**
     * set null to clear
     */
    public void setWorldAndLoadRenderers(WorldClient worldClientIn)
    {
        if (this.theWorld != null)
        {
            this.theWorld.removeWorldAccess(this);
        }

        this.frustumUpdatePosX = OBFVAL_OByWz.get();
        this.frustumUpdatePosY = OBFVAL_OByWz.get();
        this.frustumUpdatePosZ = OBFVAL_OByWz.get();
        this.frustumUpdatePosChunkX = OBFVAL_83tiZ.get();
        this.frustumUpdatePosChunkY = OBFVAL_83tiZ.get();
        this.frustumUpdatePosChunkZ = OBFVAL_83tiZ.get();
        this.renderManager.set(worldClientIn);
        this.theWorld = worldClientIn;

        if (Config.isDynamicLights())
        {
            DynamicLights.clear();
        }

        if (worldClientIn != null)
        {
            worldClientIn.addWorldAccess(this);
            this.loadRenderers();
        }
    }

    /**
     * Loads all the renderers and sets up the basic settings usage
     */
    public void loadRenderers()
    {
        if (this.theWorld != null)
        {
            this.displayListEntitiesDirty = true;
            Blocks.leaves.setGraphicsLevel(Config.isTreesFancy());
            Blocks.leaves2.setGraphicsLevel(Config.isTreesFancy());
            BlockModelRenderer.updateAoLightValue();

            if (Config.isDynamicLights())
            {
                DynamicLights.clear();
            }

            this.renderDistanceChunks = this.mc.gameSettings.renderDistanceChunks;
            this.renderDistance = this.renderDistanceChunks * OBFVAL_KiCmU.get();
            this.renderDistanceSq = this.renderDistance * this.renderDistance;
            boolean flag = this.vboEnabled;
            this.vboEnabled = OpenGlHelper.useVbo();

            if (flag && !this.vboEnabled)
            {
                this.renderContainer = new RenderList();
                this.renderChunkFactory = new ListChunkFactory();
            }
            else if (!flag && this.vboEnabled)
            {
                this.renderContainer = new VboRenderList();
                this.renderChunkFactory = new VboChunkFactory();
            }

            if (flag != this.vboEnabled)
            {
                this.generateStars();
                this.generateSky();
                this.generateSky2();
            }

            if (this.viewFrustum != null)
            {
                this.viewFrustum.deleteGlResources();
            }

            this.stopChunkUpdates();
            Set entity = this.field_181024_n;

            synchronized (this.field_181024_n)
            {
                this.field_181024_n.clear();
            }

            this.viewFrustum = new ViewFrustum(this.theWorld, this.mc.gameSettings.renderDistanceChunks, this, this.renderChunkFactory);

            if (this.theWorld != null)
            {
                Entity entity = this.mc.getRenderViewEntity();

                if (entity != null)
                {
                    this.viewFrustum.updateChunkPositions(entity.posX, entity.posZ);
                }
            }

            this.renderEntitiesStartupCounter = OBFVAL_rtaa5.get();
        }
    }

    protected void stopChunkUpdates()
    {
        this.chunksToUpdate.clear();
        this.renderDispatcher.stopChunkUpdates();
    }

    public void createBindEntityOutlineFbs(int p_72720_1_, int p_72720_2_)
    {
        if (OpenGlHelper.shadersSupported && this.entityOutlineShader != null)
        {
            this.entityOutlineShader.createBindFramebuffers(p_72720_1_, p_72720_2_);
        }
    }

    public void renderEntities(Entity renderViewEntity, ICamera camera, float partialTicks)
    {
        int i = 0;

        if (this.renderEntitiesStartupCounter > 0)
        {
            if (i > 0)
            {
                return;
            }

            --this.renderEntitiesStartupCounter;
        }
        else
        {
            double d0 = renderViewEntity.prevPosX + (renderViewEntity.posX - renderViewEntity.prevPosX) * (double)partialTicks;
            double d1 = renderViewEntity.prevPosY + (renderViewEntity.posY - renderViewEntity.prevPosY) * (double)partialTicks;
            double d2 = renderViewEntity.prevPosZ + (renderViewEntity.posZ - renderViewEntity.prevPosZ) * (double)partialTicks;
            this.theWorld.theProfiler.startSection("prepare");
            TileEntityRendererDispatcher.instance.cacheActiveRenderInfo(this.theWorld, this.mc.getTextureManager(), this.mc.fontRendererObj, this.mc.getRenderViewEntity(), partialTicks);
            this.renderManager.cacheActiveRenderInfo(this.theWorld, this.mc.fontRendererObj, this.mc.getRenderViewEntity(), this.mc.pointedEntity, this.mc.gameSettings, partialTicks);

            if (i == 0)
            {
                this.countEntitiesTotal = 0;
                this.countEntitiesRendered = 0;
                this.countEntitiesHidden = 0;
                this.countTileEntitiesRendered = 0;
            }

            Entity entity = this.mc.getRenderViewEntity();
            double d3 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)partialTicks;
            double d4 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)partialTicks;
            double d5 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)partialTicks;
            TileEntityRendererDispatcher.staticPlayerX = d3;
            TileEntityRendererDispatcher.staticPlayerY = d4;
            TileEntityRendererDispatcher.staticPlayerZ = d5;
            this.renderManager.setRenderPosition(d3, d4, d5);
            this.mc.entityRenderer.enableLightmap();
            this.theWorld.theProfiler.endStartSection("global");
            List<Entity> list = this.theWorld.getLoadedEntityList();

            if (i == 0)
            {
                this.countEntitiesTotal = list.size();
            }

            if (Config.isFogOff() && this.mc.entityRenderer.fogStandard)
            {
                GlStateManager.disableFog();
            }

            for (int j = 0; j < this.theWorld.weatherEffects.size(); ++j)
            {
                Entity entity1 = (Entity)this.theWorld.weatherEffects.get(j);
                ++this.countEntitiesRendered;

                if (entity1.isInRangeToRender3d(d0, d1, d2))
                {
                    this.renderManager.renderEntitySimple(entity1, partialTicks);
                }
            }

            if (this.isRenderEntityOutlines() && !list.isEmpty())
            {
                ;
            }

            this.theWorld.theProfiler.endStartSection("entities");
            boolean flag3 = Config.isShaders();

            if (flag3)
            {
                Shaders.beginEntities();
            }

            Iterator iterator1 = this.renderInfosEntities.iterator();
            boolean flag = this.mc.gameSettings.fancyGraphics;
            this.mc.gameSettings.fancyGraphics = Config.isDroppedItemsFancy();
            label538:

            while (iterator1.hasNext())
            {
                RenderGlobal.ContainerLocalRenderInformation renderglobal$containerlocalrenderinformation = (RenderGlobal.ContainerLocalRenderInformation)iterator1.next();
                Chunk chunk = this.theWorld.getChunkFromBlockCoords(renderglobal$containerlocalrenderinformation.renderChunk.getPosition());
                ClassInheritanceMultiMap classinheritancemultimap = chunk.getEntityLists()[renderglobal$containerlocalrenderinformation.renderChunk.getPosition().getY() / OBFVAL_KiCmU.get()];

                if (!classinheritancemultimap.isEmpty())
                {
                    Iterator iterator = classinheritancemultimap.iterator();

                    while (true)
                    {
                        Entity entity2;
                        boolean flag1;

                        while (true)
                        {
                            if (!iterator.hasNext())
                            {
                                continue label538;
                            }

                            entity2 = (Entity)iterator.next();
                            flag1 = this.renderManager.shouldRender(entity2, camera, d0, d1, d2) || entity2.riddenByEntity == this.mc.thePlayer;

                            if (!flag1)
                            {
                                break;
                            }

                            boolean flag2 = this.mc.getRenderViewEntity() instanceof EntityLivingBase ? ((EntityLivingBase)this.mc.getRenderViewEntity()).isPlayerSleeping() : false;

                            if ((entity2 != this.mc.getRenderViewEntity() || this.mc.gameSettings.thirdPersonView != 0 || flag2) && (entity2.posY < 0.0D || entity2.posY >= OBFVAL_ulxLf.get() || this.theWorld.isBlockLoaded(new BlockPos(entity2))))
                            {
                                ++this.countEntitiesRendered;

                                if (entity2.getClass() == EntityItemFrame.class)
                                {
                                    entity2.renderDistanceWeight = OBFVAL_w5WAs.get();
                                }

                                this.renderedEntity = entity2;

                                if (flag3)
                                {
                                    Shaders.nextEntity(entity2);
                                }

                                this.renderManager.renderEntitySimple(entity2, partialTicks);
                                this.renderedEntity = null;
                                break;
                            }
                        }

                        if (!flag1 && entity2 instanceof EntityWitherSkull)
                        {
                            if (flag3)
                            {
                                Shaders.nextEntity(entity2);
                            }

                            this.mc.getRenderManager().renderWitherSkull(entity2, partialTicks);
                        }
                    }
                }
            }

            this.mc.gameSettings.fancyGraphics = flag;
            FontRenderer fontrenderer = TileEntityRendererDispatcher.instance.getFontRenderer();

            if (flag3)
            {
                Shaders.endEntities();
                Shaders.beginBlockEntities();
            }

            this.theWorld.theProfiler.endStartSection("blockentities");
            RenderHelper.enableStandardItemLighting();

            for (Object object : this.renderInfosTileEntities)
            {
                RenderGlobal.ContainerLocalRenderInformation renderglobal$containerlocalrenderinformation1 = (RenderGlobal.ContainerLocalRenderInformation)object;
                List list1 = renderglobal$containerlocalrenderinformation1.renderChunk.getCompiledChunk().getTileEntities();

                if (!list1.isEmpty())
                {
                    for (TileEntity tileentity1 : list1)
                    {
                        Class oclass = tileentity1.getClass();

                        if (oclass == TileEntitySign.class && !Config.zoomMode)
                        {
                            EntityPlayer entityplayer = this.mc.thePlayer;
                            double d6 = tileentity1.getDistanceSq(entityplayer.posX, entityplayer.posY, entityplayer.posZ);

                            if (d6 > OBFVAL_ulxLf.get())
                            {
                                fontrenderer.enabled = false;
                            }
                        }

                        if (flag3)
                        {
                            Shaders.nextBlockEntity(tileentity1);
                        }

                        TileEntityRendererDispatcher.instance.renderTileEntity(tileentity1, partialTicks, -1);
                        ++this.countTileEntitiesRendered;
                        fontrenderer.enabled = true;
                    }
                }
            }

            Set set = this.field_181024_n;

            synchronized (this.field_181024_n)
            {
                for (Object object2 : this.field_181024_n)
                {
                    Class oclass1 = object2.getClass();

                    if (oclass1 == TileEntitySign.class && !Config.zoomMode)
                    {
                        EntityPlayer entityplayer1 = this.mc.thePlayer;
                        double d7 = ((TileEntity)object2).getDistanceSq(entityplayer1.posX, entityplayer1.posY, entityplayer1.posZ);

                        if (d7 > OBFVAL_ulxLf.get())
                        {
                            fontrenderer.enabled = false;
                        }
                    }

                    if (flag3)
                    {
                        Shaders.nextBlockEntity((TileEntity)object2);
                    }

                    TileEntityRendererDispatcher.instance.renderTileEntity((TileEntity)object2, partialTicks, -1);
                    fontrenderer.enabled = true;
                }
            }

            this.preRenderDamagedBlocks();

            for (Object object1 : this.damagedBlocks.values())
            {
                BlockPos blockpos = ((DestroyBlockProgress)object1).getPosition();
                TileEntity tileentity = this.theWorld.getTileEntity(blockpos);

                if (tileentity instanceof TileEntityChest)
                {
                    TileEntityChest tileentitychest = (TileEntityChest)tileentity;

                    if (tileentitychest.adjacentChestXNeg != null)
                    {
                        blockpos = blockpos.offset(EnumFacing.WEST);
                        tileentity = this.theWorld.getTileEntity(blockpos);
                    }
                    else if (tileentitychest.adjacentChestZNeg != null)
                    {
                        blockpos = blockpos.offset(EnumFacing.NORTH);
                        tileentity = this.theWorld.getTileEntity(blockpos);
                    }
                }

                Block block = this.theWorld.getBlockState(blockpos).getBlock();
                boolean flag4 = tileentity != null && (block instanceof BlockChest || block instanceof BlockEnderChest || block instanceof BlockSign || block instanceof BlockSkull);

                if (flag4)
                {
                    if (flag3)
                    {
                        Shaders.nextBlockEntity(tileentity);
                    }

                    TileEntityRendererDispatcher.instance.renderTileEntity(tileentity, partialTicks, ((DestroyBlockProgress)object1).getPartialBlockDamage());
                }
            }

            this.postRenderDamagedBlocks();
            this.mc.entityRenderer.disableLightmap();
            this.mc.mcProfiler.endSection();
        }
    }

    /**
     * Gets the render info for use on the Debug screen
     */
    public String getDebugInfoRenders()
    {
        int i = this.viewFrustum.renderChunks.length;
        int j = 0;

        for (Object object : this.renderInfos)
        {
            RenderGlobal.ContainerLocalRenderInformation renderglobal$containerlocalrenderinformation = (RenderGlobal.ContainerLocalRenderInformation)object;
            CompiledChunk compiledchunk = renderglobal$containerlocalrenderinformation.renderChunk.compiledChunk;

            if (compiledchunk != CompiledChunk.DUMMY && !compiledchunk.isEmpty())
            {
                ++j;
            }
        }

        Object[] aobject = new Object[OBFVAL_qB6X2.get()];
        aobject[0] = Integer.valueOf(j);
        aobject[1] = Integer.valueOf(i);
        aobject[OBFVAL_rtaa5.get()] = this.mc.renderChunksMany ? "(s) " : "";
        aobject[OBFVAL_zg5AC.get()] = Integer.valueOf(this.renderDistanceChunks);
        aobject[OBFVAL_Y7VKF.get()] = this.renderDispatcher.getDebugInfo();
        return String.format("C: %d/%d %sD: %d, %s", aobject);
    }

    /**
     * Gets the entities info for use on the Debug screen
     */
    public String getDebugInfoEntities()
    {
        return "Entities: " + this.countEntitiesRendered + "/" + this.countEntitiesTotal + ", B: " + this.countEntitiesHidden + ", I: " + (this.countEntitiesTotal - this.countEntitiesHidden - this.countEntitiesRendered);
    }

    public void setupTerrain(Entity viewEntity, double partialTicks, ICamera camera, int frameCount, boolean playerSpectator)
    {
        if (this.mc.gameSettings.renderDistanceChunks != this.renderDistanceChunks)
        {
            this.loadRenderers();
        }

        this.theWorld.theProfiler.startSection("camera");
        double d0 = viewEntity.posX - this.frustumUpdatePosX;
        double d1 = viewEntity.posY - this.frustumUpdatePosY;
        double d2 = viewEntity.posZ - this.frustumUpdatePosZ;

        if (this.frustumUpdatePosChunkX != viewEntity.chunkCoordX || this.frustumUpdatePosChunkY != viewEntity.chunkCoordY || this.frustumUpdatePosChunkZ != viewEntity.chunkCoordZ || d0 * d0 + d1 * d1 + d2 * d2 > OBFVAL_S9073.get())
        {
            this.frustumUpdatePosX = viewEntity.posX;
            this.frustumUpdatePosY = viewEntity.posY;
            this.frustumUpdatePosZ = viewEntity.posZ;
            this.frustumUpdatePosChunkX = viewEntity.chunkCoordX;
            this.frustumUpdatePosChunkY = viewEntity.chunkCoordY;
            this.frustumUpdatePosChunkZ = viewEntity.chunkCoordZ;
            this.viewFrustum.updateChunkPositions(viewEntity.posX, viewEntity.posZ);
        }

        if (Config.isDynamicLights())
        {
            DynamicLights.update(this);
        }

        this.theWorld.theProfiler.endStartSection("renderlistcamera");
        double d3 = viewEntity.lastTickPosX + (viewEntity.posX - viewEntity.lastTickPosX) * partialTicks;
        double d4 = viewEntity.lastTickPosY + (viewEntity.posY - viewEntity.lastTickPosY) * partialTicks;
        double d5 = viewEntity.lastTickPosZ + (viewEntity.posZ - viewEntity.lastTickPosZ) * partialTicks;
        this.renderContainer.initialize(d3, d4, d5);
        this.theWorld.theProfiler.endStartSection("cull");

        if (this.debugFixedClippingHelper != null)
        {
            Frustum frustum = new Frustum(this.debugFixedClippingHelper);
            frustum.setPosition(this.debugTerrainFrustumPosition.field_181059_a, this.debugTerrainFrustumPosition.field_181060_b, this.debugTerrainFrustumPosition.field_181061_c);
            camera = frustum;
        }

        this.mc.mcProfiler.endStartSection("culling");
        BlockPos blockpos3 = new BlockPos(d3, d4 + (double)viewEntity.getEyeHeight(), d5);
        RenderChunk renderchunk = this.viewFrustum.getRenderChunk(blockpos3);
        BlockPos blockpos = new BlockPos(MathHelper.floor_double(d3 / OBFVAL_S9073.get()) * OBFVAL_KiCmU.get(), MathHelper.floor_double(d4 / OBFVAL_S9073.get()) * OBFVAL_KiCmU.get(), MathHelper.floor_double(d5 / OBFVAL_S9073.get()) * OBFVAL_KiCmU.get());
        this.displayListEntitiesDirty = this.displayListEntitiesDirty || !this.chunksToUpdate.isEmpty() || viewEntity.posX != this.lastViewEntityX || viewEntity.posY != this.lastViewEntityY || viewEntity.posZ != this.lastViewEntityZ || (double)viewEntity.rotationPitch != this.lastViewEntityPitch || (double)viewEntity.rotationYaw != this.lastViewEntityYaw;
        this.lastViewEntityX = viewEntity.posX;
        this.lastViewEntityY = viewEntity.posY;
        this.lastViewEntityZ = viewEntity.posZ;
        this.lastViewEntityPitch = (double)viewEntity.rotationPitch;
        this.lastViewEntityYaw = (double)viewEntity.rotationYaw;
        boolean flag = this.debugFixedClippingHelper != null;
        Lagometer.timerVisibility.start();

        if (Shaders.isShadowPass)
        {
            this.renderInfos = this.renderInfosShadow;
            this.renderInfosEntities = this.renderInfosEntitiesShadow;
            this.renderInfosTileEntities = this.renderInfosTileEntitiesShadow;

            if (!flag && this.displayListEntitiesDirty)
            {
                this.renderInfos.clear();
                this.renderInfosEntities.clear();
                this.renderInfosTileEntities.clear();
                RenderInfoLazy renderinfolazy = new RenderInfoLazy();
                Iterator<RenderChunk> iterator = ShadowUtils.makeShadowChunkIterator(this.theWorld, partialTicks, viewEntity, this.renderDistanceChunks, this.viewFrustum);

                while (iterator.hasNext())
                {
                    RenderChunk renderchunk1 = (RenderChunk)iterator.next();

                    if (renderchunk1 != null)
                    {
                        renderinfolazy.setRenderChunk(renderchunk1);

                        if (!renderchunk1.compiledChunk.isEmpty() || renderchunk1.isNeedsUpdate())
                        {
                            this.renderInfos.add(renderinfolazy.getRenderInfo());
                        }

                        BlockPos blockpos1 = renderchunk1.getPosition();

                        if (this.theWorld.getChunkFromBlockCoords(blockpos1).hasEntities)
                        {
                            this.renderInfosEntities.add(renderinfolazy.getRenderInfo());
                        }

                        if (renderchunk1.getCompiledChunk().getTileEntities().size() > 0)
                        {
                            this.renderInfosTileEntities.add(renderinfolazy.getRenderInfo());
                        }
                    }
                }
            }
        }
        else
        {
            this.renderInfos = this.renderInfosNormal;
            this.renderInfosEntities = this.renderInfosEntitiesNormal;
            this.renderInfosTileEntities = this.renderInfosTileEntitiesNormal;
        }

        if (!flag && this.displayListEntitiesDirty && !Shaders.isShadowPass)
        {
            this.displayListEntitiesDirty = false;
            this.renderInfos.clear();
            this.renderInfosEntities.clear();
            this.renderInfosTileEntities.clear();
            this.visibilityDeque.clear();
            Deque deque = this.visibilityDeque;
            boolean flag1 = this.mc.renderChunksMany;

            if (renderchunk != null)
            {
                boolean flag2 = false;
                RenderGlobal.ContainerLocalRenderInformation renderglobal$containerlocalrenderinformation2 = new RenderGlobal.ContainerLocalRenderInformation(renderchunk, (EnumFacing)null, 0, (Object)null);
                Set set1 = SET_ALL_FACINGS;

                if (set1.size() == 1)
                {
                    Vector3f vector3f = this.getViewVector(viewEntity, partialTicks);
                    EnumFacing enumfacing = EnumFacing.getFacingFromVector(vector3f.x, vector3f.y, vector3f.z).getOpposite();
                    set1.remove(enumfacing);
                }

                if (set1.isEmpty())
                {
                    flag2 = true;
                }

                if (flag2 && !playerSpectator)
                {
                    this.renderInfos.add(renderglobal$containerlocalrenderinformation2);
                }
                else
                {
                    if (playerSpectator && this.theWorld.getBlockState(blockpos3).getBlock().isOpaqueCube())
                    {
                        flag1 = false;
                    }

                    renderchunk.setFrameIndex(frameCount);
                    deque.add(renderglobal$containerlocalrenderinformation2);
                }
            }
            else
            {
                int k = blockpos3.getY() > 0 ? OBFVAL_lYbKT.get() : OBFVAL_NJbZB.get();

                for (int l = -this.renderDistanceChunks; l <= this.renderDistanceChunks; ++l)
                {
                    for (int i = -this.renderDistanceChunks; i <= this.renderDistanceChunks; ++i)
                    {
                        RenderChunk renderchunk2 = this.viewFrustum.getRenderChunk(new BlockPos((l << OBFVAL_Y7VKF.get()) + OBFVAL_NJbZB.get(), k, (i << OBFVAL_Y7VKF.get()) + OBFVAL_NJbZB.get()));

                        if (renderchunk2 != null && ((ICamera)camera).isBoundingBoxInFrustum(renderchunk2.boundingBox))
                        {
                            renderchunk2.setFrameIndex(frameCount);
                            deque.add(new RenderGlobal.ContainerLocalRenderInformation(renderchunk2, (EnumFacing)null, 0, (Object)null));
                        }
                    }
                }
            }

            EnumFacing[] aenumfacing = EnumFacing.values();
            int i1 = aenumfacing.length;

            while (!deque.isEmpty())
            {
                RenderGlobal.ContainerLocalRenderInformation renderglobal$containerlocalrenderinformation3 = (RenderGlobal.ContainerLocalRenderInformation)deque.poll();
                RenderChunk renderchunk5 = renderglobal$containerlocalrenderinformation3.renderChunk;
                EnumFacing enumfacing2 = renderglobal$containerlocalrenderinformation3.facing;
                BlockPos blockpos2 = renderchunk5.getPosition();

                if (!renderchunk5.compiledChunk.isEmpty() || renderchunk5.isNeedsUpdate())
                {
                    this.renderInfos.add(renderglobal$containerlocalrenderinformation3);
                }

                if (this.theWorld.getChunkFromBlockCoords(blockpos2).hasEntities)
                {
                    this.renderInfosEntities.add(renderglobal$containerlocalrenderinformation3);
                }

                if (renderchunk5.getCompiledChunk().getTileEntities().size() > 0)
                {
                    this.renderInfosTileEntities.add(renderglobal$containerlocalrenderinformation3);
                }

                for (int j = 0; j < i1; ++j)
                {
                    EnumFacing enumfacing1 = aenumfacing[j];

                    if ((!flag1 || !renderglobal$containerlocalrenderinformation3.setFacing.contains(enumfacing1.getOpposite())) && (!flag1 || enumfacing2 == null || renderchunk5.getCompiledChunk().isVisible(enumfacing2.getOpposite(), enumfacing1)))
                    {
                        RenderChunk renderchunk3 = this.func_181562_a(blockpos3, renderchunk5, enumfacing1);

                        if (renderchunk3 != null && renderchunk3.setFrameIndex(frameCount) && ((ICamera)camera).isBoundingBoxInFrustum(renderchunk3.boundingBox))
                        {
                            RenderGlobal.ContainerLocalRenderInformation renderglobal$containerlocalrenderinformation = new RenderGlobal.ContainerLocalRenderInformation(renderchunk3, enumfacing1, renderglobal$containerlocalrenderinformation3.counter + 1, true);
                            renderglobal$containerlocalrenderinformation.setFacing.addAll(renderglobal$containerlocalrenderinformation3.setFacing);
                            renderglobal$containerlocalrenderinformation.setFacing.add(enumfacing1);
                            deque.add(renderglobal$containerlocalrenderinformation);
                        }
                    }
                }
            }
        }

        if (this.debugFixTerrainFrustum)
        {
            this.fixTerrainFrustum(d3, d4, d5);
            this.debugFixTerrainFrustum = false;
        }

        Lagometer.timerVisibility.end();

        if (Shaders.isShadowPass)
        {
            Shaders.mcProfilerEndSection();
        }
        else
        {
            this.renderDispatcher.clearChunkUpdates();
            Set set = this.chunksToUpdate;
            this.chunksToUpdate = Sets.newLinkedHashSet();
            Iterator iterator1 = this.renderInfos.iterator();
            Lagometer.timerChunkUpdate.start();

            while (iterator1.hasNext())
            {
                RenderGlobal.ContainerLocalRenderInformation renderglobal$containerlocalrenderinformation1 = (RenderGlobal.ContainerLocalRenderInformation)iterator1.next();
                RenderChunk renderchunk4 = renderglobal$containerlocalrenderinformation1.renderChunk;

                if (renderchunk4.isNeedsUpdate() || set.contains(renderchunk4))
                {
                    this.displayListEntitiesDirty = true;

                    if (this.isPositionInRenderChunk(blockpos, renderglobal$containerlocalrenderinformation1.renderChunk))
                    {
                        if (!renderchunk4.isPlayerUpdate())
                        {
                            this.chunksToUpdateForced.add(renderchunk4);
                        }
                        else
                        {
                            this.mc.mcProfiler.startSection("build near");
                            this.renderDispatcher.updateChunkNow(renderchunk4);
                            renderchunk4.setNeedsUpdate(false);
                            this.mc.mcProfiler.endSection();
                        }
                    }
                    else
                    {
                        this.chunksToUpdate.add(renderchunk4);
                    }
                }
            }

            Lagometer.timerChunkUpdate.end();
            this.chunksToUpdate.addAll(set);
            this.mc.mcProfiler.endSection();
        }
    }

    private boolean isPositionInRenderChunk(BlockPos pos, RenderChunk renderChunkIn)
    {
        BlockPos blockpos = renderChunkIn.getPosition();
        return MathHelper.abs_int(pos.getX() - blockpos.getX()) > OBFVAL_KiCmU.get() ? false : (MathHelper.abs_int(pos.getY() - blockpos.getY()) > OBFVAL_KiCmU.get() ? false : MathHelper.abs_int(pos.getZ() - blockpos.getZ()) <= OBFVAL_KiCmU.get());
    }

    private Set getVisibleFacings(BlockPos pos)
    {
        VisGraph visgraph = new VisGraph();
        BlockPos blockpos = new BlockPos(pos.getX() >> OBFVAL_Y7VKF.get() << OBFVAL_Y7VKF.get(), pos.getY() >> OBFVAL_Y7VKF.get() << OBFVAL_Y7VKF.get(), pos.getZ() >> OBFVAL_Y7VKF.get() << OBFVAL_Y7VKF.get());
        Chunk chunk = this.theWorld.getChunkFromBlockCoords(blockpos);

        for (BlockPos.MutableBlockPos blockpos$mutableblockpos : BlockPos.getAllInBoxMutable(blockpos, blockpos.add(OBFVAL_bVixy.get(), OBFVAL_bVixy.get(), OBFVAL_bVixy.get())))
        {
            if (chunk.getBlock(blockpos$mutableblockpos).isOpaqueCube())
            {
                visgraph.func_178606_a(blockpos$mutableblockpos);
            }
        }
        return visgraph.func_178609_b(pos);
    }

    private RenderChunk func_181562_a(BlockPos p_181562_1_, RenderChunk p_181562_2_, EnumFacing p_181562_3_)
    {
        BlockPos blockpos = p_181562_2_.getPositionOffset16(p_181562_3_);

        if (blockpos.getY() >= 0 && blockpos.getY() < OBFVAL_MBTlt.get())
        {
            int i = MathHelper.abs_int(p_181562_1_.getX() - blockpos.getX());
            int j = MathHelper.abs_int(p_181562_1_.getZ() - blockpos.getZ());

            if (Config.isFogOff())
            {
                if (i > this.renderDistance || j > this.renderDistance)
                {
                    return null;
                }
            }
            else
            {
                int k = i * i + j * j;

                if (k > this.renderDistanceSq)
                {
                    return null;
                }
            }

            return this.viewFrustum.getRenderChunk(blockpos);
        }
        else
        {
            return null;
        }
    }

    private void fixTerrainFrustum(double x, double y, double z)
    {
        this.debugFixedClippingHelper = new ClippingHelperImpl();
        ((ClippingHelperImpl)this.debugFixedClippingHelper).init();
        Matrix4f matrix4f = new Matrix4f(this.debugFixedClippingHelper.modelviewMatrix);
        matrix4f.transpose();
        Matrix4f matrix4f1 = new Matrix4f(this.debugFixedClippingHelper.projectionMatrix);
        matrix4f1.transpose();
        Matrix4f matrix4f2 = new Matrix4f();
        Matrix4f.mul(matrix4f1, matrix4f, matrix4f2);
        matrix4f2.invert();
        this.debugTerrainFrustumPosition.field_181059_a = x;
        this.debugTerrainFrustumPosition.field_181060_b = y;
        this.debugTerrainFrustumPosition.field_181061_c = z;
        this.debugTerrainMatrix[0] = new Vector4f(OBFVAL_hxVZE.get(), OBFVAL_hxVZE.get(), OBFVAL_hxVZE.get(), 1.0F);
        this.debugTerrainMatrix[1] = new Vector4f(1.0F, OBFVAL_hxVZE.get(), OBFVAL_hxVZE.get(), 1.0F);
        this.debugTerrainMatrix[OBFVAL_rtaa5.get()] = new Vector4f(1.0F, 1.0F, OBFVAL_hxVZE.get(), 1.0F);
        this.debugTerrainMatrix[OBFVAL_zg5AC.get()] = new Vector4f(OBFVAL_hxVZE.get(), 1.0F, OBFVAL_hxVZE.get(), 1.0F);
        this.debugTerrainMatrix[OBFVAL_Y7VKF.get()] = new Vector4f(OBFVAL_hxVZE.get(), OBFVAL_hxVZE.get(), 1.0F, 1.0F);
        this.debugTerrainMatrix[OBFVAL_qB6X2.get()] = new Vector4f(1.0F, OBFVAL_hxVZE.get(), 1.0F, 1.0F);
        this.debugTerrainMatrix[OBFVAL_KpvWK.get()] = new Vector4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.debugTerrainMatrix[OBFVAL_f8Aft.get()] = new Vector4f(OBFVAL_hxVZE.get(), 1.0F, 1.0F, 1.0F);

        for (int i = 0; i < OBFVAL_NJbZB.get(); ++i)
        {
            Matrix4f.transform(matrix4f2, this.debugTerrainMatrix[i], this.debugTerrainMatrix[i]);
            this.debugTerrainMatrix[i].x /= this.debugTerrainMatrix[i].w;
            this.debugTerrainMatrix[i].y /= this.debugTerrainMatrix[i].w;
            this.debugTerrainMatrix[i].z /= this.debugTerrainMatrix[i].w;
            this.debugTerrainMatrix[i].w = 1.0F;
        }
    }

    protected Vector3f getViewVector(Entity entityIn, double partialTicks)
    {
        float f = (float)((double)entityIn.prevRotationPitch + (double)(entityIn.rotationPitch - entityIn.prevRotationPitch) * partialTicks);
        float f1 = (float)((double)entityIn.prevRotationYaw + (double)(entityIn.rotationYaw - entityIn.prevRotationYaw) * partialTicks);

        if (Minecraft.getMinecraft().gameSettings.thirdPersonView == OBFVAL_rtaa5.get())
        {
            f += OBFVAL_NzYEr.get();
        }

        float f2 = MathHelper.cos(-f1 * OBFVAL_Vpsum.get() - OBFVAL_gZxNZ.get());
        float f3 = MathHelper.sin(-f1 * OBFVAL_Vpsum.get() - OBFVAL_gZxNZ.get());
        float f4 = -MathHelper.cos(-f * OBFVAL_Vpsum.get());
        float f5 = MathHelper.sin(-f * OBFVAL_Vpsum.get());
        return new Vector3f(f3 * f4, f5, f2 * f4);
    }

    public int renderBlockLayer(EnumWorldBlockLayer blockLayerIn, double partialTicks, int pass, Entity entityIn)
    {
        RenderHelper.disableStandardItemLighting();

        if (blockLayerIn == EnumWorldBlockLayer.TRANSLUCENT)
        {
            this.mc.mcProfiler.startSection("translucent_sort");
            double d0 = entityIn.posX - this.prevRenderSortX;
            double d1 = entityIn.posY - this.prevRenderSortY;
            double d2 = entityIn.posZ - this.prevRenderSortZ;

            if (d0 * d0 + d1 * d1 + d2 * d2 > 1.0D)
            {
                this.prevRenderSortX = entityIn.posX;
                this.prevRenderSortY = entityIn.posY;
                this.prevRenderSortZ = entityIn.posZ;
                int k = 0;
                Iterator iterator = this.renderInfos.iterator();
                this.chunksToResortTransparency.clear();

                while (iterator.hasNext())
                {
                    RenderGlobal.ContainerLocalRenderInformation renderglobal$containerlocalrenderinformation = (RenderGlobal.ContainerLocalRenderInformation)iterator.next();

                    if (renderglobal$containerlocalrenderinformation.renderChunk.compiledChunk.isLayerStarted(blockLayerIn) && k++ < OBFVAL_bVixy.get())
                    {
                        this.chunksToResortTransparency.add(renderglobal$containerlocalrenderinformation.renderChunk);
                    }
                }
            }

            this.mc.mcProfiler.endSection();
        }

        this.mc.mcProfiler.startSection("filterempty");
        int l = 0;
        boolean flag = blockLayerIn == EnumWorldBlockLayer.TRANSLUCENT;
        int i1 = flag ? this.renderInfos.size() - 1 : 0;
        int i = flag ? -1 : this.renderInfos.size();
        int j1 = flag ? -1 : 1;

        for (int j = i1; j != i; j += j1)
        {
            RenderChunk renderchunk = ((RenderGlobal.ContainerLocalRenderInformation)this.renderInfos.get(j)).renderChunk;

            if (!renderchunk.getCompiledChunk().isLayerEmpty(blockLayerIn))
            {
                ++l;
                this.renderContainer.addRenderChunk(renderchunk, blockLayerIn);
            }
        }

        if (l == 0)
        {
            this.mc.mcProfiler.endSection();
            return l;
        }
        else
        {
            if (Config.isFogOff() && this.mc.entityRenderer.fogStandard)
            {
                GlStateManager.disableFog();
            }

            this.mc.mcProfiler.endStartSection("render_" + blockLayerIn);
            this.renderBlockLayer(blockLayerIn);
            this.mc.mcProfiler.endSection();
            return l;
        }
    }

    @SuppressWarnings("incomplete-switch")
    private void renderBlockLayer(EnumWorldBlockLayer blockLayerIn)
    {
        this.mc.entityRenderer.enableLightmap();

        if (OpenGlHelper.useVbo())
        {
            GL11.glEnableClientState(OBFVAL_0yfOb.get());
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
            GL11.glEnableClientState(OBFVAL_66xZn.get());
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.lightmapTexUnit);
            GL11.glEnableClientState(OBFVAL_66xZn.get());
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
            GL11.glEnableClientState(OBFVAL_q9jRb.get());
        }

        if (Config.isShaders())
        {
            ShadersRender.preRenderChunkLayer(blockLayerIn);
        }

        this.renderContainer.renderChunkLayer(blockLayerIn);

        if (Config.isShaders())
        {
            ShadersRender.postRenderChunkLayer(blockLayerIn);
        }

        if (OpenGlHelper.useVbo())
        {
            for (VertexFormatElement vertexformatelement : DefaultVertexFormats.BLOCK.getElements())
            {
                VertexFormatElement.EnumUsage vertexformatelement$enumusage = vertexformatelement.getUsage();
                int i = vertexformatelement.getIndex();

                switch (RenderGlobal.RenderGlobal$RenderGlobal$2.field_178037_a[vertexformatelement$enumusage.ordinal()])
                {
                    case 1:
                        GL11.glDisableClientState(OBFVAL_0yfOb.get());
                        break;

                    case 2:
                        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + i);
                        GL11.glDisableClientState(OBFVAL_66xZn.get());
                        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
                        break;

                    case 3:
                        GL11.glDisableClientState(OBFVAL_q9jRb.get());
                        GlStateManager.resetColor();
                }
            }
        }

        this.mc.entityRenderer.disableLightmap();
    }

    private void cleanupDamagedBlocks(Iterator iteratorIn)
    {
        while (iteratorIn.hasNext())
        {
            DestroyBlockProgress destroyblockprogress = (DestroyBlockProgress)iteratorIn.next();
            int i = destroyblockprogress.getCreationCloudUpdateTick();

            if (this.cloudTickCounter - i > OBFVAL_EVLGo.get())
            {
                iteratorIn.remove();
            }
        }
    }

    public void updateClouds()
    {
        if (Config.isShaders() && Keyboard.isKeyDown(OBFVAL_eM2sh.get()) && Keyboard.isKeyDown(OBFVAL_28TmD.get()))
        {
            Shaders.uninit();
            Shaders.loadShaderPack();
        }

        ++this.cloudTickCounter;

        if (this.cloudTickCounter % OBFVAL_8CIc8.get() == 0)
        {
            this.cleanupDamagedBlocks(this.damagedBlocks.values().iterator());
        }
    }

    private void renderSkyEnd()
    {
        if (Config.isSkyEnabled())
        {
            GlStateManager.disableFog();
            GlStateManager.disableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(OBFVAL_H169w.get(), OBFVAL_lEpfw.get(), 1, 0);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.depthMask(false);
            this.renderEngine.bindTexture(locationEndSkyPng);
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();

            for (int i = 0; i < OBFVAL_KpvWK.get(); ++i)
            {
                GlStateManager.pushMatrix();

                if (i == 1)
                {
                    GlStateManager.rotate(OBFVAL_eVH5D.get(), 1.0F, 0.0F, 0.0F);
                }

                if (i == OBFVAL_rtaa5.get())
                {
                    GlStateManager.rotate(OBFVAL_a40Im.get(), 1.0F, 0.0F, 0.0F);
                }

                if (i == OBFVAL_zg5AC.get())
                {
                    GlStateManager.rotate(OBFVAL_NzYEr.get(), 1.0F, 0.0F, 0.0F);
                }

                if (i == OBFVAL_Y7VKF.get())
                {
                    GlStateManager.rotate(OBFVAL_eVH5D.get(), 0.0F, 0.0F, 1.0F);
                }

                if (i == OBFVAL_qB6X2.get())
                {
                    GlStateManager.rotate(OBFVAL_a40Im.get(), 0.0F, 0.0F, 1.0F);
                }

                worldrenderer.begin(OBFVAL_f8Aft.get(), DefaultVertexFormats.POSITION_TEX_COLOR);
                worldrenderer.pos(OBFVAL_71JPV.get(), OBFVAL_71JPV.get(), OBFVAL_71JPV.get()).tex(0.0D, 0.0D).color(OBFVAL_iGVQx.get(), OBFVAL_iGVQx.get(), OBFVAL_iGVQx.get(), OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(OBFVAL_71JPV.get(), OBFVAL_71JPV.get(), OBFVAL_adJne.get()).tex(0.0D, OBFVAL_S9073.get()).color(OBFVAL_iGVQx.get(), OBFVAL_iGVQx.get(), OBFVAL_iGVQx.get(), OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(OBFVAL_adJne.get(), OBFVAL_71JPV.get(), OBFVAL_adJne.get()).tex(OBFVAL_S9073.get(), OBFVAL_S9073.get()).color(OBFVAL_iGVQx.get(), OBFVAL_iGVQx.get(), OBFVAL_iGVQx.get(), OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(OBFVAL_adJne.get(), OBFVAL_71JPV.get(), OBFVAL_71JPV.get()).tex(OBFVAL_S9073.get(), 0.0D).color(OBFVAL_iGVQx.get(), OBFVAL_iGVQx.get(), OBFVAL_iGVQx.get(), OBFVAL_eydYI.get()).endVertex();
                tessellator.draw();
                GlStateManager.popMatrix();
            }

            GlStateManager.depthMask(true);
            GlStateManager.enableTexture2D();
            GlStateManager.enableAlpha();
        }
    }

    public void renderSky(float partialTicks, int pass)
    {
        if (this.mc.theWorld.provider.getDimensionId() == 1)
        {
            this.renderSkyEnd();
        }
        else if (this.mc.theWorld.provider.isSurfaceWorld())
        {
            GlStateManager.disableTexture2D();
            boolean flag = Config.isShaders();

            if (flag)
            {
                Shaders.disableTexture2D();
            }

            Vec3 vec3 = this.theWorld.getSkyColor(this.mc.getRenderViewEntity(), partialTicks);
            vec3 = CustomColors.getSkyColor(vec3, this.mc.theWorld, this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().posY + 1.0D, this.mc.getRenderViewEntity().posZ);

            if (flag)
            {
                Shaders.setSkyColor(vec3);
            }

            float f = (float)vec3.xCoord;
            float f1 = (float)vec3.yCoord;
            float f2 = (float)vec3.zCoord;

            if (pass != OBFVAL_rtaa5.get())
            {
                float f3 = (f * OBFVAL_QlAt4.get() + f1 * OBFVAL_gcaBK.get() + f2 * OBFVAL_cHxlf.get()) / OBFVAL_vbq75.get();
                float f4 = (f * OBFVAL_QlAt4.get() + f1 * OBFVAL_OWM8I.get()) / OBFVAL_vbq75.get();
                float f5 = (f * OBFVAL_QlAt4.get() + f2 * OBFVAL_OWM8I.get()) / OBFVAL_vbq75.get();
                f = f3;
                f1 = f4;
                f2 = f5;
            }

            GlStateManager.color(f, f1, f2);
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();
            GlStateManager.depthMask(false);
            GlStateManager.enableFog();

            if (flag)
            {
                Shaders.enableFog();
            }

            GlStateManager.color(f, f1, f2);

            if (flag)
            {
                Shaders.preSkyList();
            }

            if (Config.isSkyEnabled())
            {
                if (this.vboEnabled)
                {
                    this.skyVBO.bindBuffer();
                    GL11.glEnableClientState(OBFVAL_0yfOb.get());
                    GL11.glVertexPointer(OBFVAL_zg5AC.get(), OBFVAL_MIere.get(), OBFVAL_LPKYV.get(), 0L);
                    this.skyVBO.drawArrays(OBFVAL_f8Aft.get());
                    this.skyVBO.unbindBuffer();
                    GL11.glDisableClientState(OBFVAL_0yfOb.get());
                }
                else
                {
                    GlStateManager.callList(this.glSkyList);
                }
            }

            GlStateManager.disableFog();

            if (flag)
            {
                Shaders.disableFog();
            }

            GlStateManager.disableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(OBFVAL_H169w.get(), OBFVAL_lEpfw.get(), 1, 0);
            RenderHelper.disableStandardItemLighting();
            float[] afloat = this.theWorld.provider.calcSunriseSunsetColors(this.theWorld.getCelestialAngle(partialTicks), partialTicks);

            if (afloat != null && Config.isSunMoonEnabled())
            {
                GlStateManager.disableTexture2D();

                if (flag)
                {
                    Shaders.disableTexture2D();
                }

                GlStateManager.shadeModel(OBFVAL_Rll3I.get());
                GlStateManager.pushMatrix();
                GlStateManager.rotate(OBFVAL_eVH5D.get(), 1.0F, 0.0F, 0.0F);
                GlStateManager.rotate(MathHelper.sin(this.theWorld.getCelestialAngleRadians(partialTicks)) < 0.0F ? OBFVAL_NzYEr.get() : 0.0F, 0.0F, 0.0F, 1.0F);
                GlStateManager.rotate(OBFVAL_eVH5D.get(), 0.0F, 0.0F, 1.0F);
                float f6 = afloat[0];
                float f7 = afloat[1];
                float f8 = afloat[OBFVAL_rtaa5.get()];

                if (pass != OBFVAL_rtaa5.get())
                {
                    float f9 = (f6 * OBFVAL_QlAt4.get() + f7 * OBFVAL_gcaBK.get() + f8 * OBFVAL_cHxlf.get()) / OBFVAL_vbq75.get();
                    float f10 = (f6 * OBFVAL_QlAt4.get() + f7 * OBFVAL_OWM8I.get()) / OBFVAL_vbq75.get();
                    float f11 = (f6 * OBFVAL_QlAt4.get() + f8 * OBFVAL_OWM8I.get()) / OBFVAL_vbq75.get();
                    f6 = f9;
                    f7 = f10;
                    f8 = f11;
                }

                worldrenderer.begin(OBFVAL_KpvWK.get(), DefaultVertexFormats.POSITION_COLOR);
                worldrenderer.pos(0.0D, OBFVAL_adJne.get(), 0.0D).color(f6, f7, f8, afloat[OBFVAL_zg5AC.get()]).endVertex();
                boolean flag1 = true;

                for (int k = 0; k <= OBFVAL_KiCmU.get(); ++k)
                {
                    float f18 = (float)k * OBFVAL_gZxNZ.get() * OBFVAL_uH7g9.get() / OBFVAL_Gj2ce.get();
                    float f12 = MathHelper.sin(f18);
                    float f13 = MathHelper.cos(f18);
                    worldrenderer.pos((double)(f12 * OBFVAL_XegrR.get()), (double)(f13 * OBFVAL_XegrR.get()), (double)(-f13 * OBFVAL_jJP6Z.get() * afloat[OBFVAL_zg5AC.get()])).color(afloat[0], afloat[1], afloat[OBFVAL_rtaa5.get()], 0.0F).endVertex();
                }

                tessellator.draw();
                GlStateManager.popMatrix();
                GlStateManager.shadeModel(OBFVAL_JuWx4.get());
            }

            GlStateManager.enableTexture2D();

            if (flag)
            {
                Shaders.enableTexture2D();
            }

            GlStateManager.tryBlendFuncSeparate(OBFVAL_H169w.get(), 1, 1, 0);
            GlStateManager.pushMatrix();
            float f15 = 1.0F - this.theWorld.getRainStrength(partialTicks);
            GlStateManager.color(1.0F, 1.0F, 1.0F, f15);
            GlStateManager.rotate(OBFVAL_a40Im.get(), 0.0F, 1.0F, 0.0F);
            CustomSky.renderSky(this.theWorld, this.renderEngine, this.theWorld.getCelestialAngle(partialTicks), f15);

            if (flag)
            {
                Shaders.preCelestialRotate();
            }

            GlStateManager.rotate(this.theWorld.getCelestialAngle(partialTicks) * OBFVAL_28ANh.get(), 1.0F, 0.0F, 0.0F);

            if (flag)
            {
                Shaders.postCelestialRotate();
            }

            float f16 = OBFVAL_QlAt4.get();

            if (Config.isSunTexture())
            {
                this.renderEngine.bindTexture(locationSunPng);
                worldrenderer.begin(OBFVAL_f8Aft.get(), DefaultVertexFormats.POSITION_TEX);
                worldrenderer.pos((double)(-f16), OBFVAL_adJne.get(), (double)(-f16)).tex(0.0D, 0.0D).endVertex();
                worldrenderer.pos((double)f16, OBFVAL_adJne.get(), (double)(-f16)).tex(1.0D, 0.0D).endVertex();
                worldrenderer.pos((double)f16, OBFVAL_adJne.get(), (double)f16).tex(1.0D, 1.0D).endVertex();
                worldrenderer.pos((double)(-f16), OBFVAL_adJne.get(), (double)f16).tex(0.0D, 1.0D).endVertex();
                tessellator.draw();
            }

            f16 = OBFVAL_bdZXd.get();

            if (Config.isMoonTexture())
            {
                this.renderEngine.bindTexture(locationMoonPhasesPng);
                int i = this.theWorld.getMoonPhase();
                int j = i % OBFVAL_Y7VKF.get();
                int l = i / OBFVAL_Y7VKF.get() % OBFVAL_rtaa5.get();
                float f19 = (float)(j + 0) / OBFVAL_lvkuM.get();
                float f21 = (float)(l + 0) / OBFVAL_uH7g9.get();
                float f23 = (float)(j + 1) / OBFVAL_lvkuM.get();
                float f14 = (float)(l + 1) / OBFVAL_uH7g9.get();
                worldrenderer.begin(OBFVAL_f8Aft.get(), DefaultVertexFormats.POSITION_TEX);
                worldrenderer.pos((double)(-f16), OBFVAL_71JPV.get(), (double)f16).tex((double)f23, (double)f14).endVertex();
                worldrenderer.pos((double)f16, OBFVAL_71JPV.get(), (double)f16).tex((double)f19, (double)f14).endVertex();
                worldrenderer.pos((double)f16, OBFVAL_71JPV.get(), (double)(-f16)).tex((double)f19, (double)f21).endVertex();
                worldrenderer.pos((double)(-f16), OBFVAL_71JPV.get(), (double)(-f16)).tex((double)f23, (double)f21).endVertex();
                tessellator.draw();
            }

            GlStateManager.disableTexture2D();

            if (flag)
            {
                Shaders.disableTexture2D();
            }

            float f17 = this.theWorld.getStarBrightness(partialTicks) * f15;

            if (f17 > 0.0F && Config.isStarsEnabled() && !CustomSky.hasSkyLayers(this.theWorld))
            {
                GlStateManager.color(f17, f17, f17, f17);

                if (this.vboEnabled)
                {
                    this.starVBO.bindBuffer();
                    GL11.glEnableClientState(OBFVAL_0yfOb.get());
                    GL11.glVertexPointer(OBFVAL_zg5AC.get(), OBFVAL_MIere.get(), OBFVAL_LPKYV.get(), 0L);
                    this.starVBO.drawArrays(OBFVAL_f8Aft.get());
                    this.starVBO.unbindBuffer();
                    GL11.glDisableClientState(OBFVAL_0yfOb.get());
                }
                else
                {
                    GlStateManager.callList(this.starGLCallList);
                }
            }

            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.disableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.enableFog();

            if (flag)
            {
                Shaders.enableFog();
            }

            GlStateManager.popMatrix();
            GlStateManager.disableTexture2D();

            if (flag)
            {
                Shaders.disableTexture2D();
            }

            GlStateManager.color(0.0F, 0.0F, 0.0F);
            double d0 = this.mc.thePlayer.getPositionEyes(partialTicks).yCoord - this.theWorld.getHorizon();

            if (d0 < 0.0D)
            {
                GlStateManager.pushMatrix();
                GlStateManager.translate(0.0F, OBFVAL_qwCjR.get(), 0.0F);

                if (this.vboEnabled)
                {
                    this.sky2VBO.bindBuffer();
                    GL11.glEnableClientState(OBFVAL_0yfOb.get());
                    GL11.glVertexPointer(OBFVAL_zg5AC.get(), OBFVAL_MIere.get(), OBFVAL_LPKYV.get(), 0L);
                    this.sky2VBO.drawArrays(OBFVAL_f8Aft.get());
                    this.sky2VBO.unbindBuffer();
                    GL11.glDisableClientState(OBFVAL_0yfOb.get());
                }
                else
                {
                    GlStateManager.callList(this.glSkyList2);
                }

                GlStateManager.popMatrix();
                float f20 = 1.0F;
                float f22 = -((float)(d0 + OBFVAL_SbepZ.get()));
                float f24 = OBFVAL_hxVZE.get();
                worldrenderer.begin(OBFVAL_f8Aft.get(), DefaultVertexFormats.POSITION_COLOR);
                worldrenderer.pos(OBFVAL_ZyYkI.get(), (double)f22, 1.0D).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(1.0D, (double)f22, 1.0D).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(1.0D, OBFVAL_ZyYkI.get(), 1.0D).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(OBFVAL_ZyYkI.get(), OBFVAL_ZyYkI.get(), 1.0D).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(OBFVAL_ZyYkI.get(), OBFVAL_ZyYkI.get(), OBFVAL_ZyYkI.get()).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(1.0D, OBFVAL_ZyYkI.get(), OBFVAL_ZyYkI.get()).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(1.0D, (double)f22, OBFVAL_ZyYkI.get()).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(OBFVAL_ZyYkI.get(), (double)f22, OBFVAL_ZyYkI.get()).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(1.0D, OBFVAL_ZyYkI.get(), OBFVAL_ZyYkI.get()).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(1.0D, OBFVAL_ZyYkI.get(), 1.0D).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(1.0D, (double)f22, 1.0D).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(1.0D, (double)f22, OBFVAL_ZyYkI.get()).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(OBFVAL_ZyYkI.get(), (double)f22, OBFVAL_ZyYkI.get()).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(OBFVAL_ZyYkI.get(), (double)f22, 1.0D).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(OBFVAL_ZyYkI.get(), OBFVAL_ZyYkI.get(), 1.0D).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(OBFVAL_ZyYkI.get(), OBFVAL_ZyYkI.get(), OBFVAL_ZyYkI.get()).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(OBFVAL_ZyYkI.get(), OBFVAL_ZyYkI.get(), OBFVAL_ZyYkI.get()).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(OBFVAL_ZyYkI.get(), OBFVAL_ZyYkI.get(), 1.0D).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(1.0D, OBFVAL_ZyYkI.get(), 1.0D).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                worldrenderer.pos(1.0D, OBFVAL_ZyYkI.get(), OBFVAL_ZyYkI.get()).color(0, 0, 0, OBFVAL_eydYI.get()).endVertex();
                tessellator.draw();
            }

            if (this.theWorld.provider.isSkyColored())
            {
                GlStateManager.color(f * OBFVAL_vDjW0.get() + OBFVAL_t6AqD.get(), f1 * OBFVAL_vDjW0.get() + OBFVAL_t6AqD.get(), f2 * OBFVAL_dTyRj.get() + OBFVAL_6wjOg.get());
            }
            else
            {
                GlStateManager.color(f, f1, f2);
            }

            if (this.mc.gameSettings.renderDistanceChunks <= OBFVAL_Y7VKF.get())
            {
                GlStateManager.color(this.mc.entityRenderer.fogColorRed, this.mc.entityRenderer.fogColorGreen, this.mc.entityRenderer.fogColorBlue);
            }

            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, -((float)(d0 - OBFVAL_S9073.get())), 0.0F);

            if (Config.isSkyEnabled())
            {
                GlStateManager.callList(this.glSkyList2);
            }

            GlStateManager.popMatrix();
            GlStateManager.enableTexture2D();

            if (flag)
            {
                Shaders.enableTexture2D();
            }

            GlStateManager.depthMask(true);
        }
    }

    public void renderClouds(float partialTicks, int pass)
    {
        if (!TexteriaOptions.disableClouds)
        {
            if (!Config.isCloudsOff() && this.mc.theWorld.provider.isSurfaceWorld())
            {
                if (Config.isShaders())
                {
                    Shaders.beginClouds();
                }

                if (Config.isCloudsFancy())
                {
                    this.renderCloudsFancy(partialTicks, pass);
                }
                else
                {
                    this.cloudRenderer.prepareToRender(false, this.cloudTickCounter, partialTicks);
                    partialTicks = 0.0F;
                    GlStateManager.disableCull();
                    float f = (float)(this.mc.getRenderViewEntity().lastTickPosY + (this.mc.getRenderViewEntity().posY - this.mc.getRenderViewEntity().lastTickPosY) * (double)partialTicks);
                    boolean flag = true;
                    boolean flag1 = true;
                    Tessellator tessellator = Tessellator.getInstance();
                    WorldRenderer worldrenderer = tessellator.getWorldRenderer();
                    this.renderEngine.bindTexture(locationCloudsPng);
                    GlStateManager.enableBlend();
                    GlStateManager.tryBlendFuncSeparate(OBFVAL_H169w.get(), OBFVAL_lEpfw.get(), 1, 0);

                    if (this.cloudRenderer.shouldUpdateGlList())
                    {
                        this.cloudRenderer.startUpdateGlList();
                        Vec3 vec3 = this.theWorld.getCloudColour(partialTicks);
                        float f1 = (float)vec3.xCoord;
                        float f2 = (float)vec3.yCoord;
                        float f3 = (float)vec3.zCoord;

                        if (pass != OBFVAL_rtaa5.get())
                        {
                            float f4 = (f1 * OBFVAL_QlAt4.get() + f2 * OBFVAL_gcaBK.get() + f3 * OBFVAL_cHxlf.get()) / OBFVAL_vbq75.get();
                            float f5 = (f1 * OBFVAL_QlAt4.get() + f2 * OBFVAL_OWM8I.get()) / OBFVAL_vbq75.get();
                            float f6 = (f1 * OBFVAL_QlAt4.get() + f3 * OBFVAL_OWM8I.get()) / OBFVAL_vbq75.get();
                            f1 = f4;
                            f2 = f5;
                            f3 = f6;
                        }

                        float f10 = OBFVAL_bnquL.get();
                        double d2 = (double)((float)this.cloudTickCounter + partialTicks);
                        double d0 = this.mc.getRenderViewEntity().prevPosX + (this.mc.getRenderViewEntity().posX - this.mc.getRenderViewEntity().prevPosX) * (double)partialTicks + d2 * OBFVAL_P3hmd.get();
                        double d1 = this.mc.getRenderViewEntity().prevPosZ + (this.mc.getRenderViewEntity().posZ - this.mc.getRenderViewEntity().prevPosZ) * (double)partialTicks;
                        int i = MathHelper.floor_double(d0 / OBFVAL_PmzCb.get());
                        int j = MathHelper.floor_double(d1 / OBFVAL_PmzCb.get());
                        d0 = d0 - (double)(i * OBFVAL_5rFY0.get());
                        d1 = d1 - (double)(j * OBFVAL_5rFY0.get());
                        float f7 = this.theWorld.provider.getCloudHeight() - f + OBFVAL_mjsL2.get();
                        f7 = f7 + this.mc.gameSettings.ofCloudsHeight * OBFVAL_c0cPA.get();
                        float f8 = (float)(d0 * OBFVAL_pKgBW.get());
                        float f9 = (float)(d1 * OBFVAL_pKgBW.get());
                        worldrenderer.begin(OBFVAL_f8Aft.get(), DefaultVertexFormats.POSITION_TEX_COLOR);

                        for (int k = OBFVAL_3fhZL.get(); k < OBFVAL_MBTlt.get(); k += 32)
                        {
                            for (int l = OBFVAL_3fhZL.get(); l < OBFVAL_MBTlt.get(); l += 32)
                            {
                                worldrenderer.pos((double)(k + 0), (double)f7, (double)(l + OBFVAL_JlNub.get())).tex((double)((float)(k + 0) * OBFVAL_bnquL.get() + f8), (double)((float)(l + OBFVAL_JlNub.get()) * OBFVAL_bnquL.get() + f9)).color(f1, f2, f3, OBFVAL_yhkAO.get()).endVertex();
                                worldrenderer.pos((double)(k + OBFVAL_JlNub.get()), (double)f7, (double)(l + OBFVAL_JlNub.get())).tex((double)((float)(k + OBFVAL_JlNub.get()) * OBFVAL_bnquL.get() + f8), (double)((float)(l + OBFVAL_JlNub.get()) * OBFVAL_bnquL.get() + f9)).color(f1, f2, f3, OBFVAL_yhkAO.get()).endVertex();
                                worldrenderer.pos((double)(k + OBFVAL_JlNub.get()), (double)f7, (double)(l + 0)).tex((double)((float)(k + OBFVAL_JlNub.get()) * OBFVAL_bnquL.get() + f8), (double)((float)(l + 0) * OBFVAL_bnquL.get() + f9)).color(f1, f2, f3, OBFVAL_yhkAO.get()).endVertex();
                                worldrenderer.pos((double)(k + 0), (double)f7, (double)(l + 0)).tex((double)((float)(k + 0) * OBFVAL_bnquL.get() + f8), (double)((float)(l + 0) * OBFVAL_bnquL.get() + f9)).color(f1, f2, f3, OBFVAL_yhkAO.get()).endVertex();
                            }
                        }

                        tessellator.draw();
                        this.cloudRenderer.endUpdateGlList();
                    }

                    this.cloudRenderer.renderGlList();
                    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                    GlStateManager.disableBlend();
                    GlStateManager.enableCull();
                }

                if (Config.isShaders())
                {
                    Shaders.endClouds();
                }
            }
        }
    }

    /**
     * Checks if the given position is to be rendered with cloud fog
     */
    public boolean hasCloudFog(double x, double y, double z, float partialTicks)
    {
        return false;
    }

    private void renderCloudsFancy(float partialTicks, int pass)
    {
        this.cloudRenderer.prepareToRender(true, this.cloudTickCounter, partialTicks);
        partialTicks = 0.0F;
        GlStateManager.disableCull();
        float f = (float)(this.mc.getRenderViewEntity().lastTickPosY + (this.mc.getRenderViewEntity().posY - this.mc.getRenderViewEntity().lastTickPosY) * (double)partialTicks);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        float f1 = OBFVAL_qwCjR.get();
        float f2 = OBFVAL_lvkuM.get();
        double d0 = (double)((float)this.cloudTickCounter + partialTicks);
        double d1 = (this.mc.getRenderViewEntity().prevPosX + (this.mc.getRenderViewEntity().posX - this.mc.getRenderViewEntity().prevPosX) * (double)partialTicks + d0 * OBFVAL_P3hmd.get()) / OBFVAL_z4dU5.get();
        double d2 = (this.mc.getRenderViewEntity().prevPosZ + (this.mc.getRenderViewEntity().posZ - this.mc.getRenderViewEntity().prevPosZ) * (double)partialTicks) / OBFVAL_z4dU5.get() + OBFVAL_MGZdI.get();
        float f3 = this.theWorld.provider.getCloudHeight() - f + OBFVAL_mjsL2.get();
        f3 = f3 + this.mc.gameSettings.ofCloudsHeight * OBFVAL_c0cPA.get();
        int i = MathHelper.floor_double(d1 / OBFVAL_PmzCb.get());
        int j = MathHelper.floor_double(d2 / OBFVAL_PmzCb.get());
        d1 = d1 - (double)(i * OBFVAL_5rFY0.get());
        d2 = d2 - (double)(j * OBFVAL_5rFY0.get());
        this.renderEngine.bindTexture(locationCloudsPng);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(OBFVAL_H169w.get(), OBFVAL_lEpfw.get(), 1, 0);
        Vec3 vec3 = this.theWorld.getCloudColour(partialTicks);
        float f4 = (float)vec3.xCoord;
        float f5 = (float)vec3.yCoord;
        float f6 = (float)vec3.zCoord;

        if (pass != OBFVAL_rtaa5.get())
        {
            float f7 = (f4 * OBFVAL_QlAt4.get() + f5 * OBFVAL_gcaBK.get() + f6 * OBFVAL_cHxlf.get()) / OBFVAL_vbq75.get();
            float f8 = (f4 * OBFVAL_QlAt4.get() + f5 * OBFVAL_OWM8I.get()) / OBFVAL_vbq75.get();
            float f9 = (f4 * OBFVAL_QlAt4.get() + f6 * OBFVAL_OWM8I.get()) / OBFVAL_vbq75.get();
            f4 = f7;
            f5 = f8;
            f6 = f9;
        }

        float f26 = f4 * OBFVAL_x5114.get();
        float f27 = f5 * OBFVAL_x5114.get();
        float f28 = f6 * OBFVAL_x5114.get();
        float f10 = f4 * OBFVAL_uLKjf.get();
        float f11 = f5 * OBFVAL_uLKjf.get();
        float f12 = f6 * OBFVAL_uLKjf.get();
        float f13 = f4 * OBFVAL_yhkAO.get();
        float f14 = f5 * OBFVAL_yhkAO.get();
        float f15 = f6 * OBFVAL_yhkAO.get();
        float f16 = OBFVAL_haVe5.get();
        float f17 = (float)MathHelper.floor_double(d1) * OBFVAL_haVe5.get();
        float f18 = (float)MathHelper.floor_double(d2) * OBFVAL_haVe5.get();
        float f19 = (float)(d1 - (double)MathHelper.floor_double(d1));
        float f20 = (float)(d2 - (double)MathHelper.floor_double(d2));
        boolean flag = true;
        boolean flag1 = true;
        float f21 = OBFVAL_po7Kq.get();
        GlStateManager.scale(OBFVAL_qwCjR.get(), 1.0F, OBFVAL_qwCjR.get());

        for (int k = 0; k < OBFVAL_rtaa5.get(); ++k)
        {
            if (k == 0)
            {
                GlStateManager.colorMask(false, false, false, false);
            }
            else
            {
                switch (pass)
                {
                    case 0:
                        GlStateManager.colorMask(false, true, true, true);
                        break;

                    case 1:
                        GlStateManager.colorMask(true, false, false, true);
                        break;

                    case 2:
                        GlStateManager.colorMask(true, true, true, true);
                }
            }

            this.cloudRenderer.renderGlList();
        }

        if (this.cloudRenderer.shouldUpdateGlList())
        {
            this.cloudRenderer.startUpdateGlList();

            for (int j1 = OBFVAL_TMgD9.get(); j1 <= OBFVAL_Y7VKF.get(); ++j1)
            {
                for (int l = OBFVAL_TMgD9.get(); l <= OBFVAL_Y7VKF.get(); ++l)
                {
                    worldrenderer.begin(OBFVAL_f8Aft.get(), DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
                    float f22 = (float)(j1 * OBFVAL_NJbZB.get());
                    float f23 = (float)(l * OBFVAL_NJbZB.get());
                    float f24 = f22 - f19;
                    float f25 = f23 - f20;

                    if (f3 > OBFVAL_zclNP.get())
                    {
                        worldrenderer.pos((double)(f24 + 0.0F), (double)(f3 + 0.0F), (double)(f25 + OBFVAL_SJwXh.get())).tex((double)((f22 + 0.0F) * OBFVAL_haVe5.get() + f17), (double)((f23 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f18)).color(f10, f11, f12, OBFVAL_yhkAO.get()).normal(0.0F, OBFVAL_hxVZE.get(), 0.0F).endVertex();
                        worldrenderer.pos((double)(f24 + OBFVAL_SJwXh.get()), (double)(f3 + 0.0F), (double)(f25 + OBFVAL_SJwXh.get())).tex((double)((f22 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f18)).color(f10, f11, f12, OBFVAL_yhkAO.get()).normal(0.0F, OBFVAL_hxVZE.get(), 0.0F).endVertex();
                        worldrenderer.pos((double)(f24 + OBFVAL_SJwXh.get()), (double)(f3 + 0.0F), (double)(f25 + 0.0F)).tex((double)((f22 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + 0.0F) * OBFVAL_haVe5.get() + f18)).color(f10, f11, f12, OBFVAL_yhkAO.get()).normal(0.0F, OBFVAL_hxVZE.get(), 0.0F).endVertex();
                        worldrenderer.pos((double)(f24 + 0.0F), (double)(f3 + 0.0F), (double)(f25 + 0.0F)).tex((double)((f22 + 0.0F) * OBFVAL_haVe5.get() + f17), (double)((f23 + 0.0F) * OBFVAL_haVe5.get() + f18)).color(f10, f11, f12, OBFVAL_yhkAO.get()).normal(0.0F, OBFVAL_hxVZE.get(), 0.0F).endVertex();
                    }

                    if (f3 <= OBFVAL_4U9SJ.get())
                    {
                        worldrenderer.pos((double)(f24 + 0.0F), (double)(f3 + OBFVAL_lvkuM.get() - OBFVAL_po7Kq.get()), (double)(f25 + OBFVAL_SJwXh.get())).tex((double)((f22 + 0.0F) * OBFVAL_haVe5.get() + f17), (double)((f23 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f18)).color(f4, f5, f6, OBFVAL_yhkAO.get()).normal(0.0F, 1.0F, 0.0F).endVertex();
                        worldrenderer.pos((double)(f24 + OBFVAL_SJwXh.get()), (double)(f3 + OBFVAL_lvkuM.get() - OBFVAL_po7Kq.get()), (double)(f25 + OBFVAL_SJwXh.get())).tex((double)((f22 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f18)).color(f4, f5, f6, OBFVAL_yhkAO.get()).normal(0.0F, 1.0F, 0.0F).endVertex();
                        worldrenderer.pos((double)(f24 + OBFVAL_SJwXh.get()), (double)(f3 + OBFVAL_lvkuM.get() - OBFVAL_po7Kq.get()), (double)(f25 + 0.0F)).tex((double)((f22 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + 0.0F) * OBFVAL_haVe5.get() + f18)).color(f4, f5, f6, OBFVAL_yhkAO.get()).normal(0.0F, 1.0F, 0.0F).endVertex();
                        worldrenderer.pos((double)(f24 + 0.0F), (double)(f3 + OBFVAL_lvkuM.get() - OBFVAL_po7Kq.get()), (double)(f25 + 0.0F)).tex((double)((f22 + 0.0F) * OBFVAL_haVe5.get() + f17), (double)((f23 + 0.0F) * OBFVAL_haVe5.get() + f18)).color(f4, f5, f6, OBFVAL_yhkAO.get()).normal(0.0F, 1.0F, 0.0F).endVertex();
                    }

                    if (j1 > -1)
                    {
                        for (int i1 = 0; i1 < OBFVAL_NJbZB.get(); ++i1)
                        {
                            worldrenderer.pos((double)(f24 + (float)i1 + 0.0F), (double)(f3 + 0.0F), (double)(f25 + OBFVAL_SJwXh.get())).tex((double)((f22 + (float)i1 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f18)).color(f26, f27, f28, OBFVAL_yhkAO.get()).normal(OBFVAL_hxVZE.get(), 0.0F, 0.0F).endVertex();
                            worldrenderer.pos((double)(f24 + (float)i1 + 0.0F), (double)(f3 + OBFVAL_lvkuM.get()), (double)(f25 + OBFVAL_SJwXh.get())).tex((double)((f22 + (float)i1 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f18)).color(f26, f27, f28, OBFVAL_yhkAO.get()).normal(OBFVAL_hxVZE.get(), 0.0F, 0.0F).endVertex();
                            worldrenderer.pos((double)(f24 + (float)i1 + 0.0F), (double)(f3 + OBFVAL_lvkuM.get()), (double)(f25 + 0.0F)).tex((double)((f22 + (float)i1 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + 0.0F) * OBFVAL_haVe5.get() + f18)).color(f26, f27, f28, OBFVAL_yhkAO.get()).normal(OBFVAL_hxVZE.get(), 0.0F, 0.0F).endVertex();
                            worldrenderer.pos((double)(f24 + (float)i1 + 0.0F), (double)(f3 + 0.0F), (double)(f25 + 0.0F)).tex((double)((f22 + (float)i1 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + 0.0F) * OBFVAL_haVe5.get() + f18)).color(f26, f27, f28, OBFVAL_yhkAO.get()).normal(OBFVAL_hxVZE.get(), 0.0F, 0.0F).endVertex();
                        }
                    }

                    if (j1 <= 1)
                    {
                        for (int k1 = 0; k1 < OBFVAL_NJbZB.get(); ++k1)
                        {
                            worldrenderer.pos((double)(f24 + (float)k1 + 1.0F - OBFVAL_po7Kq.get()), (double)(f3 + 0.0F), (double)(f25 + OBFVAL_SJwXh.get())).tex((double)((f22 + (float)k1 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f18)).color(f26, f27, f28, OBFVAL_yhkAO.get()).normal(1.0F, 0.0F, 0.0F).endVertex();
                            worldrenderer.pos((double)(f24 + (float)k1 + 1.0F - OBFVAL_po7Kq.get()), (double)(f3 + OBFVAL_lvkuM.get()), (double)(f25 + OBFVAL_SJwXh.get())).tex((double)((f22 + (float)k1 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f18)).color(f26, f27, f28, OBFVAL_yhkAO.get()).normal(1.0F, 0.0F, 0.0F).endVertex();
                            worldrenderer.pos((double)(f24 + (float)k1 + 1.0F - OBFVAL_po7Kq.get()), (double)(f3 + OBFVAL_lvkuM.get()), (double)(f25 + 0.0F)).tex((double)((f22 + (float)k1 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + 0.0F) * OBFVAL_haVe5.get() + f18)).color(f26, f27, f28, OBFVAL_yhkAO.get()).normal(1.0F, 0.0F, 0.0F).endVertex();
                            worldrenderer.pos((double)(f24 + (float)k1 + 1.0F - OBFVAL_po7Kq.get()), (double)(f3 + 0.0F), (double)(f25 + 0.0F)).tex((double)((f22 + (float)k1 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + 0.0F) * OBFVAL_haVe5.get() + f18)).color(f26, f27, f28, OBFVAL_yhkAO.get()).normal(1.0F, 0.0F, 0.0F).endVertex();
                        }
                    }

                    if (l > -1)
                    {
                        for (int l1 = 0; l1 < OBFVAL_NJbZB.get(); ++l1)
                        {
                            worldrenderer.pos((double)(f24 + 0.0F), (double)(f3 + OBFVAL_lvkuM.get()), (double)(f25 + (float)l1 + 0.0F)).tex((double)((f22 + 0.0F) * OBFVAL_haVe5.get() + f17), (double)((f23 + (float)l1 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f18)).color(f13, f14, f15, OBFVAL_yhkAO.get()).normal(0.0F, 0.0F, OBFVAL_hxVZE.get()).endVertex();
                            worldrenderer.pos((double)(f24 + OBFVAL_SJwXh.get()), (double)(f3 + OBFVAL_lvkuM.get()), (double)(f25 + (float)l1 + 0.0F)).tex((double)((f22 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + (float)l1 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f18)).color(f13, f14, f15, OBFVAL_yhkAO.get()).normal(0.0F, 0.0F, OBFVAL_hxVZE.get()).endVertex();
                            worldrenderer.pos((double)(f24 + OBFVAL_SJwXh.get()), (double)(f3 + 0.0F), (double)(f25 + (float)l1 + 0.0F)).tex((double)((f22 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + (float)l1 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f18)).color(f13, f14, f15, OBFVAL_yhkAO.get()).normal(0.0F, 0.0F, OBFVAL_hxVZE.get()).endVertex();
                            worldrenderer.pos((double)(f24 + 0.0F), (double)(f3 + 0.0F), (double)(f25 + (float)l1 + 0.0F)).tex((double)((f22 + 0.0F) * OBFVAL_haVe5.get() + f17), (double)((f23 + (float)l1 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f18)).color(f13, f14, f15, OBFVAL_yhkAO.get()).normal(0.0F, 0.0F, OBFVAL_hxVZE.get()).endVertex();
                        }
                    }

                    if (l <= 1)
                    {
                        for (int i2 = 0; i2 < OBFVAL_NJbZB.get(); ++i2)
                        {
                            worldrenderer.pos((double)(f24 + 0.0F), (double)(f3 + OBFVAL_lvkuM.get()), (double)(f25 + (float)i2 + 1.0F - OBFVAL_po7Kq.get())).tex((double)((f22 + 0.0F) * OBFVAL_haVe5.get() + f17), (double)((f23 + (float)i2 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f18)).color(f13, f14, f15, OBFVAL_yhkAO.get()).normal(0.0F, 0.0F, 1.0F).endVertex();
                            worldrenderer.pos((double)(f24 + OBFVAL_SJwXh.get()), (double)(f3 + OBFVAL_lvkuM.get()), (double)(f25 + (float)i2 + 1.0F - OBFVAL_po7Kq.get())).tex((double)((f22 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + (float)i2 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f18)).color(f13, f14, f15, OBFVAL_yhkAO.get()).normal(0.0F, 0.0F, 1.0F).endVertex();
                            worldrenderer.pos((double)(f24 + OBFVAL_SJwXh.get()), (double)(f3 + 0.0F), (double)(f25 + (float)i2 + 1.0F - OBFVAL_po7Kq.get())).tex((double)((f22 + OBFVAL_SJwXh.get()) * OBFVAL_haVe5.get() + f17), (double)((f23 + (float)i2 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f18)).color(f13, f14, f15, OBFVAL_yhkAO.get()).normal(0.0F, 0.0F, 1.0F).endVertex();
                            worldrenderer.pos((double)(f24 + 0.0F), (double)(f3 + 0.0F), (double)(f25 + (float)i2 + 1.0F - OBFVAL_po7Kq.get())).tex((double)((f22 + 0.0F) * OBFVAL_haVe5.get() + f17), (double)((f23 + (float)i2 + OBFVAL_jRv9x.get()) * OBFVAL_haVe5.get() + f18)).color(f13, f14, f15, OBFVAL_yhkAO.get()).normal(0.0F, 0.0F, 1.0F).endVertex();
                        }
                    }

                    tessellator.draw();
                }
            }

            this.cloudRenderer.endUpdateGlList();
        }

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.disableBlend();
        GlStateManager.enableCull();
    }

    public void updateChunks(long finishTimeNano)
    {
        finishTimeNano = (long)((double)finishTimeNano + OBFVAL_MmhIX.get());
        this.displayListEntitiesDirty |= this.renderDispatcher.runChunkUploads(finishTimeNano);

        if (this.chunksToUpdateForced.size() > 0)
        {
            Iterator iterator = this.chunksToUpdateForced.iterator();

            while (iterator.hasNext())
            {
                RenderChunk renderchunk = (RenderChunk)iterator.next();

                if (!this.renderDispatcher.updateChunkLater(renderchunk))
                {
                    break;
                }

                renderchunk.setNeedsUpdate(false);
                iterator.remove();
                this.chunksToUpdate.remove(renderchunk);
                this.chunksToResortTransparency.remove(renderchunk);
            }
        }

        if (this.chunksToResortTransparency.size() > 0)
        {
            Iterator iterator2 = this.chunksToResortTransparency.iterator();

            if (iterator2.hasNext())
            {
                RenderChunk renderchunk2 = (RenderChunk)iterator2.next();

                if (this.renderDispatcher.updateTransparencyLater(renderchunk2))
                {
                    iterator2.remove();
                }
            }
        }

        int j = 0;
        int k = Config.getUpdatesPerFrame();
        int i = k * OBFVAL_rtaa5.get();
        Iterator iterator1 = this.chunksToUpdate.iterator();

        while (iterator1.hasNext())
        {
            RenderChunk renderchunk1 = (RenderChunk)iterator1.next();

            if (!this.renderDispatcher.updateChunkLater(renderchunk1))
            {
                break;
            }

            renderchunk1.setNeedsUpdate(false);
            iterator1.remove();

            if (renderchunk1.getCompiledChunk().isEmpty() && k < i)
            {
                ++k;
            }

            ++j;

            if (j >= k)
            {
                break;
            }
        }
    }

    public void renderWorldBorder(Entity p_180449_1_, float partialTicks)
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        WorldBorder worldborder = this.theWorld.getWorldBorder();
        double d0 = (double)(this.mc.gameSettings.renderDistanceChunks * OBFVAL_KiCmU.get());

        if (p_180449_1_.posX >= worldborder.maxX() - d0 || p_180449_1_.posX <= worldborder.minX() + d0 || p_180449_1_.posZ >= worldborder.maxZ() - d0 || p_180449_1_.posZ <= worldborder.minZ() + d0)
        {
            double d1 = 1.0D - worldborder.getClosestDistance(p_180449_1_) / d0;
            d1 = Math.pow(d1, OBFVAL_P5cvI.get());
            double d2 = p_180449_1_.lastTickPosX + (p_180449_1_.posX - p_180449_1_.lastTickPosX) * (double)partialTicks;
            double d3 = p_180449_1_.lastTickPosY + (p_180449_1_.posY - p_180449_1_.lastTickPosY) * (double)partialTicks;
            double d4 = p_180449_1_.lastTickPosZ + (p_180449_1_.posZ - p_180449_1_.lastTickPosZ) * (double)partialTicks;
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(OBFVAL_H169w.get(), 1, 1, 0);
            this.renderEngine.bindTexture(locationForcefieldPng);
            GlStateManager.depthMask(false);
            GlStateManager.pushMatrix();
            int i = worldborder.getStatus().getID();
            float f = (float)(i >> OBFVAL_KiCmU.get() & OBFVAL_eydYI.get()) / OBFVAL_WAHjp.get();
            float f1 = (float)(i >> OBFVAL_NJbZB.get() & OBFVAL_eydYI.get()) / OBFVAL_WAHjp.get();
            float f2 = (float)(i & OBFVAL_eydYI.get()) / OBFVAL_WAHjp.get();
            GlStateManager.color(f, f1, f2, (float)d1);
            GlStateManager.doPolygonOffset(OBFVAL_OlhPU.get(), OBFVAL_OlhPU.get());
            GlStateManager.enablePolygonOffset();
            GlStateManager.alphaFunc(OBFVAL_D44AL.get(), OBFVAL_6wjOg.get());
            GlStateManager.enableAlpha();
            GlStateManager.disableCull();
            float f3 = (float)(Minecraft.getSystemTime() % OBFVAL_JhC4g.get()) / OBFVAL_XbQDH.get();
            float f4 = 0.0F;
            float f5 = 0.0F;
            float f6 = OBFVAL_c0cPA.get();
            worldrenderer.begin(OBFVAL_f8Aft.get(), DefaultVertexFormats.POSITION_TEX);
            worldrenderer.setTranslation(-d2, -d3, -d4);
            double d5 = Math.max((double)MathHelper.floor_double(d4 - d0), worldborder.minZ());
            double d6 = Math.min((double)MathHelper.ceiling_double_int(d4 + d0), worldborder.maxZ());

            if (d2 > worldborder.maxX() - d0)
            {
                float f7 = 0.0F;

                for (double d7 = d5; d7 < d6; f7 += OBFVAL_jRv9x.get())
                {
                    double d8 = Math.min(1.0D, d6 - d7);
                    float f8 = (float)d8 * OBFVAL_jRv9x.get();
                    worldrenderer.pos(worldborder.maxX(), OBFVAL_ulxLf.get(), d7).tex((double)(f3 + f7), (double)(f3 + 0.0F)).endVertex();
                    worldrenderer.pos(worldborder.maxX(), OBFVAL_ulxLf.get(), d7 + d8).tex((double)(f3 + f8 + f7), (double)(f3 + 0.0F)).endVertex();
                    worldrenderer.pos(worldborder.maxX(), 0.0D, d7 + d8).tex((double)(f3 + f8 + f7), (double)(f3 + OBFVAL_c0cPA.get())).endVertex();
                    worldrenderer.pos(worldborder.maxX(), 0.0D, d7).tex((double)(f3 + f7), (double)(f3 + OBFVAL_c0cPA.get())).endVertex();
                    ++d7;
                }
            }

            if (d2 < worldborder.minX() + d0)
            {
                float f9 = 0.0F;

                for (double d9 = d5; d9 < d6; f9 += OBFVAL_jRv9x.get())
                {
                    double d12 = Math.min(1.0D, d6 - d9);
                    float f12 = (float)d12 * OBFVAL_jRv9x.get();
                    worldrenderer.pos(worldborder.minX(), OBFVAL_ulxLf.get(), d9).tex((double)(f3 + f9), (double)(f3 + 0.0F)).endVertex();
                    worldrenderer.pos(worldborder.minX(), OBFVAL_ulxLf.get(), d9 + d12).tex((double)(f3 + f12 + f9), (double)(f3 + 0.0F)).endVertex();
                    worldrenderer.pos(worldborder.minX(), 0.0D, d9 + d12).tex((double)(f3 + f12 + f9), (double)(f3 + OBFVAL_c0cPA.get())).endVertex();
                    worldrenderer.pos(worldborder.minX(), 0.0D, d9).tex((double)(f3 + f9), (double)(f3 + OBFVAL_c0cPA.get())).endVertex();
                    ++d9;
                }
            }

            d5 = Math.max((double)MathHelper.floor_double(d2 - d0), worldborder.minX());
            d6 = Math.min((double)MathHelper.ceiling_double_int(d2 + d0), worldborder.maxX());

            if (d4 > worldborder.maxZ() - d0)
            {
                float f10 = 0.0F;

                for (double d10 = d5; d10 < d6; f10 += OBFVAL_jRv9x.get())
                {
                    double d13 = Math.min(1.0D, d6 - d10);
                    float f13 = (float)d13 * OBFVAL_jRv9x.get();
                    worldrenderer.pos(d10, OBFVAL_ulxLf.get(), worldborder.maxZ()).tex((double)(f3 + f10), (double)(f3 + 0.0F)).endVertex();
                    worldrenderer.pos(d10 + d13, OBFVAL_ulxLf.get(), worldborder.maxZ()).tex((double)(f3 + f13 + f10), (double)(f3 + 0.0F)).endVertex();
                    worldrenderer.pos(d10 + d13, 0.0D, worldborder.maxZ()).tex((double)(f3 + f13 + f10), (double)(f3 + OBFVAL_c0cPA.get())).endVertex();
                    worldrenderer.pos(d10, 0.0D, worldborder.maxZ()).tex((double)(f3 + f10), (double)(f3 + OBFVAL_c0cPA.get())).endVertex();
                    ++d10;
                }
            }

            if (d4 < worldborder.minZ() + d0)
            {
                float f11 = 0.0F;

                for (double d11 = d5; d11 < d6; f11 += OBFVAL_jRv9x.get())
                {
                    double d14 = Math.min(1.0D, d6 - d11);
                    float f14 = (float)d14 * OBFVAL_jRv9x.get();
                    worldrenderer.pos(d11, OBFVAL_ulxLf.get(), worldborder.minZ()).tex((double)(f3 + f11), (double)(f3 + 0.0F)).endVertex();
                    worldrenderer.pos(d11 + d14, OBFVAL_ulxLf.get(), worldborder.minZ()).tex((double)(f3 + f14 + f11), (double)(f3 + 0.0F)).endVertex();
                    worldrenderer.pos(d11 + d14, 0.0D, worldborder.minZ()).tex((double)(f3 + f14 + f11), (double)(f3 + OBFVAL_c0cPA.get())).endVertex();
                    worldrenderer.pos(d11, 0.0D, worldborder.minZ()).tex((double)(f3 + f11), (double)(f3 + OBFVAL_c0cPA.get())).endVertex();
                    ++d11;
                }
            }

            tessellator.draw();
            worldrenderer.setTranslation(0.0D, 0.0D, 0.0D);
            GlStateManager.enableCull();
            GlStateManager.disableAlpha();
            GlStateManager.doPolygonOffset(0.0F, 0.0F);
            GlStateManager.disablePolygonOffset();
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
        }
    }

    private void preRenderDamagedBlocks()
    {
        GlStateManager.tryBlendFuncSeparate(OBFVAL_AxM1T.get(), OBFVAL_V67xM.get(), 1, 0);
        GlStateManager.enableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F, OBFVAL_jRv9x.get());
        GlStateManager.doPolygonOffset(OBFVAL_OlhPU.get(), OBFVAL_OlhPU.get());
        GlStateManager.enablePolygonOffset();
        GlStateManager.alphaFunc(OBFVAL_D44AL.get(), OBFVAL_6wjOg.get());
        GlStateManager.enableAlpha();
        GlStateManager.pushMatrix();

        if (Config.isShaders())
        {
            ShadersRender.beginBlockDamage();
        }
    }

    private void postRenderDamagedBlocks()
    {
        GlStateManager.disableAlpha();
        GlStateManager.doPolygonOffset(0.0F, 0.0F);
        GlStateManager.disablePolygonOffset();
        GlStateManager.enableAlpha();
        GlStateManager.depthMask(true);
        GlStateManager.popMatrix();

        if (Config.isShaders())
        {
            ShadersRender.endBlockDamage();
        }
    }

    public void drawBlockDamageTexture(Tessellator tessellatorIn, WorldRenderer worldRendererIn, Entity entityIn, float partialTicks)
    {
        double d0 = entityIn.lastTickPosX + (entityIn.posX - entityIn.lastTickPosX) * (double)partialTicks;
        double d1 = entityIn.lastTickPosY + (entityIn.posY - entityIn.lastTickPosY) * (double)partialTicks;
        double d2 = entityIn.lastTickPosZ + (entityIn.posZ - entityIn.lastTickPosZ) * (double)partialTicks;

        if (!this.damagedBlocks.isEmpty())
        {
            this.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
            this.preRenderDamagedBlocks();
            worldRendererIn.begin(OBFVAL_f8Aft.get(), DefaultVertexFormats.BLOCK);
            worldRendererIn.setTranslation(-d0, -d1, -d2);
            worldRendererIn.markDirty();
            Iterator iterator = this.damagedBlocks.values().iterator();

            while (iterator.hasNext())
            {
                DestroyBlockProgress destroyblockprogress = (DestroyBlockProgress)iterator.next();
                BlockPos blockpos = destroyblockprogress.getPosition();
                double d3 = (double)blockpos.getX() - d0;
                double d4 = (double)blockpos.getY() - d1;
                double d5 = (double)blockpos.getZ() - d2;
                Block block = this.theWorld.getBlockState(blockpos).getBlock();
                boolean flag = !(block instanceof BlockChest) && !(block instanceof BlockEnderChest) && !(block instanceof BlockSign) && !(block instanceof BlockSkull);

                if (flag)
                {
                    if (d3 * d3 + d4 * d4 + d5 * d5 > OBFVAL_hcvrF.get())
                    {
                        iterator.remove();
                    }
                    else
                    {
                        IBlockState iblockstate = this.theWorld.getBlockState(blockpos);

                        if (iblockstate.getBlock().getMaterial() != Material.air)
                        {
                            int i = destroyblockprogress.getPartialBlockDamage();
                            TextureAtlasSprite textureatlassprite = this.destroyBlockIcons[i];
                            BlockRendererDispatcher blockrendererdispatcher = this.mc.getBlockRendererDispatcher();
                            blockrendererdispatcher.renderBlockDamage(iblockstate, blockpos, textureatlassprite, this.theWorld);
                        }
                    }
                }
            }

            tessellatorIn.draw();
            worldRendererIn.setTranslation(0.0D, 0.0D, 0.0D);
            this.postRenderDamagedBlocks();
        }
    }

    /**
     * Draws the selection box for the player. Args: entityPlayer, rayTraceHit, i, itemStack, partialTickTime
     */
    public void drawSelectionBox(EntityPlayer player, MovingObjectPosition movingObjectPositionIn, int p_72731_3_, float partialTicks)
    {
        if (p_72731_3_ == 0 && movingObjectPositionIn.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
        {
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(OBFVAL_H169w.get(), OBFVAL_lEpfw.get(), 1, 0);
            GlStateManager.color(0.0F, 0.0F, 0.0F, OBFVAL_blNh9.get());
            GL11.glLineWidth(OBFVAL_uH7g9.get());
            GlStateManager.disableTexture2D();

            if (Config.isShaders())
            {
                Shaders.disableTexture2D();
            }

            GlStateManager.depthMask(false);
            float f = OBFVAL_plBla.get();
            BlockPos blockpos = movingObjectPositionIn.getBlockPos();
            Block block = this.theWorld.getBlockState(blockpos).getBlock();

            if (block.getMaterial() != Material.air && this.theWorld.getWorldBorder().contains(blockpos))
            {
                block.setBlockBoundsBasedOnState(this.theWorld, blockpos);
                double d0 = player.lastTickPosX + (player.posX - player.lastTickPosX) * (double)partialTicks;
                double d1 = player.lastTickPosY + (player.posY - player.lastTickPosY) * (double)partialTicks;
                double d2 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * (double)partialTicks;
                func_181561_a(block.getSelectedBoundingBox(this.theWorld, blockpos).expand(OBFVAL_Nfb8N.get(), OBFVAL_Nfb8N.get(), OBFVAL_Nfb8N.get()).offset(-d0, -d1, -d2));
            }

            GlStateManager.depthMask(true);
            GlStateManager.enableTexture2D();

            if (Config.isShaders())
            {
                Shaders.enableTexture2D();
            }

            GlStateManager.disableBlend();
        }
    }

    public static void func_181561_a(AxisAlignedBB p_181561_0_)
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(OBFVAL_zg5AC.get(), DefaultVertexFormats.POSITION);
        worldrenderer.pos(p_181561_0_.minX, p_181561_0_.minY, p_181561_0_.minZ).endVertex();
        worldrenderer.pos(p_181561_0_.maxX, p_181561_0_.minY, p_181561_0_.minZ).endVertex();
        worldrenderer.pos(p_181561_0_.maxX, p_181561_0_.minY, p_181561_0_.maxZ).endVertex();
        worldrenderer.pos(p_181561_0_.minX, p_181561_0_.minY, p_181561_0_.maxZ).endVertex();
        worldrenderer.pos(p_181561_0_.minX, p_181561_0_.minY, p_181561_0_.minZ).endVertex();
        tessellator.draw();
        worldrenderer.begin(OBFVAL_zg5AC.get(), DefaultVertexFormats.POSITION);
        worldrenderer.pos(p_181561_0_.minX, p_181561_0_.maxY, p_181561_0_.minZ).endVertex();
        worldrenderer.pos(p_181561_0_.maxX, p_181561_0_.maxY, p_181561_0_.minZ).endVertex();
        worldrenderer.pos(p_181561_0_.maxX, p_181561_0_.maxY, p_181561_0_.maxZ).endVertex();
        worldrenderer.pos(p_181561_0_.minX, p_181561_0_.maxY, p_181561_0_.maxZ).endVertex();
        worldrenderer.pos(p_181561_0_.minX, p_181561_0_.maxY, p_181561_0_.minZ).endVertex();
        tessellator.draw();
        worldrenderer.begin(1, DefaultVertexFormats.POSITION);
        worldrenderer.pos(p_181561_0_.minX, p_181561_0_.minY, p_181561_0_.minZ).endVertex();
        worldrenderer.pos(p_181561_0_.minX, p_181561_0_.maxY, p_181561_0_.minZ).endVertex();
        worldrenderer.pos(p_181561_0_.maxX, p_181561_0_.minY, p_181561_0_.minZ).endVertex();
        worldrenderer.pos(p_181561_0_.maxX, p_181561_0_.maxY, p_181561_0_.minZ).endVertex();
        worldrenderer.pos(p_181561_0_.maxX, p_181561_0_.minY, p_181561_0_.maxZ).endVertex();
        worldrenderer.pos(p_181561_0_.maxX, p_181561_0_.maxY, p_181561_0_.maxZ).endVertex();
        worldrenderer.pos(p_181561_0_.minX, p_181561_0_.minY, p_181561_0_.maxZ).endVertex();
        worldrenderer.pos(p_181561_0_.minX, p_181561_0_.maxY, p_181561_0_.maxZ).endVertex();
        tessellator.draw();
    }

    public static void func_181563_a(AxisAlignedBB p_181563_0_, int p_181563_1_, int p_181563_2_, int p_181563_3_, int p_181563_4_)
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(OBFVAL_zg5AC.get(), DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos(p_181563_0_.minX, p_181563_0_.minY, p_181563_0_.minZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        worldrenderer.pos(p_181563_0_.maxX, p_181563_0_.minY, p_181563_0_.minZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        worldrenderer.pos(p_181563_0_.maxX, p_181563_0_.minY, p_181563_0_.maxZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        worldrenderer.pos(p_181563_0_.minX, p_181563_0_.minY, p_181563_0_.maxZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        worldrenderer.pos(p_181563_0_.minX, p_181563_0_.minY, p_181563_0_.minZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        tessellator.draw();
        worldrenderer.begin(OBFVAL_zg5AC.get(), DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos(p_181563_0_.minX, p_181563_0_.maxY, p_181563_0_.minZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        worldrenderer.pos(p_181563_0_.maxX, p_181563_0_.maxY, p_181563_0_.minZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        worldrenderer.pos(p_181563_0_.maxX, p_181563_0_.maxY, p_181563_0_.maxZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        worldrenderer.pos(p_181563_0_.minX, p_181563_0_.maxY, p_181563_0_.maxZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        worldrenderer.pos(p_181563_0_.minX, p_181563_0_.maxY, p_181563_0_.minZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        tessellator.draw();
        worldrenderer.begin(1, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos(p_181563_0_.minX, p_181563_0_.minY, p_181563_0_.minZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        worldrenderer.pos(p_181563_0_.minX, p_181563_0_.maxY, p_181563_0_.minZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        worldrenderer.pos(p_181563_0_.maxX, p_181563_0_.minY, p_181563_0_.minZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        worldrenderer.pos(p_181563_0_.maxX, p_181563_0_.maxY, p_181563_0_.minZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        worldrenderer.pos(p_181563_0_.maxX, p_181563_0_.minY, p_181563_0_.maxZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        worldrenderer.pos(p_181563_0_.maxX, p_181563_0_.maxY, p_181563_0_.maxZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        worldrenderer.pos(p_181563_0_.minX, p_181563_0_.minY, p_181563_0_.maxZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        worldrenderer.pos(p_181563_0_.minX, p_181563_0_.maxY, p_181563_0_.maxZ).color(p_181563_1_, p_181563_2_, p_181563_3_, p_181563_4_).endVertex();
        tessellator.draw();
    }

    /**
     * Marks the blocks in the given range for update
     */
    private void markBlocksForUpdate(int x1, int y1, int z1, int x2, int y2, int z2)
    {
        this.viewFrustum.markBlocksForUpdate(x1, y1, z1, x2, y2, z2);
    }

    public void markBlockForUpdate(BlockPos pos)
    {
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();
        this.markBlocksForUpdate(i - 1, j - 1, k - 1, i + 1, j + 1, k + 1);
    }

    public void notifyLightSet(BlockPos pos)
    {
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();
        this.markBlocksForUpdate(i - 1, j - 1, k - 1, i + 1, j + 1, k + 1);
    }

    /**
     * On the client, re-renders all blocks in this range, inclusive. On the server, does nothing. Args: min x, min y,
     * min z, max x, max y, max z
     */
    public void markBlockRangeForRenderUpdate(int x1, int y1, int z1, int x2, int y2, int z2)
    {
        this.markBlocksForUpdate(x1 - 1, y1 - 1, z1 - 1, x2 + 1, y2 + 1, z2 + 1);
    }

    public void playRecord(String recordName, BlockPos blockPosIn)
    {
        ISound isound = (ISound)this.mapSoundPositions.get(blockPosIn);

        if (isound != null)
        {
            this.mc.getSoundHandler().stopSound(isound);
            this.mapSoundPositions.remove(blockPosIn);
        }

        if (recordName != null)
        {
            ItemRecord itemrecord = ItemRecord.getRecord(recordName);

            if (itemrecord != null)
            {
                this.mc.ingameGUI.setRecordPlayingMessage(itemrecord.getRecordNameLocal());
            }

            ResourceLocation resourcelocation = null;

            if (resourcelocation == null)
            {
                resourcelocation = new ResourceLocation(recordName);
            }

            PositionedSoundRecord positionedsoundrecord = PositionedSoundRecord.create(resourcelocation, (float)blockPosIn.getX(), (float)blockPosIn.getY(), (float)blockPosIn.getZ());
            this.mapSoundPositions.put(blockPosIn, positionedsoundrecord);
            this.mc.getSoundHandler().playSound(positionedsoundrecord);
        }
    }

    /**
     * Plays the specified sound. Arg: soundName, x, y, z, volume, pitch
     */
    public void playSound(String soundName, double x, double y, double z, float volume, float pitch)
    {
    }

    /**
     * Plays sound to all near players except the player reference given
     */
    public void playSoundToNearExcept(EntityPlayer except, String soundName, double x, double y, double z, float volume, float pitch)
    {
    }

    public void spawnParticle(int particleID, boolean ignoreRange, final double xCoord, final double yCoord, final double zCoord, double xOffset, double yOffset, double zOffset, int... p_180442_15_)
    {
        try
        {
            this.spawnEntityFX(particleID, ignoreRange, xCoord, yCoord, zCoord, xOffset, yOffset, zOffset, p_180442_15_);
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Exception while adding particle");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("Particle being added");
            crashreportcategory.addCrashSection("ID", Integer.valueOf(particleID));

            if (p_180442_15_ != null)
            {
                crashreportcategory.addCrashSection("Parameters", p_180442_15_);
            }

            crashreportcategory.addCrashSectionCallable("Position", new Callable()
            {
                private static final String __OBFID = "CL_00000955";
                public String call() throws Exception
                {
                    return CrashReportCategory.getCoordinateInfo(xCoord, yCoord, zCoord);
                }
            });
            throw new ReportedException(crashreport);
        }
    }

    private void spawnParticle(EnumParticleTypes particleIn, double p_174972_2_, double p_174972_4_, double p_174972_6_, double p_174972_8_, double p_174972_10_, double p_174972_12_, int... p_174972_14_)
    {
        this.spawnParticle(particleIn.getParticleID(), particleIn.getShouldIgnoreRange(), p_174972_2_, p_174972_4_, p_174972_6_, p_174972_8_, p_174972_10_, p_174972_12_, p_174972_14_);
    }

    private EntityFX spawnEntityFX(int p_174974_1_, boolean ignoreRange, double p_174974_3_, double p_174974_5_, double p_174974_7_, double p_174974_9_, double p_174974_11_, double p_174974_13_, int... p_174974_15_)
    {
        if (this.mc != null && this.mc.getRenderViewEntity() != null && this.mc.effectRenderer != null)
        {
            int i = this.mc.gameSettings.particleSetting;

            if (i == 1 && this.theWorld.rand.nextInt(OBFVAL_zg5AC.get()) == 0)
            {
                i = OBFVAL_rtaa5.get();
            }

            double d0 = this.mc.getRenderViewEntity().posX - p_174974_3_;
            double d1 = this.mc.getRenderViewEntity().posY - p_174974_5_;
            double d2 = this.mc.getRenderViewEntity().posZ - p_174974_7_;

            if (p_174974_1_ == EnumParticleTypes.EXPLOSION_HUGE.getParticleID() && !Config.isAnimatedExplosion())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.EXPLOSION_LARGE.getParticleID() && !Config.isAnimatedExplosion())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.EXPLOSION_NORMAL.getParticleID() && !Config.isAnimatedExplosion())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.SUSPENDED.getParticleID() && !Config.isWaterParticles())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.SUSPENDED_DEPTH.getParticleID() && !Config.isVoidParticles())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.SMOKE_NORMAL.getParticleID() && !Config.isAnimatedSmoke())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.SMOKE_LARGE.getParticleID() && !Config.isAnimatedSmoke())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.SPELL_MOB.getParticleID() && !Config.isPotionParticles())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.SPELL_MOB_AMBIENT.getParticleID() && !Config.isPotionParticles())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.SPELL.getParticleID() && !Config.isPotionParticles())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.SPELL_INSTANT.getParticleID() && !Config.isPotionParticles())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.SPELL_WITCH.getParticleID() && !Config.isPotionParticles())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.PORTAL.getParticleID() && !Config.isAnimatedPortal())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.FLAME.getParticleID() && !Config.isAnimatedFlame())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.REDSTONE.getParticleID() && !Config.isAnimatedRedstone())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.DRIP_WATER.getParticleID() && !Config.isDrippingWaterLava())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.DRIP_LAVA.getParticleID() && !Config.isDrippingWaterLava())
            {
                return null;
            }
            else if (p_174974_1_ == EnumParticleTypes.FIREWORKS_SPARK.getParticleID() && !Config.isFireworkParticles())
            {
                return null;
            }
            else if (ignoreRange)
            {
                return this.mc.effectRenderer.spawnEffectParticle(p_174974_1_, p_174974_3_, p_174974_5_, p_174974_7_, p_174974_9_, p_174974_11_, p_174974_13_, p_174974_15_);
            }
            else
            {
                double d3 = OBFVAL_S9073.get();
                double d4 = OBFVAL_ulxLf.get();

                if (p_174974_1_ == EnumParticleTypes.CRIT.getParticleID())
                {
                    d4 = OBFVAL_VrdQ1.get();
                }

                if (d0 * d0 + d1 * d1 + d2 * d2 > d4)
                {
                    return null;
                }
                else if (i > 1)
                {
                    return null;
                }
                else
                {
                    EntityFX entityfx = this.mc.effectRenderer.spawnEffectParticle(p_174974_1_, p_174974_3_, p_174974_5_, p_174974_7_, p_174974_9_, p_174974_11_, p_174974_13_, p_174974_15_);

                    if (p_174974_1_ == EnumParticleTypes.WATER_BUBBLE.getParticleID())
                    {
                        CustomColors.updateWaterFX(entityfx, this.theWorld, p_174974_3_, p_174974_5_, p_174974_7_);
                    }

                    if (p_174974_1_ == EnumParticleTypes.WATER_SPLASH.getParticleID())
                    {
                        CustomColors.updateWaterFX(entityfx, this.theWorld, p_174974_3_, p_174974_5_, p_174974_7_);
                    }

                    if (p_174974_1_ == EnumParticleTypes.WATER_DROP.getParticleID())
                    {
                        CustomColors.updateWaterFX(entityfx, this.theWorld, p_174974_3_, p_174974_5_, p_174974_7_);
                    }

                    if (p_174974_1_ == EnumParticleTypes.TOWN_AURA.getParticleID())
                    {
                        CustomColors.updateMyceliumFX(entityfx);
                    }

                    if (p_174974_1_ == EnumParticleTypes.PORTAL.getParticleID())
                    {
                        CustomColors.updatePortalFX(entityfx);
                    }

                    if (p_174974_1_ == EnumParticleTypes.REDSTONE.getParticleID())
                    {
                        CustomColors.updateReddustFX(entityfx, this.theWorld, p_174974_3_, p_174974_5_, p_174974_7_);
                    }

                    return entityfx;
                }
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * Called on all IWorldAccesses when an entity is created or loaded. On client worlds, starts downloading any
     * necessary textures. On server worlds, adds the entity to the entity tracker.
     */
    public void onEntityAdded(Entity entityIn)
    {
        RandomMobs.entityLoaded(entityIn, this.theWorld);

        if (Config.isDynamicLights())
        {
            DynamicLights.entityAdded(entityIn, this);
        }
    }

    /**
     * Called on all IWorldAccesses when an entity is unloaded or destroyed. On client worlds, releases any downloaded
     * textures. On server worlds, removes the entity from the entity tracker.
     */
    public void onEntityRemoved(Entity entityIn)
    {
        if (Config.isDynamicLights())
        {
            DynamicLights.entityRemoved(entityIn, this);
        }
    }

    /**
     * Deletes all display lists
     */
    public void deleteAllDisplayLists()
    {
    }

    public void broadcastSound(int p_180440_1_, BlockPos p_180440_2_, int p_180440_3_)
    {
        switch (p_180440_1_)
        {
            case 1013:
            case 1018:
                if (this.mc.getRenderViewEntity() != null)
                {
                    double d0 = (double)p_180440_2_.getX() - this.mc.getRenderViewEntity().posX;
                    double d1 = (double)p_180440_2_.getY() - this.mc.getRenderViewEntity().posY;
                    double d2 = (double)p_180440_2_.getZ() - this.mc.getRenderViewEntity().posZ;
                    double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                    double d4 = this.mc.getRenderViewEntity().posX;
                    double d5 = this.mc.getRenderViewEntity().posY;
                    double d6 = this.mc.getRenderViewEntity().posZ;

                    if (d3 > 0.0D)
                    {
                        d4 += d0 / d3 * OBFVAL_uwArG.get();
                        d5 += d1 / d3 * OBFVAL_uwArG.get();
                        d6 += d2 / d3 * OBFVAL_uwArG.get();
                    }

                    if (p_180440_1_ == OBFVAL_zTw8w.get())
                    {
                        this.theWorld.playSound(d4, d5, d6, "mob.wither.spawn", 1.0F, 1.0F, false);
                    }
                    else
                    {
                        this.theWorld.playSound(d4, d5, d6, "mob.enderdragon.end", OBFVAL_4U9SJ.get(), 1.0F, false);
                    }
                }

            default:
        }
    }

    public void playAuxSFX(EntityPlayer player, int sfxType, BlockPos blockPosIn, int p_180439_4_)
    {
        Random random = this.theWorld.rand;

        switch (sfxType)
        {
            case 1000:
                this.theWorld.playSoundAtPos(blockPosIn, "random.click", 1.0F, 1.0F, false);
                break;

            case 1001:
                this.theWorld.playSoundAtPos(blockPosIn, "random.click", 1.0F, OBFVAL_wTpdn.get(), false);
                break;

            case 1002:
                this.theWorld.playSoundAtPos(blockPosIn, "random.bow", 1.0F, OBFVAL_wTpdn.get(), false);
                break;

            case 1003:
                this.theWorld.playSoundAtPos(blockPosIn, "random.door_open", 1.0F, this.theWorld.rand.nextFloat() * OBFVAL_6wjOg.get() + OBFVAL_x5114.get(), false);
                break;

            case 1004:
                this.theWorld.playSoundAtPos(blockPosIn, "random.fizz", OBFVAL_jRv9x.get(), OBFVAL_lqmyH.get() + (random.nextFloat() - random.nextFloat()) * OBFVAL_yhkAO.get(), false);
                break;

            case 1005:
                if (Item.getItemById(p_180439_4_) instanceof ItemRecord)
                {
                    this.theWorld.playRecord(blockPosIn, "records." + ((ItemRecord)Item.getItemById(p_180439_4_)).recordName);
                }
                else
                {
                    this.theWorld.playRecord(blockPosIn, (String)null);
                }

                break;

            case 1006:
                this.theWorld.playSoundAtPos(blockPosIn, "random.door_close", 1.0F, this.theWorld.rand.nextFloat() * OBFVAL_6wjOg.get() + OBFVAL_x5114.get(), false);
                break;

            case 1007:
                this.theWorld.playSoundAtPos(blockPosIn, "mob.ghast.charge", OBFVAL_bXioY.get(), (random.nextFloat() - random.nextFloat()) * OBFVAL_vDjW0.get() + 1.0F, false);
                break;

            case 1008:
                this.theWorld.playSoundAtPos(blockPosIn, "mob.ghast.fireball", OBFVAL_bXioY.get(), (random.nextFloat() - random.nextFloat()) * OBFVAL_vDjW0.get() + 1.0F, false);
                break;

            case 1009:
                this.theWorld.playSoundAtPos(blockPosIn, "mob.ghast.fireball", OBFVAL_uH7g9.get(), (random.nextFloat() - random.nextFloat()) * OBFVAL_vDjW0.get() + 1.0F, false);
                break;

            case 1010:
                this.theWorld.playSoundAtPos(blockPosIn, "mob.zombie.wood", OBFVAL_uH7g9.get(), (random.nextFloat() - random.nextFloat()) * OBFVAL_vDjW0.get() + 1.0F, false);
                break;

            case 1011:
                this.theWorld.playSoundAtPos(blockPosIn, "mob.zombie.metal", OBFVAL_uH7g9.get(), (random.nextFloat() - random.nextFloat()) * OBFVAL_vDjW0.get() + 1.0F, false);
                break;

            case 1012:
                this.theWorld.playSoundAtPos(blockPosIn, "mob.zombie.woodbreak", OBFVAL_uH7g9.get(), (random.nextFloat() - random.nextFloat()) * OBFVAL_vDjW0.get() + 1.0F, false);
                break;

            case 1014:
                this.theWorld.playSoundAtPos(blockPosIn, "mob.wither.shoot", OBFVAL_uH7g9.get(), (random.nextFloat() - random.nextFloat()) * OBFVAL_vDjW0.get() + 1.0F, false);
                break;

            case 1015:
                this.theWorld.playSoundAtPos(blockPosIn, "mob.bat.takeoff", OBFVAL_YPPef.get(), (random.nextFloat() - random.nextFloat()) * OBFVAL_vDjW0.get() + 1.0F, false);
                break;

            case 1016:
                this.theWorld.playSoundAtPos(blockPosIn, "mob.zombie.infect", OBFVAL_uH7g9.get(), (random.nextFloat() - random.nextFloat()) * OBFVAL_vDjW0.get() + 1.0F, false);
                break;

            case 1017:
                this.theWorld.playSoundAtPos(blockPosIn, "mob.zombie.unfect", OBFVAL_uH7g9.get(), (random.nextFloat() - random.nextFloat()) * OBFVAL_vDjW0.get() + 1.0F, false);
                break;

            case 1020:
                this.theWorld.playSoundAtPos(blockPosIn, "random.anvil_break", 1.0F, this.theWorld.rand.nextFloat() * OBFVAL_6wjOg.get() + OBFVAL_x5114.get(), false);
                break;

            case 1021:
                this.theWorld.playSoundAtPos(blockPosIn, "random.anvil_use", 1.0F, this.theWorld.rand.nextFloat() * OBFVAL_6wjOg.get() + OBFVAL_x5114.get(), false);
                break;

            case 1022:
                this.theWorld.playSoundAtPos(blockPosIn, "random.anvil_land", OBFVAL_yE88W.get(), this.theWorld.rand.nextFloat() * OBFVAL_6wjOg.get() + OBFVAL_x5114.get(), false);
                break;

            case 2000:
                int i = p_180439_4_ % OBFVAL_zg5AC.get() - 1;
                int j = p_180439_4_ / OBFVAL_zg5AC.get() % OBFVAL_zg5AC.get() - 1;
                double d0 = (double)blockPosIn.getX() + (double)i * OBFVAL_toMYn.get() + OBFVAL_dvM3q.get();
                double d1 = (double)blockPosIn.getY() + OBFVAL_dvM3q.get();
                double d2 = (double)blockPosIn.getZ() + (double)j * OBFVAL_toMYn.get() + OBFVAL_dvM3q.get();

                for (int i1 = 0; i1 < OBFVAL_rgMsi.get(); ++i1)
                {
                    double d15 = random.nextDouble() * OBFVAL_F149Y.get() + OBFVAL_9Vnjm.get();
                    double d16 = d0 + (double)i * OBFVAL_9Vnjm.get() + (random.nextDouble() - OBFVAL_dvM3q.get()) * (double)j * OBFVAL_dvM3q.get();
                    double d17 = d1 + (random.nextDouble() - OBFVAL_dvM3q.get()) * OBFVAL_dvM3q.get();
                    double d18 = d2 + (double)j * OBFVAL_9Vnjm.get() + (random.nextDouble() - OBFVAL_dvM3q.get()) * (double)i * OBFVAL_dvM3q.get();
                    double d19 = (double)i * d15 + random.nextGaussian() * OBFVAL_9Vnjm.get();
                    double d20 = OBFVAL_yAWjx.get() + random.nextGaussian() * OBFVAL_9Vnjm.get();
                    double d21 = (double)j * d15 + random.nextGaussian() * OBFVAL_9Vnjm.get();
                    this.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d16, d17, d18, d19, d20, d21, new int[0]);
                }

                return;

            case 2001:
                Block block = Block.getBlockById(p_180439_4_ & OBFVAL_rxz7p.get());

                if (block.getMaterial() != Material.air)
                {
                    this.mc.getSoundHandler().playSound(new PositionedSoundRecord(new ResourceLocation(block.stepSound.getBreakSound()), (block.stepSound.getVolume() + 1.0F) / OBFVAL_uH7g9.get(), block.stepSound.getFrequency() * OBFVAL_yhkAO.get(), (float)blockPosIn.getX() + OBFVAL_jRv9x.get(), (float)blockPosIn.getY() + OBFVAL_jRv9x.get(), (float)blockPosIn.getZ() + OBFVAL_jRv9x.get()));
                }

                this.mc.effectRenderer.addBlockDestroyEffects(blockPosIn, block.getStateFromMeta(p_180439_4_ >> OBFVAL_LPKYV.get() & OBFVAL_eydYI.get()));
                break;

            case 2002:
                double d3 = (double)blockPosIn.getX();
                double d4 = (double)blockPosIn.getY();
                double d5 = (double)blockPosIn.getZ();

                for (int k = 0; k < OBFVAL_NJbZB.get(); ++k)
                {
                    EnumParticleTypes enumparticletypes1 = EnumParticleTypes.ITEM_CRACK;
                    double d25 = random.nextGaussian() * OBFVAL_b6suT.get();
                    double d26 = random.nextDouble() * OBFVAL_F149Y.get();
                    double d27 = random.nextGaussian() * OBFVAL_b6suT.get();
                    int[] aint = new int[OBFVAL_rtaa5.get()];
                    aint[0] = Item.getIdFromItem(Items.potionitem);
                    aint[1] = p_180439_4_;
                    this.spawnParticle(enumparticletypes1, d3, d4, d5, d25, d26, d27, aint);
                }

                int j1 = Items.potionitem.getColorFromDamage(p_180439_4_);
                float f = (float)(j1 >> OBFVAL_KiCmU.get() & OBFVAL_eydYI.get()) / OBFVAL_WAHjp.get();
                float f1 = (float)(j1 >> OBFVAL_NJbZB.get() & OBFVAL_eydYI.get()) / OBFVAL_WAHjp.get();
                float f2 = (float)(j1 >> 0 & OBFVAL_eydYI.get()) / OBFVAL_WAHjp.get();
                EnumParticleTypes enumparticletypes = EnumParticleTypes.SPELL;

                if (Items.potionitem.isEffectInstant(p_180439_4_))
                {
                    enumparticletypes = EnumParticleTypes.SPELL_INSTANT;
                }

                for (int k1 = 0; k1 < OBFVAL_3dHZx.get(); ++k1)
                {
                    double d7 = random.nextDouble() * OBFVAL_P5cvI.get();
                    double d9 = random.nextDouble() * OBFVAL_vn9NC.get() * OBFVAL_uwArG.get();
                    double d11 = Math.cos(d9) * d7;
                    double d23 = OBFVAL_9Vnjm.get() + random.nextDouble() * OBFVAL_dvM3q.get();
                    double d24 = Math.sin(d9) * d7;
                    EntityFX entityfx = this.spawnEntityFX(enumparticletypes.getParticleID(), enumparticletypes.getShouldIgnoreRange(), d3 + d11 * OBFVAL_EPEKk.get(), d4 + OBFVAL_onbXx.get(), d5 + d24 * OBFVAL_EPEKk.get(), d11, d23, d24, new int[0]);

                    if (entityfx != null)
                    {
                        float f3 = OBFVAL_gbjs4.get() + random.nextFloat() * OBFVAL_jN9o2.get();
                        entityfx.setRBGColorF(f * f3, f1 * f3, f2 * f3);
                        entityfx.multiplyVelocity((float)d7);
                    }
                }

                this.theWorld.playSoundAtPos(blockPosIn, "game.potion.smash", 1.0F, this.theWorld.rand.nextFloat() * OBFVAL_6wjOg.get() + OBFVAL_x5114.get(), false);
                break;

            case 2003:
                double d6 = (double)blockPosIn.getX() + OBFVAL_dvM3q.get();
                double d8 = (double)blockPosIn.getY();
                double d10 = (double)blockPosIn.getZ() + OBFVAL_dvM3q.get();

                for (int l1 = 0; l1 < OBFVAL_NJbZB.get(); ++l1)
                {
                    this.spawnParticle(EnumParticleTypes.ITEM_CRACK, d6, d8, d10, random.nextGaussian() * OBFVAL_b6suT.get(), random.nextDouble() * OBFVAL_F149Y.get(), random.nextGaussian() * OBFVAL_b6suT.get(), new int[] {Item.getIdFromItem(Items.ender_eye)});
                }

                for (double d22 = 0.0D; d22 < OBFVAL_INAd0.get(); d22 += OBFVAL_zEVCT.get())
                {
                    this.spawnParticle(EnumParticleTypes.PORTAL, d6 + Math.cos(d22) * OBFVAL_0ffrj.get(), d8 - OBFVAL_dmDxa.get(), d10 + Math.sin(d22) * OBFVAL_0ffrj.get(), Math.cos(d22) * OBFVAL_1Rfmy.get(), 0.0D, Math.sin(d22) * OBFVAL_1Rfmy.get(), new int[0]);
                    this.spawnParticle(EnumParticleTypes.PORTAL, d6 + Math.cos(d22) * OBFVAL_0ffrj.get(), d8 - OBFVAL_dmDxa.get(), d10 + Math.sin(d22) * OBFVAL_0ffrj.get(), Math.cos(d22) * OBFVAL_hlZEE.get(), 0.0D, Math.sin(d22) * OBFVAL_hlZEE.get(), new int[0]);
                }

                return;

            case 2004:
                for (int l = 0; l < OBFVAL_8CIc8.get(); ++l)
                {
                    double d12 = (double)blockPosIn.getX() + OBFVAL_dvM3q.get() + ((double)this.theWorld.rand.nextFloat() - OBFVAL_dvM3q.get()) * OBFVAL_uwArG.get();
                    double d13 = (double)blockPosIn.getY() + OBFVAL_dvM3q.get() + ((double)this.theWorld.rand.nextFloat() - OBFVAL_dvM3q.get()) * OBFVAL_uwArG.get();
                    double d14 = (double)blockPosIn.getZ() + OBFVAL_dvM3q.get() + ((double)this.theWorld.rand.nextFloat() - OBFVAL_dvM3q.get()) * OBFVAL_uwArG.get();
                    this.theWorld.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d12, d13, d14, 0.0D, 0.0D, 0.0D, new int[0]);
                    this.theWorld.spawnParticle(EnumParticleTypes.FLAME, d12, d13, d14, 0.0D, 0.0D, 0.0D, new int[0]);
                }

                return;

            case 2005:
                ItemDye.spawnBonemealParticles(this.theWorld, blockPosIn, p_180439_4_);
        }
    }

    public void sendBlockBreakProgress(int breakerId, BlockPos pos, int progress)
    {
        if (progress >= 0 && progress < OBFVAL_rgMsi.get())
        {
            DestroyBlockProgress destroyblockprogress = (DestroyBlockProgress)this.damagedBlocks.get(Integer.valueOf(breakerId));

            if (destroyblockprogress == null || destroyblockprogress.getPosition().getX() != pos.getX() || destroyblockprogress.getPosition().getY() != pos.getY() || destroyblockprogress.getPosition().getZ() != pos.getZ())
            {
                destroyblockprogress = new DestroyBlockProgress(breakerId, pos);
                this.damagedBlocks.put(Integer.valueOf(breakerId), destroyblockprogress);
            }

            destroyblockprogress.setPartialBlockDamage(progress);
            destroyblockprogress.setCloudUpdateTick(this.cloudTickCounter);
        }
        else
        {
            this.damagedBlocks.remove(Integer.valueOf(breakerId));
        }
    }

    public void setDisplayListEntitiesDirty()
    {
        this.displayListEntitiesDirty = true;
    }

    public void resetClouds()
    {
        this.cloudRenderer.reset();
    }

    public int getCountRenderers()
    {
        return this.viewFrustum.renderChunks.length;
    }

    public int getCountActiveRenderers()
    {
        return this.renderInfos.size();
    }

    public int getCountEntitiesRendered()
    {
        return this.countEntitiesRendered;
    }

    public int getCountTileEntitiesRendered()
    {
        return this.countTileEntitiesRendered;
    }

    public RenderChunk getRenderChunk(BlockPos p_getRenderChunk_1_)
    {
        return this.viewFrustum.getRenderChunk(p_getRenderChunk_1_);
    }

    public RenderChunk getRenderChunk(RenderChunk p_getRenderChunk_1_, EnumFacing p_getRenderChunk_2_)
    {
        if (p_getRenderChunk_1_ == null)
        {
            return null;
        }
        else
        {
            BlockPos blockpos = p_getRenderChunk_1_.func_181701_a(p_getRenderChunk_2_);
            return this.viewFrustum.getRenderChunk(blockpos);
        }
    }

    public WorldClient getWorld()
    {
        return this.theWorld;
    }

    public void func_181023_a(Collection p_181023_1_, Collection p_181023_2_)
    {
        Set set = this.field_181024_n;

        synchronized (this.field_181024_n)
        {
            this.field_181024_n.removeAll(p_181023_1_);
            this.field_181024_n.addAll(p_181023_2_);
        }
    }

    static
    {
        ObfValue.beginGeneration();
        ObfValue.endGeneration(new byte[] {(byte) - 18, (byte)12, (byte) - 14, (byte) - 55, (byte)34, (byte)8, (byte) - 4, (byte) - 118});
    }

    public static class ContainerLocalRenderInformation
    {
        final RenderChunk renderChunk;
        final EnumFacing facing;
        final Set setFacing;
        final int counter;
        private static final String __OBFID = "CL_00002534";
        private static final Set EMPTY_FACING = Collections.unmodifiableSet(EnumSet.<T>noneOf(EnumFacing.class));

        public ContainerLocalRenderInformation(RenderChunk p_i9_1_, EnumFacing p_i9_2_, int p_i9_3_)
        {
            this.setFacing = EMPTY_FACING;
            this.renderChunk = p_i9_1_;
            this.facing = p_i9_2_;
            this.counter = p_i9_3_;
        }

        public ContainerLocalRenderInformation(RenderChunk p_i10_1_, EnumFacing p_i10_2_, int p_i10_3_, boolean p_i10_4_)
        {
            this.setFacing = EnumSet.noneOf(EnumFacing.class);
            this.renderChunk = p_i10_1_;
            this.facing = p_i10_2_;
            this.counter = p_i10_3_;
        }

        ContainerLocalRenderInformation(RenderChunk p_i11_1_, EnumFacing p_i11_2_, int p_i11_3_, Object p_i11_4_)
        {
            this(p_i11_1_, p_i11_2_, p_i11_3_);
        }
    }

    static final class RenderGlobal$RenderGlobal$2
    {
        static final int[] field_178037_a = new int[VertexFormatElement.EnumUsage.values().length];
        private static final String __OBFID = "CL_00002535";

        static
        {
            try
            {
                field_178037_a[VertexFormatElement.EnumUsage.POSITION.ordinal()] = 1;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                field_178037_a[VertexFormatElement.EnumUsage.UV.ordinal()] = 2;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                field_178037_a[VertexFormatElement.EnumUsage.COLOR.ordinal()] = 3;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
}
