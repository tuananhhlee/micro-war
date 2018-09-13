package enemies;
import bases.FrameCounter;
import bases.GameObject;

public class EnemyShoot {
    FrameCounter frameCounter = new FrameCounter(70);

    void run(PlayerEnemy enemy) {
        frameCounter.run();
        if (frameCounter.expired) {
            EnemyBullet newBullet = GameObject.recycleEB((int)enemy.position.x,(int)enemy.position.y);
            frameCounter.reset();
        }
    }
}
