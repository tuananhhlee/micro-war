package players;

import bases.ImageUtil;
import bases.Vector2D;

import java.awt.*;

public class PlayerBullet {

    Image image;
    Vector2D position;

    PlayerBullet(int x, int y){
        this.image = ImageUtil.load("images/bullet/player/mb69bullet1.png");
        this.position = new Vector2D(x,y);
    }
    public void render(Graphics g){
        g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);
    }
    public void run(){
        this.move();
    }

    private void move() {
        Vector2D velocity = new Vector2D();
        velocity.y -=10;
        this.position.addUp(velocity);
    }
}
