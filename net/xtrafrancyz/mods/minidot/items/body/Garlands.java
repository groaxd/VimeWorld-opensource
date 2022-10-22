package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Garlands extends BaseItem
{
    public static final ResourceLocation[] RGB = new ResourceLocation[] {new ResourceLocation("minidot", "body/garlands1.png"), new ResourceLocation("minidot", "body/garlands2.png"), new ResourceLocation("minidot", "body/garlands3.png")};
    public static final ResourceLocation[] CMYK = new ResourceLocation[] {new ResourceLocation("minidot", "body/garlands4.png"), new ResourceLocation("minidot", "body/garlands5.png"), new ResourceLocation("minidot", "body/garlands6.png")};
    private final MModelRenderer Front;
    private final MModelRenderer Back;
    private final ResourceLocation[] tex;

    public Garlands(ResourceLocation[] tex)
    {
        super(ItemType.BODY);
        this.tex = tex;
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.setTextureOffset("Front.1a", 0, 0);
        this.setTextureOffset("Front.1b", 8, 0);
        this.setTextureOffset("Front.2a", 0, 8);
        this.setTextureOffset("Front.2b", 8, 8);
        this.setTextureOffset("Front.3a", 0, 0);
        this.setTextureOffset("Front.3b", 8, 0);
        this.setTextureOffset("Front.4a", 0, 0);
        this.setTextureOffset("Front.4b", 8, 0);
        this.setTextureOffset("Front.5a", 0, 8);
        this.setTextureOffset("Front.5b", 8, 8);
        this.setTextureOffset("Front.6a", 0, 16);
        this.setTextureOffset("Front.6b", 8, 16);
        this.setTextureOffset("Front.7a", 0, 0);
        this.setTextureOffset("Front.7b", 8, 0);
        this.setTextureOffset("Front.8a", 0, 0);
        this.setTextureOffset("Front.8b", 8, 0);
        this.setTextureOffset("Front.9a", 0, 16);
        this.setTextureOffset("Front.9b", 8, 16);
        this.setTextureOffset("Front.10a", 0, 16);
        this.setTextureOffset("Front.10b", 8, 16);
        this.setTextureOffset("Front.11a", 0, 8);
        this.setTextureOffset("Front.11b", 8, 8);
        this.setTextureOffset("Front.12a", 0, 8);
        this.setTextureOffset("Front.12b", 8, 8);
        this.setTextureOffset("Front.13a", 0, 16);
        this.setTextureOffset("Front.13b", 8, 16);
        this.setTextureOffset("Back.1a", 0, 8);
        this.setTextureOffset("Back.1b", 8, 8);
        this.setTextureOffset("Back.2a", 0, 16);
        this.setTextureOffset("Back.2b", 8, 16);
        this.setTextureOffset("Back.3a", 0, 8);
        this.setTextureOffset("Back.3b", 8, 8);
        this.setTextureOffset("Back.4a", 0, 8);
        this.setTextureOffset("Back.4b", 8, 8);
        this.setTextureOffset("Back.5a", 0, 16);
        this.setTextureOffset("Back.5b", 8, 16);
        this.setTextureOffset("Back.6a", 0, 0);
        this.setTextureOffset("Back.6b", 8, 0);
        this.setTextureOffset("Back.7a", 0, 8);
        this.setTextureOffset("Back.7b", 8, 8);
        this.setTextureOffset("Back.8a", 0, 8);
        this.setTextureOffset("Back.8b", 8, 8);
        this.setTextureOffset("Back.9a", 0, 0);
        this.setTextureOffset("Back.9b", 8, 0);
        this.setTextureOffset("Back.10a", 0, 0);
        this.setTextureOffset("Back.10b", 8, 0);
        this.setTextureOffset("Back.11a", 0, 16);
        this.setTextureOffset("Back.11b", 8, 16);
        this.setTextureOffset("Back.12a", 0, 16);
        this.setTextureOffset("Back.12b", 8, 16);
        this.setTextureOffset("Back.13a", 0, 0);
        this.setTextureOffset("Back.13b", 8, 0);
        this.Front = new MModelRenderer(this, "Front");
        this.Front.setRotationPoint(0.0F, 18.0F, -6.0F);
        this.Front.addBox("1a", -9.0F, 2.0F, -3.0F, 2, 2, 2);
        this.Front.addBox("1b", -10.0F, 1.0F, -4.0F, 4, 4, 4);
        this.Front.addBox("2a", 7.0F, -13.0F, -3.0F, 2, 2, 2);
        this.Front.addBox("2b", 6.0F, -14.0F, -4.0F, 4, 4, 4);
        this.Front.addBox("3a", 9.0F, -17.0F, -3.0F, 2, 2, 2);
        this.Front.addBox("3b", 8.0F, -18.0F, -4.0F, 4, 4, 4);
        this.Front.addBox("4a", 9.0F, 13.0F, -3.0F, 2, 2, 2);
        this.Front.addBox("4b", 8.0F, 12.0F, -4.0F, 4, 4, 4);
        this.Front.addBox("5a", 1.0F, 9.0F, -3.0F, 2, 2, 2);
        this.Front.addBox("5b", 0.0F, 8.0F, -4.0F, 4, 4, 4);
        this.Front.addBox("6a", -7.0F, 6.0F, -3.0F, 2, 2, 2);
        this.Front.addBox("6b", -8.0F, 5.0F, -4.0F, 4, 4, 4);
        this.Front.addBox("7a", -3.0F, 8.0F, -3.0F, 2, 2, 2);
        this.Front.addBox("7b", -4.0F, 7.0F, -4.0F, 4, 4, 4);
        this.Front.addBox("8a", 5.0F, -9.0F, -3.0F, 2, 2, 2);
        this.Front.addBox("8b", 4.0F, -10.0F, -4.0F, 4, 4, 4);
        this.Front.addBox("9a", -7.0F, -4.0F, -3.0F, 2, 2, 2);
        this.Front.addBox("9b", -8.0F, -5.0F, -4.0F, 4, 4, 4);
        this.Front.addBox("10a", 1.0F, -7.0F, -3.0F, 2, 2, 2);
        this.Front.addBox("10b", 0.0F, -8.0F, -4.0F, 4, 4, 4);
        this.Front.addBox("11a", -3.0F, -6.0F, -3.0F, 2, 2, 2);
        this.Front.addBox("11b", -4.0F, -7.0F, -4.0F, 4, 4, 4);
        this.Front.addBox("12a", -11.0F, -2.0F, -3.0F, 2, 2, 2);
        this.Front.addBox("12b", -12.0F, -3.0F, -4.0F, 4, 4, 4);
        this.Front.addBox("13a", 5.0F, 11.0F, -3.0F, 2, 2, 2);
        this.Front.addBox("13b", 4.0F, 10.0F, -4.0F, 4, 4, 4);
        this.Back = new MModelRenderer(this, "Back");
        this.Back.setRotationPoint(0.0F, 18.0F, 6.0F);
        this.Back.addBox("1a", -9.0F, 2.0F, 1.0F, 2, 2, 2);
        this.Back.addBox("1b", -10.0F, 1.0F, 0.0F, 4, 4, 4);
        this.Back.addBox("2a", 7.0F, -13.0F, 1.0F, 2, 2, 2);
        this.Back.addBox("2b", 6.0F, -14.0F, 0.0F, 4, 4, 4);
        this.Back.addBox("3a", 9.0F, -17.0F, 1.0F, 2, 2, 2);
        this.Back.addBox("3b", 8.0F, -18.0F, 0.0F, 4, 4, 4);
        this.Back.addBox("4a", 9.0F, 13.0F, 1.0F, 2, 2, 2);
        this.Back.addBox("4b", 8.0F, 12.0F, 0.0F, 4, 4, 4);
        this.Back.addBox("5a", 1.0F, 9.0F, 1.0F, 2, 2, 2);
        this.Back.addBox("5b", 0.0F, 8.0F, 0.0F, 4, 4, 4);
        this.Back.addBox("6a", -7.0F, 6.0F, 1.0F, 2, 2, 2);
        this.Back.addBox("6b", -8.0F, 5.0F, 0.0F, 4, 4, 4);
        this.Back.addBox("7a", -3.0F, 8.0F, 1.0F, 2, 2, 2);
        this.Back.addBox("7b", -4.0F, 7.0F, 0.0F, 4, 4, 4);
        this.Back.addBox("8a", 5.0F, -9.0F, 1.0F, 2, 2, 2);
        this.Back.addBox("8b", 4.0F, -10.0F, 0.0F, 4, 4, 4);
        this.Back.addBox("9a", -7.0F, -4.0F, 1.0F, 2, 2, 2);
        this.Back.addBox("9b", -8.0F, -5.0F, 0.0F, 4, 4, 4);
        this.Back.addBox("10a", 1.0F, -7.0F, 1.0F, 2, 2, 2);
        this.Back.addBox("10b", 0.0F, -8.0F, 0.0F, 4, 4, 4);
        this.Back.addBox("11a", -3.0F, -6.0F, 1.0F, 2, 2, 2);
        this.Back.addBox("11b", -4.0F, -7.0F, 0.0F, 4, 4, 4);
        this.Back.addBox("12a", -11.0F, -2.0F, 1.0F, 2, 2, 2);
        this.Back.addBox("12b", -12.0F, -3.0F, 0.0F, 4, 4, 4);
        this.Back.addBox("13a", 5.0F, 11.0F, 1.0F, 2, 2, 2);
        this.Back.addBox("13b", 4.0F, 10.0F, 0.0F, 4, 4, 4);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.33333F, 0.33333F, 0.33333F);

        if (player.getCurrentArmor(2) != null)
        {
            GlStateManager.scale(1.0F, 1.0F, 1.2F);
        }

        GlStateManager.translate(0.0F, 0.0F, -0.065F);
        float f = time % 27.0F;

        if (f > 18.0F)
        {
            this.setTexture(this.tex[0]);
        }
        else if (f > 9.0F)
        {
            this.setTexture(this.tex[1]);
        }
        else
        {
            this.setTexture(this.tex[2]);
        }
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 10.0F, 0.0F, 0.2F, 0.0F);
        GlStateManager.translate(0.0F, -0.4F, 0.3F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(-0.4F, 0.4F, 0.4F);
        GlStateManager.enableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        float f = time % 300.0F;

        if (f > 200.0F)
        {
            this.setTexture(this.tex[0]);
        }
        else if (f > 100.0F)
        {
            this.setTexture(this.tex[1]);
        }
        else
        {
            this.setTexture(this.tex[2]);
        }

        Minecraft.getMinecraft().getTextureManager().bindTexture(super.tex);
        this.Front.render(0.0625F);
        GlStateManager.disableBlend();
    }

    public String getName()
    {
        return "\u0413\u0438\u0440\u043b\u044f\u043d\u0434\u044b";
    }
}
