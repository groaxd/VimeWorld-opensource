package net.xtrafrancyz.mods.minidot.items.body;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelBox;
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

public class IronChains extends BaseItem
{
    private final MModelRenderer CHAINSNOANGLE;
    private final MModelRenderer BACK;
    private final MModelRenderer CHAIN13;
    private final MModelRenderer CHAIN15;
    private final MModelRenderer CHAIN16;
    private final MModelRenderer CHAIN17;
    private final MModelRenderer CHAIN18;
    private final MModelRenderer CHAIN19;
    private final MModelRenderer CHAIN20;
    private final MModelRenderer CHAIN21;
    private final MModelRenderer CHAIN22;
    private final MModelRenderer CHAIN23;
    private final MModelRenderer CHAIN24;
    private final MModelRenderer CHAIN25;
    private final MModelRenderer CHAINCHAIN2;
    private final MModelRenderer CHAIN5;
    private final MModelRenderer CHAIN6;
    private final MModelRenderer CHAIN14;
    private final MModelRenderer CHAIN7;
    private final MModelRenderer CHAIN8;
    private final MModelRenderer CHAINCHAIN;
    private final MModelRenderer CHAIN9;
    private final MModelRenderer CHAIN4;
    private final MModelRenderer CHAIN2;
    private final MModelRenderer CHAIN3;
    private final MModelRenderer CHAIN10;
    private final MModelRenderer CHAIN;
    private final MModelRenderer CHAIN12;
    private final MModelRenderer CHAIN11;

    public IronChains()
    {
        super(ItemType.BODY);
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.CHAINSNOANGLE = new MModelRenderer(this);
        this.CHAINSNOANGLE.setRotationPoint(-1.2F, -8.7F, -3.3F);
        this.BACK = new MModelRenderer(this);
        this.BACK.setRotationPoint(0.9F, 2.2F, 5.3F);
        this.setRotation(this.BACK, 0.0F, 0.0F, -0.0349F);
        this.CHAINSNOANGLE.addChild(this.BACK);
        this.CHAIN13 = new MModelRenderer(this);
        this.CHAIN13.setRotationPoint(-2.8F, -5.7F, 0.0F);
        this.setRotation(this.CHAIN13, 0.1745F, -1.5708F, -0.4712F);
        this.BACK.addChild(this.CHAIN13);
        this.CHAIN13.cubeList.add(new ModelBox(this.CHAIN13, 26, 12, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN13.cubeList.add(new ModelBox(this.CHAIN13, 26, 6, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.201F, false));
        this.CHAIN13.cubeList.add(new ModelBox(this.CHAIN13, 15, 3, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN13.cubeList.add(new ModelBox(this.CHAIN13, 12, 15, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN15 = new MModelRenderer(this);
        this.CHAIN15.setRotationPoint(-2.6F, -4.9F, 0.2F);
        this.setRotation(this.CHAIN15, 0.1222F, 0.0F, -0.0698F);
        this.BACK.addChild(this.CHAIN15);
        this.CHAIN15.cubeList.add(new ModelBox(this.CHAIN15, 26, 4, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN15.cubeList.add(new ModelBox(this.CHAIN15, 26, 2, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN15.cubeList.add(new ModelBox(this.CHAIN15, 0, 15, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN15.cubeList.add(new ModelBox(this.CHAIN15, 14, 0, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN16 = new MModelRenderer(this);
        this.CHAIN16.setRotationPoint(-2.3F, -3.9F, 0.0F);
        this.setRotation(this.CHAIN16, 0.1745F, -1.5708F, -0.6109F);
        this.BACK.addChild(this.CHAIN16);
        this.CHAIN16.cubeList.add(new ModelBox(this.CHAIN16, 26, 0, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN16.cubeList.add(new ModelBox(this.CHAIN16, 26, 26, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN16.cubeList.add(new ModelBox(this.CHAIN16, 8, 14, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN16.cubeList.add(new ModelBox(this.CHAIN16, 4, 13, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN17 = new MModelRenderer(this);
        this.CHAIN17.setRotationPoint(-1.8F, -2.9F, 0.2F);
        this.setRotation(this.CHAIN17, 0.1222F, 0.0F, -0.5585F);
        this.BACK.addChild(this.CHAIN17);
        this.CHAIN17.cubeList.add(new ModelBox(this.CHAIN17, 22, 26, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN17.cubeList.add(new ModelBox(this.CHAIN17, 18, 26, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN17.cubeList.add(new ModelBox(this.CHAIN17, 12, 9, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN17.cubeList.add(new ModelBox(this.CHAIN17, 12, 6, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN18 = new MModelRenderer(this);
        this.CHAIN18.setRotationPoint(-1.2F, -1.9F, 0.0F);
        this.setRotation(this.CHAIN18, 0.1745F, -1.5708F, -0.6109F);
        this.BACK.addChild(this.CHAIN18);
        this.CHAIN18.cubeList.add(new ModelBox(this.CHAIN18, 10, 26, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN18.cubeList.add(new ModelBox(this.CHAIN18, 6, 26, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN18.cubeList.add(new ModelBox(this.CHAIN18, 12, 12, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN18.cubeList.add(new ModelBox(this.CHAIN18, 0, 12, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN19 = new MModelRenderer(this);
        this.CHAIN19.setRotationPoint(-0.6F, -0.9F, 0.2F);
        this.setRotation(this.CHAIN19, 0.1222F, 0.0F, -0.7505F);
        this.BACK.addChild(this.CHAIN19);
        this.CHAIN19.cubeList.add(new ModelBox(this.CHAIN19, 0, 26, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN19.cubeList.add(new ModelBox(this.CHAIN19, 15, 25, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN19.cubeList.add(new ModelBox(this.CHAIN19, 11, 3, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN19.cubeList.add(new ModelBox(this.CHAIN19, 8, 11, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN20 = new MModelRenderer(this);
        this.CHAIN20.setRotationPoint(0.0F, 0.1F, 0.0F);
        this.setRotation(this.CHAIN20, 0.1745F, -1.5708F, -0.6109F);
        this.BACK.addChild(this.CHAIN20);
        this.CHAIN20.cubeList.add(new ModelBox(this.CHAIN20, 3, 25, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN20.cubeList.add(new ModelBox(this.CHAIN20, 24, 17, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.201F, false));
        this.CHAIN20.cubeList.add(new ModelBox(this.CHAIN20, 10, 0, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN20.cubeList.add(new ModelBox(this.CHAIN20, 4, 10, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN21 = new MModelRenderer(this);
        this.CHAIN21.setRotationPoint(0.6F, 1.3F, 0.2F);
        this.setRotation(this.CHAIN21, 0.1222F, 0.0F, -0.4014F);
        this.BACK.addChild(this.CHAIN21);
        this.CHAIN21.cubeList.add(new ModelBox(this.CHAIN21, 12, 24, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN21.cubeList.add(new ModelBox(this.CHAIN21, 0, 24, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN21.cubeList.add(new ModelBox(this.CHAIN21, 8, 8, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN21.cubeList.add(new ModelBox(this.CHAIN21, 7, 2, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN22 = new MModelRenderer(this);
        this.CHAIN22.setRotationPoint(1.1F, 2.0F, 0.0F);
        this.setRotation(this.CHAIN22, 0.1745F, -1.5708F, -0.8378F);
        this.BACK.addChild(this.CHAIN22);
        this.CHAIN22.cubeList.add(new ModelBox(this.CHAIN22, 24, 10, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN22.cubeList.add(new ModelBox(this.CHAIN22, 24, 24, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN22.cubeList.add(new ModelBox(this.CHAIN22, 0, 9, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN22.cubeList.add(new ModelBox(this.CHAIN22, 8, 5, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN23 = new MModelRenderer(this);
        this.CHAIN23.setRotationPoint(1.7F, 3.0F, 0.2F);
        this.setRotation(this.CHAIN23, 0.1222F, 0.0F, -0.5411F);
        this.BACK.addChild(this.CHAIN23);
        this.CHAIN23.cubeList.add(new ModelBox(this.CHAIN23, 23, 22, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN23.cubeList.add(new ModelBox(this.CHAIN23, 23, 19, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN23.cubeList.add(new ModelBox(this.CHAIN23, 4, 7, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN23.cubeList.add(new ModelBox(this.CHAIN23, 0, 6, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN24 = new MModelRenderer(this);
        this.CHAIN24.setRotationPoint(2.4F, 3.8F, 0.0F);
        this.setRotation(this.CHAIN24, 0.1745F, -1.5708F, -0.9948F);
        this.BACK.addChild(this.CHAIN24);
        this.CHAIN24.cubeList.add(new ModelBox(this.CHAIN24, 23, 15, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.201F, false));
        this.CHAIN24.cubeList.add(new ModelBox(this.CHAIN24, 23, 8, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN24.cubeList.add(new ModelBox(this.CHAIN24, 4, 0, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN24.cubeList.add(new ModelBox(this.CHAIN24, 4, 4, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN25 = new MModelRenderer(this);
        this.CHAIN25.setRotationPoint(3.1F, 4.6F, 0.0F);
        this.setRotation(this.CHAIN25, -0.1745F, 0.0F, -0.576F);
        this.BACK.addChild(this.CHAIN25);
        this.CHAIN25.cubeList.add(new ModelBox(this.CHAIN25, 23, 5, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN25.cubeList.add(new ModelBox(this.CHAIN25, 23, 3, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN25.cubeList.add(new ModelBox(this.CHAIN25, 0, 3, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN25.cubeList.add(new ModelBox(this.CHAIN25, 0, 0, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAINCHAIN2 = new MModelRenderer(this);
        this.CHAINCHAIN2.setRotationPoint(3.0F, 5.4F, 0.0F);
        this.CHAINSNOANGLE.addChild(this.CHAINCHAIN2);
        this.CHAIN5 = new MModelRenderer(this);
        this.CHAIN5.setRotationPoint(0.6F, 1.1F, -0.2F);
        this.setRotation(this.CHAIN5, 0.0698F, -1.9722F, -0.7854F);
        this.CHAINCHAIN2.addChild(this.CHAIN5);
        this.CHAIN5.cubeList.add(new ModelBox(this.CHAIN5, 25, 20, -0.2238F, -1.3082F, -0.6169F, 1, 1, 1, -0.2F, false));
        this.CHAIN5.cubeList.add(new ModelBox(this.CHAIN5, 25, 20, -0.2238F, 0.3918F, -0.6169F, 1, 1, 1, -0.2F, false));
        this.CHAIN5.cubeList.add(new ModelBox(this.CHAIN5, 25, 20, 0.2762F, -1.0082F, -0.6169F, 1, 2, 1, -0.25F, false));
        this.CHAIN5.cubeList.add(new ModelBox(this.CHAIN5, 25, 20, -0.7238F, -1.0082F, -0.6169F, 1, 2, 1, -0.25F, false));
        this.CHAIN6 = new MModelRenderer(this);
        this.CHAIN6.setRotationPoint(-0.5F, -1.1F, 0.0F);
        this.setRotation(this.CHAIN6, 0.0F, -1.5708F, -0.4712F);
        this.CHAINCHAIN2.addChild(this.CHAIN6);
        this.CHAIN6.cubeList.add(new ModelBox(this.CHAIN6, 25, 20, -0.5F, -1.2134F, -0.45F, 1, 1, 1, -0.2F, false));
        this.CHAIN6.cubeList.add(new ModelBox(this.CHAIN6, 25, 20, -0.5F, 0.4866F, -0.45F, 1, 1, 1, -0.2F, false));
        this.CHAIN6.cubeList.add(new ModelBox(this.CHAIN6, 25, 20, 0.0F, -0.9134F, -0.45F, 1, 2, 1, -0.25F, false));
        this.CHAIN6.cubeList.add(new ModelBox(this.CHAIN6, 25, 20, -1.0F, -0.9134F, -0.45F, 1, 2, 1, -0.25F, false));
        this.CHAIN14 = new MModelRenderer(this);
        this.CHAIN14.setRotationPoint(1.3F, 1.7F, 0.1F);
        this.setRotation(this.CHAIN14, 0.1745F, 0.0F, -0.4363F);
        this.CHAINCHAIN2.addChild(this.CHAIN14);
        this.CHAIN14.cubeList.add(new ModelBox(this.CHAIN14, 25, 20, -0.55F, -1.2134F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN14.cubeList.add(new ModelBox(this.CHAIN14, 25, 20, -0.55F, 0.4866F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN14.cubeList.add(new ModelBox(this.CHAIN14, 25, 20, -0.05F, -0.9134F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN14.cubeList.add(new ModelBox(this.CHAIN14, 25, 20, -1.05F, -0.9134F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN7 = new MModelRenderer(this);
        this.CHAIN7.setRotationPoint(0.0F, -0.1F, 0.0F);
        this.setRotation(this.CHAIN7, 0.0F, 0.0F, -0.4363F);
        this.CHAINCHAIN2.addChild(this.CHAIN7);
        this.CHAIN7.cubeList.add(new ModelBox(this.CHAIN7, 25, 20, -0.55F, -1.2134F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN7.cubeList.add(new ModelBox(this.CHAIN7, 25, 20, -0.55F, 0.4866F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN7.cubeList.add(new ModelBox(this.CHAIN7, 25, 20, -0.05F, -0.9134F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN7.cubeList.add(new ModelBox(this.CHAIN7, 25, 20, -1.05F, -0.9134F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN8 = new MModelRenderer(this);
        this.CHAIN8.setRotationPoint(-1.1F, -2.1F, 0.0F);
        this.setRotation(this.CHAIN8, 0.0F, 0.0F, -((float)Math.PI * 2F / 9F));
        this.CHAINCHAIN2.addChild(this.CHAIN8);
        this.CHAIN8.cubeList.add(new ModelBox(this.CHAIN8, 25, 20, -0.55F, -1.2134F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN8.cubeList.add(new ModelBox(this.CHAIN8, 25, 20, -0.55F, 0.4866F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN8.cubeList.add(new ModelBox(this.CHAIN8, 25, 20, -0.05F, -0.9134F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN8.cubeList.add(new ModelBox(this.CHAIN8, 25, 20, -1.05F, -0.9134F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAINCHAIN = new MModelRenderer(this);
        this.CHAINCHAIN.setRotationPoint(-1.2F, -1.4F, 0.0F);
        this.CHAINSNOANGLE.addChild(this.CHAINCHAIN);
        this.CHAIN9 = new MModelRenderer(this);
        this.CHAIN9.setRotationPoint(0.1F, 0.0F, 0.1F);
        this.setRotation(this.CHAIN9, 0.0F, -1.5708F, -0.5411F);
        this.CHAINCHAIN.addChild(this.CHAIN9);
        this.CHAIN9.cubeList.add(new ModelBox(this.CHAIN9, 6, 28, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.201F, false));
        this.CHAIN9.cubeList.add(new ModelBox(this.CHAIN9, 0, 28, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN9.cubeList.add(new ModelBox(this.CHAIN9, 4, 19, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN9.cubeList.add(new ModelBox(this.CHAIN9, 18, 0, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN4 = new MModelRenderer(this);
        this.CHAIN4.setRotationPoint(2.4F, 3.9F, 0.0F);
        this.setRotation(this.CHAIN4, 0.0349F, -1.5708F, -0.6458F);
        this.CHAINCHAIN.addChild(this.CHAIN4);
        this.CHAIN4.cubeList.add(new ModelBox(this.CHAIN4, 29, 1, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN4.cubeList.add(new ModelBox(this.CHAIN4, 13, 29, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN4.cubeList.add(new ModelBox(this.CHAIN4, 12, 21, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN4.cubeList.add(new ModelBox(this.CHAIN4, 0, 21, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN2 = new MModelRenderer(this);
        this.CHAIN2.setRotationPoint(1.2F, 2.0F, 0.0F);
        this.setRotation(this.CHAIN2, 0.0F, -1.5708F, -0.4712F);
        this.CHAINCHAIN.addChild(this.CHAIN2);
        this.CHAIN2.cubeList.add(new ModelBox(this.CHAIN2, 0, 30, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN2.cubeList.add(new ModelBox(this.CHAIN2, 29, 13, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.201F, false));
        this.CHAIN2.cubeList.add(new ModelBox(this.CHAIN2, 25, 9, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN2.cubeList.add(new ModelBox(this.CHAIN2, 22, 1, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN3 = new MModelRenderer(this);
        this.CHAIN3.setRotationPoint(1.7F, 2.9F, 0.0F);
        this.setRotation(this.CHAIN3, 0.0F, 0.0F, -0.6109F);
        this.CHAINCHAIN.addChild(this.CHAIN3);
        this.CHAIN3.cubeList.add(new ModelBox(this.CHAIN3, 29, 4, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN3.cubeList.add(new ModelBox(this.CHAIN3, 29, 3, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN3.cubeList.add(new ModelBox(this.CHAIN3, 16, 22, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN3.cubeList.add(new ModelBox(this.CHAIN3, 4, 22, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN10 = new MModelRenderer(this);
        this.CHAIN10.setRotationPoint(-0.3F, -0.8F, 0.0F);
        this.setRotation(this.CHAIN10, 0.0F, 0.0F, -0.3491F);
        this.CHAINCHAIN.addChild(this.CHAIN10);
        this.CHAIN10.cubeList.add(new ModelBox(this.CHAIN10, 27, 22, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN10.cubeList.add(new ModelBox(this.CHAIN10, 27, 18, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN10.cubeList.add(new ModelBox(this.CHAIN10, 12, 18, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN10.cubeList.add(new ModelBox(this.CHAIN10, 0, 18, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN = new MModelRenderer(this);
        this.CHAIN.setRotationPoint(0.7F, 0.9F, 0.0F);
        this.setRotation(this.CHAIN, 0.0F, 0.0F, -0.4189F);
        this.CHAINCHAIN.addChild(this.CHAIN);
        this.CHAIN.cubeList.add(new ModelBox(this.CHAIN, 10, 30, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN.cubeList.add(new ModelBox(this.CHAIN, 6, 30, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN.cubeList.add(new ModelBox(this.CHAIN, 20, 23, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN.cubeList.add(new ModelBox(this.CHAIN, 8, 23, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN12 = new MModelRenderer(this);
        this.CHAIN12.setRotationPoint(-0.8F, -2.6F, 0.4F);
        this.setRotation(this.CHAIN12, -0.4887F, 0.0F, -0.0524F);
        this.CHAINCHAIN.addChild(this.CHAIN12);
        this.CHAIN12.cubeList.add(new ModelBox(this.CHAIN12, 13, 27, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN12.cubeList.add(new ModelBox(this.CHAIN12, 3, 27, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN12.cubeList.add(new ModelBox(this.CHAIN12, 16, 9, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN12.cubeList.add(new ModelBox(this.CHAIN12, 16, 6, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN11 = new MModelRenderer(this);
        this.CHAIN11.setRotationPoint(-1.8F, -3.1F, 0.1F);
        this.setRotation(this.CHAIN11, 0.0F, -1.5708F, -0.2618F);
        this.CHAINSNOANGLE.addChild(this.CHAIN11);
        this.CHAIN11.cubeList.add(new ModelBox(this.CHAIN11, 27, 16, -0.5F, -1.3F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN11.cubeList.add(new ModelBox(this.CHAIN11, 27, 8, -0.5F, 0.4F, -0.5F, 1, 1, 1, -0.2F, false));
        this.CHAIN11.cubeList.add(new ModelBox(this.CHAIN11, 8, 17, 0.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.CHAIN11.cubeList.add(new ModelBox(this.CHAIN11, 16, 12, -1.0F, -1.0F, -0.5F, 1, 2, 1, -0.25F, false));
        this.setTexture(new ResourceLocation("minidot", "body/iron_chains.png"));
    }

    protected void preRender(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        this.setModelRotation(modelPlayer.bipedBody);
        GlStateManager.scale(1.0F, 1.0F, 0.95F);
        GlStateManager.translate(0.0F, 0.8F, 0.042F);
        this.CHAINSNOANGLE.isHidden = player.getCurrentArmor(2) != null;
        this.setRotationAngles(this.rotateX, this.rotateY, this.rotateZ);

        if (modelPlayer.isSneak)
        {
            GlStateManager.translate(0.0F, 0.255F, 0.292F);
        }
    }

    public void itemMotion(float rotation, int number)
    {
        GlStateManager.rotate(180.0F + MathHelper.sin(rotation * 0.04F + (float)number) * 40.0F, 0.0F, 0.2F, 0.0F);
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.57F, 0.4F);
        this.CHAINSNOANGLE.isHidden = false;
        super.renderAsItem(time);
    }

    public String getName()
    {
        return "\u0416\u0435\u043b\u0435\u0437\u043d\u0430\u044f \u0446\u0435\u043f\u044c";
    }

    public String getCreator()
    {
        return "Defiant";
    }

    public List<String> getDescription()
    {
        return Collections.<String>singletonList(EnumChatFormatting.GOLD + "\u041d\u0435 \u043f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442\u0441\u044f, \u0435\u0441\u043b\u0438 \u043d\u0430\u0434\u0435\u0442 \u043d\u0430\u0433\u0440\u0443\u0434\u043d\u0438\u043a");
    }
}
