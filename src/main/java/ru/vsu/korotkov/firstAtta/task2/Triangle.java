package ru.vsu.korotkov.firstAtta.task2;

public class Triangle{
    private Vertex firstVertexVertex;
    private Vertex secondVertexVertex;
    private Vertex thirdVertexVertex;

    public Triangle(Vertex firstVertexVertex, Vertex secondVertexVertex, Vertex thirdVertexVertex) {
        this.firstVertexVertex = firstVertexVertex;
        this.secondVertexVertex = secondVertexVertex;
        this.thirdVertexVertex = thirdVertexVertex;
    }

    public int[] getFirstVertexCoord() {
        return firstVertexVertex.coord;
    }


    public int[] getSecondVertexCoord() {
        return secondVertexVertex.coord;
    }


    public int[] getThirdVertexCoord() {
        return thirdVertexVertex.coord;
    }


    public boolean checkIntoTriangle(Point point){
        int[] coordA = getFirstVertexCoord();
        int[] coordB = getSecondVertexCoord();
        int[] coordC = getThirdVertexCoord();

        int a = (coordA[1] - coordB[1])*point.x + (coordB[0] - coordA[0])*point.y + (coordA[0]*coordB[1] - coordB[0]*coordA[1]);
        int b = (coordB[1] - coordC[1])*point.x + (coordC[0] - coordB[0])*point.y + (coordB[0]*coordC[1] - coordC[0]*coordB[1]);
        int c = (coordC[1] - coordA[1])*point.x + (coordA[0] - coordC[0])*point.y + (coordC[0]*coordA[1] - coordA[0]*coordC[1]);

        return (a >= 0 && b >= 0 && c >=0) || (a <0 && b < 0 && c < 0);
    }

}
