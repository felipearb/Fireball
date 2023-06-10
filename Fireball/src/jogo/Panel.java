package jogo;
import Tile.TileManager;
import entidade.Player;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {
    //caracteristicas da tela
    final int originalTileSize = 16; // 16x16 - tamanho padrao para personagens
    final int scale = 3; //redimensionar para que fique maior na tela
    public final int tileSize = 60; // 48x48px
    int fps = 60;
    boolean status=true;

    TileManager tile = new TileManager(this);
    Input keyH = new Input();
    Player player1 = new Player(this, keyH, 1);

    Player player2 = new Player(this, keyH, 2);

    public CollisionCheck cCheck = new CollisionCheck(this);

    Dimension screenSize = new Dimension(1920, 1080);

    public final int larguraTela = screenSize.width;

    public final int alturaTela = screenSize.height;

     public final int maxCol = 32;

    public final int maxLin = 18;

    //definindo a posicao do jogador1

    Thread gameThread;
    public Panel(){
        this.setPreferredSize(screenSize);
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        player2.setX(300);
        this.addKeyListener(keyH);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
    //o looping do jogo
        int intervalo = 1000000000/fps;
        double drawTime = System.nanoTime() + intervalo;
        while(status==true && gameThread != null){

            update();
            repaint();

            try {
                double remainingTime = drawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if(remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);
                drawTime += intervalo;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.exit(0);
    }
    public void update(){

        status=player1.update();
        status=player2.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tile.draw(g2);
        player1.draw(g2);
        player2.draw(g2);
        g2.dispose();
    }
}
