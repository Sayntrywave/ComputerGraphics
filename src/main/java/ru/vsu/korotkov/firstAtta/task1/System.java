package ru.vsu.korotkov.firstAtta.task1;

import ru.vsu.korotkov.firstAtta.task1.Planets.Planet;

import java.awt.*;

public abstract class System {
    protected int size;
    protected Planet[] planets;
    private int centerX;
    private int centerY;

    public System(int size, int PANEL_WIDTH, int PANEL_HEIGHT) {
        this.size = size;
        centerX = PANEL_WIDTH/2;
        centerY = PANEL_HEIGHT/2;
    }

    public System(int PANEL_WIDTH, int PANEL_HEIGHT) {
        this.centerX = PANEL_WIDTH/2;
        this.centerY = PANEL_HEIGHT/2;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    protected void setSize(int size) {
        this.size = size;
    }

    public abstract void create();

    public void draw(final Graphics g){

        g.setColor(new Color(255,162,36));
        g.fillOval(centerX - 40,centerY - 40,80,80);
        for (int i = 0; i < size; i++) {
            planets[i].draw(g);
        }
    }

    public void update(int ticks){
        for (int i = 0; i < size; i++) {
            planets[i].update(ticks);
            if (planets[i].hasMoon()){
                update(planets[i],ticks);
            }
        }
    }
    private void update(Planet planet, int ticks){
        Planet moon;
        for (int j = 0; j < planet.getMoons().size(); j++) {
            moon = planet.getMoons().get(j);
            moon.update(ticks);
            if(moon.hasMoon()){
                update(moon,ticks);
            }
        }
    }
}
