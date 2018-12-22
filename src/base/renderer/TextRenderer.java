package base.renderer;

import base.GameObject;

import java.awt.*;

public class TextRenderer extends Renderer {

    String text;
    public TextRenderer(String text) {
        this.text = text;
    }

    public void drawString(Graphics g, String text, int x, int y){
        for (String line : text.split("/n")){
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
        }
    }

    @Override
    public void render(Graphics g, GameObject master) {
        drawString(g, this.text, (int)master.position.x, (int)master.position.y);
    }
}
