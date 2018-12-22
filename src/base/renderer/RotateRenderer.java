package base.renderer;

import base.FrameCounter;
import base.GameObject;
import base.events.MouseEventMotion;
import base.game.GameCanvas;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class RotateRenderer extends Renderer {

    ArrayList<BufferedImage> images;
    FrameCounter nextImageCounter;
    int currentImageIndex;
    BufferedImage image;
    double angle;
    AffineTransform transform;
    AffineTransform emptyTransform;

    public RotateRenderer(ArrayList<BufferedImage> images, int frameCounterMax) {
//        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        this.images = images;
        this.nextImageCounter = new FrameCounter(frameCounterMax);
        this.currentImageIndex = 0;
        this.angle = 0;
        this.transform = new AffineTransform();
        this.emptyTransform = new AffineTransform();
    }

    @Override
    public void render(Graphics g, GameObject master) {
        Graphics2D g2D = (Graphics2D) g;
        this.syncTransform(master);
//        g2D.drawImage(this.image, this.transform, null);
        BufferedImage currentImage = this.images.get(currentImageIndex);
        int x = (int)(master.position.x
                - master.anchor.x * currentImage.getWidth());
        int y = (int)(master.position.y
                - master.anchor.y * currentImage.getHeight());
        g2D.drawImage(currentImage,  this.transform, null);
        if(this.nextImageCounter.run()) {
            this.currentImageIndex++;
            if(this.currentImageIndex >= this.images.size()) {
                this.currentImageIndex = 0;
            }
            this.nextImageCounter.reset();
        }
    }

    public void syncTransform(GameObject master) {
        this.transform.setTransform(this.emptyTransform);
        BufferedImage currentImage = this.images.get(currentImageIndex);
        double x = master.position.x - currentImage.getWidth() * master.anchor.x;
        double y = master.position.y - currentImage.getHeight() * master.anchor.y;
        this.transform.translate(x, y);

        this.angle = master.position.angleTo(MouseEventMotion.mousePosition);
//        this.transform.setToRotation(this.angle, image.getWidth() / 2
//                , image.getHeight() / 2);
        this.transform.rotate(this.angle, currentImage.getWidth() / 2
                , currentImage.getHeight() / 2);

//        this.transform.rotate(this.angle);
    }
}
