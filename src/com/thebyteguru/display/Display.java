package com.thebyteguru.display;

import javax.swing.*;
import java.awt.*;

public abstract class Display {
    private static boolean created = false;
    private static JFrame window;
    private static Canvas content;
    private static Object color;

    public static void create(int width, int height, String title) {
        if (created)
            return;

        window = new  JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content = new Canvas(){
            public void paint(Graphics g){
                super.paint(g);
                render(g);
            }
        };

        Dimension size = new Dimension(width,height);
        content.setPreferredSize(size);
        content.setBackground(color.black);
        window.setResizable(false);
        window.getContentPane().add(content);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);


    }

    public static void render(Graphics g){
content.repaint();
    }
    /*private static void (Graphics g){

    }*/
}