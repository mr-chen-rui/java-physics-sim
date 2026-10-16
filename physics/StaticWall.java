public class StaticWall {

    protected Vector2 start, end;
    protected Vector2 normal;

    public StaticWall(Vector2 start, Vector2 end){
        this.start = start;
        this.end = end;

        this.normal = new Vector2(end.y - start.y, -end.x + start.x).normalize(); // There's two normals for each vector idk which to use but this msg will help when i start debuggin
    }
}




