package base.item;

import base.physics.BoxCollider;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class HoLo extends Item {

    public HoLo() {
        super();
        this.boxCollider = new BoxCollider(this.anchor,this.position, 45, 45);
        this.createRenderer();
        this.addScore = 50;
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/items/holo - Copy.png"));
        images.add(SpriteUtils.loadImage("assets/images/items/holo2 - Copy.png"));
        this.renderer = new AnimationRenderer(images, 10);
    }

    @Override
    public void run() {
        super.run();
    }
}
