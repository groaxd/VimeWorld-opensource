package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class PersonaPet extends BasePet
{
    private final MModelRenderer body;
    private final MModelRenderer Shape1;
    private final MModelRenderer Shape2;
    private final MModelRenderer Shape3;
    private final MModelRenderer Shape4;
    private final MModelRenderer Shape5;
    private final MModelRenderer Shape6;
    private final MModelRenderer Shape7;
    private final MModelRenderer Shape8;
    private final MModelRenderer Shape9;
    private final MModelRenderer Shape10;

    public PersonaPet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.body = new MModelRenderer(this, 0, 0);
        this.body.addBox(0.0F, 0.0F, 0.0F, 8, 8, 5);
        this.Shape1 = new MModelRenderer(this, 0, 0);
        this.Shape1.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
        this.Shape1.setRotationPoint(7.0F, -4.0F, 2.0F);
        this.setRotation(this.Shape1, 0.0F, 0.0F, 0.3717861F);
        this.Shape2 = new MModelRenderer(this, 0, 0);
        this.Shape2.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
        this.Shape2.setRotationPoint(6.0F, -4.1F, 2.0F);
        this.setRotation(this.Shape2, 0.0F, 0.0F, 0.1487144F);
        this.Shape3 = new MModelRenderer(this, 0, 0);
        this.Shape3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
        this.Shape3.setRotationPoint(1.4F, -3.11F, 2.0F);
        this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0371786F);
        this.Shape4 = new MModelRenderer(this, 0, 0);
        this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
        this.Shape4.setRotationPoint(1.0F, -3.0F, 2.0F);
        this.setRotation(this.Shape4, 0.0F, 0.0F, -0.1487144F);
        this.Shape5 = new MModelRenderer(this, 0, 0);
        this.Shape5.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
        this.Shape5.setRotationPoint(1.0F, 7.3F, 2.0F);
        this.setRotation(this.Shape5, 0.0F, 0.0F, -0.1115358F);
        this.Shape6 = new MModelRenderer(this, 0, 0);
        this.Shape6.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
        this.Shape6.setRotationPoint(2.0F, 7.0F, 2.0F);
        this.setRotation(this.Shape6, 0.0F, 0.0F, 0.2230717F);
        this.Shape7 = new MModelRenderer(this, 0, 0);
        this.Shape7.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
        this.Shape7.setRotationPoint(4.933333F, 6.66F, 2.0F);
        this.setRotation(this.Shape7, 0.0F, 0.0F, -0.2230717F);
        this.Shape8 = new MModelRenderer(this, 0, 0);
        this.Shape8.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
        this.Shape8.setRotationPoint(6.0F, 6.6F, 2.0F);
        this.setRotation(this.Shape8, 0.0F, 0.0F, 0.1487144F);
        this.Shape9 = new MModelRenderer(this, 0, 0);
        this.Shape9.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
        this.Shape9.setRotationPoint(7.0F, 3.0F, 2.0F);
        this.setRotation(this.Shape9, 0.0F, 0.0F, -0.4833219F);
        this.Shape10 = new MModelRenderer(this, 0, 0);
        this.Shape10.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
        this.Shape10.setRotationPoint(0.0F, 3.0F, 2.0F);
        this.setRotation(this.Shape10, 0.0F, 0.0F, 0.4461433F);
        this.setTexture(new ResourceLocation("minidot", "pets/person.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.02F;
        float f1 = MathHelper.cos(time * 0.1F);
        GlStateManager.translate(0.6F, -0.5F + f, 0.3F);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(-0.15F, -0.13F, -0.1F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u041f\u0435\u0440\u0441\u043e\u043d\u0430";
    }

    public String getCreator()
    {
        return "Ursun";
    }
}
