package ru.vsu.korotkov.firstAtta.task1;

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

    private Image space = new ImageIcon("src/main/resources/1618502434_11-funart_pro-p-oboi-fon-zvezdnoe-nebo-fon-11.jpg").getImage();
//    private JLabel myLabel = new JLabel(space);


    private System system;

    public DrawPanel(int PANEL_WIDTH, int PANEL_HEIGHT, int TIMER_DELAY) {
        this.PANEL_WIDTH = PANEL_WIDTH;
        this.PANEL_HEIGHT = PANEL_HEIGHT;
        this.TIMER_DELAY = TIMER_DELAY;



        timer = new Timer(TIMER_DELAY, this);
        timer.start();

        // Ellipse2D moon = new Ellipse2D.Double(100,100,50,50);
        //system = new Planet(moon, 200,50,Color.cyan);
        system = new SolarSystem(PANEL_WIDTH,PANEL_HEIGHT);
        system.create();
    }


    @Override
    public void paint(final Graphics g) {
        super.paint(g);


        g.drawImage(space,0,0,PANEL_WIDTH,PANEL_HEIGHT,null);

        setBackground(Color.black);

        system.update(ticksFromStart);
        system.draw(g);

    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            ++ticksFromStart;
        }
    }
}
