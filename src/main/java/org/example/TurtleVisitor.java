package org.example;

public interface TurtleVisitor {
    void visitForward(int distance);
    void visitBackward(int distance);
    void visitLeft(int degrees);
    void visitRight(int degrees);
    void visitGoto(int x, int y);
    void visitSetHeading(int heading);
}