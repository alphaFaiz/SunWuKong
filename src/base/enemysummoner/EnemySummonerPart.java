package base.enemysummoner;

import base.FrameCounter;
import base.GameObject;
import base.action.*;
import base.enemy.StraightBullet;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.BoxRenderer;

import java.awt.*;

public class EnemySummonerPart extends GameObject implements Physics {
    BoxCollider boxCollider;
    Action action;
    FrameCounter summonStraightBullet = new FrameCounter(80);

    public EnemySummonerPart() {
        this.boxCollider = new BoxCollider(this.anchor,this.position
                , 40, 100);
        this.renderer = new BoxRenderer(this.boxCollider
                , Color.WHITE, true);
        this.position.set(0, 0);
    }

    void createStraightBullet() {
        if (this.summonStraightBullet.run()) {
            StraightBullet straightBullet = GameObject.recycle((StraightBullet.class));
            straightBullet.position.set(this.position.add(50, 0));
            this.summonStraightBullet.reset();
        }
    }


    @Override
    public void run() {
        super.run();
        this.createStraightBullet();
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}

