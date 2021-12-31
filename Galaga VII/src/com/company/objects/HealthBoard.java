package com.company.objects;

import com.company.Game;

import java.awt.*;

public class HealthBoard
{   // Attributes
    private int x;
    private int y;
    private int basehealth = 0;
    //Object_Player ptemp;


    // Constructor(s)
    public HealthBoard(){}
    public HealthBoard(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Method(s)
    public void draw(Graphics2D g2d, Object_Player p){
        String healthTitle = "Health";
        Font hfont = new Font("Roman", Font.ITALIC, 20);
        g2d.setColor(Color.orange);
        g2d.setFont(hfont);
        g2d.drawString(healthTitle, Game.WIDTH - 200, 110);


        // Draw Health Bar (Container)
        g2d.setColor(Color.white);
        g2d.drawRect(660, 117, 180, 30);
        g2d.setColor(new Color(95, 30, 0));
        g2d.fillRect(660, 117, 180, 30);

        // Draw Health Bar (Actual Bar)
        g2d.setColor(new Color(240, 196, 1));
        g2d.drawRect(661, 118, 178, 25);
        g2d.fillRect(661, 118, 178, 25);

        // Debug Line
        if(p.getHealth() <= 50){
            g2d.setColor(Color.orange);
        }

        // Draw Health
        int stringh;
        String healthText = Integer.toString(p.getHealth());
        Font nfont = new Font("MV Boli", Font.BOLD, 25);

        int padding2 = 15;

        stringh = (Game.WIDTH * 3/4) + padding2;

        g2d.setFont(nfont);
        g2d.setColor(Color.WHITE);
        g2d.drawString(healthText, stringh, 140);
    }
    public void drawHalf(Graphics g2d, Object_Player p){
        String healthTitle = "Health";
        Font hfont = new Font("Roman", Font.ITALIC, 20);
        g2d.setColor(Color.orange);
        g2d.setFont(hfont);
        g2d.drawString(healthTitle, Game.WIDTH - 200, 110);


        // Draw Health Bar (Container)
        g2d.setColor(Color.white);
        g2d.drawRect(660, 117, 180, 30);
        g2d.setColor(new Color(95, 30, 0));
        g2d.fillRect(660, 117, 180, 30);

        // Draw Health Bar (Actual Bar)
        g2d.setColor(new Color(235, 160, 13));
        g2d.drawRect(661, 118, 178, 25);
        g2d.fillRect(661, 118, 178, 25);

        // Debug Line
        if(p.getHealth() <= 50){
            g2d.setColor(Color.orange);
        }

        // Draw Health
        int stringh;
        String healthText = Integer.toString(p.getHealth());
        Font nfont = new Font("MV Boli", Font.BOLD, 25);

        int padding2 = 15;

        stringh = (Game.WIDTH * 3/4) + padding2;

        g2d.setFont(nfont);
        g2d.setColor(Color.WHITE);
        g2d.drawString(healthText, stringh, 140);
    }
    public void drawQuarter(Graphics g2d, Object_Player p){
        String healthTitle = "Health";
        Font hfont = new Font("Roman", Font.ITALIC, 20);
        g2d.setColor(Color.orange);
        g2d.setFont(hfont);
        g2d.drawString(healthTitle, Game.WIDTH - 200, 110);


        // Draw Health Bar (Container)
        g2d.setColor(Color.white);
        g2d.drawRect(660, 117, 180, 30);
        g2d.setColor(new Color(95, 30, 0));
        g2d.fillRect(660, 117, 180, 30);

        // Draw Health Bar (Actual Bar)
        g2d.setColor(new Color(237, 93, 7));
        g2d.drawRect(661, 118, 178, 25);
        g2d.fillRect(661, 118, 178, 25);

        // Debug Line
        if(p.getHealth() <= 50){
            g2d.setColor(Color.orange);
        }

        // Draw Health
        int stringh;
        String healthText = Integer.toString(p.getHealth());
        Font nfont = new Font("MV Boli", Font.BOLD, 25);

        int padding2 = 15;

        stringh = (Game.WIDTH * 3/4) + padding2;

        g2d.setFont(nfont);
        g2d.setColor(Color.WHITE);
        g2d.drawString(healthText, stringh, 140);
    }

    public void drawBase(Graphics2D g2d){
        String healthTitle = "Health";
        Font hfont = new Font("Roman", Font.ITALIC, 20);
        g2d.setColor(Color.orange);
        g2d.setFont(hfont);
        g2d.drawString(healthTitle, Game.WIDTH - 200, 110);


        // Draw Health Bar (Container)
        g2d.setColor(Color.white);
        g2d.drawRect(660, 117, 180, 30);
        g2d.setColor(new Color(95, 30, 0));
        g2d.fillRect(660, 117, 180, 30);

        // Draw Health Bar (Actual Bar)
        g2d.setColor(new Color(184, 11, 10));
        g2d.drawRect(661, 118, 178, 25);
        g2d.fillRect(661, 118, 178, 25);

        // Draw Health
        int stringh;
        String healthText = Integer.toString(basehealth);
        Font nfont = new Font("MV Boli", Font.BOLD, 25);

        int padding2 = 15;

        stringh = (Game.WIDTH * 3/4) + padding2;

        g2d.setFont(nfont);
        g2d.setColor(Color.WHITE);
        g2d.drawString(healthText, stringh, 140);
    }
}
