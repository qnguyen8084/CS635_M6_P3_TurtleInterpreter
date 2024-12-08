/*
 * Quy Nguyen
 * Dr. Magda Tsintsadze
 * CS635
 * M6 P3 Turtle Interpreter
 * December 7, 2024
 * MockTurtle.java
 */

package TurtleInterpreterEnhanced;

// This is a mock turtle class that implements the turtle interface. It is used for testing purposes.
public class MockTurtle implements Turtle {
    private int x;
    private int y;
    private int heading;

    public MockTurtle(int x, int y, int heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    @Override
    public void forward(int distance) {
        this.x += (int) (distance * Math.cos(Math.toRadians(heading)));
        this.y += (int) (distance * Math.sin(Math.toRadians(heading)));
    }

    @Override
    public void backward(int distance) {
        this.x += (int) (-distance * Math.cos(Math.toRadians(heading)));
        this.y += (int) (-distance * Math.sin(Math.toRadians(heading)));
    }

    @Override
    public void left(int degrees) {
        this.heading = (this.heading + degrees) % 360;
        if (this.heading < 0) this.heading += 360;
    }

    @Override
    public void right(int degrees) {
        this.heading = (this.heading - degrees) % 360;
        if (this.heading < 0) this.heading += 360;
    }

    @Override
    public void goTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setHeading(int heading) {
        this.heading = (heading % 360 + 360) % 360;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeading() {
        return heading;
    }

    @Override
    public TurtleMemento getState() {
        return new TurtleMemento(x, y, heading);
    }
}