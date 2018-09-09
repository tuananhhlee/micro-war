package bases;

import enemies.PlayerEnemy;
import players.Player;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    public Vector2D position;
    public ImageRenderer imageRenderer;
    public boolean isActive;
    public boolean isAlive;
    private static ArrayList<GameObject> gameObjects = new ArrayList<>();
    private static ArrayList<GameObject> newGameObjects = new ArrayList<>();

    public static void add(GameObject g){
        newGameObjects.add(g);
    }

    public static void runAll(){
        for(GameObject go:gameObjects){
            if (go.isActive && go.isAlive)
            go.run();
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public static void renderAll(Graphics g){
        for (GameObject go:gameObjects){
            if (go.isActive&&go.isAlive)
            go.render(g);
        }
    }

    public static PlayerEnemy checkCollision(BoxCollider boxCollider) {
        PlayerEnemy result = null;
        for (GameObject go : gameObjects) {
            if (go.isActive&&go.boxCollider!=null) {
                if (go instanceof PlayerEnemy) {
                    if (go.boxCollider.collideWith(boxCollider)){
                        result =(PlayerEnemy)go;
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
        this.imageRenderer = null;
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
        if(this.imageRenderer != null){
            this.imageRenderer.render(g,this.position);
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
    }
}
