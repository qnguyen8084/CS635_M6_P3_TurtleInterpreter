package org.example;

import org.example.generated.TurtleBaseVisitor;
import org.example.generated.TurtleParser;

import java.util.ArrayList;
import java.util.List;

public class TurtleDistanceVisitor extends TurtleBaseVisitor<Void> {
    private double totalDistance = 0;
    private int x = 0;
    private int y = 0;
    private final List<Double> totalDistances = new ArrayList<>();

    public double getTotalDistance() {
        return totalDistance;
    }

    public List<Double> getTotalDistances() {
        return new ArrayList<>(totalDistances);
    }

    @Override
    public Void visitForward(TurtleParser.ForwardContext ctx) {
        int distance = Integer.parseInt(ctx.INT().getText());
        totalDistance += distance;
        totalDistances.add(totalDistance);
        return null;
    }

    @Override
    public Void visitBackward(TurtleParser.BackwardContext ctx) {
        int distance = Integer.parseInt(ctx.INT().getText());
        totalDistance += distance;
        totalDistances.add(totalDistance);
        return null;
    }

    @Override
    public Void visitGoto(TurtleParser.GotoContext ctx) {
        int newX = Integer.parseInt(ctx.INT(0).getText());
        int newY = Integer.parseInt(ctx.INT(1).getText());
        totalDistance += Math.hypot(newX - x, newY - y);
        x = newX;
        y = newY;
        totalDistances.add(totalDistance);
        return null;
    }

    public Void visitSetHeading(TurtleParser.SetHeadingContext ctx) {
        totalDistances.add(totalDistance);
        return null;
    }

    public Void visitLeft(TurtleParser.LeftContext ctx) {
        totalDistances.add(totalDistance);
        return null;
    }

    public Void visitRight(TurtleParser.RightContext ctx) {
        totalDistances.add(totalDistance);
        return null;
    }

    public Void visitTurtle(TurtleParser.TurtleContext ctx) {
        totalDistances.add(totalDistance);
        return null;
    }
}
