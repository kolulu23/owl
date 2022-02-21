package cn.tongdun.owl.executor;

import cn.tongdun.owl.context.OwlContext;
import cn.tongdun.owl.context.OwlDSLContext;
import cn.tongdun.owl.error.OwlDSLExecutionErrorFactory;
import cn.tongdun.owl.error.OwlExecutionError;
import cn.tongdun.owl.generated.OwlLexer;
import cn.tongdun.owl.generated.OwlParser;
import cn.tongdun.owl.parse.OwlEvalVisitor;
import cn.tongdun.owl.parse.OwlSyntaxErrorListener;
import cn.tongdun.owl.parse.OwlVariableListener;
import cn.tongdun.owl.type.OwlVariable;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liutianlu
 * <br/>Created 2022/2/15 6:16 PM
 */
public class OwlDSLExecutor implements OwlExecutor {

    private final OwlSyntaxErrorListener owlSyntaxErrorListener;

    private final OwlVariableListener owlVariableListener;

    private final OwlEvalVisitor owlEvalVisitor;

    private OwlContext owlContext;

    public OwlDSLExecutor() {
        owlContext = new OwlDSLContext();
        this.owlSyntaxErrorListener = new OwlSyntaxErrorListener();
        this.owlVariableListener = new OwlVariableListener(owlContext);
        this.owlEvalVisitor = new OwlEvalVisitor(owlContext);
    }

    public OwlDSLExecutor(OwlContext owlContext) {
        this.owlContext = owlContext;
        this.owlSyntaxErrorListener = new OwlSyntaxErrorListener();
        this.owlVariableListener = new OwlVariableListener(this.owlContext);
        this.owlEvalVisitor = new OwlEvalVisitor(this.owlContext);
    }

    public OwlDSLExecutor(OwlSyntaxErrorListener owlSyntaxErrorListener,
                          OwlVariableListener owlVariableListener,
                          OwlEvalVisitor owlEvalVisitor,
                          OwlExecutionCache<String, ParseTree> parseTreeCache) {
        this.owlSyntaxErrorListener = owlSyntaxErrorListener;
        this.owlVariableListener = owlVariableListener;
        this.owlEvalVisitor = owlEvalVisitor;
    }

    @Override
    public OwlDSLExecutionResult execute(OwlExecutionUnit executionUnit, Charset charset) {
        OwlDSLExecutionResult result = new OwlDSLExecutionResult();
        result.setSuccess(false);
        ParseTree parseTree = compile(executionUnit, charset);
        if (parseTree == null) {
            OwlExecutionError executionError = OwlDSLExecutionErrorFactory.compileFailed(executionUnit.getName());
            List<OwlExecutionError> errorList = new ArrayList<>();
            errorList.add(executionError);
            result.setErrorList(errorList);
            return result;
        }
        if (this.owlContext.listAllSyntaxErrors().isEmpty()) {
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(this.owlVariableListener, parseTree);
            OwlVariable variable = this.owlEvalVisitor.visit(parseTree);
            if (this.owlContext.listAllSemanticErrors().isEmpty()) {
                result.setSuccess(true);
                result.setResult(variable);
            } else {
                result.setErrorList(new ArrayList<>(this.owlContext.listAllSemanticErrors()));
            }
        } else {
            result.setErrorList(new ArrayList<>(this.owlContext.listAllSemanticErrors()));
        }
        resetState();
        return result;
    }

    @Override
    public ParseTree compile(OwlExecutionUnit executionUnit, Charset charset) {
        InputStream source = executionUnit.getSource();
        OwlParser parser;
        try {
            OwlLexer lexer = new OwlLexer(CharStreams.fromStream(source, charset));
            TokenStream tokenStream = new CommonTokenStream(lexer);
            parser = new OwlParser(tokenStream);
        } catch (Exception e) {
            return null;
        }
        parser.removeErrorListeners();
        parser.addErrorListener(this.owlSyntaxErrorListener);
        return parser.prog();
    }

    @Override
    public void resetState() {
        this.owlContext.reset();
    }

    /**
     * Execution directly from a ParseTree and a fresh OwlContext.
     * If parseTree is non-null, there's no syntax error to handle.
     *
     * @param parseTree  Parse tree
     * @param owlContext A new context for evaluate
     * @param unitName   Execution unit name
     * @return execution result
     */
    public OwlDSLExecutionResult executeFromParseTree(ParseTree parseTree, OwlContext owlContext, String unitName) {
        this.setOwlContext(owlContext);
        OwlDSLExecutionResult result = new OwlDSLExecutionResult();
        result.setSuccess(false);
        if (parseTree == null) {
            OwlExecutionError executionError = OwlDSLExecutionErrorFactory.compileFailed(unitName);
            List<OwlExecutionError> errorList = new ArrayList<>();
            errorList.add(executionError);
            result.setErrorList(errorList);
            return result;
        }
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this.owlVariableListener, parseTree);
        OwlVariable variable = this.owlEvalVisitor.visit(parseTree);
        if (owlContext.listAllSemanticErrors().isEmpty()) {
            result.setSuccess(true);
            result.setResult(variable);
        } else {
            result.setErrorList(new ArrayList<>(owlContext.listAllSemanticErrors()));
        }
        return result;
    }

    public OwlContext getOwlContext() {
        return owlContext;
    }

    public void setOwlContext(OwlContext owlContext) {
        this.owlContext = owlContext;
        this.owlVariableListener.setOwlContext(owlContext);
        this.owlEvalVisitor.setOwlContext(owlContext);
    }
}
