package ru.vsu.korotkov.firstAtta.task2;

import java.awt.*;
import java.util.List;
import java.util.*;

public class DrawUtils {
    interface GraphicsForTriangle{
        void setPixel(Graphics gr,int x, int y);
    }

    public static boolean drawTriangle(Graphics gr, Triangle triangle) {
        Graphics2D g = (Graphics2D) gr;

        int x1 = triangle.getFirstVertexPoint().x;
        int y1 = triangle.getFirstVertexPoint().y;
        int x2 = triangle.getSecondVertexPoint().x;
        int y2 = triangle.getSecondVertexPoint().y;

        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x1, y1,
                triangle.getThirdVertexPoint().x,
                triangle.getThirdVertexPoint().y);

        g.drawLine(triangle.getThirdVertexPoint().x,
                triangle.getThirdVertexPoint().y,
                x2, y2);

        return true;
    }

    static void fillTriangle(Graphics gr, double x1, double y1, double x2, double y2, double x3, double y3, Color color1, Color color2, Color color3) {
//        fillTriangle(gr,new Point((int)Math.round(x1),(int)Math.round(y1)),new Point((int)Math.round(x2),(int)Math.round(y2)),new Point((int)Math.round(x3),(int)Math.round(y3)),color1,color2,color3);
    }

    static void fillTriangle(Graphics gr,
                             Point p1, Point p2, Point p3,
                             Color color1, Color color2, Color color3) {

        List<Point> points = new ArrayList<>(Arrays.asList(p1, p2, p3));

        Collections.sort(points, Comparator.comparingInt((Point p) -> p.y));

        int x1 = points.get(0).x;
        int x2 = points.get(1).x;
        int x3 = points.get(2).x;

        int y1 = points.get(0).y;
        int y2 = points.get(1).y;
        int y3 = points.get(2).y;

        for (int y = y1; y < y2; y++) {
            int startX = getX(y, x1, x2, y1, y2);
            int endX = getX(y, x1, x3, y1, y3);

            fillLine(gr,y, startX, endX, color1, color2, color3, x1, x2, x3, y1, y2, y3);
        }

        for (int y = y2; y < y3; y++) {
            int startX = getX(y, x1, x3, y1, y3);
            int endX = getX(y, x2, x3, y2, y3);
            fillLine(gr, y, startX, endX, color1, color2, color3, x1, x2, x3, y1, y2, y3);
        }

    }

    private static int getX(int y, int x1, int x2, int y1, int y2) {
        return Math.round((x2 - x1) * (y - y1) / (float) (y2 - y1)) + x1;
    }

    private static void fillLine(Graphics gr, int y, int startX, int endX,
                                 Color color1, Color color2, Color color3,
                                 int x1, int x2, int x3,
                                 int y1, int y2, int y3) {
        if (startX > endX) {
            int temp = startX;
            startX = endX;
            endX = temp;
        }

        for (int x = startX; x < endX; x++) {
            gr.setColor(getColor(color1, color2, color3, x, y, x1, x2, x3, y1, y2, y3));
            setPixel(gr, x, y);
        }
    }

    private static Color getColor(Color color1, Color color2, Color color3,
                                  int x, int y,
                                  int x1, int x2, int x3,
                                  int y1, int y2, int y3) {

        double detT = (y2 - y3) * (x1 - x3) + (x3 - x2) * (y1 - y3);

        double alpha = ((y2 - y3) * (x - x3) + (x3 - x2) * (y - y3)) / detT;
        if (alpha < 0 || alpha > 1) {
            alpha = Math.round(alpha);
        }

        double betta = ((y3 - y1) * (x - x3) + (x1 - x3) * (y - y3)) / detT;
        if (betta < 0 || betta > 1) {
            betta = Math.round(betta);
        }

        double gamma = 1 - alpha - betta;
        int r = (int) (alpha * color1.getRed() + betta * color2.getRed() + gamma * color3.getRed());
        int g = (int) (alpha * color1.getGreen() + betta * color2.getGreen() + gamma * color3.getGreen());
        int b = (int) (alpha * color1.getBlue() + betta * color2.getBlue() + gamma * color3.getBlue());
        return new Color(r, g, b);
    }


    // slow realization of filling a triangle
    private static boolean fillTriangle(Graphics gr, Triangle triangle, List<Color> colorsOfVertexes) {

        int x1 = triangle.getFirstVertexPoint().x;
        int x2 = triangle.getSecondVertexPoint().x;
        int x3 = triangle.getThirdVertexPoint().x;
        int y1 = triangle.getFirstVertexPoint().y;
        int y2 = triangle.getSecondVertexPoint().y;
        int y3 = triangle.getThirdVertexPoint().y;

        int minX = Math.min(x1,
                Math.min(x2, x3
                ));
        int minY = Math.min(y1,
                Math.min(y2, y3
                ));

        int maxX = Math.max(x1,
                Math.max(x2, x3
                ));
        int maxY = Math.max(y1,
                Math.max(y2, y3
                ));
        Point point;

        for (int x = minX; x < maxX; x++) {
            for (int y = minY; y < maxY; y++) {
                point = new Point(x, y);
                if (triangle.checkIntoTriangle(point)) {
                    gr.setColor(getColor(colorsOfVertexes.get(0), colorsOfVertexes.get(1), colorsOfVertexes.get(2), x, y, x1, x2, x3, y1, y2, y3));
                    setPixel(gr, x, y);
                }
            }
        }
        return true;
    }

/*    public static boolean fillTriangle(Graphics gr, Triangle triangle, Color colorOfTriangle) {
        return fillTriangle(gr, triangle, new ArrayList<Color>(Arrays.asList(colorOfTriangle, colorOfTriangle, colorOfTriangle)));
    }

    public static boolean fillTriangle(Graphics gr, Triangle triangle) {
        return fillTriangle(gr, triangle, Color.blue);
    }*/

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
