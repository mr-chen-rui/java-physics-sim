public class Entity {

    
    double radius;

    Vector2 position;
    Vector2 velocity;

    Vector2 force;
    double density = 1;
    double mass;

    Entity(float x,float y,float radius){
        this.position = new Vector2(x,y);
        this.radius = radius;
        mass = Math.PI * Math.pow(radius, 2)*mass;
    }

    Entity(Vector2 pos,float radius){
        this.position = pos;
        this.radius = radius;
        mass = Math.PI * Math.pow(radius, 2) * density;
    }

    public boolean collide_with(Entity other){
        if (this.radius + other.radius < Vector2.dist(this.position, other.position)){
            return true;

        }
        else{
            return false;
        }
    }
    public boolean collide_with(StaticWall other){
        return false;
    }


    public double dist(Vector2 a, Vector2 b){
        return  Math.sqrt(Math.pow(a.x-b.x, 2)+ Math.pow(a.y-b.y,2));
    }

    public void addForce(Vector2 f){
        this.force = this.force.add(f);
    }

    public void applyForce(double time){
        velocity = velocity.add(this.force.divide(this.mass).multiply(time)); // F=MA so A = F/M
        this.force = new Vector2(0, 0);
    }

    public void applyGravity(){ // F=MA so A = F/M

    }

}