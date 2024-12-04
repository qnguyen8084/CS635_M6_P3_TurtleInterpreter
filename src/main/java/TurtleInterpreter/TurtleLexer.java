package TurtleInterpreter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TurtleLexer {
    private final String input;
    private int pos = 0;

    public TurtleLexer(String fileName) throws IOException {
        input = new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public List<String> tokenize() {
        List<String> tokens = new ArrayList<>();
        while (pos < input.length()) {
            char currentChar = input.charAt(pos);
            if (Character.isWhitespace(currentChar)) {
                pos++;
            } else if (Character.isDigit(currentChar)) {
                tokens.add(readNumber());
            } else {
                tokens.add(readCommand());
            }
        }
        return tokens;
    }

    private String readNumber() {
        StringBuilder number = new StringBuilder();
        while (pos < input.length() && Character.isDigit(input.charAt(pos))) {
            number.append(input.charAt(pos++));
        }
        return number.toString();
    }

    private String readCommand() {
        StringBuilder command = new StringBuilder();
        while (pos < input.length() && Character.isLetter(input.charAt(pos))) {
            command.append(input.charAt(pos++));
        }
        return command.toString();
    }
}