package com.company.objects;

import com.company.Game;

import javax.swing.*;
import java.awt.*;

public class Object_Boss extends GameObject
{   // Boss Laser Class
    public class bossLaser{
        // Attributes
        protected int xPosition;
        protected int yPosition;
        protected int damage = 50;
        protected int yVel = 0;
        protected int xVel = 2;

        // Constructor(s)
        public bossLaser(){}
        public bossLaser(int x, int y){
            this.xPosition = x;
            this.yPosition = y;
        }

        // Methods
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
            Image limg = new ImageIcon("src/com/company/images/Alien Boss Shot(192x192) copy.png").getImage();
            return limg;
        }
        public Rectangle getBounds(){
            return new Rectangle(xPosition + 73, yPosition + 115, 20, 20);
        }

        public void update(){
            this.xPosition += xVel;
            this.yPosition += yVel;

            // Collision Mechanics
            if(this.xPosition > 540){
                xVel = -2;
            } else if(xPosition < -60){
                xVel = 2;
            }


        }
        public void draw(Graphics2D g2d){
            g2d.drawImage(getImage(), xPosition, yPosition, null);
        }
    }

    // Attributes
    private int health;
    private int xPosition;
    private int yPosition;
    private int xVelocity = 2;
    private int yVelocity;

    // Laser Attributes
    private bossLaser bl = new bossLaser();

    // Constructor
    public Object_Boss(int health, int x, int y){
        super(health, x, y);
        this.health = health;
        this.xPosition = x;
        this.yPosition = y;
    }

    // Methods (Getters && Setters)
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
    @Override
    public Image getImage() {
        Image pimg = new ImageIcon("src/com/company/images/Alien Boss(192x192) copy.png").getImage();
        return pimg;
    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle(xPosition + 68, yPosition + 50, 50, 50);
    }
    public bossLaser getBossLaser(){
        return bl;
    }

    public int setHealth(int value){
        this.health = value;
        return health;
    }

    // Methods
    @Override
    public void shoot(){

    }
    @Override
    public void draw(Graphics2D g2d){
        g2d.drawImage(getImage(), xPosition, yPosition, null);
    }
    @Override
    public void update(){
        xPosition += xVelocity;

        // Collision Mechanics
        if(xPosition > 540){
            xVelocity = -2;
        } else if(xPosition < -60){
            xVelocity = 2;
        }

        // Laser Mechanics
        if(bl.getYPos() > this.getyPosition()){
            bl.setXVel(0);
        }
        if(bl.getYPos() > Game.HEIGHT){
            bl.setYPos(this.getyPosition());
            bl.setXPos(this.getxPosition());
            bl.setXVel(this.xVelocity);
        }
        bl.setYVel(3);

    }
}
