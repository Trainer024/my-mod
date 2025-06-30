package com.example.mymod;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class TransparentTextButton extends ButtonWidget {
    private final TextRenderer textRenderer;

    public TransparentTextButton(int x, int y, int width, int height, Text message, PressAction onPress, TextRenderer textRenderer) {
        super(x, y, width, height, message, onPress, DEFAULT_NARRATION_SUPPLIER);
        this.textRenderer = textRenderer;
    }

    @Override
    public void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        int color = this.active ? 0xFFFFFF : 0xA0A0A0;
        context.drawCenteredTextWithShadow(
                textRenderer,
                this.getMessage(),
                this.getX() + this.getWidth() / 2,
                this.getY() + (this.getHeight() - 8) / 2,
                color
        );
    }
}
