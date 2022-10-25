package ru.vsu.korotkov.firstAtta.task2;

import java.awt.*;

public class DrawUtils {
    public static boolean drawTriangle(Graphics gr, Triangle triangle) {
        Graphics2D g = (Graphics2D) gr;

        int x1 = triangle.getFirstVertexCoord()[0];
        int y1 = triangle.getFirstVertexCoord()[1];
        int x2 = triangle.getSecondVertexCoord()[0];
        int y2 = triangle.getSecondVertexCoord()[1];

        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x1, y1,
                triangle.getThirdVertexCoord()[0],
                triangle.getThirdVertexCoord()[1]);

        g.drawLine(triangle.getThirdVertexCoord()[0],
                triangle.getThirdVertexCoord()[1],
                x2, y2);

        return true;
    }

    public static boolean fillTriangle(Graphics gr, Triangle triangle, Color[] colorsOfVertexes) {

        int x1 = triangle.getFirstVertexCoord()[0];
        int x2 = triangle.getSecondVertexCoord()[0];
        int x3 = triangle.getThirdVertexCoord()[0];
        int y1 = triangle.getFirstVertexCoord()[1];
        int y2 = triangle.getSecondVertexCoord()[1];
        int y3 = triangle.getThirdVertexCoord()[1];

        int minX = Math.min(x1,
                Math.min(x2, x3
                ));
        int minY = Math.min(y1,
                Math.min(y2, y3
                ));

        int maxX = Math.max(x1,
                Math.max(x2,x3
                ));
        int maxY = Math.max(y1,
                Math.max(y2,y3
                ));
        Point point;

        double alpha;
        double betta;
        double gamma;

        int r1 = colorsOfVertexes[0].getRed();
        int r2 = colorsOfVertexes[1].getRed();
        int r3 = colorsOfVertexes[2].getRed();
        int g1 = colorsOfVertexes[0].getGreen();
        int g2 = colorsOfVertexes[1].getGreen();
        int g3 = colorsOfVertexes[2].getGreen();
        int b1 = colorsOfVertexes[0].getBlue();
        int b2 = colorsOfVertexes[1].getBlue();
        int b3 = colorsOfVertexes[2].getBlue();

        int r;
        int g;
        int b;

        for (int x = minX; x < maxX; x++) {
            for (int y = minY; y < maxY; y++) {
                point = new Point(x, y);
                if (triangle.checkIntoTriangle(point)) {
                    double detT = (y2 - y3) * (x1 - x3) + (x3 - x2) * (y1 - y3);
                    alpha = ((y2-y3)*(x-x3) + (x3 - x2)*(y-y3))/ detT;
                    betta = ((y3-y1)*(x-x3) + (x1 - x3)*(y-y3))/ detT;
                    gamma = 1 - alpha - betta;
                    r = (int) (alpha*r1 + betta*r2 + gamma*r3);
                    g = (int) (alpha*g1 + betta*g2 + gamma*g3);
                    b = (int) (alpha*b1 + betta*b2 + gamma*b3);

                    gr.setColor(new Color(r,g,b));
                    setPixel(gr, x, y);
                }
            }
        }
        return true;


    }

    public static boolean fillTriangle(Graphics gr, Triangle triangle, Color colorOfTriangle) {
        return fillTriangle(gr,triangle,new Color[]{colorOfTriangle,colorOfTriangle,colorOfTriangle});
    }

    public static boolean fillTriangle(Graphics gr, Triangle triangle) {
        return fillTriangle(gr, triangle, Color.blue);
    }

/*    private static int[] getExactBoundary(Triangle triangle, int minX, int maxX,int currY) {
        while (true){
            int mid = (minX + maxX) /2;
            if (triangle.checkIntoTriangle(new Point(mid,currY))){
                return getExactBoundary(Triangle)
            }
        }
        return -1;
    }*/


    private static void setPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }


}
