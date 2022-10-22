package net.xtrafrancyz.mods.minidot.items.head;

import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class CrownIceKingHat extends BaseItem
{
    private final MModelRenderer Hat;

    public CrownIceKingHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("Hat.Shape1", 0, 0);
        this.setTextureOffset("Hat.Shape2", 0, 0);
        this.setTextureOffset("Hat.Shape3", 0, 0);
        this.setTextureOffset("Hat.Shape4", 0, 0);
        this.setTextureOffset("Hat.Shape5", 0, 0);
        this.setTextureOffset("Hat.Shape6", 0, 0);
        this.setTextureOffset("Hat.Shape7", 0, 0);
        this.setTextureOffset("Hat.Shape8", 0, 0);
        this.setTextureOffset("Hat.Shape9", 0, 0);
        this.setTextureOffset("Hat.Shape10", 0, 0);
        this.setTextureOffset("Hat.Shape11", 0, 0);
        this.setTextureOffset("Hat.Shape12", 0, 0);
        this.setTextureOffset("Hat.Shape13", 0, 0);
        this.setTextureOffset("Hat.Shape14", 0, 0);
        this.setTextureOffset("Hat.Shape15", 0, 0);
        this.setTextureOffset("Hat.Shape16", 0, 0);
        this.setTextureOffset("Hat.Shape17", 0, 0);
        this.setTextureOffset("Hat.Shape18", 0, 0);
        this.setTextureOffset("Hat.Shape19", 0, 0);
        this.setTextureOffset("Hat.Shape20", 22, 0);
        this.setTextureOffset("Hat.Shape21", 26, 0);
        this.setTextureOffset("Hat.Shape22", 30, 0);
        this.Hat = new MModelRenderer(this, "Hat");
        this.Hat.addBox("Shape1", -5.0F, -10.0F, -5.0F, 10, 4, 1);
        this.Hat.addBox("Shape2", -5.0F, -10.0F, 4.0F, 10, 4, 1);
        this.Hat.addBox("Shape3", 4.0F, -10.0F, -4.0F, 1, 4, 8);
        this.Hat.addBox("Shape4", -5.0F, -10.0F, -4.0F, 1, 4, 8);
        this.Hat.addBox("Shape5", 4.0F, -11.0F, -1.0F, 1, 1, 2);
        this.Hat.addBox("Shape6", -5.0F, -11.0F, -1.0F, 1, 1, 2);
        this.Hat.addBox("Shape7", -1.0F, -11.0F, 4.0F, 2, 1, 1);
        this.Hat.addBox("Shape8", 4.0F, -11.0F, 3.0F, 1, 1, 2);
        this.Hat.addBox("Shape9", -5.0F, -11.0F, 3.0F, 1, 1, 2);
        this.Hat.addBox("Shape10", 3.0F, -11.0F, 4.0F, 1, 1, 1);
        this.Hat.addBox("Shape11", -4.0F, -11.0F, 4.0F, 1, 1, 1);
        this.Hat.addBox("Shape12", 4.0F, -12.0F, -5.0F, 1, 2, 1);
        this.Hat.addBox("Shape13", -5.0F, -11.0F, -4.0F, 1, 1, 1);
        this.Hat.addBox("Shape14", 3.0F, -11.0F, -5.0F, 1, 1, 1);
        this.Hat.addBox("Shape15", 4.0F, -11.0F, -4.0F, 1, 1, 1);
        this.Hat.addBox("Shape16", -5.0F, -12.0F, -5.0F, 1, 2, 1);
        this.Hat.addBox("Shape17", -4.0F, -11.0F, -5.0F, 1, 1, 1);
        this.Hat.addBox("Shape18", -2.0F, -12.0F, -5.0F, 4, 2, 1);
        this.Hat.addBox("Shape19", -1.0F, -13.0F, -5.0F, 2, 1, 1);
        this.Hat.addBox("Shape20", -4.0F, -9.0F, -6.0F, 1, 2, 1);
        this.Hat.addBox("Shape21", 3.0F, -9.0F, -6.0F, 1, 2, 1);
        this.Hat.addBox("Shape22", -1.0F, -11.0F, -6.0F, 2, 3, 1);
        this.setTexture(new ResourceLocation("minidot", "head/crown_ik.png"));
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.15F, 0.0F);
        super.renderAsItem(time);
    }

    public List<String> getDescription()
    {
        return MNaming.fromMult("\u0412\u0440\u0435\u043c\u044f \u041f\u0440\u0438\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u0439");
    }

    public String getName()
    {
        return "\u041b\u0435\u0434\u044f\u043d\u0430\u044f \u043a\u043e\u0440\u043e\u043d\u0430";
    }
}
