package net.xtrafrancyz.mods.minidot.items.body;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class BackPack extends BaseItem
{
    private final MModelRenderer bone;
    private final MModelRenderer bone2;
    private final MModelRenderer bb_main;
    private final String color;

    public BackPack(String color)
    {
        super(ItemType.BODY);
        this.color = color;
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bone2.setTextureOffset(4, 16).addBox(-3.0F, -14.3F, -4.3F, 1, 5, 1, 0.0F);
        this.bone2.setTextureOffset(0, 16).addBox(2.0F, -14.3F, -4.3F, 1, 5, 1, 0.0F);
        this.bone2.setTextureOffset(19, 22).addBox(-3.7F, -10.3F, -4.3F, 1, 3, 1, 0.0F);
        this.bone2.setTextureOffset(7, 21).addBox(2.7F, -10.3F, -4.3F, 1, 3, 1, 0.0F);
        this.bone2.setTextureOffset(15, 23).addBox(-4.3F, -8.3F, -4.3F, 1, 2, 1, 0.0F);
        this.bone2.setTextureOffset(22, 7).addBox(3.3F, -8.3F, -4.3F, 1, 2, 1, 0.0F);
        this.bone2.setTextureOffset(23, 0).addBox(-4.3F, -7.3F, -3.3F, 1, 1, 1, 0.0F);
        this.bone2.setTextureOffset(23, 23).addBox(3.3F, -7.3F, -3.3F, 1, 1, 1, 0.0F);
        this.bone2.setTextureOffset(14, 4).addBox(-3.0F, -14.3F, -3.3F, 1, 1, 3, 0.0F);
        this.bone2.setTextureOffset(14, 0).addBox(2.0F, -14.3F, -3.3F, 1, 1, 3, 0.0F);
        this.bone2.setTextureOffset(11, 22).addBox(-3.0F, -14.3F, -0.7F, 1, 3, 1, 0.0F);
        this.bone2.setTextureOffset(0, 22).addBox(2.0F, -14.3F, -0.7F, 1, 3, 1, 0.0F);
        this.bone2.setTextureOffset(18, 20).addBox(-1.0F, -12.3F, -0.7F, 2, 1, 1, 0.0F);
        this.bone2.setTextureOffset(14, 20).addBox(-4.3F, -6.3F, -3.3F, 1, 1, 2, 0.0F);
        this.bone2.setTextureOffset(19, 0).addBox(3.3F, -6.3F, -3.3F, 1, 1, 2, 0.0F);
        this.bone2.setTextureOffset(19, 4).addBox(-4.3F, -5.3F, -2.3F, 1, 1, 2, 0.0F);
        this.bone2.setTextureOffset(16, 17).addBox(3.3F, -5.3F, -2.3F, 1, 1, 2, 0.0F);
        this.bone2.setTextureOffset(20, 17).addBox(-4.3F, -5.3F, -0.7F, 2, 1, 1, 0.0F);
        this.bone2.setTextureOffset(20, 11).addBox(2.3F, -5.3F, -0.7F, 2, 1, 1, 0.0F);
        this.bone2.setTextureOffset(12, 17).addBox(2.4F, -7.3F, 0.3F, 1, 4, 1, 0.0F);
        this.bone2.setTextureOffset(8, 16).addBox(-3.4F, -7.3F, 0.3F, 1, 4, 1, 0.0F);
        this.bone2.setTextureOffset(13, 9).addBox(-2.0F, -3.7F, 0.3F, 4, 1, 1, 0.0F);
        this.bb_main = new MModelRenderer(this);
        this.bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.bb_main.setTextureOffset(0, 0).addBox(-3.0F, -12.0F, 0.0F, 6, 9, 1, 0.0F);
        this.bb_main.setTextureOffset(0, 10).addBox(-3.0F, -8.0F, 0.8F, 6, 5, 1, 0.0F);
        this.bb_main.setTextureOffset(14, 14).addBox(-2.0F, -11.0F, 0.3F, 4, 2, 1, 0.0F);
        this.bb_main.setTextureOffset(14, 11).addBox(-1.0F, -10.0F, 0.2F, 2, 2, 1, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "body/backpack_" + color + ".png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.translate(0.0F, -0.65F, 0.15F);
        GlStateManager.scale(1.05F, 1.05F, 1.05F);
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(MathHelper.sin(rotation * 0.06F + (float)number * 0.5F) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, -0.4F, 0.5F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -1008851410:
                if (s.equals("orange"))
                {
                    b0 = 2;
                }

                break;

            case 112785:
                if (s.equals("red"))
                {
                    b0 = 3;
                }

                break;

            case 3027034:
                if (s.equals("blue"))
                {
                    b0 = 0;
                }

                break;

            case 93818879:
                if (s.equals("black"))
                {
                    b0 = 1;
                }

                break;

            case 98619139:
                if (s.equals("green"))
                {
                    b0 = 4;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0421\u0438\u043d\u0438\u0439 \u0440\u044e\u043a\u0437\u0430\u043a";

            case 1:
                return "\u0427\u0435\u0440\u043d\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a";

            case 2:
                return "\u041e\u0440\u0430\u043d\u0436\u0435\u0432\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a";

            case 3:
                return "\u041a\u0440\u0430\u0441\u043d\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a";

            case 4:
                return "\u0417\u0435\u043b\u0435\u043d\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a";

            default:
                return "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a";
        }
    }

    public String getCreator()
    {
        return "Edwaite & Wenston";
    }
}
