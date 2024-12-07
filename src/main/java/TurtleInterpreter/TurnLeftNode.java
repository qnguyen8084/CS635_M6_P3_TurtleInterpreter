package TurtleInterpreter;

public record TurnLeftNode(int value) implements ASTNode {

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
