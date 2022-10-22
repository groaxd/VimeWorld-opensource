package net.xtrafrancyz.mods.minidot.items.mask;

import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;
import org.lwjgl.opengl.GL11;

public class GeometryDashNormalMask extends BaseItem
{
    private final MModelRenderer Normal;

    public GeometryDashNormalMask()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Normal = new MModelRenderer(this);
        this.Normal.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Normal.setTextureOffset(0, 11).addBox(-3.0F, -1.0F, -5.0F, 6, 1, 1, 0.0F);
        this.Normal.setTextureOffset(0, 9).addBox(-3.0F, -8.0F, -5.0F, 6, 1, 1, 0.0F);
        this.Normal.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, -5.0F, 8, 6, 1, 0.0F);
        this.Normal.setTextureOffset(0, 7).addBox(-3.0F, -2.5F, -5.1F, 6, 1, 1, 0.0F);
        this.Normal.setTextureOffset(15, 12).addBox(2.5F, -3.0F, -5.1F, 1, 1, 1, 0.0F);
        this.Normal.setTextureOffset(12, 15).addBox(-3.5F, -3.0F, -5.1F, 1, 1, 1, 0.0F);
        this.Normal.setTextureOffset(13, 10).addBox(0.5F, -5.0F, -5.1F, 3, 1, 1, 0.0F);
        this.Normal.setTextureOffset(6, 15).addBox(1.0F, -5.5F, -5.1F, 2, 1, 1, 0.0F);
        this.Normal.setTextureOffset(4, 17).addBox(3.0F, -7.35F, -5.35F, 1, 1, 1, -0.25F);
        this.Normal.setTextureOffset(0, 17).addBox(0.5F, -7.35F, -5.35F, 1, 1, 1, -0.25F);
        this.Normal.setTextureOffset(8, 13).addBox(0.75F, -7.6F, -5.35F, 3, 1, 1, -0.25F);
        this.Normal.setTextureOffset(0, 13).addBox(-3.75F, -7.6F, -5.35F, 3, 1, 1, -0.25F);
        this.Normal.setTextureOffset(15, 14).addBox(-1.5F, -7.35F, -5.35F, 1, 1, 1, -0.25F);
        this.Normal.setTextureOffset(15, 16).addBox(-4.0F, -7.35F, -5.35F, 1, 1, 1, -0.25F);
        this.Normal.setTextureOffset(0, 15).addBox(-3.0F, -5.5F, -5.1F, 2, 1, 1, 0.0F);
        this.Normal.setTextureOffset(13, 8).addBox(-3.5F, -5.0F, -5.1F, 3, 1, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "masks/gd_normal.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GL11.glTranslatef(0.0F, -1.5F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GL11.glTranslatef(0.0F, -1.45F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0421\u0440\u0435\u0434\u043d\u0438\u0439 \u0443\u0440\u043e\u0432\u0435\u043d\u044c";
    }

    public String getCreator()
    {
        return "xRolaaan";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Geometry Dash");
    }
}
