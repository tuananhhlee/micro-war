package enemies;
import bases.ImageUtil;
import bases.ImageRenderer;
import bases.Vector2D;


import java.awt.*;

public class EnemyBullet {
    Image image;
    Vector2D position;

    public EnemyBullet(int x, int y) {
        this.image=ImageUtil.load("images/bullet/enemy/enemy2_bullet1.png");
        this.position = new Vector2D(x,y);

    }
    public void render (Graphics g){
        g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);
    }

    public void run(){
        this.move();
    }

    private void move() {
        Vector2D velocity = new Vector2D();
        velocity.y +=10;
        this.position.addUp(velocity);
    }

}
