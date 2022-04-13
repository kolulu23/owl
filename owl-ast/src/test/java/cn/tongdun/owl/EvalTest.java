package cn.tongdun.owl;

import cn.tongdun.owl.generated.OwlParser;
import cn.tongdun.owl.parse.OwlEvalVisitor;
import cn.tongdun.owl.parse.OwlSyntaxErrorListener;
import cn.tongdun.owl.parse.OwlVariableListener;
import cn.tongdun.owl.type.OwlVariable;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liutianlu
 * <br/>Created 2022/2/11 9:58 AM
 */
class EvalTest {

    private static TestOwlContext owlContext;

    private static OwlSyntaxErrorListener errorListener;

    private static OwlVariableListener variableListener;

    private static OwlEvalVisitor evalVisitor;

    @BeforeEach
    void initContext() {
        owlContext = new TestOwlContext();
        errorListener = new OwlSyntaxErrorListener(owlContext);
        variableListener = new OwlVariableListener(owlContext);
        evalVisitor = new OwlEvalVisitor(owlContext);
    }

    @AfterEach
    void printInfo() {
        System.out.println("\nVariable Map: " + owlContext.getVariableMap());
        System.out.println("\nSyntax Error: " + owlContext.getSyntaxErrorList());
        System.out.println("\nSemantic Error: " + owlContext.getSemanticErrorList());
    }

    public static TestOwlContext getOwlContext() {
        return owlContext;
    }

    public static void setOwlContext(TestOwlContext owlContext) {
        EvalTest.owlContext = owlContext;
    }

    @Test
    void testBasicArithmeticExpr() {
        evalVisitor.setDefaultScale(6);
        OwlParser parser = OwlTestUtil.getParserFromString(OwlTestResource.FUN_1, errorListener);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        ParseTree parseTree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(variableListener, parseTree);
        OwlVariable variable = evalVisitor.visit(parseTree);
        Assertions.assertNotNull(variable);
        System.out.println(variable.getInner().getValue());
    }

    @Test
    void testIfElse() {
        OwlParser parser = OwlTestUtil.getParserFromFile(OwlTestResource.PATH_TO_IFELSE);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        ParseTree parseTree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(variableListener, parseTree);
        OwlVariable variable = evalVisitor.visit(parseTree);
        Assertions.assertNotNull(variable);
        System.out.println(variable.getInner().getValue());
    }

    @Test
    void testNumericalCast() {
        OwlParser parser = OwlTestUtil.getParserFromString(OwlTestResource.INT_CAST_DOUBLE, errorListener);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        ParseTree parseTree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(variableListener, parseTree);
        OwlVariable variable = evalVisitor.visit(parseTree);
        Assertions.assertNotNull(variable);
        System.out.println(variable.getInner().getValue());
    }

    @Test
    void testAVG() {
        OwlParser parser = OwlTestUtil.getParserFromString(OwlTestResource.AVG_FUNC, errorListener);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        ParseTree parseTree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(variableListener, parseTree);
        OwlVariable variable = evalVisitor.visit(parseTree);
        variable.getInner().getListValue()
                .stream()
                .map(item -> item.getInner().getDoubleValue().doubleValue())
                .forEach(item -> {
                    Assertions.assertEquals(28.45, item);
                });

    }

    @Test
    void testMAX() {
        OwlParser parser = OwlTestUtil.getParserFromString(OwlTestResource.MAX_FUNC, errorListener);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        ParseTree parseTree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(variableListener, parseTree);
        OwlVariable variable = evalVisitor.visit(parseTree);
        variable.getInner().getListValue()
                .stream()
                .map(item -> item.getInner().getDoubleValue().doubleValue())
                .forEach(item -> {
                    Assertions.assertEquals(99, item);
                });

    }

    @Test
    void testMIN() {
        OwlParser parser = OwlTestUtil.getParserFromString(OwlTestResource.MIN_FUNC, errorListener);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        ParseTree parseTree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(variableListener, parseTree);
        OwlVariable variable = evalVisitor.visit(parseTree);
        variable.getInner().getListValue()
                .stream()
                .map(item -> item.getInner().getDoubleValue().doubleValue())
                .forEach(item -> {
                    Assertions.assertEquals(2, item);
                });

    }
}
