package com.example.mymod;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class MyScreen extends Screen {
    private String currentMode = "home"; // Tracks which page is showing

    public MyScreen() {
        super(Text.literal("Configcore"));
    }

    @Override
    protected void init() {
        this.clearChildren();  // Remove existing buttons before adding new ones

        int buttonWidth = 200;
        int buttonHeight = 30;
        int buttonX = 5;
        int buttonSpacing = 35;
        int firstButtonY = 50;

        if ("home".equals(currentMode)) {
            this.addDrawableChild(ButtonWidget.builder(Text.literal("Settings"), btn -> {
                currentMode = "settings";
                init();
            }).dimensions(buttonX, firstButtonY, buttonWidth, buttonHeight).build());

            this.addDrawableChild(ButtonWidget.builder(Text.literal("About"), btn -> {
                currentMode = "about";
                init();
            }).dimensions(buttonX, firstButtonY + buttonSpacing, buttonWidth, buttonHeight).build());

            this.addDrawableChild(ButtonWidget.builder(Text.literal("Credits"), btn -> {
                currentMode = "credits";
                init();
            }).dimensions(buttonX, firstButtonY + buttonSpacing * 2, buttonWidth, buttonHeight).build());
        } else {
            // For any other page, just show a Back button to go home
            this.addDrawableChild(ButtonWidget.builder(Text.literal("Back"), btn -> {
                currentMode = "home";
                init();
            }).dimensions(buttonX, firstButtonY, buttonWidth, buttonHeight).build());
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Draw transparent black background (remove Minecraft grey)
        context.fill(0, 0, width, height, 0x88000000);

        // Draw buttons
        for (var child : this.children()) {
            if (child instanceof net.minecraft.client.gui.Drawable drawable) {
                drawable.render(context, mouseX, mouseY, delta);
            }
        }

        // Draw title text, changing based on current page
        String titleText;
        switch (currentMode) {
            case "settings":
                titleText = "Settings";
                break;
            case "about":
                titleText = "About";
                break;
            case "credits":
                titleText = "Credits";
                break;
            default:
                titleText = "Configcore";
                break;
        }

        context.drawCenteredTextWithShadow(textRenderer, Text.literal(titleText), width / 2, 20, 0xFFFFFF);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
