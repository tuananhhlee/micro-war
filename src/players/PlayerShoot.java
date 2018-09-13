package players;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;
import inputs.InputManager;

import java.awt.*;

public class PlayerShoot {
    private boolean shootLock;
   // int count;
    FrameCounter frameCounter = new FrameCounter(10);


    void run(Player player){
        if (InputManager.instance.xPressed && !this.shootLock) {
            Vector2D bulletPosition = player.position.subtract(0,30);
            //1 try to recycle
            PlayerBullet newBullet = GameObject.recycle((int)bulletPosition.x,(int)bulletPosition.y);
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
