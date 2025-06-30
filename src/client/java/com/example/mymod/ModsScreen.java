package com.example.mymod;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class ModsScreen extends Screen {
    public ModsScreen() {
        super(Text.literal("Mods"));
    }

    @Override
    protected void init() {
        // Add a simple "Back to Home" button
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Home"), btn -> {
            MinecraftClient.getInstance().setScreen(new MyScreen());
        }).dimensions(5, 50, 200, 30).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Transparent background
        context.fill(0, 0, width, height, 0x88000000);

        // Draw children
        super.render(context, mouseX, mouseY, delta);

        // Title
        context.drawCenteredTextWithShadow(textRenderer, this.title, width / 2, 20, 0xFFFFFF);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
