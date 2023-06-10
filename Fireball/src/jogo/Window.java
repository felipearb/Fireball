package jogo;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.Toolkit;

public class Window {

    public static void main (String [] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Fireball");
        Panel panel = new Panel();
        window.add(panel);
        window.setUndecorated(true);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        panel.startGameThread();
        System.out.println(panel.larguraTela);
        System.out.println(panel.alturaTela);
    }
}
