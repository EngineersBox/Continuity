package com.engineersbox.continuity.instrumenter.lang.transform;

import com.engineersbox.continuity.instrumenter.lang.antlr.ContinuityLexer;
import com.engineersbox.continuity.instrumenter.lang.antlr.ContinuityParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.objectweb.asm.tree.InsnList;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;

public class CIBTransformer {

    public static final String CIB_FILE_EXTENSION = ".cib";

    private final ContinuityParser.ParseContext parseTree;
    private final TransformListener listener;
    private final InsnList insnList;

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
        this.parseTree = parser.parse();
        this.insnList = new InsnList();
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
                "contArgVar", "test",
                "example", "test2"
        );
        final CIBTransformer transformer = new CIBTransformer("instrumenter/src/main/resources/example.cib");
        final InsnList result = transformer.transform(tc);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
