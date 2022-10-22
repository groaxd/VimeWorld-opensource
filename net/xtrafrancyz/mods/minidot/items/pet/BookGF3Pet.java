package net.xtrafrancyz.mods.minidot.items.pet;

import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class BookGF3Pet extends BasePet
{
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
    private final MModelRenderer Shape11;
    private final MModelRenderer Shape12;
    private final MModelRenderer Shape13;
    private final MModelRenderer Shape14;
    private final MModelRenderer Shape15;

    public BookGF3Pet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.Shape1 = new MModelRenderer(this, 0, 0);
        this.Shape1.addBox(-4.0F, -1.5F, -5.0F, 8, 1, 10);
        this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, ((float)Math.PI / 2F), 0.0F, 0.0F);
        this.Shape2 = new MModelRenderer(this, 0, 11);
        this.Shape2.addBox(-4.0F, 0.5F, -5.0F, 8, 1, 10);
        this.Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, ((float)Math.PI / 2F), 0.0F, 0.0F);
        this.Shape3 = new MModelRenderer(this, 0, 22);
        this.Shape3.addBox(-3.5F, -0.5F, -4.5F, 7, 1, 9);
        this.Shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape3.setTextureSize(64, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, ((float)Math.PI / 2F), 0.0F, 0.0F);
        this.Shape4 = new MModelRenderer(this, 39, 17);
        this.Shape4.addBox(-4.5F, -1.033333F, -5.0F, 1, 2, 10);
        this.Shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape4.setTextureSize(64, 32);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, ((float)Math.PI / 2F), 0.0F, 0.0F);
        this.Shape5 = new MModelRenderer(this, 50, 7);
        this.Shape5.addBox(-4.6F, -1.1F, -4.0F, 1, 1, 1);
        this.Shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape5.setTextureSize(64, 32);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, ((float)Math.PI / 2F), 0.0F, 0.0F);
        this.Shape6 = new MModelRenderer(this, 50, 7);
        this.Shape6.addBox(-4.6F, 0.1F, -4.0F, 1, 1, 1);
        this.Shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape6.setTextureSize(64, 32);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, ((float)Math.PI / 2F), 0.0F, 0.0F);
        this.Shape7 = new MModelRenderer(this, 50, 6);
        this.Shape7.addBox(-4.7F, -1.0F, -4.0F, 1, 2, 1);
        this.Shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape7.setTextureSize(64, 32);
        this.Shape7.mirror = true;
        this.setRotation(this.Shape7, ((float)Math.PI / 2F), 0.0F, 0.0F);
        this.Shape8 = new MModelRenderer(this, 50, 7);
        this.Shape8.addBox(-4.6F, -1.1F, 3.0F, 1, 1, 1);
        this.Shape8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape8.setTextureSize(64, 32);
        this.Shape8.mirror = true;
        this.setRotation(this.Shape8, ((float)Math.PI / 2F), 0.0F, 0.0F);
        this.Shape9 = new MModelRenderer(this, 50, 7);
        this.Shape9.addBox(-4.6F, 0.1F, 3.0F, 1, 1, 1);
        this.Shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape9.setTextureSize(64, 32);
        this.Shape9.mirror = true;
        this.setRotation(this.Shape9, ((float)Math.PI / 2F), 0.0F, 0.0F);
        this.Shape10 = new MModelRenderer(this, 50, 6);
        this.Shape10.addBox(-4.733333F, -1.033333F, 3.0F, 1, 2, 1);
        this.Shape10.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape10.setTextureSize(64, 32);
        this.Shape10.mirror = true;
        this.setRotation(this.Shape10, ((float)Math.PI / 2F), 0.0F, 0.0F);
        this.Shape11 = new MModelRenderer(this, 16, 24);
        this.Shape11.addBox(2.0F, 1.5F, 0.0F, 2, 3, 0);
        this.Shape11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape11.setTextureSize(64, 32);
        this.Shape11.mirror = true;
        this.setRotation(this.Shape11, 0.0F, 0.0F, 0.8922867F);
        this.Shape12 = new MModelRenderer(this, 16, 24);
        this.Shape12.addBox(2.0F, -2.5F, 0.0F, 2, 3, 0);
        this.Shape12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape12.setTextureSize(64, 32);
        this.Shape12.mirror = true;
        this.setRotation(this.Shape12, 0.0F, 0.0F, 0.8922867F);
        this.Shape13 = new MModelRenderer(this, 16, 24);
        this.Shape13.addBox(0.8F, -3.2F, 0.0F, 2, 3, 0);
        this.Shape13.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape13.setTextureSize(64, 32);
        this.Shape13.mirror = true;
        this.setRotation(this.Shape13, 0.0F, 0.0F, 0.8922867F);
        this.Shape14 = new MModelRenderer(this, 16, 24);
        this.Shape14.addBox(-0.8F, -5.4F, 0.0F, 3, 3, 0);
        this.Shape14.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape14.setTextureSize(64, 32);
        this.Shape14.mirror = true;
        this.setRotation(this.Shape14, 0.0F, 0.0F, -0.5205006F);
        this.Shape15 = new MModelRenderer(this, 16, 24);
        this.Shape15.addBox(-0.2F, -4.4F, 0.0F, 3, 3, 0);
        this.Shape15.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape15.setTextureSize(64, 32);
        this.Shape15.mirror = true;
        this.setRotation(this.Shape15, 0.0F, 0.0F, -0.5205006F);
        this.setTexture(new ResourceLocation("minidot", "pets/bookgf3.png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.04F;
        float f1 = time / 1.5F;
        float f2 = -time / 1.5F;
        GlStateManager.translate(0.6F + f, -0.5F + f, 0.5F + f);
        GlStateManager.rotate(f1 * 4.0F, 0.0F, 0.6F, time + 0.0F);
        GlStateManager.rotate(90.0F + f1, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(90.0F + f2, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(90.0F + f1, 0.0F, 0.0F, 1.0F);
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
    }

    public void renderAsItem(float time)
    {
        float f = time / 1.5F;
        float f1 = -time / 1.5F;
        GlStateManager.scale(1.8F, 1.8F, 1.8F);
        GlStateManager.rotate(90.0F + f1, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(90.0F + f, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(90.0F + f1, 0.0F, 0.0F, 1.0F);
        super.renderAsItem(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public String getName()
    {
        return "\u0414\u043d\u0435\u0432\u043d\u0438\u043a #3";
    }

    public List<String> getDescription()
    {
        return MNaming.fromMult("Gravity Falls");
    }
}
