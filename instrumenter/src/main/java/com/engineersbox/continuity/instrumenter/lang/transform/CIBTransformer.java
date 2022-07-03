package com.engineersbox.continuity.instrumenter.lang.transform;

import com.engineersbox.continuity.instrumenter.lang.antlr.ContinuityLexer;
import com.engineersbox.continuity.instrumenter.lang.antlr.ContinuityParser;
import com.engineersbox.continuity.instrumenter.lang.transform.listener.CIBErrorListener;
import com.engineersbox.continuity.instrumenter.lang.transform.listener.TransformListener;
import com.engineersbox.continuity.instrumenter.lang.transform.visitor.TransformVisitor;
import com.engineersbox.continuity.instrumenter.stack.storage.VariableLUT;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.InsnList;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class CIBTransformer {

    public static final String CIB_FILE_EXTENSION = ".cib";

    private final ContinuityParser.ParseContext parseTree;
    private final TransformListener listener;

    private CIBTransformer(final String sourcePath) {
        verifySourcePath(sourcePath);
        final ContinuityLexer lexer;
        try {
            lexer = new ContinuityLexer(CharStreams.fromPath(Path.of(sourcePath)));
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format(
                    "Unable to load source file from \"%s\"",
                    sourcePath
            ), e);
        }
        final ContinuityParser parser = new ContinuityParser((new CommonTokenStream(lexer)));
        this.listener = new TransformListener();
        parser.addParseListener(this.listener);
        parser.addErrorListener(new CIBErrorListener());
        parser.addErrorListener(new DiagnosticErrorListener(false));
        this.parseTree = parser.parse();
    }

    private void verifySourcePath(final String path) {
        if (path == null) {
            throw new IllegalArgumentException("A path must be set to a source file");
        } else if (!path.endsWith(CIB_FILE_EXTENSION)) {
            throw new IllegalArgumentException(String.format(
                    "Source path should point to file with %s extension",
                    CIB_FILE_EXTENSION
            ));
        }
    }

    public InsnList transform(final Map<String, Object> translationContext) {
        final TransformVisitor visitor = new TransformVisitor(translationContext);
        return (InsnList) visitor.visit(this.parseTree);
    }

    public static void main(String[] args) {
        final Map<String, Object> tc = Map.of(
                "contArgVar", new VariableLUT.Variable(
                        Type.getType(String.class),
                        0,
                        true
                ), "example", new AtomicReference<>("Continuation$getState")
        );
        final CIBTransformer transformer = new CIBTransformer("instrumenter/src/main/resources/calltest.cib");
        final InsnList result = transformer.transform(tc);
        System.out.println(Arrays.toString(result.toArray()));
    }

}
