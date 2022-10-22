package net.xtrafrancyz.mods.minidot.items.head;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class LokiHelmet extends BaseHelm
{
    private final MModelRenderer LokyHelmet;
    private final MModelRenderer bone2;
    private final MModelRenderer bone10;
    private final MModelRenderer bone3;
    private final MModelRenderer bone7;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone4;
    private final MModelRenderer bone5;
    private final MModelRenderer bone6;

    public LokiHelmet()
    {
        super(ItemType.HEAD);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.LokyHelmet = new MModelRenderer(this);
        this.LokyHelmet.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.LokyHelmet.cubeList.add(new ModelBox(this.LokyHelmet, 0, 0, -4.0F, -13.0F, -4.0F, 8, 5, 8, 0.2F, false));
        this.bone2 = new MModelRenderer(this);
        this.setRotation(this.bone2, 0.6109F, 0.0F, 0.0F);
        this.LokyHelmet.addChild(this.bone2);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 0, 3, 4.25F, -6.9804F, -2.0857F, 0, 3, 10, 0.0F, false));
        this.bone10 = new MModelRenderer(this);
        this.setRotation(this.bone10, 0.6109F, 0.0F, 0.0F);
        this.LokyHelmet.addChild(this.bone10);
        this.bone10.cubeList.add(new ModelBox(this.bone10, 0, 3, -4.25F, -6.9804F, -2.0857F, 0, 3, 10, 0.0F, true));
        this.bone3 = new MModelRenderer(this);
        this.bone3.setRotationPoint(0.0F, -12.75F, -3.75F);
        this.LokyHelmet.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 18, 14, -5.0F, -1.0F, -1.0F, 10, 2, 2, 0.0F, false));
        this.bone7 = new MModelRenderer(this);
        this.bone7.setRotationPoint(0.5F, 0.4F, 1.0F);
        this.setRotation(this.bone7, 0.9599F, 0.0F, 0.0F);
        this.bone3.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 24, 23, -4.5F, -5.0F, -1.0F, 2, 4, 2, 0.003F, true));
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.setRotation(this.bone8, -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.bone7.addChild(this.bone8);
        this.bone8.cubeList.add(new ModelBox(this.bone8, 18, 18, -4.5F, -6.2591F, -6.2781F, 2, 5, 2, 0.0F, true));
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-3.5F, -2.7288F, -0.5887F);
        this.setRotation(this.bone9, -0.3054F, 0.0F, 0.0F);
        this.bone8.addChild(this.bone9);
        this.bone9.cubeList.add(new ModelBox(this.bone9, 0, 13, 0.0F, -8.0368F, -6.1352F, 0, 7, 9, 0.0F, true));
        this.bone4 = new MModelRenderer(this);
        this.bone4.setRotationPoint(-0.5F, 0.4F, 1.0F);
        this.setRotation(this.bone4, 0.9599F, 0.0F, 0.0F);
        this.bone3.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 24, 23, 2.5F, -5.0F, -1.0F, 2, 4, 2, 0.003F, false));
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.setRotation(this.bone5, -((float)Math.PI * 2F / 9F), 0.0F, 0.0F);
        this.bone4.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 18, 18, 2.5F, -6.2591F, -6.2781F, 2, 5, 2, 0.0F, false));
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(3.5F, -2.7288F, -0.5887F);
        this.setRotation(this.bone6, -0.3054F, 0.0F, 0.0F);
        this.bone5.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 13, 0.0F, -8.0368F, -6.1352F, 0, 7, 9, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "head/lokihelmet.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        super.preRender(modelPlayer, player, time, pi);
        GlStateManager.scale(1.05D, 1.05D, 1.05D);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        double d0 = 0.6D;
        GlStateManager.scale(d0, d0, d0);
        GlStateManager.translate(0.0D, 0.25D, 0.0D);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0428\u043b\u0435\u043c \u041b\u043e\u043a\u0438";
    }

    public String getCreator()
    {
        return "Wenston";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.RED + "" + EnumChatFormatting.BOLD + "MARVEL");
    }
}
