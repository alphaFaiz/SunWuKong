package base.scene.menuscene;

import base.GameObject;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.BoxRenderer;
import base.renderer.TextRenderer;

import javax.swing.*;
import java.awt.*;

public class StartButton extends GameObject implements Physics {
    BoxCollider boxCollider;
    public StartButton(){
        this.position.set(Settings.SCREEN_WIDTH/2, Settings.SCREEN_HEIGHT/2 + 200);
        this.boxCollider = new BoxCollider(this.anchor, this.position, 200, 100);
        this.renderer = new BoxRenderer(this.boxCollider, Color.RED, true);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
