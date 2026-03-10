import static java.lang.Math.sqrt;

public class StaticWall {

    final double coll_buffer = 0.9;

    double startX, startY, endX, endY;

    double length = dist(startX,startY,endX,endY) ;

    double dx,dy;

    public StaticWall(double startX, double startY, double endX, double endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

        this.length = dist(startX,startY,endX,endY) ;

        double x = (double)(startX-endX);
        double y = (double)(startY-endY);

        this.dx = x/ magnitude(x, y);
        this.dy = y/ magnitude(x, y);

        // System.out.println(x+"    "+y);
        // System.out.println(magnitude(x,y));
        

    }

    public double magnitude(double x,double y){

        return (double)sqrt(x*x + y*y);

    }

    public boolean pointCircle(double px, double py, double radius,double originx, double originy){

        if (dist(px,py,originx, originy)<= radius){
            return true;
        }
        else{
            return false;
        }
    }

    public double dist(double x1, double y1, double x2, double y2){
        return (double)sqrt( (x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1) );
    }


    public boolean pointLine(double px, double py, double radius){

        double dist1 = dist(startX,startY,px,py);
        double dist2 = dist(endX,endY,px,py);

        if (dist1+dist2 >length + radius*coll_buffer){
            return false;
        }
        else{
            return true;
        }
    }

    

    public boolean lineCircle(double cx, double cy, double radius){

        boolean inside1 = pointCircle(startX,startY, cx,cy,radius);
        boolean inside2 = pointCircle(endX,endY , cx,cy,radius);
        if (inside1 || inside2) return true;
        
        vector closest = nearestPointOnLine(cx,cy);
        boolean onSegment = pointLine(closest.x,closest.y,1);
        if (!onSegment) return false;

        
        double distance = dist(closest.x,closest.y, cx,cy);

        if (distance <= radius) {
            return true;
        }
        return false;
        
        }

        public vector nearestPointOnLine(double px, double py){
        double dot = ( ((px-startX)*(endX-startX)) + ((py-endY)*(endY-startY)) ) / Math.pow(length,2);
        double closestX = startX + (dot * (endX - startX));
        double closestY = startY + (dot * (endY - startY));

        // System.out.println(closestX+"      "+closestY);
        return new vector(closestX,closestY);
    }

}




