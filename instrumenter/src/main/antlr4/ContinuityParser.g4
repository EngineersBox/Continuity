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
    | externalEntryEnumConstantReference # enumConstantReferenceParam;

reference: referenceChain? referenceTarget;
referenceTarget: Identifier;
referenceChain: (Identifier (DOT | DOLLAR))+;

literal: IntegerLiteral # IntegerLiteral
    | FloatingPointLiteral # FloatingPointLiteral
    | BooleanLiteral # BooleanLiteral
    | CharacterLiteral # CharacterLiteral
    | StringLiteral # StringLiteral
    | NullLiteral # NullLiteral ;
