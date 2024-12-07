package org.example;

import org.example.generated.TurtleBaseVisitor;
import org.example.generated.TurtleParser;

public class TurtleDistanceVisitor extends TurtleBaseVisitor<Void> {
    private double totalDistance = 0;
    private int x = 0;
    private int y = 0;

    public double getTotalDistance() {
        return totalDistance;
    }

    @Override
    public Void visitForward(TurtleParser.ForwardContext ctx) {
        int distance = Integer.parseInt(ctx.INT().getText());
        totalDistance += distance;
        return null;
    }

    @Override
    public Void visitBackward(TurtleParser.BackwardContext ctx) {
        int distance = Integer.parseInt(ctx.INT().getText());
        totalDistance += distance;
        return null;
    }

    @Override
    public Void visitGoto(TurtleParser.GotoContext ctx) {
        int newX = Integer.parseInt(ctx.INT(0).getText());
        int newY = Integer.parseInt(ctx.INT(1).getText());
        totalDistance += Math.hypot(newX - x, newY - y);
        x = newX;
        y = newY;
        return null;
    }
}
