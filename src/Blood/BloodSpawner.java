package Blood;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class BloodSpawner extends GameObject {
    FrameCounter frameCounter = new FrameCounter(60);
    Random random = new Random();

    public BloodSpawner(int x, int y) {
        super(x, y);
    }

    public void run() {
        super.run();
        frameCounter.run();
        if (frameCounter.expired){
            frameCounter.reset();
            Blood blood = new Blood(random.nextInt(200),200);
            GameObject.add(blood);
        }
    }
}
