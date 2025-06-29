package com.example.mymod.buttons;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.client.gui.DrawContext;

public class AboutButton {

    public static ButtonWidget create(int x, int y, int width, int height, Screen parent) {
        return ButtonWidget.builder(Text.literal("About"), button -> {
            MinecraftClient.getInstance().setScreen(new AboutScreen(parent));
        }).position(x, y).size(width, height).build();
    }

    public static class AboutScreen extends Screen {
        private final Screen parent;

        public AboutScreen(Screen parent) {
            super(Text.literal("About"));
            this.parent = parent;
        }

        @Override
        protected void init() {
            int btnWidth = 160;
            int btnHeight = 25;
            int centerX = this.width / 2;
            int centerY = this.height / 2;

            // Back button to return to the parent screen
            this.addDrawableChild(ButtonWidget.builder(Text.literal("Back"), button -> {
                MinecraftClient.getInstance().setScreen(parent);
            }).position(centerX - btnWidth / 2, centerY + 40).size(btnWidth, btnHeight).build());
        }

        @Override
        public void render(DrawContext context, int mouseX, int mouseY, float delta) {
            // Draw semi-transparent dark background
            context.fill(0, 0, width, height, 0xE5000000);
            // Draw screen title
            context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);

            // About text lines
            String aboutText = "This mod was made by Trainer_024.\nThanks for playing!";
            int yOffset = 60;
            for (String line : aboutText.split("\n")) {
                context.drawCenteredTextWithShadow(this.textRenderer, line, this.width / 2, yOffset, 0xFFFFFF);
                yOffset += 12;
            }

            super.render(context, mouseX, mouseY, delta);
        }

        @Override
        public boolean shouldPause() {
            return false;
        }
    }
}
