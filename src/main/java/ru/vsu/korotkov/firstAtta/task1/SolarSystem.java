package ru.vsu.korotkov.firstAtta.task1;

import ru.vsu.korotkov.firstAtta.task1.Planets.Planet;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class SolarSystem extends System {

    public SolarSystem(int size, int PANEL_WIDTH, int PANEL_HEIGHT) {
        super(size, PANEL_WIDTH, PANEL_HEIGHT);
    }

    public SolarSystem(int centerX, int centerY) {
        super(centerX, centerY);
    }

    @Override
    public void create() {
        setSize(8);
        planets = new Planet[size];

        double weightOfEarth = 30;
        double heightOfEarth = 30;
        double semiMajorOfEarth = 150;
        //double semiMinorOfEarth = 150;


        Ellipse2D mercury = new Ellipse2D.Double(100, 100, weightOfEarth / 7, heightOfEarth / 5);
        Ellipse2D venus = new Ellipse2D.Double(100, 100, weightOfEarth / 4, heightOfEarth / 4);
        Ellipse2D earth = new Ellipse2D.Double(100, 100, weightOfEarth, heightOfEarth);
        Ellipse2D mars = new Ellipse2D.Double(100, 100, weightOfEarth / 6, heightOfEarth / 6);
        Ellipse2D jupiter = new Ellipse2D.Double(100, 100, 2.2 * weightOfEarth, 2.2 * heightOfEarth);
        Ellipse2D saturn = new Ellipse2D.Double(100, 100, 2 * weightOfEarth, 2 * heightOfEarth);
        Ellipse2D uranus = new Ellipse2D.Double(100, 100, 1.5 * weightOfEarth, 1.5 * heightOfEarth);
        Ellipse2D neptune = new Ellipse2D.Double(100, 100, 1.2 * weightOfEarth, 1.2 * heightOfEarth);
        Ellipse2D moon = new Ellipse2D.Double(100, 100, 0.4 * weightOfEarth, 0.4 * heightOfEarth);



        /*


        Ellipse2D  = new Ellipse2D.Double(100,100,,);
        Ellipse2D  = new Ellipse2D.Double(100,100,,);
        Ellipse2D  = new Ellipse2D.Double(100,100,,);
        Ellipse2D  = new Ellipse2D.Double(100,100,,);
        Ellipse2D  = new Ellipse2D.Double(100,100,,);
        Ellipse2D  = new Ellipse2D.Double(100,100,,);*/


        planets[0] = new Planet(mercury, new Color(193, 174, 156), (0.39 * semiMajorOfEarth), 0.206, getCenterX(), getCenterY());
        planets[1] = new Planet(venus, new Color(229, 167, 92), (0.72 * semiMajorOfEarth), 0.006, getCenterX(), getCenterY());
        planets[2] = new Planet(earth, new Color(14, 44, 103), (semiMajorOfEarth), 0.017, getCenterX(), getCenterY());
        planets[3] = new Planet(mars, new Color(115, 44, 44), (1.52 * semiMajorOfEarth), 0.093, getCenterX(), getCenterY());
        planets[4] = new Planet(jupiter, new Color(253, 164, 109), (1.8 * semiMajorOfEarth), 0.048, getCenterX(), getCenterY());

        planets[5] = new Planet(saturn, new Color(210, 198, 76), (2.3 * semiMajorOfEarth), 0.055, getCenterX(), getCenterY());
        planets[6] = new Planet(uranus, new Color(106, 186, 209), (2.8 * semiMajorOfEarth), 0.046, getCenterX(), getCenterY());
        planets[7] = new Planet(neptune, new Color(133, 161, 231), (3.11 * semiMajorOfEarth), 0.009, getCenterX(), getCenterY());

        planets[2].addMoon(moon, Color.gray, 5);
        planets[3].addMoon(moon, Color.blue, 10);


        Ellipse2D moonOfSaturn = new Ellipse2D.Double(100, 100, 0.2 * weightOfEarth, 0.2 * heightOfEarth);
        planets[5].addMoon(moonOfSaturn, Color.gray, 5);
        planets[5].addMoon(moonOfSaturn, Color.gray, 2);
        planets[5].addMoon(moonOfSaturn, Color.gray, 10);


        planets[2].getMoons().get(0).addMoon(moon, Color.white, 10);

    }
}
