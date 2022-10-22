package net.minecraft.client.resources;

import com.google.common.base.Charsets;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractResourcePack implements IResourcePack
{
    private static final Logger resourceLog = LogManager.getLogger();
    public final File resourcePackFile;
    private static final String[] transparent = new String[] {"redstone_block", "redstone_dust_cross", "redstone_dust_cross_overlay", "redstone_dust_line", "redstone_dust_line_overlay", "nether_wart_stage_0", "nether_wart_stage_1", "nether_wart_stage_2", "double_plant_sunflower_back", "double_plant_sunflower_bottom", "double_plant_sunflower_front", "double_plant_sunflower_top", "double_plant_paeonia_bottom", "double_plant_paeonia_top", "water_flow", "water_still", "glass_pane_top", "glass_pane_top_black", "glass_pane_top_blue", "glass_pane_top_brown", "glass_pane_top_cyan", "glass_pane_top_gray", "glass_pane_top_green", "glass_pane_top_light_blue", "glass_pane_top_lime", "glass_pane_top_magenta", "glass_pane_top_orange", "glass_pane_top_pink", "glass_pane_top_purple", "glass_pane_top_red", "glass_pane_top_silver", "glass_pane_top_white", "glass_pane_top_yellow", "leaves_acacia", "leaves_acacia_opaque", "leaves_big_oak", "leaves_big_oak_opaque", "double_plant_fern_bottom", "double_plant_fern_top", "double_plant_paeonia_bootom", "double_plant_paeonia_top", "double_plant_grass_bottom", "double_plant_grass_top", "double_plant_rose_bottom", "double_plant_rose_top", "double_plant_sunflower_back", "double_plant_sunflower_bottom", "double_plant_sunflower_front", "double_plant_sundlower_top", "double_plant_syringa_bottom", "double_plant_syringa_top", "flower_houstonia", "flower_oxeye_daisy", "flower_rose", "glass_black", "glass_blue", "glass_brown", "glass_cyan", "glass_gray", "glass_green", "glass_light_blue", "glass_lime", "glass_pink", "glass_purple", "glass_red", "glass_silver", "glass_white", "glass_yellow", "glass_magenta", "glass_orange", "glass_pane_top", "glass_pane_top_black", "flower_blue_orchid", "acacia_sapling", "flower_dandelion", "dark_oak_sapling", "flower_allium", "flower_paeonia", "flower_tulip_orange", "flower_tulip_pink", "flower_tulip_red", "flower_tulip_white", "iron_bars", "rail_(?:activator|activator_powered|detector|detector_powered|golden|golden_powered|normal|normal_turned)", "anvil_(?:top(?:_damaged_[1-2])?|base)", "bed_(?:feet|head)_(?:end|side|top)", "brewing_stand", "cactus_(?:bottom|side|top)", "cake_(?:bottom|inner|side|top)", "carrots_stage_[0-3]", "cauldron_(?:bottom|inner|side|top)", "cocoa_stage_[0-2]", "deadbush", "destroy_stage_[0-9]", "detectorRail", "door_(?:iron|wood)_(?:lower|upper)", "fenceIron", "fern", "fire_layer_[0-1]", "flower(?:_(?:pot|dandelion|rose))?", "glass", "goldenRail(?:_powered)?", "grass_side_overlay", "hopper_top", "ice", "ladder", "lava", "lava_flow", "leaves_(?:birch|birch_opaque|jungle|jungle_opaque|oak|oak_opaque|spruce|spruce_opaque)?", "lever", "mob_spawner", "mushroom_(?:brown|red)", "netherStalk_[0-2]", "portal", "potatoes_stage_[0-3]", "redstoneDust(?:_(?:cross|line)(_overlay))?", "redstone_torch(?:_(?:on|off))?", "trip_wire(?:_source)?", "reeds", "sapling(?:_(?:oak|birch|jungle|spruce|acacia|roofed_oak))?", "stem_(?:bent|straight)", "tallgrass", "thinglass_top", "torch_on", "trapdoor", "tripWire(?:Source)?", "vine", "water", "water_flow", "waterlily", "wheat_stage_[0-7]", "melon_stem_(?:connected|disconnected)?", "pumpkin_stem_(?:connected|disconnected)?", "nether_wa rt_stage_[0-2]", "web"};
    private static final Set<String> transparentNames = new HashSet();
    private static final List<Pattern> transparentCompiled = new ArrayList();
    private static final Set<String> disallowOverride = new HashSet();

    public AbstractResourcePack(File resourcePackFileIn)
    {
        this.resourcePackFile = resourcePackFileIn;
    }

    private static String locationToName(ResourceLocation location)
    {
        return String.format("%s/%s/%s", new Object[] {"assets", location.getResourceDomain(), location.getResourcePath()});
    }

    protected static String getRelativeName(File p_110595_0_, File p_110595_1_)
    {
        return p_110595_0_.toURI().relativize(p_110595_1_.toURI()).getPath();
    }

    public InputStream getInputStream(ResourceLocation location) throws IOException
    {
        String s = locationToName(location);
        return filterStream(location, s, this.getInputStreamByName(s));
    }

    public boolean resourceExists(ResourceLocation location)
    {
        return this.hasResourceName(locationToName(location));
    }

    protected abstract InputStream getInputStreamByName(String name) throws IOException;

    protected abstract boolean hasResourceName(String name);

    protected void logNameNotLowercase(String p_110594_1_)
    {
        resourceLog.warn("ResourcePack: ignored non-lowercase namespace: %s in %s", new Object[] {p_110594_1_, this.resourcePackFile});
    }

    public static InputStream filterStream(ResourceLocation p_filterStream_0_, String p_filterStream_1_, InputStream p_filterStream_2_) throws IOException
    {
        try
        {
            p_filterStream_1_ = p_filterStream_1_.replace('\\', '/');

            if (p_filterStream_1_.endsWith(".png") && p_filterStream_1_.contains("assets/minecraft/textures/blocks/"))
            {
                String s = p_filterStream_1_.substring(p_filterStream_1_.lastIndexOf(47) + 1, p_filterStream_1_.lastIndexOf(".png"));

                if (transparentNames.contains(s))
                {
                    return p_filterStream_2_;
                }
                else
                {
                    for (Pattern pattern : transparentCompiled)
                    {
                        if (pattern.matcher(s).matches())
                        {
                            return p_filterStream_2_;
                        }
                    }

                    BufferedImage bufferedimage = ImageIO.read(p_filterStream_2_);
                    int k = bufferedimage.getWidth();
                    int i = bufferedimage.getHeight();
                    int[] aint = bufferedimage.getRGB(0, 0, k, i, (int[])null, 0, k);

                    for (int j = 0; j < aint.length; ++j)
                    {
                        aint[j] |= -16777216;
                    }

                    bufferedimage.setRGB(0, 0, k, i, aint, 0, k);
                    ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                    ImageIO.write(bufferedimage, "png", (OutputStream)bytearrayoutputstream);
                    return new ByteArrayInputStream(bytearrayoutputstream.toByteArray());
                }
            }
            else
            {
                return disallowOverride.contains(p_filterStream_1_) ? Minecraft.getMinecraft().getResourcePackRepository().rprDefaultResourcePack.getInputStream(p_filterStream_0_) : p_filterStream_2_;
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
    }

    public <T extends IMetadataSection> T getPackMetadata(IMetadataSerializer p_135058_1_, String p_135058_2_) throws IOException
    {
        return readMetadata(p_135058_1_, this.getInputStreamByName("pack.mcmeta"), p_135058_2_);
    }

    static <T extends IMetadataSection> T readMetadata(IMetadataSerializer p_110596_0_, InputStream p_110596_1_, String p_110596_2_)
    {
        JsonObject jsonobject = null;
        BufferedReader bufferedreader = null;

        try
        {
            bufferedreader = new BufferedReader(new InputStreamReader(p_110596_1_, Charsets.UTF_8));
            jsonobject = (new JsonParser()).parse((Reader)bufferedreader).getAsJsonObject();
        }
        catch (RuntimeException runtimeexception)
        {
            throw new JsonParseException(runtimeexception);
        }
        finally
        {
            IOUtils.closeQuietly((Reader)bufferedreader);
        }

        return p_110596_0_.parseMetadataSection(p_110596_2_, jsonobject);
    }

    public BufferedImage getPackImage() throws IOException
    {
        return TextureUtil.readBufferedImage(this.getInputStreamByName("pack.png"));
    }

    public String getPackName()
    {
        return this.resourcePackFile.getName();
    }

    static
    {
        for (int i = 0; i < transparent.length; ++i)
        {
            if (!transparent[i].contains("(") && !transparent[i].contains("["))
            {
                transparentNames.add(transparent[i]);
            }
            else
            {
                transparentCompiled.add(Pattern.compile("^" + transparent[i] + "$"));
            }
        }

        disallowOverride.add("assets/minecraft/blockstates/stone.json");
        disallowOverride.add("assets/minecraft/blockstates/dirt.json");
        disallowOverride.add("assets/minecraft/blockstates/gravel.json");
        disallowOverride.add("assets/minecraft/blockstates/granite.json");
        disallowOverride.add("assets/minecraft/blockstates/sand.json");
        disallowOverride.add("assets/minecraft/blockstates/red_sand.json");
        disallowOverride.add("assets/minecraft/blockstates/cobblestone.json");
        disallowOverride.add("assets/minecraft/blockstates/grass.json");
        disallowOverride.add("assets/minecraft/blockstates/andesite.json");
        disallowOverride.add("assets/minecraft/blockstates/diorite.json");
        disallowOverride.add("assets/minecraft/blockstates/netherrack.json");
        disallowOverride.add("assets/minecraft/blockstates/podzol.json");
        disallowOverride.add("assets/minecraft/models/block/cube.json");
        disallowOverride.add("assets/minecraft/models/block/cube_mirrored.json");
        disallowOverride.add("assets/minecraft/models/block/cube_all.json");
        disallowOverride.add("assets/minecraft/models/block/cube_mirrored_all.json");
        disallowOverride.add("assets/minecraft/models/block/grass.json");
        disallowOverride.add("assets/minecraft/models/block/grass_normal.json");
        disallowOverride.add("assets/minecraft/models/block/grass_snowed.json");
        disallowOverride.add("assets/minecraft/models/block/stairs.json");
        disallowOverride.add("assets/minecraft/models/block/stone.json");
        disallowOverride.add("assets/minecraft/models/block/stone_mirrored.json");
        disallowOverride.add("assets/minecraft/models/block/andesite.json");
        disallowOverride.add("assets/minecraft/models/block/andesite_smooth.json");
        disallowOverride.add("assets/minecraft/models/block/diorite.json");
        disallowOverride.add("assets/minecraft/models/block/diorite_smooth.json");
        disallowOverride.add("assets/minecraft/models/block/red_sand.json");
        disallowOverride.add("assets/minecraft/models/block/sand.json");
        disallowOverride.add("assets/minecraft/models/block/dirt.json");
        disallowOverride.add("assets/minecraft/models/block/podzol.json");
        disallowOverride.add("assets/minecraft/models/block/granite.json");
        disallowOverride.add("assets/minecraft/models/block/granite_smooth.json");
        disallowOverride.add("assets/minecraft/models/block/gravel.json");
        disallowOverride.add("assets/minecraft/models/block/cobblestone.json");
        disallowOverride.add("assets/minecraft/models/block/bedrock.json");
        disallowOverride.add("assets/minecraft/models/block/sandstone_all.json");
        disallowOverride.add("assets/minecraft/models/block/sandstone_normal.json");
        disallowOverride.add("assets/minecraft/models/block/coal_block.json");
        disallowOverride.add("assets/minecraft/models/block/coal_ore.json");
        disallowOverride.add("assets/minecraft/models/block/gold_block.json");
        disallowOverride.add("assets/minecraft/models/block/gold_ore.json");
        disallowOverride.add("assets/minecraft/models/block/iron_block.json");
        disallowOverride.add("assets/minecraft/models/block/iron_ore.json");
        disallowOverride.add("assets/minecraft/models/block/lapis_block.json");
        disallowOverride.add("assets/minecraft/models/block/lapis_ore.json");
        disallowOverride.add("assets/minecraft/models/block/elerald_ore.json");
        disallowOverride.add("assets/minecraft/models/block/elerald_block.json");
        disallowOverride.add("assets/minecraft/models/block/diamond_block.json");
        disallowOverride.add("assets/minecraft/models/block/diamond_ore.json");
        disallowOverride.add("assets/minecraft/models/block/quartz_ore.json");
        disallowOverride.add("assets/minecraft/models/block/redstone_ore.json");
        disallowOverride.add("assets/minecraft/models/block/redstone_block.json");
        disallowOverride.add("assets/minecraft/models/block/mossy_cobblestone.json");
        disallowOverride.add("assets/minecraft/models/block/orientable.json");
        disallowOverride.add("assets/minecraft/models/block/orientable_vertical.json");
    }
}
