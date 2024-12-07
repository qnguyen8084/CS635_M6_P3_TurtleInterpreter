package TurtleInterpreter;

public class BackwardNode implements ASTNode {
    public final int value;

    public BackwardNode(int value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
