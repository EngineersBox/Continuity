// Generated from ContinuityParser.g4 by ANTLR 4.7.1

package com.engineersbox.continuity.instrumenter.lang.antlr;

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
	 * Visit a parse tree produced by the {@code functionStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionStatement(ContinuityParser.FunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code invocationStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvocationStatement(ContinuityParser.InvocationStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code externalLayoutStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalLayoutStatement(ContinuityParser.ExternalLayoutStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code contextLayoutStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextLayoutStatement(ContinuityParser.ContextLayoutStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(ContinuityParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleExternalLayoutDeclaration}
	 * labeled alternative in {@link ContinuityParser#externalLayout}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleExternalLayoutDeclaration(ContinuityParser.SingleExternalLayoutDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiExternalLayoutDeclaration}
	 * labeled alternative in {@link ContinuityParser#externalLayout}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiExternalLayoutDeclaration(ContinuityParser.MultiExternalLayoutDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#externalEntries}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalEntries(ContinuityParser.ExternalEntriesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#externalEntryReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalEntryReference(ContinuityParser.ExternalEntryReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#externalEntryEnumConstantReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalEntryEnumConstantReference(ContinuityParser.ExternalEntryEnumConstantReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleContextLayoutDeclaration}
	 * labeled alternative in {@link ContinuityParser#contextLayout}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleContextLayoutDeclaration(ContinuityParser.SingleContextLayoutDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiContextLayoutDeclaration}
	 * labeled alternative in {@link ContinuityParser#contextLayout}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiContextLayoutDeclaration(ContinuityParser.MultiContextLayoutDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#contextEntries}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextEntries(ContinuityParser.ContextEntriesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#contextEntryReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextEntryReference(ContinuityParser.ContextEntryReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(ContinuityParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ContinuityParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stdInvocation}
	 * labeled alternative in {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStdInvocation(ContinuityParser.StdInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionInvocation}
	 * labeled alternative in {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionInvocation(ContinuityParser.FunctionInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code externalReferenceInvocation}
	 * labeled alternative in {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalReferenceInvocation(ContinuityParser.ExternalReferenceInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code contextReferenceInvocation}
	 * labeled alternative in {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextReferenceInvocation(ContinuityParser.ContextReferenceInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enumConstantMethodInvocationParam}
	 * labeled alternative in {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantMethodInvocationParam(ContinuityParser.EnumConstantMethodInvocationParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#methodInvocationChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocationChain(ContinuityParser.MethodInvocationChainContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation(ContinuityParser.MethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(ContinuityParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralParam(ContinuityParser.LiteralParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code contextEntryReferenceParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextEntryReferenceParam(ContinuityParser.ContextEntryReferenceParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code invocationParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvocationParam(ContinuityParser.InvocationParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enumConstantReferenceParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantReferenceParam(ContinuityParser.EnumConstantReferenceParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExpressionParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpressionParam(ContinuityParser.BooleanExpressionParamContext ctx);
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
	 * Visit a parse tree produced by the {@code comparatorBooleanExpression}
	 * labeled alternative in {@link ContinuityParser#booleanExpresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparatorBooleanExpression(ContinuityParser.ComparatorBooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenBooleanExpression}
	 * labeled alternative in {@link ContinuityParser#booleanExpresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenBooleanExpression(ContinuityParser.ParenBooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryBooleanExpression}
	 * labeled alternative in {@link ContinuityParser#booleanExpresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryBooleanExpression(ContinuityParser.BinaryBooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negationBooleanExpression}
	 * labeled alternative in {@link ContinuityParser#booleanExpresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationBooleanExpression(ContinuityParser.NegationBooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code targetBooleanExpression}
	 * labeled alternative in {@link ContinuityParser#booleanExpresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetBooleanExpression(ContinuityParser.TargetBooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#comparisonJoin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonJoin(ContinuityParser.ComparisonJoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(ContinuityParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#comparisonTarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonTarget(ContinuityParser.ComparisonTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#ifCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCondition(ContinuityParser.IfConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#ifBranch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBranch(ContinuityParser.IfBranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#elseIfBranch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfBranch(ContinuityParser.ElseIfBranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link ContinuityParser#elseBranch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBranch(ContinuityParser.ElseBranchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(ContinuityParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatingPointLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointLiteral(ContinuityParser.FloatingPointLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(ContinuityParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharacterLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterLiteral(ContinuityParser.CharacterLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(ContinuityParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NullLiteral}
	 * labeled alternative in {@link ContinuityParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(ContinuityParser.NullLiteralContext ctx);
}