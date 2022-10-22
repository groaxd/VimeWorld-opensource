package net.xtrafrancyz.mods.texteria.sound;

import com.google.common.collect.Lists;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import net.minecraft.client.resources.FallbackResourceManager;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.SimpleResource;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;

public class TSoundResourceManager extends FallbackResourceManager
{
    private TexteriaSound sound;

    public TSoundResourceManager(TexteriaSound sound)
    {
        super((IMetadataSerializer)null);
        this.sound = sound;
    }

    public IResource getResource(ResourceLocation location) throws IOException
    {
        String s = location.getResourcePath();

        if (s.startsWith("file:"))
        {
            return this.makeResource(location, new FileInputStream(this.sound.getLocalFile(location)));
        }
        else
        {
            throw new FileNotFoundException(location.toString());
        }
    }

    private IResource makeResource(ResourceLocation location, InputStream is)
    {
        return new SimpleResource("TexteriaSound", location, is, (InputStream)null, (IMetadataSerializer)null);
    }

    public List<IResource> getAllResources(ResourceLocation location) throws IOException
    {
        IResource iresource = this.getResource(location);

        if (iresource == null)
        {
            throw new FileNotFoundException(location.toString());
        }
        else
        {
            return Lists.newArrayList(new IResource[] {iresource});
        }
    }

    protected InputStream getInputStream(ResourceLocation location, IResourcePack resourcePack) throws IOException
    {
        throw new IllegalStateException("Not implemented");
    }
}
