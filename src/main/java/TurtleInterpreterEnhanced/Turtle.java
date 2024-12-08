package TurtleInterpreterEnhanced;

public interface Turtle {
    void forward(int distance);
    void backward(int distance);
    void left(int degrees);
    void right(int degrees);
    void goTo(int x, int y);
    void setHeading(int heading);
    TurtleMemento getState();
}
