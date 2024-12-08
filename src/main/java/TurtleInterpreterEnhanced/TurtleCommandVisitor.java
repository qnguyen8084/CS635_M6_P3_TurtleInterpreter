/*
 * Quy Nguyen
 * Dr. Magda Tsintsadze
 * CS635
 * M6 P3 Turtle Interpreter
 * December 7, 2024
 * TurtleCommandVisitor.java
 */

package TurtleInterpreterEnhanced;

import TurtleInterpreterEnhanced.generated.TurtleBaseVisitor;
import TurtleInterpreterEnhanced.generated.TurtleParser;

import java.util.ArrayList;
import java.util.List;

// This is the visitor class that traverses the ast. He has the functionality of storing commands as
// well as executing a turtle program.
public class TurtleCommandVisitor extends TurtleBaseVisitor<Void> {
    private final Turtle turtle;
    private final List<String> commands = new ArrayList<>();

    // Constructor that takes a turtle object
    public TurtleCommandVisitor(Turtle turtle) {
        this.turtle = turtle;
    }

    // Visits the turtle AST node and sets the turtle's x, y, and heading to the values in the AST node
    @Override
    public Void visitTurtle(TurtleParser.TurtleContext ctx) {
        int x = Integer.parseInt(ctx.INT(0).getText());
        int y = Integer.parseInt(ctx.INT(1).getText());
        int heading = Integer.parseInt(ctx.INT(2).getText());
        // Set the turtle's x, y, and heading to the values in the AST node
        turtle.goTo(x, y);
        // Set the turtle's heading to the value in the AST node
        turtle.setHeading(heading);
        commands.add("Turtle " + ctx.INT(0).getText() + " " + ctx.INT(1).getText() + " " + ctx.INT(2).getText());
        return visitChildren(ctx);
    }

    // Visits the forward AST node and moves the turtle forward by the distance in the AST node
    @Override
    public Void visitForward(TurtleParser.ForwardContext ctx) {
        int distance = Integer.parseInt(ctx.INT().getText());
        // Move the turtle forward by the distance in the AST node
        turtle.forward(distance);
        commands.add("Forward " + ctx.INT().getText());
        return visitChildren(ctx);
    }

    // Visits the backward AST node and moves the turtle backward by the distance in the AST node
    @Override
    public Void visitBackward(TurtleParser.BackwardContext ctx) {
        int distance = Integer.parseInt(ctx.INT().getText());
        // Move the turtle backward by the distance in the AST node
        turtle.backward(distance);
        commands.add("Backward " + ctx.INT().getText());
        return visitChildren(ctx);
    }

    // Visits the left AST node and turns the turtle left by the degrees in the AST node
    @Override
    public Void visitLeft(TurtleParser.LeftContext ctx) {
        int degrees = Integer.parseInt(ctx.INT().getText());
        // Turn the turtle left by the degrees in the AST node
        turtle.left(degrees);
        commands.add("Left " + ctx.INT().getText());
        return visitChildren(ctx);
    }

    // Visits the right AST node and turns the turtle right by the degrees in the AST node
    @Override
    public Void visitRight(TurtleParser.RightContext ctx) {
        int degrees = Integer.parseInt(ctx.INT().getText());
        // Turn the turtle right by the degrees in the AST node
        turtle.right(degrees);
        commands.add("Right " + ctx.INT().getText());
        return visitChildren(ctx);
    }

    // Visits the goto AST node and moves the turtle to the x, y coordinates in the AST node
    @Override
    public Void visitGoto(TurtleParser.GotoContext ctx) {
        int x = Integer.parseInt(ctx.INT(0).getText());
        int y = Integer.parseInt(ctx.INT(1).getText());
        // Move the turtle to the x, y coordinates in the AST node
        turtle.goTo(x, y);
        commands.add("Goto " + ctx.INT(0).getText() + " " + ctx.INT(1).getText());
        return visitChildren(ctx);
    }

    // Visits the setheading AST node and sets the turtle's heading to the value in the AST node
    @Override
    public Void visitSetHeading(TurtleParser.SetHeadingContext ctx) {
        int heading = Integer.parseInt(ctx.INT().getText());
        // Set the turtle's heading to the value in the AST node
        turtle.setHeading(heading);
        commands.add("SetHeading " + ctx.INT().getText());
        return visitChildren(ctx);
    }

    //  Returns the list of commands
    public List<String> getCommands() {
        return new ArrayList<>(commands);
    }
}