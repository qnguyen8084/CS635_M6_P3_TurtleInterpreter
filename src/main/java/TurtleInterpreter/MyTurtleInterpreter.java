/*
 * Quy Nguyen
 * Dr. Magda Tsintsadze
 * CS635
 * M6 P3 Turtle Interpreter
 * December 7, 2024
 * MyTurtleInterpreter.java
 */

package TurtleInterpreter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyTurtleInterpreter {
    public static void main(String[] args) throws IOException {
        String fileName = "src/main/java/TurtleInterpreter/TurtleProgramTest.txt";
        TurtleLexerInt lexer = new TurtleLexer(fileName);
        List<String> tokens = lexer.tokenize();
        TurtleParser parser = new TurtleParser(tokens);
        List<ASTNode> program = parser.parse();
        Turtle turtle = new Turtle();
        TurtleInterpreter interpreter = new TurtleInterpreter(turtle);
        List<TurtleMemento> mementos = new ArrayList<>();
        TurtleDistanceVisitor turtleDistance = new TurtleDistanceVisitor();

        for (ASTNode command : program) {
            TurtleMemento memento = command.accept(interpreter);
            mementos.add(memento);
            command.accept(turtleDistance);
        }

        for (TurtleMemento memento : mementos) {
            System.out.println("Memento - X: " + memento.x() + ", Y: " + memento.y() + ", Heading: " + memento.heading());
        }

        System.out.println("Total distance traveled: " + turtleDistance.getTotalDistance());
    }
}