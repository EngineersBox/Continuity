package com.engineersbox.continuity.instrumenter.lang.transform;

import com.engineersbox.continuity.instrumenter.lang.transform.exception.ContinuityIntermediateBytecodeException;
import org.antlr.v4.runtime.ParserRuleContext;

public final aspect VisitorExceptionAspect {

    declare soft: Throwable: execution(* TransformVisitor.*(ParserRuleContext+));

    pointcut callVisit(final ParserRuleContext ctx):
            execution(* TransformVisitor.*(ParserRuleContext+)) && args(ctx);

    Object around(final ParserRuleContext ctx): callVisit(ctx){
        try {
            return proceed(ctx);
        } catch (final ContinuityIntermediateBytecodeException e) {
            throw e;
        } catch (final Throwable e) {
            throw new ContinuityIntermediateBytecodeException(
                    String.format(
                            "[%d:%d] %s",
                            ctx.getStart().getLine(),
                            ctx.getStart().getCharPositionInLine(),
                            e.getMessage()
                    ), e.getCause()
            );
        }
    }
}
