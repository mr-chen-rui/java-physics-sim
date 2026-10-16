
public class Vector2 {
    public double x;
    public double y;

    Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }
    static public double dot(Vector2 a, Vector2 b){
        return (a.x * b.x) + (a.y * b.y);
    }
    static public double dist(Vector2 a, Vector2 b){
        return Math.sqrt(Math.pow(b.x-a.x, 2)+Math.pow(b.y-a.y, 2));
    }
    public double dot(Vector2 b){
        return (this.x * b.x) + (this.y + b.y);
    }
    public Vector2 divide(double scalar){
        return new Vector2(this.x / scalar, this.y / scalar);
    }
    public Vector2 multiply(double scalar){
        return new Vector2(this.x * scalar, this.y * scalar);
    }
    public Vector2 add(Vector2 v){
        return new Vector2(this.x + v.x, this.y + v.y);
    }
    public Vector2 normalize(){
        double l = this.length();
        this.x = this.x / l;
        this.y = this.y / l;
        return this;
    }
    public double length(){
        return Math.sqrt(Math.pow(this.x,2)+ Math.pow(this.y,2));
    }
}

