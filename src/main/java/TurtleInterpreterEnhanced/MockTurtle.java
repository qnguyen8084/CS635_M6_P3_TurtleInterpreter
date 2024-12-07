package TurtleInterpreterEnhanced;

public class MockTurtle {
    private int x;
    private int y;
    private int heading;

    MockTurtle(int x, int y, int heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    public void forward(int distance) {
        this.x += (int) (distance * Math.cos(Math.toRadians(heading)));
        this.y += (int) (distance * Math.sin(Math.toRadians(heading)));
    }

    public void backward(int distance) {
        this.x -= (int) (distance * Math.cos(Math.toRadians(heading)));
        this.y -= (int) (distance * Math.sin(Math.toRadians(heading)));
    }

    public void left(int degrees) {
        this.heading += degrees % 360;
    }

    public void right(int degrees) {
        this.heading -= degrees % 360;
    }

    public void goTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public MockTurtle getState() {
        return new MockTurtle(x, y, heading);
    }
}
