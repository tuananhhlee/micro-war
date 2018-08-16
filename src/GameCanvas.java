

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    Image background;
    Image player;

    ArrayList<PlayerBullet> bs;
    ArrayList<PlayerEnemy> es;

    int x = 300 - 32;
    int y = 700 - 40;

    boolean rightPressed = false;
    boolean leftPressed = false;
    boolean upPressed = false;
    boolean downPressed = false;
    boolean xPressed = false;

    BufferedImage backBuffer;
    Graphics backbufferGraphics;

    public GameCanvas() {
        bs = new ArrayList<>();
        es = new ArrayList<>();

        PlayerBullet b1 = new PlayerBullet();
        b1.x = 300;
        b1.y = 700;

        PlayerBullet b2 = new PlayerBullet();
        b2.x = 300;
        b2.y = 600;

        try {
            background = ImageIO.read(new File("images/background/background.png"));
            player = ImageIO.read(new File("images/player/MB-69/player1.png"));
            b1.image = ImageIO.read(new File("images/bullet/player/mb69bullet1.png"));
            b2.image = ImageIO.read(new File("images/bullet/player/mb69bullet1.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        bs.add(b1);
        bs.add(b2);

        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backbufferGraphics = backBuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }

    void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = true;
        }

    }

    void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = false;
        }
    }

    void run() {
        if (rightPressed) {
            x += 5;
        }
        if (leftPressed) {
            x -= 5;
        }
        if (downPressed) {
            y += 5;
        }
        if (upPressed) {
            y -= 5;
        }
        for (PlayerBullet b : bs) {
            b.y -= 10;
        }
        for (PlayerEnemy e : es){
            e.y += 2;
        }
        if (enemyLock == false) {
            PlayerEnemy e1 = new PlayerEnemy();
            e1.x = 100;
            e1.y = 50;
            PlayerEnemy e2 = new PlayerEnemy();
            e2.x = 300;
            e2.y = 50;
            PlayerEnemy e3 = new PlayerEnemy();
            e3.x = 500;
            e3.y = 50;

            try {
                e1.image = ImageIO.read(new File("images/bullet/enemy/enemy2_bullet1.png"));
                e2.image = ImageIO.read(new File("images/bullet/enemy/enemy2_bullet1.png"));
                e3.image = ImageIO.read(new File("images/bullet/enemy/enemy2_bullet1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            es.add(e1);
            es.add(e2);
            es.add(e3);
            enemyLock = true;
        }
        if (enemyLock){
            counte++;
            if (counte >100){
                enemyLock = false;
                counte = 0;
            }
        }


        if (xPressed && shootLock == false) {
            PlayerBullet newB = new PlayerBullet();
            newB.x = x;
            newB.y = y;
            try {
                newB.image = ImageIO.read(new File("images/bullet/player/mb69bullet1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            bs.add(newB);
            shootLock = true;
            }
            if(shootLock){
                count++;
                if(count > 30){
                    shootLock = false;
                    count = 0;
                }
            }
        }


        boolean shootLock = false;
        int count;
        boolean enemyLock = false;
        int counte;

        void render () {
            backbufferGraphics.drawImage(background, 0, 0, null);
            backbufferGraphics.drawImage(player, x, y, null);

            for (PlayerBullet b : bs) {
                backbufferGraphics.drawImage(b.image, b.x, b.y, null);
            }

            for (PlayerEnemy e:es){
                backbufferGraphics.drawImage(e.image, e.x, e.y, null);
            }
            this.repaint();
        }
    }

