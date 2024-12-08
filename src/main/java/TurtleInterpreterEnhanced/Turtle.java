/*
 * Quy Nguyen
 * Dr. Magda Tsintsadze
 * CS635
 * M6 P3 Turtle Interpreter
 * December 7, 2024
 * Turtle.java
 */

package TurtleInterpreterEnhanced;


// This is the interface for the turtle. It defines the methods that the turtle can use to move around.
public interface Turtle {
    void forward(int distance);
    void backward(int distance);
    void left(int degrees);
    void right(int degrees);
    void goTo(int x, int y);
    void setHeading(int heading);
    TurtleMemento getState();
}
