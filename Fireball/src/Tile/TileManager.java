package Tile;

import jogo.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class TileManager {
    Panel g;
    Tile [] tile;
    public int mapTileNum [][];

    public TileManager(Panel g){
        this.g = g;
        tile = new Tile[9];
        getImage();
        int a, b;
        mapTileNum = new int [32][18];
        loadMap("/maps/mapa1.txt");
    }


    public void loadMap(String map){
        try{

            InputStream is = getClass().getResourceAsStream(map);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < 32 && row < 18){
                String line = br.readLine();
                while(col < 32){
                    String numbers [] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == 32){
                    col =0;
                    row++;
                }
            }
            br.close();

        } catch(Exception e){

        }
    }








    public void getImage() {
        try {

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/fundo.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/corner1.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/corner2.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/corner3.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/corner4.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lateral_superior_inferior.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lateral_vertical.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/parede_inferior.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/parede_inferior2.png"));
            tile[8].collision = true;

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        int tileNum;
        while (col < 32 && row < 18){
            tileNum = mapTileNum[col][row];
            g2.drawImage(tile[tileNum].image, x, y, g.tileSize, g.tileSize, null);
            col++;
            x += g.tileSize;

            if (col == g.maxCol) {
                col = 0;
                x = 0;
                row++;
                y += g.tileSize;
            }
        }
    }
}
