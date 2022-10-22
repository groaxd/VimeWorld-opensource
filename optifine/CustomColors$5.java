package optifine;

import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;
import optifine.CustomColors.IColorizer;

final class CustomColors$5 implements IColorizer
{
    public int getColor(IBlockAccess p_getColor_1_, BlockPos p_getColor_2_)
    {
        BiomeGenBase biomegenbase = CustomColors.getColorBiome(p_getColor_1_, p_getColor_2_);
        return CustomColors.access$400() != null ? CustomColors.access$400().getColor(biomegenbase, p_getColor_2_) : biomegenbase.waterColorMultiplier;
    }

    public boolean isColorConstant()
    {
        return false;
    }
}
