package net.xtrafrancyz.mods.texteria;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.MathHelper;
import net.xtrafrancyz.mods.texteria.world.aabb.BoundingBox;

public class PlayerCollisionTickHandler
{
    public static void tick()
    {
        if (TexteriaOptions.playerCollisionBoxes > 0)
        {
            EntityPlayerSP entityplayersp = Minecraft.getMinecraft().thePlayer;
            WorldClient worldclient = Minecraft.getMinecraft().theWorld;

            if (worldclient != null)
            {
                for (Entity entity : worldclient.getEntitiesInAABBexcluding(entityplayersp, entityplayersp.getEntityBoundingBox(), Predicates.and(EntitySelectors.NOT_SPECTATING, (entity) ->
            {
                return entity instanceof EntityOtherPlayerMP;
            })))
                {
                    BoundingBox.unstuckFromBox(entityplayersp, entityplayersp.getCollisionBox(entity));
                }
            }
        }

        if (TexteriaOptions.playerCollisionVelocity == 2)
        {
            EntityPlayerSP entityplayersp1 = Minecraft.getMinecraft().thePlayer;
            WorldClient worldclient1 = Minecraft.getMinecraft().theWorld;

            if (worldclient1 != null)
            {
                for (Entity entity1 : worldclient1.getEntitiesInAABBexcluding(entityplayersp1, entityplayersp1.getEntityBoundingBox().expand(0.05D, 0.0D, 0.05D), Predicates.and(EntitySelectors.NOT_SPECTATING, (entity) ->
            {
                return entity instanceof EntityOtherPlayerMP;
            })))
                {
                    double d0 = entity1.posX - entityplayersp1.posX;
                    double d1 = entity1.posZ - entityplayersp1.posZ;
                    double d2 = MathHelper.abs_max(d0, d1);

                    if (d2 >= 0.009999999776482582D)
                    {
                        d2 = (double)MathHelper.sqrt_double(d2);
                        d0 = d0 / d2;
                        d1 = d1 / d2;
                        double d3 = 1.0D / d2;

                        if (d3 > 1.0D)
                        {
                            d3 = 1.0D;
                        }

                        d0 = d0 * d3;
                        d1 = d1 * d3;
                        d0 = d0 * 0.15000000074505807D;
                        d1 = d1 * 0.15000000074505807D;
                        d0 = d0 * (double)(1.0F - entityplayersp1.entityCollisionReduction);
                        d1 = d1 * (double)(1.0F - entityplayersp1.entityCollisionReduction);

                        if (entityplayersp1.riddenByEntity == null)
                        {
                            entityplayersp1.addVelocity(-d0, 0.2D, -d1);
                        }

                        if (entity1.riddenByEntity == null)
                        {
                            entity1.addVelocity(d0, 0.2D, d1);
                        }
                    }
                }
            }
        }
    }
}
