package base;

import base.enemy.EnemyExplosion;
import base.enemy.EnemyHomingBullet;
import base.game.Settings;
import base.player.Player;
import base.renderer.SingleImageRenderer;
import base.renderer.TextRenderer;
import tklibs.SpriteUtils;

import java.awt.*;

public class Score extends GameObject {
    public static int value;
    FrameCounter increaseCounter;
    boolean isGameOver;
    public Score(){
        super();
        this.value = 0;
        this.position.set( Settings.SCREEN_WIDTH - 350, 30);
        this.renderer = new TextRenderer("SCORE: " + value);
        this.increaseCounter = new FrameCounter(10000/60);
        this.increaseCounter = new FrameCounter(30);
        this.isGameOver = false;
    }

    @Override
    public void run() {
        Player player = GameObject.recycle(Player.class);
        player.isActive = false;
        for (GameObject gameObject : gameObjects){
            if (gameObject.isActive && gameObject instanceof Player){
                player = (Player)gameObject;
                break;
            }
        }
        this.isGameOver = false;
        if (!this.isGameOver) {
            if (player.isActive && this.increaseCounter.run()) {
                this.value += 1;
                this.increaseCounter.reset();
            }

            if (player.isActive && EnemyHomingBullet.hitEachOther) {
                this.value += 5;
                EnemyHomingBullet.hitEachOther = false;
            }
        }
        this.renderer = new TextRenderer("SCORE: " + value);
        super.run();
    }

    @Override
    public void reset() {
        super.reset();
        this.isGameOver = true;
    }

    @Override
    public void render(Graphics g) {
        g.setFont(new Font(null,Font.BOLD,30));
        g.setColor(Color.MAGENTA);
        super.render(g);

    }
}