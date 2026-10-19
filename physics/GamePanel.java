import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    final int originalPanelSize = 16;
    final int scale = 3;
    final int panelSize = originalPanelSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = panelSize * maxScreenCol;
    final int screenHeight = panelSize * maxScreenRow;
    final double COLL_MARGIN = 5;
    final double restitution = 0.6;

    int FPS = 60;

    Thread gameThread;
    final public KeyHandler keyH = new KeyHandler();
    final public MouseHandler mouseH = new MouseHandler();
    final public Physics physics = new Physics();


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        addMouseListener(mouseH);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();

        physics.addEntity(new Entity(200,200,20));
        physics.addEntity(new Entity(400,300,20));
        physics.addEntity(new Entity(600,400,20));
    }

    @Override
    public void run(){


        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null){
            
            // System.out.println("RUNNING");
            

            // First UPDATE

            update();

            // THEN draw

            repaint();   // This calls paintComponent (the one we overrode)

            

            try {
                double remainingTime = nextDrawTime-System.nanoTime();
                remainingTime = remainingTime/1000000;
                if (remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){ // Physics update function
        if (mouseH.mousedown == true){
            mouseH.mousedown = false;
            physics.addEntity(new Entity(mouseH.mousepos,20));
        }
    }

    public void drawLine(Graphics2D g, Vector2 start, Vector2 end){ // Wrapper func
        g.drawLine((int) start.x, (int) start.y, (int) end.x, (int) end.y);
    }
    public void drawCircle(Graphics2D g, Vector2 start, double radius){
        g.fillOval((int)(start.x - radius), (int)(start.y - radius), (int)(radius * 2), (int)(radius * 2)); // Wrapper
    }

    public void paintComponent(Graphics g){  //Overrides JPanel's paintComponent
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.WHITE);

        //Walls
        StaticWall[] walls = physics.getWalls();
        if (walls != null){
            for (int i = 0; i < walls.length;i++){
                StaticWall w = walls[i];
                if (w != null){
                    drawLine(g2, w.start, w.end);
                }
            }
        }
        

        //Entities
        Entity[] entities = physics.getEntities();
        if (entities != null){
            for (int i = 0; i < entities.length; i++){
                Entity e = entities[i];

                if (e != null){

                    //Draw
                    drawCircle(g2, e.position, e.radius);
                }
            }
        }
        

        g2.dispose(); // Gets rid of g2 and frees some memory.
    }
}
