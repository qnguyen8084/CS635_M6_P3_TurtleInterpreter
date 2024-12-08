/*
 * Quy Nguyen
 * Dr. Magda Tsintsadze
 * CS635
 * M6 P3 Turtle Interpreter
 * December 7, 2024
 * TurtleMemento.java
 */

package TurtleInterpreterEnhanced;


// This is a memento class for the turtle. It is used to store the state of a turtle after a command is executed.
public class TurtleMemento {
    private final int x;
    private final int y;
    private final int heading;

    public TurtleMemento(int x, int y, int heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
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
}