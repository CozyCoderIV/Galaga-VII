package com.company;

import com.company.objects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable, KeyListener
{   // ScoreBoard Class

    // Attributes
    public static final int WIDTH = 860;
    public static final int HEIGHT = 670;

    public boolean running = true;
    private Thread gameThread;

    private MovingBackground mb;
    private ScoreBoard scoreBoard;
    private HealthBoard healthBoard;
    private ObjectHandler oh;

    private Object_Player ptemp;
    private Object_Boss btemp;
    private Object_Enemy etemp;

    private int gScore = 0;
    private int gHealth = 100;

    // Constructor
    public Game(){
        canvasSetUp();
        init();
    }

    // Methods
    public void canvasSetUp(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.addKeyListener(this);
        this.setFocusable(true);
    }
    public void init(){
        // Initialize GameObjects
        oh = new ObjectHandler();

        // Initialize Moving Background
        mb = new MovingBackground(0, 0);

        // Initialize ScoreBoard && HealthBar
        scoreBoard = new ScoreBoard(); // maybe pass in a player
        healthBoard = new HealthBoard(); // maybe pass in a player
    }
    public void draw(){
        // Initialize Drawing Tools
        BufferStrategy buffer = this.getBufferStrategy();
        if (buffer == null)
        {   this.createBufferStrategy(5);
            return;
        }

        Graphics g = buffer.getDrawGraphics();
        Graphics2D g3d = (Graphics2D) buffer.getDrawGraphics();

        // Draw Background
        drawBackground(g);
        // Draw Moving Background
        mb.draw(g3d);

        // Draw Object Handler
        oh.drawPlayer(g3d);
        oh.drawBoss(g3d);
        oh.drawEnemy(g3d);

        // Draw ScoreBoard && HealthBar
        if(!oh.getPlayerList().isEmpty())
        {   healthBoard.draw(g3d, oh.getPlayer()); // 100 HP
            scoreBoard.draw(g3d, oh.getPlayer());

            if(oh.getPlayer().getHealth() <= 50){
                healthBoard.drawHalf(g3d, oh.getPlayer());
            } // 50 HP
            if(oh.getPlayer().getHealth() <= 25){
                healthBoard.drawQuarter(g3d, oh.getPlayer());
            } // 25 HP
        }
        if(oh.getPlayerList().isEmpty()){healthBoard.drawBase(g3d);scoreBoard.drawBase(g3d);}

        // Dispose -> Actually Draws (Puts Things On Screen)
        g.dispose();
        g3d.dispose();
        buffer.show();
    }
    public void drawBackground(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        Image bimg = new ImageIcon("src/com/company/images/space_edited (1) copy.png").getImage();
        g.drawImage(bimg,0, 0, this);
    }
    public void start(){
        gameThread = new Thread(this);
        gameThread.start();
        running = true;
    }
    public void update(){
        // Update Background
        mb.update();

        // Update Object Handler
        if (!oh.getPlayerList().isEmpty()){   ptemp = oh.getPlayer();
            oh.updatePlayer(ptemp);
        }
        // Update Boss
        if(!oh.getBossList().isEmpty()){   btemp = oh.getBoss();
            oh.updateBoss(btemp);
        }
        // Update Enemy
        if(!oh.getEnemyList().isEmpty()){
            etemp = oh.getEnemy();
            oh.updateEnemy(etemp);
        }


    }

    // Methods (Runnable)
    @Override
    public void run()  // Start Game Thread
    {   // Game Loop
        final int MAX_fps = 60;
        final int MAX_ups = 60;

        final double F_Optimal = 1000000000/ MAX_fps;
        final double U_Optimal = 1000000000/ MAX_ups;

        double fDeltaTime = 0;
        double uDeltaTime = 0;

        long startTime = System.nanoTime();


        while(running)
        {   // Calaculate difference in time
            long currentTime = System.nanoTime();
            uDeltaTime += (currentTime - startTime);
            fDeltaTime += (currentTime - startTime);
            startTime = currentTime;

            if (uDeltaTime >= U_Optimal)
            {   update();
                uDeltaTime -= U_Optimal;
            }
            if (fDeltaTime >= F_Optimal)
            {   draw();
                fDeltaTime -= F_Optimal;
            }
        }
    }

    // Methods (Key Input)
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e)  // Player Input
    {   switch(e.getKeyCode())
        {   case 37: // left
                oh.getPlayer().setxVelocity(-9);
                oh.getPlayer().getLaser().setXVel(-9);
                break;
            case 39: // right
                oh.getPlayer().setxVelocity(9);
                oh.getPlayer().getLaser().setXVel(9);
                break;
            case 38: // up
                oh.getPlayer().setxVelocity(0);
                oh.getPlayer().getLaser().setXVel(0);
                break;
            case 32: // Space -> (Shoot)
                oh.getPlayer().shoot();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
