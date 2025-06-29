package com.example.mymod;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class MyModClient implements ClientModInitializer {

    private static KeyBinding openScreenKey;

    @Override
    public void onInitializeClient() {
        // Register keybind for M key
        openScreenKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.mymod.openscreen",               // translation key (can be anything)
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_M,
                "category.mymod.keybindings"          // keybinding category
        ));

        // Listen for client ticks to detect key press
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openScreenKey.wasPressed()) {
                // Open your custom screen when M is pressed
                client.setScreen(new MyScreen());
            }
        });
    }
}
