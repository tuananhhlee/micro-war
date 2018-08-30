package players;

import java.awt.*;
import java.util.ArrayList;
import bases.ImageRenderer;
import bases.Vector2D;

public class Player {
    Vector2D position;
    ImageRenderer imageRenderer;
    PlayerMove playerMove;
    PlayerShoot playerShoot;
    public ArrayList<PlayerBullet> bullets;



    public Player(int x, int y) {
        this.position = new Vector2D(x,y);
        this.imageRenderer = new ImageRenderer("images/player/MB-69/player1.png");
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
    }

    public void render(Graphics g) {
        imageRenderer.render(g,this.position);
    }


    public void run() {
        this.move();
        this.shoot();
    }

    void move() {
        this.playerMove.run(this.position);
    }

    private void shoot() {
        this.playerShoot.run(this);
    }
}
