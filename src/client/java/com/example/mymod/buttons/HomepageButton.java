package com.example.mymod.buttons;

import com.example.mymod.MyScreen; // Make sure this matches your main screen class name
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class HomepageButton {
    public static ButtonWidget create(Screen parent, int x, int y, int width, int height) {
        return ButtonWidget.builder(Text.literal("Home"), button -> {
                    MinecraftClient.getInstance().setScreen(new MyScreen());
                })
                .position(x, y)
                .size(width, height)
                .build();
    }
}
