package ru.vsu.korotkov.firstAtta.task2;

import java.awt.*;
import java.util.Arrays;

public class Vertex {
    Point point;
    Color color;

    public Vertex(int x, int y, Color color) {
        point = new Point(x,y);
        this.color = color;
    }

    public Vertex(Point point, Color color) {
        this.point = point;
        this.color = color;
    }

    public Vertex(Point point) {
        this.point = point;
        color = Color.cyan;
    }
}
