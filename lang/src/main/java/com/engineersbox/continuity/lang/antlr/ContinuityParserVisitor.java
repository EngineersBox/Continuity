// Generated from ContinuityParser.g4 by ANTLR 4.7.1

package com.engineersbox.continuity.lang.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ContinuityParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ContinuityParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(ContinuityParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ContinuityParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#inputDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputDeclaration(ContinuityParser.InputDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#inputReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputReference(ContinuityParser.InputReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#inputReferenceTarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputReferenceTarget(ContinuityParser.InputReferenceTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(ContinuityParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(ContinuityParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(ContinuityParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(ContinuityParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#referenceTarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceTarget(ContinuityParser.ReferenceTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#referenceChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceChain(ContinuityParser.ReferenceChainContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(ContinuityParser.LiteralContext ctx);
}