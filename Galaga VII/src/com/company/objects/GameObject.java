package com.company.objects;

import java.awt.*;

public abstract class GameObject
{   // Attributes
    private int health;
    private int xPosition;
    private int yPosition;
    private int xVelocity;
    private int yVelocity;

    // Constructor(s)
    public GameObject(int health, int x, int y){
        this.health = health;
        this.xPosition = x;
        this.yPosition = y;
    }

    // Abstract Methods (Getters && Setters)
    public abstract int getHealth();
    public abstract int getxPosition();
    public abstract int getyPosition();
    public abstract int getxVelocity();
    public abstract int getyVelocity();
    public abstract Image getImage();
    public abstract Rectangle getBounds();

    // Abstract Methods
    public abstract void shoot();
    public abstract void draw(Graphics2D g2d);
    public abstract void update();

}
