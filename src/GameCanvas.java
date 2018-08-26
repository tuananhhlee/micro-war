

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {
    Image background;
    Random random;
    ArrayList<PlayerBullet> bullets;
    ArrayList<PlayerEnemy> enemies;
    Player player;
    InputManager inputManager;

    BufferedImage backBuffer;
    Graphics backbufferGraphics;
    int enemySpawnCount;

    public GameCanvas() {
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        random = new Random();
        player = new Player(268, 600);
        player.bullets = this.bullets;
        inputManager = new InputManager();
        player.inputManager = inputManager;

        background = ImageUtil.load("images/background/background.png");
        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backbufferGraphics = backBuffer.getGraphics();

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }


    void run() {
        player.run();
        for (PlayerBullet b : bullets) {
            b.run();
        }
        for (PlayerEnemy e : enemies){
            e.run();
        }
        // hiện enemy
        enemySpawnCount++;
        if (enemySpawnCount >= 60) {
            enemySpawnCount = 0;
            PlayerEnemy enemy = new PlayerEnemy(random.nextInt(600) ,10);
            enemies.add(enemy);
        }

        }

        void render () {
            backbufferGraphics.drawImage(background, 0, 0, null);

            player.render(backbufferGraphics);

            for (PlayerBullet b : bullets) {
                b.render(backbufferGraphics);
            }

            for (PlayerEnemy e:enemies){
                e.render(backbufferGraphics);
            }
            this.repaint();
        }
    }

