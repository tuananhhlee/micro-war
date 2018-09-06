package Blood;

import bases.Vector2D;

public class BloodMove {
    public void run(Vector2D position){
        Vector2D velocity = new Vector2D();
        velocity.y +=3;
        position.addUp(velocity);
    }
}
