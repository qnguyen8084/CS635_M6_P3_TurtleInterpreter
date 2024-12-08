package TurtleInterpreterEnhanced;

import TurtleInterpreterEnhanced.generated.TurtleBaseVisitor;
import TurtleInterpreterEnhanced.generated.TurtleParser;

import java.util.ArrayList;
import java.util.List;

public class TurtleCommandVisitor extends TurtleBaseVisitor<Void> {
    private final Turtle turtle;
    private final List<String> commands = new ArrayList<>();

    public TurtleCommandVisitor(Turtle turtle) {
        this.turtle = turtle;
    }

    @Override
    public Void visitTurtle(TurtleParser.TurtleContext ctx) {
        int x = Integer.parseInt(ctx.INT(0).getText());
        int y = Integer.parseInt(ctx.INT(1).getText());
        int heading = Integer.parseInt(ctx.INT(2).getText());
        turtle.goTo(x, y);
        turtle.setHeading(heading);
        commands.add("Turtle " + ctx.INT(0).getText() + " " + ctx.INT(1).getText() + " " + ctx.INT(2).getText());
        return visitChildren(ctx);
    }

    @Override
    public Void visitForward(TurtleParser.ForwardContext ctx) {
        int distance = Integer.parseInt(ctx.INT().getText());
        turtle.forward(distance);
        commands.add("Forward " + ctx.INT().getText());
        return visitChildren(ctx);
    }

    @Override
    public Void visitBackward(TurtleParser.BackwardContext ctx) {
        int distance = Integer.parseInt(ctx.INT().getText());
        turtle.backward(distance);
        commands.add("Backward " + ctx.INT().getText());
        return visitChildren(ctx);
    }

    @Override
    public Void visitLeft(TurtleParser.LeftContext ctx) {
        int degrees = Integer.parseInt(ctx.INT().getText());
        turtle.left(degrees);
        commands.add("Left " + ctx.INT().getText());
        return visitChildren(ctx);
    }

    @Override
    public Void visitRight(TurtleParser.RightContext ctx) {
        int degrees = Integer.parseInt(ctx.INT().getText());
        turtle.right(degrees);
        commands.add("Right " + ctx.INT().getText());
        return visitChildren(ctx);
    }

    @Override
    public Void visitGoto(TurtleParser.GotoContext ctx) {
        int x = Integer.parseInt(ctx.INT(0).getText());
        int y = Integer.parseInt(ctx.INT(1).getText());
        turtle.goTo(x, y);
        commands.add("Goto " + ctx.INT(0).getText() + " " + ctx.INT(1).getText());
        return visitChildren(ctx);
    }

    @Override
    public Void visitSetHeading(TurtleParser.SetHeadingContext ctx) {
        int heading = Integer.parseInt(ctx.INT().getText());
        turtle.setHeading(heading);
        commands.add("SetHeading " + ctx.INT().getText());
        return visitChildren(ctx);
    }

    public List<String> getCommands() {
        return new ArrayList<>(commands);
    }
}