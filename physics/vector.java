
public class vector {
    double x;
    double y;
    vector(double x, double y){
        this.x = x;
        this.y = y;
    }
    double dot(vector a, vector b){
        return (a.x * b.x) + (a.y * b.y);
    }
}
