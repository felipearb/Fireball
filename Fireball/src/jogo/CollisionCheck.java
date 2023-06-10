package jogo;

import entidade.Entity;

public class CollisionCheck {

    Panel g;

    public CollisionCheck(Panel g){
        this.g = g;
    }

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

        switch(entity.direction){
            case "up":
                break;
            case "down":
                break;
            case "left":
                break;
            case "right":
                break;
        }

    }
}
