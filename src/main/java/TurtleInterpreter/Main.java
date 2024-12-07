package TurtleInterpreter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "src/main/java/TurtleInterpreter/TurtleProgramTest.txt";
        TurtleLexerInt lexer = new TurtleLexer(fileName);
        List<String> tokens = lexer.tokenize();
        TurtleParser parser = new TurtleParser(tokens);
        List<ASTNode> commands = parser.parse();
        Turtle turtle = new Turtle();
        TurtleInterpreter interpreter = new TurtleInterpreter(turtle);
        List<TurtleMemento> mementos = new ArrayList<>();
        TurtleDistanceVisitor turtleDistance = new TurtleDistanceVisitor();
        for (ASTNode command : commands) {
            TurtleMemento memento = command.accept(interpreter);
            mementos.add(memento);
            command.accept(turtleDistance);
        }
        for (TurtleMemento memento : mementos) {
            System.out.println("Memento - X: " + memento.getX() + ", Y: " + memento.getY() + ", Heading: " + memento.getHeading());
        }
        System.out.println("Total distance traveled: " + turtleDistance.getTotalDistance());
    }
}