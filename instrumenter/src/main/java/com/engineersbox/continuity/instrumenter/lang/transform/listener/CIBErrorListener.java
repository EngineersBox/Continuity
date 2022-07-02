package com.engineersbox.continuity.instrumenter.lang.transform.listener;

import com.engineersbox.continuity.instrumenter.lang.transform.exception.CIBSyntaxError;
import org.antlr.v4.runtime.*;

public class CIBErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(final Recognizer<?, ?> recognizer,
                            final Object offendingSymbol,
                            final int line,
                            final int column,
                            final String message,
                            final RecognitionException e) {
        throw new CIBSyntaxError(String.format(
                "Line %d:%d %s",
                line, column,
                message
        ), e);
    }

}
