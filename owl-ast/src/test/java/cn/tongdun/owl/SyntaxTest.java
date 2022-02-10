package cn.tongdun.owl;

import cn.tongdun.owl.parse.OwlSyntaxErrorListener;
import cn.tongdun.owl.generated.OwlLexer;
import cn.tongdun.owl.generated.OwlParser;
import cn.tongdun.owl.parse.OwlVariableListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author liutianlu
 * <br/>Created 2022/2/10 2:45 PM
 */
public class SyntaxTest {

    public static final String INIT = "int a = 0; " +
            "double b = 2.0; " +
            "boolean c = false; " +
            "string d = \"kek\"; " +
            "list e = [a, b, d, true, false];" +
            "int m = @metric_1 + 3; k = m;";

    public static final String INIT_ERROR = ";ino a = 0";

    public static final String PATH_TO_IFELSE = "/Users/liutianlu/Projects/JavaProjects/owl/owl-ast/src/test/java/cn/tongdun/owl/example/ifelse.txt";

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
        OwlParser parser = getParserFromString(INIT_ERROR);
        OwlSyntaxErrorListener errorListener = new OwlSyntaxErrorListener();
        parser.addErrorListener(errorListener);
        parser.prog();
        System.out.println(errorListener.getSyntaxErrorList());
    }

    public OwlParser getParserFromString(String input) {
        OwlLexer lexer = new OwlLexer(CharStreams.fromString(input));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        return new OwlParser(tokenStream);
    }

    public OwlParser getParserFromFile(String path){
        OwlLexer lexer = null;
        try {
            lexer = new OwlLexer(CharStreams.fromFileName(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert lexer != null;
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        return new OwlParser(tokenStream);
    }
}
