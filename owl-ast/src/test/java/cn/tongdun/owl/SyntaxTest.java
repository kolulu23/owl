package cn.tongdun.owl;

import cn.tongdun.owl.generated.OwlParser;
import cn.tongdun.owl.parse.OwlSyntaxErrorListener;
import cn.tongdun.owl.parse.OwlVariableListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static cn.tongdun.owl.OwlTestResource.*;
import static cn.tongdun.owl.OwlTestUtil.getParserFromFile;
import static cn.tongdun.owl.OwlTestUtil.getParserFromString;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 2:45 PM
 */
class SyntaxTest {

    private static TestOwlContext owlContext;

    private static OwlSyntaxErrorListener syntaxErrorListener;

    private static OwlVariableListener variableListener;

    @BeforeEach
    void initContext() {
        owlContext = new TestOwlContext();
        syntaxErrorListener = new OwlSyntaxErrorListener(owlContext);
        variableListener = new OwlVariableListener(owlContext);
    }

    @Test
    void testBasicInit() {
        OwlParser parser = getParserFromString(INIT);
        OwlParser.ProgContext parseTree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(variableListener, parseTree);
        System.out.println(owlContext.getVariableMap());
        System.out.println(owlContext.listAllGlobalVariables());
        System.out.println(owlContext.getSemanticErrorList());
    }

    @Test
    void testIfElse() {
        OwlParser parser = getParserFromFile(PATH_TO_IFELSE);
        OwlParser.ProgContext parseTree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(variableListener, parseTree);
        System.out.println(owlContext.getVariableMap());
        System.out.println(owlContext.listAllGlobalVariables());
        System.out.println(owlContext.getSemanticErrorList());
    }

    @Test
    void testBasicInitError() {
        OwlParser parser = getParserFromString(INIT_ERROR, syntaxErrorListener);
        parser.removeErrorListeners();
        parser.addErrorListener(syntaxErrorListener);
        parser.prog();
        System.out.println(syntaxErrorListener.getOwlContext().listAllSyntaxErrors());
    }

    @Test
    void testLexicalError() {
        OwlParser parser = getParserFromString(LEXICAL_ERROR_TOKEN, syntaxErrorListener);
        parser.removeErrorListeners();
        parser.addErrorListener(syntaxErrorListener);
        parser.prog();
        System.out.println(syntaxErrorListener.getOwlContext().listAllSyntaxErrors());
    }
}
