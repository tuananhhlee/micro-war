package Blood;

import bases.GameObject;
import bases.ImageRenderer;

public class Blood extends GameObject {
    BloodMove bloodMove;

    public Blood(int x, int y) {
        super(x, y);
        this.imageRenderer = new ImageRenderer("images/blood cells/blood-cell1.png");
        this.bloodMove = new BloodMove();
    }
    public void run(){
        super.run();
        this.move();
    }

    private void move() {
        this.bloodMove.run(this.position);
    }
}
