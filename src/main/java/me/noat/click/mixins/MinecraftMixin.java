package me.noat.click.mixins;

import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.PixelFormat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// its in the mod template so i still put it in lol

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Shadow
    private static Logger logger;

    @Shadow
    private boolean fullscreen;

    @Inject(method="Lnet/minecraft/client/Minecraft;createDisplay()V", at = @At("HEAD"), cancellable = true)
    private void createDisplay(CallbackInfo ci) throws LWJGLException {
        Display.setResizable(true);
        Display.setTitle("MyCustomTitle");
        try {
            Display.create((new PixelFormat()).withDepthBits(24));
        } catch (LWJGLException lwjglexception) {
            logger.error("Couldn't set pixel format", lwjglexception);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException ignored) {
            }
            if (this.fullscreen) {
                this.updateDisplayMode();
            }
            Display.create();
        } finally {
            ci.cancel();
        }
    }

    @Shadow
    private void updateDisplayMode() {
    }
}