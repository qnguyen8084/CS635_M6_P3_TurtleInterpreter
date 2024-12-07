package org.example;

import org.example.generated.TurtleBaseVisitor;
import org.example.generated.TurtleParser;

import java.util.ArrayList;
import java.util.List;

public class TurtleInterpreter extends TurtleBaseVisitor<Void> {
    private int x = 0;
    private int y = 0;
    private int direction = 0; // 0: north, 90: east, 180: south, 270: west
    private final List<TurtleMemento> mementos = new ArrayList<>();

    public double getNetDistance() {
        return Math.hypot(x, y);
    }

    @Override
    public Void visitTurtle(TurtleParser.TurtleContext ctx) {
        System.out.println("Turtle");
        x = Integer.parseInt(ctx.INT(0).getText());
        y = Integer.parseInt(ctx.INT(1).getText());
        direction = Integer.parseInt(ctx.INT(2).getText());
        mementos.add(new TurtleMemento(x, y, direction));
        return null;
    }

    @Override
    public Void visitForward(TurtleParser.ForwardContext ctx) {
        int distance = Integer.parseInt(ctx.INT().getText());
        switch (direction) {
            case 0: y += distance; break;
            case 90: x += distance; break;
            case 180: y -= distance; break;
            case 270: x -= distance; break;
        }
        System.out.println("Forward " + distance + " to (" + x + ", " + y + ")");
        mementos.add(new TurtleMemento(x, y, direction));
        return null;
    }

    @Override
    public Void visitBackward(TurtleParser.BackwardContext ctx) {
        int distance = Integer.parseInt(ctx.INT().getText());
        switch (direction) {
            case 0: y -= distance; break;
            case 90: x -= distance; break;
            case 180: y += distance; break;
            case 270: x += distance; break;
        }
        System.out.println("Backward " + distance + " to (" + x + ", " + y + ")");
        mementos.add(new TurtleMemento(x, y, direction));
        return null;
    }

    @Override
    public Void visitLeft(TurtleParser.LeftContext ctx) {
        int degrees = Integer.parseInt(ctx.INT().getText());
        direction = (direction - degrees + 360) % 360;
        System.out.println("Left " + degrees + " degrees to " + direction);
        mementos.add(new TurtleMemento(x, y, direction));
        return null;
    }

    @Override
    public Void visitRight(TurtleParser.RightContext ctx) {
        int degrees = Integer.parseInt(ctx.INT().getText());
        direction = (direction + degrees) % 360;
        System.out.println("Right " + degrees + " degrees to " + direction);
        mementos.add(new TurtleMemento(x, y, direction));
        return null;
    }

    @Override
    public Void visitGoto(TurtleParser.GotoContext ctx) {
        x = Integer.parseInt(ctx.INT(0).getText());
        y = Integer.parseInt(ctx.INT(1).getText());
        System.out.println("Goto (" + x + ", " + y + ")");
        mementos.add(new TurtleMemento(x, y, direction));
        return null;
    }

    @Override
    public Void visitSetHeading(TurtleParser.SetHeadingContext ctx) {
        direction = Integer.parseInt(ctx.INT().getText());
        System.out.println("Set heading to " + direction);
        mementos.add(new TurtleMemento(x, y, direction));
        return null;
    }    public List<TurtleMemento> getMementos() {
        return mementos;
    }
}