import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MouseHandler implements MouseListener {
    public vector mousepos = new vector(0,0);
    public boolean mousedown = false;

    @Override
    public void mouseExited(MouseEvent e){
      //Do not delete!
    }
    @Override
    public void mouseReleased(MouseEvent e){

    }
    @Override
    public void mouseClicked(MouseEvent e){
      
    }
    @Override
    public void mousePressed(MouseEvent e){
      mousepos = new vector(e.getX(),e.getY());
      mousedown = true;
      System.out.println("Clicked!");
      System.out.println(e.getY());
    }
    @Override
    public void mouseEntered(MouseEvent e){

    }

}
