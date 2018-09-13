package players;

import bases.*;
import enemies.PlayerEnemy;

import java.awt.*;

public class PlayerBullet extends GameObject {

    //Image image;

    public PlayerBullet(int x, int y){
        super(x,y);
        this.renderer = new Animation(
                ImageUtil.load("images/bullet/player/mb69bullet1.png"),
                ImageUtil.load("images/bullet/player/mb69bullet2.png"),
                ImageUtil.load("images/bullet/player/mb69bullet3.png"),
                ImageUtil.load("images/bullet/player/mb69bullet4.png")
        );
        this.boxCollider = new BoxCollider(x,y,10,20);
    }

    @Override
    public void run() {
        super.run();
        move();
        hitEnemies();
        deactivateIfNeeded();
    }

    private void deactivateIfNeeded() {
        if(this.position.y<0){
            this.isActive = false;
        }
    }

    private void hitEnemies() {
        PlayerEnemy enemy =GameObject.checkCollision(this.boxCollider,PlayerEnemy.class);
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
