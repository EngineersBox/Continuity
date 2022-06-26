parser grammar ContinuityParser;
@header {
package com.engineersbox.continuity.lang.antlr;
}

options {
    tokenVocab = ContinuityLexer;
}

parse: (statement SEMI)* EOF;

statement: function | inputDeclaration;

inputDeclaration: IN_PARAM Identifier;
inputReference: IN_PARAM COLONCOLON inputReferenceTarget;
inputReferenceTarget: reference;

function: reference LPAREN params RPAREN;
params: (param ( COMMA param )* )?;
param: literal | reference | inputReference | function;

reference: referenceChain? referenceTarget;
referenceTarget: Identifier;
referenceChain: (Identifier DOT)+;

literal: IntegerLiteral
    | FloatingPointLiteral
    | BooleanLiteral
    | CharacterLiteral
    | StringLiteral
    | NullLiteral;
