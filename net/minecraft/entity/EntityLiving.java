package net.minecraft.entity;

import java.util.UUID;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityJumpHelper;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.server.S1BPacketEntityAttach;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.xtrafrancyz.covered.ObfValue;
import optifine.BlockPosM;
import optifine.Config;

public abstract class EntityLiving extends EntityLivingBase
{
    private static final ObfValue.OFloat OBFVAL_bq6j5 = ObfValue.create(2.0F);
    private static final ObfValue.OInteger OBFVAL_1lc8v = ObfValue.create(15);
    private static final ObfValue.OFloat OBFVAL_KSpPM = ObfValue.create(0.1F);
    private static final ObfValue.OInteger OBFVAL_UJUP3 = ObfValue.create(8);
    private static final ObfValue.ODouble OBFVAL_Knxmr = ObfValue.create(1024.0D);
    private static final ObfValue.ODouble OBFVAL_sPw4t = ObfValue.create(0.05D);
    private static final ObfValue.ODouble OBFVAL_wK3sV = ObfValue.create(16.0D);
    private static final ObfValue.OInteger OBFVAL_q9L8h = ObfValue.create(20);
    private static final ObfValue.OInteger OBFVAL_vUPKH = ObfValue.create(40);
    private static final ObfValue.ODouble OBFVAL_u3Dox = ObfValue.create(16384.0D);
    private static final ObfValue.OFloat OBFVAL_HXqtc = ObfValue.create(0.095F);
    private static final ObfValue.ODouble OBFVAL_2HY2j = ObfValue.create(-1.0D);
    private static final ObfValue.OFloat OBFVAL_MYWow = ObfValue.create(0.01F);
    private static final ObfValue.ODouble OBFVAL_MxiKB = ObfValue.create(Math.PI);
    private static final ObfValue.OFloat OBFVAL_T8jAb = ObfValue.create(90.0F);
    private static final ObfValue.OInteger OBFVAL_IsYiY = ObfValue.create(5);
    private static final ObfValue.OInteger OBFVAL_F6CG4 = ObfValue.create(1000);
    private static final ObfValue.OLong OBFVAL_iZ2Pg = ObfValue.create(2147483647L);
    private static final ObfValue.OFloat OBFVAL_9Dsog = ObfValue.create(5.0F);
    private static final ObfValue.OInteger OBFVAL_RVLI4 = ObfValue.create(80);
    private static final ObfValue.ODouble OBFVAL_YpKOM = ObfValue.create(180.0D);
    private static final ObfValue.OInteger OBFVAL_Pu6Mc = ObfValue.create(25);
    private static final ObfValue.OFloat OBFVAL_Hw6vk = ObfValue.create(0.33F);
    private static final ObfValue.OFloat OBFVAL_bQp8M = ObfValue.create(0.085F);
    private static final ObfValue.OInteger OBFVAL_tHnJs = ObfValue.create(100);
    private static final ObfValue.OInteger OBFVAL_q4aUT = ObfValue.create(4);
    private static final ObfValue.OInteger OBFVAL_JCvDM = ObfValue.create(2);
    private static final ObfValue.OInteger OBFVAL_qTNjD = ObfValue.create(9);
    private static final ObfValue.OInteger OBFVAL_dzQEy = ObfValue.create(600);
    private static final ObfValue.OFloat OBFVAL_uyYNu = ObfValue.create(0.25F);
    private static final ObfValue.OFloat OBFVAL_FKdiv = ObfValue.create(0.5F);
    private static final ObfValue.ODouble OBFVAL_FvL03 = ObfValue.create(0.02D);
    private static final ObfValue.ODouble OBFVAL_t3lAb = ObfValue.create(2.0D);
    private static final ObfValue.OFloat OBFVAL_B4xwu = ObfValue.create(0.15F);
    private static final ObfValue.OInteger OBFVAL_L6P2W = ObfValue.create(18);
    private static final ObfValue.OFloat OBFVAL_zInuQ = ObfValue.create(0.8F);
    private static final ObfValue.ODouble OBFVAL_7kjA4 = ObfValue.create(10.0D);
    private static final ObfValue.OInteger OBFVAL_SZIJq = ObfValue.create(99);
    private static final ObfValue.OInteger OBFVAL_12PoI = ObfValue.create(3);
    private static final ObfValue.OInteger OBFVAL_W71Y6 = ObfValue.create(800);
    private static final ObfValue.OInteger OBFVAL_EGX2W = ObfValue.create(10);

    /** Number of ticks since this EntityLiving last produced its sound */
    public int livingSoundTime;

    /** The experience points the Entity gives. */
    protected int experienceValue;
    private EntityLookHelper lookHelper;
    protected EntityMoveHelper moveHelper;

    /** Entity jumping helper */
    protected EntityJumpHelper jumpHelper;
    private EntityBodyHelper bodyHelper;
    protected PathNavigate navigator;

    /** Passive tasks (wandering, look, idle, ...) */
    protected final EntityAITasks tasks;

    /** Fighting tasks (used by monsters, wolves, ocelots) */
    protected final EntityAITasks targetTasks;

    /** The active target the Task system uses for tracking */
    private EntityLivingBase attackTarget;
    private EntitySenses senses;

    /** Equipment (armor and held item) for this entity. */
    private ItemStack[] equipment;

    /** Chances for each equipment piece from dropping when this entity dies. */
    protected float[] equipmentDropChances;

    /** Whether this entity can pick up items from the ground. */
    private boolean canPickUpLoot;

    /** Whether this entity should NOT despawn. */
    private boolean persistenceRequired;
    private boolean isLeashed;
    private Entity leashedToEntity;
    private NBTTagCompound leashNBTTag;
    private static final String __OBFID = "CL_00001550";
    public int randomMobsId;
    public BiomeGenBase spawnBiome;
    public BlockPos spawnPosition;

    public EntityLiving(World worldIn)
    {
        super(worldIn);
        this.equipment = new ItemStack[OBFVAL_IsYiY.get()];
        this.equipmentDropChances = new float[OBFVAL_IsYiY.get()];
        this.randomMobsId = 0;
        this.spawnBiome = null;
        this.spawnPosition = null;
        this.tasks = new EntityAITasks(worldIn != null && worldIn.theProfiler != null ? worldIn.theProfiler : null);
        this.targetTasks = new EntityAITasks(worldIn != null && worldIn.theProfiler != null ? worldIn.theProfiler : null);
        this.lookHelper = new EntityLookHelper(this);
        this.moveHelper = new EntityMoveHelper(this);
        this.jumpHelper = new EntityJumpHelper(this);
        this.bodyHelper = new EntityBodyHelper(this);
        this.navigator = this.getNewNavigator(worldIn);
        this.senses = new EntitySenses(this);

        for (int i = 0; i < this.equipmentDropChances.length; ++i)
        {
            this.equipmentDropChances[i] = OBFVAL_bQp8M.get();
        }

        UUID uuid = this.getUniqueID();
        long j = uuid.getLeastSignificantBits();
        this.randomMobsId = (int)(j & OBFVAL_iZ2Pg.get());
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.followRange).setBaseValue(OBFVAL_wK3sV.get());
    }

    /**
     * Returns new PathNavigateGround instance
     */
    protected PathNavigate getNewNavigator(World worldIn)
    {
        return new PathNavigateGround(this, worldIn);
    }

    public EntityLookHelper getLookHelper()
    {
        return this.lookHelper;
    }

    public EntityMoveHelper getMoveHelper()
    {
        return this.moveHelper;
    }

    public EntityJumpHelper getJumpHelper()
    {
        return this.jumpHelper;
    }

    public PathNavigate getNavigator()
    {
        return this.navigator;
    }

    /**
     * returns the EntitySenses Object for the EntityLiving
     */
    public EntitySenses getEntitySenses()
    {
        return this.senses;
    }

    /**
     * Gets the active target the Task system uses for tracking
     */
    public EntityLivingBase getAttackTarget()
    {
        return this.attackTarget;
    }

    /**
     * Sets the active target the Task system uses for tracking
     */
    public void setAttackTarget(EntityLivingBase entitylivingbaseIn)
    {
        this.attackTarget = entitylivingbaseIn;
    }

    /**
     * Returns true if this entity can attack entities of the specified class.
     */
    public boolean canAttackClass(Class cls)
    {
        return cls != EntityGhast.class;
    }

    /**
     * This function applies the benefits of growing back wool and faster growing up to the acting entity. (This
     * function is used in the AIEatGrass)
     */
    public void eatGrassBonus()
    {
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(OBFVAL_1lc8v.get(), Byte.valueOf((byte)0));
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    public int getTalkInterval()
    {
        return OBFVAL_RVLI4.get();
    }

    /**
     * Plays living's sound at its position
     */
    public void playLivingSound()
    {
        String s = this.getLivingSound();

        if (s != null)
        {
            this.playSound(s, this.getSoundVolume(), this.getSoundPitch());
        }
    }

    /**
     * Gets called every tick from main Entity class
     */
    public void onEntityUpdate()
    {
        super.onEntityUpdate();
        this.worldObj.theProfiler.startSection("mobBaseTick");

        if (this.isEntityAlive() && this.rand.nextInt(OBFVAL_F6CG4.get()) < this.livingSoundTime++)
        {
            this.livingSoundTime = -this.getTalkInterval();
            this.playLivingSound();
        }

        this.worldObj.theProfiler.endSection();
    }

    /**
     * Get the experience points the entity currently has.
     */
    protected int getExperiencePoints(EntityPlayer player)
    {
        if (this.experienceValue > 0)
        {
            int i = this.experienceValue;
            ItemStack[] aitemstack = this.getInventory();

            for (int j = 0; j < aitemstack.length; ++j)
            {
                if (aitemstack[j] != null && this.equipmentDropChances[j] <= 1.0F)
                {
                    i += 1 + this.rand.nextInt(OBFVAL_12PoI.get());
                }
            }

            return i;
        }
        else
        {
            return this.experienceValue;
        }
    }

    /**
     * Spawns an explosion particle around the Entity's location
     */
    public void spawnExplosionParticle()
    {
        if (this.worldObj.isRemote)
        {
            for (int i = 0; i < OBFVAL_q9L8h.get(); ++i)
            {
                double d0 = this.rand.nextGaussian() * OBFVAL_FvL03.get();
                double d1 = this.rand.nextGaussian() * OBFVAL_FvL03.get();
                double d2 = this.rand.nextGaussian() * OBFVAL_FvL03.get();
                double d3 = OBFVAL_7kjA4.get();
                this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX + (double)(this.rand.nextFloat() * this.width * OBFVAL_bq6j5.get()) - (double)this.width - d0 * d3, this.posY + (double)(this.rand.nextFloat() * this.height) - d1 * d3, this.posZ + (double)(this.rand.nextFloat() * this.width * OBFVAL_bq6j5.get()) - (double)this.width - d2 * d3, d0, d1, d2, new int[0]);
            }
        }
        else
        {
            this.worldObj.setEntityState(this, (byte)OBFVAL_q9L8h.get());
        }
    }

    public void handleStatusUpdate(byte id)
    {
        if (id == OBFVAL_q9L8h.get())
        {
            this.spawnExplosionParticle();
        }
        else
        {
            super.handleStatusUpdate(id);
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        if (Config.isSmoothWorld() && this.canSkipUpdate())
        {
            this.onUpdateMinimal();
        }
        else
        {
            super.onUpdate();

            if (!this.worldObj.isRemote)
            {
                this.updateLeashedState();
            }
        }
    }

    protected float func_110146_f(float p_110146_1_, float p_110146_2_)
    {
        this.bodyHelper.updateRenderAngles();
        return p_110146_2_;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return null;
    }

    protected Item getDropItem()
    {
        return null;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        Item item = this.getDropItem();

        if (item != null)
        {
            int i = this.rand.nextInt(OBFVAL_12PoI.get());

            if (p_70628_2_ > 0)
            {
                i += this.rand.nextInt(p_70628_2_ + 1);
            }

            for (int j = 0; j < i; ++j)
            {
                this.dropItem(item, 1);
            }
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setBoolean("CanPickUpLoot", this.canPickUpLoot());
        tagCompound.setBoolean("PersistenceRequired", this.persistenceRequired);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.equipment.length; ++i)
        {
            NBTTagCompound nbttagcompound = new NBTTagCompound();

            if (this.equipment[i] != null)
            {
                this.equipment[i].writeToNBT(nbttagcompound);
            }

            nbttaglist.appendTag(nbttagcompound);
        }

        tagCompound.setTag("Equipment", nbttaglist);
        NBTTagList nbttaglist1 = new NBTTagList();

        for (int j = 0; j < this.equipmentDropChances.length; ++j)
        {
            nbttaglist1.appendTag(new NBTTagFloat(this.equipmentDropChances[j]));
        }

        tagCompound.setTag("DropChances", nbttaglist1);
        tagCompound.setBoolean("Leashed", this.isLeashed);

        if (this.leashedToEntity != null)
        {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();

            if (this.leashedToEntity instanceof EntityLivingBase)
            {
                nbttagcompound1.setLong("UUIDMost", this.leashedToEntity.getUniqueID().getMostSignificantBits());
                nbttagcompound1.setLong("UUIDLeast", this.leashedToEntity.getUniqueID().getLeastSignificantBits());
            }
            else if (this.leashedToEntity instanceof EntityHanging)
            {
                BlockPos blockpos = ((EntityHanging)this.leashedToEntity).getHangingPosition();
                nbttagcompound1.setInteger("X", blockpos.getX());
                nbttagcompound1.setInteger("Y", blockpos.getY());
                nbttagcompound1.setInteger("Z", blockpos.getZ());
            }

            tagCompound.setTag("Leash", nbttagcompound1);
        }

        if (this.isAIDisabled())
        {
            tagCompound.setBoolean("NoAI", this.isAIDisabled());
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);

        if (tagCompund.hasKey("CanPickUpLoot", 1))
        {
            this.setCanPickUpLoot(tagCompund.getBoolean("CanPickUpLoot"));
        }

        this.persistenceRequired = tagCompund.getBoolean("PersistenceRequired");

        if (tagCompund.hasKey("Equipment", OBFVAL_qTNjD.get()))
        {
            NBTTagList nbttaglist = tagCompund.getTagList("Equipment", OBFVAL_EGX2W.get());

            for (int i = 0; i < this.equipment.length; ++i)
            {
                this.equipment[i] = ItemStack.loadItemStackFromNBT(nbttaglist.getCompoundTagAt(i));
            }
        }

        if (tagCompund.hasKey("DropChances", OBFVAL_qTNjD.get()))
        {
            NBTTagList nbttaglist1 = tagCompund.getTagList("DropChances", OBFVAL_IsYiY.get());

            for (int j = 0; j < nbttaglist1.tagCount(); ++j)
            {
                this.equipmentDropChances[j] = nbttaglist1.getFloatAt(j);
            }
        }

        this.isLeashed = tagCompund.getBoolean("Leashed");

        if (this.isLeashed && tagCompund.hasKey("Leash", OBFVAL_EGX2W.get()))
        {
            this.leashNBTTag = tagCompund.getCompoundTag("Leash");
        }

        this.setNoAI(tagCompund.getBoolean("NoAI"));
    }

    public void setMoveForward(float p_70657_1_)
    {
        this.moveForward = p_70657_1_;
    }

    /**
     * set the movespeed used for the new AI system
     */
    public void setAIMoveSpeed(float speedIn)
    {
        super.setAIMoveSpeed(speedIn);
        this.setMoveForward(speedIn);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        this.worldObj.theProfiler.startSection("looting");

        if (!this.worldObj.isRemote && this.canPickUpLoot() && !this.dead && this.worldObj.getGameRules().getBoolean("mobGriefing"))
        {
            for (EntityItem entityitem : this.worldObj.getEntitiesWithinAABB(EntityItem.class, this.getEntityBoundingBox().expand(1.0D, 0.0D, 1.0D)))
            {
                if (!entityitem.isDead && entityitem.getEntityItem() != null && !entityitem.cannotPickup())
                {
                    this.updateEquipmentIfNeeded(entityitem);
                }
            }
        }

        this.worldObj.theProfiler.endSection();
    }

    /**
     * Tests if this entity should pickup a weapon or an armor. Entity drops current weapon or armor if the new one is
     * better.
     */
    protected void updateEquipmentIfNeeded(EntityItem itemEntity)
    {
        ItemStack itemstack = itemEntity.getEntityItem();
        int i = getArmorPosition(itemstack);

        if (i > -1)
        {
            boolean flag = true;
            ItemStack itemstack1 = this.getEquipmentInSlot(i);

            if (itemstack1 != null)
            {
                if (i == 0)
                {
                    if (itemstack.getItem() instanceof ItemSword && !(itemstack1.getItem() instanceof ItemSword))
                    {
                        flag = true;
                    }
                    else if (itemstack.getItem() instanceof ItemSword && itemstack1.getItem() instanceof ItemSword)
                    {
                        ItemSword itemsword = (ItemSword)itemstack.getItem();
                        ItemSword itemsword1 = (ItemSword)itemstack1.getItem();

                        if (itemsword.getDamageVsEntity() != itemsword1.getDamageVsEntity())
                        {
                            flag = itemsword.getDamageVsEntity() > itemsword1.getDamageVsEntity();
                        }
                        else
                        {
                            flag = itemstack.getMetadata() > itemstack1.getMetadata() || itemstack.hasTagCompound() && !itemstack1.hasTagCompound();
                        }
                    }
                    else if (itemstack.getItem() instanceof ItemBow && itemstack1.getItem() instanceof ItemBow)
                    {
                        flag = itemstack.hasTagCompound() && !itemstack1.hasTagCompound();
                    }
                    else
                    {
                        flag = false;
                    }
                }
                else if (itemstack.getItem() instanceof ItemArmor && !(itemstack1.getItem() instanceof ItemArmor))
                {
                    flag = true;
                }
                else if (itemstack.getItem() instanceof ItemArmor && itemstack1.getItem() instanceof ItemArmor)
                {
                    ItemArmor itemarmor = (ItemArmor)itemstack.getItem();
                    ItemArmor itemarmor1 = (ItemArmor)itemstack1.getItem();

                    if (itemarmor.damageReduceAmount != itemarmor1.damageReduceAmount)
                    {
                        flag = itemarmor.damageReduceAmount > itemarmor1.damageReduceAmount;
                    }
                    else
                    {
                        flag = itemstack.getMetadata() > itemstack1.getMetadata() || itemstack.hasTagCompound() && !itemstack1.hasTagCompound();
                    }
                }
                else
                {
                    flag = false;
                }
            }

            if (flag && this.func_175448_a(itemstack))
            {
                if (itemstack1 != null && this.rand.nextFloat() - OBFVAL_KSpPM.get() < this.equipmentDropChances[i])
                {
                    this.entityDropItem(itemstack1, 0.0F);
                }

                if (itemstack.getItem() == Items.diamond && itemEntity.getThrower() != null)
                {
                    EntityPlayer entityplayer = this.worldObj.getPlayerEntityByName(itemEntity.getThrower());

                    if (entityplayer != null)
                    {
                        entityplayer.triggerAchievement(AchievementList.diamondsToYou);
                    }
                }

                this.setCurrentItemOrArmor(i, itemstack);
                this.equipmentDropChances[i] = OBFVAL_bq6j5.get();
                this.persistenceRequired = true;
                this.onItemPickup(itemEntity, 1);
                itemEntity.setDead();
            }
        }
    }

    protected boolean func_175448_a(ItemStack stack)
    {
        return true;
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return true;
    }

    /**
     * Makes the entity despawn if requirements are reached
     */
    protected void despawnEntity()
    {
        if (this.persistenceRequired)
        {
            this.entityAge = 0;
        }
        else
        {
            EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity(this, OBFVAL_2HY2j.get());

            if (entityplayer != null)
            {
                double d0 = entityplayer.posX - this.posX;
                double d1 = entityplayer.posY - this.posY;
                double d2 = entityplayer.posZ - this.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;

                if (this.canDespawn() && d3 > OBFVAL_u3Dox.get())
                {
                    this.setDead();
                }

                if (this.entityAge > OBFVAL_dzQEy.get() && this.rand.nextInt(OBFVAL_W71Y6.get()) == 0 && d3 > OBFVAL_Knxmr.get() && this.canDespawn())
                {
                    this.setDead();
                }
                else if (d3 < OBFVAL_Knxmr.get())
                {
                    this.entityAge = 0;
                }
            }
        }
    }

    protected final void updateEntityActionState()
    {
        ++this.entityAge;
        this.worldObj.theProfiler.startSection("checkDespawn");
        this.despawnEntity();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("sensing");
        this.senses.clearSensingCache();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("targetSelector");
        this.targetTasks.onUpdateTasks();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("goalSelector");
        this.tasks.onUpdateTasks();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("navigation");
        this.navigator.onUpdateNavigation();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("mob tick");
        this.updateAITasks();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.startSection("controls");
        this.worldObj.theProfiler.startSection("move");
        this.moveHelper.onUpdateMoveHelper();
        this.worldObj.theProfiler.endStartSection("look");
        this.lookHelper.onUpdateLook();
        this.worldObj.theProfiler.endStartSection("jump");
        this.jumpHelper.doJump();
        this.worldObj.theProfiler.endSection();
        this.worldObj.theProfiler.endSection();
    }

    protected void updateAITasks()
    {
    }

    /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed()
    {
        return OBFVAL_vUPKH.get();
    }

    /**
     * Changes pitch and yaw so that the entity calling the function is facing the entity provided as an argument.
     */
    public void faceEntity(Entity entityIn, float p_70625_2_, float p_70625_3_)
    {
        double d0 = entityIn.posX - this.posX;
        double d1 = entityIn.posZ - this.posZ;
        double d2;

        if (entityIn instanceof EntityLivingBase)
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)entityIn;
            d2 = entitylivingbase.posY + (double)entitylivingbase.getEyeHeight() - (this.posY + (double)this.getEyeHeight());
        }
        else
        {
            d2 = (entityIn.getEntityBoundingBox().minY + entityIn.getEntityBoundingBox().maxY) / OBFVAL_t3lAb.get() - (this.posY + (double)this.getEyeHeight());
        }

        double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d1 * d1);
        float f = (float)(MathHelper.func_181159_b(d1, d0) * OBFVAL_YpKOM.get() / OBFVAL_MxiKB.get()) - OBFVAL_T8jAb.get();
        float f1 = (float)(-(MathHelper.func_181159_b(d2, d3) * OBFVAL_YpKOM.get() / OBFVAL_MxiKB.get()));
        this.rotationPitch = this.updateRotation(this.rotationPitch, f1, p_70625_3_);
        this.rotationYaw = this.updateRotation(this.rotationYaw, f, p_70625_2_);
    }

    /**
     * Arguments: current rotation, intended rotation, max increment.
     */
    private float updateRotation(float p_70663_1_, float p_70663_2_, float p_70663_3_)
    {
        float f = MathHelper.wrapAngleTo180_float(p_70663_2_ - p_70663_1_);

        if (f > p_70663_3_)
        {
            f = p_70663_3_;
        }

        if (f < -p_70663_3_)
        {
            f = -p_70663_3_;
        }

        return p_70663_1_ + f;
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return true;
    }

    /**
     * Checks that the entity is not colliding with any blocks / liquids
     */
    public boolean isNotColliding()
    {
        return this.worldObj.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(this.getEntityBoundingBox());
    }

    /**
     * Returns render size modifier
     */
    public float getRenderSizeModifier()
    {
        return 1.0F;
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk()
    {
        return OBFVAL_q4aUT.get();
    }

    /**
     * The maximum height from where the entity is alowed to jump (used in pathfinder)
     */
    public int getMaxFallHeight()
    {
        if (this.getAttackTarget() == null)
        {
            return OBFVAL_12PoI.get();
        }
        else
        {
            int i = (int)(this.getHealth() - this.getMaxHealth() * OBFVAL_Hw6vk.get());
            i = i - (OBFVAL_12PoI.get() - this.worldObj.getDifficulty().getDifficultyId()) * OBFVAL_q4aUT.get();

            if (i < 0)
            {
                i = 0;
            }

            return i + OBFVAL_12PoI.get();
        }
    }

    /**
     * Returns the item that this EntityLiving is holding, if any.
     */
    public ItemStack getHeldItem()
    {
        return this.equipment[0];
    }

    /**
     * 0: Tool in Hand; 1-4: Armor
     */
    public ItemStack getEquipmentInSlot(int slotIn)
    {
        return this.equipment[slotIn];
    }

    public ItemStack getCurrentArmor(int slotIn)
    {
        return this.equipment[slotIn + 1];
    }

    /**
     * Sets the held item, or an armor slot. Slot 0 is held item. Slot 1-4 is armor. Params: Item, slot
     */
    public void setCurrentItemOrArmor(int slotIn, ItemStack stack)
    {
        this.equipment[slotIn] = stack;
    }

    /**
     * returns the inventory of this entity (only used in EntityPlayerMP it seems)
     */
    public ItemStack[] getInventory()
    {
        return this.equipment;
    }

    /**
     * Drop the equipment for this entity.
     */
    protected void dropEquipment(boolean p_82160_1_, int p_82160_2_)
    {
        for (int i = 0; i < this.getInventory().length; ++i)
        {
            ItemStack itemstack = this.getEquipmentInSlot(i);
            boolean flag = this.equipmentDropChances[i] > 1.0F;

            if (itemstack != null && (p_82160_1_ || flag) && this.rand.nextFloat() - (float)p_82160_2_ * OBFVAL_MYWow.get() < this.equipmentDropChances[i])
            {
                if (!flag && itemstack.isItemStackDamageable())
                {
                    int j = Math.max(itemstack.getMaxDamage() - OBFVAL_Pu6Mc.get(), 1);
                    int k = itemstack.getMaxDamage() - this.rand.nextInt(this.rand.nextInt(j) + 1);

                    if (k > j)
                    {
                        k = j;
                    }

                    if (k < 1)
                    {
                        k = 1;
                    }

                    itemstack.setItemDamage(k);
                }

                this.entityDropItem(itemstack, 0.0F);
            }
        }
    }

    /**
     * Gives armor or weapon for entity based on given DifficultyInstance
     */
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
        if (this.rand.nextFloat() < OBFVAL_B4xwu.get() * difficulty.getClampedAdditionalDifficulty())
        {
            int i = this.rand.nextInt(OBFVAL_JCvDM.get());
            float f = this.worldObj.getDifficulty() == EnumDifficulty.HARD ? OBFVAL_KSpPM.get() : OBFVAL_uyYNu.get();

            if (this.rand.nextFloat() < OBFVAL_HXqtc.get())
            {
                ++i;
            }

            if (this.rand.nextFloat() < OBFVAL_HXqtc.get())
            {
                ++i;
            }

            if (this.rand.nextFloat() < OBFVAL_HXqtc.get())
            {
                ++i;
            }

            for (int j = OBFVAL_12PoI.get(); j >= 0; --j)
            {
                ItemStack itemstack = this.getCurrentArmor(j);

                if (j < OBFVAL_12PoI.get() && this.rand.nextFloat() < f)
                {
                    break;
                }

                if (itemstack == null)
                {
                    Item item = getArmorItemForSlot(j + 1, i);

                    if (item != null)
                    {
                        this.setCurrentItemOrArmor(j + 1, new ItemStack(item));
                    }
                }
            }
        }
    }

    public static int getArmorPosition(ItemStack stack)
    {
        if (stack.getItem() != Item.getItemFromBlock(Blocks.pumpkin) && stack.getItem() != Items.skull)
        {
            if (stack.getItem() instanceof ItemArmor)
            {
                switch (((ItemArmor)stack.getItem()).armorType)
                {
                    case 0:
                        return OBFVAL_q4aUT.get();

                    case 1:
                        return OBFVAL_12PoI.get();

                    case 2:
                        return OBFVAL_JCvDM.get();

                    case 3:
                        return 1;
                }
            }

            return 0;
        }
        else
        {
            return OBFVAL_q4aUT.get();
        }
    }

    /**
     * Gets the vanilla armor Item that can go in the slot specified for the given tier.
     */
    public static Item getArmorItemForSlot(int armorSlot, int itemTier)
    {
        switch (armorSlot)
        {
            case 4:
                if (itemTier == 0)
                {
                    return Items.leather_helmet;
                }
                else if (itemTier == 1)
                {
                    return Items.golden_helmet;
                }
                else if (itemTier == OBFVAL_JCvDM.get())
                {
                    return Items.chainmail_helmet;
                }
                else if (itemTier == OBFVAL_12PoI.get())
                {
                    return Items.iron_helmet;
                }
                else if (itemTier == OBFVAL_q4aUT.get())
                {
                    return Items.diamond_helmet;
                }

            case 3:
                if (itemTier == 0)
                {
                    return Items.leather_chestplate;
                }
                else if (itemTier == 1)
                {
                    return Items.golden_chestplate;
                }
                else if (itemTier == OBFVAL_JCvDM.get())
                {
                    return Items.chainmail_chestplate;
                }
                else if (itemTier == OBFVAL_12PoI.get())
                {
                    return Items.iron_chestplate;
                }
                else if (itemTier == OBFVAL_q4aUT.get())
                {
                    return Items.diamond_chestplate;
                }

            case 2:
                if (itemTier == 0)
                {
                    return Items.leather_leggings;
                }
                else if (itemTier == 1)
                {
                    return Items.golden_leggings;
                }
                else if (itemTier == OBFVAL_JCvDM.get())
                {
                    return Items.chainmail_leggings;
                }
                else if (itemTier == OBFVAL_12PoI.get())
                {
                    return Items.iron_leggings;
                }
                else if (itemTier == OBFVAL_q4aUT.get())
                {
                    return Items.diamond_leggings;
                }

            case 1:
                if (itemTier == 0)
                {
                    return Items.leather_boots;
                }
                else if (itemTier == 1)
                {
                    return Items.golden_boots;
                }
                else if (itemTier == OBFVAL_JCvDM.get())
                {
                    return Items.chainmail_boots;
                }
                else if (itemTier == OBFVAL_12PoI.get())
                {
                    return Items.iron_boots;
                }
                else if (itemTier == OBFVAL_q4aUT.get())
                {
                    return Items.diamond_boots;
                }

            default:
                return null;
        }
    }

    /**
     * Enchants Entity's current equipments based on given DifficultyInstance
     */
    protected void setEnchantmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
        float f = difficulty.getClampedAdditionalDifficulty();

        if (this.getHeldItem() != null && this.rand.nextFloat() < OBFVAL_uyYNu.get() * f)
        {
            EnchantmentHelper.addRandomEnchantment(this.rand, this.getHeldItem(), (int)(OBFVAL_9Dsog.get() + f * (float)this.rand.nextInt(OBFVAL_L6P2W.get())));
        }

        for (int i = 0; i < OBFVAL_q4aUT.get(); ++i)
        {
            ItemStack itemstack = this.getCurrentArmor(i);

            if (itemstack != null && this.rand.nextFloat() < OBFVAL_FKdiv.get() * f)
            {
                EnchantmentHelper.addRandomEnchantment(this.rand, itemstack, (int)(OBFVAL_9Dsog.get() + f * (float)this.rand.nextInt(OBFVAL_L6P2W.get())));
            }
        }
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata)
    {
        this.getEntityAttribute(SharedMonsterAttributes.followRange).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextGaussian() * OBFVAL_sPw4t.get(), 1));
        return livingdata;
    }

    /**
     * returns true if all the conditions for steering the entity are met. For pigs, this is true if it is being ridden
     * by a player and the player is holding a carrot-on-a-stick
     */
    public boolean canBeSteered()
    {
        return false;
    }

    /**
     * Enable the Entity persistence
     */
    public void enablePersistence()
    {
        this.persistenceRequired = true;
    }

    public void setEquipmentDropChance(int slotIn, float chance)
    {
        this.equipmentDropChances[slotIn] = chance;
    }

    public boolean canPickUpLoot()
    {
        return this.canPickUpLoot;
    }

    public void setCanPickUpLoot(boolean canPickup)
    {
        this.canPickUpLoot = canPickup;
    }

    public boolean isNoDespawnRequired()
    {
        return this.persistenceRequired;
    }

    /**
     * First layer of player interaction
     */
    public final boolean interactFirst(EntityPlayer playerIn)
    {
        if (this.getLeashed() && this.getLeashedToEntity() == playerIn)
        {
            this.clearLeashed(true, !playerIn.capabilities.isCreativeMode);
            return true;
        }
        else
        {
            ItemStack itemstack = playerIn.inventory.getCurrentItem();

            if (itemstack != null && itemstack.getItem() == Items.lead && this.allowLeashing())
            {
                if (!(this instanceof EntityTameable) || !((EntityTameable)this).isTamed())
                {
                    this.setLeashedToEntity(playerIn, true);
                    --itemstack.stackSize;
                    return true;
                }

                if (((EntityTameable)this).isOwner(playerIn))
                {
                    this.setLeashedToEntity(playerIn, true);
                    --itemstack.stackSize;
                    return true;
                }
            }

            return this.interact(playerIn) ? true : super.interactFirst(playerIn);
        }
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    protected boolean interact(EntityPlayer player)
    {
        return false;
    }

    /**
     * Applies logic related to leashes, for example dragging the entity or breaking the leash.
     */
    protected void updateLeashedState()
    {
        if (this.leashNBTTag != null)
        {
            this.recreateLeash();
        }

        if (this.isLeashed)
        {
            if (!this.isEntityAlive())
            {
                this.clearLeashed(true, true);
            }

            if (this.leashedToEntity == null || this.leashedToEntity.isDead)
            {
                this.clearLeashed(true, true);
            }
        }
    }

    /**
     * Removes the leash from this entity
     */
    public void clearLeashed(boolean sendPacket, boolean dropLead)
    {
        if (this.isLeashed)
        {
            this.isLeashed = false;
            this.leashedToEntity = null;

            if (!this.worldObj.isRemote && dropLead)
            {
                this.dropItem(Items.lead, 1);
            }

            if (!this.worldObj.isRemote && sendPacket && this.worldObj instanceof WorldServer)
            {
                ((WorldServer)this.worldObj).getEntityTracker().sendToAllTrackingEntity(this, new S1BPacketEntityAttach(1, this, (Entity)null));
            }
        }
    }

    public boolean allowLeashing()
    {
        return !this.getLeashed() && !(this instanceof IMob);
    }

    public boolean getLeashed()
    {
        return this.isLeashed;
    }

    public Entity getLeashedToEntity()
    {
        return this.leashedToEntity;
    }

    /**
     * Sets the entity to be leashed to.
     */
    public void setLeashedToEntity(Entity entityIn, boolean sendAttachNotification)
    {
        this.isLeashed = true;
        this.leashedToEntity = entityIn;

        if (!this.worldObj.isRemote && sendAttachNotification && this.worldObj instanceof WorldServer)
        {
            ((WorldServer)this.worldObj).getEntityTracker().sendToAllTrackingEntity(this, new S1BPacketEntityAttach(1, this, this.leashedToEntity));
        }
    }

    private void recreateLeash()
    {
        if (this.isLeashed && this.leashNBTTag != null)
        {
            if (this.leashNBTTag.hasKey("UUIDMost", OBFVAL_q4aUT.get()) && this.leashNBTTag.hasKey("UUIDLeast", OBFVAL_q4aUT.get()))
            {
                UUID uuid = new UUID(this.leashNBTTag.getLong("UUIDMost"), this.leashNBTTag.getLong("UUIDLeast"));

                for (EntityLivingBase entitylivingbase : this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox().expand(OBFVAL_7kjA4.get(), OBFVAL_7kjA4.get(), OBFVAL_7kjA4.get())))
                {
                    if (entitylivingbase.getUniqueID().equals(uuid))
                    {
                        this.leashedToEntity = entitylivingbase;
                        break;
                    }
                }
            }
            else if (this.leashNBTTag.hasKey("X", OBFVAL_SZIJq.get()) && this.leashNBTTag.hasKey("Y", OBFVAL_SZIJq.get()) && this.leashNBTTag.hasKey("Z", OBFVAL_SZIJq.get()))
            {
                BlockPos blockpos = new BlockPos(this.leashNBTTag.getInteger("X"), this.leashNBTTag.getInteger("Y"), this.leashNBTTag.getInteger("Z"));
                EntityLeashKnot entityleashknot = EntityLeashKnot.getKnotForPosition(this.worldObj, blockpos);

                if (entityleashknot == null)
                {
                    entityleashknot = EntityLeashKnot.createKnot(this.worldObj, blockpos);
                }

                this.leashedToEntity = entityleashknot;
            }
            else
            {
                this.clearLeashed(false, true);
            }
        }

        this.leashNBTTag = null;
    }

    public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn)
    {
        int i;

        if (inventorySlot == OBFVAL_SZIJq.get())
        {
            i = 0;
        }
        else
        {
            i = inventorySlot - OBFVAL_tHnJs.get() + 1;

            if (i < 0 || i >= this.equipment.length)
            {
                return false;
            }
        }

        if (itemStackIn != null && getArmorPosition(itemStackIn) != i && (i != OBFVAL_q4aUT.get() || !(itemStackIn.getItem() instanceof ItemBlock)))
        {
            return false;
        }
        else
        {
            this.setCurrentItemOrArmor(i, itemStackIn);
            return true;
        }
    }

    /**
     * Returns whether the entity is in a server world
     */
    public boolean isServerWorld()
    {
        return super.isServerWorld() && !this.isAIDisabled();
    }

    /**
     * Set whether this Entity's AI is disabled
     */
    public void setNoAI(boolean disable)
    {
        this.dataWatcher.updateObject(OBFVAL_1lc8v.get(), Byte.valueOf((byte)(disable ? 1 : 0)));
    }

    /**
     * Get whether this Entity's AI is disabled
     */
    public boolean isAIDisabled()
    {
        return this.dataWatcher.getWatchableObjectByte(OBFVAL_1lc8v.get()) != 0;
    }

    /**
     * Checks if this entity is inside of an opaque block
     */
    public boolean isEntityInsideOpaqueBlock()
    {
        if (this.noClip)
        {
            return false;
        }
        else
        {
            BlockPosM blockposm = new BlockPosM(0, 0, 0);

            for (int i = 0; i < OBFVAL_UJUP3.get(); ++i)
            {
                double d0 = this.posX + (double)(((float)((i >> 0) % OBFVAL_JCvDM.get()) - OBFVAL_FKdiv.get()) * this.width * OBFVAL_zInuQ.get());
                double d1 = this.posY + (double)(((float)((i >> 1) % OBFVAL_JCvDM.get()) - OBFVAL_FKdiv.get()) * OBFVAL_KSpPM.get());
                double d2 = this.posZ + (double)(((float)((i >> OBFVAL_JCvDM.get()) % OBFVAL_JCvDM.get()) - OBFVAL_FKdiv.get()) * this.width * OBFVAL_zInuQ.get());
                blockposm.setXyz(d0, d1 + (double)this.getEyeHeight(), d2);

                if (this.worldObj.getBlockState(blockposm).getBlock().isVisuallyOpaque())
                {
                    return true;
                }
            }

            return false;
        }
    }

    private boolean canSkipUpdate()
    {
        if (this.isChild())
        {
            return false;
        }
        else if (this.hurtTime > 0)
        {
            return false;
        }
        else if (this.ticksExisted < OBFVAL_q9L8h.get())
        {
            return false;
        }
        else
        {
            World world = this.getEntityWorld();

            if (world == null)
            {
                return false;
            }
            else if (world.playerEntities.size() != 1)
            {
                return false;
            }
            else
            {
                Entity entity = (Entity)world.playerEntities.get(0);
                double d0 = Math.max(Math.abs(this.posX - entity.posX) - OBFVAL_wK3sV.get(), 0.0D);
                double d1 = Math.max(Math.abs(this.posZ - entity.posZ) - OBFVAL_wK3sV.get(), 0.0D);
                double d2 = d0 * d0 + d1 * d1;
                return !this.isInRangeToRenderDist(d2);
            }
        }
    }

    private void onUpdateMinimal()
    {
        ++this.entityAge;

        if (this instanceof EntityMob)
        {
            float f = this.getBrightness(1.0F);

            if (f > OBFVAL_FKdiv.get())
            {
                this.entityAge += OBFVAL_JCvDM.get();
            }
        }

        this.despawnEntity();
    }

    static
    {
        ObfValue.beginGeneration();
        ObfValue.endGeneration(new byte[] {(byte) - 86, (byte) - 31, (byte)54, (byte) - 97, (byte)8, (byte)64, (byte)91, (byte) - 39});
    }

    public static enum SpawnPlacementType
    {
        ON_GROUND,
        IN_AIR,
        IN_WATER;
    }
}
