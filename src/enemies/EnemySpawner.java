package enemies;

import bases.FrameCounter;
import bases.GameObject;
import players.Player;

import java.util.Random;

public class EnemySpawner extends GameObject {
    FrameCounter frameCounter = new FrameCounter(150);
    Random random = new Random();

    public EnemySpawner(int x, int y) {
        super(x, y);
    }
    public void run(){
        super.run();
        frameCounter.run();
        if (frameCounter.expired){
            frameCounter.reset();
            PlayerEnemy enemy = GameObject.recyclePE(random.nextInt(600),10);
        }
    }
}

