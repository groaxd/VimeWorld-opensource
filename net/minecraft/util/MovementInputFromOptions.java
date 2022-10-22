package net.minecraft.util;

import net.minecraft.client.settings.GameSettings;
import net.xtrafrancyz.covered.ObfValue;

public class MovementInputFromOptions extends MovementInput
{
    private static final ObfValue.ODouble OBFVAL_oODMj = ObfValue.create(0.3D);
    private final GameSettings gameSettings;

    public MovementInputFromOptions(GameSettings gameSettingsIn)
    {
        this.gameSettings = gameSettingsIn;
    }

    public void updatePlayerMoveState()
    {
        this.moveStrafe = 0.0F;
        this.moveForward = 0.0F;

        if (this.gameSettings.keyBindForward.isKeyDown())
        {
            ++this.moveForward;
        }

        if (this.gameSettings.keyBindBack.isKeyDown())
        {
            --this.moveForward;
        }

        if (this.gameSettings.keyBindLeft.isKeyDown())
        {
            ++this.moveStrafe;
        }

        if (this.gameSettings.keyBindRight.isKeyDown())
        {
            --this.moveStrafe;
        }

        this.jump = this.gameSettings.keyBindJump.isKeyDown();
        this.sneak = this.gameSettings.keyBindSneak.isKeyDown();

        if (this.sneak)
        {
            this.moveStrafe = (float)((double)this.moveStrafe * OBFVAL_oODMj.get());
            this.moveForward = (float)((double)this.moveForward * OBFVAL_oODMj.get());
        }
    }

    static
    {
        ObfValue.beginGeneration();
        ObfValue.endGeneration(new byte[] {(byte)0, (byte)0, (byte)0, (byte)0, (byte)12, (byte) - 32, (byte)0, (byte)0});
    }
}
