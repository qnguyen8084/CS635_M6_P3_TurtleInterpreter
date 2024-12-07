// Generated from C:/Users/quy92/OneDrive/Documents/SDSU/2024Fall/CS635/CS635_M6_P3_TurtleInterpreter/src/main/java/org/example/Turtle.g4 by ANTLR 4.13.2
package TurtleInterpreterEnhanced.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TurtleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TurtleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TurtleParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TurtleParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(TurtleParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#turtle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTurtle(TurtleParser.TurtleContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#forward}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForward(TurtleParser.ForwardContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#backward}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackward(TurtleParser.BackwardContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#left}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeft(TurtleParser.LeftContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#right}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRight(TurtleParser.RightContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#goto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoto(TurtleParser.GotoContext ctx);
	/**
	 * Visit a parse tree produced by {@link TurtleParser#setHeading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetHeading(TurtleParser.SetHeadingContext ctx);
}