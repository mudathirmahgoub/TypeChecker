// Generated from SystemF.g4 by ANTLR 4.7.1
package parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SystemFParser}.
 */
public interface SystemFListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SystemFParser#systemF}.
	 * @param ctx the parse tree
	 */
	void enterSystemF(SystemFParser.SystemFContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemFParser#systemF}.
	 * @param ctx the parse tree
	 */
	void exitSystemF(SystemFParser.SystemFContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemFParser#subtype}.
	 * @param ctx the parse tree
	 */
	void enterSubtype(SystemFParser.SubtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemFParser#subtype}.
	 * @param ctx the parse tree
	 */
	void exitSubtype(SystemFParser.SubtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemFParser#judgment}.
	 * @param ctx the parse tree
	 */
	void enterJudgment(SystemFParser.JudgmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemFParser#judgment}.
	 * @param ctx the parse tree
	 */
	void exitJudgment(SystemFParser.JudgmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemFParser#typingContext}.
	 * @param ctx the parse tree
	 */
	void enterTypingContext(SystemFParser.TypingContextContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemFParser#typingContext}.
	 * @param ctx the parse tree
	 */
	void exitTypingContext(SystemFParser.TypingContextContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemFParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SystemFParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemFParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SystemFParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SystemFParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(SystemFParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SystemFParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(SystemFParser.TermContext ctx);
}