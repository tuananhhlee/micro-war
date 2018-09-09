package players;

import bases.*;
import enemies.PlayerEnemy;

import java.awt.*;

public class PlayerBullet extends GameObject {

    //Image image;

    public PlayerBullet(int x, int y){
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/bullet/player/mb69bullet1.png");
        this.boxCollider = new BoxCollider(x,y,10,20);
    }

    @Override
    public void run() {
        super.run();
        move();
        hitEnemies();
    }

    private void hitEnemies() {
        PlayerEnemy enemy =GameObject.checkCollision(this.boxCollider);
        if (enemy!=null){
            System.out.println("Hit");
            enemy.getHit();
            this.destroy();
        }
    }

    private void move() {
        this.position.addUp(0,-10);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }
}
