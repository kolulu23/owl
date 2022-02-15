package cn.tongdun.owl.executor;

import cn.tongdun.owl.context.OwlContext;
import cn.tongdun.owl.context.OwlDSLContext;
import cn.tongdun.owl.generated.OwlLexer;
import cn.tongdun.owl.generated.OwlParser;
import cn.tongdun.owl.parse.OwlEvalVisitor;
import cn.tongdun.owl.parse.OwlSyntaxErrorListener;
import cn.tongdun.owl.parse.OwlVariableListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author liutianlu
 * <br/>Created 2022/2/15 6:16 PM
 */
public class OwlDSLExecutor implements OwlExecutor {

    private final OwlSyntaxErrorListener owlSyntaxErrorListener;

    private final OwlVariableListener owlVariableListener;

    private final OwlEvalVisitor owlEvalVisitor;

    public OwlDSLExecutor() {
        OwlContext owlContext = new OwlDSLContext();
        this.owlSyntaxErrorListener = new OwlSyntaxErrorListener();
        this.owlVariableListener = new OwlVariableListener(owlContext);
        this.owlEvalVisitor = new OwlEvalVisitor(owlContext);
    }

    public OwlDSLExecutor(OwlContext owlContext) {
        this.owlSyntaxErrorListener = new OwlSyntaxErrorListener();
        this.owlVariableListener = new OwlVariableListener(owlContext);
        this.owlEvalVisitor = new OwlEvalVisitor(owlContext);
    }

    @Override
    public Object execute(InputStream inputStream, Charset charset) {
        // TODO Fetch parseTree from cache
        ParseTree parseTree = compile(inputStream, charset);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this.owlVariableListener, parseTree);
        return this.owlEvalVisitor.visit(parseTree);
    }

    @Override
    public ParseTree compile(InputStream inputStream, Charset charset) {
        OwlParser parser = null;
        try {
            OwlLexer lexer = new OwlLexer(CharStreams.fromStream(inputStream, charset));
            TokenStream tokenStream = new CommonTokenStream(lexer);
            parser = new OwlParser(tokenStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert parser != null;
        parser.addErrorListener(this.owlSyntaxErrorListener);
        return parser.prog();
    }
}
