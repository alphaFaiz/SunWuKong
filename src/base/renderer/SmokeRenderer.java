package base.renderer;

import base.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SmokeRenderer extends Renderer {
    public BufferedImage image;
    public int width;
    public int height;

    public SmokeRenderer(String url) {
        this.image = SpriteUtils.loadImage(url);
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
    }

    @Override
    public void render(Graphics g, GameObject master) {
        int x = (int)(master.position.x
                - master.anchor.x * this.width);
        int y = (int)(master.position.y
                - master.anchor.y * this.height);
        g.drawImage(this.image, x, y, this.width, this.height, null);
    }
}
