package entidade;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int x,y;
    public int speed;

    public Rectangle solidArea;

    public boolean collisionOn = false;

    public BufferedImage mov1, mov2, mov3, mov4, mov5, mov6, mov7;

    public BufferedImage [] sprite = new BufferedImage[15];

    public int spriteNum = 0;

    public int spriteCouter = 0;

    public String direction;

    boolean moving;
}
