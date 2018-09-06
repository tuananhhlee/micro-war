package game;

import Blood.Blood;
import bases.GameObject;
import bases.ImageUtil;
import enemies.EnemySpawner;
import inputs.InputManager;
import players.Player;
import players.Player2;
import players.PlayerBullet;
import enemies.PlayerEnemy;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {
    Image background;
    Random random;

    Player player;
    Player2 player2;
    PlayerEnemy enemy;

    BufferedImage backBuffer;
    Graphics backbufferGraphics;

    //BackGround backGround;

    EnemySpawner enemySpawner;

    Blood blood;

    public GameCanvas() {
        random = new Random();
        player = new Player(300, 700);
        enemy = new PlayerEnemy(random.nextInt(600), 10);
        GameObject.add(player);

        player2 = new Player2(100,200);
        GameObject.add(player2);

        enemySpawner = new EnemySpawner(10,10);
        GameObject.add(enemySpawner);

        blood = new Blood(random.nextInt(200),200);
        GameObject.add(blood);

//        backGround = new BackGround(600,800);
//        GameObject.add(backGround);


        background = ImageUtil.load("images/background/background.png");
        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backbufferGraphics = backBuffer.getGraphics();

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }


    void run() {
        GameObject.runAll();
        }

        void render () {
            backbufferGraphics.drawImage(background, 0, 0, null);
            GameObject.renderAll(backbufferGraphics);
            this.repaint();
        }
    }

