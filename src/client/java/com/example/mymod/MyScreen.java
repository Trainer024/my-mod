package com.example.mymod;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class MyScreen extends Screen {
    public MyScreen() {
        super(Text.literal("Configcore"));
    }

    @Override
    protected void init() {
        this.clearChildren();

        int buttonWidth = 200;
        int buttonHeight = 30;
        int buttonX = 5;
        int buttonSpacing = 35;
        int firstButtonY = 50;

        this.addDrawableChild(new TransparentTextButton(
                buttonX,
                firstButtonY,
                buttonWidth,
                buttonHeight,
                Text.literal("Settings"),
                btn -> MinecraftClient.getInstance().setScreen(new SettingsScreen()),
                this.textRenderer
        ));

        this.addDrawableChild(new TransparentTextButton(
                buttonX,
                firstButtonY + buttonSpacing,
                buttonWidth,
                buttonHeight,
                Text.literal("About"),
                btn -> MinecraftClient.getInstance().setScreen(new AboutScreen()),
                this.textRenderer
        ));

        this.addDrawableChild(new TransparentTextButton(
                buttonX,
                firstButtonY + buttonSpacing * 2,
                buttonWidth,
                buttonHeight,
                Text.literal("Credits"),
                btn -> MinecraftClient.getInstance().setScreen(new CreditsScreen()),
                this.textRenderer
        ));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(0, 0, width, height, 0x88000000); // semi-transparent black bg
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(textRenderer, this.title, width / 2, 20, 0xFFFFFF);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    // Simple sub-screens with Back button returning to MyScreen:

    private static class SettingsScreen extends Screen {
        public SettingsScreen() {
            super(Text.literal("Settings"));
        }

        @Override
        protected void init() {
            this.addDrawableChild(new TransparentTextButton(
                    5, 50, 200, 30, Text.literal("Back"),
                    btn -> MinecraftClient.getInstance().setScreen(new MyScreen()),
                    this.textRenderer
            ));
        }

        @Override
        public void render(DrawContext context, int mouseX, int mouseY, float delta) {
            context.fill(0, 0, width, height, 0x88000000);
            super.render(context, mouseX, mouseY, delta);
            context.drawCenteredTextWithShadow(textRenderer, this.title, width / 2, 20, 0xFFFFFF);
        }
    }

    private static class AboutScreen extends Screen {
        public AboutScreen() {
            super(Text.literal("About"));
        }

        @Override
        protected void init() {
            this.addDrawableChild(new TransparentTextButton(
                    5, 50, 200, 30, Text.literal("Back"),
                    btn -> MinecraftClient.getInstance().setScreen(new MyScreen()),
                    this.textRenderer
            ));
        }

        @Override
        public void render(DrawContext context, int mouseX, int mouseY, float delta) {
            context.fill(0, 0, width, height, 0x88000000);
            super.render(context, mouseX, mouseY, delta);
            context.drawCenteredTextWithShadow(textRenderer, this.title, width / 2, 20, 0xFFFFFF);
        }
    }

    private static class CreditsScreen extends Screen {
        public CreditsScreen() {
            super(Text.literal("Credits"));
        }

        @Override
        protected void init() {
            this.addDrawableChild(new TransparentTextButton(
                    5, 50, 200, 30, Text.literal("Back"),
                    btn -> MinecraftClient.getInstance().setScreen(new MyScreen()),
                    this.textRenderer
            ));
        }

        @Override
        public void render(DrawContext context, int mouseX, int mouseY, float delta) {
            context.fill(0, 0, width, height, 0x88000000);
            super.render(context, mouseX, mouseY, delta);
            context.drawCenteredTextWithShadow(textRenderer, this.title, width / 2, 20, 0xFFFFFF);
        }
    }
}
