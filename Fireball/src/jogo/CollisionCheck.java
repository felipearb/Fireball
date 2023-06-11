package jogo;

import entidade.Entity;

import java.awt.*;
import java.util.ArrayList;

public class CollisionCheck {

    Panel g;
    public static Rectangle elements[];
    private static ArrayList <Integer>mapLimits =new ArrayList<Integer>();
    private static Rectangle player;

    public void setMap(int top,int down,int right,int left){
        mapLimits.add(top);
        mapLimits.add(down);
        mapLimits.add(right);
        mapLimits.add(left);
    }
    public boolean collisionPlayer(){
        for(Rectangle element:elements){
            continue;
        }
        return false;
    }

    public String collisionMapY(int y) {
        if(y<=mapLimits.get(0))return "top";
        if(y>=mapLimits.get(1))return "botton";
        return "No Colission";
    }

    public String collisionMapX(int x) {
        if(x>=mapLimits.get(2))return "right";
        if(x<=mapLimits.get(3))return "left";
        return "No Colission";
    }



    public int collisionMapCorrection(String A){
        if(A=="top")return mapLimits.get(0);
        if(A=="botton")return mapLimits.get(1);
        if(A=="right")return mapLimits.get(2);
        if(A=="left")return mapLimits.get(3);
        return 0;
    }
/*/
    public CollisionCheck(Panel g){
        this.g = g;
    }*/

    public void checkTile(Entity entity){

        int entityLeftWorldX = entity.x + entity.solidArea.x;
        int entityRightWorldX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.y + entity.solidArea.y;
        int entityBottomWorldY = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/g.tileSize;
        int entityRightCol = entityRightWorldX/g.tileSize;
        int entityTopRow = entityTopWorldY/g.tileSize;
        int entityBottomRow = entityBottomWorldY/g.tileSize;

        int tileNum1, tilenum2;
/*
        switch(entity.direction){
            case "up":
                break;
            case "down":
                break;
            case "left":
                break;
            case "right":
                break;
        }*/

    }


}
