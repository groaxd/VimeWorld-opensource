package net.xtrafrancyz.mods.minidot.gui;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.xtrafrancyz.mods.minidot.MiniDot;
import net.xtrafrancyz.mods.minidot.MiniDotPlayer;
import net.xtrafrancyz.mods.minidot.items.ItemType;
import org.lwjgl.input.Mouse;

public class MGuiMain extends GuiScreen
{
    public static final ResourceLocation BACKGROUND = new ResourceLocation("minidot", "gui/main.png");
    private final int windowWidth = 256;
    private final int windowHeight = 184;
    public int guiLeft;
    public int guiTop;
    GuiButton btnBack;
    private GuiButton btnHead;
    private GuiButton btnMask;
    private GuiButton btnBody;
    private GuiButton btnPets;
    private GuiButton btnExit;
    private ModalGui modal;
    private String title;
    private boolean backClicked = false;
    MiniDotPlayer previewPlayerData = null;

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
        super.initGui();
        this.guiLeft = (this.width - 256) / 2;
        this.guiTop = (this.height - 184) / 2;
        this.buttonList.add(this.btnBack = new GuiButton(-51, this.guiLeft + 99, this.guiTop + 144 + 15 + 2, 80, 18, "\u041d\u0430\u0437\u0430\u0434"));
        this.buttonList.clear();
        this.buttonList.add(this.btnHead = new GuiButton(1, this.guiLeft + 121, this.guiTop + 25, 100, 20, "\u0413\u043e\u043b\u043e\u0432\u0430"));
        this.buttonList.add(this.btnMask = new GuiButton(2, this.guiLeft + 121, this.guiTop + 50, 100, 20, "\u041c\u0430\u0441\u043a\u0430 (\u0413\u043e\u043b\u043e\u0432\u0430)"));
        this.buttonList.add(this.btnBody = new GuiButton(3, this.guiLeft + 121, this.guiTop + 75, 100, 20, "\u0422\u0435\u043b\u043e"));
        this.buttonList.add(this.btnPets = new GuiButton(4, this.guiLeft + 121, this.guiTop + 100, 100, 20, "\u041f\u0438\u0442\u043e\u043c\u0446\u044b"));
        this.buttonList.add(this.btnExit = new GuiButton(-52, this.guiLeft + 10, this.guiTop + 184 - 23, 236, 18, "\u041e\u0431\u0440\u0430\u0442\u043d\u043e \u0432 \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c"));
        ModalGui modalgui = this.modal;
        this.modal = null;
        this.setModal(modalgui);
    }

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(BACKGROUND);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, 256, 184);
        MiniDotPlayer minidotplayer = MiniDot.instance.getLocalPlayer();
        MiniDot.instance.setLocalPlayer(this.previewPlayerData);
        ScaledResolution scaledresolution = new ScaledResolution(this.mc);
        int i = scaledresolution.getScaledWidth() / 2;
        int j = scaledresolution.getScaledHeight() / 2;
        drawEntityOnScreen(this.guiLeft + 48, this.guiTop + 140, 50, i + 43 - mouseX, j - mouseY, this.mc.thePlayer);
        MiniDot.instance.setLocalPlayer(minidotplayer);
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.drawStringCentered(EnumChatFormatting.BOLD + this.title, this.guiLeft + 172, this.guiTop + 4, -13421773);

        if (this.modal != null)
        {
            this.modal.draw(mouseX, mouseY);
        }

        this.backClicked = false;
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if (!this.backClicked)
        {
            ModalGui modalgui = null;

            switch (button.id)
            {
                case -52:
                    this.mc.displayGuiScreen(new GuiInventory(this.mc.thePlayer));
                    break;

                case -51:
                    this.setModal((ModalGui)null);
                    this.backClicked = true;
                    break;

                case 1:
                    modalgui = new ModalSelectItemGui(ItemType.HEAD);
                    break;

                case 2:
                    modalgui = new ModalSelectItemGui(ItemType.MASK);
                    break;

                case 3:
                    modalgui = new ModalSelectItemGui(ItemType.BODY);
                    break;

                case 4:
                    modalgui = new ModalSelectItemGui(ItemType.PET);
            }

            if (modalgui != null)
            {
                this.setModal(modalgui);
            }
            else if (this.modal != null && button.id > 1000)
            {
                this.modal.actionPerformed(button);
            }
        }
    }

    /**
     * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
     */
    protected void mouseClicked(int mouseX, int mouseY, int par3) throws IOException
    {
        boolean flag = false;

        if (this.modal != null)
        {
            flag = this.modal.mouseClicked(mouseX, mouseY, par3);
        }

        if (!flag)
        {
            super.mouseClicked(mouseX, mouseY, par3);
        }
    }

    /**
     * Handles mouse input.
     */
    public void handleMouseInput() throws IOException
    {
        super.handleMouseInput();

        if (this.modal != null)
        {
            int i = Mouse.getEventDWheel();

            if (i != 0)
            {
                if (i > 1)
                {
                    i = 1;
                }

                if (i < -1)
                {
                    i = -1;
                }

                this.modal.scroll(i);
            }
        }
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();

        if (this.modal != null)
        {
            this.modal.updateScreen();
        }
    }

    public void setModal(ModalGui modal)
    {
        this.buttonList.remove(this.btnBack);
        this.btnBack = new GuiButton(-51, this.guiLeft + 99, this.guiTop + 144 + 15 + 2, 80, 18, "\u041d\u0430\u0437\u0430\u0434");
        this.buttonList.add(this.btnBack);
        boolean flag = modal == null;
        this.btnHead.visible = flag;
        this.btnMask.visible = flag;
        this.btnBody.visible = flag;
        this.btnPets.visible = flag;
        this.btnExit.visible = flag;
        this.btnBack.visible = !flag;
        MiniDotPlayer minidotplayer = MiniDot.instance.getLocalPlayer();
        this.previewPlayerData = new MiniDotPlayer(minidotplayer);
        this.previewPlayerData.prevPetBodyYawOffset = minidotplayer.prevPetBodyYawOffset;

        if (this.modal != null)
        {
            this.modal.onGuiClosed();
            this.buttonList.removeIf((button) ->
            {
                return button.id > 1000;
            });
        }

        if (flag)
        {
            this.title = "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0430 \u0432\u0438\u0434\u0430";
        }
        else
        {
            modal.parent = this;

            if (modal instanceof ModalSelectItemGui)
            {
                this.title = ((ModalSelectItemGui)modal).type.getName();
            }
            else if (modal instanceof ModalUnlockItemGui)
            {
                this.title = "\u0420\u0430\u0437\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u043a\u0430 \u0432\u0435\u0449\u0438";
            }

            modal.initGui();
        }

        this.modal = modal;
    }

    public void addButton(GuiButton button)
    {
        this.buttonList.add(button);
    }

    public void drawStringCentered(String str, int posX, int posY, int color)
    {
        this.fontRendererObj.drawString(str, posX - this.fontRendererObj.getStringWidth(str) / 2, posY, color);
    }

    public void drawString(String str, int posX, int posY, int color)
    {
        this.fontRendererObj.drawString(str, posX, posY, color);
    }

    public int getStringWidth(String str)
    {
        return this.fontRendererObj.getStringWidth(str);
    }

    public void drawHoveringText(int mouseX, int mouseY, List<String> text)
    {
        int int = mouseX - this.guiLeft;
        int int = mouseY - this.guiTop;
        this.drawHoveringText(text, int - 95, int - 18);
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    /**
     * Fired when a key is typed (except F11 which toggles full screen). This is the equivalent of
     * KeyListener.keyTyped(KeyEvent e). Args : character (character on the key), keyCode (lwjgl Keyboard key code)
     */
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        if (keyCode == 1 || keyCode == this.mc.gameSettings.keyBindInventory.getKeyCode())
        {
            this.mc.thePlayer.closeScreen();
        }
    }

    private static void drawEntityOnScreen(int posX, int posY, int scale, int mouseX, int mouseY, EntityLivingBase ent)
    {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)posX, (float)posY, 500.0F);
        GlStateManager.scale((float)(-scale), (float)scale, (float)scale);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float float = ent.renderYawOffset;
        float float = ent.rotationYaw;
        float float = ent.rotationPitch;
        float float = ent.prevRotationYawHead;
        float float = ent.rotationYawHead;
        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
        ent.renderYawOffset = (float)((mouseX > 0 ? 1 : -1) * mouseX * mouseX) * 0.005F;
        ent.rotationYaw = ent.renderYawOffset;
        ent.rotationPitch = -((float)Math.atan((double)((float)mouseY / 40.0F))) * 20.0F;
        ent.rotationYawHead = ent.rotationYaw;
        ent.prevRotationYawHead = ent.rotationYaw;
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.setPlayerViewY(180.0F);
        rendermanager.setRenderShadow(false);
        rendermanager.renderEntityWithPosYaw(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        rendermanager.setRenderShadow(true);
        ent.renderYawOffset = float;
        ent.rotationYaw = float;
        ent.rotationPitch = float;
        ent.prevRotationYawHead = float;
        ent.rotationYawHead = float;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
}
