package TurtleInterpreterEnhanced;

import TurtleInterpreterEnhanced.generated.TurtleBaseVisitor;
import TurtleInterpreterEnhanced.generated.TurtleParser;

import java.util.ArrayList;
import java.util.List;

public class TurtleCommandVisitor extends TurtleBaseVisitor<Void> {
    private final List<String> commands = new ArrayList<>();

    @Override
    public Void visitTurtle(TurtleParser.TurtleContext ctx) {
        commands.add("Turtle " + ctx.INT(0).getText() + " " + ctx.INT(1).getText() + " " + ctx.INT(2).getText());
        return visitChildren(ctx);
    }

    @Override
    public Void visitForward(TurtleParser.ForwardContext ctx) {
        commands.add("Forward " + ctx.INT().getText());
        return visitChildren(ctx);
    }

    @Override
    public Void visitBackward(TurtleParser.BackwardContext ctx) {
        commands.add("Backward " + ctx.INT().getText());
        return visitChildren(ctx);
    }

    @Override
    public Void visitLeft(TurtleParser.LeftContext ctx) {
        commands.add("Left " + ctx.INT().getText());
        return visitChildren(ctx);
    }

    @Override
    public Void visitRight(TurtleParser.RightContext ctx) {
        commands.add("Right " + ctx.INT().getText());
        return visitChildren(ctx);
    }

    @Override
    public Void visitGoto(TurtleParser.GotoContext ctx) {
        commands.add("Goto " + ctx.INT(0).getText() + " " + ctx.INT(1).getText());
        return visitChildren(ctx);
    }

    @Override
    public Void visitSetHeading(TurtleParser.SetHeadingContext ctx) {
        commands.add("SetHeading " + ctx.INT().getText());
        return visitChildren(ctx);
    }

    public List<String> getCommands() {
        return new ArrayList<>(commands);
    }
}