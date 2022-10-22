package net.xtrafrancyz.mods.texteria.world.particle;

import net.minecraft.util.MathHelper;
import net.xtrafrancyz.util.ByteMap;

public class ParticleConfig
{
    public float posX;
    public float posY;
    public float posZ;
    public float spreadPosX;
    public float spreadPosY;
    public float spreadPosZ;
    public float motX;
    public float motY;
    public float motZ;
    public float spreadMotX;
    public float spreadMotY;
    public float spreadMotZ;
    public float scale = 1.0F;
    public float spreadScale;
    public float gravity = 0.0F;
    public float spreadGravity;
    public float airFriction = 0.02F;
    public float spreadAirFriction;
    public int duration = 3000;
    public int spreadDuration;
    public int delay;
    public int spreadDelay;
    public int color = -1;
    public int renderDistance = 64;
    public int light = 15;
    public boolean dynamicLight = false;
    public boolean randomMirrorHorizontal = false;
    public boolean randomMirrorVertical = false;
    public String image;
    public byte[] imageData;
    public float gifSpeed;
    public float spreadGifSpeed;

    public ParticleConfig()
    {
    }

    public ParticleConfig(ByteMap params)
    {
        this.posX = params.getFloat("x");
        this.posY = params.getFloat("y");
        this.posZ = params.getFloat("z");
        this.spreadPosX = params.getFloat("sx", 0.0F);
        this.spreadPosY = params.getFloat("sy", 0.0F);
        this.spreadPosZ = params.getFloat("sz", 0.0F);
        this.motX = params.getFloat("mx", 0.0F);
        this.motY = params.getFloat("my", 0.0F);
        this.motZ = params.getFloat("mz", 0.0F);
        this.spreadMotX = params.getFloat("smx", 0.0F);
        this.spreadMotY = params.getFloat("smy", 0.0F);
        this.spreadMotZ = params.getFloat("smz", 0.0F);
        this.scale = params.getFloat("sc", this.scale);
        this.spreadScale = params.getFloat("ssc", 0.0F);
        this.airFriction = params.getFloat("af", this.airFriction);
        this.spreadAirFriction = params.getFloat("saf", 0.0F);
        this.gravity = params.getFloat("gr", this.gravity);
        this.spreadGravity = params.getFloat("sgr", 0.0F);
        this.duration = params.getInt("dur", this.duration);
        this.spreadDuration = params.getInt("sdur", 0);
        this.delay = params.getInt("del", 0);
        this.spreadDelay = params.getInt("sdel", 0);
        this.light = MathHelper.clamp_int(params.getInt("l", this.light), 0, 15);
        this.dynamicLight = params.getBoolean("dl", false);
        this.color = params.getInt("c", this.color);
        this.renderDistance = params.getInt("rndrd", this.renderDistance);
        int i = params.getInt("rm", 0);
        this.randomMirrorHorizontal = (i & 1) == 1;
        this.randomMirrorVertical = (i & 2) == 2;
        this.image = params.getString("img");
        this.imageData = params.getByteArray("imgd");
        this.gifSpeed = params.getFloat("gs", 1.0F);
        this.spreadGifSpeed = params.getFloat("sgs", 0.0F);
    }
}
