package net.minecraft.client.entity;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.xtrafrancyz.covered.ObfValue;
import net.xtrafrancyz.mods.texteria.TexteriaOptions;

public class EntityOtherPlayerMP extends AbstractClientPlayer
{
    private static final ObfValue.OFloat OBFVAL_FxjYD = ObfValue.create(4.0F);
    private static final ObfValue.ODouble OBFVAL_UpCvN = ObfValue.create(0.20000000298023224D);
    private static final ObfValue.ODouble OBFVAL_MabGi = ObfValue.create(0.05D);
    private static final ObfValue.ODouble OBFVAL_LYZPr = ObfValue.create(360.0D);
    private static final ObfValue.OFloat OBFVAL_dgWeL = ObfValue.create(0.8F);
    private static final ObfValue.ODouble OBFVAL_VPyd8 = ObfValue.create(180.0D);
    private static final ObfValue.OFloat OBFVAL_IJHLF = ObfValue.create(0.4F);
    private static final ObfValue.OInteger OBFVAL_J2ud1 = ObfValue.create(2);
    private static final ObfValue.OFloat OBFVAL_Nh86K = ObfValue.create(0.25F);
    private static final ObfValue.ODouble OBFVAL_tq2xp = ObfValue.create(10.0D);
    private static final ObfValue.OFloat OBFVAL_GC2wa = ObfValue.create(15.0F);
    private static final ObfValue.ODouble OBFVAL_HFYnW = ObfValue.create(-180.0D);
    private static final ObfValue.ODouble OBFVAL_E3a0T = ObfValue.create(0.5D);
    private static final ObfValue.OFloat OBFVAL_VHq9i = ObfValue.create(0.1F);
    private boolean isItemInUse;
    private int otherPlayerMPPosRotationIncrements;
    private double otherPlayerMPX;
    private double otherPlayerMPY;
    private double otherPlayerMPZ;
    private double otherPlayerMPYaw;
    private double otherPlayerMPPitch;

    public EntityOtherPlayerMP(World worldIn, GameProfile gameProfileIn)
    {
        super(worldIn, gameProfileIn);
        this.stepHeight = 0.0F;
        this.noClip = true;
        this.renderOffsetY = OBFVAL_Nh86K.get();
        this.renderDistanceWeight = OBFVAL_tq2xp.get();
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        return true;
    }

    public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_)
    {
        this.otherPlayerMPX = x;
        this.otherPlayerMPY = y;
        this.otherPlayerMPZ = z;
        this.otherPlayerMPYaw = (double)yaw;
        this.otherPlayerMPPitch = (double)pitch;
        this.otherPlayerMPPosRotationIncrements = posRotationIncrements;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.renderOffsetY = 0.0F;
        super.onUpdate();
        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d0 = this.posX - this.prevPosX;
        double d1 = this.posZ - this.prevPosZ;
        float f = MathHelper.sqrt_double(d0 * d0 + d1 * d1) * OBFVAL_FxjYD.get();

        if (f > 1.0F)
        {
            f = 1.0F;
        }

        this.limbSwingAmount += (f - this.limbSwingAmount) * OBFVAL_IJHLF.get();
        this.limbSwing += this.limbSwingAmount;

        if (!this.isItemInUse && this.isEating() && this.inventory.mainInventory[this.inventory.currentItem] != null)
        {
            ItemStack itemstack = this.inventory.mainInventory[this.inventory.currentItem];
            this.setItemInUse(this.inventory.mainInventory[this.inventory.currentItem], itemstack.getItem().getMaxItemUseDuration(itemstack));
            this.isItemInUse = true;
        }
        else if (this.isItemInUse && !this.isEating())
        {
            this.clearItemInUse();
            this.isItemInUse = false;
        }
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (this.otherPlayerMPPosRotationIncrements > 0)
        {
            double d0 = this.posX + (this.otherPlayerMPX - this.posX) / (double)this.otherPlayerMPPosRotationIncrements;
            double d1 = this.posY + (this.otherPlayerMPY - this.posY) / (double)this.otherPlayerMPPosRotationIncrements;
            double d2 = this.posZ + (this.otherPlayerMPZ - this.posZ) / (double)this.otherPlayerMPPosRotationIncrements;
            double d3;

            for (d3 = this.otherPlayerMPYaw - (double)this.rotationYaw; d3 < OBFVAL_HFYnW.get(); d3 += OBFVAL_LYZPr.get())
            {
                ;
            }

            while (d3 >= OBFVAL_VPyd8.get())
            {
                d3 -= OBFVAL_LYZPr.get();
            }

            this.rotationYaw = (float)((double)this.rotationYaw + d3 / (double)this.otherPlayerMPPosRotationIncrements);
            this.rotationPitch = (float)((double)this.rotationPitch + (this.otherPlayerMPPitch - (double)this.rotationPitch) / (double)this.otherPlayerMPPosRotationIncrements);
            --this.otherPlayerMPPosRotationIncrements;
            this.setPosition(d0, d1, d2);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }

        this.prevCameraYaw = this.cameraYaw;
        this.updateArmSwingProgress();
        float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        float f = (float)Math.atan(-this.motionY * OBFVAL_UpCvN.get()) * OBFVAL_GC2wa.get();

        if (f1 > OBFVAL_VHq9i.get())
        {
            f1 = OBFVAL_VHq9i.get();
        }

        if (!this.onGround || this.getHealth() <= 0.0F)
        {
            f1 = 0.0F;
        }

        if (this.onGround || this.getHealth() <= 0.0F)
        {
            f = 0.0F;
        }

        this.cameraYaw += (f1 - this.cameraYaw) * OBFVAL_IJHLF.get();
        this.cameraPitch += (f - this.cameraPitch) * OBFVAL_dgWeL.get();
    }

    /**
     * Sets the held item, or an armor slot. Slot 0 is held item. Slot 1-4 is armor. Params: Item, slot
     */
    public void setCurrentItemOrArmor(int slotIn, ItemStack stack)
    {
        if (slotIn == 0)
        {
            this.inventory.mainInventory[this.inventory.currentItem] = stack;
        }
        else
        {
            this.inventory.armorInventory[slotIn - 1] = stack;
        }
    }

    /**
     * Send a chat message to the CommandSender
     */
    public void addChatMessage(IChatComponent component)
    {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(component);
    }

    /**
     * Returns {@code true} if the CommandSender is allowed to execute the command, {@code false} if not
     */
    public boolean canCommandSenderUseCommand(int permLevel, String commandName)
    {
        return false;
    }

    /**
     * Get the position in the world. <b>{@code null} is not allowed!</b> If you are not an entity in the world, return
     * the coordinates 0, 0, 0
     */
    public BlockPos getPosition()
    {
        return new BlockPos(this.posX + OBFVAL_E3a0T.get(), this.posY + OBFVAL_E3a0T.get(), this.posZ + OBFVAL_E3a0T.get());
    }

    /**
     * Returns the collision bounding box for this entity
     */
    public AxisAlignedBB getCollisionBoundingBox()
    {
        if (TexteriaOptions.playerCollisionBoxes == OBFVAL_J2ud1.get() && !this.isPlayerSleeping())
        {
            AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
            return new AxisAlignedBB(axisalignedbb.minX - OBFVAL_MabGi.get(), axisalignedbb.minY, axisalignedbb.minZ - OBFVAL_MabGi.get(), axisalignedbb.maxX + OBFVAL_MabGi.get(), axisalignedbb.minY + 1.0D, axisalignedbb.maxZ + OBFVAL_MabGi.get());
        }
        else
        {
            return super.getCollisionBoundingBox();
        }
    }

    static
    {
        ObfValue.beginGeneration();
        ObfValue.endGeneration(new byte[] {(byte) - 64, (byte) - 28, (byte)15, (byte)40, (byte)81, (byte) - 34, (byte) - 124, (byte)53});
    }
}
