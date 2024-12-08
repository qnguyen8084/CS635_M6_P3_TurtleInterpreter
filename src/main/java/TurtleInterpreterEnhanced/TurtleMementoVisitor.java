/*
 * Quy Nguyen
 * Dr. Magda Tsintsadze
 * CS635
 * M6 P3 Turtle Interpreter
 * December 7, 2024
 * TurtleMementoVisitor.java
 */

package TurtleInterpreterEnhanced;

import TurtleInterpreterEnhanced.generated.TurtleBaseVisitor;
import TurtleInterpreterEnhanced.generated.TurtleParser;

import java.util.ArrayList;
import java.util.List;

// This is the visitor class that traverses the AST genereated by the parser and creates a list of mementos
// of the turtle's state after each command is executed. It also includes the method to calculate the net
// distance of the turtles final position from the starting position.
public class TurtleMementoVisitor extends TurtleBaseVisitor<Void> {
    private int x = 0;
    private int y = 0;
    private int heading = 0; // 0: east, 90: north, 180: west, 270: south
    private final List<TurtleMemento> mementos = new ArrayList<>();
    private final Turtle turtle;

    public TurtleMementoVisitor(Turtle turtle) {
        this.turtle = turtle;
    }

    public double getNetDistance() {
        return Math.hypot(x, y);
    }

    // Visits the turtle AST node and sets the turtle's x, y, and heading to the values in the AST node
    @Override
    public Void visitTurtle(TurtleParser.TurtleContext ctx) {
        try {
            x = Integer.parseInt(ctx.INT(0).getText());
            y = Integer.parseInt(ctx.INT(1).getText());
            heading = Integer.parseInt(ctx.INT(2).getText());
            turtle.goTo(x, y);
            turtle.setHeading(heading);
            mementos.add(new TurtleMemento(x, y, heading));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integers in visitTurtle: " + e.getMessage());
        }
        return visitChildren(ctx);
    }

    // Visits the forward AST node and moves the turtle forward by the distance in the AST node
    @Override
    public Void visitForward(TurtleParser.ForwardContext ctx) {
        try {
            int distance = Integer.parseInt(ctx.INT().getText());
            turtle.forward(distance);
            x += (int) (distance * Math.cos(Math.toRadians(heading)));
            y += (int) (distance * Math.sin(Math.toRadians(heading)));
            mementos.add(new TurtleMemento(x, y, heading));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer in visitForward: " + e.getMessage());
        }
        return visitChildren(ctx);
    }

    // Visits the backward AST node and moves the turtle backward by the distance in the AST node
    @Override
    public Void visitBackward(TurtleParser.BackwardContext ctx) {
        try {
            int distance = Integer.parseInt(ctx.INT().getText());
            turtle.backward(distance);
            x -= (int) (distance * Math.cos(Math.toRadians(heading)));
            y -= (int) (distance * Math.sin(Math.toRadians(heading)));
            mementos.add(new TurtleMemento(x, y, heading));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer in visitBackward: " + e.getMessage());
        }
        return visitChildren(ctx);
    }

    // Visits the left AST node and turns the turtle left by the degrees in the AST node
    @Override
    public Void visitLeft(TurtleParser.LeftContext ctx) {
        try {
            int degrees = Integer.parseInt(ctx.INT().getText());
            turtle.left(degrees);
            heading = (heading + degrees) % 360;
            if (heading < 0) heading += 360;
            mementos.add(new TurtleMemento(x, y, heading));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer in visitLeft: " + e.getMessage());
        }
        return visitChildren(ctx);
    }

    // Visits the right AST node and turns the turtle right by the degrees in the AST node
    @Override
    public Void visitRight(TurtleParser.RightContext ctx) {
        try {
            int degrees = Integer.parseInt(ctx.INT().getText());
            turtle.right(degrees);
            heading = (heading - degrees + 360) % 360;
            if (heading < 0) heading += 360;
            mementos.add(new TurtleMemento(x, y, heading));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer in visitRight: " + e.getMessage());
        }
        return visitChildren(ctx);
    }

    // Visits the goto AST node and moves the turtle to the x, y coordinates in the AST node
    @Override
    public Void visitGoto(TurtleParser.GotoContext ctx) {
        try {
            x = Integer.parseInt(ctx.INT(0).getText());
            y = Integer.parseInt(ctx.INT(1).getText());
            turtle.goTo(x, y);
            mementos.add(new TurtleMemento(x, y, heading));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integers in visitGoto: " + e.getMessage());
        }
        return visitChildren(ctx);
    }

    // Visits the setheading AST node and sets the turtle's heading to the degrees in the AST node
    @Override
    public Void visitSetHeading(TurtleParser.SetHeadingContext ctx) {
        try {
            heading = Integer.parseInt(ctx.INT().getText());
            heading = (heading % 360 + 360) % 360;
            turtle.setHeading(heading);
            mementos.add(new TurtleMemento(x, y, heading));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer in visitSetHeading: " + e.getMessage());
        }
        return visitChildren(ctx);
    }

    // Returns the list of mementos
    public List<TurtleMemento> getMementos() {
        return new ArrayList<>(mementos);
    }
}