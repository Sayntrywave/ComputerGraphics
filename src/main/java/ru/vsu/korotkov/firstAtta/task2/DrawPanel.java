package ru.vsu.korotkov.firstAtta.task2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        Triangle triangle = new Triangle(new Vertex(new int[]{10, 12}), new Vertex(new int[]{500, 12}), new Vertex(new int[]{10, 500}));
        DrawUtils.drawTriangle(g, triangle);
        DrawUtils.fillTriangle(g, triangle, new Color[]{Color.red,Color.green,Color.blue});

        Triangle triangle2 = new Triangle(new Vertex(new int[]{700, 100}), new Vertex(new int[]{550, 150}), new Vertex(new int[]{900, 350}));
        DrawUtils.drawTriangle(g, triangle2);
        DrawUtils.fillTriangle(g, triangle2, new Color[]{Color.green,Color.green,Color.blue});

    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            ++ticksFromStart;
        }
    }
}