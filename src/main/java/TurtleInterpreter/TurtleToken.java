package TurtleInterpreter;

public class TurtleToken {
    static final int NUMBER = 0;
    static final int FORWARD = 1;
    static final int BACKWARD = 2;
    static final int TURN_LEFT = 3;
    static final int TURN_RIGHT = 4;

    int turtleTokenId;
    String string;
    int intValue;

    public TurtleToken(String s) {
        string = s;
        if (s.equals("fd")) {
            turtleTokenId = FORWARD;
        } else if (s.equals("bk")) {
            turtleTokenId = BACKWARD;
        } else if (s.equals("tl")) {
            turtleTokenId = TURN_LEFT;
        } else if (s.equals("tr")) {
            turtleTokenId = TURN_RIGHT;
        } else try {
            intValue = Integer.parseInt(s.trim());
            turtleTokenId = NUMBER;
        } catch (NumberFormatException e) {
            System.out.println("Invalid token: " + s);
        }
    }

    static String name(int turtleTokenId) {
        return switch (turtleTokenId) {
            case NUMBER -> "NUMBER";
            case FORWARD -> "FORWARD";
            case BACKWARD -> "BACKWARD";
            case TURN_LEFT -> "TURN_LEFT";
            case TURN_RIGHT -> "TURN_RIGHT";
            default -> "Invalid token";
        };
    }
}


