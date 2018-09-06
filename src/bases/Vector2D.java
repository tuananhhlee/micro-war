package bases;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D( float x, float y ){
        this.x = x;
        this.y = y;
    }

    public Vector2D (){
        this.x = 0; //this(0,0) sử dụng luôn hàm this bên trên
        this.y = 0;
    }

    public void addUp(float x, float y){
        this.x += x;
        this.y += y;
    }
    public void addUp (Vector2D other){
        this.addUp(other.x, other.y );
    }

    public Vector2D add(float x, float y){
        return new Vector2D(this.x +x, this.y +y );
    }
    Vector2D add(Vector2D other){
        return this.add(other.x,other.y);
    }

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(2,3);
//        v1.print();
//        v1.addUp(3, 5);
//        bases.Vector2D v2 = new bases.Vector2D();
//        v2.print();
        Vector2D v3 = v1.add(3,4);
        v3.print();
        v1.print();
        Vector2D v4 = new Vector2D(2, 4);
        v4.subtractBy(1,2);
        assert v4.x ==1;
        assert v4.y == 2;
        v4.subtractBy(new Vector2D(1,3));


        Vector2D v5 = v4.subtract(4,3);
        assert v5.x == -4;

    }
    void print (){
        System.out.println(this.x + "," + this.y );
    }
    void subtractBy(float x, float y){
        this.x -= x;
        this.y -= y;
    }
    void subtractBy(Vector2D other){
        this.subtractBy(other.x, other.y );
    }
    public Vector2D subtract(float x, float y){
        return new Vector2D(this.x - x, this.y -y);
    }
    Vector2D subtract(Vector2D other){
        return this.subtract(other.x, other.y);
    }
    void scaleBy(float f){
        this.x *=f;
        this.y *= f;
    }
    Vector2D scale(float f){
        return new Vector2D(this.x *f,this.y*f);
    }
    float length(){
        return (float) Math.sqrt(x*x +y *y);
    }
    Vector2D nomalize(){
        float length = this.length();
        return new Vector2D(this.x/length,this.y/length);
    }
}
