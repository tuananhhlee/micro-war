package players;

import bases.Animation;
import bases.GameObject;
import bases.ImageUtil;

public class PBAnimation extends GameObject {
    public PBAnimation(int x, int y) {
        super(x, y);
        this.renderer = new Animation(3, true,
                ImageUtil.load("images/bullet/player/mb69bullet1.png"),
                ImageUtil.load("images/bullet/player/mb69bullet2.png"),
                ImageUtil.load("images/bullet/player/mb69bullet3.png"),
                ImageUtil.load("images/bullet/player/mb69bullet4.png")
        );
    }

    @Override
    public void run() {
        super.run();
        Animation animation = (Animation)this.renderer;
        if (animation.finished){
            this.destroy();
        }
    }
}
