import java.awt.*;

public class PlayerEnemy {
    int x;
    int y;
    Image image;

    PlayerEnemy(int x, int y){
        this.x = x;
        this.y = y;
        this.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
    }

    public void render(Graphics g) {
        g.drawImage(this.image,this.x, this.y, null);
    }

    public void run() {
        this.y +=3;
    }
}
