package TurtleInterpreter;

public class TurnLeftNode implements ASTNode {
    public final int value;

    public TurnLeftNode(int value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
