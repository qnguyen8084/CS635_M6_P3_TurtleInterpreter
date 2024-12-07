package org.example;


import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.example.generated.TurtleLexer;
import org.example.generated.TurtleParser;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World!");
        String fileName = "src/main/java/org/example/turtleProgramFile.txt";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromFileName(fileName));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext program = parser.program();
//        System.out.println(program.toStringTree(parser));
        TurtleInterpreter interpreter = new TurtleInterpreter();
        TurtleInterpreterDistance interpreterDistance = new TurtleInterpreterDistance();
        interpreter.visit(program);

        List<TurtleMemento> mementos = interpreter.getMementos();
        for (TurtleMemento memento : mementos) {
            System.out.println("Memento - X: " + memento.x() + ", Y: " + memento.y() + ", Heading: " + memento.heading());
        }

        interpreterDistance.visit(program);

    }
}