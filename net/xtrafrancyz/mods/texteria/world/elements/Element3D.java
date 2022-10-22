package net.xtrafrancyz.mods.texteria.world.elements;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.AxisAlignedBB;
import net.xtrafrancyz.mods.texteria.Texteria;
import net.xtrafrancyz.mods.texteria.elements.Element;
import net.xtrafrancyz.mods.texteria.world.Visibility3D;
import net.xtrafrancyz.util.ByteMap;

public abstract class Element3D extends Element
{
    public float distanceSquaredToPlayer;
    public float renderDistanceSquared;
    public long finishTime;
    public long startTime = Texteria.time;
    public int finishFade;
    public int startFade;
    public AxisAlignedBB boundingBox;
    public boolean hover = false;
    public int hoverRangeSquared;
    public boolean hoverable;
    public boolean frustumDisabled;
    public Visibility3D visibility;
    protected final RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();

    public Element3D(ByteMap params)
    {
        super(params.getString("id"));
        this.finishTime = this.startTime + params.getLong("dur", 432000000L);

        if (params.containsKey("fade"))
        {
            this.finishFade = this.startFade = params.getInt("fade");
        }
        else
        {
            this.startFade = params.getInt("fade.s", 255);
            this.finishFade = params.getInt("fade.f", 255);
        }

        this.renderDistanceSquared = (float)square(params.getInt("rndrDist", 64));
        this.hoverable = params.getBoolean("hv", false);

        if (this.hoverable)
        {
            this.hoverRangeSquared = square(params.getInt("hr", 10));
        }

        this.frustumDisabled = !params.getBoolean("fe", true);

        if (params.containsKey("vis"))
        {
            this.visibility = new Visibility3D(params.getMapArray("vis"));
        }
    }

    public boolean isInViewRange()
    {
        return this.distanceSquaredToPlayer < this.renderDistanceSquared;
    }

    public boolean isVisible(Frustum frustum)
    {
        if (this.visibility != null)
        {
            boolean flag = false;

            for (Visibility3D.Selector visibility3d$selector : this.visibility.selectors)
            {
                if (visibility3d$selector.acceptable(Minecraft.getMinecraft(), this))
                {
                    flag = visibility3d$selector.show;
                }
            }

            if (!flag)
            {
                return false;
            }
        }

        return this.frustumDisabled || frustum.isBoundingBoxInFrustum(this.boundingBox);
    }

    public void invisibleTick(long time)
    {
    }

    public void revalidateBB(long time)
    {
    }

    public void remove()
    {
        if (this.finishTime > Texteria.time + (long)this.finishFade)
        {
            this.finishTime = Texteria.time + (long)this.finishFade;
        }
    }

    public void calcDistanceSquaredToPlayer()
    {
        this.distanceSquaredToPlayer = (float)(square(this.renderManager.viewerPosX - (this.boundingBox.maxX + this.boundingBox.minX) / 2.0D) + square(this.renderManager.viewerPosY - (this.boundingBox.maxY + this.boundingBox.minY) / 2.0D) + square(this.renderManager.viewerPosZ - (this.boundingBox.maxZ + this.boundingBox.minZ) / 2.0D));
    }

    protected static int square(int num)
    {
        return num * num;
    }

    protected static float square(float num)
    {
        return num * num;
    }

    protected static double square(double num)
    {
        return num * num;
    }

    public boolean mouseClick(int button)
    {
        return false;
    }

    public boolean mouseWheel(int dwheel)
    {
        return false;
    }
}
