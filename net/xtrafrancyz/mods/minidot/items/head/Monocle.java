package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class Monocle extends BaseItem
{
    private final MModelRenderer Piece1;

    public Monocle()
    {
        super(ItemType.HEAD);
        this.textureWidth = 8;
        this.textureHeight = 8;
        this.setTextureOffset("Piece1.Shape1", 0, 3);
        this.setTextureOffset("Piece1.Shape2", 0, 0);
        this.setTextureOffset("Piece1.Shape3", 0, 0);
        this.setTextureOffset("Piece1.Shape4", 0, 0);
        this.setTextureOffset("Piece1.Shape5", 0, 0);
        this.setTextureOffset("Piece1.Shape6", 0, 0);
        this.setTextureOffset("Piece1.Shape7", 0, 0);
        this.Piece1 = new MModelRenderer(this, "Piece1");
        this.Piece1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.setRotation(this.Piece1, 0.0F, 0.0F, 0.0F);
        this.Piece1.mirror = true;
        this.Piece1.addBox("Shape1", 1.0F, -4.0F, -4.1F, 2, 2, 0);
        this.Piece1.addBox("Shape2", 1.0F, -5.0F, -4.5F, 2, 1, 1);
        this.Piece1.addBox("Shape3", 4.0F, -5.0F, -3.0F, 1, 1, 1);
        this.Piece1.addBox("Shape4", 1.0F, -2.0F, -4.5F, 2, 1, 1);
        this.Piece1.addBox("Shape5", 4.0F, -4.0F, -4.0F, 1, 1, 1);
        this.Piece1.addBox("Shape6", 3.0F, -4.0F, -4.5F, 1, 2, 1);
        this.Piece1.addBox("Shape7", 0.0F, -4.0F, -4.5F, 1, 2, 1);
        this.setTexture(new ResourceLocation("minidot", "head/monocle.png"));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        GlStateManager.translate(0.0F, 0.0F, -0.02F);
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.07F + (float)number) * 20.0F, 0.0F, 0.2F, 0.0F);
        GlStateManager.translate(-0.15F, -0.15F, 0.2F);
    }

    public String getName()
    {
        return "\u041c\u043e\u043d\u043e\u043a\u043b\u044c";
    }

    public String getCreator()
    {
        return "Ursun";
    }
}
