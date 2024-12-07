package TurtleInterpreter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// This it the lexer class that reads the input file or turtle program and tokenizes it
public class TurtleLexer implements TurtleLexerInt {
    private final String input;
    private int pos = 0;

    // Constructor that reads the input file
    public TurtleLexer(String fileName) throws IOException {
        input = new String(Files.readAllBytes(Paths.get(fileName)));
    }

    // Tokenizes the input file. It reads the input file character by character and tokenizes it
    // based on the characters it reads. It returns a list of tokens.
    // If first character is a letter, it reads the command and adds it to the list of tokens.
    // If first character is a digit, it reads the number and adds it to the list of tokens.
    @Override
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

    // Reads the number from the input file
    private String readNumber() {
        StringBuilder number = new StringBuilder();
        while (pos < input.length() && Character.isDigit(input.charAt(pos))) {
            number.append(input.charAt(pos++));
        }
        return number.toString();
    }

    // Reads the command from the input file
    private String readCommand() {
        StringBuilder command = new StringBuilder();
        while (pos < input.length() && Character.isLetter(input.charAt(pos))) {
            command.append(input.charAt(pos++));
        }
        return command.toString();
    }
}