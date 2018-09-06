package players;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import inputs.InputManager;

public class PlayerShoot {
    private boolean shootLock;
   // int count;
    FrameCounter frameCounter = new FrameCounter(10);


    void run(Player player){
        if (InputManager.instance.xPressed && !this.shootLock) {
            Vector2D bulletPsition = player.position.subtract(0,30);
            PlayerBullet newBullet = new PlayerBullet((int)bulletPsition.x,(int)bulletPsition.y);
            GameObject.add(newBullet);
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
