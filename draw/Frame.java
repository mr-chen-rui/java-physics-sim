import java.awt.*;
import javax.swing.*;
public class Frame extends JFrame{
    
    Panel Panel;

    Frame(String title){
        Panel = new Panel();
        this.add(Panel);
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.pack();
    }

    
}
