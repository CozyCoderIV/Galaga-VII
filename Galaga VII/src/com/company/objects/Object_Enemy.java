package com.company.objects;

import com.company.Game;

import javax.swing.*;
import java.awt.*;

public class Object_Enemy extends GameObject
{   // Enemy Laser Class
    public class enemyLaser{
        // Attributes
        protected int xPosition;
        protected int yPosition;
        protected int damage = 50;
        protected int yVel = 0;
        protected int xVel = 3;

        // Constructctor(s)
        public enemyLaser(){}
        public enemyLaser(int x, int y){
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
            Image limg = new ImageIcon("src/com/company/images/purplebeam copy.png").getImage();
            return limg;
        }
        public Rectangle getBounds(){
            return new Rectangle(xPosition + 23, yPosition + 18, 15, 15);
        }

        public void update(){
            this.xPosition += xVel;
            this.yPosition += yVel;

            // Collision Mechanics
            if(this.xPosition > 540){
                xVel = -3;
            } else if(xPosition < -60){
                xVel = 3;
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
    private int xVelocity = 3;
    private int yVelocity;

    private enemyLaser el = new enemyLaser();

    // Constructor
    public Object_Enemy(int health, int x, int y)
    {   super(health, x, y);
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
        Image pimg = new ImageIcon("src/com/company/images/aliev copy.png").getImage();
        return pimg;
    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle(xPosition + 68, yPosition + 50, 50, 50); // creates rectangle around enemy;
    }

    public int setHealth(int value){
        this.health = value;
        return health;
    }
    public enemyLaser getELaser(){
        return el;
    }

    // Methods
    @Override
    public void shoot() {

    }
    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getImage(), xPosition, yPosition, null);
    }
    @Override
    public void update() {
        xPosition += xVelocity;
        if(xPosition > 540){
            xVelocity = -3;
        }else if(xPosition < -60){
            xVelocity = 3;
        }

        // Laser Mechanics
        if(el.getYPos() > this.getyPosition()){
            el.setXVel(0);
        }
        if(el.getYPos() > Game.HEIGHT){
            el.setYPos(this.getyPosition());
            el.setXPos(this.getxPosition());
            el.setXVel(this.xVelocity);
        }
        el.setYVel(4);
    }
}
