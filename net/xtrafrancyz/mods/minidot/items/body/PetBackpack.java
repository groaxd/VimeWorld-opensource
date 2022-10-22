package net.xtrafrancyz.mods.minidot.items.body;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;

public class PetBackpack extends BaseItem
{
    private final MModelRenderer root;
    private final MModelRenderer Steklo;
    private final MModelRenderer bone6;
    private final MModelRenderer Verh;
    private final MModelRenderer bone5;
    private final MModelRenderer Niz;
    private final MModelRenderer Spina;
    private final MModelRenderer PravyiBok;
    private final MModelRenderer LevyiBok;
    private final MModelRenderer Cat;
    private final MModelRenderer bone16;
    private final MModelRenderer bone15;
    private final MModelRenderer bone14;
    private final MModelRenderer PravayaLyamka;
    private final MModelRenderer bone8;
    private final MModelRenderer bone9;
    private final MModelRenderer bone10;
    private final MModelRenderer LevayaLyamka;
    private final MModelRenderer bone13;
    private final MModelRenderer bone11;
    private final MModelRenderer bone12;
    private final MModelRenderer Pered;
    private final MModelRenderer bone;
    private final String color;

    public PetBackpack(String color)
    {
        super(ItemType.BODY);
        this.color = color;
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.root = new MModelRenderer(this);
        this.root.setRotationPoint(0.0F, 11.0F, 7.0F);
        this.Steklo = new MModelRenderer(this);
        this.Steklo.setRotationPoint(-0.5F, 1.0F, -1.0F);
        this.root.addChild(this.Steklo);
        this.Steklo.setTextureOffset(10, 26).addBox(-2.0F, -7.0F, 0.7F, 5, 6, 0, 0.0F);
        this.bone6 = new MModelRenderer(this);
        this.bone6.setRotationPoint(0.5F, -7.0F, 0.7F);
        this.Steklo.addChild(this.bone6);
        this.setRotation(this.bone6, 0.48F, 0.0F, 0.0F);
        this.bone6.setTextureOffset(50, 10).addBox(-2.5F, -3.0F, 0.0F, 5, 3, 0, 0.0F);
        this.Verh = new MModelRenderer(this);
        this.Verh.setRotationPoint(-0.1F, -6.0F, 0.0F);
        this.root.addChild(this.Verh);
        this.setRotation(this.Verh, 0.48F, 0.0F, 0.0F);
        this.Verh.setTextureOffset(45, 9).addBox(2.5998F, -3.0F, -1.0F, 1, 3, 1, 0.0F);
        this.Verh.setTextureOffset(20, 26).addBox(-3.3998F, -3.0F, -1.0F, 1, 3, 1, 0.0F);
        this.Verh.setTextureOffset(9, 10).addBox(-3.0001F, -3.8153F, -3.6452F, 0, 4, 3, 0.0F);
        this.Verh.setTextureOffset(0, 10).addBox(3.2001F, -3.8153F, -3.6452F, 0, 4, 3, 0.0F);
        this.Verh.setTextureOffset(15, 12).addBox(-2.9991F, -4.8153F, -2.6452F, 0, 1, 1, 0.0F);
        this.Verh.setTextureOffset(15, 15).addBox(3.1991F, -4.8153F, -2.6452F, 0, 1, 1, 0.0F);
        this.bone5 = new MModelRenderer(this);
        this.bone5.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.Verh.addChild(this.bone5);
        this.setRotation(this.bone5, 0.6545F, 0.0F, 0.0F);
        this.bone5.setTextureOffset(18, 0).addBox(-3.4F, -3.0F, -1.0F, 7, 3, 1, -0.001F);
        this.Niz = new MModelRenderer(this);
        this.Niz.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root.addChild(this.Niz);
        this.setRotation(this.Niz, 0.2182F, 0.0F, 0.0F);
        this.Niz.setTextureOffset(0, 0).addBox(-3.5F, -1.0F, -4.0F, 7, 1, 4, 0.0F);
        this.Spina = new MModelRenderer(this);
        this.Spina.setRotationPoint(0.0F, 13.0F, -7.0F);
        this.root.addChild(this.Spina);
        this.Spina.setTextureOffset(18, 5).addBox(-3.5F, -23.0F, 2.0F, 7, 4, 1, 0.0F);
        this.Spina.setTextureOffset(0, 5).addBox(-4.0F, -19.0F, 2.0F, 8, 7, 1, 0.0F);
        this.PravyiBok = new MModelRenderer(this);
        this.PravyiBok.setRotationPoint(-3.5F, -6.0F, 0.0F);
        this.root.addChild(this.PravyiBok);
        this.setRotation(this.PravyiBok, 0.0F, -1.4835F, 0.0F);
        this.PravyiBok.setTextureOffset(24, 25).addBox(-4.0F, 0.0F, -1.0F, 4, 6, 1, 0.0F);
        this.PravyiBok.setTextureOffset(33, 19).addBox(-4.0697F, 2.4F, -0.203F, 3, 3, 1, 0.0F);
        this.LevyiBok = new MModelRenderer(this);
        this.LevyiBok.setRotationPoint(3.5F, -6.0F, 0.0F);
        this.root.addChild(this.LevyiBok);
        this.setRotation(this.LevyiBok, 0.0F, 1.4835F, 0.0F);
        this.LevyiBok.setTextureOffset(33, 15).addBox(1.0697F, 2.4F, -0.203F, 3, 3, 1, 0.0F);
        this.LevyiBok.setTextureOffset(0, 22).addBox(0.0F, 0.0F, -1.0F, 4, 6, 1, 0.0F);
        this.Cat = new MModelRenderer(this);
        this.Cat.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root.addChild(this.Cat);
        this.Cat.setTextureOffset(29, 10).addBox(-1.5F, -2.4F, -4.2F, 3, 2, 2, -0.3F);
        this.Cat.setTextureOffset(10, 22).addBox(-1.5F, -1.4F, -3.7F, 1, 1, 2, -0.3F);
        this.Cat.setTextureOffset(0, 17).addBox(0.5F, -1.4F, -3.7F, 1, 1, 2, -0.3F);
        this.bone16 = new MModelRenderer(this);
        this.bone16.setRotationPoint(0.0F, -3.5333F, -2.7F);
        this.Cat.addChild(this.bone16);
        this.setRotation(this.bone16, 0.0873F, 0.0F, 0.0F);
        this.bone16.setTextureOffset(46, 3).addBox(-1.0F, -2.2667F, -1.0F, 2, 2, 2, 0.3F);
        this.bone16.setTextureOffset(34, 7).addBox(-1.2F, -3.3667F, -0.5F, 1, 2, 1, -0.2F);
        this.bone16.setTextureOffset(6, 29).addBox(0.2F, -3.3667F, -0.5F, 1, 2, 1, -0.2F);
        this.bone15 = new MModelRenderer(this);
        this.bone15.setRotationPoint(0.0F, -2.7F, -2.6F);
        this.Cat.addChild(this.bone15);
        this.setRotation(this.bone15, 0.1309F, 0.0F, 0.0F);
        this.bone15.setTextureOffset(20, 10).addBox(0.0F, -0.7F, -0.5F, 1, 3, 1, -0.2F);
        this.bone15.setTextureOffset(0, 0).addBox(-1.0F, -0.7F, -0.5F, 1, 3, 1, -0.2F);
        this.bone14 = new MModelRenderer(this);
        this.bone14.setRotationPoint(0.0F, -3.4F, -3.2F);
        this.Cat.addChild(this.bone14);
        this.setRotation(this.bone14, -0.3927F, 0.0F, 0.0F);
        this.bone14.setTextureOffset(38, 3).addBox(-1.0F, -1.3F, -1.0F, 2, 4, 2, -0.2F);
        this.PravayaLyamka = new MModelRenderer(this);
        this.PravayaLyamka.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root.addChild(this.PravayaLyamka);
        this.PravayaLyamka.setTextureOffset(20, 10).addBox(-3.6F, -11.7F, -9.5F, 2, 1, 5, -0.3F);
        this.PravayaLyamka.setTextureOffset(54, 3).addBox(-4.6157F, -5.5949F, -9.9F, 1, 2, 2, -0.3F);
        this.bone8 = new MModelRenderer(this);
        this.bone8.setRotationPoint(-2.6F, -11.4F, -4.8F);
        this.PravayaLyamka.addChild(this.bone8);
        this.setRotation(this.bone8, 0.3054F, 0.0F, 0.0F);
        this.bone8.setTextureOffset(34, 23).addBox(-1.0F, -0.3F, -0.7F, 2, 3, 1, -0.3F);
        this.bone9 = new MModelRenderer(this);
        this.bone9.setRotationPoint(-3.3F, -11.4F, -9.0F);
        this.PravayaLyamka.addChild(this.bone9);
        this.setRotation(this.bone9, 0.0F, 0.0F, 0.1309F);
        this.bone9.setTextureOffset(27, 16).addBox(-0.3F, -0.3F, -0.7F, 2, 8, 1, -0.3F);
        this.bone10 = new MModelRenderer(this);
        this.bone10.setRotationPoint(-4.2F, -2.1F, -6.3F);
        this.PravayaLyamka.addChild(this.bone10);
        this.setRotation(this.bone10, -0.7854F, 0.0F, 0.0F);
        this.bone10.setTextureOffset(0, 13).addBox(-0.5F, -1.0F, -4.0F, 1, 2, 7, -0.3F);
        this.LevayaLyamka = new MModelRenderer(this);
        this.LevayaLyamka.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root.addChild(this.LevayaLyamka);
        this.LevayaLyamka.setTextureOffset(11, 20).addBox(1.6F, -11.7F, -9.5F, 2, 1, 5, -0.3F);
        this.LevayaLyamka.setTextureOffset(54, 3).addBox(3.6157F, -5.5949F, -9.9F, 1, 2, 2, -0.3F);
        this.bone13 = new MModelRenderer(this);
        this.bone13.setRotationPoint(2.6F, -11.4F, -4.8F);
        this.LevayaLyamka.addChild(this.bone13);
        this.setRotation(this.bone13, 0.3054F, 0.0F, 0.0F);
        this.bone13.setTextureOffset(20, 20).addBox(-1.0F, -0.3F, -0.7F, 2, 3, 1, -0.3F);
        this.bone11 = new MModelRenderer(this);
        this.bone11.setRotationPoint(3.3F, -11.4F, -9.0F);
        this.LevayaLyamka.addChild(this.bone11);
        this.setRotation(this.bone11, 0.0F, 0.0F, -0.1309F);
        this.bone11.setTextureOffset(27, 16).addBox(-1.7F, -0.3F, -0.7F, 2, 8, 1, -0.3F);
        this.bone12 = new MModelRenderer(this);
        this.bone12.setRotationPoint(4.2F, -2.1F, -6.3F);
        this.LevayaLyamka.addChild(this.bone12);
        this.setRotation(this.bone12, -0.7854F, 0.0F, 0.0F);
        this.bone12.setTextureOffset(11, 11).addBox(-0.5F, -1.0F, -4.0F, 1, 2, 7, -0.3F);
        this.Pered = new MModelRenderer(this);
        this.Pered.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root.addChild(this.Pered);
        this.Pered.setTextureOffset(41, 9).addBox(-3.5F, -6.0F, -1.0F, 1, 6, 1, 0.0F);
        this.Pered.setTextureOffset(34, 0).addBox(2.5F, -6.0F, -1.0F, 1, 6, 1, 0.0F);
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root.addChild(this.bone);
        this.bone.setTextureOffset(38, 0).addBox(-3.0F, -0.6F, -4.0F, 6, 1, 2, 0.0F);
        this.setTexture(new ResourceLocation("minidot", "body/pet_backpack_" + color + ".png"));
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        if (player.getCurrentArmor(2) == null)
        {
            super.render(modelPlayer, player, time, pi);
        }
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(MathHelper.sin(rotation * 0.06F + (float)number * 0.5F) * 20.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        GlStateManager.translate(0.0F, 0.1F, 0.3F);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.color;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -734239628:
                if (s.equals("yellow"))
                {
                    b0 = 4;
                }

                break;

            case 3027034:
                if (s.equals("blue"))
                {
                    b0 = 0;
                }

                break;

            case 3181155:
                if (s.equals("gray"))
                {
                    b0 = 3;
                }

                break;

            case 3441014:
                if (s.equals("pink"))
                {
                    b0 = 1;
                }

                break;

            case 98619139:
                if (s.equals("green"))
                {
                    b0 = 2;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u0421\u0438\u043d\u0438\u0439 \u0440\u044e\u043a\u0437\u0430\u043a-\u043f\u0435\u0440\u0435\u043d\u043e\u0441\u043a\u0430";

            case 1:
                return "\u0420\u043e\u0437\u043e\u0432\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a-\u043f\u0435\u0440\u0435\u043d\u043e\u0441\u043a\u0430";

            case 2:
                return "\u0417\u0435\u043b\u0435\u043d\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a-\u043f\u0435\u0440\u0435\u043d\u043e\u0441\u043a\u0430";

            case 3:
                return "\u0421\u0435\u0440\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a-\u043f\u0435\u0440\u0435\u043d\u043e\u0441\u043a\u0430";

            case 4:
                return "\u0416\u0435\u043b\u0442\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a-\u043f\u0435\u0440\u0435\u043d\u043e\u0441\u043a\u0430";

            default:
                return "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a \u0441 \u043a\u043e\u0442\u043e\u043c...";
        }
    }

    public String getCreator()
    {
        return "chikon";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.GOLD + "\u041d\u0435 \u043f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442\u0441\u044f, \u0435\u0441\u043b\u0438 \u043d\u0430\u0434\u0435\u0442 \u043d\u0430\u0433\u0440\u0443\u0434\u043d\u0438\u043a");
    }
}
