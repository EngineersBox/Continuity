parser grammar ContinuityParser;
@header {
package com.engineersbox.continuity.instrumenter.lang.antlr;
}

options {
    tokenVocab = ContinuityLexer;
}

parse: (statement SEMI)* EOF;

statement: function # functionStatement
    | invocation # invocationStatement
    | externalLayout # externalLayoutStatement
    | contextLayout # contextLayoutStatement
    | ifCondition # ifStatement
    | variableDeclaration # variableDeclarationStatement;

variableDeclaration: LET Identifier COLON variableType ASSIGN valueTarget;
variableType: CHAR
    | BOOL
    | INT8
    | INT16
    | INT32
    | INT64
    | FLOAT32
    | FLOAT64
    | STRING
    | OBJECT;
variableReference: LET DOT Identifier;

externalLayout: EXT reference # singleExternalLayoutDeclaration
    | EXT LBRACE externalEntries RBRACE # multiExternalLayoutDeclaration;
externalEntries: (reference SEMI)+;
externalEntryReference: EXT COLONCOLON Identifier;
externalEntryEnumConstantReference: externalEntryReference DOT Identifier;

contextLayout: CTX Identifier # singleContextLayoutDeclaration
    | CTX LBRACE contextEntries RBRACE # multiContextLayoutDeclaration;
contextEntries: (Identifier SEMI)+;
contextEntryReference: CTX COLONCOLON Identifier;

function: FN Identifier LPAREN RPAREN block;
block: LBRACE (statement SEMI)+ RBRACE;

invocation: STD COLONCOLON referenceTarget LPAREN params RPAREN # stdInvocation
    | FN DOT referenceTarget LPAREN RPAREN # functionInvocation
    | externalEntryReference ARROW methodInvocationChain # externalReferenceInvocation
    | contextEntryReference ARROW methodInvocationChain # contextReferenceInvocation
    | externalEntryEnumConstantReference ARROW referenceTarget LPAREN RPAREN # enumConstantMethodInvocationParam;
methodInvocationChain: methodInvocation (DOT methodInvocation)*;
methodInvocation: referenceTarget LPAREN params RPAREN;
params: (param ( COMMA param )* )?;
param: literal # literalParam
    | contextEntryReference # contextEntryReferenceParam
    | invocation # invocationParam
    | externalEntryEnumConstantReference # enumConstantReferenceParam
    | booleanExpresion # booleanExpressionParam
    | variableReference # variableReferenceParam;

reference: referenceChain? referenceTarget;
referenceTarget: Identifier;
referenceChain: (Identifier (DOT | DOLLAR))+;

booleanExpresion: LPAREN booleanExpresion RPAREN # parenBooleanExpression
    | BANG booleanExpresion # negationBooleanExpression
    | left=booleanExpresion comparator right=booleanExpresion # comparatorBooleanExpression
    | left=booleanExpresion comparisonJoin right=booleanExpresion # binaryBooleanExpression
    | valueTarget # targetBooleanExpression;
comparisonJoin: AND | OR | CARET;
comparator: GT | LT | LE | GE | EQUAL | NOTEQUAL;

valueTarget: externalEntryReference
    | contextEntryReference
    | invocation
    | literal
    | variableReference;

ifCondition: ifBranch elseIfBranch* elseBranch?;
ifBranch: IF booleanExpresion block;
elseIfBranch: ELSE ifBranch;
elseBranch: ELSE block;

literal: IntegerLiteral # IntegerLiteral
    | FloatingPointLiteral # FloatingPointLiteral
    | BooleanLiteral # BooleanLiteral
    | CharacterLiteral # CharacterLiteral
    | StringLiteral # StringLiteral
    | NullLiteral # NullLiteral ;
