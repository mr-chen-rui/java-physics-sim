public class Entity {

    
    double worldX, worldY, radius;
    double velocityX, velocityY;

    Entity(float x,float y,float radius){
        this.worldX = x;
        this.worldY = y;
        this.radius = radius;
    }


    public double dist(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2-x1, 2)+ Math.pow(y2-y1,2));
    }
    public void collide_with(Entity other){
        if (this.radius + other.radius < dist(this.worldX, this.worldY, other.worldX, other.worldY)){
            

        }
    }
    
    Entity(vector pos,float radius){
        this.worldX = pos.x;
        this.worldY = pos.y;
        this.radius = radius;
    }


    public double dist(vector a, vector b){
        return  Math.sqrt(Math.pow(a.x-b.x, 2)+ Math.pow(a.y-b.y,2));
    }

}
