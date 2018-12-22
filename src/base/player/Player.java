package base.player;

import base.FrameCounter;
import base.GameObject;
import base.Score;
import base.Vector2D;
import base.action.Action;
import base.enemy.EnemyExplosion;
import base.events.KeyEventPress;
import base.events.MouseEventMotion;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.*;
import base.scene.overscene.GameOverScene;
import base.scene.SceneManager;
import base.scene.overscene.GameOverScore;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    Clip sound;
    double angle;
    Action action;
    int hp;
    public boolean immune;
    public FrameCounter immuneCouter;
    BoxCollider boxCollider;
    FrameCounter smokeCounter;


    public Player() {
        super();
//        this.createRenderer();
//        this.renderer= new SingleImageRenderer(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
//        this.renderer = new RotateRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png"));
        this.createRenderer();
        this.position.set(Settings.SCREEN_WIDTH/2, Settings.SCREEN_HEIGHT/2);
        this.hp = 1;
        this.immuneCouter = new FrameCounter(200);
        this.immune = false;
        this.boxCollider = new BoxCollider(this.anchor,this.position, 48, 110);
        this.angle = 0;
        this.smokeCounter = new FrameCounter(10);
        this.sound = AudioUtils.loadSound("assets/music/sfx/player-dead.wav");

    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        this.renderer = new RotateRenderer(images, 300);
    }

    public void takeDamage(int damage) {
        if(this.immune)
            return;
        this.hp -= damage;
        if(this.hp <= 0) {
            this.hp = 0;
            this.destroy();
            KeyEventPress.isClicked = false;
        }
//        else {
//            this.immune = true;
//            this.immuneCouter.reset();
//        }
    }

    @Override
    public void destroy() {
        super.destroy();
        EnemyExplosion explosion = GameObject.recycle(EnemyExplosion.class);
        explosion.position.set(this.position);

        this.sound.setFramePosition(0);
        this.sound.start();
        SceneManager.signNewScene(new GameOverScene());
    }

    @Override
    public void reset() {
        super.reset();
        this.velocity.set(3, 0);
        this.immune = false;
        this.immuneCouter.reset();
        this.hp = 3;
    }

    @Override
    public void run() {
        super.run(); //this.position.addThis(this.velocity)
        this.createSmoke();
    }

    private void createSmoke() {
        Vector2D toMouse = MouseEventMotion.getVectorFromCentorToMouse();
        toMouse.setLength(50).scaleThis(-1);
        if (this.smokeCounter.run()){
            SmokeEffect smokeEffect = GameObject.recycle(SmokeEffect.class);
            smokeEffect.position.set(this.position).addThis(toMouse);
            this.smokeCounter.reset();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void render(Graphics g) {
        if (this.immune){
            if (this.immuneCouter.run()) {
                this.immune = false;
            }
            if (this.immuneCouter.count % 10 == 0) {
                    super.render(g);
            }
        }
        else super.render(g);

    }
}
