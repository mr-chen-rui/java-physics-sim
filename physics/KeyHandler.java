import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;


public class KeyHandler implements KeyListener ,MouseInputListener{

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public vector mousepos = new vector(0,0);
    public boolean mousedown = false;

    @Override
    public void mouseExited(MouseEvent e){
      //Do not delete!
    }
    @Override
    public void mouseDragged(MouseEvent e){

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
    }
    @Override
    public void mouseEntered(MouseEvent e){

    }
    @Override
    public void mouseMoved(MouseEvent e){

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Unused method, must be kept so do NOT delete
    }

    @Override
    public void keyPressed(KeyEvent e) {
         int code = e.getKeyCode();

         if (code == KeyEvent.VK_W){
            upPressed = true;
         }

         if (code == KeyEvent.VK_A){
            leftPressed = true;
         }

         if (code == KeyEvent.VK_S){
            downPressed = true;
         }

         if (code == KeyEvent.VK_D){
            rightPressed = true;
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
           upPressed = false;
        }

        if (code == KeyEvent.VK_A){
           leftPressed = false;
        }

        if (code == KeyEvent.VK_S){
           downPressed = false;
        }

        if (code == KeyEvent.VK_D){
           rightPressed = false;
        }
    }
    
}
