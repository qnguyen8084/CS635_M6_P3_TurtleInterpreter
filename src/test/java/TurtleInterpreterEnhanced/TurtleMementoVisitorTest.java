package TurtleInterpreterEnhanced;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import TurtleInterpreterEnhanced.generated.TurtleLexer;
import TurtleInterpreterEnhanced.generated.TurtleParser;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TurtleMementoVisitorTest {

    private Turtle turtle;
    private TurtleMementoVisitor mementoVisitor;

    @BeforeEach
    void setUp() {
        turtle = new MockTurtle(0, 0, 0);
        mementoVisitor = new TurtleMementoVisitor(turtle);
    }

    @Test
    void visitTurtleInitializesState() throws IOException {
        String program = "turtle 10 20 90\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        mementoVisitor.visit(programContext);

        assertEquals(10, mementoVisitor.getMementos().get(0).getX());
        assertEquals(20, mementoVisitor.getMementos().get(0).getY());
        assertEquals(90, mementoVisitor.getMementos().get(0).getHeading());
    }

    @Test
    void visitForwardUpdatesPosition() throws IOException {
        String program = "turtle 0 0 0\nforward 10\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        mementoVisitor.visit(programContext);

        assertEquals(10, mementoVisitor.getMementos().get(1).getX());
        assertEquals(0, mementoVisitor.getMementos().get(1).getY());
    }

    @Test
    void visitBackwardUpdatesPosition() throws IOException {
        String program = "turtle 10 0 0\nbackward 10\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        mementoVisitor.visit(programContext);

        assertEquals(0, mementoVisitor.getMementos().get(1).getX());
        assertEquals(0, mementoVisitor.getMementos().get(1).getY());
    }

    @Test
    void visitLeftUpdatesHeading() throws IOException {
        String program = "turtle 0 0 0\nleft 90\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        mementoVisitor.visit(programContext);

        assertEquals(90, mementoVisitor.getMementos().get(1).getHeading());
    }

    @Test
    void visitRightUpdatesHeading() throws IOException {
        String program = "turtle 0 0 90\nright 90\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        mementoVisitor.visit(programContext);

        assertEquals(0, mementoVisitor.getMementos().get(1).getHeading());
    }

    @Test
    void visitGotoUpdatesPosition() throws IOException {
        String program = "goto 10 20\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        mementoVisitor.visit(programContext);

        assertEquals(10, mementoVisitor.getMementos().get(0).getX());
        assertEquals(20, mementoVisitor.getMementos().get(0).getY());
    }

    @Test
    void visitSetHeadingUpdatesHeading() throws IOException {
        String program = "setHeading 180\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        mementoVisitor.visit(programContext);

        assertEquals(180, mementoVisitor.getMementos().get(0).getHeading());
    }

    @Test
    void getNetDistanceCalculatesCorrectly() throws IOException {
        String program = "turtle 0 0 0\nforward 3\nright 90\nforward 4\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        mementoVisitor.visit(programContext);

        assertEquals(5.0, mementoVisitor.getNetDistance());
    }
    @Test
    void visitForwardWithNegativeDistance() throws IOException {
        String program = "turtle 0 0 0\nforward -10\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        mementoVisitor.visit(programContext);

        assertEquals(-10, mementoVisitor.getMementos().get(1).getX());
        assertEquals(0, mementoVisitor.getMementos().get(1).getY());
    }

    @Test
    void visitBackwardWithNegativeDistance() throws IOException {
        String program = "turtle 0 0 0\nbackward -10\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        mementoVisitor.visit(programContext);

        assertEquals(10, mementoVisitor.getMementos().get(1).getX());
        assertEquals(0, mementoVisitor.getMementos().get(1).getY());
    }

    @Test
    void visitSetHeadingWithNegativeValue() throws IOException {
        String program = "turtle 0 0 0\nsetHeading -90\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        mementoVisitor.visit(programContext);

        assertEquals(270, mementoVisitor.getMementos().get(1).getHeading());
    }

    @Test
    void visitSetHeadingWithLargeValue() throws IOException {
        String program = "turtle 0 0 0\nsetHeading 450\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        mementoVisitor.visit(programContext);

        assertEquals(90, mementoVisitor.getMementos().get(1).getHeading());
    }

    @Test
    void visitGotoWithNegativeCoordinates() throws IOException {
        String program = "goto -10 -20\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        mementoVisitor.visit(programContext);

        assertEquals(-10, mementoVisitor.getMementos().get(0).getX());
        assertEquals(-20, mementoVisitor.getMementos().get(0).getY());
    }

    @Test
    void visitLeftWithNegativeDegrees() throws IOException {
        String program = "turtle 0 0 0\nleft -90\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        mementoVisitor.visit(programContext);

        assertEquals(270, mementoVisitor.getMementos().get(1).getHeading());
    }

    @Test
    void visitRightWithNegativeDegrees() throws IOException {
        String program = "turtle 0 0 0\nright -90\n";
        TurtleLexer lexer = new TurtleLexer(CharStreams.fromString(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TurtleParser parser = new TurtleParser(tokens);
        TurtleParser.ProgramContext programContext = parser.program();

        mementoVisitor.visit(programContext);

        assertEquals(90, mementoVisitor.getMementos().get(1).getHeading());
    }
}