package entidade;

import jogo.*;
import jogo.Panel;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Player extends Entity{
    Panel g;
    Input keyH;
    int number;

    public Player(Panel g, Input a, int number){
        this.g = g;
        this.number = number;
        this.keyH = a;
        setDefaultValues();
        getPlayerImage();
        solidArea = new Rectangle(0, 0, 60, 60);
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 8;
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
                direction = "up";
            }
            if (keyH.sPressed == true) {
                y += speed;
                direction = "down";
            }
            if (keyH.dPressed == true) {
                x += speed;
                direction = "right";
            }
            if (keyH.aPressed == true) {
                x -= speed;
                direction = "left";
            }
        }
        //-------------------------------------------------------------------------------------

        if(number == 2 && (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed)) {
            moving = true;
            if (keyH.upPressed == true) {
                y -= speed;
                direction = "up";
            }
            if (keyH.downPressed == true) {
                y += speed;
                direction = "down";
            }
            if (keyH.rightPressed == true) {
                x += speed;
                direction = "right";
            }
            if (keyH.leftPressed == true) {
                x -= speed;
                direction = "left";
            }
        }

        spriteNum = 0;
        if(moving) {
            collisionOn = false;
            g.cCheck.checkTile(this);

            spriteCouter++;
            if (spriteCouter > 1) {
                spriteNum++;
                spriteCouter = 0;
            }
            if (spriteNum > 12) {
                spriteNum = 0;
            }
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

