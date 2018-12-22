package base.enemy;

import base.Vector2D;
import base.events.MouseEventMotion;
import base.renderer.AnimationRenderer;
import base.renderer.RotateRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class StraightBullet extends EnemyBullet {
    public StraightBullet() {
        super();
        this.createRenderer();
    }

    protected void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/kimco1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/kimco2.png"));
//        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/kimco3.png"));
//        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/kimco4.png"));
//        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/kimco5.png"));
        this.renderer = new AnimationRenderer(images, 50);
    }

    void move(){
        Vector2D toMouse = MouseEventMotion.getVectorFromCentorToMouse();
        this.velocity.set(toMouse).scaleThis(-1).setLength(speed).addThis(0,10);
    }

    @Override
    public void run() {
        super.run();
        this.move();
    }
}
