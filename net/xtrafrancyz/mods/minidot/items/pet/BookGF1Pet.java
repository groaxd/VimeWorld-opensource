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

public class BookGF1Pet extends BasePet
{
    private final MModelRenderer Book;
    private final MModelRenderer Shape12;
    private final MModelRenderer Shape13;

    public BookGF1Pet()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.useDisplayLists = true;
        this.setTextureOffset("Book.Shape1", 2, 2);
        this.setTextureOffset("Book.Shape2", 0, 11);
        this.setTextureOffset("Book.Shape3", 0, 22);
        this.setTextureOffset("Book.Shape4", 39, 17);
        this.setTextureOffset("Book.Shape5", 50, 7);
        this.setTextureOffset("Book.Shape6", 50, 7);
        this.setTextureOffset("Book.Shape7", 50, 6);
        this.setTextureOffset("Book.Shape8", 50, 7);
        this.setTextureOffset("Book.Shape9", 50, 7);
        this.setTextureOffset("Book.Shape10", 50, 6);
        this.setTextureOffset("Book.Shape11", 8, 0);
        this.Book = new MModelRenderer(this, "Book");
        this.Book.addBox("Shape1", -4.0F, -1.5F, -5.0F, 8, 1, 8);
        this.Book.addBox("Shape2", -4.0F, 0.5F, -5.0F, 8, 1, 10);
        this.Book.addBox("Shape3", -3.5F, -0.5F, -4.5F, 7, 1, 9);
        this.Book.addBox("Shape4", -4.5F, -1.0F, -5.0F, 1, 2, 10);
        this.Book.addBox("Shape5", -4.6F, -1.1F, -4.0F, 1, 1, 1);
        this.Book.addBox("Shape6", -4.6F, 0.1F, -4.0F, 1, 1, 1);
        this.Book.addBox("Shape7", -4.7F, -1.0F, -4.0F, 1, 2, 1);
        this.Book.addBox("Shape8", -4.6F, -1.1F, 3.0F, 1, 1, 1);
        this.Book.addBox("Shape9", -4.6F, 0.1F, 3.0F, 1, 1, 1);
        this.Book.addBox("Shape10", -4.7F, -1.0F, 3.0F, 1, 2, 1);
        this.Book.addBox("Shape11", -4.0F, -1.5F, 3.0F, 6, 1, 2);
        this.Shape12 = new MModelRenderer(this, 41, 7);
        this.Shape12.addBox(-1.7F, -1.4F, 3.5F, 2, 1, 1);
        this.setRotation(this.Shape12, 0.0F, ((float)Math.PI / 4F), 0.0F);
        this.Shape13 = new MModelRenderer(this, 11, 27);
        this.Shape13.addBox(-1.2F, 0.0F, -0.2F, 3, 0, 2);
        this.setRotation(this.Shape13, 0.0F, 0.9599311F, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "pets/bookgf1.png"));
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
        GlStateManager.rotate(90.0F + f, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(90.0F + f1, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(90.0F + f, 0.0F, 0.0F, 1.0F);
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
        return "\u0414\u043d\u0435\u0432\u043d\u0438\u043a #1";
    }

    public List<String> getDescription()
    {
        return MNaming.fromMult("Gravity Falls");
    }
}
