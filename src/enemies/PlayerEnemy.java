package enemies;

import bases.*;
import players.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class PlayerEnemy extends GameObject {
    EnemyMove enemyMove;
    EnemyShoot enemyShoot;
    FrameCounter frameCounter;
    Random random;



    public PlayerEnemy(int x, int y){
        super (x,y);
        //ArrayList<Image> images = new ArrayList<>();
        this.renderer = new Animation(
                ImageUtil.load("images/enemy/bacteria/bacteria1.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria2.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria3.png")
        );

        this.enemyMove = new EnemyMove();
        this.enemyShoot = new EnemyShoot();
        random = new Random();
        frameCounter = new FrameCounter(100);
        this.boxCollider = new BoxCollider(x,y,30,30);
    }



    public void run() {
        this.move();
        this.shoot();
        super.run();
        hitPlayer();
    }

    private void hitPlayer() {
        Player player =GameObject.checkCollisionplayers(this.boxCollider);
        if(player!=null){
            System.out.println("Game Over");
            player.getHit();
            this.destroy();
        }
    }


    private void shoot() {
        this.enemyShoot.run(this);
    }

    private void move() {
        this.enemyMove.run(this.position);
    }
    public void getHit() {
        this.destroy();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }
}
