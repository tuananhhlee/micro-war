package bases;

import enemies.EnemyBullet;
import enemies.PlayerEnemy;
import players.Player;
import players.PlayerBullet;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    public Vector2D position;
    public Renderer renderer;
    public boolean isActive;
    public boolean isAlive;
    private static ArrayList<GameObject> gameObjects = new ArrayList<>();
    private static ArrayList<GameObject> newGameObjects = new ArrayList<>();

    public static void add(GameObject g) {
        newGameObjects.add(g);
    }

    public static void runAll() {
        for (GameObject go : gameObjects) {
            if (go.isActive && go.isAlive)
                go.run();
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
        System.out.println(gameObjects.size());
    }

    public static void renderAll(Graphics g) {
        for (GameObject go : gameObjects) {
            if (go.isActive && go.isAlive)
                go.render(g);
        }
    }

    public static PlayerBullet recycle(int x, int y) {
        PlayerBullet pb = null;
        for (GameObject go : gameObjects) {
            if (!go.isActive) {
                if (go instanceof PlayerBullet) {
                    pb = (PlayerBullet) go;
                }
            }
        }
        if (pb == null) {
            pb = new PlayerBullet(x, y);
            GameObject.add(pb);
        } else {
            pb.isActive = true;
            pb.position.x = x;
            pb.position.y = y;
        }
        return pb;
    }

    public static PlayerEnemy recyclePE(int x, int y) {
        PlayerEnemy pe = null;
        for (GameObject go : gameObjects) {
            if (!go.isActive) {
                if (go instanceof PlayerEnemy) {
                    pe = (PlayerEnemy) go;
                }
            }
        }
        if (pe == null) {
            pe = new PlayerEnemy(x, y);
            GameObject.add(pe);
        } else {
            pe.isActive = true;
            pe.position.x = x;
            pe.position.y = y;
        }
        return pe;
    }

    public static EnemyBullet recycleEB(int x, int y){
        EnemyBullet eb = null;
        for (GameObject go:gameObjects){
            if (!go.isActive){
                if (go instanceof  EnemyBullet){
                    eb = (EnemyBullet)go;
                }
            }
        }
        if (eb ==null){
            eb = new EnemyBullet(x,y);
            GameObject.add(eb);
        }
        else {
            eb.isActive =true;
            eb.position.x = x;
            eb.position.y = y;
        }
        return eb;
    }

    //Generics: tổng quát kiểu
    public static <T extends GameObject> T checkCollision(BoxCollider boxCollider,Class<T> cls) {
        T result = null;
        for (GameObject go : gameObjects) {
            if (go.isActive&&go.boxCollider!=null) {
                if (go.getClass().equals(cls)) {
                    if (go.boxCollider.collideWith(boxCollider)){
                        result =(T)go;
                    }
                }
            }
        }
        return result;
    }

    public static Player checkCollisionplayers(BoxCollider boxCollider){
        Player result = null;
        for (GameObject go:gameObjects){
            if (go.isActive&&go.boxCollider != null){
                if (go instanceof Player){
                    if (go.boxCollider.collideWith(boxCollider)){
                        result =(Player)go;
                    }
                }
            }
        }
        return result;
    }

    public BoxCollider boxCollider;

    public GameObject(int x, int y ){
        this.position = new Vector2D(x,y);
        this.renderer = null;
        this.boxCollider = null;
        this.isActive = true;
        this.isAlive=true;
    }
    public void run(){
        if (this.boxCollider!=null){
            this.boxCollider.position.x = this.position.x;
            this.boxCollider.position.y = this.position.y;
            this.boxCollider.run();
        }
    }

    public void render(Graphics g){
        if(this.renderer != null){
            this.renderer.render(g,this.position);
        }

        if (this.boxCollider!=null){
            this.boxCollider.render(g);
        }
    }
    public void destroy(){
        this.isActive=false;
    }

    public void gameover(){
        this.isAlive=false;
        System.exit(0);
    }
}
