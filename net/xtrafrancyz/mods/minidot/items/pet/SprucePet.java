package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class SprucePet extends BasePet
{
    final MModelRenderer Purple;
    final MModelRenderer Red;
    final MModelRenderer Yellow;
    final MModelRenderer Blue;
    final MModelRenderer Tree;
    final MModelRenderer Star;
    final MModelRenderer b3;
    final MModelRenderer b4;
    final MModelRenderer b8;

    public SprucePet()
    {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.setTextureOffset("Purple.p1", 0, 18);
        this.setTextureOffset("Purple.p2", 0, 18);
        this.setTextureOffset("Purple.p3", 0, 18);
        this.setTextureOffset("Purple.p4", 0, 18);
        this.setTextureOffset("Purple.p5", 0, 18);
        this.setTextureOffset("Purple.p6", 0, 18);
        this.setTextureOffset("Purple.p7", 0, 18);
        this.setTextureOffset("Red.r1", 5, 18);
        this.setTextureOffset("Red.r2", 5, 18);
        this.setTextureOffset("Red.r3", 5, 18);
        this.setTextureOffset("Red.r4", 5, 18);
        this.setTextureOffset("Red.r5", 5, 18);
        this.setTextureOffset("Red.r6", 5, 18);
        this.setTextureOffset("Red.r7", 5, 18);
        this.setTextureOffset("Yellow.y1", 10, 18);
        this.setTextureOffset("Yellow.y2", 10, 18);
        this.setTextureOffset("Yellow.y3", 10, 18);
        this.setTextureOffset("Yellow.y4", 10, 18);
        this.setTextureOffset("Yellow.y5", 10, 18);
        this.setTextureOffset("Yellow.y6", 10, 18);
        this.setTextureOffset("Yellow.y7", 10, 18);
        this.setTextureOffset("Blue.b1", 15, 18);
        this.setTextureOffset("Blue.b2", 15, 18);
        this.setTextureOffset("Blue.b5", 15, 18);
        this.setTextureOffset("Blue.b6", 15, 18);
        this.setTextureOffset("Blue.b7", 15, 18);
        this.setTextureOffset("Blue.b8", 15, 18);
        this.setTextureOffset("Blue.b9", 15, 18);
        this.setTextureOffset("Tree.Shape1", 2, 23);
        this.setTextureOffset("Tree.Shape2", 0, 0);
        this.setTextureOffset("Tree.Shape3", 0, 0);
        this.setTextureOffset("Tree.Shape4", 0, 0);
        this.setTextureOffset("Tree.Shape5", 0, 0);
        this.setTextureOffset("Tree.Shape6", 0, 0);
        this.setTextureOffset("Tree.Shape7", 0, 0);
        this.setTextureOffset("Tree.Shape8", 0, 0);
        this.setTextureOffset("Tree.Shape9", 0, 0);
        this.setTextureOffset("Tree.Shape10", 0, 0);
        this.setTextureOffset("Tree.Shape11", 0, 0);
        this.setTextureOffset("Tree.Shape12", 0, 0);
        this.setTextureOffset("Tree.Shape13", 0, 0);
        this.setTextureOffset("Tree.Shape14", 0, 0);
        this.setTextureOffset("Tree.Shape15", 0, 0);
        this.setTextureOffset("Tree.Shape16", 0, 0);
        this.setTextureOffset("Tree.Shape17", 0, 0);
        this.setTextureOffset("Tree.Shape18", 0, 0);
        this.setTextureOffset("Tree.Shape19", 0, 0);
        this.setTextureOffset("Tree.Shape20", 0, 0);
        this.setTextureOffset("Tree.Shape21", 0, 0);
        this.setTextureOffset("Tree.Shape22", 0, 0);
        this.setTextureOffset("Tree.Shape23", 0, 0);
        this.setTextureOffset("Tree.Shape24", 0, 0);
        this.setTextureOffset("Tree.Shape25", 0, 0);
        this.setTextureOffset("Tree.Shape26", 0, 0);
        this.setTextureOffset("Tree.Shape27", 0, 0);
        this.setTextureOffset("Tree.Shape28", 0, 0);
        this.setTextureOffset("Tree.Shape29", 0, 0);
        this.setTextureOffset("Tree.Shape30", 0, 0);
        this.setTextureOffset("Tree.Shape31", 0, 0);
        this.setTextureOffset("Tree.Shape32", 0, 0);
        this.setTextureOffset("Tree.Shape33", 0, 0);
        this.setTextureOffset("Tree.Shape34", 0, 0);
        this.setTextureOffset("Tree.Shape35", 0, 0);
        this.setTextureOffset("Tree.Shape36", 0, 0);
        this.setTextureOffset("Tree.Shape37", 0, 0);
        this.setTextureOffset("Tree.Shape38", 0, 0);
        this.setTextureOffset("Star.Shape39", 0, 13);
        this.setTextureOffset("Star.Shape40", 0, 13);
        this.setTextureOffset("Star.Shape41", 0, 13);
        this.Purple = new MModelRenderer(this, "Purple");
        this.Purple.addBox("p1", 1.0F, -11.0F, -3.0F, 1, 1, 1);
        this.Purple.addBox("p2", -3.0F, -7.0F, 0.0F, 1, 1, 1);
        this.Purple.addBox("p3", 1.0F, -8.0F, -2.0F, 1, 1, 1);
        this.Purple.addBox("p4", -5.0F, -1.01F, -1.0F, 1, 1, 1);
        this.Purple.addBox("p5", 3.0F, -3.0F, 1.0F, 1, 1, 1);
        this.Purple.addBox("p6", -1.0F, -4.0F, 2.0F, 1, 1, 1);
        this.Purple.addBox("p7", 2.0F, -9.0F, 1.0F, 1, 1, 1);
        this.Purple.scaleModifier = 1.005F;
        this.Red = new MModelRenderer(this, "Red");
        this.Red.addBox("r1", 1.0F, -5.0F, 2.0F, 1, 1, 1);
        this.Red.addBox("r2", 0.0F, -3.0F, -3.0F, 1, 1, 1);
        this.Red.addBox("r3", -1.0F, -7.0F, -3.0F, 1, 1, 1);
        this.Red.addBox("r4", -1.0F, -12.0F, -1.0F, 1, 1, 1);
        this.Red.addBox("r5", -3.0F, -11.0F, 0.0F, 1, 1, 1);
        this.Red.addBox("r6", -1.0F, -10.0F, 1.0F, 1, 1, 1);
        this.Red.addBox("r7", -4.0F, -2.0F, 0.0F, 1, 1, 1);
        this.Red.scaleModifier = 1.001F;
        this.Yellow = new MModelRenderer(this, "Yellow");
        this.Yellow.addBox("y1", 4.0F, -6.0F, 0.0F, 1, 1, 1);
        this.Yellow.addBox("y2", -1.0F, -5.0F, -2.0F, 1, 1, 1);
        this.Yellow.addBox("y3", -2.0F, -6.0F, -3.0F, 1, 1, 1);
        this.Yellow.addBox("y4", -1.0F, -13.0F, 0.0F, 1, 1, 1);
        this.Yellow.addBox("y5", 1.0F, -8.0F, 2.0F, 1, 1, 1);
        this.Yellow.addBox("y6", 3.0F, -11.0F, 1.0F, 1, 1, 1);
        this.Yellow.addBox("y7", 3.0F, -1.01F, 3.0F, 1, 1, 1);
        this.Yellow.scaleModifier = 1.001F;
        this.Blue = new MModelRenderer(this, "Blue");
        this.Blue.addBox("b1", 4.0F, -2.0F, -1.0F, 1, 1, 1);
        this.Blue.addBox("b2", 0.0F, -9.0F, -2.0F, 1, 1, 1);
        this.Blue.addBox("b5", -2.0F, -8.0F, -1.0F, 1, 1, 1);
        this.Blue.addBox("b6", -2.0F, -4.0F, 1.0F, 1, 1, 1);
        this.Blue.addBox("b7", 0.0F, -3.0F, 3.0F, 1, 1, 1);
        this.Blue.addBox("b9", 3.0F, -7.0F, 2.0F, 1, 1, 1);
        this.Blue.scaleModifier = 1.001F;
        this.Tree = new MModelRenderer(this, "Tree");
        this.Tree.addBox("Shape1", -0.5F, 0.0F, -0.5F, 2, 2, 2);
        this.Tree.addBox("Shape2", -2.0F, -1.0F, -4.0F, 1, 1, 9);
        this.Tree.addBox("Shape3", -1.0F, -1.0F, -5.0F, 3, 1, 11);
        this.Tree.addBox("Shape4", -3.0F, -1.0F, -3.0F, 1, 1, 7);
        this.Tree.addBox("Shape5", 5.0F, -1.0F, -1.0F, 1, 1, 3);
        this.Tree.addBox("Shape6", -4.0F, -1.0F, -2.0F, 1, 1, 5);
        this.Tree.addBox("Shape7", 2.0F, -1.0F, -4.0F, 1, 1, 9);
        this.Tree.addBox("Shape8", -5.0F, -1.0F, -1.0F, 1, 1, 3);
        this.Tree.addBox("Shape9", 4.0F, -1.0F, -2.0F, 1, 1, 5);
        this.Tree.addBox("Shape10", 3.0F, -1.0F, -3.0F, 1, 1, 7);
        this.Tree.addBox("Shape11", -3.0F, -7.0F, -2.0F, 7, 2, 5);
        this.Tree.addBox("Shape12", -1.0F, -6.0F, -4.0F, 3, 1, 9);
        this.Tree.addBox("Shape13", -4.0F, -6.0F, -1.0F, 9, 1, 3);
        this.Tree.addBox("Shape14", -2.0F, -7.0F, -3.0F, 5, 2, 7);
        this.Tree.addBox("Shape15", -2.0F, -8.0F, -2.0F, 5, 1, 5);
        this.Tree.addBox("Shape16", -1.0F, -9.0F, -2.0F, 3, 1, 5);
        this.Tree.addBox("Shape17", -3.0F, -8.0F, 0.0F, 7, 1, 1);
        this.Tree.addBox("Shape18", -2.0F, -9.0F, -1.0F, 5, 1, 3);
        this.Tree.addBox("Shape19", 0.0F, -8.0F, -3.0F, 1, 1, 7);
        this.Tree.addBox("Shape20", -1.0F, -2.0F, -4.0F, 3, 1, 9);
        this.Tree.addBox("Shape21", -2.0F, -3.0F, -3.0F, 5, 2, 7);
        this.Tree.addBox("Shape22", -3.0F, -3.0F, -2.0F, 7, 2, 5);
        this.Tree.addBox("Shape23", -4.0F, -2.0F, -1.0F, 9, 1, 3);
        this.Tree.addBox("Shape24", -3.0F, -4.0F, 0.0F, 7, 1, 1);
        this.Tree.addBox("Shape25", 0.0F, -4.0F, -3.0F, 1, 1, 7);
        this.Tree.addBox("Shape26", -2.0F, -4.0F, -2.0F, 5, 1, 5);
        this.Tree.addBox("Shape27", -1.0F, -5.0F, -2.0F, 3, 1, 5);
        this.Tree.addBox("Shape28", -2.0F, -5.0F, -1.0F, 5, 1, 3);
        this.Tree.addBox("Shape29", -1.0F, -10.0F, -1.0F, 3, 1, 3);
        this.Tree.addBox("Shape30", -3.0F, -11.0F, -1.0F, 7, 1, 3);
        this.Tree.addBox("Shape31", -1.0F, -11.0F, -3.0F, 3, 1, 7);
        this.Tree.addBox("Shape32", -2.0F, -11.0F, -2.0F, 5, 1, 5);
        this.Tree.addBox("Shape33", -1.0F, -14.0F, 0.0F, 3, 1, 1);
        this.Tree.addBox("Shape34", -1.0F, -13.0F, -1.0F, 3, 2, 3);
        this.Tree.addBox("Shape35", -2.0F, -12.0F, -1.0F, 1, 1, 3);
        this.Tree.addBox("Shape36", 2.0F, -12.0F, -1.0F, 1, 1, 3);
        this.Tree.addBox("Shape37", 0.0F, -12.0F, -2.0F, 1, 1, 5);
        this.Tree.addBox("Shape38", 0.0F, -14.0F, -1.0F, 1, 1, 3);
        this.Star = new MModelRenderer(this, "Star");
        this.Star.addBox("Shape39", -1.0F, -16.0F, 0.0F, 3, 1, 1);
        this.Star.addBox("Shape40", 0.0F, -17.0F, 0.0F, 1, 3, 1);
        this.Star.addBox("Shape41", 0.0F, -16.0F, -1.0F, 1, 1, 3);
        this.b3 = new MModelRenderer(this, 15, 18);
        this.b3.addBox(-0.001F, -14.0F, -1.0F, 1, 1, 1);
        this.b3.scaleModifier = 1.002F;
        this.b4 = new MModelRenderer(this, 15, 18);
        this.b4.addBox(-2.0F, -12.0F, 1.01F, 1, 1, 1);
        this.b4.scaleModifier = 1.002F;
        this.b8 = new MModelRenderer(this, 15, 18);
        this.b8.addBox(-0.001F, -12.0F, 2.0F, 1, 1, 1);
        this.b8.scaleModifier = 1.002F;
        this.setTexture(new ResourceLocation("minidot", "pets/sprucepet.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.16F) * 0.02F;
        GlStateManager.translate(0.75F, -0.2F + f, 0.3F);
        GlStateManager.rotate(time * 1.5F, 0.0F, 1.0F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(-0.05F, 0.25F, 0.0F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0401\u043b\u043a\u0430";
    }
}
