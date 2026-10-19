import java.util.*;

public class Physics {
    private List<Entity> entities = new ArrayList<>();
    private List<StaticWall> walls = new ArrayList<>();
    private Vector2 gravity = new Vector2(0, -9.81);

    public void addEntity(Entity e){
        this.entities.add(e);
    }
    public void removeEntity(Entity e){

    }
    public void addWall(StaticWall w){
        this.walls.add(w);
    }
    public void removeWall(StaticWall w){

    }

    public StaticWall[] getWalls(){
        StaticWall[] walls = new StaticWall[ this.walls.size()];
        this.walls.toArray(walls);
        return walls;
    }
    public  Entity[] getEntities(){
        Entity[] entities = new Entity[ this.entities.size()];
        this.entities.toArray(entities);
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
