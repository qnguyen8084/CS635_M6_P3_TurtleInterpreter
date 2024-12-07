package TurtleInterpreter;

import java.util.ArrayList;
import java.util.List;

public class TurtleParser {
    private final List<String> tokens;
    private int pos = 0;

    public TurtleParser(List<String> tokens) {
        this.tokens = tokens;
    }

    public List<ASTNode> parse() {
        List<ASTNode> commands = new ArrayList<>();
        while (pos < tokens.size()) {
            String command = tokens.get(pos++);
            int value = Integer.parseInt(tokens.get(pos++));
            switch (command) {
                case "fd":
                    commands.add(new ForwardNode(value));
                    break;
                case "bk":
                    commands.add(new BackwardNode(value));
                    break;
                case "tr":
                    commands.add(new TurnRightNode(value));
                    break;
                case "tl":
                    commands.add(new TurnLeftNode(value));
                    break;
            }
        }
        return commands;
    }
}