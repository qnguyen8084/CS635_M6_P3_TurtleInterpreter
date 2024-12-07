package TurtleInterpreter;

public class TurtleMemento {
    private final double x;
    private final double y;
    private final double heading;

    public TurtleMemento(double x, double y, double heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
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