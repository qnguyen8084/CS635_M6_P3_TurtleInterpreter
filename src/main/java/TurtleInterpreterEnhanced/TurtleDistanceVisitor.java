/*
 * Quy Nguyen
 * Dr. Magda Tsintsadze
 * CS635
 * M6 P3 Turtle Interpreter
 * December 7, 2024
 * TurtleDistanceVisitor.java
 */

package TurtleInterpreterEnhanced;

import TurtleInterpreterEnhanced.generated.TurtleBaseVisitor;
import TurtleInterpreterEnhanced.generated.TurtleParser;

import java.util.ArrayList;
import java.util.List;

// This is the visitor class that traverses the ast. He has the functionality of storing the total distance
// It also has uses an array list to store the cumulative distance for each step in the turtle program.

public class TurtleDistanceVisitor extends TurtleBaseVisitor<Void> {
    private double totalDistance = 0;
    private int x = 0;
    private int y = 0;
    private final List<Double> totalDistances = new ArrayList<>();

    // Returns the total distance traversed by the turtle
    public double getTotalDistance() {
        return totalDistance;
    }

    // Returns the list of cumulative distances for each step in the turtle program
    public List<Double> getTotalDistances() {
        return new ArrayList<>(totalDistances);
    }

    // Visits the turtle Forward AST node and adds the distance to the total distance
    @Override
    public Void visitForward(TurtleParser.ForwardContext ctx) {
        int distance = Integer.parseInt(ctx.INT().getText());
        totalDistance += distance;
        totalDistances.add(totalDistance);
        return null;
    }

    // Visits the turtle Backward AST node and adds the distance to the total distance
    @Override
    public Void visitBackward(TurtleParser.BackwardContext ctx) {
        int distance = Integer.parseInt(ctx.INT().getText());
        totalDistance += distance;
        totalDistances.add(totalDistance);
        return null;
    }

    // Visits the turtle Goto AST node and adds the distance to the total distance
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

    // These four following methods effectively add 0 to the total distance, but is needed to be able to correlate
    // the distances along with the commands.
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
