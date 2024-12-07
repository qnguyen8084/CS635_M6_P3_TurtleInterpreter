package TurtleInterpreter;

public class TurnRightNode implements ASTNode {
    public final int value;

    public TurnRightNode(int value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
