package TurtleInterpreterEnhanced;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import TurtleInterpreterEnhanced.generated.TurtleLexer;
import TurtleInterpreterEnhanced.generated.TurtleParser;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TurtleCommandVisitorTest {

    private MockTurtle mockTurtle;
    private TurtleCommandVisitor commandVisitor;

    @BeforeEach
    void setUp() {
        mockTurtle = new MockTurtle(0, 0, 0);
        commandVisitor = new TurtleCommandVisitor(mockTurtle);
    }

    @Test
    void visitTurtle() throws IOException {
        String program = "turtle 0 0 0\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        MockTurtle mockTurtle = new MockTurtle(0, 0, 0);
        TurtleCommandVisitor commandVisitor = new TurtleCommandVisitor(mockTurtle);

        commandVisitor.visit(programContext);

        assertEquals(0, mockTurtle.getX());
        assertEquals(0, mockTurtle.getY());
        assertEquals(0, mockTurtle.getHeading());
    }

    @Test
    void visitForward() throws IOException {
        String program = "forward 10\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        commandVisitor.visit(programContext);

        assertEquals(10, mockTurtle.getX());
        assertEquals(0, mockTurtle.getY());
    }

    @Test
    void visitBackward() throws IOException {
        String program = "backward 10\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        commandVisitor.visit(programContext);

        assertEquals(-10, mockTurtle.getX());
        assertEquals(0, mockTurtle.getY());
    }

    @Test
    void visitLeft() throws IOException {
        String program = "left 90\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        commandVisitor.visit(programContext);

        assertEquals(90, mockTurtle.getHeading());
    }

    @Test
    void visitRight() throws IOException {
        String program = "right 90\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        commandVisitor.visit(programContext);

        assertEquals(270, mockTurtle.getHeading());
    }

    @Test
    void visitGoto() throws IOException {
        String program = "goto 10 20\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        commandVisitor.visit(programContext);

        assertEquals(10, mockTurtle.getX());
        assertEquals(20, mockTurtle.getY());
    }

    @Test
    void visitSetHeading() throws IOException {
        String program = "setHeading 180\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        commandVisitor.visit(programContext);

        assertEquals(180, mockTurtle.getHeading());
    }

    @Test
    void getCommands() throws IOException {
        String program = "forward 10\nright 90\nforward 10\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        commandVisitor.visit(programContext);

        assertEquals(3, commandVisitor.getCommands().size());
        assertEquals("Forward 10", commandVisitor.getCommands().get(0));
        assertEquals("Right 90", commandVisitor.getCommands().get(1));
        assertEquals("Forward 10", commandVisitor.getCommands().get(2));
    }
}