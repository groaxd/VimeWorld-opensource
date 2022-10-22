package net.xtrafrancyz.mods.minidot.items.head;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class KiwiHat extends BaseItem
{
    private final MModelRenderer Hat;

    public KiwiHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Hat.Shape1", 0, 22);
        this.setTextureOffset("Hat.Shape2", 0, 22);
        this.setTextureOffset("Hat.Shape3", 0, 22);
        this.setTextureOffset("Hat.Shape4", 0, 22);
        this.setTextureOffset("Hat.Shape5", 49, 0);
        this.setTextureOffset("Hat.Shape6", 49, 0);
        this.setTextureOffset("Hat.Shape7", 0, 0);
        this.setTextureOffset("Hat.Shape8", 0, 0);
        this.setTextureOffset("Hat.Shape9", 0, 0);
        this.setTextureOffset("Hat.Shape10", 40, 0);
        this.setTextureOffset("Hat.Shape11", 31, 22);
        this.setTextureOffset("Hat.Shape12", 31, 22);
        this.setTextureOffset("Hat.Shape13", 0, 22);
        this.setTextureOffset("Hat.Shape14", 0, 24);
        this.setTextureOffset("Hat.Shape15", 0, 22);
        this.setTextureOffset("Hat.Shape16", 0, 22);
        this.setTextureOffset("Hat.Shape17", 0, 22);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -3.0F, -24.0F, 4.0F, 1, 3, 1);
        this.Hat.addBox("Shape2", -4.0F, -21.0F, 0.0F, 3, 1, 6);
        this.Hat.addBox("Shape3", -4.0F, -21.0F, -2.0F, 1, 1, 2);
        this.Hat.addBox("Shape4", -2.0F, -21.0F, -2.0F, 1, 1, 2);
        this.Hat.addBox("Shape5", -4.0F, -25.0F, 3.0F, 3, 1, 3);
        this.Hat.addBox("Shape6", 1.0F, -25.0F, 3.0F, 3, 1, 3);
        this.Hat.addBox("Shape7", -4.0F, -34.0F, -2.0F, 8, 9, 10);
        this.Hat.addBox("Shape8", 4.0F, -31.0F, 0.0F, 2, 4, 9);
        this.Hat.addBox("Shape9", -6.0F, -31.0F, 0.0F, 2, 4, 9);
        this.Hat.addBox("Shape10", -3.0F, -30.0F, -8.0F, 6, 5, 6);
        this.Hat.addBox("Shape11", -4.0F, -29.0F, -7.0F, 1, 3, 3);
        this.Hat.addBox("Shape12", 3.0F, -29.0F, -7.0F, 1, 3, 3);
        this.Hat.addBox("Shape13", -1.0F, -25.0F, -7.5F, 2, 5, 2);
        this.Hat.addBox("Shape14", 2.0F, -24.0F, 4.0F, 1, 3, 1);
        this.Hat.addBox("Shape15", 1.0F, -21.0F, 0.0F, 3, 1, 6);
        this.Hat.addBox("Shape16", 1.0F, -21.0F, -2.0F, 1, 1, 2);
        this.Hat.addBox("Shape17", 3.0F, -21.0F, -2.0F, 1, 1, 2);
        this.setTexture(new ResourceLocation("minidot", "head/kiwi.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.4F, 0.4F, 0.4F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.7F, 0.0F);
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        super.renderAsItem(time);
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.WHITE + "\u0418\u0437 \u0438\u0433\u0440\u044b: " + EnumChatFormatting.BOLD + "Crossy Road");
    }

    public String getName()
    {
        return "\u041a\u0438\u0432\u0438";
    }
}
