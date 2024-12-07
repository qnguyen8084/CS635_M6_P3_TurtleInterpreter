package org.example;


import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.example.generated.TurtleLexer;
import org.example.generated.TurtleParser;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName;
        if (args.length == 0) {
            fileName = "src/main/java/org/example/turtleProgramFile.txt";
        } else {
            fileName = args[0];
        }
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromFileName(fileName));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext program = parser.program();

        System.out.println("This is the contents of the AST formed by the parser");
        System.out.println(program.toStringTree(parser));

        TurtleCommandVisitor commandVisitor = new TurtleCommandVisitor();
        TurtleMementoVisitor mementoVisitor = new TurtleMementoVisitor();
        TurtleDistanceVisitor distanceVisitor = new TurtleDistanceVisitor();

        commandVisitor.visit(program);
        mementoVisitor.visit(program);
        distanceVisitor.visit(program);

        System.out.println("This is the commands that the turtle executed");
        List<String> commands = commandVisitor.getCommands();
        for (String command : commands) {
            System.out.println(command);
        }

        System.out.println("This is the mementos of the turtle's state after each command");
        List<TurtleMemento> mementos = mementoVisitor.getMementos();
        for (TurtleMemento memento : mementos) {
            System.out.println("Memento - ("+ memento.x() + "," + memento.y() + "," + memento.heading() + ")");
        }

        System.out.println("This is the composite list of commands and mementos:");
        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);
            TurtleMemento memento = mementos.get(i);
            System.out.println("Command: " + command + " | Memento - (" + memento.x() + "," + memento.y() + "," + memento.heading() + ")");
        }

        List<Double> distances = distanceVisitor.getTotalDistances();

        System.out.println("This is the composite list of commands, mementos, and distances:");
        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);
            TurtleMemento memento = mementos.get(i);
            double distance = distances.get(i);
            System.out.println("Command: " + command + " | Memento - (" + memento.x() + "," + memento.y() + "," +
                    memento.heading() + ") | Distance: " + distance);
        }

        System.out.println("This is the total and net distance traveled by the turtle");
        System.out.println("Total distance traveled: " + distanceVisitor.getTotalDistance());
        System.out.println("Net distance traveled: " + mementoVisitor.getNetDistance());
    }
}