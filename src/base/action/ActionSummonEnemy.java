package base.action;

import base.GameObject;
import base.enemy.EnemyHomingBullet;

public class ActionSummonEnemy implements Action {
    boolean isDone;

    @Override
    public boolean run(GameObject master) {
        EnemyHomingBullet enemyHomingBullet = GameObject.recycle(EnemyHomingBullet.class);
            enemyHomingBullet.position.set(master.position.add(20,0));
            this.isDone = true;
            return this.isDone;
    }

    @Override
    public void reset() {
        this.isDone = false;
    }
}
