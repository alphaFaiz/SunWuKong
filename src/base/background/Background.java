package base.background;

import base.GameObject;
import base.Vector2D;
import base.events.MouseEventMotion;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.BoxRenderer;

import java.awt.*;

public class Background extends GameObject implements Physics {
    BackgroundPart part1;
    BackgroundPart part2;
    BackgroundPart part3;
    BackgroundPart part4;
    BoxCollider boxCollider;

    int width = 2000;
    int height = 1125;
    public static int speed;

    public Background() {
        this.createParts();
        this.boxCollider = new BoxCollider(this.anchor,this.position, width * 2, height * 2);
        this.renderer = new BoxRenderer(this.boxCollider, Color.green, false);
        this.position.set((int)Settings.SCREEN_WIDTH / 2, (int)Settings.SCREEN_HEIGHT / 2);
        this.speed = 10;
    }

    private void createParts() {
        Vector2D centerPoint = new Vector2D((int)Settings.SCREEN_WIDTH / 2, (int)Settings.SCREEN_HEIGHT / 2);
        this.part1 = GameObject.recycle(BackgroundPart.class);
        this.part1.position.set(centerPoint.substract(width, height));
        this.part2 = GameObject.recycle(BackgroundPart.class);
        this.part2.position.set(centerPoint.substract(0, height));
        this.part3 = GameObject.recycle(BackgroundPart.class);
        this.part3.position.set(centerPoint.substract(width, 0));
        this.part4 = GameObject.recycle(BackgroundPart.class);
        this.part4.position.set(centerPoint.substract(0, 0));
    }

    @Override
    public void run() {
        super.run();
        this.move();
        int outOfBoundDirection = this.outOfBound();
        this.switchPart(outOfBoundDirection);
    }

    private void move() {
        Vector2D toMouse = MouseEventMotion.getVectorFromCentorToMouse();
        Vector2D velocity = new Vector2D();
        if(toMouse.length() > 10) {
            velocity.set(toMouse.scaleThis(-1).setLength(speed)); // 3 ~ backgroundSpeed
        }
        part1.velocity.set(velocity);
        part2.velocity.set(velocity);
        part3.velocity.set(velocity);
        part4.velocity.set(velocity);
        this.velocity.set(velocity);
    }

    //direction ~ TOP / BOT / LEFT / RIGHT
    public void switchPart(int direction) {
        switch (direction) {
            case Settings.TOP: {
                part3.position.addThis(0, -height * 2);
                part4.position.addThis(0, -height * 2);
                this.position.addThis(0, -height);

                BackgroundPart temp = part1;
                part1 = part3;
                part3 = temp;
                temp = part2;
                part2 = part4;
                part4 = temp;
                break;
            }
            case Settings.BOT: {
                part1.position.addThis(0, height * 2);
                part2.position.addThis(0, height * 2);
                this.position.addThis(0, height);

                BackgroundPart temp = part3;
                part3 = part1;
                part1 = temp;
                temp = part4;
                part4 = part2;
                part2 = temp;
                break;
            }
            case Settings.LEFT: {
                part2.position.addThis( - width * 2, 0);
                part4.position.addThis( - width * 2, 0);
                this.position.addThis(- width, 0);

                BackgroundPart temp = part2;
                part2 = part1;
                part1 = temp;
                temp = part4;
                part4 = part3;
                part3 = temp;
                break;
            }
            case Settings.RIGHT: {
                part1.position.addThis(width * 2, 0);
                part3.position.addThis(width * 2, 0);
                this.position.addThis(width, 0);

                BackgroundPart temp = part2;
                part2 = part1;
                part1 = temp;
                temp = part4;
                part4 = part3;
                part3 = temp;
                break;
            }
        }
    }

    //detect screen out of background's bound
    public int outOfBound() {
        if(this.position.x > width) {
            return Settings.LEFT;
        }
        if(this.position.x < Settings.SCREEN_WIDTH - width) {
            return Settings.RIGHT;
        }
        if(this.position.y > height) {
            return Settings.TOP;
        }
        if(this.position.y < Settings.SCREEN_HEIGHT - height) {
            return Settings.BOT;
        }
        return -1;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
