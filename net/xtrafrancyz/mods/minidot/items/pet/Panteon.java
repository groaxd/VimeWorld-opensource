package net.xtrafrancyz.mods.minidot.items.pet;

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
import net.xtrafrancyz.mods.minidot.items.MModelRenderer;
import net.xtrafrancyz.mods.minidot.items.animation.BBAnimationLoader;
import net.xtrafrancyz.mods.minidot.items.animation.IAnimation;

public class Panteon extends BasePet
{
    private final String type;
    private static MModelRenderer Cup6;
    private static MModelRenderer Cup5;
    private static MModelRenderer Cup4;
    private static MModelRenderer Cup3;
    private static MModelRenderer Cup12;
    private static MModelRenderer Cup11;
    private static MModelRenderer Cup10;
    private static MModelRenderer Cup8;
    private static MModelRenderer Cup15;
    private static MModelRenderer Cup16;
    private static MModelRenderer Cup17;
    private static MModelRenderer Cup18;
    private static MModelRenderer Cup19;
    private static MModelRenderer Cup20;
    private static MModelRenderer Cup21;
    private static MModelRenderer Cup22;
    private static MModelRenderer Cup23;
    private static MModelRenderer Cup24;
    private static MModelRenderer Cup25;
    private static MModelRenderer Cup26;
    private static MModelRenderer Cup27;
    private static MModelRenderer Cup28;
    private static MModelRenderer Cup29;
    private static MModelRenderer Cup30;
    private static MModelRenderer Cup31;
    private static MModelRenderer Cup32;
    private static MModelRenderer Cup33;
    private static MModelRenderer Cup34;
    private static MModelRenderer Cup35;
    private static MModelRenderer Cup36;
    private static MModelRenderer Cup37;
    private static MModelRenderer Cup38;
    private static MModelRenderer Cup39;
    private static MModelRenderer Cup40;
    private static MModelRenderer Cup41;
    private static MModelRenderer Cup42;
    private static MModelRenderer Cup43;
    private static MModelRenderer Cup44;
    private static MModelRenderer Cup45;
    private static MModelRenderer Cup46;
    private static MModelRenderer Cup47;
    private static MModelRenderer Cup48;
    private static MModelRenderer Cup49;
    private static MModelRenderer Cup50;
    private static MModelRenderer Cup51;
    private static MModelRenderer Cup52;
    private static MModelRenderer Cup53;
    private static MModelRenderer Cup54;
    private static MModelRenderer Cup55;
    private static MModelRenderer Cup57;
    private static MModelRenderer Cup56;
    private static MModelRenderer Cup59;
    private static MModelRenderer Cup58;
    private static MModelRenderer Cup63;
    private static MModelRenderer Cup65;
    private static MModelRenderer Cup64;
    private static MModelRenderer Cup67;
    private static MModelRenderer Cup66;
    private static MModelRenderer Cup68;
    private static MModelRenderer Cup69;
    private static MModelRenderer Cup61;
    private final IAnimation anim;

    public Panteon(String type)
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.type = type;
        this.useDisplayLists = true;

        if (Cup6 == null)
        {
            Cup6 = new MModelRenderer(this);
            this.setRotation(Cup6, 0.0F, -0.3927F, 0.0F);
            Cup6.cubeList.add(new ModelBox(Cup6, 18, 53, -1.95F, -7.5F, -2.05F, 4, 6, 4, 0.0F, false));
            Cup5 = new MModelRenderer(this);
            this.setRotation(Cup5, 0.0F, -1.1781F, 0.0F);
            Cup5.cubeList.add(new ModelBox(Cup5, 18, 53, -1.95F, -7.5F, -2.05F, 4, 6, 4, 0.0F, false));
            Cup4 = new MModelRenderer(this);
            Cup4.setRotationPoint(0.05F, -4.75F, -0.05F);
            Cup4.cubeList.add(new ModelBox(Cup4, 17, 50, -2.0F, -5.75F, -2.0F, 4, 9, 4, 0.0F, false));
            Cup3 = new MModelRenderer(this);
            Cup3.setRotationPoint(0.05F, -4.75F, -0.05F);
            this.setRotation(Cup3, 0.0F, -0.7854F, 0.0F);
            Cup3.cubeList.add(new ModelBox(Cup3, 17, 50, -2.0F, -5.75F, -2.0F, 4, 9, 4, 0.0F, false));
            Cup12 = new MModelRenderer(this);
            Cup12.cubeList.add(new ModelBox(Cup12, 7, 54, -3.0F, -1.8F, -3.5F, 6, 1, 7, 0.0F, false));
            Cup12.cubeList.add(new ModelBox(Cup12, 7, 54, -3.0F, -1.8F, -3.5F, 6, 1, 7, 0.0F, false));
            Cup11 = new MModelRenderer(this);
            this.setRotation(Cup11, 0.0F, 0.0F, 0.4363F);
            Cup11.cubeList.add(new ModelBox(Cup11, 17, 54, 1.9582F, -2.8992F, -3.001F, 2, 1, 6, 0.0F, false));
            Cup10 = new MModelRenderer(this);
            Cup10.setRotationPoint(-3.65F, -1.3F, 0.0F);
            this.setRotation(Cup10, 0.0F, 0.0F, -0.4363F);
            Cup10.cubeList.add(new ModelBox(Cup10, 7, 55, -1.1996F, -0.1784F, -3.0F, 2, 1, 6, 0.0F, false));
            Cup8 = new MModelRenderer(this);
            Cup8.cubeList.add(new ModelBox(Cup8, 0, 18, -3.0F, -1.1F, -5.0F, 6, 1, 10, 0.0F, false));
            Cup8.cubeList.add(new ModelBox(Cup8, 0, 18, 2.2F, -1.2F, -4.0F, 2, 1, 8, 0.0F, false));
            Cup8.cubeList.add(new ModelBox(Cup8, 0, 18, 3.2F, -1.1F, -3.0F, 2, 1, 6, 0.0F, false));
            Cup8.cubeList.add(new ModelBox(Cup8, 0, 18, -4.2F, -1.2F, -4.0F, 2, 1, 8, 0.0F, false));
            Cup8.cubeList.add(new ModelBox(Cup8, 0, 18, -5.3F, -1.1F, -3.001F, 2, 1, 6, 0.0F, false));
            Cup15 = new MModelRenderer(this);
            Cup15.setRotationPoint(5.1F, -13.5F, 0.0F);
            this.setRotation(Cup15, 0.0F, 0.0F, 0.2618F);
            Cup15.cubeList.add(new ModelBox(Cup15, 42, 43, -12.2F, 1.8F, -4.0F, 3, 2, 8, 0.0F, false));
            Cup16 = new MModelRenderer(this);
            Cup16.setRotationPoint(-5.1F, 1.0F, 0.0F);
            this.setRotation(Cup16, 0.0F, 0.0F, -0.4363F);
            Cup15.addChild(Cup16);
            Cup16.cubeList.add(new ModelBox(Cup16, 39, 21, -6.1204F, -4.9364F, -0.9F, 2, 5, 2, 0.0F, false));
            Cup17 = new MModelRenderer(this);
            Cup17.setRotationPoint(1.2F, 0.0F, 0.0F);
            this.setRotation(Cup17, 0.0F, 0.0F, -1.2217F);
            Cup16.addChild(Cup17);
            Cup17.cubeList.add(new ModelBox(Cup17, 39, 21, 0.8191F, -10.6879F, -1.0F, 2, 4, 2, 0.0F, false));
            Cup18 = new MModelRenderer(this);
            this.setRotation(Cup18, 0.0F, 0.0F, 1.0472F);
            Cup17.addChild(Cup18);
            Cup18.cubeList.add(new ModelBox(Cup18, 39, 21, -8.8464F, -10.0533F, -1.1F, 2, 4, 2, 0.0F, false));
            Cup18.cubeList.add(new ModelBox(Cup18, 39, 21, -10.2614F, -14.9806F, -0.5F, 2, 6, 1, 0.0F, false));
            Cup19 = new MModelRenderer(this);
            this.setRotation(Cup19, 0.0F, 0.0F, 0.3491F);
            Cup18.addChild(Cup19);
            Cup19.cubeList.add(new ModelBox(Cup19, 39, 21, -11.7513F, -10.4213F, -0.25F, 2, 4, 1, 0.0F, false));
            Cup19.cubeList.add(new ModelBox(Cup19, 39, 21, -11.7513F, -10.4213F, -0.75F, 2, 4, 1, 0.0F, false));
            Cup19.cubeList.add(new ModelBox(Cup19, 39, 21, -15.0709F, -11.1748F, -0.4F, 2, 4, 1, 0.0F, false));
            Cup20 = new MModelRenderer(this);
            this.setRotation(Cup20, 0.0F, 0.0F, 0.3491F);
            Cup19.addChild(Cup20);
            Cup20.cubeList.add(new ModelBox(Cup20, 39, 21, -14.6069F, -8.7736F, -0.6F, 2, 3, 1, 0.0F, false));
            Cup20.cubeList.add(new ModelBox(Cup20, 39, 21, -13.7617F, -10.5863F, -0.4F, 1, 2, 1, 0.0F, false));
            Cup21 = new MModelRenderer(this);
            this.setRotation(Cup21, 0.0F, 0.0F, 0.4363F);
            Cup20.addChild(Cup21);
            Cup21.cubeList.add(new ModelBox(Cup21, 39, 21, -16.9463F, -3.7785F, -0.5F, 1, 3, 1, 0.0F, false));
            Cup22 = new MModelRenderer(this);
            this.setRotation(Cup22, 0.0F, 0.0F, 0.3491F);
            Cup19.addChild(Cup22);
            Cup22.cubeList.add(new ModelBox(Cup22, 39, 21, -15.0296F, -7.8673F, -0.4F, 1, 4, 1, 0.0F, false));
            Cup22.cubeList.add(new ModelBox(Cup22, 39, 21, -16.9579F, -8.1655F, -0.6F, 1, 3, 1, 0.0F, false));
            Cup23 = new MModelRenderer(this);
            this.setRotation(Cup23, 0.0F, 0.0F, 0.3491F);
            Cup22.addChild(Cup23);
            Cup23.cubeList.add(new ModelBox(Cup23, 39, 21, -18.728F, -1.8731F, -0.51F, 1, 3, 1, 0.0F, false));
            Cup24 = new MModelRenderer(this);
            this.setRotation(Cup24, 0.0F, 0.0F, -0.5236F);
            Cup18.addChild(Cup24);
            Cup24.cubeList.add(new ModelBox(Cup24, 39, 21, -4.7003F, -16.7685F, -0.6F, 2, 7, 1, 0.0F, false));
            Cup25 = new MModelRenderer(this);
            this.setRotation(Cup25, 0.0F, 0.0F, 0.3491F);
            Cup24.addChild(Cup25);
            Cup25.cubeList.add(new ModelBox(Cup25, 39, 21, -10.152F, -16.1496F, -0.61F, 1, 2, 1, 0.0F, false));
            Cup26 = new MModelRenderer(this);
            this.setRotation(Cup26, 0.0F, 0.0F, 0.6109F);
            Cup25.addChild(Cup26);
            Cup26.cubeList.add(new ModelBox(Cup26, 39, 21, -17.5791F, -7.4061F, -0.5F, 1, 2, 1, 0.0F, false));
            Cup27 = new MModelRenderer(this);
            this.setRotation(Cup27, 0.0F, 0.0F, -((float)Math.PI * 2F / 9F));
            Cup26.addChild(Cup27);
            Cup27.cubeList.add(new ModelBox(Cup27, 39, 21, -9.9914F, -15.4409F, -0.3F, 2, 5, 1, 0.0F, false));
            Cup28 = new MModelRenderer(this);
            this.setRotation(Cup28, 0.0F, 0.0F, -0.5236F);
            Cup24.addChild(Cup28);
            Cup28.cubeList.add(new ModelBox(Cup28, 39, 21, 1.16F, -17.6043F, -0.5F, 1, 2, 1, 0.0F, false));
            Cup29 = new MModelRenderer(this);
            this.setRotation(Cup29, 0.0F, 0.0F, -((float)Math.PI * 2F / 9F));
            Cup28.addChild(Cup29);
            Cup29.cubeList.add(new ModelBox(Cup29, 39, 21, 7.5718F, -11.7579F, -0.5F, 1, 4, 1, 0.0F, false));
            Cup30 = new MModelRenderer(this);
            this.setRotation(Cup30, 0.0F, 0.0F, -1.3963F);
            Cup29.addChild(Cup30);
            Cup30.cubeList.add(new ModelBox(Cup30, 39, 21, 7.9548F, 3.5096F, -0.4F, 2, 3, 1, 0.0F, false));
            Cup31 = new MModelRenderer(this);
            this.setRotation(Cup31, 0.0F, 0.0F, 0.3491F);
            Cup29.addChild(Cup31);
            Cup31.cubeList.add(new ModelBox(Cup31, 39, 21, 3.0937F, -13.6385F, -0.6F, 1, 8, 1, 0.0F, false));
            Cup32 = new MModelRenderer(this);
            this.setRotation(Cup32, 0.0F, 0.0F, -0.7854F);
            Cup29.addChild(Cup32);
            Cup32.cubeList.add(new ModelBox(Cup32, 39, 21, 6.5117F, -2.9435F, -0.5F, 4, 4, 1, 0.0F, false));
            Cup33 = new MModelRenderer(this);
            Cup33.setRotationPoint(8.3343F, -5.2242F, 0.0F);
            this.setRotation(Cup33, 0.0F, 0.0F, -1.5708F);
            Cup32.addChild(Cup33);
            Cup33.cubeList.add(new ModelBox(Cup33, 39, 21, -3.0728F, -1.8317F, -0.6289F, 1, 4, 1, 0.0F, false));
            Cup34 = new MModelRenderer(this);
            this.setRotation(Cup34, 0.0F, 0.0F, 0.3491F);
            Cup28.addChild(Cup34);
            Cup34.cubeList.add(new ModelBox(Cup34, 39, 21, -4.931F, -16.9394F, -0.6F, 1, 4, 1, 0.0F, false));
            Cup35 = new MModelRenderer(this);
            this.setRotation(Cup35, 0.0F, 0.0F, -0.7854F);
            Cup34.addChild(Cup35);
            Cup35.cubeList.add(new ModelBox(Cup35, 39, 21, 5.6627F, -12.6363F, -0.4F, 3, 4, 1, 0.0F, false));
            Cup36 = new MModelRenderer(this);
            Cup36.setRotationPoint(-5.1F, 1.0F, 0.0F);
            this.setRotation(Cup36, 0.0F, 0.0F, -0.0873F);
            Cup15.addChild(Cup36);
            Cup36.cubeList.add(new ModelBox(Cup36, 39, 21, 4.2878F, -4.966F, -0.9F, 2, 5, 2, 0.0F, false));
            Cup37 = new MModelRenderer(this);
            Cup37.setRotationPoint(-3.0F, -0.7F, 0.0F);
            this.setRotation(Cup37, 0.0F, 0.0F, 1.2217F);
            Cup36.addChild(Cup37);
            Cup37.cubeList.add(new ModelBox(Cup37, 39, 21, -1.5161F, -12.3074F, -1.0F, 2, 4, 2, 0.0F, false));
            Cup38 = new MModelRenderer(this);
            this.setRotation(Cup38, 0.0F, 0.0F, -1.0472F);
            Cup37.addChild(Cup38);
            Cup38.cubeList.add(new ModelBox(Cup38, 39, 21, 8.9005F, -9.7346F, -1.1F, 2, 4, 2, 0.0F, false));
            Cup38.cubeList.add(new ModelBox(Cup38, 39, 21, 10.3154F, -14.6619F, -0.5F, 2, 6, 1, 0.0F, false));
            Cup39 = new MModelRenderer(this);
            this.setRotation(Cup39, 0.0F, 0.0F, -0.3491F);
            Cup38.addChild(Cup39);
            Cup39.cubeList.add(new ModelBox(Cup39, 39, 21, 11.5725F, -9.4194F, -0.25F, 2, 4, 1, 0.0F, false));
            Cup39.cubeList.add(new ModelBox(Cup39, 39, 21, 11.5725F, -9.4194F, -0.75F, 2, 4, 1, 0.0F, false));
            Cup39.cubeList.add(new ModelBox(Cup39, 39, 21, 14.892F, -10.1729F, -0.4F, 2, 4, 1, 0.0F, false));
            Cup40 = new MModelRenderer(this);
            this.setRotation(Cup40, 0.0F, 0.0F, -0.3491F);
            Cup39.addChild(Cup40);
            Cup40.cubeList.add(new ModelBox(Cup40, 39, 21, 13.9756F, -7.2093F, -0.6F, 2, 3, 1, 0.0F, false));
            Cup40.cubeList.add(new ModelBox(Cup40, 39, 21, 14.1304F, -9.0219F, -0.4F, 1, 2, 1, 0.0F, false));
            Cup41 = new MModelRenderer(this);
            this.setRotation(Cup41, 0.0F, 0.0F, -0.4363F);
            Cup40.addChild(Cup41);
            Cup41.cubeList.add(new ModelBox(Cup41, 39, 21, 16.5256F, -1.7822F, -0.5F, 1, 3, 1, 0.0F, false));
            Cup42 = new MModelRenderer(this);
            this.setRotation(Cup42, 0.0F, 0.0F, -0.3491F);
            Cup39.addChild(Cup42);
            Cup42.cubeList.add(new ModelBox(Cup42, 39, 21, 15.3982F, -6.3029F, -0.4F, 1, 4, 1, 0.0F, false));
            Cup42.cubeList.add(new ModelBox(Cup42, 39, 21, 17.3266F, -6.6011F, -0.6F, 1, 3, 1, 0.0F, false));
            Cup43 = new MModelRenderer(this);
            this.setRotation(Cup43, 0.0F, 0.0F, -0.3491F);
            Cup42.addChild(Cup43);
            Cup43.cubeList.add(new ModelBox(Cup43, 39, 21, 18.4791F, 0.0651F, -0.51F, 1, 3, 1, 0.0F, false));
            Cup44 = new MModelRenderer(this);
            this.setRotation(Cup44, 0.0F, 0.0F, 0.5236F);
            Cup38.addChild(Cup44);
            Cup44.cubeList.add(new ModelBox(Cup44, 39, 21, 4.6385F, -17.5196F, -0.6F, 2, 7, 1, 0.0F, false));
            Cup45 = new MModelRenderer(this);
            this.setRotation(Cup45, 0.0F, 0.0F, -0.3491F);
            Cup44.addChild(Cup45);
            Cup45.cubeList.add(new ModelBox(Cup45, 39, 21, 11.2302F, -16.1925F, -0.6F, 1, 2, 1, 0.0F, false));
            Cup46 = new MModelRenderer(this);
            this.setRotation(Cup46, 0.0F, 0.0F, -0.6109F);
            Cup45.addChild(Cup46);
            Cup46.cubeList.add(new ModelBox(Cup46, 39, 21, 18.306F, -6.2492F, -0.5F, 1, 2, 1, 0.0F, false));
            Cup47 = new MModelRenderer(this);
            this.setRotation(Cup47, 0.0F, 0.0F, ((float)Math.PI * 2F / 9F));
            Cup46.addChild(Cup47);
            Cup47.cubeList.add(new ModelBox(Cup47, 39, 21, 10.0579F, -15.6647F, -0.3F, 2, 5, 1, 0.0F, false));
            Cup48 = new MModelRenderer(this);
            this.setRotation(Cup48, 0.0F, 0.0F, 0.5236F);
            Cup44.addChild(Cup48);
            Cup48.cubeList.add(new ModelBox(Cup48, 39, 21, -0.857F, -19.2238F, -0.5F, 1, 2, 1, 0.0F, false));
            Cup49 = new MModelRenderer(this);
            this.setRotation(Cup49, 0.0F, 0.0F, ((float)Math.PI * 2F / 9F));
            Cup48.addChild(Cup49);
            Cup49.cubeList.add(new ModelBox(Cup49, 39, 21, -8.6147F, -13.836F, -0.5F, 1, 4, 1, 0.0F, false));
            Cup50 = new MModelRenderer(this);
            this.setRotation(Cup50, 0.0F, 0.0F, 1.3963F);
            Cup49.addChild(Cup50);
            Cup50.cubeList.add(new ModelBox(Cup50, 39, 21, -12.0089F, 3.191F, -0.4F, 2, 3, 1, 0.0F, false));
            Cup51 = new MModelRenderer(this);
            this.setRotation(Cup51, 0.0F, 0.0F, -0.3491F);
            Cup49.addChild(Cup51);
            Cup51.cubeList.add(new ModelBox(Cup51, 39, 21, -3.4233F, -15.606F, -0.6F, 1, 8, 1, 0.0F, false));
            Cup52 = new MModelRenderer(this);
            this.setRotation(Cup52, 0.0F, 0.0F, 0.7854F);
            Cup49.addChild(Cup52);
            Cup52.cubeList.add(new ModelBox(Cup52, 39, 21, -12.0115F, -4.3826F, -0.5F, 4, 4, 1, 0.0F, false));
            Cup53 = new MModelRenderer(this);
            Cup53.setRotationPoint(-8.3343F, -5.2242F, 0.0F);
            this.setRotation(Cup53, 0.0F, 0.0F, 1.5708F);
            Cup52.addChild(Cup53);
            Cup53.cubeList.add(new ModelBox(Cup53, 39, 21, 0.6337F, -0.3319F, -0.6289F, 1, 4, 1, 0.0F, false));
            Cup54 = new MModelRenderer(this);
            this.setRotation(Cup54, 0.0F, 0.0F, -0.3491F);
            Cup48.addChild(Cup54);
            Cup54.cubeList.add(new ModelBox(Cup54, 39, 21, 5.7093F, -18.0156F, -0.6F, 1, 4, 1, 0.0F, false));
            Cup55 = new MModelRenderer(this);
            this.setRotation(Cup55, 0.0F, 0.0F, 0.7854F);
            Cup54.addChild(Cup55);
            Cup55.cubeList.add(new ModelBox(Cup55, 39, 21, -8.1663F, -14.6547F, -0.4F, 3, 4, 1, 0.0F, false));
            Cup57 = new MModelRenderer(this);
            Cup57.setRotationPoint(0.0F, -19.5F, 0.0F);
            Cup57.cubeList.add(new ModelBox(Cup57, 24, 52, -5.0F, 5.4F, -5.0F, 10, 2, 10, 0.0F, false));
            Cup57.cubeList.add(new ModelBox(Cup57, 24, 52, -4.0F, 5.1F, -5.9F, 8, 2, 2, 0.0F, false));
            Cup57.cubeList.add(new ModelBox(Cup57, 11, 59, -4.0F, 5.1F, 3.9F, 8, 2, 2, 0.0F, false));
            Cup56 = new MModelRenderer(this);
            Cup56.setRotationPoint(0.0F, -19.5F, 0.0F);
            this.setRotation(Cup56, 0.0F, 0.0F, -0.2618F);
            Cup56.cubeList.add(new ModelBox(Cup56, 42, 45, 2.7F, 6.3F, -4.0F, 3, 2, 8, 0.0F, false));
            Cup59 = new MModelRenderer(this);
            Cup59.cubeList.add(new ModelBox(Cup59, 6, 55, -3.8F, -10.9F, -3.0F, 1, 1, 6, 0.0F, false));
            Cup59.cubeList.add(new ModelBox(Cup59, 6, 55, 2.8F, -10.9F, -3.0F, 1, 1, 6, 0.0F, false));
            Cup59.cubeList.add(new ModelBox(Cup59, 6, 55, -3.0F, -10.8F, -3.5F, 6, 1, 7, 0.0F, false));
            Cup59.cubeList.add(new ModelBox(Cup59, 6, 55, 3.6F, -11.0F, -2.0F, 1, 1, 4, 0.0F, false));
            Cup59.cubeList.add(new ModelBox(Cup59, 6, 55, -4.6F, -11.1F, -2.0F, 1, 1, 4, 0.0F, false));
            Cup59.cubeList.add(new ModelBox(Cup59, 6, 55, -5.0F, -11.3F, -1.0F, 1, 1, 2, 0.0F, false));
            Cup59.cubeList.add(new ModelBox(Cup59, 6, 55, 4.0F, -11.2F, -1.0F, 1, 1, 2, 0.0F, false));
            Cup59.cubeList.add(new ModelBox(Cup59, 6, 55, -3.0F, -10.8F, -3.5F, 6, 1, 7, 0.0F, false));
            Cup58 = new MModelRenderer(this);
            Cup58.cubeList.add(new ModelBox(Cup58, 36, 43, -3.0F, -12.7F, -4.001F, 6, 2, 8, 0.0F, false));
            Cup58.cubeList.add(new ModelBox(Cup58, 36, 43, 2.4F, -12.9F, -4.0F, 2, 2, 8, 0.0F, false));
            Cup58.cubeList.add(new ModelBox(Cup58, 36, 43, 3.7F, -13.1F, -3.0F, 2, 2, 6, 0.0F, false));
            Cup58.cubeList.add(new ModelBox(Cup58, 36, 43, -6.5F, -13.3F, -2.0F, 2, 2, 4, 0.0F, false));
            Cup58.cubeList.add(new ModelBox(Cup58, 36, 43, -4.4F, -12.9F, -4.0F, 2, 2, 8, 0.0F, false));
            Cup58.cubeList.add(new ModelBox(Cup58, 36, 43, -5.8F, -13.1F, -3.0F, 2, 2, 6, 0.0F, false));
            Cup58.cubeList.add(new ModelBox(Cup58, 36, 43, 4.5F, -13.3F, -2.0F, 2, 2, 4, 0.0F, false));
            Cup63 = new MModelRenderer(this);
            Cup63.setRotationPoint(0.0F, -23.0F, 0.0F);
            this.setRotation(Cup63, -0.7854F, -0.7854F, -0.7854F);
            Cup63.cubeList.add(new ModelBox(Cup63, 32, 0, -2.9F, 4.1F, 4.6F, 1, 1, 1, 0.0F, false));
            Cup65 = new MModelRenderer(this);
            Cup65.setRotationPoint(0.0F, -23.0F, 0.0F);
            this.setRotation(Cup65, -0.1745F, 0.2618F, -0.2618F);
            Cup65.cubeList.add(new ModelBox(Cup65, 32, 0, 5.6F, 0.8F, 1.1F, 1, 1, 1, 0.0F, false));
            Cup64 = new MModelRenderer(this);
            Cup64.setRotationPoint(0.0F, -23.0F, 0.0F);
            this.setRotation(Cup64, 0.1745F, -0.5236F, -0.2618F);
            Cup64.cubeList.add(new ModelBox(Cup64, 32, 0, -5.0F, -0.5F, 4.9F, 1, 1, 1, 0.0F, false));
            Cup67 = new MModelRenderer(this);
            Cup67.setRotationPoint(0.0F, -23.0F, 0.0F);
            this.setRotation(Cup67, 0.0F, 0.0F, -0.0873F);
            Cup67.cubeList.add(new ModelBox(Cup67, 32, 0, 0.0F, -0.4F, -7.0F, 1, 1, 1, 0.0F, false));
            Cup66 = new MModelRenderer(this);
            Cup66.setRotationPoint(0.0F, -23.0F, 0.0F);
            this.setRotation(Cup66, 0.0F, -0.4363F, 0.7854F);
            Cup66.cubeList.add(new ModelBox(Cup66, 32, 0, -4.0F, -7.3F, -0.2F, 1, 1, 1, 0.0F, false));
            Cup68 = new MModelRenderer(this);
            Cup68.setRotationPoint(0.0F, -23.0F, 0.0F);
            this.setRotation(Cup68, 0.1745F, -0.1745F, -0.1745F);
            Cup68.cubeList.add(new ModelBox(Cup68, 32, 0, -0.2F, -2.2F, 6.5F, 1, 1, 1, 0.0F, false));
            Cup69 = new MModelRenderer(this);
            Cup69.setRotationPoint(0.0F, -23.0F, 0.0F);
            this.setRotation(Cup69, 0.0873F, -0.4363F, -0.6109F);
            Cup69.cubeList.add(new ModelBox(Cup69, 32, 0, 5.8F, 2.5F, 1.9F, 1, 1, 1, 0.0F, false));
            Cup61 = new MModelRenderer(this);
            Cup61.setRotationPoint(0.0F, -23.0F, 0.0F);
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, -4.0F, -3.9F, -4.0F, 8, 8, 8, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, -3.0F, -2.9F, 4.0F, 6, 6, 1, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, 4.0F, -2.9F, -3.0F, 1, 6, 6, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, -3.0F, -4.9F, -3.0F, 6, 1, 6, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, -3.0F, 4.1F, -3.0F, 6, 1, 6, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, -5.0F, -2.9F, -3.0F, 1, 6, 6, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, -3.0F, -2.9F, -5.0F, 6, 6, 1, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, -4.5F, -3.4F, -3.5F, 9, 7, 7, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, -3.5F, -4.4F, -3.5F, 7, 9, 7, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, -3.5F, -3.4F, -4.5F, 7, 7, 9, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, -2.0F, -1.9F, 4.25F, 4, 4, 1, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, 4.25F, -1.9F, -2.0F, 1, 4, 4, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, -5.25F, -1.9F, -2.0F, 1, 4, 4, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, -2.0F, 4.35F, -2.0F, 4, 1, 4, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, -2.0F, -5.15F, -2.0F, 4, 1, 4, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, -2.0F, -1.9F, -5.25F, 4, 4, 1, 0.0F, false));
            Cup61.cubeList.add(new ModelBox(Cup61, 32, 0, -2.0F, -1.9F, -2.0F, 4, 4, 4, 0.0F, false));
        }

        BBAnimationLoader bbanimationloader = new BBAnimationLoader(new ResourceLocation("minidot", "pets/panteon_animation.json"));
        this.anim = bbanimationloader.mustGet("panteon.anim", this);
        this.setTexture(new ResourceLocation("minidot:pets/panteon_" + type + ".png"));
    }

    protected void processMotion(ModelPlayer modelPlayer, EntityPlayer player, float time)
    {
        float f = MathHelper.sin(time * 0.1F) * 0.05F;
        GlStateManager.translate(0.7F, 0.0F + f, 0.5F);
        GlStateManager.scale(0.75F, 0.75F, 0.75F);
        this.anim.tick(time);
    }

    public void render(ModelPlayer modelPlayer, EntityPlayer player, float time, MiniDotPlayer pi)
    {
        GlStateManager.enableCull();
        super.render(modelPlayer, player, time, pi);
        GlStateManager.disableCull();
    }

    public void renderAsItem(float time)
    {
        GlStateManager.translate(0.0F, 0.37F, 0.0F);
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
        this.anim.tick(time);
        super.renderAsItem(time);
    }

    public String getName()
    {
        String s = this.type;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -1380612710:
                if (s.equals("bronze"))
                {
                    b0 = 2;
                }

                break;

            case -902311155:
                if (s.equals("silver"))
                {
                    b0 = 3;
                }

                break;

            case 110308:
                if (s.equals("org"))
                {
                    b0 = 5;
                }

                break;

            case 3178592:
                if (s.equals("gold"))
                {
                    b0 = 4;
                }

                break;

            case 3181382:
                if (s.equals("grid"))
                {
                    b0 = 1;
                }

                break;

            case 853620882:
                if (s.equals("classic"))
                {
                    b0 = 0;
                }
        }

        switch (b0)
        {
            case 0:
                return "\u041a\u0443\u0431\u043e\u043a";

            case 1:
                return "\u041a\u0430\u043c\u0435\u043d\u043d\u044b\u0439 \u043a\u0443\u0431\u043e\u043a";

            case 2:
                return "\u0411\u0440\u043e\u043d\u0437\u043e\u0432\u044b\u0439 \u043a\u0443\u0431\u043e\u043a";

            case 3:
                return "\u0421\u0435\u0440\u0435\u0431\u0440\u044f\u043d\u044b\u0439 \u043a\u0443\u0431\u043e\u043a";

            case 4:
                return "\u0417\u043e\u043b\u043e\u0442\u043e\u0439 \u043a\u0443\u0431\u043e\u043a";

            case 5:
                return "\u0421\u0442\u0435\u043a\u043b\u044f\u043d\u043d\u044b\u0439 \u043a\u0443\u0431\u043e\u043a";

            default:
                return "\u0419\u0443\u0445";
        }
    }

    public List<String> getDescription()
    {
        String s = this.type;
        byte b0 = -1;

        switch (s.hashCode())
        {
            case -1380612710:
                if (s.equals("bronze"))
                {
                    b0 = 2;
                }

                break;

            case -902311155:
                if (s.equals("silver"))
                {
                    b0 = 3;
                }

                break;

            case 110308:
                if (s.equals("org"))
                {
                    b0 = 5;
                }

                break;

            case 3178592:
                if (s.equals("gold"))
                {
                    b0 = 4;
                }

                break;

            case 3181382:
                if (s.equals("grid"))
                {
                    b0 = 1;
                }

                break;

            case 853620882:
                if (s.equals("classic"))
                {
                    b0 = 0;
                }
        }

        switch (b0)
        {
            case 0:
                return Collections.<String>singletonList("\u0417\u0430 \u0443\u0447\u0430\u0441\u0442\u0438\u0435 \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars VimeWorld Cup");

            case 1:
                return Collections.<String>singletonList("\u0417\u0430 \u043f\u043e\u043f\u0430\u0434\u0430\u043d\u0438\u0435 \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u043d\u0443\u044e \u0441\u0435\u0442\u043a\u0443 " + EnumChatFormatting.AQUA + "BedWars VimeWorld Cup");

            case 2:
                return Collections.<String>singletonList("\u0417\u0430 \u0442\u0440\u0435\u0442\u044c\u0435 \u043c\u0435\u0441\u0442\u043e \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars VimeWorld Cup");

            case 3:
                return Collections.<String>singletonList("\u0417\u0430 \u0432\u0442\u043e\u0440\u043e\u0435 \u043c\u0435\u0441\u0442\u043e \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars VimeWorld Cup");

            case 4:
                return Collections.<String>singletonList("\u0417\u0430 \u043f\u043e\u0431\u0435\u0434\u0443 \u0432 \u0442\u0443\u0440\u043d\u0438\u0440\u0435 " + EnumChatFormatting.AQUA + "BedWars VimeWorld Cup");

            case 5:
                return Collections.<String>singletonList("\u0417\u0430 \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u044e \u0442\u0443\u0440\u043d\u0438\u0440\u0430 " + EnumChatFormatting.AQUA + "BedWars VimeWorld Cup");

            default:
                return null;
        }
    }
}
