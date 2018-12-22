package base.item;

import base.FrameCounter;
import base.GameObject;
import base.Score;
import base.Vector2D;
import base.events.MouseEventMotion;
import base.game.Settings;
import base.physics.BoxCollider;
import base.player.Player;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.util.Random;

public class Peach extends Item {
    public Peach() {
        super();
        this.boxCollider = new BoxCollider(this.anchor, this.position, 45, 45);
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/items/peach.png"));
        this.addScore = 20;
    }
}
