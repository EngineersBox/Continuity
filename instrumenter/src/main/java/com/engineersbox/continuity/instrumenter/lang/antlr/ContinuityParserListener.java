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
	 * Enter a parse tree produced by the {@code externalLayoutStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExternalLayoutStatement(ContinuityParser.ExternalLayoutStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code externalLayoutStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExternalLayoutStatement(ContinuityParser.ExternalLayoutStatementContext ctx);
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
	 * Enter a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(ContinuityParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(ContinuityParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableDeclarationStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationStatement(ContinuityParser.VariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableDeclarationStatement}
	 * labeled alternative in {@link ContinuityParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationStatement(ContinuityParser.VariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(ContinuityParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(ContinuityParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#variableType}.
	 * @param ctx the parse tree
	 */
	void enterVariableType(ContinuityParser.VariableTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#variableType}.
	 * @param ctx the parse tree
	 */
	void exitVariableType(ContinuityParser.VariableTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(ContinuityParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(ContinuityParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(ContinuityParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(ContinuityParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#variableReference}.
	 * @param ctx the parse tree
	 */
	void enterVariableReference(ContinuityParser.VariableReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#variableReference}.
	 * @param ctx the parse tree
	 */
	void exitVariableReference(ContinuityParser.VariableReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#arrayIndexer}.
	 * @param ctx the parse tree
	 */
	void enterArrayIndexer(ContinuityParser.ArrayIndexerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#arrayIndexer}.
	 * @param ctx the parse tree
	 */
	void exitArrayIndexer(ContinuityParser.ArrayIndexerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleExternalLayoutDeclaration}
	 * labeled alternative in {@link ContinuityParser#externalLayout}.
	 * @param ctx the parse tree
	 */
	void enterSingleExternalLayoutDeclaration(ContinuityParser.SingleExternalLayoutDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleExternalLayoutDeclaration}
	 * labeled alternative in {@link ContinuityParser#externalLayout}.
	 * @param ctx the parse tree
	 */
	void exitSingleExternalLayoutDeclaration(ContinuityParser.SingleExternalLayoutDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiExternalLayoutDeclaration}
	 * labeled alternative in {@link ContinuityParser#externalLayout}.
	 * @param ctx the parse tree
	 */
	void enterMultiExternalLayoutDeclaration(ContinuityParser.MultiExternalLayoutDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiExternalLayoutDeclaration}
	 * labeled alternative in {@link ContinuityParser#externalLayout}.
	 * @param ctx the parse tree
	 */
	void exitMultiExternalLayoutDeclaration(ContinuityParser.MultiExternalLayoutDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#externalEntries}.
	 * @param ctx the parse tree
	 */
	void enterExternalEntries(ContinuityParser.ExternalEntriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#externalEntries}.
	 * @param ctx the parse tree
	 */
	void exitExternalEntries(ContinuityParser.ExternalEntriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#externalEntryReference}.
	 * @param ctx the parse tree
	 */
	void enterExternalEntryReference(ContinuityParser.ExternalEntryReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#externalEntryReference}.
	 * @param ctx the parse tree
	 */
	void exitExternalEntryReference(ContinuityParser.ExternalEntryReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#externalEntryEnumConstantReference}.
	 * @param ctx the parse tree
	 */
	void enterExternalEntryEnumConstantReference(ContinuityParser.ExternalEntryEnumConstantReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#externalEntryEnumConstantReference}.
	 * @param ctx the parse tree
	 */
	void exitExternalEntryEnumConstantReference(ContinuityParser.ExternalEntryEnumConstantReferenceContext ctx);
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
	 * Enter a parse tree produced by the {@code stdInvocation}
	 * labeled alternative in {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 */
	void enterStdInvocation(ContinuityParser.StdInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stdInvocation}
	 * labeled alternative in {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 */
	void exitStdInvocation(ContinuityParser.StdInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionInvocation}
	 * labeled alternative in {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 */
	void enterFunctionInvocation(ContinuityParser.FunctionInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionInvocation}
	 * labeled alternative in {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 */
	void exitFunctionInvocation(ContinuityParser.FunctionInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code externalReferenceInvocation}
	 * labeled alternative in {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 */
	void enterExternalReferenceInvocation(ContinuityParser.ExternalReferenceInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code externalReferenceInvocation}
	 * labeled alternative in {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 */
	void exitExternalReferenceInvocation(ContinuityParser.ExternalReferenceInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code contextReferenceInvocation}
	 * labeled alternative in {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 */
	void enterContextReferenceInvocation(ContinuityParser.ContextReferenceInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code contextReferenceInvocation}
	 * labeled alternative in {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 */
	void exitContextReferenceInvocation(ContinuityParser.ContextReferenceInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code enumConstantMethodInvocationParam}
	 * labeled alternative in {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantMethodInvocationParam(ContinuityParser.EnumConstantMethodInvocationParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code enumConstantMethodInvocationParam}
	 * labeled alternative in {@link ContinuityParser#invocation}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantMethodInvocationParam(ContinuityParser.EnumConstantMethodInvocationParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#methodInvocationChain}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocationChain(ContinuityParser.MethodInvocationChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#methodInvocationChain}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocationChain(ContinuityParser.MethodInvocationChainContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation(ContinuityParser.MethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation(ContinuityParser.MethodInvocationContext ctx);
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
	 * Enter a parse tree produced by the {@code enumConstantReferenceParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantReferenceParam(ContinuityParser.EnumConstantReferenceParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code enumConstantReferenceParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantReferenceParam(ContinuityParser.EnumConstantReferenceParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanExpressionParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpressionParam(ContinuityParser.BooleanExpressionParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanExpressionParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpressionParam(ContinuityParser.BooleanExpressionParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableReferenceParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void enterVariableReferenceParam(ContinuityParser.VariableReferenceParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableReferenceParam}
	 * labeled alternative in {@link ContinuityParser#param}.
	 * @param ctx the parse tree
	 */
	void exitVariableReferenceParam(ContinuityParser.VariableReferenceParamContext ctx);
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
	 * Enter a parse tree produced by the {@code comparatorBooleanExpression}
	 * labeled alternative in {@link ContinuityParser#booleanExpresion}.
	 * @param ctx the parse tree
	 */
	void enterComparatorBooleanExpression(ContinuityParser.ComparatorBooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparatorBooleanExpression}
	 * labeled alternative in {@link ContinuityParser#booleanExpresion}.
	 * @param ctx the parse tree
	 */
	void exitComparatorBooleanExpression(ContinuityParser.ComparatorBooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenBooleanExpression}
	 * labeled alternative in {@link ContinuityParser#booleanExpresion}.
	 * @param ctx the parse tree
	 */
	void enterParenBooleanExpression(ContinuityParser.ParenBooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenBooleanExpression}
	 * labeled alternative in {@link ContinuityParser#booleanExpresion}.
	 * @param ctx the parse tree
	 */
	void exitParenBooleanExpression(ContinuityParser.ParenBooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryBooleanExpression}
	 * labeled alternative in {@link ContinuityParser#booleanExpresion}.
	 * @param ctx the parse tree
	 */
	void enterBinaryBooleanExpression(ContinuityParser.BinaryBooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryBooleanExpression}
	 * labeled alternative in {@link ContinuityParser#booleanExpresion}.
	 * @param ctx the parse tree
	 */
	void exitBinaryBooleanExpression(ContinuityParser.BinaryBooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negationBooleanExpression}
	 * labeled alternative in {@link ContinuityParser#booleanExpresion}.
	 * @param ctx the parse tree
	 */
	void enterNegationBooleanExpression(ContinuityParser.NegationBooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negationBooleanExpression}
	 * labeled alternative in {@link ContinuityParser#booleanExpresion}.
	 * @param ctx the parse tree
	 */
	void exitNegationBooleanExpression(ContinuityParser.NegationBooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code targetBooleanExpression}
	 * labeled alternative in {@link ContinuityParser#booleanExpresion}.
	 * @param ctx the parse tree
	 */
	void enterTargetBooleanExpression(ContinuityParser.TargetBooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code targetBooleanExpression}
	 * labeled alternative in {@link ContinuityParser#booleanExpresion}.
	 * @param ctx the parse tree
	 */
	void exitTargetBooleanExpression(ContinuityParser.TargetBooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#comparisonJoin}.
	 * @param ctx the parse tree
	 */
	void enterComparisonJoin(ContinuityParser.ComparisonJoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#comparisonJoin}.
	 * @param ctx the parse tree
	 */
	void exitComparisonJoin(ContinuityParser.ComparisonJoinContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(ContinuityParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(ContinuityParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#valueTarget}.
	 * @param ctx the parse tree
	 */
	void enterValueTarget(ContinuityParser.ValueTargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#valueTarget}.
	 * @param ctx the parse tree
	 */
	void exitValueTarget(ContinuityParser.ValueTargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void enterIfCondition(ContinuityParser.IfConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#ifCondition}.
	 * @param ctx the parse tree
	 */
	void exitIfCondition(ContinuityParser.IfConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#ifBranch}.
	 * @param ctx the parse tree
	 */
	void enterIfBranch(ContinuityParser.IfBranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#ifBranch}.
	 * @param ctx the parse tree
	 */
	void exitIfBranch(ContinuityParser.IfBranchContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#elseIfBranch}.
	 * @param ctx the parse tree
	 */
	void enterElseIfBranch(ContinuityParser.ElseIfBranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#elseIfBranch}.
	 * @param ctx the parse tree
	 */
	void exitElseIfBranch(ContinuityParser.ElseIfBranchContext ctx);
	/**
	 * Enter a parse tree produced by {@link ContinuityParser#elseBranch}.
	 * @param ctx the parse tree
	 */
	void enterElseBranch(ContinuityParser.ElseBranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link ContinuityParser#elseBranch}.
	 * @param ctx the parse tree
	 */
	void exitElseBranch(ContinuityParser.ElseBranchContext ctx);
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