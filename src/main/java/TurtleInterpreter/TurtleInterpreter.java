package TurtleInterpreter;

import java.util.List;

public class TurtleInterpreter implements ASTVisitor<TurtleMemento> {
    private final Turtle turtle;

    public TurtleInterpreter(Turtle turtle) {
        this.turtle = turtle;
    }
    public void interpret(List<ASTNode> commands) {
        for (ASTNode command : commands) {
            command.accept(this);
        }
    }

    @Override
    public TurtleMemento visit(ForwardNode node) {
        turtle.forward(node.value());
        System.out.println("Moved forward to (" + turtle.getX() + ", " + turtle.getY() + ")");
        return new TurtleMemento(turtle.getX(), turtle.getY(), turtle.getHeading());
    }

    @Override
    public TurtleMemento visit(BackwardNode node) {
        turtle.backward(node.value());
        System.out.println("Moved backward to (" + turtle.getX() + ", " + turtle.getY() + ")");
        return new TurtleMemento(turtle.getX(), turtle.getY(), turtle.getHeading());
    }

    @Override
    public TurtleMemento visit(TurnRightNode node) {
        turtle.turnright(node.value());
        System.out.println("Turned right to " + turtle.getHeading() + " degrees");
        return new TurtleMemento(turtle.getX(), turtle.getY(), turtle.getHeading());
    }

    @Override
    public TurtleMemento visit(TurnLeftNode node) {
        turtle.turnleft(node.value());
        System.out.println("Turned left to " + turtle.getHeading() + " degrees");
        return new TurtleMemento(turtle.getX(), turtle.getY(), turtle.getHeading());
    }
}