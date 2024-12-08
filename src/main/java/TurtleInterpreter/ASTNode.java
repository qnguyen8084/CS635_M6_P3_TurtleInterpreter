/*
 * Quy Nguyen
 * Dr. Magda Tsintsadze
 * CS635
 * M6 P3 Turtle Interpreter
 * December 7, 2024
 * ASTNode.java
 */

package TurtleInterpreter;

public interface ASTNode {
    <T> T accept(ASTVisitor<T> visitor);
}
