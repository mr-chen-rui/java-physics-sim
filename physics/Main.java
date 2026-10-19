import javax.swing.JFrame;

public class Main{
    public static void main(String[] args){
        final double VERSION_NUMBER = 0.6;
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Physics Sim. " + VERSION_NUMBER);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();

    }
}

