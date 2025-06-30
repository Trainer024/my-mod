package com.example.mymod.buttons;

import com.example.mymod.ModsScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class ModsButton {
    public static ButtonWidget create(int x, int y, int width, int height) {
        return ButtonWidget.builder(Text.literal("Mods"), btn -> {
            MinecraftClient.getInstance().setScreen(new ModsScreen());
        }).dimensions(x, y, width, height).build();
    }
}
