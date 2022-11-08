package ru.vsu.korotkov.firstAtta.task2;

import java.awt.*;

public class Triangle{
    private Vertex firstVertex;
    private Vertex secondVertex;
    private Vertex thirdVertex;

    public Triangle(Vertex firstVertexVertex, Vertex secondVertexVertex, Vertex thirdVertexVertex) {
        this.firstVertex = firstVertexVertex;
        this.secondVertex = secondVertexVertex;
        this.thirdVertex = thirdVertexVertex;
    }

    public Point getFirstVertexPoint() {
        return firstVertex.point;
    }


    public Point getSecondVertexPoint() {
        return secondVertex.point;
    }


    public Point getThirdVertexPoint() {
        return thirdVertex.point;
    }


    public boolean checkIntoTriangle(Point point){
        Point point1 = getFirstVertexPoint();
        Point point2 = getSecondVertexPoint();
        Point point3 = getThirdVertexPoint();

        int a = (point1.y - point2.y)*point.x + (point2.x - point1.x)*point.y + (point1.x*point2.y - point2.x*point1.y);
        int b = (point2.y - point3.y)*point.x + (point3.x - point2.x)*point.y + (point2.x*point3.y - point3.x*point2.y);
        int c = (point3.y - point1.y)*point.x + (point1.x - point3.x)*point.y + (point3.x*point1.y - point1.x*point3.y);

        return (a >= 0 && b >= 0 && c >=0) || (a <= 0 && b <= 0 && c <= 0);
    }

}
