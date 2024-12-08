/*
 * Quy Nguyen
 * Dr. Magda Tsintsadze
 * CS635
 * M6 P3 Turtle Interpreter
 * December 7, 2024
 * MockTurtleTest.java
 */

package TurtleInterpreterEnhanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MockTurtleTest {

    @Test
    void forwardMovesTurtleCorrectly() {
        MockTurtle turtle = new MockTurtle(0, 0, 0);
        turtle.forward(10);
        assertEquals(10, turtle.getX());
        assertEquals(0, turtle.getY());
    }

    @Test
    void backwardMovesTurtleCorrectly() {
        MockTurtle turtle = new MockTurtle(10, 0, 0);
        turtle.backward(10);
        assertEquals(0, turtle.getX());
        assertEquals(0, turtle.getY());
    }

    @Test
    void leftTurnsTurtleCorrectly() {
        MockTurtle turtle = new MockTurtle(0, 0, 0);
        turtle.left(90);
        assertEquals(90, turtle.getHeading());
    }

    @Test
    void rightTurnsTurtleCorrectly() {
        MockTurtle turtle = new MockTurtle(0, 0, 90);
        turtle.right(90);
        assertEquals(0, turtle.getHeading());
    }

    @Test
    void goToMovesTurtleCorrectly() {
        MockTurtle turtle = new MockTurtle(0, 0, 0);
        turtle.goTo(10, 20);
        assertEquals(10, turtle.getX());
        assertEquals(20, turtle.getY());
    }

    @Test
    void setHeadingChangesHeadingCorrectly() {
        MockTurtle turtle = new MockTurtle(0, 0, 0);
        turtle.setHeading(180);
        assertEquals(180, turtle.getHeading());
    }

    @Test
    void forwardWithNonZeroHeading() {
        MockTurtle turtle = new MockTurtle(0, 0, 90);
        turtle.forward(10);
        assertEquals(0, turtle.getX());
        assertEquals(10, turtle.getY());
    }

    @Test
    void backwardWithNonZeroHeading() {
        MockTurtle turtle = new MockTurtle(0, 10, 90);
        turtle.backward(10);
        assertEquals(0, turtle.getX());
        assertEquals(0, turtle.getY());
    }

    @Test
    void leftWithLargeDegrees() {
        MockTurtle turtle = new MockTurtle(0, 0, 0);
        turtle.left(450);
        assertEquals(90, turtle.getHeading());
    }

    @Test
    void rightWithLargeDegrees() {
        MockTurtle turtle = new MockTurtle(0, 0, 0);
        turtle.right(450);
        assertEquals(270, turtle.getHeading());
    }

    @Test
    void getStateReturnsCorrectMemento() {
        MockTurtle turtle = new MockTurtle(1000, -100, 75);
        TurtleMemento memento = turtle.getState();
        assertEquals(1000, memento.getX());
        assertEquals(-100, memento.getY());
        assertEquals(75, memento.getHeading());
    }

    @Test
    void forwardWithNegativeDistance() {
        MockTurtle turtle = new MockTurtle(0, 0, 0);
        turtle.forward(-10);
        assertEquals(-10, turtle.getX());
        assertEquals(0, turtle.getY());
    }

    @Test
    void backwardWithNegativeDistance() {
        MockTurtle turtle = new MockTurtle(0, 0, 0);
        turtle.backward(-10);
        assertEquals(10, turtle.getX());
        assertEquals(0, turtle.getY());
    }

    @Test
    void setHeadingWithNegativeValue() {
        MockTurtle turtle = new MockTurtle(0, 0, 0);
        turtle.setHeading(-90);
        assertEquals(270, turtle.getHeading());
    }

    @Test
    void setHeadingWithLargeValue() {
        MockTurtle turtle = new MockTurtle(0, 0, 0);
        turtle.setHeading(450);
        assertEquals(90, turtle.getHeading());
    }

    @Test
    void goToWithNegativeCoordinates() {
        MockTurtle turtle = new MockTurtle(0, 0, 0);
        turtle.goTo(-10, -20);
        assertEquals(-10, turtle.getX());
        assertEquals(-20, turtle.getY());
    }

    @Test
    void leftWithNegativeDegrees() {
        MockTurtle turtle = new MockTurtle(0, 0, 0);
        turtle.left(-90);
        assertEquals(270, turtle.getHeading());
    }

    @Test
    void rightWithNegativeDegrees() {
        MockTurtle turtle = new MockTurtle(0, 0, 0);
        turtle.right(-90);
        assertEquals(90, turtle.getHeading());
    }

}