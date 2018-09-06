package players;

import bases.GameObject;
import bases.ImageRenderer;

public class Player2 extends GameObject {
    public Player2(int x, int y) {
        super(x, y);
        this.imageRenderer = new ImageRenderer("images/player/MB-69/player2.png");
    }
    public void run(){
        super.run();
    }
}
