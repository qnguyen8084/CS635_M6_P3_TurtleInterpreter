package TurtleInterpreterEnhanced;

import TurtleInterpreterEnhanced.generated.TurtleLexer;
import TurtleInterpreterEnhanced.generated.TurtleParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TurtleDistanceVisitorTest {

    private Turtle turtle;
    private TurtleDistanceVisitor distanceVisitor;

    @BeforeEach
    void setUp() {
        distanceVisitor = new TurtleDistanceVisitor();
    }

    @Test
    void getTotalDistance() {
        String program = "forward 10\nbackward 5\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        distanceVisitor.visit(programContext);

        assertEquals(15, distanceVisitor.getTotalDistance());
    }

    @Test
    void getTotalDistances() {
        String program = "forward 10\nbackward 5\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        distanceVisitor.visit(programContext);

        assertEquals(List.of(10.0, 15.0), distanceVisitor.getTotalDistances());
    }

    @Test
    void visitForward() {
        String program = "forward 10\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        distanceVisitor.visit(programContext);

        assertEquals(10, distanceVisitor.getTotalDistance());
    }

    @Test
    void visitBackward() {
        String program = "backward 5\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        distanceVisitor.visit(programContext);

        assertEquals(5, distanceVisitor.getTotalDistance());
    }

    @Test
    void visitGoto() {
        String program = "goto 10 20\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        distanceVisitor.visit(programContext);

        assertEquals(Math.hypot(10, 20), distanceVisitor.getTotalDistance());
    }

    @Test
    void visitSetHeading() {
        String program = "setHeading 90\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        distanceVisitor.visit(programContext);

        assertEquals(0, distanceVisitor.getTotalDistance());
    }

    @Test
    void visitLeft() {
        String program = "left 90\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        distanceVisitor.visit(programContext);

        assertEquals(0, distanceVisitor.getTotalDistance());
    }

    @Test
    void visitRight() {
        String program = "right 90\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        distanceVisitor.visit(programContext);

        assertEquals(0, distanceVisitor.getTotalDistance());
    }

    @Test
    void visitTurtle() {
        String program = "turtle 0 0 0\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        distanceVisitor.visit(programContext);

        assertEquals(0, distanceVisitor.getTotalDistance());
    }
}