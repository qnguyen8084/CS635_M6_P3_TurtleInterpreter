// Generated from C:/Users/quy92/OneDrive/Documents/SDSU/2024Fall/CS635/CS635_M6_P3_TurtleInterpreter/src/main/java/TurtleInterpreterEnhanced/Turtle.g4 by ANTLR 4.13.2
package TurtleInterpreterEnhanced.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TurtleParser}.
 */
public interface TurtleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TurtleParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TurtleParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TurtleParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(TurtleParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(TurtleParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#turtle}.
	 * @param ctx the parse tree
	 */
	void enterTurtle(TurtleParser.TurtleContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#turtle}.
	 * @param ctx the parse tree
	 */
	void exitTurtle(TurtleParser.TurtleContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#forward}.
	 * @param ctx the parse tree
	 */
	void enterForward(TurtleParser.ForwardContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#forward}.
	 * @param ctx the parse tree
	 */
	void exitForward(TurtleParser.ForwardContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#backward}.
	 * @param ctx the parse tree
	 */
	void enterBackward(TurtleParser.BackwardContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#backward}.
	 * @param ctx the parse tree
	 */
	void exitBackward(TurtleParser.BackwardContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#left}.
	 * @param ctx the parse tree
	 */
	void enterLeft(TurtleParser.LeftContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#left}.
	 * @param ctx the parse tree
	 */
	void exitLeft(TurtleParser.LeftContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#right}.
	 * @param ctx the parse tree
	 */
	void enterRight(TurtleParser.RightContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#right}.
	 * @param ctx the parse tree
	 */
	void exitRight(TurtleParser.RightContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#goto}.
	 * @param ctx the parse tree
	 */
	void enterGoto(TurtleParser.GotoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#goto}.
	 * @param ctx the parse tree
	 */
	void exitGoto(TurtleParser.GotoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TurtleParser#setHeading}.
	 * @param ctx the parse tree
	 */
	void enterSetHeading(TurtleParser.SetHeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link TurtleParser#setHeading}.
	 * @param ctx the parse tree
	 */
	void exitSetHeading(TurtleParser.SetHeadingContext ctx);
}