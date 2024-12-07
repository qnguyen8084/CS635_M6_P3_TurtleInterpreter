package TurtleInterpreter;

public interface ASTNode {
    <T> T accept(ASTVisitor<T> visitor);
}
