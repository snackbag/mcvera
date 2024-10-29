package net.snackbag.mcvera.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

/**
 * Existence is required for mouse movements
 */
public class VeraVisibilityScreen extends Screen {
    public VeraVisibilityScreen() {
        super(Text.of("Vera"));
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}