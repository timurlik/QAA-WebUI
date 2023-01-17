package org.example.lesson4;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        try {
            triangle.calculateSquare(10, 10, 10);
        } catch (TriangleException e) {
            e.printStackTrace();
        }
    }
}
