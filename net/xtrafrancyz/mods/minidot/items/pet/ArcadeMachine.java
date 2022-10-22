package net.xtrafrancyz.mods.minidot.items.pet;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class ArcadeMachine extends BasePet
{
    private final MModelRenderer SlotMachine;
    private final MModelRenderer Jostic;
    private final MModelRenderer Buttons;
    private final MModelRenderer bone;
    private final MModelRenderer TheBasisOfTheSlotMachine;
    private final MModelRenderer Game;
    private final MModelRenderer Two;
    private final MModelRenderer One;
    private final MModelRenderer Three;
    private final MModelRenderer Food;
    private final MModelRenderer Red;
    private final MModelRenderer GameOver;
    private final IAnimation animation;

    public ArcadeMachine()
    {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.SlotMachine = new MModelRenderer(this);
        this.Jostic = new MModelRenderer(this);
        this.Jostic.setRotationPoint(-3.5F, -10.0F, -4.5F);
        this.SlotMachine.addChild(this.Jostic);
        this.Jostic.cubeList.add(new ModelBox(this.Jostic, 0, 0, -1.0F, -3.0F, -1.0F, 2, 2, 2, -0.3F, false));
        this.Jostic.cubeList.add(new ModelBox(this.Jostic, 8, 0, -0.5F, -2.0F, -0.5F, 1, 3, 1, -0.2F, false));
        this.Buttons = new MModelRenderer(this);
        this.SlotMachine.addChild(this.Buttons);
        this.Buttons.cubeList.add(new ModelBox(this.Buttons, 4, 4, 0.75F, -10.25F, -5.0F, 1, 1, 1, 0.0F, false));
        this.Buttons.cubeList.add(new ModelBox(this.Buttons, 0, 4, 2.75F, -10.25F, -5.0F, 1, 1, 1, 0.0F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0F, 0.0F, -2.5F);
        this.setRotation(this.bone, -0.1745F, 0.0F, 0.0F);
        this.SlotMachine.addChild(this.bone);
        this.bone.cubeList.add(new ModelBox(this.bone, 31, 22, -5.0F, -12.0F, -2.0F, 10, 3, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 38, 3.0F, -19.0F, -1.0F, 2, 10, 2, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 8, 38, -3.0F, -19.0F, -1.0F, 6, 2, 1, 0.0F, false));
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 22, -5.0F, -19.0F, -1.0F, 2, 9, 2, 0.0F, false));
        this.TheBasisOfTheSlotMachine = new MModelRenderer(this);
        this.SlotMachine.addChild(this.TheBasisOfTheSlotMachine);
        this.TheBasisOfTheSlotMachine.cubeList.add(new ModelBox(this.TheBasisOfTheSlotMachine, 0, 0, -5.0F, -10.0F, -6.0F, 10, 10, 12, 0.001F, false));
        this.TheBasisOfTheSlotMachine.cubeList.add(new ModelBox(this.TheBasisOfTheSlotMachine, 36, 32, -5.0F, -19.0F, 0.0F, 10, 9, 6, 0.001F, false));
        this.TheBasisOfTheSlotMachine.cubeList.add(new ModelBox(this.TheBasisOfTheSlotMachine, 0, 22, -5.0F, -24.0F, -5.0F, 10, 5, 11, 0.0F, false));
        this.TheBasisOfTheSlotMachine.cubeList.add(new ModelBox(this.TheBasisOfTheSlotMachine, 31, 26, -3.0F, -12.0F, -2.0F, 6, 2, 2, 0.0F, false));
        this.Game = new MModelRenderer(this);
        this.Game.setRotationPoint(-1.0F, 0.0F, 9.975F);
        this.SlotMachine.addChild(this.Game);
        this.Two = new MModelRenderer(this);
        this.Game.addChild(this.Two);
        this.Two.cubeList.add(new ModelBox(this.Two, 0, 1, -1.0F, -13.0F, -10.0F, 1, 1, 0, 0.0F, false));
        this.One = new MModelRenderer(this);
        this.Game.addChild(this.One);
        this.One.cubeList.add(new ModelBox(this.One, 0, 1, -1.0F, -13.0F, -10.0F, 1, 1, 0, 0.0F, false));
        this.Three = new MModelRenderer(this);
        this.Game.addChild(this.Three);
        this.Three.cubeList.add(new ModelBox(this.Three, 0, 1, -1.0F, -13.0F, -10.0F, 1, 1, 0, 0.0F, false));
        this.Food = new MModelRenderer(this);
        this.Food.setRotationPoint(2.0F, -3.0F, 0.175F);
        this.SlotMachine.addChild(this.Food);
        this.Red = new MModelRenderer(this);
        this.Red.setRotationPoint(-1.0F, 0.5F, 7.5F);
        this.Food.addChild(this.Red);
        this.Red.cubeList.add(new ModelBox(this.Red, 0, 0, -1.0F, -13.0F, -7.7F, 1, 1, 0, 0.0F, false));
        this.GameOver = new MModelRenderer(this);
        this.SlotMachine.addChild(this.GameOver);
        this.GameOver.cubeList.add(new ModelBox(this.GameOver, 32, 0, 9.0F, -24.0F, 0.0F, 15, 11, 0, 0.0F, false));
        super.setTexture(new ResourceLocation("minidot", "pets/arcademachine.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/arcademachine_animation.json"));
        this.animation = bbanimationloader.mustGet("arcade.default", this);
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        double d0 = (double)MathHelper.sin(time * 0.1F) * 0.03D;
        GlStateManager.translate(0.6D, d0, 0.3D);
        this.animation.tick(time);
        super.preRender(modelPlayer, player, time, pi);
        double d1 = 0.7D;
        GlStateManager.scale(d1, d1, d1);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0D, 0.4D, 0.0D);
        double d0 = 0.9D;
        GlStateManager.scale(d0, d0, d0);
        this.animation.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0410\u0440\u043a\u0430\u0434\u043d\u044b\u0439 \u0430\u0432\u0442\u043e\u043c\u0430\u0442";
    }

    public String getCreator()
    {
        return "Rander_";
    }
}
