package base.renderer;

import base.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SingleImageRenderer extends Renderer {
    public BufferedImage image; // = null

    public SingleImageRenderer(String url) {
        this.image = SpriteUtils.loadImage(url);
    }

    public SingleImageRenderer(BufferedImage image) {
        this.image = image;
    }

    public SingleImageRenderer(Image img){
        if (img instanceof BufferedImage)
        {
            this.image = (BufferedImage)img;
        }
        else {
            // Create a buffered image with transparency
            BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

            // Draw the image on to the buffered image
            Graphics2D bGr = bimage.createGraphics();
            bGr.drawImage(img, 0, 0, null);
            bGr.dispose();
            this.image = bimage;
        }
    }

    @Override
    public void render(Graphics g, GameObject master) {
        int x = (int)(master.position.x
                - master.anchor.x * this.image.getWidth());
        int y = (int)(master.position.y
                - master.anchor.y * this.image.getHeight());
        g.drawImage(this.image, x, y, null);
    }
}
