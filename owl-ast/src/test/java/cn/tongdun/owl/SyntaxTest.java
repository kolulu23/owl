package cn.tongdun.owl;

import cn.tongdun.owl.generated.OwlParser;
import cn.tongdun.owl.parse.OwlSyntaxErrorListener;
import cn.tongdun.owl.parse.OwlVariableListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static cn.tongdun.owl.OwlTestResource.*;
import static cn.tongdun.owl.OwlTestUtil.getParserFromFile;
import static cn.tongdun.owl.OwlTestUtil.getParserFromString;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 2:45 PM
 */
public class SyntaxTest {


    @Test
    public void testBasicInit() {
        TestOwlContext owlContext = new TestOwlContext();
        owlContext.setVariableMap(new HashMap<>());
        owlContext.setGlobalVariableMap(new HashMap<>());
        owlContext.setSemanticErrorList(new ArrayList<>());
        OwlVariableListener variableListener = new OwlVariableListener();
        variableListener.setOwlContext(owlContext);
        OwlParser parser = getParserFromString(INIT);
        OwlParser.ProgContext parseTree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(variableListener, parseTree);
        System.out.println(owlContext.getVariableMap());
        System.out.println(owlContext.listAllGlobalVariables());
        System.out.println(owlContext.getSemanticErrorList());
    }

    @Test
    public void testIfElse() {
        OwlVariableListener variableListener = new OwlVariableListener();
        TestOwlContext owlContext = new TestOwlContext();
        owlContext.setVariableMap(new HashMap<>());
        owlContext.setGlobalVariableMap(new HashMap<>());
        owlContext.setSemanticErrorList(new ArrayList<>());
        variableListener.setOwlContext(owlContext);
        OwlParser parser = getParserFromFile(PATH_TO_IFELSE);
        OwlParser.ProgContext parseTree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(variableListener, parseTree);
        System.out.println(owlContext.getVariableMap());
        System.out.println(owlContext.listAllGlobalVariables());
        System.out.println(owlContext.getSemanticErrorList());
    }

    @Test
    public void testBasicInitError() {
        OwlSyntaxErrorListener errorListener = new OwlSyntaxErrorListener();
        errorListener.setOwlContext(new TestOwlContext());
        OwlParser parser = getParserFromString(INIT_ERROR, errorListener);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        parser.prog();
        System.out.println(errorListener.getOwlContext().listAllSyntaxErrors());
    }

    @Test
    public void testLexicalError() {
        OwlSyntaxErrorListener errorListener = new OwlSyntaxErrorListener();
        errorListener.setOwlContext(new TestOwlContext());
        OwlParser parser = getParserFromString(LEXICAL_ERROR_TOKEN, errorListener);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        parser.prog();
        System.out.println(errorListener.getOwlContext().listAllSyntaxErrors());
    }
}
