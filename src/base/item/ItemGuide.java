package base.item;

import base.GameObject;
import base.Vector2D;
import base.game.Settings;
import base.physics.BoxCollider;
import base.player.Player;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class ItemGuide extends GameObject {
    Vector2D toItemVector = new Vector2D();
//    BoxCollider boxCollider;
    public ItemGuide() {
      super();
      this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png"));
//      this.boxCollider = new BoxCollider(this.anchor,this.position, 45, 45);
//      this.position.set(500,200);
    }

    public  void findItem() {


        Item item = null;
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive && gameObject instanceof Item && !(gameObject instanceof ItemGuide)) {
                item = (Item) gameObject;
                break;
            }
        }

        if (item!=null) {
            toItemVector = item.position.substractThis((int) Settings.SCREEN_WIDTH / 2,
                    (int) Settings.SCREEN_HEIGHT / 2).setLength(50);
            this.position = toItemVector;
            System.out.println(this.position.x);
        }

    }



    @Override
    public void run() {
        super.run();
        this.findItem();
    }
}
