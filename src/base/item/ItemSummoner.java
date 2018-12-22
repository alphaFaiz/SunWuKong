package base.item;

import base.FrameCounter;
import base.GameObject;
import base.enemy.EnemyHomingBullet;

import java.util.Random;

public class ItemSummoner extends GameObject {
    FrameCounter durationNew;
    public ItemSummoner(){
        super();
        this.durationNew = new FrameCounter(100);
    }

    @Override
    public void run() {
        super.run();
        Item item = null;
        for (GameObject gameObject: gameObjects){
            if (gameObject.isActive && gameObject instanceof Item){
                item = (Item) gameObject;
                break;
            }
        }
        if (item == null) {
            if (this.durationNew.run()) {
                Random random = new Random();
                int randomItem = random.nextInt(2);
                switch (randomItem){
                    case 0:{
                        Peach peach = GameObject.recycle(Peach.class);
                        this.durationNew.reset();
                        break;
                    }
                    case 1: {
                        HoLo hoLo = GameObject.recycle(HoLo.class);
                        this.durationNew.reset();
                        break;
                    }
                    default:{
                        break;
                    }
                }

            }
        }
    }
}
