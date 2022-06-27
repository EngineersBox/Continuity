package com.engineersbox.continuity.instrumenter.lang.lexer;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;

public abstract class LexerBase extends Lexer {
    public LexerBase(final CharStream input) {
        super(input);
    }

    /**
     * Covers all characters above 0x7F which are not a surrogate
     */
    public boolean checkSupportedSingletonCharacters() {
        return Character.isJavaIdentifierStart(_input.LA(-1));
    }

    /**
     * Covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
     */
    public boolean checkSupportedSurrogatePairCharacters() {
        return Character.isJavaIdentifierStart(Character.toCodePoint(
                (char) _input.LA(-2),
                (char) _input.LA(-1)
        ));
    }
}
