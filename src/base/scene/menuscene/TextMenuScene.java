package base.scene.menuscene;

import base.GameObject;
import base.game.Settings;
import base.renderer.SingleImageRenderer;
import base.renderer.TextRenderer;

import java.awt.*;

public class TextMenuScene extends GameObject {
    public TextMenuScene(){
        this.renderer = new SingleImageRenderer("assets/images/background/textMenu.png");
        this.position.set(Settings.SCREEN_WIDTH/2, 50);
    }
}
