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

public class SouthParkHat extends BaseItem
{
    private static final Map<String, ResourceLocation> colors = new HashMap();
    private static MModelRenderer Piece1;
    private String color;

    public SouthParkHat(String color)
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.color = color;

        if (Piece1 == null)
        {
            this.setTextureOffset("Piece1.Shape1", 0, 22);
            this.setTextureOffset("Piece1.Shape2", 0, 22);
            this.setTextureOffset("Piece1.Shape3", 0, 22);
            this.setTextureOffset("Piece1.Shape4", 0, 24);
            this.setTextureOffset("Piece1.Shape5", 0, 0);
            this.setTextureOffset("Piece1.Shape6", 0, 0);
            this.setTextureOffset("Piece1.Shape7", 0, 0);
            Piece1 = new MModelRenderer(this, "Piece1");
            Piece1.addBox("Shape1", -4.5F, -9.0F, -4.5F, 9, 1, 9);
            Piece1.addBox("Shape2", -4.0F, -10.0F, -4.5F, 8, 1, 9);
            Piece1.addBox("Shape3", -4.5F, -10.0F, -4.0F, 9, 1, 8);
            Piece1.addBox("Shape4", -3.5F, -10.5F, -3.5F, 7, 1, 7);
            Piece1.addBox("Shape5", -1.0F, -12.5F, -1.0F, 2, 2, 2);
            Piece1.addBox("Shape6", -5.0F, -8.0F, -4.5F, 10, 1, 9);
            Piece1.addBox("Shape7", -4.5F, -8.0F, -5.0F, 9, 1, 10);
        }

        this.setTexture((ResourceLocation)colors.get(color));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.01F, 1.01F, 1.01F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.2F, 0.0F);
        super.renderAsItem(time);
    }

    public List<String> getDescription()
    {
        return MNaming.fromMult("\u042e\u0436\u043d\u044b\u0439 \u041f\u0430\u0440\u043a");
    }

    public String getCreator()
    {
        return "BlackNT";
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -935481278:
                if (s.equals("kartman"))
                {
                    b0 = 0;
                }

                break;

            case 3540682:
                if (s.equals("sten"))
                {
                    b0 = 1;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0428\u0430\u043f\u043a\u0430 \u041a\u0430\u0440\u0442\u043c\u0430\u043d\u0430";

            case 1:
                return "\u0428\u0430\u043f\u043a\u0430 \u0421\u0442\u044d\u043d\u0430";

            default:
                return "\u0425\u0443\u0439";
        }
    }

    static
    {
        colors.put("kartman", new ResourceLocation("minidot", "head/sp_kartman.png"));
        colors.put("sten", new ResourceLocation("minidot", "head/sp_sten.png"));
    }
}
