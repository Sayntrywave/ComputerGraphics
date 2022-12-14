package ru.vsu.korotkov.firstAtta.task2;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class DrawPanel extends JPanel implements ActionListener {
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final int TIMER_DELAY;
    private Timer timer;
    private int ticksFromStart = 0;


    public DrawPanel(int PANEL_WIDTH, int PANEL_HEIGHT, int TIMER_DELAY) {
        this.PANEL_WIDTH = PANEL_WIDTH;
        this.PANEL_HEIGHT = PANEL_HEIGHT;
        this.TIMER_DELAY = TIMER_DELAY;


        timer = new Timer(TIMER_DELAY, this);
        timer.start();


    }


    @Override
    public void paint(final Graphics g) {
        super.paint(g);
/*
        Triangle triangle = new Triangle(new Vertex(new Point(10, 12)), new Vertex(new Point(500, 12)), new Vertex(new Point(10, 500)));
        DrawUtils.drawTriangle(g, triangle);
        DrawUtils.fillTriangle(g, triangle, new ArrayList<Color>(Arrays.asList(Color.red,Color.green,Color.blue)));
        DrawUtils.fillTriangle(g, triangle, new ArrayList<Color>(Arrays.asList(Color.red,Color.green,Color.blue)));

        Triangle triangle2 = new Triangle(new Vertex(new Point(700, 100)), new Vertex(new Point(550, 150)), new Vertex(new Point(900, 350)));
        DrawUtils.drawTriangle(g, triangle2);
        DrawUtils.fillTriangle(g, triangle2, new ArrayList<Color>(Arrays.asList(Color.green,Color.green,Color.blue)));

        Triangle triangle3 = new Triangle(new Vertex(new Point(700, 800)), new Vertex(new Point(550, 400)), new Vertex(new Point(900, 350)));
        DrawUtils.drawTriangle(g, triangle3);
        DrawUtils.fillTriangle(g, triangle3, new ArrayList<Color>(Arrays.asList(Color.MAGENTA,Color.ORANGE,Color.blue)));


*/
        /*DrawUtils.fillTriangle(g,

                1,1,200,300,100,500,Color.cyan,Color.RED,Color.GREEN);
*/


//        DrawUtils.fillTriangle(g,(grafics,x,y) -> grafics.drawLine(x,y,x,y), new Point(1,1),new Point(200,300), new Point(100,500),Color.red, Color.green, Color.blue);
        DrawUtils.fillTriangle(g, new Point(1,1),new Point(200,300), new Point(100,500),Color.red, Color.green, Color.blue);

    }


    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            ++ticksFromStart;
        }
    }
}