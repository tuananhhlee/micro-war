package enemies;

import bases.ImageRenderer;
import bases.ImageUtil;
import bases.Vector2D;


import java.awt.*;
import java.util.ArrayList;

public class PlayerEnemy {
    Image image;
    Vector2D position;
    EnemyMove enemyMove;
    EnemyShoot enemyShoot;
    ImageRenderer imageRenderer;
    public ArrayList<PlayerEnemy> enemies;

    public PlayerEnemy(int x, int y){
        this.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
        this.position = new Vector2D(x,y);
        this.enemyMove = new EnemyMove();
        this.enemyShoot = new EnemyShoot();
    }

    public void render(Graphics g) {
        imageRenderer.render(g,this.position);
    }

    public void run() {
        this.move();
        this.shoot();
    }

    private void shoot() {
        this.enemyShoot.run(this);
    }

    private void move() {
        this.enemyMove.run(this.position);
    }
}
