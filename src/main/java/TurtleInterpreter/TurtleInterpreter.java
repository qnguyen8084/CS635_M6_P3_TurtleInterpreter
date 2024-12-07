package TurtleInterpreter;

import java.util.List;

public class TurtleInterpreter {
    private double x = 0, y = 0;
    private double heading = 0;

    public void interpret(List<TurtleParser.Command> commands) {
        for (TurtleParser.Command command : commands) {
            switch (command.command) {
                case "fd":
                    forward(command.value);
                    break;
                case "bk":
                    backward(command.value);
                    break;
                case "tr":
                    turnRight(command.value);
                    break;
                case "tl":
                    turnLeft(command.value);
                    break;
            }
        }
    }

    private void forward(int distance) {
        x += distance * Math.cos(Math.toRadians(heading));
        y += distance * Math.sin(Math.toRadians(heading));
        System.out.println("Moved forward " + distance + " to (" + x + ", " + y + ")");
    }

    private void backward(int distance) {
        x -= distance * Math.cos(Math.toRadians(heading));
        y -= distance * Math.sin(Math.toRadians(heading));
        System.out.println("Moved backward " + distance + " to (" + x + ", " + y + ")");
    }

    private void turnRight(int degrees) {
        heading = (heading + degrees) % 360;
        System.out.println("Turned right " + degrees + " degrees to " + heading);
    }

    private void turnLeft(int degrees) {
        heading = (heading - degrees + 360) % 360;
        System.out.println("Turned left " + degrees + " degrees to " + heading);
    }
}