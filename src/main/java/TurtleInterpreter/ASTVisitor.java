/*
 * Quy Nguyen
 * Dr. Magda Tsintsadze
 * CS635
 * M6 P3 Turtle Interpreter
 * December 7, 2024
 * ASTVisitor.java
 */

package TurtleInterpreter;

public interface ASTVisitor<T> {
    T visit(ForwardNode node);
    T visit(BackwardNode node);
    T visit(TurnRightNode node);
    T visit(TurnLeftNode node);
}
