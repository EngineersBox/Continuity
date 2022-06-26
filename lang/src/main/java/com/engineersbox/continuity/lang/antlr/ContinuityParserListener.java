// Generated from ContinuityParser.g4 by ANTLR 4.7.1

package com.engineersbox.continuity.lang.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ContinuityParser}.
 */
public interface ContinuityParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(ContinuityParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(ContinuityParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ContinuityParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ContinuityParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#inputDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInputDeclaration(ContinuityParser.InputDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#inputDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInputDeclaration(ContinuityParser.InputDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#inputReference}.
	 * @param ctx the parse tree
	 */
	void enterInputReference(ContinuityParser.InputReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#inputReference}.
	 * @param ctx the parse tree
	 */
	void exitInputReference(ContinuityParser.InputReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#inputReferenceTarget}.
	 * @param ctx the parse tree
	 */
	void enterInputReferenceTarget(ContinuityParser.InputReferenceTargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#inputReferenceTarget}.
	 * @param ctx the parse tree
	 */
	void exitInputReferenceTarget(ContinuityParser.InputReferenceTargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(ContinuityParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(ContinuityParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(ContinuityParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(ContinuityParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(ContinuityParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(ContinuityParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(ContinuityParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(ContinuityParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#referenceTarget}.
	 * @param ctx the parse tree
	 */
	void enterReferenceTarget(ContinuityParser.ReferenceTargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#referenceTarget}.
	 * @param ctx the parse tree
	 */
	void exitReferenceTarget(ContinuityParser.ReferenceTargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#referenceChain}.
	 * @param ctx the parse tree
	 */
	void enterReferenceChain(ContinuityParser.ReferenceChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#referenceChain}.
	 * @param ctx the parse tree
	 */
	void exitReferenceChain(ContinuityParser.ReferenceChainContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ContinuityParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ContinuityParser.LiteralContext ctx);
}