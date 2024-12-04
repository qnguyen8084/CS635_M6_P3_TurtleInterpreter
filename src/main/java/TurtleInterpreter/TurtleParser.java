package TurtleInterpreter;

import java.util.ArrayList;
import java.util.List;

public class TurtleParser {
    private final List<String> tokens;
    private int pos = 0;

    public TurtleParser(List<String> tokens) {
        this.tokens = tokens;
    }

    public List<Command> parse() {
        List<Command> commands = new ArrayList<>();
        while (pos < tokens.size()) {
            String command = tokens.get(pos++);
            int value = Integer.parseInt(tokens.get(pos++));
            commands.add(new Command(command, value));
        }
        return commands;
    }

    public static class Command {
        public final String command;
        public final int value;

        public Command(String command, int value) {
            this.command = command;
            this.value = value;
        }
    }
}