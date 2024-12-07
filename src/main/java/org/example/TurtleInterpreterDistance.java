package org.example;

import org.example.generated.TurtleBaseVisitor;
import org.example.generated.TurtleParser;

public class TurtleInterpreterDistance extends TurtleBaseVisitor<Void> {
    private double totalDistance = 0;

    public double getTotalDistance() {
        return totalDistance;
    }

//    @Override
//    public Void visitTurtle(TurtleParser.TurtleContext ctx) {
//        return null;
//    }

    @Override
    public Void visitForward(TurtleParser.ForwardContext ctx) {
        totalDistance += Integer.parseInt(ctx.INT().getText());
//        System.out.println("Total distance: " + totalDistance);
        return null;
    }

    @Override
    public Void visitBackward(TurtleParser.BackwardContext ctx) {
        totalDistance += Integer.parseInt(ctx.INT().getText());
//        System.out.println("Total distance: " + totalDistance);
        return null;
    }

//    @Override
//    public Void visitLeft(TurtleParser.LeftContext ctx) {
//        return null;
//    }
//
//    @Override
//    public Void visitRight(TurtleParser.RightContext ctx) {
//        return null;
//    }
//
    @Override
    public Void visitGoto(TurtleParser.GotoContext ctx) {
        return null;
    }

    @Override
    public Void visitSetHeading(TurtleParser.SetHeadingContext ctx) {
        return null;
    }
}
