package net.minecraft.entity.monster;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.xtrafrancyz.covered.ObfValue;

public class EntityZombie extends EntityMob
{
    private static final ObfValue.OFloat OBFVAL_3QbUX = ObfValue.create(8.0F);
    private static final ObfValue.OInteger OBFVAL_RiwEw = ObfValue.create(1016);
    private static final ObfValue.OInteger OBFVAL_7BLXK = ObfValue.create(10);
    private static final ObfValue.ODouble OBFVAL_EVi8v = ObfValue.create(0.81D);
    private static final ObfValue.OFloat OBFVAL_duAOn = ObfValue.create(0.3F);
    private static final ObfValue.OFloat OBFVAL_fn5iG = ObfValue.create(1.74F);
    private static final ObfValue.OFloat OBFVAL_nyvRw = ObfValue.create(0.15F);
    private static final ObfValue.ODouble OBFVAL_rmBYp = ObfValue.create(0.05D);
    private static final ObfValue.ODouble OBFVAL_cMw37 = ObfValue.create(35.0D);
    private static final ObfValue.ODouble OBFVAL_n0PSy = ObfValue.create(5.0D);
    private static final ObfValue.ODouble OBFVAL_lrlDV = ObfValue.create(0.5D);
    private static final ObfValue.OInteger OBFVAL_XmTfN = ObfValue.create(200);
    private static final ObfValue.OFloat OBFVAL_qmh9Z = ObfValue.create(0.25F);
    private static final ObfValue.OInteger OBFVAL_1L8rU = ObfValue.create(6);
    private static final ObfValue.OInteger OBFVAL_e7ZJn = ObfValue.create(12);
    private static final ObfValue.OInteger OBFVAL_8QmWR = ObfValue.create(20);
    private static final ObfValue.ODouble OBFVAL_I5ti3 = ObfValue.create(1.5D);
    private static final ObfValue.OInteger OBFVAL_j1GWW = ObfValue.create(16);
    private static final ObfValue.OInteger OBFVAL_sUE2e = ObfValue.create(2);
    private static final ObfValue.OFloat OBFVAL_1EpJ9 = ObfValue.create(0.4F);
    private static final ObfValue.OInteger OBFVAL_RIpOj = ObfValue.create(3);
    private static final ObfValue.OFloat OBFVAL_Mhi0G = ObfValue.create(1.95F);
    private static final ObfValue.ODouble OBFVAL_pFGFS = ObfValue.create(0.25D);
    private static final ObfValue.OInteger OBFVAL_A6vKn = ObfValue.create(2401);
    private static final ObfValue.ODouble OBFVAL_zhJBd = ObfValue.create(-0.35D);
    private static final ObfValue.OInteger OBFVAL_nsgTY = ObfValue.create(8);
    private static final ObfValue.OInteger OBFVAL_adMd2 = ObfValue.create(50);
    private static final ObfValue.OInteger OBFVAL_VgjPG = ObfValue.create(13);
    private static final ObfValue.OFloat OBFVAL_Lqqeh = ObfValue.create(2.0F);
    private static final ObfValue.OFloat OBFVAL_M42Ne = ObfValue.create(0.55F);
    private static final ObfValue.OInteger OBFVAL_izrSG = ObfValue.create(3600);
    private static final ObfValue.ODouble OBFVAL_U6npl = ObfValue.create(-0.05000000074505806D);
    private static final ObfValue.OInteger OBFVAL_FKEnU = ObfValue.create(31);
    private static final ObfValue.ODouble OBFVAL_Chfw4 = ObfValue.create(0.10000000149011612D);
    private static final ObfValue.OInteger OBFVAL_fSXqW = ObfValue.create(14);
    private static final ObfValue.ODouble OBFVAL_cVcZR = ObfValue.create(7.0D);
    private static final ObfValue.OInteger OBFVAL_h5Gnj = ObfValue.create(40);
    private static final ObfValue.OInteger OBFVAL_SKozk = ObfValue.create(99);
    private static final ObfValue.OInteger OBFVAL_H9gE7 = ObfValue.create(4);
    private static final ObfValue.OInteger OBFVAL_lUlq0 = ObfValue.create(1017);
    private static final ObfValue.OInteger OBFVAL_gs0yT = ObfValue.create(-24000);
    private static final ObfValue.OFloat OBFVAL_LIsWx = ObfValue.create(2.5F);
    private static final ObfValue.OFloat OBFVAL_rJzaJ = ObfValue.create(-1.0F);
    private static final ObfValue.OFloat OBFVAL_jHM41 = ObfValue.create(0.05F);
    private static final ObfValue.OFloat OBFVAL_OgGHQ = ObfValue.create(0.1F);
    private static final ObfValue.ODouble OBFVAL_gK9Au = ObfValue.create(0.23000000417232513D);
    private static final ObfValue.OFloat OBFVAL_O1SmZ = ObfValue.create(0.5F);
    private static final ObfValue.OFloat OBFVAL_85m4H = ObfValue.create(0.7F);
    private static final ObfValue.OFloat OBFVAL_gCSJU = ObfValue.create(0.01F);
    private static final ObfValue.OInteger OBFVAL_THSts = ObfValue.create(5);
    private static final ObfValue.ODouble OBFVAL_bFzm3 = ObfValue.create(3.0D);
    private static final ObfValue.OInteger OBFVAL_V71N4 = ObfValue.create(7);
    private static final ObfValue.OFloat OBFVAL_tbtFm = ObfValue.create(30.0F);
    private static final ObfValue.ODouble OBFVAL_jkhmz = ObfValue.create(0.05000000074505806D);

    /**
     * The attribute which determines the chance that this mob will spawn reinforcements
     */
    protected static final IAttribute reinforcementChance = (new RangedAttribute((IAttribute)null, "zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).setDescription("Spawn Reinforcements Chance");
    private static final UUID babySpeedBoostUUID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    private static final AttributeModifier babySpeedBoostModifier = new AttributeModifier(babySpeedBoostUUID, "Baby speed boost", 0.5D, 1);
    private final EntityAIBreakDoor breakDoor = new EntityAIBreakDoor(this);

    /**
     * Ticker used to determine the time remaining for this zombie to convert into a villager when cured.
     */
    private int conversionTime;
    private boolean isBreakDoorsTaskSet = false;

    /** The width of the entity */
    private float zombieWidth;

    /** The height of the the entity. */
    private float zombieHeight;

    public EntityZombie(World worldIn)
    {
        super(worldIn);
        this.zombieWidth = OBFVAL_rJzaJ.get();
        ((PathNavigateGround)this.getNavigator()).setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(OBFVAL_sUE2e.get(), new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(OBFVAL_THSts.get(), new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(OBFVAL_V71N4.get(), new EntityAIWander(this, 1.0D));
        this.tasks.addTask(OBFVAL_nsgTY.get(), new EntityAIWatchClosest(this, EntityPlayer.class, OBFVAL_3QbUX.get()));
        this.tasks.addTask(OBFVAL_nsgTY.get(), new EntityAILookIdle(this));
        this.applyEntityAI();
        this.setSize(getDefaultWidth(), OBFVAL_Mhi0G.get());
    }

    protected void applyEntityAI()
    {
        this.tasks.addTask(OBFVAL_H9gE7.get(), new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
        this.tasks.addTask(OBFVAL_H9gE7.get(), new EntityAIAttackOnCollide(this, EntityIronGolem.class, 1.0D, true));
        this.tasks.addTask(OBFVAL_1L8rU.get(), new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {EntityPigZombie.class}));
        this.targetTasks.addTask(OBFVAL_sUE2e.get(), new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(OBFVAL_sUE2e.get(), new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
        this.targetTasks.addTask(OBFVAL_sUE2e.get(), new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(OBFVAL_cMw37.get());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(OBFVAL_gK9Au.get());
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(OBFVAL_bFzm3.get());
        this.getAttributeMap().registerAttribute(reinforcementChance).setBaseValue(this.rand.nextDouble() * OBFVAL_Chfw4.get());
    }

    protected void entityInit()
    {
        super.entityInit();
        this.getDataWatcher().addObject(OBFVAL_e7ZJn.get(), Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(OBFVAL_VgjPG.get(), Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(OBFVAL_fSXqW.get(), Byte.valueOf((byte)0));
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    public int getTotalArmorValue()
    {
        int i = super.getTotalArmorValue() + OBFVAL_sUE2e.get();

        if (i > OBFVAL_8QmWR.get())
        {
            i = OBFVAL_8QmWR.get();
        }

        return i;
    }

    public boolean isBreakDoorsTaskSet()
    {
        return this.isBreakDoorsTaskSet;
    }

    /**
     * Sets or removes EntityAIBreakDoor task
     */
    public void setBreakDoorsAItask(boolean par1)
    {
        if (this.isBreakDoorsTaskSet != par1)
        {
            this.isBreakDoorsTaskSet = par1;

            if (par1)
            {
                this.tasks.addTask(1, this.breakDoor);
            }
            else
            {
                this.tasks.removeTask(this.breakDoor);
            }
        }
    }

    /**
     * If Animal, checks if the age timer is negative
     */
    public boolean isChild()
    {
        return this.getDataWatcher().getWatchableObjectByte(OBFVAL_e7ZJn.get()) == 1;
    }

    /**
     * Get the experience points the entity currently has.
     */
    protected int getExperiencePoints(EntityPlayer player)
    {
        if (this.isChild())
        {
            this.experienceValue = (int)((float)this.experienceValue * OBFVAL_LIsWx.get());
        }

        return super.getExperiencePoints(player);
    }

    /**
     * Set whether this zombie is a child.
     */
    public void setChild(boolean childZombie)
    {
        this.getDataWatcher().updateObject(OBFVAL_e7ZJn.get(), Byte.valueOf((byte)(childZombie ? 1 : 0)));

        if (this.worldObj != null && !this.worldObj.isRemote)
        {
            IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
            iattributeinstance.removeModifier(babySpeedBoostModifier);

            if (childZombie)
            {
                iattributeinstance.applyModifier(babySpeedBoostModifier);
            }
        }

        this.setChildSize(childZombie);
    }

    /**
     * Return whether this zombie is a villager.
     */
    public boolean isVillager()
    {
        return this.getDataWatcher().getWatchableObjectByte(OBFVAL_VgjPG.get()) == 1;
    }

    /**
     * Set whether this zombie is a villager.
     */
    public void setVillager(boolean villager)
    {
        this.getDataWatcher().updateObject(OBFVAL_VgjPG.get(), Byte.valueOf((byte)(villager ? 1 : 0)));
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild())
        {
            float f = this.getBrightness(1.0F);
            BlockPos blockpos = new BlockPos(this.posX, (double)Math.round(this.posY), this.posZ);

            if (f > OBFVAL_O1SmZ.get() && this.rand.nextFloat() * OBFVAL_tbtFm.get() < (f - OBFVAL_1EpJ9.get()) * OBFVAL_Lqqeh.get() && this.worldObj.canSeeSky(blockpos))
            {
                boolean flag = true;
                ItemStack itemstack = this.getEquipmentInSlot(OBFVAL_H9gE7.get());

                if (itemstack != null)
                {
                    if (itemstack.isItemStackDamageable())
                    {
                        itemstack.setItemDamage(itemstack.getItemDamage() + this.rand.nextInt(OBFVAL_sUE2e.get()));

                        if (itemstack.getItemDamage() >= itemstack.getMaxDamage())
                        {
                            this.renderBrokenItemStack(itemstack);
                            this.setCurrentItemOrArmor(OBFVAL_H9gE7.get(), (ItemStack)null);
                        }
                    }

                    flag = false;
                }

                if (flag)
                {
                    this.setFire(OBFVAL_nsgTY.get());
                }
            }
        }

        if (this.isRiding() && this.getAttackTarget() != null && this.ridingEntity instanceof EntityChicken)
        {
            ((EntityLiving)this.ridingEntity).getNavigator().setPath(this.getNavigator().getPath(), OBFVAL_I5ti3.get());
        }

        super.onLivingUpdate();
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (super.attackEntityFrom(source, amount))
        {
            EntityLivingBase entitylivingbase = this.getAttackTarget();

            if (entitylivingbase == null && source.getEntity() instanceof EntityLivingBase)
            {
                entitylivingbase = (EntityLivingBase)source.getEntity();
            }

            if (entitylivingbase != null && this.worldObj.getDifficulty() == EnumDifficulty.HARD && (double)this.rand.nextFloat() < this.getEntityAttribute(reinforcementChance).getAttributeValue())
            {
                int i = MathHelper.floor_double(this.posX);
                int j = MathHelper.floor_double(this.posY);
                int k = MathHelper.floor_double(this.posZ);
                EntityZombie entityzombie = new EntityZombie(this.worldObj);

                for (int l = 0; l < OBFVAL_adMd2.get(); ++l)
                {
                    int i1 = i + MathHelper.getRandomIntegerInRange(this.rand, OBFVAL_V71N4.get(), OBFVAL_h5Gnj.get()) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
                    int j1 = j + MathHelper.getRandomIntegerInRange(this.rand, OBFVAL_V71N4.get(), OBFVAL_h5Gnj.get()) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
                    int k1 = k + MathHelper.getRandomIntegerInRange(this.rand, OBFVAL_V71N4.get(), OBFVAL_h5Gnj.get()) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);

                    if (World.doesBlockHaveSolidTopSurface(this.worldObj, new BlockPos(i1, j1 - 1, k1)) && this.worldObj.getLightFromNeighbors(new BlockPos(i1, j1, k1)) < OBFVAL_7BLXK.get())
                    {
                        entityzombie.setPosition((double)i1, (double)j1, (double)k1);

                        if (!this.worldObj.isAnyPlayerWithinRangeAt((double)i1, (double)j1, (double)k1, OBFVAL_cVcZR.get()) && this.worldObj.checkNoEntityCollision(entityzombie.getEntityBoundingBox(), entityzombie) && this.worldObj.getCollidingBoundingBoxes(entityzombie, entityzombie.getEntityBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(entityzombie.getEntityBoundingBox()))
                        {
                            this.worldObj.spawnEntityInWorld(entityzombie);
                            entityzombie.setAttackTarget(entitylivingbase);
                            entityzombie.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(entityzombie)), (IEntityLivingData)null);
                            this.getEntityAttribute(reinforcementChance).applyModifier(new AttributeModifier("Zombie reinforcement caller charge", OBFVAL_U6npl.get(), 0));
                            entityzombie.getEntityAttribute(reinforcementChance).applyModifier(new AttributeModifier("Zombie reinforcement callee charge", OBFVAL_U6npl.get(), 0));
                            break;
                        }
                    }
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        if (!this.worldObj.isRemote && this.isConverting())
        {
            int i = this.getConversionTimeBoost();
            this.conversionTime -= i;

            if (this.conversionTime <= 0)
            {
                this.convertToVillager();
            }
        }

        super.onUpdate();
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        boolean flag = super.attackEntityAsMob(entityIn);

        if (flag)
        {
            int i = this.worldObj.getDifficulty().getDifficultyId();

            if (this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float)i * OBFVAL_duAOn.get())
            {
                entityIn.setFire(OBFVAL_sUE2e.get() * i);
            }
        }

        return flag;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.zombie.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.zombie.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.zombie.death";
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound("mob.zombie.step", OBFVAL_nyvRw.get(), 1.0F);
    }

    protected Item getDropItem()
    {
        return Items.rotten_flesh;
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    /**
     * Causes this Entity to drop a random item.
     */
    protected void addRandomDrop()
    {
        switch (this.rand.nextInt(OBFVAL_RIpOj.get()))
        {
            case 0:
                this.dropItem(Items.iron_ingot, 1);
                break;

            case 1:
                this.dropItem(Items.carrot, 1);
                break;

            case 2:
                this.dropItem(Items.potato, 1);
        }
    }

    /**
     * Gives armor or weapon for entity based on given DifficultyInstance
     */
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
        super.setEquipmentBasedOnDifficulty(difficulty);

        if (this.rand.nextFloat() < (this.worldObj.getDifficulty() == EnumDifficulty.HARD ? OBFVAL_jHM41.get() : OBFVAL_gCSJU.get()))
        {
            int i = this.rand.nextInt(OBFVAL_RIpOj.get());

            if (i == 0)
            {
                this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
            }
            else
            {
                this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_shovel));
            }
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);

        if (this.isChild())
        {
            tagCompound.setBoolean("IsBaby", true);
        }

        if (this.isVillager())
        {
            tagCompound.setBoolean("IsVillager", true);
        }

        tagCompound.setInteger("ConversionTime", this.isConverting() ? this.conversionTime : -1);
        tagCompound.setBoolean("CanBreakDoors", this.isBreakDoorsTaskSet());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);

        if (tagCompund.getBoolean("IsBaby"))
        {
            this.setChild(true);
        }

        if (tagCompund.getBoolean("IsVillager"))
        {
            this.setVillager(true);
        }

        if (tagCompund.hasKey("ConversionTime", OBFVAL_SKozk.get()) && tagCompund.getInteger("ConversionTime") > -1)
        {
            this.startConversion(tagCompund.getInteger("ConversionTime"));
        }

        this.setBreakDoorsAItask(tagCompund.getBoolean("CanBreakDoors"));
    }

    /**
     * This method gets called when the entity kills another one.
     */
    public void onKillEntity(EntityLivingBase entityLivingIn)
    {
        super.onKillEntity(entityLivingIn);

        if ((this.worldObj.getDifficulty() == EnumDifficulty.NORMAL || this.worldObj.getDifficulty() == EnumDifficulty.HARD) && entityLivingIn instanceof EntityVillager)
        {
            if (this.worldObj.getDifficulty() != EnumDifficulty.HARD && this.rand.nextBoolean())
            {
                return;
            }

            EntityLiving entityliving = (EntityLiving)entityLivingIn;
            EntityZombie entityzombie = new EntityZombie(this.worldObj);
            entityzombie.copyLocationAndAnglesFrom(entityLivingIn);
            this.worldObj.removeEntity(entityLivingIn);
            entityzombie.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(entityzombie)), (IEntityLivingData)null);
            entityzombie.setVillager(true);

            if (entityLivingIn.isChild())
            {
                entityzombie.setChild(true);
            }

            entityzombie.setNoAI(entityliving.isAIDisabled());

            if (entityliving.hasCustomName())
            {
                entityzombie.setCustomNameTag(entityliving.getCustomNameTag());
                entityzombie.setAlwaysRenderNameTag(entityliving.getAlwaysRenderNameTag());
            }

            this.worldObj.spawnEntityInWorld(entityzombie);
            this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, OBFVAL_RiwEw.get(), new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);
        }
    }

    public float getEyeHeight()
    {
        float f = OBFVAL_fn5iG.get();

        if (this.isChild())
        {
            f = (float)((double)f - OBFVAL_EVi8v.get());
        }

        return f;
    }

    protected boolean func_175448_a(ItemStack stack)
    {
        return stack.getItem() == Items.egg && this.isChild() && this.isRiding() ? false : super.func_175448_a(stack);
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata)
    {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        float f = difficulty.getClampedAdditionalDifficulty();
        this.setCanPickUpLoot(this.rand.nextFloat() < OBFVAL_M42Ne.get() * f);

        if (livingdata == null)
        {
            livingdata = new EntityZombie.GroupData(this.worldObj.rand.nextFloat() < OBFVAL_jHM41.get(), this.worldObj.rand.nextFloat() < OBFVAL_jHM41.get());
        }

        if (livingdata instanceof EntityZombie.GroupData)
        {
            EntityZombie.GroupData entityzombie$groupdata = (EntityZombie.GroupData)livingdata;

            if (entityzombie$groupdata.isVillager)
            {
                this.setVillager(true);
            }

            if (entityzombie$groupdata.isChild)
            {
                this.setChild(true);

                if ((double)this.worldObj.rand.nextFloat() < OBFVAL_rmBYp.get())
                {
                    List<EntityChicken> list = this.worldObj.<EntityChicken>getEntitiesWithinAABB(EntityChicken.class, this.getEntityBoundingBox().expand(OBFVAL_n0PSy.get(), OBFVAL_bFzm3.get(), OBFVAL_n0PSy.get()), EntitySelectors.IS_STANDALONE);

                    if (!list.isEmpty())
                    {
                        EntityChicken entitychicken = (EntityChicken)list.get(0);
                        entitychicken.setChickenJockey(true);
                        this.mountEntity(entitychicken);
                    }
                }
                else if ((double)this.worldObj.rand.nextFloat() < OBFVAL_rmBYp.get())
                {
                    EntityChicken entitychicken1 = new EntityChicken(this.worldObj);
                    entitychicken1.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                    entitychicken1.onInitialSpawn(difficulty, (IEntityLivingData)null);
                    entitychicken1.setChickenJockey(true);
                    this.worldObj.spawnEntityInWorld(entitychicken1);
                    this.mountEntity(entitychicken1);
                }
            }
        }

        this.setBreakDoorsAItask(this.rand.nextFloat() < f * OBFVAL_OgGHQ.get());
        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);

        if (this.getEquipmentInSlot(OBFVAL_H9gE7.get()) == null)
        {
            Calendar calendar = this.worldObj.getCurrentDate();

            if (calendar.get(OBFVAL_sUE2e.get()) + 1 == OBFVAL_7BLXK.get() && calendar.get(OBFVAL_THSts.get()) == OBFVAL_FKEnU.get() && this.rand.nextFloat() < OBFVAL_qmh9Z.get())
            {
                this.setCurrentItemOrArmor(OBFVAL_H9gE7.get(), new ItemStack(this.rand.nextFloat() < OBFVAL_OgGHQ.get() ? Blocks.lit_pumpkin : Blocks.pumpkin));
                this.equipmentDropChances[OBFVAL_H9gE7.get()] = 0.0F;
            }
        }

        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * OBFVAL_jkhmz.get(), 0));
        double d0 = this.rand.nextDouble() * OBFVAL_I5ti3.get() * (double)f;

        if (d0 > 1.0D)
        {
            this.getEntityAttribute(SharedMonsterAttributes.followRange).applyModifier(new AttributeModifier("Random zombie-spawn bonus", d0, OBFVAL_sUE2e.get()));
        }

        if (this.rand.nextFloat() < f * OBFVAL_jHM41.get())
        {
            this.getEntityAttribute(reinforcementChance).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * OBFVAL_pFGFS.get() + OBFVAL_lrlDV.get(), 0));
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * OBFVAL_bFzm3.get() + 1.0D, OBFVAL_sUE2e.get()));
            this.setBreakDoorsAItask(true);
        }

        return livingdata;
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.getCurrentEquippedItem();

        if (itemstack != null && itemstack.getItem() == Items.golden_apple && itemstack.getMetadata() == 0 && this.isVillager() && this.isPotionActive(Potion.weakness))
        {
            if (!player.capabilities.isCreativeMode)
            {
                --itemstack.stackSize;
            }

            if (itemstack.stackSize <= 0)
            {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
            }

            if (!this.worldObj.isRemote)
            {
                this.startConversion(this.rand.nextInt(OBFVAL_A6vKn.get()) + OBFVAL_izrSG.get());
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Starts converting this zombie into a villager. The zombie converts into a villager after the specified time in
     * ticks.
     */
    protected void startConversion(int ticks)
    {
        this.conversionTime = ticks;
        this.getDataWatcher().updateObject(OBFVAL_fSXqW.get(), Byte.valueOf((byte)1));
        this.removePotionEffect(Potion.weakness.id);
        this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, ticks, Math.min(this.worldObj.getDifficulty().getDifficultyId() - 1, 0)));
        this.worldObj.setEntityState(this, (byte)OBFVAL_j1GWW.get());
    }

    public void handleStatusUpdate(byte id)
    {
        if (id == OBFVAL_j1GWW.get())
        {
            if (!this.isSilent())
            {
                this.worldObj.playSound(this.posX + OBFVAL_lrlDV.get(), this.posY + OBFVAL_lrlDV.get(), this.posZ + OBFVAL_lrlDV.get(), "mob.zombie.remedy", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * OBFVAL_85m4H.get() + OBFVAL_duAOn.get(), false);
            }
        }
        else
        {
            super.handleStatusUpdate(id);
        }
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return !this.isConverting();
    }

    /**
     * Returns whether this zombie is in the process of converting to a villager
     */
    public boolean isConverting()
    {
        return this.getDataWatcher().getWatchableObjectByte(OBFVAL_fSXqW.get()) == 1;
    }

    /**
     * Convert this zombie into a villager.
     */
    protected void convertToVillager()
    {
        EntityVillager entityvillager = new EntityVillager(this.worldObj);
        entityvillager.copyLocationAndAnglesFrom(this);
        entityvillager.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(entityvillager)), (IEntityLivingData)null);
        entityvillager.setLookingForHome();

        if (this.isChild())
        {
            entityvillager.setGrowingAge(OBFVAL_gs0yT.get());
        }

        this.worldObj.removeEntity(this);
        entityvillager.setNoAI(this.isAIDisabled());

        if (this.hasCustomName())
        {
            entityvillager.setCustomNameTag(this.getCustomNameTag());
            entityvillager.setAlwaysRenderNameTag(this.getAlwaysRenderNameTag());
        }

        this.worldObj.spawnEntityInWorld(entityvillager);
        entityvillager.addPotionEffect(new PotionEffect(Potion.confusion.id, OBFVAL_XmTfN.get(), 0));
        this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, OBFVAL_lUlq0.get(), new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);
    }

    /**
     * Return the amount of time decremented from conversionTime every tick.
     */
    protected int getConversionTimeBoost()
    {
        int i = 1;

        if (this.rand.nextFloat() < OBFVAL_gCSJU.get())
        {
            int j = 0;
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            for (int k = (int)this.posX - OBFVAL_H9gE7.get(); k < (int)this.posX + OBFVAL_H9gE7.get() && j < OBFVAL_fSXqW.get(); ++k)
            {
                for (int l = (int)this.posY - OBFVAL_H9gE7.get(); l < (int)this.posY + OBFVAL_H9gE7.get() && j < OBFVAL_fSXqW.get(); ++l)
                {
                    for (int i1 = (int)this.posZ - OBFVAL_H9gE7.get(); i1 < (int)this.posZ + OBFVAL_H9gE7.get() && j < OBFVAL_fSXqW.get(); ++i1)
                    {
                        Block block = this.worldObj.getBlockState(blockpos$mutableblockpos.func_181079_c(k, l, i1)).getBlock();

                        if (block == Blocks.iron_bars || block == Blocks.bed)
                        {
                            if (this.rand.nextFloat() < OBFVAL_duAOn.get())
                            {
                                ++i;
                            }

                            ++j;
                        }
                    }
                }
            }
        }

        return i;
    }

    /**
     * sets the size of the entity to be half of its current size if true.
     */
    public void setChildSize(boolean isChild)
    {
        this.multiplySize(isChild ? OBFVAL_O1SmZ.get() : 1.0F);
    }

    /**
     * Sets the width and height of the entity. Args: width, height
     */
    protected final void setSize(float width, float height)
    {
        boolean flag = this.zombieWidth > 0.0F && this.zombieHeight > 0.0F;
        this.zombieWidth = width;
        this.zombieHeight = height;

        if (!flag)
        {
            this.multiplySize(1.0F);
        }
    }

    /**
     * Multiplies the height and width by the provided float.
     */
    protected final void multiplySize(float size)
    {
        super.setSize(this.zombieWidth * size, this.zombieHeight * size);
    }

    /**
     * Returns the Y Offset of this entity.
     */
    public double getYOffset()
    {
        return this.isChild() ? 0.0D : OBFVAL_zhJBd.get();
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);

        if (cause.getEntity() instanceof EntityCreeper && !(this instanceof EntityPigZombie) && ((EntityCreeper)cause.getEntity()).getPowered() && ((EntityCreeper)cause.getEntity()).isAIEnabled())
        {
            ((EntityCreeper)cause.getEntity()).func_175493_co();
            this.entityDropItem(new ItemStack(Items.skull, 1, OBFVAL_sUE2e.get()), 0.0F);
        }
    }

    static
    {
        ObfValue.beginGeneration();
        ObfValue.endGeneration(new byte[] {(byte)86, (byte)6, (byte) - 75, (byte) - 64, (byte) - 117, (byte) - 77, (byte)42, (byte) - 39});
    }

    class GroupData implements IEntityLivingData
    {
        public boolean isChild;
        public boolean isVillager;

        private GroupData(boolean isBaby, boolean isVillagerZombie)
        {
            this.isChild = false;
            this.isVillager = false;
            this.isChild = isBaby;
            this.isVillager = isVillagerZombie;
        }
    }
}
