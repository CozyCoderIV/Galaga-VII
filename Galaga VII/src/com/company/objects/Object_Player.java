package com.company.objects;

import javax.swing.*;
import java.awt.*;

public class Object_Player extends GameObject
{   // Laser Class
    public  class playerLaser{
        // Attributes
        protected int xPosition = 300;
        protected int yPosition = 565;
        protected int damage = 25;
        protected int yVel = 0;
        protected int xVel = 0;

        // Constructor(s)
        public playerLaser(){}
        public playerLaser(int x, int y){
            this.xPosition = x;
            this.yPosition = y;
        }

        // Methods (Getters && Setters)
        public int getXPos(){
            return xPosition;
        }
        public int getYPos(){
            return yPosition;
        }
        public int getYVel(){
            return yVel;
        }
        public int getDamage(){return damage;}

        public int setXPos(int newXPos){
            this.xPosition = newXPos;
            return xPosition;
        }
        public int setYPos(int newYPos){
            this.yPosition = newYPos;
            return yPosition;
        }
        public int setDamage(int newPower){
            this.damage = newPower;
            return damage;
        }
        public int setYVel(int speed){
            this.yVel = speed;
            return yVel;
        }
        public int setXVel(int speed){
            this.xVel = speed;
            return xVel;
        }

        public Image getImage(){
            Image limg = new ImageIcon("src/com/company/images/G5S (128x128) copy.png").getImage();
            return limg;
        }
        public Rectangle getBounds(){return new Rectangle(xPosition + 54, yPosition + 55, 20, 20);
        }

        // Methods
        public void updateLaser(){
            xPosition += xVel;
            yPosition += yVel;

            // Collision Mechanics
            if(xPosition < -30){
                xVel = 9;
                count++;
            }
            if(xPosition > 550){
                xVel = -9;
                count++;
            }
        }
        public void draw(Graphics2D g2d){
            g2d.drawImage(getImage(), xPosition, yPosition, null);
        }
    }

    // Result Class
    public class playerResult{
        // Attributes
        private int x;
        private int y;

        // Constructor(s)
        public playerResult(){}
        public playerResult(int x, int y){}

        // Methods
        public int setPRX(int val){
            pr.x = val;
            return pr.x;
        }
        public int setPRY(int val){
            pr.y = val;
            return pr.y;
        }

        public void drawResult(Graphics2D g2d){
            g2d.drawImage(getImage(), x, y, null);
        }
        public Image getImage(){
            Image rimg = new ImageIcon("src/com/company/images/Victory(256x256) copy.png").getImage();
            return rimg;
        }
    }

    // Attributes
    private int health;
    private int score = 0;
    private int xPosition;
    private int yPosition;
    private int xVelocity = 0;
    private int yVelocity = 0;
    private int speed = 9;

    // Debug Attributes
    private int count = 0;

    // Result && Laser Attributes
    private playerLaser pl = new playerLaser();
    private playerResult pr = new playerResult(300, 300);


    // Constructor
    public Object_Player(int health, int x, int y)
    {   super(health, x, y);
        this.health = health;
        this.xPosition = x;
        this.yPosition = y;

    }

    // Abstract Methods (Getters && Setters)
    @Override
    public int getHealth() {
        return health;
    }
    @Override
    public int getxPosition() {
        return xPosition;
    }
    @Override
    public int getyPosition() {
        return yPosition;
    }
    @Override
    public int getxVelocity() {
        return xVelocity;
    }
    @Override
    public int getyVelocity() {
        return yVelocity;
    }

    public int setxVelocity(int value){
        this.xVelocity = value;
        return xVelocity;
    }
    public int setHealth(int value){
        this.health = value;
        return health;
    }
    public int setScore(int value){
        this.score = value;
        return score;
    }

    @Override
    public Image getImage(){
        Image pimg = new ImageIcon("src/com/company/images/GalagaD copy.png").getImage();
        return pimg;
    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle(xPosition + 40, yPosition + 40, 50, 50);
    }
    public playerLaser getLaser(){return pl;}
    public int getScore(){
        return this.score;
    }
    public playerResult getPResult(){
        return pr;
    }


    // Abstract Methods
    @Override
    public void shoot() {
        pl.setYVel(-70);
        pl.setXVel(0);
    }
    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getImage(), xPosition, yPosition, null);
        //g2d.draw(getBounds());
    }
    @Override
    public void update() {
        xPosition += xVelocity;

        // Collision Mechanics
        if(xPosition < -30){
            xVelocity = 9;
            //count++;
            // health -= 25;
            //System.out.println(count);
        }
        if(xPosition > 550){
            xVelocity = -9;
            //count++;
            // health -= 25;
            //System.out.println(count);
        }

        // Laser Mechanics
        if(this.pl.yPosition < 0){
            pl.yVel = 0;
            pl.yPosition = this.yPosition;
            pl.xPosition = this.xPosition;
            pl.xVel = this.xVelocity;
        }

    }
    //Debug Methods
    public int getCount(){
        return this.count;
    }
}
