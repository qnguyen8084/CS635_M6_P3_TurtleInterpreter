package TurtleInterpreter;

public class ForwardNode implements ASTNode {
    public final int value;

    public ForwardNode(int value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
