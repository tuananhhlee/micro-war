package enemies;
import bases.FrameCounter;

public class EnemyShoot {
    FrameCounter frameCounter = new FrameCounter(10);

    void run(PlayerEnemy enemy) {
        frameCounter.run();
        if (frameCounter.expired) {
            EnemyBullet newBullet = new EnemyBullet((int)enemy.position.x,(int)enemy.position.y);
            enemy.enemyBullets.add(newBullet);
            frameCounter.reset();
        }
    }

}
