package com.engineersbox.continuity.instrumenter.lang.transform;

import com.engineersbox.continuity.instrumenter.bytecode.InsnListCollector;
import com.engineersbox.continuity.instrumenter.lang.antlr.ContinuityParser;
import com.engineersbox.continuity.instrumenter.lang.antlr.ContinuityParserBaseVisitor;
import com.engineersbox.continuity.instrumenter.lang.transform.stdlib.BuilderResolver;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.tree.InsnList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class TransformVisitor extends ContinuityParserBaseVisitor<Object> {

    /* TODO: Convert Map<String, Object> to use Map<Pair<String, Boolean>, Object>
     *  so that the loaded state can be a flag, avoiding the use of two separate maps
     */
    private final Map<String, Object> translationContext;
    private final Map<String, Object> declaredContextLayoutVariables;
    private final Map<String, Object> declaredFunctions;
    private final Map<String, Class<?>> externalReferences;

    private final BuilderResolver builderResolver;

    public TransformVisitor(final Map<String, Object> translationContext) {
        this.translationContext = translationContext;
        this.declaredContextLayoutVariables = new HashMap<>();
        this.declaredFunctions = new HashMap<>();
        this.externalReferences = new HashMap<>();
        this.builderResolver = new BuilderResolver();
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
        final String reference = ctx.referenceTarget().Identifier().getText();
        final Object[] params = (Object[]) super.visit(ctx.params());
        return this.builderResolver.invokeStdlibMethod(reference, List.of(params));
    }

    @Override
    public Object visitFunctionInvocation(final ContinuityParser.FunctionInvocationContext ctx) {
        final String functionName = ctx.referenceTarget().Identifier().getText();
        final Object resolvedFunctionResult;
        if ((resolvedFunctionResult = this.declaredFunctions.get(functionName)) == null) {
            throw new IllegalStateException(String.format(
                    "Function \"%s\" referenced before declaration",
                    functionName
            ));
        } else if (resolvedFunctionResult instanceof InsnList insnList) {
            return insnList;
        }
        throw new IllegalStateException(String.format(
                "Expected resolved function \"%s\" to be %s, not %s",
                functionName,
                InsnList.class.getCanonicalName(),
                resolvedFunctionResult.getClass().getCanonicalName()
        ));
    }

    @Override
    public Object visitFunction(final ContinuityParser.FunctionContext ctx) {
        final String functionName = ctx.Identifier().getText();
        if (this.declaredFunctions.containsKey(functionName)) {
            throw new IllegalStateException(String.format(
                    "Function \"%s\" previously declared",
                    functionName
            ));
        }
        this.declaredFunctions.put(
                functionName,
                super.visit(ctx.block())
        );
        return new InsnList();
    }

    @Override
    public Object visitBlock(final ContinuityParser.BlockContext ctx) {
        return ctx.statement()
                .stream()
                .map(super::visit)
                .filter(Objects::nonNull) // TODO: Remove this after testing done
                .collect(InsnListCollector.toInsnList());
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
                    "Unable to load externally referenced class from path: %s",
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
                    "Referenced undeclared external class reference \"%s\". Load it with \"ext <path>.%s;\"",
                    target,
                    target
            ));
        }
        return externalClass;
    }

    private void validateMethodTargetAsInvokable(final ParserRuleContext ctx,
                                                 final Method targetMethod,
                                                 final Class<?> declaringClass) {
        final Class<?> returnType = targetMethod.getReturnType();
        /* If this is a statement, then the method must return InsnList,
         * otherwise it would have been invoked as a parameter which is
         * fine to pass any object value to.
         */
        if (ctx.getParent() instanceof ContinuityParser.StatementContext
                && !InsnList.class.isAssignableFrom(returnType)) {
            throw new IllegalStateException(String.format(
                    "Statement method invocations must return \"%s\". Returning \"%s\" in invocation of \"%s$%s\" is not valid.",
                    InsnList.class.getCanonicalName(),
                    returnType.getCanonicalName(),
                    declaringClass.getCanonicalName(),
                    targetMethod.getName()
            ));
        } else if (!Modifier.isStatic(targetMethod.getModifiers())) {
            throw new IllegalStateException(String.format(
                    "Cannot invoke non-static method \"%s$%s\"",
                    declaringClass.getCanonicalName(),
                    targetMethod.getName()
            ));
        }
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
                    "No such method exists for \"%s.%s(%s)\"",
                    externalClass.getCanonicalName(),
                    target,
                    Arrays.stream(params)
                            .map(Object::getClass)
                            .map(Class::getCanonicalName)
                            .collect(Collectors.joining(","))
            ), e);
        }
        validateMethodTargetAsInvokable(
                ctx,
                targetMethod,
                externalClass
        );
        try {
            return targetMethod.invoke(null, params);
        } catch (final InvocationTargetException | IllegalAccessException e) {
            throw new IllegalStateException(String.format(
                    "Unable to invoke method \"%s$%s\"",
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
                "Referenced undeclared context variable \"%s\". Variable is %spresent in translation context%s",
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
                this.translationContext.get(ctxVar)
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
        final StringBuilder referenceBuilder = new StringBuilder();
        final ContinuityParser.ReferenceChainContext referenceChainContext = ctx.referenceChain();
        if (referenceChainContext != null) {
            for (int i = 0; i < referenceChainContext.Identifier().size(); i++) {
                referenceBuilder.append(referenceChainContext.Identifier(i));
                referenceBuilder.append(referenceChainContext.DOT(i) != null ? '.' : '$');
            }
        }
        referenceBuilder.append(ctx.referenceTarget().Identifier().getText());
        return referenceBuilder.toString();
    }
    @SuppressWarnings("unchecked")
    @Override
    public Object visitExternalEntryEnumConstantReference(final ContinuityParser.ExternalEntryEnumConstantReferenceContext ctx) {
        super.visit(ctx.externalEntryReference());
        final String enumReference = ctx.externalEntryReference().Identifier().getText();
        final Class<?> referenceClass = this.externalReferences.get(enumReference);
        if (!referenceClass.isEnum()) {
            throw new IllegalStateException(String.format(
                    "Expected external enum reference to \"%s\" to be an enum",
                    referenceClass.getCanonicalName()
            ));
        }
        final Class<Enum<?>> enumClass = (Class<Enum<?>>) referenceClass;
        final Optional<Enum<?>> enumConstant = Arrays.stream(enumClass.getEnumConstants())
                .filter((final Enum<?> constant) -> constant.name().equals(ctx.Identifier().getText()))
                .findFirst();
        if (enumConstant.isEmpty()) {
            throw new IllegalStateException(String.format(
                    "No such constant \"%s\" could be found on enum \"%s\"",
                    ctx.Identifier().getText(),
                    enumClass.getCanonicalName()
            ));
        }
        return enumConstant.get();
    }

    @Override
    public Object visitEnumConstantMethodInvocationParam(final ContinuityParser.EnumConstantMethodInvocationParamContext ctx) {
        final Enum<?> enumConstant = (Enum<?>) super.visit(ctx.externalEntryEnumConstantReference());
        try {
            final Method method = enumConstant.getDeclaringClass()
                    .getMethod(ctx.referenceTarget().Identifier().getText());
            return method.invoke(enumConstant);
        } catch (final NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new IllegalStateException(String.format(
                    "Cannot invoke \"%s\" on enum constant \"%s.%s\"",
                    ctx.referenceTarget().Identifier().getText(),
                    enumConstant.getDeclaringClass().getCanonicalName(),
                    enumConstant.name()
            ));
        }
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
