package net.minecraft.client.renderer;

import java.util.concurrent.Callable;
import net.minecraft.client.gui.ScaledResolution;

class EntityRenderer$4 implements Callable<String>
{
    EntityRenderer$4(EntityRenderer p_i46417_1_, ScaledResolution p_i46417_2_)
    {
        this.field_181047_b = p_i46417_1_;
        this.field_181046_a = p_i46417_2_;
    }

    public String call() throws Exception
    {
        return String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", new Object[] {Integer.valueOf(this.field_181046_a.getScaledWidth()), Integer.valueOf(this.field_181046_a.getScaledHeight()), Integer.valueOf(EntityRenderer.access$000(this.field_181047_b).displayWidth), Integer.valueOf(EntityRenderer.access$000(this.field_181047_b).displayHeight), Integer.valueOf(this.field_181046_a.getScaleFactor())});
    }
}
