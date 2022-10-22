package net.xtrafrancyz.mods.texteria.world.particle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.client.particle.EntityFX;

public class ParticleList
{
    private final Set<Particle> particles = new LinkedHashSet();
    private Particle[] sortedVisible = new Particle[0];
    private boolean changed;
    private long lastDistanceValidation;

    public void add(Particle particle)
    {
        this.particles.add(particle);
        this.changed = true;
    }

    public void remove(Particle particle)
    {
        this.particles.remove(particle);
        this.changed = true;
    }

    public void clearNow()
    {
        this.particles.clear();
        this.sortedVisible = new Particle[0];
    }

    public int size()
    {
        return this.particles.size();
    }

    public Particle[] getSortedVisible(long time)
    {
        float f = (float)EntityFX.interpPosX;
        float f1 = (float)EntityFX.interpPosY;
        float f2 = (float)EntityFX.interpPosZ;

        if (!this.changed && time - this.lastDistanceValidation <= 1000L)
        {
            for (Particle particle1 : this.sortedVisible)
            {
                particle1.calcDistanceSquaredToPlayer(f, f1, f2);
            }
        }
        else
        {
            this.changed = false;
            this.lastDistanceValidation = time;
            List<Particle> list = new ArrayList(Math.max(10, this.sortedVisible.length + 10));
            Iterator<Particle> iterator = this.particles.iterator();

            while (iterator.hasNext())
            {
                Particle particle = (Particle)iterator.next();

                if (particle.deadline < time)
                {
                    iterator.remove();
                }
                else
                {
                    particle.calcDistanceSquaredToPlayer(f, f1, f2);

                    if (particle.distanceSquaredToPlayer < Math.max(particle.renderDistanceSquared, 10000))
                    {
                        list.add(particle);
                    }
                }
            }

            this.sortedVisible = (Particle[])list.toArray(new Particle[0]);
        }

        Arrays.sort(this.sortedVisible, (p1, p2) ->
        {
            return p2.distanceSquaredToPlayer - p1.distanceSquaredToPlayer;
        });
        return this.sortedVisible;
    }

    public Particle[] getCachedSortedVisible()
    {
        return this.sortedVisible;
    }
}
