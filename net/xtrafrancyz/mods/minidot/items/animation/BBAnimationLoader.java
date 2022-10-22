package net.xtrafrancyz.mods.minidot.items.animation;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResource;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDot;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import org.apache.logging.log4j.Level;

public class BBAnimationLoader
{
    private final Map<String, IAnimation> animations = new HashMap();

    public BBAnimationLoader(ResourceLocation location)
    {
        try
        {
            IResource iresource = Minecraft.getMinecraft().getResourceManager().getResource(location);
            this.read((new JsonParser()).parse((Reader)(new InputStreamReader(iresource.getInputStream(), StandardCharsets.UTF_8))).getAsJsonObject());
        }
        catch (Exception exception)
        {
            MiniDot.log.log(Level.WARN, (String)("Could not load animation " + location), (Throwable)exception);
        }
    }

    private void read(JsonObject json)
    {
        JsonPrimitive jsonprimitive = json.getAsJsonPrimitive("format_version");

        if (jsonprimitive.isNumber() && jsonprimitive.getAsInt() == 1)
        {
            for (Entry<String, JsonElement> entry1 : json.getAsJsonObject("animations").entrySet())
            {
                this.animations.put(entry1.getKey(), new BBVimeAnimation((String)entry1.getKey(), ((JsonElement)entry1.getValue()).getAsJsonObject()));
            }
        }
        else if (jsonprimitive.isString() && jsonprimitive.getAsString().equals("1.8.0"))
        {
            for (Entry<String, JsonElement> entry : json.getAsJsonObject("animations").entrySet())
            {
                this.animations.put(entry.getKey(), new BBAnimation((String)entry.getKey(), ((JsonElement)entry.getValue()).getAsJsonObject()));
            }
        }
        else
        {
            throw new IllegalArgumentException("Unsupported version");
        }
    }

    public IAnimation mustGet(String name, BaseItem item)
    {
        IAnimation ianimation = (IAnimation)this.animations.get(name);

        if (ianimation == null)
        {
            throw new IllegalArgumentException("Animation " + name + " is not found");
        }
        else
        {
            return ianimation.bind(item);
        }
    }
}
