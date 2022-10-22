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

public class GeometryDashDemonMask extends BaseItem
{
    private final MModelRenderer Demon;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;

    public GeometryDashDemonMask()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Demon = new MModelRenderer(this);
        this.Demon.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.Demon.setTextureOffset(0, 9).addBox(-3.0F, -1.0F, -5.0F, 6, 1, 1, 0.0F);
        this.Demon.setTextureOffset(0, 7).addBox(-3.0F, -8.0F, -5.0F, 6, 1, 1, 0.0F);
        this.Demon.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, -5.0F, 8, 6, 1, 0.0F);
        this.Demon.setTextureOffset(0, 11).addBox(-1.5F, -2.75F, -5.1F, 3, 2, 1, 0.0F);
        this.Demon.setTextureOffset(18, 3).addBox(-2.5F, -3.0F, -5.1F, 1, 2, 1, 0.0F);
        this.Demon.setTextureOffset(18, 0).addBox(1.5F, -3.0F, -5.1F, 1, 2, 1, 0.0F);
        this.Demon.setTextureOffset(18, 9).addBox(2.5F, -2.8F, -5.1F, 1, 1, 1, 0.0F);
        this.Demon.setTextureOffset(17, 6).addBox(-3.5F, -2.8F, -5.1F, 1, 1, 1, 0.0F);
        this.Demon.setTextureOffset(11, 16).addBox(0.85F, -5.1F, -5.2F, 2, 1, 1, -0.1F);
        this.Demon.setTextureOffset(18, 11).addBox(0.6F, -4.75F, -5.2F, 1, 1, 1, -0.1F);
        this.Demon.setTextureOffset(0, 17).addBox(1.75F, -5.5F, -5.1F, 2, 1, 1, 0.0F);
        this.Demon.setTextureOffset(13, 8).addBox(-2.85F, -5.1F, -5.2F, 2, 1, 1, -0.1F);
        this.Demon.setTextureOffset(10, 18).addBox(-1.6F, -4.75F, -5.2F, 1, 1, 1, -0.1F);
        this.Demon.setTextureOffset(13, 10).addBox(-3.75F, -5.5F, -5.1F, 2, 1, 1, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(-0.25F, 0.25F, 0.0F);
        this.Demon.addChild(this.bone);
        this.bone.setTextureOffset(6, 14).addBox(3.0F, -8.0F, -5.0F, 2, 2, 1, -0.2F);
        this.bone.setTextureOffset(0, 14).addBox(3.75F, -8.75F, -5.0F, 2, 2, 1, -0.2F);
        this.bone.setTextureOffset(16, 17).addBox(5.0F, -9.75F, -5.0F, 1, 2, 1, -0.2F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.25F, 0.25F, 0.0F);
        this.Demon.addChild(this.bone2);
        this.bone2.setTextureOffset(13, 13).addBox(-5.0F, -8.0F, -5.0F, 2, 2, 1, -0.2F);
        this.bone2.setTextureOffset(8, 11).addBox(-5.75F, -8.75F, -5.0F, 2, 2, 1, -0.2F);
        this.bone2.setTextureOffset(6, 17).addBox(-6.0F, -9.75F, -5.0F, 1, 2, 1, -0.2F);
        this.setTexture(new ResourceLocation("minidot", "masks/gd_demon.png"));
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
        return "\u0414\u0435\u043c\u043e\u043d";
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
