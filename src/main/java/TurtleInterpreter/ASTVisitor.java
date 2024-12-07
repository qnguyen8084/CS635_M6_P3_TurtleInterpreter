package TurtleInterpreter;

public interface ASTVisitor<T> {
    T visit(ForwardNode node);
    T visit(BackwardNode node);
    T visit(TurnRightNode node);
    T visit(TurnLeftNode node);
}
