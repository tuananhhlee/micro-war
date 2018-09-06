package enemies;

import bases.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class PlayerEnemy extends GameObject {
    EnemyMove enemyMove;
    EnemyShoot enemyShoot;
    ImageRenderer imageRenderer;
    FrameCounter frameCounter;
    Random random;
    public ArrayList<EnemyBullet> enemyBullets;



    public PlayerEnemy(int x, int y){
        super (x,y);
        this.imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
        this.enemyMove = new EnemyMove();
        this.enemyShoot = new EnemyShoot();
        random = new Random();
        enemyBullets = new ArrayList<>();
        frameCounter = new FrameCounter(100);


    }

    public void render(Graphics g) {
        super.render(g);
        for (EnemyBullet e:enemyBullets){
            e.render(g);
        }
    }

    public void run() {
        this.move();
        this.shoot();
        super.run();
    }

    private void shoot() {
        this.enemyShoot.run(this);
    }

    private void move() {
        this.enemyMove.run(this.position);
    }

}
