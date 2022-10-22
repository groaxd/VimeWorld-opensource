package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class CupheadPet extends BasePet
{
    private final MModelRenderer Legs;
    private final MModelRenderer Legs2;
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bone3;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer Head;
    private final MModelRenderer bone9;

    public CupheadPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Legs = new MModelRenderer(this);
        this.Legs.setRotationPoint(-3.0F, 24.0F, 0.0F);
        this.Legs.setTextureOffset(0, 49).addBox(0.0F, -3.0F, 0.0F, 4, 3, 4, 0.0F);
        this.Legs.setTextureOffset(0, 5).addBox(0.0F, -2.0F, -3.0F, 4, 2, 3, 0.0F);
        this.Legs2 = new MModelRenderer(this);
        this.Legs2.setRotationPoint(6.0F, 0.0F, 0.0F);
        this.Legs.addChild(this.Legs2);
        this.Legs2.setTextureOffset(40, 44).addBox(-1.0F, -3.0F, 0.0F, 4, 3, 4, 0.0F);
        this.Legs2.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -3.0F, 4, 2, 3, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, -3.0F, 1.0F);
        this.Legs.addChild(this.bone);
        this.bone.setTextureOffset(40, 51).addBox(1.0F, -4.0F, 0.0F, 2, 4, 2, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(7.0F, -3.0F, 1.0F);
        this.Legs.addChild(this.bone2);
        this.bone2.setTextureOffset(32, 50).addBox(-1.0F, -4.0F, 0.0F, 2, 4, 2, 0.0F);
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.Legs.addChild(this.bone3);
        this.bone3.setTextureOffset(16, 50).addBox(-3.0F, -8.0F, 0.0F, 4, 1, 4, 0.0F);
        this.bone3.setTextureOffset(44, 8).addBox(2.0F, -8.0F, 0.0F, 4, 1, 4, 0.0F);
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.Legs.addChild(this.bone4);
        this.bone4.setTextureOffset(28, 30).addBox(-4.0F, -12.0F, -1.0F, 11, 4, 6, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.Legs.addChild(this.bone5);
        this.bone5.setTextureOffset(0, 24).addBox(-4.0F, -18.0F, -1.0F, 11, 6, 6, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone5.addChild(this.bone6);
        this.bone6.setTextureOffset(40, 40).addBox(-9.0F, -16.0F, 1.0F, 5, 2, 2, 0.0F);
        this.bone6.setTextureOffset(0, 10).addBox(7.0F, -16.0F, 1.0F, 5, 2, 2, 0.0F);
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone6.addChild(this.bone7);
        this.bone7.setTextureOffset(54, 54).addBox(-9.0F, -14.0F, 1.0F, 2, 3, 2, 0.0F);
        this.bone7.setTextureOffset(52, 42).addBox(10.0F, -14.0F, 1.0F, 2, 3, 2, 0.0F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone6.addChild(this.bone8);
        this.bone8.setTextureOffset(44, 0).addBox(-9.0F, -11.0F, 0.0F, 4, 4, 4, 0.0F);
        this.bone8.setTextureOffset(28, 40).addBox(8.0F, -11.0F, 0.0F, 4, 4, 4, 0.0F);
        this.Head = new MModelRenderer(this);
        this.Head.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.Legs.addChild(this.Head);
        this.Head.setTextureOffset(0, 0).addBox(-6.0F, -28.0F, -5.0F, 15, 10, 14, 0.0F);
        this.Head.setTextureOffset(28, 26).addBox(-6.0F, -29.0F, -5.0F, 15, 1, 1, 0.0F);
        this.Head.setTextureOffset(28, 24).addBox(-6.0F, -29.0F, 8.0F, 15, 1, 1, 0.0F);
        this.Head.setTextureOffset(14, 37).addBox(8.0F, -29.0F, -4.0F, 1, 1, 12, 0.0F);
        this.Head.setTextureOffset(0, 36).addBox(-6.0F, -29.0F, -4.0F, 1, 1, 12, 0.0F);
        this.Head.setTextureOffset(14, 44).addBox(9.0F, -22.0F, 1.0F, 4, 2, 2, 0.0F);
        this.Head.setTextureOffset(48, 51).addBox(11.0F, -25.0F, 1.0F, 2, 3, 2, 0.0F);
        this.Head.setTextureOffset(0, 42).addBox(9.0F, -27.0F, 1.0F, 4, 2, 2, 0.0F);
        this.Head.setTextureOffset(14, 36).addBox(6.0F, -34.0F, 6.0F, 2, 6, 2, 0.0F);
        this.Head.setTextureOffset(0, 36).addBox(6.0F, -34.0F, 8.0F, 2, 2, 4, 0.0F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.Legs.addChild(this.bone9);
        this.bone9.setTextureOffset(54, 49).addBox(0.5F, -24.5F, -7.0F, 2, 2, 2, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/cuphead.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.05F;
        GlStateManager.translate(0.65F, -0.55F + f, 0.3F);
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
        GlStateManager.translate(0.0F, -0.2F, 0.0F);
        super.renderAsItem(time);
    }

    public String getCreator()
    {
        return "GetoGdeto";
    }

    public String getName()
    {
        return "\u041a\u0430\u043f\u0445\u0435\u0434";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Cuphead");
    }
}
