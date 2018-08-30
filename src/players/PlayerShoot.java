package players;

import bases.FrameCounter;
import inputs.InputManager;

public class PlayerShoot {
    boolean shootLock;
   // int count;
    FrameCounter frameCounter = new FrameCounter(10);


    void run(Player player){
        if (InputManager.instance.xPressed && !this.shootLock) {
            PlayerBullet newBullet = new PlayerBullet((int)player.position.x,(int)player.position.y);
            player.bullets.add(newBullet);
            this.shootLock = true;
        }
        if(shootLock){
            frameCounter.run();
            if (frameCounter.expired){
                shootLock = false;
                frameCounter.reset();
            }
        }
    }
}
