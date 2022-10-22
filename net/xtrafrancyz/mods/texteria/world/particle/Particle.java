package net.xtrafrancyz.mods.texteria.world.particle;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.elements.Image;

public class Particle
{
    private static int hashCounter;
    private final int hash;
    private static final Random RANDOM = new Random();
    private static final BlockPos.MutableBlockPos BLOCK_POS = new BlockPos.MutableBlockPos();
    public float motX;
    public float motY;
    public float motZ;
    public float posX;
    public float posY;
    public float posZ;
    public float prevPosX;
    public float prevPosY;
    public float prevPosZ;
    public float gravity;
    public float invertedAirFriction;
    public Image.AnimationContext animationContext;
    public Image.ImageInfo image;
    public float scale;
    public int color;
    public long deadline;
    public long start;
    public int renderDistanceSquared;
    public boolean dynamicLight;
    public boolean mirrorU;
    public boolean mirrorV;
    public int blockLight;
    public int skyLight;
    public int distanceSquaredToPlayer;

    public Particle(ParticleConfig config)
    {
        this.hash = hashCounter++;
        this.posX = this.prevPosX = this.rand(config.posX, config.spreadPosX);
        this.posY = this.prevPosY = this.rand(config.posY, config.spreadPosY);
        this.posZ = this.prevPosZ = this.rand(config.posZ, config.spreadPosZ);
        this.motX = this.rand(config.motX, config.spreadMotX);
        this.motY = this.rand(config.motY, config.spreadMotY);
        this.motZ = this.rand(config.motZ, config.spreadMotZ);
        this.scale = this.rand(config.scale, config.spreadScale) * 0.1F;
        this.invertedAirFriction = 1.0F - this.rand(config.airFriction, config.spreadAirFriction);
        this.gravity = this.rand(config.gravity, config.spreadGravity);
        this.start = Texteria.time + (long)this.rand(config.delay, config.spreadDelay);
        this.deadline = this.start + (long)this.rand(config.duration, config.spreadDuration);
        this.skyLight = this.blockLight = config.light << 4;
        this.dynamicLight = config.dynamicLight;
        this.color = config.color;
        this.renderDistanceSquared = config.renderDistance * config.renderDistance;
        this.mirrorU = config.randomMirrorHorizontal && RANDOM.nextBoolean();
        this.mirrorV = config.randomMirrorVertical && RANDOM.nextBoolean();
        Image.LoadingRequest image$loadingrequest = new Image.LoadingRequest(config.image);
        image$loadingrequest.data = config.imageData;
        this.image = Image.createImage(image$loadingrequest);
        this.animationContext = new Image.AnimationContext(this.start);
        this.animationContext.speedModifier = (double)this.rand(config.gifSpeed, config.spreadGifSpeed);

        if (this.dynamicLight)
        {
            this.readLight(Minecraft.getMinecraft().theWorld);
        }
    }

    private float rand(float initial, float spread)
    {
        return spread == 0.0F ? initial : initial - spread * 0.5F + RANDOM.nextFloat() * spread;
    }

    private int rand(int initial, int spread)
    {
        return spread == 0 ? initial : initial - spread / 2 + (int)(RANDOM.nextFloat() * (float)spread);
    }

    private void readLight(World world)
    {
        int i = world.getCombinedLight(BLOCK_POS.func_181079_c((int)this.posX, (int)this.posY, (int)this.posZ), 0);
        this.skyLight = i >> 16 & 65535;
        this.blockLight = i & 65535;
    }

    public void tick(long time, World world)
    {
        if (time >= this.start)
        {
            if (this.dynamicLight)
            {
                this.readLight(world);
            }

            this.motY -= this.gravity;

            if (this.invertedAirFriction != 0.0F)
            {
                this.motX *= this.invertedAirFriction;
                this.motY *= this.invertedAirFriction;
                this.motZ *= this.invertedAirFriction;
            }

            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            this.posX += this.motX;
            this.posY += this.motY;
            this.posZ += this.motZ;
        }
    }

    public void render(ParticleRenderHelper renderHelper, long time, float partialTicks, float camx, float camy, float camz)
    {
        if (time >= this.start && this.image.loadingState == Image.LoadState.READY)
        {
            int i = this.color;
            int j = i >> 24 & 255;
            int k = i >> 16 & 255;
            int l = i >> 8 & 255;
            int i1 = i & 255;
            float f = this.prevPosX + (this.posX - this.prevPosX) * partialTicks - camx;
            float f1 = this.prevPosY + (this.posY - this.prevPosY) * partialTicks - camy;
            float f2 = this.prevPosZ + (this.posZ - this.prevPosZ) * partialTicks - camz;
            float f3 = ActiveRenderInfo.getRotationX();
            float f4 = ActiveRenderInfo.getRotationXZ();
            float f5 = ActiveRenderInfo.getRotationZ();
            float f6 = ActiveRenderInfo.getRotationYZ();
            float f7 = ActiveRenderInfo.getRotationXY();
            float f8 = 0.0F;
            float f9 = 0.0F;
            int j1;
            float f10;
            float f11;

            if (this.image instanceof Image.TexturedImageInfo)
            {
                Image.TexturedImageInfo image$texturedimageinfo = (Image.TexturedImageInfo)this.image;
                image$texturedimageinfo.tex.upload(this.image, Image.TextureRenderHint.CLAMP);
                float f12;
                float f13;

                if (image$texturedimageinfo.tex instanceof Image.AnimatedTexture)
                {
                    Image.AnimatedFrame image$animatedframe = ((Image.AnimatedTexture)image$texturedimageinfo.tex).getCurrentFrame(this.animationContext, time);
                    j1 = image$animatedframe.sprite.atlas.glid;
                    f12 = 1.0F / (float)image$animatedframe.sprite.atlas.width;
                    f13 = 1.0F / (float)image$animatedframe.sprite.atlas.height;
                    f8 = (float)image$animatedframe.sprite.x * f12;
                    f9 = (float)image$animatedframe.sprite.y * f13;
                }
                else
                {
                    Image.MultipartTexture image$multiparttexture = (Image.MultipartTexture)image$texturedimageinfo.tex;

                    if (image$multiparttexture.sprite != null)
                    {
                        j1 = image$multiparttexture.sprite.atlas.glid;
                        f12 = 1.0F / (float)image$multiparttexture.sprite.atlas.width;
                        f13 = 1.0F / (float)image$multiparttexture.sprite.atlas.height;
                        f8 = (float)image$multiparttexture.sprite.x * f12;
                        f9 = (float)image$multiparttexture.sprite.y * f13;
                    }
                    else
                    {
                        Image.TexturePart image$texturepart = (Image.TexturePart)image$multiparttexture.parts.get(0);
                        j1 = image$texturepart.glTextureId;
                        f12 = 1.0F / (float)image$texturepart.width;
                        f13 = 1.0F / (float)image$texturepart.height;
                    }
                }

                f10 = f8 + (float)this.image.getWidth() * f12;
                f11 = f9 + (float)this.image.getHeight() * f13;
            }
            else
            {
                if (!(this.image instanceof Image.BlocksTextureImageInfo))
                {
                    return;
                }

                Image.BlocksTextureImageInfo image$blockstextureimageinfo = (Image.BlocksTextureImageInfo)this.image;
                TextureMap texturemap = image$blockstextureimageinfo.getBlocksMap();
                TextureAtlasSprite textureatlassprite = image$blockstextureimageinfo.getSprite(texturemap);
                j1 = texturemap.getGlTextureId();
                f8 = textureatlassprite.getMinU();
                f9 = textureatlassprite.getMinV();
                f10 = textureatlassprite.getMaxU();
                f11 = textureatlassprite.getMaxV();
            }

            float f14 = this.scale;

            if (this.mirrorU)
            {
                float f15 = f10;
                f10 = f8;
                f8 = f15;
            }

            if (this.mirrorV)
            {
                float f16 = f11;
                f11 = f9;
                f9 = f16;
            }

            renderHelper.bindTexture(j1);
            renderHelper.pos((double)(f - (f3 + f6) * f14), (double)(f1 - f4 * f14), (double)(f2 - (f5 + f7) * f14)).tex((double)f10, (double)f11).color(k, l, i1, j).lightmap(this.skyLight, this.blockLight).endVertex();
            renderHelper.pos((double)(f - (f3 - f6) * f14), (double)(f1 + f4 * f14), (double)(f2 - (f5 - f7) * f14)).tex((double)f10, (double)f9).color(k, l, i1, j).lightmap(this.skyLight, this.blockLight).endVertex();
            renderHelper.pos((double)(f + (f3 + f6) * f14), (double)(f1 + f4 * f14), (double)(f2 + (f5 + f7) * f14)).tex((double)f8, (double)f9).color(k, l, i1, j).lightmap(this.skyLight, this.blockLight).endVertex();
            renderHelper.pos((double)(f + (f3 - f6) * f14), (double)(f1 - f4 * f14), (double)(f2 + (f5 - f7) * f14)).tex((double)f8, (double)f11).color(k, l, i1, j).lightmap(this.skyLight, this.blockLight).endVertex();
        }
    }

    public boolean isInViewRange()
    {
        return this.distanceSquaredToPlayer < this.renderDistanceSquared;
    }

    public void calcDistanceSquaredToPlayer(float x, float y, float z)
    {
        this.distanceSquaredToPlayer = (int)(square(x - this.posX) + square(y - this.posY) + square(z - this.posZ));
    }

    protected static float square(float num)
    {
        return num * num;
    }

    public int hashCode()
    {
        return this.hash;
    }

    public boolean equals(Object obj)
    {
        return obj == this;
    }
}
