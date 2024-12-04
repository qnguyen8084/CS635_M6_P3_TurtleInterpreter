package TurtleInterpreter;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "src/main/java/TurtleInterpreter/TurtleProgramTest.txt";
        TurtleLexer lexer = new TurtleLexer(fileName);
        List<String> tokens = lexer.tokenize();
        TurtleParser parser = new TurtleParser(tokens);
        List<TurtleParser.Command> commands = parser.parse();
        TurtleInterpreter interpreter = new TurtleInterpreter();
        interpreter.interpret(commands);
    }
}