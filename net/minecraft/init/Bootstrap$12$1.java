package net.minecraft.init;

import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

class Bootstrap$12$1 extends BehaviorProjectileDispense
{
    Bootstrap$12$1(Object p_i46468_1_, ItemStack p_i46468_2_)
    {
        this.field_150837_c = p_i46468_1_;
        this.field_150836_b = p_i46468_2_;
    }

    /**
     * Return the projectile entity spawned by this dispense behavior.
     */
    protected IProjectile getProjectileEntity(World worldIn, IPosition position)
    {
        return new EntityPotion(worldIn, position.getX(), position.getY(), position.getZ(), this.field_150836_b.copy());
    }

    protected float func_82498_a()
    {
        return super.func_82498_a() * 0.5F;
    }

    protected float func_82500_b()
    {
        return super.func_82500_b() * 1.25F;
    }
}
