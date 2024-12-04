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
        heading = (heading + degrees) % 360;
    }

    public void turnright(double degrees) {
        heading = (heading - degrees) % 360;
    }
}
