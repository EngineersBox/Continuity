// Generated from ContinuityParser.g4 by ANTLR 4.7.1

package com.engineersbox.continuity.instrumenter.lang.antlr;

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
	 * Enter a parse tree produced by the {@code functionStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionStatement(ContinuityParser.FunctionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionStatement(ContinuityParser.FunctionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invocationStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterInvocationStatement(ContinuityParser.InvocationStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code invocationStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitInvocationStatement(ContinuityParser.InvocationStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code contextLayoutStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContextLayoutStatement(ContinuityParser.ContextLayoutStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code contextLayoutStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContextLayoutStatement(ContinuityParser.ContextLayoutStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleContextLayoutDeclaration}
	 * labeled alternative in {@link ContinuityParser#contextLayout}.
	 * @param ctx the parse tree
	 */
	void enterSingleContextLayoutDeclaration(ContinuityParser.SingleContextLayoutDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleContextLayoutDeclaration}
	 * labeled alternative in {@link ContinuityParser#contextLayout}.
	 * @param ctx the parse tree
	 */
	void exitSingleContextLayoutDeclaration(ContinuityParser.SingleContextLayoutDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiContextLayoutDeclaration}
	 * labeled alternative in {@link ContinuityParser#contextLayout}.
	 * @param ctx the parse tree
	 */
	void enterMultiContextLayoutDeclaration(ContinuityParser.MultiContextLayoutDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiContextLayoutDeclaration}
	 * labeled alternative in {@link ContinuityParser#contextLayout}.
	 * @param ctx the parse tree
	 */
	void exitMultiContextLayoutDeclaration(ContinuityParser.MultiContextLayoutDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#contextEntries}.
	 * @param ctx the parse tree
	 */
	void enterContextEntries(ContinuityParser.ContextEntriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#contextEntries}.
	 * @param ctx the parse tree
	 */
	void exitContextEntries(ContinuityParser.ContextEntriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#contextEntryReference}.
	 * @param ctx the parse tree
	 */
	void enterContextEntryReference(ContinuityParser.ContextEntryReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#contextEntryReference}.
	 * @param ctx the parse tree
	 */
	void exitContextEntryReference(ContinuityParser.ContextEntryReferenceContext ctx);
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
	 * Enter a parse tree produced by {@link ContinuityParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ContinuityParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ContinuityParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(ContinuityParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(ContinuityParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 */
	void enterInvocation(ContinuityParser.InvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 */
	void exitInvocation(ContinuityParser.InvocationContext ctx);
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
	 * Enter a parse tree produced by the {@code literalParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void enterLiteralParam(ContinuityParser.LiteralParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void exitLiteralParam(ContinuityParser.LiteralParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code referenceParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void enterReferenceParam(ContinuityParser.ReferenceParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code referenceParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void exitReferenceParam(ContinuityParser.ReferenceParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code contextEntryReferenceParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void enterContextEntryReferenceParam(ContinuityParser.ContextEntryReferenceParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code contextEntryReferenceParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void exitContextEntryReferenceParam(ContinuityParser.ContextEntryReferenceParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invocationParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void enterInvocationParam(ContinuityParser.InvocationParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code invocationParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void exitInvocationParam(ContinuityParser.InvocationParamContext ctx);
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
	 * Enter a parse tree produced by the {@code IntegerLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(ContinuityParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(ContinuityParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatingPointLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointLiteral(ContinuityParser.FloatingPointLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatingPointLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointLiteral(ContinuityParser.FloatingPointLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(ContinuityParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(ContinuityParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharacterLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterCharacterLiteral(ContinuityParser.CharacterLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharacterLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitCharacterLiteral(ContinuityParser.CharacterLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(ContinuityParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(ContinuityParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NullLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(ContinuityParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NullLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(ContinuityParser.NullLiteralContext ctx);
}