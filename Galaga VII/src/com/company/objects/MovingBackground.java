package com.company.objects;

import javax.swing.*;
import java.awt.*;

public class MovingBackground
{   // Attributes
    private int x;
    private int y;
    private int yVel = 10;

    // Constructor
    public MovingBackground(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Methods (Getters && Setters)
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getyVel(){
        return yVel;
    }

    // Methods
    public void draw(Graphics2D g2d){
        // Draw Moving Background
        g2d.drawImage(getImage(), x, y, null);
    }
    public void update(){
        y += yVel;

        if(y > 50)
        {   y = -30;
        }
    }
    public Image getImage(){
        Image pimg = new ImageIcon("src/com/company/images/space_edited (1) copy.png").getImage();
        return pimg;
    }
}
