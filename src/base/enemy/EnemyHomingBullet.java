package base.enemy;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import base.events.MouseEventMotion;
import base.physics.Physics;
import base.player.Player;

public class EnemyHomingBullet extends EnemyBullet implements Physics {
    public static boolean hitEachOther;


    public EnemyHomingBullet(){
        super();
        this.hitEachOther = false;
    }
    private void hitEachOther() {
        Vector2D toMouse = MouseEventMotion.getVectorFromCentorToMouse();
        EnemyHomingBullet enemyHomingBullet = null;
        for (GameObject gameObject : GameObject.gameObjects) {

            if (gameObject instanceof EnemyHomingBullet && gameObject != this &&gameObject.isActive
                    && ((EnemyHomingBullet) gameObject).getBoxCollider().intersects(this.boxCollider)){
                enemyHomingBullet = (EnemyHomingBullet) gameObject;
                this.hitEachOther = true;
                break;
            }
        }
        if (enemyHomingBullet != null) {
            EnemyExplosion explosion = GameObject.recycle(EnemyExplosion.class);
            enemyHomingBullet.destroy();
            this.destroy();
            this.sound.setFramePosition(0);
            this.sound.start();
            explosion.position.set(enemyHomingBullet.position);
            if (toMouse.length()>10) {
                explosion.velocity.set(toMouse.scaleThis(-1).setLength(speed));
            } else {
                explosion.velocity.set(0,0);
            }
        }
    }

    private void moveToPlayer() {
        Player player = null;
        for (GameObject gameObject : GameObject.gameObjects) {
            if(gameObject.isActive && gameObject instanceof Player) {
                player = (Player) gameObject;
                break;
            }
        }
        if(player != null) {
            Vector2D playerPosition = player.position;
            Vector2D result = playerPosition.substract(this.position);

            result.setLength(speed + 0.01f);
            result.addThis(this.velocity);
            result.setLength(speed);

            Vector2D toMouse = MouseEventMotion.getVectorFromCentorToMouse();
            Vector2D velocity2 = new Vector2D();
            if(toMouse.length() > 10) {
                velocity2.set(toMouse).setLength(speed - 1); //bullet's speed
            }
            this.velocity.set(result).substractThis(velocity2);
        }
    }

    @Override
    public void run() {
        super.run();
        this.hitEachOther();
        this.moveToPlayer();
    }
}