/*
 * Quy Nguyen
 * Dr. Magda Tsintsadze
 * CS635
 * M6 P3 Turtle Interpreter
 * December 7, 2024
 * Turtle.java
 */

package TurtleInterpreter;

public class Turtle {
    private double x, y;
    private double heading;

    public Turtle() {
        x = 0;
        y = 0;
        heading = 0;
    }

    public void forward(double distance) {
        x += distance * Math.cos(Math.toRadians(heading));
        y += distance * Math.sin(Math.toRadians(heading));
    }

    public void backward(double distance) {
        forward(-distance);
    }

    public void turnleft(double degrees) {
        heading = (heading - degrees + 360) % 360;
    }

    public void turnright(double degrees) {
        heading = (heading + degrees) % 360;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHeading() {
        return heading;
    }
}