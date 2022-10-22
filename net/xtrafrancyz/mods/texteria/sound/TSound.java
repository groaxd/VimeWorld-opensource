package net.xtrafrancyz.mods.texteria.sound;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.texteria.util.Vec3d;
import net.xtrafrancyz.util.ByteMap;

public class TSound implements ISound
{
    public String path;
    public String id;
    public boolean streaming;
    public SoundCategory category;
    public float pitch;
    public float volume;
    public Vec3d pos;
    public ISound.AttenuationType attenuationType;
    public boolean repeat;
    public int repeatDelay;
    public float distance;

    public TSound(ByteMap data)
    {
        this.path = data.getString("path");
        this.id = data.getString("id");
        this.streaming = data.getBoolean("stream", false);
        this.category = SoundCategory.getCategory(data.getString("category", "ambient"));
        this.pitch = data.getFloat("pitch", 1.0F);
        this.volume = data.getFloat("volume", 1.0F);
        this.repeat = data.getBoolean("repeat", false);
        this.repeatDelay = data.getInt("repDel", 0);
        this.distance = data.getFloat("dist", 0.0F);

        if (data.containsKey("pos.x"))
        {
            this.pos = new Vec3d((double)data.getFloat("pos.x"), (double)data.getFloat("pos.y"), (double)data.getFloat("pos.z"));
            this.attenuationType = ISound.AttenuationType.LINEAR;
        }
        else
        {
            this.pos = new Vec3d();
            this.attenuationType = ISound.AttenuationType.NONE;
        }
    }

    public ResourceLocation getSoundLocation()
    {
        return new ResourceLocation("texteria-sound", this.path);
    }

    public boolean canRepeat()
    {
        return this.repeat;
    }

    public int getRepeatDelay()
    {
        return this.repeatDelay;
    }

    public float getVolume()
    {
        return this.volume;
    }

    public float getPitch()
    {
        return this.pitch;
    }

    public float getXPosF()
    {
        return (float)this.pos.x;
    }

    public float getYPosF()
    {
        return (float)this.pos.y;
    }

    public float getZPosF()
    {
        return (float)this.pos.z;
    }

    public ISound.AttenuationType getAttenuationType()
    {
        return this.attenuationType;
    }

    public float getDistance()
    {
        return this.distance;
    }
}
