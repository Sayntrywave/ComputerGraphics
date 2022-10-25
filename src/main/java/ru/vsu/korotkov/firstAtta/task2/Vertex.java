package ru.vsu.korotkov.firstAtta.task2;

import java.util.Arrays;

public class Vertex {
    int[] coord = new int[4];

    public Vertex(int[] coord) {
        // Проверка на то, что не ввели длину отличную от 4
        try {
            if (coord.length != 4){
                throw new Exception();
            }
        }
         catch (Exception e) {
            e.printStackTrace();
            System.out.println("Кол-во элементов матрицы не может быть отличной от  4");
        }
        this.coord = coord.clone();
    }

    public Vertex(Point point) {
        coord[0] = point.getX();
        coord[1] = point.getY();
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex1 = (Vertex) o;
        return Arrays.equals(coord, vertex1.coord);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coord);
    }
}
