package base.enemy;

import base.GameObject;
import base.Vector2D;
import base.events.MouseEventMotion;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.BoxRenderer;
import base.renderer.RotateRenderer;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject implements Physics {
    BoxCollider boxCollider;
    int damage;
    Clip sound;


    public EnemyBullet() {
        super();
        this.boxCollider = new BoxCollider(this.anchor,this.position
                , 16, 16);
//-----
        this.createRenderer();
//        this.renderer = new BoxRenderer(this.boxCollider
//                , Color.green, true);
        this.damage = 1;
        this.speed = 10;
        this.sound = AudioUtils.loadSound("assets/music/sfx/enemy-explosion.wav");
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/1.png"));
        this.renderer = new RotateRenderer(images, 80);
    }
//    private void move(){
//        Vector2D toMouse = MouseEventMotion.getVectorFromCentorToMouse();
//        Vector2D velocity = new Vector2D();
//        if(toMouse.length() > 10) {
//            velocity.set(toMouse.scaleThis(-1).setLength(speed)); //bullet's speed
//        }
//        this.velocity.substractThis(velocity);
//    }

    private void hitPlayer() {
        Vector2D toMouse = MouseEventMotion.getVectorFromCentorToMouse();
        Player player = GameObject.intersects(Player.class, this.boxCollider);
        if(player != null) {
            player.takeDamage(this.damage);
            EnemyExplosion explosion = GameObject.recycle(EnemyExplosion.class);
            explosion.position.set(this.position);
            this.destroy();
            this.sound.setFramePosition(0);
            this.sound.start();
            if (toMouse.length()>10) {
                explosion.velocity.set(toMouse.scaleThis(-1).setLength(speed));
            } else {
                explosion.velocity.set(0,0);
            }
        }
    }

    @Override
    public void run() {
        super.run();
        this.hitPlayer();
        this.destroyIfNeeded();
//        this.move();
    }

    private void destroyIfNeeded() {
        if(this.position.y < -500 || this.position.y >= Settings.SCREEN_HEIGHT + 500
                || this.position.x < -500 || this.position.x >= Settings.SCREEN_WIDTH + 500) {
            this.destroy();
            this.velocity.set(0,0);
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
