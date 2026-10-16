import java.util.ArrayList;

public class Physics {
    private Entity[] entities;
    private StaticWall[] walls;
    private Vector2 gravity = new Vector2(0, -9.81);

    public void addEntity(Entity e){

    }
    public void removeEntity(Entity e){

    }
    public void addWall(StaticWall w){

    }
    public void removeWall(StaticWall w){

    }

    public StaticWall[] getWalls(){
        return walls;
    }
    public  Entity[] getEntities(){
        return entities;
    }

    public void physicsStep(double delta){
        for (Entity entity : entities) {
            entity.addForce(gravity);
            for (Entity e : entities){
                if (entity == e){
                    continue;
                }
                else{

                }
            }
            
        }
    }
}
