package net.minecraft.client.renderer;

import java.util.concurrent.Callable;
import org.lwjgl.input.Mouse;

class EntityRenderer$3 implements Callable<String>
{
    EntityRenderer$3(EntityRenderer p_i46418_1_, int p_i46418_2_, int p_i46418_3_)
    {
        this.field_90028_b = p_i46418_1_;
        this.field_181048_a = p_i46418_2_;
        this.field_181049_b = p_i46418_3_;
    }

    public String call() throws Exception
    {
        return String.format("Scaled: (%d, %d). Absolute: (%d, %d)", new Object[] {Integer.valueOf(this.field_181048_a), Integer.valueOf(this.field_181049_b), Integer.valueOf(Mouse.getX()), Integer.valueOf(Mouse.getY())});
    }
}
