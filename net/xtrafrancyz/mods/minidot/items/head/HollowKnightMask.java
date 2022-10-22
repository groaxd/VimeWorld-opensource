package net.xtrafrancyz.mods.minidot.items.head;

import java.util.List;
import net.minecraft.client.model.ModelBox;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.items.BaseItem;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;
import net.xtrafrancyz.mods.minidot.util.MNaming;

public class HollowKnightMask extends BaseItem
{
    private final MModelRenderer bb_main;
    private final MModelRenderer bone;
    private final MModelRenderer bone3;
    private final MModelRenderer bone7;
    private final MModelRenderer bone6;
    private final MModelRenderer bone5;
    private final MModelRenderer bone4;
    private final MModelRenderer bone2;
    private final IAnimation animation;

    public HollowKnightMask()
    {
        super(ItemType.MASK);
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.bb_main = new MModelRenderer(this);
        this.bb_main.cubeList.add(new ModelBox(this.bb_main, 0, 0, -4.0F, -6.675F, -4.7F, 8, 6, 1, -0.175F, false));
        this.bone = new MModelRenderer(this);
        this.bone.setRotationPoint(0.0055F, -0.734F, -3.85F);
        this.setRotation(this.bone, 0.2356F, 0.0F, 0.0F);
        this.bone.cubeList.add(new ModelBox(this.bone, 0, 9, -1.0652F, 0.0482F, -0.5F, 2, 1, 1, -0.175F, false));
        this.bone3 = new MModelRenderer(this);
        this.setRotation(this.bone3, 0.0F, 0.0F, -0.3229F);
        this.bone.addChild(this.bone3);
        this.bone3.cubeList.add(new ModelBox(this.bone3, 6, 9, 0.6632F, -0.3094F, -0.5F, 2, 1, 1, -0.175F, false));
        this.bone7 = new MModelRenderer(this);
        this.setRotation(this.bone7, 0.0F, 0.0F, -0.7941F);
        this.bone.addChild(this.bone7);
        this.bone7.cubeList.add(new ModelBox(this.bone7, 0, 7, -0.7652F, -0.6018F, -0.5F, 2, 1, 1, -0.175F, false));
        this.bone6 = new MModelRenderer(this);
        this.setRotation(this.bone6, 0.0F, 0.0F, -0.7941F);
        this.bone.addChild(this.bone6);
        this.bone6.cubeList.add(new ModelBox(this.bone6, 0, 7, -0.7652F, -0.7768F, -0.5F, 2, 1, 1, -0.175F, false));
        this.bone5 = new MModelRenderer(this);
        this.setRotation(this.bone5, 0.0F, 0.0F, 0.7941F);
        this.bone.addChild(this.bone5);
        this.bone5.cubeList.add(new ModelBox(this.bone5, 6, 7, -0.9425F, 0.0561F, -0.5F, 2, 1, 1, -0.175F, false));
        this.bone4 = new MModelRenderer(this);
        this.setRotation(this.bone4, 0.0F, 0.0F, 0.3229F);
        this.bone.addChild(this.bone4);
        this.bone4.cubeList.add(new ModelBox(this.bone4, 0, 11, -2.6736F, -0.3059F, -0.5F, 2, 1, 1, -0.175F, false));
        this.bone2 = new MModelRenderer(this);
        this.bone2.setRotationPoint(0.0F, -3.65F, -0.1F);
        this.bone2.cubeList.add(new ModelBox(this.bone2, 18, 0, -2.55F, -0.975F, -4.45F, 1, 2, 0, 0.0F, false));
        this.bone2.cubeList.add(new ModelBox(this.bone2, 18, 0, 1.55F, -0.975F, -4.45F, 1, 2, 0, 0.0F, true));
        super.setTexture(new ResourceLocation("minidot", "masks/hollowknightmask.png"));
        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "masks/hollowknightmask_animation.json"));
        this.animation = bbanimationloader.mustGet("mask.default", this);
    }

    public String getName()
    {
        return "\u041c\u0430\u0441\u043a\u0430 \u043c\u0440\u0430\u0447\u043d\u043e\u0433\u043e \u0443\u0447\u0435\u043d\u0438\u043a\u0430";
    }

    public String getCreator()
    {
        return "GUllT";
    }

    public List<String> getDescription()
    {
        return MNaming.fromGame("Hollow Knight");
    }
}
