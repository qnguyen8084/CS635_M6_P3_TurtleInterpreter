package org.example;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point fromPolar(double angle, double distance) {
        double x = distance * Math.cos(Math.toRadians(angle));
        double y = distance * Math.sin(Math.toRadians(angle));
        return new Point(x, y);
    }
}
