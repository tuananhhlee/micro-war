import java.awt.*;

public class PlayerEnemy {
    Image image;
    Vector2D position;

    PlayerEnemy(int x, int y){
        this.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
        this.position = new Vector2D(x,y);
    }

    public void render(Graphics g) {
        g.drawImage(this.image,(int)this.position.x, (int)this.position.y, null);
    }

    public void run() {
        this.move();
    }

    private void move() {
        Vector2D velocity = new Vector2D();
        velocity.y +=3;
        this.position.addUp(velocity);
    }
}
