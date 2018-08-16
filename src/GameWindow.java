import javax.swing.*;
import java.awt.event.*;

public class GameWindow extends JFrame {

    GameCanvas canvas;

    public GameWindow(){
        // Setup Game Window

       this.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent windowEvent) {
               System.exit(0);  //0->OK
           }
       });
       this.addKeyListener(new KeyAdapter() {
           @Override
           public void keyTyped(KeyEvent e) {
               canvas.keyPressed(e);
           }

           @Override
           public void keyPressed(KeyEvent  e  ) {
                canvas.keyPressed(e);
           }

           @Override
           public void keyReleased(KeyEvent e) {
               canvas.keyReleased(e);
           }
       });
        this.setSize(600, 800);
        this.setResizable(false);
        this.setTitle("Micro-war");

        // Setup canvas
        canvas = new GameCanvas();
        this.setContentPane(canvas);
        this.setVisible(true);
    }

    long lastTimeRender = 0;

    void mainLoop(){
        while (true){
            long currentTime = System.nanoTime();
            if (currentTime - lastTimeRender >= 17_000_000){
                canvas.run ();
                canvas.render();
                lastTimeRender = currentTime;
            }
        }
    }
}
