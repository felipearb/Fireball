package entidade;

import jogo.*;
import jogo.Panel;
import jogo.CollisionCheck;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Player extends Entity{
    Panel g;
    Input keyH;
    int number;
    CollisionCheck A =new CollisionCheck();

    public Player(Panel g, Input a, int number){
        this.g = g;
        this.number = number;
        this.keyH = a;
        setValues(100,100,8);
        getPlayerImage();
        solidArea = new Rectangle(0, 0, 60, 60);

    }
    public Player(Panel g, Input a, int number,int x,int y){
        this.g = g;
        this.number = number;
        this.keyH = a;
        setValues(x,y,8);
        getPlayerImage();
        solidArea = new Rectangle(0, 0, 60, 60);
    }

    public Player(Panel g, Input a, int number,int x,int y,int speed){
        this.g = g;
        this.number = number;
        this.keyH = a;
        setValues(x,y,speed);
        getPlayerImage();
        solidArea = new Rectangle(0, 0, 60, 60);
    }


    public void setValues(int x,int y,int speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void getPlayerImage(){

        try {
            sprite[0] = ImageIO.read(getClass().getResourceAsStream("/Jogador/sprite_astronauta.png"));
            sprite[1] = ImageIO.read(getClass().getResourceAsStream("/Jogador/sprite_astronauta2.png"));
            sprite[2] = ImageIO.read(getClass().getResourceAsStream("/Jogador/sprite_astronauta3.png"));
            sprite[3] = ImageIO.read(getClass().getResourceAsStream("/Jogador/sprite_astronauta4.png"));
            sprite[4] = ImageIO.read(getClass().getResourceAsStream("/Jogador/sprite_astronauta5.png"));
            sprite[5] = ImageIO.read(getClass().getResourceAsStream("/Jogador/sprite_astronauta6.png"));
            sprite[6] = ImageIO.read(getClass().getResourceAsStream("/Jogador/sprite_astronauta7.png"));
            sprite[7] = ImageIO.read(getClass().getResourceAsStream("/Jogador/sprite_astronauta6.png"));
            sprite[8] = ImageIO.read(getClass().getResourceAsStream("/Jogador/sprite_astronauta5.png"));
            sprite[9] = ImageIO.read(getClass().getResourceAsStream("/Jogador/sprite_astronauta4.png"));
            sprite[10] = ImageIO.read(getClass().getResourceAsStream("/Jogador/sprite_astronauta3.png"));
            sprite[11] = ImageIO.read(getClass().getResourceAsStream("/Jogador/sprite_astronauta2.png"));
            sprite[12] = ImageIO.read(getClass().getResourceAsStream("/Jogador/sprite_astronauta.png"));
            sprite[13] = ImageIO.read(getClass().getResourceAsStream("/Jogador/sprite_astronauta_parado.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean update(){
        if(keyH.escPressed==true)return false;
        spriteCouter++;
        if(spriteCouter > 60) {
            if (spriteNum == 0) {
                spriteNum = 13;
            }
            else if (spriteNum == 13) {
                spriteNum = 0;
            }
            spriteCouter = 0;
        }
        // ----------------------------------------------------------------------------------------------
        if(number == 1 && (keyH.wPressed || keyH.sPressed || keyH.aPressed || keyH.dPressed)) {
            moving = true;
            if (keyH.wPressed == true) {
                y -= speed;
                speedY = -speed;
            }
            if (keyH.sPressed == true) {
                y += speed;
                speedY = speed;
            }
            if (keyH.dPressed == true) {
                x += speed;
                speedX = speed;
            }
            if (keyH.aPressed == true) {
                x -= speed;
                speedX = -speed;
            }
        }
        //-------------------------------------------------------------------------------------

        if(number == 2 && (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed)) {
            moving = true;
            if (keyH.upPressed == true) {
                y -= speed;
                speedY = -speed;
            }
            if (keyH.downPressed == true) {
                y += speed;
                speedY = speed;
            }
            if (keyH.rightPressed == true) {
                x += speed;
                speedX = speed;
            }
            if (keyH.leftPressed == true) {
                x -= speed;
                speedX = -speed;
            }
        }

        spriteNum = 0;
        if(moving) {
            collisionOn = false;
            //g.cCheck.checkTile(this);

            spriteCouter++;
            if (spriteCouter > 1) {
                spriteNum++;
                spriteCouter = 0;
            }
            if (spriteNum > 12) {
                spriteNum = 0;
            }
        }
        String Colission;
        Colission=A.collisionMapX(this.x);
        if(Colission!="No Colission"){
            if(Colission=="right")x=A.collisionMapCorrection(Colission);
            if(Colission=="left")x=A.collisionMapCorrection(Colission);
        }

        Colission=A.collisionMapY(this.y);
        if(Colission!="No Colission"){
            if(Colission=="top")y=A.collisionMapCorrection(Colission);
            if(Colission=="botton")y=A.collisionMapCorrection(Colission);
        }

        return true;
    }
    public void draw(Graphics2D g2){
        //g2.setColor(Color.green);
        //g2.fillRect(x, y, g.tileSize, g.tileSize);
        g2.drawImage(sprite[spriteNum], x, y, 60, 60, null);

    }
    public void setX (int x){
        this.x = x;
    }

}

