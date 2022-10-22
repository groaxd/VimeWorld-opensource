package net.xtrafrancyz.mods.texteria.world.aabb;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ClassInheritanceMultiMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.xtrafrancyz.util.ByteMap;

public class BoundingBox
{
    private static int counter;
    private final int id;
    public AxisAlignedBB bb;
    public boolean drag;
    public boolean affectOnlyPlayers;
    public boolean impelYOnTop;
    public boolean impelXZOnSides;
    public BoundingBox.ImpelType impelType;
    public float impelX;
    public float impelY;
    public float impelZ;
    private AxisAlignedBB transformingFrom;
    private AxisAlignedBB transformingTo;
    private boolean moving;
    public double moveOffsetX;
    public double moveOffsetY;
    public double moveOffsetZ;
    public int moveTicks;
    public int moveProgress;
    public boolean dynamic;

    public BoundingBox(ByteMap map)
    {
        this.id = counter++;
        this.bb = read(map.getLongArray("c"));
        this.drag = map.getBoolean("drag", false);
        this.affectOnlyPlayers = map.getBoolean("aop", true);
        this.impelX = map.getFloat("ix", 0.0F);
        this.impelY = map.getFloat("iy", 0.0F);
        this.impelZ = map.getFloat("iz", 0.0F);
        this.impelYOnTop = map.getBoolean("iyot", false);
        this.impelXZOnSides = map.getBoolean("ixzos", false);
        this.impelType = (BoundingBox.ImpelType)map.getStringEnum("it", BoundingBox.ImpelType.MOVE);
    }

    public void tick()
    {
        World world = Minecraft.getMinecraft().thePlayer.getEntityWorld();

        if (this.moveProgress > 0)
        {
            --this.moveProgress;

            if (!this.moving)
            {
                double d3 = (double)(this.moveTicks - this.moveProgress) / (double)this.moveTicks;
                this.bb = new AxisAlignedBB(lerp(d3, this.transformingFrom.minX, this.transformingTo.minX), lerp(d3, this.transformingFrom.minY, this.transformingTo.minY), lerp(d3, this.transformingFrom.minZ, this.transformingTo.minZ), lerp(d3, this.transformingFrom.maxX, this.transformingTo.maxX), lerp(d3, this.transformingFrom.maxY, this.transformingTo.maxY), lerp(d3, this.transformingFrom.maxZ, this.transformingTo.maxZ));
            }
            else
            {
                double d0 = this.moveOffsetX / (double)this.moveTicks;
                double d1 = this.moveOffsetY / (double)this.moveTicks;
                double d2 = this.moveOffsetZ / (double)this.moveTicks;

                if (this.drag)
                {
                    for (Entity entity1 : getEntitiesWithinAABB(world, this.bb.expand(0.0D, 0.02D, 0.0D), this.affectOnlyPlayers))
                    {
                        moveEntity(entity1, d0, d1, d2);
                    }
                }

                this.bb = this.bb.offset(d0, d1, d2);
            }

            for (Entity entity : getEntitiesWithinAABB(world, this.bb, this.affectOnlyPlayers))
            {
                unstuckFromBox(entity, this.bb);
            }
        }

        if (this.impelY != 0.0F)
        {
            AxisAlignedBB axisalignedbb = this.bb.expand(0.02D, 0.0D, 0.02D);

            if (this.impelYOnTop)
            {
                axisalignedbb = axisalignedbb.offset(0.0D, 0.02D, 0.0D);
            }

            for (Entity entity2 : getEntitiesWithinAABB(world, axisalignedbb, this.affectOnlyPlayers))
            {
                entity2.motionY = (double)this.impelY;
            }
        }

        if (this.impelX != 0.0F || this.impelZ != 0.0F)
        {
            AxisAlignedBB axisalignedbb1 = this.bb.offset(0.0D, 0.02D, 0.0D);

            if (this.impelXZOnSides)
            {
                axisalignedbb1 = axisalignedbb1.expand(0.02D, 0.0D, 0.02D);
            }

            for (Entity entity3 : getEntitiesWithinAABB(world, axisalignedbb1, this.affectOnlyPlayers))
            {
                if (this.impelType == BoundingBox.ImpelType.MOVE)
                {
                    moveEntity(entity3, (double)this.impelX, 0.0D, (double)this.impelZ);
                }
                else if (this.impelType == BoundingBox.ImpelType.VELOCITY)
                {
                    if (this.impelX != 0.0F)
                    {
                        entity3.motionX += (double)this.impelX;
                    }

                    if (this.impelZ != 0.0F)
                    {
                        entity3.motionZ += (double)this.impelZ;
                    }
                }
            }
        }
    }

    public void edit(ByteMap map)
    {
        if (map.containsKey("c"))
        {
            this.bb = read(map.getLongArray("c"));
            this.moveProgress = 0;
        }
        else if (map.containsKey("#c"))
        {
            this.transformingFrom = this.bb;
            this.transformingTo = read(map.getLongArray("#c"));
            this.moveProgress = this.moveTicks = map.getInt("at");
            AxisAlignedBB axisalignedbb = this.transformingTo;

            if (Math.abs(this.bb.maxX - this.bb.minX - (axisalignedbb.maxX - axisalignedbb.minX)) < 0.001D && Math.abs(this.bb.maxY - this.bb.minY - (axisalignedbb.maxY - axisalignedbb.minY)) < 0.001D && Math.abs(this.bb.maxZ - this.bb.minZ - (axisalignedbb.maxZ - axisalignedbb.minZ)) < 0.001D)
            {
                this.moveOffsetX = axisalignedbb.maxX - this.bb.maxX;
                this.moveOffsetY = axisalignedbb.maxY - this.bb.maxY;
                this.moveOffsetZ = axisalignedbb.maxZ - this.bb.maxZ;
                this.moving = true;
            }
            else
            {
                this.moving = false;
            }

            this.dynamic = true;
        }

        this.impelX = map.getFloat("ix", this.impelX);
        this.impelY = map.getFloat("iy", this.impelY);
        this.impelZ = map.getFloat("iz", this.impelZ);
        this.impelYOnTop = map.getBoolean("iyot", this.impelYOnTop);
        this.impelXZOnSides = map.getBoolean("ixzos", this.impelYOnTop);
        this.impelType = (BoundingBox.ImpelType)map.getStringEnum("it", this.impelType);
        this.drag = map.getBoolean("drag", this.drag);
    }

    public boolean isDynamic()
    {
        return this.dynamic;
    }

    public boolean isMoving()
    {
        return this.moveProgress > 0 && this.moving;
    }

    public boolean hasImpel()
    {
        return this.impelX != 0.0F || this.impelY != 0.0F || this.impelZ != 0.0F;
    }

    public boolean isTicking()
    {
        return this.isDynamic() || this.hasImpel();
    }

    public int hashCode()
    {
        return this.id;
    }

    private static double lerp(double progress, double start, double finish)
    {
        return start + progress * (finish - start);
    }

    private static AxisAlignedBB read(long[] coords)
    {
        return new AxisAlignedBB(Double.longBitsToDouble(coords[0]), Double.longBitsToDouble(coords[1]), Double.longBitsToDouble(coords[2]), Double.longBitsToDouble(coords[3]), Double.longBitsToDouble(coords[4]), Double.longBitsToDouble(coords[5]));
    }

    public static void unstuckFromBox(Entity entity, AxisAlignedBB bb)
    {
        AxisAlignedBB axisalignedbb = entity.getEntityBoundingBox();
        TreeMap<Double, Runnable> treemap = new TreeMap();

        if (axisalignedbb.maxX > bb.minX)
        {
            treemap.put(Double.valueOf(Math.abs(axisalignedbb.maxX - bb.minX)), () ->
            {
                moveEntity(entity, bb.minX - ebb.maxX, 0.0D, 0.0D);
            });
        }

        if (axisalignedbb.minX < bb.maxX)
        {
            treemap.put(Double.valueOf(Math.abs(axisalignedbb.minX - bb.maxX)), () ->
            {
                moveEntity(entity, bb.maxX - ebb.minX, 0.0D, 0.0D);
            });
        }

        if (axisalignedbb.maxY > bb.minY)
        {
            treemap.put(Double.valueOf(Math.abs(axisalignedbb.maxY - bb.minY)), () ->
            {
                moveEntity(entity, 0.0D, bb.minY - ebb.maxY, 0.0D);
            });
        }

        if (axisalignedbb.minY < bb.maxY)
        {
            treemap.put(Double.valueOf(Math.abs(axisalignedbb.minY - bb.maxY)), () ->
            {
                moveEntity(entity, 0.0D, bb.maxY - ebb.minY, 0.0D);
            });
        }

        if (axisalignedbb.maxZ > bb.minZ)
        {
            treemap.put(Double.valueOf(Math.abs(axisalignedbb.maxZ - bb.minZ)), () ->
            {
                moveEntity(entity, 0.0D, 0.0D, bb.minZ - ebb.maxZ);
            });
        }

        if (axisalignedbb.minZ < bb.maxZ)
        {
            treemap.put(Double.valueOf(Math.abs(axisalignedbb.minZ - bb.maxZ)), () ->
            {
                moveEntity(entity, 0.0D, 0.0D, bb.maxZ - ebb.minZ);
            });
        }

        ((Runnable)treemap.firstEntry().getValue()).run();
    }

    private static void moveEntity(Entity entity, double dx, double dy, double dz)
    {
        boolean boolean = entity.onGround && dy == 0.0D;
        entity.moveEntity(dx, dy, dz);

        if (boolean)
        {
            entity.isCollidedVertically = true;
            entity.isCollided = true;
            entity.onGround = true;
        }
    }

    private static List<Entity> getEntitiesWithinAABB(World world, AxisAlignedBB aabb, boolean onlyPlayers)
    {
        if (onlyPlayers)
        {
            EntityPlayerSP entityplayersp = Minecraft.getMinecraft().thePlayer;
            return entityplayersp.getEntityBoundingBox().intersectsWith(aabb) ? Collections.singletonList(entityplayersp) : Collections.emptyList();
        }
        else
        {
            int int = MathHelper.floor_double((aabb.minX - 2.0D) / 16.0D);
            int int = MathHelper.floor_double((aabb.maxX + 2.0D) / 16.0D);
            int int = MathHelper.floor_double((aabb.minZ - 2.0D) / 16.0D);
            int int = MathHelper.floor_double((aabb.maxZ + 2.0D) / 16.0D);
            List<Entity> list = Lists.<Entity>newArrayList();

            for (int int = int; int <= int; ++int)
            {
                for (int int = int; int <= int; ++int)
                {
                    if (world.getChunkProvider().chunkExists(int, int))
                    {
                        Chunk chunk = world.getChunkFromChunkCoords(int, int);
                        ClassInheritanceMultiMap<Entity>[] classinheritancemultimap = chunk.getEntityLists();
                        int int = MathHelper.floor_double((aabb.minY - 2.0D) / 16.0D);
                        int int = MathHelper.floor_double((aabb.maxY + 2.0D) / 16.0D);
                        int = MathHelper.clamp_int(int, 0, classinheritancemultimap.length - 1);
                        int = MathHelper.clamp_int(int, 0, classinheritancemultimap.length - 1);

                        for (int int = int; int <= int; ++int)
                        {
                            for (Entity entity : classinheritancemultimap[int])
                            {
                                if (entity.getEntityBoundingBox().intersectsWith(aabb))
                                {
                                    list.add(entity);
                                }
                            }
                        }
                    }
                }
            }

            return list;
        }
    }

    public static enum ImpelType
    {
        MOVE,
        VELOCITY;
    }
}
