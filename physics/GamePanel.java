import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    final int originalPanelSize = 16;
    final int scale = 3;
    final int panelSize = originalPanelSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = panelSize * maxScreenCol;
    final int screenHeight = panelSize * maxScreenRow;

    final float restitution = 0.6f;

    int FPS = 60;

    Thread gameThread;
    KeyHandler keyH = new KeyHandler();

    float playerX = 100;
    float playerY = 100;
    float playerSpeed = 48;

    public Entity[] entities = {
        new Entity(200,200,20),
        new Entity(400,300,20),
        new Entity(600,400,20)
    };

    public float dot(float x1,float y1,float x2,float y2){
        return x1*x2 + y1*y2;
    }
    public StaticWall[] walls = {
        new StaticWall(0,screenHeight,screenWidth,screenHeight),
    };


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
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

    public void update(){

        // Movement code (not needed)
        // if (keyH.upPressed == true){
        //     playerY -= playerSpeed;
        // }
        // if (keyH.downPressed == true){
        //     playerY += playerSpeed;
        // }
        // if (keyH.leftPressed == true){
        //     playerX -= playerSpeed;
        // }
        // if (keyH.rightPressed == true){
        //     playerX += playerSpeed;
        // }
    }

    public void paintComponent(Graphics g){  //Overrides JPanel's paintComponent
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.WHITE);


        //Walls

        for (int i = 0; i < walls.length;i++){
            StaticWall w = walls[i];
            if (w != null){
                g2.drawLine((int)w.startX, (int)w.startY, (int)w.endX, (int)w.endY);
            }
        }

        //Entities

        for (int i = 0; i < entities.length; i++){
            Entity e = entities[i];

            if (e != null){

                //Physics step (one 'tick' is 1000000000/60 nanosecond or 16666666)

                e.worldY += e.velocityY;
                e.worldX += e.velocityX;
                e.velocityY += 1.0;

                for (int j = 0;j<walls.length;j++){
                    StaticWall w = walls[j];

                    if (w != null){
                        //System.out.println(w.dx+"      "+  -w.dy);
                        if ( w.lineCircle(e.worldX,e.worldY,e.radius) ){//need better detection algorithm
                            
                            e.worldY = screenHeight - e.radius;

                            e.velocityY = (float) Math.floor(-e.velocityY * (restitution));

                        }
                    }
                }

                for (int j = 0;j<entities.length;j++){
                    Entity other = entities[i];
                    if (other != e && other != null){
                        
                    }
                }



                //Draw
                g2.fillOval((int)(e.worldX - e.radius), (int)(e.worldY - e.radius), (int)(e.radius * 2), (int)(e.radius * 2));
            }
        }
        // g2.fillRect(playerX,playerY,48,48);
        




        g2.dispose(); // Gets rid of g2 and frees some memory.
    }
}
