package net.xtrafrancyz.mods.minidot.items.head;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class DeerHornsHat extends BaseItem
{
    private final MModelRenderer Shape1;
    private final MModelRenderer Shape4;
    private final MModelRenderer Shape2;
    private final MModelRenderer Shape3;
    private final MModelRenderer Shape12;
    private final MModelRenderer Shape32;
    private final MModelRenderer Shape42;
    private final MModelRenderer Shape22;

    public DeerHornsHat()
    {
        super(ItemType.HEAD);
        this.textureWidth = 32;
        this.textureHeight = 8;
        this.useDisplayLists = true;
        this.Shape12 = new MModelRenderer(this, 0, 0);
        this.Shape12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape12.addBox(4.5F, -6.0F, -0.5F, 9, 1, 1, 0.0F);
        this.setRotation(this.Shape12, 0.0F, -0.0F, -0.18587756F);
        this.Shape1 = new MModelRenderer(this, 0, 0);
        this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape1.addBox(4.5F, -6.0F, -0.5F, 9, 1, 1, 0.0F);
        this.setRotation(this.Shape1, (float)Math.PI, -0.0F, -2.9557152F);
        this.Shape42 = new MModelRenderer(this, 0, 0);
        this.Shape42.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape42.addBox(10.5F, 5.4F, -0.4998F, 3, 1, 1, 0.0F);
        this.setRotation(this.Shape42, 0.0F, -0.0F, -1.1697197F);
        this.Shape4 = new MModelRenderer(this, 0, 0);
        this.Shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape4.addBox(10.5F, 5.4F, -0.5002F, 3, 1, 1, 0.0F);
        this.setRotation(this.Shape4, (float)Math.PI, -0.0F, -1.9577358F);
        this.Shape3 = new MModelRenderer(this, 0, 0);
        this.Shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape3.addBox(9.0F, 2.1F, -0.5002F, 3, 1, 1, 0.0F);
        this.setRotation(this.Shape3, (float)Math.PI, -0.0F, -2.024582F);
        this.Shape2 = new MModelRenderer(this, 0, 0);
        this.Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape2.addBox(14.0F, 2.4F, -0.4998F, 5, 1, 1, 0.0F);
        this.setRotation(this.Shape2, (float)Math.PI, -0.0F, -2.3609068F);
        this.Shape32 = new MModelRenderer(this, 0, 0);
        this.Shape32.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape32.addBox(9.0F, 2.1F, -0.5002F, 3, 1, 1, 0.0F);
        this.setRotation(this.Shape32, 0.0F, -0.0F, -1.1150908F);
        this.Shape22 = new MModelRenderer(this, 0, 0);
        this.Shape22.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape22.addBox(14.0F, 2.4F, -0.4998F, 5, 1, 1, 0.0F);
        this.setRotation(this.Shape22, 0.0F, -0.0F, -0.7806858F);
        this.setTexture(new ResourceLocation("minidot", "head/deerhornshat.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(0.9F, 0.9F, 0.9F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(0.5F, 0.7F, 0.7F);
        GlStateManager.translate(0.0F, 0.15F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041e\u043b\u0435\u043d\u044c\u0438 \u0440\u043e\u0433\u0430";
    }
}
