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
    | contextLayout # contextLayoutStatement;

externalLayout: EXT reference # singleExternalLayoutDeclaration
    | EXT LBRACE externalEntries RBRACE # multiExternalLayoutDeclaration;
externalEntries: (reference SEMI)+;
externalEntryReference: EXT COLONCOLON Identifier;

contextLayout: CTX Identifier # singleContextLayoutDeclaration
    | CTX LBRACE contextEntries RBRACE # multiContextLayoutDeclaration;
contextEntries: (Identifier SEMI)+;
contextEntryReference: CTX COLONCOLON Identifier;

function: FN Identifier LPAREN RPAREN block;
block: LBRACE statements RBRACE;
statements: (statement SEMI)+;

invocation: STD COLONCOLON reference LPAREN params RPAREN # stdInvocation
    | FN COLONCOLON referenceTarget LPAREN RPAREN # functionInvocation
    | reference LPAREN params RPAREN # externalDirectInvocation
    | externalEntryReference DOT referenceTarget LPAREN params RPAREN # externalReferenceInvocation;
params: (param ( COMMA param )* )?;
param: literal # literalParam
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
