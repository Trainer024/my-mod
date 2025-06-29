package com.example.mymod.buttons;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class SettingsButton {

    public static ButtonWidget create(int x, int y, int width, int height, Screen parent) {
        return ButtonWidget.builder(Text.literal("Settings"), button -> {
            MinecraftClient.getInstance().setScreen(new SettingsScreen(parent));
        }).position(x, y).size(width, height).build();
    }

    public static class SettingsScreen extends Screen {
        private final Screen parent;

        public SettingsScreen(Screen parent) {
            super(Text.literal("Settings"));
            this.parent = parent;
        }

        @Override
        protected void init() {
            int btnWidth = 160;
            int btnHeight = 25;
            int centerX = this.width / 2;
            int centerY = this.height / 2;

            this.addDrawableChild(ButtonWidget.builder(Text.literal("Back"), button -> {
                MinecraftClient.getInstance().setScreen(parent);
            }).position(centerX - btnWidth / 2, centerY + 40).size(btnWidth, btnHeight).build());
        }

        @Override
        public void render(net.minecraft.client.gui.DrawContext context, int mouseX, int mouseY, float delta) {
            context.fill(0, 0, width, height, 0xE5000000);
            context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
            super.render(context, mouseX, mouseY, delta);
        }

        @Override
        public boolean shouldPause() {
            return false;
        }
    }
}
