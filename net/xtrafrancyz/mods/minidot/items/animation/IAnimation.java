package net.xtrafrancyz.mods.minidot.items.animation;

import net.xtrafrancyz.mods.minidot.items.BaseItem;

public interface IAnimation
{
    void tickDelayed(float var1, float var2);

    void tick(float var1);

    boolean isFinished();

    void reset();

    void stop();

    IAnimation bind(BaseItem var1);
}
