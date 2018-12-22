package base.scene.menuscene;

import base.GameObject;
import base.events.KeyEventPress;
import base.game.Settings;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;
import base.scene.SceneStage1;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackgroundMenuScene extends GameObject {
    public BackgroundMenuScene() {
        Image image = SpriteUtils.loadImage("assets/images/background/menu.png");
        Image newImage = image.getScaledInstance(1366, 768, Image.SCALE_SMOOTH);
        this.renderer = new SingleImageRenderer(newImage);
        this.position.set(Settings.SCREEN_WIDTH/2, Settings.SCREEN_HEIGHT/2);
    }

    @Override
    public void run() {
        super.run();
        if (KeyEventPress.isAnyKeyPress || KeyEventPress.isClicked) {
            SceneManager.signNewScene(new SceneStage1());
        }
    }
}
