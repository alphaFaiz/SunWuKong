package base.game;

import base.GameObject;
import base.scene.menuscene.MenuScene;
import base.scene.SceneManager;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    public GameCanvas() {
        System.out.println(">>");
        SceneManager.signNewScene(new MenuScene());
    }

    public void gameLoop() {
        int delay = 1000 / 60;
        long lastRun = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastRun > delay) {
                this.runAll();
                this.renderAll();
                lastRun = currentTime;
            }
        }
    }

    public void runAll() {
        for(int i = 0; i < GameObject.gameObjects.size(); i++) {
            GameObject gameObject = GameObject.gameObjects.get(i);
            if(gameObject.isActive) {
                gameObject.run();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.fillRect(0, 0, (int)Settings.SCREEN_WIDTH, (int)Settings.SCREEN_HEIGHT);
        for(int i = 0; i < GameObject.gameObjects.size(); i++) {
            GameObject gameObject = GameObject.gameObjects.get(i);
            if(gameObject.isActive) {
                gameObject.render(g);
            }
        }
    }

    public void renderAll() {
        this.repaint();
    }
}
