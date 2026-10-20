public class Entity {

    
    double radius;
    double radiusScale = 0.1;

    Vector2 position;
    Vector2 velocity = new Vector2(0, 0);

    Vector2 force = new Vector2(0, 0);
    double density = 1;
    double mass;

    Entity(float x,float y,float radius){
        this.position = new Vector2(x,y);
        this.radius = radius;
        mass = Math.PI * Math.pow(radius * radiusScale, 2) * density;
    }

    Entity(Vector2 pos,float radius){
        this.position = pos;
        this.radius = radius;
        mass = Math.PI * Math.pow(radius * radiusScale, 2) * density;
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
        if (time != 0){
            velocity = velocity.add(this.force.divide(this.mass).multiply(time)); // F=MA so A = F/M
            position = position.add(velocity);
        }
        this.force = new Vector2(0, 0);
    }

    @Override 
    public String toString(){
        return String.format("Entity with position %1$s, mass %2$f, velocity %3$s", this.position, this.mass, this.velocity);
    }
}