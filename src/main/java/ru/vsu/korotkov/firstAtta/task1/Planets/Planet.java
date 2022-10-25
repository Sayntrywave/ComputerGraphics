package ru.vsu.korotkov.firstAtta.task1.Planets;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;
import java.util.List;

public class Planet {

    public final Color color;
    public final int a;
    public final int b;
    private Ellipse2D shape;
    private List<Planet> moons = new LinkedList<>();
    private int x;
    private int y;
    private int upperLowerEllipsePartCoeff = 1;

    private int centerX = 0;
    private int centerY = 0;


    public Planet(Ellipse2D shape, Color color, double a, double e) {
        this.shape = shape;
        this.a = (int) a;
        this.b = (int) (a * Math.sqrt(1 - e));
        this.color = color;
    }


    public Planet(Ellipse2D shape, Color color, double a, double e, int centerX, int centerY) {
        this.shape = shape;
        this.color = color;
        this.a = (int) a;
        this.b = (int) (a * Math.sqrt(1 - e));
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public void addMoon(Ellipse2D shape, Color color, double dr) {

        moons.add(new Planet(shape, color, this.shape.getWidth() / 2 + dr + shape.getWidth() / 2,
                1 - Math.pow(this.shape.getWidth() / 2, 2) / Math.pow(this.shape.getHeight() / 2, 2),
                centerX - this.a, centerY - this.b));
    }

    public boolean hasMoon() {
        return !moons.isEmpty();
    }

    public List<Planet> getMoons() {
        return moons;
    }


    public void update(int ticks) {
        this.x = ((ticks / (2 * a)) % 2 == 0) ? ticks % (2 * a) : 2 * a - ticks % (2 * a);
        int y = (int) Math.round(b * Math.sqrt(1 - Math.pow(x - a, 2) / (a * a)));

        if (y == 0)
            upperLowerEllipsePartCoeff *= -1;
        this.y = y * upperLowerEllipsePartCoeff;
    }

    public void draw(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        if (this.hasMoon()) {
            for (Planet moon : moons) {
                moon.centerX = (x + (centerX - a));
                moon.centerY = (y + (centerY));
                moon.draw(gr);

            }
        }
        g.setColor(Color.gray);

        g.drawOval(centerX - a, centerY - b, 2 * a, 2 * b);


        g.setColor(color);

        shape = new Ellipse2D.Double(
                x + (centerX - a) - shape.getWidth() / 2,
                y + (centerY) - shape.getHeight() / 2,
                shape.getWidth(), shape.getHeight());

        // color.brighter();

        //   g.fillArc(100,100,50,50,0,180);
        g.fill(shape);

    }

}
/*

        if(!moons.isEmpty()){
            for (Planet moon : moons) {
//                int x1 =  (int) (x + (centerX - a) - shape.getWidth()/2);
//                int y1 =  (int) (y + (centerY) - shape.getHeight()/2);
                g.drawOval((int) (shape.getX() - moon.shape.getWidth()/2 -3) ,
                        (int)(shape.getY() - moon.shape.getHeight()/2 -3),
                        (int) (shape.getWidth() + moon.shape.getWidth() + 6),
                        (int) (shape.getHeight() + moon.shape.getHeight() + 6));
                g.setColor(Color.BLACK);

                moon.draw(gr);

            }

        }


    public void setX(int ticks) {
        this.x = ((ticks/a)% 2 == 0) ? ticks % a : a - ticks % a ;
    }

    public void getY(int x) {
        double temp = 2*(1 - Math.pow(x,2)/10) ;
        Math.round(Math.sqrt(temp));
    }*/