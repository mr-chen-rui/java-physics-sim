public class Entity {

    
    float worldX, worldY, radius;
    float velocityX, velocityY;

    Entity(float x,float y,float radius){
        this.worldX = x;
        this.worldY = y;
        this.radius = radius;
    }


    public float dist(float x1, float y1, float x2, float y2){
        return (float) Math.sqrt(Math.pow(x2-x1, 2)+ Math.pow(y2-y1,2));
    }
    public void collide_with(Entity other){
        if (this.radius + other.radius < dist(this.worldX, this.worldY, other.worldX, other.worldY)){
            

        }
    }
    
    

}
