package TurtleInterpreterEnhanced;

import TurtleInterpreterEnhanced.generated.TurtleBaseVisitor;
import TurtleInterpreterEnhanced.generated.TurtleParser;

import java.util.ArrayList;
import java.util.List;

public class TurtleMementoVisitor extends TurtleBaseVisitor<Void> {
    private int x = 0;
    private int y = 0;
    private int heading = 0; // 0: east, 90: north, 180: west, 270: south
    private final List<TurtleMemento> mementos = new ArrayList<>();

    public double getNetDistance() {
        return Math.hypot(x, y);
    }

    @Override
    public Void visitTurtle(TurtleParser.TurtleContext ctx) {
        try {
            x = Integer.parseInt(ctx.INT(0).getText());
            y = Integer.parseInt(ctx.INT(1).getText());
            heading = Integer.parseInt(ctx.INT(2).getText());
            mementos.add(new TurtleMemento(x, y, heading));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integers in visitTurtle: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitForward(TurtleParser.ForwardContext ctx) {
        try {
            int distance = Integer.parseInt(ctx.INT().getText());
            x += (int) (distance * Math.cos(Math.toRadians(heading)));
            y += (int) (distance * Math.sin(Math.toRadians(heading)));
            mementos.add(new TurtleMemento(x, y, heading));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer in visitForward: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitBackward(TurtleParser.BackwardContext ctx) {
        try {
            int distance = Integer.parseInt(ctx.INT().getText());
            x -= (int) (distance * Math.cos(Math.toRadians(heading)));
            y -= (int) (distance * Math.sin(Math.toRadians(heading)));
            mementos.add(new TurtleMemento(x, y, heading));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer in visitBackward: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitLeft(TurtleParser.LeftContext ctx) {
        try {
            int degrees = Integer.parseInt(ctx.INT().getText());
            heading = (heading + degrees) % 360;
            mementos.add(new TurtleMemento(x, y, heading));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer in visitLeft: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitRight(TurtleParser.RightContext ctx) {
        try {
            int degrees = Integer.parseInt(ctx.INT().getText());
            heading = (heading - degrees + 360) % 360;
            mementos.add(new TurtleMemento(x, y, heading));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer in visitRight: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitGoto(TurtleParser.GotoContext ctx) {
        try {
            x = Integer.parseInt(ctx.INT(0).getText());
            y = Integer.parseInt(ctx.INT(1).getText());
            mementos.add(new TurtleMemento(x, y, heading));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integers in visitGoto: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitSetHeading(TurtleParser.SetHeadingContext ctx) {
        try {
            heading = Integer.parseInt(ctx.INT().getText());
            mementos.add(new TurtleMemento(x, y, heading));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer in visitSetHeading: " + e.getMessage());
        }
        return null;
    }

    public List<TurtleMemento> getMementos() {
        return new ArrayList<>(mementos);
    }
}