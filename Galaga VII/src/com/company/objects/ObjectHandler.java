package com.company.objects;
import java.awt.*;
import java.util.*;

public class ObjectHandler
{   // Attributes
    Object_Player ptemp;
    Object_Player.playerResult prtemp;
    Object_Enemy etemp;
    Object_Boss btemp;

    Random spawn;

    // Wave Tracker
    private int waveCount = 0;
    private boolean vic = false;

    public static LinkedList <Object_Player> playerList = new LinkedList<>();
    public static LinkedList <Object_Boss> bossList = new LinkedList<>();
    public static LinkedList <Object_Enemy> enemyList = new LinkedList<>();

    // Constructor
    public ObjectHandler()
    {   // Spawn Player
        addPlayer(new Object_Player(100, 300, 565));

        // Spawn Methods
        spawnEnemy(5);

    }

    // Methods (Getters && Setters)
    public Object_Player getPlayer(){
        ptemp = playerList.getFirst();
        return ptemp;
    }
    public Object_Boss getBoss(){
        btemp = bossList.getFirst();
        return btemp;
    }
    public Object_Enemy getEnemy(){
        etemp = enemyList.getFirst();
        return etemp;
    }

    public LinkedList<Object_Player> getPlayerList() {
        return playerList;
    }
    public LinkedList<Object_Boss> getBossList() {
        return bossList;
    }
    public LinkedList<Object_Enemy> getEnemyList() {
        return enemyList;
    }

    // Methods
    public void addPlayer(Object_Player p){
        playerList.add(p);
    }
    public void addEnemy(Object_Enemy e){
        enemyList.add(e);
    }
    public void addBoss(Object_Boss b){
        bossList.add(b);
    }

    public void removePlayer(Object_Player p){
        playerList.remove(p);
    }
    public void removeEnemy(Object_Enemy e){
        enemyList.remove(e);
    }
    public void removeBoss(Object_Boss b){
        bossList.remove(b);
    }

    public void drawPlayer(Graphics2D g2d){
        for(int i = 0; i < playerList.size(); i++){
            ptemp = playerList.get(i);
            ptemp.getLaser().draw(g2d);
            ptemp.draw(g2d);
        }
        // Result Mechanics
        complete();
        if(vic){
            prtemp = ptemp.getPResult();
            prtemp.setPRX(180);
            prtemp.setPRY(200);
            prtemp.drawResult(g2d);
        }
    }
    public void drawEnemy(Graphics2D g2d){
        for(int i = 0; i < enemyList.size(); i++){
            etemp = enemyList.get(i);
            etemp.getELaser().draw(g2d);
            etemp.draw(g2d);
        }
    }
    public void drawBoss(Graphics2D g2d){
        for(int i = 0; i < bossList.size(); i++){
            btemp = bossList.get(i);
            btemp.getBossLaser().draw(g2d);
            btemp.draw(g2d);
        }
    }

    public void updatePlayer(Object_Player p){
        for(int i = 0; i < playerList.size(); i++){
            p = playerList.get(i);
            p.update();
            p.getLaser().updateLaser();
        }
        if(p.getHealth() <= 0){
            removePlayer(p);
        }

        // Laser Collision Mechanics
        for(int k = 0; k < enemyList.size(); k++){
            if(p.getLaser().getBounds().intersects(enemyList.get(k).getBounds())){
                etemp = enemyList.get(k);
                etemp.setHealth(etemp.getHealth()-25);

                p.getLaser().setYVel(0);
                p.getLaser().setXPos(p.getxPosition());
                p.getLaser().setYPos(p.getyPosition());
                p.getLaser().setXVel(p.getxVelocity());

                p.setScore(p.getScore()+10);

            }

        }
        for(int j = 0; j < bossList.size(); j++){
            if(p.getLaser().getBounds().intersects(bossList.get(j).getBounds())){
                btemp = bossList.get(j);
                btemp.setHealth(btemp.getHealth()-25);

                p.getLaser().setYVel(0);
                p.getLaser().setXPos(p.getxPosition());
                p.getLaser().setYPos(p.getyPosition());
                p.getLaser().setXVel(p.getxVelocity());

                p.setScore(p.getScore() + 95);
            }
        }


    }
    public void updateEnemy(Object_Enemy e){
        for(int i = 0; i < enemyList.size(); i++){
            e = enemyList.get(i);
            e.update();
            e.getELaser().update();

            if(e.getHealth() <= 0){
                removeEnemy(e);
                ptemp.setScore(ptemp.getScore()+300);
            }
            if(enemyList.size() == 0){
                spawnControl();
            }

        }

        // Laser Collision Mechanics
        for(int k = 0; k < playerList.size(); k++){
            if(e.getELaser().getBounds().intersects(playerList.get(k).getBounds())){
                ptemp = playerList.get(k);
                ptemp.setHealth(ptemp.getHealth()-10);

                e.getELaser().setXPos(e.getxPosition());
                e.getELaser().setYPos(e.getyPosition());
                e.getELaser().setXVel(e.getxVelocity());
            }
        }
    }
    public void updateBoss(Object_Boss b){
        for(int i = 0; i < bossList.size(); i++){
            b = bossList.get(i);
            b.update();
            b.getBossLaser().update();
        }
        if(b.getHealth() <= 0){
            removeBoss(b);
            ptemp.setScore(ptemp.getScore()+1750);
        }

        // Laser Collision Mechanics
        for(int i = 0; i < playerList.size(); i++){
            if(b.getBossLaser().getBounds().intersects(playerList.get(i).getBounds())){
                ptemp = playerList.get(i);
                ptemp.setHealth(ptemp.getHealth()-50);

                b.getBossLaser().setXPos(b.getxPosition());
                b.getBossLaser().setYPos(b.getyPosition());
                b.getBossLaser().setXVel(b.getxVelocity());
            }
        }

    }

    // Spawn Methods
    public void spawnEnemy(int amount){
        spawn = new Random();
        for(int i = 0; i < amount; i++){
            addEnemy(new Object_Enemy(75, spawn.nextInt(700), spawn.nextInt(300)));
        }
    }
    public void spawnBoss(){
        spawn = new Random();
            addBoss(new Object_Boss(350, 300, 90));
    }
    public void spawnControl(){
        if(waveCount <= 3){
            if(enemyList.size() == 0){
                spawnEnemy(5);

                // Debug Code
                waveCount++;
                System.out.println("wave " + waveCount);
            }
        }
        if(waveCount == 4){
            spawnBoss();
        }

    }

    // Result Method
    public void complete(){
        if(!playerList.isEmpty() && ((waveCount >= 4 && bossList.isEmpty()) && (waveCount >= 4 && enemyList.isEmpty()))){
             vic = true;
        }
    }
}
