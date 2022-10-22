package net.xtrafrancyz.mods.minidot.items.head;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class BearHat extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Piece1;
    private String color;

    public BearHat(String color)
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 16;
        this.color = color;

        if (Piece1 == null)
        {
            this.setTextureOffset("Piece1.Shape10", 0, 0);
            this.setTextureOffset("Piece1.Shape1", 15, 0);
            this.setTextureOffset("Piece1.Shape2", 0, 10);
            this.setTextureOffset("Piece1.Shape3", 0, 0);
            this.setTextureOffset("Piece1.Shape4", 0, 0);
            this.setTextureOffset("Piece1.Shape5", 0, 0);
            this.setTextureOffset("Piece1.Shape6", 0, 0);
            this.setTextureOffset("Piece1.Shape7", 0, 0);
            this.setTextureOffset("Piece1.Shape8", 0, 0);
            this.setTextureOffset("Piece1.Shape9", 0, 6);
            Piece1 = new MModelRenderer(this, "Piece1");
            Piece1.addBox("Shape10", 2.0F, -21.0F, -1.0F, 2, 2, 1);
            Piece1.addBox("Shape1", -3.0F, -20.0F, -2.0F, 6, 10, 5);
            Piece1.addBox("Shape2", -3.0F, -14.0F, -3.0F, 6, 4, 1);
            Piece1.addBox("Shape3", 2.0F, -12.0F, -4.0F, 2, 2, 2);
            Piece1.addBox("Shape4", -5.0F, -16.0F, -1.0F, 2, 2, 2);
            Piece1.addBox("Shape5", -4.0F, -12.0F, -4.0F, 2, 2, 2);
            Piece1.addBox("Shape6", -4.0F, -21.0F, -1.0F, 2, 2, 1);
            Piece1.addBox("Shape7", 3.0F, -16.0F, -1.0F, 2, 2, 2);
            Piece1.addBox("Shape8", -1.0F, -12.0F, 3.0F, 2, 2, 1);
            Piece1.addBox("Shape9", -2.0F, -17.0F, -3.0F, 4, 2, 1);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        GlStateManager.translate(0.0F, -0.225F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.45F, 0.0F);
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case 106432986:
                if (s.equals("panda"))
                {
                    b0 = 2;
                }

                break;

            case 113101865:
                if (s.equals("white"))
                {
                    b0 = 1;
                }

                break;

            case 288046763:
                if (s.equals("grizzly"))
                {
                    b0 = 0;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0413\u0440\u0438\u0437\u043b\u0438";

            case 1:
                return "\u0411\u0435\u043b\u044b\u0439";

            case 2:
                return "\u041f\u0430\u043d\u0434\u0430";

            default:
                return "\u0425\u0443\u0439";
        }
    }

    public List<String> getDescription()
    {
        return MNaming.fromMult("\u041c\u044b \u043e\u0431\u044b\u0447\u043d\u044b\u0435 \u043c\u0435\u0434\u0432\u0435\u0434\u0438");
    }

    public String getCreator()
    {
        return "ANACTAC";
    }

    static
    {
        colors.put("grizzly", new ResourceLocation("minidot", "head/bearhat1.png"));
        colors.put("white", new ResourceLocation("minidot", "head/bearhat2.png"));
        colors.put("panda", new ResourceLocation("minidot", "head/bearhat3.png"));
    }
}
