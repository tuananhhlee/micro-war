package enemies;
import bases.FrameCounter;
import bases.GameObject;

public class EnemyShoot {
    FrameCounter frameCounter = new FrameCounter(70);

    void run(PlayerEnemy enemy) {
        frameCounter.run();
        if (frameCounter.expired) {
            EnemyBullet newBullet = new EnemyBullet((int)enemy.position.x,(int)enemy.position.y);
            GameObject.add(newBullet);
            frameCounter.reset();
        }
    }

}
