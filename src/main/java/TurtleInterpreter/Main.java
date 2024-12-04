package TurtleInterpreter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String TURTLE_PROGRAM_FILE = "src/main/java/TurtleInterpreter/TurtleProgramTest.txt";
        TurtleProgramParser turtleProgramParser = new TurtleProgramParser(TURTLE_PROGRAM_FILE);
    }
}