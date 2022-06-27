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
    | contextLayout # contextLayoutStatement;

contextLayout: CTX Identifier # singleContextLayoutDeclaration
    | CTX LBRACE contextEntries RBRACE # multiContextLayoutDeclaration;
contextEntries: Identifier+;
contextEntryReference: CTX COLONCOLON Identifier;

function: FN Identifier LPAREN RPAREN block;
block: LBRACE statements RBRACE;
statements: (statement SEMI)+;

invocation: (STD COLONCOLON)? reference LPAREN params RPAREN;
params: (param ( COMMA param )* )?;
param: literal # literalParam
    | reference # referenceParam
    | contextEntryReference # contextEntryReferenceParam
    | invocation # invocationParam;

reference: referenceChain? referenceTarget;
referenceTarget: Identifier;
referenceChain: (Identifier DOT)+;

literal: IntegerLiteral # IntegerLiteral
    | FloatingPointLiteral # FloatingPointLiteral
    | BooleanLiteral # BooleanLiteral
    | CharacterLiteral # CharacterLiteral
    | StringLiteral # StringLiteral
    | NullLiteral # NullLiteral ;
