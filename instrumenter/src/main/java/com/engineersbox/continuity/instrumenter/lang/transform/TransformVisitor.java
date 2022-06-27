package com.engineersbox.continuity.instrumenter.lang.transform;

import com.engineersbox.continuity.instrumenter.bytecode.InsnListCollector;
import com.engineersbox.continuity.instrumenter.lang.antlr.ContinuityParser;
import com.engineersbox.continuity.instrumenter.lang.antlr.ContinuityParserBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.tree.InsnList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TransformVisitor extends ContinuityParserBaseVisitor<Object> {

    /* TODO: Convert Map<String, Object> to use Map<Pair<String, Boolean>, Object>
     *  so that the loaded state can be a flag, avoiding the use of two separate maps
     */
    private final Map<String, Object> translationContext;
    private final Map<String, Object> declaredContextLayoutVariables;
    private final Map<String, Object> declaredFunctions;
    private final Map<String, Class<?>> externalReferences;

    public TransformVisitor(final Map<String, Object> translationContext) {
        this.translationContext = translationContext;
        this.declaredContextLayoutVariables = new HashMap<>();
        this.declaredFunctions = new HashMap<>();
        this.externalReferences = new HashMap<>();
    }

    private String getLineColumn(final ParserRuleContext ctx) {
        return String.format(
                "%d:%d",
                ctx.getStart().getLine(),
                ctx.getStart().getCharPositionInLine()
        );
    }

    @Override
    public Object visitParse(final ContinuityParser.ParseContext ctx) {
        return ctx.statement()
                .stream()
                .map(super::visit)
                .filter(Objects::nonNull) // TODO: Remove this after testing done
                .collect(InsnListCollector.toInsnList());
    }

    @Override
    public Object visitFunctionStatement(final ContinuityParser.FunctionStatementContext ctx) {
        return super.visit(ctx.function());
    }

    @Override
    public Object visitInvocationStatement(final ContinuityParser.InvocationStatementContext ctx) {
        return super.visit(ctx.invocation());
    }

    @Override
    public Object visitStdInvocation(final ContinuityParser.StdInvocationContext ctx) {
        final String reference = referenceContextToString(ctx.reference());
        return new InsnList();
    }

    private void checkFunctionDeclared(final String functionName) {
        if (!this.declaredFunctions.containsKey(functionName)) {
            throw new IllegalStateException(String.format(
                    "Function \"%s\" referenced before declaration",
                    functionName
            ));
        }
    }

    @Override
    public Object visitFunctionInvocation(final ContinuityParser.FunctionInvocationContext ctx) {
        checkFunctionDeclared(ctx.referenceTarget().Identifier().getText());
        return new InsnList();
    }

    @Override
    public Object visitExternalDirectInvocation(final ContinuityParser.ExternalDirectInvocationContext ctx) {
        return new InsnList();
    }

    @Override
    public Object visitExternalLayoutStatement(final ContinuityParser.ExternalLayoutStatementContext ctx) {
        return super.visit(ctx.externalLayout());
    }

    private Class<?> loadExternalReferenceClass(final ParserRuleContext ctx,
                                                final String classPath) {
        try {
            return Class.forName(classPath);
        } catch (final ClassNotFoundException e) {
            throw new IllegalStateException(String.format(
                    "[%s] Unable to load externally referenced class from path: %s",
                    getLineColumn(ctx),
                    classPath
            ), e);
        }
    }

    private void checkedLoadExternalReference(final ParserRuleContext ctx,
                                              final ContinuityParser.ReferenceContext referenceCtx) {
        final String reference = referenceContextToString(referenceCtx);
        final String target = referenceCtx.referenceTarget().Identifier().getText();
        final Class<?> previouslyLoadedClass = this.externalReferences.get(target);
        if (previouslyLoadedClass != null) {
            throw new IllegalStateException(String.format(
                    "External reference to class \"%s\" already exists",
                    previouslyLoadedClass.getCanonicalName()
            ));
        }
        this.externalReferences.put(
                target,
                loadExternalReferenceClass(ctx, reference)
        );
    }

    @Override
    public Object visitSingleExternalLayoutDeclaration(final ContinuityParser.SingleExternalLayoutDeclarationContext ctx) {
        checkedLoadExternalReference(ctx, ctx.reference());
        return new InsnList();
    }

    @Override
    public Object visitMultiExternalLayoutDeclaration(final ContinuityParser.MultiExternalLayoutDeclarationContext ctx) {
        ctx.externalEntries()
                .reference()
                .forEach((final ContinuityParser.ReferenceContext referenceCtx) -> checkedLoadExternalReference(ctx, referenceCtx));
        return new InsnList();
    }

    @Override
    public Object visitExternalEntryReference(final ContinuityParser.ExternalEntryReferenceContext ctx) {
        final String target = ctx.Identifier().getText();
        final Class<?> externalClass = this.externalReferences.get(target);
        if (externalClass == null) {
            throw new IllegalStateException(String.format(
                    "[%s] Referenced undeclared external class reference \"%s\". Load it with \"ext <path>.%s;\"",
                    getLineColumn(ctx),
                    target,
                    target
            ));
        }
        return externalClass;
    }


    @Override
    public Object visitExternalReferenceInvocation(final ContinuityParser.ExternalReferenceInvocationContext ctx) {
        final Class<?> externalClass = (Class<?>) super.visit(ctx.externalEntryReference());
        final String target = ctx.referenceTarget().Identifier().getText();
        final Object[] params = (Object[]) super.visit(ctx.params());
        final Method targetMethod;
        try {
            targetMethod = externalClass.getMethod(
                    target,
                    Arrays.stream(params)
                            .map(Object::getClass)
                            .toArray(Class[]::new)
            );

        } catch (final NoSuchMethodException e) {
            throw new IllegalStateException(String.format(
                    "[%s] No such method exists for \"%s.%s(%s)\"",
                    getLineColumn(ctx),
                    externalClass.getCanonicalName(),
                    target,
                    Arrays.stream(params)
                            .map(Object::getClass)
                            .map(Class::getCanonicalName)
                            .collect(Collectors.joining(","))
            ), e);
        }
        if (!Modifier.isStatic(targetMethod.getModifiers())) {
            throw new IllegalStateException(String.format(
                    "[%s] Cannot invoke non-static method \"%s$%s\"",
                    getLineColumn(ctx),
                    externalClass.getCanonicalName(),
                    target
            ));
        }
        try {
            return targetMethod.invoke(null, params);
        } catch (final InvocationTargetException | IllegalAccessException e) {
            throw new IllegalStateException(String.format(
                    "[%s] Unable to invoke method \"%s$%s\"",
                    getLineColumn(ctx),
                    externalClass.getCanonicalName(),
                    target
            ), e);
        }
    }

    @Override
    public Object visitParams(final ContinuityParser.ParamsContext ctx) {
        return ctx.param()
                .stream()
                .map(super::visit)
                .toArray(Object[]::new);
    }

    @Override
    public Object visitLiteralParam(final ContinuityParser.LiteralParamContext ctx) {
        return super.visit(ctx.literal());
    }

    @Override
    public Object visitContextEntryReferenceParam(final ContinuityParser.ContextEntryReferenceParamContext ctx) {
        return super.visit(ctx.contextEntryReference());
    }

    @Override
    public Object visitInvocationParam(final ContinuityParser.InvocationParamContext ctx) {
        return super.visit(ctx.invocation());
    }

    @Override
    public Object visitContextLayoutStatement(final ContinuityParser.ContextLayoutStatementContext ctx) {
        return super.visit(ctx.contextLayout());
    }

    private void checkTranslationContextEntryPresent(final String ctxVar) {
        if (!this.translationContext.containsKey(ctxVar)) {
            throw new IllegalStateException(String.format(
                    "Unknown context variable: %s",
                    ctxVar
            ));
        }
    }

    private void checkLoadedContextEntryPresent(final ParserRuleContext ctx,
                                                final String ctxVar) {
        if (this.declaredContextLayoutVariables.containsKey(ctxVar)) {
            return;
        }
        throw new IllegalStateException(String.format(
                "[%s] Referenced undeclared context variable \"%s\". Variable is %spresent in translation context%s",
                getLineColumn(ctx),
                ctxVar,
                this.translationContext.containsKey(ctxVar) ? "" : "not ",
                !this.translationContext.containsKey(ctxVar) ? "" : String.format(
                        ", load it with \"ctx %s;\"",
                        ctxVar
                )
        ));
    }

    private void registerDeclaredContextEntry(final String ctxVar) {
        this.declaredContextLayoutVariables.put(
                ctxVar,
                this.translationContext.containsKey(ctxVar)
        );
    }

    @Override
    public Object visitSingleContextLayoutDeclaration(final ContinuityParser.SingleContextLayoutDeclarationContext ctx) {
        final String ctxVar = ctx.Identifier().getText();
        checkTranslationContextEntryPresent(ctxVar);
        registerDeclaredContextEntry(ctxVar);
        return new InsnList();
    }

    @Override
    public Object visitMultiContextLayoutDeclaration(final ContinuityParser.MultiContextLayoutDeclarationContext ctx) {
        return super.visit(ctx.contextEntries());
    }

    @Override
    public Object visitContextEntries(final ContinuityParser.ContextEntriesContext ctx) {
        ctx.Identifier()
                .stream()
                .map(TerminalNode::getText)
                .peek(this::checkTranslationContextEntryPresent)
                .forEach(this::registerDeclaredContextEntry);
        return new InsnList();
    }

    @Override
    public Object visitContextEntryReference(final ContinuityParser.ContextEntryReferenceContext ctx) {
        final String ctxVar = ctx.Identifier().getText();
        checkLoadedContextEntryPresent(ctx, ctxVar);
        return this.declaredContextLayoutVariables.get(ctxVar);
    }

    private String referenceContextToString(final ContinuityParser.ReferenceContext ctx) {
        String prefix = null;
        final ContinuityParser.ReferenceChainContext referenceChainContext = ctx.referenceChain();
        if (referenceChainContext != null) {
            prefix = referenceChainContext.Identifier()
                    .stream()
                    .map(TerminalNode::getText)
                    .collect(Collectors.joining("."));
        }
        return prefix == null ? ctx.referenceTarget().Identifier().getText() : String.format(
                "%s.%s",
                prefix,
                ctx.referenceTarget().Identifier().getText()
        );
    }

    @Override
    public Object visitIntegerLiteral(final ContinuityParser.IntegerLiteralContext ctx) {
        return Integer.parseInt(ctx.IntegerLiteral().getText());
    }

    @Override
    public Object visitFloatingPointLiteral(final ContinuityParser.FloatingPointLiteralContext ctx) {
        return Float.parseFloat(ctx.FloatingPointLiteral().getText());
    }

    @Override
    public Object visitBooleanLiteral(final ContinuityParser.BooleanLiteralContext ctx) {
        return Boolean.parseBoolean(ctx.BooleanLiteral().getText());
    }

    @Override
    public Object visitCharacterLiteral(final ContinuityParser.CharacterLiteralContext ctx) {
        return ctx.CharacterLiteral().getText().charAt(1);
    }

    @Override
    public Object visitStringLiteral(final ContinuityParser.StringLiteralContext ctx) {
        return StringUtils.strip(ctx.StringLiteral().getText(), "\"");
    }

    @Override
    public Object visitNullLiteral(final ContinuityParser.NullLiteralContext ignored) {
        return null;
    }
}
