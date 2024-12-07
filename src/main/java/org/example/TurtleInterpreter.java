package org.example;

public class TurtleInterpreter implements TurtleVisitor {
    private int x = 0;
    private int y = 0;
    private int heading = 0; // 0: east, 90: north, 180: west, 270: south

    public double getNetDistance() {
        return Math.hypot(x, y);
    }

    @Override
    public void visitForward(int distance) {
        x += (int) (distance * Math.cos(Math.toRadians(heading)));
        y += (int) (distance * Math.sin(Math.toRadians(heading)));
    }

    @Override
    public void visitBackward(int distance) {
        x -= (int) (distance * Math.cos(Math.toRadians(heading)));
        y -= (int) (distance * Math.sin(Math.toRadians(heading)));
    }

    @Override
    public void visitLeft(int degrees) {
        heading = (heading + degrees) % 360;
    }

    @Override
    public void visitRight(int degrees) {
        heading = (heading - degrees + 360) % 360;
    }

    @Override
    public void visitGoto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void visitSetHeading(int heading) {
        this.heading = heading;
    }
}