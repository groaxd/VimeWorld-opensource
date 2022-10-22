package net.minecraft.entity.ai.attributes;

import java.util.UUID;
import net.xtrafrancyz.covered.ObfValue;

public class ObfAttributeModifier extends AttributeModifier
{
    private final ObfValue.ODouble amount;
    private final ObfValue.OInteger operation;

    public ObfAttributeModifier(UUID p_i24_1_, String p_i24_2_, double p_i24_3_, int p_i24_5_)
    {
        super(p_i24_1_, p_i24_2_, p_i24_3_, p_i24_5_);
        this.amount = new ObfValue.ODouble(p_i24_3_);
        this.operation = new ObfValue.OInteger(p_i24_5_);
    }

    public double getAmount()
    {
        return this.amount.get();
    }

    public int getOperation()
    {
        return this.operation.get();
    }
}
