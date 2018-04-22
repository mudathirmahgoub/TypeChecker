// Generated from SystemF.g4 by ANTLR 4.7.1
package parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SystemFParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SystemFVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SystemFParser#systemF}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemF(SystemFParser.SystemFContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemFParser#subtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtype(SystemFParser.SubtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemFParser#judgment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJudgment(SystemFParser.JudgmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemFParser#typingContext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypingContext(SystemFParser.TypingContextContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemFParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SystemFParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SystemFParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(SystemFParser.TermContext ctx);
}