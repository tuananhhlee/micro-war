package enemies;
import bases.GameObject;
import bases.ImageRenderer;
import bases.ImageUtil;
import bases.Vector2D;


import java.awt.*;

public class EnemyBullet extends GameObject {
//    Image image;
//    Vector2D position;

    public EnemyBullet(int x, int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/bullet/enemy/enemy2_bullet1.png");
    }
    public void run(){
        super.run();
        this.position.addUp(0,-10);
    }
}
