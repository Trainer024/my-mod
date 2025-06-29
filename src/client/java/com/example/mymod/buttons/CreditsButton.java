package com.example.mymod.buttons;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class CreditsButton {

    public static ButtonWidget create(Screen parent, int x, int y, int width, int height) {
        return ButtonWidget.builder(Text.literal("Credits"), button -> {
                    MinecraftClient.getInstance().setScreen(new CreditsScreen(parent));
                })
                .position(x, y)
                .size(width, height)
                .build();
    }

    // Inner CreditsScreen class
    public static class CreditsScreen extends Screen {
        private final Screen parent;

        public CreditsScreen(Screen parent) {
            super(Text.literal("Credits"));
            this.parent = parent;
        }

        @Override
        protected void init() {
            // Add Home button at the top
            this.addDrawableChild(HomepageButton.create(this, this.width / 2 - 60, 40, 120, 20));
        }

        @Override
        public void render(DrawContext context, int mouseX, int mouseY, float delta) {
            // Semi-transparent background
            context.fill(0, 0, width, height, 0xE5000000);

            // Title text
            context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);

            // Credits text
            context.drawCenteredTextWithShadow(
                    this.textRenderer,
                    Text.literal("Created by YourNameHere"),
                    this.width / 2,
                    this.height / 2 - 10,
                    0xFFFFFF
            );

            context.drawCenteredTextWithShadow(
                    this.textRenderer,
                    Text.literal("Special Thanks to OpenAI"),
                    this.width / 2,
                    this.height / 2 + 10,
                    0xFFFFFF
            );

            super.render(context, mouseX, mouseY, delta);
        }

        @Override
        public boolean shouldPause() {
            return false;
        }
    }
}
