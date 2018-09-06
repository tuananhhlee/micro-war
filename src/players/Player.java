package players;

import java.awt.*;
import java.util.ArrayList;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;

public class Player extends GameObject {
    PlayerMove playerMove;
    PlayerShoot playerShoot;


    public Player(int x, int y) {
        super(x, y);
        this.imageRenderer = new ImageRenderer("images/player/MB-69/player1.png");
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
    }

    public void run() {
        super.run();
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
