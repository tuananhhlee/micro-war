package enemies;

import bases.Animation;
import bases.GameObject;
import bases.ImageUtil;

public class EBAnimation extends GameObject {
    public EBAnimation(int x, int y) {
        super(x, y);
        this.renderer = new Animation(3, true,
                ImageUtil.load("images/bullet/enemy/enemy_bullet1.png"),
                ImageUtil.load("images/bullet/enemy/enemy_bullet2.png"),
                ImageUtil.load("images/bullet/enemy/enemy_bullet3.png"));
    }

    @Override
    public void run() {
        super.run();
        Animation animation = (Animation)this.renderer;
        if (animation.finished){
            this.gameover();
        }
    }
}
