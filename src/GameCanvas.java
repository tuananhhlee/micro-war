

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

    public GameCanvas() {
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        random = new Random();
        player = new Player(300, 400);
        inputManager = new InputManager();

        background = ImageUtil.load("images/background/background.png");
        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backbufferGraphics = backBuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }


    void run() {
        player.run(bullets);


        for (PlayerEnemy e : enemies){
            e.run();
        }
        // hiện enemy
        counte++;
        if (counte >= 60) {
            counte = 0;
            PlayerEnemy enemy = new PlayerEnemy(random.nextInt(600) ,10);
            enemies.add(enemy);
        }

        /*if (inputManager.xPressed && shootLock == false) {
            PlayerBullet newB = new PlayerBullet(player.x, player.y);
            bullets.add(newB);
            shootLock = true;
            }
            if(shootLock){
                count++;
                if(count > 30){
                    shootLock = false;
                    count = 0;
                }
            }*/
        }

        /*boolean shootLock = false;
        int count;*/
        boolean enemyLock = false;
        int counte;

        void render () {
            backbufferGraphics.drawImage(background, 0, 0, null);
            //backbufferGraphics.drawImage(playerX, x, playerY, null);
            player.render(backbufferGraphics);

            for (PlayerBullet b : bullets) {
                b.render(backbufferGraphics);
               // backbufferGraphics.drawImage(b.image, b.x, b.y, null);
            }

            for (PlayerEnemy e:enemies){
                e.render(backbufferGraphics);
                //backbufferGraphics.drawImage(e.image, e.x, e.y, null);
            }
            this.repaint();
        }
    }

