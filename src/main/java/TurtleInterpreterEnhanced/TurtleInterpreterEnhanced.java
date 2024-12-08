/*
 * Quy Nguyen
 * Dr. Magda Tsintsadze
 * CS635
 * M6 P3 Turtle Interpreter
 * December 7, 2024
 * TurtleInterpreterEnhanced.java
 */

package TurtleInterpreterEnhanced;


import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import TurtleInterpreterEnhanced.generated.TurtleLexer;
import TurtleInterpreterEnhanced.generated.TurtleParser;

// This is the main class that is used to run the turtle program file. It uses the lexer and parser to create an AST
// and then uses the visitor classes to traverse the AST and execute the turtle program.
// Once the main function completes it displays the total distance traversed by the turtle as well as its net
// distance from the starting point.
public class TurtleInterpreterEnhanced {
    public static void main(String[] args) throws IOException {
        String fileName;
        if (args.length == 0) {
            fileName = "src/main/java/TurtleInterpreterEnhanced/turtleProgramFile.txt";
        } else {
            fileName = args[0];
        }
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromFileName(fileName));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext program = parser.program();

        System.out.println("This is the contents of the AST formed by the parser");
        System.out.println(program.toStringTree(parser));

        Turtle turtle = new MockTurtle(0, 0, 0); {
        }

        TurtleCommandVisitor commandVisitor = new TurtleCommandVisitor(turtle);
        TurtleMementoVisitor mementoVisitor = new TurtleMementoVisitor(turtle);
        TurtleDistanceVisitor distanceVisitor = new TurtleDistanceVisitor();

        commandVisitor.visit(program);
        mementoVisitor.visit(program);
        distanceVisitor.visit(program);

        List<String> commands = commandVisitor.getCommands();
        List<TurtleMemento> mementos = mementoVisitor.getMementos();
        List<Double> distances = distanceVisitor.getTotalDistances();

        System.out.println("This is the composite list of commands, mementos, and distances:");
        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);
            TurtleMemento memento = mementos.get(i);
            double distance = distances.get(i);
            System.out.println("Command: " + command + " | Memento - (" + memento.getX() + "," + memento.getY() + "," +
                    memento.getHeading() + ") | Distance: " + distance);
        }

        System.out.println("This is the total and net distance traveled by the turtle");
        System.out.println("Total distance traveled: " + distanceVisitor.getTotalDistance());
        System.out.println("Net distance traveled: " + mementoVisitor.getNetDistance());
    }
}