package enemies;
import bases.*;
import players.Player;

public class EnemyBullet extends GameObject {
//    Image image;
//    Vector2D position;

    public EnemyBullet(int x, int y) {
        super(x,y);
        this.renderer = new Animation(
                ImageUtil.load("images/bullet/enemy/enemy_bullet1.png"),
                ImageUtil.load("images/bullet/enemy/enemy_bullet2.png"),
                ImageUtil.load("images/bullet/enemy/enemy_bullet3.png")
        );
        this.boxCollider = new BoxCollider(x,y,20,20);
    }
    public void run(){
        super.run();
        move();
        hitPlayer();
        deactivateIfNeeded();
    }

    private void deactivateIfNeeded() {
        if(this.position.y >800){
            this.isActive = false;
        }
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
