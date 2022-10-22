package shadersmod.client;

import java.io.InputStream;

public class ShaderPackDefault implements IShaderPack
{
    public void close()
    {
    }

    public InputStream getResourceAsStream(String resName)
    {
        return null;
    }

    public String getName()
    {
        return Shaders.packNameDefault;
    }

    public boolean hasDirectory(String name)
    {
        return false;
    }
}
