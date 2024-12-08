/*
 * Quy Nguyen
 * Dr. Magda Tsintsadze
 * CS635
 * M6 P3 Turtle Interpreter
 * December 7, 2024
 * TurtleDistanceVisitor.java
 */

package TurtleInterpreter;

public class TurtleDistanceVisitor implements ASTVisitor<Void> {
    private double totalDistance = 0;

    public double getTotalDistance() {
        return totalDistance;
    }

    @Override
    public Void visit(ForwardNode node) {
        totalDistance += node.value();
        return null;
    }

    @Override
    public Void visit(BackwardNode node) {
        totalDistance += node.value();
        return null;
    }

    @Override
    public Void visit(TurnLeftNode node) {
        // Turning does not affect the distance traveled
        return null;
    }

    @Override
    public Void visit(TurnRightNode node) {
        // Turning does not affect the distance traveled
        return null;
    }
}