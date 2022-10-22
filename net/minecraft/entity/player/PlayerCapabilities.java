package net.minecraft.entity.player;

import net.minecraft.nbt.NBTTagCompound;
import net.xtrafrancyz.covered.ObfValue;

public class PlayerCapabilities
{
    private static final ObfValue.OFloat OBFVAL_TdXq2 = ObfValue.create(0.05F);
    private static final ObfValue.OInteger OBFVAL_mC4b9 = ObfValue.create(99);
    private static final ObfValue.OInteger OBFVAL_895zG = ObfValue.create(10);
    private static final ObfValue.OFloat OBFVAL_4Fge6 = ObfValue.create(0.1F);

    /** Disables player damage. */
    public boolean disableDamage;

    /** Sets/indicates whether the player is flying. */
    public boolean isFlying;

    /** whether or not to allow the player to fly when they double jump. */
    public boolean allowFlying;

    /**
     * Used to determine if creative mode is enabled, and therefore if items should be depleted on usage
     */
    public boolean isCreativeMode;

    /** Indicates whether the player is allowed to modify the surroundings */
    public boolean allowEdit = true;
    private ObfValue.WalkingFloat flySpeed;
    private ObfValue.WalkingFloat walkSpeed;

    public PlayerCapabilities()
    {
        this.flySpeed = new ObfValue.WalkingFloat(OBFVAL_TdXq2.get(), 1);
        this.walkSpeed = new ObfValue.WalkingFloat(OBFVAL_4Fge6.get(), 1);
    }

    public void writeCapabilitiesToNBT(NBTTagCompound tagCompound)
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.setBoolean("invulnerable", this.disableDamage);
        nbttagcompound.setBoolean("flying", this.isFlying);
        nbttagcompound.setBoolean("mayfly", this.allowFlying);
        nbttagcompound.setBoolean("instabuild", this.isCreativeMode);
        nbttagcompound.setBoolean("mayBuild", this.allowEdit);
        nbttagcompound.setFloat("flySpeed", this.flySpeed.get());
        nbttagcompound.setFloat("walkSpeed", this.walkSpeed.get());
        tagCompound.setTag("abilities", nbttagcompound);
    }

    public void readCapabilitiesFromNBT(NBTTagCompound tagCompound)
    {
        if (tagCompound.hasKey("abilities", OBFVAL_895zG.get()))
        {
            NBTTagCompound nbttagcompound = tagCompound.getCompoundTag("abilities");
            this.disableDamage = nbttagcompound.getBoolean("invulnerable");
            this.isFlying = nbttagcompound.getBoolean("flying");
            this.allowFlying = nbttagcompound.getBoolean("mayfly");
            this.isCreativeMode = nbttagcompound.getBoolean("instabuild");

            if (nbttagcompound.hasKey("flySpeed", OBFVAL_mC4b9.get()))
            {
                this.flySpeed.set(nbttagcompound.getFloat("flySpeed"));
                this.walkSpeed.set(nbttagcompound.getFloat("walkSpeed"));
            }

            if (nbttagcompound.hasKey("mayBuild", 1))
            {
                this.allowEdit = nbttagcompound.getBoolean("mayBuild");
            }
        }
    }

    public float getFlySpeed()
    {
        return this.flySpeed.get();
    }

    public void setFlySpeed(float speed)
    {
        this.flySpeed.set(speed);
    }

    public float getWalkSpeed()
    {
        return this.walkSpeed.get();
    }

    public void setPlayerWalkSpeed(float speed)
    {
        this.walkSpeed.set(speed);
    }

    static
    {
        ObfValue.beginGeneration();
        ObfValue.endGeneration(new byte[] {(byte)0, (byte)0, (byte)28, (byte)23, (byte) - 7, (byte)25, (byte) - 30, (byte)103});
    }
}
