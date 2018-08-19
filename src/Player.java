import java.awt.*;
import java.util.ArrayList;

public class Player {
    int x;
    int y;
    Image image;
    InputManager inputManager;
    ArrayList<PlayerBullet> bullets;
    boolean shootLock = false;
    int count;


    public  Player(int x, int y){
        this.x = x;
        this.y=y;
        this.image = ImageUtil.load("images/player/MB-69/player1.png");
    }

    void render(Graphics g){
        g.drawImage(this.image,this.x, this.y, null);
    }

    void run(ArrayList<PlayerBullet> bullets){
        this.bullets = bullets;
        if (inputManager.rightPressed) {
            this.x += 5;
        }
        if (inputManager.leftPressed) {
            this.x -= 5;
        }
        if (inputManager.downPressed) {
            this.y += 5;
        }
        if (inputManager.upPressed) {
            this.y -= 5;
        }
        for (PlayerBullet b : bullets) {
            b.run();
        }
        if (inputManager.xPressed && shootLock == false) {
            PlayerBullet newB = new PlayerBullet(this.x, this.y);
            bullets.add(newB);
            shootLock = true;
            }
            if(shootLock){
                count++;
                if(count > 30){
                    shootLock = false;
                    count = 0;
                }
            }
    }
}
