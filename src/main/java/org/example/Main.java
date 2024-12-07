package org.example;


import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.example.generated.TurtleLexer;
import org.example.generated.TurtleParser;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "src/main/java/org/example/turtleProgramFile.txt";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromFileName(fileName));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext program = parser.program();

        System.out.println("This is the contents of the AST formed by the parser");
        System.out.println(program.toStringTree(parser));
        TurtleMementoVisitor interpreter = new TurtleMementoVisitor();
        TurtleDistanceVisitor distanceVisitor = new TurtleDistanceVisitor();

        interpreter.visit(program);
        distanceVisitor.visit(program);

        System.out.println("This is the mementos of the turtle's state after each command");
        List<TurtleMemento> mementos = interpreter.getMementos();
        for (TurtleMemento memento : mementos) {
            System.out.println("Memento - ("+ memento.x() + "," + memento.y() + "," + memento.heading() + ")");
        }

        System.out.println("This is the total and net distance traveled by the turtle");
        System.out.println("Total distance traveled: " + distanceVisitor.getTotalDistance());
        System.out.println("Net distance traveled: " + interpreter.getNetDistance());
    }
}