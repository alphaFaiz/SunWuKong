package base.background;

import base.GameObject;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BackgroundPart extends GameObject {
    public BackgroundPart() {
        super();
        BufferedImage image = SpriteUtils.loadImage(
                "assets/images/background/2000x1125.png"
        );
        this.renderer = new SingleImageRenderer(image);
        this.anchor.set(0, 0);
    }
}
