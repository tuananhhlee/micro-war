package enemies;
import bases.FrameCounter;

public class EnemyShoot {
    FrameCounter frameCounter = new FrameCounter(10);

    void run(PlayerEnemy enemy) {
        frameCounter.run();
        if (frameCounter.expired) {
            PlayerEnemy newBullet = new PlayerEnemy((int)enemy.position.x,(int)enemy.position.y);
            enemy.enemies.add(newBullet);
            frameCounter.reset();
        }
    }

}
