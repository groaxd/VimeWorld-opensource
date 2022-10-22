package net.xtrafrancyz.mods.pvp.gui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.pvp.PvpOptions;
import net.xtrafrancyz.mods.texteria.gui.GuiElementWrapper;
import net.xtrafrancyz.mods.texteria.util.TRenderUtil;

public class GuiPvPScreen extends GuiScreen
{
    protected static final int BTN_DONE = 200;
    protected final GuiScreen parent;
    protected final String title;
    protected final List<GuiPvPScreen.GuiColorSection> sectionList = new ArrayList();
    protected boolean modified;
    private int index = 0;

    public GuiPvPScreen(GuiScreen parent, String title)
    {
        this.parent = parent;
        this.title = title;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
        this.buttonList.clear();
        this.sectionList.clear();
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, I18n.format("gui.done", new Object[0])));
        this.index = 0;
        this.onInit();
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if (button.enabled)
        {
            if (button.id == 200)
            {
                this.mc.displayGuiScreen(this.parent);
            }
            else
            {
                this.onButtonAction(button);
            }
        }
    }

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 20, 16777215);

        for (GuiPvPScreen.GuiColorSection guipvpscreen$guicolorsection : this.sectionList)
        {
            guipvpscreen$guicolorsection.drawSection();
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed()
    {
        if (this.modified)
        {
            PvpOptions.save();
            this.modified = false;
        }
    }

    protected void onInit()
    {
    }

    protected void onButtonAction(GuiButton button)
    {
    }

    protected GuiButton addButton(int id, String text)
    {
        return this.addButton(id, text, 1);
    }

    protected GuiButton addButton(int id, String text, int indexSkip)
    {
        GuiButton guibutton = new GuiButton(id, this.getButtonX(), this.getButtonY(), 150, 20, text);
        this.buttonList.add(guibutton);
        this.index += indexSkip;
        return guibutton;
    }

    protected GuiPvPScreen.GuiColorSection addSection(int id, int color)
    {
        return this.addSection(id, color, 1);
    }

    protected GuiPvPScreen.GuiColorSection addSection(int id, int color, int indexSkip)
    {
        GuiPvPScreen.GuiColorSection guipvpscreen$guicolorsection = new GuiPvPScreen.GuiColorSection(id, this.getButtonX(), this.getButtonY(), 150, 14, color);
        this.sectionList.add(guipvpscreen$guicolorsection);
        this.index += indexSkip;
        return guipvpscreen$guicolorsection;
    }

    private int getButtonX()
    {
        return this.width / 2 - 155 + this.index % 2 * 160;
    }

    private int getButtonY()
    {
        return this.height / 6 + 24 * (this.index >> 1);
    }

    protected void drawGradientHorizontalRect(int left, int top, int right, int bottom, int startColor, int endColor)
    {
        float f = (float)(startColor >> 24 & 255) / 255.0F;
        float f1 = (float)(startColor >> 16 & 255) / 255.0F;
        float f2 = (float)(startColor >> 8 & 255) / 255.0F;
        float f3 = (float)(startColor & 255) / 255.0F;
        float f4 = (float)(endColor >> 24 & 255) / 255.0F;
        float f5 = (float)(endColor >> 16 & 255) / 255.0F;
        float f6 = (float)(endColor >> 8 & 255) / 255.0F;
        float f7 = (float)(endColor & 255) / 255.0F;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos((double)right, (double)top, (double)this.zLevel).color(f5, f6, f7, f4).endVertex();
        worldrenderer.pos((double)left, (double)top, (double)this.zLevel).color(f1, f2, f3, f).endVertex();
        worldrenderer.pos((double)left, (double)bottom, (double)this.zLevel).color(f1, f2, f3, f).endVertex();
        worldrenderer.pos((double)right, (double)bottom, (double)this.zLevel).color(f5, f6, f7, f4).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    protected static void setEnabled(GuiButton button, boolean enabled)
    {
        if (button instanceof GuiPvPScreen.GuiColorButton)
        {
            GuiPvPScreen.GuiColorButton guipvpscreen$guicolorbutton = (GuiPvPScreen.GuiColorButton)button;
            guipvpscreen$guicolorbutton.section.setEnabled(enabled);
        }
        else
        {
            button.enabled = enabled;
        }
    }

    protected static String getBoolOptionText(String prefix, boolean value)
    {
        return prefix + ": " + (value ? "\u0412\u041a\u041b" : "\u0412\u042b\u041a\u041b");
    }

    protected static String getPositionText(GuiElementWrapper wrapper)
    {
        String s = null;

        switch (wrapper.element.pos)
        {
            case LEFT:
                s = "\u0421\u043b\u0435\u0432\u0430";
                break;

            case TOP_RIGHT:
                s = "\u0421\u043f\u0440\u0430\u0432\u0430 \u0441\u0432\u0435\u0440\u0445\u0443";
                break;

            case BOTTOM_RIGHT:
                s = "\u0421\u043f\u0440\u0430\u0432\u0430 \u0441\u043d\u0438\u0437\u0443";
        }

        return "\u041c\u0435\u0441\u0442\u043e: " + s;
    }

    protected static String getTextAnimation(int textAnimation)
    {
        String s = null;

        switch (textAnimation)
        {
            case 0:
                s = "\u0412\u042b\u041a\u041b";
                break;

            case 1:
                s = "\u0420\u0430\u0434\u0443\u0433\u0430";
                break;

            case 2:
                s = "\u0425\u0440\u043e\u043c\u0430";
        }

        return "\u0410\u043d\u0438\u043c\u0430\u0446\u0438\u044f \u0446\u0432\u0435\u0442\u0430 \u0442\u0435\u043a\u0441\u0442\u0430: " + s;
    }

    public class GuiColorButton extends GuiButton
    {
        protected final GuiPvPScreen.GuiColorSection section;
        protected final String prefix;
        protected float value;
        protected boolean pressed;

        public GuiColorButton(GuiPvPScreen.GuiColorSection section, int buttonId, int x, int y, int widthIn, int heightIn, String prefix, float value)
        {
            super(buttonId, x, y, widthIn, heightIn, (String)null);
            this.section = section;
            this.prefix = prefix;
            this.value = value;
            this.setDisplayName();
        }

        protected void updateValue(int mouseX)
        {
            float f = (float)(mouseX - (this.xPosition + 4)) / (float)(this.width - 8);
            f = MathHelper.clamp_float(f, 0.0F, 1.0F);

            if (this.value != f)
            {
                this.value = f;
                this.section.updateColor();
                this.setDisplayName();
                GuiPvPScreen.this.onButtonAction(this);
            }
        }

        protected void setDisplayName()
        {
        }

        protected void drawButtonBackground()
        {
        }

        protected int getHoverState(boolean mouseOver)
        {
            return 0;
        }

        public void drawButton(Minecraft mc, int mouseX, int mouseY)
        {
            if (this.visible)
            {
                this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                GlStateManager.blendFunc(770, 771);
                drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 1728053247);
                this.drawButtonBackground();
                this.mouseDragged(mc, mouseX, mouseY);
                int i = 14737632;

                if (!this.enabled)
                {
                    i = 10526880;
                }
                else if (this.hovered)
                {
                    i = 16777120;
                }

                this.drawCenteredString(mc.fontRendererObj, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, i);
            }
        }

        protected void mouseDragged(Minecraft mc, int mouseX, int mouseY)
        {
            if (this.visible)
            {
                if (this.pressed)
                {
                    this.updateValue(mouseX);
                }

                int i = this.xPosition + (int)(this.value * (float)(this.width - 4));
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                drawRect(i, this.yPosition, i + 4, this.yPosition + this.height, Integer.MAX_VALUE);
                drawRect(i + 1, this.yPosition + 1, i + 3, this.yPosition + this.height - 1, Integer.MAX_VALUE);
            }
        }

        public boolean mousePressed(Minecraft mc, int mouseX, int mouseY)
        {
            if (super.mousePressed(mc, mouseX, mouseY))
            {
                this.updateValue(mouseX);
                this.pressed = true;
                return true;
            }
            else
            {
                return false;
            }
        }

        public void playPressSound(SoundHandler soundHandlerIn)
        {
        }

        public void mouseReleased(int mouseX, int mouseY)
        {
            if (this.pressed)
            {
                GuiPvPScreen.this.mc.getSoundHandler().playSound(PositionedSoundRecord.create(new ResourceLocation("gui.button.press"), 1.0F));
            }

            this.pressed = false;
        }
    }

    public class GuiColorSection
    {
        private final int id;
        private final int x;
        private final int y;
        private final int width;
        private final int height;
        private final GuiPvPScreen.GuiColorButton hueButton;
        private final GuiPvPScreen.GuiColorButton saturationButton;
        private final GuiPvPScreen.GuiColorButton brightnessButton;
        private boolean enabled = true;
        public int origColor;
        public int color;

        public GuiColorSection(int id, int x, int y, int width, int height, int color)
        {
            this.id = id;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            float[] afloat = Color.RGBtoHSB(color >> 16 & 255, color >> 8 & 255, color & 255, (float[])null);
            this.hueButton = GuiPvPScreen.this.new GuiTexturedButton(this, id, x, y + 4 + height, width, height, "\u0426\u0432\u0435\u0442\u043e\u0432\u043e\u0439 \u0442\u043e\u043d", afloat[0]);
            GuiPvPScreen.this.buttonList.add(this.hueButton);
            this.saturationButton = GuiPvPScreen.this.new GuiGradientButton(this, id, x, y + (4 + height) * 2, width, height, "\u041d\u0430\u0441\u044b\u0449\u0435\u043d\u043d\u043e\u0441\u0442\u044c", afloat[1], -1);
            GuiPvPScreen.this.buttonList.add(this.saturationButton);
            this.brightnessButton = GuiPvPScreen.this.new GuiGradientButton(this, id, x, y + (4 + height) * 3, width, height, "\u042f\u0440\u043a\u043e\u0441\u0442\u044c", afloat[2], -16777216);
            GuiPvPScreen.this.buttonList.add(this.brightnessButton);
            this.updateColor();
        }

        public void setEnabled(boolean enabled)
        {
            if (this.enabled != enabled)
            {
                this.enabled = enabled;
                this.hueButton.enabled = enabled;
                this.saturationButton.enabled = enabled;
                this.brightnessButton.enabled = enabled;
            }
        }

        public void updateColor()
        {
            this.origColor = Color.HSBtoRGB(this.hueButton.value, 1.0F, 1.0F);
            this.color = Color.HSBtoRGB(this.hueButton.value, this.saturationButton.value, this.brightnessButton.value);
        }

        public void drawSection()
        {
            int i = this.x + (this.width - this.width / 4) / 2;
            int j = this.y + (this.height - 8) / 2;
            GuiPvPScreen.this.drawCenteredString(GuiPvPScreen.this.mc.fontRendererObj, "\u0426\u0432\u0435\u0442 \u0442\u0435\u043a\u0441\u0442\u0430:", i, j, 14737632);
            Gui.drawRect(this.x + this.width - this.width / 4, this.y, this.x + this.width, this.y + this.height, 1728053247);
            Gui.drawRect(this.x + this.width - this.width / 4 + 1, this.y + 1, this.x + this.width - 1, this.y + this.height - 1, this.color);
        }
    }

    private class GuiGradientButton extends GuiPvPScreen.GuiColorButton
    {
        private final int startColor;

        public GuiGradientButton(GuiPvPScreen.GuiColorSection section, int buttonId, int x, int y, int widthIn, int heightIn, String prefix, float value, int startColor)
        {
            super(section, buttonId, x, y, widthIn, heightIn, prefix, value);
            this.startColor = startColor;
        }

        protected void setDisplayName()
        {
            this.displayString = this.prefix + ": " + (int)(this.value * 100.0F) + "%";
        }

        protected void drawButtonBackground()
        {
            GuiPvPScreen.this.drawGradientHorizontalRect(this.xPosition + 1, this.yPosition + 1, this.xPosition + this.width - 1, this.yPosition + this.height - 1, this.startColor, this.section.origColor);
        }
    }

    private class GuiTexturedButton extends GuiPvPScreen.GuiColorButton
    {
        private DynamicTexture texture;

        public GuiTexturedButton(GuiPvPScreen.GuiColorSection section, int buttonId, int x, int y, int widthIn, int heightIn, String prefix, float value)
        {
            super(section, buttonId, x, y, widthIn, heightIn, prefix, value);
            this.drawColorSelector();
        }

        private void drawColorSelector()
        {
            BufferedImage bufferedimage = new BufferedImage(this.width - 2, this.height - 2, 2);

            for (int i = 0; i < bufferedimage.getWidth(); ++i)
            {
                int j = Color.HSBtoRGB((float)i / ((float)bufferedimage.getWidth() * 1.0F), 1.0F, 1.0F);

                for (int k = 0; k < bufferedimage.getHeight(); ++k)
                {
                    bufferedimage.setRGB(i, k, j);
                }
            }

            this.texture = new DynamicTexture(bufferedimage);
        }

        protected void setDisplayName()
        {
            this.displayString = this.prefix + ": " + (int)(this.value * 360.0F) + "\u00b0";
        }

        protected void drawButtonBackground()
        {
            GlStateManager.bindTexture(this.texture.getGlTextureId());
            TRenderUtil.drawTexturedRect(this.xPosition + 1, this.yPosition + 1, 0.0F, 0.0F, (float)(this.width - 2), (float)(this.height - 2), (float)(this.width - 2), (float)(this.height - 2));
        }
    }
}
