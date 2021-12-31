package com.company.objects;

import com.company.Game;

import java.awt.*;

public class ScoreBoard
{   // Attributes
    private int x;
    private int y;
    private int score;

    Object_Player ptemp;
    Object_Enemy etemp;
    Object_Boss btemp;

    // Constructor(s)
    public ScoreBoard(){}
    public ScoreBoard(int x, int y){
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
    public int getScore(){
        return score;
    }
    public int setX(int xpos){
        this.x = xpos;
        return x;
    }
    public int setY(int ypos){
        this.y = ypos;
        return y;
    }
    public int setScore(int total){
        this.score = total;
        return score;
    }

    // Methods
    public void draw(Graphics g2d, Object_Player p){
        // Draw ScoreBoard

        // Draw Score Title
        String scoreTitle = "Score";
        Font stfont = new Font("Roman", Font.ITALIC, 20);
        g2d.setColor(Color.orange);
        g2d.setFont(stfont);
        g2d.drawString(scoreTitle, Game.WIDTH - 200, 30);

        // Draw Score
        int stringx;
        String scoreText = Integer.toString(p.getScore());
        Font font = new Font("MV Boli", Font.BOLD, 25);

        //int stringWidth = g2d.getFontMetrics(font).stringWidth(scoreText)+1;
        int padding = 15; // distance between center line and each score

        stringx = (Game.WIDTH * 3/4) + padding;

        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        g2d.drawString(scoreText, stringx, 58);

        score = p.getScore();
    }
    public void drawBase(Graphics2D g2d){
        String scoreTitle = "Score";
        Font stfont = new Font("Roman", Font.ITALIC, 20);
        g2d.setColor(Color.orange);
        g2d.setFont(stfont);
        g2d.drawString(scoreTitle, Game.WIDTH - 200, 30);

        // Draw Score
        int stringx;
        String scoreText = Integer.toString(getFinalScore());
        Font font = new Font("MV Boli", Font.BOLD, 25);

        //int stringWidth = g2d.getFontMetrics(font).stringWidth(scoreText)+1;
        int padding = 15; // distance between center line and each score

        stringx = (Game.WIDTH * 3/4) + padding;

        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        g2d.drawString(scoreText, stringx, 58);
    }

    public int getFinalScore(){
        return score;
    }

    public void updateScore(Object_Player p){

    }

}
