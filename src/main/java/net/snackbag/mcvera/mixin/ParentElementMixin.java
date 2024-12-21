package net.snackbag.mcvera.mixin;

import net.minecraft.client.gui.ParentElement;
import net.snackbag.vera.Vera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ParentElement.class)
public interface ParentElementMixin {
    @Inject(method = "mouseClicked", at = @At("HEAD"))
    private void mcvera$handleMouseClick(double mouseX, double mouseY, int button, CallbackInfoReturnable<Boolean> cir) {
        Vera.forHoveredWidget((int) mouseX, (int) mouseY, (widget) -> {
            switch (button) {
                case 0: widget.fireEvent("left-click"); break;
                case 1: widget.fireEvent("right-click"); break;
                case 2: widget.fireEvent("middle-click"); break;
                default: throw new IllegalStateException("Invalid button type: " + button);
            }
        });
    }

    @Inject(method = "mouseReleased", at = @At("HEAD"))
    private void mcvera$handleMouseRelease(double mouseX, double mouseY, int button, CallbackInfoReturnable<Boolean> cir) {
        Vera.forHoveredWidget((int) mouseX, (int) mouseY, (widget) -> {
            switch (button) {
                case 0: widget.fireEvent("left-click-release"); break;
                case 1: widget.fireEvent("right-click-release"); break;
                case 2: widget.fireEvent("middle-click-release"); break;
            }
        });
    }
}
