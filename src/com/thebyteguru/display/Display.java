package com.thebyteguru.display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public abstract class Display {
    private static boolean created = false;
    private static JFrame window;
    private static Canvas content;
    private static Object color;

    private static BufferedImage buffer;
    private static int[] bufferData;
    private static Graphics bufferGraphics;
    private static int clearColor;

private static BufferStrategy bufferStrategy;

    // temp
    private static float delta = 0;

    // temp end

    public static void create(int width, int height, String title, int _clearColor,int numBuffers) {
        if (created)
            return;

        window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content = new Canvas();

        Dimension size = new Dimension(width, height);
        content.setPreferredSize(size);


        window.setResizable(false);
        window.getContentPane().add(content);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        bufferData = ((DataBufferInt) buffer.getRaster().getDataBuffer()).getData();
        bufferGraphics = buffer.getGraphics();
        clearColor = _clearColor;

        content.createBufferStrategy(numBuffers);
bufferStrategy = content.getBufferStrategy();

        created = true;

    }
public  static void clear(){
    Arrays.fill(bufferData,clearColor);
    }
public static  void render(){
bufferGraphics.setColor(new Color(0x0000ff));
bufferGraphics.fillOval((int) (350 + (Math.sin(delta) * 200)), 250,100, 100);
delta += 0.02f;
}
public static void swapBuffers(){
        Graphics g = bufferStrategy.getDrawGraphics();
        g.drawImage(buffer,0,0, null);
}


}
