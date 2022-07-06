lexer grammar ContinuityLexer;
@header {
package com.engineersbox.continuity.instrumenter.lang.antlr;

import com.engineersbox.continuity.instrumenter.lang.lexer.LexerBase;
}

options {
    superClass = LexerBase;
}

// Keywords
CTX: 'ctx';
EXT: 'ext';
FN: 'fn';
STD: 'std';
IF: 'if';
ELSE: 'else';

// Literals
IntegerLiteral: DecimalIntegerLiteral
    | HexIntegerLiteral
    | OctalIntegerLiteral
    | BinaryIntegerLiteral;

fragment DecimalIntegerLiteral: DecimalNumeral IntegerTypeSuffix?;
fragment HexIntegerLiteral: HexNumeral IntegerTypeSuffix?;
fragment OctalIntegerLiteral: OctalNumeral IntegerTypeSuffix?;
fragment BinaryIntegerLiteral: BinaryNumeral IntegerTypeSuffix?;
fragment IntegerTypeSuffix: [lL];
fragment DecimalNumeral: '0' | NonZeroDigit (Digits? | Underscores Digits);
fragment Digits: Digit (DigitsAndUnderscores? Digit)? ;
fragment Digit: '0' | NonZeroDigit;
fragment NonZeroDigit: [1-9];
fragment DigitsAndUnderscores: DigitOrUnderscore+;
fragment DigitOrUnderscore: Digit | '_';
fragment Underscores: '_'+;
fragment HexNumeral: '0' [xX] HexDigits;
fragment HexDigits: HexDigit (HexDigitsAndUnderscores? HexDigit)?;
fragment HexDigit: [0-9a-fA-F];
fragment HexDigitsAndUnderscores: HexDigitOrUnderscore+;
fragment HexDigitOrUnderscore : HexDigit | '_';
fragment OctalNumeral: '0' Underscores? OctalDigits;
fragment OctalDigits: OctalDigit (OctalDigitsAndUnderscores? OctalDigit)?;
fragment OctalDigit: [0-7];
fragment OctalDigitsAndUnderscores : OctalDigitOrUnderscore+;
fragment OctalDigitOrUnderscore: OctalDigit | '_';
fragment BinaryNumeral: '0' [bB] BinaryDigits;
fragment BinaryDigits: BinaryDigit (BinaryDigitsAndUnderscores? BinaryDigit)?;
fragment BinaryDigit: [01] ;
fragment BinaryDigitsAndUnderscores : BinaryDigitOrUnderscore+ ;
fragment BinaryDigitOrUnderscore : BinaryDigit | '_';

// Floating-Point Literals
FloatingPointLiteral : DecimalFloatingPointLiteral | HexadecimalFloatingPointLiteral;
fragment DecimalFloatingPointLiteral : Digits '.' Digits? ExponentPart? FloatTypeSuffix?
	| '.' Digits ExponentPart? FloatTypeSuffix?
	| Digits ExponentPart FloatTypeSuffix?
	| Digits FloatTypeSuffix;
fragment ExponentPart: ExponentIndicator SignedInteger;
fragment ExponentIndicator: [eE];
fragment SignedInteger: Sign? Digits;
fragment Sign: [+-];
fragment FloatTypeSuffix: [fFdD];
fragment HexadecimalFloatingPointLiteral: HexSignificand BinaryExponent FloatTypeSuffix?;
fragment HexSignificand: HexNumeral '.'? | '0' [xX] HexDigits? '.' HexDigits;
fragment BinaryExponent: BinaryExponentIndicator SignedInteger;
fragment BinaryExponentIndicator: [pP];

// Boolean Literals
BooleanLiteral : 'true' | 'false';

// Character Literals
CharacterLiteral: '\'' SingleCharacter '\'' | '\'' EscapeSequence '\'';

fragment SingleCharacter: ~['\\\r\n];
// String Literals
StringLiteral: '"' StringCharacters? '"';
fragment StringCharacters: StringCharacter+;
fragment StringCharacter : ~["\\\r\n] | EscapeSequence;
// Escape Sequences for Character and String Literals
fragment EscapeSequence:	'\\' [btnfr"'\\] | OctalEscape | UnicodeEscape; // This is not in the spec but prevents having to preprocess the input

fragment OctalEscape: '\\' OctalDigit
	| '\\' OctalDigit OctalDigit
	| '\\' ZeroToThree OctalDigit OctalDigit;

fragment ZeroToThree: [0-3];

// This is not in the spec but prevents having to preprocess the input
fragment UnicodeEscape: '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit;

// The Null Literal
NullLiteral: 'null';

// Separators
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
LBRACK: '[';
RBRACK: ']';
SEMI: ';';
DOT: '.';
DOLLAR: '$';
COMMA: ',';
ARROW: '->';

// Operators
ASSIGN: '=';
GT: '>';
LT: '<';
BANG: '!';
TILDE: '~';
QUESTION: '?';
COLON: ':';
COLONCOLON: '::';
EQUAL: '==';
LE: '<=';
GE: '>=';
NOTEQUAL: '!=';
AND: '&&';
OR: '||';
INC: '++';
DEC: '--';
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
BITAND: '&';
BITOR: '|';
CARET: '^';
MOD: '%';

// Identifiers (must appear after all keywords in the grammar)
Identifier:	Letter LetterOrDigit*;

fragment Letter: [a-zA-Z$_] // these are the "letters" below 0x7F
    // covers all characters above 0x7F which are not a surrogate
    | ~[\u0000-\u007F\uD800-\uDBFF] { checkSupportedSingletonCharacters() }?
    // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
    | [\uD800-\uDBFF] [\uDC00-\uDFFF] { checkSupportedSurrogatePairCharacters() }?;

fragment LetterOrDigit: [a-zA-Z0-9$_] // these are the "letters or digits" below 0x7F
    // covers all characters above 0x7F which are not a surrogate
    | ~[\u0000-\u007F\uD800-\uDBFF] { checkSupportedSingletonCharacters() }?
    // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
    | [\uD800-\uDBFF] [\uDC00-\uDFFF] { checkSupportedSurrogatePairCharacters() }?;

// Whitespace and comments
WS: [ \t\r\n\u000C]+ -> skip;
COMMENT: '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);
