package base.item;

import base.FrameCounter;
import base.GameObject;
import base.Score;
import base.Vector2D;
import base.events.MouseEventMotion;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;
import java.util.Random;

public class Item extends GameObject implements Physics {
    BoxCollider boxCollider;
    int randomX, randomY;
    Random rd;
    FrameCounter durationItem;
    Clip sound;
    int addScore;


    public Item() {
        super();
        this.randomPosition();
        this.speed = 10;
        this.durationItem = new FrameCounter(300);
        this.sound = AudioUtils.loadSound("assets/music/sfx/powerup.wav");

    }

    public void hitPlayer() {
        Player player = null;
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive && gameObject instanceof Player)
                player = (Player) gameObject;
        }
        if (player != null && this.getBoxCollider().intersects(player.getBoxCollider())){
            this.sound.setFramePosition(0);
            this.sound.start();
            this.destroy();
            Score.value += this.addScore;
            if (this instanceof HoLo){
                player.immuneCouter.count = 0;
                player.immune = true;
            }
        }

    }
    @Override
    public void run() {
        super.run();
        this.move();
        this.hitPlayer();
        this.destroyAfterDuration();
    }

    private void move() {
        Vector2D toMouse = MouseEventMotion.getVectorFromCentorToMouse();
        Vector2D velocity = new Vector2D();
        if(toMouse.length() > 10) {
            velocity.set(toMouse.scaleThis(-1).setLength(speed)); // 3 ~ backgroundSpeed
        }
        this.velocity.set(velocity);
    }

    private void destroyAfterDuration() {
        if (this.isActive && this.durationItem.run()){
            this.destroy();
            this.durationItem.reset();
        }
    }

    private void randomPosition() {
        rd = new Random();
        int i = rd.nextInt(2);
        switch (i) {
            default: break;
            case 0: {
                i = 1;
                break;
            }
            case 1: {
                i = -1;
                break;
            }
        }
        randomX =  i * (rd.nextInt(400) + 100 ) + Settings.SCREEN_WIDTH / 2 ;
        randomY =  i * (rd.nextInt(400) + 100 ) + Settings.SCREEN_HEIGHT / 2 ;
        this.position.set(randomX, randomY);
    }

    @Override
    public void reset() {
        super.reset();
        this.randomPosition();
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
