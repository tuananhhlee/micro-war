package enemies;
import bases.*;
import players.Player;


import java.awt.*;

public class EnemyBullet extends GameObject {
//    Image image;
//    Vector2D position;

    public EnemyBullet(int x, int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/bullet/enemy/enemy2_bullet1.png");
        this.boxCollider = new BoxCollider(x,y,20,20);
    }
    public void run(){
        super.run();
        move();
        hitPlayer();
    }

    private void hitPlayer() {
        Player player = GameObject.checkCollisionplayers(this.boxCollider);
        if (player!=null){
            System.out.println("Game Over");
            player.getHit();
            this.gameover();
        }
    }


    private void move() {
        this.position.addUp(0,10);
    }
}
